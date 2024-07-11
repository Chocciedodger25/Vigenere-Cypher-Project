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


        Alphabet alphabet = new Alphabet('A','Z');

        JFrame f=new JFrame("Vigenere Cypher 1.0");

        // text to explain what the program is
        JLabel intro = new JLabel();
        intro.setText("<html>This is the first version of my Vigenere Cypher. it is a simple program<br> used to " +
                "encrypt a string and then return the encrypted text, while also being able to decrypt the text.</html>");
        intro.setBounds(10,0, 400,50);

        // text area to enter the message the user wants to encrypt
        JTextArea area=new JTextArea("Add message to encrypt here.");
        area.setBounds(10,60, 250,250);
        area.setLineWrap(true);
        area.setWrapStyleWord(true);

        // text field to enter the key to encrypt the message
        JTextField keyfield = new JTextField("Please enter Key Here.");
        keyfield.setBounds(10,330, 250,30);

        // button to then encrypt the message
        JButton encryptButton=new JButton("Encrypt");
        encryptButton.setBounds(270,60,95,30);

        // button to then decrypt the message
        JButton decryptButton=new JButton("Decrypt");
        decryptButton.setBounds(270,100,95,30);
        decryptButton.setEnabled(false);

        // button to then compare the messages
        JButton compareButton=new JButton("Compare");
        compareButton.setBounds(270,140,95,30);
        compareButton.setEnabled(false);

        JButton resetButton = new JButton("Reset");
        resetButton.setBounds(270,240,95,30);

        JButton helpButton = new JButton("Help");
        helpButton.setBounds(270,280,95,30);




        // actions -----------------------------------------------------------------------------------------------------

        // encryption button action ------------------------------------------------------------------------------------
        encryptButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String plainText = area.getText();
                Message message = new Message(plainText);

                String key = keyfield.getText();
                Key keyword = new Key(key);

                plainText = message.encryption(keyword,alphabet);

                area.setText(plainText);

                encryptButton.setEnabled(false);

                decryptButton.setEnabled(true);
            }
        });

        // decryption button action ------------------------------------------------------------------------------------
        decryptButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String plaintext = area.getText();
                Message message = new Message(plaintext);

                String key = keyfield.getText();
                Key keyword = new Key(key);

                area.setText(message.decryption(keyword,alphabet));

                encryptButton.setEnabled(true);

                decryptButton.setEnabled(false);
            }
        });

        // reset button action -----------------------------------------------------------------------------------------
        resetButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                area.setText("Add message to encrypt here.");
                keyfield.setText("Please enter Key Here.");

                encryptButton.setEnabled(true);

                decryptButton.setEnabled(false);

            }
        });

        // help button action ------------------------------------------------------------------------------------------
        helpButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                JFrame fHelp=new JFrame("Vigenere Cypher 1.0 Help.");

                // text to explain what the program is
                JLabel help = new JLabel();
                help.setText("<html>Step one: locate the message text field and add your message <br><br>" +
                        "NOTE: this may not contain special characters or numbers! <br><br>" +
                        "Step two: Add a key to the key field.<br><br> " +
                        "NOTE: this may not contain special characters or numbers!<br><br> " +
                        "NOTE: The key MUST be a single word!<br><br> " +
                        "Step three: Once both fields have been entered press the encrypt button. <br><br>" +
                        "Step four: to decrypt the text, press the decrypt button.<br><br>" +
                        "NOTE: This will convert all lower case to upper case.</html>");

                help.setBounds(10,30, 400,250);
                fHelp.setSize(400,400);
                help.setVisible(true);
                fHelp.add(help);
                fHelp.setLayout(null);
                fHelp.setVisible(true);
                fHelp.setResizable(false);
            }
        });

        // removing text from textfield when clicked -------------------------------------------------------------------
        area.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                area.setText(null);
            }
        });

        // removing text from keyfield when clicked --------------------------------------------------------------------
        keyfield.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                keyfield.setText(null);
            }
        });

        // adding the components to the frame --------------------------------------------------------------------------
        f.setSize(450,450);
        f.add(intro);
        f.add(area);
        f.add(encryptButton);
        f.add(decryptButton);
        //f.add(compareButton);
        f.add(resetButton);
        f.add(helpButton);
        f.add(keyfield);
        f.setLayout(null);
        f.setVisible(true);
        f.setResizable(false);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }
}