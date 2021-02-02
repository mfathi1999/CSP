package com.fathi;

public class MapGraph {
    int size;
    int [][] mapMatrix;
    State[] stateList;
    int numberOfStates;

    MapGraph(int size){

        this.size = size;
        stateList = new State[this.size];
        mapMatrix = new int[this.size][this.size];
        numberOfStates = 0;
    }

    public void ConnectCity(int first , int second){
        mapMatrix[first][second]=1;
        mapMatrix[second][first]=1;
    }
    public void AddState(String name){
        if(numberOfStates<size) {
            stateList[numberOfStates] = new State(name);
            numberOfStates++;

        }
    }
}
