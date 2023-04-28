// Class House, C211 Group Project, Spring 2023
// Author: Ethan Kvachkoff
package application;

import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;

public class House {

    // Instance attributes
    String name, description, color;
    int population;

    // Default constructor
    public House() {
        name = "";
        description = "";
        color = "";
        population = 0;
    }

    // Non-Default constructor
    public House(String theName, String descrip, String theColor, int pop) {
        name = theName;
        description = descrip;
        color = theColor;
        population = pop;
    }

    // Setters
    public void setName(String theName) {
        this.name = theName;
    }

    public void setDescription(String descrip) {
        this.description = descrip;
    }

    public void setColor(String theColor) {
        this.color = theColor;
    }

    public void setPopulation(int pop) {
        this.population = pop;
    }

    // Getters
    public String getName() {
        return this.name;
    }

    public String getDescription() {
        return this.description;
    }

    public String getColor() {
        return this.color;
    }

    public int getPopulation() {
        return this.population;
    }

    // Reads house's name and population from given file
    public void read(String filename) {
        File f = new File(filename);
        try (Scanner scan = new Scanner(f)) {
            name = scan.nextLine();
            description = scan.nextLine();
            color = scan.nextLine();
            population = scan.nextInt();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Reads multiple objects from the same file
    public void read(Scanner scan) {
        if (scan.hasNext()) {
            name = scan.nextLine();
            description = scan.nextLine();
            color = scan.nextLine();
            population = scan.nextInt();
        }
    }

    // Write house's name and population to file
    public void write(String filename) {

        try (FileWriter f = new FileWriter(filename)) {
            f.write(name + "\n" + description + "\n" + color + "\n" + population + "\n");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Write to file with FileWriter object
    public void write(FileWriter f) {
        try {
            f.write(name + "\n" + description + "\n" + color + "\n" + population + "\n");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    // Creates houses.txt and populates it with default information
    public static void createHouses(String filename) {
        try (FileWriter f = new FileWriter(filename)) {
            f.write("Hufflepuff\n" + "Hufflepuff is known for having members that are patient, fair, hard-working, and sometimes blandly nice.\n" + "yellow\n" + 0 + "\n");
            f.write("Slytherin\n" + "Slytherins tend to be ambitious, shrewd, cunning, strong leaders, and achievement-oriented.\n" + "green\n" + 0 + "\n");
            f.write("Gryffindor\n" + "Gryffindor is know to have the traits of courage as well as daring, nerve, and chivalry. Very Brave.\n" + "red\n" + 0 + "\n");
            f.write("Ravenclaw\n" + "Ravenclaws possess the traits of cleverness, wisdom, wit, intellectual ability and creativity.\n" + "blue\n" + 0 + "\n");        
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
