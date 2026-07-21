import java.io.Serializable;

public class JournalEntry implements Serializable {

    private String title;
    private String date;
    private String content;

    public JournalEntry(String title, String date, String content) {
        this.title = title;
        this.date = date;
        this.content = content;
    }

    public String getTitle() {
        return title;
    }

    public String getDate() {
        return date;
    }

    public String getContent() {
        return content;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "\n---------------------------" +
               "\nTitle : " + title +
               "\nDate : " + date +
               "\nJournal : " + content;
    }
}