/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aps;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 *
 * @author Gui
 */
public class Materials {
    //metodo que ira criar o material caso não tenha nenhum outro com esse mesmo 
    //nome, se der tudo certo retornará mensagem de sucesso,senão retorna 
    //uma mensagem de erro
    public String create(String name, String coefficient){
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
    
    public String delete(String name){
        String msg="";
        
        try {
            Scanner fileRead = new Scanner(new FileReader("Materials.txt"));
            
            String fileCont = "";
            
            while(fileRead.hasNextLine()){
                String line = fileRead.nextLine();
                String[] split = line.split(":");
                
                if(split[0].equals(name)){
                    msg = "Material apagado com sucesso!";
                }else{
                    fileCont += line + "\n";
                }                
            }
            
            FileWriter file = new FileWriter("Materials.txt");
            PrintWriter fileWrite = new PrintWriter(file);
            
            fileWrite.write(fileCont);
            
            file.close();
            
            if (msg.equals("")){
                msg = "Não existe nenhum material cadastrado com esse nome!";
            }
        }catch(Exception e){
            msg = "Ocorreu um erro na hora de apagar!";
        } 
        return msg;
    }
    
    //Método para a atualização de um coeficiente caso já exista no txt e retornará
    //uma mensagem de erro, caso não ele retornará uma mensagem de erro 
    public String update(String name, String coefficient){
        String msg="";
        
        try {            
            //Traz o txt para a memória do programa
            Scanner fileRead = new Scanner(new FileReader("Materials.txt"));
            
            String fileCont = "";
            //Vai ficar procurando no arquivo até encontrar um registro igual
            while(fileRead.hasNextLine()){
                String line = fileRead.nextLine();
                String[] split = line.split(":");
                if(split[0].equals(name)){
                    fileCont += split[0]+":"+coefficient + "\n";
                    msg = "Coeficiente alterado com sucesso!";
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
            
            //Se depois de procurar um material com o mesmo nome e não achar 
            //ele escreverá no txt
            if (msg.equals("")){
                msg = "Não existe nenhum material cadastrado com esse nome";
            }
        }catch(Exception e){
            msg = "Ocorreu um erro na hora de alterar!";
        } 
        return msg;
    }
    
    //Metodo para exibir todos os materiais que existe no txt
    public void show(){
        try {
            Scanner fileRead = new Scanner(new FileReader("Materials.txt"));
            
            for(int i = 0; fileRead.hasNextLine(); i++){
                if (i!=0){
                    System.out.println(fileRead.nextLine());
                } else{
                    System.out.println("------Tabela de Materiais e Coeficientes-----");
                    fileRead.nextLine();
                }
            }			
        }catch(Exception e){}
    }
}
