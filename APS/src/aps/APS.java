/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aps;

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
        
        //Apenas para teste dos metodos da classe Materials
        Materials rm = new Materials();        
        String material = rm.delete("chumbo");
        System.out.println(material);
        rm.show();
        //---------------------------
    }
    
}
