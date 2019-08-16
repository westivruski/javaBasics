package com.wesleyh;

import java.util.HashMap;
import java.util.Map;

public class MapTest {

    public static void main (String[] args){


        //trying some stuff with maps with bigT
        //we define maps and hashmaps(not sorted map)
        Map<String, String> languages = new HashMap<>();
        //we use .put to add Key, and valuses to the map we created
        languages.put("Java", "im learning this java thing");
        languages.put("python", "I will get ahead of python soon");
        languages.put("C++", "I think i know this C++ guy");
        languages.put("C", "i think this and C++ are friends");
        languages.put("C#", "its like C or C++ but sharper i guess");
        languages.put("Javaaaaaaa", "Its cool but not so cool");
        for(String key: languages.keySet()){
            System.out.println(key+" "+ languages.get(key));
        }

        System.out.println("__________________________________________________________________");
        System.out.println("__________________________________________________________________");

        //we use .remove to remove items using the key we defined wen putting it there
        languages.remove("C++");

        //here we replace the keys and values
        languages.replace("python","i dont think it has to do with a snake");
        //or we can use this other method new value old value
        languages.replace("Java","im learning this java thing", "this is the string containing newValue");
        for(String key: languages.keySet()){
            System.out.println(key+" "+ languages.get(key));
        }
    }
}
