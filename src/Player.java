/**
 * Created by t00125172 on 15/11/2016.
 */
public class Player {
    private String name;
    private int score;

    Player(){
        this("none",0);
    }
    Player(String name,int score){
        setName(name);
        setScore(score);
    }
    public void setName(String name){
        this.name = name;
    }
    public void setScore(int score){
        this.score = score;
    }
    public String getName(){
        return this.name;
    }
    public int getScore(){
        return this.score;
    }
    public String toString(){
        return "Name: " + this.name + "\n" + "Score" + this.score;
    }

}
