package co.buildOrder47;

import java.util.List;
import java.util.LinkedList;

public class BuildOrder{
    public static void main(String args[]){
        String[] projects={"f","a","b","d","c","e","g","h"};
        String[][] dependencies={{"a","f"},{"b","f"},{"d","a"},{"d","b"},{"c","d"},{"g","e"}};
        Graph g=new Graph(projects,dependencies);
        List<String> buildOrder=buildOrder(g);
        System.out.println("");
    }

    public static List<String> buildOrder(Graph g){
        List<Node> nodes=g.getNodes();
        List<String> buildOrder=new LinkedList<String>();
        for(Node n : nodes){
            doDfsOrder(n,buildOrder);
        }
        return buildOrder;
    }

    private static void doDfsOrder(Node n, List<String> buildOrder){
        if(n.getState()==Node.STATE.VISITIN){
            throw new RuntimeException("project cannot be build, circular dependencies");
        }
        if(n.getState()== Node.STATE.COMPLETED){
            return;
        }
        n.setState(Node.STATE.VISITIN);

        for(Node child: n.getNeighbours()){
            if(child.getState()!=Node.STATE.COMPLETED){
                doDfsOrder(child,buildOrder);
            }

        }
        if(n.getState()!=Node.STATE.COMPLETED){
            buildOrder.add(n.getProjectName());
            n.setState(Node.STATE.COMPLETED);
        }

    }

}
