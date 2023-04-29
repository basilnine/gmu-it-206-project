

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
    private static int numEmployees;

    private static int idTrack = 0;
    private static final int MAX_INVENTORY_ITEM = 3;
    private InventoryItem[] inventory = new InventoryItem[MAX_INVENTORY_ITEM];
    private int numInventoryItem;

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

    public int getNumInventoryItem(){
        return this.numInventoryItem;
    }

    public static int getMaxInventoryItems(){
        return MAX_INVENTORY_ITEM;
    }
    public String getInventoryString(int searchIndex){
        return inventory[searchIndex].toString();
    }
    
    public int getInventoryType(int searchIndex){
        return inventory[searchIndex].getType();
    }

    public String getInventoryToString(int searchIndex){
        return inventory[searchIndex].toString();
    }

    //mutators

    public void setID() {
        //generate an ID with a 3 digit
        String id = "LE" + getIdTrack();
        
        if (id.length() == 3) {
            id = "LE000" + (getIdTrack() + 1);
        } 
        else if (id.length() == 4) {
            id = "LE00" + (getIdTrack() + 1);
        } 
        else if (id.length() == 5) {
            id = "LE0" + (getIdTrack() + 1);
        } 
        else{
            id = "LE" + (getIdTrack() + 1);
        }

        this.id = id;
    }

    public void setFirstName(String firstName) {
        //validate that the first letter is capitalized
        if (firstName.charAt(0) != firstName.toUpperCase().charAt(0)) {
            throw new IllegalArgumentException("First name must be capitalized");
        } 
        //if first name has a space, throw an exception
        else if (firstName.contains(" ")) {
            throw new IllegalArgumentException("First name cannot contain a space");
        } 
        //if first name has a number, throw an exception
        else if (firstName.matches(".*\\d.*")) {
            throw new IllegalArgumentException("First name cannot contain a number");
        } 
        //if first name has a special character, throw an exception
        else if (firstName.matches("[^a-zA-Z0-9 ]")) {
            throw new IllegalArgumentException("First name cannot contain a special character");
        }
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        if (lastName == null || lastName.isEmpty()) {
            throw new IllegalArgumentException("Last name cannot be empty");
        } 
        else if (lastName.charAt(0) != lastName.toUpperCase().charAt(0)) {
            throw new IllegalArgumentException("Last name must be capitalized");
        } 
        else if (lastName.contains(" ")) {
            throw new IllegalArgumentException("Last name cannot contain a space");
        } 
        else if (lastName.matches(".*\\d.*")) {
            throw new IllegalArgumentException("Last name cannot contain a number");
        } 
        else if (lastName.matches("[^a-zA-Z0-9 ]")) {
            throw new IllegalArgumentException("Last name cannot contain a special character");
        } 
        else {
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
        //two-character limit, capitalized, no numbers, no special characters
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
        //salary cannot be negative
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
        //field office cannot be empty, cannot contain numbers, cannot contain special characters
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
                "Position: " + getWorkTitle() + " | " +
                "Field Office: " + getFieldOffice() + " | " +
                "Work Email: " + getWorkEmail() + " | ";
        return output;
    }

    public String addressToString() {
        return getAddressStreet() + ", " + getAddressCity() + ", " + getAddressState() + " " + getAddressZip();
    }

    public String fullNameToString() {
        return getFirstName() + " " + getLastName();
    }

    public void addInventoryItem(String empID, int type) {
        //if inventory is not full, add item
        if (numInventoryItem < MAX_INVENTORY_ITEM) {
            inventory[(numInventoryItem)] = new InventoryItem(empID, type);
            this.numInventoryItem++;
        } 
        else {
            throw new IllegalArgumentException("Inventory is full!");
        }
    }

    public int searchInventoryItem(int itemType){
        int index = -1;
        for (int i = 0; i < numInventoryItem; i++){
            if (itemType == inventory[i].getType()){
                index = i;
            }
        }
        return index;
    }

    public void removeInventoryItem(int searchIndex) {
        int inventoryType = getInventoryType(searchIndex);
        
        if (inventoryType == 0){
            InventoryItem.updateNumLaptops();
        }
        if (inventoryType == 1){
            InventoryItem.updateNumPhones();
        }
        if (inventoryType == 2){
            InventoryItem.updateNumPatrolCars();
        }

        if (numInventoryItem > 0) {
            for (int i = searchIndex; i < numInventoryItem; i++){
                inventory[i] = inventory[i+1];
            }
            this.numInventoryItem--;
        } 
        else {
            throw new IllegalArgumentException("Inventory is empty!");
        }
    }


    public static void updateNumEmployees() {
        numEmployees--;
    }
}