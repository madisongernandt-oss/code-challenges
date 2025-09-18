# Part 5

The adventurers have made several bases throughout their travels.
They have decided to make this base their hub and want all their previous bases to lead it.
The base’s paths are one-way and they want to know which paths to fix. They want to fix the least amount of paths possible.
Given a 2D array *paths* of 2 sized arrays that represent [to, from] and the number of nodes *n*, return the minimum number of paths to fix.
The base is the number 0.

## Contraints

- 1 <= *n.length* <= 1000
- 0 <= *n[i][0]* <= 1000
- 0 <= *n[i][1]* <= 1000

It is guaranteed that there will be at least one path to the base.
It is also guaranteed that a solution exists for each test case.

## Case 1

Input:

```js
n = [[2, 1], [0, 1], [1, 3], [5, 3], [2, 4], [3, 6]]
```

Output:

```js
2
```

## Submission

Write your answer in the Solution class, and run the main file / class to test.

Judge file contains the solution. Try challenging yourself before looking if you cannot get it.
