import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/** coin.class cria o ator coin
 * 
 * @param null
 * @return null
 * @author Heber Junior
 * @version 1.0
 */
public class coin extends Actor
{
    
    private GreenfootImage coin1 = new GreenfootImage("coin1.png"); 
    private GreenfootImage coin2 = new GreenfootImage("coin2.png"); 
    private GreenfootImage coin3 = new GreenfootImage("coin3.png"); 
    private GreenfootImage coin4 = new GreenfootImage("coin4.png"); 
    private GreenfootImage coin5 = new GreenfootImage("coin5.png"); 
    private GreenfootImage coin6 = new GreenfootImage("coin6.png");     
    private int count = 60;
    
    /**
     * act() define o que o ator fará assim que for criado - no caso ele roda a moeda e caso seja clicado ele inicia o jogo
     * 
     * @param null
     * @return null
     * @author Heber Junior
     * @version 1.0
     */
    public void act()
    {
        count--;
        if (count >50){
            setImage(coin1);
        }else if(count<=50 && count > 40){
            setImage(coin2);
        }else if(count<=40 && count > 30){
            setImage(coin3);
        }else if(count<=30 && count > 20){
            setImage(coin4);
        }else if(count<=20 && count > 10){
            setImage(coin5);
        }else if(count<=10 && count > 0){
            setImage(coin6);
        } else{
            count = 60;
        }
        
        if(Greenfoot.mouseClicked(this))
        {
            Greenfoot.setWorld(new Space());
            
        }   
    }
}
