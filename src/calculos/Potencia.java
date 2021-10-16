/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculos;

/**
 *
 * @author Usuario
 */
public class Potencia {
    
    public static double potencia(double base, Integer exp) {
        double res = 1;
        double d;
        
        if (exp > 0) {
            
            for (int i = 0; i < exp; i++) {
                res *= base;
            }
            
        } 
        
        else if (exp < 0) {
            
            for (int i = 0; i < exp * (-1); i++) {
                res *= base;
            }
            d = 1 / res;
            res = d;
            
        }
        
        return res;
    
    }
    
}
