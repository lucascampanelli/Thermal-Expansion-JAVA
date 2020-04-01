/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aps;

import java.text.DecimalFormat;
import java.text.NumberFormat;

/**
 *
 * @author Gui
 */
public class Math {
    //Recebe um vetor com 3 valores, o primeiro comprimento inicial, coeficiente de 
    //dilatação linear e a variação de temperatura 
    //retorna um vetor com dois valores, um é a variação e a outra é o comprimento final
    public String[] linearDilation(double[] values){
        double dilation = values[0] * values[1] * values[2];
        
        NumberFormat format = new DecimalFormat("0.########");
        
        String results[] = new String[2];
        
        results[0] = format.format(dilation);
        results[1] = format.format(values[0] + dilation);
        
        return results;
    } 
            
    public String[] superficialDilation(double[] values){
        double dilation = values[0] * (values[1] * 2) * values[2];
        
        NumberFormat format = new DecimalFormat("0.########");
        
        String results[] = new String[2];
        
        results[0] = format.format(dilation);
        results[1] = format.format(values[0] + dilation);
        
        return results;
    }
    
    public String[] volumetricDilation(double[] values){
        double dilation = values[0] * (values[1] * 3) * values[2];
        
        NumberFormat format = new DecimalFormat("0.########");
        
        String results[] = new String[2];
        
        results[0] = format.format(dilation);
        results[1] = format.format(values[0] + dilation);
        
        return results;
    }
}
