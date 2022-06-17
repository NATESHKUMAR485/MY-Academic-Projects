import java.io.File;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.FileWriter;
public class Natesh22983
    {
     public static String ReadFile(String filename)
        {
            String  html = "";
            try
            {
                File file = new File(filename);
                Scanner myReader = new Scanner(file);
                int type = 0;
                String color = "", alignment = "";
                html = "<!DOCTYPE html>\n<html>\n\t<style>\nbody" ;
                while (myReader.hasNextLine())
                {
                    String data = myReader.nextLine();
                    data = data.toUpperCase();
                    String[] parts = data.split(" ");
                    int option = 0;
                    int width =0;
                    int height =0;
                    String text2 = new String();
                    for(int i = 0; i<parts.length; i++)
                    {
                        if(parts[0].charAt(0)=='H')
                        {
                            type = Integer.parseInt(parts[0].substring(1,2));
                            option = 0;
                            color = parts[1].toLowerCase();
                            alignment = parts[2].toLowerCase();
                        }
                       
                        else if(parts[0].equals("PARA"))
                        {
                            option = 1;
                            color = parts[1].toLowerCase();
                            alignment = parts[2].toLowerCase();
                        }
                        else if(parts[0].equals("IMG"))
                        {
                            option = 2;
                            width = Integer.parseInt(parts[1]);
                            height = Integer.parseInt(parts[2]);
                            alignment = parts[3].toLowerCase();
                        }
                        
                        else if(parts[0].equals("LINK"))
                        {
                            option = 3;
                            text2 = parts[1];
                            alignment = parts[2];
                        }
                        else if(parts[0].equals("QUOTE"))
                        {
                            option = 4;
                            color = parts[1].toLowerCase();
                            alignment = parts[2].toLowerCase();
                        }
                        else if(parts[0].equals("BI"))
                        {
                            option = 5;
                        }
                    }

                    data = myReader.nextLine();
                    switch(option)
                    {
                        case 0:
                            html += HEADING(type, color, data,alignment);
                            break;
                        case 1:
                            html += PARA(data,color, alignment);
                            break;
                        case 2:
                            html += IMG(data,width,height, alignment);
                            break;
                        case 3:
                            html += LINK(data, text2, alignment);
                            break;
                        case 4:
                            html += QUOTE(data,color,alignment);
                            break;
                        case 5:
                            html += BACKROUNDIMAGE(data);
                            break;
                    }

                }
                html += "\n\t</body>\n</html>";
                myReader.close();
            }
            catch (FileNotFoundException e)
                {
                System.out.println("File not found.");
                e.printStackTrace();
                }
                return html;
    }


        public static String HEADING(int type, String color, String text, String alignment)
        {
            String heading = "";
            heading += "\n\t\t<h" +type + " style=\"color:" + color + ";text-align:" + alignment +";\">" + text + "</h" + type + ">";
            return heading;
        }

        public static String PARA(String text, String color, String alignment)
        {
            String para = "";
            para += "\n\t\t<p style=background-color:" + color + ";text-align:" + alignment + ";>\n\t\t" + text + "\n\t\t</p>";
            return para;
        }
        public static String IMG(String text, int width, int height, String alignment)
            {
                String image = "";
                if (alignment.charAt(0)=='c')
                    {
                        image += "\n\t\t<center> <img src=" + text + " width=" + width + " height=" + height + ">" + "\n</center>";
                    }
                    else
                    {
                        image += "\n\t\t<center> <img src=" + text + " width=" + width + " height=" + height + ">" + "\n</center>";
                    }
                    return image;
            }
        public static String LINK(String text, String Linktext, String alignment)
            {
                String link = "";
                link += "\n<p style=text-align:" + alignment +";>" + "<a style=color:white; href=" + text + ">" + Linktext + "</a></p>";
                return link;
            }
        public static String QUOTE(String text, String color, String alignment)
            {
                String quote = "";
                quote += "<p style=\"color: " + color  + ";text-align:" + alignment + ";\">" + "<q>" + text + "</q></p>";
                return quote;
            }
         public static String BACKROUNDIMAGE(String text)
            {
                String Bi = "";
                Bi += " { \n\t background-image: url('" + text + "');\nbackground-size: cover;\n}\n</style>\n<body>";
                return Bi;
            }

        //Writing files
        public static void WriteFile(String filename, String text)
        {
            try
            {
                FileWriter myWriter = new FileWriter(filename);
                myWriter.write(text);
                myWriter.close();
            }
            catch (IOException e)
            {
                System.out.println("An error occurred.");
                e.printStackTrace();
            }
        }

        public static void main(String[] args)
        {
            String html = ReadFile("C:\\Natesh22983\\Index.txt");
            WriteFile("C:\\Natesh22983\\Index.html", html);
            html = ReadFile("C:\\Natesh22983\\About.txt");
            WriteFile("C:\\Natesh22983\\About.html", html);
            html = ReadFile("C:\\Natesh22983\\School.txt");
            WriteFile("C:\\Natesh22983\\School.html", html);
            html = ReadFile("C:\\Natesh22983\\Hobby.txt");
            WriteFile("C:\\Natesh22983\\Hobby.html", html);
        }
    }

