import java.util.*;
import java.io.*;

public class DigitalJournal {

    static ArrayList<JournalEntry> journal = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        loadEntries();

        while (true) {

            System.out.println("\n========= DIGITAL JOURNAL =========");
            System.out.println("1. Write New Entry");
            System.out.println("2. View All Entries");
            System.out.println("3. Search Entry");
            System.out.println("4. Edit Entry");
            System.out.println("5. Delete Entry");
            System.out.println("6. Save Entries");
            System.out.println("7. Exit");
            System.out.print("Enter Choice: ");

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:
                    addEntry();
                    break;

                case 2:
                    viewEntries();
                    break;

                case 3:
                    searchEntry();
                    break;

                case 4:
                    editEntry();
                    break;

                case 5:
                    deleteEntry();
                    break;

                case 6:
                    saveEntries();
                    break;

                case 7:
                    saveEntries();
                    System.out.println("Journal Saved. Goodbye!");
                    System.exit(0);

                default:
                    System.out.println("Invalid Choice.");
            }
        }
    }

    static void addEntry() {

        System.out.print("Title: ");
        String title = sc.nextLine();

        System.out.print("Date (DD/MM/YYYY): ");
        String date = sc.nextLine();

        System.out.println("Write Journal:");
        String content = sc.nextLine();

        journal.add(new JournalEntry(title, date, content));

        System.out.println("Entry Added Successfully.");
    }

    static void viewEntries() {

        if (journal.isEmpty()) {
            System.out.println("No Journal Entries Found.");
            return;
        }

        for (JournalEntry j : journal) {
            System.out.println(j);
        }
    }

    static void searchEntry() {

        System.out.print("Enter Title: ");
        String title = sc.nextLine();

        for (JournalEntry j : journal) {

            if (j.getTitle().equalsIgnoreCase(title)) {
                System.out.println(j);
                return;
            }
        }

        System.out.println("Entry Not Found.");
    }

    static void editEntry() {

        System.out.print("Enter Title to Edit: ");
        String title = sc.nextLine();

        for (JournalEntry j : journal) {

            if (j.getTitle().equalsIgnoreCase(title)) {

                System.out.print("New Title: ");
                j.setTitle(sc.nextLine());

                System.out.print("New Date: ");
                j.setDate(sc.nextLine());

                System.out.println("New Journal:");
                j.setContent(sc.nextLine());

                System.out.println("Entry Updated.");
                return;
            }
        }

        System.out.println("Entry Not Found.");
    }

    static void deleteEntry() {

        System.out.print("Enter Title to Delete: ");
        String title = sc.nextLine();

        Iterator<JournalEntry> it = journal.iterator();

        while (it.hasNext()) {

            JournalEntry j = it.next();

            if (j.getTitle().equalsIgnoreCase(title)) {

                it.remove();
                System.out.println("Entry Deleted.");
                return;
            }
        }

        System.out.println("Entry Not Found.");
    }

    static void saveEntries() {

        try {

            ObjectOutputStream out =
                    new ObjectOutputStream(new FileOutputStream("entries.dat"));

            out.writeObject(journal);
            out.close();

            System.out.println("Entries Saved.");

        } catch (Exception e) {
            System.out.println("Error Saving File.");
        }
    }

    @SuppressWarnings("unchecked")
    static void loadEntries() {

        try {

            ObjectInputStream in =
                    new ObjectInputStream(new FileInputStream("entries.dat"));

            journal = (ArrayList<JournalEntry>) in.readObject();

            in.close();

        } catch (Exception e) {

            journal = new ArrayList<>();
        }
    }
}