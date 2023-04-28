public class Agent extends Employee {
    private String radioNum;
    private String assignNum;

    private String rank;
    private static int numAgents;

    public Agent(String firstName, String lastName, String addressStreet, String addressCity, String addressState, String addressZIP, String phone, String workTitle, double salary, String fieldOffice, String radioNum, String assignNum, String rank){
        super(firstName, lastName, addressStreet, addressCity, addressState, addressZIP, phone, workTitle, salary, fieldOffice);
        setRadioNum(radioNum);
        setAssignNum(assignNum);
        setRank(rank);
        numAgents++;
    }

    //accessors
    public String getRadioNum(){
        return radioNum;
    }

    public String getAssignNum(){
        return assignNum;
    }

    public String getRank(){
        return rank;
    }

    public static int getNumAgents(){
        return numAgents;
    }

    //mutators
    public void setRadioNum(String radioNum){
        //make sure the length is 5 digits
        if(radioNum.length() != 5) {
            throw new IllegalArgumentException("Radio Number must be 5 digits long!");
        } else if(!radioNum.matches("[0-9]+")) {
            throw new IllegalArgumentException("Radio Number must be numeric!");
        }
        this.radioNum = radioNum;
    }

    public void setAssignNum(String assignNum){
        //make sure the length is 5 digits
        if(assignNum.length() != 5) {
            throw new IllegalArgumentException("Assignment Number must be 5 digits long!");
        } else if(!assignNum.matches("[0-9]+")) {
            throw new IllegalArgumentException("Assignment Number must be numeric!");
        }
        this.assignNum = assignNum;
    }

    public void setRank(String rank){
        //if rank is null or empty
        if(rank == null || rank.isEmpty()) {
            throw new IllegalArgumentException("Rank cannot be empty!");
        }
        this.rank = rank;
    }

    //special methods
    public String toString(){
        return super.toString() + "Agent";
    }

    public void updateNumAgents(){
        //Subtracts one from number of Agents and Employees
        numAgents--;
    }
    
}
