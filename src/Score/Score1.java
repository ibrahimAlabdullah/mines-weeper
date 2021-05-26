package Score;

import static Controler.Constatnts.*;
import static GameGrid.Grid.grid;
import Player.HumanPlayer;
import GameGrid.SquareState;
import static GameState.Win.win;
import static OutPut.GuiOutPut.pane2;
import static OutPut.GuiOutPut.scoreLabel;
import static Player.Player.players;
import static Score.Save_Score.savescore;
import static Score.Score_Methods.Scor;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import java.io.IOException;

public class Score1 extends Score_Methods{
    
    HumanPlayer humanplayer;
    int ScoreLoser,ScoreWinner;
    boolean finish;
    public Score1()
    {
        finish=false;
        ScoreLoser=0;
        ScoreWinner=0;
    }
    
public void ScoreThisMOve( SquareState status,int x,int y, int k)
           { 
                if(FINISISH)
                {
                  ScoreLoser=CURRENT_PLAYER;
                  finish=true;
                }
              if(grid[x][y].getNumber()==0)
                 Scor[k]+=10;
              if(grid[x][y].getNumber()>0)
              {
                Scor[k]+=grid[x][y].getNumber();
              }
              if(grid[x][y].getSatus()==status.F)
              {
                  if(grid[x][y].getNumber()>0)
                    Scor[k]+=(-grid[x][y].getNumber()-1);
                else 
                    Scor[k]+=5;
              }
              if(grid[x][y].getNumber() == -1 && players[k]>=0 && !ifLose)
                  Scor[k]-=10;
              for(k=1;k<=NUM_PLayer;k++)
               if(win())
               {
               Scor[k]+=100*NUM_MINES;
               Scor[k]+=50* players[k];
             }
           }
           
    @Override
    public void OrderScore() throws IOException
    {
         for(int i=1;i<=NUM_PLayer;i++)
        {
         scoreLabel[i] = new Label();
         scoreLabel[i].setStyle("-fx-font: bold 40px adobe");
         scoreLabel[i].setTextFill(Color.RED);
         pane2.add(scoreLabel[i],1, i);
        }
      
        if((choice!=1||choice!=2)&&choiceComputer!=1)
        for(int k=1;k<=NUM_PLayer;k++)
              scoreLabel[k].setText("Player "+k+" Score is : "+Scor[k]);
          
        for(int k=1;k<=NUM_PLayer;k++)
          System.out.println("The score of player ["+k+"]  is :"+Scor[k]);
        if(!finish)
        for(int k=1;k<=NUM_PLayer;k++)
            {
                 if(Scor[k]<min)
                {
                    min=Scor[k];
                    ScoreLoser=k;
                }}
         for(int k=1;k<=NUM_PLayer;k++)
            if(Scor[k]>max)
                {
                    if(k==ScoreLoser)
                        continue;
                    max=Scor[k];
                    ScoreWinner=k;
                }
            
            System.out.println("The loser player is ["+ScoreLoser+"]");
            
            System.out.println("The winner player is ["+ScoreWinner+"]");
            if(!SCOOREBOARD)
            savescore();
    }
      
}
