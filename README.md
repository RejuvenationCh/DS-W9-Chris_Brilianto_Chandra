# DS-W9-Chris_Brilianto_Chandra

## The Root Node in the Program
The main root node is "Start Build" and it is used primarily for the starting node, before the main item is  even selected. Primarily for helping to act as a library, if i were to make the main root as userinput, the main program will lose its ability to find the item. 

## Which nodes are leaf nodes?
The main leafs node are the smallest item to buy, which include
> Dagger, Knife, Expert Glove, Hero's Ring, Javelin, Vitality Crystal, Magic necklace, Vampire Mallet, Iron Hunting Bow, Leather Armor

## Why is children stored as a List<ItemNode> instead of a single variable?
A single variable have one reference, if i for instance want to get Endless Battle (require azure blade, vampire mallet, and ogre tomahawk), everytime i add the recipe it would override itself, making it useless. An item require a few subitems and when an item override the item, its basically useless, and using a single variable wont allow it to branch out to other item as it is very linear, not hierarchical

## What is the difference between a linear structure and a tree structure in this example?
Linear follows a single pathway such as from dagger to legion sword to blade of despair. This wont allow for special branching as it only represent one path. When we use a tree structure, one parent can have alot of children (nodes / smaller item variants)

## How does recursion help when working with trees?
It allows me to just make a singular function, instead of making a nested nested nested nested loop for every branch, one function can help navigate a tree of any size, from a small one with the size of my will to live to a big one, as big as your mom

## What path is printed when searching for Corrosion Scythe?
 Corrosion Scythe -> Attack Speed & Mov Speed Debuff
 - Swift Crossbow -> +20% Attack Speed
    - Knife -> +10% Attack Speed
    - Knife -> +10% Attack Speed
 - Regular Spear -> 20 Physical Attack & 10% Attack Speed
    - Dagger -> +15 Phys Attack
    - Knife -> +10% Attack Speed

## Reflection
Tree is more suitable as it is mainly used for any kind of hierarchy. When we want to make an item in the game, we buy the smaller item and as we get more money, it will then upgrades into some better item and then the final item. Tree is suitable as its main flow is just like that. From a leaf onto a node onto the root. It allows the program to represent any kind of multi layered branches and makes it possible to calculate stuff that a normal array cant map.
All part in the item handling logic helps with understanding recursion as almost every traversal require recursion, without it then the whole thing would be a big spaggetthi code full of nested loops. Even with that, the main problem is still in understanding the logic, especially backtracking and tracing the tree. Tracing it logically might be okay but tracing it per line of code is quite the challange