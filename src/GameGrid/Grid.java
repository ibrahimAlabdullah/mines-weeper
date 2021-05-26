package GameGrid;

import static Controler.Constatnts.*;
import Random.Randomizer;
import java.io.Serializable;


public class Grid implements Serializable
{    
    public static Square grid[][];
    private SquareState status;  
      
   public Grid()
    {
        grid = new Square[NUM_ROWS][NUM_ROWS];  
        
    }
 public void initGrade()
 {
    
    for(int row=0;row<NUM_ROWS;row++)
      {
         for(int col=0;col<NUM_COLS;col++)
           {
              Square temp = new Square(row,col,status.C,0,false);
              grid[row][col]=temp;
           }
      }
}
 
 public void setMine()
    {   
         Randomizer rand = new Randomizer();
         int i=NUM_MINES;
        while (i > 0)
        {    
                int row = rand.nextInt(0, NUM_ROWS-1);
                int col = rand.nextInt(0, NUM_COLS-1);
               
                while (grid[row][col].status==status.M)
                {
                    row = rand.nextInt(0, NUM_ROWS-1);
                    col = rand.nextInt(0, NUM_COLS-1);
                }
               
                grid[row][col].status=status.M;
                grid[row][col].setNumber(-1);
                i--;          
            }
        }  
 
 public void setNumber() 
    {
        
      for(int row=0;row<NUM_ROWS;row++)
        {
          for(int col=0;col<NUM_ROWS;col++)
            {               
              if(grid[row][col].status!=status.M)
                {
                   int mx = row-1;
                   int gx = row+1;
                   int my = col-1;
                   int gy = col+1;
                   
                   int numOfMines =0;
                   
                   if(mx>=0&&my>=0&&(grid[mx][my].getSatus())==status.M)
                       numOfMines++;
                   if(mx>=0&&(grid[mx][col].getSatus())==status.M)
                       numOfMines++;
                   if(mx>=0&&gy<NUM_ROWS&&(grid[mx][gy].getSatus())==status.M)
                       numOfMines++;
                   if(my>=0&&(grid[row][my].getSatus())==status.M)
                       numOfMines++;
                   if(gy<NUM_ROWS&&my>=0&&(grid[row][gy].getSatus())==status.M)
                       numOfMines++;
                   if(gx<NUM_ROWS&&my>=0&&(grid[gx][my].getSatus())==status.M)
                       numOfMines++;
                   if(gx<NUM_ROWS&&(grid[gx][col].getSatus())==status.M)
                       numOfMines++;
                   if(gx<NUM_ROWS&&gy<NUM_ROWS&&(grid[gx][gy].getSatus())==status.M)
                       numOfMines++;
                  
                   if(numOfMines>0)
                   {
                   grid[row][col].setNumber(numOfMines);
                   grid[row][col].setSatus(status.N);
                   }
                   else
                   {
                       grid[row][col].setSatus(status.E);
                   }
                }
             
            }
        }
    }
 
 public void setshield()
 {
     Randomizer rand = new Randomizer();
         int i=NUM_SFEILD;
        while (i > 0)
        {    
                int row = rand.nextInt(0, NUM_ROWS-1);
                int col = rand.nextInt(0, NUM_COLS-1);
               
                while (grid[row][col].status==status.M)
                {
                    row = rand.nextInt(0, NUM_ROWS-1);
                    col = rand.nextInt(0, NUM_COLS-1);
                }
                grid[row][col].setnshield(50);
                grid[row][col].setNumber(50);
                grid[row][col].setshield(false);
                i--;  
         }
 }
 
 public static void open(int x,int y)
 {
    
  grid[x][y].setOpen(true);
  
   if(x>=0&&x<NUM_ROWS&&y>=0&&y<NUM_ROWS)
    {
       if(grid[x][y].getSatus()!=SquareState.M&&grid[x][y].getNumber()==0)
        {
           for(int i=-1 ; i<2 ; i++)
             for(int j=-1 ; j<2 ; j++)
               if(x+i!=-1&&y+j!=-1&&y+j<NUM_ROWS&&x+i<NUM_ROWS&&grid[x+i][y+j].getSatus()!=SquareState.M
                    &&grid[x+i][y+j].canOpen())
                {
                  open(x+i,y+j);
                }
        }
    }
 }
 
 public void show()
   { 
    for(int i=0;i<NUM_COLS;i++)
        System.out.print(" "+i);
      System.out.println("");
       for(int row=0;row<NUM_ROWS;row++)
        {System.out.print(row+" ");
            for(int col=0;col<NUM_COLS;col++)
            {
                 if(FINISISH)
                 {                 
                  if(grid[row][col].isOpen())
                   {
                    if(grid[row][col].getNumber()>0)
                       System.out.print(grid[row][col].getNumber()+" ");
                    else
                       System.out.print(grid[row][col].getSatus()+" ");  
                    }
                  else if(!grid[row][col].isOpen()&&grid[row][col].getSatus()==SquareState.M)
                  {
                      System.out.print(grid[row][col].getSatus()+" "); 
                  }
                   else
                {
                    
                     if(grid[row][col].getSatus().equals(status.F))
                        System.out.print(status.F+" ");
                     else
                         System.out.print(status.C+" ");          
                }
                   //System.exit(-1);  
                 }
                            
                else
               {
                
                if(grid[row][col].isOpen())
                   {
                    if(grid[row][col].getNumber()>0)
                       System.out.print(grid[row][col].getNumber()+" ");
                    else
                       System.out.print(grid[row][col].getSatus()+" ");  
                    }
                else
                {
                  //System.out.print(grid[row][col].getNumber()+" ");
                    if(grid[row][col].getSatus().equals(status.F))
                        System.out.print(status.F+" ");
                     else
                        System.out.print(status.C+" "); 
                           
                }
               }
            }
            System.out.println();
         }  
         }
    }