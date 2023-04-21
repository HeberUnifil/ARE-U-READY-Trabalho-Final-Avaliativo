import greenfoot.*;  // (World, Actor, GreenfootImage, and Greenfoot)
import javax.swing.JOptionPane;
import java.util.List;
import java.io.*;
import java.util.*;

/**
 * LeaderboardSpace.class Tela de exposicão do Highscore do jogo
 * 
 * @param int pontos - Ao chamar essa classe, deve se passar os pontos que o jogador adquiriu durante a fase de jogo.
 * 
 * @author Heber Junior
 * @version 1.0
 */  

public class LeaderboardSpace extends World
{
    private Counter scoreCounter;
    private int startAsteroids = 15;

    
    /**
     * LeaderboardSpace() constutor da tela de exposicão do Highscore do jogo
     * 
     * @param int pontos - Ao chamar esse metodo, deve se passar os pontos que o jogador adquiriu durante a fase de jogo.
     * @return null
     * @author Heber Junior
     * @version 1.0
     */  
    public LeaderboardSpace(int pontos) 
    {
        super(1200, 700, 1);
        GreenfootImage background = getBackground();
        background.setColor(Color.BLACK);
        background.fill();
        
        createStars( 300 );
        
        addAsteroids(startAsteroids);
                
        setPaintOrder(ScoreBoard2.class,Asteroid.class);
        save(Greenfoot.ask("Digite o seu nome"), pontos);
        prepare();
        addObject(new RetryButton(), getWidth()*7/8, getHeight()*7/8);
    }
    
    /**
     * addAsteroids() cria asteroids no espaco
     * 
     * @param int count - Ao chamar esse metodo, deve se passar a quantidade de asterois da serem criados.
     * @return null
     * @author Heber Junior
     * @version 1.0
     */ 
    public void addAsteroids(int count) 
    {
        for(int i = 0; i < count; i++) 
        {
            int x = Greenfoot.getRandomNumber(getWidth()/2);
            int y = Greenfoot.getRandomNumber(getHeight()/2);
            addObject(new Asteroid(), x, y);
        }
    }
    
    /**
     * createStars() cria os pontos de estrelas no espaco
     * 
     * @param int number - Ao chamar esse metodo, deve se passar os pontos de estrelas a serem criados.
     * @return null
     * @author Heber Junior
     * @version 1.0
     */
    private void createStars( int number )
    {
        GreenfootImage background = getBackground();
        for ( int i = 0; i < number; i++ )
        {
            int x = Greenfoot.getRandomNumber( getWidth() );
            int y = Greenfoot.getRandomNumber( getHeight() );
            int color = Greenfoot.getRandomNumber( 256 );
            background.setColor( new Color(color, color, color) );
            background.fillOval(x, y, 2, 2);
        } 
    }
    
    
    /**
     * prepare() gera o ator Scoreboard
     * 
     * @param null
     * @return null
     * @author Heber Junior
     * @version 1.0
     */
    private void prepare()
    {
        ScoreBoard2 scoreboard = new ScoreBoard2();
        addObject(scoreboard,getWidth()/2,getHeight()- 350);
        
    }
    
    /**
     * save() salva os pontos do jogados
     * 
     * @param 
     *  String nome [nome do jogador]
     *  int pontos [pontos adquiridos pelo jogador]
     * @return null
     * @author Heber Junior
     * @version 1.0
     */
    private void save(String nome, int pontos){
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("saves.txt", true));
            writer.write(nome + "," + pontos);
            writer.newLine();
            writer.close();
        } catch (IOException e) {
          System.out.println("An error occurred.");
          e.printStackTrace();
        }
        try
            {
                SaveManager.SaveManager();
            }
            catch (java.io.IOException ioe)
            {
                System.out.println("An error occurred.");
                ioe.printStackTrace();
            }
    }    
}
