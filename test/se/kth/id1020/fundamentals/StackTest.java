package se.kth.id1020.fundamentals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

class StackTest {
    private Stack stack;


    @BeforeEach
    void setUp(){
        stack = new Stack<Character>();
    }

    @AfterEach
    void tearDown(){
        stack = null;
    }

    @Test
    void testPushNormal(){
        boolean expResult = false;
        stack.push("First");
        boolean result = stack.isEmpty();
        assertEquals(expResult, result, "Expected " + expResult + " and got " + result + ".");

    }

    @Test
    void testPopNormal(){
        String expResult = "second in";
        stack.push("first in");
        stack.push("second in");
        String result = stack.pop().toString();
        assertEquals(expResult, result, "Expected " + expResult + " and got " + result + ".");
    }

    @Test
    void testPopEmpty(){
        String expResult = "Stack underflow.";
        String result = null;

        try{
            stack.pop();
        }
        catch (NoSuchElementException e){
            result = e.getMessage();
        }

        assertEquals(expResult, result, "Expected " + expResult + " and got " + result + ".");
    }
}