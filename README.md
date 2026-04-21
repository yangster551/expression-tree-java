# Expression Tree (Java)

This project implements an expression tree in Java. It converts infix expressions to postfix notation, builds a binary expression tree, and outputs the expression in prefix, infix, and postfix forms.

## Features
- Converts infix expressions to postfix using a stack-based algorithm
- Builds a binary expression tree from postfix input
- Traverses the tree to generate prefix, infix, and postfix expressions
- Supports basic arithmetic operators such as +, -, *, /, and ^

## Concepts Used
- Stacks
- Binary trees
- Recursion
- Expression parsing
- Tree traversal algorithms

## Files
- `ExpressionTree.java` – builds and manages the expression tree
- `Converter.java` – converts infix expressions to postfix
- `ParserHelper.java` – parses input expressions into tokens
- `ArrayStack.java` – stack implementation used in conversion
- `Stack.java` – stack interface
- `Main.java` – runs the program and handles user input

## How to Run
Compile all Java files:
```bash
javac *.java
