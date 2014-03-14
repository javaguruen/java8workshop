package no.berghamre.util;

import java.util.PrimitiveIterator;
import java.util.Spliterator;
import java.util.Spliterators;
import java.util.stream.LongStream;
import java.util.stream.StreamSupport;

public class FibonacciGenerator implements PrimitiveIterator.OfLong {
    private long currentNode = 0;
    private long previous = 0;

    @Override
    public long nextLong() {
        nextAndSave();
        return currentNode;
    }

    private void nextAndSave(){
        if(0 == currentNode){
            currentNode=1;
        }else if(0 == previous){
            previous = 1;
        }else{
            long next = currentNode + previous;
            previous = currentNode;
            currentNode = next;
        }
    }

    @Override
    public boolean hasNext() {
        return currentNode + previous > -1;
    }


    public static LongStream infiniteStream() {
        return StreamSupport.longStream(
                Spliterators.spliteratorUnknownSize(new FibonacciGenerator(), Spliterator.ORDERED | Spliterator.IMMUTABLE), false
        );
    }
}
