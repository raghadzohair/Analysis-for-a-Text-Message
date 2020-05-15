/*
 * Raghad Zohair,  ID 1705628, section number  GCR .
 * EMAIL  ryahya0010@stu.kau.edu.sa
 * Program 4: Syntactic Analysis for a Text Message  Sunday, December 10th, 2017 .
 */
package p41705628gcr;

import java.util.Scanner;

/**
 *
 * @author Raghad
 */
public class P41705628GCR {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {    
        Scanner input = new Scanner(System.in);
        while(true){
            System.out.println("|----------------------------------------------------------------|");
            System.out.println("|---------    Syntactic Analysis for a Text Message     ---------|");
            System.out.println("|----------------------------------------------------------------|");
            System.out.println(" > Enter a text message:");
            System.out.print("   ");
            String tokens = input.nextLine();
            if(tokens.equals("") || tokens.contains("        ") || tokens.contains("  ") || tokens.equals(" ")){
               continue;
            }
            while(true){                 
                int choice;
                displayMainMenu();
                choice = input.nextInt();
                if(choice > 5 || choice < 1 ){                    
                    System.out.println(">    Wrong selection. Try again.");
                    System.out.println();
                    continue;
                }
                if(choice == 1){                
                    System.out.println("The total count of tokens = "+tokensCounter(tokens)+" tokens");
                    System.out.println();
                    continue;
                }
                if(choice == 2){
                    System.out.println("  The num of words starting with a capital letter = "+startWithCapital(tokens)+" words");
                    System.out.println();
                    continue;
                }
                if(choice == 3){                   
                    while (true){                        
                        displayPrintMenu();                       
                        input.nextLine();
                        int choice2 = input.nextInt();
                        if(choice2 > 4 || choice2 < 1 ){
                            System.out.println(">    Wrong selection. Try again.");
                            System.out.println();
                            continue;
                        }                   
                        if(choice2 == 1){
                            printTokens(tokens);
                            System.out.println();
                        }
                        if(choice2 == 2 || choice2 == 3){
                            printTokens(tokens, choice2);
                            System.out.println();                       
                        }                    
                        if(choice2 == 4){
                            break;
                        }                    
                    }
                }
                if(choice == 4){
                    System.out.print("> Enter the token :");
                    input.nextLine();
                    String word = input.nextLine() ; 
                    boolean i = findToken(tokens, word);
                    if(i == true ){
                    System.out.println("> The token "+word+" exists in the message.");
                    }
                    else{
                    System.out.println("> The token "+word+" does not exist in the message.");
                    }
                    System.out.println();
                    continue;
                }
                if(choice == 5){
                    System.out.println(">     Exiting the program.....");
                    System.out.println(">     Goodbye!");
                    System.out.println();
                    System.exit(0);
                }
            }
        }        
    } 
    //method for Main Menu
    public static void displayMainMenu(){
        //print main menu
        System.out.println("|----------------------------------------------------------------|");
        System.out.println("|---------    Syntactic Analysis for a Text Message     ---------|");
        System.out.println("|----------------------------------------------------------------|");
        System.out.println("|   1. Compute tokens count (words, digits, others).             |");
        System.out.println("|   2. Compute the num of words starting with a capital letter.  |");
        System.out.println("|   3. Print the list of tokens.                                 |");
        System.out.println("|   4. Find a token in the message.                              |");
        System.out.println("|   5. Exit.                                                     |");
        System.out.println("|----------------------------------------------------------------|");
        System.out.print("> Please enter your choice: ");
    }
    //method for Print Menu
    public static void displayPrintMenu(){
        //print options menu
        System.out.println("|----------------------------------------------------------------|");
        System.out.println("|---------    Syntactic Analysis for a Text Message     ---------|");
        System.out.println("|----------------------------------------------------------------|");
        System.out.println("|                     Print Options Menu                         |");
        System.out.println("|   1. Print all the tokens.                                     |");
        System.out.println("|   2. Print the digit tokens.                                   |");
        System.out.println("|   3. Print the word tokens.                                    |");
        System.out.println("|   4. Return to the main menu.                                  |");
        System.out.println("|----------------------------------------------------------------|");  
        System.out.print("> Please enter your choice: ");
    }
    //method for Print Tokens with string
    public static void printTokens(String message){       
        while(true){
            // for calclute the message from 0 to space 
            int tab = message.indexOf(' ');
            //check if the word in the last 
            if( !message.contains(" ") ){
                System.out.print(message);
                break;
            }
            String newWord = message.substring(0, tab);
            System.out.print(newWord+" , ");
            //new text
            message = message.substring(tab + 1);
        }
    }
    //method for Print Tokens with strin, intger
    public static void printTokens(String message, int choice2){
        //to check if character letter or number
        // use bolean because enter in the loop
        boolean islastLetterOrNumber = false ;
        int countN = 0;
        int countL = 0;
        while(islastLetterOrNumber == false){
            int tab = message.indexOf(' ');
            if( tab==-1 ){
                islastLetterOrNumber = true;
            }
            String newWord;
            if(islastLetterOrNumber==true){
                newWord = message;              
            }
            else{
                newWord = message.substring(0, tab);
            }           
            if(choice2 == 2){
                boolean isNumber = true;
                int i ;
                for( i=0; i<newWord.length(); i++){
                    char check = newWord.charAt(i);
                    if(Character.isDigit(check) == false){
                        isNumber = false; 
                        break;
                    }
                }
                if(isNumber== true){                  
                    System.out.print(newWord+" , ");
                    countN++;  
                }
            }            
            else if(choice2 == 3) {
                boolean isLetter = true;
                for(int i=0; i<newWord.length(); i++){
                    char check = newWord.charAt(i);
                    if(Character.isLetter(check) == false){
                        isLetter = false;
                        break;
                    }
                }
                if(isLetter== true){
                    System.out.print(newWord+" , ");
                    countL++;
                }
            }
            if(islastLetterOrNumber != true){
            message = message.substring(tab + 1);
            }
        }
        System.out.print("\b\b");
        //check if message contains number
        if(choice2 == 2 && countN == 0){
            System.out.println("  No digit tokens in the message.");
        }
        //check if message contains word 
        if(choice2 == 3 && countL == 0){
            System.out.println("  No word tokens in the message.");
        }
        System.out.println();
    }
    //method for Tokens Counter
    public static int tokensCounter(String message){
        //put counter to count the word in text
        int count = 0;
        while(true){            
            int tab = message.indexOf(' ');
            if( !message.contains(" ") ){
                count++;
                break;
            }
            count++;
            // for count new word
            message = message.substring(tab + 1);
        }
        //return num of word
        return count;
    }
    //method for Start With Capital
    public static int startWithCapital(String message){
        //to count num of word start with capital letter
        int countUpper = 0;
        while(true){
            int tab = message.indexOf(' ');
            char upper;
            if( !message.contains(" ") ){
                upper = message.charAt(0);
                //check the word start with uppercase
                if(Character.isUpperCase(upper)== true){
                    countUpper++;
                }
                break;
            }
            String token = message.substring(0, tab); 
            upper = token.charAt(0);
            if(Character.isUpperCase(upper)== true){
               countUpper++; 
            }
            //for gnreate new word
            message = message.substring(tab + 1);           
        }
        //return num of word start with capital
        return countUpper;
    }
    //method for Find Token
    public static boolean findToken(String text, String word){
        //check if a text contains the word and conversion all to lower case for comparison
        String s1 = text.toLowerCase();
        String s2 = word.toLowerCase();
        //return true or false
        return s1.contains(s2);         
    }
}
