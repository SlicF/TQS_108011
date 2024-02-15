import org.junit.jupiter.api.*;

import lab.Stack;

import static org.junit.jupiter.api.Assertions.*;

class StackTest {  

    @Test
    void testPush() {
        Stack stack = new Stack(10);  
        stack.push(1);
        stack.push(2);
        stack.push(3);
        assertEquals(3, stack.peek());
    }

    @Test
    void testPop() {
        Stack stack = new Stack(10);
        stack.push(1);
        stack.push(2);
        stack.push(3);
        assertEquals(3, stack.pop());
        assertEquals(2, stack.pop());
        assertEquals(1, stack.pop());
    }

    @Test
    void testPeek() {
        Stack stack = new Stack(10);
        stack.push(1);
        assertEquals(1, stack.peek());
    }

    @Test
    void testisEmpty() {
        Stack stack = new Stack(10);
        stack.push(1);
        assertFalse(stack.isEmpty());
    }

    @Test
    void testgetSize() {
        Stack stack = new Stack(10);
        assertEquals(10, stack.getSize());
    }

    @Test
    void testisFull() {
        Stack stack = new Stack(10);
        for (int i = 0; i < 10; i++) {
            stack.push(i);
        }
        assertTrue(stack.isFull());
    }

    @Test
    void testStackOverflowError() {
        Stack stack = new Stack(10);
        for (int i = 0; i < 10; i++) {
            stack.push(i);
        }
        assertThrows(StackOverflowError.class, () -> stack.push(11));
    }

    @Test
    void testStackUnderflowError() {
        Stack stack = new Stack(10);
        assertThrows(ArrayIndexOutOfBoundsException.class, () -> stack.pop());
    }

    @Test
    void testPeekEmptyStack() {
        Stack stack = new Stack(10);
        assertThrows(ArrayIndexOutOfBoundsException.class, () -> stack.peek());
    }

    @Test
    void testPopEmptyStack() {
        Stack stack = new Stack(10);
        assertThrows(ArrayIndexOutOfBoundsException.class, () -> stack.pop());
    }

}