package com.fathi;

import javax.print.DocFlavor;

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

    public boolean Conflicte(){
        for (int i=0 ; i<numberOfStates;++i){
            if(stateList[i].color==null && stateList[i].colorCandidate[0]==1 && stateList[i].colorCandidate[1]==1 && stateList[i].colorCandidate[2]==1 ){
                return true;
            }
        }
        return false;
    }
    //returned true if successfully
    public boolean SetColor(int state,String color){

        if(color=="RED" && stateList[state].colorCandidate[0] != 1){
            stateList[state].color="RED";
            stateList[state].colorCandidate[0]=1;
            stateList[state].colorCandidate[1]=1;
            stateList[state].colorCandidate[2]=1;

            return true;
        }
        else if(color=="GREEN" && stateList[state].colorCandidate[1] != 1){

            stateList[state].color="GREEN";
            stateList[state].colorCandidate[0]=1;
            stateList[state].colorCandidate[1]=1;
            stateList[state].colorCandidate[2]=1;

            return true;
        }
        else if (color=="BLUE" && stateList[state].colorCandidate[2] != 1){

            stateList[state].color="BLUE";
            stateList[state].colorCandidate[0]=1;
            stateList[state].colorCandidate[1]=1;
            stateList[state].colorCandidate[2]=1;

            return true;

        }
        return false;
    }

    public void ConnectState(int first , int second){
        mapMatrix[first][second]=1;
        mapMatrix[second][first]=1;
    }
    public void AddState(String name){
        if(numberOfStates<size) {
            stateList[numberOfStates] = new State(name);
            numberOfStates++;

        }
    }

    public int MostBorder(){
        int res = 0;
        int resBorder=0;
        for (int row=0 ; row<numberOfStates ; ++row){
            int numOfBorder=0;
            for(int col=0;col<numberOfStates;++col){
                if(mapMatrix[row][col]==1){
                    numOfBorder++;
                }
            }
            if(numOfBorder> resBorder){
                res=row;
                resBorder=numOfBorder;
            }
        }
        return res;

    }
    public void ReduceNeighbours(int state , String color){
        for(int col=0;col<numberOfStates;col++){
            if(mapMatrix[state][col]==1 ){
                switch (color){
                    case "RED":
                        stateList[col].colorCandidate[0]=1;
                        break;
                    case "GREEN":
                        stateList[col].colorCandidate[1]=1;
                        break;
                    case "BLUE":
                        stateList[col].colorCandidate[2]=1;
                        break;
                }
            }
        }
    }

    public int NextState(){

        for (int i=0;i<numberOfStates;i++){
            if(stateList[i].color==null){
                return i;
            }
        }
        return -1;
    }

    public void PrintResult(){
        for(int i=0;i<numberOfStates;i++){
            System.out.println(stateList[i].name+" ==> "+stateList[i].color);
        }
    }

    public void doColoring(){

        int start = MostBorder();
        //RED
        if(Tracking(start,"RED")){
            PrintResult();
        }
        //GREEN
        else if(Tracking(start,"GREEN")){
            PrintResult();
        }
        //BLUE
        else if(Tracking(start,"BLUE")){
            PrintResult();
        }


        PrintResult();



    }

    public boolean Tracking(int state,String color){

        if(Conflicte()){
            return false;
        }

        if(color=="RED"){
            if(SetColor(state,"RED")){
                ReduceNeighbours(state,color);
            }

        }
        else if(color=="GREEN"){
            if(SetColor(state,"GREEN")){
                ReduceNeighbours(state , color);
            }

        }
        //BLUE
        else {
            if(SetColor(state,"GREEN")){
                ReduceNeighbours(state , color);
            }

        }

        int next =NextState();
        if(next==-1){
            return false;
        }

        State[] tmp = stateList;
        boolean status;

        //RED
        status =Tracking(next , "RED");
        if(status){
            return true;
        }
        else {
            stateList = tmp;
        }

        //GREEN
        status = Tracking(next , "GREEN");
        if(status){
            return true;
        }
        else {
            stateList = tmp;
        }


        //BLUE
        status = Tracking(next , "BLUE");
        if(status){
            return true;
        }
        else {
            stateList = tmp;
        }
        return false;
    }


}
