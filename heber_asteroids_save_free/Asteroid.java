import greenfoot.*;  // (World, Actor, GreenfootImage, and Greenfoot)

/** Asteroid.class cria o ator Asteroid
 * 
 * @param null
 * @return null
 * @author Heber Junior
 * @version 1.0
 */
public class Asteroid extends SmoothMover
{
    private int size;
    private int stability;
    
    /** Asteroid() construtor da classe Asteroid
     * 
     * @param null
     * @return Asteroid
     * @author Heber Junior
     * @version 1.0
     */
    public Asteroid()
    {
        this(50);
    }
    
    /** Asteroid() construtor da classe Asteroid
     * 
     * @param int size [tamanho desejado do Asteroid]
     * @return Asteroid
     * @author Heber Junior
     * @version 1.0
     */
    public Asteroid(int size)
    {
        super(new Vector(Greenfoot.getRandomNumber(360), 2));
        setSize(size);
    }
    
    /** Asteroid() construtor da classe Asteroid
     * 
     * @param 
     *  int size [tamanho desejado do Asteroid]
     *  Vector speed [vetor de velocidade do asteroid]
     * @return Asteroid
     * @author Heber Junior
     * @version 1.0
     */
    public Asteroid(int size, Vector speed)
    {
        super(speed);
        setSize(size);
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
        move();
    }

    /**
     * setSize() muda o tamanho do asteroid
     * 
     * @param int size [tamanho desejado do asteroid]
     * @return null
     * @author Heber Junior
     * @version 1.0
     */
    public void setSize(int size) 
    {
        stability = size;
        this.size = size;
        GreenfootImage image = getImage();
        image.scale(size, size);
    }

    /**
     * getStability() retorna a atual estabilidade do asteroid
     * 
     * @param int size [tamanho desejado do asteroid]
     * @return int
     * @author Heber Junior
     * @version 1.0
     */
    public int getStability() 
    {
        return stability;
    }
    
    /**
     * hit() registra dano no asteroid
     * 
     * @param int damage [dano ao asteroid]
     * @return null
     * @author Heber Junior
     * @version 1.0
     */
    public void hit(int damage) {
        stability = stability - damage;
        if(stability <= 0) 
            breakUp ();         
    }
    
    /**
     * breakUp() quebra o asteroid em asteroids menores, enquanto cria novos asteroids quando se quebra inteiramente um asteroid
     * 
     * @param null
     * @return null
     * @author Heber Junior
     * @version 1.0
     */
    private void breakUp() 
    {
        /**Greenfoot.playSound("Explosion.wav");*/
        
        if(size <= 16) 
        {
            Space space = (Space) getWorld();
            space.countScore();
            
            int r = getMovement().getDirection() + Greenfoot.getRandomNumber(45);
            double l = getMovement().getLength();
            Vector speed = new Vector(r + 60, l * 1.2);
            Asteroid a = new Asteroid(50, speed);
            
            int x = Greenfoot.getRandomNumber(getWorld().getWidth()/2);
            int y = Greenfoot.getRandomNumber(getWorld().getHeight()/2);
            getWorld().addObject(new Asteroid(), x, y);
            
            getWorld().removeObject(this);
            
        }
        else 
        {
            int r = getMovement().getDirection() + Greenfoot.getRandomNumber(45);
            double l = getMovement().getLength();
            Vector speed1 = new Vector(r + 60, l * 1.2);
            Vector speed2 = new Vector(r - 60, l * 1.2);        
            Asteroid a1 = new Asteroid(size/2, speed1);
            Asteroid a2 = new Asteroid(size/2, speed2);
            getWorld().addObject(a1, getX(), getY());
            getWorld().addObject(a2, getX(), getY());        
            a1.move();
            a2.move();
        
            getWorld().removeObject(this);
        }
    }
}