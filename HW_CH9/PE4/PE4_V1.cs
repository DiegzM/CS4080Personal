using System;

// This code will not compile
class PE4_V1
{
    static void ChangeRef(ref double x)
    {
        x = 99.9;
    }
    static void Main()
    {
        // Passing literal by reference, wont compile
        ChangeRef(ref 1.0);
    }
}