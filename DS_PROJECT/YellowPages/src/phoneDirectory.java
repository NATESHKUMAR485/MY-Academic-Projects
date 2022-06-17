import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class phoneDirectory {
    BST BST_p=new BST();
    Array people_names=new Array();

    public void clear(){
        for(int i=0;i<26;i++){
            if (people_names.peopleArr[i]!=null){
                people_names.peopleArr[i].head=null;
            }
        }
    }

    public void load_peopleLL(){

        try {
            FileInputStream fis=new FileInputStream("people_directory.txt");
            Scanner sc=new Scanner(fis);
            while(sc.hasNextLine())  {
                Person p=new Person();
                p.name=sc.nextLine().strip();
                p.phone_number=Long.parseLong(sc.nextLine());
                p.email=sc.nextLine().strip();
                p.address=sc.nextLine().strip();
                // BST_p.insert(p);
                people_names.Insert(p);
            }
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }

    }

    public void load_peopleBST(){
        try {
            FileInputStream fis=new FileInputStream("people_directory.txt");
            Scanner sc=new Scanner(fis);
            while(sc.hasNextLine())  {
                Person p=new Person();
                p.name=sc.nextLine().strip();
                p.phone_number=Long.parseLong(sc.nextLine().strip());
                p.email=sc.nextLine().strip();
                p.address=sc.nextLine().strip();
                BST_p.insert(p);
                //people_names.Insert(p);
            }

        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
    }

    public void save_peopleLL(){
        try {

            FileWriter myWriter = new FileWriter("people_directory.txt",false);
            for (int i = 0; i < 26;i++){
                if(people_names.peopleArr[i]!=null){
                    myWriter.write(people_names.peopleArr[i].toString());
                }
            }
            myWriter.close();
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public void save_peopleBST(){
        try {

            FileWriter myWriter = new FileWriter("people_directory.txt",false);
            myWriter.write(BST_p.MakeString());
            myWriter.close();

        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

}
