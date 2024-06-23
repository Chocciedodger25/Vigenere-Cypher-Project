import java.util.ArrayList;
import java.util.Arrays;

public class Binary
{

    public static void main(String[] args)
    {
        int binary = 10000000;

        int decimal = 0;

        int position = 0;

        while (binary>0)
        {
            int check = binary % 10;

            if (check == 1 )
            {
                decimal = (int) Math.pow(2,position) + decimal;
                System.out.println(decimal);
            }

            binary = binary / 10;
            ++ position;
        }
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

        // starting string
        String sentence = "it was a lovely day but because of the heat it was to much and I hid in the shade";

        // split every word by space and add to array
        String[] words = sentence.split(" ");

        // convert to arraylist
        ArrayList<String> word = new ArrayList<>(Arrays.asList(words));

        // word count
        int wordCount = 0;

        // position tracker to come back to
        int positionTracker = 0;

        // letter count of word at positionTracker
        int letterCount = word.get(positionTracker).length();

        // loop through all words in the array
        for (int i = 0; i < word.size(); i++)
        {
            // word length at position i
            int wordLength = word.get(i).length();

            // check to replace with bigger letter count if word is longer
            if (wordLength>wordCount)
            {
                // replace wordCount with bigger word count
                wordCount = wordLength;

                // increase to match position outside
                positionTracker = i;
            }
        }

        // print the longest word with letter count
        System.out.println(word.get(positionTracker) + " " + letterCount);
    }
}
