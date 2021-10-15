import java.util.Scanner;
//========================================
public class teef {
//----------------------------------------
    private static final Scanner keyboard = new Scanner(System.in);
//----------------------------------------
    public static void main(String[] args) {
        int numFam;
        int index;
        String menuResponse;
        String[] names = new String[5];
        String[] uppers = new String [10];
        String[] lowers = new String[10];

    //--- do while loop for number of family members (max of 5)
        do {
         System.out.println("Please enter number of people in the family: (max of 5)");
         numFam = keyboard.nextInt();
        }while ((numFam < 0) || (numFam > 5));

    //--- for loop to get names based on number of family members
        for (index = 0; index < numFam; index++) {
            System.out.println("Please enter the name for family member" + (index + 1));
            names[index] = keyboard.next();
    //--- getting uppers and lowers with restraints with a do while loop: max of 10, only B C M or b c m
            do {
            System.out.println("Please enter the uppers for " + names[index]);
            uppers[index] = keyboard.next();
            } while (uppers[index].length() > 10 || !(uppers[index].matches("^[BCMbcm]*")));
            do {
                System.out.println("Please enter the lowers for " + names[index]);
                lowers[index] = keyboard.next();
            } while (lowers[index].length() > 10 || !(lowers[index].matches("^[BCMbcm]*")));

        }

    do {
        System.out.println("(P)rint, (E)xtract, (R)oot, e(X)it");
        menuResponse = keyboard.next().toUpperCase();

        if (menuResponse.equals("P")) {
            System.out.println("test");
                System.out.println("test");

        } else if (menuResponse.equals("E")) {
                System.out.println("test");

        } else if (menuResponse.equals("R")) {
                System.out.println("test");
        }
    } while (!menuResponse.equals("X"));
            System.out.println("Exiting the Floridian Tooth Records :)");


        }







//--------------------------------------------------------------------------------------------------------------
}


