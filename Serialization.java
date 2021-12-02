import java.util.Scanner;
import java.util.ArrayList;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.IOException;
import java.lang.ClassNotFoundException;
import java.lang.ClassCastException;

public class Serialization {

    public static String ask(String query) {

        // Initialize Scanner object
        boolean isValidInput = false;
        String input = "";
        Scanner scan = new Scanner(System.in);

        // Print question & capture response.
        System.out.println(query);
        input = scan.nextLine();
        return input;

    }

    // Serialize and Write Data
    public static void writeToFile(ArrayList<Person> peopleFromMain) throws IOException {
        try {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("Person.bin"));
            oos.writeObject(peopleFromMain);
            oos.close();
        }
        catch(IOException e) {
            e.printStackTrace();
        }
    }

    // Deserialize and Read Objects/Data
    public static ArrayList<Person> readFile() throws IOException, ClassNotFoundException {
        ArrayList<Person> peopleFromFile = null;
        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream("Person.bin"));
            peopleFromFile = (ArrayList<Person>) ois.readObject();
            ois.close();
            return peopleFromFile;
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        catch (ClassNotFoundException e) {
            System.err.println("Error: Class specified is not found.");
            e.printStackTrace();
        }
        catch (ClassCastException e) {
            e.printStackTrace();
        }
        return peopleFromFile;
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        boolean isRunning = true;
        ArrayList<Person> people = new ArrayList<Person>();
        String response = "";
        while(isRunning) {
            // Display Menu
            int optionSelected = Integer.parseInt(ask("\nSelect an option.\n\n1) Add information into a file.\n2) Retrieve information from a file and display them.\n3) Delete information.\n4) Update information.\n5) Exit.\n"));
            switch(optionSelected) {
                case 1:
                    // add info
                    people = readFile();
                    String name = ask("What is the name?");
                    String number = ask("What is the phone number?");
                    String dob = ask("What is the Date of Birth?");
                    String email = ask("What is the email address?");
                    people.add(new Person(name, number, dob, email));
                    writeToFile(people);
                    break;
                case 2:
                    // read data on file
                    people = readFile();
                    for (Person person : people) {
                        System.out.println(person.toString());
                    }
                    break;
                case 3:
                    // delete data
                    people = readFile();
                    System.out.println("\nSelect an item from the list to delete it.");
                    for (int i = 0; i < people.size(); i++) {
                        System.out.println((i + 1) + ". " + people.get(i).toString());
                    }
                    response = ask("");
                    int indexToDelete = (Integer.parseInt(response)) - 1;
                    people.remove(indexToDelete);
                    writeToFile(people);
                    System.out.println("Item deleted.");
                    break;
                case 4:
                    // update data
                    people = readFile();
                    System.out.println("\nSelect an item from the list to update.");
                    for (int i = 0; i < people.size(); i++) {
                        System.out.println((i + 1) + ". " + people.get(i).toString());
                    }
                    response = ask("");
                    int indexToModify = (Integer.parseInt(response)) - 1;
                    String name1 = ask("What is the name?");
                    String number1 = ask("What is the phone number?");
                    String dob1 = ask("What is the Date of Birth?");
                    String email1 = ask("What is the email address?");
                    people.set(indexToModify, new Person(name1, number1, dob1, email1));
                    writeToFile(people);
                    System.out.println("Item deleted.");
                    break;
                case 5:
                    isRunning = false;
                    break;
                default:
                    System.err.println("Error: Invalid option entered. Please try again.");
                
            }

            // people.add(new Person("Nick", "630-945-2263", "01-26-1995", "nick@email.com"));
            // people.add(new Person("Alex", "630-752-9212", "04-17-1990", "alex@email.com"));
            
            writeToFile(people);

        }
    }
}