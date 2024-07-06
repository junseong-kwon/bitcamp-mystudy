package poly.basic;

public class CastingMain2 {

    public static void main(String[] args) {
        Child child = new Child();
        Parent parent1 = (Parent) child;
        Parent parent2 = child;
        //업캐스팅의 과정

        parent1.parentMethod();
        parent2.parentMethod();
    }
}
