package poly.basic;

public class PolyMain {
    public static void main(String[] args) {

     Parent parent = new Parent();
     parent.parentMethod();

     Child child = new Child();
     child.childMethod();
     child.parentMethod();
    }
}
