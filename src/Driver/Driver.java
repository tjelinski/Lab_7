package Driver;

public class Driver {
    private String firstName;
    protected String lastName;
    public int age;
    public String pesel;

    public Driver(String firstName, String lastName, int age, String pesel) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.pesel = pesel;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getAge() {
        return age;
    }

    public String getPesel() {
        return pesel;
    }

    public void displayInfo() {
        System.out.println("First Name: " + firstName);
        System.out.println("Last Name: " + lastName);
        System.out.println("Age: " + age);
        System.out.println("PESEL: " + pesel);
    }
}
