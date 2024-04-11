package co;
import java.util.List;
import java.util.ArrayList;
public class Node{
    public int data;
    public List<Node> neighbours;

    public boolean visit;
    public Node(int data){
        this.data=data;
        this.neighbours=new ArrayList();
        visit=false;
    }
}
