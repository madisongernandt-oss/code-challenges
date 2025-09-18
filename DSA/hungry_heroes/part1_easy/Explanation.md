# Hungry Heroes Part 1

## Topics

- Hash Map
- String
- Array

## Question

You oversee a group of adventurers. The adventurers plan to stay in the area for a while so they set up a base. They decide to split the food into categories of Pork, Beef, Chicken, Grain, Fruit, and Vegetable. Given a string array of stock *stock*, return each food item and amount.

## Optimal Approach

One of the earliest data structures we learn is the hash map, and it is used pretty much everywhere in programming. It is a data structure that allows us to store key-value pairs, with the benefits of fast insertion, deletion, and lookup.

To answer this problem, we can simply use a hash map to store the food item as the key, and the amount as the value.

We iterate through the stock array, and add the food item and amount to the hash map.

We then return the hash map as an array of strings, with the food item and amount.

## Complexity

- Time Complexity: O(n)
- Space Complexity: O(n)

## Code

```java
Map<String, Integer> foods = new HashMap<>();
for(String s : stock) { // O(n)
    foods.put(s, foods.getOrDefault(s, 0) + 1);
}
List<String> result = new ArrayList<>();
for(Map.Entry<String, Integer> entry : foods.entrySet()) { // O(n)
    result.add(entry.getKey());
    result.add(entry.getValue().toString());
}

// O(n) + O(n) = O(2n) which is just O(n)

return result.toArray(new String[0]);

```

Output:

```bash
["Beef", "2", "Chicken", "1", "Pork", "1", "Vegetable", "3", "Grain", "1"]
```
