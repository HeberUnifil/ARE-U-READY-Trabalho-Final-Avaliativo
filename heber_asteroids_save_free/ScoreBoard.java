import greenfoot.*;  // (World, Actor, GreenfootImage, and Greenfoot)
import java.util.Calendar;

/**
 * ScoreBoard.class cria o ator ScoreBoard
 * 
 * @param null
 * @return null
 * @author Heber Junior
 * @version 1.0
 */
public class ScoreBoard extends Actor
{
    public static final float FONT_SIZE = 48.0f;
    public static final int WIDTH = 400;
    public static final int HEIGHT = 300;
    private boolean lifetimeChecked = false;
    private int lifetime = 50;
    
    /**
     * act() define o que o ator fará assim que for criado
     * 
     * @param null
     * @return null
     * @author Heber Junior
     * @version 1.0
     */
    public void act()
    {
        GreenfootImage i = getImage();
        int t = i.getTransparency();
        i.setTransparency(0);
        
        i.setTransparency(t);
        checkLifetime();
    }
    
    /**
     * ScoreBoard() construtor da classe ScoreBoard 
     * 
     * @param null
     * @return null
     * @author Heber Junior
     * @version 1.0
     */
    public ScoreBoard()
    {
        this(000);
        
    }

    /**
     * ScoreBoard() construtor da classe ScoreBoard 
     * 
     * @param int score [quantidade de pontos do jogador]
     * @return null
     * @author Heber Junior
     * @version 1.0
     */
    public ScoreBoard(int score)
    {
        makeImage("Game Over", "Score: ", score);

    }

    /**
     * makeImage() gera a imagem do placar
     * 
     * @param 
     *  String title [título do placar]
     *  String prefix [prefixo da quantidade de pontos]
     *  int score [quantidade de pontos do jogador]
     * @return null
     * @author Heber Junior
     * @version 1.0
     */
    private void makeImage(String title, String prefix, int score)
    {
        GreenfootImage image = new GreenfootImage(WIDTH, HEIGHT);

        image.setColor(new Color(255,255,255, 128));
        image.fillRect(0, 0, WIDTH, HEIGHT);
        image.setColor(new Color(0, 0, 0, 128));
        image.fillRect(5, 5, WIDTH-10, HEIGHT-10);
        Font font = image.getFont();
        font = font.deriveFont(FONT_SIZE);
        image.setFont(font);
        image.setColor(Color.WHITE);
        image.drawString(title, 60, 100);
        image.drawString(prefix + score, 60, 200);
        setImage(image);
    }
    
    /**
     * checkLifetime() faz o placar piscar
     * 
     * @param null
     * @return null
     * @author Heber Junior
     * @version 1.0
     */
    private void checkLifetime() {
        if (lifetime == 0) {
            GreenfootImage i = getImage();
            int t = i.getTransparency();
            if (t < 100) {
                i.setTransparency(255);
                setImage(i);
            } else {
                i.setTransparency(0);
                setImage(i);
            }            
            
            lifetime = 50;
        } else {
            lifetime--;
        }
    }
}
