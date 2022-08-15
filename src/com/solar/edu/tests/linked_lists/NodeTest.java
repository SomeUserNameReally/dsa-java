package com.solar.edu.tests.linked_lists;

import com.solar.edu.linked_lists.Node;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


public class NodeTest {

    @Test
    void instantiatingWithNullThrows() {
        Exception e = assertThrows(IllegalArgumentException.class, () -> {
            new Node<>(null);
        }, "Node instantiation with null value expected to fail but succeeded.");

        assertTrue(e.getMessage().contains("Cannot instantiate"));
    }

    @Test
    void objectForNewlyInstantiatedNodeRemainsUnchanged() {
        String obj = "test";
        Node<String> node = new Node<>(obj);
        assertEquals(0, obj.compareTo(node.getO()));
        assertEquals(obj, node.getO());
    }

    @Test
    void newlyInstantiatedNodeHasNoNextOrPrev() {
        String obj = "test";
        Node<String> node = new Node<>(obj);
        assertNull(node.getNext());
        assertNull(node.getPrevious());
    }

    @Test
    void nodeHasCorrectPrevious() {
        String obj = "test";
        String prevObj = "prev";

        Node<String> node = new Node<>(obj);
        Node<String> prev = new Node<>(prevObj);

        node.setPrevious(prev);

        assertEquals(0, obj.compareTo(node.getO()));
        assertEquals(obj, node.getO());
        assertEquals(0, prevObj.compareTo(prev.getO()));
        assertEquals(prevObj, prev.getO());

        assertEquals(prev, node.getPrevious());
        assertEquals(prevObj, node.getPrevious().getO());
    }

    @Test
    void nodeHasCorrectNext() {
        String obj = "test";
        String nextObj = "next";

        Node<String> node = new Node<>(obj);
        Node<String> next = new Node<>(nextObj);

        node.setNext(next);

        assertEquals(0, obj.compareTo(node.getO()));
        assertEquals(obj, node.getO());
        assertEquals(0, nextObj.compareTo(next.getO()));
        assertEquals(nextObj, next.getO());

        assertEquals(next, node.getNext());
        assertEquals(nextObj, node.getNext().getO());
    }

    @Test
    void allowsForCircularRefToPrevious() {
        String obj = "test";
        Node<String> node = new Node<>(obj);

        node.setPrevious(node);

        assertEquals(node, node.getPrevious());
        assertEquals(obj, node.getPrevious().getO());

        // There is only one object, therefore node, and
        // calling `getPrevious` twice should result in a
        // null reference exception if node is not
        // circular. This node links to itself
        assertEquals(node, node.getPrevious().getPrevious());
        assertEquals(obj, node.getPrevious().getPrevious().getO());
    }

    @Test
    void allowsForCircularRefToNext() {
        String obj = "test";
        Node<String> node = new Node<>(obj);

        node.setNext(node);

        assertEquals(0, obj.compareTo(node.getO()));
        assertEquals(obj, node.getO());

        assertEquals(node, node.getNext());
        assertEquals(obj, node.getNext().getO());

        // There is only one object, therefore node, and
        // calling `getNext` twice should result in a
        // null reference exception if node is not
        // circular. This node links to itself
        assertEquals(node, node.getNext().getNext());
        assertEquals(obj, node.getNext().getNext().getO());
    }
}
