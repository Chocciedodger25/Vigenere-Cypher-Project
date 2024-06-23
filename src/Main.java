/***********************************************************************************************************************
 File name: Main.java
 File Type: Java Sourcecode file
 Size: 2KB
 Author: Chocciedodger25
 Created on: 19/06/24 20:58
 Last modified on: 23/06/24 02:17
 Description: This is a simple Vigenere Cypher that I have made as some practise for my portfolio and to keep me
 busy over the summer break. I am aware that there will be pieces of code that will be inefficient but this is what
 I came up with, any feedback is greatly appreciated.
 **********************************************************************************************************************/

import java.util.ArrayList;

public class Main
{
/***********************************************************************************************************************
 Function name: alphabetBuilder
 Inputs: a (char), b (char)
 Returns: alphabet (ArrayList<Character>)
 Author: Chocciedodger25
 Created on: 19/06/24 20:58
 Last modified on: 23/06/24 02:17
 Description: method to build an alphabet of any size using the ascii table which will then return as an arraylist.
 This method is not the most optimal way to do this with the alphabet, we could use some maths which I am working
 on to solve what happens when the alphabet goes out of range when adding the key letter to it.
 Currently, it works by doubling itself, so it can't go out of range.
***********************************************************************************************************************/
    public static ArrayList<Character> alphabetBuilder(char start, char end)
    {
        // variable to hold character from given arguments
        char character;

        // array of the alphabet we will use
        ArrayList<Character> alphabet = new ArrayList<>();

        // to fill the alphabet
        for(character = start; character<= end; ++character)
        {
            alphabet.add(character);
        }

        // add alphabet to itself to accommodate for the addition
        alphabet.addAll(alphabet);

        return alphabet;
    }

/***********************************************************************************************************************
 Function name: letterCheck
 Inputs: text (String), alphabet (ArrayList<Character>)
 Returns: checker (boolean)
 Author: Chocciedodger25
 Created on: 22/06/24
 Last modified on: 22/06/24 22:23
 Description: A function to check to see if the provided string contains any characters that are not within the given
 alphabet. It takes two arguments text (string) and alphabet (ArrayList<Character>). Text being the string you want to
 check and alphabet being the alphabet you want to check with.
 **********************************************************************************************************************/

    public static boolean letterCheck (String text,ArrayList<Character> alphabet )
    {
        // set checker to true to assume it is all contained
        boolean checker = true;

        // breaking text into an array
        char[] words = text.toCharArray();

        // check each element in words if contained within alphabet
        for (int i = 0; i < words.length; i++)
        {
            // if not contained change status of checker
            if (!alphabet.contains(words[i]))
            {
                checker = false;
                break;
            }
        }

        return checker;
    }

    // -----------------------------------------------------------------------------------------------------------------
    public static void main(String[] args)
    {
        // test string
        String test = "why does my mum keep bothering me";

        ArrayList<Character> alphabet = Main.alphabetBuilder(' ', '~');
        ArrayList<Character> alphabet2 = Main.alphabetBuilder('0', '0');
        System.out.println(alphabet);

        System.out.println(Main.letterCheck(test, alphabet));
        System.out.println(Main.letterCheck(test, alphabet2));


    }
}