package com.vincentdao.List;

import java.lang.reflect.Array;
import java.util.NoSuchElementException;


/**
 * <p>
 * Abstract class {@code List} that holds all basic functions 
 * of a List.This is also applicable for its family, 
 such as SinglyLinkedList, DoublyLinkedList, etc...</p>
 * 
 * <p>
 * This abstract class can also be used for other ADT as 
 * well, such as Stack, Queue, Dequeue, etc...
 * </p>
 * 
 * @version 0.1
 * 
 * @author vincentdao
 */
public abstract class List<T extends Comparable<T>>
{
    //--------------------------------------------------
    // This block contains the class for node.


    /** Represents a {@code Node} in the list. */
    class Node
    {
        /** Value of the node. */
        T value;

        /** Pointer to the previous node */
        Node prevNode;

        /** Pointer to the next node. */
        Node nextNode;


        /**
         * Constructs a {@code Node} with assigned value. 
         * The {@code Node} would not point to any of the 
         * other {@code Node}.
         * 
         * @param value : Value of the node.
         */
        Node(T value)
        {
            this.value = value;
            this.prevNode = null;
            this.nextNode = null;
        }


        /**
         * Compare method for the {@code Node}. Same 
         * usage as the {@code compareTo} method.
         * 
         * @param nodeToCompare : {@code Node} to be 
         * compared with.
         * 
         * @return {@code int} : a negative number, 0 or 
         * positive number depends on whether the value of 
         * the first {@code Node} is lesser, equaled or 
         * larger than the value of the second {@code Node}, 
         * respectively.
         */
        int CompareTo(Node nodeToCompare)
        {
            return this.value.compareTo(nodeToCompare.value);
        }
    }


    //--------------------------------------------------
    // This block contains fields of the list.

    
    /** Head pointer of the list. */
    private Node headNode;

    /** Tail pointer of the list. */
    private Node tailNode;

    /** Size of the list. */
    private int size;


    //--------------------------------------------------
    // This block contains constructors for the list.


    /**
     * Constructs an empty list.
     */
    public List()
    {
        this.headNode = null;
        this.tailNode = null;
        this.size = 0;
    }


    //--------------------------------------------------
    // This block contains utilities methods for the list.

    
    /**
     * Checks if the list is empty.
     * 
     * @return {@code true} is the list is empty, {@code false} otherwise.
     */
    public final boolean IsEmpty()
    {
        return this.headNode == null && this.tailNode == null;
    }


    /**
     * Checks if the list has only one {@code Node}.
     * 
     * @return {@code true} if the list is not empty, and the
     * head pointer equals to the tail pointer. Return 
     * {@code false} otherwise.
     */
    private final boolean HasOnlyOneElement()
    {
        final boolean HeadEqualsTail = this.headNode == this.tailNode;

        return IsEmpty() == false && HeadEqualsTail;
    }


    /**
     * Gets the {@code Node} at given index.
     * 
     * @param index - {@code int}: Index of the node.
     * 
     * @return {@code Node} : Node at given index
     */
    private final Node GetNodeAt(int index)
    {
        Node workingNode = this.headNode;

        for (int i = 0; i < index; i++)
        {
            // error null node in list
            if (workingNode == null)
            {
                throw new NullPointerException();
            }

            workingNode = workingNode.nextNode;
        }

        return workingNode;
    }


    //--------------------------------------------------
    // This block contains clear method to destroy the list


    /**
     * Empties the list.
     */
    public final void Clear()
    {
        this.headNode = null;
        this.tailNode = null;
        this.size = 0;
    }
   

    //--------------------------------------------------
    // This block contains removal methods


    /**
     * Removes the first value of the list and returns 
     * itself.
     * 
     * @return {@code T} : First value of the list.
     * 
     * @throws NoSuchElementException If the list is empty.
     */
    public final T RemoveFirst()
    {
        // error empty list
        if (IsEmpty() == true)
        {
            throw new NoSuchElementException();
        }
        

        final Node workingNode = this.headNode;


        // remove list with only one node
        if (HasOnlyOneElement() == true)
        {
            this.headNode = null;
            this.tailNode = null;
            this.size--;

            return workingNode.value;
        }


        // remove head from list
        workingNode.nextNode.prevNode = null;
        this.headNode = workingNode.nextNode;
        this.size--;

        return workingNode.value;
    }


    /**
     * Removes the last value of the list and returns 
     * itself
     * 
     * @return {@code T} : Last value of the list.
     * 
     * @throws NoSuchElementException If the list is empty, 
     * or if it cannot find the {@code Node} before the 
     * tail {@code Node}.
     * 
     * @throws NullPointerException If there is {@code null} 
     * {@code Node} in the list.
     */
    public final T RemoveLast()
    {
        // error empty list
        if (IsEmpty() == true)
        {
            throw new NoSuchElementException();
        }


        Node workingNode = this.headNode;
        final Node deleteNode = this.tailNode;


        // delete only single node in list
        if (HasOnlyOneElement() == true)
        {
            this.headNode = null;
            this.tailNode = null;
            this.size--;

            return deleteNode.value;
        }


        // find the node before the tail
        for (int i = 0; i < this.size; i++)
        {
            // error null node in list
            if (workingNode == null)
            {
                throw new NullPointerException();
            }


            // remove tail from list
            if (workingNode == deleteNode)
            {
                this.tailNode = workingNode.prevNode;
                workingNode.prevNode.nextNode = null;
                this.size--;

                return deleteNode.value;
            }

            workingNode = workingNode.nextNode;
        }


        // error cannot find the node before tail
        throw new NoSuchElementException();
    }


    /**
     * Removes the value at given index and returns itself.
     * 
     * @param index : Index of the value, starts from 0.
     * 
     * @return {@code T} : Value at the given index.
     * 
     * @throws IndexOutOfBoundsException If the {@code index} 
     * is not in the range from {@code 0} to {@code size - 1}.
     * 
     * @throws NoSuchElementException If the list is empty.
     * 
     * @throws NullPointerException If there is {@code null} 
     * {@code Node} in the list.
     */
    public final T RemoveAt(int index)
    {
        // error index not in size range
        if (index < 0 || this.size - 1 < index)
        {
            throw new IndexOutOfBoundsException();
        }


        // error empty list
        if (IsEmpty() == true)
        {
            throw new NoSuchElementException();
        }
        

        Node workingNode = this.headNode;


        // search for the node at given index
        for (int i = 0; i < index; i++)
        {
            // error null node in list
            if (workingNode == null)
            {
                throw new NullPointerException();
            }

            workingNode = workingNode.nextNode;
        }


        // remove the node
        workingNode.prevNode.nextNode = workingNode.nextNode;
        this.size--;

        return workingNode.value;
    }


    //--------------------------------------------------
    // This block contains adding methods


    /**
     * Adds the value to the beginning of the list.
     * 
     * @param value : Value to add.
     */
    public final void AddFirst(T value)
    {
        Node addingNode = new Node(value);


        // add node to empty list
        if (IsEmpty() == true)
        {
            this.headNode = addingNode;
            this.tailNode = addingNode;
            this.size++;

            return;
        }
        

        // add node to the head of the list
        addingNode.nextNode = headNode;
        this.headNode = addingNode;
        this.size++;
    }


    /**
     * Adds the value to the end of the list.
     * 
     * @param value : Value to add.
     */
    public final void AddLast(T value)
    {
        Node addingNode = new Node(value);


        // add node to empty list
        if (IsEmpty() == true)
        {
            this.headNode = addingNode;
            this.tailNode = addingNode;
            this.size++;

            return;
        }


        // add node to the tail of the list
        addingNode.prevNode = this.tailNode;
        addingNode.prevNode.nextNode = addingNode;
        this.tailNode = addingNode;
        this.size++;
    }


    /**
     * Adds the value to the given index.
     * 
     * @param value : Value to add.
     * 
     * @param index : Index to add to.
     * 
     * @throws IndexOutOfBoundsException If the {@code index} 
     * is not in the range from {@code 0} to {@code size - 1}.
     * 
     * @throws NullPointerException If there is {@code null} 
     * node in the list.
     */
    public final void AddAt(T value, int index)
    {
        // error index not in size range
        if (index < 0 || this.size - 1 < index)
        {
            throw new IndexOutOfBoundsException();
        }


        // use AddHead method when list is empty or
        // when the index points to the start of 
        // the list
        if (IsEmpty() == true || index == 0)
        {
            AddFirst(value);
            return;
        }


        // use AddTail method when index points to 
        // the end of the list
        if (index == this.size - 1)
        {
            AddLast(value);
            return;
        }


        Node workingNode = this.headNode;


        // get the node before the index
        for (int i = 0; i < index - 1; i++)
        {
            // error null node in list
            if (workingNode == null)
            {
                throw new NullPointerException();
            }

            workingNode = workingNode.nextNode;
        }

        Node addingNode = new Node(value);

        addingNode.nextNode = workingNode.nextNode;
        workingNode.nextNode = addingNode;
        addingNode.prevNode = workingNode;
        this.size++;
    }


    //--------------------------------------------------
    // This block contains methods to get the fields' data 
    // from the list.


    /**
     * Returns the {@code size} of the list.
     * 
     * @return {@code int}  : Size of the list.
     */
    public final int Size()
    {
        return this.size;
    }


    /**
     * Returns the first value of the list.
     * 
     * @return {@code T} : First value of the list. 
     * {@code null} if the list is empty.
     */
    public final T GetFirst()
    {
        return this.headNode == null ? null : this.headNode.value;
    }


    /**
     * Returns the last value of the list.
     * 
     * @return {@code T} : Last value of the list. 
     * {@code null} if the list is empty.
     */
    public final T GetLast()
    {
        return this.tailNode == null ? null : this.tailNode.value;
    }


    /**
     * Gets the value at the given {@code index}.
     * 
     * @param index : Index of the node to retrieve
     * 
     * @return {@code T} : Value at the given {@code index}.
     * 
     * @throws IndexOutOfBoundsException If the {@code index} 
     * is not in the range from {@code 0} to {@code size - 1}.
     * 
     * @throws NoSuchElementException If the list is empty.
     * 
     * @throws NullPointerException If there is {@code null} 
     * node in the list.
     */
    public final T GetAt(int index)
    {
        // error index not in size range
        if (index < 0 || this.size - 1 < index)
        {
            throw new IndexOutOfBoundsException();
        }


        // error list is empty
        if (IsEmpty() == true)
        {
            throw new NoSuchElementException();
        }

        
        Node workingNode = this.headNode;


        // get the node at index
        for (int i = 0; i < index; i++)
        {
            if (workingNode == null)
            {
                throw new NullPointerException();
            }

            workingNode = workingNode.nextNode;
        }

        return workingNode.value;
    }


    //--------------------------------------------------
    // This block contains method to turn the list into
    // "workable" collection, array to be specific


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
    @SuppressWarnings("unchecked")
    public final T[] ToArray(T[] arrayType)
    {
        // return null if empty list
        if (IsEmpty() == true)
        {
            return null;
        }


        arrayType = (T[]) Array.newInstance(arrayType.getClass().componentType(), this.size);
        Node workingNode = this.headNode;


        // copy from list to array
        for (int i = 0; i < this.size; i++)
        {
            // error null node in list
            if (workingNode == null)
            {
                throw new NullPointerException();
            }

            arrayType[i] = workingNode.value;
            workingNode = workingNode.nextNode;
        }

        return arrayType;
    }


    //--------------------------------------------------
    // This block contains swap method


    /**
     * Swaps two values.
     * 
     * @param index1 : Index of the first node.
     * 
     * @param index2 : Index of the second node.
     * 
     * @throws IndexOutOfBoundsException If the {@code index} 
     * is not in the range from {@code 0} to {@code size - 1}.
     * 
     * @throws NoSuchElementException If the list is empty.
     */
    public final void Swap(int index1, int index2)
    {
        // error index out of size range
        if (index1 < 0 || this.size - 1 < index1)
        {
            throw new IndexOutOfBoundsException();
        }
        else if (index2 < 0 || this.size - 1 < index2)
        {
            throw new IndexOutOfBoundsException();
        }


        // swap the same node -> no swap
        if (index1 == index2)
        {
            return;
        }


        // error empty list, or there is only one node
        if (IsEmpty() == true || HasOnlyOneElement() == true)
        {
            throw new NoSuchElementException();
        }


        // swap the value of the two node
        Node node1 = GetNodeAt(index1);
        Node node2 = GetNodeAt(index2);
        T tmp;

        tmp = node1.value;
        node1.value = node2.value;
        node2.value = tmp;
    }


    //--------------------------------------------------
    // This block contains sorting method, using QuickSort


    /**
     * Sorts the list in a non-decreasing manner using Quick Sort
     */
    public final void Sort()
    {
        // no sorting when the list is empty or only has
        // 1 node
        if (IsEmpty() == true || HasOnlyOneElement() == true)
        {
            return;
        }


        // sort
        QuickSort(0, this.size - 1);
    }


    /**
     * Quick Sort algorithm
     * 
     * @param low : Bottom index of the (sub)list
     * 
     * @param high : Top index of the (sub)list
     */
    private void QuickSort(int low, int high)
    {
        if (low < high)
        {
            int pivot = Divide(low, high);

            QuickSort(low, pivot - 1);
            QuickSort(pivot + 1, high);
        }
    }


    /**
     * Divide the (sub)list into 2 parts, with the left side 
     * smaller than the {@code pivot} and the right side 
     * larger than said {@code pivot}. {@code pivot} here is 
     * the last node of the (sub)list
     * 
     * @param low : Bottom index of the (sub)list
     * 
     * @param high : Top index of the (sub)list
     * 
     * @return {@code int} : Index of the {@code pivot}
     */
    private int Divide(int low, int high)
    {
        // pivot is the value at right most
        Node pivot = GetNodeAt(high);

        // swapIndex will mark the last known value that is larger 
        // than the pivot
        int swapIndex = low - 1;


        // swap the value if the current value is smaller than pivot, else
        // advance. This will automatically swap the small vs big value, 
        // leaving the left side to be smaller than the pivot and the right 
        // to be larger.
        for (int traverseIndex = low; traverseIndex < high; traverseIndex++)
        {
            int compare = GetNodeAt(traverseIndex).CompareTo(pivot);

            if (compare <= 0)
            {
                swapIndex++;
                Swap(swapIndex, traverseIndex);
            }
        }


        // put the pivot at the last known place of larger value than pivot, 
        // leaving the pivot to be the "border".
        Swap(++swapIndex, high);
        return swapIndex;
    }
}
