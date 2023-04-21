import greenfoot.*;  // (World, Actor, GreenfootImage, and Greenfoot)
import javax.swing.JOptionPane;
import java.util.List;

/**
 * StartMenu.class cria o ambiente menu inicial do jogo
 * 
 * @param null
 * @return null
 * @author Heber Junior
 * @version 1.0
 */
public class StartMenu extends World
{
    private Counter scoreCounter;
    private int startAsteroids = 15;

    /**
     * StartMenu() construtor da classe StartMenu
     * 
     * @param null
     * @return null
     * @author Heber Junior
     * @version 1.0
     */
    public StartMenu() 
    {
        super(1200, 700, 1);
        GreenfootImage background = getBackground();
        background.setColor(Color.BLACK);
        background.fill();
        
        createStars( 300 );
        
        addObject(new logo(), getWidth()/2, getHeight()/4);
        addObject(new insert(), getWidth()/2, getHeight()*4/7);
        addObject(new coin(), getWidth()/2, getHeight()*5/7);
        
        addAsteroids(startAsteroids);
        
        setPaintOrder(logo.class,Asteroid.class);
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
    
}