package Classes;
import java.util.Random;

class MatchResult {
    Team home;
    Team away;
    int goalsHome;
    int goalsAway;


    public MatchResult (Team home, Team away) {
        this.home = home;
        this.away = away;
    }

    public void playMatch(Team home, Team away) {
        Result resultMatch = result(home, away);
        
        if (resultMatch.winner.equals("home")) {
            home.goals += resultMatch.placarWin;
            away.goals += resultMatch.placarDef;
            home.points += 3;
        } 
        else if (resultMatch.winner.equals("away")) {
            away.goals += resultMatch.placarWin;
            home.goals += resultMatch.placarDef;
            away.points += 3;
        }
        else {
            home.goals = resultMatch.placarWin;
            away.goals += resultMatch.placarDef;
            home.points += 1;
            away.points += 1;
        }
    }

    public Result result ( Team home, Team away ) {
        Random random = new Random();

        int homeStregnth = home.getCoach().getExperience() * random.nextInt(3);
        int awayStrength = away.getCoach().getExperience() * random.nextInt(3);


        if (homeStregnth > awayStrength) {
            goalsHome = random.nextInt(4) + 2;
            goalsAway = random.nextInt(3) + 1;
            if(goalsHome > goalsAway){
                return new Result(goalsHome, goalsAway, "home");
            } else if (goalsAway > goalsHome){
                return new Result(goalsAway, goalsHome, "away");
            } else {
                return new Result(goalsHome, goalsAway, "draw");
            }
        } 
        else if (awayStrength > homeStregnth) {
            goalsAway = random.nextInt(4) + 2;
            goalsHome = random.nextInt(3) + 1;
            if(goalsHome > goalsAway){
                return new Result(goalsAway, goalsHome, "away");
            } else if ( goalsHome > goalsAway) {
                return new Result(goalsHome, goalsAway, "home");
            } else {
                return new Result(goalsHome, goalsAway, "draw");
            }
        } 
        else {
            return new Result(goalsHome, goalsAway, "draw");
        }
    }
}