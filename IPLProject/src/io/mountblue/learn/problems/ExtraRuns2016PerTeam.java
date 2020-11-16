package io.mountblue.learn.problems;

import io.mountblue.learn.resources.ReadDataAndReturnList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ExtraRuns2016PerTeam {

    //577-637; 16th index for extra runs.
    public void getAnswer() {
        ReadDataAndReturnList theDeliveriesUtility = new ReadDataAndReturnList();
        List<String> theListOfDeliveries = theDeliveriesUtility.readData("deliveries.csv");
        //List from 577th match to 637th match;
        List<String> filteredList=theListOfDeliveries.subList(136366,150460);
        Map<String, Integer> theExtrasCount2016PerTeam = new HashMap<>();
        String[][] theSplitDelivery = new String[1][];
        int extra;
        for (String eachDelivery : filteredList) {
            //take each delivery from filteredList and split to get a 1D array;
            theSplitDelivery[0] = eachDelivery.split(",");
            //fetch 16th element from 1D array which is 'extras';
            extra=Integer.parseInt(theSplitDelivery[0][16]);
            addToMapUtility(theExtrasCount2016PerTeam, theSplitDelivery, extra);
        }
        System.out.println("\nExtra runs per team in 2016\n----------------");
        for(Map.Entry<String,Integer> entry: theExtrasCount2016PerTeam.entrySet())
        {
            System.out.println(entry.getKey()+": "+entry.getValue());
        }
    }

    public void addToMapUtility(Map<String, Integer> theExtrasCount2016PerTeam, String[][] theSplitDelivery, int extra) {
        if(theExtrasCount2016PerTeam.containsKey(theSplitDelivery[0][3])){
            int count= theExtrasCount2016PerTeam.get(theSplitDelivery[0][3]);
            theExtrasCount2016PerTeam.put(theSplitDelivery[0][3],count+ extra);
        }
        else{
            theExtrasCount2016PerTeam.put(theSplitDelivery[0][3], extra);
        }
    }
}

