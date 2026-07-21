import java.io.Serializable;

public class Contact implements Serializable {
    private String name;
    private String phone;
    private String email;
    private String company;
    private String notes;

    public Contact(String name, String phone, String email, String company, String notes) {
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.company = company;
        this.notes = notes;
    }

    public String getName() {
        return name;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    @Override
    public String toString() {
        return "---------------------------------\n" +
               "Name    : " + name + "\n" +
               "Phone   : " + phone + "\n" +
               "Email   : " + email + "\n" +
               "Company : " + company + "\n" +
               "Notes   : " + notes + "\n";
    }
}