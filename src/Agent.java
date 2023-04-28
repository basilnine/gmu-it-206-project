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
        this.radioNum = radioNum;
    }

    public void setAssignNum(String assignNum){
        this.assignNum = assignNum;
    }

    public void setRank(String rank){
        this.rank = rank;
    }

    //special methods
    public String toString(){
        return super.toString() + "\nRadio Number: " + radioNum + "\nAssignment Number: " + assignNum + "\nRank: " + rank;
    }

    public int updateNumAgents(){
        //Subtracts one from number of Agents and Employees
        numAgents--;
        return numAgents;
    }
    
}
