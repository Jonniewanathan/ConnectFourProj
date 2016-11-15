/**
 * Created by t00125172 on 15/11/2016.
 */
public class Computer extends Player{
    Computer(){

    }
    Computer(String name,int score){
        setName("Computer");
        setScore(0);
    }
    public int play(){
        return (int) (Math.random()*6)+1;
    }

}
