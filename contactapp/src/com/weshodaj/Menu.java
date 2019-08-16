package com.weshodaj;

import java.util.Scanner;

public class Menu {
    public Menu(){
    }

    public static void showWelcomeMenu(){
        System.out.println("*****************************************************");
        System.out.println("         Kjo eshte menu kryesore e ContaktApp       .");
        System.out.println("Zgjidhni nje nga opsionet e meposhteme.");
        System.out.println("1. Per te hyre ne menune e Kontakteve");
        System.out.println("2. per te hyre ne menune e Listave");
        System.out.println("0. per te mbyllur applikacionin");
        System.out.println("*****************************************************");
    }
    public static void showContactMenu() {
        System.out.println("Krijoni nje Liste per te shtuar kontaktet tuaja. ");
        System.out.println("1. per krijuar nje kontakt te ri");
        System.out.println("2. per fshire  nje kontakt ekzistues");
        System.out.println("3. per te pare kontaktet e krijuar");


    }


    public static void showListsMenu(){
        System.out.println("Krijoni nje Liste per te shtuar kontaktet tuaja. ");
        System.out.println("1. per krijuar nje Liste te re");
        System.out.println("2. per fshire  nje Liste ekzistuese");
        System.out.println("3. per te pare listat e krijuara");
    }

    public static int selectMenu(){
        Scanner in = new Scanner(System.in);
        return in.nextInt();
    }

}

