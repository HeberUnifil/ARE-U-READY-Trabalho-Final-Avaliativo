import greenfoot.Greenfoot;

/** Vector.class faz o controle dos vetores dos atores
 * 
 * @param null
 * @return null
 * @author Heber Junior
 * @version 1.0
 */
public final class Vector
{
    double dx;
    double dy;
    int direction;
    double length;
    
    /**
     * Vector() cria o ator Vector neutro
     * 
     * @param null
     * @return Vector
     * @author Heber Junior
     * @version 1.0
     */
    public Vector()
    {
    }

    
    /**
     * Vector() cria o ator Vector com direcão e sentido
     * 
     * @param 
     *  int direction [direcão do vetor, deve ser entre [0..359] aonde 0 é Leste]
     *  double length [tamanho do vetor]
     * @return Vector
     * @author Heber Junior
     * @version 1.0
     */
    public Vector(int direction, double length)
    {
        this.length = length;
        this.direction = direction;
        updateCartesian();
    }

    /**
     * Vector() cria o ator Vector com direcão e sentido baseando-se em dois pontos
     * 
     * @param 
     *  double dx [direcão x]
     *  double dy [direcão y]
     * @return Vector
     * @author Heber Junior
     * @version 1.0
     */
    public Vector(double dx, double dy)
    {
        this.dx = dx;
        this.dy = dy;
        updatePolar();
    }

    /**
     * setDirection() muda a direcão em graus do vetor mantendo a sua intensidade
     * 
     * @param 
     *  int direction [direcão x]
     * @return null
     * @author Heber Junior
     * @version 1.0
     */
    public void setDirection(int direction) 
    {
        this.direction = direction;
        updateCartesian();
    }
   
    /**
     * add() soma com outro vetor
     * 
     * @param 
     *  Vector other [Vetor a ser somado]
     * @return null
     * @author Heber Junior
     * @version 1.0
     */
    public void add(Vector other) 
    {
        dx += other.dx;
        dy += other.dy;
        updatePolar();
    }
    
    /**
     * setLength() muda a intensidade do vetor,mantendo a sua direcão
     * 
     * @param 
     *  double length [intensidade nova do vetor]
     * @return null
     * @author Heber Junior
     * @version 1.0
     */
    public void setLength(double length) 
    {
        this.length = length;
        updateCartesian();
    }
    
    
    /**
     * scale() aumenta a escala do vetor acima (factor > 1) ou abaixo(factor < 1), a direcão mantém a mesma
     * 
     * @param 
     *  double factor [fator de escala]
     * @return null
     * @author Heber Junior
     * @version 1.0
     */
    public void scale(double factor) 
    {
        length = length * factor;
        updateCartesian();
    }
    
    /**
     * setNeutral() remove todas as propriedades do vetor
     * 
     * @param null
     * @return null
     * @author Heber Junior
     * @version 1.0
     */
    public void setNeutral() {
        dx = 0.0;
        dy = 0.0;
        length = 0.0;
        direction = 0;
    }
    
    /**
     * revertHorizontal() inverte as propriedades X do vetor
     * 
     * @param null
     * @return null
     * @author Heber Junior
     * @version 1.0
     */
    public void revertHorizontal() {
        dx = -dx;
        updatePolar();
    }
    
    /**
     * revertHorizontal() inverte as propriedades Y do vetor
     * 
     * @param null
     * @return null
     * @author Heber Junior
     * @version 1.0
     */
    public void revertVertical() {
        dy = -dy;
        updatePolar();
    }
    
    /**
     * getX() retorna a propriedade X do ponto do vetor
     * 
     * @param null
     * @return Double
     * @author Heber Junior
     * @version 1.0
     */
    public double getX() {
        return dx;
    }
     
    /**
     * getY() retorna a propriedade Y do ponto do vetor
     * 
     * @param null
     * @return Double
     * @author Heber Junior
     * @version 1.0
     */
    public double getY() {
        return  dy;
    }
    
    /**
     * getDirection() retorna a direcão do vetor
     * 
     * @param null
     * @return int
     * @author Heber Junior
     * @version 1.0
     */
    public int getDirection() {
        return direction;
    }
    
    /**
     * getLength() retorna o tamanho do vetor
     * 
     * @param null
     * @return Double
     * @author Heber Junior
     * @version 1.0
     */
    public double getLength() {
        return length;
    }

    /**
     * updatePolar() atualiza as direcão cartesianas do vetor
     * 
     * @param null
     * @return null
     * @author Heber Junior
     * @version 1.0
     */
    private void updatePolar() 
    {
        this.direction = (int) Math.toDegrees(Math.atan2(dy, dx));
        this.length = Math.sqrt(dx*dx+dy*dy);
    }   
    
    /**
     * updateCartesian() atualiza as propriedades cartesianas do vetor
     * 
     * @param null
     * @return null
     * @author Heber Junior
     * @version 1.0
     */
    private void updateCartesian() 
    {
        dx = length * Math.cos(Math.toRadians(direction));
        dy = length * Math.sin(Math.toRadians(direction));   
    }
    
    /**
     * copy() cria uma copia o vetor
     * 
     * @param null
     * @return Vector
     * @author Heber Junior
     * @version 1.0
     */
    public Vector copy() 
    {
        Vector copy = new Vector();
        copy.dx = dx;
        copy.dy = dy;
        copy.direction = direction;
        copy.length = length;
        return copy;
    }    
}