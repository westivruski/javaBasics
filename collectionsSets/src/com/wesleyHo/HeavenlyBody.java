package com.wesleyHo;

import java.util.Set;
import java.util.HashSet;

public class HeavenlyBody {
   // private final String name;                we comment these because we added them
  //  private final BodyTypes bodyType;          at the inner class
    private final Key key;
    private final double orbitalPeriod;
    private final Set<HeavenlyBody> satelites;



    public enum BodyTypes {
        STAR,
        PLANET,
        DWARF_PLANET,
        MOON,
        COMET,
        ASTEROID
    }

    /* we gonna make this but with enum
    public static final int STAR = 1;
    public static final int PLANET = 1;
    public static final int MOON = 1;
    public static final int COMET = 1;
    public static final int ASTEROID = 1;
    public static final int DWARF_PLANET = 1;
*/
    public HeavenlyBody(String name, double orbitalPeriod, BodyTypes bodyType) {
       // this.name = name;
        this.key = new Key(name, bodyType);
        this.orbitalPeriod = orbitalPeriod;
        this.satelites = new HashSet<>();
     //   this.bodyType = bodyType;
    }


    /*
    public String getName() {
        return name;
    }
    public BodyTypes getBodyType() {
        return bodyType;
    }
    */

    public Key getKey() {
        return key;
    }

    public double getOrbitalPeriod() {
        return orbitalPeriod;
    }



    public boolean addSatelite(HeavenlyBody moon) {
        return this.satelites.add(moon);
    }

    public Set<HeavenlyBody> getSatelites() {
        return new HashSet<>(this.satelites);
    }


    // this is some hashcode to not allow this duplicates on HashMaps
    @Override
    public final boolean equals (Object obj) {
        if (this == obj){
            return true;
        }

        if(obj instanceof HeavenlyBody){
            HeavenlyBody theObject = (HeavenlyBody) obj;
            return this.key.equals(theObject.getKey());
         //   if(this.name.equals(theObject.getName())) {           this was commented out later after the nested class was added i dont know why dont ack
         //         return this.bodyType == theObject.getBodyType();
         //   }
        }
        return false;
    }


    //some wired spells here from nerdy bigT
    @Override
   public final int hashCode() {
       // return this.name.hashCode() +57 +this.bodyType.hashCode(); also this was replaced idc :(
        return this.key.hashCode();
    }

    public static Key makeKey(String name, BodyTypes bodyTypes) {
        return new Key(name, bodyTypes);
    }

    @Override
    public String toString() {
        return this.key.name + ": " + this.key.bodyType + "," + this.orbitalPeriod;
    }

    public static final class Key {
        private String name;
        private BodyTypes bodyType;

        private Key(String name, BodyTypes bodyType){
            this.name = name;
            this.bodyType = bodyType;
        }
        public String getName(){
            return name;
        }
        public BodyTypes getBodyType(){
            return bodyType;
        }

        @Override
        public int hashCode() {
            return this.name.hashCode() + 57 + this.bodyType.hashCode();
        }

        @Override
        public boolean equals(Object obj) {
            Key key = (Key) obj;
            if(this.name.equals(key.getName())) {
                return (this.bodyType == key.getBodyType());
            }
            return false;
        }

        @Override
        public String toString() {
            return this.name + " " + this.bodyType;
        }
    }
}
