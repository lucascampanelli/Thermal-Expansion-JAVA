
package aps;

import java.text.DecimalFormat;
import java.text.NumberFormat;

/**
 *
 * @author Guilherme Rodrigues da Silva & Lucas Campanelli de Souza
 */
public class Math {
    /*
        This method receives an array with three values,
        the first one is the initial length,
        the second one is the linear expansion and
        the third one is the temperature variation.
        Returns an array with two values,
        the first one is the variation and
        the second one is the final length.
    */
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
