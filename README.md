# IC28_PaleoDiet
## In this assignment, you will be creating a Java console application to maintain a daily food journal for a person who is participating in the trendy "Paleo Diet", which is a dietary shift to food items that are either produce (vegetables and fruit) or meat (including seafood).  **Note: I'm overgeneralizing a bit here for the purposes of this assignment and I'm not an advocate of the Paleo diet, but it does make for an interesting exercise in Inheritance**</br></br> According to the Paleo Diet, an individual should limit their carbohydrate intake to 100-150 grams per day.</br></br>The Paleo food journal will record information about for all the "PaleoFood" that one individual eats in one day, including “Produce” and "Meat".  In this programming exercise, you will be creating 3 classes to represent this data: PaleoFood.java, Produce.java and Meat.java.  For our purposes, “PaleoFood” will be the abstract base (parent) class and “Produce” and “Meat” will be the concrete derived (child) classes.

**_PaleoFood:_** This is the abstract parent (base) class of the other two.  Here are the specifications:

1. Make PaleoFood an abstract class (cannot be instantiated).
2. Create instance variables for `name` (String), `calories` (int) and `carbohydrates` (int).   **Be sure that all instance variables can be inherited by the two child classes**
3. Create accessors/mutators for all instance variables.

**_Meat:_** This one of the concrete child (derived) classes.  Ensure that it is Serializable.  Here are the specifications:

1. Create instance variable for type (1 represents animal meat, 2 means seafood) (int).
2. Create accessor/mutator for type.
3. Create instance variable for cookingTemp (the temperature, in Fahrenheit, at which the meat should be cooked before consumption.  Some meat (e.g. seafood) can be eaten raw, which would be 0 for cookingTemp) (int)
4. Create accessor/mutator for cookingTemp
5. Create a constructor with 4 parameters (name, calories, type, cookingTemp).  Initialize all instance variables.  For Meat, the carbohydrates should be initialized to 0 (no carbs).  Carbohydrates should not appear in the constructor parameter list.
6. Override the equals() method to compare all instance variables for equality.
7. Override the toString() method that displays all fields in the following format:
`Type: name, calories, carbohydrates, cookingTemp`

(If the type is 1 - animal):
`Meat: Beef, 650 calories, 0g carbs, 170 degrees F`

(If the type is 2 - seafood):
`Seafood: Ahi, 300 calories, 0g carbs, 0 degrees F`

**_UnknownMeatException:_** This class is used to indicate the meat type specified is not one of the known types (e.g. Meat or Seafood).  It is not part of the inheritance tree, but it is used by the Meat class whenever the meat type is specified.

1. Create class UnknownMeatException to extend the Exception class.
2. Throw this exception in your Meat class whenever the Meat type is changed and not 1 (Meat) or 2 (Seafood).
3. Catch the exception in your FoodJournalDemo when the user is entering new Meat data.

**_Produce:_** This is the other concrete child (derived) class.  Ensure that it is Serializable.  Here are the specifications:

1. Create instance variable for organic (boolean).  (true represents organic produce, false represents non-organic)
2. Create accessor/mutator for organic
3. Create a constructor with 4 parameters (name, calories, carbohydrates, organic).  Initialize all instance variables.
4. Override the equals() method to compare all instance variables for equality.
5. Override the toString() method that displays all fields in the following format:
`[Organic] Produce:  name, calories, carbohydrates, `  For example:

(If organic is true):
`Organic Produce: Brussels Sprouts, 50 calories, 2g carbs`

(If organic is false):
`Produce: Fuji Apple, 150 calories, 12g carbs`

**_FoodJournalDemo:_** in this demo, write a public static void main(String[ ] args) method that performs the following:

1. Maintains an ArrayList<PaleoFood>
2. In a loop, display the current list of PaleoFood eaten that day by looping through the ArrayList and printing each of the PaleoFood objects to the console.  
If the ArrayList is empty, display the message `[No food eaten.  You must be hungry.]`

Display the total number of calories consumed (use function described below).
Display the total number of organic produce consumed (use function described below)

3. Next, prompt the user with 3 options to record a new Meat (option 1) or Produce (option 2) entry in the food journal.  Option 3 is to exit
  * If the user enters option 1 (Meat), prompt for name, calories, type (1 for animal, 2 for seafood) and cooking temperature.  Create a new Meat object and add it to the ArrayList.
  * Else if the user enters option 2 (Produce), prompt for name, calories, carbohydrates and organic (1 for organic, 0 for non-organic).  Create a new Produce object and add it to the ArrayList.
  * Else if the user enters option 3 (exit), write the ArrayList to the binary file (named "FoodJournal.dat"), then print the message "Eat healthy and enjoy your break!"  and exit.
  * Note:  Every time a user enters a new food item (option 1 or 2), your program should re-display the current list of PaleoFood eaten (loop through ArrayList) and print the total number of calories and organic produce consumed (see step 2. above)

Add functionality to your program to read from / write to a binary file (named "FoodJournal.dat"):

When the program first runs (before the user prompt), open the binary file (named "FoodJournal.dat") for reading and read all the PaleoFood objects into the ArrayList

When the user enters option 3 (exit) write the ArrayList to the binary file (named "FoodJournal.dat") and exit.

Create a method named `public static int totalCalories` that takes, as input, an ArrayList<PaleoFood>.  This method should loop through all the food in the list, add up the calories of each item and return the total calories.  Use this method in step 2 (above).

Create a method named `public static int organicProduceConsumed` that takes, as input, an ArrayList<PaleoFood>.  This method should loop through all the food in the list and determines how many organic produce items have been consumed that day.  Use this method in step 2 (above).




Below is a UML diagram showing the class inheritance:

Paleo class diagram
