
//Jake White




//package com.hascode.samples.jsoup;

import java.io.IOException;
import java.util.*;
import java.lang.*;

import org.jsoup.helper.Validate;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.jsoup.nodes.Element;

/*
Notes:


goal leaders: http://www.nhl.com/ice/playerstats.htm?fetchKey=20152ALLSASAll&sort=goals&viewName=summary
assist leaders: http://www.nhl.com/ice/playerstats.htm?fetchKey=20152ALLSASAll&sort=assists&viewName=summary
Point leaders: http://www.nhl.com/ice/playerstats.htm?fetchKey=20152ALLSASAll&sort=points&viewName=summary
Plus/Minus: http://www.nhl.com/ice/playerstats.htm?fetchKey=20152ALLSASAll&sort=plusMinus&viewName=summary
Penalty Minutes (PIM): http://www.nhl.com/ice/playerstats.htm?fetchKey=20152ALLSASAll&sort=penaltyMinutes&viewName=summary
Power Play Goals: http://www.nhl.com/ice/playerstats.htm?fetchKey=20152ALLSASAll&sort=powerPlayGoals&viewName=summary
Power Play Points: http://www.nhl.com/ice/playerstats.htm?fetchKey=20152ALLSASAll&sort=powerPlayPoints&viewName=summary
Short Handed Goals: http://www.nhl.com/ice/playerstats.htm?fetchKey=20152ALLSASAll&sort=shortHandedGoals&viewName=summary
Short Handed Points: http://www.nhl.com/ice/playerstats.htm?fetchKey=20152ALLSASAll&sort=shortHandedPoints&viewName=summary
Game Winning Goals: http://www.nhl.com/ice/playerstats.htm?fetchKey=20152ALLSASAll&sort=gameWinningGoals&viewName=summary
Overtime Goals: http://www.nhl.com/ice/playerstats.htm?fetchKey=20152ALLSASAll&sort=overtimeGoals&viewName=summary
Shots: http://www.nhl.com/ice/playerstats.htm?fetchKey=20152ALLSASAll&sort=shots&viewName=summary
Time On Ice Per game: http://www.nhl.com/ice/playerstats.htm?fetchKey=20152ALLSASAll&sort=avgTOIPerGame&viewName=summary
Shift # Per Game (avg): http://www.nhl.com/ice/playerstats.htm?fetchKey=20152ALLSASAll&sort=avgShiftsPerGame&viewName=summary


*/




public class nhl_top_individuals 
{
    public static void main(final String[] args) throws IOException 
    {

    /********************* Variables *********************/


        String statName = "empty";
        String statNameCase = "empty";
     
        
     


    /*************************** Text color manipulator variables ***************/

        String RESET = "\u001B[0m";        // called at end of string to reset to original text color
        String BLACK = "\u001B[30m";
        String RED = "\u001B[31m";         // called at begining of string to print text as red
        String GREEN = "\u001B[32m";
        String YELLOW = "\u001B[33m";
        String BLUE = "\u001B[34m";
        String PURPLE = "\u001B[35m";
        String CYAN = "\u001B[36m";
        String WHITE = "\u001B[37m";
    


    /******** Give User Input Options *****************************/
    

        System.out.print("\n");
        System.out.print(CYAN + "Availible statistic leaderboards: \n");
        System.out.print(WHITE + "      Goals (G)\n" + RESET);
        System.out.print(WHITE + "      Assists (A)\n" + RESET);
        System.out.print(WHITE + "      Points (Pts)\n" + RESET);
        System.out.print(WHITE + "      Plus Minus (PLMS)\n" + RESET);
        System.out.print(WHITE + "      Penalty Minutes (PIM)\n" + RESET);
        System.out.print(WHITE + "      Power Play Goals (PPG)\n" + RESET);
        System.out.print(WHITE + "      Power Play Points (PPP)\n" + RESET);
        System.out.print(WHITE + "      Short Handed Goals (SHG)\n" + RESET);
        System.out.print(WHITE + "      Short Handed Points (SHP)\n" + RESET);
        System.out.print(WHITE + "      Game Winning Goals (GW)\n" + RESET);
        System.out.print(WHITE + "      Overtime Goals (OT)\n" + RESET);
        System.out.print(WHITE + "      Shots (S)\n" + RESET);
        System.out.print(WHITE + "      Shotting Percentage (SP)\n" + RESET);
        System.out.print(WHITE + "      Time On Ice Per Game (TOI/GP)\n" + RESET);
        System.out.print(WHITE + "      Shifts Per Game (Shift/GP)\n" + RESET);
        System.out.print('\n');

    /************* Recieve User Info *********************/
    

        System.out.print("Enter statistic value: ");
        Scanner statScanner = new Scanner(System.in);
        statNameCase = statScanner.nextLine();
        statName = statNameCase.toLowerCase();
        System.out.print('\n');
    
    /**************************************************/


        if (statName.equals("goals") || statName.equals("g"))
        {
            //Document doc = Jsoup.connect("http://www.nhl.com/ice/playerstats.htm?fetchKey=20152ALLSASAll&sort=goals&viewName=summary").userAgent("Mozilla").timeout(6000).get();
            //Elements firstPlayer = doc.select("div#pageWrapper.PlayerStats div#pageBody div#fullPage div.contentBlock table.data.stats tbody tr td a");
            //Elements firstPlayer = doc.select("div#pageWrapper.PlayerStats table.data.stats > tbody > tr > td > a");
            //Elements firstPlayer = doc.select("div#pageWrapper.PlayerStats div#pageBody div#fullPage div.contentBlock table.data.stats tbody tr td");
            //String goalString = firstPlayer.get(5).text();
            //int goalInt = Integer.parseInt(goalString);
            //String playerNameTest = firstPlayer.get(1).text();



            //System.out.print(playerNameTest + "     " + goalInt + "\n");
            //System.out.print('\n');

            
            Document doc = Jsoup.connect("http://www.nhl.com/ice/playerstats.htm?fetchKey=20152ALLSASAll&sort=goals&viewName=summary").userAgent("Mozilla").timeout(6000).get();
            System.out.print("Leading Goal Scorers:\n");
            int i = 1;
            String row = "tr";
            while(i < 11 )
            {
                
                Elements player = doc.select("div#pageWrapper.PlayerStats div#pageBody div#fullPage div.contentBlock table.data.stats tbody " + row + " td");
                String goalString = player.get(5).text();
                int goalInt = Integer.parseInt(goalString);
                String playerName = player.get(1).text();

                System.out.print("      " + i + ")      " + playerName + "     " + goalInt + "\n");

                String nextRow = "+ tr";
                row = row + nextRow;
                i = i + 1;
            }             


        }
        else if (statName.equals("assists") || statName.equals("a"))
        {
            Document doc = Jsoup.connect("http://www.nhl.com/ice/playerstats.htm?fetchKey=20152ALLSASAll&sort=assists&viewName=summary").userAgent("Mozilla").timeout(6000).get();
            System.out.print("Assist Leaders:\n");
            int i = 1;
            String row = "tr";
            while(i < 11 )
            {
                
                Elements player = doc.select("div#pageWrapper.PlayerStats div#pageBody div#fullPage div.contentBlock table.data.stats tbody " + row + " td");
                String goalString = player.get(6).text();
                int goalInt = Integer.parseInt(goalString);
                String playerName = player.get(1).text();

                System.out.print("      " + i + ")      " + playerName + "     " + goalInt + "\n");

                String nextRow = "+ tr";
                row = row + nextRow;
                i = i + 1;
            }             
            
        }
        else if (statName.equals("points") || statName.equals("pts"))
        {
            Document doc = Jsoup.connect("http://www.nhl.com/ice/playerstats.htm?fetchKey=20152ALLSASAll&sort=points&viewName=summary").userAgent("Mozilla").timeout(6000).get();
            System.out.print("Point Leaders:\n");
            int i = 1;
            String row = "tr";
            while(i < 11 )
            {
                
                Elements player = doc.select("div#pageWrapper.PlayerStats div#pageBody div#fullPage div.contentBlock table.data.stats tbody " + row + " td");
                String goalString = player.get(7).text();
                int goalInt = Integer.parseInt(goalString);
                String playerName = player.get(1).text();

                System.out.print("      " + i + ")      " + playerName + "     " + goalInt + "\n");

                String nextRow = "+ tr";
                row = row + nextRow;
                i = i + 1;
            }    
        }
        else if (statName.equals("plus minus") || statName.equals("plms"))
        {
            Document doc = Jsoup.connect("http://www.nhl.com/ice/playerstats.htm?fetchKey=20152ALLSASAll&sort=plusMinus&viewName=summary").userAgent("Mozilla").timeout(6000).get();
            System.out.print("Plus Minus Leaders:\n");
            int i = 1;
            String row = "tr";
            while(i < 11 )
            {
                
                Elements player = doc.select("div#pageWrapper.PlayerStats div#pageBody div#fullPage div.contentBlock table.data.stats tbody " + row + " td");
                String goalString = player.get(8).text();
                //int goalInt = Integer.parseInt(goalString);
                String playerName = player.get(1).text();

                System.out.print("      " + i + ")      " + playerName + "     " + goalString + "\n");

                String nextRow = "+ tr";
                row = row + nextRow;
                i = i + 1;
            }    
        }
        else if (statName.equals("penalty minuts") || statName.equals("pim"))
        {
            Document doc = Jsoup.connect("http://www.nhl.com/ice/playerstats.htm?fetchKey=20152ALLSASAll&sort=penaltyMinutes&viewName=summary").userAgent("Mozilla").timeout(6000).get();
            System.out.print("Penalty Minute Leaders:\n");
            int i = 1;
            String row = "tr";
            while(i < 11 )
            {
                
                Elements player = doc.select("div#pageWrapper.PlayerStats div#pageBody div#fullPage div.contentBlock table.data.stats tbody " + row + " td");
                String goalString = player.get(9).text();
                //int goalInt = Integer.parseInt(goalString);
                String playerName = player.get(1).text();

                System.out.print("      " + i + ")      " + playerName + "     " + goalString + "\n");

                String nextRow = "+ tr";
                row = row + nextRow;
                i = i + 1;
            }    
        }
        else if (statName.equals("power play goals") || statName.equals("ppg"))
        {
            Document doc = Jsoup.connect("http://www.nhl.com/ice/playerstats.htm?fetchKey=20152ALLSASAll&sort=powerPlayGoals&viewName=summary").userAgent("Mozilla").timeout(6000).get();
            System.out.print("Power Play Goal Leaders:\n");
            int i = 1;
            String row = "tr";
            while(i < 11 )
            {
                
                Elements player = doc.select("div#pageWrapper.PlayerStats div#pageBody div#fullPage div.contentBlock table.data.stats tbody " + row + " td");
                String goalString = player.get(10).text();
                //int goalInt = Integer.parseInt(goalString);
                String playerName = player.get(1).text();

                System.out.print("      " + i + ")      " + playerName + "     " + goalString + "\n");

                String nextRow = "+ tr";
                row = row + nextRow;
                i = i + 1;
            }    
        }
        else if (statName.equals("power play points") || statName.equals("ppp"))
        {
            Document doc = Jsoup.connect("http://www.nhl.com/ice/playerstats.htm?fetchKey=20152ALLSASAll&sort=powerPlayPoints&viewName=summary").userAgent("Mozilla").timeout(6000).get();
            System.out.print("Power Play Point Leaders:\n");
            int i = 1;
            String row = "tr";
            while(i < 11 )
            {
                
                Elements player = doc.select("div#pageWrapper.PlayerStats div#pageBody div#fullPage div.contentBlock table.data.stats tbody " + row + " td");
                String goalString = player.get(11).text();
                //int goalInt = Integer.parseInt(goalString);
                String playerName = player.get(1).text();

                System.out.print("      " + i + ")      " + playerName + "     " + goalString + "\n");

                String nextRow = "+ tr";
                row = row + nextRow;
                i = i + 1;
            }    
        }
        else if (statName.equals("short handed goals") || statName.equals("shg"))
        {
            Document doc = Jsoup.connect("http://www.nhl.com/ice/playerstats.htm?fetchKey=20152ALLSASAll&sort=shortHandedGoals&viewName=summary").userAgent("Mozilla").timeout(6000).get();
            System.out.print("Short Handed Goal Leaders:\n");
            int i = 1;
            String row = "tr";
            while(i < 11 )
            {
                
                Elements player = doc.select("div#pageWrapper.PlayerStats div#pageBody div#fullPage div.contentBlock table.data.stats tbody " + row + " td");
                String goalString = player.get(12).text();
                //int goalInt = Integer.parseInt(goalString);
                String playerName = player.get(1).text();

                System.out.print("      " + i + ")      " + playerName + "     " + goalString + "\n");

                String nextRow = "+ tr";
                row = row + nextRow;
                i = i + 1;
            }    
        }
        else if (statName.equals("short handed points") || statName.equals("shp"))
        {
            Document doc = Jsoup.connect("http://www.nhl.com/ice/playerstats.htm?fetchKey=20152ALLSASAll&sort=shortHandedPoints&viewName=summary").userAgent("Mozilla").timeout(6000).get();
            System.out.print("Short Handed Point Leaders:\n");
            int i = 1;
            String row = "tr";
            while(i < 11 )
            {
                
                Elements player = doc.select("div#pageWrapper.PlayerStats div#pageBody div#fullPage div.contentBlock table.data.stats tbody " + row + " td");
                String goalString = player.get(13).text();
                //int goalInt = Integer.parseInt(goalString);
                String playerName = player.get(1).text();

                System.out.print("      " + i + ")      " + playerName + "     " + goalString + "\n");

                String nextRow = "+ tr";
                row = row + nextRow;
                i = i + 1;
            }    
        }       
        else if (statName.equals("game winning goals") || statName.equals("gw"))
        {
            Document doc = Jsoup.connect("http://www.nhl.com/ice/playerstats.htm?fetchKey=20152ALLSASAll&sort=gameWinningGoals&viewName=summary").userAgent("Mozilla").timeout(6000).get();
            System.out.print("Game Winning Goal Leaders:\n");
            int i = 1;
            String row = "tr";
            while(i < 11 )
            {
                
                Elements player = doc.select("div#pageWrapper.PlayerStats div#pageBody div#fullPage div.contentBlock table.data.stats tbody " + row + " td");
                String goalString = player.get(14).text();
                //int goalInt = Integer.parseInt(goalString);
                String playerName = player.get(1).text();

                System.out.print("      " + i + ")      " + playerName + "     " + goalString + "\n");

                String nextRow = "+ tr";
                row = row + nextRow;
                i = i + 1;
            }    
        }   
        else if (statName.equals("overtime goals") || statName.equals("ot"))
        {
            Document doc = Jsoup.connect("http://www.nhl.com/ice/playerstats.htm?fetchKey=20152ALLSASAll&sort=overtimeGoals&viewName=summary").userAgent("Mozilla").timeout(6000).get();
            System.out.print("Overtime Goal Leaders:\n");
            int i = 1;
            String row = "tr";
            while(i < 11 )
            {
                
                Elements player = doc.select("div#pageWrapper.PlayerStats div#pageBody div#fullPage div.contentBlock table.data.stats tbody " + row + " td");
                String goalString = player.get(15).text();
                //int goalInt = Integer.parseInt(goalString);
                String playerName = player.get(1).text();

                System.out.print("      " + i + ")      " + playerName + "     " + goalString + "\n");

                String nextRow = "+ tr";
                row = row + nextRow;
                i = i + 1;
            }    
        } 
        else if (statName.equals("shots") || statName.equals("s"))
        {
            Document doc = Jsoup.connect("http://www.nhl.com/ice/playerstats.htm?fetchKey=20152ALLSASAll&sort=shots&viewName=summary").userAgent("Mozilla").timeout(6000).get();
            System.out.print("Shot Total Leaders:\n");
            int i = 1;
            String row = "tr";
            while(i < 11 )
            {
                
                Elements player = doc.select("div#pageWrapper.PlayerStats div#pageBody div#fullPage div.contentBlock table.data.stats tbody " + row + " td");
                String goalString = player.get(16).text();
                //int goalInt = Integer.parseInt(goalString);
                String playerName = player.get(1).text();

                System.out.print("      " + i + ")      " + playerName + "     " + goalString + "\n");

                String nextRow = "+ tr";
                row = row + nextRow;
                i = i + 1;
            }    
        }    
        else if (statName.equals("time on ice per game") || statName.equals("toi/gp"))
        {
            Document doc = Jsoup.connect("http://www.nhl.com/ice/playerstats.htm?fetchKey=20152ALLSASAll&sort=avgTOIPerGame&viewName=summary").userAgent("Mozilla").timeout(6000).get();
            System.out.print("Average Time On Ice Per Game Leaders:\n");
            int i = 1;
            String row = "tr";
            while(i < 11 )
            {
                
                Elements player = doc.select("div#pageWrapper.PlayerStats div#pageBody div#fullPage div.contentBlock table.data.stats tbody " + row + " td");
                String goalString = player.get(18).text();
                //int goalInt = Integer.parseInt(goalString);
                String playerName = player.get(1).text();

                System.out.print("      " + i + ")      " + playerName + "     " + goalString + " min\n");

                String nextRow = "+ tr";
                row = row + nextRow;
                i = i + 1;
            }    
        }     
        else if (statName.equals("shifts per game") || statName.equals("shift/gp"))
        {
            Document doc = Jsoup.connect("http://www.nhl.com/ice/playerstats.htm?fetchKey=20152ALLSASAll&sort=avgShiftsPerGame&viewName=summary").userAgent("Mozilla").timeout(6000).get();
            System.out.print("Average Shift Numbers Per Game Leaders:\n");
            int i = 1;
            String row = "tr";
            while(i < 11 )
            {
                
                Elements player = doc.select("div#pageWrapper.PlayerStats div#pageBody div#fullPage div.contentBlock table.data.stats tbody " + row + " td");
                String goalString = player.get(19).text();
                //int goalInt = Integer.parseInt(goalString);
                String playerName = player.get(1).text();

                System.out.print("      " + i + ")      " + playerName + "     " + goalString + "\n");

                String nextRow = "+ tr";
                row = row + nextRow;
                i = i + 1;
            }    
        }                                     
        else
        {
            System.out.print("Statistic not recognized\n");
            System.exit(0);
        }


        System.out.print('\n');



    }
}

























