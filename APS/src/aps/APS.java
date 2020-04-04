
package aps;

import java.util.Scanner;

/**
 *
 * @author Guilherme Rodrigues da Silva & Lucas Campanelli de Souza
 */
public class APS {

    public static void main(String[] args) {
        
        Scanner selector = new Scanner(System.in);
        Scanner scannerValue = new Scanner(System.in);
        
        int operation;
        String[] values = new String[2];
        double[] numbers = new double[3]; 
        
        Materials materials = new Materials();
        
        Math math = new Math();
        do{
            System.out.println("\n*****Solids expansion calculator*****");
            System.out.println("\nType a number to choose an option");
            System.out.println("1 - Show all materials registered");
            System.out.println("2 - Register a material");
            System.out.println("3 - Change a material coefficient");
            System.out.println("4 - Delete a material");
            System.out.println("5 - Calculate linear expansion");
            System.out.println("6 - Calculate superficial expansion");
            System.out.println("7 - Calculate volumetric expansion");
            System.out.println("0 - Exit");
            
            operation = selector.nextInt();
            
            switch(operation){
                case 1:
                    clearScreen();
                    
                    System.out.println("All registered materials");
                    
                    materials.show();
                    break;
                case 2:
                    clearScreen();
                    
                    System.out.println("Type the name of the material, preferably all lowercase.");
                    values[0] = scannerValue.nextLine();
                    
                    System.out.println("Type the material coefficient.");
                    values[1] = scannerValue.nextLine();
                    
                    System.out.println(materials.create(values));
                    
                    break;
                case 3:
                    clearScreen();
                    
                    System.out.println("Type the material name as it appears in the list.");
                    values[0] = scannerValue.nextLine();
                    
                    System.out.println("Type the new material coefficient.");
                    values[1] = scannerValue.nextLine();
                    
                    System.out.println(materials.update(values));
                    break;
                case 4:
                    clearScreen();
                    
                    System.out.println("Type the material name as it appears in the list.");
                    values[0] = scannerValue.nextLine();
                    
                    System.out.println(materials.delete(values[0]));
                    break;
                case 5:
                    clearScreen();
                    
                    System.out.println("Type the material name as it appears in the list.");
                    values[0] = scannerValue.nextLine();
                    
                    values = materials.read(values[0]);
                     
                    if (values[0].equals("true")){
                        System.out.println("Type the initial length.");
                        numbers[0] = Double.parseDouble(scannerValue.nextLine());
                        
                        numbers[1] = Double.parseDouble(values[1]);
                                
                        System.out.println("Type the temperature variation.");
                        numbers[2] = Double.parseDouble(scannerValue.nextLine());
                        
                        values = math.linearDilation(numbers);
                        System.out.println("The material variation was: "+ values[0]);
                        System.out.println("The length is: "+ values[1]);
                        
                    } else{
                        System.out.println("There is no material registered with this name.");
                        
                    }
                    break;
                case 6:
                    clearScreen();
                    
                    System.out.println("Type the material name as it appears in the list.");
                    values[0] = scannerValue.nextLine();
                    
                    values = materials.read(values[0]);
                     
                    if (values[0].equals("true")){
                        System.out.println("Type the initial length.");
                        numbers[0] = Double.parseDouble(scannerValue.nextLine());
                        
                        numbers[1] = Double.parseDouble(values[1]);
                                
                        System.out.println("Type the temperature variation.");
                        numbers[2] = Double.parseDouble(scannerValue.nextLine());
                        
                        values = math.superficialDilation(numbers);
                        System.out.println("The material variation was: "+ values[0]);
                        System.out.println("The final length is: "+ values[1]);
                        
                    } else{
                        System.out.println("There is no material registered with this name.");
                        
                    }                    
                    break;
                case 7:
                    clearScreen();
                    
                    System.out.println("Type the material name as it appears in the list.");
                    values[0] = scannerValue.nextLine();
                    
                    values = materials.read(values[0]);
                     
                    if (values[0].equals("true")){
                        System.out.println("Type the initial length.");
                        numbers[0] = Double.parseDouble(scannerValue.nextLine());
                        
                        numbers[1] = Double.parseDouble(values[1]);
                                
                        System.out.println("Type the temperature variation.");
                        numbers[2] = Double.parseDouble(scannerValue.nextLine());
                        
                        values = math.volumetricDilation(numbers);
                        System.out.println("The material variation was: "+ values[0]);
                        System.out.println("The final length is: "+ values[1]);
                        
                    } else{
                        System.out.println("There is no material registered with this name.");
                        
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
