# Part 1

The party of adventurers are trying to navigate through land. The land has different elevations, and the adventurers are wondering if it’s possible to cross. It is possible to cross if the absolute difference in elevations between the current elevation and the next elevation is smaller than or equal to the current elevation and the next elevation. Given a double array of heights *h*, return a boolean if it’s possible to cross.

## Contraints

- 1 <= *h.length* <= 10^9
- 0 <= *h[i]* <= 10^9

## Case 1

Input:

- h = [5, 3, 6, 4, 2, 3]

Output:

- true

## Case 2

Input:

- h = [1, 2, 4, 8, 16, 32]

Output:

- true

## Case 3

Input:

- h = [1, 2, 8, 5, 4, 10]

Output:

- false

## Submission

Write your answer in the Solution class, and run the main file / class to test.

Judge file contains the solution. Try challenging yourself before looking if you cannot get it.
