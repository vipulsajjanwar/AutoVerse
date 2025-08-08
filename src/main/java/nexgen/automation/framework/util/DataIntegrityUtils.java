package nexgen.automation.framework.util;

import java.text.Collator;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import nexgen.automation.framework.baseclass.BaseSuite;

public class DataIntegrityUtils {

	
	private DataIntegrityUtils(){
		throw new UnsupportedOperationException("DataIntegrityUtils Utility class should not be instantiated");
	}

	// ========== STRING & LIST VALIDATIONS ==========
/**
	public static boolean isSorted(List<String> list, boolean ascending) {
		if (list == null || list.size() < 2) return true;
		boolean result =true;int x=0;
		for (int i = 0; i < list.size() - 1; i++) {
			String current = list.get(i);
			String next = list.get(i + 1);

			int comparison = current.compareToIgnoreCase(next);

			if ((ascending && comparison > 0) || (!ascending && comparison < 0)) {
				// Only log the failure if the condition is met
				BaseSuite.reportLog("List is not sorted in " + (ascending ? "ascending" : "descending") + " order.");
				BaseSuite.reportLog("Sorting failed at index " + i + ": '" + current + "' vs '" + next + "'");
				x++;
			}
		}
		if(x>0) {
			result =false;
		}
		return result;
	}
*/
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
	            BaseSuite.reportLog("List is not sorted in " + (ascending ? "ascending" : "descending") + " order.");
	            BaseSuite.reportLog("Sorting failed at index " + i + ": '" + current + "' vs '" + next + "'");
	            failures++;
	        }
	    }

	    if (failures > 0) {
	        result = false;
	    }

	    return result;
	}
	
	private static Date parseDateOrLog(String dateStr, int index, SimpleDateFormat sdf) throws ParseException {
	    if (dateStr == null || dateStr.trim().isEmpty()) {
	        BaseSuite.reportLog("Invalid or empty date string at index " + index + ": \"" + dateStr + "\"");
	        return null;
	    }

	    try {
	        return sdf.parse(dateStr);
	    } catch (ParseException e) {
	        BaseSuite.reportLog("Failed to parse date at index " + index + ": \"" + dateStr + "\"");
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
	            BaseSuite.reportLog("Date list is not sorted in " + (ascending ? "ascending" : "descending") + " order.");
	            BaseSuite.reportLog("Sorting failed at index " + i + ": '" + current + "' vs '" + next + "'");
	            x++;
	        }
	    }
		
		return (x <= 0);
	}

	public static boolean allNonEmpty(List<String> list) {
		boolean result = list != null && list.stream().allMatch(s -> s != null && !s.trim().isEmpty());
		if (!result) BaseSuite.reportLog("List contains null or empty strings.");
		return result;
	}

	public static <T> boolean allUnique(List<T> list) {
		boolean result = new HashSet<>(list).size() == list.size();
		if (!result) BaseSuite.reportLog("List contains duplicates.");
		return result;
	}

	public static <T> boolean hasDuplicates(List<T> list) {
		Set<T> seen = new HashSet<>();
		boolean result = list.stream().anyMatch(e -> !seen.add(e));
		if (result) BaseSuite.reportLog("List has duplicates.");
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

}

