package javamid2.generic.ex3;

import javamid2.generic.animal.Cat;
import javamid2.generic.animal.Dog;

public class AnimalHospital {

    public static void main(String[] args) {
        DogHospital dogHospital = new DogHospital();
        CatHospital catHospital = new CatHospital();

        Dog dog = new Dog("멍멍이", 100);
        Cat cat = new Cat("냐옹이", 300);

        dogHospital.set(dog);
        dogHospital.checkUp();

        catHospital.set(cat);
        catHospital.checkUp();

        //
    }
}
