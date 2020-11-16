package io.mountblue.learn.problems;

import io.mountblue.learn.resources.ReadDataAndReturnList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TopEconomicalBowlers2k15 {

    public void getAnswer() {
        ReadDataAndReturnList theDeliveriesUtility = new ReadDataAndReturnList();
        List<String> theListOfDeliveries = theDeliveriesUtility.readData("deliveries.csv");
        List<String> filteredList = theListOfDeliveries.subList(122715, 136364);
        Map<String, Integer> eachBowlerConcededRuns2k15 = new HashMap<>();
        Map<String, Integer> eachBowlerBowledBalls2k15 = new HashMap<>();
        String[][] theSplitDelivery = new String[1][];
        for (String eachDelivery : filteredList) {
            //take each delivery from filteredList and split to get a 1D array;
            theSplitDelivery[0] = eachDelivery.split(",");
            //check if a ball is wide-ball or no-ball,
            // if yes->just add runs to 'eachBowlerConcededRuns2k15' ;
            if(Integer.parseInt(theSplitDelivery[0][10])>0 || Integer.parseInt(theSplitDelivery[0][13])>0){
                //if bowler(theSplitDelivery[0][8]) is present in map
                addToMapUtility(eachBowlerConcededRuns2k15, theSplitDelivery,Integer.parseInt(theSplitDelivery[0][16]));
            }
            else {
                // if not, add totalRuns-(legByes+byes) to eachBowlerConcededRuns2k15;
                int totalRunsPerBall=Integer.parseInt(theSplitDelivery[0][17])-(Integer.parseInt(theSplitDelivery[0][11]))-(Integer.parseInt(theSplitDelivery[0][12]));
                addToMapUtility(eachBowlerConcededRuns2k15, theSplitDelivery, totalRunsPerBall);
                //add balls(just +1) to that eachBowlerBowledBalls2k15;
                addToMapUtility(eachBowlerBowledBalls2k15, theSplitDelivery, 1);
            }
        }
        //Now get conceded runs from eachBowlerConcededRuns2k15 map and divide with (balls from other map/6);
        Map<String, Float> theFinalMap = new HashMap<>();

        for(Map.Entry<String,Integer> entry: eachBowlerConcededRuns2k15.entrySet()) {

                theFinalMap.put(entry.getKey(), (entry.getValue()/(float)(eachBowlerBowledBalls2k15.get(entry.getKey())/6)));
        }

        //sort the Map based on economy
        System.out.println("\nTop Economic bowlers in IPL 2015\n----------------");
        theFinalMap.entrySet().stream()
                //.sorted((k1, k2) -> k1.getValue().compareTo(k2.getValue()))
                .sorted(Map.Entry.comparingByValue())
                .limit(10)
                .forEach(k -> System.out.println(k.getKey() + ": " + k.getValue()));

    }

    public void addToMapUtility(Map<String, Integer> eachBowlerBowledBalls2k15, String[][] theSplitDelivery, int i) {
        if (eachBowlerBowledBalls2k15.containsKey(theSplitDelivery[0][8])) {
            int count2 = eachBowlerBowledBalls2k15.get(theSplitDelivery[0][8]);
            eachBowlerBowledBalls2k15.put(theSplitDelivery[0][8], count2 + i);
        } else {
            eachBowlerBowledBalls2k15.put(theSplitDelivery[0][8], i);
        }
    }

}
