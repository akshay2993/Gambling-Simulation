package com.bridgelabz.Java_Day7;

import java.util.Arrays;
import java.util.Scanner;

public class GamblingSimulator {
    static final int WON = 1;
    static final int STAKE = 100;
    static final int BET_PER_GAME = 1;
    static final int DAILY_LIMIT = 50;
    static int winAmount = 0;
    static int lossAmount = 0;
    static int totalWinAmount = 0;
    static int totalLossAmount = 0;
    static int daysWon = 0;
    static int daysLost = 0;
    static int luckiestDay;
    static int unLuckiestDay;

    public static void playGame() {
        int result = (int)Math.floor(Math.random()*2)+1;
        if(result == WON){
            System.out.println("You Won!");
            winAmount += BET_PER_GAME;
            totalWinAmount += BET_PER_GAME;
        }
        else {
            System.out.println("You Lost!");
            lossAmount += BET_PER_GAME;
            totalLossAmount += BET_PER_GAME;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Welcome to Gambling Simulation: ");
        System.out.println("Press any key to start: ");
        String start = sc.nextLine();

        if (!(start.length() == 0)){
            System.out.println("For 20 days: ");
            for(int i = 1; i <= 20; i++){
                System.out.println("Day: "+ i);
                winAmount = 0;
                lossAmount = 0;
                while (winAmount != DAILY_LIMIT && lossAmount != DAILY_LIMIT) {
                    playGame();
                    System.out.println(totalWinAmount);
                    System.out.println(totalLossAmount);
                }
                if (winAmount > lossAmount){
                    daysWon ++;
                }else {
                    daysLost ++;
                }
                System.out.println("Done for the day!");
                System.out.println("Total win amount: "+totalWinAmount);
                System.out.println("Total loss amount: "+totalLossAmount);
            }
            System.out.println("Days won: "+daysWon);
            System.out.println("Days lost: " +daysLost);
        }
    }
}
