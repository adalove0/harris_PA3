import java.security.SecureRandom;
import java.util.Scanner;

public class MultiplicationPractice {
    public static void main(String[] args) {
        SecureRandom rand = new SecureRandom();
        Scanner scnr = new Scanner(System.in);
        double average;
        int choice = 0;
        final int numQuestions = 10;
        int[][] problems = new int[2][numQuestions];
        while (choice != 2) {
            int numCorrect = 0;
            int numIncorrect = 0;
            System.out.println("Choose a type of arithmetic problem to study (1) Addition, (2) Multiplication (3) Subtraction (4) Division (5) Random Mix.");
            int arithmeticType = scnr.nextInt();
            int difficulty = difficulty(scnr);
            problems = setNumbers(rand, numQuestions, difficulty);
            for (int i = 0; i < numQuestions; i++) {
                if (askQuestions(problems, arithmeticType, i, rand, scnr)) {
                    numCorrect++;
                } else {
                    numIncorrect++;
                }
            }
            average = 100 * (double)numCorrect / numQuestions;
            System.out.println("Number Correct: " + numCorrect + ". Number Incorrect: " + numIncorrect + ".");
            if (average < 75) {
                System.out.println("You got: " + average + "%. Please ask your teacher for extra help.");
            } else {
                System.out.println("You got: " + average + "%. Congratulations, you are ready to go to the next level!");
            }
            System.out.println("Would you like to try again? (1) Yes. (2) No.");
            choice = scnr.nextInt();
            if (choice == 2) {
                System.out.println("Goodbye!");
            }
        }
    }

    public static int difficulty(Scanner scnr) {
        System.out.println("Choose your difficulty level from 1 to 4");
        return scnr.nextInt();
    }

    public static int[][] setNumbers(SecureRandom rand, int numQuestions, int difficulty) {
        int[][] newProblems = new int[2][numQuestions];
        int num1, num2;
        int bound = (int)Math.pow(10, difficulty);
        for (int i = 0; i < numQuestions; i++) {
            boolean set = false;
            while (!set) {
                num1 = rand.nextInt(bound);
                num2 = rand.nextInt(bound);
                boolean found = false;
                for (int j = 0; j <= i; j++) {
                    if (newProblems[0][j] == num1 && newProblems[1][j] == num2) {
                        found = true;
                        num1 = rand.nextInt(bound);
                        num2 = rand.nextInt(bound);
                    }
                }
                if (!found) {
                    newProblems[0][i] = num1;
                    newProblems[1][i] = num2;
                    set = true;
                }
            }
        }
        return newProblems;
    }

    public static String correctResponse(SecureRandom rand) {
        int response = rand.nextInt(4 );
        switch (response) {
            case 0:
                return "Very good!";
            case 1:
                return "Excellent!";
            case 2:
                return "Nice work!";
            case 3:
                return "Keep up the good work!";
            default:
                return "Unexpected error generating random number";
        }
    }

    public static String incorrectResponse(SecureRandom rand) {
        int response = rand.nextInt(4 );
        switch (response) {
            case 0:
                return "No. Please try again.";
            case 1:
                return "Wrong. Try once more.";
            case 2:
                return "Don't give up!";
            case 3:
                return "No. Keep trying.";
            default:
                return "Unexpected error generating random number";
        }
    }

    public static boolean askQuestions (int[][] problems, int arithmeticType, int i, SecureRandom rand, Scanner scnr) {
        if (arithmeticType == 5) {
            arithmeticType = rand.nextInt(4) + 1;
        }
        double userAnswer;
        switch (arithmeticType) {
            case 1: // addition case
                System.out.println((i + 1) + ". What is " + problems[0][i] + " plus " + problems[1][i] + "? (input your answer with 3 digits after the decimal point, like 0.000)");
                userAnswer = scnr.nextDouble();
                if ((Math.abs(userAnswer - (problems[0][i] + problems[1][i]))) <= 0.001) {
                    System.out.println(correctResponse(rand));
                    return true;
                } else {
                    System.out.println(incorrectResponse(rand));
                    return false;
                }
            case 2: // multiplication case
                System.out.println((i + 1) + ". What is " + problems[0][i] + " times " + problems[1][i] + "? (input your answer with 3 digits after the decimal point, like 0.000)");
                userAnswer = scnr.nextDouble();
                if ((Math.abs(userAnswer - (problems[0][i] * problems[1][i]))) <= 0.001) {
                    System.out.println(correctResponse(rand));
                    return true;
                } else {
                    System.out.println(incorrectResponse(rand));
                    return false;
                }
            case 3: // subtraction case
                System.out.println((i + 1) + ". What is " + problems[0][i] + " minus " + problems[1][i] + "?");
                userAnswer = scnr.nextDouble();
                if ((Math.abs(userAnswer - (problems[0][i] - problems[1][i]))) <= 0.001) {
                    System.out.println(correctResponse(rand));
                    return true;
                } else {
                    System.out.println(incorrectResponse(rand));
                    return false;
                }
            case 4: // division case, with added if statement to take care of division by 0.
                if (problems[1][i] == 0) {
                    System.out.println((i + 1) + ". What is " + problems[0][i] + " divided by 1?");
                    userAnswer = scnr.nextDouble();
                    if ((Math.abs(userAnswer - ((double)problems[0][i] / 1))) <= 0.001) {
                        System.out.println(correctResponse(rand));
                        return true;
                    } else {
                        System.out.println(incorrectResponse(rand));
                        return false;
                    }
                } else {
                    System.out.println((i + 1) + ". What is " + problems[0][i] + " divided by " + problems[1][i] + "?");
                    userAnswer = scnr.nextDouble();
                    if ((Math.abs(userAnswer - ((double)problems[0][i] / problems[1][i]))) <= 0.001) {
                        System.out.println(correctResponse(rand));
                        return true;
                    } else {
                        System.out.println(incorrectResponse(rand));
                        return false;
                    }
                }
        }
        return true;
    }
}
