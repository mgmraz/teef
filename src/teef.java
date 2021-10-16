import java.util.Scanner;
//========================================
public class teef {
//----------------------------------------
    private static final Scanner keyboard = new Scanner(System.in);
//----------------------------------------
    public static void main(String[] args) {
        int numFam;
        int index;
        int rows, columns;
        String menuResponse;
        String familyMember = "";
        char toothLayer;
        int toothNumber;
        //--- to deal with string length null issue in the print menu option pt 1
        String[] names = null;
        String[] uppers = null;
        String[] lowers = null;
        char teeth[][][];

    //--- do while loop for number of family members (max of 5)
        do {
         System.out.println("Please enter number of people in the family: (max of 5)");
         numFam = keyboard.nextInt();
        }while ((numFam < 0) || (numFam > 5));

    //--- to deal with string length null issue in the print menu option pt 2
        names = new String[numFam];
        uppers = new String[numFam];
        lowers = new String[numFam];
        teeth = new char[numFam][2][];

    //--- for loop to get names based on number of family members
        for (index = 0; index < numFam; index++) {
            System.out.println("Please enter the name for family member " + (index + 1));
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
        System.out.println("\n(P)rint, (E)xtract, (R)oot, e(X)it");
        menuResponse = keyboard.next().toUpperCase();

        if (menuResponse.equals("P")) {
            for (rows = 0; rows < numFam; rows++) {
                System.out.println("\n " + names[rows]);
                System.out.print("\t Uppers: ");

                for(columns = 0; columns < uppers[rows].length(); columns++){
                    System.out.print((columns + 1) + ":" + uppers[rows].toUpperCase().charAt(columns) + " ");
                }
                System.out.print("\n\t Lowers: ");
                for(columns = 0; columns < lowers[rows].length(); columns++){
                    System.out.print((columns + 1) + ":" + lowers[rows].toUpperCase().charAt(columns) + " ");
            }
            } System.out.println();


//-----------------------------------------------------------------------------------
        } else if (menuResponse.equals("E")) {
            System.out.println("Which family member ");

            while(true){
                familyMember = keyboard.next();
                boolean b = false;
                for(int i = 0; i < numFam; i++){
                    if(familyMember.equalsIgnoreCase(names[i])){
                        b = true;
                        break;
                    }
                }if(b == true){
                    break;

                } else{
                    System.out.print("Invalid family member, try again ");
                }

            }System.out.print("Which tooth layer (U)pper or (L)ower ");
                toothLayer = keyboard.next().charAt(0);
                toothLayer = Character.toUpperCase(toothLayer);
                while(!(toothLayer =='U' || toothLayer =='L'))
            {
                System.out.print("Invalid layer, try again ");
                toothLayer= keyboard.next().charAt(0);
                toothLayer = Character.toUpperCase(toothLayer);
            }

            if (toothLayer == 'U') {
                System.out.println("Which tooth number ");
                toothNumber = keyboard.nextInt();
                for (int i = 0; i < numFam; i++) {
                if(toothNumber > uppers[i].length() || toothNumber < 1){
                    System.out.print("Invalid tooth number, try again : ");
                    toothNumber = keyboard.nextInt();
                } else{
                    char missing = uppers[i].toUpperCase().charAt(toothNumber - 1);
                    if (missing =='M'){
                        System.out.print("Missing teeth, try again ");
                        toothNumber = keyboard.nextInt();
                    } else{
                        System.out.println();
                    }
                }
                }
            }
            if (toothLayer == 'L'){
                System.out.println("Which tooth number");
                toothNumber = keyboard.nextInt();
                for (int j = 0; j < numFam; j++) {
                    if (toothNumber > lowers[j].length() || toothNumber < 1) {
                        System.out.println("Invalid tooth number, try again ");
                        toothNumber = keyboard.nextInt();
                    } else{
                        char missing = lowers[j].toUpperCase().charAt(toothNumber - 1);
                        if (missing == 'M'){
                            System.out.print("Missing teeth, try again ");
                            toothNumber = keyboard.nextInt();
                        } else{
                            System.out.println();
                        }
                    }
                }
            }
//----------------------------------------------------------------------------------------------------------------------
        } else if (menuResponse.equals("R")) {
            int B=0, M=0, C=0;

            for(int j = 0; j < numFam; j++){
                for(int i = 0; i < uppers[j].length(); i++){
                    if(uppers[j].toUpperCase().charAt(i)=='B'){B++;}
                    if(uppers[j].toUpperCase().charAt(i)=='M'){M++;}
                    if(uppers[j].toUpperCase().charAt(i)=='C'){C++;}
                }

                for(int i = 0; i < lowers[j].length(); i++){
                    if(lowers[j].toUpperCase().charAt(i)=='B'){B++;}
                    if(lowers[j].toUpperCase().charAt(i)=='M'){M++;}
                    if(lowers[j].toUpperCase().charAt(i)=='C'){C++;}
                }
            }

            double base = C * C - 4 * B * (-M);
            double root1, root2;
            if(base > 0) {
                root1 = (-C + Math.sqrt(base)) / (2 * B);
                root2 = (-C - Math.sqrt(base)) / (2 * B);
                System.out.printf("One root canal at %.2f%n",root1);
                System.out.printf("Another root canal at %.2f%n",root2);
            }
        }
    } while (!menuResponse.equals("X"));
            System.out.println("Exiting the Floridian Tooth Records :)");


        }







//--------------------------------------------------------------------------------------------------------------
}


