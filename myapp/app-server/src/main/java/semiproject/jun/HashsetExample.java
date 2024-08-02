package semiproject.jun;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class HashsetExample {

  public static void main(String[] args) {
    Set<String> set = new HashSet<>();

    set.add("Java");
    set.add("JDBC");
    set.add("JSP");
    set.add("Java");
    set.add("Spring");

    Iterator<String> iterator = set.iterator();
    while (iterator.hasNext()) {
  }

}
