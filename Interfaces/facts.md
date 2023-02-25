# An interface in Java is a blueprint of a class.

# It is a mechanism to achieve abstraction.

# interfaces can have abstract methods and variables. It cannot have a method body.

# Interface fields are public, static and final by default, and the methods are public and abstract.

* Multiple inheritance is not supported in the case of class because of ambiguity. 
  However, it is supported in case of an interface because there is no ambiguity. 
  It is because its implementation is provided by the implementation class.

* An interface which has no member is known as a marker or tagged interface, 
   for example, Serializable, Cloneable, Remote, etc. They are used to provide 
   some essential information to the JVM so that JVM may perform some useful operation. 