package Classes;
import java.util.*;

class League {
    String name;
    int season;
    String trophy;
    private ArrayList<Team> times;

    public League ( String name, int season, String trophy) {
        this.name = name;
        this.season = season;
        this.trophy = trophy;
        this.times = new ArrayList<>();
    }

    public String getName(){
        return this.name;
    }
    public int leagueSize(){
        int tamanho = times.size();
        return tamanho;
    }

    public boolean isEmpty(){
        return times.isEmpty();
    }

    public void addTeam(Team team) {
        times.add(team);
    }
    public void delTeam(Team team){
        times.remove(team);
    }
    public String ShowTable() {
        return null;
    }
    public boolean checkTeam(String name){
        for(Team time : times){
            if(time.name.equals(name)){
                return true;
            }
        }
        return false;
    }
    public Team getTeam(String name){
        for(Team time : times){
            if(time.name.equals(name)){
                return time;
            }
        }
                return null;
    }

    public List<Team> getTeams(){
        return times;
    }

    public void OverrideTeam(Team team){
        Iterator<Team> iterator = times.iterator();
        while (iterator.hasNext()) {
            Team time = iterator.next();
            if(time.name.equals(team.name)){
                iterator.remove();
                times.add(team);
                break;
            }
        }
    }

    public void showAllTeams(){
        for(Team time : times){
            System.out.printf("- %s\n", time.name);
        }
    }
}