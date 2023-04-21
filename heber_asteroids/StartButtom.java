import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/** StartButtom.class cria o ator StartButtom
 * 
 * @param null
 * @return null
 * @author Heber Junior
 * @version 1.0
 */
public class StartButtom extends Actor
{
    private GreenfootImage i = getImage();
    private int lifetime = 30;

    /** StartButtom() construtor da classe StartButtom
     * 
     * @param null
     * @return StartButtom
     * @author Heber Junior
     * @version 1.0
     */
    public StartButtom(){
        i.scale(600,300);
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
        checkLifetime();
        if(Greenfoot.mouseClicked(this))
        {
            Greenfoot.setWorld(new Space());
            
        }        
    }
    
    /**
     * checkLifetime() faz o botão piscar
     * 
     * @param null
     * @return null
     * @author Heber Junior
     * @version 1.0
     */
    private void checkLifetime(){
        if(lifetime==0){
            GreenfootImage i = getImage();
            int t = i.getTransparency();
            if(t<100){
                i.setTransparency(255);
                setImage(i);
                lifetime = 50;
            }else{
                i.setTransparency(0);
                setImage(i);
                lifetime = 50;
            }
        } else{
            
            lifetime--;
        }
    }
    
}
