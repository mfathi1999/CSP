package com.fathi;

public class State {
    public String name;
    //Blue
    //Red
    //Green
    public String color;
    // 0)RED 1)GREEN 2)BLUE
    // 0 => candidate 1=> not candidate
    public int[] colorCandidate;

    State(String name){
        this.name = name;
        colorCandidate = new int[3];

    }



}
