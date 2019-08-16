package com.wesleyh;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    private static Map<Integer, Location> locations = new HashMap<>();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
/*
       this is commented for immutable classes ok?
        locations.put(0, new Location(0, "You are sitting in front of a computer learning Java",tempExit));
        locations.put(1, new Location(1, "You are standing at the end of a road before a small brick building",tempExit));
        locations.put(2, new Location(2, "You are at the top of a hill",tempExit));
        locations.put(3, new Location(3, "You are inside a building, a well house for a small spring",tempExit));
        locations.put(4, new Location(4, "You are in a valley beside a stream",tempExit));
        locations.put(5, new Location(5, "You are in the forest",tempExit));
*/

/*
        //using toString method to override the default string output and use the for loop to iterate and print the values of the map
        for(int i: locations.keySet()){
            System.out.println(locations.get(i,tempExit));
        }
*/
        //creating temporally map (this is created after for immutable class
        Map<String, Integer> tempExit = new HashMap<String, Integer>();
        locations.put(0, new Location(0, "You are sitting in front of a computer learning Java",tempExit));

        tempExit = new HashMap<String, Integer>();
        tempExit.put("W",2);
        tempExit.put("E",3);
        tempExit.put("S",4);
        tempExit.put("N",5);
        locations.put(1, new Location(1, "You are standing at the end of a road before a small brick building",tempExit));

        tempExit = new HashMap<String, Integer>(); // adding this new hashmap every time
        tempExit.put("N",5);
        locations.put(2, new Location(2, "You are at the top of a hill",tempExit));

        tempExit = new HashMap<String, Integer>();
        tempExit.put("W",1);
        locations.put(3, new Location(3, "You are inside a building, a well house for a small spring",tempExit));

        tempExit = new HashMap<String, Integer>();
        tempExit.put("N",1);
        tempExit.put("W",2);
        locations.put(4, new Location(4, "You are in a valley beside a stream",tempExit));

        tempExit = new HashMap<String, Integer>();
        tempExit.put("S",1);
        tempExit.put("W",2);
        locations.put(5, new Location(5, "You are in the forest",tempExit));

        Map<String, String> vocabulary = new HashMap<>();
        vocabulary.put("QUIT", "Q");
        vocabulary.put("NORTH", "N");
        vocabulary.put("SOUTH", "S");
        vocabulary.put("EAST", "E");
        vocabulary.put("WEST", "W");



     /*   //setting this values based on the map witch is specific
        locations.get(1).addExit("W",2);
        locations.get(1).addExit("E",3);
        locations.get(1).addExit("S",4);
        locations.get(1).addExit("N",5);
        //this was added into location class since it it true to quit every time
        // locations.get(1).addExit("Q",0);

        locations.get(2).addExit("N",5);

        locations.get(3).addExit("W",1);

        locations.get(4).addExit("N",1);
        locations.get(4).addExit("W",2);

        locations.get(5).addExit("S",1);
        locations.get(5).addExit("W",2);

        this was added first than replaced because bigT decided to show us immutable classes

        */



        //starting from 1 ofc
        int loc = 1;
        while(true) {                                               //loops through letters N W S E Q cant type nothing else and returns available letters each time
            System.out.println(locations.get(loc).getDescription());
            if(loc==0){               //breaking if typed 0
                break;
            }
            Map<String, Integer> exits = locations.get(loc).getExits();  //matching the map from location class to the input and back to locations in this class
            System.out.println("Available exits for you are man : ");      //printing out available letter you can type
            for(String exit : exits.keySet()){
                System.out.print(exit+",");
            }
            System.out.println();

            String direction = sc.nextLine().toUpperCase();   //some awesome code right here yoo!!!!!!
            if(direction.length() >1) {  ///first if length > 1 take Q W E S as input
                String[] words = direction.split(" "); // take an array of strings and split each input you type when space is pressed
                for(String word : words) {                     //iterate through the words array and find words we input splitted by split method
                    if(vocabulary.containsKey(word)){          //if vocabulary(we created it for EAST WEST NORTH SOUTH) as keywords, contains one of those from input
                        direction = vocabulary.get(word);      //match input with the word and get back to the main code
                        break;                                 //needs to break manually i guess
                    }
                }
            }

            if(exits.containsKey(direction)){
             loc = exits.get(direction);
            }else{                                             //if none of key typed nope nope forever
                System.out.println("NOPE NOPE");
            }
        }

    }
}
