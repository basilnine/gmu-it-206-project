public class InventoryItem {
    private String empID;
    private int type;

    private final static int MAX_LAPTOPS = 50;
    private final static int MAX_PHONES = 50;
    
    private final static int MAX_PATROLCARS = 50;

    private static int numLaptops = MAX_LAPTOPS;
    private static int numPhones = MAX_PHONES;
    private static int numPatrolCars = MAX_PATROLCARS;

    public InventoryItem(String empID, int type){
        
        setEmpID(empID);
        setType(type);
       
        if (type == 0){
            numLaptops--;
        } 
        if (type == 1){
            numPhones--;
        } 
        if( type == 2){
            numPatrolCars--;
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
    
    public static int getMaxLaptops(){
        return MAX_LAPTOPS;
    }

    public static int getMaxPhones(){
        return MAX_PHONES;
    }

    public static int getMaxPatrolCars(){
        return MAX_PATROLCARS;
    }

    //mutators
    public void setEmpID(String empID){
        this.empID = empID;
    }

    public void setType(int type){
        
        //Checks if any of the items have hit the maximum amount of items assigned
        if (type == 0){
            if (numLaptops <= 0){
                throw new IllegalArgumentException("Maximum amount of laptops have been assigned!");
            }
        }
        if (type == 1){
            if (numPhones <= 0){
                throw new IllegalArgumentException("Maximum amount of phones have been assigned!");
            }
        }
        if (type == 2){
            if (numPatrolCars <= 0){
                throw new IllegalArgumentException("Maximum amount of patrol cars have been assigned!");
            }
        }

        this.type = type;
    }

    //special methods
    public String toString(){
        String type = "";

        if (getType() == 0){
            type = "Laptop";
        }
        if (getType() == 1){
            type = "Phone";
        }
        if (getType() == 2){
            type = "Patrol Car";
        }
        return type;
    }

    public static void updateNumLaptops(){
        //Adds one from number of laptops
        numLaptops++;
    }

    public static void updateNumPhones(){
        //Adds one from number of phones
        numPhones++;
    }

    public static void updateNumPatrolCars(){
        //Adds one from number of patrol cars
        numPatrolCars++;
    }

    public static int numLaptopsUsed(){
        return MAX_LAPTOPS - numLaptops;
    }

    public static int numPhonesUsed(){
        return MAX_PHONES - numPhones;
    }

    public static int numPatrolCarsUsed(){
        return MAX_PATROLCARS - numPatrolCars;
    }

    
}
