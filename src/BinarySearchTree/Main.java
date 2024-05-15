package BinarySearchTree;

import java.util.Iterator;

public class Main {
    public static void main(String[] args) {
        BST<Integer, String> bst = new BST<>();

        bst.put(50, "Value50");
        bst.put(30, "Value30");
        bst.put(20, "Value20");
        bst.put(40, "Value40");
        bst.put(70, "Value70");
        bst.put(60, "Value60");
        bst.put(80, "Value80");

        System.out.println("Retrieving key 50: " + bst.get(50));
        System.out.println("Retrieving key 20: " + bst.get(20));
        System.out.println("Retrieving key 70: " + bst.get(70));

        System.out.println("In-order traversal:");
        Iterator<BST<Integer, String>.Node> iterator = bst.iterator();
        while (iterator.hasNext()) {
            BST<Integer, String>.Node node = iterator.next();
            System.out.println("Key is " + node.getKey() + " and value is " + node.getValue());
        }

        bst.delete(20);
        System.out.println("In-order traversal after deleting key 20:");
        iterator = bst.iterator();
        while (iterator.hasNext()) {
            BST<Integer, String>.Node node = iterator.next();
            System.out.println("Key is " + node.getKey() + " and value is " + node.getValue());
        }

        bst.delete(30);
        System.out.println("In-order traversal after deleting key 30:");
        iterator = bst.iterator();
        while (iterator.hasNext()) {
            BST<Integer, String>.Node node = iterator.next();
            System.out.println("Key is " + node.getKey() + " and value is " + node.getValue());
        }

        bst.delete(50);
        System.out.println("In-order traversal after deleting key 50:");
        iterator = bst.iterator();
        while (iterator.hasNext()) {
            BST<Integer, String>.Node node = iterator.next();
            System.out.println("Key is " + node.getKey() + " and value is " + node.getValue());
        }
    }
}