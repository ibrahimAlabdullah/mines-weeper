package OutPut;

import static Controler.Constatnts.*;
import static GameGrid.Grid.grid;
import static GameState.Win.win;
import java.util.Timer;
import java.util.TimerTask;
import static OutPut.GuiOutPut.*;
import Player.ComputerGui;
import static Player.Player.players;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.paint.Color;
import static Controler.Constatnts.*;

public class TimeGame  implements Runnable,Serializable
{
    Timer timer = new Timer();
     public static Thread threadStop;
     
      
    @Override
    public void run()
    {   
      
    TimerTask task = new TimerTask() 
    {
        @Override
        public void run() 
        {
            
          javafx.application.Platform.runLater(new Runnable() 
          {   
              @Override
              public void run() 
              { 
               if(ifLose||win())
                   Thread.currentThread().stop();
               
               
               time.setTextFill(Color.BLACK);
               if(NUM_PLayer!=1)
               time.setText("Time :"+SECOND); 
               if(CURRENT_PLAYER==NUM_PLayer)
                   CURRENT_PLAYER=0;
               if(SECOND<5)
               {
                   time.setTextFill(Color.RED);
               }
                
          turnLabel.setText("Turn : "+turn+" Player : "+NAMEPLAYERTEXT [CURRENT_PLAYER+1].getText()+"\nShield :"+players[CURRENT_PLAYER]);
        
           if(CURRENT_PLAYER==NUM_PLayer&&choiceComputer==1)
           {
                ComputerGui computergui = new ComputerGui();   
                computergui.run();
            }
        
               if(CURRENT_PLAYER==0)  
               turnLabel.setTextFill(Color.RED);
               else if(CURRENT_PLAYER==1)
               turnLabel.setTextFill(Color.ORANGE);
               else if(CURRENT_PLAYER==2)
               turnLabel.setTextFill(Color.PURPLE);
               else if(CURRENT_PLAYER==3)
               turnLabel.setTextFill(Color.VIOLET);
               else
               turnLabel.setTextFill(Color.GREEN);
              }
          });
            
            if(SECOND<=0)
                {
                SECOND=10;
                CURRENT_PLAYER++;
                }
            SECOND--;
           
           try
           {    
           FileOutputStream f = new FileOutputStream(quick_save);
           ObjectOutputStream o = new ObjectOutputStream(f);
           Save quickSave = new Save(null,0,NUM_ROWS,NUM_COLS,NUM_MINES,choice,choiceComputer,NUM_PLayer,CURRENT_PLAYER,
           TYPE_COMPUTER,NUM_SFEILD,turn,SECOND,FINISISH,LOSE,Winn,ifLose,ComputerTurn,grid);
        
            o.writeObject(quickSave); 
            o.close();
            f.close();
           }
              catch(IOException e)
              {
                  e.printStackTrace();
              }
        }
    };  
    timer.schedule(task,1000,1000);
}

    
}
