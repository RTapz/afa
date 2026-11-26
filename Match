public class Match {
    private String schedule;
    private Team homeTeam;
    private Team awayTeam;
    private Referee referee;
    private int homeGoals;
    private int awayGoals;
    private boolean extraTime;
    private boolean penalties;

    public Match() {
        this.schedule = "TBD";
        this.homeGoals = 0;
        this.awayGoals = 0;
        this.extraTime = false;
        this.penalties = false;
    }

    public Match(String schedule, Team homeTeam, Team awayTeam, Referee referee) {
        this();
        try {
            validateTeams(homeTeam, awayTeam);
            this.schedule = (schedule == null || schedule.trim().isEmpty()) ? "TBD" : schedule.trim();
            this.homeTeam = homeTeam;
            this.awayTeam = awayTeam;
            this.referee = referee;
        } catch (InvalidMatchException e) {
            System.out.println("Match setup error: " + e.getMessage());
        }
    }

    private void validateTeams(Team home, Team away) throws InvalidMatchException {
        if (home == null || away == null) {
            throw new InvalidMatchException("Both home and away teams must be provided.");
        }
        if (home == away) {
            throw new InvalidMatchException("A team cannot play against itself.");
        }
    }

    public void setResult(int homeGoals, int awayGoals) {
        try {
            if (homeGoals < 0 || awayGoals < 0) {
                throw new InvalidScoreException("Goals cannot be negative.");
            }
            this.homeGoals = homeGoals;
            this.awayGoals = awayGoals;
        } catch (InvalidScoreException e) {
            System.out.println("Score update error: " + e.getMessage());
        }
    }

    public Team getWinner() {
        if (homeGoals > awayGoals) {
            return homeTeam;
        } else if (awayGoals > homeGoals) {
            return awayTeam;
        }
        return null; 
    }

    public void displayDetails() {
        String homeName = (homeTeam != null) ? homeTeam.getName() : "TBD";
        String awayName = (awayTeam != null) ? awayTeam.getName() : "TBD";
        String refName = (referee != null) ? referee.getName() : "Unassigned";
        Team winner = getWinner();
        String outcome = (winner != null) ? "Winner: " + winner.getName() : "Result: Draw / Pending";

        System.out.println("Schedule: " + schedule);
        System.out.println("Fixture: " + homeName + " vs " + awayName);
        System.out.println("Score: " + homeGoals + " - " + awayGoals);
        System.out.println("Extra Time: " + extraTime + " | Penalties: " + penalties);
        System.out.println("Referee: " + refName);
        System.out.println(outcome);
    }

    public String getSchedule() {
        return schedule;
    }

    public void setSchedule(String schedule) {
        if (schedule != null && !schedule.trim().isEmpty()) {
            this.schedule = schedule.trim();
        }
    }

    public Team getHomeTeam() {
        return homeTeam;
    }

    public Team getAwayTeam() {
        return awayTeam;
    }

    public Referee getReferee() {
        return referee;
    }

    public void setReferee(Referee referee) {
        this.referee = referee;
    }

    public int getHomeGoals() {
        return homeGoals;
    }

    public int getAwayGoals() {
        return awayGoals;
    }

    public boolean isExtraTime() {
        return extraTime;
    }

    public void setExtraTime(boolean extraTime) {
        this.extraTime = extraTime;
    }

    public boolean isPenalties() {
        return penalties;
    }

    public void setPenalties(boolean penalties) {
        this.penalties = penalties;
    }
}
