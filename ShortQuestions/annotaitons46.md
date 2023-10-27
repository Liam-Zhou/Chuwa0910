@Before:Run before the method execution<br>
@After:Run after the method returned a result<br>
@AfterReturning:Run after the method returned a result, intercept the returned result as well.<br>
@AfterThrowing:Run after the method throws an exception<br>
@Around:Run around the method execution, combine all three advices above.<br>
@Aspect:indicate this is a aop class<br>
@EnableSchduling:is an annotation used in the Spring Framework to enable the scheduling of tasks using Spring's task scheduling capabilities. When you apply this annotation to a configuration class or a component, it allows you to define methods that should be scheduled to run at specific intervals or on a regular basis. These scheduled methods are typically used for tasks like batch processing, sending periodic reports, or any other time-bound operations.<br>
@Scheduled(cron = "* * * * * *"):all fields are set to *, which means the method will be scheduled to run every second. This is a very frequent schedule and will execute the method every second.<br>


