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
import java.awt.event.*;
import javax.swing.*;

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


        JFrame f=new JFrame("Vigenere Cypher 1.0");

        JTextArea area=new JTextArea("Add message to encrypt here.");
        area.setBounds(10,30, 250,250);

        JButton encryptButton=new JButton("Encrypt");
        encryptButton.setBounds(270,30,95,30);

        JButton decryptButton=new JButton("Decrypt");
        decryptButton.setBounds(270,70,95,30);

        JTextField keyfield = new JTextField("Please enter Key Here.");
        keyfield.setBounds(10,300, 200,30);



        f.setSize(400,400);
        f.add(area);
        f.add(encryptButton);
        f.add(decryptButton);
        f.add(keyfield);
        f.setLayout(null);
        f.setVisible(true);
        f.setResizable(false);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);




        // input variables to pass to the encryption method
        Message test = new Message(area.getText());
        Key keyword = new Key("Test");
        Alphabet alphabet = new Alphabet('A','Z');

        // the below is used to actually do the encryption
        //System.out.println(test.encryption(keyword,alphabet));
    }
}