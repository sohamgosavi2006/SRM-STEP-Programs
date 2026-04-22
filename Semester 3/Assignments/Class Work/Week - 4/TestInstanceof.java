class Animal {}
class Dog extends Animal {}
class Cat extends Animal {}

class Lion extends Animal{}

public class TestInstanceof {
    public static void main(String[] args) {
        Animal[] animals = { new Dog(), new Cat(), new Dog(), new Animal() };

        int dogs = 0;
        int cats = 0;

        int lion = 0;

        for (Animal a : animals) {
            if (a instanceof Dog)
                 dogs++;
            else if (a instanceof Cat)  
                 cats++;
            // animals array does not have Lion() constructor so Lion is not part of animals array
            // but is part of Animal class
            else if (a instanceof Lion) 
                lion++;
        }

        System.out.println("Number of Dog objects: " + dogs);
        System.out.println("Number of Cat objects: " + cats);

         System.out.println("Number of Lion objects in Array of objects (animals) of Class Animal: " 
                            + lion);

    }
}
