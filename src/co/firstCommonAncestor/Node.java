package co.firstCommonAncestor;

public class Node {
    int data;
    boolean hasPath;
    boolean isLooked;
    Node left;
    Node right;
    public Node(int data){
        this.data=data;
        hasPath=false;
    }

    public void setLeft(Node left){
        this.left=left;
    }

    public void setRight(Node right){
        this.right=right;
    }

    public void setHasPath(boolean hasPath){
        this.hasPath=hasPath;
    }

    public Node getLeft(){
        return left;
    }

    public Node getRight(){
        return right;
    }

    public boolean getHasPath(){
        return hasPath;
    }
    public boolean getIsLooked(){
        return isLooked;
    }
    public void setIsLooked(boolean isLooked){
        this.isLooked=isLooked;
    }

    public int getData(){
        return data;
    }
}

