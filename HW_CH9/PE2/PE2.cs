using System;

class PE2
{
    static void Main()
    {
        int value;
        Console.WriteLine("value is still uninitialized");
        Method(out value);
        Console.WriteLine("value after method call: " + value);
    }

    static void Method(out int x)
    {
        Console.WriteLine("In Method: x is about to be assigned");
        x = 42; // Assign a value to the out parameter
        Console.WriteLine("In Method: x has been assigned the value " + x);
    }
}