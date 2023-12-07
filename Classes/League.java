package Classes;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class League {
    public String name;
    public int season;
    public String trophy;
    public ArrayList<Team> times;

    public League(String name, int season, String trophy) {
        this.name = name;
        this.season = season;
        this.trophy = trophy;
        this.times = new ArrayList<>();
    }

    public String getName() {
        return this.name;
    }

    public int leagueSize() {
        return times.size();
    }

    public boolean isEmpty() {
        return times.isEmpty();
    }

    public void addTeam(Team team) {
        times.add(team);
    }

    public void delTeam(Team team) {
        times.remove(team);
    }

    public String showTable() {
        return null;
    }

    public boolean checkTeam(String name) {
        for (Team time : times) {
            if (time.getName().equals(name)) {
                return true;
            }
        }
        return false;
    }

    public Team getTeam(String name) {
        for (Team time : times) {
            if (time.getName().equals(name)) {
                return time;
            }
        }
        return null;
    }

    public List<Team> getTeams() {
        return times;
    }

    public void overrideTeam(Team team) {
        Iterator<Team> iterator = times.iterator();
        while (iterator.hasNext()) {
            Team time = iterator.next();
            if (time.getName().equals(team.getName())) {
                iterator.remove();
                times.add(team);
                break;
            }
        }
    }

    public void showAllTeams() {
        for (Team time : times) {
            System.out.printf("- %s\n", time.getName());
        }
    }
}
