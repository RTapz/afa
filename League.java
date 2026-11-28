import java.util.Arrays;

public class League {
    private final String ASSOCIATION = "ASHESI FOOTBALL ASSOCIATION";
    private String name;
    private Team[] teams = new Team[6];
    private Match[] fixtures = new Match[30];
    private Referee[] referees = new Referee[3];



    // Constructors
    public League(){}

    public League(String name, Team[] teams, Match[] fixtures, Referee[] referees){
        setName(name);
        setTeams(teams);
        setFixtures(fixtures);
        setReferees(referees);
    }



    // getters and setters
    public String getName(){
        return this.name;
    }

    public void setName(String name){
        if (name != null && !name.isBlank()){
            this.name = name;
        } else {
            System.out.println("Name cannot be empty.");
        }
    }

    public Team[] getTeams(){
        if (this.teams == null){
            return null;
        } else {
            return Arrays.copyOf(this.teams, this.teams.length);
        }
    }

    public void setTeams(Team[] teams){
        if(teams == null){
            this.teams = null;
        } else{
            // fill in null spaces with team objects
            // pick teams from the parameter to add
            for (int i = 0; i < teams.length; i++){    
                // loop through the teams list
                for (int j = 0; j < this.teams.length; j++){
                    //if the team is already in the league, move on to check the next team
                    if(teams[i] == this.teams[j]){
                        break;
                    }
                    // if the slot is empty, put the player in the team
                    if(this.teams[j] == null){
                        this.teams[j] = teams[i];
                        continue;
                    }
                }
            }
        }
    }

    public Match[] getFixtures(){
        if (this.fixtures == null){
            return null;
        } else {
            return Arrays.copyOf(this.fixtures, this.fixtures.length);
        }
    }

    public void setFixtures(Match[] fixtures){
        if(fixtures == null){
            this.fixtures = null;
        } else{
            // fill in null spaces with Match objects
            // pick matches from the parameter to add
            for (int i = 0; i < fixtures.length; i++){    
                // loop through the fixtures list
                for (int j = 0; j < this.fixtures.length; j++){
                    //if the match is already in the fixtures list, move on to check the next match
                    if(fixtures[i] == this.fixtures[j]){
                        break;
                    }
                    // if the slot is empty, put the match in the team
                    if(this.fixtures[j] == null){
                        this.fixtures[j] = fixtures[i];
                        continue;
                    }
                }
            }
        }
    }

    public Referee[] getReferees(){
        if (this.referees == null){
            return null;
        } else {
            return Arrays.copyOf(this.referees, this.referees.length);
        }
    }

    public void setReferees(Referee[] referees){
        if(referees == null){
            this.referees = null;
        } else{
            // fill in null spaces with referee objects
            // pick referees from the parameter to add
            for (int i = 0; i < referees.length; i++){    
                // loop through the referees list
                for (int j = 0; j < this.referees.length; j++){
                    // if the referee is already in the league, move on to check the next referee
                    if(referees[i] == this.referees[j]){
                        break;
                    }
                    // if the slot is empty, put the referee in the team
                    if(this.referees[j] == null){
                        this.referees[j] = referees[i];
                    }
                }
            }
        }
    }



    // Methods
    public void createFixture(Match match){
        if(match == null){
            throw new IllegalArgumentException("Match cannot be null");
        }

        for (int i = 0; i < fixtures.length; i++){    
            // loop through the fixture list
            for (int j = 0; j < this.fixtures.length; j++){
                // if the fixture is already in the array, move on to check the next fixture
                if(fixtures[i] == this.fixtures[j]){
                    break;
                }
                // if the slot is empty, put the fixture in the fixtures array
                if(this.fixtures[j] == null){
                    this.fixtures[j] = match;
                }
            }
        }
    }
        

    public void updateFixture(int fixturePosition, Match match){
        if(match == null){
            throw new IllegalArgumentException("Match cannot be null");
        }
        for (int i = 0; i < fixtures.length; i++){
            if (fixtures[i] != null && fixtures[i] == match){
                System.out.println("Fixture already exists");
                return;
            }
        }
        fixtures[fixturePosition] = match;
    }

    public void displayFixtures(){
        System.out.println(getName() + "Fixtures");
        for(int i = 0; i < getFixtures().length; i++){
            System.out.printf("%d. %s vs %s", i+1, fixtures[i].getHomeTeam().getName(), fixtures[i].getAwayTeam().getName());
        }
    }

    public void transferPlayer(Player player, Team transferFrom, Team transferTo){
        // make sure arguments are not null
        if (player == null){
            throw new IllegalArgumentException("Player cannot be null");
        }
        if (transferFrom == null || transferTo == null){
            throw new IllegalArgumentException("Teams cannot be null");
        }
        // check whether both teams exist
        boolean t1Exists;
        boolean t2Exists;
        for (Team team: teams){
            if (team == transferFrom){
                t1Exists = true;
            }
            if (team == transferTo){
                t2Exists = true;
            }
        }
        // check whether player exists in transferFrom
        if (t1Exists && t2Exists){
            for (Player p: transferFrom.getPlayers()){
                // if player is found
                if (p == player){
                    for (int i = 0; i < transferTo.getPlayers().length; i++)
                    // check if theres space in the new team
                        if (transferTo.getPlayers()[i] == null){
                            transferTo.getPlayers()[i] = player;
                        }
                    // put the player in the new team and set his value in the old team to null
                    for (int j = 0; j < transferFrom.getPlayers().length; j++){
                        if (transferFrom.getPlayers()[j] == player){
                            transferFrom.getPlayers()[j] = null;
                        }
                    }
                }
            }
            System.out.println("Player does not exist.");

        }
        else {
            System.out.println("Make sure both teams exist.");
            return;
        }
    }

    public void updateLeagueStats(){
        // set every team's stats back to zero so matches are not counted twice
        for (Team team: teams){
            if (team != null){
                team.setPoints(0);
                team.setMatchesPlayed(0);
                team.setWins(0);
                team.setDraws(0);
                team.setLosses(0);
                team.setGoalsFor(0);
                team.setGoalsAgainst(0);
            }
        }

        // go through every match and update both teams
        for (Match match: fixtures){
            // skip empty slots
            if (match == null){
                continue;
            }

            Team home = match.getHomeTeam();
            Team away = match.getAwayTeam();
            int homeGoals = match.getHomeGoals();
            int awayGoals = match.getAwayGoals();

            // update matches played
            home.setMatchesPlayed(home.getMatchesPlayed() + 1);
            away.setMatchesPlayed(away.getMatchesPlayed() + 1);

            // update goals for and goals against
            home.setGoalsFor(home.getGoalsFor() + homeGoals);
            home.setGoalsAgainst(home.getGoalsAgainst() + awayGoals);
            away.setGoalsFor(away.getGoalsFor() + awayGoals);
            away.setGoalsAgainst(away.getGoalsAgainst() + homeGoals);

            // win = 3 points, draw = 1 point, loss = 0 points
            if (homeGoals > awayGoals){
                home.setWins(home.getWins() + 1);
                home.setPoints(home.getPoints() + 3);
                away.setLosses(away.getLosses() + 1);
            } else if (homeGoals < awayGoals){
                away.setWins(away.getWins() + 1);
                away.setPoints(away.getPoints() + 3);
                home.setLosses(home.getLosses() + 1);
            } else {
                home.setDraws(home.getDraws() + 1);
                away.setDraws(away.getDraws() + 1);
                home.setPoints(home.getPoints() + 1);
                away.setPoints(away.getPoints() + 1);
            }
        }
    }

    public void displayLeagueStats(){
        // make sure the stats are up to date before showing them
        updateLeagueStats();

        System.out.println(ASSOCIATION);
        System.out.println(getName() + " Stats");
        System.out.printf("%s %s %s %s %s %s %s%n", "Team", "P", "W", "D", "L", "GF", "GA");

        // print one row for each team
        for (Team team: teams){
            // skip empty slots
            if (team == null){
                continue;
            }
            System.out.printf("%s %d %d %d %d %d %d%n", team.getName(), team.getMatchesPlayed(),
                team.getWins(), team.getDraws(), team.getLosses(), team.getGoalsFor(), team.getGoalsAgainst());
        }
    }

    public void displayLeagueTable(){
        // make sure the stats are up to date before ranking
        updateLeagueStats();

        // sort a copy so the league's own teams array keeps its order
        Team[] sorted = getTeams();

        // compare neighbours and swap if they are in the wrong order
        for (int i = 0; i < sorted.length - 1; i++){
            for (int j = 0; j < sorted.length - 1 - i; j++){
                Team a = sorted[j];
                Team b = sorted[j + 1];

                // only compare two real teams (empty slots stay at the end)
                if (a != null && b != null){
                    // swap if a has fewer points, or the same points but a worse goal difference
                    if (a.getPoints() < b.getPoints() ||
                        (a.getPoints() == b.getPoints() && a.getGoalDifference() < b.getGoalDifference())){
                        sorted[j] = b;
                        sorted[j + 1] = a;
                    }
                }
            }
        }

        System.out.println(ASSOCIATION);
        System.out.println(getName() + " Table");
        System.out.printf("%s %s %s %s %s %s %s %s%n", "Pos", "Team", "P", "W", "D", "L", "GD", "Pts");

        // print the teams from first place downwards
        for (int i = 0; i < sorted.length; i++){
            // skip empty slots
            if (sorted[i] == null){
                continue;
            }
            System.out.printf("%4d %-20s %3d %3d %3d %3d %4d %4d%n", i + 1, sorted[i].getName(),
                sorted[i].getMatchesPlayed(), sorted[i].getWins(), sorted[i].getDraws(),
                sorted[i].getLosses(), sorted[i].getGoalDifference(), sorted[i].getPoints());
        }
    }
}
