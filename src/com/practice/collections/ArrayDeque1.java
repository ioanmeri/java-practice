package com.practice.collections;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Optional;

public class ArrayDeque1 {

    public static void main(String[] args) {
        Deque<Integer> d = new ArrayDeque<>();
        d.add(1);
        d.push(2);
        d.pop();
        d.offerFirst(3);
        d.remove();
        System.out.println(d);
    }
}

// add(e)   -> addLast
// offer(e) -> offerLast
// push(e)  -> addFirst
// pop(e)   -> removeFirst
// remove() -> removeFirst
// poll()   -> pollFirst
// peek()   -> peekFirst
// offerFirst(e)
// offerLast(e)
// removeLast()
// peekLast()

// In the context of Deque
// pop()     == removeFirst()
// remove()  == removeFirst()
// poll()    == pollFirst()
// peek()    == peekFirst()
// push(e)   == addFirst(e)

// poll
// - It removes and returns the first (front) element of the queue/deque.
// - returns null if no elements

// peek
// - only returns the first element—it does not remove it.

// offer
// - It attempts to insert the element.
// - Returns true if the element was added.
// - Returns false if it could not be added (for example, in a capacity-restricted queue).