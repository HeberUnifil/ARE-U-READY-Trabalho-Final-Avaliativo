import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/** logo.class cria o ator logo
 * 
 * @param null
 * @return null
 * @author Heber Junior
 * @version 1.0
 */
public class logo extends Actor
{
    private GreenfootImage i = getImage();
    
    /** logo() construtor da classe logo
     * 
     * @param null
     * @return logo
     * @author Heber Junior
     * @version 1.0
     */
    public logo()
    {
        i.scale(600,300);
        setImage(i); 
        
    }
}
