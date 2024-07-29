package javamid2.generic.ex2;

import javamid2.generic.animal.Animal;
import javamid2.generic.animal.Cat;
import javamid2.generic.animal.Dog;

public class AnimalMain1 {

    public static void main(String[] args) {
        Animal animal = new Animal("동물", 0);
        Dog dog = new Dog("멍멍이", 100);
        Cat cat = new Cat("냐옹이", 50);

        Box<Dog> dogBox = new Box<>();
        dogBox.set(dog);
        Dog dog1 = dogBox.get();
        System.out.println("dogbox = " + dog1);


    Box<Cat> catBox = new Box<>();
    catBox.set(cat);
        Cat cat1 = catBox.get();
        System.out.println("catBox = " + cat1);

        Box<Animal> animalBox = new Box<>();
        animalBox.set(animal);
        Animal animal1 = animalBox.get();
        System.out.println("animalBox = " + animal1);

    }
}
