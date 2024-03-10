public class CLL {
    Node head;
    Node tail;
    int size;
    public void addFirst(int value){
        Node nN=new Node(value);
        nN.next=head;
        if(head==null){
            head=nN;
            tail=head;
        }
        else{
            Node temp=head;
            nN.next=head;
            head=nN;
            tail.next=head;
        }
        size++;
    }
    public void addLast(int value){
        if(head==null){
            addFirst(value);
        }
        else{
            Node nN=new Node(value);
            Node temp=tail;
            tail.next=nN;
            nN.next=head;
            tail=nN;
            size++;
        }
    }
    public void addAtIndex(int index,int value){
        if(index==0){
            addFirst(value);
        }
        else if(index==size-1){
            addLast(value);
        }
        else{
            Node nN=new Node(value);
            Node temp=head;
            for(int i=0;i<index;i++){
                temp=temp.next;
            }
            Node t=temp.next;
            temp.next=nN;
            nN.next=t;
            size++;
        }
    }
    public void deleteFirst()throws Exception{
        if(head==null){
            throw new Exception("List is Empty");
        }
        if(head.next==tail){
            head=tail;
        }
        head=head.next;
        tail=head;
        size--;
    }
    public void deleteLast()throws Exception{
        if(head==null){
            throw new Exception("List is Empty");
        }
        if(head.next==tail){
            try{
                deleteFirst();
            }
            catch(Exception e){
                System.out.println(e);
            }
        }
        else{
            Node temp=head;
            for(int i=0;i<size-1;i++){
                temp=temp.next;
            }
            temp.next=head;
            tail=temp;
            size--;
        }
    }
    public void deleteAtIndex(int index)throws Exception{
        if(head==null){
            throw new Exception("List is Empyt");
        }
        if(index==0){
            try{
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
            for(int i=0;i<index;i++){
                temp=temp.next;
            }
            temp.next=temp.next.next;
            size--;
        }
    }
    public int middleNumb(){
        Node f=head;
        Node s=head;
        do{
            f=f.next.next;
            s=s.next;
        }while(f!=head && f.next!=head);
        return s.value;
    }
    public int get(int index){
        Node temp=head;
        for(int i=0;i<index;i++){
            temp=temp.next;
        }
        return temp.value;
    }
    public void replace(int index,int value){
        Node temp=head;
        for(int i=0;i<index;i++){
            temp=temp.next;
        }
        temp.value=value;
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
    public class Node{
        Node next;
        int value;
        public Node(int value){
            this.value=value;
        }
    }
    public void display(){
        Node temp=head;
        do {
            System.out.print(temp.value+"-");
            temp=temp.next;
        }while(temp!=head);
    }
    public static void main(String[] args){
        CLL a=new CLL();
        a.addFirst(43);
        a.addFirst(23);
        a.addFirst(10);
        a.addFirst(20);
        a.addLast(50);
        a.addAtIndex(2,12);
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
            System.out.println();
        }
        a.addFirst(1);
        a.display();
        System.out.println();
        System.out.println(a.middleNumb());
        System.out.println(a.get(3));
        a.replace(2,40);
        a.sort();
        a.display();
    }
}
