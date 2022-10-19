package com.vincentdao.List;


/**
 * Implementation of the Stack ADT. Uses {@code interface} 
 * to simulate basic operations of a Stack.
 * 
 * @version 0.1
 * 
 * @author vincentdao
 */
public interface IStack<T extends Comparable<T>>
{
    /**
     * Pushes the value to the top of the Stack. 
     * Equivalent to {@code AddLast} from {@code List}.
     * 
     * @param value : Value to push onto the Stack.
     */
    public void Push(T value);
    

    /**
     * Pops the top value of the Stack. Equivalent to 
     * {@code RemoveLast} from {@code List}.
     * 
     * @return {@code T} : Top value of the Stack.
     */
    public T Pop();


    /**
     * Peeks at the top value of the Stack. Equivalent 
     * to {@code GetLast} from {@code List}.
     * 
     * @return {@code T} : Top value of the Stack.
     */
    public T Peek();


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
