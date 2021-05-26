package Player;

import Input.ConsolInput;
import Input.Input;

public class HumanPlayer extends Player{
    
    public HumanPlayer()
    {
       
    }
    
    @Override
    public Input GetPlayerMove() 
    {  Input in=new ConsolInput();
       in= in.input();
       
     return in ;
    }
    
   

    
}
