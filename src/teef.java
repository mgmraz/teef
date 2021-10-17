import java.util.Scanner;
//========================================
public class teef  {
//----------------------------------------
    private static final Scanner keyboard = new Scanner(System.in);
    private static final int MAX_FAM = 5;
    private static final int MAX_TEETH = 10;
//----------------------------------------
    public static void main(String[] args) {

//--- to deal with string length null issue in the print menu option pt 1
    String[] names = null;
    String[] uppers = null;
    String[] lowers = null;
    char tooth[][][];
    int numFam;
    int index;
    String menuResponse;

//--- welcome message
     System.out.println("Welcome to the Floridian Tooth Records");
     System.out.println("--------------------------------------");

//--- do while loop for number of family members (max of 5)
     do {
         System.out.println("Please enter number of people in the family: (max of 5)");
         numFam = keyboard.nextInt();
     }while ((numFam < 0) || (numFam > MAX_FAM));

//--- to deal with string length null issue in the print menu option pt 2, 3D array for tooth info
     names = new String[numFam];
     uppers = new String[numFam];
     lowers = new String[numFam];
     tooth = new char[numFam][2][1];

//--- for loop to get names based on number of family members
     for (index = 0; index < numFam; index++) {
         System.out.println("Please enter the name for family member " + (index + 1));
         names[index] = keyboard.next();

//--- getting uppers and lowers with restraints with a do while loop: max of 10, only B C M or b c m
         do {
             System.out.println("Please enter the uppers for " + names[index]);
             uppers[index] = keyboard.next();
         } while (uppers[index].length() > MAX_TEETH || !(uppers[index].matches("^[BCMbcm]*")));

         do {
             System.out.println("Please enter the lowers for " + names[index]);
             lowers[index] = keyboard.next();
         } while (lowers[index].length() > MAX_TEETH || !(lowers[index].matches("^[BCMbcm]*")));

        }


//--- loop for menu options
     do {
         System.out.println("\n(P)rint, (E)xtract, (R)oot, e(X)it");
         menuResponse = keyboard.next().toUpperCase();

         if (menuResponse.equals("P")) {
                Print(names, uppers, lowers, numFam);

         } else if (menuResponse.equals("E")) {
                Extract(names, uppers, lowers, numFam);
            }
         else if (menuResponse.equals("R")) {
                Root(uppers, lowers, numFam);
            }
     } while (!menuResponse.equals("X"));
        System.out.println("Exiting the Floridian Tooth Records :)");
    }

//--------------------------------------------------------------------------------------
    private static void Print(String[] names, String[] uppers, String[] lowers, int numFam) {

    int rows, columns;

    for (rows = 0; rows < numFam; rows++) { // iteration to display the names, title upper
        System.out.println("\n " + names[rows]);
        System.out.print("\t Uppers: ");
        for (columns = 0; columns < uppers[rows].length(); columns++){ // for loop to display uppers with number
            System.out.print((columns + 1) + ":" + uppers[rows].toUpperCase().charAt(columns) + " ");
            }
        System.out.print("\n\t Lowers: ");
        for (columns = 0; columns < lowers[rows].length(); columns++){ // for loop to display lowers with number
            System.out.print((columns + 1) + ":" + lowers[rows].toUpperCase().charAt(columns) + " ");
            }
    } System.out.println(); // new line before menu option reappear
    }
//---------------------------------------------------------------------------------
    private static void Extract(String[] names, String[] uppers, String[] lowers, int numFam) {

    String familyMember = "";
    char toothLayer;
    int toothNumber;

    System.out.print("Which family member ");

    while(true){ // while loop with boolean to only accept valid names
        familyMember = keyboard.next();
        boolean memFam = false;
        for (int i = 0; i < numFam; i++){
            if(familyMember.equalsIgnoreCase(names[i])){
                memFam = true;
                break;
                }
        }if (memFam){
            break;

        }else{
            System.out.print("Invalid family member, try again ");
            }
        }

    System.out.print("Which tooth layer (U)pper or (L)ower "); // loop to only accept u or l
    toothLayer = keyboard.next().charAt(0);
    toothLayer = Character.toUpperCase(toothLayer);

    while(!(toothLayer =='U' || toothLayer =='L')) {
        System.out.print("Invalid layer, try again ");
        toothLayer= keyboard.next().charAt(0);
        toothLayer = Character.toUpperCase(toothLayer);
        }

    if (toothLayer == 'U') {
        System.out.print("Which tooth number ");
        toothNumber = keyboard.nextInt();

        for (int i = 0; i < numFam; i++) { // iterating index for til numFam to get invalid tooth options, below 1 or above the number of teeth
            if (toothNumber > uppers[i].length() || toothNumber < 1){
                System.out.print("Invalid tooth number, try again ");
                toothNumber = keyboard.nextInt();
            }else{
                char missing = uppers[i].toUpperCase().charAt(toothNumber - 1); // determining if missing teeth at spot toothNumber -1 cuz spots are off
                if (missing =='M'){
                    System.out.print("Missing teeth, try again ");
                    toothNumber = keyboard.nextInt();

                }else{
                        System.out.println();
                    }

                }
            }
        }

    if (toothLayer == 'L'){ // the same as toothLayer == 'U'
        System.out.print("Which tooth number");
        toothNumber = keyboard.nextInt();
        for (int j = 0; j < numFam; j++) {
            if (toothNumber > lowers[j].length() || toothNumber < 1) {
                System.out.println("Invalid tooth number, try again ");
                toothNumber = keyboard.nextInt();
            }else{
                char missing = lowers[j].toUpperCase().charAt(toothNumber - 1);
                if (missing == 'M'){
                    System.out.print("Missing teeth, try again ");
                    toothNumber = keyboard.nextInt();
                }else{
                    System.out.println();
                    }

                }
            }
        }


    }
//-----------------------------------------------------------------------------------
    private static void Root(String[] uppers, String[] lowers, int numFam) {

    int b = 0, m = 0, c = 0;
    double root1, root2;

    for(int j = 0; j < numFam; j++){ // iterating each tooth kind for uppers
        for(int i = 0; i < uppers[j].length(); i++){
            if(uppers[j].toUpperCase().charAt(i)=='B'){b++;}
            if(uppers[j].toUpperCase().charAt(i)=='M'){m++;}
            if(uppers[j].toUpperCase().charAt(i)=='C'){c++;}
            }

    for(int i = 0; i < lowers[j].length(); i++){ // iterating each tooth kind for lowers
        if(lowers[j].toUpperCase().charAt(i)=='B'){b++;}
        if(lowers[j].toUpperCase().charAt(i)=='M'){m++;}
        if(lowers[j].toUpperCase().charAt(i)=='C'){c++;}
            }

        }
    int base = c * c + 4 * b * m; // this is the discriminant
    root1 = (c + Math.sqrt(base)) / (double)(2 * b);
    root2 = (-c + Math.sqrt(base)) / (double)(2 * b);

    System.out.printf("One root canal at %.2f%n",root1);
    System.out.printf("Another root canal at %.2f%n",root2);

    }
//-------------------------------------------------------------------------------------
}