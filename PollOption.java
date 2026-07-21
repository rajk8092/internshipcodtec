public class PollOption {

    private String option;
    private int votes;

    public PollOption(String option) {
        this.option = option;
        this.votes = 0;
    }

    public String getOption() {
        return option;
    }

    public int getVotes() {
        return votes;
    }

    public void vote() {
        votes++;
    }
}