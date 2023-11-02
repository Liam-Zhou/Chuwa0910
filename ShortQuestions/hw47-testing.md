###### 2.  what is selenium?
A kind of user-behavior simulation. It enables tasks such as testing web applications and web scraping by providing APIs to interact with web elements and perform actions in web browsers like Chrome, Firefox, and others.

###### 3.  what is cucumber?
A tool that facilitates Behavior-Driven Development (BDD) by allowing software developers, testers, and non-technical stakeholders to collaborate and define application behavior in plain text.

###### 4.  what is JMeter?
A tool designed for performance testing and load testing of web applications and services. It allows you to simulate multiple users interacting with a web application to assess its performance under different load conditions. 

###### 5.  What is the lifecircle of Junit?
The lifecycle of JUnit tests typically involves the following stages:

Initialization: @BeforeAll and @BeforeEach methods (optional) are executed to set up the test environment.
Test Execution: Test methods annotated with @Test are executed.
Cleanup: @AfterEach and @AfterAll methods (optional) are executed to clean up resources and finalize the test environment.

###### 6.  Is @BeforeAll method should be Class level(static)?
Yes, in JUnit 5, the @BeforeAll method should be a static method because it is executed before any test methods in the test class, and it is associated with the class itself rather than an instance of the class. In JUnit 4, it didn't have to be static, but JUnit 5 introduced this requirement for better control and encapsulation of the test class setup.

###### 7. What is Mockito? and what is its limitations?  what kind of tools can give help?
Mockito is a popular Java library used for mocking objects and simulating behavior in unit tests. It helps in isolating the code under test by replacing dependencies with mock objects. However, Mockito has some limitations, such as it cannot mock final classes, static methods, or constructors. To overcome some of these limitations, you can use tools like PowerMock or JMockit, which offer more advanced mocking capabilities.

###### 8.  What is @Mock and what is @InjectMocks?
@Mock: Used to annotate fields or method parameters to indicate that they should be mocked objects. 
@InjectMocks: Used to annotate a field or parameter in a test class to indicate that Mockito should inject mock instances into this field. 

###### 9.  What is the stubbing (define behaviors)?
Stubbing in Mockito refers to defining the behavior of a mock object when certain methods are called. You specify what the mock should return or throw when specific method calls occur during the test. 

###### 10. what is Mockito ArgumentMatchers
Mockito provides argument matchers like any(), eq(), anyInt(), etc.

###### 11. what is Hamcrest Matchers
It provides a set of matchers that can be used with testing frameworks like JUnit and Mockito to create expressive and readable assertions in tests.

###### 12. do you know @spy? what is difference between @spy and @Mock?
@Spy: Used to create a partial mock of a real object.
@Mock: Used to create a mock object with all of its methods mocked. It doesn't execute the real methods.

###### 13. What is assertion?
Used to validate that the actual outcome of a test matches the expected outcome.

###### 14. If you have developed a new feature, how many types of tests for this feature? and what kind of tests are written by you? what is the purpose of each type of tests?
Unit Testing:
- Testing individual functions or methods.
- Verifying the correctness of isolated components.
- Typically written and maintained by developers to ensure the reliability of small code units.

Integration Testing:
- Testing the interactions between multiple components or modules.
- Verifying that different parts of the system work together correctly.
- Ensuring that integrated components collaborate as expected.

Regression Testing:
- Rerunning previously executed tests after making changes to confirm that new errors have not been introduced.
- Ensuring that existing functionality remains correct as the software evolves.

Performance Testing:
- Evaluating the system's performance and response times under specific workloads.
- Verifying that the system meets performance and efficiency requirements, often in terms of response times (e.g., 200ms).

Stress Testing:
- Testing the system's stability and reliability by subjecting it to workloads or data volumes beyond normal levels.
- Ensuring that the system can handle high-pressure scenarios, such as high request rates (e.g., 2k queries per second).

User Acceptance Testing (UAT):
- Allowing end users to test the software under real-world conditions.
- Ensuring that the software meets user needs and expectations and can perform required tasks effectively.