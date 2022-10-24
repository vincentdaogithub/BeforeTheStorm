package com.vincentdao.List;

/**
 * Implementation of the abstract class {@code List}. 
 * Contains all the methods that {@code List} offers, 
 * plus extra methods for Stack and Queue ADT.
 * 
 * @version 0.1
 * 
 * @author vincentdao
 */
public final class LinkedList<T extends Comparable<T>> extends List<T> implements IStack<T>, IQueue<T>
{
    //--------------------------------------------------
    // This block contains methods for Stack ADT


    /**
     * Pops the top value of the Stack. Equivalent to 
     * {@code RemoveLast} from {@code List}.
     * 
     * @return {@code T} : Top value of the Stack.
     */
    @Override
    public final T Pop()
    {
        return RemoveLast();
    }


    /**
     * Pushes the value to the top of the Stack. 
     * Equivalent to {@code AddLast} from {@code List}.
     * 
     * @param value : Value to push onto the Stack.
     */
    @Override
    public final void Push(T value)
    {
        AddLast(value);
    }


    /**
     * Peeks at the top value of the Stack. Equivalent 
     * to {@code GetLast} from {@code List}.
     * 
     * @return {@code T} : Top value of the Stack.
     */
    @Override
    public final T Peek()
    {
        return GetLast();
    }


    //--------------------------------------------------
    // This block contains methods for Queue ADT


    /**
     * Adds value to the beginning of the Queue. 
     * Equivalent to {@code AddFirst} from {@code List}.
     * 
     * @param value : Value to add to the Queue.
     */
    @Override
    public final void Enqueue(T value)
    {
        AddLast(value);
    }


    /**
     * Removes value from the end of the Queue 
     * and returns itself. Equivalent to {@code RemoveLast} 
     * from {@code List}.
     * 
     * @return {@code T} : Value at the end of the 
     * Queue.
     */
    @Override
    public final T Dequeue()
    {
        return RemoveFirst();
    }


    /**
     * Gets value at the beginning of the Queue. 
     * Equivalent to {@code GetFirst} from {@code List}.
     * 
     * @return {@code T} : Value at the beginning of 
     * the Queue.
     */
    @Override
    public final T First()
    {
        return GetFirst();
    }
}
