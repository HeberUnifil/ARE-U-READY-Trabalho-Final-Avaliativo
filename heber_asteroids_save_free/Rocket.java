import greenfoot.*;  // (World, Actor, GreenfootImage, and Greenfoot)

/** Rocket.class cria o ator Rocket
 * 
 * @param null
 * @return null
 * @author Heber Junior
 * @version 1.0
 */
public class Rocket extends SmoothMover
{
    private static final int gunReloadTime = 5;         
    private static final int protonReloadTime = 500; 

    private int reloadDelayCount;               
    private int protonReloadDelayCount;  
    
    private GreenfootImage rocket = new GreenfootImage("rocket.png");    
    private GreenfootImage rocketWithThrust = new GreenfootImage("rocketWithThrust.png");
    
    /** Rocket() construtor da classe Rocket
     * 
     * @param null
     * @return Rocket
     * @author Heber Junior
     * @version 1.0
     */
    public Rocket()
    {
        rocket.scale(50,30); 
        rocketWithThrust.scale(50,30);
        setImage(rocket);
        
        reloadDelayCount = 5;
        protonReloadDelayCount = 500;
        Vector drift = new Vector(0,0.3);
        addForce(drift);
        
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
        checkKeys();
        reloadDelayCount++;
        protonReloadDelayCount++;
        move();
        checkCollision();
    }
    
    /**
     * checkKeys() checa se as teclas de movimento foram pressionadas
     * 
     * @param null
     * @return null
     * @author Heber Junior
     * @version 1.0
     */
    private void checkKeys() 
    {
        if (Greenfoot.isKeyDown("space")) 
        {
            fire();
        }
        if (Greenfoot.isKeyDown("left")||Greenfoot.isKeyDown("a"))
        {
            setRotation( getRotation() - 5 );
        }
        if (Greenfoot.isKeyDown("right")||Greenfoot.isKeyDown("d"))
        {
            setRotation( getRotation() + 5 );
        }
        
        ignite(Greenfoot.isKeyDown("up")||Greenfoot.isKeyDown("w"));
        if (Greenfoot.isKeyDown("down")||Greenfoot.isKeyDown("s")){
            getMovement().scale(0.9);
        }
        if (Greenfoot.isKeyDown("z"))
        {
            startProtonWave();
        }
    }
    
    /**
     * fire() atira se a arma do foguete estiver pronta
     * 
     * @param null
     * @return null
     * @author Heber Junior
     * @version 1.0
     */
    private void fire() 
    {
        if (reloadDelayCount >= gunReloadTime) 
        {
            Bullet bullet = new Bullet (getMovement().copy(), getRotation());
            getWorld().addObject (bullet, getX(), getY());
            bullet.move ();
            reloadDelayCount = 0;
        }
    }
    
    /**
     * ignite() move o foguete pra frente e muda o sprite do foguete
     * 
     * @param null
     * @return null
     * @author Heber Junior
     * @version 1.0
     */
    private void ignite( boolean boosterOn )
    {
        if (boosterOn)
        {
            
            setImage(rocketWithThrust);
            Vector drift = new Vector(getRotation(), 0.3);
            addForce(drift);
        }
        if (!boosterOn)
        {
            
            setImage(rocket);
        }
    }
    
    /**
     * checkCollision() checa se o foguete bateu em algum asteroid
     * 
     * @param null
     * @return null
     * @author Heber Junior
     * @version 1.0
     */
    private void checkCollision()
    {
        Actor asteroid = getOneIntersectingObject(Asteroid.class);
        if (asteroid != null)
        {
            getWorld().addObject( new Explosion(), getX(), getY() );
            Space space = (Space) getWorld();
            space.gameOver();
            getWorld().removeObject(this);
        }
    }
    
    /**
     * startProtonWave() cria um ataque de proton wave
     * 
     * @param null
     * @return null
     * @author Heber Junior
     * @version 1.0
     */
    private void startProtonWave()
    {
        if (protonReloadDelayCount >= protonReloadTime)
        {
            getWorld().addObject( new ProtonWave(), getX(), getY() );
            protonReloadDelayCount = 0;
        }
    } 
    
}