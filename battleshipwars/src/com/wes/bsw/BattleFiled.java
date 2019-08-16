package com.wes.bsw;

import java.util.Random;
import java.util.Scanner;

public class BattleFiled {
    private int row = 10;
    private int colum = 10;
    private int row1 = 10;
    private int colum1 = 10;
    private int myShips = 2;
    private int pcShips = 2;
    private int[][] field1 = new int[row1][colum1];
    private int[][] field = new int[row][colum];
    Scanner sc = new Scanner(System.in);
    //private Object Random;


    public int getMyShips() {
        return myShips;
    }

    public int getPcShips() {
        return pcShips;
    }

    public void showField() {

        for (int i = 1; i < 10; i++) {
            System.out.print("\t" + i + "\t\t");
        }
        System.out.println("\n______________________________");
        for (int row = 1; row < field.length; row++) {
            System.out.print(row);
            for (int colum = 1; colum < field[row].length; colum++) {
                if (field[row][colum] == 1) {
                    System.out.print("\t0\t\t");
                } else if (field[row][colum] == 2) {
                    System.out.print("\t!\t\t");
                } else if (field[row][colum] == 3) {
                    System.out.print("\tx\t\t");
                } else if (field[row][colum] == 0) {
                    System.out.print("\t-\t\t");
                }
            }
            System.out.println("");
            System.out.println("");
        }
        System.out.println("______****FRONT LINE****_______");
        for (int row1 = 1; row1 < field1.length; row1++) {
            System.out.print(row1);
            for (int colum1 = 1; colum1 < field1[row1].length; colum1++) {
                if (field1[row1][colum1] == 0 || field1[row1][colum1] == 1) {
                    System.out.print("\t-\t\t");
                } else if (field1[row1][colum1] == 2) {
                    System.out.print("\t!\t\t");
                } else if (field1[row1][colum1] == 3) {
                    System.out.print("\tx\t\t");
                }
            }
            System.out.println("");
            System.out.println("");
        }
    }

    public void placeBS() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Place your battleship 1, enter your coordinates below :");
        pickPosition();
        System.out.println("Place your battleship 2, enter your coordinates below :");
        pickPosition();
        System.out.println("Pc is randomly seting their placement");
        pickPCBS();
        pickPCBS();
    }

    public void pickPCBS() {
        int low = 1;
        int high = 10;
        Random RR = new Random();
        row1 = RR.nextInt(high - low) + low;
        colum1 = RR.nextInt(high - low) + low;
        while (field1[row1][colum1] == 1) {
            row1 = RR.nextInt(high - low) + low;
            colum1 = RR.nextInt(high - low) + low;
        }
        field1[row1][colum1] = 1;
    }

    public void pickPosition() {
        System.out.println("row and colum");
        row = takeCoordinate();
        colum = takeCoordinate();
        while (field[row][colum] == 1) {
                System.out.println("fusni kordinata te tjera te pazena");
                row = takeCoordinate();
                colum = takeCoordinate();
        }
        field[row][colum] = 1;
    }

    public void playerShoot() {

        System.out.println("Zgjidhni koordinatat  ku do te gjuani predhen 1 me poshte :");
       // row1 = takeCoordinate() ;
        //  System.out.println("Zgjidhni koordinaten y ku do te gjuani predhen 1 me poshte :");
        // colum1 = takeCoordinate() ;
        boolean isNumber = false;
        String input;


        while(!isNumber){
            try {
                input = sc.next();
                int  intValue = Integer.parseInt(input);
                row1 = Integer.parseInt(input);
                input = sc.next();
                int  intValue1 = Integer.parseInt(input);
                colum1 =  Integer.parseInt(input);

                isNumber = true;
            }catch (NumberFormatException e) {
                System.out.println("Input is not a valid integer");
            }
        }






        if (field1[row1][colum1] == 1) {
            System.out.println("qellove me sukses");
            field1[row1][colum1] = 2;
            pcShips--;
        } else if (field1[row1][colum1] == 0) {
            System.out.println("dole huq");
            field1[row1][colum1] = 3;
        }
    }

    public void PcShoot() {
        System.out.println("Pc is picking his shooting bomb cordinates");
        int low = 1;
        int high = 3;
        Random RR = new Random();
        row = RR.nextInt(high - low) + low;
        colum = RR.nextInt(high - low) + low;
        if (field[row][colum] == 1) {
            System.out.println("Kompjuteri ju goditi");
            field[row][colum] = 2;
           myShips--;
        } else if (field[row][colum] == 0){
            field[row][colum] = 3;
        System.out.println("Kompjuteri doli huq");
    }
    }


    public boolean checkWinner() {
        if (pcShips==0) {
            System.out.println("ju fituar");
            return true;
        }else if(myShips==0){
            System.out.println("Ju humbet");
        }
        return false;
    }



    public void pcWin() {
        while (field[row][colum] != 0 && field[row][colum] != 1 ) {
            System.out.println("Pc shooting, take cover");
            PcShoot();
            break;
        }
        System.out.println("Pc won you lost hahah");
    }

    private int takeCoordinate(){
        String temp = sc.next();
        String check = "123";
        while (!check.contains(temp)){
            System.out.println("Shkruani nje koordinate nga 1 ne 3");
            temp = sc.next();
        }
        return Integer.parseInt(temp);
    }
}








