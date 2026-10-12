learn spring core concepts 

<b>

1. What is Spring Framework & Spring Core?

• Spring Framework is a massive ecosystem that makes enterprise Java development easy.
• Spring Core is the foundation (the engine) of this ecosystem. If you do not understand Spring Core, you cannot master Spring Boot, JPA, or AOP.
• Core Goal: To make your Java classes loosely coupled (independent) so they are easy to test, maintain, and modify.

2. What is a Spring Bean?

• Simple Definition: A Bean is just a standard Java object managed entirely by the Spring Container.
• Explanation: In traditional Java, you create objects using the new keyword (e.g., Car myCar = new Car();). In Spring, you let Spring create and manage that object. That managed object is called a Spring Bean.

3. Inversion of Control (IoC) & The Container

• Simple Definition: IoC means shifting the control of creating and managing objects from you (the developer) to the framework (Spring).
• The Spring IoC Container: Think of it as a factory or a giant box. You give Spring your class blueprints, and the container automatically instantiates, configures, wires, and manages those objects.

The Brain of IoC: ApplicationContext

• ApplicationContext is the actual interface representing the Spring IoC Container.
• It reads your configuration (Annotations or XML), starts the container, and hands you the objects when you ask for them using context.getBean().

4. Dependency Injection (DI)

• Simple Definition: DI is the process where the Spring Container automatically injects (provides) the required dependent objects into a class.
• Real-World Analogy: Think of a Car and an Engine. A Car depends on an Engine to run.
	• Without DI: The Car class goes to a factory, buys an engine, and builds it inside itself (new Engine()). The Car is stuck with that specific engine forever.
	• With DI: The Car just says, "I need an engine." The Spring Container builds an engine outside and drops it right into the Car. Now, you can easily swap it for a sports engine or an electric engine without changing the Car's internal code.

5. Core Annotations You Must Know

To stop using old XML files, Spring uses Annotations (metadata tags starting with @) to control the IoC Container.

🏭 The Stereotype Annotations (Creating Beans)

• @Component: Tells Spring, "Hey, look at this class! Please manage it and make a Bean out of it automatically."
• @Service: A specialized form of @Component used to mark classes that hold business logic.
• @Repository: A specialized form of @Component used for database communication classes.

⚙️ The Configuration Annotations

• @Configuration: Tells Spring that this class contains setup rules for the application (replaces the old beans.xml).
• @ComponentScan: Tells Spring exactly which folders/packages to scan to find classes marked with @Component.

🔌 The Wiring Annotation

• @Autowired: Tells Spring to look into its container box, find the matching Bean, and automatically inject (wire) it into this variable. It eliminates the need for manual setup or factory patterns.

6. Types of Dependency Injection

There are two primary ways Spring injects a dependency into your class:

A. Constructor Injection (Recommended)

Spring injects the dependency through the class constructor.
java
@Component
public class Car {
    private final Engine engine;

    // Spring automatically passes the Engine bean here
    @Autowired 
    public Car(Engine engine) {
        this.engine = engine;
    }
}

• Why use it? It makes fields immutable (final) and guarantees that the object cannot be created without its required dependencies.

B. Setter Injection

Spring injects the dependency using a standard setter method.
java
@Component
public class Car {
    private Engine engine;

    @Autowired
    public void setEngine(Engine engine) {
        this.engine = engine;
    }
}
• Why use it? Good for optional dependencies that can be changed or added later.

7. Bean Scopes (How Beans are Created)

When you ask Spring for an object, how does it deliver it? You can control this using the @Scope annotation.

Scope	How it Works	Best Used For
Singleton (Default)	Spring creates only one single instance of the Bean in memory. Every time you ask for it, you get the exact same object.	Stateless classes like Services, Repositories, and Controllers.
Prototype	Spring creates a brand new instance every single time you ask the container for it.	Stateful objects that hold data unique to a specific user or action.


8. Summary Checklist: How Spring Core Works Together

1. You mark your classes with @Component.
2. You tell Spring where to look using @ComponentScan.
3. The ApplicationContext (IoC Container) starts up, scans your packages, and creates the objects (Beans).
4. Wherever Spring finds @Autowired, it automatically wires the dependent Beans together (Dependency Injection).


***********************************************************************************************************


1. Singleton Scope (Default)

• Simple Explanation: Spring creates only one single object of the class for the entire project. Everyone shares the exact same instance in memory.
• Basic Example: Think of a Classroom Whiteboard. There is only one board in the room. All students look at and share the same board.
• Code:
java
@Component
// By default, it is @Scope("singleton")
public class Whiteboard {
// Shared by everyone
}


2. Prototype Scope

• Simple Explanation: Spring creates a brand-new object every single time you ask for it or inject it.
• Basic Example: Think of a Student Notebook. Every student gets their own personal, separate notebook.
• Code:
java
@Component
@Scope("prototype") // Tells Spring to make a new object every time
public class Notebook {
// Private to whoever asks for it
}


3. @PostConstruct & @PreDestroy (Lifecycle Hooks)

• Simple Explanation:
• @PostConstruct runs code automatically right after the object is born (initialized).
• @PreDestroy runs code automatically right before the object dies (destroyed at application shutdown).
• Basic Example: Starting and stopping a machine.
• Code:
java
@Component
public class DatabaseMachine {

    @PostConstruct
    public void start() {
        System.out.println("🔌 Connected to Database (Object is Born!)");
    }

    @PreDestroy
    public void stop() {
        System.out.println("❌ Disconnected cleanly (Object is dying...)");
    }
}


4. @Qualifier

• Simple Explanation: Used when Spring gets confused. If you have two different classes implementing the same interface, @Qualifier tells Spring exactly which class object you want to use.
• Basic Example: If you ask for a "Payment", Spring asks: "UPI or Card?". You use @Qualifier to say "Give me UPI".
• Code:
java
@Component
public class Checkout {

    @Autowired
    @Qualifier("upiPayment") // Directs Spring to choose the UPI object specifically
    private PaymentType payment; 
} 




</b>

