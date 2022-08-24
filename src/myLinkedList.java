public class myLinkedList<V> {

    private myNode head=null;
    private myNode tail=null;
    private int len=0;

    public myNode getHead() {
        return head;
    }

    public void setHead(myNode head) {
        this.head = head;
    }

    public myNode getTail() {
        return tail;
    }

    public void setTail(myNode tail) {
        this.tail = tail;
    }

    public int getLen() {
        return len;
    }

    public void setLen(int len) {
        this.len = len;
    }

    public void add(V data){
        myNode node= new myNode(data);
        node.setNext(null);
        this.len+=1;
        if (tail==null){ //list is empty
            this.head=node;
            this.tail=node;
            node.setPrev(null);
        }
        this.tail.setNext(node);
        node.setPrev(this.tail);
        this.tail=node;
    }
    public void remove(myNode node){
        if (this.len==1){
            this.head=null;
            this.tail=null;
        }
        else if (node==this.head){ //node is head
            myNode new_head=this.head.getNext();
            this.head.setNext(null);
            new_head.setPrev(null);
            this.head=new_head;
        }
        else if(node==this.tail){ //node is tail
            myNode new_tail= this.tail.getPrev();
            this.tail.setPrev(null);
            new_tail.setNext(null);
            this.tail=new_tail;
        }
        else{
            myNode next=node.getNext();
            myNode prev= node.getPrev();
            node.setNext(null);
            node.setPrev(null);
            prev.setNext(next);
            next.setPrev(prev);
        }
        this.len-=1;
    }

    public String toString(){
        myNode node=head;
        String ret="";
        while (node!=null){
            ret=ret+" "+node.getVal();
            node=node.getNext();
        }
        return ret;
    }
    }


