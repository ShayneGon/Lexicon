package com.mycompany.lexicon;
import java.util.*;
public class main {
    static Scanner input = new Scanner(System.in);
    static ArrayList<Character> ogAlphabet = new ArrayList<>(Arrays.asList('A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'));
    static ArrayList<String> alphabet = new ArrayList<>(Arrays.asList("=","*","^","@","#",":",";","~","/","[","<",">","|","¬","+","!","£","%","$","&","{","}",":)","'_'","]","-"));
    public static void main(String[] args){
        boolean repeat = true;
        do{
            showAlphabet();
            System.out.println("Would you like to: Translate text[1], Add a character[2], change a character[3], remove a character[4] or exit program[0]");
            int ans = input.nextInt();
            if (ans == 1){
                translate();
            }else if (ans == 2) {
                addToLexicon();
            }else if (ans == 3) {
                removeFromLexicon();
                addToLexicon();
            }else if (ans == 4) {
                removeFromLexicon();
            }else if (ans == 0) {
                repeat = false;
            }else{
                System.out.println("Enter valid choice");
            }
        }while (repeat == true);
    }
    
    public static void translate(){
        boolean repeat = true;
        do{
            
            System.out.println("Enter what you would like to be translated");
            String bugStr = input.next();
            String str = input.nextLine();
            str = bugStr+ str;
            for (int i = 0; i < alphabet.size(); i++) {
                str = str.replace(String.valueOf(ogAlphabet.get(i)), alphabet.get(i));
            }
            System.out.println("The translated text is: ");
            System.out.println(str);
            System.out.println("Would you like to translate some other text? Enter y for yes or n for no.");
            String ans = input.nextLine();
            if (ans.equalsIgnoreCase("n")){
                repeat = false;
            }
        }while (repeat == true);
    }
    public static void showAlphabet(){
        for (int i = 0; i < alphabet.size(); i++) {
            System.out.println("The character " + ogAlphabet.get(i) + " has been replaced by " + alphabet.get(i));
        }
    }
    
    public static void addToLexicon(){
        char replacedChr;
        boolean repeat;
        String newChr;
        char c;
        char character = ' ';
        int num;
        int j = 0;
        ArrayList<Integer> nums = new ArrayList<Integer>();
        System.out.println("What is the characters as ascii value that you would like too add/replace with,"
                + " if your character is an amalgamation of multiple characters denote the new "
                + "characters ascii value with a space. Write the ascii value in denary");
        System.out.println("Enter new character");
        String bugStr = input.next();
        String str = input.nextLine();
        str = bugStr + str;
        System.out.println(str);
        do{
            System.out.println("What character does it replace, state the ascii value.");
            int integer = input.nextInt();
            repeat = false;
            replacedChr = (char) integer;
            for (int i = 0; i < alphabet.size(); i++) {
                if (replacedChr == ogAlphabet.get(i)){
                    System.out.println("The character alreagy gets replaced by our lexicon, change the"
                            + " character representing the one you want to replace from menu or "
                            + "replace different character");
                    repeat = true;
                }
            }
        }while (repeat);
        ogAlphabet.add(replacedChr);
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == ' '){
                nums.add(Integer.parseInt(str.substring(j, i-1)));
                j = i+1;
            }
        }if (j == 0){
            nums.add(Integer.parseInt(str));
        }else{
            nums.add(Integer.parseInt(str.substring(j)));
        }for (int i = 0; i < nums.size(); i++) {
            num = nums.get(i);
            c = (char) (num);
            character = (char)(character + c);
        }
        newChr = String.valueOf(character);
        alphabet.add(newChr);
    }
    
    public static void removeFromLexicon(){
        for (int i = 0; i < alphabet.size(); i++) {
            System.out.println("At position: " + (i+1) + " the character is: " + alphabet.get(i));
        }
        System.out.println("Enter the character to be removed or replaced position's in the table");
        int place = input.nextInt();
        ogAlphabet.remove(place-1);
        alphabet.remove(place-1);
    }
} 
