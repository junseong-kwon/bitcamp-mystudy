package javamid2.generic.ex1;

public class BoxMain {

    public static void main(String[] args) {

    GenericBox<Integer> integerGenericBox = new GenericBox<>();
    integerGenericBox.set(100);
        Integer integer = integerGenericBox.get();//Integer타입 반환(캐스팅 x)
        System.out.println("integer = " + integer);

        GenericBox<String> stringGenericBox = new GenericBox<>();
        stringGenericBox.set("Hello");
        String s = stringGenericBox.get();
        System.out.println("string = " + s);
    }
}
