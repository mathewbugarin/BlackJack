/* This program simulates a game of BlackJack. The program is 
based on a while loop and will continue to loop until user input
suggests so.*/

import java.util.Random;         //import random class for the cards
import java.util.Scanner;        //import scanner class to recieve input

public class BlackJack
{
   public static void main(String[] args)
   {
      int playAgain = 1;            //playAgain initialized at 1
      while (playAgain == 1)        //program will run as long as playAgain == 1
      {
      Scanner keyboard = new Scanner(System.in);
      int[] newCard = {2,2,2,2,3,3,3,3,4,4,4,4,5,5,5,5,6,6,6,6,7,7,7,7,8,8,8,8,9,9,9,9,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10};  //Deck of 52 Cards   
      shuffleArray(newCard);                                                           //shuffles the deck once per game

      System.out.println("***Black Jack***");
      System.out.println("*Dealer gives you two cards*");
      System.out.println("You draw a " + newCard[0] + " and a " + newCard[1] + ".");   //two cards are given to the user
      int playerTotal = newCard[0] + newCard[1];
      System.out.println("Your total score is " + playerTotal + ".");                  //total score is determined by the sum of those two cards
      System.out.println();

      if (playerTotal == 21)
      {
          System.out.println("Blackjack, you win.");                                   //user immediately wins if a black jack(21) is drawn
          System.out.println("Play again? (Enter '1' for yes, '0' for no): ");
          playAgain = keyboard.nextInt();
          if (playAgain == 1)                                                          //prompt user to play again
          {
            BlackJack.main(args);
          }
          else
          {
            System.exit(0);
          }
      }
      if (playerTotal > 21)                                                            //user immediately loses if playerTotal > 21
      {
          System.out.println("Bust, You lose.");
          System.out.println("Play again? (Enter '1' for yes, '0' for no): ");
          playAgain = keyboard.nextInt();
          if (playAgain == 1)
          {
            BlackJack.main(args);
          }
          else
          {
            System.exit(0);
          }
      }

      System.out.println("The dealer has a " + newCard[2] + " showing, and a hidden card."); //dealer draws two cards
      int dealerTotal = newCard[2] + newCard[3];                                             //one card is hidden from the user
      if (dealerTotal > 21)                                                                  //this loop checks if dealer goes over score of 21
      {                                                                                      //dealer busts if dealerTotal > 21
          System.out.println();
          System.out.println("Dealers total is " + dealerTotal + ".");
          System.out.println("Dealer is bust, you win!");
          System.out.println("Play again? (Enter '1' for yes, '0' for no): ");               //prompt user to play again
          playAgain = keyboard.nextInt();
          if (playAgain == 1)
          {
            BlackJack.main(args);
          }
          else
          {
            System.out.println("Thanks for playing!"); 
            System.exit(0);
          }
      }
      if (dealerTotal == 21)                                                                 //this loop will check if dealer draws a black jack                                                              
      {   
          System.out.println();
          System.out.println("Dealer reveals his second card: " + newCard[3] + ".");         //dealer shows hidden card
          System.out.println("Dealers total is " + dealerTotal + ".");
          System.out.println();
          System.out.println("Dealer has BlackJack, you lose.");                             //dealer may win if a blackjack is drawn
          System.out.println("Play again? (Enter '1' for yes, '0' for no): ");
          playAgain = keyboard.nextInt();
          if (playAgain == 1)
          {
            BlackJack.main(args);
          }
          else
          {
          System.out.println("Thanks for playing!");
            System.exit(0);
          }
      }
      System.out.println("His total is hidden.");
      System.out.println();

      System.out.print("Would you like to \"hit\" or \"stay\"? ");   //prompt user to draw another card or stay for the round
      String hitStay = keyboard.next();
      System.out.println();

      int cc = 4;                                                    //card count for each card
      if (hitStay.equalsIgnoreCase("hit"))
      {
         while (playerTotal < 21 && hitStay.equalsIgnoreCase("hit")) //while loop will run as long as user wants to draw another card
         {
            if (hitStay.equalsIgnoreCase("hit"))
            {
               System.out.println("You drew a " + newCard[cc] + ".");
               playerTotal = playerTotal + newCard[cc];
               System.out.println("Your total is " + playerTotal + ".");
               System.out.println();
               cc++;                                                 //cc is incremented to make sure next card is different
            }
            if (playerTotal > 21)                                    //this loop determines if user goes over the score of 21
            {                                                        //if user goes over 21, user loses the game
               System.out.println("You are bust, You lose.");
               System.out.println("Play again? (Enter '1' for yes, '0' for no): ");
               playAgain = keyboard.nextInt();
               if (playAgain == 1)                                   //prompt user to play again
               {
                  BlackJack.main(args);
               }
               else
               {
                   System.exit(0);
               } 
            }
            if (playerTotal == 21)                                   //this loop determines if user gets a blackjack
            {                                                        //user wins if a black jack is made
               System.out.println("Blackjack, you win");
               System.out.println("Play again? (Enter '1' for yes, '0' for no): ");
               playAgain = keyboard.nextInt();
               if (playAgain == 1)                                   //prompt user to play again
               {
                  BlackJack.main(args);
               }
               else
               {
                  System.exit(0);
               }
            }
            System.out.print("Would you like to \"hit\" or \"stay\"? ");
            hitStay = keyboard.next();
            System.out.println();
         }
      }        

      System.out.println("***DEALERS TURN***");
      System.out.println("Dealers hidden card was a " + newCard[3] + "."); //hidden card is revealed

      cc++;
      while (dealerTotal < 17)         //dealer will always draw a card if score is below 17
      {
         System.out.println();
         System.out.println("Dealer chooses to hit.");
         System.out.println("Dealer draws a " + newCard[cc] + ".");
         cc++;
         dealerTotal = dealerTotal + newCard[cc];
         System.out.println();
         System.out.println("Dealers total is " + dealerTotal);

         if (dealerTotal > 21)         //dealer will bust if score is over 21
         {
            System.out.println();
            System.out.println("Dealer is bust, YOU WIN!");
            System.out.println("Play again? (Enter '1' for yes, '0' for no): ");    //prompt user to play again
            playAgain = keyboard.nextInt();
            if (playAgain == 1)
            {
               BlackJack.main(args);
            }
            else
            {
               System.exit(0);
            }
         }
                                                      //this if loop will determine if dealer stays
         if (dealerTotal < 21 && dealerTotal > 16)    //Dealer will not draw cards if score is between 16 and 21
         {
            System.out.println();
            System.out.println("Dealer Stays.");
         }
      }

        System.out.println();
        System.out.println("Dealer total is " + dealerTotal);
        System.out.println("Your total is " + playerTotal);
        System.out.println();

        if (dealerTotal > playerTotal)
        {
            System.out.println("Dealer wins.");
        } 
        if (dealerTotal == playerTotal)
        
        {
            System.out.println("You both draw.");
        }
        if (dealerTotal < playerTotal)
        {
            System.out.println("You win.");
        }
        System.out.println("Play again? (Enter '1' for yes, '0' for no): ");
        playAgain = keyboard.nextInt();
      }
   }
  
   public static void shuffleArray(int[] deckCards)         //this method will shuffle the cards each time the main method is executed
   {
      Random rnd = new Random();
      for (int i = deckCards.length - 1; i > 0; i--)
      {
          int index = rnd.nextInt(i + 1);
          int a = deckCards[index];
          deckCards[index] = deckCards[i];
          deckCards[i] = a;
      }
   }
}
