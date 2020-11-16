package io.mountblue.learn.resources;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ReadDataAndReturnList {
    List<String> theList= new ArrayList<>();
    public List<String> readData(String fileName){
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            //skip headings of table.
            br.readLine();
            String line=br.readLine();
            while(line!=null)
            {
                theList.add(line);
                line=br.readLine();
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        return theList;
    }

}
