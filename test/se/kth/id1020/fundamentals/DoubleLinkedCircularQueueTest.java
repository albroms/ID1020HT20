package se.kth.id1020.fundamentals;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DoubleLinkedCircularQueueTest {
    private DoubleLinkedCircularQueue queue;

    @BeforeEach
    void setUp(){
        queue = new DoubleLinkedCircularQueue();
    }

    @AfterEach
    void tearDown(){
        queue = null;
    }

    @Test
    void enqueueToEmptyQueue() {
    }

    @Test
    void dequeueEmptyQueue() {
    }

    @Test
    void printQueue() {
    }

    @Test
    void printIterable() {
    }

    @Test
    void addToFront() {
    }

    @Test
    void removeLast() {
    }
}