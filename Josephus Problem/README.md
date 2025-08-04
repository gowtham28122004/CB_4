# 🛡️ Josephus Special (Amazon Interview Question)

This project provides a Java implementation of a variation of the classic **Josephus Problem**, specifically where **every second soldier is eliminated** in a circular fashion.

---

## 📌 Problem Description

Given `N` soldiers standing in a circle, numbered from `1` to `N`:

- Starting from the 1st soldier, **every second soldier is executed**.
- The process continues **clockwise** until **only one soldier remains**.
- You must **determine the position of this lucky survivor**.

---

## 📥 Input Format

A single integer:

Where `1 ≤ N ≤ 10⁹`

---

## 📤 Output Format

A single integer:

The position of the lucky soldier who is not executed.

---

## ✅ Sample Input

## 🎯 Sample Output

---

## 💡 Explanation

For `N = 4`, the elimination order is:
- Eliminate 2 → Remaining: [1, 3, 4]
- Eliminate 4 → Remaining: [1, 3]
- Eliminate 3 → Remaining: [1]

Position `1` survives.

---

## 🧠 Approach (Using Power of 2)

For this specific version (k = 2), the position of the last remaining person can be calculated in **O(log N)** time using:


This works because the Josephus problem with step size 2 follows a binary pattern.

---

## 💻 Java Code

```java
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int m = 0;
        int i = 0;

        // Find the largest power of 2 less than or equal to n
        while (Math.pow(2, i) < n) {
            m = (int)Math.pow(2, i++);
        }

        int r = n - m;
        System.out.println(r * 2 + 1);
    }
}
