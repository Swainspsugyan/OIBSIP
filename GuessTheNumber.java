import java.util.Scanner;
import java.util.Random;

class FirstGame {
    int counter = 0;
    int myNum;
    int compNum;

    public FirstGame() {
        compNum = (int) (Math.random() * 100);

    }

    public void setNumber(int n) {
        myNum = n;
    }

    public int isCorrect() {
        if (myNum == compNum) {
            return 0;
        } else if (myNum > compNum) {
            return -1;
        } else {
            return 1;
        }
    }

    public void setCounter() {
        counter++;

    }

    public void getCounter() {

        System.out.println("The number of guesses were " + counter);
    }

}

public class GuessTheNumber {

    public static void main(String[] args) {

        FirstGame obj = new FirstGame();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("Enter a number between 1 to 100 : ");
            int n = sc.nextInt();
            obj.setNumber(n);

            if (obj.isCorrect() == 0) {
                obj.setCounter();
                System.out.println("Congratulations !! You have guessed the correct number ");
                obj.getCounter();
                break;
            } else if (obj.isCorrect() == -1) {
                obj.setCounter();
                System.out.println("Enter the smaller number");
            } else if (obj.isCorrect() == 1) {
                obj.setCounter();
                System.out.println("Enter the larger number ");
            }
        }

    }

}
