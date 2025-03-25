# Hungry Heroes Part 2 Explanation

## Topics

- Hash Map
- String
- Array
- Prefix Sum

## Question

An adventurer decides to keep track of their satisfaction each day. This adventurer has a preference for certain foods. Given a liked food gives 2 satisfaction, neutral food is 1 satisfaction, disliked food is 0.5 satisfaction. The adventurer plans on picking ranges of days to check their satisfaction. Given a string array of foods consumed *c*, a string array of preferences *p*, and a list of queries *q*, where each query is a 2-sized array *[start, end]*, return the total satisfaction for each query.

## Naive Approach

In a naive approach, we can iterate through the queries, and for each query, iterate through the range of days, and calculate the satisfaction.

That would solve the problem, but it would be slow in terms of time complexity.

What if you had a query that asked for the satisfaction of the first 1000000 days?
What if a query asks this 1000 times?

It would be too slow, so we need to find a better way.

```java
// Naive Approach
HashMap<String, Double> satisfactionMap = new HashMap<>();
for (int i = 0; i < p.length; i += 2) {
    String food = p[i];
    double satisfaction = Double.parseDouble(p[i + 1]);
    satisfactionMap.put(food, satisfaction);
}

double[] result = new double[q.length];
for (int i = 0; i < q.length; i++) {
    int start = q[i][0];
    int end = q[i][1];
    double sum = 0;
    for (int j = start; j <= end; j++) {
        sum += satisfactionMap.getOrDefault(c[j], 0.0);
    }
    result[i] = sum;
}

return result;

```

## Optimal Approach

In an optimal approach, we can use a prefix sum to calculate the satisfaction for each query. A prefix sum allows us to calculate the sum of a range of numbers in constant time, after some preprocessing.

We first create a HashMap to map each food item to its satisfaction score. This helps quickly look up the satisfaction of each food.

Then, we calculate a prefixSum array. This array holds the cumulative satisfaction up to each day, so we can later calculate the satisfaction for any range using a constant time difference.

And for each query, we can calculate the satisfaction for the range by subtracting the prefix sum of the start from the prefix sum of the end.

Total satisfaction for a query is calculated by:

```math
prefixSum[end + 1] - prefixSum[start]
```

This essentially can be done in O(1) time.

## Complexity

- Time Complexity: O(n + m + q)  
Where n is the length of the food list c, m is the length of the preferences p, and q is the number of queries.

- Space Complexity: O(n + m)  
Where n is the length of the food list c, and m is the length of the preferences p.

## Code

```java
HashMap<String, Double> satisfactionMap = new HashMap<>();
for (int i = 0; i < p.length; i += 2) {
    String food = p[i];
    double satisfaction = Double.parseDouble(p[i + 1]);
    satisfactionMap.put(food, satisfaction);
}

double[] prefixSum = new double[c.length + 1];
for (int i = 0; i < c.length; i++) {
    double satisfaction = satisfactionMap.getOrDefault(c[i], 0.0);
    prefixSum[i + 1] = prefixSum[i] + satisfaction;
}

double[] result = new double[q.length];
for (int i = 0; i < q.length; i++) {
    int start = q[i][0];
    int end = q[i][1];
    result[i] = prefixSum[end + 1] - prefixSum[start];
}

return result;
```

Input:

```java
c = ["Beef", "Beef", "Chicken", "Pork", "Vegetable", "Grain", "Vegetable", "Vegetable"]
p = ["Beef", "2", "Chicken", "1", "Pork", "2", "Vegetable", "0.5", "Grain", "1", "Fruit", "0.5"]
q = [[1, 3], [0, 4], [2, 6]]
```

Output:

```bash
[5.0, 7.5, 5.0]
```
