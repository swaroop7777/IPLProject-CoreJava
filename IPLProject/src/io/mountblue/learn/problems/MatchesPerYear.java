package io.mountblue.learn.problems;
import io.mountblue.learn.resources.ReadDataAndReturnList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MatchesPerYear {

    public void getAnswer() {
        ReadDataAndReturnList theMatchesUtility = new ReadDataAndReturnList();
        List<String> theListOfMatches = theMatchesUtility.readData("matches.csv");
        Map<String,Integer> theMatchCountPerSeason=new HashMap<>();
        String[][] theSplitMatch=new String[1][];
        for (String eachMatch : theListOfMatches) {
            //take each match and split to get a 1D array.
            theSplitMatch[0]=eachMatch.split(",");
            //fetch 2nd element from 1D array which is 'season' and add to Map for counting matches.
            String season=theSplitMatch[0][1];
            addToMapUtility(theMatchCountPerSeason, season);
        }
        System.out.println("\nMatches per Year\n----------------");
        for(Map.Entry<String,Integer> entry: theMatchCountPerSeason.entrySet())
        {
            System.out.println(entry.getKey()+": "+entry.getValue());
        }


    }

    public void addToMapUtility(Map<String, Integer> theMatchCountPerSeason, String season) {
        if(theMatchCountPerSeason.containsKey(season)){
            int count= theMatchCountPerSeason.get(season);
            theMatchCountPerSeason.put(season,count+1);
        }
        else{
            theMatchCountPerSeason.put(season,1);
        }
    }

}