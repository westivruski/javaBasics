package com.wesleyHo;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Main {
    private static Map<HeavenlyBody.Key, HeavenlyBody> solarSystem = new HashMap<>();
    private static Set<HeavenlyBody> planets = new HashSet<>();

    public static void main(String[] args) {
        HeavenlyBody temp = new Planet("Mercury", 88);
        solarSystem.put(temp.getKey(), temp);
        planets.add(temp);

        HeavenlyBody tempMoon = new Moon ("Moon of Mercury", 27);
        solarSystem.put(tempMoon.getKey(), tempMoon);
        temp.addSatelite(tempMoon);
        tempMoon = new Moon("Moon2", 27);
        solarSystem.put(tempMoon.getKey(), tempMoon);
        temp.addSatelite(tempMoon);
//here we are adding moons as part of the Mercury planet , if we addMoon after new HeavenlyBody(planet) that moon will be part of the new object

        temp = new Planet("Venus", 225);
        solarSystem.put(temp.getKey(), temp);
        planets.add(temp);
        temp = new Planet("Pluto", 99);
        solarSystem.put(temp.getKey(), temp);
        planets.add(temp);
        temp = new Planet("Earth", 365);
        solarSystem.put(temp.getKey(), temp);
        planets.add(temp);
        tempMoon = new Moon("Moon", 27);
        solarSystem.put(tempMoon.getKey(), tempMoon);
        temp.addSatelite(tempMoon);




        System.out.println("printing planets yoo");
        for(HeavenlyBody planet : planets){
            System.out.println("\t"+planet.getKey());
        }

        HeavenlyBody pluto = new DwarfPLanet("Pluto", 100);
        planets.add(pluto);

        System.out.println("printing planets yoo");
        for(HeavenlyBody planet : planets){
            System.out.println(planet);
            //  System.out.println("\t"+planet.getKey()+planet.getOrbitalPeriod());
        }

       // some printing codes
       // HeavenlyBody body = solarSystem.get("Mars");
        HeavenlyBody body = solarSystem.get(HeavenlyBody.makeKey("Mercury", HeavenlyBody.BodyTypes.PLANET));
        System.out.println("Moons of "+body.getKey());
        for(HeavenlyBody mMoon : body.getSatelites()){
            System.out.println(mMoon.getKey());
        }



        //creating new hashset with all the moons there
        Set<HeavenlyBody> moons = new HashSet<>();
        for(HeavenlyBody planet : planets){
            moons.addAll(planet.getSatelites());
        }
        System.out.println("printing all moons yoo");
        for(HeavenlyBody moon : moons){
            System.out.println("\t"+moon.getKey());
        }

        /*
        //this is for the hashcode duplicate thing nerd T made up
        Object o = new Object();
        o.equals(o);
        "venus".equals("");
         */
        HeavenlyBody earth1 = new Planet("Earth", 365);
        HeavenlyBody earth2 = new Planet("Earth", 365);

        //check if check is symetric or not should return both true
        System.out.println(earth1.equals(earth2));
        System.out.println(earth2.equals(earth1));
        //check should return false both
        System.out.println(earth1.equals(pluto));
        System.out.println(pluto.equals(earth1));

        solarSystem.put(pluto.getKey(), pluto);
        System.out.println(solarSystem.get(HeavenlyBody.makeKey("Pluto", HeavenlyBody.BodyTypes.PLANET)));
        System.out.println(solarSystem.get(HeavenlyBody.makeKey("Pluto", HeavenlyBody.BodyTypes.DWARF_PLANET)));

        System.out.println();
        System.out.println("This is the solar system : ");
        for(HeavenlyBody heavenlyBody : solarSystem.values()) {
            System.out.println(heavenlyBody);
        }

   }

}
