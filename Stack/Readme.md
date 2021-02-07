## Check for Balanced Brackets in an expression (well-formedness) using Stack

Algorithm: 

1. Declare a character stack S.
2. Now traverse the expression string exp. 

    a) If the current character is a starting bracket (‘(‘ or ‘{‘ or ‘[‘) then push it to stack.

    b) If the current character is a closing bracket (‘)’ or ‘}’ or ‘]’) then pop from stack and if the popped character is the matching starting bracket then fine else brackets are not balanced.
3. After complete traversal, if there is some starting bracket left in stack then “not balanced”

Time Complexity: O(n) 

Auxiliary Space: O(n) for stack.

![image](https://user-images.githubusercontent.com/51791113/99537745-11985900-29d2-11eb-9ba5-a2918aaffafb.png)


## Infix to Postfix

Infix expression:The expression of the form a op b. When an operator is in-between every pair of operands.

Postfix expression:The expression of the form a b op. When an operator is followed for every pair of operands.

Why postfix representation of the expression?

The compiler scans the expression either from left to right or from right to left. 
Consider the below expression: a op1 b op2 c op3 d 
If op1 = +, op2 = *, op3 = +

The compiler first scans the expression to evaluate the expression b * c, then again scan the expression to add a to it. The result is then added to d after another scan.

The repeated scanning makes it very in-efficient. It is better to convert the expression to postfix(or prefix) form before evaluation.

The corresponding expression in postfix form is: abc*+d+. The postfix expressions can be evaluated easily using a stack. We will cover postfix expression evaluation in a separate post.

Algorithm 
1. Scan the infix expression from left to right. 
2. If the scanned character is an operand, output it. 
3. Else, 
      1 If the precedence of the scanned operator is greater than the precedence of the operator in the stack(or the stack is empty           or the stack contains a ‘(‘ ), push it. 
      2 Else, Pop all the operators from the stack which are greater than or equal to in precedence than that of the scanned operator. After doing that Push the scanned operator to the stack. (If you encounter parenthesis while popping then stop there and push the scanned operator in the stack.) 
4. If the scanned character is an ‘(‘, push it to the stack. 
5. If the scanned character is an ‘)’, pop the stack and and output it until a ‘(‘ is encountered, and discard both the parenthesis. 
6. Repeat steps 2-6 until infix expression is scanned. 
7. Print the output 
8. Pop and output from the stack until it is not empty.

## Infix to Prefix

To convert an infix to postfix expression -

Step 1: Reverse the infix expression i.e A+B\*C will become C*B+A. Note while reversing each ‘(‘ will become ‘)’ and each ‘)’ becomes ‘(‘.

Step 2: Obtain the postfix expression of the modified expression i.e CB*A+.

Step 3: Reverse the postfix expression. Hence in our example prefix is +A*BC. 

## Reverse a stack using recursion

In this solution, we need two recursive functions. reverse() and insert_at_bottom().

reverse() – this function will be called by the driver. In this function, Pop the element from the stack make a recursive call to reverse() till the stack is not empty. This will put all the popped elements in the function stack, and our stack will be empty, in tail recursion insert all these popped elements at the bottom of the stack, one after another using insert_at_bottom().

insert_at_bottom() – This function is called with element passed as a parameter and objective of this function to insert the element at the bottom of the stack. If stack is empty, just push the element and if stack is not empty then pop the top element and make a recursive call to insert_at_bottom(), this will pop out all the elements to the function stack and our stack will be empty so that element (passed as parameter) will be pushed to the empty stack and after that all the earlier popped element will be pushed back on top of that.

![image](https://user-images.githubusercontent.com/51791113/99542876-8a021880-29d8-11eb-893e-b567df33ce15.png)

As you can see the insert_at_bottom() is called 4 times, once for each element. insert_at_bottom() itself is a recursive function. Let’s see what is happening inside the function for one instance. insert_at_bottom(4) is the last time this function was called and produced our final result as well. let’s take a look inside. 

![image](https://user-images.githubusercontent.com/51791113/99543003-ad2cc800-29d8-11eb-8334-3b7cda04329f.png)


## Postfix to Infix
Algorithm

1. While there are input symbol left, Read the next symbol from the input.
2. If the symbol is an operand, Push it onto the stack.
3. Otherwise,

        -> the symbol is an operator.
        -> Pop the top 2 values from the stack.
        -> Put the operator, with the values as arguments and form a string.
        -> Push the resulted string back to stack.
4. If there is only one value in the stack
     That value in the stack is the desired infix string.

## Postfix to Prefix Conversion

Read the Postfix expression from left to right
If the symbol is an operand, then push it onto the Stack
If the symbol is an operator, then pop two operands from the Stack 
Create a string by concatenating the two operands and the operator before them. 
string = operator + operand2 + operand1 
And push the resultant string back to Stack
Repeat the above steps until end of Prefix expression.

## Next Greater Element

1. Push the first element to stack.
2. Pick rest of the elements one by one and follow the following steps in loop.

        -> Mark the current element as next.
        -> If stack is not empty, compare top element of stack with next.
        -> If next is greater than the top element,Pop element from stack. next is the next greater element for the popped element.
        -> Keep popping from the stack while the popped element is smaller than next. next becomes the next greater element for all such popped elements

3. Finally, push the next in the stack.
4. After the loop in step 2 is over, pop all the elements from stack and print -1 as next element for them.

![image](https://media.geeksforgeeks.org/wp-content/cdn-uploads/20190626132057/NextGreaterElement.png)

## Sort a Stack using temporary stack

We follow this algorithm.

1. Create a temporary stack say tmpStack.

2. While input stack is NOT empty do this:
        
        * Pop an element from input stack call it temp
        * while temporary stack is NOT empty and top of temporary stack is greater than temp,
        * pop from temporary stack and push it to the input stack
        * push temp in temporary stack
3. The sorted numbers are in tmpStack

Here is a dry run of above pseudo code.

        input: [34, 3, 31, 98, 92, 23]

        Element taken out: 23
        input: [34, 3, 31, 98, 92]
        tmpStack: [23]

        Element taken out: 92
        input: [34, 3, 31, 98]
        tmpStack: [23, 92]

        Element taken out: 98
        input: [34, 3, 31]
        tmpStack: [23, 92, 98]

        Element taken out: 31
        input: [34, 3, 98, 92]
        tmpStack: [23, 31]

        Element taken out: 92
        input: [34, 3, 98]
        tmpStack: [23, 31, 92]

        Element taken out: 98
        input: [34, 3]
        tmpStack: [23, 31, 92, 98]

        Element taken out: 3
        input: [34, 98, 92, 31, 23]
        tmpStack: [3]

        Element taken out: 23
        input: [34, 98, 92, 31]
        tmpStack: [3, 23]

        Element taken out: 31
        input: [34, 98, 92]
        tmpStack: [3, 23, 31]

        Element taken out: 92
        input: [34, 98]
        tmpStack: [3, 23, 31, 92]

        Element taken out: 98
        input: [34]
        tmpStack: [3, 23, 31, 92, 98]

        Element taken out: 34
        input: [98, 92]
        tmpStack: [3, 23, 31, 34]

        Element taken out: 92
        input: [98]
        tmpStack: [3, 23, 31, 34, 92]

        Element taken out: 98
        input: []
        tmpStack: [3, 23, 31, 34, 92, 98]

        final sorted list: [3, 23, 31, 34, 92, 98]