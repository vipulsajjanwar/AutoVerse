package com.framework.utils;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.Collator;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Random;
import java.util.Set;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.apache.log4j.Logger;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.InvalidSelectorException;
import org.openqa.selenium.JavascriptException;
import org.openqa.selenium.NoSuchFrameException;
import org.openqa.selenium.NoSuchWindowException;
import org.openqa.selenium.SessionNotCreatedException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.interactions.MoveTargetOutOfBoundsException;

public class DataIntegrityUtil {

	private DataIntegrityUtil(){
		throw new UnsupportedOperationException("DataIntegrityUtils Utility class should not be instantiated");
	}

	public static final Logger log = Logger.getLogger(DataIntegrityUtil.class);

	public static boolean isSorted(List<String> list, boolean ascending) {
		if (list == null || list.size() < 2) return true;

		boolean result = true;
		int failures = 0;

		// Use locale-sensitive comparator (default locale or customize to Locale.ENGLISH)
		Collator collator = Collator.getInstance(Locale.ENGLISH);
		collator.setStrength(Collator.PRIMARY); // Ignores case and accents

		for (int i = 0; i < list.size() - 1; i++) {
			String current = list.get(i);
			String next = list.get(i + 1);

			int comparison = collator.compare(current, next);

			if ((ascending && comparison > 0) || (!ascending && comparison < 0)) {
				log.info("List is not sorted in " + (ascending ? "ascending" : "descending") + " order.");
				log.info("Sorting failed at index " + i + ": '" + current + "' vs '" + next + "'");
				failures++;
			}
		}

		if (failures > 0) {
			result = false;
		}

		return result;
	}

	public static boolean isSortedCustom(List<String> list, boolean ascending) {
		if (list == null || list.size() < 2) return true;

		int failures = 0;

		Comparator<String> customComparator = (a, b) -> {
			// Custom logic: treat '-' before '_' in ascending, reverse in descending
			if (ascending) {
				return customCompare(a, b);
			} else {
				return customCompare(b, a);
			}
		};

		for (int i = 0; i < list.size() - 1; i++) {
			String current = list.get(i);
			String next = list.get(i + 1);

			if (customComparator.compare(current, next) > 0) {
				log.info("List is not sorted in " + (ascending ? "ascending" : "descending") + " order.");
				log.info("Sorting failed at index " + i + ": '" + current + "' vs '" + next + "'");
				failures++;
			}
		}

		return failures == 0;
	}

	// Custom compare logic for '-', '_'
	private static int customCompare(String s1, String s2) {
		for (int i = 0; i < Math.min(s1.length(), s2.length()); i++) {
			char c1 = s1.charAt(i);
			char c2 = s2.charAt(i);

			// If different, apply custom priority
			if (c1 != c2) {
				if (c1 == '-' && c2 == '_') return -1; // '-' before '_'
				if (c1 == '_' && c2 == '-') return 1;  // '_' after '-'
				return Character.compare(c1, c2); // Normal compare otherwise
			}
		}
		return Integer.compare(s1.length(), s2.length()); // Compare by length if same prefix
	}


	private static Date parseDateOrLog(String dateStr, int index, SimpleDateFormat sdf) throws ParseException {
		if (dateStr == null || dateStr.trim().isEmpty()) {
			log.info("Invalid or empty date string at index " + index + ": \"" + dateStr + "\"");
			return null;
		}

		try {
			return sdf.parse(dateStr);
		} catch (ParseException e) {
			log.info("Failed to parse date at index " + index + ": \"" + dateStr + "\"");
			throw e;
		}
	}

	public static boolean isDateSorted(List<String> dateList, String format, boolean ascending) throws ParseException {
		if (dateList == null || dateList.size() < 2) return true;

		int x=0;
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		List<Date> dates = new ArrayList<>();
		for (int i = 0; i < dateList.size(); i++) {

			Date parsedDate = parseDateOrLog(dateList.get(i), i, sdf);
			if (parsedDate != null) {
				dates.add(parsedDate);
			}
		}

		for (int i = 0; i < dates.size() - 1; i++) {
			Date current = dates.get(i);
			Date next = dates.get(i + 1);

			int comparison = current.compareTo(next);

			if ((ascending && comparison > 0) || (!ascending && comparison < 0)) {
				// Log the failure details if sorting is not correct
				log.info("Date list is not sorted in " + (ascending ? "ascending" : "descending") + " order.");
				log.info("Sorting failed at index " + i + ": '" + current + "' vs '" + next + "'");
				x++;
			}
		}

		return (x <= 0);
	}

	public static boolean allNonEmpty(List<String> list) {
		boolean result = list != null && list.stream().allMatch(s -> s != null && !s.trim().isEmpty());
		if (!result) log.info("List contains null or empty strings.");
		return result;
	}

	public static <T> boolean allUnique(List<T> list) {
		boolean result = new HashSet<>(list).size() == list.size();
		if (!result) log.info("List contains duplicates.");
		return result;
	}

	public static <T> boolean hasDuplicates(List<T> list) {
		Set<T> seen = new HashSet<>();
		boolean result = list.stream().anyMatch(e -> !seen.add(e));
		if (result) log.info("List has duplicates.");
		return result;
	}

	public static boolean isNumberListSorted(List<Integer> list, boolean ascending) {
		return IntStream.range(0, list.size() - 1)
				.allMatch(i -> ascending
						? list.get(i) <= list.get(i + 1)
						: list.get(i) >= list.get(i + 1));
	}

	public static boolean allStringsNumeric(List<String> list) {
		return list.stream().allMatch(s -> s != null && s.matches("\\d+"));
	}

	public static boolean containsIgnoreCase(List<String> list, String keyword) {
		return list.stream().anyMatch(s -> s != null && s.equalsIgnoreCase(keyword));
	}

	public static boolean matchesRegex(List<String> list, String regex) {
		return list.stream().allMatch(s -> s != null && s.matches(regex));
	}

	public static <T> Map<T, Long> frequencyMap(List<T> list) {
		return list.stream().collect(Collectors.groupingBy(e -> e, Collectors.counting()));
	}

	public static <T> boolean areListsEqualIgnoreOrder(List<T> list1, List<T> list2) {
		return new HashSet<>(list1).equals(new HashSet<>(list2));
	}

	public static <T> boolean areListsExactlyEqual(List<T> list1, List<T> list2) {
		return Objects.equals(list1, list2);
	}

	public static <T> List<T> getCommonElements(List<T> list1, List<T> list2) {
		return list1.stream()
				.filter(new HashSet<>(list2)::contains)
				.collect(Collectors.toList());
	}

	public static <T> List<T> getMissingElements(List<T> source, List<T> target) {
		return source.stream()
				.filter(e -> !target.contains(e))
				.collect(Collectors.toList());
	}

	public static <T> boolean allMatch(List<T> list, Predicate<T> predicate) {
		return list != null && list.stream().allMatch(predicate);
	}

	public static <T> boolean anyMatch(List<T> list, Predicate<T> predicate) {
		return list != null && list.stream().anyMatch(predicate);
	}

	public static <T> boolean containsNull(List<T> list) {
		return list.stream().anyMatch(Objects::isNull);
	}

	public static List<String> cleanStringList(List<String> list) {
		return list.stream()
				.filter(Objects::nonNull)
				.map(String::trim)
				.filter(s -> !s.isEmpty())
				.collect(Collectors.toList());
	}

	public static <T> List<T> flattenListOfLists(List<List<T>> nestedList) {
		return nestedList.stream()
				.flatMap(Collection::stream)
				.collect(Collectors.toList());
	}

	public static <T> boolean isPalindrome(List<T> list) {
		int size = list.size();
		for (int i = 0; i < size / 2; i++) {
			if (!Objects.equals(list.get(i), list.get(size - 1 - i))) {
				return false;
			}
		}
		return true;
	}

	// ========== MAP VALIDATIONS ==========

	public static <K, V> boolean allMapKeysNonNull(Map<K, V> map) {
		return map != null && map.keySet().stream().noneMatch(Objects::isNull);
	}

	public static <K, V> boolean allMapValuesNonNull(Map<K, V> map) {
		return map != null && map.values().stream().noneMatch(Objects::isNull);
	}

	public static <K, V> boolean containsKeyValue(Map<K, V> map, K key, V value) {
		return map != null && map.containsKey(key) && Objects.equals(map.get(key), value);
	}

	public static <K, V> boolean hasDuplicateValues(Map<K, V> map) {
		return hasDuplicates(new ArrayList<>(map.values()));
	}

	public static <K, V> Map<V, Long> duplicateValueCounts(Map<K, V> map) {
		return map.values().stream()
				.collect(Collectors.groupingBy(v -> v, Collectors.counting()))
				.entrySet().stream()
				.filter(e -> e.getValue() > 1)
				.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
	}


	public static String humanReadableByteCountSI(long bytes) {

		if (bytes < 1000) {
			// Round up even small values to one decimal place
			double kb = Math.ceil((bytes / 1024.0) * 10) / 10.0;
			return String.format("%.1f KB", kb);
		}
		int exp = (int) (Math.log(bytes) / Math.log(1024));
		String pre = "kMGTPE".charAt(exp - 1) + "";

		double value = bytes / Math.pow(1024, exp);
		value = Math.ceil(value * 10) / 10.0;  // Round up to 1 decimal place

		return String.format("%.1f %sB", value, pre);
	}

	public static long convertToBytes(String sizeStr) {
		sizeStr = sizeStr.trim().toUpperCase().replaceAll("[^0-9. KMGTPEB]", "");
		double size = Double.parseDouble(sizeStr.replaceAll("[^0-9.]", ""));
		if (sizeStr.contains("KB")) return (long) (size * 1024);
		if (sizeStr.contains("MB")) return (long) (size * 1024 * 1024);
		if (sizeStr.contains("GB")) return (long) (size * 1024 * 1024 * 1024);
		if (sizeStr.contains("B"))  return (long) size;
		return -1;
	}

	// Method to generate a random string
	public static String generateRandomLowercaseString(int length) {
		String characters = "abcdefghijklmnopqrstuvwxyz";
		StringBuilder sb = new StringBuilder(length);
		for (int i = 0; i < length; i++) {
			int index = RANDOM.nextInt(characters.length());
			sb.append(characters.charAt(index));
		}
		return sb.toString();
	}

	// Method to generate a random string
	public static String generateRandomString(int length) {
		String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789-_";
		StringBuilder sb = new StringBuilder(length);
		for (int i = 0; i < length; i++) {
			int index = RANDOM.nextInt(characters.length());
			sb.append(characters.charAt(index));
		}
		return sb.toString();
	}

	private static final String[] AI_NAMES = {
			"NeuralMind", "DeepVision", "CognitiveCore", "QuantumAI", "SentientLogic",
			"AetherNet", "NeuroLink", "Singularity", "AlphaBrain", "DeepSynapse",
			"CyberMind", "GigaNeuron", "Intellecta", "SynthoMind", "MetaCog",
			"DeepThink", "HyperNeural", "Neuronexus", "CogniBot", "NeuraFlow",
			"AI_Nexus", "SmartAI", "AutoCog", "NeuroSynth", "QuantumBot",
			"ThinkNet", "AI_Fusion", "DeepSense", "CyberIntellect", "GeniusAI",
			"SingularCore", "HyperIntellect", "NeuraX", "AI_Sentinel", "CerebraNet",
			"MindMeld", "VisionAI", "DeepMorph", "EvoMind", "HyperCog",
			"NeuralSpark", "AI_Visionary", "CortexNet", "QuantumThink", "LogicMind",
			"DeepGen", "AI_Evolve", "AutoNeural", "NexusBot", "AI_Prime",
			"BrainwaveAI", "DeepNet", "AI_Nova", "NeuraGen", "NeuroSphere",
			"HyperMind", "CyberThink", "AI_Cognition", "MetaMind", "DeepBot",
			"AI_Insight", "NeuralFocus", "Deep_Intelligence", "CognitiveAI", "AI_Link",
			"HyperNeuro", "NeuraCloud", "AI_Precision", "IntellectX", "SmartNeuron",
			"DeepNeuron", "AI_Zenith", "CyberCore", "QuantumNeuro", "AI_Echo",
			"Deep Fusion", "NeuroHive", "AI_Mindstorm", "MetaNeural", "ThinkBot",
			"NeuralCircuit", "CogniVerse", "IntelliAI", "AutoMind", "DeepEcho",
			"SentientAI", "NeuroMorph", "HyperCortex", "DeepStream", "NeuroThink",
			"AI_Pulse", "GeniusNeural", "CognitiveLink", "DeepNeuronX", "AI_Reflex",
			"QuantumCortex", "CognitiveBot", "AutoCortex", "CyberNeural", "AI_Core"
	};
	private static final Random RANDOM = new Random();
	public static String getRandomSuffix() {

		return AI_NAMES[RANDOM.nextInt(AI_NAMES.length)];
	}

	public static void setSystemPropertiesForExecution() {

		System.setProperty("fieldNameSuffix", "_"+generateRandomLowercaseString(5));
		System.setProperty("displayNameSuffix", "_"+getRandomSuffix()+"_"+generateRandomString(3));
		System.setProperty("updateDisplayNameSuffix", "_"+getRandomSuffix()+"_"+generateRandomString(3));
		System.setProperty("valueNameSuffix", "_"+getRandomSuffix()+"_"+generateRandomString(3));
		System.setProperty("updatevalueNameSuffix", "_"+getRandomSuffix()+"_"+generateRandomString(3));
		System.setProperty("ldapsuffix","_"+getRandomSuffix()+"_"+generateRandomString(3));
		System.setProperty("Updateldapsuffix","_"+getRandomSuffix()+"_"+generateRandomString(3));
		System.setProperty("mappersuffix","_"+generateRandomString(3));
		System.setProperty("idpaliassuffix","_"+getRandomSuffix()+"_"+generateRandomString(3));
		System.setProperty("idpupdatealiassuffix","_"+getRandomSuffix()+"_"+generateRandomString(3));
		System.setProperty("schedulesuffix", "_"+getRandomSuffix()+"_"+generateRandomString(3));
		System.setProperty("updateschedulesuffix", "_"+getRandomSuffix()+"_"+generateRandomString(3));
		System.setProperty("foldersuffix", "_"+generateRandomString(5));
		System.setProperty("updatefoldersuffix", "_"+generateRandomString(5));
	}

	private static final Map<Class<? extends Exception>, String> exceptionMessages = createExceptionMessages();

	private static Map<Class<? extends Exception>, String> createExceptionMessages() {
		Map<Class<? extends Exception>, String> map = new HashMap<>();

		// Selenium-specific exceptions
		map.put(StaleElementReferenceException.class, "The web element is no longer attached to the DOM. It may have been refreshed or removed.");
		map.put(NoSuchElementException.class, "Element not found. Verify the locator or ensure the element is visible.");
		map.put(TimeoutException.class, "The operation timed out. Consider increasing wait time or refining the wait condition.");
		map.put(ElementNotInteractableException.class, "Element is present but not interactable. It may be hidden, disabled, or overlapped.");
		map.put(ElementClickInterceptedException.class, "Click was intercepted. Another element (e.g., popup or overlay) may be blocking the target.");
		map.put(WebDriverException.class, "WebDriver encountered an error. Check browser session, compatibility, or driver path.");
		map.put(JavascriptException.class, "A JavaScript error occurred during script execution. Review console for JS errors.");
		map.put(InvalidSelectorException.class, "Invalid selector used. Check for typos or incorrect XPath/CSS syntax.");
		map.put(SessionNotCreatedException.class, "Failed to create a browser session. This may be due to mismatched driver/browser versions.");
		map.put(NoSuchWindowException.class, "Attempted to switch to a non-existent window. Ensure the window handle is valid.");
		map.put(NoSuchFrameException.class, "Frame not found. Check if the frame index or name is correct.");
		map.put(MoveTargetOutOfBoundsException.class, "Element is outside of the viewport. Scroll into view or adjust your interaction.");

		// General Java exceptions
		map.put(NullPointerException.class, "Null reference encountered. Make sure the object is initialized before use.");
		map.put(IllegalArgumentException.class, "Invalid argument passed to a method. Check parameter values.");
		map.put(IllegalStateException.class, "Method was invoked at an illegal or inappropriate time. Check object state.");
		map.put(IOException.class, "An I/O error occurred. Check file paths, permissions, or network resources.");
		map.put(FileNotFoundException.class, "File not found. Verify the file path and that the file exists.");
		map.put(ArithmeticException.class, "Illegal arithmetic operation (e.g., division by zero). Check your calculations.");
		map.put(ArrayIndexOutOfBoundsException.class, "Array index is out of range. Check array size and accessed index.");
		map.put(ClassCastException.class, "Invalid type casting. Ensure correct object type before casting.");
		map.put(NumberFormatException.class, "Invalid number format. Ensure the string can be parsed as a number.");

		return map;
	}

	public static String getExceptionCause(Exception e) {
		for (Map.Entry<Class<? extends Exception>, String> entry : exceptionMessages.entrySet()) {
			if (entry.getKey().isInstance(e)) {
				return entry.getValue();
			}
		}
		return "Unknown error occurred. Check the stack trace for more details.";
	}
}
