package com.wesleyh;

import java.util.HashMap;
import java.util.Map;


public class Location {
    private final int locationID;
    private final String description;
    private final Map<String, Integer> exits;

    public Location(int locationID, String description, Map<String, Integer> exits) {
        this.locationID = locationID;
        this.description = description;
        //this.exits = new HashMap<String, Integer>(); // we added into parameters Map so we dont need this now (meaning its deleted after)
        if(exits != null) {
            this.exits = new HashMap<String, Integer>(exits);//this will make class fully immutable so meaning we cannot edit it from the main class is as we set it :D
        }else{
            this.exits = new HashMap<String, Integer>(); //make it with empty rather than exits so its == null or smthing like that
        }
        //exits with key Q and value 0 is used anytime to quit so we add it here
        this.exits.put("Q", 0);

        //immutable class into the constructor, set it once and never again that is why constructor, so what we gonna do is
        //accept map object
    }

  /*  public void addExit(String direction, int location) {
        exits.put(direction, location);
    }*/
    public int getLocationID() {
        return locationID;
    }

    public String getDescription() {
        return description;
    }

  /*  @Override
    public String toString() {
        return "Location{" +
                "locationID=" + locationID +
                ", description='" + description + '\'' +
                '}';
    }
*/
  @Override
  public String toString() {
      return locationID +" " + description +".";
  }


    public Map<String, Integer> getExits() {
        return new HashMap<String, Integer>(exits);
    }
}
