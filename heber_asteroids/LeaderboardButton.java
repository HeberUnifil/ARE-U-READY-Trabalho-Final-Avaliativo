import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * LeaderboardButton.class cria o botão de acesso ao Leaderboard
 * 
 * @param null
 * @return null
 * @author Heber Junior
 * @version 1.0
 */
public class LeaderboardButton extends Actor
{
    int score;
 
    /**
     * LeaderboardButton() construtor da classe LeaderboardButton 
     * 
     * @param null
     * @return null
     * @author Heber Junior
     * @version 1.0
     */
    public LeaderboardButton(int pontos) {
        GreenfootImage i = getImage();
        i.scale(460,140);
        setImage(i);
        score= pontos;
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
        if(Greenfoot.mouseClicked(this)){
            Greenfoot.setWorld(new LeaderboardSpace(this.score));
        }
    }
}
