# Part 3

The party of adventurers are trying to navigate through a forest. They use a recon bird to get an overview of each exit.
You are tasked with finding the shortest path to an exit given the rules:

- You can only move up, down, left, right
- You cannot move through trees (1s)

Given an 2D integer array *f* that has 0 as an open path, 1 as a tree, and 2 as a valid exit, 3 as the start, return the coordinates of the shortest path to an exit as a string.
If no path is found, return an empty string.

## Contraints

- 1 <= *f.length* <= 1000
- 1 <= *f[i].length* <= 1000

## Case 1

Input:

```js
f = [
  [1, 1, 1, 1, 1, 1],
  [3, 0, 1, 1, 0, 2],
  [1, 0, 1, 1, 0, 1],
  [1, 0, 0, 0, 0, 2],
  [2, 0, 0, 1, 1, 1],
  [1, 1, 1, 1, 1, 1]
]
```

Output:

```js
"4,0"
```

## Case 2

Input:

```js
f = [
  [1, 1, 1, 1, 1, 1],
  [1, 1, 1, 1, 1, 1],
  [3, 0, 0, 0, 0, 2],
  [1, 1, 0, 1, 0, 1],
  [1, 0, 0, 0, 0, 2],
  [2, 0, 1, 1, 1, 1],
  [1, 1, 1, 0, 0, 1]
]
```

Output:

```js
"1,5"
```

## Submission

Write your answer in the Solution class, and run the main file / class to test.

Judge file contains the solution. Try challenging yourself before looking if you cannot get it.
