package Classes;
import java.util.Scanner;
// import java.util.regex.MatchResult;

public class Main {
    public static void main(String[] arg) {
        try (Scanner scanner = new Scanner(System.in)) {
         League league = null;
         Team team = null;

           while (true) {
               System.out.println("-----------------MENU-----------------");
               System.out.println("1- Adicionar Campeonato \n2- Adicionar Time \n3- Excluir Time \n"
                   + "4- Contratar Jogador \n5- Demitir Jogador \n6- Contratar Tecnico \n7- Mostrar Time \n 8- Jogar Partida");

                System.out.println("Escolha uma opção:");

               int opcion = scanner.nextInt();
               scanner.nextLine();

               switch (opcion) {
                   case 1:
                       if (league == null) {
                           System.out.println("\nNome do campeonato:");
                           String leagueName = scanner.nextLine();
                           System.out.println("Temporada:");
                           int leagueSeason = scanner.nextInt();
                           scanner.nextLine();
                           System.out.println("Troféu:");
                           String leagueTrophy = scanner.nextLine();
                           league = new League(leagueName, leagueSeason, leagueTrophy);
                           System.out.println("Campeonato adicionado com sucesso!");
                       } else {
                           System.out.println("fail: já existe um campeonato");
                       }
                       break;

                   case 2:
                       if (league != null) {
                           System.out.println("\nNome do Time");
                           String teamName = scanner.nextLine();
                           team = new Team(teamName);
                           league.addTeam(team);
                           System.out.println("Time adicionado com sucesso!");
                       } else {
                           System.out.println("fail: não existe campeonato");
                       }
                       break;

                   case 3:
                       if(team == null){
                        System.out.println("Não existem times para serem excluidos");
                       }
                       if (league != null) {
                           System.out.println("\nNome do Time:");
                           String teamName = scanner.nextLine();
                           Team teamToRemove = league.getTeam(teamName);
                           if (teamToRemove != null) {
                               league.delTeam(teamToRemove);
                               System.out.println("Time removido com sucesso!");
                           } else {
                               System.out.println("fail: O time não existe");
                           }
                       } else {
                           System.out.println("fail: não existe campeonato");
                       }
                       break;

                   case 4:
                       if (league == null) {
                           System.out.println("fail: não existe campeonato");
                           break;
                       }

                       if (team == null) {
                           System.out.println("fail: não existe time(s)");
                           break;
                       }

                       System.out.println("Qual o time do jogador?");
                       String teamName = scanner.nextLine();

                       if (league.checkTeam(teamName)) {
                           System.out.println("Nome do jogador:");
                           String playerName = scanner.nextLine();
                           System.out.println("Posição do jogador:");
                           String posicPlayer = scanner.nextLine();
                           System.out.println("Salario do jogador:");
                           int wagePlayer = scanner.nextInt();
                           Team equip = league.getTeam(teamName);
                           Player player = new Player(playerName, wagePlayer, posicPlayer);
                           equip.addPlayer(player);
                           league.OverrideTeam(equip);
                           System.out.println("Jogador contratado com sucesso!");
                       } else {
                           System.out.println("fail: o time não existe");
                       }
                       break;

                   case 5:
                       if (league == null) {
                           System.out.println("fail: não existe campeonato");
                           break;
                       }

                       if (team == null) {
                           System.out.println("fail: não existe time(s)");
                           break;
                       }

                       System.out.println("Qual o time do jogador?");
                       String timeNome = scanner.nextLine();

                       if (league.checkTeam(timeNome)) {
                           Team time = league.getTeam(timeNome);
                           System.out.println("\nNome do Jogador");
                           String playerToRemove = scanner.nextLine();

                           if (time.getPlayer(playerToRemove) != null) {
                               time.delPlayer(time.getPlayer(playerToRemove));
                               System.out.println("Jogador demitido com sucesso!");
                           } else {
                               System.out.println("fail: o jogador não existe");
                           }
                       } else {
                           System.out.println("fail: O time não existe");
                       }
                       break;
                   case 6:
                   if (league == null) {
                           System.out.println("fail: não existe campeonato");
                           break;
                       }

                       if (team == null) {
                           System.out.println("fail: não existe time(s)");
                           break;
                       }

                       System.out.println("Qual o time do Tecnico?");
                       String TeamName = scanner.nextLine();

                       if (league.checkTeam(TeamName)) {
                           System.out.println("Nome do Tecnico:");
                           String coachName = scanner.nextLine();
                           System.out.println("Experiencia do Tecnico:");
                           int coachExperience = scanner.nextInt();
                           System.out.println("Salario do Tecnico:");
                           int coachWage = scanner.nextInt();
                           Team equip = league.getTeam(TeamName);
                           Coach coach = new Coach(coachName, coachWage, coachExperience);
                           equip.addCoach(coach);
                           league.OverrideTeam(equip);
                           System.out.println("Tecnico contratado com sucesso!");
                       } else {
                           System.out.println("fail: o time não existe");
                       }
                       break;

                   case 7:
                       if (league == null) {
                           System.out.println("fail: não existe campeonato");
                           break;
                       }
                   
                       if (team == null) {
                           System.out.println("fail: não existe time(s)");
                           break;
                       }
                   
                       System.out.println("Qual time você quer ver?");
                       String NomeTime = scanner.nextLine();
                   
                       if (league.getTeam(NomeTime) != null) {
                           Team equip = league.getTeam(NomeTime);
                           if (equip != null && equip.players != null && equip.getCoach() != null) {
                               equip.ShowTeam();
                           } else {
                               System.out.println("fail: time incompleto. Adicione um treinador ou jogador");
                           }
                       } else {
                           System.out.println("fail: seu time não existe");
                       }
                       break;
                       case 8:
                       if (league == null) {
                           System.out.println("fail: não existe campeonato");
                           break;
                       }
                   
                       if (team == null && league.leagueSize() < 2) {
                           System.out.println("fail: não existe time(s) suficientes(Minimo de 2 times na Liga)");
                           break;
                       }

                       
                       System.out.println("Qual o time jogara em casa?");
                       league.showAllTeams();
                       String teamHomeName = scanner.nextLine();
                       Team teamHome = league.getTeam(teamHomeName);
                       if (teamHome == null) {
                           System.out.println("fail: Time não encontrado");
                           break;
                        }
                        
                        System.out.println("Qual o time jogara em fora?");
                        league.showAllTeams();
                        String teamAwayName = scanner.nextLine();
                        Team teamAway = league.getTeam(teamAwayName);
                        if (teamAway == null) {
                            System.out.println("fail: Time não encontrado");
                            break;
                        }
                        // MatchResult matcher = new MatchResult(teamHome, teamAway);
                        // matcher.playMatch(teamHome, teamAway);
                        break;
                        default: 
                        System.out.println("fail: opção invalida");
               }
           }
      }
    }
}
