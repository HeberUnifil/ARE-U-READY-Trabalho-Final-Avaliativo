import greenfoot.*;  // (World, Actor, GreenfootImage, and Greenfoot)

/**
 * Uma variação de um ator que mantém a localização precisa (usando duplos para as coordenadas em vez de ints). 
 * Ele também mantém um movimento de corrente na forma de um vetor de movimento. 
 * Esta é uma variação da classe SmoothMover  
 * Esta versão implementa o wrap-around movement: quando o ator se move para fora do mundo de um lado, ele entra nele novamente na borda oposta.
 
/** SmoothMover.class cria o ator SmoothMover
 * 
 * @param null
 * @return null
 * @author Heber Junior
 * @version 1.0
 */
public abstract class SmoothMover extends Actor
{
    private Vector movement;
    private double exactX;
    private double exactY;
    
    /**
     * SmoothMover() cria o ator SmoothMover
     * 
     * @param null
     * @return null
     * @author Heber Junior
     * @version 1.0
     */
    public SmoothMover()
    {
        this(new Vector());
    }
    
    /**
     * SmoothMover() cria o ator SmoothMover
     * 
     * @param Vector movement [introduz um vetor de movimento já existente]
     * @return null
     * @author Heber Junior
     * @version 1.0
     */
    public SmoothMover(Vector movement)
    {
        this.movement = movement;
    }
    
    /**
     * move() ativamente move o ator
     * 
     * @param null
     * @return null
     * @author Heber Junior
     * @version 1.0
     */
    public void move() 
    {
        exactX = exactX + movement.getX();
        exactY = exactY + movement.getY();
        if(exactX >= getWorld().getWidth()) {
            exactX = 0;
        }
        if(exactX < 0) {
            exactX = getWorld().getWidth() - 1;
        }
        if(exactY >= getWorld().getHeight()) {
            exactY = 0;
        }
        if(exactY < 0) {
            exactY = getWorld().getHeight() - 1;
        }
        super.setLocation((int) exactX, (int) exactY);
    }
    
    /**
     * setLocation() muda a localidade do ator
     * 
     * @param 
     *  double x [localidade x]
     *  double y [localidade y]
     * @return null
     * @author Heber Junior
     * @version 1.0
     */
    public void setLocation(double x, double y) 
    {
        exactX = x;
        exactY = y;
        super.setLocation((int) x, (int) y);
    }
    
    /**
     * setLocation() muda a localidade do ator
     * 
     * @param 
     *  int x [localidade x]
     *  int y [localidade y]
     * @return null
     * @author Heber Junior
     * @version 1.0
     */
    public void setLocation(int x, int y) 
    {
        exactX = x;
        exactY = y;
        super.setLocation(x, y);
    }

    /**
     * getExactX() retorna a localizacão exata x do ator
     * 
     * @param null
     * @return double
     * @author Heber Junior
     * @version 1.0
     */
    public double getExactX() 
    {
        return exactX;
    }

    /**
     * getExactY() retorna a localizacão exata y do ator
     * 
     * @param null
     * @return double
     * @author Heber Junior
     * @version 1.0
     */
    public double getExactY() 
    {
        return exactY;
    }

    /**
     * addForce() soma os vetores do ator
     * 
     * @param Vector force [vetor a ser somado]
     * @return null
     * @author Heber Junior
     * @version 1.0
     */
    public void addForce(Vector force) 
    {
        movement.add(force);
    }
    
    /**
     * accelerate() soma os vetores do ator
     * 
     * @param double factor [fator de aceleracão do vetor]
     * @return null
     * @author Heber Junior
     * @version 1.0
     */
    public void accelerate(double factor)
    {
        movement.scale(factor);
        if (movement.getLength() < 0.15) {
            movement.setNeutral();
        }
    }
    
    /**
     * getSpeed() retorna a velocidade do movimento do ator
     * 
     * @param null
     * @return double
     * @author Heber Junior
     * @version 1.0
     */
    public double getSpeed()
    {
        return movement.getLength();
    }
    
    /**
     * stop() para o movimento do ator
     * 
     * @param null
     * @return null
     * @author Heber Junior
     * @version 1.0
     */
    public void stop()
    {
        movement.setNeutral();
    }
    
    /**
     * getMovement() retorna o vetor de movimento do ator
     * 
     * @param null
     * @return Vector
     * @author Heber Junior
     * @version 1.0
     */
    public Vector getMovement() 
    {
        return movement;
    }
}
