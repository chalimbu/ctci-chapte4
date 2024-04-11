package co;
import java.util.*;

public class Main {

    public static void main(String args[]){
        int[][] adjacencyMatrix={
                {0,1,0,0,0,0,0},
                {1,0,1,0,0,0,0},
                {0,1,0,1,1,0,0},
                {0,0,1,0,0,0,0},
                {0,0,1,0,0,0,1},
                {0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0}
        };
        Graph g=new Graph(adjacencyMatrix);
        System.out.println("is there a path? "+isThereAPath(g,g.nodes.get(0),g.nodes.get(5)));//node 1 an 7
    }

    public static boolean isThereAPath(Graph graph,Node one,Node two){
        Queue<Node> toVisit=new LinkedList<>();
        if(one!=null){
            one.visit=true;
            toVisit.add(one);
        }
        while(!toVisit.isEmpty()){
            Node current=toVisit.remove();
            if(current==two){
                return true;
            }
            for(Node n:current.neighbours){
                if(n.visit==false){
                    n.visit=true;
                    toVisit.add(n);
                }
            }
        }
        return false;
    }
}
