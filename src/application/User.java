// Class User, C211 Group Project, Spring 2023
// Author: Zach Butler
package application;

import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;

public class User {

    // Instance variables
	int id;
    String name, pet;
    
    
    //Aggregation relationship
    private House house;
    
    //Non-default constructor
    public User(int id, String name, String pet, House house) {
        super();
        this.id = id;
        this.name = name;
        this.pet = pet;
        this.house = house;
    }
    
    // Get methods
    public int getId() {
    	return id;
    }
    
    public String getName() {
        return name;
    }
    
    public String getPet() {
        return pet;
    }
    
    public House getHouse() {
        return house;
    }
    
    // Set methods
    public void setId(int id) {
    	this.id = id;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public void setPet(String pet) {
        this.pet = pet;
    }
    
    public void setHouse(House house) {
        this.house = house;
    }
    
    public void assignPet(House house) { 
        if (house.getName() == "Slytherin") {
            setPet("Snake");
        }else if (house.getName() == "Hufflepuff") {
            setPet("Cat");     
        }else if (house.getName() == "Gryfindor") {
            setPet("Owl");     
        }else if (house.getName() == "Ravenclaw"){
            setPet("Toad");       
        } else {
           System.out.println("No suitable house found. Cant assign a pet."); 
        }
    }
    
 // Reads user's id, name, pet, and house from given file
    public void read(String filename) {
        File f = new File(filename);
        try (Scanner scan = new Scanner(f)) {
        	id = scan.nextInt();
            name = scan.nextLine();
            pet = scan.nextLine();
            house.name = scan.nextLine();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Reads multiple objects from the same file
    public void read(Scanner scan) {
        if (scan.hasNext()) {
        	id = scan.nextInt();
            name = scan.nextLine();
            pet = scan.nextLine();
            house.name = scan.nextLine();
        }
    }

    // Write user's id, name, pet, and house to file
    public void write(String filename) {

        try (FileWriter f = new FileWriter(filename)) {
            f.write(id + "\n" + name + "\n" + pet + "\n" + house.name + "\n");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Write to file with FileWriter object
    public void write(FileWriter f) {
        try {
            f.write(id + "\n" + name + "\n" + pet + "\n" + house.name + "\n");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

