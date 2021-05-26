package Player;

import Input.Input;

public abstract class Player {
   private String name;
   private int  currentScore;
   public static int [] players;
   public static Input saveInput[];
   
   public abstract Input GetPlayerMove();
}
