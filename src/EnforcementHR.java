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
                    //searchEmployee(employeeRoster);
                    break;
                    case 5:
                    //manageInventory(employeeRoster);
                    break;
                    case 6:
                    //generateReports(employeeRoster);
                    break;
                    case 7:
                    break;
                    default:
                    JOptionPane.showMessageDialog(null, "Please choose a number between 1 and 7!", "Error!", JOptionPane.ERROR_MESSAGE);
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
            String addressCity = JOptionPane.showInputDialog("Enter city name:");
            String addressState = JOptionPane.showInputDialog("Enter state initials:");
            String addressZIP = JOptionPane.showInputDialog("Enter ZIP code:");
            String phone = JOptionPane.showInputDialog("Enter phone number format: (xxx) xxx xxx:");
            String fieldOffice = JOptionPane.showInputDialog("Enter Field Office Location:");
            String[] options = new String[] {"Agent", "Professional Staff", "Lab Specialist"};
            int response = JOptionPane.showOptionDialog(null, "Pick Employee Type", "Title", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE,null, options, options[0]);
            String workTitle = JOptionPane.showInputDialog("Enter work title:");
            double salary = Double.parseDouble(JOptionPane.showInputDialog("Enter salary:"));

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
            JOptionPane.showMessageDialog(null, "Maximum Number of Employees Met!", "Error!", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static int searchEmployeeByID(Employee[] rosterEmployees, String id){
        int index = -1;
        for (int i = 0; i < Employee.getNumEmployees(); i++){
            if (id.equalsIgnoreCase(rosterEmployees[i].getId())){
                index = i;
            }
        }
        return index;
    }

    public static int searchEmployeeByName(Employee[] rosterEmployees, String name){
        int index = -1;
        for (int i = 0; i < Employee.getNumEmployees(); i++){
            if (name.equalsIgnoreCase(rosterEmployees[i].fullNameToString())){
                index = i;
            }
        }
        return index;
    }

    public static int searchEmployeeByPhone(Employee[] rosterEmployees, String phone){
        int index = -1;
        for (int i = 0; i < Employee.getNumEmployees(); i++){
            if (phone.equalsIgnoreCase(rosterEmployees[i].getPhoneNumber())){
                index = i;
            }
        }
        return index;
    }

    public static int searchEmployeeByEmail(Employee[] rosterEmployees, String email){
        int index = -1;
        for (int i = 0; i < Employee.getNumEmployees(); i++){
            if (email.equalsIgnoreCase(rosterEmployees[i].getWorkEmail())){
                index = i;
            }
        }
        return index;
    }

    public static void updateEmployee(Employee[] rosterEmployees){
        if (Employee.getNumEmployees() > 0){
            String id = JOptionPane.showInputDialog("Enter Employee ID:");
            int search = searchEmployeeByID(rosterEmployees, id);
            if (search == -1){
                JOptionPane.showMessageDialog(null, "Employee not found!", "Error!", JOptionPane.ERROR_MESSAGE);
            }
            else{
                String menu = "** Update Employee Data **\n\n1. Update Name\n.2. Update Address\n3. Salary\n4. Update Position\n5. Update Phone Number";
                if (rosterEmployees[search] instanceof Agent){
                    menu += "\n6. Update Agent Data";
                }
                if (rosterEmployees[search] instanceof ProfessionalStaff){
                    menu += "\n6. Update Professional Staff Data";
                }
                if (rosterEmployees[search] instanceof LabSpecialist){
                    menu += "\n6. Update Lab Specialist Data";
                }
                menu += "\n7. Exit";
                int choice = 0;
                do{
                    try{
                        switch(choice = Integer.parseInt(JOptionPane.showInputDialog(menu))){
                            case 1:
                            updateName(rosterEmployees, search);
                            break;

                            case 2:
                            updateAddress(rosterEmployees, search);
                            break;

                            case 3:
                            updateSalary(rosterEmployees, search);
                            break;

                            case 4:
                            updatePosition(rosterEmployees, search);
                            break;

                            case 5:
                            updatePhone(rosterEmployees, search);
                            break;

                            case 6:
                            updateEmployeeTypeData(rosterEmployees, search);
                            break;

                            case 7:
                            break;

                            default:
                            JOptionPane.showMessageDialog(null, "Please choose a number between 1 and 7!", "Error!", JOptionPane.ERROR_MESSAGE);
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

    public static void updateName(Employee[] rosterEmployees, int search){
        String firstName = JOptionPane.showInputDialog("Enter first name:");
        String lastName = JOptionPane.showInputDialog("Enter last name:");
        rosterEmployees[search].setFirstName(firstName);
        rosterEmployees[search].setLastName(lastName);
        JOptionPane.showMessageDialog(null, "Name has been updated!", "Updated Data!", JOptionPane.WARNING_MESSAGE);
    }

    public static void updateAddress(Employee[] rosterEmployees, int search){
        String addressStreet = JOptionPane.showInputDialog("Enter street address:");
        String addressCity = JOptionPane.showInputDialog("Enter city:");
        String addressState = JOptionPane.showInputDialog("Enter state:");
        String addressZIP = JOptionPane.showInputDialog("Enter zip code:");
        rosterEmployees[search].setAddressStreet(addressStreet);
        rosterEmployees[search].setAddressCity(addressCity);
        rosterEmployees[search].setAddressState(addressState);
        rosterEmployees[search].setAddressZip(addressZIP);
        JOptionPane.showMessageDialog(null, "Address has been updated!", "Updated Data!", JOptionPane.WARNING_MESSAGE);
    }

    public static void updateSalary(Employee[] rosterEmployees, int search){
        double salary = Double.parseDouble(JOptionPane.showInputDialog("Enter salary:"));
        rosterEmployees[search].setSalary(salary);
        JOptionPane.showMessageDialog(null, "Salary has been updated!", "Updated Data!", JOptionPane.WARNING_MESSAGE);
    }

    public static void updatePosition(Employee[] rosterEmployees, int search){
        String position = JOptionPane.showInputDialog("Enter positon:");
        int choice = JOptionPane.showConfirmDialog(null, "Does this new position come with a salary update?", "", JOptionPane.YES_NO_OPTION);
        rosterEmployees[search].setWorkTitle(position);
        if (choice == JOptionPane.YES_OPTION){
            double salary = Double.parseDouble(JOptionPane.showInputDialog("Enter salary:"));
            rosterEmployees[search].setSalary(salary);
            JOptionPane.showMessageDialog(null, "Position and Salary has been updated!", "Updated Data!", JOptionPane.WARNING_MESSAGE);
        } 
        else {
            JOptionPane.showMessageDialog(null, "Position has been updated!", "Updated Data!", JOptionPane.WARNING_MESSAGE);
        }
    }

    public static void updatePhone(Employee[] rosterEmployees, int search){
        String phone = JOptionPane.showInputDialog("Enter phone number:");
        rosterEmployees[search].setPhoneNumber(phone);
        JOptionPane.showMessageDialog(null, "Phone number has been updated!", "Updated Data!", JOptionPane.WARNING_MESSAGE);
    }

    public static void updateEmployeeTypeData(Employee[] rosterEmployees, int search){
        if (rosterEmployees[search] instanceof Agent){
            String menu = "Update Agent Data:\n\n1. Update Radio Number\n2. Update Assignment Number\n3. Update Rank";
            switch(Integer.parseInt(JOptionPane.showInputDialog(menu))){
                //TEST DOWNCAST --- 
                case 1:
                String radioNum = JOptionPane.showInputDialog("Enter radio number:");
                ((Agent)rosterEmployees[search]).setRadioNum(radioNum);
                break;

                case 2:
                String assignNum = JOptionPane.showInputDialog("Enter assignment number:");
                ((Agent)rosterEmployees[search]).setAssignNum(assignNum);
                break;

                case 3:
                String rank = JOptionPane.showInputDialog("Enter rank:");
                ((Agent)rosterEmployees[search]).setRank(rank);
                break;

                default:
                JOptionPane.showMessageDialog(null, "Please choose a number between 1 and 3!", "Error!", JOptionPane.ERROR_MESSAGE);
            }
        }
        if (rosterEmployees[search] instanceof LabSpecialist){
            String labNum = JOptionPane.showInputDialog("Enter lab number:");
            ((LabSpecialist)rosterEmployees[search]).setLabNum(labNum);
        }
        if (rosterEmployees[search] instanceof ProfessionalStaff){
            String cubicleNum = JOptionPane.showInputDialog("Enter cubicle number:");
            ((ProfessionalStaff)rosterEmployees[search]).setCubicleNum(cubicleNum);
        }
    }

    public static void removeEmployee(Employee[] rosterEmployees){
        if (Employee.getNumEmployees() > 0){
            String id = JOptionPane.showInputDialog("Enter Employee ID you would like to remove:");
            int search = searchEmployeeByID(rosterEmployees, id);
            if (search == -1){
                JOptionPane.showMessageDialog(null, "Employee not found!", "Error!", JOptionPane.ERROR_MESSAGE);
            }
            else{
                for (int i = search; i < Employee.getNumEmployees(); i++){
                    rosterEmployees[i] = rosterEmployees[i+1];
                }
                Employee.updateNumEmployees();
                JOptionPane.showMessageDialog(null, "Employee ID: " + id + " has been deleted!", "Deleted!", JOptionPane.WARNING_MESSAGE);
            }
        }
        else{
            JOptionPane.showMessageDialog(null, "There are no employees!", "Error!", JOptionPane.ERROR_MESSAGE);
        }

    }

    

}