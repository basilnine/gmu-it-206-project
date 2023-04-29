import javax.swing.JOptionPane;
public class EnforcementHR {
    public static void main(String[] args){
        Employee[] employeeRoster = new Employee[Employee.getMaxEmployees()];
        String menu = "HR Law Enforcement System\n\n1. Add New Employee\n2. Update Employee\n3. Remove Employee\n4. Search Employee\n5. Manage Employee Inventory\n6. Generate Reports\n7. Quit";
        int choice = 0;
        do{
            try{
                switch(choice = Integer.parseInt(JOptionPane.showInputDialog(menu))){
                    case 1:
                    addEmployee(employeeRoster);
                    break;
                    
                    case 2:
                    updateEmployee(employeeRoster);
                    break;
                    
                    case 3:
                    removeEmployee(employeeRoster);
                    break;
                    
                    case 4:
                    searchEmployee(employeeRoster);
                    break;
                    
                    case 5:
                    manageInventory(employeeRoster);
                    break;
                    
                    case 6:
                    generateReports(employeeRoster);
                    break;
                    
                    case 7:
                    break;
                    
                    default:
                    JOptionPane.showMessageDialog(null, "Please choose a number between 1 and 7!", "Error!", JOptionPane.ERROR_MESSAGE);
                    break;
                }
            }catch(Exception e){
                JOptionPane.showMessageDialog(null, e.getMessage(), "Error!", JOptionPane.ERROR_MESSAGE);
            }
        }while(choice != 7);
        JOptionPane.showMessageDialog(null, "Powering off..");
        System.exit(0);
    }

    public static void addEmployee(Employee[] employeeRoster){

        if (Employee.getNumEmployees() <= Employee.getMaxEmployees()){
            String firstName = JOptionPane.showInputDialog("Enter First Name:");
            String lastName = JOptionPane.showInputDialog("Enter Last Name:");
            String addressStreet = JOptionPane.showInputDialog("Enter Street Number and Name:");
            String addressCity = JOptionPane.showInputDialog("Enter City Name:");
            String addressState = JOptionPane.showInputDialog("Enter State Initials:");
            String addressZIP = JOptionPane.showInputDialog("Enter ZIP code:");
            String phone = JOptionPane.showInputDialog("Enter Phone Number [Format: (xxx-xxx-xxxx)]:");
            String fieldOffice = JOptionPane.showInputDialog("Enter Field Office Location:");
            String[] options = new String[] {"Agent", "Professional Staff", "Lab Specialist"};
            int response = JOptionPane.showOptionDialog(null, "Pick Employee Type", "Title", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE,null, options, options[0]);
            String workTitle = JOptionPane.showInputDialog("Enter Position Title:");
            double salary = Double.parseDouble(JOptionPane.showInputDialog("Enter Salary:"));

            if (response == 0){
                String radioNum = JOptionPane.showInputDialog("Enter Radio Number:");
                String assignNum = JOptionPane.showInputDialog("Enter Assignment Number:");
                String rank = JOptionPane.showInputDialog("Enter Rank:");
                employeeRoster[Employee.getNumEmployees()] = new Agent(firstName, lastName, addressStreet, addressCity, addressState, addressZIP, phone, workTitle, salary, fieldOffice, radioNum, assignNum, rank);
            }
            else if (response == 1){
                String cubicleNum = JOptionPane.showInputDialog("Enter Cubicle Number:");
                employeeRoster[Employee.getNumEmployees()] = new ProfessionalStaff(firstName, lastName, addressStreet, addressCity, addressState, addressZIP, phone, workTitle, salary, fieldOffice, cubicleNum);
            }
            else if (response == 2){
                String labNum = JOptionPane.showInputDialog("Enter Lab Number:");
                employeeRoster[Employee.getNumEmployees()] = new LabSpecialist(firstName, lastName, addressStreet, addressCity, addressState, addressZIP, phone, workTitle, salary, fieldOffice, labNum);
            }
            else{
                JOptionPane.showMessageDialog(null, "Must choose a valid employee type!", "Error!", JOptionPane.ERROR_MESSAGE);
            }
        }
        else{
            JOptionPane.showMessageDialog(null, "Maximum number of employees met!", "Error!", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static int searchEmployeeByID(Employee[] employeeRoster, String id){
        int index = -1;
        for (int i = 0; i < Employee.getNumEmployees(); i++){
            if (id.equalsIgnoreCase(employeeRoster[i].getId())){
                index = i;
            }
        }
        return index;
    }

    public static int searchEmployeeByName(Employee[] employeeRoster, String name){
        int index = -1;
        for (int i = 0; i < Employee.getNumEmployees(); i++){
            if (name.equalsIgnoreCase(employeeRoster[i].fullNameToString())){
                index = i;
            }
        }
        return index;
    }

    public static int searchEmployeeByPhone(Employee[] employeeRoster, String phone){
        int index = -1;
        for (int i = 0; i < Employee.getNumEmployees(); i++){
            if (phone.equalsIgnoreCase(employeeRoster[i].getPhoneNumber())){
                index = i;
            }
        }
        return index;
    }

    public static int searchEmployeeByEmail(Employee[] employeeRoster, String email){
        int index = -1;
        for (int i = 0; i < Employee.getNumEmployees(); i++){
            if (email.equalsIgnoreCase(employeeRoster[i].getWorkEmail())){
                index = i;
            }
        }
        return index;
    }

    public static void updateEmployee(Employee[] employeeRoster){
        if (Employee.getNumEmployees() > 0){
            String id = JOptionPane.showInputDialog("Enter Employee ID:");
            int search = searchEmployeeByID(employeeRoster, id);
            if (search == -1){
                JOptionPane.showMessageDialog(null, "Employee not found!", "Error!", JOptionPane.ERROR_MESSAGE);
            }
            else{
                String menu = "** Update Employee Data **\nID: " + employeeRoster[search].getId() + "\n\n";
                menu += "1. Update Name\n2. Update Address\n3. Update Salary\n4. Update Position\n5. Update Phone Number";
                if (employeeRoster[search] instanceof Agent){
                    menu += "\n6. Update Agent Data";
                }
                if (employeeRoster[search] instanceof ProfessionalStaff){
                    menu += "\n6. Update Professional Staff Data";
                }
                if (employeeRoster[search] instanceof LabSpecialist){
                    menu += "\n6. Update Lab Specialist Data";
                }
                menu += "\n7. Exit";
                int choice = 0;
                do{
                    try{
                        switch(choice = Integer.parseInt(JOptionPane.showInputDialog(menu))){
                            case 1:
                            updateName(employeeRoster, search);
                            break;

                            case 2:
                            updateAddress(employeeRoster, search);
                            break;

                            case 3:
                            updateSalary(employeeRoster, search);
                            break;

                            case 4:
                            updatePosition(employeeRoster, search);
                            break;

                            case 5:
                            updatePhone(employeeRoster, search);
                            break;

                            case 6:
                            updateEmployeeTypeData(employeeRoster, search);
                            break;

                            case 7:
                            break;

                            default:
                            JOptionPane.showMessageDialog(null, "Please choose a number between 1 and 7!", "Error!", JOptionPane.ERROR_MESSAGE);
                            break;
                        }
                    }catch(Exception e){
                        JOptionPane.showMessageDialog(null, e.getMessage(), "Error!", JOptionPane.ERROR_MESSAGE);
                    }
                }while(choice != 7);
            }
        }
        else{
            JOptionPane.showMessageDialog(null, "There are no employees!", "Error!", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void updateName(Employee[] employeeRoster, int search){
        String firstName = JOptionPane.showInputDialog("Enter first name:");
        String lastName = JOptionPane.showInputDialog("Enter last name:");
        employeeRoster[search].setFirstName(firstName);
        employeeRoster[search].setLastName(lastName);
        JOptionPane.showMessageDialog(null, "Name has been updated!", "Updated Data!", JOptionPane.WARNING_MESSAGE);
    }

    public static void updateAddress(Employee[] employeeRoster, int search){
        String addressStreet = JOptionPane.showInputDialog("Enter street address:");
        String addressCity = JOptionPane.showInputDialog("Enter city:");
        String addressState = JOptionPane.showInputDialog("Enter state:");
        String addressZIP = JOptionPane.showInputDialog("Enter zip code:");
        employeeRoster[search].setAddressStreet(addressStreet);
        employeeRoster[search].setAddressCity(addressCity);
        employeeRoster[search].setAddressState(addressState);
        employeeRoster[search].setAddressZip(addressZIP);
        JOptionPane.showMessageDialog(null, "Address has been updated!", "Updated Data!", JOptionPane.WARNING_MESSAGE);
    }

    public static void updateSalary(Employee[] employeeRoster, int search){
        double salary = Double.parseDouble(JOptionPane.showInputDialog("Enter salary:"));
        employeeRoster[search].setSalary(salary);
        JOptionPane.showMessageDialog(null, "Salary has been updated!", "Updated Data!", JOptionPane.WARNING_MESSAGE);
    }

    public static void updatePosition(Employee[] employeeRoster, int search){
        String position = JOptionPane.showInputDialog("Enter positon:");
        int choice = JOptionPane.showConfirmDialog(null, "Does this new position come with a salary update?", "", JOptionPane.YES_NO_OPTION);
        employeeRoster[search].setWorkTitle(position);
        if (choice == JOptionPane.YES_OPTION){
            double salary = Double.parseDouble(JOptionPane.showInputDialog("Enter salary:"));
            employeeRoster[search].setSalary(salary);
            JOptionPane.showMessageDialog(null, "Position and Salary has been updated!", "Updated Data!", JOptionPane.WARNING_MESSAGE);
        } 
        else {
            JOptionPane.showMessageDialog(null, "Position has been updated!", "Updated Data!", JOptionPane.WARNING_MESSAGE);
        }
    }

    public static void updatePhone(Employee[] employeeRoster, int search){
        String phone = JOptionPane.showInputDialog("Enter phone number:");
        employeeRoster[search].setPhoneNumber(phone);
        JOptionPane.showMessageDialog(null, "Phone number has been updated!", "Updated Data!", JOptionPane.WARNING_MESSAGE);
    }

    public static void updateEmployeeTypeData(Employee[] employeeRoster, int search){
        if (employeeRoster[search] instanceof Agent){
            String menu = "Update Agent Data:\n\n1. Update Radio Number\n2. Update Assignment Number\n3. Update Rank";
            switch(Integer.parseInt(JOptionPane.showInputDialog(menu))){
                case 1:
                String radioNum = JOptionPane.showInputDialog("Enter Radio Number:");
                ((Agent)employeeRoster[search]).setRadioNum(radioNum);
                JOptionPane.showMessageDialog(null, "Radio number has been updated!", "Updated Data!", JOptionPane.WARNING_MESSAGE);
                break;

                case 2:
                String assignNum = JOptionPane.showInputDialog("Enter Assignment Number:");
                ((Agent)employeeRoster[search]).setAssignNum(assignNum);
                JOptionPane.showMessageDialog(null, "Assignment number has been updated!", "Updated Data!", JOptionPane.WARNING_MESSAGE);
                break;

                case 3:
                String rank = JOptionPane.showInputDialog("Enter Rank:");
                ((Agent)employeeRoster[search]).setRank(rank);
                JOptionPane.showMessageDialog(null, "Rank has been updated!", "Updated Data!", JOptionPane.WARNING_MESSAGE);
                break;

                default:
                JOptionPane.showMessageDialog(null, "Please choose a number between 1 and 3!", "Error!", JOptionPane.ERROR_MESSAGE);
                break;
            }
        }
        if (employeeRoster[search] instanceof LabSpecialist){
            String labNum = JOptionPane.showInputDialog("Enter Lab Number:");
            ((LabSpecialist)employeeRoster[search]).setLabNum(labNum);
            JOptionPane.showMessageDialog(null, "Lab number has been updated!", "Updated Data!", JOptionPane.WARNING_MESSAGE);
        }
        if (employeeRoster[search] instanceof ProfessionalStaff){
            String cubicleNum = JOptionPane.showInputDialog("Enter Cubicle Number:");
            ((ProfessionalStaff)employeeRoster[search]).setCubicleNum(cubicleNum);
            JOptionPane.showMessageDialog(null, "Cubicle number has been updated!", "Updated Data!", JOptionPane.WARNING_MESSAGE);

        }
    }

    public static void removeEmployee(Employee[] employeeRoster){
        if (Employee.getNumEmployees() > 0){
            String id = JOptionPane.showInputDialog("Enter Employee ID you would like to remove:");
            int search = searchEmployeeByID(employeeRoster, id);
            if (search == -1){
                JOptionPane.showMessageDialog(null, "Employee not found!", "Error!", JOptionPane.ERROR_MESSAGE);
            }
            else{
                if (employeeRoster[search] instanceof Agent){
                    Agent.updateNumAgents();
                }
                if (employeeRoster[search] instanceof ProfessionalStaff){
                    ProfessionalStaff.updateNumProfStaff();
                }
                if (employeeRoster[search] instanceof LabSpecialist){
                    LabSpecialist.updateNumLabSpecialists();
                }
                if (employeeRoster[search].getNumInventoryItem() > 0){
                    for (int i = employeeRoster[search].getNumInventoryItem(); i > 0; i--){
                        employeeRoster[search].removeInventoryItem(i-1);
                    }
                }
                for (int i = search; i < Employee.getNumEmployees(); i++){
                    employeeRoster[i] = employeeRoster[i+1];
                }
                Employee.updateNumEmployees();
                JOptionPane.showMessageDialog(null, "Employee ID: " + id + " has been deleted!", "Deleted!", JOptionPane.WARNING_MESSAGE);
            }
        }
        else{
            JOptionPane.showMessageDialog(null, "There are no employees!", "Error!", JOptionPane.ERROR_MESSAGE);
        }

    }

    public static void printEmployeeReport(Employee[] employeeRoster, int i){
        if (i >= 0){
            String report = "** Employee Report **\n\n";
            report += "ID: " + employeeRoster[i].getId() + "\nName: " + employeeRoster[i].fullNameToString() + "\nAddress: " + employeeRoster[i].addressToString() +
            "\nPhone number: " + employeeRoster[i].getPhoneNumber() + "\nEmail: " + employeeRoster[i].getWorkEmail() +
            "\nPosition: " + employeeRoster[i].getWorkTitle() + "\nSalary: " + String.format("$%.2f", employeeRoster[i].getSalary()) +
            "\nField Office: " + employeeRoster[i].getFieldOffice() + "\nActivity Status: ";

            if (employeeRoster[i].getIsActive() == true){
                report += "True";
            }
            else{
                report += "False";
            }

            if (employeeRoster[i] instanceof Agent){
                report += "\n\nAgent Details:\nRadio Number: " + ((Agent)employeeRoster[i]).getRadioNum() +
                "\nAssignment Number: " + ((Agent)employeeRoster[i]).getAssignNum() + "\nRank: " +
                ((Agent)employeeRoster[i]).getRank();
            }
            if (employeeRoster[i] instanceof ProfessionalStaff){
                report += "\n\nProfessional Staff Details:\nCubicle Number: " + ((ProfessionalStaff)employeeRoster[i]).getCubicleNum();
            }
            if (employeeRoster[i] instanceof LabSpecialist){
                report += "\n\nLab Specialist Details:\nLab Number: " + ((LabSpecialist)employeeRoster[i]).getLabNum();
            }

            JOptionPane.showMessageDialog(null, report, "Employee Report", JOptionPane.INFORMATION_MESSAGE);
        }
        else{
            JOptionPane.showMessageDialog(null, "Employee not found!", "Error!", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void searchEmployee(Employee[] employeeRoster){
        if (Employee.getNumEmployees() > 0){
            int index = -1;
            String menu = "** Search Employee **\n\n1. Search by ID\n2. Search by Name\n3. Search by Phone\n4. Search by Email\n5. Exit";
            try{
                switch(Integer.parseInt(JOptionPane.showInputDialog(menu))){
                    case 1:
                    String id = JOptionPane.showInputDialog("Enter ID:");
                    index = searchEmployeeByID(employeeRoster, id);
                    printEmployeeReport(employeeRoster, index);
                    break;

                    case 2:
                    String name = JOptionPane.showInputDialog("Enter Full Name:");
                    index = searchEmployeeByName(employeeRoster, name);
                    printEmployeeReport(employeeRoster, index);
                    break;

                    case 3:
                    String phone = JOptionPane.showInputDialog("Enter Phone Number:");
                    index = searchEmployeeByPhone(employeeRoster, phone);
                    printEmployeeReport(employeeRoster, index);
                    break;

                    case 4:
                    String email = JOptionPane.showInputDialog("Enter Email:");
                    index = searchEmployeeByEmail(employeeRoster, email);
                    printEmployeeReport(employeeRoster, index);
                    break;

                    case 5:
                    break;

                    default:
                    JOptionPane.showMessageDialog(null, "Please choose a number between 1 and 5!", "Error!", JOptionPane.ERROR_MESSAGE);
                    break;

                }
            }catch(Exception e){
                JOptionPane.showMessageDialog(null, e.getMessage(), "Error!", JOptionPane.ERROR_MESSAGE);
            }
        }
        else{
            JOptionPane.showMessageDialog(null, "There are no employees!", "Error!", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void manageInventory(Employee[] employeeRoster){
        if (Employee.getNumEmployees() > 0){
            String menu = "** Inventory Management **\n\n1. Assign an Inventory Item\n2. Return an Inventory Item\n3. Employee Inventory Audit\n4. Exit";
            try{
                switch(Integer.parseInt(JOptionPane.showInputDialog(menu))){
                    case 1:
                    assignInventoryItem(employeeRoster);
                    break;

                    case 2:
                    returnInventoryItem(employeeRoster);
                    break;

                    case 3:
                    auditInventoryItem(employeeRoster);
                    break;

                    case 4:
                    break;

                    default:
                    JOptionPane.showMessageDialog(null, "Please choose a number between 1 and 4!", "Error!", JOptionPane.ERROR_MESSAGE);
                    break;

                }

            }catch(Exception e){
                JOptionPane.showMessageDialog(null, e.getMessage(), "Error!", JOptionPane.ERROR_MESSAGE);
            }
        }
        else{
            JOptionPane.showMessageDialog(null, "There are no employees!", "Error!", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void assignInventoryItem(Employee[] employeeRoster){
        String id = JOptionPane.showInputDialog("Enter Employee ID:");
        int searchIndex = searchEmployeeByID(employeeRoster, id);
        try{
            if (searchIndex >= 0){
                if (employeeRoster[searchIndex].getNumInventoryItem() < Employee.getMaxInventoryItems()){
                    String[] options = new String[] {"Laptop", "Cell Phone", "Patrol Car"};
                    int itemType = JOptionPane.showOptionDialog(null, "What item would you like to assign " + employeeRoster[searchIndex].fullNameToString() + "?", "Title", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE,null, options, options[0]);
                    if (employeeRoster[searchIndex].searchInventoryItem(itemType) == -1){
                        employeeRoster[searchIndex].addInventoryItem(id, itemType);
                        JOptionPane.showMessageDialog(null, "Item has been assigned to employee!", "Success!", JOptionPane.INFORMATION_MESSAGE);
                    }
                    else{
                        JOptionPane.showMessageDialog(null, "Item type already assigned to this employee!", "Error!", JOptionPane.ERROR_MESSAGE);
                    }
                }
                else{
                    JOptionPane.showMessageDialog(null, "This employee has the maximum amount of items!", "Error!", JOptionPane.ERROR_MESSAGE);
                }
            }
            else{
                JOptionPane.showMessageDialog(null, "Employee not found!", "Error!", JOptionPane.ERROR_MESSAGE);
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error!", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void returnInventoryItem(Employee[] employeeRoster){
        String id = JOptionPane.showInputDialog("Enter Employee ID:");
        int searchIndex = searchEmployeeByID(employeeRoster, id);
        try{
            if (searchIndex >= 0){
                if (employeeRoster[searchIndex].getNumInventoryItem() > 0){
                    String[] options = new String[employeeRoster[searchIndex].getNumInventoryItem()];
                    for (int i = 0; i < employeeRoster[searchIndex].getNumInventoryItem(); i++){
                        if (employeeRoster[searchIndex].getInventoryType(i) == 0){
                            options[i] = "Laptop";
                        }
                        if (employeeRoster[searchIndex].getInventoryType(i) == 1){
                            options[i] = "Phone";
                        }
                        if (employeeRoster[searchIndex].getInventoryType(i) == 2){
                            options[i] = "Patrol Car";
                        }
                    }
                    int choice = JOptionPane.showOptionDialog(null, "What item would you like " + employeeRoster[searchIndex].fullNameToString() + " to return?", "Title", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE,null, options, options[0]);
                    int itemType = -1;
                    if (options[choice].equals("Laptop")){
                        itemType = 0;
                    }
                    if (options[choice].equals("Phone")){
                        itemType = 1;
                    }
                    if (options[choice].equals("Patrol Car")){
                        itemType = 2;
                    }
                    int inventorySearchIndex = employeeRoster[searchIndex].searchInventoryItem(itemType);
                    employeeRoster[searchIndex].removeInventoryItem(inventorySearchIndex);
                    JOptionPane.showMessageDialog(null, "Item has been successfully returned to Inventory!", "Success!", JOptionPane.INFORMATION_MESSAGE);
                }
                else{
                    JOptionPane.showMessageDialog(null, "Employee has not been assigned any items!", "Error!", JOptionPane.ERROR_MESSAGE);
                }
            }
            else{
                JOptionPane.showMessageDialog(null, "Employee not found!", "Error!", JOptionPane.ERROR_MESSAGE);
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error!", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void auditInventoryItem(Employee[] employeeRoster){
        String id = JOptionPane.showInputDialog("Enter Employee ID:");
        int searchIndex = searchEmployeeByID(employeeRoster, id);
        try{
            if (searchIndex >= 0){
                if (employeeRoster[searchIndex].getNumInventoryItem() > 0){
                    String report = "Employee ID: " + employeeRoster[searchIndex].getId() + "\n\n";
                    report += employeeRoster[searchIndex].fullNameToString() + " has been assigned these items:";
                    for (int i = 0; i < employeeRoster[searchIndex].getNumInventoryItem(); i++){
                        report += "\n" + employeeRoster[searchIndex].getInventoryString(i);
                    }
                    JOptionPane.showMessageDialog(null, report, "Employee Item Audit Report", JOptionPane.INFORMATION_MESSAGE);
                }
                else{
                    JOptionPane.showMessageDialog(null, "Employee has not been assigned any items!", "Error!", JOptionPane.ERROR_MESSAGE);
                }
            }
            else{
                JOptionPane.showMessageDialog(null, "Employee not found!", "Error!", JOptionPane.ERROR_MESSAGE);
            }

        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error!", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void generateReports(Employee[] employeeRoster){
        if (Employee.getNumEmployees() > 0){
            String menu = "** Generate Reports **\n\n1. Organization Report\n2. Inventory Report\n3. Exit";
            try{
                switch(Integer.parseInt(JOptionPane.showInputDialog(menu))){
                    case 1:
                    generateOrgReport(employeeRoster);
                    break;
                    
                    case 2:
                    generateInventoryReport(employeeRoster);
                    break;

                    case 3:
                    break;

                    default:
                    JOptionPane.showMessageDialog(null, "Please choose a number between 1 and 3!", "Error!", JOptionPane.ERROR_MESSAGE);
                    break;
                }
            }catch(Exception e){
                JOptionPane.showMessageDialog(null, e.getMessage(), "Error!", JOptionPane.ERROR_MESSAGE);
            }
        }
        else{
            JOptionPane.showMessageDialog(null, "There are no employees!", "Error!", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public static void generateOrgReport(Employee[] employeeRoster){
        String report1 = "** Employee Stats **\n\nNumber of Employees: " + Employee.getNumEmployees() +
        "\nNumber of Agents: " + Agent.getNumAgents() + "\nNumber of Lab Specialists: " + LabSpecialist.getNumLabSpecialists() +
        "\nNumber of Professional Specialists: " + ProfessionalStaff.getNumProfStaff();
        String report2 = "** Employee List **\n\n";
        double salary = 0;
        for (int i = 0; i < Employee.getNumEmployees(); i++){
            report2 += employeeRoster[i].toString() + "\n";
            salary += employeeRoster[i].getSalary();
        }
        report1 += "\n\nTotal Employee Budget: " + String.format("$%.2f", salary);
        JOptionPane.showMessageDialog(null, report1, "Organization Report", JOptionPane.INFORMATION_MESSAGE);
        JOptionPane.showMessageDialog(null, report2, "Organization Report", JOptionPane.INFORMATION_MESSAGE);
    }

    public static void generateInventoryReport(Employee[] employeeRoster){
        if (InventoryItem.numLaptopsUsed() == 0 && InventoryItem.numPhonesUsed() == 0 && InventoryItem.numPatrolCarsUsed() == 0){
            JOptionPane.showMessageDialog(null, "No inventory items have been assigned to any employee!", "Error!", JOptionPane.ERROR_MESSAGE);
        }
        else{
            String report1 = "** Inventory Stats **\n\n";
            report1 += InventoryItem.numLaptopsUsed() + " out of " + InventoryItem.getMaxLaptops() + " laptops have been used.\n" +
            InventoryItem.numPhonesUsed() + " out of " + InventoryItem.getMaxPhones() + " phones have been used.\n" +
            InventoryItem.numPatrolCarsUsed() + " out of " + InventoryItem.getMaxPatrolCars() + " patrol cars have been used.";
            String report2 = "** Inventory List **\n";
            for (int i = 0; i < Employee.getNumEmployees(); i++){
                if ((employeeRoster[i].getNumInventoryItem()) > 0){
                    report2 += "\n" + employeeRoster[i].getId() + ": " + employeeRoster[i].fullNameToString() + " assigned items: ";
                    for (int j = 0; j < (employeeRoster[i].getNumInventoryItem()); j++){
                        if ((j+1) == (employeeRoster[i].getNumInventoryItem())){
                            report2 += employeeRoster[i].getInventoryToString(j);
                        }
                        else{
                            report2 += employeeRoster[i].getInventoryToString(j) + ", ";
                        }
                    }
                }
            }
            JOptionPane.showMessageDialog(null, report1, "Inventory Report", JOptionPane.INFORMATION_MESSAGE);
            JOptionPane.showMessageDialog(null, report2, "Inventory Report", JOptionPane.INFORMATION_MESSAGE);
        }
    }

}