package com.company;
import Lab5.*;

public class Lab5 {
    //За допомогою масиву (відкрита адресація)	Квадратичне дослідження
    public static void execute()
    {
        MyHashtable<String> table = new MyHashtable<String>(10);
        table.add("One", "Один");
        table.add("enO", "Один наоборот");
        System.out.println(table.toString());
        table.add("Two", "Два");
        table.add("Tvp", "Два, и с тем же хешом");
        table.add("Ttr", "Тоже");
        table.add("Sur", "Тоже...");
        table.add("Twoo", "Дваааааа");
        table.add("Three", "Троечка");
        System.out.println(table.toString());
        System.out.println(table.get("Tvp"));
        System.out.println(table.get("Sur"));
        table.remove("Tvp");
        System.out.println(table.toString());
        System.out.println(table.get("Sur"));
    }
}
