package ejercisio1;

import java.util.List;

public class Nodo {
    public int data;
    public List<Nodo> childs;
    public Nodo(int data,List<Nodo> childs){
        this.data=data;
        this.childs=childs;
    }
}
