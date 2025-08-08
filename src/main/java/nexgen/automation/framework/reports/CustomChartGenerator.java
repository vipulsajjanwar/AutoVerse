package nexgen.automation.framework.reports;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Map;


public class CustomChartGenerator {
	
	public static void generateChart(String reportPath) {
		
      //  String reportPath = "extent-report.html"; // Adjust the path as necessary
        try {
            String content = new String(Files.readAllBytes(Paths.get(reportPath)));
            String chartScript = generateChartScript();

            // Append custom chart script before the closing body tag
            content = content.replace("</body>", chartScript + "</body>");

            try (FileWriter writer = new FileWriter(new File(reportPath))) {
                writer.write(content);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String generateChartScript() {
        Map<String, Long> durations = TimeAnalyzer.getTestDurations();
        StringBuilder labels = new StringBuilder();
        StringBuilder data = new StringBuilder();

        for (Map.Entry<String, Long> entry : durations.entrySet()) {
            if (labels.length() > 0) {
                labels.append(",");
                data.append(",");
            }
            labels.append("'").append(entry.getKey()).append("'");
            data.append(entry.getValue());
        }

        return "<script src=\"https://cdn.jsdelivr.net/npm/chart.js\"></script>\n" +
               "<script>\n" +
               "var ctx = document.createElement('canvas');\n" +
               "document.body.appendChild(ctx);\n" +
               "var chart = new Chart(ctx, {\n" +
               "    type: 'bar',\n" +
               "    data: {\n" +
               "        labels: [" + labels.toString() + "],\n" +
               "        datasets: [{\n" +
               "            label: 'Test Duration (ms)',\n" +
               "            data: [" + data.toString() + "],\n" +
               "            backgroundColor: 'rgba(75, 192, 192, 0.2)',\n" +
               "            borderColor: 'rgba(75, 192, 192, 1)',\n" +
               "            borderWidth: 1\n" +
               "        }]\n" +
               "    },\n" +
               "    options: {\n" +
               "        scales: {\n" +
               "            y: {\n" +
               "                beginAtZero: true\n" +
               "            }\n" +
               "        }\n" +
               "    }\n" +
               "});\n" +
               "</script>\n";
    }
}
