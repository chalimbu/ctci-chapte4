package co.buildOrder47;

import java.util.List;
import java.util.LinkedList;

public class Node{
    String projectName;
    List<Node> neighbours;
    public enum STATE{INITIAL,VISITIN,COMPLETED};
    STATE state;
    public Node(String projectName){
        this.projectName=projectName;
        neighbours=new LinkedList<Node>();
        state=STATE.INITIAL;
    }
    public void addNeighbour(Node n){
        neighbours.add(n);
    }
    public STATE getState(){
        return state;
    }
    public void setState(STATE state){
        this.state=state;
    }
    public List<Node> getNeighbours(){
        return neighbours;
    }
    public String getProjectName(){
        return projectName;
    }
}
