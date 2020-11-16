package io.mountblue.learn.problems;

import io.mountblue.learn.resources.ReadDataAndReturnList;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MatchesWonPerTeam {

    public void getAnswer() {
        ReadDataAndReturnList theMatchesUtility = new ReadDataAndReturnList();
        List<String> theListOfMatches = theMatchesUtility.readData("matches.csv");
        Map<String,Integer> theMatchesWonByTeams=new HashMap<>();
        String[][] theSplitMatch=new String[1][];
        for (String eachMatch : theListOfMatches) {
            //take each match and split to get a 1D array.
            theSplitMatch[0]=eachMatch.split(",");
            //fetch 10th element from 1D array which is 'winner' and add to Map for counting matches.
            String winner=theSplitMatch[0][10];
            if(winner.equals("")){
                winner="Tied";
            }
            addToMapUtility(theMatchesWonByTeams, winner);
        }
        System.out.println("\nMatches won per team\n----------------");
        for(Map.Entry<String,Integer> entry: theMatchesWonByTeams.entrySet())
        {
            System.out.println(entry.getKey()+": "+entry.getValue());
        }
    }

    public void addToMapUtility(Map<String, Integer> theMatchesWonByTeams, String winner) {
        if(theMatchesWonByTeams.containsKey(winner)){

            int count= theMatchesWonByTeams.get(winner);
            theMatchesWonByTeams.put(winner,count+1);
        }
        else{
            theMatchesWonByTeams.put(winner,1);
        }
    }
}
