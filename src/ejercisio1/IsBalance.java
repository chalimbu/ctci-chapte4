package ejercisio1;

public class IsBalance {

    public static void main(String args[]){
        int[][] adjancencyMatrix={{0,1,1,0,0}
                ,{0,0,0,1,0}
                ,{0,0,0,0,0}
                ,{0,0,0,0,1}
                ,{0,0,0,0,0}};
        Graph g=new Graph(adjancencyMatrix);
        Node n=g.nodes.get(0);
        boolean isBalance=isBalance(n);
        System.out.println("is balanced? "+isBalance);
    }

    public static boolean isBalance(Node n){
        if(n==null) return true;
        int h1=height(n.neighbours.size()>0?n.neighbours.get(0):null);
        int h2=height(n.neighbours.size()>1?n.neighbours.get(1):null);
        System.out.println("h1 "+h1+"h2 "+h2);
        if(h1==Integer.MIN_VALUE||h2==Integer.MIN_VALUE){
            return false;
        }
        int absHeigh=Math.abs(h1-h2);
        if(absHeigh<=1){
            return true;
        }
        return false;
    }

    public static int height(Node n){
        if(n==null || n.neighbours.size()==0) return 0;
        int maxHeight=Integer.MIN_VALUE;
        int lastNeighbort=0;
        for(Node neight:n.neighbours){
            int currentHeight=height(neight);
            if(neight.neighbours.size()==0){
                currentHeight=0;
            }
            if(maxHeight!=Integer.MIN_VALUE&&Math.abs(lastNeighbort-currentHeight)>1){
                return Integer.MIN_VALUE;
            }
            if(currentHeight>maxHeight){
                maxHeight=currentHeight;
            }
            lastNeighbort=currentHeight;
        }
        return maxHeight+1;
    }
}
