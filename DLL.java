public class DLL {
    Node head;
    Node tail;
    int size;
    public void addFirst(int value){
        Node nN=new Node(value);
        nN.next=head;
        if(head!=null) {
            head.previous = nN;
        }
        if(tail==null){
            tail=head;
        }
        head=nN;
        size++;
    }
    public void addLast(int value){
        if(tail==null){
            addFirst(value);
        }
        else{
            Node nN=new Node(value);
            tail.next=nN;
            nN.previous=tail;
            tail=nN;
            size++;
        }
    }
    public void addAtIndex(int index,int value){
        if(index==0){
            addFirst(value);
        }
        else if(index==size){
            addLast(value);
        }
        else{
            Node nN=new Node(value);
            Node temp=head;
            for(int i=0;i<index-1;i++){
                temp=temp.next;
            }
            Node temp2=temp.next;
            temp.next=nN;
            nN.previous=temp;
            nN.next=temp2;
            temp2.previous=nN;
        }
    }
    public void deleteFirst() throws Exception{
        if(head==null){
            throw new Exception("List is Empty");
        }
        if(head.next==null){
            tail=null;
        }
        head=head.next;
        size--;
    }
    public void deleteLast()throws Exception{
        if(head==null){
            throw new Exception("List is Empty");
        }
        if(head.next==null){
            head=null;
            tail=null;
        }
        else{
            Node temp=head;
            for(int i=0;i<size-1;i++){
                temp=temp.next;
            }
            temp.next=null;
            tail=temp;
        }
    }
    public void deleteAtIndex(int index)throws Exception{
        if(head==null){
            throw new Exception("List is Empty");
        }
        if(index==0){
            try {
                deleteFirst();
            }
            catch(Exception e){
                System.out.println(e);
            }
        }
        else if(index==size-1){
            try{
                deleteLast();
            }
            catch(Exception e){
                System.out.println(e);
            }
        }
        else{
            Node temp=head;
            for(int i=0;i<index-1;i++){
                temp=temp.next;
            }
            temp.next=temp.next.next;
            temp.previous.previous=temp.previous;
            size--;
        }
    }
    public int middleNum(){
        Node s=head;
        Node f=head;
        while(f!=null &&f.next!=null){
            f=f.next.next;
            s=s.next;
        }
        return s.value;
    }
    public int get(int index){
        Node temp=head;
        for(int i=0;i<index;i++){
            temp=temp.next;
        }
        return temp.value;
    }
    public void sort(){
        Node temp=head;
        for(int i=0;i<size-1;i++){
            for(int j=0;j<size-1;j++){
                if(temp.value>temp.next.value){
                    int t=temp.value;
                    temp.value=temp.next.value;
                    temp.next.value=t;
                }
                temp=temp.next;
            }
            temp=head;
        }
    }
    public void reverseLL(){
        Node temp=head;
        reverseLL(temp);
    }
    public void reverseLL(Node temp){
        if(temp==tail){
            head=tail;
            return;
        }
        reverseLL(temp.next);
        tail.next=temp;
        temp.next=null;
        tail=temp;
    }
    public class Node{
        int value;
        Node next;
        Node previous;
        public Node(int value){
            this.value=value;
        }
    }
    public void display(){
        Node temp=head;
        while(temp!=null){
            System.out.print(temp.value+"-");
            temp=temp.next;
        }
        System.out.print("@");
    }
    public void replace(int index,int value){
        Node temp=head;
        for(int i=0;i<index;i++){
            temp=temp.next;
        }
        temp.value=value;
    }
    public static void main(String[] rgs)
    {
        DLL a=new DLL();
        a.addFirst(53);
        a.addFirst(12);
        a.addLast(76);
        a.addLast(54);
        a.addLast(23);
        a.addLast(5);
        a.addFirst(34);
        a.addAtIndex(2,90);
        try{
            a.deleteFirst();
        }
        catch(Exception e){
            System.out.println(e);
        }
        try{
            a.deleteLast();
        }
        catch(Exception e){
            System.out.println(e);
        }
        try{
            a.deleteAtIndex(2);
        }
        catch(Exception e){
            System.out.println(e);
        }
        a.addLast(65);
        a.addFirst(7);
        a.addFirst(51);
        a.display();
        System.out.println();


        a.sort();
        a.reverseLL();
        a.display();
    }
}
