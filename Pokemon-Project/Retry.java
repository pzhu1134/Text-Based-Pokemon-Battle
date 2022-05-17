import java.util.*;
public class Retry
{
   public static void Retry()
  {
    Game game = new Game();
    Scanner tryAgain = new Scanner(System.in);
    System.out.println("You lost the battle. \n \nWould you like to try again? (y/n)"); 
    String again = tryAgain.nextLine();

    if(again.equalsIgnoreCase("y"))
    {
      game.battle1();
    }
    else 
    {
       System.out.println("You officially lose! \nTHE END!");
       System.exit(1);
    }   
  }
}