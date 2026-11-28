import java.time.Year;
import java.util.Arrays;

public class Team{
    private final int MAX_TEAM_LIMIT = 26;
    private String name;
    private int yearFounded;
    private int points;
    private int matchesPlayed;
    private int wins;
    private int draws;
    private int losses;
    private int goalsFor;
    private int goalsAgainst;
    private int goalDifference;
    private int playerCount;
    private int assistantCoachCount;
    private Coach coach;
    private Player[] players = new Player[26];
    private AssistantCoach[] assistantCoaches = new AssistantCoach[2];


    // Constructors
    public Team(){}

    public Team(String name, int yearFounded){
        setName(name);
        setYearFounded(yearFounded);
    }

    public Team(String name, int yearFounded, Coach coach, Player[] players, AssistantCoach[] assistantCoaches){
        setName(name);
        setYearFounded(yearFounded);
        setCoach(coach);
        setPlayers(players);
        setAssistantCoaches(assistantCoaches);
    }


    // Getters and Setters
    public String getName(){
        return this.name;
    }

    public void setName(String name){
        if (name == null || name.isBlank()){
            throw new IllegalArgumentException("Name cannot be null or empty");
        }
        this.name = name;
    }

    public int getYearFounded(){
        return this.yearFounded;
    }

    public void setYearFounded(int yearFounded){
        int currentYear = Year.now().getValue();
        if(yearFounded < 2002 && yearFounded > currentYear){
            System.out.println("Year must be between 2002 and current year inclusive.");
        }
        this.yearFounded = yearFounded;
    }

    public int getPoints(){
        return this.points;
    }

    public void setPoints(int points){
        if (points < 0){
            throw new IllegalArgumentException("Points cannot be negative.");
        }
        this.points = points;
    }
    

    public int getGoalsFor(){
        return this.goalsFor;
    }

    public void setGoalsFor(int goalsFor){
        if (goalsFor < 0){
            throw new IllegalArgumentException("Goals for cannot be negative.");
        }
        this.goalsFor = goalsFor;
    }

    public int getGoalsAgainst(){
        return this.goalsAgainst;
    }

    public void setGoalsAgainst(int goalsAgainst){
        if (goalsAgainst < 0){
            throw new IllegalArgumentException("Goals against cannot be negative.");
        }
        this.goalsAgainst = goalsAgainst;
    }

    public int getMatchesPlayed(){
        return this.matchesPlayed;
    }

    public void setMatchesPlayed(int matchesPlayed){
        if (matchesPlayed < 0){
            throw new IllegalArgumentException("Matches played cannot be negative.");
        }
        this.matchesPlayed = matchesPlayed;
    }

    public int getWins(){
        return this.wins;
    }

    public void setWins(int wins){
        if (wins < 0){
            throw new IllegalArgumentException("Wins cannot be negative.");
        }
        this.wins = wins;
    }

    public int getDraws(){
        return this.draws;
    }

    public void setDraws(int draws){
        if (draws < 0){
            throw new IllegalArgumentException("Draws cannot be negative");
        }
        this.draws = draws;
    }

    public int getLosses(){
        return this.losses;
    }

    public void setLosses(int losses){
        if (losses < 0){
            throw new IllegalArgumentException("Losses cannot be negative");
        }
        this.losses = losses;
    }

    public int getGoalDifference(){
        return this.goalsFor - this.goalsAgainst;
    }


    // get the current number of players in the team
    public int getPlayerCount(){
        for(int i = 0; i < this.getPlayers().length; i++){
            if (this.getPlayers()[i] != null){
                this.playerCount++;
            }
        }
        return this.playerCount;
    }

    // get the current number of assistant coaches in the team
    public int getAssistantCoachCount(){
        for(int i = 0; i < this.getAssistantCoaches().length; i++){
            if (this.getAssistantCoaches()[i] != null){
                this.assistantCoachCount++;
            }
        }
        return this.assistantCoachCount++;

    }

    // Check how to properly get and set attributes which are objects
    public Coach getCoach(){
        if (this.coach == null){
            return null;
        }
        return this.coach;
    }

    public void setCoach(Coach coach){
        if (coach == null){
            throw new IllegalArgumentException("Coach cannot be null");
        }
        this.coach = coach;
    }

    // For arrays, handle null and return a copy of the original
    public Player[] getPlayers(){
        if (this.players == null){
            return null;
        }
        return Arrays.copyOf(this.players, this.players.length);
    }

    // For arrays, handle null
    public void setPlayers(Player[] players){
        if(players == null){
            throw new IllegalArgumentException("Players cannot be null");
        } 
        // fill in null spaces with player objects
        // pick players from the parameter to add
        for (int i = 0; i < players.length; i++){    
            // loop through the team's player list
            for (int j = 0; j < this.players.length; j++){
                //if the player is already in the team, move on to check the next player
                if(players[i] == this.players[j]){
                    break;
                }
                // if the slot is empty, put the player in the team
                if(this.players[j] == null){
                    this.players[j] = players[i];
                    continue;
                }
            }
        }
    }

    public AssistantCoach[] getAssistantCoaches(){
        if (this.assistantCoaches == null){
            return null;
        }
        return Arrays.copyOf(this.assistantCoaches, this.assistantCoaches.length);
    }

    public void setAssistantCoaches(AssistantCoach[] assistantCoaches){
        if (assistantCoaches == null){
            throw new IllegalArgumentException("Assistant coaches cannot be null");
        }            
        this.assistantCoaches = Arrays.copyOf(assistantCoaches, assistantCoaches.length);
    }



    // Methods
    public void addPlayers(Player[] players){
        setPlayers(players);
    }

    public void removePlayers(Player[] players){
        for (int i = 0; i < players.length; i++){
            for (int j = 0; j < this.players.length; j++){
                if (this.players[j] == players[i]){
                    this.players[j] = null;
                }
            }
        }

    }

    public void updateStats(Match match){
        if (this == match.getHomeTeam()) {
            goalsFor = match.getHomeGoals();
            goalsAgainst = match.getAwayGoals();
        } else if (this == match.getAwayTeam()) {
            goalsFor = match.getAwayGoals();
            goalsAgainst = match.getHomeGoals();
        } else {
            throw new IllegalArgumentException("This team is not part of the match.");
        }

        // update matches played
        this.setMatchesPlayed(this.getMatchesPlayed() + 1);
        // update goals for
        this.setGoalsFor(this.getGoalsFor() + goalsFor);
        // update goals against
        this.setGoalsAgainst(this.getGoalsAgainst() + goalsAgainst);
        // update goal difference
        this.goalDifference = this.getGoalsFor() - this.getGoalsAgainst();
        // update wins, draws, losses, goal difference and points based on goals
    

        if (goalsFor > goalsAgainst){
            this.setWins(this.getWins() + 1);
            this.setPoints(this.getPoints() + 3);
        } else if (goalsFor == goalsAgainst){
            this.setDraws(this.getDraws() + 1);
            this.setPoints(this.getPoints() + 1);
        } else {
            this.setLosses(this.getLosses() + 1);
        }
    }

    public void displayStats(){
        System.out.printf("TEAM NAME: %s", this.getName());
        System.out.printf("YEAR FOUNDED: %d%n", this.getYearFounded());
        System.out.printf("SQUAD LIST: %s", Arrays.toString(this.getPlayers()));
        System.out.printf("MATCHES PLAYED: %d%n", this.getMatchesPlayed());
        System.out.printf("WINS: %d%n", this.getWins());
        System.out.printf("DRAWS: %d%n", this.getDraws());
        System.out.printf("LOSSES: %d%n", this.getLosses());
        System.out.printf("GOALS FOR: %d%n", this.getGoalsFor());
        System.out.printf("GOALS AGAINST: %d%n", this.getGoalsAgainst());
        System.out.printf("GOAL DIFFERENCE: %d%n", this.getGoalDifference());
        System.out.printf("POINTS: %d%n", this.getPoints());
    }
}
