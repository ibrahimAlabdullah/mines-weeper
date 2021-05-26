package Player;
import Input.ComputerInput;
import Input.Input;

public class ComputerPlayer extends Player{

    @Override
    public Input GetPlayerMove() 
    {
     Input in=new ComputerInput();
     in= in.input();
     
     return in ;
    }
    
}
