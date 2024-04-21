package baseProblem.sortAndRamuda;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by @gaofenglin
 * on 2024/4/21.
 */
public class PersonAge {
    // ソート対象の準備
    public static void main(String[] args) {
        List<Person> persons = new ArrayList<>();
        persons.add(new Person("alice",16));
        persons.add(new Person("jack",12));
        persons.add(new Person("bob",13));

        //从大到小，降序
        //从小到大，升序
        //(parameters) -> expression
        persons.sort((p1, p2) -> Integer.compare(p2.age, p1.age));
        for (Person p : persons) {
            System.out.println(p.name + " " + p.age);
        }

    }
}

class Person {
    String name;
    int age;
    Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

}
