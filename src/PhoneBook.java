public class PhoneBook {
    private String name;
    private String phoneNumber;
    private String address;
    private String group;
    private String gender;
    private String dateOfBirth;

    public PhoneBook() {
    }

    public PhoneBook(String name, String phoneNumber, String address, String group, String gender, String dateOfBirth) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.group = group;
        this.gender = gender;
        this.dateOfBirth = dateOfBirth;
    }

    public String getName() {
        return name;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return  name  +
                ","+ phoneNumber +
                ", " + address +
                "," + group  +
                "," + gender +
                "," + dateOfBirth;
    }
}
