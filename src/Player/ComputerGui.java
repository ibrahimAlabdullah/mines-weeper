package Player;

import static Controler.Constatnts.CURRENT_PLAYER;
import static Controler.Constatnts.ComputerTurn;
import Input.ComputerInput;
import Input.Input;
import MovePlayer.PlayerMove;


public class ComputerGui implements Runnable
{
    @Override
    public void run() 
    {
        
         /*try 
          {
             Thread.sleep(500);
          } catch (InterruptedException ex)
          {
            Logger.getLogger(TimeGame.class.getName()).log(Level.SEVERE, null, ex);
          }*/
         // turnLabel.setText("Comp :"+CURRENT_PLAYER+"  Shield :"+players[CURRENT_PLAYER]);
         // turnLabel.setTextFill(Color.BLUE);
          PlayerMove move = new PlayerMove();
          Input in = new ComputerInput();
          ComputerTurn=true;
          move.move(in);
          ComputerTurn=false;
          CURRENT_PLAYER =1; 
    }
}
