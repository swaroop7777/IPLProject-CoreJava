package io.mountblue.learn.main;

import io.mountblue.learn.problems.*;

public class IplProjectLauncher {
    public static void main(String[] args) {
        MatchesPerYear firstProblem=new MatchesPerYear();
        firstProblem.getAnswer();
        System.out.println("-----------------------------");
        MatchesWonPerTeam secondProblem=new MatchesWonPerTeam();
        secondProblem.getAnswer();
        System.out.println("-----------------------------");
        ExtraRuns2016PerTeam thirdProblem=new ExtraRuns2016PerTeam();
        thirdProblem.getAnswer();
        System.out.println("-----------------------------");
        TopEconomicalBowlers2k15 fourthProblem=new TopEconomicalBowlers2k15();
        fourthProblem.getAnswer();
        System.out.println("-----------------------------");
        SixesPerTeam2016 fifthProblem=new SixesPerTeam2016();
        fifthProblem.getAnswer();
    }
}
