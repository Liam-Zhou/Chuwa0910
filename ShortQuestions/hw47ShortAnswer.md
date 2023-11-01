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
