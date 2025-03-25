# Part 3

The adventurers are on a journey and need to share the food available in their stock to ensure everyone gets the satisfaction they need.
Each adventurer has a set of preferences for different types of food, and their satisfaction depends on how much they like or dislike the food.
You are tasked with finding an optimal distribution of the food from the available stock to the adventurers such that:

- Each adventurer gets at least the minimum required satisfaction.
- The food distribution is within the available stock for each food item.
- The distribution should maximize the total satisfaction for each adventurer.

Given a liked food gives 2 satisfaction, neutral food is 1 satisfaction, disliked food is 0.5 satisfaction. Given a String array of stock *s* which contain food items and their amounts, a 2D array of preferences *p*, and an integer array of satisfaction requirements *r*, return the maximum total satisfaction for all adventurers in a 4 length integer array.

## Contraints

- 2 <= *s.length* <= 12, you may assume that the stock is always valid
- *p.length* = 12, you may assume that the preferences are always valid
- *r.length* = 4
- 1 <= *r[i]* <= 30

## Case 1

Input:

- s = ["Beef", "2", "Chicken", "1", "Pork", "1", "Vegetable", "3", "Grain", "1"]
- p = [
        ["Beef", "2", "Chicken", "1", "Pork", "2", "Vegetable", "0.5", "Grain", "1", "Fruit", "0.5"],
        ["Beef", "0.5", "Chicken", "1", "Pork", "0.5", "Vegetable", "2", "Grain", "1", "Fruit", "2"],
        ["Beef", "2", "Chicken", "2", "Pork", "0.5", "Vegetable", "1", "Grain", "0.5", "Fruit", "1"],
        ["Beef", "1", "Chicken", "2", "Pork", "2", "Vegetable", "0.5", "Grain", "1", "Fruit", "1"],
    ]
- r = [2, 2, 2, 2]
