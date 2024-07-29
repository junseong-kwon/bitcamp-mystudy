package javamid2.generic.ex3;

import javamid2.generic.animal.Animal;
import javamid2.generic.animal.Cat;
import javamid2.generic.animal.Dog;

public class AnimalHospitalMainV1 {


  public static void main(String[] args) {

    AnimalHospitalV1 dogHospital = new AnimalHospitalV1();
    AnimalHospitalV1 catHospital = new AnimalHospitalV1();

    Dog dog = new Dog("멍멍이1", 100);
    Cat cat = new Cat("냐옹이1", 300);

    //개 병원
    dogHospital.set(dog);
    dogHospital.cheakup();

    catHospital.set(cat);
    catHospital.cheakup();

    dogHospital.set(dog);
    Animal animal;
  }
}
