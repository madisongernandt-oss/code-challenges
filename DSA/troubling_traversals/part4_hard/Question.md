# Part 4

The party of adventurers are back trying to navigate through a forest. This time, monsters have run rampant around the forest. They use a recon bird to get an overview of each exit.
The adventurers are fine with battling monsters, but it will cost the equivalence of 2 spaces to deal with.
You are tasked with finding the shortest path to an exit given the rules:

- You can only move up, down, left, right
- You cannot move through trees (1s)
- You can move through monsters (4s) but it will cost the equivalence of 2 moves.

Given an 2D integer array *f* that has 0 as an open path, 1 as a tree, and 2 as a valid exit, 3 as the start, and 4 as a monster, return the coordinates of the shortest path to an exit as a string.

## Contraints

- 1 <= *f.length* <= 100
- 1 <= *f[i].length* <= 100

## Case 1

Input:

```js
forest = [
  [1, 1, 1, 1, 1, 1],
  [3, 0, 4, 4, 4, 2],
  [1, 0, 1, 1, 1, 1],
  [1, 0, 0, 0, 0, 2],
  [0, 1, 0, 1, 1, 1],
  [1, 2, 4, 1, 1, 1]
]
```

Output:

```js
[3, 5]
```

## Submission

Write your answer in the Solution class, and run the main file / class to test.

Judge file contains the solution. Try challenging yourself before looking if you cannot get it.

## Follow up

Can you do this in one search?
