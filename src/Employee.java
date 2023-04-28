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
    protected static int numEmployees;

    private static int idTrack;

    static final int MAX_EMPLOYEES = 100;

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

    public static int getNumEmployees() {
        return numEmployees;
    }

    public static int getMaxEmployees() {
        return MAX_EMPLOYEES;
    }

    public static int getIdTrack() {
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
        if(lastName == null || lastName.isEmpty()){
            throw new IllegalArgumentException("Last name cannot be empty");
        } else if(lastName.charAt(0) != lastName.toUpperCase().charAt(0)){
            throw new IllegalArgumentException("Last name must be capitalized");
        } else if(lastName.contains(" ")){
            throw new IllegalArgumentException("Last name cannot contain a space");
        } else if(lastName.matches(".*\\d.*")){
            throw new IllegalArgumentException("Last name cannot contain a number");
        } else if(lastName.matches("[^a-zA-Z0-9 ]")){
            throw new IllegalArgumentException("Last name cannot contain a special character");
        } else {
            this.lastName = lastName;
        }
    }

    public void setAddressStreet(String addressStreet) {
        if(addressStreet == null || addressStreet.isEmpty()){
            throw new IllegalArgumentException("Address cannot be empty");
        }
        this.addressStreet = addressStreet;
    }

    public void setAddressCity(String addressCity) {
        if (addressCity == null || addressCity.isEmpty()) {
            throw new IllegalArgumentException("City cannot be empty");
        }else if(addressCity.charAt(0) != addressCity.toUpperCase().charAt(0)){
            throw new IllegalArgumentException("City must be capitalized");
        } else if(addressCity.matches(".*\\d.*")){
            throw new IllegalArgumentException("City cannot contain a number");
        } else if(addressCity.matches("[^a-zA-Z0-9 ]")){
            throw new IllegalArgumentException("City cannot contain a special character");
        }
        this.addressCity = addressCity;

    }

    public void setAddressState(String addressState) {
        if (addressState == null || addressState.isEmpty()) {
            throw new IllegalArgumentException("State cannot be empty");
        } else if(addressState.length() != 2){
            throw new IllegalArgumentException("State must be two characters");
        } else if(addressState.charAt(0) != addressState.toUpperCase().charAt(0) && addressState.charAt(1) != addressState.toUpperCase().charAt(1)){
            throw new IllegalArgumentException("State must be capitalized");
        } else if(addressState.matches(".*\\d.*")){
            throw new IllegalArgumentException("State cannot contain a number");
        } else if(addressState.matches("[^a-zA-Z0-9 ]")){
            throw new IllegalArgumentException("State cannot contain a special character");
        }

    }

    public void setAddressZip(String addressZip) {
        //five-digit limit and no letters
        if(addressZip == null || addressZip.isEmpty()){
            throw new IllegalArgumentException("Zip code cannot be empty");
        } else if(addressZip.length() != 5){
            throw new IllegalArgumentException("Zip code must be 5 digits");
        } else if(addressZip.matches(".*[a-zA-Z]+.*")){
            throw new IllegalArgumentException("Zip code cannot contain letters");
        }
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
