public class CustomStack {
    protected int data[];
    int Default_Size=10;
    int ptr=-1;
    public CustomStack(int size){
        this.data=new int[size];
    }
    public CustomStack( ){
        this.data=new int[Default_Size];
    }
    public boolean isFull(){
        if(ptr==data.length-1)
            return true;
        else
            return false;
    }
    public void push(int value) throws Exception{
        if(isFull())
            throw new Exception("Stack is Full");
        ptr++;
        data[ptr]=value;
    }

    public boolean isEmpty(){
        if(ptr==-1)
            return true;
        else
            return false;
    }
    public int pop()throws Exception{
        if(isEmpty())
            throw new Exception("Stack is Empty");
        int k=data[ptr];
        ptr--;
        return k;
    }
    public void display(){
        int i=0;
        while(i<=ptr){
            System.out.print(data[i++]+" ");
        }
    }
    public String toString(){
        String s="[";
        int i=0;
        while(i<=ptr){
            if(i==0)
                s=s+data[i++];
            else
                s=s+", "+data[i++];
        }
        s=s+"]";
        return s;
    }
}
class DynamicStack extends CustomStack
{
    public DynamicStack(){
        super();
    }
    public DynamicStack(int size){
        super(size);
    }
    public void push(int value) throws Exception{
        if(isFull()){
            int temp[]=new int[data.length*2];
            for(int i=0;i<data.length;i++)
                temp[i]=data[i];
            data=temp;
        }
        super.push(value);
    }
    public int size(){
        return ptr+1;
    }
    public int capacity(){
        return data.length;
    }
}
class Main1
{
    public static void main(String[] args){
        DynamicStack a=new DynamicStack();
        try{
            a.push(10);
        }
        catch(Exception e){
            System.out.println(e);
        }
        try{
            a.push(20);
        }
        catch(Exception e){
            System.out.println(e);
        }
        try{
            a.push(30);
        }
        catch(Exception e){
            System.out.println(e);
        }
        try{
            a.push(40);

        }
        catch(Exception e){
            System.out.println(e);
        }
        a.display();
        System.out.print("\n"+a);
        try{
            a.pop();
        }
        catch(Exception e){
            System.out.println(e);
        }
        a.display();
    }
}
