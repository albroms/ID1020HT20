/**
 * A class used to quickly test the code without unit testing.
 * Unit tests will be written if there is enough time.
 */
package se.kth.id1020;

import se.kth.id1020.fundamentals.*;

import java.util.Iterator;
import java.util.Scanner;

public class Main<Item> {

    public static void main(String[] args) {
	// write your code here

        /*
        //Test code for task 2.
        Reverse rev = new Reverse();
        Scanner in = new Scanner(System.in);
        System.out.println("Please enter string for iterative reverse.");
        String iterativeInput = in.nextLine();
        System.out.println("Please enter string for recursive reverse.");
        String recursiveInput = in.nextLine();
        Stack iterativeStack = rev.buildStack(iterativeInput);
        Stack recursiveStack = rev.buildStackRecursive(recursiveInput, new Stack());
        System.out.println("Result of iterative reverse:");
        System.out.println(rev.iterativeReverse(iterativeStack));
        System.out.println("Result of recursive reverse:");
        System.out.println(rev.recursiveReverse(recursiveStack));
        */

        /*
        //Test code for task 3.
        DoubleLinkedCircularQueue queue = new DoubleLinkedCircularQueue();
        Iterator iterator = queue.iterator();
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(4);
        queue.dequeue();
        queue.dequeue();
        queue.dequeue();
        */


        //Test code for task 4.
        /*

        DoubleLinkedCircularQueue queue = new DoubleLinkedCircularQueue();
        Iterator iterator = queue.iterator();
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(4);
        queue.addToFront(5);

        queue.removeLast();
        queue.dequeue();
        */

        //Test code for task 5.


        TaskFiveDoubleLinkedCircularQueue taskFiveQueue = new TaskFiveDoubleLinkedCircularQueue();
        taskFiveQueue.enqueue("Banana");
        taskFiveQueue.enqueue("Apple");
        taskFiveQueue.enqueue("Pear");
        taskFiveQueue.enqueue("Orange");
        taskFiveQueue.enqueue("Pineapple");

        taskFiveQueue.remove(3); //expected result: "Pear" at index 3 gone. y
        taskFiveQueue.remove(3); //expected result: "Apple" at index 3 gone. y
        taskFiveQueue.remove(2); //expected result: "Orange" at index 2 gone. y
        taskFiveQueue.remove(2); //expected result: "Banana" at index 2 gone. y
        taskFiveQueue.remove(1); //expected result: "Pineapple" at index 1 gone. y
        taskFiveQueue.remove(1); //expected result: IllegalArgumentException y


        //Test code for task 6.

        /*

        */
    }
}
