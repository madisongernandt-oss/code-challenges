# Expensive Expeditions Part 1 Explanation

## Topics

- Array
- Sorting
- HashMap

## Question

The adventurers want to visit places of interest. They wish to visit the highest value locations first.
Given an integer array of places *p*, modify the array in-place so that the adventurers can visit the high value locations first. Do not use a built-in sorting algorithm.

## Approach

This questing is a sorting problem, and since we cannot use a built-in sorting algorithm, we need to implement our own.

You can do this in many ways, but I will go over how to solve it using Counting Sort with an integer array of size 101.
Why size 101? Well, the problem statement says that the values in the array are between 0 and 100, so an array of size 101 is more than enough to store all the values.

Counting Sort is a sorting algorithm that works by counting the frequency of each value in the array. You can do this with an integer array.

Counting Sort can be viewed [here](https://www.w3schools.com/dsa/dsa_algo_countingsort.php).

Once you count the frequency of each value, you can iterate through the array and place the values in the array in descending order.

You can also do this with a HashMap, but it can be slower than using an integer array since values are between 0 and 100.

## Complexity

- Time Complexity: O(n)  
Where n is the length of the places array.

- Space Complexity: O(1)
We are using an integer array of size 101, which is a constant space.

## Code

```java
int[] count = new int[101];

for (int num : p) {
    count[num]++;
}

int index = 0;
for(int value = 100; value >= 0; value--) {
    while(count[value] > 0) {
        p[index++] = value;
        count[value]--;
    }
}

return p;
```

Input:

```java
p = [0,1,2,5,2,10,30,4,7,0,0,0,1]
```

Output:

```bash
[30,10,7,5,4,2,2,1,1,0,0,0,0]
```
