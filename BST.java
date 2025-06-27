import java.util.*;
public class BST {
    Node root;
    public void insert(int value){

        root=insert(root,value); // Comment merge coflict
    }
    public Node insert (Node node,int value){
        if(node==null){
            Node nN=new Node(value);
            return nN;
        }
        if(value<node.value){
            node.left=insert(node.left,value);
        }
        if(value>=node.value){
            node.right=insert(node.right,value);

        }
        node.height=Math.max(height(node.left),height(node.right))+1;
        return rotate(node);
    }
    public void clearDisplay(){
        clearDisplay(root,0);
    }
    public void clearDisplay(Node node,int level){
        if(node==null){
            return;
        }
        clearDisplay(node.right,level+1);
        if(level==0)
            System.out.println(node.value);
        else{
            for(int i=1;i<level;i++){
                System.out.print("|\t");
            }
            System.out.println("|----->"+node.value);
        }
        clearDisplay(node.left,level+1);
    }
    public int bigNo(){
        Node temp=root;
        while(temp.right!=null){
            temp=temp.right;
        }
        return temp.value;
    }
    public int bigNo(int n){
        Node temp=root;
        int i=0;
        while(i!=n){
            temp=temp.right;
            i++;
        }
        return temp.value;
    }
    public void preOrder(){preOrder(root);}

    public void preOrder(Node node){
        if(node==null){return;}
        System.out.print(node.value+" ");
        preOrder(node.left);
        preOrder(node.right);
    }
    public void inOrder(){inOrder(root);}
    public void inOrder(Node node){
        if(node==null){return;}
        inOrder(node.left);
        System.out.print(node.value+" ");
        inOrder(node.right);
    }
    public void postOrder(){postOrder(root);}
    public void postOrder(Node node){
        if(node==null){return;}
        postOrder(node.left);
        postOrder(node.right);
        System.out.print(node.value+" ");
    }
    public void levelOrder(){
        PriorityQueue<Node> a=new PriorityQueue<>();
        a.add(root);
        while(!a.isEmpty());
        {
            Node x=a.remove();
            System.out.print(x.value+" ");
            if(x.left!=null){a.add(x.left);}
            if(x.right!=null){a.add(x.right);}
        }
    }
    public int height(){
        return height(root);
    }
    public int height(Node node){
        if(node==null){
            return -1;
        }
        return node.height;
    }
    public Node rotate(Node node){
        //left heavy case
        if((height(node.left)-height(node.right))>1){
            //left-left case
            if((height(node.left.left)-height(node.left.right))>0){
                return rightRotate(node);
            }
            //left right case
            if((height(node.left.left)-height(node.left.right))<0){
                node.left=leftRotate(node.left);
                return rightRotate(node);
            }
        }
        //right heavy case
        if((height(node.left)-height(node.right))<-1){
            //right left case
            if((height(node.right.right)-height(node.right.left))<0){
                return leftRotate(node);
            }
            //right left case
            if((height(node.right.right)-height(node.right.left))>0){
                node.left=leftRotate(node.left);
                return rightRotate(node);
            }
        }
        return node;
    }
    public Node leftRotate(Node p){
        Node c=p.right;
        Node t=c.left;
        c.left=p;
        p.right=t;
        c.height=Math.max(height(c.left),height(c.right))+1;
        p.height=Math.max(height(p.left),height(p.right))+1;
        return c;
    }
    public Node rightRotate(Node p){
        Node c=p.left;
        Node t=c.right;
        c.right=p;
        p.left=t;
        c.height=Math.max(height(c.left),height(c.right))+1;
        p.height=Math.max(height(p.left),height(p.right))+1;
        return c;
    }



    class Node{
        int value;
        Node left;
        Node right;
        int height;
        public Node(int value){
            this.value=value;
        }
    }
}

class main{
    public static void main(String[] args){
        BST a=new BST();
        a.insert(20);
        a.insert(25);
        a.insert(19);
        a.insert(17);
        a.insert(18);
        a.insert(9);
        a.clearDisplay();
        System.out.println();
        System.out.println(a.bigNo());
        System.out.println(a.bigNo(2));
        a.preOrder();
        System.out.println();
        a.inOrder();
        System.out.println();
        a.postOrder();
        System.out.println();
        a.levelOrder();
    }
}
