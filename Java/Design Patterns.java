/* ----- Factory Design Pattern ----- */
// . Solution using Abs Classes
// Abstract Product Class
abstract class Product {
    public abstract void display();
}

// Concrete Products
class ConcreteProductA extends Product {
    @Override
    public void display() {
        System.out.println("This is Concrete Product A.");
    }
}

class ConcreteProductB extends Product {
    @Override
    public void display() {
        System.out.println("This is Concrete Product B.");
    }
}

// Creator Abstract Class
abstract class Creator {
    public abstract Product factoryMethod();
}

// Concrete Creators
class ConcreteCreatorA extends Creator {
    @Override
    public Product factoryMethod() {
        return new ConcreteProductA();
    }
}

class ConcreteCreatorB extends Creator {
    @Override
    public Product factoryMethod() {
        return new ConcreteProductB();
    }
}

// Client Code
public class FactoryMethodExample {
    public static void main(String[] args) {
        Creator creatorA = new ConcreteCreatorA();
        Product productA = creatorA.factoryMethod();
        productA.display();

        Creator creatorB = new ConcreteCreatorB();
        Product productB = creatorB.factoryMethod();
        productB.display();
    }
}

// -------- 

// 2. Solution using Interface
// Product Interface
interface Product {
    void display();
}

// Concrete Products
class ConcreteProductA implements Product {
    @Override
    public void display() {
        System.out.println("This is Concrete Product A.");
    }
}

class ConcreteProductB implements Product {
    @Override
    public void display() {
        System.out.println("This is Concrete Product B.");
    }
}

// Factory Interface
interface Factory {
    Product factoryMethod();
}

// Concrete Factories
class ConcreteFactoryA implements Factory {
    @Override
    public Product factoryMethod() {
        return new ConcreteProductA();
    }
}

class ConcreteFactoryB implements Factory {
    @Override
    public Product factoryMethod() {
        return new ConcreteProductB();
    }
}

// Client Code
public class FactoryMethodExample {
    public static void main(String[] args) {
        Factory factoryA = new ConcreteFactoryA();
        Product productA = factoryA.factoryMethod();
        productA.display();

        Factory factoryB = new ConcreteFactoryB();
        Product productB = factoryB.factoryMethod();
        productB.display();
    }
}

