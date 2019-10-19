import java.util.Scanner;
import java.util.Random;
import java.security.SecureRandom;

// Change continue statement in generate question so its in a do while loop that says while result == x+y;




    public class Frucht_PA3_p1 {
        private static double SecureRandom(double difficulty){
            SecureRandom rand = new SecureRandom();
            double numDigits = Math.pow(10,difficulty);
            byte[] bytes = new byte[20];
            rand.nextBytes(bytes);
            return Math.abs(rand.nextInt()%numDigits);

        }
        private static void GenerateSuccess(Random rand){
            int x = rand.nextInt(4);
            switch (x){
                case 0:
                    System.out.println("Very good!");
                    break;
                case 1:
                    System.out.println("Excellent!");
                    break;
                case 2:
                    System.out.println("Nice work!");
                    break;
                case 3:
                    System.out.println("Keep up the good work!");
                    break;
            }
        }

        private static void GenerateFail(Random rand){
            int x = rand.nextInt(4);
            switch (x){
                case 0:
                    System.out.println("No. Please try again.");
                    break;
                case 1:
                    System.out.println("Wrong. Try once more.");
                    break;
                case 2:
                    System.out.println("Don't give up!");
                    break;
                case 3:
                    System.out.println("No. Keep trying.");
                    break;
            }
        }

        private static void GenerateQuestion(Random rand, Scanner sc, int difficulty, int type) {
            double x,y,result,resultCmp;
            double correctPercentage,correct=0,total=0;
            int i,typeFlag = type;
            for (i = 0; i < 10; ++i) {
                if (type == 5)
                    typeFlag = typeFlag%4 + 1;

                x = SecureRandom(difficulty);
                y = SecureRandom(difficulty);

                switch (typeFlag) {
                    case 1:
                        System.out.println("How much is " + x + " plus " + y + "?");
                        result = sc.nextDouble();
                        resultCmp = (x + y);
                        if (Math.abs(result - resultCmp) > 0.0001) {
                           GenerateFail(rand);
                           ++total;
                           break;
                        }
                        GenerateSuccess(rand);
                        ++correct;
                        ++total;
                        break;
                    case 2:
                        System.out.println("How much is " + x + " times " + y + "?");
                        result = sc.nextDouble();
                        resultCmp = (x * y);
                        if (Math.abs(result - resultCmp) > 0.0001) {
                           GenerateFail(rand);
                           ++total;
                           break;
                        }
                        GenerateSuccess(rand);
                        ++correct;
                        ++total;
                        break;
                    case 3:
                        System.out.println("How much is " + x + " minus " + y + "?");
                        result = sc.nextDouble();
                        resultCmp = (x - y);
                        if (Math.abs(result - resultCmp) > 0.0001) {
                           GenerateFail(rand);
                           ++total;
                           break;
                        }
                        GenerateSuccess(rand);
                        ++correct;
                        ++total;
                        break;
                    case 4:
                        System.out.println("How much is " + x + " divided " + y + "?");
                        result = sc.nextDouble();
                        resultCmp = (x / y);
                        if (Math.abs(result - resultCmp) > 0.0001) {
                           GenerateFail(rand);
                           ++total;
                           break;
                        }
                        GenerateSuccess(rand);
                        ++correct;
                        ++total;
                        break;

                }
            }
            correctPercentage = correct/total;
            if (correctPercentage < .75)
                System.out.println("Please ask your teacher for extra help.");
            else
                System.out.println("Congratulations, you are ready to go to the next level!");


        }

        public static void main(String[] args){
            Scanner sc = new Scanner(System.in);
            int difficulty,type,cont;
            Random rand = new Random(4);

            while(true){
                do {
                    System.out.println("What difficulty would you like to practice with?\n1) 1-Digit\n2) 2-Digit\n3) 3-digit\n4) 4-digits");
                    difficulty = sc.nextInt();
                } while (difficulty < 0 || difficulty > 5);
                do {
                    System.out.println("What type of problem would you like to practice?\n1) Addition\n2) Multiplication\n3) Subtraction\n4) Division\n5) Random mix ");
                    type = sc.nextInt();
                } while (type < 0 || type > 5);


                GenerateQuestion(rand,sc,difficulty,type);

                System.out.println("Would you like to start a new session?\n1) Yes\n2) No");
                cont = sc.nextInt();
                if (cont == 2)
                    break;
            }
        }

    }

