import greenfoot.*;  // (World, Actor, GreenfootImage, and Greenfoot)

/** Bullet.class cria o ator Bullet
 * 
 * @param null
 * @return null
 * @author Heber Junior
 * @version 1.0
 */
public class Bullet extends SmoothMover
{
    private static final int damage = 16;
    private int life = 40;
    
    /** Bullet() construtor neutro da classe Bullet
     * 
     * @param null
     * @return Bullet
     * @author Heber Junior
     * @version 1.0
     */
    public Bullet()
    {
    }
    
    /** Bullet() construtor da classe Bullet
     * 
     * @param 
     *  Vector speed [vetor de velocidade do tiro]
     *  int rotation [direcão do tiro]
     * @return Bullet
     * @author Heber Junior
     * @version 1.0
     */
    public Bullet(Vector speed, int rotation)
    {
        super(speed);
        setRotation(rotation);
        addForce(new Vector(rotation, 15));
        /**Greenfoot.playSound("EnergyGun.wav");*/
        
        setRotation(rotation);
        GreenfootImage i = getImage();
        i.setTransparency(0);
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
        if(life <= 0) {
            getWorld().removeObject(this);
        } 
        else {
            GreenfootImage i = getImage();
            i.scale(8,4);
            if (life >= 39)
            {
                i.setTransparency(0);
                setImage(i);    
            }
            else
            {
                i.setTransparency(255);
                setImage(i);
            }
            life--;
            move();
            checkAsteroidHit();
        }
    }
    
    /**
     * checkAsteroidHit() checa se o tiro acertou algum asteroid
     * 
     * @param null
     * @return null
     * @author Heber Junior
     * @version 1.0
     */
    private void checkAsteroidHit()
    {
        Asteroid asteroid = (Asteroid) getOneIntersectingObject(Asteroid.class);
        if (asteroid != null){
            getWorld().removeObject(this);
            asteroid.hit(damage);
        }
    }
}