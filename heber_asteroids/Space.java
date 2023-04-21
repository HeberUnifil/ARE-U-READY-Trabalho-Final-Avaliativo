import greenfoot.*;  // (World, Actor, GreenfootImage, and Greenfoot)
import javax.swing.JOptionPane;
import java.util.List;

/**
 * Space.class cria o ambiente aonde roda o jogo
 * 
 * @param 
 * @return null
 * @author Heber Junior
 * @version 1.0
 */
public class Space extends World
{
    private Counter scoreCounter;
    private int startAsteroids = 3;

    /**
     * Space() construtor do ambiente Space
     * 
     * @param 
     * @return null
     * @author Heber Junior
     * @version 1.0
     */
    public Space() 
    {
        super(1200, 700, 1);
        GreenfootImage background = getBackground();
        background.setColor(Color.BLACK);
        background.fill();
        
        createStars( 300 );
        
        
        addObject(new Rocket(), getWidth()/2 + 100, getHeight()/2);
        
        addAsteroids(startAsteroids);
        
        scoreCounter = new Counter("Score: ");
        addObject(scoreCounter, 60, 380);

        Explosion.initializeImages();
        ProtonWave.initializeImages();
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
        } // end for ( int i = 0; i < number; i++ )
    }
    
    /**
     * countScore() adiciona pontos ao jogador
     * 
     * @param null
     * @return null
     * @author Heber Junior
     * @version 1.0
     */
    public void countScore()
    {
        List<Counter> score = getObjects(Counter.class);
        for (Counter s : score)
        {
            s.add(100);
        }
    }
    
    /**
     * gameOver() adiciona tela de game over
     * 
     * @param null
     * @return null
     * @author Heber Junior
     * @version 1.0
     */
    public void gameOver() 
    {
        List<Counter> score = getObjects(Counter.class);
        for (Counter s : score)
        {
            int finalScore = s.getValue();
            addObject( new ScoreBoard( finalScore ), getWidth()/2, getHeight()/2 );
            addObject( new RetryButton(), getWidth()*4/10, getHeight()*5/6 -5 );
            addObject( new LeaderboardButton(finalScore), getWidth()*6/10, getHeight()*5/6 );
                   
        }

    }

}