import greenfoot.*;  // (World, Actor, GreenfootImage, and Greenfoot)


import java.awt.Graphics;

/**
 * Counter.class cria o contador de pontos do jogador
 * 
 * @param 
 * @return null
 * @author Heber Junior
 * @version 1.0
 */
public class Counter extends Actor
{
    private static final Color textColor = new Color(255, 180, 150);
    
    private int value = 0;
    private int target = 0;
    private String text;
    private int stringLength;

    /**
     * Counter() é o construtor da classe Counter
     * 
     * @param 
     * @return null
     * @author Heber Junior
     * @version 1.0
     */
    public Counter()
    {
        this("");
    }

    /**
     * Counter() é o construtor da classe Counter
     * 
     * @param String prefix [variavel que inicializa o tamanho do contador]
     * @return null
     * @author Heber Junior
     * @version 1.0
     */
    public Counter(String prefix)
    {
        text = prefix;
        stringLength = (text.length() + 2) * 10;

        setImage(new GreenfootImage(stringLength, 16));
        GreenfootImage image = getImage();
        image.setColor(textColor);

        updateImage();
    }
    
    /**
     * act() define o que o ator fará assim que for criado
     * 
     * @param null
     * @return null
     * @author Heber Junior
     * @version 1.0
     */
    public void act() {
        if(value < target) {
            value++;
            updateImage();
        }
        else if(value > target) {
            value--;
            updateImage();
        }
    }
    
    /**
     * add() adiciona pontos ao jogador
     * 
     * @param int score [quantidade de pontos a serem dados ao jogador]
     * @return null
     * @author Heber Junior
     * @version 1.0
     */
    public void add(int score)
    {
        target += score;
    }

    /**
     * getValue() retorna a quantidade de pontos do jogador
     * 
     * @param 
     * @return int [quantidade de pontos do jogador]
     * @author Heber Junior
     * @version 1.0
     */
    public int getValue()
    {
        return value;
    }

    /**
     * updateImage() troca a imagem do contador de acordo com a quantidade de pontos
     * 
     * @param 
     * @return 
     * @author Heber Junior
     * @version 1.0
     */
    private void updateImage()
    {
        GreenfootImage image = getImage();
        image.clear();
        image.drawString(text + value, 1, 12);
    }
}
