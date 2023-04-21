import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
* RetryButton() cria o ator RetryButton
* 
* @param null
* @return null
* @author Heber Junior
* @version 1.0
*/
public class RetryButton extends Actor
{
    /**
     * RetryButton() construtor da classe RetryButton 
     * 
     * @param null
     * @return null
     * @author Heber Junior
     * @version 1.0
     */
    public RetryButton()
    {
        GreenfootImage i = getImage();
        i.scale(260,140);
        setImage(i);
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
        if(Greenfoot.mouseClicked(this))
        {
            Greenfoot.setWorld(new Space());
            
        } 
    }
}
