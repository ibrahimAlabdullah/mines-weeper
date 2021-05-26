package OutPut;

import static Controler.Constatnts.*;
import static GameGrid.Grid.grid;
import static Score.Save_Score.savescore;
import GameGrid.SquareState;
import Input.GuiInput;
import Input.Input;
import static Player.Player.players;
import static Player.Player.saveInput;
import Score.Save_Score;
import static Score.Save_Score.show_save_score;
import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleGroup;
import javafx.scene.effect.Light.Point;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;



public class GuiOutPut  extends Application implements Serializable
{
public static Point point=new Point();
public static Point point1=new Point();
public static GridPane pane=new GridPane();
public static GridPane pane1 =new GridPane();
public static GridPane pane2 =new GridPane();
public static GridPane pane3 =new GridPane();
public static ToggleGroup toggle = new ToggleGroup();
public static ToggleGroup toggle1 = new ToggleGroup();
public static ToggleGroup toggle2 = new ToggleGroup();
public static ToggleGroup toggle3 = new ToggleGroup();
public static ToggleGroup toggle4 = new ToggleGroup();
public static Label label = new Label(); 
public static Label gridSize = new Label("Size Grid : ");
public static Label numMines = new Label("Number Mine : ");

public static Label numPlayer = new Label("Number Players : ");
public static Label numShield = new Label("Number Shields : ");
public static Label computerPlayer = new Label("ComputerPlayer : ");
public static Label time = new Label();
public static Label turnLabel = new Label();
public static Label gameStateLabel = new Label();
public static Integer number;
public static String num;
public static Stage primaryStageGrid= new Stage();
public static Stage primaryStageScoor= new Stage();
public static Stage primaryStageNameGame= new Stage();
public static Stage primaryStageLoad = new Stage();

public static Label scoreLabel[]= new Label[5];
public static Label namePlayer = new Label(); 
public static Button QuickLoad = new Button("QuickLoad");
public static Button Save = new Button("Save");
public static Button QuickSave = new Button("QuickSave");
public static Button OK = new Button("OK");
public static TextField TEXT = new TextField();
public static Button Load = new Button("Load");
public static Stage primaryStageNamePlayer = new Stage();
public static GridPane PaneNamePlayer = new GridPane();
public static TextField NAMEPLAYERTEXT[] = new TextField[5];
public static Label NAMEPLAYERLABEL[] = new Label[5];
public static Button Start = new Button("Start");
public static VBox vbox = new VBox();
public static Stage primaryStageScoorBoard = new Stage();
public static GridPane PaneScoorBoard = new GridPane();
public static Button ScoorButton = new Button("Scoor Board");
public static VBox vbox_scoor = new VBox();


        @Override
 public void start(Stage primaryStageOption)
{
       setupOption();
       
       pane.setPadding(new Insets(100,100,100,100));
       HBox hbox = new HBox(pane,turnLabel,time,QuickSave,Save);        
       Scene scene = new Scene(hbox,800,600);
       
       ImageView image = new ImageView(new Image("next.png"));
       image.setFitHeight(100);
       image.setFitWidth(100);    
       Button b = new Button();
       b.setTranslateX(200);
       b.setTranslateY(150);

       label.setStyle("-fx-font: bold 40px adobe");
       b.setStyle("-fx-padding : 0;"+"-fx-pref-width :100px;"+"-fx-pref-height:100px;"+"-fx-border-Background:blue");
       b.setGraphic(image);
    
       QuickLoad.setOnAction(event->
       {
           Load load = new Load();
           load.Action_Quick_Load();
           Input in = new GuiInput();
           in.input();
           primaryStageOption.hide();
         for(int k=1;k<=NUM_PLayer;k++)
           players[k]=1;
         primaryStageGrid.setScene(scene);
         primaryStageGrid.setTitle("MinesWepper Game!");       
         primaryStageGrid.show();
       });
       
       
       
        Load.setOnAction(event->
        {
           primaryStageOption.hide();
           Load load = new Load();
           load.Action_Load();
          
           for(int k=1;k<=NUM_PLayer;k++)
           players[k]=1;
           primaryStageGrid.setScene(scene);
           primaryStageGrid.setTitle("MinesWepper Game!");
        });
       
       b.setOnAction(event->
          {
         primaryStageOption.hide();
         primaryStageNamePlayer.show();
         
          for(int i=1;i<=NUM_PLayer;i++)
          {
              NAMEPLAYERLABEL[i] = new Label("Name Player "+i);
              PaneNamePlayer.add(NAMEPLAYERLABEL[i],0, i);
              NAMEPLAYERLABEL[i].setTextFill(Color.RED);
              NAMEPLAYERLABEL[i].setStyle("-fx-font: bold 25px adobe;"+"-fx-padding : 0;"+"-fx-pref-width :200px;"+"-fx-pref-height:50px;");
          }
        
           for(int i=1;i<=NUM_PLayer;i++)
          {
              NAMEPLAYERTEXT[i] = new TextField();
              PaneNamePlayer.add(NAMEPLAYERTEXT[i],1, i);
              NAMEPLAYERTEXT[i].setStyle("-fx-font: bold 20px adobe");
          }
           
            PaneNamePlayer.add(Start,1, 6);
          }
        );
       
       Start.setOnAction(event->
       {
          primaryStageNamePlayer.hide();
       for(int k=1;k<=NUM_PLayer;k++)
         {
          
           NAMEPLAYER[NUM_PLayer] = new String();  
           NAMEPLAYER[k]= NAMEPLAYERTEXT[k].getText();
             System.out.println("name "+NAMEPLAYER[k]);
         }
       
         Input in = new GuiInput();
         in.input();

         for(int k=1;k<=NUM_PLayer;k++)
         {
           players[k]=1;
         }
         primaryStageGrid.setScene(scene);
         primaryStageGrid.setTitle("MinesWepper Game!");       
         primaryStageGrid.show();  
       });
  
       
  ScoorButton.setOnAction(event->
       {
          SCOOREBOARD = true;
          for(int i=1;i<=NUM_PLayer;i++)
          {
              NAMEPLAYERLABEL[i] = new Label("Name Player "+i);
              PaneNamePlayer.add(NAMEPLAYERLABEL[i],0, i);
              NAMEPLAYERLABEL[i].setTextFill(Color.RED);
              NAMEPLAYERLABEL[i].setStyle("-fx-font: bold 25px adobe;"+"-fx-padding : 0;"+"-fx-pref-width :200px;"+"-fx-pref-height:50px;");
          }
         primaryStageOption.hide();
        
           try {
               show_save_score();
           } catch (InterruptedException ex) {
               Logger.getLogger(GuiOutPut.class.getName()).log(Level.SEVERE, null, ex);
           }
         
         primaryStageGrid.setScene(scene);
         primaryStageGrid.setTitle("MinesWepper Game!");       
       });
       
        setUP();
      
        pane1.add(gridSize,4, 4);
        pane1.add(numMines,4,5);
        pane1.add(numPlayer,4,6);
        pane1.add(numShield,4,7);
        pane1.add(computerPlayer,4,8);
        pane1.add(b,4, 9);
        pane1.add(QuickLoad,4,10);
        pane1.add(Load,4,11);
        pane1.add(ScoorButton,4,12);
        
        pane2.add(gameStateLabel, 0, 0);
 
        Scene starter=new Scene(pane1,700,600);
        primaryStageOption.setScene(starter);
        primaryStageOption.setTitle("Option");
        primaryStageOption.show();
        
        Scene score=new Scene(pane2,700,600);
        primaryStageScoor.setScene(score);
        primaryStageScoor.setTitle("Score");
        
        
        HBox hbox_name = new HBox(TEXT,OK);
        Scene name_game = new Scene(hbox_name,300,50);
        primaryStageNameGame.setScene(name_game);
        primaryStageNameGame.setTitle("Name Game");
        primaryStageNameGame.hide();
        
   
       Scene SceneNamePlayer = new Scene(PaneNamePlayer,500,400);
       primaryStageNamePlayer.setScene(SceneNamePlayer);
       
          
       Scene SceneScoorBoard = new Scene(vbox_scoor,700,600);
       primaryStageScoorBoard.setScene(SceneScoorBoard);
    
    
    }
 
 
 
 public void setUP()
 {       
          time.setMinWidth(150);
          time.setMinHeight(50);
          time.setTranslateX(-600);
          time.setTranslateY(50);
          time.setStyle("-fx-font: bold 30px adobe");
       
          turnLabel.setMinWidth(400);
          turnLabel.setMinHeight(75);
          turnLabel.setTranslateX(-600);
          turnLabel.setTranslateY(0);
          turnLabel.setStyle("-fx-font: bold 30px adobe");
          
          QuickSave.setMinWidth(150);
          QuickSave.setMinHeight(50);
          QuickSave.setTranslateX(-600);
          QuickSave.setTranslateY(150);
          QuickSave.setStyle("-fx-font: bold 20px adobe");
          
          Start.setMinWidth(150);
          Start.setMinHeight(50);
          Start.setTranslateY(150);
          Start.setStyle("-fx-font: bold 20px adobe;"+"-fx-color:blue;");
          
          Save.setMinWidth(150);
          Save.setMinHeight(50);
          Save.setTranslateX(-750);
          Save.setTranslateY(225);
          Save.setStyle("-fx-font: bold 20px adobe");
          
          OK.setMinWidth(75);
          OK.setMinHeight(25);
          OK.setStyle("-fx-font: bold 20px adobe");
          
          TEXT.setStyle("-fx-font: bold 20px adobe");
          
          QuickLoad.setTranslateX(500);
          QuickLoad.setTranslateY(100);
          QuickLoad.setStyle("-fx-font: bold 20px adobe");
          
          
          Load.setTranslateX(500);
          Load.setTranslateY(110);
          Load.setStyle("-fx-font: bold 20px adobe;"+"-fx-pref-width :130px");
          
          gameStateLabel.setStyle("-fx-font: bold 30px adobe");
          
          
          gridSize.setStyle("-fx-font: bold 35px adobe");
          numMines.setStyle("-fx-font: bold 35px adobe");
          numPlayer.setStyle("-fx-font: bold 30px adobe");
          numShield.setStyle("-fx-font: bold 30px adobe");
          computerPlayer.setStyle("-fx-font: bold 30px adobe");
          
          ScoorButton.setTranslateX(500);
          ScoorButton.setTranslateY(120);
          ScoorButton.setStyle("-fx-font: bold 18px adobe;"+"-fx-pref-width :130px");
          
 }
  
 public static void open(int x,int y,String num)
 {
        
         number = grid[x][y].getNumber();
         num = Integer.toString(number);
          grid[x][y].setOpen(true);
         
           ImageView image = new ImageView(new Image(num+".png"));
           image.setFitHeight(40);
           image.setFitWidth(40);
         
           button[y][x].setGraphic(image);
           if(CURRENT_PLAYER==1)
               button[y][x].setStyle("-fx-padding : 0;"+"-fx-pref-width :200px;"
                       +"-fx-pref-height:100px;"+"-fx-border-color: red");
           else if(CURRENT_PLAYER==2)
               button[y][x].setStyle("-fx-padding : 0;"+"-fx-pref-width :200px;"
                       +"-fx-pref-height:100px;"+"-fx-border-color: orange");
           else if(CURRENT_PLAYER==3)
               button[y][x].setStyle("-fx-padding : 0;"+"-fx-pref-width :200px;"
                       +"-fx-pref-height:100px;"+"-fx-border-color: purple");
           else if(CURRENT_PLAYER==4)
               button[y][x].setStyle("-fx-padding : 0;"+"-fx-pref-width :200px;"
                       +"-fx-pref-height:100px;"+"-fx-border-color: violet");
           else
               button[y][x].setStyle("-fx-padding : 0;"+"-fx-pref-width :200px;"
                       +"-fx-pref-height:100px;"+"-fx-border-color: green");
       
        
   if(x>=0&&x<grid.length&&y>=0&&y<grid.length)
    {
       if(grid[x][y].getSatus()!=SquareState.M&&grid[x][y].getNumber()==0)
        {
           for(int i=-1 ; i<2 ; i++)
             for(int j=-1 ; j<2 ; j++)
               if(x+i!=-1&&y+j!=-1&&y+j<grid.length&&x+i<grid.length&&
                       grid[x+i][y+j].getSatus()!=SquareState.M 
                       &&grid[x+i][y+j].getSatus()!=SquareState.F&&grid[x+i][y+j].canOpen())       
                   open(x+i,y+j,num);
        }
    }  
 }

 public static void setupOption()
 {
   
   RadioButton r6 = new RadioButton("6");
   RadioButton r7 = new RadioButton("7");
   RadioButton r8 = new RadioButton("8");
   RadioButton r9 = new RadioButton("9");
   RadioButton r10 = new RadioButton("10");
   r6.setStyle("-fx-font: bold 30px adobe;");
   r7.setStyle("-fx-font: bold 30px adobe");
   r8.setStyle("-fx-font: bold 30px adobe");
   r9.setStyle("-fx-font: bold 30px adobe");
   r10.setStyle("-fx-font: bold 30px adobe");
   r6.setToggleGroup(toggle);
   r7.setToggleGroup(toggle);
   r8.setToggleGroup(toggle);
   r9.setToggleGroup(toggle);
   r10.setToggleGroup(toggle);
   HBox h =new HBox(r6,r7,r8,r9,r10);
   pane1.add(h,5 , 4);
     
   
   RadioButton r11 = new RadioButton("10");
   RadioButton r15 = new RadioButton("15");
   RadioButton r20= new RadioButton("20");
   RadioButton r25 = new RadioButton("25");
   RadioButton r30 = new RadioButton("30");
   r11.setStyle("-fx-font: bold 30px adobe");
   r15.setStyle("-fx-font: bold 30px adobe");
   r20.setStyle("-fx-font: bold 30px adobe");
   r25.setStyle("-fx-font: bold 30px adobe");
   r30.setStyle("-fx-font: bold 30px adobe");
   r11.setToggleGroup(toggle1);
   r15.setToggleGroup(toggle1);
   r20.setToggleGroup(toggle1);
   r25.setToggleGroup(toggle1);
   r30.setToggleGroup(toggle1);
   HBox h1 =new HBox(r11,r15,r20,r25,r30);
   pane1.add(h1,5 , 5);
   
   RadioButton r1 = new RadioButton("1");
   RadioButton r2 = new RadioButton("2");
   RadioButton r3= new RadioButton("3");
   RadioButton r4 = new RadioButton("4");
   RadioButton r5 = new RadioButton("5");
   r1.setStyle("-fx-font: bold 30px adobe");
   r2.setStyle("-fx-font: bold 30px adobe");
   r3.setStyle("-fx-font: bold 30px adobe");
   r4.setStyle("-fx-font: bold 30px adobe");
   r5.setStyle("-fx-font: bold 30px adobe");
   r1.setToggleGroup(toggle2);
   r2.setToggleGroup(toggle2);
   r3.setToggleGroup(toggle2);
   r4.setToggleGroup(toggle2);
   r5.setToggleGroup(toggle2);
   HBox h2 =new HBox(r1,r2,r3,r4,r5);
   pane1.add(h2,5,6);
   
   RadioButton rr1 = new RadioButton("3");
   RadioButton rr2 = new RadioButton("4");
   RadioButton rr3= new RadioButton("5");
   RadioButton rr4 = new RadioButton("6");
   RadioButton rr5 = new RadioButton("7");
   rr1.setStyle("-fx-font: bold 30px adobe");
   rr2.setStyle("-fx-font: bold 30px adobe");
   rr3.setStyle("-fx-font: bold 30px adobe");
   rr4.setStyle("-fx-font: bold 30px adobe");
   rr5.setStyle("-fx-font: bold 30px adobe");
   rr1.setToggleGroup(toggle3);
   rr2.setToggleGroup(toggle3);
   rr3.setToggleGroup(toggle3);
   rr4.setToggleGroup(toggle3);
   rr5.setToggleGroup(toggle3);
   HBox h3 =new HBox(rr1,rr2,rr3,rr4,rr5);
   pane1.add(h3,5,7);
   
   
   RadioButton rrr1 = new RadioButton("YES");
   RadioButton rrr2 = new RadioButton("NO");
   rrr1.setStyle("-fx-font: bold 30px adobe");
   rrr2.setStyle("-fx-font: bold 30px adobe");
   rrr1.setToggleGroup(toggle4);
   rrr2.setToggleGroup(toggle4);
   HBox h4 =new HBox(rrr1,rrr2);
   pane1.add(h4,5,8);
   
   toggle.selectedToggleProperty().addListener(new ChangeListener<Toggle>()
   {
       @Override
       public void changed(ObservableValue<? extends Toggle> ov, Toggle old, Toggle neww)
       {
           if(toggle.getSelectedToggle()!=null)
           {
            RadioButton selecte =(RadioButton)toggle.getSelectedToggle();
            String tt = selecte.getText();
            System.out.println(tt);  
            NUM_ROWS=Integer.parseInt(tt);
            NUM_COLS=Integer.parseInt(tt);
           }
       }     
   });
  
    toggle1.selectedToggleProperty().addListener(new ChangeListener<Toggle>()
   {
       @Override
       public void changed(ObservableValue<? extends Toggle> ov, Toggle old, Toggle neww)
       {
           if(toggle1.getSelectedToggle()!=null)
           {
            RadioButton selecte =(RadioButton)toggle1.getSelectedToggle();
            String tt = selecte.getText();
            NUM_MINES= Integer.parseInt(tt);
            System.out.println(tt);  
           }
       }     
   });
    
   toggle2.selectedToggleProperty().addListener(new ChangeListener<Toggle>()
   {
       @Override
       public void changed(ObservableValue<? extends Toggle> ov, Toggle old, Toggle neww)
       {
           if(toggle2.getSelectedToggle()!=null)
           {
            RadioButton selecte =(RadioButton)toggle2.getSelectedToggle();
            String tt = selecte.getText();
            NUM_PLayer= Integer.parseInt(tt);
            System.out.println(tt);  
           }
       }     
   });
    
   toggle3.selectedToggleProperty().addListener(new ChangeListener<Toggle>()
   {
       @Override
       public void changed(ObservableValue<? extends Toggle> ov, Toggle old, Toggle neww)
       {
           if(toggle3.getSelectedToggle()!=null)
           {
            RadioButton selecte =(RadioButton)toggle3.getSelectedToggle();
            String tt = selecte.getText();
            System.out.println(tt);  
            NUM_SFEILD=Integer.parseInt(tt); 
           }
       }     
   });
   
  toggle4.selectedToggleProperty().addListener(new ChangeListener<Toggle>()
   {
       @Override
       public void changed(ObservableValue<? extends Toggle> ov, Toggle old, Toggle neww)
       {
           if(toggle4.getSelectedToggle()!=null)
           {
            RadioButton selecte =(RadioButton)toggle4.getSelectedToggle();
            String tt = selecte.getText();
            System.out.println(tt);
            if(tt.equals("YES"))
            {
                NUM_PLayer++;
                choiceComputer=1;
            }
           }
       }     
   });
  
    }
 
 public void initGUI()
 {
     for (int i=0;i<NUM_ROWS;i++)
        {
            for(int j=0;j<NUM_COLS;j++)
            {   
                button[i][j]=new Button("");
                ImageView closed = new ImageView(new Image("10.png"));
                closed.setFitHeight(40);
                closed.setFitWidth(40);
                button[i][j].setGraphic(closed);
                button[i][j].setStyle("-fx-padding : 0;"+"-fx-pref-width :200px;"+"-fx-pref-height:100px;"+"-fx-border-color: black");
                pane.add(button[i][j],i,j);
            }
        }
 }

}   
 

