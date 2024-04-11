package co;
import java.util.List;
import java.util.ArrayList;

public class Graph{

    public List<Node> nodes;

    public Graph(int[][] adjancencyMatrix){
        nodes=new ArrayList<Node>();
        for(int i=0;i<adjancencyMatrix.length;i++){
            nodes.add(new Node(i));
        }
        for(int i=0;i<adjancencyMatrix.length;i++){
            for(int j=0;j<adjancencyMatrix[i].length;j++){
                if(adjancencyMatrix[i][j]==1){
                    nodes.get(i).neighbours.add(nodes.get(j));
                }
            }

        }

    }


    public static void main(String args[]){
        int[][] adjacencyMatrix={{0,1,0,0,0},
                {0,0,0,1,0},
                {0,0,0,0,0},
                {0,0,1,0,1},
                {0,0,0,1,0}
        };
        Graph myGraph=new Graph(adjacencyMatrix);
        List<Node> nodesInGraph=myGraph.nodes;
        System.out.println("");
    }

}