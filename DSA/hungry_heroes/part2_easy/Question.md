# Part 2

An adventurer decides to keep track of their satisfaction each day. This adventurer has a preference for certain foods. Given a liked food gives 2 satisfaction, neutral food is 1 satisfaction, disliked food is 0.5 satisfaction. The adventurer plans on picking ranges of days to check their satisfaction. Given a string array of foods consumed *c*, a string array of preferences *p*, and a list of queries *q*, where each query is a 2-sized array *[start, end]*, return the total satisfaction for each query.

## Contraints

- 1 <= *c.length* <= 10^5
- *p.length* = 12 (Food, Satisfaction, repeating)
- 1 <= *q.length* <= 5000
- 0 <= *q[i][0]* < *q[i][1]* <= c.length - 1

## Case 1

Input:

- c = ["Beef", "Beef", "Chicken", "Pork", "Vegetable", "Grain", "Vegetable", "Vegetable"]
- p = ["Beef", "2", "Chicken", "1", "Pork", "2", "Vegetable", "0.5", "Grain", "1", "Fruit", "0.5"]
- q = [[1, 3], [0, 4], [2, 6]]

Output:

- [5.0, 7.5, 5.0]

## Case 2

Input:

- c = ["Fruit", "Beef", "Vegetable"]
- p = ["Beef", "2", "Chicken", "1", "Pork", "2", "Vegetable", "0.5", "Grain", "1", "Fruit", "0.5"]
- q = [[0, 2]]

Output:

- [3.0]

## Submission

Write your answer in the Solution class, and run the main file / class to test.

Judge file contains the solution. Try challenging yourself before looking if you cannot get it.
