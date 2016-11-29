import java.io.*;

/**This is an instantiable Player Class.
 *@author Jonathan Quirke
 *@version 1.0*/
public class Player implements Serializable{
    //attributes
    private String name;
    private int win;
    private int loses;

    /**no argument constructor method
     */
    public Player()
    {
        this("none");
    }

    /**single argument constructor method
     @param name the full name of the Player
     */
    public Player(String name){
        setName(name);
        setExactWin(0);
        setExactLose(0);
    }

    /**mutator method to set the player name
     * @param name the name of the student
     */
    public void setName(String name)
    {
        this.name = name;
    }

    /**mutator method to add to the players win count
     *@param win the number of wins to add to the win count
     */
    public void setWin(int win)
    {
        this.win += win;
    }
    /**mutator method to add to the players win count
     *@param loses the number of loses to add to the lose count
     */
    public void setLoses(int loses)
    {
        this.loses += loses;
    }
    /**mutator method to add to the players win count
     *@param win the numbers of wins the player has
     */
    public void setExactWin(int win)
    {
        this.win = win;
    }
    /**mutator method to add to the players win count
     *@param loses the number of loses the player has
     */
    public void setExactLose(int loses)
    {
        this.loses = loses;
    }

    /**acessor method to return the player name
     * @return name the name of the player
     */
    public String getName()
    {
        return this.name;
    }

    /**acessor method to return the number of player wins
     * @return win the number of player wins
     */
    public int getWin()
    {
        return this.win;
    }

    /**acessor method to return the number of player loses
     * @return loses the number of player loses
     */
    public int getLoses()
    {
        return this.loses;
    }

    /**toString method to return the players details
     * @return the name, wins and loses of the player
     */
    public String toString()
    {
        return "Name: " + getName() + "\n" + "Win: " + getWin() + "\n" + "Loses: " + getLoses();
    }

}//end of class
