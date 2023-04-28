import javax.swing.*;

public abstract class Employee {
    private String id;
    private String firstName;
    private String lastName;
    private String addressStreet;
    private String addressCity;
    private String addressState;
    private String addressZip;
    private String phoneNumber;
    private String workTitle;
    private double salary;
    private String workEmail;
    private String fieldOffice;
    private boolean isActive;
    protected int numEmployees;

    private static int idTrack;

    final int MAX_EMPLOYEES = 100;

    public Employee(String firstName, String lastName, String addressStreet, String addressCity, String addressState, String addressZip, String phoneNumber, String workTitle, double salary, String fieldOffice) {
        setID();
        setFirstName(firstName);
        setLastName(lastName);
        setAddressStreet(addressStreet);
        setAddressCity(addressCity);
        setAddressState(addressState);
        setAddressZip(addressZip);
        setPhoneNumber(phoneNumber);
        setWorkTitle(workTitle);
        setSalary(salary);
        setWorkEmail();
        setFieldOffice(fieldOffice);
        setIsActive(true);
        numEmployees++;
        idTrack++;
    }

    //accessors

    public String getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getAddressStreet() {
        return addressStreet;
    }

    public String getAddressCity() {
        return addressCity;
    }

    public String getAddressState() {
        return addressState;
    }

    public String getAddressZip() {
        return addressZip;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getWorkTitle() {
        return workTitle;
    }

    public double getSalary() {
        return salary;
    }

    public String getWorkEmail() {
        return workEmail;
    }

    public String getFieldOffice() {
        return fieldOffice;
    }

    public boolean getIsActive() {
        return isActive;
    }

    protected int getNumEmployees() {
        return numEmployees;
    }

    public int getMaxEmployees() {
        return MAX_EMPLOYEES;
    }

    public int getIdTrack() {
        return idTrack;
    }

    //mutators

    public void setID() {
        //generate an ID with a 3 digit
        String id = "LE";
        if (id.length() == 1) {
            id += "0000000" + (getIdTrack() + 1);
        } else if (id.length() == 2) {
            id += "000000" + (getIdTrack() + 1);
        } else if (id.length() == 3) {
            id += "00000" + (getIdTrack() + 1);
        } else if (id.length() == 4) {
            id += "0000" + (getIdTrack() + 1);
        } else if (id.length() == 5) {
            id += "000" + (getIdTrack() + 1);
        } else if (id.length() == 6) {
            id += "00" + (getIdTrack() + 1);
        } else if (id.length() == 7) {
            id += "0" + (getIdTrack() + 1);
        } else if (id.length() == 8) {
            id += (getIdTrack() + 1);
        } else {
            this.id = id;
        }
        this.id = id;
    }

    public void setFirstName(String firstName) {
        //validate that the first letter is capitalized
        if(firstName.charAt(0) != firstName.toUpperCase().charAt(0)){
            throw new IllegalArgumentException("First name must be capitalized");
        } //if first name has a space,throw an exception
        else if(firstName.contains(" ")){
            throw new IllegalArgumentException("First name cannot contain a space");
        } //if first name has a number, throw an exception
        else if(firstName.matches(".*\\d.*")){
            throw new IllegalArgumentException("First name cannot contain a number");
        } //if first name has a special character, throw an exception
        else if(firstName.matches("[^a-zA-Z0-9 ]")){
            throw new IllegalArgumentException("First name cannot contain a special character");
        }
        this.firstName = firstName;
    }

    public void setLastName(String lastName){
        //validate that the first letter is capitalized
        if(lastName.charAt(0) != lastName.toUpperCase().charAt(0)){
            throw new IllegalArgumentException("Last name must be capitalized");
        } //if last name has a space,throw an exception
        else if(lastName.contains(" ")){
            throw new IllegalArgumentException("Last name cannot contain a space");
        } //if last name has a number, throw an exception
        else if(lastName.matches(".*\\d.*")){
            throw new IllegalArgumentException("Last name cannot contain a number");
        } //if last name has a special character, throw an exception
        else if(lastName.matches("[^a-zA-Z0-9 ]")){
            throw new IllegalArgumentException("Last name cannot contain a special character");
        }
        this.lastName = lastName;
    }

    public void setAddressStreet(String addressStreet) {
        if(addressStreet == null || addressStreet.isEmpty()){
            throw new IllegalArgumentException("Address cannot be empty");
        }
        this.addressStreet = addressStreet;
    }

    public void setAddressCity(String addressCity) {

    }

    public void setAddressState(String addressState) {
        if(addressState.length() != 2){
            throw new IllegalArgumentException("State must be two characters");
        } else if(addressState.charAt(0) != addressState.toUpperCase().charAt(0) && addressState.charAt(1) != addressState.toUpperCase().charAt(1)){
            throw new IllegalArgumentException("State must be capitalized");
        } //if state has a number, throw an exception
        else if(addressState.matches(".*\\d.*")){
            throw new IllegalArgumentException("State cannot contain a number");
        } //if state has a special character, throw an exception
        else if(addressState.matches("[^a-zA-Z0-9 ]")){
            throw new IllegalArgumentException("State cannot contain a special character");
        }

    }

    public void setAddressZip(String addressZip) {
        //five digit limit
        this.addressZip = addressZip;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setWorkTitle(String workTitle) {
        this.workTitle = workTitle;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public void setWorkEmail() {
        //first letter of first name, last name, last two numbers of ID and then grab the last digit of number of employees
        this.workEmail = workEmail;
    }

    public void setFieldOffice(String fieldOffice) {
        this.fieldOffice = fieldOffice;
    }

    public void setIsActive(boolean isActive) {
        this.isActive = isActive;
    }


   //special methods
   public String toString(){
       return "Employee ID: " + getId() + "\n" +
               "Name: " + getFirstName() + " " + getLastName() + "\n" +
               "Address: " + getAddressStreet() + ", " + getAddressCity() + ", " + getAddressState() + " " + getAddressZip() + "\n" +
               "Phone Number: " + getPhoneNumber() + "\n" +
               "Work Title: " + getWorkTitle() + "\n" +
               "Salary: $" + getSalary() + "\n" +
               "Work Email: " + getWorkEmail() + "\n" +
               "Field Office: " + getFieldOffice() + "\n" +
               "Is Active: " + getIsActive() + "\n";
   }

   public String addressToString() {
       return getAddressStreet() + ", " + getAddressCity() + ", " + getAddressState() + " " + getAddressZip();
   }

   public String fullNameToString() {
       return getFirstName() + " " + getLastName();
   }

}
