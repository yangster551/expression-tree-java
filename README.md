# Expression Tree (Java)

This project implements an expression tree in Java. It converts infix expressions to postfix notation, builds a binary expression tree, and outputs the expression in prefix, infix, and postfix forms.

## Features
- Converts infix expressions to postfix using a stack-based algorithm
- Builds a binary expression tree from postfix input
- Traverses the tree to generate:
  - Prefix (preorder)
  - Infix (inorder with parentheses)
  - Postfix (postorder)
- Supports basic arithmetic operators (+, -, *, /, ^)

## Concepts Used
- Stacks
- Binary trees
- Recursion
- Expression parsing
- Tree traversal algorithms

## Files
- `ExpressionTree.java` – builds and manages the expression tree
- `Converter.java` – converts infix expressions to postfix
- `ParserHelper.java` – handles tokenizing input expressions
- `ArrayStack.java` / `LinkedStack.java` – stack implementation
- `Main.java` – runs the program and handles user input

## How to Run
Compile all Java files:
```bash
javac *.java
