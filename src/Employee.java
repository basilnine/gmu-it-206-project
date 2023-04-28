

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
    private final int MAX_INVENTORY_ITEM = 3;
    private InventoryItem[] Inventory = new InventoryItem[MAX_INVENTORY_ITEM];

    private static final int MAX_EMPLOYEES = 100;

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
        if (firstName.charAt(0) != firstName.toUpperCase().charAt(0)) {
            throw new IllegalArgumentException("First name must be capitalized");
        } //if first name has a space,throw an exception
        else if (firstName.contains(" ")) {
            throw new IllegalArgumentException("First name cannot contain a space");
        } //if first name has a number, throw an exception
        else if (firstName.matches(".*\\d.*")) {
            throw new IllegalArgumentException("First name cannot contain a number");
        } //if first name has a special character, throw an exception
        else if (firstName.matches("[^a-zA-Z0-9 ]")) {
            throw new IllegalArgumentException("First name cannot contain a special character");
        }
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        if (lastName == null || lastName.isEmpty()) {
            throw new IllegalArgumentException("Last name cannot be empty");
        } else if (lastName.charAt(0) != lastName.toUpperCase().charAt(0)) {
            throw new IllegalArgumentException("Last name must be capitalized");
        } else if (lastName.contains(" ")) {
            throw new IllegalArgumentException("Last name cannot contain a space");
        } else if (lastName.matches(".*\\d.*")) {
            throw new IllegalArgumentException("Last name cannot contain a number");
        } else if (lastName.matches("[^a-zA-Z0-9 ]")) {
            throw new IllegalArgumentException("Last name cannot contain a special character");
        } else {
            this.lastName = lastName;
        }
    }

    public void setAddressStreet(String addressStreet) {
        if (addressStreet == null || addressStreet.isEmpty()) {
            throw new IllegalArgumentException("Address cannot be empty");
        }
        this.addressStreet = addressStreet;
    }

    public void setAddressCity(String addressCity) {
        if (addressCity == null || addressCity.isEmpty()) {
            throw new IllegalArgumentException("City cannot be empty");
        } else if (addressCity.charAt(0) != addressCity.toUpperCase().charAt(0)) {
            throw new IllegalArgumentException("City must be capitalized");
        } else if (addressCity.matches(".*\\d.*")) {
            throw new IllegalArgumentException("City cannot contain a number");
        } else if (addressCity.matches("[^a-zA-Z0-9 ]")) {
            throw new IllegalArgumentException("City cannot contain a special character");
        }
        this.addressCity = addressCity;

    }

    public void setAddressState(String addressState) {
        if (addressState == null || addressState.isEmpty()) {
            throw new IllegalArgumentException("State cannot be empty");
        } else if (addressState.length() != 2) {
            throw new IllegalArgumentException("State must be two characters");
        } else if (addressState.charAt(0) != addressState.toUpperCase().charAt(0) && addressState.charAt(1) != addressState.toUpperCase().charAt(1)) {
            throw new IllegalArgumentException("State must be capitalized");
        } else if (addressState.matches(".*\\d.*")) {
            throw new IllegalArgumentException("State cannot contain a number");
        } else if (addressState.matches("[^a-zA-Z0-9 ]")) {
            throw new IllegalArgumentException("State cannot contain a special character");
        }
        this.addressState = addressState;

    }

    public void setAddressZip(String addressZip) {
        //five-digit limit and no letters
        if (addressZip == null || addressZip.isEmpty()) {
            throw new IllegalArgumentException("Zip code cannot be empty");
        } else if (addressZip.length() != 5) {
            throw new IllegalArgumentException("Zip code must be 5 digits");
        } else if (addressZip.matches(".*[a-zA-Z]+.*")) {
            throw new IllegalArgumentException("Zip code cannot contain letters");
        }
        this.addressZip = addressZip;
    }

    public void setPhoneNumber(String phoneNumber) {
        // Phone, format must be xxx-xxx-xxxx
        if (phoneNumber == null || phoneNumber.isEmpty()) {
            throw new IllegalArgumentException("Phone number cannot be empty");
        } else if (phoneNumber.length() != 12) {
            throw new IllegalArgumentException("Phone number must be 12 digits");
        } else if (phoneNumber.charAt(3) != '-' || phoneNumber.charAt(7) != '-') {
            throw new IllegalArgumentException("Phone number must be in the format xxx-xxx-xxxx");
        } else if (phoneNumber.matches(".*[a-zA-Z]+.*")) {
            throw new IllegalArgumentException("Phone number cannot contain letters");
        }
        this.phoneNumber = phoneNumber;
    }

    public void setWorkTitle(String workTitle) {
        if (workTitle == null || workTitle.isEmpty()) {
            throw new IllegalArgumentException("Work title cannot be empty");
        } else if (workTitle.matches(".*\\d.*")) {
            throw new IllegalArgumentException("Work title cannot contain a number");
        } else if (workTitle.matches("[^a-zA-Z0-9 ]")) {
            throw new IllegalArgumentException("Work title cannot contain a special character");
        }
        this.workTitle = workTitle;
    }

    public void setSalary(double salary) {
        if (salary < 0) {
            throw new IllegalArgumentException("Salary cannot be negative");
        } //if salary contains letters
        else if (String.valueOf(salary).matches(".*[a-zA-Z]+.*")) {
            throw new IllegalArgumentException("Salary cannot contain letters");
        } //if salary contains special characters
        else if (String.valueOf(salary).matches("[^a-zA-Z0-9 ]")) {
            throw new IllegalArgumentException("Salary cannot contain a special character");
        }
        this.salary = salary;
    }

    public void setWorkEmail() {
        //first letter of first name, last name, last two numbers of ID and then grab the last digit of number of employees
        String email = getFirstName().charAt(0) + getLastName() + getId().substring(getId().length() - 2) + String.valueOf(getNumEmployees()).substring(String.valueOf(getNumEmployees()).length() - 1);
        this.workEmail = email.toLowerCase() + "@agency.gov";

    }

    public void setFieldOffice(String fieldOffice) {
        if (fieldOffice == null || fieldOffice.isEmpty()) {
            throw new IllegalArgumentException("Field office cannot be empty");
        } else if (fieldOffice.matches(".*\\d.*")) {
            throw new IllegalArgumentException("Field office cannot contain a number");
        } else if (fieldOffice.matches("[^a-zA-Z0-9 ]")) {
            throw new IllegalArgumentException("Field office cannot contain a special character");
        }
        this.fieldOffice = fieldOffice;
    }

    public void setIsActive(boolean isActive) {
        this.isActive = isActive;
    }


    //special methods
    public String toString() {
        String output = "";
        //get id, full name to string(), get work title, field office, work email
        output += "ID: " + getId() + "\n" +
                "Full Name: " + fullNameToString() + " | " +
                "Work Title: " + getWorkTitle() + " | " +
                "Field Office: " + getFieldOffice() + " | " +
                "Work email: " + getWorkEmail() + " | ";
        return output;
    }

    public String addressToString() {
        return getAddressStreet() + ", " + getAddressCity() + ", " + getAddressState() + " " + getAddressZip();
    }

    public String fullNameToString() {
        return getFirstName() + " " + getLastName();
    }

    public void addInventoryItem(String empID, int type) {
        if (Inventory.length < MAX_INVENTORY_ITEM) {
            Inventory[(Inventory.length + 1)] = new InventoryItem(empID, type);
        } else {
            throw new IllegalArgumentException("Inventory is full");
        }
    }

    public void removeInventoryItem(InventoryItem item) {
        if (Inventory.length > 0) {
            Inventory[(Inventory.length - 1)] = null;
        } else {
            throw new IllegalArgumentException("Inventory is empty");
        }


    }
    public static void updateNumEmployees() {
        numEmployees--;
    }


}