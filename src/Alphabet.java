/***********************************************************************************************************************
 Function name: alphabetBuilder
 Inputs: a (char), b (char)
 Returns: Alphabet (Object)
 Author: Chocciedodger25
 Created on: 24/06/24 12:01
 Last modified on: 24/06/24 12:01
 Description: This class makes an alphabet object which contains all characters within the given range of start and end
 currently for the cypher this only works with A-Z, although this can be used to form multiple alphabets, those
 alternatives ones can't be used currently as it throws the counting of the cypher off.
 **********************************************************************************************************************/


import java.util.ArrayList;

public class Alphabet
{

    ArrayList<Integer> alphabet = new ArrayList<>();

    public Alphabet (char start, char end)
    {
        // variable to hold character from given arguments
        char character;

        // to fill the alphabet
        for(character = start; character<= end; ++character)
        {

            alphabet.add((int) character);
        }

        // add alphabet to itself to accommodate for the addition
        alphabet.addAll(alphabet);
    }

    // getter for Alphabet
    public ArrayList<Integer> getAlphabet()
    {
        return alphabet;
    }

    // toString for alphabet
    @Override
    public String toString() {
        return "Alphabet = " + alphabet;
    }

    public static void main(String[] args)
    {
        Alphabet alphabet = new Alphabet('A', 'Z');
        System.out.println(alphabet);

    }
}
