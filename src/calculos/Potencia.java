
package calculos;

    /**
     *
     * <h1>Classe responsável por realizar a potenciação entre base e expoente.</h1>
     *
     * <p>
     * Realiza a potenciação entre base e expoente</p>
     *
     *
     * @author Henrique
     *
     * @see Potencia
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
