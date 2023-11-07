### 2. Selenium
Selenium is a web driver to directly give command or retrieve information from web broswer. It has the ability to create a java class to simulate a web page behavior.

### 3. cucumber
Cucumber is a tool for Test Driven Development and Behavior Driven Development(encourages collaboration between developers, QA, and non-technical or business participants in a software project). It's written in Gherkin language which is human readble. (like " Given I am on the login page, When I enter valid credentials, Then I should be redirected to the homepages".) If all the steps pass, then the scnario is successful.

### 4. JMeter
JMeter is an app for performance testing and evaluation. It can be used to simulate load on a server, network. 

### 5. JUnit lifecycle
It's used to run automated tests. JUnit uses annotations to simulate the lifecycle of the test. Here's each of them
@BeforeAll: executed before all the test methods in the test class, usually the setup operations that are needed by all tests. 
@BeforeEach: marked the methods to be executed before each individual test method.
@Test: where the actual test code goes. 
@AfterEach: usually used for cleanup operations after each test.
@AfterAll: executed after all test methods.

### 6. 
Yes, @BeforeAll methods must be static. This is because the property of static class that it cannot create an instance of a class, and @BeforeAll runs only once in a test class.

### 7. Mockito
Mockito is used to create mock objects in unit tests. Mock objects can simulate real objects, controlled by Mockito. Mockito would specify return values. Here's an example of using Mockito to verify the size of a list:
```java
//create mock object
List<String> mockedList = mock(List.class);

//define mock object behavior
when(mockedList.size()).thenRetrun(10);

//using the mock object
int size = mockedList.size();

//verify the method is called with the correct arguments.
verify(mockedList).size();

//Check the result
assertEquals(10,size);
```
Limitations: it cannot mock final classes or methods. it cannot mock private methods. We need to use PowerMockito to finish these tasks.

### 8. @Mock and @InjectMocks
@Mock is used to create a mock for a class. @InjectMocks is used to create the instance of the class under test and inject the mock objects. For example, if we have a Service and Controller dependency class: 
```java
public class MyService {
    public String performAction() {
        return "Action Performed";
    }
}

public class MyController {
    private MyService myService;

    public MyController(MyService myService) {
        this.myService = myService;
    }

    public String doAction() {
        return myService.performAction();
    }
}
```
we do this: 
```java
@ExtendWith(MockitoExtension.class)
public class MyControllerTest {

    @Mock
    MyService myService;

    @InjectMocks
    MyController myController;

    @Test
    public void testDoAction() {
        when(myService.performAction()).thenReturn("Mocked Action Performed");

        String result = myController.doAction();

        assertEquals("Mocked Action Performed", result);
    }
}
```

### 9. Stubbing
Stubbing is a technique in unit testing to replace an object with a "stub" that provides pre-determined responses.
For example:
```java
    @Test
    public void test() {
        // Create a mock object
        List<String> mockedList = mock(List.class);

        // Stubbing: define behavior for specific method calls
        when(mockedList.get(0)).thenReturn("first");
        when(mockedList.get(1)).thenThrow(new RuntimeException());

        // Using the stubbed methods
        System.out.println(mockedList.get(0)); // Outputs: first
        // mockedList.get(1); 

        // Verifying interactions with the mock
        verify(mockedList).get(0);
    }
```

### 10. Mockito ArgumentMatchers
Used to specify conditions for method arguments used in stubbing and verification. It set up general conditions, covering all the test cases.
for example:  
```java
Mockito.When(aa.method(ArgumentMatchers.anyString()).thenReturn(
new AA());
```

### 11. Hamcrest Matchers
Also used for matching objects for the test class. It has a method 'assertThat' to assert variable expectations. for example:
```java
        String str = "Hello, World!";
        int number = 5;

        // Assertions using Hamcrest Matchers
        assertThat(str, startsWith("Hello"));
        assertThat(str, endsWith("World!"));
        assertThat(str, containsString("World"));

        assertThat(number, greaterThan(3));
        assertThat(number, lessThan(10));

        assertThat(number, is(5));
        assertThat(str, is(not(emptyString())));
```

### 12. @spy vs @mock
@Spy represents the real object, it's an actual instance of the class that can perform in its real behavior. like if you create a @Spy list, the list will have the actual size of the original list.
but @Mock is like the fake object, it doesn't contain any real code behavior.

### 13. Assertion
in unit testing, assertion check if a condition is true. For true, the program continues to execute; if false, the error is thrown and showing that there is a problem in the code. There are many types of Assertions, including Equality for numbers, truth for boolean, nullitly for null value, etc.

### 14. 
Unit testing: testing individual components like functions.
Integration testing: testing among multiple components, verifying the collaboration between each of them is correct.
Regression Testing: test the program in different envirnoment.
Performance testing: test the response time of the system under a specific workload.
Stress testing: testing the stability and reliability of the system by simulating an environemnt with workloads or data volumes beyond normal levels.
User Acceptance testing: test performed by the actual users to see if it meets user needs and expectations.


