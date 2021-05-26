package Input;

import java.io.Serializable;

public abstract class Input implements Serializable
{
   public int x,y;
   public char type;
   
   public abstract Input input();
   
}
