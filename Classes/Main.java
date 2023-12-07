package Classes;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] arg) {
        try (Scanner scanner = new Scanner(System.in)) {
            League league = null;
            Team team = null;

            while (true) {
                try {
                    System.out.println("-----------------MENU-----------------");
                    System.out.println("0- CASO TESTE PARA O PROFESSOR \n1- Adicionar Campeonato \n2- Adicionar Time \n3- Excluir Time \n"
                            + "4- Contratar Jogador \n5- Demitir Jogador \n6- Contratar Técnico \n7- Mostrar Time \n"
                            + "8- Jogar Partida \n9- Mostrar Tabela \n10- Mostrar vencedor");

                    System.out.println("Escolha uma opção:");

                    int option = scanner.nextInt();
                    scanner.nextLine();

                    switch (option) {
                        case 0:
                        league = new League("Brasileiro", 2024, "Brasileiro");
                        

                        Team Flamengo = new Team("Flamengo");
                        Player playerFla = new Player("Pedro", 2650, "CA");
                        Coach coachFla = new Coach("Jorge Jesus", 4560, 9);
                        Flamengo.addCoach(coachFla);
                        Flamengo.addPlayer(playerFla);
                        league.addTeam(Flamengo);

                        Team Vasco = new Team("Vasco");
                        Player playerVas = new Player("Verreti", 2420, "PD");
                        Coach coachVas = new Coach("Pablo", 4500, 7);
                        league.addTeam(Vasco);
                        Vasco.addCoach(coachVas);
                        Vasco.addPlayer(playerVas);

                        Team Palmeiras = new Team("Palmeiras");
                        Player playerPal = new Player("Endrick", 3200, "CA");
                        Coach coachPal = new Coach("Abel Ferreira", 4320, 8);
                        league.addTeam(Palmeiras);
                        Palmeiras.addCoach(coachPal);
                        Palmeiras.addPlayer(playerPal);

                        Team Bahia = new Team("Bahia");
                        Player playerBah = new Player("Bahiano", 1500, "PE");
                        Coach coachBah = new Coach("Fernando Noronha", 2520, 7);
                        league.addTeam(Bahia);
                        Bahia.addCoach(coachBah);
                        Bahia.addPlayer(playerBah);

                        System.out.println("Times já criados:\n");
                        league.showAllTeams();
                        System.out.println(league);

                        break;
                        case 1:
                        System.out.println(league);
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
                            if (team == null) {
                                System.out.println("Não existem times para serem excluídos");
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
                                league.overrideTeam(equip);
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
                            String timeName = scanner.nextLine();

                            if (league.checkTeam(timeName)) {
                                Team time = league.getTeam(timeName);
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

                            System.out.println("Qual o time do Técnico?");
                            String TeamName = scanner.nextLine();

                            if (league.checkTeam(TeamName)) {
                                System.out.println("Nome do Técnico:");
                                String coachName = scanner.nextLine();
                                System.out.println("Experiência do Técnico:");
                                int coachExperience = scanner.nextInt();
                                System.out.println("Salário do Técnico:");
                                int coachWage = scanner.nextInt();
                                Team equip = league.getTeam(TeamName);
                                Coach coach = new Coach(coachName, coachWage, coachExperience);
                                equip.addCoach(coach);
                                league.overrideTeam(equip);
                                System.out.println("Técnico contratado com sucesso!");
                            } else {
                                System.out.println("fail: o time não existe");
                            }
                            break;

                        case 7:
                            if (league == null) {
                                System.out.println("fail: não existe campeonato");
                                break;
                            }

                            // if (team == null) {
                            //     System.out.println("fail: não existe time(s)");
                            //     break;
                            // }

                            System.out.println("Qual time você quer ver?");
                            league.showAllTeams();
                            String TeamNameToShow = scanner.nextLine();

                            if (league.getTeam(TeamNameToShow) != null) {
                                Team equip = league.getTeam(TeamNameToShow);
                                if (equip != null && equip.players != null && equip.getCoach() != null) {
                                    equip.showTeam();
                                } else {
                                    System.out.println("fail: time incompleto. Adicione um treinador e/ou jogador");
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
                            
                            if (league.leagueSize() < 2) {
                                System.out.println("fail: não existe time(s) suficientes (Mínimo de 2 times na Liga)");
                                break;
                            }
                            

                            System.out.println("Qual o time jogará em casa?");
                            league.showAllTeams();
                            String teamHomeName = scanner.nextLine();
                            Team teamHome = league.getTeam(teamHomeName);
                            if (teamHome == null) {
                                System.out.println("fail: Time não encontrado");
                                break;
                            }

                            System.out.println("Qual o time jogará fora?");
                            league.showAllTeams();
                            String teamAwayName = scanner.nextLine();
                            Team teamAway = league.getTeam(teamAwayName);
                            if (teamAway == null) {
                                System.out.println("fail: Time não encontrado");
                                break;
                            }

                            Partida matcher = new Partida(teamHome, teamAway);
                            matcher.playMatch(teamHome, teamAway);

                            int value1 = teamHome.points;
                            int value2 = teamAway.points;
                            System.out.printf("Pontos atuais %s: %d\n", teamHome.name, value1);
                            System.out.printf("Pontos atuais %s: %d\n", teamAway.name, value2);

                            break;

                        case 9:
                            if (league == null) {
                                System.out.println("fail: não existe campeonato");
                                break;
                            }

                            if (league.leagueSize() < 1) {
                                System.out.println("fail: não existe time(s) suficientes (Mínimo de 1 time na Liga)");
                                break;
                            }

                            List<Team> sortedTeams = new ArrayList<>(league.getTeams());
                            sortedTeams.sort(Comparator.comparingInt(Team::getPoints).reversed());

                            System.out.println("===================================");
                            System.out.printf("| TABELA CAMPEONATO %s | Temp %d |\n", league.getName(), league.season);
                            System.out.println("===================================");
                            System.out.println("     TIME     |  GOLS  |  PONTOS  |");
                            for (Team team2 : sortedTeams) {
                                System.out.printf("|  %-10s | %-6d | %-5d |\n", team2.getName(), team2.getGoals(),team2.getPoints());
                            }

                            break;
                        case 10:
                            if (league == null) {
                                System.out.println("fail: não existe campeonato");
                                break;
                            }

                            if (league.leagueSize() < 2) {
                                System.out.println("fail: não existe time(s) suficientes (Mínimo de 2 times na Liga)");
                                break;
                            }

                            List<Team> ganhador = new ArrayList<>(league.getTeams());
                            ganhador.sort(Comparator.comparingInt(Team::getPoints).reversed());

                            System.out.printf("====== O vencedor da temporada %d ======\n" +
                                              "======== do Campeonato %s é ======== \n", league.season, league.getName());
                            if(!ganhador.isEmpty()){
                                Team vencedor = ganhador.get(0);
                                Team vencedor2 = ganhador.get(1);
                                if(vencedor.getPoints() == vencedor2.getPoints()){
                                    for(int i = 0; i < ganhador.size(); i++){
                                        Team vencedorPossivel = ganhador.get(i);
                                        if(vencedor.getGoals() <= vencedorPossivel.getGoals()){
                                            vencedor = vencedorPossivel;
                                        }
                                    }
                                }
                                System.out.println("=============" + vencedor.getName() + "==============");
                                league.season += 1;
                                for(Team times1 : ganhador){
                                    times1.points = 0;
                                    times1.goals = 0;
                                }
                            }

                            break;

                        default:
                            System.out.println("fail: opção inválida");
                            break;
                    }
                } catch (InputMismatchException e) {
                    System.out.println("fail: entrada inválida, por favor, insira uma entrada válida");
                    scanner.nextLine();
                } catch (NoSuchElementException e) {
                    System.out.println("fail: entrada não encontrada");
                } catch (Exception e) {
                    System.out.println("fail: ocorreu um erro inesperado");
                    e.printStackTrace();
                }
            }
        }
    }
}
