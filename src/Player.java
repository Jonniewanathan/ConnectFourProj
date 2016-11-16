/**
 * Created by t00125172 on 15/11/2016.
 */
public class Player {
    private String name;
    private static int win;
    private static int loses;

    Player(){
        this("none");
    }
    Player(String name){
        setName(name);
        win = 0;
        loses = 0;
    }
    public void setName(String name){
        this.name = name;
    }
    public static void setWin(int win2){
        win += win2;
    }
    public static void setLoses(int loses2){
        loses += loses2;
    }
    public String getName(){
        return this.name;
    }
    public int getWin(){
        return win;
    }
    public int getLoses(){
        return loses;
    }
    public String toString(){
        return "Name: " + getName() + "\n" + "Win: " + getWin() + "\n" + "Loses: " + getLoses();
    }

}
