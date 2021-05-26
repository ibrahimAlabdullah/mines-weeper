package Controler;

import GameGrid.Grid;
import Input.Input;
import java.io.File;
import java.io.Serializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;

public class Constatnts implements Serializable
{
    public static int NUM_ROWS = 10;
    public static int NUM_COLS = 10;
    public static  int NUM_MINES = 3;
    public static boolean FINISISH = false; 
    public static boolean LOSE= false;
    public static boolean Winn= false;
    public static boolean ifLose = false;
    public static int choice;
    public static int choiceComputer=0;
    public static boolean ComputerTurn=false;
    public static int NUM_PLayer=0;
    public static int CURRENT_PLAYER=0;
    public static  int TYPE_COMPUTER= 0;
    public static  int NUM_SFEILD=0;
    public static  int turn=0;
    public static int SECOND=10;
    public static Button[][] button = new Button[NUM_ROWS][NUM_ROWS];
    public static File quick_save = new File("quick_save.txt");
    public static File SAVE = new File("save.txt");
     public static File score_board = new File("score_board.txt");
    public static boolean Quick = false;
    public static Grid objGrid = new Grid();
    public static String NAMEPLAYER[] = new String[5];
    public static boolean SCOOREBOARD = false;
    public static int SLEEP = 0;
   
    
    
}
