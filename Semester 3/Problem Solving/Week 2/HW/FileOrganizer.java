import java.util.*;

public class FileOrganizer {

    static class FileInfo {
        String originalName;
        String name;
        String extension;
        String category;
        String newName;
        String subCategory;
        boolean valid;
    }

    public static FileInfo extractFileInfo(String file) {
        FileInfo info = new FileInfo();
        info.originalName = file;
        int dotIndex = file.lastIndexOf(".");
        if (dotIndex == -1 || dotIndex == 0 || dotIndex == file.length() - 1) {
            info.valid = false;
            info.name = file;
            info.extension = "";
        } else {
            info.name = file.substring(0, dotIndex);
            info.extension = file.substring(dotIndex + 1).toLowerCase();
            info.valid = validateName(info.name);
        }
        return info;
    }

    public static boolean validateName(String name) {
        for (int i = 0; i < name.length(); i++) {
            char c = name.charAt(i);
            if (!(Character.isLetterOrDigit(c) || c == '_' || c == '-')) return false;
        }
        return true;
    }

    public static String categorize(FileInfo info) {
        String ext = info.extension;
        if (ext.equals("txt") || ext.equals("doc")) return "Document";
        if (ext.equals("jpg") || ext.equals("png")) return "Image";
        if (ext.equals("mp3") || ext.equals("wav")) return "Audio";
        if (ext.equals("mp4") || ext.equals("avi")) return "Video";
        if (ext.equals("pdf")) return "PDF";
        return "Unknown";
    }

    public static String generateNewName(FileInfo info, Map<String, Integer> counters, String date) {
        String base = info.category + "_" + date;
        int count = counters.getOrDefault(base, 0) + 1;
        counters.put(base, count);
        StringBuilder sb = new StringBuilder();
        sb.append(base);
        sb.append("_");
        sb.append(count);
        if (!info.extension.isEmpty()) {
            sb.append(".");
            sb.append(info.extension);
        }
        return sb.toString();
    }

    public static String analyzeContent(FileInfo info) {
        if (info.category.equals("Document")) {
            String lower = info.name.toLowerCase();
            if (lower.contains("resume") || lower.contains("cv")) return "Resume";
            if (lower.contains("report")) return "Report";
            if (lower.contains("code")) return "Code";
            return "GeneralDoc";
        }
        return "N/A";
    }

    public static void displayReport(List<FileInfo> files) {
        System.out.println("File Organization Report:");
        System.out.printf("%-20s %-12s %-25s %-12s\n", "Original", "Category", "New Name", "SubCategory");
        for (FileInfo f : files) {
            System.out.printf("%-20s %-12s %-25s %-12s\n",
                    f.originalName, f.category, f.newName, f.subCategory);
        }
        Map<String, Integer> counts = new HashMap<>();
        for (FileInfo f : files) {
            counts.put(f.category, counts.getOrDefault(f.category, 0) + 1);
        }
        System.out.println("\nCategory-wise Counts:");
        for (String c : counts.keySet()) {
            System.out.println(c + ": " + counts.get(c));
        }
        System.out.println("\nFiles needing attention:");
        for (FileInfo f : files) {
            if (!f.valid || f.category.equals("Unknown")) {
                System.out.println(f.originalName);
            }
        }
    }

    public static void generateBatchCommands(List<FileInfo> files) {
        System.out.println("\nBatch Rename Commands:");
        for (FileInfo f : files) {
            System.out.println("rename \"" + f.originalName + "\" \"" + f.newName + "\"");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<FileInfo> files = new ArrayList<>();
        System.out.println("Enter file names (blank line to stop):");
        while (true) {
            String line = sc.nextLine();
            if (line.equals("")) break;
            FileInfo f = extractFileInfo(line);
            f.category = categorize(f);
            f.subCategory = analyzeContent(f);
            files.add(f);
        }
        String date = "20250904";
        Map<String, Integer> counters = new HashMap<>();
        for (FileInfo f : files) {
            f.newName = generateNewName(f, counters, date);
        }
        displayReport(files);
        generateBatchCommands(files);

        sc.close();
    }
}