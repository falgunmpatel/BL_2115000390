import java.util.*;

class Person {
    String name;
    int age;

    Person(String name,int age) {
        this.name = name;
        this.age = age;
    }

    Person(Person person) {
        this.name = person.name;
        this.age = person.age;
    }

    void displayPerson() {
        System.out.println("*******************");
        System.out.println();

        System.out.println("Person Details: ");
        System.out.println("Name :" + this.name);
        System.out.println("Age :" + this.age);

        System.out.println();
        System.out.println("*******************");
    }
}

public class PersonExample {
    public static void main (String []args) {
        Person person1 = new Person("Person_01", 32);
        Person person2 = new Person(person1);
        person1.displayPerson();
        person2.displayPerson();
    }
}
