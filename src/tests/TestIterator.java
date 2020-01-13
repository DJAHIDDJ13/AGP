package tests;

import java.util.Iterator;

import bde.iterator.LinkedList;

class TestIterator {
	
    public static void main(String[] args) {
 
        LinkedList<String> list = new LinkedList<>("One");
        list.add("Two");
        list.add("Four");
        list.add("Three");
 
        //Test #1
        System.out.println("using Iterator:");
        Iterator<String> itr = list.iterator();
        while (itr.hasNext()) {
            String i = itr.next();
            System.out.print(i + " ");
        }
 
        //Test #2
        System.out.println("\n\nusing for-each:");
        for (String data : list) {
            System.out.print(data + " ");
        }
    }
}