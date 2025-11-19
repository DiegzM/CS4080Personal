using System;

// This code will compile
class PE4_V2
{
    static void ChangeRef(ref double x)
    {
        Console.WriteLine("In ChangeRef: x before assignment: " + x);
        x = 99.9;
        Console.WriteLine("In ChangeRef: x after assignment: " + x);
    }

    static void Main()
    {
        double a = 1.0;
        Console.WriteLine("Before ChangeRef: a = " + a);
        ChangeRef(ref a);
        Console.WriteLine("After ChangeRef: a = " + a);
    }
}