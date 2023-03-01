import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class MangaTracker {

    private static Map<String, Manga> mangaList = new HashMap<String, Manga>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        boolean running = true;

        while (running) {
            System.out.println("Welcome to MangaTracker!");
            System.out.println("Please select an option:");
            System.out.println("1. Add Manga");
            System.out.println("2. Remove Manga");
            System.out.println("3. View Manga List");
            System.out.println("4. Exit");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    addManga();
                    break;
                case 2:
                    removeManga();
                    break;
                case 3:
                    viewMangaList();
                    break;
                case 4:
                    running = false;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }
    }

    private static void addManga() {
        scanner.nextLine();

        System.out.println("Enter the name of the manga:");
        String name = scanner.nextLine();

        System.out.println("Enter the current chapter:");
        int currentChapter = scanner.nextInt();

        System.out.println("Enter the total chapters:");
        int totalChapters = scanner.nextInt();

        Manga manga = new Manga(name, currentChapter, totalChapters);
        mangaList.put(name, manga);

        System.out.println("Manga added successfully!");
    }

    private static void removeManga() {
        scanner.nextLine();

        System.out.println("Enter the name of the manga:");
        String name = scanner.nextLine();

        if (mangaList.containsKey(name)) {
            mangaList.remove(name);
            System.out.println("Manga removed successfully!");
        } else {
            System.out.println("Manga not found.");
        }
    }

    private static void viewMangaList() {
        System.out.println("Manga List:");

        if (mangaList.isEmpty()) {
            System.out.println("No manga in list.");
        } else {
            for (Manga manga : mangaList.values()) {
                System.out.println(manga);
            }
        }
    }
}

class Manga {

    private String name;
    private int currentChapter;
    private int totalChapters;

    public Manga(String name, int currentChapter, int totalChapters) {
        this.name = name;
        this.currentChapter = currentChapter;
        this.totalChapters = totalChapters;
    }

    public String getName() {
        return name;
    }

    public int getCurrentChapter() {
        return currentChapter;
    }

    public void setCurrentChapter(int currentChapter) {
        this.currentChapter = currentChapter;
    }

    public int getTotalChapters() {
        return totalChapters;
    }

    public void setTotalChapters(int totalChapters) {
        this.totalChapters = totalChapters;
    }

    public String getStatus() {
        if (currentChapter == 0) {
            return "Not started";
        } else if (currentChapter < totalChapters) {
            return "In progress";
        } else {
            return "Completed";
        }
    }

    public int getProgress() {
        return (int) (((double) currentChapter / totalChapters) * 100);
    }

    @Override
    public String toString() {
        return name + " - " + getStatus() + "";
    }
}
