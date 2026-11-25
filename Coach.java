public class Coach extends Person{
    private int yearsExperience;
    private Team team;

    public Coach(){
        yearsExperience = 0;
        team = null;
    }

    public Coach(String name, String dateOfBirth, double height, double weight, String nationality, String gender, int yearsExperience, Team team){
        super(name, dateOfBirth, height, weight, nationality, gender);
        this.yearsExperience = 0;
        setYearsExperience(yearsExperience);
        setTeam(team);
    }

    public int getYearsExperience(){
        return yearsExperience;
    }

    public Team getTeam(){
        return team;
    }
    public void setYearsExperience(int yearsExperience){
        if(yearsExperience < 0){
            System.out.println("Years of experience cannot be negative.");
        }
        else{
            this.yearsExperience = yearsExperience;
        }
    }

    public void setTeam(Team team){
        this.team = team;
    }

    public void displayInfo(){
        System.out.println("---- Coach Info ----");
        System.out.println("Name: " + getName());
        if(team == null){
            System.out.println("Team: No team");
        }
        else{
            System.out.println("Team: " + team.getName());
        }
        System.out.println("Years of Experience: " + yearsExperience);
    }

    @Override
    public String getRole(){
        return "Coach";
    }
}
