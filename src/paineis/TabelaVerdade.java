/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paineis;

import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

/**
 *
 * @author Usuario
 */
public class TabelaVerdade extends javax.swing.JPanel {

    private String expressao;
    private String[][] matrizVerdade = null;
    private int tamanhoExpressao = 0;
    private int quantidadeLinhas = 0;
    private final Map<String, Integer> tabelaGrauDePrioridades = new HashMap<>();

    private void montaTabelaVerdade(String expressao) {
        this.expressao = expressao;
        this.tamanhoExpressao = expressao.length();
        this.matrizVerdade = new String[expressao.length()][17];
        this.configuraTabelaGrauPrioridades();
        this.executaConversao();
    }
    
        // Informa Quais tem maior grau de pioridade ('^' e '+' tem \\ na frente pois são caracteres especiais) 
    private void configuraTabelaGrauPrioridades() {
        tabelaGrauDePrioridades.put("~", 0); 
        tabelaGrauDePrioridades.put("\\^", 1);
        tabelaGrauDePrioridades.put("v", 2);
        tabelaGrauDePrioridades.put("\\+", 3);
        tabelaGrauDePrioridades.put("→", 4);
        tabelaGrauDePrioridades.put("↔", 5);
    }
    // Faz a conversão da expressao
    private void executaConversao() {
        inicializaMatriz();
        expressaoParaColunas();
        calculaQuantidadeLinhasUsadas();
        geraValoresDasPreposicoes(); // 
        resolveDentroDosParenteses();
        processa(0, tamanhoExpressao - 1);
    }
   
    // Monta colunas a partir dos caracteres da expressão informada 
    // Ex: ~ | ( | p | ^ | q | ^ | (  ....    
    private void expressaoParaColunas() {
        for (int i = 0; i < expressao.length(); i++) {
            matrizVerdade[i][0] = Character.toString(expressao.charAt(i));
        }
    }

    private void inicializaMatriz() {
        for (int i = 0; i < tamanhoExpressao; i++) {
            for (int j = 0; j < 17; j++) {
                matrizVerdade[i][j] = " ";
            }
        }        
    }

    private Set<String> carregaPreposicoes () {
        Set<String> preposicoes = new HashSet<>();
        for (int i = 0; i < tamanhoExpressao; i++) {
            if (matrizVerdade[i][0].matches("p|q|r|s")) {
                preposicoes.add(matrizVerdade[i][0]);
            }
        }        
        return preposicoes;        
    }
    
    private void calculaQuantidadeLinhasUsadas() {
        final Set<String> preposicoes = carregaPreposicoes();        
        this.quantidadeLinhas = (int) Math.pow(2, preposicoes.size());  
    }

    private void geraValoresDasPreposicoes() {
        final Set<String> preposicoes = carregaPreposicoes();        

        int numeroProposicao = 1;
        for (String proposicao : preposicoes) {
            String[] valores = geraVeFnasPreposicoes(numeroProposicao, preposicoes.size());
            for (int i = 0; i < tamanhoExpressao; i++) {
                if (matrizVerdade[i][0].contentEquals(proposicao)) {
                    System.arraycopy(valores, 0, matrizVerdade[i], 1, quantidadeLinhas);
                }
            }
            numeroProposicao++;
        }
    }

    // Monta V e F conforme as preposicoes p q r s  
    private String[] geraVeFnasPreposicoes(int numeroProposicao, int tamanhoProposicao) {
        List<String> retorno = new ArrayList<>();

        numeroProposicao = tamanhoProposicao - numeroProposicao + 1 ;
        
        for (int i = 0; i < quantidadeLinhas; i++) {            
            switch (numeroProposicao) {
                case 1:   // F V F V F V ...
                    if (i % 2 == 0) {
                        retorno.add("F");
                    } else {
                        retorno.add("V");
                    }
                    break;
                case 2:  // V V F F V V ...
                    if (i == 0 || i == 1 || i == 4 || i == 5 || i == 8 || i == 9 || i == 12
                            || i == 13) {
                        retorno.add("F");
                    } else {
                        retorno.add("V");
                    }
                    break;
                case 3:   // V V V V F F ...
                    if ((i >= 0 && i <= 3) || (i >= 8 && i <= 11)) {
                        retorno.add("F");
                    } else {
                        retorno.add("V");
                    }
                    break;
                case 4:   //  V V V V V ...
                    if (i >= 0 && i <= 7) {
                        retorno.add("F");
                    } else {
                        retorno.add("V");
                    }
                    break;
            }
        }

        String[] retornoArray = new String[retorno.size()];
        for (int i = 0; i < retorno.size(); i++) {
            retornoArray[i] = retorno.get(i);
        }
        return retornoArray;
    }
    //Pega a equação
    private void resolveDentroDosParenteses() {
        List<Integer> limiteParentesesTratados = new ArrayList<>();
        int numeroDeParentesesTotal = pegaQuantidadeDeParentesesTotal();

        if (numeroDeParentesesTotal != 0) {
            while (limiteParentesesTratados.size() < numeroDeParentesesTotal) {
                int[] parentesesTratados = retornaLimiteParenteses(
                        limiteParentesesTratados);
                processa(parentesesTratados[0], parentesesTratados[1]);
                limiteParentesesTratados.add(parentesesTratados[0]);
                limiteParentesesTratados.add(parentesesTratados[1]);
            }
        }
    }

    private int pegaQuantidadeDeParentesesTotal() {
        int numeroDeParenteses = 0;

        for (int i = 0; i < tamanhoExpressao; i++) {
            if (this.matrizVerdade[i][0].matches("\\(|\\)")) {
                numeroDeParenteses++;
            }
        }
        return numeroDeParenteses;
    }

    private int[] retornaLimiteParenteses(List<Integer> limiteParentesesTratados) {

        int indiceInicio = 0;
        int indiceFinal = 0;
        boolean achouIndiceFinal = false;

        for (int i = 0; i < tamanhoExpressao; i++) {
            if (matrizVerdade[i][0].matches("\\(")
                    && !(limiteParentesesTratados.contains(i))) {
                indiceInicio = i;
            }
            if (matrizVerdade[i][0].matches("\\)")
                    && !(limiteParentesesTratados.contains(i)) && (!achouIndiceFinal)) {
                indiceFinal = i;
                achouIndiceFinal = true;                
            }
        }

        int[] retorno = new int[2];
        retorno[0] = indiceInicio;
        retorno[1] = indiceFinal;

        return retorno;
    }

    private void processa(int indiceInicio, int indiceFinal) {
        processaNegacoes(indiceInicio, indiceFinal);
        processaConjucao(indiceInicio, indiceFinal);
        processaDisjuncao(indiceInicio, indiceFinal);
        processaXor(indiceInicio, indiceFinal);
        processaCondicional(indiceInicio, indiceFinal);
        processaBicondicional(indiceInicio, indiceFinal);
    }
    
    private int pegaIndiceValorParentesesDireita(int indiceParentesesInicio) {
        int parentesesFinalCorrespondente = pegaParentesesFinalCorrespondente(
                indiceParentesesInicio);
        int elementoDeMaiorPrioridade = pegaIndiceDeMaiorPrioridade(indiceParentesesInicio,
                parentesesFinalCorrespondente);
        return elementoDeMaiorPrioridade;
    }

    private int pegaIndiceValorParentesesEsquerda(int indiceParentesesFinal) {
        int parentesesInicialCorrespondente = pegaParentesesInicialCorrespondente(
                indiceParentesesFinal);
        int elementoDeMaiorPriordad = pegaIndiceDeMaiorPrioridade(
                parentesesInicialCorrespondente, indiceParentesesFinal);
        return elementoDeMaiorPriordad;
    }

    private int pegaParentesesFinalCorrespondente(int indiceParentesesInicio) {
        int parentesesAMais = 0;
        int retorno = 0;

        for (int i = indiceParentesesInicio + 1; i < tamanhoExpressao; i++) {
            if (matrizVerdade[i][0].matches("\\(")) {
                parentesesAMais++;
            } else if (matrizVerdade[i][0].matches("\\)")) {
                if (parentesesAMais == 0) {
                    retorno = i;
                } else {
                    parentesesAMais--;
                }
            }
        }
        return retorno;
    }

    private int pegaParentesesInicialCorrespondente(int indiceParentesesFinal) {
        int parentesesAMais = 0;
        int retorno = 0;

        for (int i = indiceParentesesFinal - 1; i > 0; i--) {
            if (matrizVerdade[i][0].matches("\\)")) {
                parentesesAMais++;
            } else if (matrizVerdade[i][0].matches("\\(")) {
                if (parentesesAMais == 0) {
                    retorno = i;
                } else {
                    parentesesAMais--;
                }
            }
        }

        return retorno;
    }

    private int pegaIndiceDeMaiorPrioridade(int indiceInicio, int indiceFinal) {

        int indiceInicioReal = indiceInicio, indiceFinalReal = indiceFinal;
        
        if (matrizVerdade[indiceInicio][0].matches("\\(")) {
            indiceInicioReal = indiceInicio + 1;
        }
        if (matrizVerdade[indiceFinal][0].matches("\\)")) {
            indiceFinalReal = indiceFinal - 1;
        }

        int indiceRetorno = indiceInicioReal;
        final String[] arrayExpressoes = {"p", "q", "r", "s","~", "\\^", "v", "\\+", "→", "↔"};

        for (String element : arrayExpressoes) {
            for (int i = indiceInicioReal; i < indiceFinalReal; i++) {
                if (matrizVerdade[i][0].matches("\\(")) {
                    i = pegaParentesesFinalCorrespondente(i);
                }
                if (matrizVerdade[i][0].matches(element)) {
                    indiceRetorno = i;
                }
            }
        }
        return indiceRetorno;
    }

      // A negação é simbolizada por ~. A operação lógica da negação é a mais simples e muitas vezes dispensa o uso da tabela verdade. 
    // Seguindo o mesmo exemplo, se João é alto (p) dizer que João não é alto (~p) é FALSO, e vice-versa.
    private void processaNegacoes(int indiceInicio, int indiceFinal) {
        for (int i = indiceInicio; i < indiceFinal; i++) {
            if (matrizVerdade[i][0].matches("~")) {
                if (matrizVerdade[i + 1][0].matches("\\(")) {
                    int indiceValorInternoParenteses = pegaIndiceValorParentesesDireita(i + 1);
                    negacao(indiceValorInternoParenteses, i);
                } else {
                    negacao(i + 1, i);
                }
            }
        }
    }

    private void negacao(int indiceValor, int indiceDestino) {
        for (int i = 1; i < quantidadeLinhas + 1; i++) {
            if (matrizVerdade[indiceValor][i].matches("V")) {
                matrizVerdade[indiceDestino][i] = "F";
            } else if (matrizVerdade[indiceValor][i].matches("F")) {
                matrizVerdade[indiceDestino][i] = "V";
            }
        }
    }

    // A conjunção é simbolizada por ^. O exemplo "João é alto e Maria é baixa" 
    // será simbolizado por "p^q" e a tabela verdade será:
    private void processaConjucao(int indiceInicio, int indiceFinal) {
        for (int i = indiceInicio; i < indiceFinal; i++) {
            if (matrizVerdade[i][0].matches("\\^")) {
                int indiceValorDireita, indiceValorEsquerda;
                if (matrizVerdade[i + 1][0].matches("\\(")) {
                    indiceValorDireita = pegaIndiceValorParentesesDireita(i + 1);
                } else {
                    indiceValorDireita = i + 1;
                }

                int[] conectivoAnterior = temConectivoAntes(i, "\\^");
                if (conectivoAnterior[0] != -1) {
                    indiceValorEsquerda = conectivoAnterior[1];
                } else if (matrizVerdade[i - 1][0].matches("\\)")) {
                    indiceValorEsquerda = pegaIndiceValorParentesesEsquerda(i - 1);
                } else {
                    indiceValorEsquerda = i - 1;
                }
                conjucao(indiceValorEsquerda, indiceValorDireita, i);
            }
        }
    }

    private void conjucao(int indiceValorEsquerda, int indiceValorDireita, int indiceDestino) {
        for (int i = 1; i < quantidadeLinhas + 1; i++) {
            if (matrizVerdade[indiceValorEsquerda][i].matches("V")) {
                if (matrizVerdade[indiceValorDireita][i].matches("V")) {
                    matrizVerdade[indiceDestino][i] = "V";
                } else {
                    matrizVerdade[indiceDestino][i] = "F";
                }
            } else {
                matrizVerdade[indiceDestino][i] = "F";
            }
        }
    }

    // A disjunção é simbolizada por v. Trocando o conectivo do exemplo acima 
    // para ou teremos "João é alto ou Maria é baixa". Nesse caso, a frase será simbolizada por "pvq"
    private void processaDisjuncao(int indiceInicio, int indiceFinal) {
        for (int i = indiceInicio; i < indiceFinal; i++) {
            if (matrizVerdade[i][0].matches("v")) {
                int indiceValorDireita, indiceValorEsquerda;

                int[] conectivoSubsequente = temConectivoDepois(i, "v");

                if (conectivoSubsequente[0] != -1) {
                    indiceValorDireita = conectivoSubsequente[1];
                } else if (matrizVerdade[i + 1][0].matches("\\(")) {
                    indiceValorDireita = pegaIndiceValorParentesesDireita(i + 1);
                } else {
                    indiceValorDireita = i + 1;
                }

                int[] conectivoAnterior = temConectivoAntes(i, "v");

                if (conectivoAnterior[0] != -1) {
                    indiceValorEsquerda = conectivoAnterior[1];
                } else if (matrizVerdade[i - 1][0].matches("\\)")) {
                    indiceValorEsquerda = pegaIndiceValorParentesesEsquerda(i - 1);
                } else {
                    indiceValorEsquerda = i - 1;
                }

                disjuncao(indiceValorEsquerda, indiceValorDireita, i);

            }
        }
    }

    private void disjuncao(int indiceValorEsquerda, int indiceValorDireita, int indiceDestino) {
        for (int i = 1; i < quantidadeLinhas + 1; i++) {
            if (matrizVerdade[indiceValorEsquerda][i].matches("V")
                    || matrizVerdade[indiceValorDireita][i].matches("V")) {
                matrizVerdade[indiceDestino][i] = "V";
            } else {
                matrizVerdade[indiceDestino][i] = "F";
            }
        }
    }

    private int[] temConectivoAntes(int indiceAtual, String conectivo) {

        int[] retorno = new int[2];

        retorno[0] = -1;
        retorno[1] = -1;

        for (int i = indiceAtual - 1; i >= 0; i--) {
            if (matrizVerdade[i][0].matches("\\)")) {
                i = pegaParentesesInicialCorrespondente(i);
            } else if (matrizVerdade[i][0].matches("\\(")) {
                return retorno;
            } else if (matrizVerdade[i][0].matches("v|\\^|\\+|→|↔|~")) {
                retorno[1] = i;
                if (tabelaGrauDePrioridades
                        .get(conectivo) >= tabelaGrauDePrioridades
                        .get(matrizVerdade[i][0])) {
                    retorno[0] = 1;

                    return retorno;
                } else {
                    retorno[0] = -1;
                    return retorno;
                }
            }
        }

        return retorno;
    }

    private int[] temConectivoDepois(int indiceAtual, String conectivo) {

        int[] retorno = new int[2];

        retorno[0] = -1;
        retorno[1] = -1;

        for (int i = indiceAtual + 1; i < tamanhoExpressao; i++) {
            if (matrizVerdade[i][0].matches("\\(")) {
                i = pegaParentesesFinalCorrespondente(i);
            } else if (matrizVerdade[i][0].matches("\\)")) {
                return retorno;
            } else if (matrizVerdade[i][0].matches("v|\\^|\\+|→|↔|~")) {
                retorno[1] = i;
                if (tabelaGrauDePrioridades
                        .get(conectivo) > tabelaGrauDePrioridades
                        .get(matrizVerdade[i][0])) {
                    retorno[0] = 1;
                    return retorno;
                } else {
                    retorno[0] = -1;
                    return retorno;
                }
            }
        }

        return retorno;

    }

    // Ou exclusivo ou disjunção exclusiva é uma operação lógica entre dois 
    // operandos que resulta em um valor lógico verdadeiro se e somente se os 
    // dois operandos forem diferentes, ou seja, se um for verdadeiro e o outro for falso. 
    // É conhecido também pelas abreviações XOR
    private void processaXor(int indiceInicio, int indiceFinal) {
        for (int i = indiceInicio; i < indiceFinal; i++) {
            if (matrizVerdade[i][0].matches("\\+")) {
                int indiceValorDireita, indiceValorEsquerda;

                int[] conectivoSubsequente = temConectivoDepois(i, "\\+");

                if (conectivoSubsequente[0] != -1) {
                    indiceValorDireita = conectivoSubsequente[1];
                } else if (matrizVerdade[i + 1][0].matches("\\(")) {
                    indiceValorDireita = pegaIndiceValorParentesesDireita(i + 1);
                } else {
                    indiceValorDireita = i + 1;
                }

                int[] conectivoAnterior = temConectivoAntes(i, "\\+");

                if (conectivoAnterior[0] != -1) {
                    indiceValorEsquerda = conectivoAnterior[1];
                } else if (matrizVerdade[i - 1][0].matches("\\)")) {
                    indiceValorEsquerda = pegaIndiceValorParentesesEsquerda(i - 1);
                } else {
                    indiceValorEsquerda = i - 1;
                }

                xor(indiceValorEsquerda, indiceValorDireita, i);

            }
        }
    }

    private void xor(int indiceValorEsquerda, int indiceValorDireita, int indiceDestino) {
        for (int i = 1; i < quantidadeLinhas + 1; i++) {
            if (matrizVerdade[indiceValorEsquerda][i].matches("V")
                    ^ matrizVerdade[indiceValorDireita][i].matches("V")) {
                matrizVerdade[indiceDestino][i] = "V";
            } else {
                matrizVerdade[indiceDestino][i] = "F";
            }
        }
    }

    // A condicional é simbolizada por →. É expressa pelos conectivos se e então, 
    // que interligam as proposições simples em uma relação de causalidade. 
    //O exemplo "Se Paulo é carioca, então ele é brasileiro" se torna "p→q"
    private void processaCondicional(int indiceInicio, int indiceFinal) {
        for (int i = indiceInicio; i < indiceFinal; i++) {
            if (matrizVerdade[i][0].matches("→")) {
                int indiceValorDireita, indiceValorEsquerda;

                int[] conectivoSubsequente = temConectivoDepois(i, "→");

                if (conectivoSubsequente[0] != -1) {
                    indiceValorDireita = conectivoSubsequente[1];
                } else if (matrizVerdade[i + 1][0].matches("\\(")) {
                    indiceValorDireita = pegaIndiceValorParentesesDireita(i + 1);
                } else {
                    indiceValorDireita = i + 1;
                }

                int[] conectivoAnterior = temConectivoAntes(i, "→");

                if (conectivoAnterior[0] != -1) {
                    indiceValorEsquerda = conectivoAnterior[1];
                } else if (matrizVerdade[i - 1][0].matches("\\)")) {
                    indiceValorEsquerda = pegaIndiceValorParentesesEsquerda(i - 1);
                } else {
                    indiceValorEsquerda = i - 1;
                }

                condicional(indiceValorEsquerda, indiceValorDireita, i);

            }
        }
    }

    private void condicional(int indiceValorEsquerda, int indiceValorDireita, int indiceDestino) {
        for (int i = 1; i < quantidadeLinhas + 1; i++) {
            if (matrizVerdade[indiceValorEsquerda][i].matches("V")
                    && matrizVerdade[indiceValorDireita][i].matches("F")) {
                matrizVerdade[indiceDestino][i] = "F";
            } else {
                matrizVerdade[indiceDestino][i] = "V";
            }
        }
    }

    // A bicondicional é simbolizada por ↔. É lida através dos conectivos 
    // se e somente se, que interligam as proposições simples em uma relação 
    // de equivalência. O exemplo "João fica feliz se e somente se Maria sorri." se torna "p↔q"
    private void processaBicondicional(int indiceInicio, int indiceFinal) {
        for (int i = indiceInicio; i < indiceFinal; i++) {
            if (matrizVerdade[i][0].matches("↔")) {
                int indiceValorDireita, indiceValorEsquerda;

                int[] conectivoSubsequente = temConectivoDepois(i, "↔");

                if (conectivoSubsequente[0] != -1) {
                    indiceValorDireita = conectivoSubsequente[1];
                } else if (matrizVerdade[i + 1][0].matches("\\(")) {
                    indiceValorDireita = pegaIndiceValorParentesesDireita(i + 1);
                } else {
                    indiceValorDireita = i + 1;
                }

                int[] conectivoAnterior = temConectivoAntes(i, "↔");

                if (conectivoAnterior[0] != -1) {
                    indiceValorEsquerda = conectivoAnterior[1];
                } else if (matrizVerdade[i - 1][0].matches("\\)")) {
                    indiceValorEsquerda = pegaIndiceValorParentesesEsquerda(i - 1);
                } else {
                    indiceValorEsquerda = i - 1;
                }
                Bicondicional(indiceValorEsquerda, indiceValorDireita, i);

            }
        }
    }

    private void Bicondicional(int indiceValorEsquerda, int indiceValorDireita, int indiceDestino) {
        for (int i = 1; i < quantidadeLinhas + 1; i++) {
            if (matrizVerdade[indiceValorEsquerda][i]
                    .matches(matrizVerdade[indiceValorDireita][i])) {
                matrizVerdade[indiceDestino][i] = "V";
            } else {
                matrizVerdade[indiceDestino][i] = "F";
            }
        }
    }

    
    
    public TabelaVerdade() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        BtmAC = new javax.swing.JButton();
        txtResultadoTela = new javax.swing.JTextField();
        BtmDEL = new javax.swing.JButton();
        BtmRES = new javax.swing.JButton();
        BtmP = new javax.swing.JButton();
        BtmQ = new javax.swing.JButton();
        BtmR = new javax.swing.JButton();
        BtmS = new javax.swing.JButton();
        BtmNegacao = new javax.swing.JButton();
        BtmConju = new javax.swing.JButton();
        BtmDisjun = new javax.swing.JButton();
        BtmXOR = new javax.swing.JButton();
        BtmCondi = new javax.swing.JButton();
        BtmBicondi = new javax.swing.JButton();
        jButton11 = new javax.swing.JButton();
        jButton12 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        BtmAC.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        BtmAC.setText("AC");
        BtmAC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtmACActionPerformed(evt);
            }
        });

        txtResultadoTela.setEditable(false);
        txtResultadoTela.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtResultadoTelaActionPerformed(evt);
            }
        });

        BtmDEL.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        BtmDEL.setText("DEL");
        BtmDEL.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtmDELActionPerformed(evt);
            }
        });

        BtmRES.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        BtmRES.setText("=");
        BtmRES.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtmRESActionPerformed(evt);
            }
        });

        BtmP.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        BtmP.setText("p");
        BtmP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtmPActionPerformed(evt);
            }
        });

        BtmQ.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        BtmQ.setText("q");
        BtmQ.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtmQActionPerformed(evt);
            }
        });

        BtmR.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        BtmR.setText("r");
        BtmR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtmRActionPerformed(evt);
            }
        });

        BtmS.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        BtmS.setText("s");
        BtmS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtmSActionPerformed(evt);
            }
        });

        BtmNegacao.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        BtmNegacao.setText("~");
        BtmNegacao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtmNegacaoActionPerformed(evt);
            }
        });

        BtmConju.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        BtmConju.setText("^");
        BtmConju.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtmConjuActionPerformed(evt);
            }
        });

        BtmDisjun.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        BtmDisjun.setText("v");
        BtmDisjun.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtmDisjunActionPerformed(evt);
            }
        });

        BtmXOR.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        BtmXOR.setText("+");
        BtmXOR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtmXORActionPerformed(evt);
            }
        });

        BtmCondi.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        BtmCondi.setText("→");
        BtmCondi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtmCondiActionPerformed(evt);
            }
        });

        BtmBicondi.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        BtmBicondi.setText("↔");
        BtmBicondi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtmBicondiActionPerformed(evt);
            }
        });

        jButton11.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton11.setText("(");
        jButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton11ActionPerformed(evt);
            }
        });

        jButton12.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton12.setText(")");
        jButton12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton12ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(BtmAC, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(BtmP, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(27, 27, 27)
                                        .addComponent(BtmDEL, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(26, 26, 26)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(BtmBicondi, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(BtmConju, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(BtmQ, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                            .addComponent(BtmNegacao, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(BtmCondi, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jButton11, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(BtmDisjun, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(BtmR, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(20, 20, 20)
                                        .addComponent(jButton12, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(18, 18, 18)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(BtmS, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(BtmXOR, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                            .addComponent(BtmRES, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(txtResultadoTela, javax.swing.GroupLayout.PREFERRED_SIZE, 395, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(28, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(txtResultadoTela, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(BtmRES, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(BtmDEL, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(BtmAC, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(BtmP, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(BtmQ, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(BtmR, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(BtmS, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(BtmNegacao, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
                    .addComponent(BtmConju, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(BtmDisjun, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(BtmXOR, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton12, javax.swing.GroupLayout.DEFAULT_SIZE, 52, Short.MAX_VALUE)
                    .addComponent(jButton11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(BtmBicondi, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(BtmCondi, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(34, 34, 34))
        );

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 40)); // NOI18N
        jLabel3.setText("Tabela Verdade");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(635, 635, 635)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(80, 80, 80)))
                .addContainerGap(595, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(159, 159, 159)
                .addComponent(jLabel3)
                .addGap(30, 30, 30)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(403, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txtResultadoTelaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtResultadoTelaActionPerformed
        // TODO add your handling code here:
        txtResultadoTela.setEditable(false);
    }//GEN-LAST:event_txtResultadoTelaActionPerformed

    private void BtmACActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtmACActionPerformed
        // TODO add your handling code here:
        txtResultadoTela.setText("");
    }//GEN-LAST:event_BtmACActionPerformed

    private void BtmPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtmPActionPerformed
        // TODO add your handling code here:
        txtResultadoTela.setText(txtResultadoTela.getText()+"p");
    }//GEN-LAST:event_BtmPActionPerformed

    private void BtmNegacaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtmNegacaoActionPerformed
        // TODO add your handling code here:
        txtResultadoTela.setText(txtResultadoTela.getText()+"~");
    }//GEN-LAST:event_BtmNegacaoActionPerformed

    private void BtmCondiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtmCondiActionPerformed
        // TODO add your handling code here:
        txtResultadoTela.setText(txtResultadoTela.getText()+"→");
    }//GEN-LAST:event_BtmCondiActionPerformed

    private void BtmBicondiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtmBicondiActionPerformed
        // TODO add your handling code here:
        txtResultadoTela.setText(txtResultadoTela.getText()+"↔");
    }//GEN-LAST:event_BtmBicondiActionPerformed

    private void BtmConjuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtmConjuActionPerformed
        // TODO add your handling code here:
        txtResultadoTela.setText(txtResultadoTela.getText()+"^");
    }//GEN-LAST:event_BtmConjuActionPerformed

    private void BtmQActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtmQActionPerformed
        // TODO add your handling code here:
        txtResultadoTela.setText(txtResultadoTela.getText()+"q");
    }//GEN-LAST:event_BtmQActionPerformed

    private void BtmDELActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtmDELActionPerformed
        // TODO add your handling code here:
        txtResultadoTela.setText("");
    }//GEN-LAST:event_BtmDELActionPerformed

    private void BtmRESActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtmRESActionPerformed
        // TODO add your handling code here:
        montaTabelaVerdade(txtResultadoTela.getText());
        // Expressao nas linhas e tabela verdade em colunas = 2 for...
        String[][] strings2 = new String[matrizVerdade[0].length][matrizVerdade.length];

        for (int i = 0; i < strings2.length; i++) {
            for (int j = 0; j < strings2[0].length; j++) {
                strings2[i][j] = matrizVerdade[j][i];
                System.out.print(strings2[i][j] + " ");
            }
            System.out.println(" ");
        }

        // pega oque recebeu da matrizVerdade e monta a matrizExibiçao
        String[] matrizColuna = new String[matrizVerdade.length];

        String[][] matrizExibicao = new String[matrizVerdade[0].length-1][matrizVerdade.length];

        for (int i = 0; i < matrizExibicao.length; i++) {

            for (int j = 0; j < matrizExibicao[0].length; j++) {

                if (i == 0) {

                    matrizColuna[j] = matrizVerdade[j][i];

                } else {

                    matrizExibicao[i-1][j] = matrizVerdade[j][i];

                }

            }

        }

        JTable table = new JTable(matrizExibicao,matrizColuna);
        
        table.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 18));
        table.getTableHeader().setOpaque(false);
        table.getTableHeader().setBackground(new Color(0,0,0));
        table.getTableHeader().setForeground(new Color(255,255,255));
        table.setRowHeight(25);
        
        
        JFrame frame = new JFrame("Tabela Verdade");
        frame.add(new JScrollPane(table));
        frame.setSize(500, 350);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
 
        

    }//GEN-LAST:event_BtmRESActionPerformed

    private void BtmRActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtmRActionPerformed
        // TODO add your handling code here:
        txtResultadoTela.setText(txtResultadoTela.getText()+"r");
    }//GEN-LAST:event_BtmRActionPerformed

    private void BtmDisjunActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtmDisjunActionPerformed
        // TODO add your handling code here:
        txtResultadoTela.setText(txtResultadoTela.getText()+"v");
    }//GEN-LAST:event_BtmDisjunActionPerformed

    private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton11ActionPerformed
        // TODO add your handling code here:
        txtResultadoTela.setText(txtResultadoTela.getText()+"(");
    }//GEN-LAST:event_jButton11ActionPerformed

    private void jButton12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton12ActionPerformed
        // TODO add your handling code here:
        txtResultadoTela.setText(txtResultadoTela.getText()+")");
    }//GEN-LAST:event_jButton12ActionPerformed

    private void BtmXORActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtmXORActionPerformed
        // TODO add your handling code here:
        txtResultadoTela.setText(txtResultadoTela.getText()+"+");
    }//GEN-LAST:event_BtmXORActionPerformed

    private void BtmSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtmSActionPerformed
        // TODO add your handling code here:
        txtResultadoTela.setText(txtResultadoTela.getText()+"s");
    }//GEN-LAST:event_BtmSActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtmAC;
    private javax.swing.JButton BtmBicondi;
    private javax.swing.JButton BtmCondi;
    private javax.swing.JButton BtmConju;
    private javax.swing.JButton BtmDEL;
    private javax.swing.JButton BtmDisjun;
    private javax.swing.JButton BtmNegacao;
    private javax.swing.JButton BtmP;
    private javax.swing.JButton BtmQ;
    private javax.swing.JButton BtmR;
    private javax.swing.JButton BtmRES;
    private javax.swing.JButton BtmS;
    private javax.swing.JButton BtmXOR;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton12;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField txtResultadoTela;
    // End of variables declaration//GEN-END:variables
}
