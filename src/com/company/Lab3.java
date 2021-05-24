package com.company;
import java.io.*;
import java.util.Scanner;
import Lab3.*;

public class Lab3 {
    public static LoopList<String> wordList = new LoopList<>();
    public static int lineLength = 90;

    public static void readFile(String filename)
    {
        FileInputStream inputStream = null;
        try
        {
            inputStream = new FileInputStream(filename);
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
        Scanner scanner = new Scanner(inputStream);
        while(scanner.hasNextLine())
        {
            wordList.add(scanner.nextLine().split("[ ,.…\\-()\\[\\]:]+"));
            wordList.add("\n");
        }
        scanner.close();
    }

    public static void removeOrPlaceConnector(String connector)
    {
        if (wordList.removeAll(connector) != 0)
            return;
        wordList.resetCur();
        int count = wordList.size - 1;
        for (int i = 0; i < count; i++)
        {
            wordList.insert(connector);
            wordList.next();
        }
    }

    public static void print()
    {
        StringBuilder curLine = new StringBuilder();
        wordList.resetCur();
        for (int i = 0; i < wordList.size - 1; i++)
        {
            String value = wordList.next();
            if (value.equals("\n") || curLine.length() + value.length()>= lineLength)
            {
                if (value.equals("\n"))
                    value = "";

                System.out.println(" ".repeat(lineLength - curLine.length()) + curLine.toString());
                curLine = new StringBuilder();
            }
            else
            {
                curLine.append(" ");
            }
            curLine.append(value);
        }
    }
}