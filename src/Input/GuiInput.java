package Input;

import static Controler.Constatnts.*;
import static GameGrid.Grid.grid;
import MovePlayer.PlayerMove;
import OutPut.GuiOutPut;
import static OutPut.GuiOutPut.*;
import OutPut.Save;
import OutPut.TimeGame;
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
import javafx.event.EventHandler;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;


public class GuiInput extends Input implements Serializable 
{     

  
    
    public Input in;
    
    GuiOutPut gui = new GuiOutPut();
    public static Save quicksave;
    @Override
    public Input input()
    { 
       PlayerMove move = new PlayerMove();
       in =new GuiInput();
      
        //CURRENT_PLAYER=1;
         
         TimeGame time = new TimeGame();
         Thread thread = new Thread(time); 
         thread.start();
         
   
       QuickSave.setOnAction(event->
       {
           try
           {    
           FileOutputStream f = new FileOutputStream(quick_save);
           ObjectOutputStream o = new ObjectOutputStream(f);
           Save quickSave = new Save(null,0,NUM_ROWS,NUM_COLS,NUM_MINES,choice,choiceComputer,NUM_PLayer,CURRENT_PLAYER,
           TYPE_COMPUTER,NUM_SFEILD,turn,SECOND,FINISISH,LOSE,Winn,ifLose,ComputerTurn,grid);
        
            o.writeObject(quickSave); 
            System.out.println("Done Quick Save");
            o.close();
            f.close();
           }
              catch(IOException e)
              {
                  e.printStackTrace();
              }
       });
         
         
         
         
      Save.setOnAction(event->
         {
           primaryStageNameGame.show();       
         });
         
      OK.setOnAction(event->
        {     
        FileInputStream fs = null;
        ObjectInputStream os = null;
       Save save = new Save(TEXT.getText(),0,NUM_ROWS,NUM_COLS,NUM_MINES,choice,choiceComputer,NUM_PLayer,CURRENT_PLAYER,
           TYPE_COMPUTER,NUM_SFEILD,turn,SECOND,FINISISH,LOSE,Winn,ifLose,ComputerTurn,grid);
          
        ArrayList<Save> temp = new ArrayList<Save>();

        try {
            fs = new FileInputStream(SAVE);
            os = new ObjectInputStream(fs);

            temp = (ArrayList<Save>) os.readObject();

        }
        catch (Exception e)
        {
            
            FileOutputStream f;
            ObjectOutputStream o ;
            try {
                f = new FileOutputStream(SAVE);
                o = new ObjectOutputStream(f);
                
                 // Write objects to file
            System.out.printf("\n\nNO Array --> create Array and write in file\n\n");
            
            o.writeObject(temp);

            o.close();
            f.close();
            } catch (FileNotFoundException ex) {
                Logger.getLogger(GuiInput.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(GuiInput.class.getName()).log(Level.SEVERE, null, ex);
            }
          
        }

        FileOutputStream f = null;
        ObjectOutputStream o = null;

     try 
        {
            f = new FileOutputStream(SAVE);
            o = new ObjectOutputStream(f);

            // Write objects to file
            temp.add(save);
            o.writeObject(temp);
            System.out.printf("complete write");
            o.close();
            f.close();

        } 
     catch (Exception e) 
     {
            //o.close();
            //f.close();
     }
         primaryStageNameGame.close(); 
        });
          
          
          
          
         if(!Quick)
        {   
         objGrid.initGrade();
         objGrid.setMine();
         objGrid.setNumber();
         objGrid.setshield();
         gui.initGUI();
        }
      objGrid.show();
       
      for (int i=0;i<NUM_ROWS;i++)
        {
            for(int j=0;j<NUM_COLS;j++)
            { 
                final int indexi=i;
                final int indexj=j;
          button[i][j].setOnMouseClicked(new EventHandler<MouseEvent>()
{   
    @Override
 public void handle(MouseEvent event) 
 {
 MouseButton btn = event.getButton();
  if(btn==MouseButton.PRIMARY)
  {
    
    point.setX(indexj);
    point.setY(indexi); 
    
    in.x=(int)point.getX();
    in.y=(int)point.getY();
    in.type='r';
    
   
    System.out.println(in.x+","+in.y);
    
           if(!FINISISH)
             {          
               turn++;
              if(CURRENT_PLAYER==NUM_PLayer)
                  CURRENT_PLAYER=0;
               if(CURRENT_PLAYER<=NUM_PLayer)
               {
                System.out.println("Turn "+turn+"  player "+CURRENT_PLAYER+":");
                move.move(in);
                objGrid.show();
                CURRENT_PLAYER++;   
                }
              }
           }
  else if(btn == MouseButton.SECONDARY)
  {
    point.setX(indexj);
    point.setY(indexi); 
    in.x=(int)point.getX();
    in.y=(int)point.getY();
    in.type='f';
     System.out.println(in.x+","+in.y);
      if(!FINISISH)
             {   
               turn++; 
              if(CURRENT_PLAYER>NUM_PLayer)
                  CURRENT_PLAYER=1;
               if(CURRENT_PLAYER<=NUM_PLayer)
               {
                System.out.println("Turn "+turn+"  player "+CURRENT_PLAYER+":");
                move.move(in);
               objGrid.show();
                CURRENT_PLAYER++;
                }
              }      
  }                              
                    }
              });
            }
        }
          return in;  
    }

    

 
}
  
