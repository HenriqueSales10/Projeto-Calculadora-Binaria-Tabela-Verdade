package conversao;

import calculos.Potencia;
import javax.swing.JOptionPane;
import static calculos.Potencia.potencia;

public class Conversor {

    //ATRIBUTOS:
    private String N1 = "";
    private int base1 = 10;
    private int base2 = 2;
    int aux;
    int num;
    String tabHex = "0123456789ABCDEF";
    String resultado;
    
    public String getResultado() {
        return resultado;
    }

    public void setResultado(String resultado) {
        this.resultado = resultado;
    }
    
    //METODOS:
    public String getN1() {
        return N1;
    }

    public void setN1(String N1) throws Exception {
        this.N1 = N1;
    }

    public int getBase1() {
        return base1;
    }

    public int getBase2() {
        return base2;
    }

    public void setBase1(int base1) {
        this.base1 = base1;
    }

    public void setBase2(int base2) {
        this.base2 = base2;
    }

    public String decimalHex(String decimal) {
        int res;
        char[] hexa = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
        String valorHexadecimal = "";
        int dec = Integer.parseInt(decimal);
         
        while (dec > 0) {
              
            res = dec % 16;
            valorHexadecimal = hexa[res] + valorHexadecimal;
            dec = dec / 16;
            
          }
        resultado = valorHexadecimal;
        return resultado;
    }

    public String decimalBin(String decimal) {
        resultado = "";
          while (Integer.parseInt(decimal) > 0) {
              
            resultado = Integer.parseInt(decimal) % base2 + resultado;
            decimal = "" + (Integer.parseInt(decimal) / base2);
            
          }
        return resultado;
    }

    public String binDec(String binario) {
        aux = 0;
        num = 0;
        resultado = "";
          
        while (Integer.parseInt(binario) > 0) {
           
            num = (int) (Potencia.potencia(2, aux) * (Integer.parseInt(binario) % 10) + num);
            aux++;
            binario = "" + (Integer.parseInt(binario) / 10);
            
          }
        resultado = "" + num;
        return resultado;
    }

    public String binHex(String binario) {
        String hexadecimal = "";
        int bin = Integer.parseInt(binario);
        int aux, cont = 0, acumulador = 0;
          
        while (bin > 0) {
            
            acumulador = 0;
            cont = 0;

             while (cont < 4) {

                aux = bin % 10;

                if (aux == 1) {

                    //Primeira posição (direita)
                    switch (cont) {
                        case 0:
                            acumulador = acumulador + 1;
                            break;
                        case 1:
                            acumulador = acumulador + 2;
                            break;
                        case 2:
                            acumulador = acumulador + 4;
                            break;
                        case 3:
                            acumulador = acumulador + 8;
                            break;
                        default:
                            break;
                    }
                }

                bin = bin / 10;
                cont++;
             }

            if (acumulador <= 9) {
                hexadecimal = acumulador + hexadecimal;
            } else if (acumulador > 9) {
                
                switch (acumulador) {
                   
                    case 10:
                        hexadecimal = "A" + hexadecimal;
                        break;
                    case 11:
                        hexadecimal = "B" + hexadecimal;
                        break;
                    case 12:
                        hexadecimal = "C" + hexadecimal;
                        break;
                    case 13:
                        hexadecimal = "D" + hexadecimal;
                        break;
                    case 14:
                        hexadecimal = "E" + hexadecimal;
                        break;
                    case 15:
                        hexadecimal = "F" + hexadecimal;
                        break;
                    default:
                        break;
                }
                
            }
            
           }

        resultado = hexadecimal;
        return resultado;

    }

    public String hexDec(String numeroHex) {
        int res, numDec = 0, i = 0;

        for (i = 0; i < numeroHex.length(); i++) {

            char c = numeroHex.charAt(i);
            int d = tabHex.indexOf(c);
            numDec = 16 * numDec + d;
            
        }

        resultado = Integer.toString(numDec);

        return resultado;
    }

    public String hexBin(String numeroHexadecimal) {
        String decimal = hexDec(numeroHexadecimal);

        String binario = decimalBin(decimal);

        resultado = binario;

        return binario;
    }

    public String mudarBase() throws Exception {
        resultado = "";

        // CONVERSAO DECIMAL
        if (base1 == 10) {

            //DECIMAL P./HEXADECIMAL
            if (base2 == 16) {
                
                decimalHex(N1);
                
            } //Decimal para binário
            else {
                decimalBin(N1);
            }
        } 

        //CONVERSAO BINARIO 
        else if (base1 == 2) {

            aux = 0;
            num = 0;

            //BINARIO PARA DECIMAL
            if (base2 == 10) {
                
                binDec(N1);
                
            } //BINARIO PARA HEXADECIMAL
            else if (base2 == 16) {
                
                binHex(N1);
                
            }

        } 

        //CONVERSAO HEXADECIMAL  
        else if (base1 == 16) {

            // HEXADECIMAL PARA DECIMAL
            if (base2 == 10) {
                
                hexDec(N1);
                
            } // HEXADECIMAL PARA BINARIO
            else if (base2 == 2) {
                
                hexBin(N1);
                
            }
        }
        return resultado;
    }
}
