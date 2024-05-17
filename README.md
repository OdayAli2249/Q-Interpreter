# Q Interpreter: A JavaCC-Based Language Interpreter

## Description

The Q Interpreter is a Java-based project developed using JavaCC, aimed at interpreting the Q programming language (my made up programming language :-) ). This project provides a parser capable of understanding Q code through the utilization of tokens and grammars defined in a `.jj` file. JavaCC then generates a set of files that serve as the lexical and syntax analyzers, constructing a parse tree from the input code.

At its core, the Q Interpreter converts Q code into Java programs. This conversion process involves utilizing the generated parser to construct a parse tree, where each node represents a language construct such as statements, conditions, loops, or functions. The parse tree is composed of Java objects of the `TreeNode` class, an abstract class containing a list of children nodes and an abstract `execute` function that leverages the current context to execute the corresponding node.

The development of the Q Interpreter involved defining context-free grammars in the `.jj` file, where JavaCC facilitates the inclusion of code during the parsing process. This is where the construction of tree nodes takes place, ensuring the representation of Q code in the form of a parse tree.

### Flow Chart
![Flow Chart](images/chart.png)

As I reflect on this project, I recognize its significance in my journey as a programmer. It stands as a testament to my curiosity and determination to understand the intricacies of compiler design and language interpretation. Through the Q Interpreter, I not only explored the depths of compiler theory but also honed my abilities in software development and problem-solving.

What makes the Q programming language special is its foundation in exploration and understanding of how programming languages function. In addition, I intentionally designed Q with very concise tokens, drawing inspiration from Python, to minimize the need for excessive typing when forming programs. This design choice aims to create an easy-to-use programming language, making it accessible to both novice and experienced programmers alike. By combining simplicity with the principles of language design and interpretation, Q offers a unique platform for experimentation and learning in the realm of programming language development.

### Output
![Output](images/output.png)
Q interpreter support recursion functions! above is a screenshot of defining and testing Fibonacci sequence function.
