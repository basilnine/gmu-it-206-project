public class InventoryItem {
    public String empID;
    public int type;
    public static int numLaptops;
    public static int numPhones;
    public static int numPatrolCars;

    public InventoryItem(String empID, int type){
        setEmpID(empID);
        setType(type);
        if(type == 1){
            numLaptops++;
        } else if(type == 2){
            numPhones++;
        } else if(type == 3){
            numPatrolCars++;
        }
    }

    //accessors
    public String getEmpID(){
        return empID;
    }

    public int getType(){
        return type;
    }

    public static int getNumLaptops(){
        return numLaptops;
    }

    public static int getNumPhones(){
        return numPhones;
    }

    public static int getNumPatrolCars(){
        return numPatrolCars;
    }

    //mutators
    public void setEmpID(String empID){
        //make sure the length is 5 digits
        if(empID.length() != 5) {
            throw new IllegalArgumentException("Employee ID must be 5 digits long!");
        } else if(!empID.matches("[0-9]+")) {
            throw new IllegalArgumentException("Employee ID must be numeric!");
        }
        this.empID = empID;
    }

    public void setType(int type){
        //make sure the type is 1, 2, or 3
        if(type < 1 || type > 3){
            throw new IllegalArgumentException("Type must be 1, 2, or 3!");
        }
        this.type = type;
    }

    //special methods
    public String toString(){
        return "Inventory Item";
    }

    public void updateNumLaptops(){
        //Subtracts one from number of laptops
        numLaptops--;
    }

    public void updateNumPhones(){
        //Subtracts one from number of phones
        numPhones--;
    }

    public void updateNumPatrolCars(){
        //Subtracts one from number of patrol cars
        numPatrolCars--;
    }

    
}
