# The static variable gets memory only once in the class area at the time of class loading.


# Q)   Why is the Java main method static?
        It is because the object is not required to call a static method. 
        If it were a non-static method, JVM creates an object first then 
        call main() method that will lead the problem of extra memory allocation.


# Restrictions of static
* The static method can not use non static data member or call non-static method directly.
* this and super cannot be used in static context.