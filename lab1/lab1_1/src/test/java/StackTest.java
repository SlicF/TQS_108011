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
        
    }

}