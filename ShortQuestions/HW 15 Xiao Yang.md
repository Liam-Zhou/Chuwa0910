# HW 15 Xiao Yang

### 1. List all of the new learned annotations to your annotations.md
[annotations.md](./annotations.md)

### 2. What is selenium?

Selenium is a popular and widely used open-source framework and browser automation tool that is primarily used for automating web applications for testing purposes. It allows you to automate interactions with a web browser, such as clicking buttons, filling out forms, and navigating between pages, just like a human user would do. Selenium is commonly used in software testing to perform regression testing of web applications, where it ensures that the functionality of a web application remains consistent as changes are made to the code.

### 3.  What is cucumber?

Cucumber is a popular open-source tool that supports Behavior-Driven Development (BDD) and is often used in software testing and automated testing of web applications. It is primarily used for creating and running automated acceptance tests written in a human-readable, plain text format called Gherkin. Gherkin is a domain-specific language that uses keywords like "Given," "When," and "Then" to describe the behavior of a system in a structured and understandable manner. 

### 4.  What is JMeter?

JMeter is widely used to simulate a variety of scenarios, including high levels of concurrent users, network loads, or stress testing to assess the performance and stability of web servers, databases, and other services.

1. **Protocol Support:** JMeter supports a wide range of network protocols, making it versatile for testing different types of applications, including HTTP, HTTPS, FTP, JDBC, LDAP, SOAP, REST, and more.
2. **User-Friendly GUI:** JMeter provides a user-friendly graphical interface that allows testers to create and configure test plans and scenarios. Testers can define test scripts and scenarios by adding elements and configuring various settings through the GUI.
3. **Scripting and Recording:** JMeter allows for the creation of test scripts manually or through the recording of user interactions with a web application. This helps automate the testing process and mimic user behavior.
4. **Distributed Testing:** JMeter supports distributed testing, which enables running tests from multiple machines simultaneously to simulate a large number of virtual users or test scenarios. This is crucial for assessing the scalability and performance of a system.
5. **Assertions:** JMeter provides various assertions to validate the correctness of server responses, ensuring that the application behaves as expected during testing.
6. **Reporting:** JMeter generates comprehensive test reports that include response times, throughput, error rates, and other metrics. These reports help testers and developers analyze and diagnose performance issues.
7. **Integration:** JMeter can be integrated with other tools and frameworks, such as Jenkins, to automate test execution as part of the Continuous Integration (CI) or Continuous Delivery (CD) pipeline.
8. **Extensibility:** JMeter is extensible through plugins and supports the development of custom components to enhance its capabilities.

### 5.  What is the lifecycles of Junit?

**Test Class Initialization**: Before running any test methods, JUnit initializes the test class. This phase typically involves setting up resources and objects that are shared by multiple test methods within the same test class. JUnit executes methods annotated with `@BeforeAll` once before any test method in the class. This is where you might set up database connections, create test data, or initialize other shared resources.

```java
@BeforeAll
public static void setUpClass() {
    // Perform one-time setup for the entire test class
}
```

**Test Method Initialization**: JUnit initializes each test method individually. This phase involves preparing the environment for the specific test method. Methods annotated with `@BeforeEach` are executed before each test method.

```java
@BeforeEach
public void setUp() {
    // Set up test-specific resources before each test method
}
```

**Test Method Execution**: JUnit runs the test methods, which are annotated with `@Test`, to perform the actual testing. The test methods contain assertions to verify that the code under test behaves as expected.

```java
@Test
public void testSomething() {
    // Perform test-specific actions and assertions
}
```

**Test Method Cleanup**: After each test method completes, methods annotated with `@AfterEach` are executed. This is where you can release resources or perform cleanup.

```java
@AfterEach
public void tearDown() {
    // Clean up resources after each test method
}
```

**Test Class Cleanup**: Once all test methods have been executed, JUnit performs cleanup at the test class level. Methods annotated with `@AfterAll` are executed to release resources and perform any necessary cleanup.

```java
@AfterAll
public static void tearDownClass() {
    // Perform one-time cleanup for the entire test class
}
```



### 6.  Is @BeforeAll method should be Class level(static)?

Yes, `@BeforeAll`  is used to designate a method that will be executed once before any test methods in the test class. It's meant for setting up resources or performing one-time initialization that is shared among all test methods in the class.

### 7.  What is Mockito? and what is its limitations?  what kind of tools can give help?

Mockito is a popular and widely used Java framework for creating and working with mock objects in unit testing. Mock objects are simulated or fake objects that imitate the behavior of real objects. They are used in unit testing to isolate the code under test and verify its interactions with dependencies, such as other classes or components, without actually invoking the real implementations of those dependencies.

The most limitation for Mockito is that it cannot mock final and static classes or methods. 

PowerMock is an extension to Mockito that allows you to mock final classes, static methods, and other constructs that Mockito cannot handle.



### 8.  What is @Mock and what is @InjectMocks?

**@Mock:**

- `@Mock` is used to annotate fields that represent mock objects.

- Mock objects are used to simulate the behavior of dependencies or collaborators of the code under test.

- When a field is annotated with `@Mock`, Mockito initializes a mock object for that field.

- You use `@Mock` to create mocks of the classes or interfaces that your tested code interacts with. Mocks allow you to control the behavior and verify interactions without invoking the actual methods of those dependencies.

  Example:

  ```java
  @Mock
  private DependencyClass dependency;
  ```

  ​

**@InjectMocks:**

- `@InjectMocks` is used to annotate the field of the class that you want to test, which will be the target of your unit test.

- When a field is annotated with `@InjectMocks`, Mockito attempts to inject the mocked dependencies (fields annotated with `@Mock`) into the test class.

- This helps in achieving the "injecting mocks" part of the unit test, making sure that the code under test interacts with the mocked dependencies.

  Example:

  ```java
  @InjectMocks
  private ClassUnderTest classUnderTest;
  ```

  Given the above example, Mockito will attempt to inject the `dependency` mock object into the `classUnderTest` object so that when you test `classUnderTest`, it will use the mocked `dependency`.

### 9.  What is the stubbing (define behaviors)?

Stubbing, in the context of testing and mocking, refers to the process of defining the expected behavior of a mock object or a stub. 

The main goals of stubbing are as follows:

1. **Define Return Values:** You specify what a mocked method should return when it is called. This allows you to simulate the behavior of a real object without invoking the actual method. For example, you can stub a database access method to return specific data without actually hitting the database.

2. **Define Exceptions:** You can specify that a mocked method should throw a specific exception when called. This allows you to test how your code handles exceptional situations without having to trigger those exceptions in a real environment.

3. **Verify Method Calls:** You can also use stubbing to verify that specific methods on the mock object are called with the expected arguments. This is useful for ensuring that your code interacts with its dependencies as intended.

   Example:

```java
// Create a mock object
MyClass myMock = mock(MyClass.class);

// Stubbing: Define the behavior of the mocked method
when(myMock.someMethod()).thenReturn("Mocked Result");

// Now, when you call someMethod on myMock, it will return "Mocked Result"
String result = myMock.someMethod();
```



### 10.  What is Mockito ArgumentMatchers

Mockito ArgumentMatchers are a set of powerful utilities provided by the Mockito framework in Java for defining flexible and expressive argument matching when working with mock objects. When you create a mock object, you often need to specify how it should behave when specific arguments are passed to its methods. ArgumentMatchers help you define these expectations in a more flexible and dynamic way.

Here are some commonly used Mockito ArgumentMatchers:

- `any()`: Matches any argument of the expected type. For example, `any(String.class)` matches any String argument.

- `eq(value)`: Matches the argument that is equal to the provided value.

- `isA(type)`: Matches an argument that is an instance of the given type.

- `isNull()`: Matches a `null` argument.

- `isNotNull()`: Matches a non-`null` argument.

- `anyInt()`, `anyString()`, `anyDouble()`: Specific matchers for primitive types or common types.

  Example:

  ```java
  import static org.mockito.Mockito.*;

  // Create a mock object
  @Mock
  MyClass myMock;

  // Define behavior for a method with ArgumentMatchers
  when(myMock.someMethod(ArgumentMatchers.anyInt(), eq("Test"))).thenReturn("Mocked Result");

  // Perform a test
  String result = myMock.someMethod(42, "Test");

  // Verify that the method was called with the expected arguments
  verify(myMock).someMethod(ArgumentMatchers.anyInt(), eq("Test"));

  ```

  ​

### 11.  What is Hamcrest Matchers

Hamcrest is a framework for writing matchers in Java that allow you to create more expressive and readable assertions in your unit tests.

The key features and benefits of Hamcrest matchers are as follows:

1. **Expressive Assertions:** Hamcrest allows you to create assertions that read like natural language. This makes your test cases more understandable and self-explanatory.

2. **Custom Matchers:** You can create your own custom matchers to suit the specific needs of your test cases. This allows you to write assertions that are closely aligned with your application's domain and requirements.

3. **Integration with Testing Frameworks:** Hamcrest is commonly used with popular Java testing frameworks like JUnit, TestNG, and others. Many of these frameworks have built-in support for Hamcrest matchers, making it easy to incorporate them into your test suites.

4. **Combining Matchers:** Hamcrest provides various combinators, such as `allOf`, `anyOf`, and `not`, which allow you to create complex assertions by combining multiple matchers.

5. **Type Safety:** Hamcrest matchers are type-safe, which helps prevent common mistakes in your assertions. If you attempt to use a matcher with an incompatible type, you'll get a compilation error.

   Example:

   ```java
   import static org.hamcrest.MatcherAssert.assertThat;
   import static org.hamcrest.Matchers.*;
   import org.junit.Test;

   public class MyTest {

       @Test
       public void testExample() {
           int value = 42;

           // Using Hamcrest matchers to make an assertion
           assertThat(value, is(equalTo(42)));
           assertThat(value, greaterThan(30));
           assertThat("Hello, World", containsString("World"));
       }
   }
   ```

### 12.  Do you know @spy? what is difference between @spy and @Mock?

`@Spy` is an annotation used to create partially mocked objects, whereas `@Mock` is used to create fully mocked (pure mock) objects. The key difference between them lies in how they handle method invocations on the original object.

When you use `@Spy`, the object is partially mocked. The original methods of the object are invoked by default, and you can selectively mock or stub specific methods. While for `@Mock` object, it would throw exceptions or return null if there is no definition for any methods used in the original objects.

### 13.  What is assertion?

In JUnit, assertions are a fundamental component used to verify the correctness of your test cases by checking whether the actual results match the expected results. 

JUnit provides a range of assertion methods that cover various data types and scenarios. Some of the commonly used JUnit assertion methods include:

1. `assertEquals(expected, actual)`: Compares if the `expected` value is equal to the `actual` value. This is often used to check the equality of values.
2. `assertNotEquals(expected, actual)`: Verifies that the `expected` value is not equal to the `actual` value.
3. `assertTrue(condition)`: Asserts that the given `condition` is true.
4. `assertFalse(condition)`: Asserts that the given `condition` is false.
5. `assertNull(object)`: Verifies that the given `object` is null.
6. `assertNotNull(object)`: Ensures that the given `object` is not null.
7. `assertSame(expected, actual)`: Checks that `expected` and `actual` refer to the exact same object.
8. `assertNotSame(unexpected, actual)`: Asserts that `unexpected` and `actual` do not refer to the same object.
9. `assertArrayEquals(expectedArray, actualArray)`: Compares two arrays for equality element by element.
10. `assertThrows(expectedException, executable)`: Verifies that an exception of the specified type is thrown when the `executable` code block is executed.

### 14.  If you have developed a new feature, how many types of tests for this feature?and what kind of tests are written by you? What is the purpose of each type of tests?

First of all, it needs a `unit test` for checking the basic functionalities of the new features. 

Secondly, `Integration test` is also needed to verify that the new features works correctly when combined with other components or modules.

Third, `Regression test` should run to check that if the existing functionality that could be impacted by the new features.

Fourth, `User Inteface Test` focus on the UI related to the new features.

Fifth, `Performance test(Stress test)` to measures response times, resource consumption, and scalability of the feature.

Finally, `User Acceptance Test` to ensure that the feature meet all expectations from users.

### 15.  Add unit test for CommentServiceImpl, the coverage should be 100%.
[CommentServiceImplTest.java](../Coding/coding7/CommentServiceImplTest.java)
### 16.  Write Integration tests for PostController. The tests should cover all scenarios.

