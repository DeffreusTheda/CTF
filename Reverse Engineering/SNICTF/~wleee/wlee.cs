// Decompiled with JetBrains decompiler
// Type: Program
// Assembly: wleee, Version=1.0.0.0, Culture=neutral, PublicKeyToken=null
// MVID: 40CDD1A5-1010-491C-B590-E97E98350824
// Assembly location: wleee.dll inside \\Mac\CTF\Reverse Engineering\SNICTF\wleee\wleee.exe)

using System;

#nullable enable
internal class Program {
  private static Program.Checker checker1(string flag) {
    int correct_number = 0;
    int[][] numArray = new int[8][] {
      Array.Empty<int>(),
      Array.Empty<int>(),
      new int[2]{ 5, 37 },
      new int[7]{ 15, 19, 22, 24, 26, 30, 34 },
      new int[5]{ 1, 2, 4, 18, 40 },
      new int[8]{ 0, 6, 13, 20, 25, 28, 29, 35 },
      new int[14]{ 7, 8, 10, 11, 16, 17, 21, 23, 31, 32, 33, 36, 38, 39 },
      new int[6]{ 3, 9, 12, 14, 27, 41 }
    };
    for (int index1 = 0; index1 < numArray.Length; ++index1) {
      for (int index2 = 0; index2 < numArray[index1].Length; ++index2) {
        if (flag.Length <= numArray[index1][index2])
          return (Program.Checker) (() => false);
        correct_number += (int) flag[numArray[index1][index2]] >> 4 == index1 ? 1 : 0;
      }
    }
    return (Program.Checker) (() => correct_number == flag.Length);
  }

  private static Program.Checker checker2(string flag) {
    int correct_number = 0;
    int[][] numArray = new int[8][] {
      new int[6]{ 15, 22, 26, 30, 34, 37 },
      new int[9]{ 0, 4, 5, 14, 19, 24, 27, 29, 36 },
      new int[4]{ 7, 9, 11, 12 },
      new int[5]{ 17, 21, 38, 39, 40 },
      new int[1]{ 2 },
      new int[1]{ 3 },
      new int[3]{ 18, 23, 41 },
      new int[13]{ 1, 6, 8, 10, 13, 16, 20, 25, 28, 31, 32, 33, 35 }
    };
    for (int index1 = 0; index1 < numArray.Length; ++index1) {
      for (int index2 = 0; index2 < numArray[index1].Length; ++index2) {
        if (flag.Length <= numArray[index1][index2])
          return (Program.Checker) (() => false);
        correct_number += ((int) flag[numArray[index1][index2]] >> 1 & 7) == index1 ? 1 : 0;
      }
    }
    return (Program.Checker) (() => correct_number == flag.Length);
  }

  private static Program.Checker checker3(string flag) {
    int correct_number = 0;
    int[][] numArray = new int[2][] {
      new int[12]{ 1, 7, 9, 10, 12, 16, 18, 21, 23, 30, 34, 36 },
      new int[30] { 0, 2, 3, 4, 5, 6, 8, 11, 13, 14, 15, 17, 19, 20, 22, 24, 25, 26, 27, 28, 29, 31, 32, 33, 35, 37, 38, 39, 40, 41 }
    };
    for (int index1 = 0; index1 < numArray.Length; ++index1) {
      for (int index2 = 0; index2 < numArray[index1].Length; ++index2) {
        if (flag.Length <= numArray[index1][index2])
          return (Program.Checker) (() => false);
        correct_number += ((int) flag[numArray[index1][index2]] & 1) == index1 ? 1 : 0;
      }
    }
    return (Program.Checker) (() => correct_number == flag.Length);
  }

  private static void Main() {
    Program.CheckerCallback[] checkerCallbackArray = new Program.CheckerCallback[3] {
      (Program.CheckerCallback) (flag => Program.checker1(flag)),
      (Program.CheckerCallback) (flag => Program.checker2(flag)),
      (Program.CheckerCallback) (flag => Program.checker3(flag))
    };
    Console.Write("Enter the flag: ");
    string _ = Console.ReadLine();
    foreach (Program.CheckerCallback checkerCallback in checkerCallbackArray) {
      if (!checkerCallback(_)()) {
        Console.WriteLine("Incorrect!!");
        Environment.Exit(1);
      }
    }
    Console.WriteLine("Correct!!");
  }

  public delegate bool Checker();

  public delegate Program.Checker CheckerCallback(string _);
}
