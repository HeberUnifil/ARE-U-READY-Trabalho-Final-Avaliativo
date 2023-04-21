import greenfoot.*;  // (World, Actor, GreenfootImage, and Greenfoot)
import java.util.List;

/**
* ProtonWave() cria o ator ProtonWave
* 
* @param null
* @return null
* @author Heber Junior
* @version 1.0
*/
public class ProtonWave extends Actor
{
    private int imageCount = 0;
    private static final int DAMAGE = 30;
    private static final int NUMBER_IMAGES= 30;
    private static GreenfootImage[] images;
    
    /**
     * ProtonWave() construtor da classe ProtonWave 
     * 
     * @param null
     * @return null
     * @author Heber Junior
     * @version 1.0
     */
    public ProtonWave() 
    {
        initializeImages();
        setImage(images[0]);
        /**Greenfoot.playSound("proton.wav");*/
    }
    
    /**
     * initializeImages() cria imagem de explosão 
     * 
     * @param null
     * @return null
     * @author Heber Junior
     * @version 1.0
     */
    public static void initializeImages() 
    {
        if(images == null) 
        {
            GreenfootImage baseImage = new GreenfootImage("wave.png");
            images = new GreenfootImage[NUMBER_IMAGES];
            for (int i = 0; i < NUMBER_IMAGES; i++)
            {
                int size = (i+1) * ( baseImage.getWidth() / NUMBER_IMAGES );
                images[i] = new GreenfootImage(baseImage);
                images[i].scale(size, size);
            }
            
        }
    }
    
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
        checkCollision();
        grow();
    }
    
    /**
     * grow() aumenta o tamanho da explosão 
     * 
     * @param null
     * @return null
     * @author Heber Junior
     * @version 1.0
     */
    private void grow()
    {
        if (imageCount >= NUMBER_IMAGES )
        {
            getWorld().removeObject(this);
        }
        else
        {
            setImage(images[imageCount]);
            imageCount++;
        }
    }
    
    /**
     * checkCollision() checa se o ator colide com outros ateroids
     * 
     * @param null
     * @return null
     * @author Heber Junior
     * @version 1.0
     */
    private void checkCollision()
    {
        int range = getImage().getWidth()/2;
        List<Asteroid> asteroids = getObjectsInRange(range, Asteroid.class);
        for ( Asteroid asteroid : asteroids )
        {
            asteroid.hit(DAMAGE);
        }
    }
    
}
