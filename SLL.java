
class LL
{
    Node head;
    Node tail;
    int size;
    public void addFirst(int value){
        Node nN=new Node(value);
        nN.next=head;
        head=nN;
        if(tail==null){
            tail=head;
        }
        size++;
    }
    public void addLast(int value){
        if(tail==null){
            addFirst(value);
        }
        else {
            Node nN=new Node(value);
            tail.next=nN;
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
            Node temp1=head;
            for(int i=1;i<index;i++){
                temp1=temp1.next;
            }
            Node temp2=temp1.next;
            temp1.next=nN;
            nN.next=temp2;
            size++;
        }
    }
    public void deleteFirst()throws Exception{
        if(head==null){
            throw new Exception("List is Empty");
        }
        if(head.next==null){
            tail=null;
        }
        head=head.next;
        size--;
    }
    public void deleteLast() throws Exception{
        if(head==null){
            throw new Exception("List is Empty");
        }
        if(head.next==null){
            head=null;
            tail=null;
            size--;
        }
        else{
            Node temp=head;
            for(int i=1;i<size-1;i++){
                temp=temp.next;
            }
            temp.next=null;
            tail=temp;
            size--;
        }
    }
    public void deleteAtIndex(int index) throws Exception{
        if(head==null){
            throw new Exception("List is Empty");
        }
        else if(head.next==null){
            try {
                deleteFirst();
            }
            catch(Exception e){
                System.out.println(e);
            }
        }
        else if(index==0){
            try {
                deleteFirst();
            }
            catch(Exception e){
                System.out.print(e);
            }
        }
        else if(index==size-1){
            try {
                deleteLast();
            }
            catch(Exception e){
                System.out.println(e);
            }
        }
        else{
            Node temp=head;
            for(int i=1;i<index;i++){
                temp=temp.next;
            }
            temp.next=temp.next.next;
            size--;
        }
    }
    public int middleNumber(){
        Node slow=head;
        Node fast=head;
        while(fast!=null && fast.next!=null){
            fast=fast.next.next;
            slow=slow.next;
        }
        return slow.value;
    }
    public int get(int index){
        Node temp=head;
        for(int i=1;i<=index;i++)
            temp=temp.next;
        return temp.value;
    }
    public void replace(int index,int value){
        Node temp=head;
        for(int i=0;i<=index;i++)
            temp=temp.next;
        temp.value=value;
    }
    public void reverse(){
        Node temp=head;
        reverse(temp);
    }
    public void reverse(Node temp){
        if(temp==null)
            return ;
        reverse(temp.next);
        System.out.print(temp.value+" ");
    }
    public void sort(){
        Node temp=head;
        for(int i=1;i<=size-1;i++){
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
    public Node middle(){
        Node f=head; Node s=head;
        while(f!=null && f.next!=null){
            f=f.next.next;
            s=s.next;
        }
        return s;
    }
    public void displayFromMiddle(){
        Node temp=middle();
        displayFromMiddle(temp);
    }
    public void displayFromMiddle(Node temp){
        while(temp!=null){
            System.out.print(temp.value+" ");
            temp=temp.next;
        }
    }
    public void reverseOfLL(){
        Node temp=head;
        reverseofLL(temp);
    }
    public void reverseofLL(Node temp){
        if(temp==tail){
            head=tail;
            return;
        }
        reverseofLL(temp.next);
        tail.next=temp;
        temp.next=null;
        tail=temp;
    }
    public void display(){
        Node temp=head;
        while(temp!=null){
            System.out.print(temp.value+"-");
            temp=temp.next;
        }
        System.out.print("@");
    }
    class Node{
        int value;
        Node next;
        public Node(int value){
            this.value=value;
        }

    }
    public static void main(String[] args){
        LL a=new LL();
        a.addFirst(19);
        a.addFirst(20);
        a.addFirst(54);
        a.addLast(34);
        a.addLast(23);
        a.addAtIndex(3,78);
        a.display();
        System.out.println(a.size);
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
            a.deleteAtIndex(3);
        }
        catch(Exception e){
            System.out.println(e);
        }
        a.display();
        /*a.middle();
        a.reverseOfLL();
        a.display();*/
    }
}