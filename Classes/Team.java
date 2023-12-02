package Classes;
import java.util.ArrayList;

class Team {
    public String name;
    public int points = 0;
    public int goals = 0;
    public Coach coach;
    public ArrayList<Player> players = new ArrayList<>();

    public Team(String name) {
        this.name = name;
    }

    public void addPlayer(Player player) {
        players.add(player);
    }

    public void addCoach(Coach coach) {
        this.coach = coach;
    }

    public void delPlayer(Player player) {
        players.remove(player);
    }

    public Coach getCoach() {
        return coach;
    }

    public Player getPlayer(String playerName) {
        for (Player player : players) {
            if (player.name.equals(playerName)) {
                return player;
            }
        }
        return null; // Retorna null se o jogador não for encontrado
    }

    public void ShowTeam() {
        System.out.println("  +----------------------------------+");
        System.out.printf("  | %-30s |\n", "Team: " + name);
        System.out.printf("  | Coach: %-25s |\n", coach.name);
        System.out.printf("  | Coach Wage: %-20d |\n", coach.wage);
        System.out.printf("  | Coach Experience: %-15d |\n", coach.experience);
        System.out.println("  |----------------------------------|");
        System.out.printf("  | %-30s |\n", "Players:");
        System.out.printf("  | %-20s | %-10s | %-10s |\n", "Name", "Wage", "Position");
        
        for (Player player : players) {
            System.out.printf("  | %-20s | %-10d | %-10s |\n", player.name, player.wage, player.posicion);
        }
        
        float teamValue = 0;
        for(Player player : players) {
            teamValue += player.wage;
        }
        
        System.out.println("  |----------------------------------|");
        System.out.printf("  | %-30s |\n", "Team Value: " + teamValue);
        System.out.println("  +----------------------------------+");
    }
    
}
