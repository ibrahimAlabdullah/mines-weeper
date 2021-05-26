
package GameRules;

import MovePlayer.PlayerMove;
import Player.*;
import java.util.List;


public abstract class GameRules {
    public abstract int GetScoreChange(List<PlayerMove> moves);
    public abstract Player DecideNextPlayer(List<PlayerMove> moves);  
}
