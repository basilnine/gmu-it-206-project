public class ProfessionalStaff extends Employee {
    private String cubicleNum;
    private static int numProfStaff;

    public ProfessionalStaff(String firstName, String lastName, String addressStreet, String addressCity, String addressState, String addressZIP, String phone, String workTitle, double salary, String fieldOffice, String cubicleNum){
        super(firstName, lastName, addressStreet, addressCity, addressState, addressZIP, phone, workTitle, salary, fieldOffice);
        setCubicleNum(cubicleNum);
        numProfStaff++;
    }

    //accessors
    public String getCubicleNum(){
        return cubicleNum;
    }

    public static int getNumProfStaff(){
        return numProfStaff;
    }

    //mutators

    public void setCubicleNum(String cubicleNum){
        //make sure the length is 5 digits
        if(cubicleNum == null || cubicleNum.isEmpty()) {
            throw new IllegalArgumentException("Cubicle Number cannot be empty!");
        } else if(cubicleNum.length() != 5) {
            throw new IllegalArgumentException("Cubicle Number must be 5 digits long!");
        } else if(!cubicleNum.matches("[0-9]+")) {
            throw new IllegalArgumentException("Cubicle Number must be numeric!");
        }
        this.cubicleNum = cubicleNum;
    }

    //special methods
    public String toString(){
        return super.toString() + "Professional Staff";
    }

    public static void updateNumProfStaff(){
        //Subtracts one from number of proffessional staff
        numProfStaff--;
    }
    
}
