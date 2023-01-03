package ru.job4j.queue;

import java.util.Deque;
import java.util.Iterator;

public class ReconstructPhrase {
    private final Deque<Character> descendingElements;
    private final Deque<Character> evenElements;

    public ReconstructPhrase(Deque<Character> descendingElements, Deque<Character> evenElements) {
        this.descendingElements = descendingElements;
        this.evenElements = evenElements;
    }

    private String getEvenElements() {
        int size = evenElements.size() / 4;
        StringBuilder stringBuilderHead = new StringBuilder();
        StringBuilder stringBuilderTail = new StringBuilder();
        for (int i = 0; i < size; i++) {
            stringBuilderHead.append(evenElements.pollFirst());
            evenElements.pollLast();
            stringBuilderTail.append(evenElements.pollLast());
            evenElements.pollFirst();
        }
        return stringBuilderHead + stringBuilderTail.reverse().toString();
    }

    private String getDescendingElements() {
        StringBuilder stringBuilder = new StringBuilder();
        Iterator<Character> iterator = descendingElements.descendingIterator();
        while (iterator.hasNext()) {
            stringBuilder.append(iterator.next());
        }
        return stringBuilder.toString();
    }

    public String getReconstructPhrase() {
        return getEvenElements() + getDescendingElements();
    }
}
