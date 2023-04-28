public class LabSpecialist extends Employee {
    private String labNum;
    private static int numLabSpecialists;

    public LabSpecialist(String firstName, String lastName, String addressStreet, String addressCity, String addressState, String addressZIP, String phone, String workTitle, double salary, String fieldOffice, String labNum){
        super(firstName, lastName, addressStreet, addressCity, addressState, addressZIP, phone, workTitle, salary, fieldOffice);
        setLabNum(labNum);
        numLabSpecialists++;
    }

    //accessors
    public String getLabNum(){
        return labNum;
    }

    public static int getNumLabSpecialists(){
        return numLabSpecialists;
    }

    //mutators
    public void setLabNum(String labNum){
        //make sure the length is 5 digits
        if(labNum == null || labNum.isEmpty()) {
            throw new IllegalArgumentException("Lab Number cannot be empty!");
        } else if(labNum.length() != 5) {
            throw new IllegalArgumentException("Lab Number must be 5 digits long!");
        } else if(!labNum.matches("[0-9]+")) {
            throw new IllegalArgumentException("Lab Number must be numeric!");
        }
        this.labNum = labNum;
    }

    public String toString(){
        return super.toString() + "Lab Specialist";
    }

    public void updateLabNum(){
        //Subtracts one from number of lab specialists and Employees
        numLabSpecialists--;
    }
    
}
