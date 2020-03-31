/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aps;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 *
 * @author Gui
 */
public class Materials {
    public String write(String name, double coefficient){
        String msg = "";
        try {
            FileWriter file = new FileWriter("Materials.txt", true);
            PrintWriter fileWrite = new PrintWriter(file);

            //Traz o txt para a memória do programa
            Scanner fileRead = new Scanner(new FileReader("Materials.txt"));
            
            //Vai ficar procurando no arquivo até encontrar um registro
            //igual
            while(fileRead.hasNextLine()){
                String[] line = fileRead.nextLine().split(":");
                if(line[0].equals(name)){
                    msg = "Já existe um material com esse nome";
                }
            }
            
            //Se depois de procurar um material com o mesmo nome e não achar 
            //ele escreverá no txt
            if (msg.equals("")){
                fileWrite.println(name + ":"+ coefficient);
                msg = "Material Cadastrado com sucesso";
            }

            file.close();
			
        }catch(Exception e){
            msg = "Ocorreu um erro na hora de escrever";
        }
        
        return msg;
    }
    
    //Esse método ira retornar um vetor, o primeiro campo estará informando
    //se ocorreu tudo corretamente, caso positivo terá um segundo campo com o
    //valor do coeficiente do material
    public String[] read(String name){
        String[] msg = new String[2];
        try {
            //Traz o txt para a memória do programa
            Scanner fileRead = new Scanner(new FileReader("Materials.txt"));
            
            //Vai ficar procurando no arquivo até encontrar um registro
            //igual
            while(fileRead.hasNextLine()){
                String[] line = fileRead.nextLine().split(":");
                if(line[0].equals(name)){
                    msg[0] = "true";
                    msg[1] = (String) line[1];
                }
            }
            
            //Se depois de procurar um material com o mesmo nome e não achar 
            //ele escreverá no txt
            if (msg[0].equals("")){
                msg[0] = "false";
            }
			
        }catch(Exception e){
            msg[0] = "false";
        }
        return msg;
    }
    
    public void delete(){
        //Falta fazer
    }
    
    public void update(){
        //Falta fazer
    }
}
