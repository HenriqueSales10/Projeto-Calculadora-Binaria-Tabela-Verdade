/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculos;

import conversao.Conversor;

/**
 *
 * @author Usuario
 */
public class Calculador {

    private String n1, n2;
    private char op;
    private int baseN1 = 10;
    private int baseN2 = 2;

    Conversor calc = new Conversor();
    
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

    public String operacoesDecHex(String decimal, String hexadecimal) {
        int numDecimal = Integer.parseInt(decimal);
        String numHexa = calc.hexDec(hexadecimal);
        String txt = "Binário: ";

        if (op == '+') {
            
            int res = numDecimal + Integer.parseInt(numHexa);
            resultado = txt + calc.decimalBin(Integer.toString(res));
            
        } 
        
        else if (op == '-') {
            int resSub = numDecimal - Integer.parseInt(numHexa);
            
                if (resSub == 0) {

                    resultado = "0";

                } else {

                    resultado = txt + calc.decimalBin(Integer.toString(resSub));

                  }
        } 
        
        else {
            
            int resMult = numDecimal * Integer.parseInt(numHexa);
            resultado = txt + calc.decimalBin(Integer.toString(resMult));
            
        }

        return resultado;

    }
    
    public String operacoesDecBin(String decimal, String binario) {
        int numDecimal = Integer.parseInt(decimal);
        String numBin = calc.binDec(binario);
        String txt = "Binário: ";
        
        if (op == '+') {
            
            int res = numDecimal + Integer.parseInt(numBin);
            resultado = txt + calc.decimalBin(Integer.toString(res));
            
        } else if (op == '-') {
            
            int resSub = numDecimal - Integer.parseInt(numBin);
            
                if (resSub == 0) {

                    resultado = "0";

                } 

                else {

                    resultado = txt + calc.decimalBin(Integer.toString(resSub));

                }
            
        } 
        
        else {
            
            int resMult = numDecimal * Integer.parseInt(numBin);
            resultado = txt + calc.decimalBin(Integer.toString(resMult));
            
        }
        
        return resultado;
    }
    
    public String operacoesDec(String decimal1, String decimal2) {
        
        String txt = "Decimal: ";
        if (op == '+') {
            
            int res = Integer.parseInt(decimal1)+ Integer.parseInt(decimal2);
            resultado = txt + Integer.toString(res);
            
        }
        
        else if (op == '-') {
            int resSub = Integer.parseInt(decimal1) - Integer.parseInt(decimal2);
                
                if (resSub == 0) {
                    
                    resultado = "0";
                    
                } 
                
                else {
                    
                    resultado = txt + Integer.toString(resSub);
                    
                }
        } 
        
        else {
            
            int resMult = Integer.parseInt(decimal1) * Integer.parseInt(decimal2);
            resultado = txt + Integer.toString(resMult);
            
        }
        
        return resultado;
    }
    
    public String operacoesHexDec(String hexadecimal, String decimal) {
        int numDecimal = Integer.parseInt(decimal);
        String numHex = calc.hexDec(hexadecimal);
        String txt = "Binário: ";
        
        if (op == '+') {
            
            int res = numDecimal + Integer.parseInt(numHex);
            resultado = txt + calc.decimalBin(Integer.toString(res));
            
        } 
        
        else if (op == '-') {
           
            int resSub = Integer.parseInt(numHex) - numDecimal;
               
                if (resSub == 0) {
                    
                    resultado = "0";
                    
                } 
                
                else {
                    
                    resultado = txt + calc.decimalBin(Integer.toString(resSub));
                    
                }
                
        } 
        
        else {
            
            int resMult = numDecimal * Integer.parseInt(numHex);
            resultado = txt + calc.decimalBin(Integer.toString(resMult));
            
        }
        
        return resultado;
    }
    
    public String operacoesHexBin(String hexadecimal, String binario){
        int numHexadecimal = Integer.parseInt(calc.hexDec(hexadecimal));
        int numBinario = Integer.parseInt(calc.binDec(binario));
        String txt = "Binário: ";
        
        if (op == '+') {
            
            int res = numHexadecimal + numBinario;
            resultado = txt + calc.decimalBin(Integer.toString(res));
        } 
        
        else if (op == '-') {
            int resSub = numHexadecimal - numBinario;
            
                if (resSub == 0) {
                    resultado = "0";
                } 

                else {
                    resultado = txt + calc.decimalBin(Integer.toString(resSub));
                }
        } 
        
        else {
            
            int resMult = numHexadecimal * numBinario;
            resultado = txt + calc.decimalBin(Integer.toString(resMult));
            
        }
        
        return resultado;
    }

    public String operacoesHex(String hexadecimal, String hexadecimal2){
        int numHexadecimal = Integer.parseInt(calc.hexDec(hexadecimal));
        int numHexadecimal2 = Integer.parseInt(calc.hexDec(hexadecimal2));
        String txt = "Hexadecimal: ";
 
        if (op == '+') {
            
            int res = numHexadecimal + numHexadecimal2;
            resultado = txt + calc.decimalHex(Integer.toString(res));
            
        } 
        
        else if (op == '-') {
            int resSub = numHexadecimal - numHexadecimal2;
                if (resSub == 0) {
                    resultado = "0";
                } else {
                    resultado = txt + calc.decimalHex(Integer.toString(resSub));
                }
        } 
        
        else {
            
            int resMult = numHexadecimal * numHexadecimal2;
            resultado = txt + calc.decimalHex(Integer.toString(resMult));
            
        }
        
        return resultado;
    }
    
    public String operacoesBinDec(String binario, String decimal){
        int numBinario = Integer.parseInt(calc.binDec(binario));
        int numDecimal = Integer.parseInt(decimal);
        String txt = "Binário: ";
       
        if (op == '+') {
            int res = numBinario + numDecimal;
            resultado = txt + calc.decimalBin(Integer.toString(res));
        } 
        
        else if (op == '-') {
            int resSub = numBinario - numDecimal;
            
                if (resSub == 0) {
                    resultado = "0";
                } 
                
                else {
                     resultado = txt + calc.decimalBin(Integer.toString(resSub));
                }
        } 
        
        else {
            
            int resMult = numBinario + numDecimal;
            resultado = txt + calc.decimalBin(Integer.toString(resMult));
            
        }
        
        return resultado;
    }
    
    public String operacoesBinHex(String binario, String hexadecimal){
        int numBinario = Integer.parseInt(calc.binDec(binario));
        int numHexadecimal = Integer.parseInt(calc.hexDec(hexadecimal));
        String txt = "Binário: ";
       
        if (op == '+') {
            
            int res = numBinario + numHexadecimal;
            resultado = txt + calc.decimalBin(Integer.toString(res));
            
        } 
        
        else if (op == '-') {
            
            int resSub = numBinario - numHexadecimal;
            
                if (resSub == 0) {
                    resultado = "0";
                } 
                
                else {
                     resultado = txt + calc.decimalBin(Integer.toString(resSub));
                }
        } 
        
        else {
            
            int resMult = numBinario + numHexadecimal;
            resultado = txt + calc.decimalBin(Integer.toString(resMult));
            
        }
        
        return resultado;
    }
    
    public String operacoesBin(String binario, String binario2){
        int numBinario = Integer.parseInt(calc.binDec(binario));
        int numBinario2 = Integer.parseInt(calc.binDec(binario2));
        String txt = "Binário: ";

        if (op == '+') {
            
            int res = numBinario + numBinario2;
            resultado = txt + calc.decimalBin(Integer.toString(res));
            
        } 
        
        else if (op == '-') {
            
            int resSub = numBinario - numBinario2;
                if (resSub == 0) {
                    
                    resultado = "0";
                    
                } 
                
                else {
                    
                     resultado = txt + calc.decimalBin(Integer.toString(resSub));
                     
                }
        } 
        
        else {
            
            int resMult = numBinario + numBinario2;
            resultado = txt + calc.decimalBin(Integer.toString(resMult));
            
        }
        
        return resultado;
    }
    
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
