class Array {
        LinkedList[] peopleArr =new LinkedList[26];


        public void initialize(int i){
            peopleArr[i]=new LinkedList();
        }

        public void Insert(Person p){

            String up=p.name.toUpperCase();
            char ch=up.charAt(0);
            int index = ch - 65;
            if (peopleArr[index]==null) initialize(index);
                peopleArr[index].insert(p);
        }
        public LinkedList.Person_Node find(String name){
            String up= name.toUpperCase();
            char ch=up.charAt(0);
            int index = ch - 65;
            if (peopleArr[index]==null) return null;
            else return(peopleArr[index].find(name));
        }
        public void delete(String name){
            String up= name.toUpperCase();
            char ch=up.charAt(0);
            int index = ch - 65;
            if (peopleArr[index]!=null) peopleArr[index].remove(name);

        }
        //O(1)
        public String toString(){
            String x="";
            for (int i = 0; i <26 ; i++) {
                if (peopleArr[i]!=null)
                    x=x+ peopleArr[i].toString();
            }
            return x;
        }

}
