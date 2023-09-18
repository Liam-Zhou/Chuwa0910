## 1.	What is the checked exception and unchecked exception in Java, could you give one example?


Checked Exceptions: These are exceptions that the Java compiler requires you to either catch (handle) or declare (propagate) in your code.
They are usually used for situations where recovery is possible, and you should handle them explicitly. Example :

![sample1](https://github.com/Liam-Zhou/Chuwa0910/assets/70967683/bc78118d-0505-45be-a051-9b93ee5eb33e)

Unchecked Exceptions (Runtime Exceptions): These are exceptions that the compiler does not require you to catch or declare. 
They typically indicate programming errors or conditions that are not recoverable. Examples include NullPointerException and ArrayIndexOutOfBoundsException

![sample2](https://github.com/Liam-Zhou/Chuwa0910/assets/70967683/00136bc4-57cc-4624-abb2-0480b84001f8)

## 2.	Can there be multiple finally blocks?

Yes, you can have multiple finally blocks in a try-catch-finally construct. They will be executed in the order in which they appear, from top to bottom.

## 3.	When both catch and finally return values, what will be the final result?

If both the catch block and the finally block return values, the value returned by the finally block will take precedence.
The value returned by the catch block will be ignored.
   
## 4.	What is Runtime/unchecked exception? what is Compile/Checked Exception?

Runtime/Unchecked Exception: These are exceptions that are not checked at compile-time but can occur at runtime. 
They typically indicate issues in the code logic or unexpected situations. You do not have to catch or declare them explicitly. 
Examples include NullPointerException, ArithmeticException, and IllegalArgumentException.

Compile/Checked Exception: These are exceptions that the Java compiler requires you to either catch or declare in your code. 
They typically represent external factors or operations that may go wrong and should be handled gracefully.
Examples include IOException, SQLException, and ClassNotFoundException

## 5.	What is the difference between throw and throws?

throw: It is used to explicitly throw an exception in your code. You use the throw keyword followed by an exception object to raise an exception.
For example:

`throw new CustomException("This is a custom exception");`

throws: It is used in the method signature to declare that a method might throw a particular type of exception. 
It doesn't throw the exception itself but informs the caller that the method may throw that exception. For example:

`public void myMethod() throws IOException { // Method code that might throw an IOException }`
