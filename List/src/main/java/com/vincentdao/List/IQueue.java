package com.vincentdao.List;


/**
 * Implementation of the Queue ADT. Uses {@code interface} 
 * to simulate basic operations of a Queue.
 * 
 * @version 0.1
 * 
 * @author vincentdao
 */
public interface IQueue<T extends Comparable<T>>
{
    /**
     * Adds value to the beginning of the Queue. 
     * Equivalent to {@code AddFirst} from {@code List}.
     * 
     * @param value : Value to add to the Queue.
     */
    public void Enqueue(T value);


    /**
     * Removes value from the end of the Queue 
     * and returns itself. Equivalent to {@code RemoveLast} 
     * from {@code List}.
     * 
     * @return {@code T} : Value at the end of the 
     * Queue.
     */
    public T Dequeue();


    /**
     * Gets value at the beginning of the Queue. 
     * Equivalent to {@code GetFirst} from {@code List}.
     * 
     * @return {@code T} : Value at the beginning of 
     * the Queue.
     */
    public T First();


    /**
     * Empties the list.
     */
    public void Clear();


    /**
     * Converts the list into array.
     * 
     * @param arrayType : Type of array to sort (must be the 
     * same type as defined). This parameter accepts an 
     * instance of previously-defined-type array.
     * 
     * <p>
     * Example: if the {@code list} holds Integer, 
     * then 
     * {@code Integer[] array = list.ToArray(new Integer[0])}
     * </p>
     * 
     * @return {@code T[]} : Representation of the list as array. 
     * {@code null} if the list is empty
     * 
     * @throws NullPointerException If there is {@code null} 
     * node in the list.
     */
    public T[] ToArray(T[] arrayType);


    /**
     * Returns the {@code size} of the list.
     * 
     * @return {@code int}  : Size of the list.
     */
    public int Size();
}
