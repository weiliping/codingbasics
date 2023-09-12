Singleton Pattern
  - Bean Creation
Factory Pattern
  - BeanFactory
  - ApplicationContext
Template Method Pattern
  - Eg:
    1. JdbcTemplate execute() method
    2. AbstractController handleRequestInternal()
Proxy Pattern
  - Eg:
    1. Implementation of AOP
    2. @Transactional annotation(Transaction management)
    3. Annotation @Overwrite
  - Implementation
    1. JDK dynamic proxies
    2. CGLIB proxies
Decorator Pattern
  - HandleInterceptor
  - LoggingFilter - Filter
Observer Pattern
  - ApplicationEventPublisher and ApplicationListener
  - @EventListener annotation
Command Pattern
  - @RequestMapping annotation
  - JdbcTemplateclass to execute database queries
Chain of Responsibility Pattern
  - Interceptors tohandle HTTP requests
  - The use of AOP (Aspect-Oriented Programming) to add behavior to Spring beans.
Flyweight Pattern
  - The Singleton scope for beans
  - The Object Pool design pattern for managing objects
Interpreter Pattern
  - The Spring Expression Language(SpEL)

