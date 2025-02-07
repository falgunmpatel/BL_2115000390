import java.util.*;

class Animal {
	protected String name;
	protected int age;
	
	Animal(String name, int age) {
		this.name = name;
		this.age = age;
	}

	void makeSound() {
		System.out.println("Inside Animal Class, Lion Roars!!");
	}
}

class Dog extends Animal {
	Dog(String name, int age) {
		super(name, age);
	}

	@Override
	void makeSound() {
		System.out.println("Inside Dog Class, Dog barks!!");
	}
}

class Cat extends Animal {
	Cat(String name, int age) {	
		super(name, age);
	}
	
	@Override
	void makeSound() {
		System.out.println("Inside Cat Class, Cat meows!!");
	}
}

class Bird extends Animal {
	Bird(String name, int age) {
		super(name, age);
	}

	@Override
	void makeSound() {
		System.out.println("Inside Bird Class, Bird chirps!!");
	}
}

public class AnimalHierarchy {
	public static void main (String []args) {
		Animal animal = new Animal("Animal_01", 12);
		Dog dog = new Dog("Dog_01", 7);
		Cat cat = new Cat("Cat_01", 9);
		Animal bird = new Bird("Bird_01", 4);

		animal.makeSound();
		dog.makeSound();
		cat.makeSound();
		bird.makeSound();
		
	}
}
