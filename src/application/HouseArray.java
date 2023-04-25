// Class HouseArray, C211 Group Project, Spring 2023
// Authors: Catlin Kramka/Zach Butler/Ethan Kvachkoff

package application;

import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;

public class HouseArray {

    // Instance variables
    House[] houses;

    // Non-default constructor
    public HouseArray(int numberHouses) {
        this.houses = new House[numberHouses];
        for (int i = 0; i < houses.length; i++) {
            houses[i] = new House();
        }
    }

    // Reads each house object from file
    public void read(String filename) {
        File f = new File(filename);
        try (Scanner scan = new Scanner(f)) {
            for (House h : houses) {
                if (scan.hasNext()) {
                    h.read(scan);
                    scan.nextLine();
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Write house's name, description, color, and population to file
    public void write(String filename) {

        try (FileWriter f = new FileWriter(filename)) {
            for (House h : houses) {
                h.write(f);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Outputs each house from the file in a format that is easy to read
    public void output() {
        for (House h : houses) {
            System.out.println("House: " + h.name);
            System.out.println("Description: " + h.description);
            System.out.println("Color: " + h.color);
            System.out.println("Population: " + h.population);

            System.out.println();
        }
    }

    // Loads each house from file and puts them in houseArray
    public void loadHouse(HouseArray houseArray) {
        houseArray.read("houses.txt");
    }

}