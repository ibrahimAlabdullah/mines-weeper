package Input;

import java.util.Scanner;

public class ConsolInput extends Input
{

    @Override
    public Input input()
    {
        Input in=new ConsolInput();
        
        Scanner input = new Scanner(System.in);
        System.out.println("Please Enter Row");
        in.x = input.nextInt(); 
        
        System.out.println("Please Enter Col");
        in.y = input.nextInt();
        
        System.out.println("Please Enter R to reveal or F to mark");
        in.type =input.next().charAt(0);
       return in;
            
    }
    
}
