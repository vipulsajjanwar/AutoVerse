package nexgen.automation.framework.reports;
import java.util.HashMap;
import java.util.Map;
public class TimeAnalyzer {

	private static final Map<String, Long> testDurations = new HashMap<>();

    public static void addTestDuration(String testName, long duration) {
        testDurations.put(testName, duration);
    }

    public static Map<String, Long> getTestDurations() {
        return testDurations;
    }
}
