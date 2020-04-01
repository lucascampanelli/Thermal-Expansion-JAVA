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
        Scanner scannerValue = new Scanner(System.in);
        
        int operation;
        String[] values = new String[2];
        double[] numbers = new double[3]; 
        
        Materials materials = new Materials();
        
        Math math = new Math();
        do{
            System.out.println("\n*****Calculadora de dilatação de sólidos*****");
            System.out.println("\nDigite o número referente a opção desejada");
            System.out.println("1 - Mostrar todos os materiais já cadastrados");
            System.out.println("2 - Incluir material");
            System.out.println("3 - Alterar o coeficiente do material");
            System.out.println("4 - Excluir material");
            System.out.println("5 - Calcular a dilatação linear");
            System.out.println("6 - Calcular a dilatação superficial");
            System.out.println("7 - Calcular a dilatação volumétrica");
            System.out.println("0 - Sair");
            
            operation = selector.nextInt();
            
            switch(operation){
                case 1:
                    clearScreen();
                    
                    System.out.println("Todos os materiais cadastrados");
                    
                    materials.show();
                    break;
                case 2:
                    clearScreen();
                    
                    System.out.println("Informe o nome do material, de preferência tudo em minúsculo");
                    values[0] = scannerValue.nextLine();
                    
                    System.out.println("Informe o coeficiente do material");
                    values[1] = scannerValue.nextLine();
                    
                    System.out.println(materials.create(values));
                    
                    break;
                case 3:
                    clearScreen();
                    
                    System.out.println("Informe o nome do material, igual ao que aparece na listagem");
                    values[0] = scannerValue.nextLine();
                    
                    System.out.println("Informe o novo coeficiente do material");
                    values[1] = scannerValue.nextLine();
                    
                    System.out.println(materials.update(values));
                    break;
                case 4:
                    clearScreen();
                    
                    System.out.println("Informe o nome do material, igual ao que aparece na listagem");
                    values[0] = scannerValue.nextLine();
                    
                    System.out.println(materials.delete(values[0]));
                    break;
                case 5:
                    clearScreen();
                    
                    System.out.println("Informe o nome do material, igual ao que aparece na listagem");
                    values[0] = scannerValue.nextLine();
                    
                    values = materials.read(values[0]);
                     
                    if (values[0].equals("true")){
                        System.out.println("Informe o comprimento inicial");
                        numbers[0] = Double.parseDouble(scannerValue.nextLine());
                        
                        numbers[1] = Double.parseDouble(values[1]);
                                
                        System.out.println("Informe a variação de temperatura");
                        numbers[2] = Double.parseDouble(scannerValue.nextLine());
                        
                        values = math.linearDilation(numbers);
                        System.out.println("A variação do material foi de: "+ values[0]);
                        System.out.println("O comprimento final é: "+ values[1]);
                        
                    } else{
                        System.out.println("Não existe nenhum material cadastrado com esse nome");
                        
                    }
                    break;
                case 6:
                    clearScreen();
                    
                    System.out.println("Informe o nome do material, igual ao que aparece na listagem");
                    values[0] = scannerValue.nextLine();
                    
                    values = materials.read(values[0]);
                     
                    if (values[0].equals("true")){
                        System.out.println("Informe o comprimento inicial");
                        numbers[0] = Double.parseDouble(scannerValue.nextLine());
                        
                        numbers[1] = Double.parseDouble(values[1]);
                                
                        System.out.println("Informe a variação de temperatura");
                        numbers[2] = Double.parseDouble(scannerValue.nextLine());
                        
                        values = math.superficialDilation(numbers);
                        System.out.println("A variação do material foi de: "+ values[0]);
                        System.out.println("O comprimento final é: "+ values[1]);
                        
                    } else{
                        System.out.println("Não existe nenhum material cadastrado com esse nome");
                        
                    }                    
                    break;
                case 7:
                    clearScreen();
                    
                    System.out.println("Informe o nome do material, igual ao que aparece na listagem");
                    values[0] = scannerValue.nextLine();
                    
                    values = materials.read(values[0]);
                     
                    if (values[0].equals("true")){
                        System.out.println("Informe o comprimento inicial");
                        numbers[0] = Double.parseDouble(scannerValue.nextLine());
                        
                        numbers[1] = Double.parseDouble(values[1]);
                                
                        System.out.println("Informe a variação de temperatura");
                        numbers[2] = Double.parseDouble(scannerValue.nextLine());
                        
                        values = math.volumetricDilation(numbers);
                        System.out.println("A variação do material foi de: "+ values[0]);
                        System.out.println("O comprimento final é: "+ values[1]);
                        
                    } else{
                        System.out.println("Não existe nenhum material cadastrado com esse nome");
                        
                    }
                    break;
                default:
                    operation = 0;
                    break;
            }
        }while(operation != 0);
        
        
        

    }
    
    public static void clearScreen(){
        for(int i = 0;i < 20;i++){
            System.out.println("");
        }
    }
    
}
