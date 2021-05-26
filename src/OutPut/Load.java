package OutPut;

import static Controler.Constatnts.*;
import static Controler.Constatnts.ComputerTurn;
import static Controler.Constatnts.FINISISH;
import static Controler.Constatnts.LOSE;
import static Controler.Constatnts.NUM_COLS;
import static Controler.Constatnts.NUM_MINES;
import static Controler.Constatnts.NUM_PLayer;
import static Controler.Constatnts.NUM_ROWS;
import static Controler.Constatnts.NUM_SFEILD;
import static Controler.Constatnts.Quick;
import static Controler.Constatnts.SECOND;
import static Controler.Constatnts.TYPE_COMPUTER;
import static Controler.Constatnts.Winn;
import static Controler.Constatnts.choice;
import static Controler.Constatnts.choiceComputer;
import static Controler.Constatnts.ifLose;
import static Controler.Constatnts.objGrid;
import static Controler.Constatnts.turn;
import static GameGrid.Grid.grid;
import Input.GuiInput;
import Input.Input;
import static OutPut.GuiOutPut.num;
import static OutPut.GuiOutPut.number;
import static OutPut.GuiOutPut.open;
import static OutPut.GuiOutPut.primaryStageGrid;
import static OutPut.GuiOutPut.primaryStageLoad;
import static Player.Player.players;
import static Player.Player.saveInput;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;


public class Load 
{
    
    public void Action_Quick_Load()
    {
       
           objGrid.initGrade();
           GuiOutPut gui = new GuiOutPut();
           Quick = true;
           try
           {
           Save load = Save.quick_load();
           NUM_ROWS = load.NEW_NUM_ROWS;
           NUM_COLS = load.NEW_NUM_COLS;
           NUM_MINES = load.NEW_NUM_MINES;
           choice = load.NEW_choice;
           choiceComputer =load.NEW_choiceComputer;
           NUM_PLayer = load.NEW_NUM_PLayer;
           CURRENT_PLAYER = load.NEW_CURRENT_PLAYER;
           TYPE_COMPUTER = load.NEW_TYPE_COMPUTER;
           NUM_SFEILD = load.NEW_NUM_SFEILD;
           turn = load.NEW_turn;
           SECOND = load.NEW_SECOND;
           FINISISH = load.NEW_FINISISH;
           LOSE = load.NEW_LOSE;
           Winn = load.NEW_Winn;
           ifLose = load.NEW_ifLose;
           ComputerTurn = load.NEW_ComputerTurn;
           
           for(int i=0;i<NUM_ROWS;i++)
               for(int j=0;j<NUM_COLS;j++)
                   grid[i][j] = load.New_grid[i][j];
           }
           catch(Exception e){}
          gui.initGUI();
       for (int i=0;i<NUM_ROWS;i++)
        {
            for(int j=0;j<NUM_COLS;j++)
            {
             if(grid[i][j].isOpen())
             {
                 number = grid[i][j].getNumber();
                 num = Integer.toString(number);                    
                 open(i,j,num);
             }
            }
        }
        
    }
    
    
    public void Action_Load()
    {
        
              
                   
                  
         GridPane gridLoad = new GridPane();  
         try
         {
         Save load = new Save();
         ArrayList<Save> temp ;
        
         try
         {  
         FileInputStream f = new FileInputStream(SAVE);
         ObjectInputStream o = new ObjectInputStream(f);
         temp = (ArrayList<Save>)o.readObject();
         
         for(int i=0;i<temp.size();i++)
         {
         Label nameGameLabel = new Label(temp.get(i).NEW_NAME_GAME);
         
         nameGameLabel.setStyle("-fx-padding : 30 150 20 20; -fx-font-size:15;");
         Button play = new Button("Play");
         play.setStyle("-fx-border-color : rgb(255,255,255);"
                         + "-fx-padding : 10 20 5 20;"
                         + "-fx-background-color : #ff9d9d;");
         play.setOnAction(event->
         { 
           Quick = true; 
           NUM_ROWS = temp.get(gridLoad.getRowIndex(play)).NEW_NUM_ROWS;
           NUM_COLS = temp.get(gridLoad.getRowIndex(play)).NEW_NUM_COLS;
           objGrid.initGrade();
           NUM_MINES = temp.get(gridLoad.getRowIndex(play)).NEW_NUM_MINES;
           choice = temp.get(gridLoad.getRowIndex(play)).NEW_choice;
           choiceComputer =temp.get(gridLoad.getRowIndex(play)).NEW_choiceComputer;
           NUM_PLayer = temp.get(gridLoad.getRowIndex(play)).NEW_NUM_PLayer;
           CURRENT_PLAYER = temp.get(gridLoad.getRowIndex(play)).NEW_CURRENT_PLAYER;
           TYPE_COMPUTER = temp.get(gridLoad.getRowIndex(play)).NEW_TYPE_COMPUTER;
           NUM_SFEILD = temp.get(gridLoad.getRowIndex(play)).NEW_NUM_SFEILD;
           turn = temp.get(gridLoad.getRowIndex(play)).NEW_turn;
           SECOND = temp.get(gridLoad.getRowIndex(play)).NEW_SECOND;
           FINISISH = temp.get(gridLoad.getRowIndex(play)).NEW_FINISISH;
           LOSE = temp.get(gridLoad.getRowIndex(play)).NEW_LOSE;
           Winn = temp.get(gridLoad.getRowIndex(play)).NEW_Winn;
           ifLose = temp.get(gridLoad.getRowIndex(play)).NEW_ifLose;
           ComputerTurn = temp.get(gridLoad.getRowIndex(play)).NEW_ComputerTurn;
           
             System.out.println("INDEX = "+ gridLoad.getRowIndex(play));
           for(int k=0;k<NUM_ROWS;k++)
               for(int j=0;j<NUM_COLS;j++)
                   grid[k][j] = temp.get(gridLoad.getRowIndex(play)).New_grid[k][j];    
          
           GuiOutPut gui = new GuiOutPut();
            gui.initGUI();
           Input in = new GuiInput();
           in.input();
           
         for (int h=0;h<NUM_ROWS;h++)
          {
            for(int j=0;j<NUM_COLS;j++)
            {
             if(grid[h][j].isOpen())
             {
                 number = grid[h][j].getNumber();
                 num = Integer.toString(number); 
                 open(h,j,num);
             }
            }
          } 
         
         primaryStageLoad.hide();
         primaryStageGrid.show();
          
         });
          
         gridLoad.add(nameGameLabel, 0, i);
         gridLoad.add(play,1, i);
         }
         f.close();
         o.close();
         }
         catch (FileNotFoundException e) {
                System.out.println("File not found");

            } catch (IOException e) {
                System.out.println("Error initializing stream");
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(GuiOutPut.class.getName()).log(Level.SEVERE, null, ex);
            } finally {

            }
        
          Scene scene1 = new Scene(gridLoad, 400, 400);
          primaryStageLoad.setScene(scene1);
          primaryStageLoad.show();
         }
         catch(Exception e){}
                 
    }
}
