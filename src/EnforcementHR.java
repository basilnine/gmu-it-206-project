import javax.swing.*;
public class EnforcementHR {
    public static void main(String[] args){
        //Employee Object Data Stored in employeeRoster array
        Employee[] employeeRoster = new Employee[Employee.getMaxEmployees()];
        employeeRoster[0] = new ProfessionalStaff("Basil", "Ali", "addressStreet", "AddressCity", "VA", "22204", "703-999-9999", "workTitle", 10, "fieldOffice", "00211");
        //Menu is shown and the choice is picked within choiceString, if user presses cancel it will skip switch and shut down the program.
        String menu = "HR Law Enforcement System\n\n1. Add New Employee\n2. Update Employee\n3. Remove Employee\n4. Search Employee\n5. Manage Employee Inventory\n6. Generate Reports\n7. Quit";
        String choiceString = JOptionPane.showInputDialog(null, menu, "HR System", JOptionPane.INFORMATION_MESSAGE);
        int choice = 0;
        //Checks if user presses cancel "cancel button sends null to String"
        if (choiceString != null){
            do{
                try{
                    //Parses choice into an Integer for switch case
                    switch(choice = Integer.parseInt(choiceString)){

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
                //If other choice is made, then will prompt again and check for null send.
                if (choice != 7){
                    choiceString = JOptionPane.showInputDialog(null, menu, "HR System", JOptionPane.INFORMATION_MESSAGE);
                    if (choiceString == null){
                        choice = 7;
                    }
                }
            }while(choice != 7);
        }
        //Sends powering off message and closes the program
        JOptionPane.showMessageDialog(null, "Powering off..");
        System.exit(0);
    }

    public static void addEmployee(Employee[] employeeRoster){
        //Checks if employee object is less than max employee
        if (Employee.getNumEmployees() < Employee.getMaxEmployees()){

            //Creation of three new panels
            JPanel namePanel = new JPanel();
            JPanel addressPanel = new JPanel();
            JPanel workPanel = new JPanel();
            
            //Sets panel layout so that fields are vertical
            namePanel.setLayout(new BoxLayout(namePanel, BoxLayout.Y_AXIS));
            addressPanel.setLayout(new BoxLayout(addressPanel, BoxLayout.Y_AXIS));
            workPanel.setLayout(new BoxLayout(workPanel, BoxLayout.Y_AXIS));
            
            //Name Panel Fields
            JTextField firstNameField = new JTextField(6); //Creates new field (length) | First name
            namePanel.add(new JLabel("First Name:")); //Creates label for field
            namePanel.add(firstNameField); //Adds field to
            JTextField lastNameField = new JTextField(6); //Last Name
            namePanel.add(new JLabel("Last Name:"));
            namePanel.add(lastNameField);
            JTextField phoneField = new JTextField(4); //Phone
            namePanel.add(new JLabel("Phone Number:"));
            namePanel.add(phoneField);

            //Address Panel Fields
            JTextField addressStreetField = new JTextField(8); //Street Address
            addressPanel.add(new JLabel("Street Address:"));
            addressPanel.add(addressStreetField);
            JTextField addressCityField = new JTextField(8); //City Address
            addressPanel.add(new JLabel("City:"));
            addressPanel.add(addressCityField);
            JTextField addressStateField = new JTextField(2); //State Initials
            addressPanel.add(new JLabel("State Initals:"));
            addressPanel.add(addressStateField);
            JTextField addressZIPField = new JTextField(4); //ZIP Address
            addressPanel.add(new JLabel("ZIP Code:"));
            addressPanel.add(addressZIPField);

            //Work Panel Fields
            JTextField fieldOfficeField = new JTextField(6); //Field Office
            workPanel.add(new JLabel("Field Office:"));
            workPanel.add(fieldOfficeField);
            JTextField workTitleField = new JTextField(6); //Position Title
            workPanel.add(new JLabel("Position Title:"));
            workPanel.add(workTitleField);
            JTextField salaryField = new JTextField(6); //Salary
            workPanel.add(new JLabel("Salary:"));
            workPanel.add(salaryField);
            
            //Displays Name Panel
            int resultNamePanel = JOptionPane.showConfirmDialog(null, namePanel, "Add Employee", JOptionPane.OK_CANCEL_OPTION);
            //If User presses OK button, display Address Panel
            String firstName = firstNameField.getText(); //Stores value into variable
            String lastName = lastNameField.getText();
            String phone = phoneField.getText();

            if (resultNamePanel == JOptionPane.OK_OPTION){
                //Display Address Panel
                int resultAddressPanel = JOptionPane.showConfirmDialog(null, addressPanel, "Add Employee", JOptionPane.OK_CANCEL_OPTION);
                String addressStreet = addressStreetField.getText();
                String addressCity = addressCityField.getText();
                String addressState = addressStateField.getText();
                String addressZIP = addressZIPField.getText();

                //If user presses OK button, display Work Type Dialog
                if (resultAddressPanel == JOptionPane.OK_OPTION){
                    String[] options = new String[] {"Agent", "Professional Staff", "Lab Specialist"};
                    int response = JOptionPane.showOptionDialog(null, "Pick Employee Type", "Add Employee", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE,null, options, options[0]);
                    //If user picks Agent, create new fields, display Work Panel
                    if (response == 0){
                        JTextField radioNumField = new JTextField(4);
                        workPanel.add(new JLabel("Radio Number:"));
                        workPanel.add(radioNumField);
                        JTextField assignNumField = new JTextField(4);
                        workPanel.add(new JLabel("Assignment Number:"));
                        workPanel.add(assignNumField);
                        JTextField rankField = new JTextField(5);
                        workPanel.add(new JLabel("Rank:"));
                        workPanel.add(rankField);
                        int resultWorkPanel = JOptionPane.showConfirmDialog(null, workPanel, "Add Employee", JOptionPane.OK_CANCEL_OPTION);
                        
                        String fieldOffice = fieldOfficeField.getText();
                        String workTitle = workTitleField.getText();
                        double salary = Double.parseDouble(salaryField.getText());
                        String radioNum = radioNumField.getText();
                        String assignNum = assignNumField.getText();
                        String rank = rankField.getText();

                        if (resultWorkPanel == JOptionPane.OK_OPTION){
                            employeeRoster[Employee.getNumEmployees()] = new Agent(firstName, lastName, addressStreet, addressCity, addressState, addressZIP, phone, workTitle, salary, fieldOffice, radioNum, assignNum, rank);
                            JOptionPane.showMessageDialog(null, "Employee has been added!", "Add Employee", JOptionPane.INFORMATION_MESSAGE);
                        }
                        else{
                            JOptionPane.showMessageDialog(null, "Add Employee Operation Cancelled!", "Cancelled!", JOptionPane.WARNING_MESSAGE);
                        }
                    }
                    //If user picks Professional Stafff, create new fields, display Work Panel
                    else if (response == 1){
                        JTextField cubicleNumField = new JTextField(4);
                        workPanel.add(new JLabel("Cubical Number:"));
                        workPanel.add(cubicleNumField);
                        int resultWorkPanel = JOptionPane.showConfirmDialog(null, workPanel, "Add Employee", JOptionPane.OK_CANCEL_OPTION);
                        
                        String fieldOffice = fieldOfficeField.getText();
                        String workTitle = workTitleField.getText();
                        double salary = Double.parseDouble(salaryField.getText());
                        String cubicleNum = cubicleNumField.getText();

                        if (resultWorkPanel == JOptionPane.OK_OPTION){
                            employeeRoster[Employee.getNumEmployees()] = new ProfessionalStaff(firstName, lastName, addressStreet, addressCity, addressState, addressZIP, phone, workTitle, salary, fieldOffice, cubicleNum);
                            JOptionPane.showMessageDialog(null, "Employee has been added!", "Add Employee", JOptionPane.INFORMATION_MESSAGE);
                        }
                        else{
                            JOptionPane.showMessageDialog(null, "Add Employee Operation Cancelled!", "Cancelled!", JOptionPane.WARNING_MESSAGE);
                        }
                    }
                    //If user picks Lab Specialist, create new fields, display Work Panel
                    else if (response == 2){
                        JTextField labNumField = new JTextField(4);
                        workPanel.add(new JLabel("Lab Number:"));
                        workPanel.add(labNumField);
                        int resultWorkPanel = JOptionPane.showConfirmDialog(null, workPanel, "Add Employee", JOptionPane.OK_CANCEL_OPTION);
                        
                        String fieldOffice = fieldOfficeField.getText();
                        String workTitle = workTitleField.getText();
                        double salary = Double.parseDouble(salaryField.getText());
                        String labNum = labNumField.getText();

                        if (resultWorkPanel == JOptionPane.OK_OPTION){
                            employeeRoster[Employee.getNumEmployees()] = new LabSpecialist(firstName, lastName, addressStreet, addressCity, addressState, addressZIP, phone, workTitle, salary, fieldOffice, labNum);
                            JOptionPane.showMessageDialog(null, "Employee has been added!", "Add Employee", JOptionPane.INFORMATION_MESSAGE);
                        }
            //All else statements lead to cancel message
                        else{
                            JOptionPane.showMessageDialog(null, "Add Employee Operation Cancelled!", "Cancelled!", JOptionPane.WARNING_MESSAGE);
                        }
                    }
                    else{
                        JOptionPane.showMessageDialog(null, "Add Employee Operation Cancelled!", "Cancelled!", JOptionPane.WARNING_MESSAGE);
                    }
                }
                else{
                    JOptionPane.showMessageDialog(null, "Add Employee Operation Cancelled!", "Cancelled!", JOptionPane.WARNING_MESSAGE);
                }
            }
            else{
                JOptionPane.showMessageDialog(null, "Add Employee Operation Cancelled!", "Cancelled!", JOptionPane.WARNING_MESSAGE);
            }
        }
        else{
            JOptionPane.showMessageDialog(null, "Maximum number of employees met!", "Error!", JOptionPane.ERROR_MESSAGE);
        }
    }

    //All search Employee functions check for match of specific user input, returns index of match if found, or sends -1
    public static int searchEmployeeByID(Employee[] employeeRoster, String id){
        int index = -1;
        for (int i = 0; i < Employee.getNumEmployees(); i++){
            if (id.equalsIgnoreCase(employeeRoster[i].getId())){
                index = i;
                break;
            }
        }
        return index;
    }

    public static int searchEmployeeByName(Employee[] employeeRoster, String name){
        int index = -1;
        for (int i = 0; i < Employee.getNumEmployees(); i++){
            if (name.equalsIgnoreCase(employeeRoster[i].fullNameToString())){
                index = i;
                break;
            }
        }
        return index;
    }

    public static int searchEmployeeByPhone(Employee[] employeeRoster, String phone){
        int index = -1;
        for (int i = 0; i < Employee.getNumEmployees(); i++){
            if (phone.equalsIgnoreCase(employeeRoster[i].getPhoneNumber())){
                index = i;
                break;
            }
        }
        return index;
    }

    public static int searchEmployeeByEmail(Employee[] employeeRoster, String email){
        int index = -1;
        for (int i = 0; i < Employee.getNumEmployees(); i++){
            if (email.equalsIgnoreCase(employeeRoster[i].getWorkEmail())){
                index = i;
                break;
            }
        }
        return index;
    }

    public static void updateEmployee(Employee[] employeeRoster){
        //Checks if any employee objects have been created
        if (Employee.getNumEmployees() > 0){
            //Ask for employee ID, if null then update operation is cancelled
            String id = JOptionPane.showInputDialog("Enter Employee ID:");
            if (id == null){
                JOptionPane.showMessageDialog(null, "Update Employee Operation Cancelled!", "Cancelled!", JOptionPane.WARNING_MESSAGE);
            }
            //If not null, then searches for employee by ID, if search index is -1, will send an error, else it will provide switch menu to update employee
            else{
                int search = searchEmployeeByID(employeeRoster, id);
                if (search == -1){
                    JOptionPane.showMessageDialog(null, "Employee not found!", "Error!", JOptionPane.ERROR_MESSAGE);
                }
                else{
                    //Adds specific options based on employee type
                    String menu = "** Update Employee Data **\nID: " + employeeRoster[search].getId() + " [" + employeeRoster[search].fullNameToString() + "]\n";
                    menu += "1. Update Name\n2. Update Address\n3. Update Salary\n4. Update Position\n5. Update Phone Number\n6. Update Status";
                    if (employeeRoster[search] instanceof Agent){
                        menu += "\n7. Update Agent Data";
                    }
                    if (employeeRoster[search] instanceof ProfessionalStaff){
                        menu += "\n7. Update Professional Staff Data";
                    }
                    if (employeeRoster[search] instanceof LabSpecialist){
                        menu += "\n7. Update Lab Specialist Data";
                    }
                    menu += "\n8. Exit";
                    String choiceString = JOptionPane.showInputDialog(null, menu, "Update Employee", JOptionPane.INFORMATION_MESSAGE);
                    int choice = 0;
                    if (choiceString != null){
                        do{
                            try{
                                switch(choice = Integer.parseInt(choiceString)){
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
                                    updateStatus(employeeRoster, search);
                                    break;

                                    case 7:
                                    updateEmployeeTypeData(employeeRoster, search);
                                    break;

                                    case 8:
                                    break;

                                    default:
                                    JOptionPane.showMessageDialog(null, "Please choose a number between 1 and 7!", "Error!", JOptionPane.ERROR_MESSAGE);
                                    break;
                                }
                            }catch(Exception e){
                                JOptionPane.showMessageDialog(null, e.getMessage(), "Error!", JOptionPane.ERROR_MESSAGE);
                            }
                            if (choice != 8){
                                choiceString = JOptionPane.showInputDialog(null, menu, "Update Employee", JOptionPane.INFORMATION_MESSAGE);
                                if (choiceString == null){
                                    choice = 8;
                                }
                            }
                        }while(choice != 8);
                    }
                }
            }
        }
        else{
            JOptionPane.showMessageDialog(null, "There are no employees!", "Error!", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void updateName(Employee[] employeeRoster, int search){
        JPanel namePanel = new JPanel(); //Create new Panel
        namePanel.setLayout(new BoxLayout(namePanel, BoxLayout.Y_AXIS)); //Sets layout for panel

        JTextField firstNameField = new JTextField(8); //Creates First Name Field
        namePanel.add(new JLabel("First Name:")); //Adds label for First Name Field
        namePanel.add(firstNameField); //Adds First Name Field to Panel 
        JTextField lastNameField = new JTextField(8); //Last Name Field
        namePanel.add(new JLabel("Last Name:")); 
        namePanel.add(lastNameField);

        int resultNamePanel = JOptionPane.showConfirmDialog(null, namePanel, "Update Employee", JOptionPane.OK_CANCEL_OPTION);
        
        if (resultNamePanel == JOptionPane.OK_OPTION){
            employeeRoster[search].setFirstName(firstNameField.getText());
            employeeRoster[search].setLastName(lastNameField.getText());
            JOptionPane.showMessageDialog(null, "Name has been updated!", "Employee Updated!", JOptionPane.INFORMATION_MESSAGE);
        }
        else{
            JOptionPane.showMessageDialog(null, "Update Employee Operation Cancelled!", "Cancelled!", JOptionPane.WARNING_MESSAGE);
        }
    }

    public static void updateAddress(Employee[] employeeRoster, int search){

        JPanel addressPanel = new JPanel(); //Creates Address Panel
        addressPanel.setLayout(new BoxLayout(addressPanel, BoxLayout.Y_AXIS)); //Sets layout for panel

        JTextField addressStreetField = new JTextField(10); //Street Address Field
        addressPanel.add(new JLabel("Street Address:"));
        addressPanel.add(addressStreetField);
        JTextField addressCityField = new JTextField(10); //City Field
        addressPanel.add(new JLabel("City:"));
        addressPanel.add(addressCityField);
        JTextField addressStateField = new JTextField(10); //State Field
        addressPanel.add(new JLabel("State Initials:"));
        addressPanel.add(addressStateField);
        JTextField addressZIPField = new JTextField(10); //ZIP Code Field
        addressPanel.add(new JLabel("ZIP Code:"));
        addressPanel.add(addressZIPField);

        //Display Address Panel
        int resultAddressPanel = JOptionPane.showConfirmDialog(null, addressPanel, "Update Employee", JOptionPane.OK_CANCEL_OPTION);

        //Updates Data if user presses OK
        if (resultAddressPanel == JOptionPane.OK_OPTION){
            employeeRoster[search].setAddressStreet(addressStreetField.getText());
            employeeRoster[search].setAddressCity(addressCityField.getText());
            employeeRoster[search].setAddressState(addressStateField.getText());
            employeeRoster[search].setAddressZip(addressZIPField.getText());
            //Sends confirm message when successful
            JOptionPane.showMessageDialog(null, "Address has been updated!", "Updated Employee!", JOptionPane.INFORMATION_MESSAGE);
        }
        //Sends confirm message when cancelled
        else{
            JOptionPane.showMessageDialog(null, "Update Employee Operation Cancelled!", "Cancelled!", JOptionPane.WARNING_MESSAGE);
        }
    }

    public static void updateSalary(Employee[] employeeRoster, int search){
        JPanel salaryPanel = new JPanel(); //Salary Panel

        JTextField salaryField = new JTextField(6); //Salary Field
        salaryPanel.add(new JLabel("Enter new salary:"));
        salaryPanel.add(salaryField);

        int resultSalaryPanel = JOptionPane.showConfirmDialog(null, salaryPanel, "Update Employee", JOptionPane.OK_CANCEL_OPTION);

        if (resultSalaryPanel == JOptionPane.OK_OPTION){
            employeeRoster[search].setSalary(Double.parseDouble(salaryField.getText()));
            JOptionPane.showMessageDialog(null, "Salary has been updated!", "Updated Employee!", JOptionPane.INFORMATION_MESSAGE);
        }
        else{
            JOptionPane.showMessageDialog(null, "Update Employee Operation Cancelled!", "Cancelled!", JOptionPane.WARNING_MESSAGE);
        }
    }

    public static void updatePosition(Employee[] employeeRoster, int search){
        JPanel positionPanel = new JPanel(); //Position Panel

        JTextField positionField = new JTextField(6); //Position Field
        positionPanel.add(new JLabel("Position:"));
        positionPanel.add(positionField);

        //Asks user if employee position update comes with a salary change?
        int salaryConfirm = JOptionPane.showConfirmDialog(null, "Does this position come with a salary change?", "Update Employee", JOptionPane.YES_NO_CANCEL_OPTION);

        //If yes, include salary field in Position Panel and ask user for phone position and salary
        if (salaryConfirm == JOptionPane.YES_OPTION){
            positionPanel.setLayout(new BoxLayout(positionPanel, BoxLayout.Y_AXIS)); //Sets layout for panel
            JTextField salaryField = new JTextField(6); //Salary Field
            positionPanel.add(new JLabel("Salary:"));
            positionPanel.add(salaryField);
            int resultPositionPanel = JOptionPane.showConfirmDialog(null, positionPanel, "Update Employee", JOptionPane.OK_CANCEL_OPTION);
            
            //Once pressed okay, sends data from position and salary fields into employee object
            if (resultPositionPanel == JOptionPane.OK_OPTION){
                employeeRoster[search].setWorkTitle(positionField.getText());
                employeeRoster[search].setSalary(Double.parseDouble(salaryField.getText()));
                JOptionPane.showMessageDialog(null, "Position and Salary has been updated!", "Updated Employee!", JOptionPane.INFORMATION_MESSAGE);
            }
            //Cancel message if pressed cancel
            else{
                JOptionPane.showMessageDialog(null, "Update Employee Operation Cancelled!", "Cancelled!", JOptionPane.WARNING_MESSAGE);
            }
        }
        //If says no, then asks for employee position
        else if (salaryConfirm == JOptionPane.NO_OPTION){
            int resultPositionPanel = JOptionPane.showConfirmDialog(null, positionPanel, "Update Employee", JOptionPane.OK_CANCEL_OPTION);

            //Once pressed okay, sends data from position field into employee object
            if (resultPositionPanel == JOptionPane.OK_OPTION){
                employeeRoster[search].setWorkTitle(positionField.getText());
                JOptionPane.showMessageDialog(null, "Position has been updated!", "Updated Employee!", JOptionPane.INFORMATION_MESSAGE);
            }
            //Cancel message if pressed cancel
            else{
                JOptionPane.showMessageDialog(null, "Update Employee Operation Cancelled!", "Cancelled!", JOptionPane.WARNING_MESSAGE);
            }
        }
        //Cancel message if pressed cancel
        else{
            JOptionPane.showMessageDialog(null, "Update Employee Operation Cancelled!", "Cancelled!", JOptionPane.WARNING_MESSAGE);
        }
    }

    public static void updatePhone(Employee[] employeeRoster, int search){
        JPanel phonePanel = new JPanel(); //Phone Panel

        JTextField phoneField = new JTextField(6); //Phone Field
        phonePanel.add(new JLabel("Phone Number:"));
        phonePanel.add(phoneField);

        int resultPhonePanel = JOptionPane.showConfirmDialog(null, phonePanel, "Update Employee", JOptionPane.OK_CANCEL_OPTION);
        
        //Once pressed okay, sends data from phone field into employee object
        if (resultPhonePanel == JOptionPane.OK_OPTION){
            employeeRoster[search].setPhoneNumber(phoneField.getText());
            JOptionPane.showMessageDialog(null, "Phone number has been updated!", "Updated Employee!", JOptionPane.INFORMATION_MESSAGE);
        }
        else{
            JOptionPane.showMessageDialog(null, "Update Employee Operation Cancelled!", "Cancelled!", JOptionPane.WARNING_MESSAGE);
        }
    }

    public static void updateStatus(Employee[] employeeRoster, int search){
        String menu = "Current employee status: ";
        if (employeeRoster[search].getIsActive() == true){
            menu += "Active\nWoud you like to change it to Inactive?";
        }
        else if (employeeRoster[search].getIsActive() == false){
            menu += "Inactive\nWould you like to change it to Active?";
        }
        int choiceStatus = JOptionPane.showConfirmDialog(null, menu, "Update Employee", JOptionPane.YES_NO_OPTION);
        if (choiceStatus == JOptionPane.YES_OPTION){
            if (employeeRoster[search].getIsActive() == true){
                employeeRoster[search].setIsActive(false);
            }
            else if (employeeRoster[search].getIsActive() == false){
                employeeRoster[search].setIsActive(true);
            }
        }
        else{
            JOptionPane.showMessageDialog(null, "Update Employee Operation Cancelled!", "Cancelled!", JOptionPane.WARNING_MESSAGE);
        }
    }

    public static void updateEmployeeTypeData(Employee[] employeeRoster, int search){
        //Agent Employee Type Update Options
        if (employeeRoster[search] instanceof Agent){
            String menu = "Update Agent Data:\n\n1. Update Radio Number\n2. Update Assignment Number\n3. Update Rank\n4. Exit";
            String choiceString = JOptionPane.showInputDialog(null, menu, "Update Employee", JOptionPane.INFORMATION_MESSAGE);
            int choice = 0;
            if (choiceString != null){
                do{
                    switch(choice = Integer.parseInt(choiceString)){
                        case 1: //Update radio number
                        JPanel radioPanel = new JPanel(); //Radio Number Panel
                
                        JTextField radioField = new JTextField(6); //Radio Number Field
                        radioPanel.add(new JLabel("Radio Number:"));
                        radioPanel.add(radioField);
                
                        int resultRadioPanel = JOptionPane.showConfirmDialog(null, radioPanel, "Update Employee", JOptionPane.OK_CANCEL_OPTION);
                        
                        //Once pressed okay, sends data from radio number field into employee object
                        if (resultRadioPanel == JOptionPane.OK_OPTION){
                            ((Agent)employeeRoster[search]).setRadioNum(radioField.getText());
                            JOptionPane.showMessageDialog(null, "Radio number has been updated!", "Updated Employee!", JOptionPane.INFORMATION_MESSAGE);
                        }
                        else{
                            JOptionPane.showMessageDialog(null, "Update Employee Operation Cancelled!", "Cancelled!", JOptionPane.WARNING_MESSAGE);
                        }
                        break;

                        case 2:
                        JPanel assignPanel = new JPanel(); //Assignment Number Panel
                
                        JTextField assignField = new JTextField(6); //Assignment Number Field
                        assignPanel.add(new JLabel("Assignment Number:"));
                        assignPanel.add(assignField);
                
                        int resultAssignPanel = JOptionPane.showConfirmDialog(null, assignPanel, "Update Employee", JOptionPane.OK_CANCEL_OPTION);
                        
                        //Once pressed okay, sends data from assignment field into employee object
                        if (resultAssignPanel == JOptionPane.OK_OPTION){
                            ((Agent)employeeRoster[search]).setAssignNum(assignField.getText());
                            JOptionPane.showMessageDialog(null, "Assignment number has been updated!", "Updated Employee!", JOptionPane.INFORMATION_MESSAGE);
                        }
                        else{
                            JOptionPane.showMessageDialog(null, "Update Employee Operation Cancelled!", "Cancelled!", JOptionPane.WARNING_MESSAGE);
                        }
                        break;

                        case 3:
                        JPanel rankPanel = new JPanel(); //Rank Panel
                
                        JTextField rankField = new JTextField(6); //Rank Field
                        rankPanel.add(new JLabel("Rank:"));
                        rankPanel.add(rankField);
                
                        int resultRankPanel = JOptionPane.showConfirmDialog(null, rankPanel, "Update Employee", JOptionPane.OK_CANCEL_OPTION);
                        
                        //Once pressed okay, sends data from rank field into employee object
                        if (resultRankPanel == JOptionPane.OK_OPTION){
                            ((Agent)employeeRoster[search]).setRank(rankField.getText());
                            JOptionPane.showMessageDialog(null, "Rank has been updated!", "Updated Employee!", JOptionPane.INFORMATION_MESSAGE);
                        }
                        else{
                            JOptionPane.showMessageDialog(null, "Update Employee Operation Cancelled!", "Cancelled!", JOptionPane.WARNING_MESSAGE);
                        }
                        break;

                        case 4:
                        break;

                        default:
                        JOptionPane.showMessageDialog(null, "Please choose a number between 1 and 4!", "Error!", JOptionPane.ERROR_MESSAGE);
                        break;
                    }
                    if (choice != 4){
                        choiceString = JOptionPane.showInputDialog(null, menu, "Update Employee", JOptionPane.INFORMATION_MESSAGE);
                        if (choiceString == null){
                            choice = 4;
                        }
                    }
                }while(choice != 4);
            }
        }

        if (employeeRoster[search] instanceof LabSpecialist){
            JPanel labPanel = new JPanel(); //Lab number Panel
        
            JTextField labField = new JTextField(6); //Lab number Field
            labPanel.add(new JLabel("Lab Number:"));
            labPanel.add(labField);
        
            int resultLabPanel = JOptionPane.showConfirmDialog(null, labPanel, "Update Employee", JOptionPane.OK_CANCEL_OPTION);                
            //Once pressed okay, sends data from lab number field into employee object
            if (resultLabPanel == JOptionPane.OK_OPTION){
                ((LabSpecialist)employeeRoster[search]).setLabNum(labField.getText());
                JOptionPane.showMessageDialog(null, "Lab number has been updated!", "Updated Employee!", JOptionPane.INFORMATION_MESSAGE);
            }
            else{
                JOptionPane.showMessageDialog(null, "Update Employee Operation Cancelled!", "Cancelled!", JOptionPane.WARNING_MESSAGE);
            }
        }

        if (employeeRoster[search] instanceof ProfessionalStaff){
            JPanel cubiclePanel = new JPanel(); //Cubicle number Panel
        
            JTextField cubicleField = new JTextField(6); //Cubicle number Field
            cubiclePanel.add(new JLabel("Cubicle Number:"));
            cubiclePanel.add(cubicleField);
        
            int resultCubiclePanel = JOptionPane.showConfirmDialog(null, cubiclePanel, "Update Employee", JOptionPane.OK_CANCEL_OPTION);                
            //Once pressed okay, sends data from cubicle field into employee object
            if (resultCubiclePanel == JOptionPane.OK_OPTION){
                ((ProfessionalStaff)employeeRoster[search]).setCubicleNum(cubicleField.getText());
                JOptionPane.showMessageDialog(null, "Cubicle number has been updated!", "Updated Employee!", JOptionPane.INFORMATION_MESSAGE);
            }
            else{
                JOptionPane.showMessageDialog(null, "Update Employee Operation Cancelled!", "Cancelled!", JOptionPane.WARNING_MESSAGE);
            }
        }
    }

    public static void removeEmployee(Employee[] employeeRoster){
        //Checks if any employee objects have been created, if so then continue, if not send error message
        if (Employee.getNumEmployees() > 0){
            //Enter employee ID to search
            String id = JOptionPane.showInputDialog(null, "Enter Employee ID:", "Remove Employee", JOptionPane.INFORMATION_MESSAGE);
            if (id != null){
                //Searches employee by ID, if not found sends error message, if found continues
                int search = searchEmployeeByID(employeeRoster, id);
                if (search == -1){
                    JOptionPane.showMessageDialog(null, "Employee not found!", "Error!", JOptionPane.ERROR_MESSAGE);
                }
                else{
                    //Grabs ID and store it in a string, then prompts confirmation message either to delete or not
                    String idDelete = employeeRoster[search].getId();
                    int deleteConfirm = JOptionPane.showConfirmDialog(null, "Are you sure you want to delete?\nID: " + idDelete + " [" + employeeRoster[search].fullNameToString(), "] Remove Employee", JOptionPane.YES_NO_OPTION);

                    //If yes, updates nessecary trackers and deletes objecy by overwriting data in array and sends confirmation message
                    if (deleteConfirm == JOptionPane.YES_OPTION){
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
                        JOptionPane.showMessageDialog(null, "Employee ID: " + idDelete + " has been deleted!", "Deleted!", JOptionPane.INFORMATION_MESSAGE);
                    }
        //If cancel or no has been done, then will send a message that the operation is cancelled
                    else{
                        JOptionPane.showMessageDialog(null, "Remove Employee Operation Cancelled!", "Cancelled!", JOptionPane.WARNING_MESSAGE);
                    }
                }
            }
            else{
                JOptionPane.showMessageDialog(null, "Remove Employee Operation Cancelled!", "Cancelled!", JOptionPane.WARNING_MESSAGE);
            }
        }
        //Sends error message if no employees
        else{
            JOptionPane.showMessageDialog(null, "There are no employees!", "Error!", JOptionPane.ERROR_MESSAGE);
        }

    }

    public static void printEmployeeReport(Employee[] employeeRoster, int i){
        //Checks if employee exists
        if (i >= 0){
            //Sets up report for employee
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
        //Checks if an employee object has been made
        if (Employee.getNumEmployees() > 0){
            int index = -1;
            //Gives switch menu options to search by type
            String menu = "** Search Employee **\n\n1. Search by ID\n2. Search by Name\n3. Search by Phone\n4. Search by Email\n5. Exit";
            String choiceString = JOptionPane.showInputDialog(null, menu, "Search Employee", JOptionPane.INFORMATION_MESSAGE);
            int choice = 0;
            if (choiceString != null){
                do{
                    try{
                        switch(choice = Integer.parseInt(choiceString)){
                            case 1:
                            String id = JOptionPane.showInputDialog(null, "Enter ID:", "Search Employee", JOptionPane.INFORMATION_MESSAGE);
                            if (id != null){
                                index = searchEmployeeByID(employeeRoster, id);
                                printEmployeeReport(employeeRoster, index);
                            }
                            break;

                            case 2:
                            String name = JOptionPane.showInputDialog(null, "Enter Full Name:", "Search Employee", JOptionPane.INFORMATION_MESSAGE);
                            if (name != null){
                                index = searchEmployeeByName(employeeRoster, name);
                                printEmployeeReport(employeeRoster, index);
                            }
                            break;

                            case 3:
                            String phone = JOptionPane.showInputDialog(null, "Enter Phone Number:", "Search Employee", JOptionPane.INFORMATION_MESSAGE);
                            if (phone != null){
                                index = searchEmployeeByPhone(employeeRoster, phone);
                                printEmployeeReport(employeeRoster, index);
                            }
                            break;

                            case 4:
                            String email = JOptionPane.showInputDialog(null, "Enter Email:", "Search Employee", JOptionPane.INFORMATION_MESSAGE);
                            if (email != null){
                                index = searchEmployeeByEmail(employeeRoster, email);
                                printEmployeeReport(employeeRoster, index);
                            }
                            break;

                            case 5:
                            break;

                            default:
                            JOptionPane.showMessageDialog(null, "Please choose a number between 1 and 5!", "Error!", JOptionPane.ERROR_MESSAGE);
                            break;
                            }
                        if (choice != 5){
                            choiceString = JOptionPane.showInputDialog(null, menu, "Search Employee", JOptionPane.INFORMATION_MESSAGE);
                            if (choiceString == null){
                                choice = 5;
                            }
                        }
                    }catch(Exception e){
                        JOptionPane.showMessageDialog(null, e.getMessage(), "Error!", JOptionPane.ERROR_MESSAGE);
                    }
                }while(choice != 5);    
            }
        }
        else{
            JOptionPane.showMessageDialog(null, "There are no employees!", "Error!", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void manageInventory(Employee[] employeeRoster){
        if (Employee.getNumEmployees() > 0){
            //Inventory Management switch options located here
            String menu = "** Inventory Management **\n\n1. Assign an Inventory Item\n2. Return an Inventory Item\n3. Employee Inventory Audit\n4. Exit";
            String choiceString = JOptionPane.showInputDialog(null, menu, "Inventory Management", JOptionPane.INFORMATION_MESSAGE);
            int choice = 0;
            do{
                if (choiceString != null){
                    try{
                        switch(choice = Integer.parseInt(choiceString)){
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
                        if (choice != 4){
                            choiceString = JOptionPane.showInputDialog(null, menu, "Inventory Management", JOptionPane.INFORMATION_MESSAGE);
                            if (choiceString == null){
                                choice = 4;
                            }
                        }
                    }catch(Exception e){
                        JOptionPane.showMessageDialog(null, e.getMessage(), "Error!", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }while(choice != 4);
        }
        else{
            JOptionPane.showMessageDialog(null, "There are no employees!", "Error!", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void assignInventoryItem(Employee[] employeeRoster){
        //Askes for employee ID, checks if exists, then gives options to assign
        String id = JOptionPane.showInputDialog(null, "Enter Employee ID:", "Inventory Management", JOptionPane.INFORMATION_MESSAGE);
        if (id != null){
            try{
                int searchIndex = searchEmployeeByID(employeeRoster, id);
                if (searchIndex >= 0){
                    if (employeeRoster[searchIndex].getNumInventoryItem() < Employee.getMaxInventoryItems()){
                        String[] options = new String[] {"Laptop", "Cell Phone", "Patrol Car"};
                        int itemType = JOptionPane.showOptionDialog(null, "What item would you like to assign " + employeeRoster[searchIndex].fullNameToString() + "?", "Title", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE,null, options, options[0]);
                        //Checks employee's inventory, if item has been assigned then adds to employee's inventory array, if not send error message
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
    }

    public static void returnInventoryItem(Employee[] employeeRoster){
        String id = JOptionPane.showInputDialog(null, "Enter Employee ID:", "Inventory Management", JOptionPane.INFORMATION_MESSAGE);
        if (id != null){
            try{
                int searchIndex = searchEmployeeByID(employeeRoster, id);
                if (searchIndex >= 0){
                    //Checks if employee has items in its inventory, then checks what they have and puts them as options
                    if (employeeRoster[searchIndex].getNumInventoryItem() > 0){
                        String[] options = new String[(employeeRoster[searchIndex].getNumInventoryItem()+1)];
                        int optionNum = 0;
                        for (int i = 0; i < employeeRoster[searchIndex].getNumInventoryItem(); i++){
                            if (employeeRoster[searchIndex].getInventoryType(i) == 0){
                                options[i] = "Laptop";
                                optionNum++;
                            }
                            if (employeeRoster[searchIndex].getInventoryType(i) == 1){
                                options[i] = "Phone";
                                optionNum++;
                            }
                            if (employeeRoster[searchIndex].getInventoryType(i) == 2){
                                options[i] = "Patrol Car";
                                optionNum++;
                            }
                        }
                        options[(optionNum)] = "Cancel";
                        //If an item has been picked, it will send itemType based on option
                        int choice = JOptionPane.showOptionDialog(null, "What item would you like " + employeeRoster[searchIndex].fullNameToString() + " to return?", "Title", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE,null, options, options[0]);
                        int itemType = -1;
                        if (options[choice].equals("Laptop")){
                            itemType = 0;
                            int inventorySearchIndex = employeeRoster[searchIndex].searchInventoryItem(itemType);
                            employeeRoster[searchIndex].removeInventoryItem(inventorySearchIndex);
                            JOptionPane.showMessageDialog(null, "Item has been successfully returned to Inventory!", "Success!", JOptionPane.INFORMATION_MESSAGE);
                 
                        }
                        else if (options[choice].equals("Phone")){
                            itemType = 1;
                            int inventorySearchIndex = employeeRoster[searchIndex].searchInventoryItem(itemType);
                            employeeRoster[searchIndex].removeInventoryItem(inventorySearchIndex);
                            JOptionPane.showMessageDialog(null, "Item has been successfully returned to Inventory!", "Success!", JOptionPane.INFORMATION_MESSAGE);
                 
                        }
                        else if (options[choice].equals("Patrol Car")){
                            itemType = 2;
                            int inventorySearchIndex = employeeRoster[searchIndex].searchInventoryItem(itemType);
                            employeeRoster[searchIndex].removeInventoryItem(inventorySearchIndex);
                            JOptionPane.showMessageDialog(null, "Item has been successfully returned to Inventory!", "Success!", JOptionPane.INFORMATION_MESSAGE);
                 
                        }
                        else{
                            JOptionPane.showMessageDialog(null, "Item Operation has been cancelled!", "Cancelled!", JOptionPane.WARNING_MESSAGE);
                        }
                        //Removes by overwriting Inventory array in Employee and sends confirmation message
                        /*
                        int inventorySearchIndex = employeeRoster[searchIndex].searchInventoryItem(itemType);
                        employeeRoster[searchIndex].removeInventoryItem(inventorySearchIndex);
                        JOptionPane.showMessageDialog(null, "Item has been successfully returned to Inventory!", "Success!", JOptionPane.INFORMATION_MESSAGE);
                    */
                    }
            //All errors located under here:
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
    }

    public static void auditInventoryItem(Employee[] employeeRoster){
        //Prompts for employee ID
        String id = JOptionPane.showInputDialog(null, "Enter Employee ID:", "Inventory Management", JOptionPane.INFORMATION_MESSAGE);
        if (id != null){
            try{
                //search employee ID, if found then will provide a report by checking Inventory array within Employee object
                int searchIndex = searchEmployeeByID(employeeRoster, id);
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
    }

    public static void generateReports(Employee[] employeeRoster){
        //Checks if employee objects have been made, provides a switch for two different reports
        if (Employee.getNumEmployees() > 0){
            String menu = "** Generate Reports **\n\n1. Organization Report\n2. Inventory Report\n3. Exit";
            String choiceString = JOptionPane.showInputDialog(null, menu, "Report Generator", JOptionPane.INFORMATION_MESSAGE);
            int choice = 0;
            do{
                if (choiceString != null){
                    try{
                        switch(choice = Integer.parseInt(choiceString)){
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
                        if (choice != 3){
                            choiceString = JOptionPane.showInputDialog(null, menu, "Report Generator", JOptionPane.INFORMATION_MESSAGE);
                            if (choiceString == null){
                                choice = 3;
                            }
                        }
        //Error messages here:
                    }catch(Exception e){
                        JOptionPane.showMessageDialog(null, e.getMessage(), "Error!", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }while(choice !=3);
        }
        else{
            JOptionPane.showMessageDialog(null, "There are no employees!", "Error!", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public static void generateOrgReport(Employee[] employeeRoster){
        //Generates two dialogs, one for stats on employees, the second a list of active employees
        String report1 = "** Employee Stats **\n\nNumber of Employees: " + Employee.getNumEmployees() +
        "\nNumber of Agents: " + Agent.getNumAgents() + "\nNumber of Lab Specialists: " + LabSpecialist.getNumLabSpecialists() +
        "\nNumber of Professional Specialists: " + ProfessionalStaff.getNumProfStaff();
        String report2 = "** Active Employee List **\n\n";
        double salary = 0;
        for (int i = 0; i < Employee.getNumEmployees(); i++){
            if (employeeRoster[i].getIsActive() == true){
                report2 += employeeRoster[i].toString() + "\n";
                salary += employeeRoster[i].getSalary();
            }
        }
        report1 += "\n\nTotal Employee Budget: " + String.format("$%.2f", salary);
        JOptionPane.showMessageDialog(null, report1, "Organization Report", JOptionPane.INFORMATION_MESSAGE);
        JOptionPane.showMessageDialog(null, report2, "Organization Report", JOptionPane.INFORMATION_MESSAGE);
    }

    public static void generateInventoryReport(Employee[] employeeRoster){
        //Generates organization stats of inventory used, then sends list of employees and their inventory if applicable
        if (InventoryItem.numLaptopsUsed() == 0 && InventoryItem.numPhonesUsed() == 0 && InventoryItem.numPatrolCarsUsed() == 0){
            JOptionPane.showMessageDialog(null, "No inventory items have been assigned to any employee!", "Error!", JOptionPane.ERROR_MESSAGE);
        }
        else{
            String report1 = "** Inventory Stats **\n\n";
            report1 += InventoryItem.numLaptopsUsed() + " out of " + InventoryItem.getMaxLaptops() + " laptops have been used.\n" +
            InventoryItem.numPhonesUsed() + " out of " + InventoryItem.getMaxPhones() + " phones have been used.\n" +
            InventoryItem.numPatrolCarsUsed() + " out of " + InventoryItem.getMaxPatrolCars() + " patrol cars have been used.";
            String report2 = "** Inventory List **\n";
            int report2Count = 0;
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
                        report2Count++;
                    }
                }
            }
            JOptionPane.showMessageDialog(null, report1, "Inventory Report", JOptionPane.INFORMATION_MESSAGE);
            if (report2Count > 0){
                JOptionPane.showMessageDialog(null, report2, "Inventory Report", JOptionPane.INFORMATION_MESSAGE);
            }
        }
    }

}