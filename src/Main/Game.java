package Main;
import static Controler.Constatnts.*;
import GameGrid.Grid;
import Input.Input;

import static Player.Player.players;
import MovePlayer.PlayerMove;
import OutPut.GuiOutPut;
import Player.ComputerPlayer;
import Player.HumanPlayer;
import Player.Player;
import java.io.Serializable;
import java.util.Scanner;

public class Game implements Serializable
{

    
   private  Player player;
   private  Player player1;
   private Input in;
   
   
    public Game() 
    {
        player1 = new ComputerPlayer();
        player = new HumanPlayer();
        
    }    
    
   public void initGame()
   { 
       
   if(choice==1)
     {
      in=player.GetPlayerMove();
     }
  else if(choice==2)
     {
        in=player1.GetPlayerMove();
     } 
       
        Scanner input=new Scanner(System.in);
        Grid grid = new Grid();    
        System.out.println("1-Play Consol Game \n2- Play GUI Game");
        int number = 2;//input.nextInt();
        
        switch(number)
        {
            case 1 :
            { 
                 
                PlayerMove move = new PlayerMove();
                System.out.println("Enter the dimensions of the board");
                NUM_COLS =input.nextInt();
                NUM_ROWS =input.nextInt();
                System.out.println("Enter the number of mines");
                NUM_MINES=input.nextInt();
                System.out.println("Enter the number of shield");
                NUM_SFEILD=input.nextInt();
                
                 grid.initGrade();
                 grid.setMine();
                 grid.setNumber();
                 grid.setshield();
                System.out.println("1-Human Player\n2-Computer Player");
                choice = input.nextInt();
               
                switch(choice)
                {
                    case 1:
                    {
                         System.out.println("Enter the number of player");
                         NUM_PLayer = input.nextInt();
                         for(int k=1;k<=NUM_PLayer;k++)
                           players[k]=1;
                       do
                       {   
                           turn++; 
                       for(CURRENT_PLAYER=1;CURRENT_PLAYER<=NUM_PLayer;CURRENT_PLAYER++)
                       {
                         System.out.println("Turn "+turn+"  player "+CURRENT_PLAYER+":");
                         grid.show();
                         move.move(in);
                       }
                       }
                        while(!FINISISH);
                      break;
                    }
                    
                    case 2:
                    {
                    System.out.println("Enter the type of computer player \n1-Easy\n2-Hard");
                    TYPE_COMPUTER = input.nextInt();
                      do
                      { 
                         NUM_PLayer=2;
                         for(int k=1;k<=NUM_PLayer;k++)
                           players[k]=1;
                         CURRENT_PLAYER=1;
                         turn++;
                         System.out.println("Turn "+turn+"  player "+CURRENT_PLAYER+":");
                         choice=1;
                         grid.show();
                         move.move(in);
                         if(!FINISISH)
                         {
                         CURRENT_PLAYER=2;
                         System.out.println("Turn "+turn+"  player "+CURRENT_PLAYER+":");
                         choice=2;
                         grid.show();
                         move.move(in);
                       }
                      }
                      while(!FINISISH);
                     break;   
                    }
                }
                break;
            }
            case 2 :
            {  
               
                new Thread()
                 {    
                    @Override
                    public void run()
                    {
                      javafx.application.Application.launch(GuiOutPut.class);
                    }  
                  }.start();
             break;
            }       
        }
     }
}
