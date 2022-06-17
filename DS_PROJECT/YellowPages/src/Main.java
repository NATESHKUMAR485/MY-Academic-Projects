import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        phoneDirectory yp = new phoneDirectory();
        yp.load_peopleLL();
        int exit = 0;
        do {
            Scanner myObj = new Scanner(System.in);  // Create a Scanner object
            System.out.println("=====================MENU======================");
            System.out.println("==> Enter 1 to add contact.");
            System.out.println("==> Enter 2 to search contact.");
            System.out.println("==> Enter 3 to delete contact.");
            System.out.println("==> Enter 4 to display all contacts.");
            System.out.println("==> Enter 5 to exit the progran.");
            System.out.println("=====================****======================");
            System.out.print("Enter the number to run the function: ");
            int choice = myObj.nextInt();

            switch (choice) {
                case 1:

                    System.out.print("Enter name: ");
                    String namefake = myObj.nextLine();
                    String name = myObj.nextLine();

                    System.out.print("Enter number: ");
                    Long num = myObj.nextLong();

                    System.out.print("Enter email: ");
                    String emailfake = myObj.nextLine();
                    String email = myObj.nextLine();

                    System.out.print("Enter address: ");
                    String address = myObj.nextLine();




                    //yp.load_peopleLL();
                    if (name == null) name = "-";
                    if (email == null) email = "-";
                    if (address == null) address = "-";
                    if (num == null) num = Long.parseLong(0 + " ");


                    Person p = new Person();
                    p.setName(name);
                    p.setPhone_number(num);
                    p.setEmail(email);
                    p.setAddress(address);
                    yp.people_names.Insert(p);
                    yp.save_peopleLL();

                    break;

                case 2:
                    System.out.print("enter the number you want to search: ");
                    Long key1 = myObj.nextLong();
                    yp.load_peopleBST();
                    Node temp1;
                    temp1 = yp.BST_p.find(key1);
                    if (temp1 == null) {
                        System.out.println("not found");
                    } else {
                        System.out.println(temp1.data.name);
                        String x = String.valueOf(temp1.data.phone_number);
                        System.out.println(x);
                        System.out.println(temp1.data.email);
                        System.out.println(temp1.data.address);
                    }
                    break;

                case 3:

                    System.out.print("enter the number: ");
                    Long key2 = myObj.nextLong();
                    yp.load_peopleBST();
                    yp.BST_p.delete(key2);
                    yp.save_peopleBST();

                    break;

                case 4:
                    //yp.load_peopleLL();
                    String temp="Personal Contacts";
                    for(int i=0;i<26;i++){
                        String name1;
                        Long num1;
                        String email1;
                        String address1;
                        if(yp.people_names.peopleArr[i]!=null){
                            LinkedList.Person_Node x=yp.people_names.peopleArr[i].head;
                            while (x!=null){
                                name1=x.data.getName();
                                num1=x.data.getPhone_number();
                                email1=x.data.getEmail();
                                address1=x.data.getAddress();
                                System.out.printf("%s , %d , %s , %s \n",name1,num1,email1,address1);
                                x=x.next;
                            }
                        }
                    }
                    break;

                case 5:
                    exit+=1;
                    break;
            }
        }
        while (exit == 0) ;

    }



}
