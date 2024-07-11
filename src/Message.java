import java.util.ArrayList;

/***********************************************************************************************************************
 File name: Message.java
 File Type: Java Sourcecode file
 Size:
 Author: Chocciedodger25
 Created on: 24/06/24 01:42
 Last modified on: 09/07/24 13:47
 Description: This is a simple Vigenere Cypher that I have made as some practise for my portfolio and to keep me
 busy over the summer break. This is the soucecode for the Message and plaintext
 **********************************************************************************************************************/


public class Message
{
    String plainText;

    // constructor for the given plaintext
    public Message (String plainText)
    {
        this.plainText=plainText;

    }

    // getter for the message as a string
    public String getPlainText()
    {
        return plainText;
    }



/***********************************************************************************************************************
 Function name: encryption
 Inputs: keyword (key), alphabet (Alphabet)
 Returns: encryptionString (String)
 Author: Chocciedodger25
 Created on: 24/06/24 12:01
 Last modified on: 24/06/24 12:01
 Description: This encrypt the message with the given inputs from Key and Alphabet, moving away from the static
 variation of the previous version.
 **********************************************************************************************************************/
    public String encryption (Key keyword, Alphabet alphabet)
    {
        String message = getPlainText();

        StringBuilder encryptionString = new StringBuilder();

        // an array for the keyword stored as numbers which relates to the ascii table
        ArrayList<Integer> keywordList = Main.getNumbers(keyword.getKey().toUpperCase());

        // an array for the input string stored as numbers which relates to the ascii table
        ArrayList<Integer> inputlist = Main.getNumbers(message.toUpperCase());

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
            if (alphabet.getAlphabet().contains(inputlist.get(i)))
            {
                // variable to get letter from input and find in alphabet
                int letter = alphabet.getAlphabet().indexOf(inputlist.get(i));

                // variable to get letter from keyword and find in alphabet
                int letter2 = alphabet.getAlphabet().indexOf(keywordList.get(keywordTracker));

                // variable to hold ascii number of the key plus input
                int encryptedLetterNumber = alphabet.getAlphabet().get(letter + letter2);

                // converting encryptedLetterNumber back to letter
                char encryptedLetter = (char) encryptedLetterNumber;

                // appending to string builder
                encryptionString.append(encryptedLetter);

                // increasing the position on keyword
                keywordTracker++;

            }else
            {
                // appending space for special characters or numbers currently
                encryptionString.append(" ");
            }
        }

        return String.valueOf(encryptionString);
    }



/***********************************************************************************************************************
 Function name: decryption
 Inputs: encryptionText (String), keyword (key), alphabet (Alphabet)
 Returns: decryptionString (String)
 Author: Chocciedodger25
 Created on: 11/07/24 12:32
 Last modified on: 11/07/24 12:32
 Description: This is a function to reverse the encryption method, it simply moves the pointer to the second occurrence
 and then minus the letter from the key rather then adding and this results in the method of decrypting the message so
 long as the key's are the same.

 **********************************************************************************************************************/

    public String decryption (Key keyword, Alphabet alphabet)
    {

        StringBuilder decryptionString = new StringBuilder();

        // an array for the keyword stored as numbers which relates to the ascii table
        ArrayList<Integer> keywordList = Main.getNumbers(keyword.getKey().toUpperCase());

        // an array for the input string stored as numbers which relates to the ascii table
        ArrayList<Integer> inputlist = Main.getNumbers(getPlainText().toUpperCase());

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
            if (alphabet.getAlphabet().contains(inputlist.get(i)))
            {
                // variable to get letter from input and find in alphabet
                int letter = alphabet.getAlphabet().indexOf(inputlist.get(i)) + 26;

                // variable to get letter from keyword and find in alphabet
                int letter2 = alphabet.getAlphabet().indexOf(keywordList.get(keywordTracker));

                // variable to hold ascii number of the key plus input
                int decryptedLetterNumber = alphabet.getAlphabet().get((letter) - letter2);

                // converting encryptedLetterNumber back to letter
                char decryptedLetter = (char) decryptedLetterNumber;

                // appending to string builder
                decryptionString.append(decryptedLetter);

                // increasing the position on keyword
                keywordTracker++;

            }else
            {
                // appending space for special characters or numbers currently
                decryptionString.append(" ");
            }
        }

        return String.valueOf(decryptionString);
    }

    // -----------------------------------------------------------------------------------------------------------------

    public static void main(String[] args) {
        Message test = new Message("is this working");
        Key Keyword = new Key("test");
        Alphabet alphabet = new Alphabet('A','Z');

        String test1 = test.encryption(Keyword,alphabet);
        System.out.println(test1);
        System.out.println(test.decryption(Keyword,alphabet));
    }
}
