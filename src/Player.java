import java.io.*;

/**
 * Created by t00125172 on 15/11/2016.
 */
public class Player implements Serializable{
    private String name;
    private int win;
    private int loses;

    Player()
    {
        this("none");
    }
    Player(String name){
        setName(name);
        setExactWin(0);
        setExactLose(0);
    }
    public void setName(String name)
    {
        this.name = name;
    }
    public void setWin(int win)
    {
        this.win += win;
    }
    public void setLoses(int loses)
    {
        this.loses += loses;
    }
    public void setExactWin(int win)
    {
        this.win = win;
    }
    public void setExactLose(int loses)
    {
        this.loses = loses;
    }
    public String getName()
    {
        return this.name;
    }
    public int getWin()
    {
        return this.win;
    }
    public int getLoses()
    {
        return this.loses;
    }
    public String toString()
    {
        return "Name: " + getName() + "\n" + "Win: " + getWin() + "\n" + "Loses: " + getLoses();
    }

}
