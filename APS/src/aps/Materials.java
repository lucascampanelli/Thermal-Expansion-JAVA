
package aps;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 *
 * @author Guilherme Rodrigues da Silva & Lucas Campanelli de Souza
 */
public class Materials {
    /*
        This method will create a material if there isn't other with the same name, 
        if it works will return a success message, 
        otherwise will return a error message.
    */
    public String create(String[] values){
        String msg = "";
        try {
            FileWriter file = new FileWriter("Materials.txt", true);
            PrintWriter fileWrite = new PrintWriter(file);

            //Brings the txt file to program memory
            Scanner fileRead = new Scanner(new FileReader("Materials.txt"));
            
            //Searches each line till find a material with the same name
            while(fileRead.hasNextLine()){
                String[] line = fileRead.nextLine().split(":");
                if(line[0].equals(values[0])){
                    msg = "A material with the same name already exists.";
                }
            }
            
            //If there is no a material with the same name, writes a new material in the txt file
            if (msg.equals("")){
                fileWrite.println(values[0] + ":"+ values[1]);
                msg = "Material successfully registered!";
            }

            file.close();
			
        }catch(Exception e){
            msg = "An error occurred to write a new material.";
        }
        
        return msg;
    }

    /*
        This method returns an array with two lines,
        the first one shows if everything works well,
        if it was sucessful, the second one shows the material coefficient value
    */
    public String[] read(String name){
        String[] msg = new String[2];
        try {
            //Brings the txt file to program memory.
            Scanner fileRead = new Scanner(new FileReader("Materials.txt"));
            
            //Searchs each line of the txt file a material with the same name.
            while(fileRead.hasNextLine()){
                String[] line = fileRead.nextLine().split(":");
                if(line[0].equals(name)){
                    msg[0] = "true";
                    msg[1] = (String) line[1];
                }
            }
            
            //If there is no a material with the same name, writes in the txt file
            if (msg[0].equals("")){
                msg[0] = "false";
            }
			
        }catch(Exception e){
            msg[0] = "false";
        }
        return msg;
    }
    
    public String delete(String name){
        String msg="";
        
        try {
            Scanner fileRead = new Scanner(new FileReader("Materials.txt"));
            
            String fileCont = "";
            
            while(fileRead.hasNextLine()){
                String line = fileRead.nextLine();
                String[] split = line.split(":");
                
                if(split[0].equals(name)){
                    msg = "Material deletion successful!";
                }else{
                    fileCont += line + "\n";
                }                
            }
            
            FileWriter file = new FileWriter("Materials.txt");
            PrintWriter fileWrite = new PrintWriter(file);
            
            fileWrite.write(fileCont);
            
            file.close();
            
            if (msg.equals("")){
                msg = "There is no material registered with this name.";
            }
        }catch(Exception e){
            msg = "An error occurred to delete this material.";
        } 
        return msg;
    }
    
    //This method updates a material coefficient, if it already exists.
    public String update(String[] values){
        String msg="";
        
        try {            
            //Brings the txt file to program memory
            Scanner fileRead = new Scanner(new FileReader("Materials.txt"));
            
            String fileCont = "";
            //Searches in the text file till find a material with the same name
            while(fileRead.hasNextLine()){
                String line = fileRead.nextLine();
                String[] split = line.split(":");
                if(split[0].equals(values[0])){
                    fileCont += split[0]+":"+values[1] + "\n";
                    msg = "Coefficient deletion was succesful!";
                }else{
                    fileCont += line + "\n";
                }                
            }
            try{
                
            }catch(Exception e){
                
            }
            FileWriter file = new FileWriter("Materials.txt");
            PrintWriter fileWrite = new PrintWriter(file);
            
            fileWrite.write(fileCont);
            
            file.close();
            
            //If there is no a material registered with the same name, writes in the txt file.
            if (msg.equals("")){
                msg = "There is no material registered with this name.";
            }
        }catch(Exception e){
            msg = "An error occurred to change.";
        } 
        return msg;
    }
    
    //This Method shows all materials that exists in txt file
    public void show(){
        try {
            Scanner fileRead = new Scanner(new FileReader("Materials.txt"));
            
            for(int i = 0; fileRead.hasNextLine(); i++){
                if (i!=0){
                    System.out.println(fileRead.nextLine());
                } else{
                    System.out.println("------Table of materials and coefficients-----");
                    fileRead.nextLine();
                }
            }			
        }catch(Exception e){}
    }
}
