package io.mountblue.learn.problems;

import io.mountblue.learn.resources.ReadDataAndReturnList;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SixesPerTeam2016 {

    public void getAnswer(){
        ReadDataAndReturnList theDeliveriesUtility = new ReadDataAndReturnList();
        List<String> theListOfDeliveries = theDeliveriesUtility.readData("deliveries.csv");
        //List from 577th match to 637 match;
        List<String> filteredList=theListOfDeliveries.subList(136366,150460);
        Map<String, Integer> theSixesCount2016PerTeam = new HashMap<>();
        String[][] theSplitDelivery = new String[1][];
        int runAtThatDelivery;
        for (String eachDelivery : filteredList) {
            //take each delivery from filteredList and split to get a 1D array;
            theSplitDelivery[0] = eachDelivery.split(",");
            //fetch 17th element from 1D array which is 'total_runs';
            runAtThatDelivery=Integer.parseInt(theSplitDelivery[0][17]);
            addToMapUtility(theSixesCount2016PerTeam, theSplitDelivery, runAtThatDelivery);
        }
        System.out.println("\nSixes per team in 2016\n----------------");
        for(Map.Entry<String,Integer> entry: theSixesCount2016PerTeam.entrySet())
        {
            System.out.println(entry.getKey()+": "+entry.getValue());
        }

    }
    public void addToMapUtility(Map<String, Integer> theSixesCount2016PerTeam, String[][] theSplitDelivery, int runAtThatDelivery) {
        if(theSixesCount2016PerTeam.containsKey(theSplitDelivery[0][2])){
            if(runAtThatDelivery ==6) {
                int count = theSixesCount2016PerTeam.get(theSplitDelivery[0][2]);
                theSixesCount2016PerTeam.put(theSplitDelivery[0][2], count + 1);
            }
        }
        else{
            if(runAtThatDelivery ==6)
            theSixesCount2016PerTeam.put(theSplitDelivery[0][2],1);
        }
    }
}
