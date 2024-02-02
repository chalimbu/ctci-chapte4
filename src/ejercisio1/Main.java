package ejercisio1;
import java.util.*;

public class Main {

    public static void main(String args[]){
        int[] input={1,2,3,4,5,6,8};
        NodeBinaryTree result=generateTree(input);
        System.out.println("...");
    }

    public static NodeBinaryTree generateTree(int[] input){
        return generateTreeRecursive(input,0,input.length);
    }

    private static NodeBinaryTree generateTreeRecursive(int[] input,int start,int end){
        if(end-start<0 || (start==end&&end==input.length)){
            return null;
        }
        if(end==start){
            return new NodeBinaryTree(input[start]);
        }
        int midle=(start+end)/2;
        NodeBinaryTree current=new NodeBinaryTree(input[midle]);
        current.left=generateTreeRecursive(input,start,midle-1);
        current.right=generateTreeRecursive(input,midle+1,end);
        return current;
    }
}
