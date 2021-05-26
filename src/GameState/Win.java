package GameState;
import static Controler.Constatnts.*;
import static GameGrid.Grid.grid;
import GameGrid.SquareState;
import OutPut.TimeGame;
import static java.lang.System.exit;


public class Win 
 {
   public static boolean win() 
 {
     int counter=0;
     for(int i=0;i<NUM_ROWS;i++)
         for(int j=0;j<NUM_COLS;j++)
         {
            if(!grid[i][j].isOpen())
                counter++;          
         }
     if(counter==NUM_MINES)
     { 
         
         return true;
     }
     else
         return false;
    
 }
   
}
