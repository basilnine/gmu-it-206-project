import javax.swing.JOptionPane;
public class EnforcementHR {

    public static void main(String[] args){
        Employee[] employeeRoster = new Employee[Employee.getMAX_EMPLOYEE()];
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
                    JOptionPane.showMessageDialog(null, "Please choose a number between 1 and 6!", "Error!", JOptionPane.ERROR_MESSAGE);
                }
            }catch(Exception e){
                JOptionPane.showMessageDialog(null, e.getMessage(), "Error!", JOptionPane.ERROR_MESSAGE);
            }
        }while(choice != 7);
        JOptionPane.showMessageDialog(null, "Powering off..");
        System.exit(0);
    }

    public static void addEmployee(Employee[] employeeRoster){
        if (Employee.getNumEmployees <= Employee.getMAX_EMPLOYEE()){

        }
    }
    
}
