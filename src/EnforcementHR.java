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
                    //addEmployee(employeeRoster);
                    break;
                    case 2:
                    //updateEmployee(employeeRoster);
                    break;
                    case 3:
                    //removeEmployee(employeeRoster);
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
                menu += "\n7. Quit";
                int choice = 0;
                try{
                    switch(choice = Integer.parseInt(JOptionPane.showInputDialog(menu))){
                        case 1:
                        //updateName(employeeRoster);
                        break;
                        case 2:
                        //updateAddress(employeeRoster);
                        break;
                        case 3:
                        //updateSalary(employeeRoster);
                        break;
                        case 4:
                        //updatePosition(employeeRoster);
                        break;
                        case 5:
                        //updatePhone(employeeRoster);
                        break;
                        case 6:
                        //updateEmployeeTypeData(employeeRoster);
                        break;
                        case 7:
                        break;
                        default:
                        JOptionPane.showMessageDialog(null, "Please choose a number between 1 and 7!", "Error!", JOptionPane.ERROR_MESSAGE);
                    }
                }catch(Exception e){

                }
            }
        }
        else{
            JOptionPane.showMessageDialog(null, "There are no employees!", "Error!", JOptionPane.ERROR_MESSAGE);
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