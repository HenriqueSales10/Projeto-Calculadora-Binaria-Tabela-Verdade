
package calculos;

import conversao.Conversor;

    /**
     *
     * <h1>Classe responsável por realizar o cálculo de adição, multiplicação e subtração de números de base 10, base 2 e base 16.</h1>
     *
     * <p>
     * Realiza o cálculo das expressões</p>
     *
     *
     * @author Henrique
     *
     * @see Calculadora
     */
public class Calculadora {

    private String n1, n2;
    private char op;
    private int baseN1 = 10;
    private int baseN2 = 2;

    Conversor converter = new Conversor();
    
    String resultado;

    public String getN1() {
        return n1;
    }

    public void setN1(String n1) {
        this.n1 = n1;
    }

    public String getN2() {
        return n2;
    }

    public void setN2(String n2) {
        this.n2 = n2;
    }

    public char getOp() {
        return op;
    }

    public void setOp(char op) {
        this.op = op;
    }

    public int getBaseN1() {
        return baseN1;
    }

    public void setBaseN1(int baseN1) {
        this.baseN1 = baseN1;
    }

    public int getBaseN2() {
        return baseN2;
    }

    public void setBaseN2(int baseN2) {
        this.baseN2 = baseN2;
    }

    public String getResultado() {
        return resultado;
    }

    public void setResultado(String resultado) {
        this.resultado = resultado;
    }

    /**
     *
     * <h1>Método responsável por realizar os cálculos de adição, 
     * subtração e multiplicação entre números decimais e hexadecimais.</h1>
     * 
     *
     * <p>
     * Realiza os cálculos de números decimais e hexadecimais</p>
     *
     *
     * @author Henrique
     *
     * @see operacoesDecHex
     */
    public String operacoesDecHex(String decimal, String hexadecimal) {
        int numDecimal = Integer.parseInt(decimal);
        String numHexa = converter.hexDec(hexadecimal);
        String txt = "Binário: ";

        switch (op) {
            case '+':
                int res = numDecimal + Integer.parseInt(numHexa);
                resultado = txt + converter.decimalBin(Integer.toString(res));
                break;
            case '-':
                int resSub = numDecimal - Integer.parseInt(numHexa);
                if (resSub == 0) {

                    resultado = "0";

                } else {

                    resultado = txt + converter.decimalBin(Integer.toString(resSub));
                    
                }
                break;
            default:
                int resMult = numDecimal * Integer.parseInt(numHexa);
                resultado = txt + converter.decimalBin(Integer.toString(resMult));
                break;
        }

        return resultado;

    }
    
    /**
     *
     * <h1>Método responsável por realizar os cálculos de adição, 
     * subtração e multiplicação entre números decimais e binários.</h1>
     * 
     *
     * <p>
     * Realiza os cálculos de números decimais e binários</p>
     *
     *
     * @author Henrique
     *
     * @see operacoesDecBin
     */
    
    public String operacoesDecBin(String decimal, String binario) {
        int numDecimal = Integer.parseInt(decimal);
        String numBin = converter.binDec(binario);
        String txt = "Binário: ";
        
        switch (op) {
            case '+':
                int res = numDecimal + Integer.parseInt(numBin);
                resultado = txt + converter.decimalBin(Integer.toString(res));
                break;
            case '-':
                int resSub = numDecimal - Integer.parseInt(numBin);
                if (resSub == 0) {

                    resultado = "0";
                    
                }
                
                else {

                    resultado = txt + converter.decimalBin(Integer.toString(resSub));

                }
                break;
            default:
                int resMult = numDecimal * Integer.parseInt(numBin);
                resultado = txt + converter.decimalBin(Integer.toString(resMult));
                break;
        }
        
        return resultado;
    }
    
/**
     *
     * <h1>Método responsável por realizar os cálculos de adição, 
     * subtração e multiplicação entre números decimais.</h1>
     * 
     *
     * <p>
     * Realiza os cálculos de números decimais</p>
     *
     *
     * @author Henrique
     *
     * @see operacoesDecBin
     */
    public String operacoesDec(String decimal1, String decimal2) {
        
        String txt = "Decimal: ";
        switch (op) {
            case '+':
                int res = Integer.parseInt(decimal1)+ Integer.parseInt(decimal2);
                resultado = txt + Integer.toString(res);
                break;
            case '-':
                int resSub = Integer.parseInt(decimal1) - Integer.parseInt(decimal2);
                if (resSub == 0) {
                    
                    resultado = "0";
                    
                } 
                
                else {
                    
                    resultado = txt + Integer.toString(resSub);
                    
                }
                break;
            default:
                int resMult = Integer.parseInt(decimal1) * Integer.parseInt(decimal2);
                resultado = txt + Integer.toString(resMult);
                break;
        }
        
        return resultado;
    }
    
    /**
     *
     * <h1>Método responsável por realizar os cálculos de adição, 
     * subtração e multiplicação entre números hexadecimais e decimais.</h1>
     * 
     *
     * <p>
     * Realiza os cálculos de números hexadecimais e decimais</p>
     *
     *
     * @author Henrique
     *
     * @see operacoesHexDec
     */
    public String operacoesHexDec(String hexadecimal, String decimal) {
        int numDecimal = Integer.parseInt(decimal);
        String numHex = converter.hexDec(hexadecimal);
        String txt = "Binário: ";
        
        switch (op) {
            case '+':
                int res = numDecimal + Integer.parseInt(numHex);
                resultado = txt + converter.decimalBin(Integer.toString(res));
                break;
            case '-':
                int resSub = Integer.parseInt(numHex) - numDecimal;
                if (resSub == 0) {
                    
                    resultado = "0";
                    
                } 
                
                else {
                    
                    resultado = txt + converter.decimalBin(Integer.toString(resSub));
                    
                }
                break;
            default:
                int resMult = numDecimal * Integer.parseInt(numHex);
                resultado = txt + converter.decimalBin(Integer.toString(resMult));
                break;
        }
        
        return resultado;
    }
    
    /**
     *
     * <h1>Método responsável por realizar os cálculos de adição, 
     * subtração e multiplicação entre números hexadecimais e binários.</h1>
     * 
     *
     * <p>
     * Realiza os cálculos de números hexadecimais e binários</p>
     *
     *
     * @author Henrique
     *
     * @see operacoesHexBin
     */
    public String operacoesHexBin(String hexadecimal, String binario){
        int numHexadecimal = Integer.parseInt(converter.hexDec(hexadecimal));
        int numBinario = Integer.parseInt(converter.binDec(binario));
        String txt = "Binário: ";
        
        switch (op) {
            case '+':
                int res = numHexadecimal + numBinario;
                resultado = txt + converter.decimalBin(Integer.toString(res));
                break;
            case '-':
                int resSub = numHexadecimal - numBinario;
                if (resSub == 0) {
                    resultado = "0";
                }
                
                else {
                    resultado = txt + converter.decimalBin(Integer.toString(resSub));
                }
                break;
            default:
                int resMult = numHexadecimal * numBinario;
                resultado = txt + converter.decimalBin(Integer.toString(resMult));
                break;
        }
        
        return resultado;
    }

    /**
     *
     * <h1>Método responsável por realizar os cálculos de adição, 
     * subtração e multiplicação entre números hexadecimais.</h1>
     * 
     *
     * <p>
     * Realiza os cálculos de números hexadecimais</p>
     *
     *
     * @author Henrique
     *
     * @see operacoesHex
     */
    public String operacoesHex(String hexadecimal, String hexadecimal2){
        int numHexadecimal = Integer.parseInt(converter.hexDec(hexadecimal));
        int numHexadecimal2 = Integer.parseInt(converter.hexDec(hexadecimal2));
        String txt = "Hexadecimal: ";
 
        switch (op) {
            case '+':
                int res = numHexadecimal + numHexadecimal2;
                resultado = txt + converter.decimalHex(Integer.toString(res));
                break;
            case '-':
                int resSub = numHexadecimal - numHexadecimal2;
                if (resSub == 0) {
                    resultado = "0";
                } else {
                    resultado = txt + converter.decimalHex(Integer.toString(resSub));
                }
                break;
            default:
                int resMult = numHexadecimal * numHexadecimal2;
                resultado = txt + converter.decimalHex(Integer.toString(resMult));
                break;
        }
        
        return resultado;
    }
    
    /**
     *
     * <h1>Método responsável por realizar os cálculos de adição, 
     * subtração e multiplicação entre números binários e decimais.</h1>
     * 
     *
     * <p>
     * Realiza os cálculos de números binários e decimais</p>
     *
     *
     * @author Henrique
     *
     * @see operacoesBinDec
     */
    public String operacoesBinDec(String binario, String decimal){
        int numBinario = Integer.parseInt(converter.binDec(binario));
        int numDecimal = Integer.parseInt(decimal);
        String txt = "Binário: ";
       
        switch (op) {
            case '+':
                int res = numBinario + numDecimal;
                resultado = txt + converter.decimalBin(Integer.toString(res));
                break;
            case '-':
                int resSub = numBinario - numDecimal;
                if (resSub == 0) {
                    resultado = "0";
                } 
                
                else {
                    resultado = txt + converter.decimalBin(Integer.toString(resSub));
                }
                break;
            default:
                int resMult = numBinario + numDecimal;
                resultado = txt + converter.decimalBin(Integer.toString(resMult));
                break;
        }
        
        return resultado;
    }
    
     /**
     *
     * <h1>Método responsável por realizar os cálculos de adição, 
     * subtração e multiplicação entre números binários e hexadecimais.</h1>
     * 
     *
     * <p>
     * Realiza os cálculos de números binários e hexadecimais</p>
     *
     *
     * @author Henrique
     *
     * @see operacoesBinHex
     */
    public String operacoesBinHex(String binario, String hexadecimal){
        int numBinario = Integer.parseInt(converter.binDec(binario));
        int numHexadecimal = Integer.parseInt(converter.hexDec(hexadecimal));
        String txt = "Binário: ";
       
        switch (op) {
            case '+':
                int res = numBinario + numHexadecimal;
                resultado = txt + converter.decimalBin(Integer.toString(res));
                break;
            case '-':
                int resSub = numBinario - numHexadecimal;
                if (resSub == 0) {
                    resultado = "0";
                } 
                
                else {
                    resultado = txt + converter.decimalBin(Integer.toString(resSub));
                }
                break;
            default:
                int resMult = numBinario + numHexadecimal;
                resultado = txt + converter.decimalBin(Integer.toString(resMult));
                break;
        }
        
        return resultado;
    }
    
    /**
     *
     * <h1>Método responsável por realizar os cálculos de adição, 
     * subtração e multiplicação entre números binários.</h1>
     * 
     *
     * <p>
     * Realiza os cálculos de números binários</p>
     *
     *
     * @author Henrique
     *
     * @see operacoesBin
     */
    public String operacoesBin(String binario, String binario2){
        int numBinario = Integer.parseInt(converter.binDec(binario));
        int numBinario2 = Integer.parseInt(converter.binDec(binario2));
        String txt = "Binário: ";

        switch (op) {
            case '+':
                int res = numBinario + numBinario2;
                resultado = txt + converter.decimalBin(Integer.toString(res));
                break;
            case '-':
                int resSub = numBinario - numBinario2;
                if (resSub == 0) {
                    
                    resultado = "0";
                    
                } 
                
                else {
                    
                    resultado = txt + converter.decimalBin(Integer.toString(resSub));
                    
                }
                break;
            default:
                int resMult = numBinario + numBinario2;
                resultado = txt + converter.decimalBin(Integer.toString(resMult));
                break;
        }
        
        return resultado;
    }
    
    /**
     *
     * <h1>Método responsável por chamar os métodos que realizam os cálculos de adição, 
     * subtração e multiplicação entre números.</h1>
     * 
     *
     * <p>
     * Chama os métodos que realizam os cálculos de adição, 
     * subtração e multiplicação entre os números informados pelo usuário</p>
     *
     *
     * @author Henrique
     *
     * @see calcular
     */
    
    public String calcular() throws Exception {

        resultado = "";

        // CALCULO DECIMAL
        if (baseN1 == 10) {

            switch (baseN2) {

                case 16:
                    operacoesDecHex(n1, n2);
                    break;
                case 2:
                    operacoesDecBin(n1, n2);
                    break;
                case 10:
                    operacoesDec(n1, n2);
                    break;
                default:
                    break;
            }
            
        }
        
        //CALCULO HEXADECIMAL
        if (baseN1 == 16){
            switch (baseN2) {

                case 10:
                    operacoesHexDec(n1, n2);
                    break;
                case 2:
                    operacoesHexBin(n1, n2);
                    break;    
                case 16:
                    operacoesHex(n1, n2);
                    break;        
                default:
                    break;
            }
        }
        
        // CALCULO BINÁRIO
        if (baseN1 == 2) {

            switch (baseN2) {

                case 10:
                    operacoesBinDec(n1, n2);
                    break;
                case 16:
                    operacoesBinHex(n1, n2);
                    break;
                case 2:
                    operacoesBin(n1, n2);
                    break;
                default:
                    break;
            }
            
        }
        
        return resultado;
        
    }

}
