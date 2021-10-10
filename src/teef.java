import java.util.Scanner;
//========================================
public class teef {
//----------------------------------------
    private static final Scanner keyboard = new Scanner(System.in);
//----------------------------------------
    public static void main(String[] args) {
        int numFam;
        int index;
        String[] names = new String[5];
        String[] uppers = new String[10];
        String[] lowers = new String[10];
        String[] acceptedLetters = {"B", "C", "M", "b", "c", "m"};  // may or may not use if i can figure it out

    //--- do while loop for number of family members (max of 5)
        do {
         System.out.println("Please enter number of people in the family: (max of 5)");
         numFam = keyboard.nextInt();
        }while ((numFam < 0) || (numFam > 5));

    //--- for loop to get names based on number of family members
        for (index = 0; index < numFam; index++) {
            System.out.println("Please enter the name for family member" + (index + 1));
            names[index] = keyboard.next();
    //--- getting uppers and lowers with restraints with a do while loop: max of 10, only "B" "C" "M"
            do {
            System.out.println("Please enter the uppers for " + names[index]);
            uppers[index] = keyboard.next();
            } while (uppers[index].length() > 10 || !(uppers[index].matches("[BCMbcm]")));
            do {
                System.out.println("Please enter the lowers for " + names[index]);
                lowers[index] = keyboard.next();
            } while (lowers[index].length() > 10 || !(lowers[index].matches("[BCMbcm]")));

                    //!(lowers[index].contains(acceptedAnswers)));





        }

    }
}

