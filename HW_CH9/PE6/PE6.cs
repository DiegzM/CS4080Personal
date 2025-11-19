using System;
using System.Diagnostics;
using System.Runtime.CompilerServices;

class PE6
{
    static volatile int sink;

    [MethodImpl(MethodImplOptions.NoInlining)]
    static void ByValue(int[] arr) {sink ^= arr[0];}

    [MethodImpl(MethodImplOptions.NoInlining)]
    static void ByRef(ref int[] arr) {sink ^= arr[0];}

    static void Main()
    {
        var arr = new int[1_000_000]; arr[0] = 42;
        int N = 50_000_000;

        var sw = Stopwatch.StartNew();
        for (int i = 0; i < N; i++) ByValue(arr);
        Console.WriteLine($"ByValue: {sw.ElapsedMilliseconds} ms");

        sw.Restart();
        for (int i = 0; i < N; i++) ByRef(ref arr);
        Console.WriteLine($"ByRef: {sw.ElapsedMilliseconds} ms");
    }
}