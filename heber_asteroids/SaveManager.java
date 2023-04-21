import java.io.BufferedReader;
import java.util.*;
import java.io.*;

/** SaveManager.class faz o controle dos saves dos jogadores
 * 
 * @param null
 * @return null
 * @author Heber Junior
 * @version 1.0
 */
public class SaveManager {
    
    /**
     * SaveManager() roda a rotina de save do jogo
     * Essa rotina implica em:
     *  - Ler o arquivo saves.txt e armazenar as pontuações em um mapa
     *  - Selecionar apenas as linhas com maior valor para cada jogador
     *  - Escrever o resultado no arquivo saves_temp.txt
     *  - apagar o arquivo saves.txt original
     *  - Renomear o arquivo saves_temp.txt para saves.txt, substituindo o arquivo original
     *  
     * @param null
     * @return null
     * @author Heber Junior
     * @version 1.0
     */
    public static void SaveManager() throws IOException {
        
        Map<String, Integer> pontuacoes = lerArquivo();

        
        Map<String, Integer> pontuacoesFinais = removerRepetidos(pontuacoes);

        
        escreverArquivo("saves_temp.txt",pontuacoesFinais );
        
        
        apagarArquivo("saves.txt");
        
        
        renomearArquivo("saves_temp.txt", "saves.txt");
        
    }

    /**
     * lerArquivo() faz a leitura do arquivo saves.txt e retorna um Map<String, Integer>
     * 
     * @param null
     * @return Map<String, Integer>
     * @author Heber Junior
     * @version 1.0
     */
    public static Map<String, Integer> lerArquivo() throws IOException {
        Map<String, Integer> pontuacoes = new HashMap<>();

        try (BufferedReader br = new BufferedReader(new FileReader("saves.txt"))) {
            String linha;
            while ((linha = br.readLine()) != null) {
                String[] partes = linha.split(",");
                String jogador = partes[0];
                int pontuacao = Integer.parseInt(partes[1].trim());
                if (!pontuacoes.containsKey(jogador)) {
                    pontuacoes.put(jogador, pontuacao);
                } else {
                    int pontuacaoAtual = pontuacoes.get(jogador);
                    if (pontuacao > pontuacaoAtual) {
                        pontuacoes.put(jogador, pontuacao);
                    }
                }
            }
        }
        return pontuacoes;
    }

    /**
     * removerRepetidos() remove as pontuacões repetidas e mantem apenas a maior pontuacão
     * 
     * @param Map<String, Integer> pontuacoes [recebe a o objeto Map<String, Integer> do metodo lerArquivo]
     * @return Map<String, Integer>
     * @author Heber Junior
     * @version 1.0
     */
    public static Map<String, Integer> removerRepetidos(Map<String, Integer> pontuacoes) {
        Map<String, Integer> resultado = new HashMap<>();
        for (Map.Entry<String, Integer> entry : pontuacoes.entrySet()) {
            String jogador = entry.getKey();
            Integer pontuacao = entry.getValue();
            if (resultado.containsKey(jogador)) {
                Integer maiorPontuacao = resultado.get(jogador);
                if (pontuacao > maiorPontuacao) {
                    resultado.put(jogador, pontuacao);
                }
            } else {
                resultado.put(jogador, pontuacao);
            }
        }
        if (resultado.equals(pontuacoes)) {
            return resultado;
        } else {
            return removerRepetidos(resultado);
        }
    }
    
    /**
     * escreverArquivo() registra no arquivo desejado com um objeto Map<String, Integer>
     * 
     * @param 
     *  String nomeArquivo [nome do arquivo a ser editado]
     *  Map<String, Integer> pontuacoes [lista de pontuacões a ser gravadas] 
     * @return null
     * @author Heber Junior
     * @version 1.0
     */
    public static void escreverArquivo(String nomeArquivo, Map<String, Integer> pontuacoes) {
        try {
            PrintWriter writer = new PrintWriter(nomeArquivo);
            for (Map.Entry<String, Integer> entry : pontuacoes.entrySet()) {
                String jogador = entry.getKey();
                Integer pontuacao = entry.getValue();
                writer.println(jogador + "," + pontuacao);
            }
            writer.close();
        } catch (FileNotFoundException e) {
            System.err.println("Erro ao escrever arquivo: " + e.getMessage());
        }
    }
    
    /**
     * renomearArquivo() renomeia o arquivo desejado
     * 
     * @param 
     *  String nomeArquivoAntigo
     *  String nomeArquivoNovo
     * @return null
     * @author Heber Junior
     * @version 1.0
     */
    public static void renomearArquivo(String nomeArquivoAntigo, String nomeArquivoNovo) {
        File arquivoAntigo = new File(nomeArquivoAntigo);
        File arquivoNovo = new File(nomeArquivoNovo);
        if (arquivoAntigo.exists()) {
            arquivoAntigo.renameTo(arquivoNovo);
        }
    }
    
    /**
     * apagarArquivo() apaga o arquivo desejado
     * 
     * @param String nomeArquivo
     * @return null
     * @author Heber Junior
     * @version 1.0
     */
    public static void apagarArquivo(String nomeArquivo) {
        File arquivo = new File(nomeArquivo);
        if (arquivo.exists()) {
            arquivo.delete();
        }
    }   
}
