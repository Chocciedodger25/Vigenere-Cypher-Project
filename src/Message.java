/***********************************************************************************************************************
 File name: Message.java
 File Type: Java Sourcecode file
 Size:
 Author: Chocciedodger25
 Created on: 24/06/24 01:42
 Last modified on: 24/06/24 01:42
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
}
