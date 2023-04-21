import greenfoot.*;// (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;
import java.io.*;
import java.util.*;

/**
 * ScoreBoard2.class cria o ator ScoreBoard2
 * 
 * @param null
 * @return null
 * @author Heber Junior
 * @version 1.0
 */
public class ScoreBoard2 extends Actor
{
    private static final int GAP = 25;
    private static final int HEADER_TEXT_HEIGHT = 25;
    private static final Color MAIN_COLOR = new Color(0x60, 0x60, 0x60); 
    private static final Color SCORE_COLOR = new Color(0xB0, 0x40, 0x40); 
    private static final Color BACKGROUND_COLOR = new Color(0xFF, 0xFF, 0xFF, 0xB0);
    private static final Color BACKGROUND_HIGHLIGHT_COLOR = new Color(180, 230, 255, 0xB0);
    
    /**
     * ScoreBoard2() cria o ator ScoreBoard
     * 
     * @param null
     * @return null
     * @author Heber Junior
     * @version 1.0
     */
    public ScoreBoard2()
    {     
        setImage(new GreenfootImage(300,600)); 
        
        drawScores();
    }
    
    /**
     * drawString() cria uma linha de texto
     * 
     * @param 
     *   String text [texto a ser exposto]
     *   int x [posicão x]
     *   int y [poxicào y]
     *   Color color [cor do texto]
     *   int height [tamanho da fonte do texto]
     * 
     * @return null
     * @author Heber Junior
     * @version 1.0
     */
    private void drawString(String text, int x, int y, Color color, int height)
    {
        getImage().drawImage(new GreenfootImage(text, height, color, new Color(255, 255, 255, 0)), x, y);
    }
    
    /**
     * drawScores() desenha os pontos do highscore
     * 
     * @param null
     * @return null
     * @author Heber Junior
     * @version 1.0
     */
    private void drawScores()
    {
        // 50 pixels is the max height of the user image
        final int pixelsPerUser = 50 + GAP;
        // Calculate how many users we have room for:
        final int numUsers = ((getImage().getHeight() - (HEADER_TEXT_HEIGHT + 10)) / pixelsPerUser);
        final int topSpace = 35;

        getImage().setColor(BACKGROUND_COLOR);
        getImage().fill();

        
        drawString("HighScores", getImage().getWidth()*3/8, topSpace - HEADER_TEXT_HEIGHT - 5, MAIN_COLOR, HEADER_TEXT_HEIGHT);
    
        drawUserPanel(GAP , topSpace, getImage().getWidth() - GAP, topSpace + numUsers * pixelsPerUser, ordenarPontuacoes(removerRepetidos(getScores())));
    }
    
    /**
     * drawScores() desenha os pontos do highscore
     * 
     * @param 
     *  int left [margem à esquerda]
     *  int top [margem à cima]
     *  int right [margem à direita]
     *  int bottom [margem à baixo]
     *  Map<String, Integer> score [lista de jogadores por pontos]
     *  
     * @return null
     * @author Heber Junior
     * @version 1.0
     */
    private void drawUserPanel(int left, int top, int right, int bottom, Map<String, Integer> score)
    {
        getImage().setColor(MAIN_COLOR);
        getImage().drawRect(left, top, right - left, bottom - top);
    
        if (score == null)
        {
            return;
        }
    
        
        int y = top + GAP -19;
        for (Map.Entry<String, Integer> entry  : score.entrySet())
        {
            String key = entry.getKey();
            Integer value = entry.getValue();

            Color c = BACKGROUND_COLOR;;
            
            getImage().setColor(c);
            getImage().fillRect(left +1, y - GAP + 20, right - left -1, 50 + 2*GAP - 40);
    
            int x = left + 10;
            
            drawString(Integer.toString (value), x, y+18, SCORE_COLOR, 25);
            x += 55;
            drawString(key, x, y + 18, MAIN_COLOR, 25);
            y += 62;
        }
    }
    
    /**
     * getScores() lê o arquivo saves.txt e lista os pontos de cada jogador
     * 
     * @param 
     * @return Map<String, Integer> [retorna uma lista dos pontos de cada jogador num objeto Map<String, Integer>]
     * @author Heber Junior
     * @version 1.0
     */
    public Map<String, Integer> getScores() {
        
        return getScores("saves.txt");
    }
    
    /**
     * getScores() lê o arquivo saves.txt e lista os pontos de cada jogador
     * 
     * @param 
     *  String nomeArquivo [nome do arquivo de saves a ser lido]
     *  
     * @return Map<String, Integer> [retorna uma lista dos pontos de cada jogador num objeto Map<String, Integer>]
     * @author Heber Junior
     * @version 1.0
     */
    private Map<String, Integer> getScores(String nomeArquivo) {
        Map<String, Integer> pontuacoes = new HashMap<>();

        try (BufferedReader br = new BufferedReader(new FileReader(nomeArquivo))) {
            String linha;
            while ((linha = br.readLine()) != null) {
                String[] partes = linha.split(",");
                String nome = partes[0];
                int pontuacao = Integer.parseInt(partes[1]);
                pontuacoes.put(nome, pontuacao);
            }
        } catch (IOException e) {
            System.out.println("Erro ao ler arquivo: " + e.getMessage());
        }
        
        return pontuacoes;
    }

    /**
     * removerRepetidos() lista apenas as maiores 
     * 
     * @param 
     *  Map<String, Integer> pontuacoes [lista coletada pelo metodo getScores()]
     *  
     * @return Map<String, Integer> [retorna uma lista dos pontos de cada jogador num objeto Map<String, Integer>]
     * @author Heber Junior
     * @version 1.0
     */
    public static Map<String, Integer> removerRepetidos(Map<String, Integer> pontuacoes) {
        Map<String, Integer> resultado = new HashMap<>();
        
        // Caso base: o mapa está vazio
        if (pontuacoes.isEmpty()) {
            return resultado;
        }

        // Encontrar o jogador com a maior pontuação
        String jogadorMaiorPontuacao = null;
        int maiorPontuacao = Integer.MIN_VALUE;
        for (Map.Entry<String, Integer> entrada : pontuacoes.entrySet()) {
            if (entrada.getValue() > maiorPontuacao) {
                jogadorMaiorPontuacao = entrada.getKey();
                maiorPontuacao = entrada.getValue();
            }
        }

        // Adicionar o jogador com a maior pontuação ao resultado
        resultado.put(jogadorMaiorPontuacao, maiorPontuacao);

        // Remover todas as ocorrências do jogador com a maior pontuação
        Map<String, Integer> pontuacoesSemMaior = new HashMap<>(pontuacoes);
        pontuacoesSemMaior.remove(jogadorMaiorPontuacao);

        // Chamada recursiva para processar as pontuações restantes
        resultado.putAll(removerRepetidos(pontuacoesSemMaior));

        return resultado;
    } 
    
    /**
     * ordenarPontuacoes() organiza os jogadores da maior pontuacão pra menor pontuacão 
     * 
     * @param 
     *  Map<String, Integer> pontuacoes [lista coletada pelo metodo removerRepetidos()]
     *  
     * @return Map<String, Integer> [retorna uma lista dos pontos de cada jogador num objeto Map<String, Integer>]
     * @author Heber Junior
     * @version 1.0
     */
        public static Map<String, Integer> ordenarPontuacoes(Map<String, Integer> pontuacoes) {
        List<Map.Entry<String, Integer>> lista = new ArrayList<>(pontuacoes.entrySet());
        mergeSort(lista, 0, lista.size() - 1);
        Map<String, Integer> mapaOrdenado = new LinkedHashMap<>();
        for (Map.Entry<String, Integer> entrada : lista) {
            mapaOrdenado.put(entrada.getKey(), entrada.getValue());
        }
        return mapaOrdenado;
    }
    
    /**
     * mergeSort() organiza objetos numa lista 
     * 
     * @param 
     *  List<Map.Entry<String, Integer>> lista [lista a ser organizada]
     *  int inicio [comeco da lista]
     *  int fim [fim da lista]
     *  
     * @return null
     * @author Heber Junior
     * @version 1.0
     */
    private static void mergeSort(List<Map.Entry<String, Integer>> lista, int inicio, int fim) {
        if (inicio < fim) {
            int meio = (inicio + fim) / 2;
            mergeSort(lista, inicio, meio);
            mergeSort(lista, meio + 1, fim);
            merge(lista, inicio, meio, fim);
        }
    }
    
    /**
     * merge() uni novamente as listas organizadas 
     * 
     * @param 
     *  List<Map.Entry<String, Integer>> lista [lista a ser organizada]
     *  int inicio [comeco da lista]
     *  int fim [fim da lista]
     *  
     * @return null
     * @author Heber Junior
     * @version 1.0
     */
    private static void merge(List<Map.Entry<String, Integer>> lista, int inicio, int meio, int fim) {
        List<Map.Entry<String, Integer>> listaEsquerda = new ArrayList<>(lista.subList(inicio, meio + 1));
        List<Map.Entry<String, Integer>> listaDireita = new ArrayList<>(lista.subList(meio + 1, fim + 1));
        int i = 0;
        int j = 0;
        for (int k = inicio; k <= fim; k++) {
            if (i >= listaEsquerda.size()) {
                lista.set(k, listaDireita.get(j));
                j++;
            } else if (j >= listaDireita.size()) {
                lista.set(k, listaEsquerda.get(i));
                i++;
            } else if (listaEsquerda.get(i).getValue() >= listaDireita.get(j).getValue()) {
                lista.set(k, listaEsquerda.get(i));
                i++;
            } else {
                lista.set(k, listaDireita.get(j));
                j++;
            }
        }
    }
}