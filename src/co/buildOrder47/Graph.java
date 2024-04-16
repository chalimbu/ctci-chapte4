package co.buildOrder47;

import java.util.List;
import java.util.LinkedList;
import java.util.Map;
import java.util.HashMap;

public class Graph{
    List<Node> nodes;
    Map<String,Node> map;

    public List<Node> getNodes(){
        return nodes;
    }

    public Graph(String projects[],String[][] dependencies){
        nodes=new LinkedList<Node>();
        map=new HashMap<String,Node>();

        for(String project: projects){
            if(!map.containsKey(project)){
                Node nProject=new Node(project);
                nodes.add(nProject);
                map.put(project,nProject);
            }
        }
        for(String[] dependency: dependencies){
            if(dependency.length==2){
                String first=dependency[0];
                String second=dependency[1];
                map.get(first).addNeighbour(map.get(second));
            }
        }
    }
}