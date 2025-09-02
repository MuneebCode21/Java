package dynamic;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		
		Animal animal;
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Welcome to Animal show");
		System.out.print("(1=Gog) or (2=cat)");
		int choice = scanner.nextInt();
		
		if (choice==1) {
			animal = new Dog();
			animal.speaks("BOWWW");
		}
		else if (choice==2) {
			animal=new Cat();
			animal.speaks("LOL");
			
		}
		else{
			animal = new Animal();
			System.out.println("That was invalid");
		}while(choice==4);
	}

}
