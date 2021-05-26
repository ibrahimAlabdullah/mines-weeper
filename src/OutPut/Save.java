package OutPut;

import static Controler.Constatnts.*;
import GameGrid.Square;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import javafx.scene.control.Button;



public class Save implements Serializable
{

    public int NEW_NUM_ROWS = 10;
    public int NEW_NUM_COLS = 10;
    public int NEW_NUM_MINES = 3;
    public int NEW_choice;
    public int NEW_choiceComputer=0;
    public int NEW_NUM_PLayer=0;
    public int NEW_CURRENT_PLAYER=0;
    public int NEW_TYPE_COMPUTER= 0;
    public int NEW_NUM_SFEILD=0;
    public int NEW_turn=0;
    public int NEW_SECOND=10;
    
    public boolean NEW_FINISISH = false; 
    public boolean NEW_LOSE= false;
    public boolean NEW_Winn= false;
    public boolean NEW_ifLose = false;
    public boolean NEW_ComputerTurn=false;
   
    public Square New_grid[][];
    
    public String NEW_NAME_GAME;
    public int NEW_INDEX_ARRAY;
      
  public Save() 
    {
        New_grid = new Square[this.NEW_NUM_ROWS][this.NEW_NUM_ROWS];
        //System.out.println("Done");       
    }

        
public Save(String new_NAME_GAME,int new_index_array,int new_NUM_ROWS,int new_NUM_COL,int new_NUM_MINES,int new_choice,int new_choiceComputer,int new_NUM_PLAYER,
          int new_CURRENT_PLAYER,int new_TYPE_COMPUTER,int new_NUM_SFEILD,int new_turn,int new_SECOND,     
          boolean new_FINISISH,boolean new_LOSE,boolean new_Winn,boolean new_ifLose,boolean new_ComputerTurn,
          Square new_grid[][]
          )
    {
     this.NEW_NAME_GAME = new_NAME_GAME;
     
     this.NEW_NUM_ROWS = new_NUM_ROWS;
     this.NEW_NUM_COLS = new_NUM_COL;
     this.NEW_NUM_MINES = new_NUM_MINES;
     this.NEW_choice = new_choice;
     this.NEW_choiceComputer = new_choiceComputer;
     this.NEW_NUM_PLayer = new_NUM_PLAYER;
     this.NEW_CURRENT_PLAYER = new_CURRENT_PLAYER;
     this.NEW_TYPE_COMPUTER = new_TYPE_COMPUTER;
     this.NEW_NUM_SFEILD = new_NUM_SFEILD;
     this.NEW_turn = new_turn;
     this.NEW_SECOND = new_SECOND;
     
     this.NEW_FINISISH = new_FINISISH;
     this.NEW_LOSE = new_LOSE;
     this.NEW_Winn = new_Winn;
     this.NEW_ifLose = new_ifLose;
     this.NEW_ComputerTurn = new_ComputerTurn;
     
      New_grid = new Square[this.NEW_NUM_ROWS][this.NEW_NUM_COLS];
    
     for(int i=0;i<this.NEW_NUM_ROWS;i++)
         for(int j=0;j<this.NEW_NUM_COLS;j++)
         {
             this.New_grid[i][j] = new_grid[i][j];
         }   
    }

 public static Save quick_load()
    {
        System.out.println("quick load");
        try
        {
            System.out.println("yes");
            FileInputStream fi = new FileInputStream(quick_save);
            ObjectInputStream oi = new ObjectInputStream(fi);

            Save temp = new Save();
            temp = (Save) oi.readObject();
            
            oi.close();
            fi.close();
            return temp;

        }
        catch (FileNotFoundException e){System.out.println("File not found");} 
        catch (IOException e) {e.printStackTrace();} 
        catch (ClassNotFoundException e){e.printStackTrace();}
        return null;
    }
}
