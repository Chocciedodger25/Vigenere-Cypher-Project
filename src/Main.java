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
    public static ArrayList<Integer> alphabetBuilder(char start, char end)
    {
        // variable to hold character from given arguments
        char character;

        // array of the alphabet we will use
        ArrayList<Integer> alphabet = new ArrayList<>();

        // to fill the alphabet
        for(character = start; character<= end; ++character)
        {

            alphabet.add((int) character);
        }

        // add alphabet to itself to accommodate for the addition
        alphabet.addAll(alphabet);

        return alphabet;
    }


/***********************************************************************************************************************
 Function name: getNumbers
 Inputs: test (String)
 Returns: chars (ArrayList<Integer>)
 Author: Chocciedodger25
 Created on: 23/06/24
 Last modified on: 23/06/24 18:28
 Description: Used on the keyword from the looks of it. I can't remember what I was doing when writing this.
 **********************************************************************************************************************/
    public static ArrayList<Integer> getNumbers(String test)
    {
        ArrayList<Integer> chars = new ArrayList<>();
        for (int i = 0; i < test.length(); i++)
        {
            char test1 = test.charAt(i);
            chars.add((int) test1);
        }
        return chars;
    }


/***********************************************************************************************************************
 Function name: encrypt
 Inputs: input (String), keyword (String), alphabet (ArrayList<Integer>)
 Returns: encryptString (StringBuilder)
 Author: Chocciedodger25
 Created on: 23/06/24
 Last modified on: 23/06/24 22:24
 Description: A function to use the logic behind the vigenere cypher, taking 3 arguments input, keyword and alphabet.
 all oif these must be numbers of character contained within the alphabet for this we have stuck with the normal 65-90
 within the alphabet forming a list of ascii characters going from A-Z. Anything outside of this range is treated as a
 " ".
 Notes: need to work on rejecting inputs and keywords that are not within the alphabet as exceptions.
 **********************************************************************************************************************/
    public static StringBuilder encrypt (String input, String keyword, ArrayList<Integer> alphabet)
    {
        // is the new string that we will return
        StringBuilder encryptedString = new StringBuilder();

        // an array for the keyword stored as numbers which relates to the ascii table
        ArrayList<Integer> keywordList = getNumbers(keyword.toUpperCase());

        // an array for the input string stored as numbers which relates to the ascii table
        ArrayList<Integer> inputlist = getNumbers(input.toUpperCase());

        // variable to track ourselves through the keyword
        int keywordTracker = 0;

        // loop to run through the arraylist for the input
        for(int i = 0; i < inputlist.size(); i++)
        {
            // check to see if keyword tracker is bigger then the list if so reset
            if (keywordTracker+1 > keywordList.size())
            {
                keywordTracker = 0;
            }

            // check to see if inputlist.get(i) is within the alphabet
            if (alphabet.contains(inputlist.get(i)))
            {
                // variable to get letter from input and find in alphabet
                int letter = alphabet.indexOf(inputlist.get(i));

                // variable to get letter from keyword and find in alphabet
                int letter2 = alphabet.indexOf(keywordList.get(keywordTracker));

                // variable to hold ascii number of the key plus input
                int encryptedLetterNumber = alphabet.get(letter + letter2);

                // converting encryptedLetterNumber back to letter
                char encryptedLetter = (char) encryptedLetterNumber;

                // appending to string builder
                encryptedString.append(encryptedLetter);

                // increasing the position on keyword
                keywordTracker++;

            }else
            {
                // appending space for special characters or numbers currently
                encryptedString.append(" ");
            }
        }

        return encryptedString;
    }

    // -----------------------------------------------------------------------------------------------------------------
    public static void main(String[] args)
    {

        String test2 = "lewis beard";
        String keyword = "key";

        ArrayList<Integer> alphabet = Main.alphabetBuilder('A', 'Z');

        System.out.println(alphabet);

        StringBuilder test3 = (encrypt(test2,keyword,alphabet));
        System.out.println(test3);



    }
}