package MovePlayer;

import static Controler.Constatnts.*;
import static GameGrid.Grid.*;
import GameGrid.SquareState;
import GameState.Lose;
import Input.Input;
import static OutPut.GuiOutPut.label;
import static OutPut.GuiOutPut.num;
import static OutPut.GuiOutPut.number;
import static OutPut.GuiOutPut.open;
import static GameGrid.Grid.open;
import Player.ComputerPlayer;
import Player.HumanPlayer;
import Player.Player;
import static Player.Player.players;
import static GameState.Win.win;
import Input.GuiInput;
import static OutPut.GuiOutPut.gameStateLabel;
import static OutPut.GuiOutPut.primaryStageGrid;
import static OutPut.GuiOutPut.primaryStageScoor;
import static OutPut.GuiOutPut.*;
import OutPut.TimeGame;
import static Player.Player.saveInput;
import Score.*;
import static Score.Score_Methods.Scor;
import static java.lang.System.exit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class PlayerMove
{
   private SquareState status;
   public Score1 score;  
   private  Player player;
   private  Player player1;
  
 
  public PlayerMove()
   {
        score = new Score1();
        player1 = new ComputerPlayer();
        player = new HumanPlayer();
        players= new int[100];
        saveInput = new Input[100];
        
        for(int k=0;k<NUM_PLayer;k++)
           {
              players[k]=1;
           }
        
         for(int i=1;i<=99;i++)
                {
                    Input temp = new GuiInput();
                    saveInput[i]= temp;
                } 
       /*for(int i=0;i<NUM_PLayer;i++)
        {
            NAMEPLAYER[i]="n";
        }   
      for(int i=0;i<NUM_PLayer;i++)
        {
            NAMEPLAYER[i]=NAMEPLAYERTEXT[i].getText();
        }   */   
   }
   
public void move(Input input)
{
    SECOND=10;
    ifLose = false;
   
    
  if(choice==1)
     {
      input=player.GetPlayerMove();
     }
  else if(choice==2)
     {
        input=player1.GetPlayerMove();
     } 
  
  else if(choiceComputer==1&&ComputerTurn)
     {
      input=player1.GetPlayerMove(); 
     }
  
     if(!SCOOREBOARD)
        {
          saveInput[turn].x=input.x;
          saveInput[turn].y=input.y;
          saveInput[turn].type=input.type;
        }
     
     for(int i=0;i<NUM_PLayer;i++)
   
     try
     {
       if((input.type=='F')||(input.type=='f'))
       {
           if(grid[input.x][input.y].isOpen())
              {
                  if((choice!=1||choice!=2)&&choiceComputer!=1)
                  {
                      CURRENT_PLAYER--;
                      return;
                  }
                  else
                  {
                 System.out.println("Can not Flge Open Square Please Enter another Coordinates");
                 move(input);
                  }
              }
           else if(grid[input.x][input.y].getSatus().equals(status.F))
           {
               grid[input.x][input.y].setSatus(status.C);
               ImageView image = new ImageView(new Image("10.png"));
               image.setFitHeight(40);
               image.setFitWidth(40);
               button[input.y][input.x].setGraphic(image);
           }
           else
           {
               grid[input.x][input.y].setSatus(status.F);
               ImageView image = new ImageView(new Image("9.png"));
               image.setFitHeight(40);
               image.setFitWidth(40);
               button[input.y][input.x].setGraphic(image);
           }
       }
else if((input.type=='R')||(input.type=='r'))
       {
           if(grid[input.x][input.y].isOpen())
           {
               if((choice!=1||choice!=2)&&choiceComputer!=1)
                   return;
               else
               {
                System.out.println("this Square is already opend Please Enter another Coordinates");
                move(input);
               }
           }
           else 
           {
               
             if(grid[input.x][input.y].getNumber()>=0)  
             { 
                 grid[input.x][input.y].setOpen(true); 
                  
                 number = grid[input.x][input.y].getNumber();
                 num = Integer.toString(number); 
                    open(input.x,input.y,num);
               if((choice==1||choice==2)||choiceComputer==1)
                  {
                      open(input.x,input.y);
                  }
             } 
             else  
                 {
                   if(players[CURRENT_PLAYER]>0)
                     {
                        grid[input.x][input.y].setOpen(true);
                        players[CURRENT_PLAYER]--;
                        NUM_MINES--;
                        ifLose=false;
                        open(input.x, input.y,"-1"); 
                     }
                    else
                       {
                        grid[input.x][input.y].setOpen(true);
                           if(choice!=1&&choice!=2)
                            {     
                        open(input.x, input.y,"-1");                   
                         for(int k=0;k<NUM_ROWS;k++)
                            for(int j=0;j<NUM_COLS;j++)
                             {
                           if(grid[k][j].getNumber()==-1) 
                            open(k, j,"-1"); 
                              }
                             }
                        ifLose=true;
                       }    
                 }
            }
       }
        
       //if(TYPE_COMPUTER!=1 || (TYPE_COMPUTER==1 && CURRENT_PLAYER==1))
       for(int row=0;row<NUM_ROWS;row++)
       for(int col=0;col<NUM_COLS;col++)
       if(grid[row][col].isOpen() && grid[row][col].getnshield()==50 && !grid[row][col].getshield())
       {
          grid[row][col].setshield(true);
          players[CURRENT_PLAYER]++;
       }
    
   score.ScoreThisMOve(grid[input.x][input.y].getSatus(),input.x, input.y,CURRENT_PLAYER);  
   
   
     if(ifLose) 
     {      
            new Lose().lose();
            score.OrderScore();
            
            gameStateLabel.setText("Game State : Lose");
            //primaryStageGrid.hide();
            primaryStageScoor.show();
            
            
            Save.setDisable(true);
            QuickSave.setDisable(true);
           for(int g=0;g<NUM_ROWS;g++)
               for(int j=0;j<NUM_COLS;j++)
                   button[g][j].setDisable(true);         
       }
      
       if(win())
       {
           win();
           System.out.println("YOU WIN");
           score.OrderScore();
           
           gameStateLabel.setText("Game State Win : ");
           //primaryStageGrid.hide();
           primaryStageScoor.show();
          Save.setDisable(true);
          QuickSave.setDisable(true);
          for(int g=0;g<NUM_ROWS;g++)
               for(int j=0;j<NUM_COLS;j++)
                   button[g][j].setDisable(true);  
           //exit(0);
       }
     }
       catch(Exception e)
      {
         // e.printStackTrace();
          System.out.println("Error!!! \nPlease Enter another Coordinats\n");
      }
    
              
   }      
}