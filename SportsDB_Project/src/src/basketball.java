/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package src;


import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.*;
/**
 *
 * @author h6iqbal
 */
public class basketball {
    
    Connection con = null;
    
    public Connection connectDB(){
    
    try {
        Class.forName("org.sqlite.JDBC");
        con = DriverManager.getConnection("jdbc:sqlite:basketball.db");
        System.out.println("Opened database successfully");
        return con;
    }
        catch ( Exception e ) {
        System.err.println("Problem Encountered");
        return null;
        }
        
    
    }
    
    
    public static void query1() {
        Connection con = null;
        Statement stmt = null;
        try {
            Class.forName("org.sqlite.JDBC");
            con = DriverManager.getConnection("jdbc:sqlite:basketball.db");
            stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT MAX (pointsPG) pointsPG, name FROM stats");
            while (rs.next()){
                String pointsPG = rs.getString("pointsPG");
                String name = rs.getString("name");
              
                System.out.println(name + " scores the most points per game with: " + pointsPG + "PPG");
            }

            stmt.close();
            con.commit();
            con.close();
        } catch (Exception e) {
            System.err.println( e.getClass().getName() + ": " + e.getMessage());
        }
    }
    
    
    public static void query2() {
        Connection con = null;
        Statement stmt = null;
        try {
            Class.forName("org.sqlite.JDBC");
            con = DriverManager.getConnection("jdbc:sqlite:basketball.db");
            stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT Min (reboundsPG) reboundsPG, name FROM stats");
            while (rs.next()){
                String reboundsPG = rs.getString("reboundsPG");
                String name = rs.getString("name");
                System.out.println(name + " is the player who managed to acquire the least rebounds with: " + reboundsPG );
            }

            stmt.close();
            con.commit();
            con.close();
        } catch (Exception e) {
            System.err.println( e.getClass().getName() + ": " + e.getMessage());
        }
    }
    
    
    public static void query3() {
        Connection con = null;
        Statement stmt = null;
        try {
            Class.forName("org.sqlite.JDBC");
            con = DriverManager.getConnection("jdbc:sqlite:basketball.db");
            stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT MAX (wins) wins, teamname from team WHERE conference = 'East'");
            while (rs.next()){
                String teamname = rs.getString("teamname");
                String wins = rs.getString("wins");
                System.out.println("The" + teamname + " is the Eastern conference team with the most WINS with: " + wins );
            }

            stmt.close();
            con.commit();
            con.close();
        } catch (Exception e) {
            System.err.println( e.getClass().getName() + ": " + e.getMessage());
        }
    }
    
    
    public static void query4() {
        Connection con = null;
        Statement stmt = null;
        try {
            Class.forName("org.sqlite.JDBC");
            con = DriverManager.getConnection("jdbc:sqlite:basketball.db");
            stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT awardee_name from awards where MVPS>=1 AND NumofAllStars >3");
            while (rs.next()){
                String awardee_name = rs.getString("awardee_name");
                System.out.println(awardee_name + " is a player with more than 1 MVP & more than 3 All Stars.");
            }

            stmt.close();
            con.commit();
            con.close();
        } catch (Exception e) {
            System.err.println( e.getClass().getName() + ": " + e.getMessage());
        }
    }
    
    
    
    public static void query5() {
        Connection con = null;
        Statement stmt = null;
        try {
            Class.forName("org.sqlite.JDBC");
            con = DriverManager.getConnection("jdbc:sqlite:basketball.db");
            stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT name FROM player WHERE team_name = 'Golden State Warriors'");
            while (rs.next()){
                String name = rs.getString("name");
                System.out.println(name + " is a player that plays for the Golden State Warriors listed under this database.");
            }

            stmt.close();
            con.commit();
            con.close();
        } catch (Exception e) {
            System.err.println( e.getClass().getName() + ": " + e.getMessage());
        }
    }
    
    
    
    
    public static void query6() {
        Connection con = null;
        Statement stmt = null;
        try {
            Class.forName("org.sqlite.JDBC");
            con = DriverManager.getConnection("jdbc:sqlite:basketball.db");
            stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("Select x.name from player x, team y WHERE y.conference = 'East' AND y.teamName = x.team_name");
            while (rs.next()){
                String name = rs.getString("name");
                System.out.println(name + " is an Eastern conference player.");
            }

            stmt.close();
            con.commit();
            con.close();
        } catch (Exception e) {
            System.err.println( e.getClass().getName() + ": " + e.getMessage());
        }
    }
    
    
    
    
    public static void query7() {
        Connection con = null;
        Statement stmt = null;
        try {
            Class.forName("org.sqlite.JDBC");
            con = DriverManager.getConnection("jdbc:sqlite:basketball.db");
            stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT name FROM stats WHERE pointsPG>20");
            while (rs.next()){
                String name = rs.getString("name");
                System.out.println(name + " is a player that averages more than 20 Points per Game. ");
            }

            stmt.close();
            con.commit();
            con.close();
        } catch (Exception e) {
            System.err.println( e.getClass().getName() + ": " + e.getMessage());
        }
    }
    
    
    
    
    public static void query8() {
        Connection con = null;
        Statement stmt = null;
        try {
            Class.forName("org.sqlite.JDBC");
            con = DriverManager.getConnection("jdbc:sqlite:basketball.db");
            stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM stats WHERE pointsPG>15 AND assistsPG>=5");
            while (rs.next()){
                String statID = rs.getString("statID");
                String name = rs.getString("name");
                String pointsPG = rs.getString("pointsPG");
                String assistsPG = rs.getString("assistsPG");
                String reboundsPG = rs.getString("reboundsPG");
                String blocksPG = rs.getString("blocksPG");
                String stealsPG = rs.getString("stealsPG");
                
                
                System.out.println(name + ": " +pointsPG +"PPG , " +  assistsPG + "APG , " + reboundsPG  + "RPG , " + blocksPG  + " BPG, " + stealsPG  +" SPG");
            }

            stmt.close();
            con.commit();
            con.close();
        } catch (Exception e) {
            System.err.println( e.getClass().getName() + ": " + e.getMessage());
        }
    }
    
    
    
    
    public static void query9() {
        Connection con = null;
        Statement stmt = null;
        try {
            Class.forName("org.sqlite.JDBC");
            con = DriverManager.getConnection("jdbc:sqlite:basketball.db");
            stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT name, MAX(weight) weight from physicalprofile");
            while (rs.next()){
                String name = rs.getString("name");
                String weight = rs.getString("weight");
                System.out.println(name + " is the heaviest player listed, weight: " + weight );
            }

            stmt.close();
            con.commit();
            con.close();
        } catch (Exception e) {
            System.err.println( e.getClass().getName() + ": " + e.getMessage());
        }
    }
    
    
    
    public static void query10() {
        Connection con = null;
        Statement stmt = null;
        try {
            Class.forName("org.sqlite.JDBC");
            con = DriverManager.getConnection("jdbc:sqlite:basketball.db");
            stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT teamName,wins,MAX (losses) losses FROM team WHERE conference = 'West'");
            while (rs.next()){
                String teamName = rs.getString("teamName");
                String wins = rs.getString("wins");
                String losses = rs.getString("losses");
                System.out.println("The " + teamName + " is the western conference team with the most losses with: " + losses );
            }

            stmt.close();
            con.commit();
            con.close();
        } catch (Exception e) {
            System.err.println( e.getClass().getName() + ": " + e.getMessage());
        }
    }

    
    public static void main (String [] args ){
        basketball obj = new basketball ();
        obj.connectDB();
        Scanner sc = new Scanner(System.in);  // Create a Scanner object
        boolean running = true;
        System.out.println("Welcome to the NBA player statistics Database!");
        
        
        do{
            
            
            System.out.println("Enter a number from 1-10 from the selecting from the following queries list:");
            System.out.println("1 - Who averaged the most points per game NBAseason and how much did they average?");
            System.out.println("2 - Who averaged the least rebounds per game in the NBA season.");
            System.out.println("3 - Which team in the Eastern conference has the most wins and how many?");
            System.out.println("4 - List all players that have at least 1 MVP and 4+ Allstar appearances.");
            System.out.println("5 - List all players that play for the Golden State Warriors");
            System.out.println("6 - List all Eastern conference Players");
            System.out.println("7 - List all players who averaged more than 20 point per game in the NBA season");
            System.out.println("8 - List all players stats for those who averaged 15+ points and 5+ assists per game in the NBA season.");
            System.out.println("9 - Who is the heaviest player in the NBA?");
            System.out.println("10 - Which team in the Western conference has the lowest wins?");
            System.out.println("0 - Quit the Program");
            System.out.print("Query: ");
        
        
            
            int selection = sc.nextInt();
            if (selection == 0) {
                System.out.println("Quitting program...");
                running = false;
            } else if (selection == 1) {
                query1();
            } else if (selection == 2) {
                query2();
            } else if (selection == 3) {
                query3();
            } else if (selection == 4) {
                query4();
            } else if (selection == 5) {
                query5();
            } else if (selection == 6) {
                query6();
            } else if (selection == 7) {
                query7();
            } else if (selection == 8) {
                query8();
            } else if (selection == 9) {
                query9();
            } else if (selection == 10) {
                query10();
            } else {
                System.out.println("invalid input. Enter a number from 0-10");
            }
        } while(running != false);                        
    }
}
