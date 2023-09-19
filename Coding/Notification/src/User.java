public class User {
    private String firstName;
    private String preference; // 'EMAIL', 'SMS', 'WhatsAPP'
    private String email;
    private String phoneNumber;

    public User(String firstName, String preference, String email, String phoneNumber) {
        this.firstName = firstName;
        this.preference = preference;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getPreference() {
        return preference;
    }

    public String getEmail() {
        return email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }
}