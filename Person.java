public class Person implements java.io.Serializable {

    private String name;
    private String phoneNumber;
    private String dateOfBirth;
    private String emailAddress;

    // Constructor
    public Person(String name, String phoneNumber, String dateOfBirth, String emailAddress) {
        super();
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.dateOfBirth = dateOfBirth;
        this.emailAddress = emailAddress;
    }

    // Getters & Setters
    public String getName() {
        return this.name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return this.phoneNumber;
    }
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getDateOfBirth() {
        return this.dateOfBirth;
    }
    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getEmailAddress() {
        return this.emailAddress;
    }
    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    @Override
    public String toString() {
        return "Name: " + getName() + ", Phone Number: " + getPhoneNumber() + ", Date of Birth: " + getDateOfBirth() + ", Email Address: " + getEmailAddress();
    }

}