public class Player extends Person{
    private String position;
    private int jerseyNumber;
    private int goals;
    private int appearances;
    private int minutesPlayed;
    private String condition;
    private Team team;

    public Player(){
        super();
        position = "Unknown";
        jerseyNumber = 0;
        goals = 0;
        appearances = 0;
        minutesPlayed = 0;
        condition = "Fit";
        team = null;
    }

    public Player(String name, String dateOfBirth, double height, double weight, String nationality, String gender, String position, int jerseyNumber, Team team){
        super(name, dateOfBirth, height, weight, nationality, gender);
        this.position = "Unknown";
        this.jerseyNumber = 0;
        this.goals = 0;
        this.appearances = 0;
        this.minutesPlayed = 0;
        this.condition = "Fit";
        setPosition(position);
        setJerseyNumber(jerseyNumber);
        setTeam(team);
    }

    public String getPosition(){
        return position;
    }

    public int getJerseyNumber(){
        return jerseyNumber;
    }

    public int getGoals(){
        return goals;
    }

    public int getAppearances(){
        return appearances;
    }

    public int getMinutesPlayed(){
        return minutesPlayed;
    }

    public String getCondition(){
        return condition;
    }

    public Team getTeam(){
        return team;
    }

    public void setPosition(String position){
        if(position == null || position.equals("")){
            System.out.println("Invalid position. Position not changed.");
        }
        else{
            this.position = position;
        }
    }

    public void setJerseyNumber(int jerseyNumber){
        if(jerseyNumber < 1 || jerseyNumber > 99){
            System.out.println("Jersey number must be between 1 and 99. Jersey number not changed.");
        }
        else{
            this.jerseyNumber = jerseyNumber;
        }
    }

    public void setCondition(String condition){
        if(condition != null && (condition.equals("Fit") || condition.equals("Injured") || condition.equals("Suspended"))){
            this.condition = condition;
        }
        else{
            System.out.println("Condition must be Fit, Injured or Suspended. Condition not changed.");
        }
    }

    public void setTeam(Team team){
        this.team = team;
    }

    public void updateStats(int goals, int minutes){
        if(goals < 0){
            System.out.println("Goals cannot be negative. Stats not updated.");
            return;
        }
        if(minutes < 0 || minutes > 120){
            System.out.println("Minutes must be between 0 and 120. Stats not updated.");
            return;
        }
        this.goals += goals;
        this.minutesPlayed += minutes;
        appearances++;
    }

    public void displayStats(){
        System.out.println("---- Player Stats ----");
        System.out.println("Name: " + getName());
        if(team == null){
            System.out.println("Team: No team");
        }
        else{
            System.out.println("Team: " + team.getName());
        }
        System.out.println("Position: " + position);
        System.out.println("Jersey Number: " + jerseyNumber);
        System.out.println("Condition: " + condition);
        System.out.println("Appearances: " + appearances);
        System.out.println("Goals: " + goals);
        System.out.println("Minutes Played: " + minutesPlayed);
    }

    @Override
    public String getRole(){
        return "Player";
    }
}
