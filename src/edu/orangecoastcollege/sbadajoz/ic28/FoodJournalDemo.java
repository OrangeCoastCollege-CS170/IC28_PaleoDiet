package edu.orangecoastcollege.sbadajoz.ic28;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Scanner;

public class FoodJournalDemo {
	public static void print(ArrayList<PaleoFood> food) {
		iterate(food);
		System.out.println("Calories: " + totalCalories(food));
		System.out.println("Number of organic produce items: " + organicProduceConsumed(food));
		System.out.println();
	}
	
	public static void iterate(ArrayList<PaleoFood> food) {
		for (PaleoFood paleoFood : food) {
			System.out.println(paleoFood);
		}
	}

	public static int totalCalories(ArrayList<PaleoFood> food) {
		int calories = 0;
		for (PaleoFood paleoFood : food) {
			calories += paleoFood.getCalories();
		}
		return calories;
	}

	public static int organicProduceConsumed(ArrayList<PaleoFood> food) {
		int i = 0;
		for (PaleoFood paleoFood : food) {
			if (paleoFood instanceof Produce) {
				if(((Produce) paleoFood).isOrganic()) i++;
			}
		}
		return i;
	}
	public static void main(String[] args) {
		ArrayList<PaleoFood> food = new ArrayList<>();
		Scanner input = new Scanner(System.in);
		File file = new File("FoodJournal.dat");
		Object[] arr;

		int userIn;

		if (file.exists()) {

			try {
				arr = (Object[]) new ObjectInputStream(
						new FileInputStream(file)).readObject();
				for (Object newFood : arr)
					food.add((PaleoFood) newFood);
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace(System.out);
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace(System.out);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace(System.out);
			}

		}
		if (food.size() == 0) {
			System.out.println("[No food eaten. You must be hungry.]");
		} else {
			print(food);
		}

		while (true) {
			System.out.println("Enter a number...\n" + "1: Record a meat\n"
					+ "2: Record a produce\n" + "3: Exit");
			userIn = input.nextInt();
			input.nextLine();

			switch (userIn) {
				case 1 :

					System.out.print("Meat name: ");
					String name = input.nextLine();
					System.out.print("Number of Calories: ");
					int calories = input.nextInt();
					System.out.print("Meat type (1 for Animal, 2 for Fish): ");
					int type = input.nextInt();
					System.out.print("Cooking temperature: ");
					int temperature = input.nextInt();
					input.nextLine();
					try {
						food.add(new Meat(name, calories, type, temperature));
					} catch (UnkownMeatException e) {
						System.out.println(e.getMessage());
					}
					print(food);
					break;

				case 2 :
					System.out.print("Produce name: ");
					name = input.nextLine();
					System.out.print("Number of Calories: ");
					calories = input.nextInt();
					System.out.print("Number of Carbohydrates: ");
					type = input.nextInt();
					System.out.print("Is it organic (1/0): ");
					temperature = input.nextInt();
					input.nextLine();
					food.add(new Produce(name, calories, type,
							(temperature == 1)));
					print(food);
					break;

				case 3 :
					arr = new Object[food.size()];
					for (int i = 0; i < food.size(); i++) {
						arr[i] = food.get(i);
					}
					try {
						new ObjectOutputStream(new FileOutputStream(file))
								.writeObject(arr);
					} catch (FileNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace(System.out);
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace(System.out);
					}
					System.out.println("Enjoy your healthy break!");
					System.exit(0);
			}
		}
	}

}
