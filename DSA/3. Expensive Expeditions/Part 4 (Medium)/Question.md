# Part 4

The adventurers come across a valley of valuable land they can excavate to dig treasure. The adventurers want to dig up the most valuable pieces of land, but they can only choose land n x n area.
Given the size of the allowed bounds n and a 2D integer array m, find the most valuable area such that:

- The area must be n x n.
- The square cannot go out of bounds (You have to claim n x n land).

Return a 2D array of the coordinates of the top-left corner and bottom-right corners of the area claimed.

## Contraints

- 1 <= n <= 20
- 1 <= m.length <= 20
- 1 <= m[i].length <= 20
- -100 <= m[i][j] <= 100

## Case 1

Input:

- n = 5
- m = [
  [1, -1, 1, 1, 1, 1],
  [3, 0, -4, 4, 4, 2],
  [1, 0, 1, 1, 1, 1],
  [1, 0, 0, 0, 0, -2],
  [0, 1, 0, 1, -1, 1],
  [1, 2, -4, 1, 1, 1]
]

Output:

- [[0, 0], [4, 4]]

## Submission

Write your answer in the Solution class, and run the main file / class to test.

Judge file contains the solution. Try challenging yourself before looking if you cannot get it.
