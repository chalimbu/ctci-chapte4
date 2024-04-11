package co.succesor46;

public class TreeNode{
    public int data;
    public TreeNode left;
    public TreeNode right;
    public TreeNode parent;

    public TreeNode(int data){
        this.data=data;
        this.left=null;
        this.right=null;
        this.parent=null;
    }

    public static void main(String args[]){
        TreeNode n40= new TreeNode(40);
        TreeNode n20= new TreeNode(20);
        TreeNode n10= new TreeNode(10);
        TreeNode n25= new TreeNode(25);
        TreeNode n60= new TreeNode(60);
        TreeNode n50= new TreeNode(50);
        TreeNode n80= new TreeNode(80);

        n40.left=n20;
        n20.parent=n40;
        n20.left=n10;
        n10.parent=n20;
        n20.right=n25;
        n25.parent=n20;
        n40.right=n60;
        n60.parent=n40;
        n60.left=n50;
        n50.parent=n60;
        n60.right=n80;
        n80.parent=n60;


        System.out.println("n40 "+ findSuccesor(n40).data);//50
        System.out.println("n25 "+ findSuccesor(n25).data);//40
        System.out.println("n60 "+ findSuccesor(n60).data);//80
        System.out.println("n80 "+ findSuccesor(n80).data);//null
    }

    public static TreeNode findSuccesor(TreeNode n){
        if(n==null) return null;
        if(n.right!=null){
            TreeNode result=n.right;
            while(result.left!=null){
                result=result.left;
            }
            return result;
        }else{
            TreeNode parent=n.parent;
            TreeNode current=n;
            while(current!=null&&parent!=null&&parent.left!=current){
                current=parent;
                parent=current.parent;
            }
            return parent;
        }
    }

}