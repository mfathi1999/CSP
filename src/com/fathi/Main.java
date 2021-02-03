package com.fathi;
import java.io.FileNotFoundException;

//This class implements the map coloring problem.


public class Main {

    public static void main(String[] args) {
	// write your code here


        //Make Map
        MapGraph mapGraph = new MapGraph(7);
        mapGraph.AddState("Western Australia");
        mapGraph.AddState("Northern Territory");
        mapGraph.AddState("South Australia");
        mapGraph.AddState("Queensland");
        mapGraph.AddState("New South Wales");
        mapGraph.AddState("Victoria");
        mapGraph.AddState("Tasmania");

        //Make border (connect states together)
        mapGraph.ConnectState(0,1);
        mapGraph.ConnectState(0,2);
        mapGraph.ConnectState(1,2);
        mapGraph.ConnectState(1,3);
        mapGraph.ConnectState(2,3);
        mapGraph.ConnectState(2,4);
        mapGraph.ConnectState(2,5);
        mapGraph.ConnectState(3,4);
        mapGraph.ConnectState(4,5);

        //RUN
        mapGraph.doColoring();




    }
}
