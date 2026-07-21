import java.util.ArrayList;

public class Poll {

    private String question;
    private ArrayList<PollOption> options;

    public Poll(String question) {
        this.question = question;
        options = new ArrayList<>();
    }

    public void addOption(String option) {
        options.add(new PollOption(option));
    }

    public void displayPoll() {

        System.out.println("\n" + question);

        for (int i = 0; i < options.size(); i++) {
            System.out.println((i + 1) + ". " +
                    options.get(i).getOption());
        }
    }

    public void vote(int choice) {

        if (choice >= 1 && choice <= options.size()) {
            options.get(choice - 1).vote();
            System.out.println("Vote Submitted Successfully.");
        } else {
            System.out.println("Invalid Option.");
        }
    }

    public void showResults() {

        int totalVotes = 0;

        for (PollOption option : options)
            totalVotes += option.getVotes();

        System.out.println("\n===== LIVE RESULTS =====");

        for (PollOption option : options) {

            double percentage = totalVotes == 0 ? 0 :
                    (option.getVotes() * 100.0) / totalVotes;

            System.out.printf("%s : %d votes (%.2f%%)%n",
                    option.getOption(),
                    option.getVotes(),
                    percentage);
        }

        System.out.println("Total Votes : " + totalVotes);
    }
}