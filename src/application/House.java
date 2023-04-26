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

}
