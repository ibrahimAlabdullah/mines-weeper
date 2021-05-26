package Input;

import static Controler.Constatnts.*;
import static GameGrid.Grid.grid;
import Random.*;
import java.awt.AWTException;
import java.awt.Robot;
import java.util.logging.Level;
import java.util.logging.Logger;

public  class ComputerInput extends Input
{
    
  @Override
    public Input input()
    {
        
      try {
          Robot  r = new Robot();
         r.delay(1000);
      } catch (AWTException ex) {
          Logger.getLogger(ComputerInput.class.getName()).log(Level.SEVERE, null, ex);
      }
        
        if(TYPE_COMPUTER==1)
        {
            
        String type = "RF";
        Randomizer rand = new Randomizer();
        Input in=new ComputerInput();
        int size = type.length();
        
         in.x = rand.nextInt(0,NUM_ROWS-1);
         System.out.println("Enter Row : "+in.x);
        
        
         in.y = rand.nextInt(0,NUM_COLS-1);
         System.out.println("Enter Col : "+in.y);
        
         in.type = type.charAt(rand.nextInt(size));
         System.out.println("Please Enter R to reveal or F to mark : "+in.type);
        
       return in;
        }
        else
        {
        String type = "RF";
        Randomizer rand = new Randomizer();
        Input in=new ComputerInput();
        int size = type.length();
        
         in.x = rand.nextInt(0,NUM_ROWS-1);
         in.y = rand.nextInt(0,NUM_COLS-1);
         while(grid[in.x][in.y].getNumber()==-1)
         {
             in.x = rand.nextInt(0,NUM_ROWS-1);
             in.y = rand.nextInt(0,NUM_COLS-1);
         }
         System.out.println("Enter Row : "+in.x);
         System.out.println("Enter Col : "+in.y);
         
         in.type = type.charAt(rand.nextInt(size));
         System.out.println("Please Enter R to reveal or F to mark : "+in.type);
        
       return in;
        }
    }
    
}
