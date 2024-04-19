package co.firstCommonAncestor;

public class FirstCommonAncestor{

    public static void main(String args[]){
        Node n1=new Node(1);
        Node n2=new Node(2);
        Node n3=new Node(3);
        Node n4=new Node(4);
        Node n5=new Node(5);
        Node n6=new Node(6);
        Node n7=new Node(7);
        Node n8=new Node(8);

        n1.left=n2;
        n2.left=n4;
        n1.right=n3;
        n3.left=n5;
        n5.left=n6;
        n5.right=n7;
        n3.right=n8;

        System.out.println("firs common succesor 6 an 7"+ firstCommoSuccesor(n1,n6,n7).getData()); //n5
        System.out.println("firs common succesor 6 an 7"+ firstCommoSuccesor(n1,n6,n8).getData()); //n3
        System.out.println("firs common succesor 8 an 4"+ firstCommoSuccesor(n1,n8,n4).getData()); //n1
        System.out.println("firs common succesor 1 an 4"+ firstCommoSuccesor(n1,n8,n4).getData()); //n1
    }

    public static Node firstCommoSuccesor(Node root,Node n1,Node n2){
        if(fillPath(root,n1,n2)){
            boolean pathFound=false;
            Node current=root;
            while(pathFound==false){

                if(current.getIsLooked()&&(hasPath(current.left)||hasPath(current.right))){
                    pathFound=true;
                    return current;
                }else if(hasPath(current.left)&&hasPath(current.right)){
                    pathFound=true;
                    return current;
                }else{
                    if(hasPath(current.left)){
                        current=current.left;
                    }else{
                        current=current.right;
                    }
                }
            }
            return null;
        }else{
            //there is not path
            return null;
        }

    }

    public static boolean hasPath(Node n){
        if(n==null) return false;
        return n.getHasPath();
    }

    private static boolean fillPath(Node current,Node n1,Node n2){
        if(current==null){
            return false;
        }
        boolean pahtOnLeft=fillPath(current.getLeft(),n1,n2);
        boolean pahtOnRight=fillPath(current.getRight(),n1,n2);


        if(pahtOnLeft||pahtOnRight||current==n1||current==n2){
            if(current==n1||current==n2){
                current.setIsLooked(true);
            }
            current.setHasPath(true);
            return true;
        }else{
            return false;
        }

    }

}
