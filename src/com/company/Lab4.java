package com.company;
import Lab4.*;

public class Lab4 {
    //вставка 48, 52, 15, 54, 79, 56, 46, 73, 65, 94, 9, 85, 7, 33, 8
    //поиск 73, 85, 8 ,max
    //удаление	48,79, 15
    public static void execute() {
        BinaryTree<String> tree = new BinaryTree<>();
        tree.add(48, "FortyEight");
        tree.add(52, "FiftyTwo");
        tree.add(15, "Fifteen");
        tree.add(54, "FiftyFour");
        tree.add(79, "SeventyNine");
        tree.add(56, "FiftySix");
        tree.add(46, "FortySix");
        tree.add(73, "SeventyThree");
        tree.add(65, "SixtyFive");
        tree.add(94, "NinetyFour");
        tree.add(9, "Nine");
        tree.add(85, "EightyFive");
        tree.add(7, "Seven");
        tree.add(33, "ThirtyThree");
        tree.add(8, "Eight");
        tree.printOrdered();
        System.out.println("15 = " + tree.get(15));
        System.out.println("85 = " + tree.get(85));
        System.out.println("73 = " + tree.get(73));
        System.out.println("Highest = " + tree.getHighest());
        tree.remove(79);
        tree.printOrdered();
        tree.remove(48);
        tree.printOrdered();
        tree.remove(15);
        tree.printOrdered();
    }
}
