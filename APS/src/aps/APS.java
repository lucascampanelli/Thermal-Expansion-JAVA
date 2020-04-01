/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aps;

import java.util.Scanner;

/**
 *
 * @author Gui
 */
public class APS {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner selector = new Scanner(System.in);
        int operation = 0;
        do{
            System.out.println("*****Calculadora de dilatação de sólidos*****");
            System.out.println("\nDigite o número referente a opção desejada");
            System.out.println("1 - Mostrar todos os materiais já cadastrados");
            System.out.println("2 - Incluir material");
            System.out.println("3 - Excluir material");
            System.out.println("4 - ");
            System.out.println("5 - ");
            System.out.println("6 - ");
            System.out.println("0 - Sair");
        }while(operation != 0);
        
        
        

    }
    
    public static void clearScreen(){
        for(int i = 0;i < 15;i++){
            System.out.println("");
        }
    }
    
}
