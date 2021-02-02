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




    }
}
