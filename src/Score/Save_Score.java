package Score;

import static Controler.Constatnts.*;
import static GameGrid.Grid.grid;
import GameGrid.Square;
import GameGrid.SquareState;
import Input.GuiInput;
import Input.Input;
import MovePlayer.PlayerMove;
import OutPut.GuiOutPut;
import static OutPut.GuiOutPut.*;
import OutPut.TimeGame;
import static Player.Player.players;
import static Player.Player.saveInput;
import static Score.Score_Methods.Scor;
import com.sun.org.apache.bcel.internal.Constants;
import java.awt.Color;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;


public class Save_Score implements Serializable
{
    
    public int NEW_NUM_PLayer=0;
    public int[] New_Scor;
    public boolean NEW_LOSE= false;
    public String NEW_Name_Player[];
    public Input [] NEW_Input;
    public int NEW_Turn=0;
    public int NEW_NUM_ROWS = 10;
    public Square New_grid[][];
    public int NEW_Num_Sheild;
    public int NEW_Num_Mine;
        
    
public Save_Score(int new_num_player,int []new_score,boolean new_lose,String new_name_player[],
            Input []new_input,int new_turn,int new_NUM_ROWS,Square new_grid[][],int new_numSheild,int new_numMine)
    {
        
        New_Scor=new int[100];
        NEW_Name_Player = new String[5];
        NEW_Input = new Input[100];
        New_grid = new Square[this.NEW_NUM_ROWS][this.NEW_NUM_ROWS];
       
        
        this.NEW_NUM_PLayer=new_num_player;
        this.NEW_LOSE=new_lose;
        this.NEW_Turn = new_turn;
        this.NEW_NUM_ROWS = new_NUM_ROWS;
        this.NEW_Num_Sheild = new_numSheild;
        this.NEW_Num_Mine = new_numMine;
       
        for(int i=1;i<=this.NEW_NUM_PLayer;i++)
        {   
            this.New_Scor[i]= new_score[i];
            System.out.println("score "+i+ " "+New_Scor[i]);
        }
        
         
        for(int i=1;i<=this.NEW_NUM_PLayer;i++)
        this.NEW_Name_Player[i] = new_name_player[i];
         
        for(int i=1;i<=turn;i++)
        {
            this.NEW_Input[i] = new_input[i];
        }
        
     for(int i=0;i<this.NEW_NUM_ROWS;i++)
         for(int j=0;j<this.NEW_NUM_ROWS;j++)
         {
             this.New_grid[i][j] = new_grid[i][j];
         }
   
    }
    
     public Save_Score()
    {
        New_Scor=new int[100];
        NEW_Name_Player = new String[5];
        NEW_Input = new Input[100];
        New_grid = new Square[this.NEW_NUM_ROWS][this.NEW_NUM_ROWS];
    }
    
     
     
public static void savescore() throws IOException{
        FileInputStream fs = null;
        ObjectInputStream os = null;
     
   
  Save_Score save = new Save_Score(NUM_PLayer,Scor,ifLose,NAMEPLAYER,saveInput,turn,NUM_ROWS,grid,NUM_SFEILD,NUM_MINES);
        ArrayList<Save_Score> temp;

        try {
            fs = new FileInputStream(score_board);
            os = new ObjectInputStream(fs);

            temp = (ArrayList<Save_Score>) os.readObject();

        } catch (Exception e) {

            FileOutputStream f = new FileOutputStream(score_board);
            ObjectOutputStream o = new ObjectOutputStream(f);
            // Write objects to file
            System.out.printf("\n\nNO Array --> create Array and write in file\n\n");
            temp = new ArrayList<Save_Score>();
            o.writeObject(temp);

            o.close();
            f.close();
        }

        FileOutputStream f = null;
        ObjectOutputStream o = null;

        try {
            f = new FileOutputStream(score_board);
            o = new ObjectOutputStream(f);

            // Write objects to file
            temp.add(save);
            o.writeObject(temp);
            System.out.println("complete write");
            o.close();
            f.close();

        } catch (Exception e) {
            o.close();
            f.close();

        }
    }
    
    
    
public static void show_save_score() throws InterruptedException
         {  
            /* Input saveInput[]  = new Input[100];
             //CURRENT_PLAYER=1;
          for(int q=1;q<=99;q++)
                {
                 Input temp = new GuiInput();
                 saveInput[q]= temp;
                }*/ 
             Scor=new int[100];
             Save_Score load;
             Save_Score load_game = new Save_Score();
            ArrayList<Save_Score> temp;
            
        
            Label NamePlayerScoorLabel [] = new Label[5];
            Label PlayerScoreLabel[] = new Label[5];
            Label gameState = new Label("Game State       ");
            Label nameplayer = new Label("Name Player      ");
            Label scoor = new Label("Scoor           ");
            Label View = new Label("View");
            GridPane order = new GridPane();
            order.add(gameState,0, 0);
            order.add(nameplayer,1, 0);
            order.add(scoor,2, 0);
            order.add(View, 3,0);
            order.setStyle("-fx-padding:10;"+
                       "-fx-border-color: red;"+"-fx-font: bold 20px adobe;");
       
       vbox_scoor.getChildren().add(0,order);
       vbox_scoor.getChildren().add(1,PaneScoorBoard);
            
            try {

                FileInputStream fi = new FileInputStream(score_board);
                ObjectInputStream oi = new ObjectInputStream(fi);
                temp = (ArrayList<Save_Score>) oi.readObject();

                for (int i = 0; i < temp.size(); i++) 
                {
                   Label gameStateScoorLabel = new Label();
                   Button Show = new Button("Show");
                   NamePlayerScoorLabel[temp.get(i).NEW_NUM_PLayer] = new Label();
                   PlayerScoreLabel[temp.get(i).NEW_NUM_PLayer] = new Label();
                   
                   GridPane small= new GridPane();
                    
                 ifLose=temp.get(i).NEW_LOSE;
                
                 if(ifLose)
                 {
                   //  System.out.println("Game State : LOSE");
                     gameStateScoorLabel.setText("Lose               ");
                 }   
                 else
                 {
                    // System.out.println("Game State : WIN");
                     gameStateScoorLabel.setText("WIN               ");   
                 }
                 NUM_PLayer = temp.get(i).NEW_NUM_PLayer;
                 
                 
                 for(int k=1;k<=NUM_PLayer;k++)
                 {
                    Scor[k] = temp.get(i).New_Scor[k];
                    NAMEPLAYER[k] = temp.get(i).NEW_Name_Player[k];
                 }
                 
             
                
                   for(int k=1;k<=NUM_PLayer;k++)
                   {
                        //System.out.println("["+k+"]     :"+Scor[k]);
                        
                        NamePlayerScoorLabel[k] = new Label();
                        NamePlayerScoorLabel[k].setText(NAMEPLAYER[k]);
                        NamePlayerScoorLabel[k].setTextFill(javafx.scene.paint.Color.BLUE);
                        small.add(NamePlayerScoorLabel[k],0,k);
                        
                        PlayerScoreLabel[k] = new Label();
                        PlayerScoreLabel[k].setText("                             "+Scor[k]+"          ");
                        PlayerScoreLabel[k].setTextFill(javafx.scene.paint.Color.BLUE);
                        small.add(PlayerScoreLabel[k],0,k);
                   }
                     gameStateScoorLabel.setStyle("-fx-padding:10;"+
                       "-fx-border-color: red;"+"-fx-font: bold 20px adobe;");
                       small.setStyle("-fx-padding:10;"+
                       "-fx-border-color: red;"+"-fx-font: bold 20px adobe;");
                     Show.setStyle("-fx-padding:10;"+
                       "-fx-border-color: red;"+"-fx-font: bold 20px adobe;");
                     PaneScoorBoard.add(gameStateScoorLabel,0, i);
                     PaneScoorBoard.add(small,1,i);
                     PaneScoorBoard.add(Show,2 ,i);
                     
                     
Show.setOnAction(event->       
                {           
                  primaryStageScoorBoard.hide();
                  primaryStageGrid.show();
                  GuiOutPut gui = new GuiOutPut();
                  gui.initGUI();
                   PlayerMove move = new PlayerMove();
                  NUM_PLayer = temp.get(PaneScoorBoard.getRowIndex(Show)).NEW_NUM_PLayer;     
                  NUM_ROWS = temp.get(PaneScoorBoard.getRowIndex(Show)).NEW_NUM_ROWS; 
                  NUM_SFEILD = temp.get(PaneScoorBoard.getRowIndex(Show)).NEW_Num_Sheild;
                  NUM_MINES = temp.get(PaneScoorBoard.getRowIndex(Show)).NEW_Num_Mine;
                 for(int j=1;j<=temp.get(PaneScoorBoard.getRowIndex(Show)).NEW_Turn;j++)
                    {                    
                     saveInput[j] = temp.get(PaneScoorBoard.getRowIndex(Show)).NEW_Input[j];
                    } 
                 
                  
                  objGrid.initGrade();
                  objGrid.show();
                  for(int m=0;m<NUM_ROWS;m++)
                     for(int n=0;n<NUM_ROWS;n++)
                     {
                        grid[m][n]=temp.get(PaneScoorBoard.getRowIndex(Show)).New_grid[m][n];
                     }
                     
                 for(int m=0;m<NUM_ROWS;m++)
                   for(int n=0;n<NUM_ROWS;n++)
                     {
                        grid[m][n].setOpen(false);
                        grid[m][n].setshield(false);
                     }
                  
                 
                  final int num_turn = temp.get(PaneScoorBoard.getRowIndex(Show)).NEW_Turn;
          
    for(int h=1;h<=num_turn;h++)
      {         
                     
             turn++;
              System.out.println("input x ="+saveInput[h].x);
              System.out.println("input y ="+saveInput[h].y);
            if(!FINISISH)
             {
             TimeGame time = new TimeGame();
             Thread thread = new Thread(time);
             thread.start();
              if(CURRENT_PLAYER==NUM_PLayer)
                  CURRENT_PLAYER=0;
               if(CURRENT_PLAYER<=NUM_PLayer)
               {
            System.out.println("Turn "+turn+"  player "+CURRENT_PLAYER+":");
            
                move.move(saveInput[turn]);            
                objGrid.show();
                CURRENT_PLAYER++;
               }  
             }
                     
      }
         
      
      });
      //System.out.println("--------------------------");
         }
            }catch (FileNotFoundException e) {
                System.out.println("File not found");

            } catch (IOException e) {
                System.out.println("Error initializing stream");
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(Save_Score.class.getName()).log(Level.SEVERE, null, ex);
            } finally {

            }
         primaryStageScoorBoard.show();
         }
}
