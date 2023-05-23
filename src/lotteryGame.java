import java.util.Scanner;
import java.util.Random;

public class lotteryGame {

    public static void main(String[] args) {
        //Assign variables
        Random rand = new Random();
        int upperBound = 9;
        int lotLength = 5;
        int matching = 0;

        //Create random number array
        int[] lotArray = new int[lotLength];
        for (int i = 0; i < lotArray.length; i++) {
            lotArray[i] = rand.nextInt(upperBound);
            System.out.print(" ");
            System.out.print(lotArray[i]);
        }
        //Take numbers from user to array
        System.out.println();
        System.out.println("Enter " + lotLength + " numbers: ");

        Scanner reader = new Scanner(System.in);
        int[] userArray = new int[lotLength];
        boolean[] matchedUserElements = new boolean[lotLength]; //Track matched elements in the array
        for (int i = 0; i < userArray.length; i++) {
            while (!reader.hasNextInt()) {
                System.out.println("Invalid input. Please enter an integer: ");
                reader.next(); // Clear the invalid input
            }
        userArray[i] = reader.nextInt();
        }

        //Compare user numbers against random numbers
        for (int lotNumber : lotArray) {
            for (int i = 0; i < userArray.length; i++) {
                if (lotNumber == userArray[i] && !matchedUserElements[i]) {
                    matching++;
                    matchedUserElements[i] = true; // Mark the matched user element as already matched
                    break;
                }
            }
        }
        //Win conditions of lottery
        if(matching == lotLength){
            System.out.println("YOU WON!!!");
        }  else if (matching > 0){
            System.out.println("You had " + matching + " matching numbers");
        } else System.out.println("You did not win :(");


    }
}
