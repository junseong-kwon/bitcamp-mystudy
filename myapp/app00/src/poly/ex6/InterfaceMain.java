package poly.ex6;

public class InterfaceMain {
    public static void main(String[] args) {
       // InterfaceAnimal interfaceAnimal = new InterfaceAnimal();
        //인터페이스 생성 불가

        Dog dog = new Dog();
        Caw caw = new Caw();
        Cat cat = new Cat();

        AnimalSound(dog,dog);
        AnimalSound(cat,cat);
        AnimalSound(caw,caw);



    }

    private static void AnimalSound(InterfaceAnimal sound, InterfaceAnimal move){
        System.out.println("동물 울음 시작");
        sound.sound();
        System.out.println("동물 울음 종료");

        System.out.println("움직이자!");
        move.move();
        System.out.println("그만!");
    }
}
