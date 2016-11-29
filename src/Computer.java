import java.io.*;

/**
 * Created by t00125172 on 15/11/2016.
 */
public class Computer extends Player implements Serializable{

    Computer(){
        setName("Computer");
        setWin(0);
        setLoses(0);
    }
    public int play()
    {
        return (int) (Math.random()*6)+1;
    }

}
