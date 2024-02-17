package ejercisio1;

import java.util.ArrayList;
import java.util.LinkedList;

public class ListByLevel {

    public static void main(String args[]){
        int[][] adjacencyMatrix={{0,1,1,0,0,0,0},
                {0,0,0,1,1,0,0},
                {0,0,0,0,0,0,1},
                {0,0,0,0,0,0,0},
                {0,0,0,0,0,1,0},
                {0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0}
        };
        Graph g=new Graph(adjacencyMatrix);
        Node n=g.nodes.get(0);
        ArrayList<LinkedList<Node>> resul=getEachLevel(n);
        System.out.println("something");
    }

    public static ArrayList<LinkedList<Node>> getEachLevel(Node root){
        ArrayList<LinkedList<Node>> result=new ArrayList<>();
        getEachLevelRecursive(root,result,0);
        return result;
    }

    public static void getEachLevelRecursive(Node current,ArrayList<LinkedList<Node>> resul,int level){
        LinkedList<Node> currentList;
        if(resul.size()<=level){
            currentList=new LinkedList<>();
            resul.add(currentList);
        }else{
            currentList=resul.get(level);
        }
        currentList.add(current);
        for(int i=0;i<current.neighbours.size();i++){
            getEachLevelRecursive(current.neighbours.get(i),resul,level+1);
        }
    }
}
