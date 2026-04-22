import java.util.*;

public class CSVAnalyzer {

    public static String[][] parseCSV(String input) {
        List<List<String>> rows = new ArrayList<>();
        int n = input.length();
        int i = 0;
        boolean inQuotes = false;
        int start = 0;
        List<String> row = new ArrayList<>();
        while (i < n) {
            char c = input.charAt(i);
            if (c == '"') {
                inQuotes = !inQuotes;
            } else if (c == ',' && !inQuotes) {
                row.add(input.substring(start, i));
                start = i + 1;
            } else if (c == '\n' && !inQuotes) {
                row.add(input.substring(start, i));
                rows.add(row);
                row = new ArrayList<>();
                start = i + 1;
            }
            i++;
        }
        if (start < n || row.size() > 0) {
            row.add(input.substring(start, n));
            rows.add(row);
        }
        String[][] result = new String[rows.size()][];
        for (int r = 0; r < rows.size(); r++) {
            result[r] = rows.get(r).toArray(new String[0]);
        }
        return result;
    }

    public static String[][] cleanData(String[][] data) {
        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data[i].length; j++) {
                String field = data[i][j].trim();
                if (field.startsWith("\"") && field.endsWith("\"")) {
                    field = field.substring(1, field.length() - 1);
                }
                data[i][j] = field;
            }
        }
        return data;
    }

    public static boolean isNumeric(String s) {
        if (s.length() == 0) return false;
        boolean dot = false;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            int a = (int) c;
            if (a == 46 && !dot) {
                dot = true;
            } else if (a < 48 || a > 57) {
                return false;
            }
        }
        return true;
    }

    public static void analyze(String[][] data) {
        int cols = data[0].length;
        int rows = data.length - 1;
        System.out.println("Total Records: " + rows);
        for (int j = 0; j < cols; j++) {
            String header = data[0][j];
            List<String> values = new ArrayList<>();
            for (int i = 1; i < data.length; i++) values.add(data[i][j]);
            boolean numeric = true;
            for (String v : values) if (!isNumeric(v)) numeric = false;
            if (numeric) {
                double min = Double.MAX_VALUE, max = -Double.MAX_VALUE, sum = 0;
                for (String v : values) {
                    double num = Double.parseDouble(v);
                    min = Math.min(min, num);
                    max = Math.max(max, num);
                    sum += num;
                }
                double avg = sum / values.size();
                System.out.println("Column: " + header + " | Min=" + min + " Max=" + max + " Avg=" + String.format("%.2f", avg));
            } else {
                Set<String> uniq = new HashSet<>(values);
                System.out.println("Column: " + header + " | Unique values=" + uniq.size());
            }
        }
    }

    public static void formatTable(String[][] data) {
        int cols = data[0].length;
        int[] widths = new int[cols];
        for (int j = 0; j < cols; j++) {
            int w = 0;
            for (int i = 0; i < data.length; i++) {
                w = Math.max(w, data[i][j].length());
            }
            widths[j] = w + 2;
        }
        StringBuilder sb = new StringBuilder();
        for (int j = 0; j < cols; j++) {
            sb.append("+");
            for (int k = 0; k < widths[j]; k++) sb.append("-");
        }
        sb.append("+\n");
        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < cols; j++) {
                sb.append("| ").append(data[i][j]);
                for (int k = data[i][j].length() + 1; k < widths[j]; k++) sb.append(" ");
            }
            sb.append("|\n");
            for (int j = 0; j < cols; j++) {
                sb.append("+");
                for (int k = 0; k < widths[j]; k++) sb.append("-");
            }
            sb.append("+\n");
        }
        System.out.println(sb.toString());
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder input = new StringBuilder();
        while (sc.hasNextLine()) {
            String line = sc.nextLine();
            if (line.equals("")) break;
            input.append(line).append("\n");
        }
        String[][] data = parseCSV(input.toString());
        data = cleanData(data);
        formatTable(data);
        analyze(data);

        sc.close();
    }
}