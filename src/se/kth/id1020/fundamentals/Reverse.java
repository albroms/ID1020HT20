/**
 * Task 2 of Lab 1
 */
package se.kth.id1020.fundamentals;

public class Reverse {
    String output = "";

    /**
     * Push each character from the input to a stack.
     * O(N) time complexity since it needs to iterate through the whole char array to create the stack.
     * O(N) space complexity due to how the stack grows in this method.
     * @param input the given input
     * @return a stack of chars based on input.
     */
    public Stack buildStack(String input){
        Stack stack = new Stack();
        for(char c : input.toCharArray()){
            stack.push(c);
        }
        return stack;
    }

    /**
     * Recursively push items to a stack from the given input.
     * O(N) time complexity since it needs to process the entire string given by the user.
     * O(N) space complexity due to how the stack grows in this method.
     * @param remainingInput the part of the string that hasn't been processed yet.
     * @param stack the stack to push things on to.
     * @return
     */
    public Stack buildStackRecursive(String remainingInput, Stack stack){
        if(remainingInput.isEmpty()){
            return stack;
        }
        stack.push(remainingInput.charAt(0));
        return buildStackRecursive(remainingInput.substring(1), stack);
    }

    /**
     * Iteratively visualize the reversed input.
     * Time complexity is O(N).
     * Space complexity is O(1).
     * @param stack
     * @return
     */
    public String iterativeReverse(Stack stack){
        while (!stack.isEmpty()){
            output += "[" + stack.pop() + "], ";
        }
        return output;
    }

    /**
     * Recursively visualize the reversed input.
     * Time complexity is O(N).
     * Space complexity is O(1).
     * @param stack
     * @return
     */
    public String recursiveReverse(Stack stack){
        if(stack.isEmpty()){
            return "";
        }
        return "[" + stack.pop().toString() + "], " + recursiveReverse(stack); //tail recursive!
    }
}
