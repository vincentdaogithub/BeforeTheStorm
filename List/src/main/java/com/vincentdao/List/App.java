package com.vincentdao.List;


public class App
{
    public static void main(String[] args)
    {
        System.out.println();

        List<String> list = new LinkedList<>();

        list.AddLast("f");
        list.AddLast("h");
        list.AddLast("e");
        list.AddLast("a");

        list.Sort();
        String[] array3 = list.ToArray(new String[0]);

        for (String item : array3)
        {
            System.out.println(item);
        }

        System.out.println(list.Size());

        System.out.println();

        IStack<Float> stack = new LinkedList<>();

        stack.Push(1.0f);
        stack.Push(2.5f);
        stack.Push(5.6f);
        stack.Push(8.9f);

        Float[] array4 = stack.ToArray(new Float[0]);

        for (Float item : array4)
        {
            System.out.println(item);
        }

        System.out.println(stack.Size());

        System.out.println();

        IQueue<Double> queue = new LinkedList<>();

        queue.Enqueue(4.5);
        queue.Enqueue(5.0);
        queue.Enqueue(8.0);
        queue.Enqueue(9.7);

        Double double1 = queue.Dequeue();
        Double double2 = queue.Dequeue();

        System.out.println(double1);
        System.out.println(double2);

        Double[] array5 = queue.ToArray(new Double[0]);

        for (Double item : array5)
        {
            System.out.println(item);
        }

        System.out.println(queue.Size());
    }
}
