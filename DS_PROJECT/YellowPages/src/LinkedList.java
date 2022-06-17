class LinkedList {

        public class Person_Node{
            Person data;
            Person_Node next;
            Person_Node prev;

            Person_Node(Person p){
                data=p;
            }
        }

        Person_Node head;

        public String toString(){
            Person_Node p=head;
            String x="";
            while (p!=null){
                x=x+p.data.name+"\n"+p.data.phone_number+"\n"+p.data.email+"\n"+p.data.address+"\n";
                p=p.next;
            }
            return x;
        }


        public void insert(Person i){
            Person_Node newNode=new  Person_Node(i);

            if (head==null){
                head=newNode;
            }

            else{
                Person_Node T1=head;
                Person_Node T2=head;

                while(T1!=null && i.name.compareTo(T1.data.name)>0){
                    T2=T1;
                    T1=T1.next;
                }

                if (T1==head){
                    head.prev=newNode;
                    newNode.next=head;
                    head=newNode;
                }
                else if(T1==null){
                    T2.next=newNode;
                    newNode.prev=T2;
                }

                else {
                    newNode.next=T1;
                    newNode.prev=T2;
                    T2.next=newNode;
                    T1.prev=newNode;
                }
            }
        }

        public  Person_Node find(String i){
            Person_Node temp=head;
            while (temp!=null){
                if (temp.data.name.toUpperCase().compareTo(i.toUpperCase())==0) return temp;
                temp=temp.next;
            }
            return null;
        }

        public void remove(String i) {
            Person_Node temp = head;
            boolean found=false;
            if (head.data.name.compareTo(i) == 0) head = temp.next;
            while (temp != null && temp.next!=null && found==false) {
                if (temp.next.data.name.compareTo(i) == 0) {
                    temp.next.prev=temp.prev;
                    temp.next = temp.next.next;
                    found=true;
                }
                temp=temp.next;
            }
        }
}
