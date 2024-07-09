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

    // -----------------------------------------------------------------------------------------------------------------
    public static void main(String[] args)
    {

        // input variables to pass to the encryption method
        Message test = new Message("Hello There");
        Key keyword = new Key("Test");
        Alphabet alphabet = new Alphabet('A','Z');

        System.out.println(test.encryption(keyword,alphabet));


    }
}