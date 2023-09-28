import java.util.*;

class Main {
  public static void main(String[] args) 
  {
    Game game = new Game();
    Scanner name = new Scanner(System.in);
    String playerName = null;
    Charizard c = new Charizard();
    System.out.println("Welcome to the world of Pokemon! I am the Professor and you will be engaging in a 2v2 Pokemon Battle! \n");
    System.out.print("Now tell me your name! \n");
    playerName = name.nextLine();
    System.out.println("\nSo you're " + playerName + " welcome to the battle. \n");
    System.out.println(playerName + ", you will be using Charizard and Blastoise to go against your rival with a Lapras and Mewtwo. \n");
    System.out.println("Now Fight! \n");
    game.battle1();
  }
  
  public static int level()
  {
    System.out.println("What level would you like the Pokemon to be at (1-100)?");
    Scanner level = new Scanner(System.in);
    int lvl = level.nextInt();
    while (lvl < 1 || lvl > 100)
    {
      System.out.println("Enter a number between 1-100 for the level.");
      lvl = level.nextInt();
    }
    return lvl;
  }
}