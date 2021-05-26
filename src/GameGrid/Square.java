package GameGrid;

import java.io.Serializable;

public class Square implements Serializable
{
    private int x;
    private int y;
    private int number;
    private boolean open;     
    public SquareState status;
    private int nshield;
    private boolean shield;
  

    public Square(int x, int y,SquareState satuts,int number,boolean open) 
    {
        this.x = x;
        this.y = y;
        this.status= satuts;
        this.number= number;
        this.open= open;
        this.shield=shield;
        this.nshield=nshield;
    }
  
  public boolean canOpen()
  {
      return !isOpen()&&number >=0 ;
  }
    
    public void setSatus(SquareState satuts) {
        this.status = satuts;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public boolean isOpen() {
        return open;
    }

    public void setOpen(boolean open) {
        this.open = open;
    }
   
      public void setnshield(int nshield) {
        this.nshield= nshield;
    }
     
     public int getnshield()
     {
         return nshield;
     }
     public void setshield(boolean shield) {
        this.shield= shield;
    }
     
     public boolean getshield()
     {
         return shield;
     }
     
    public SquareState getSatus() {
        return status;
    }
    
    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }
    
    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
