// Class UserList, C211 Group Project, Spring 2023
// Authors: Catlin Kramka/Zach Butler/Ethan Kvachkoff

package application;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class UserList {

    // Instance variables
    ArrayList<User> users;

    // Default constructor
    public UserList() {
        this.users = new ArrayList<User>();
    }

    // Reads each user object from file
    public void read(String filename) {
        File f = new File(filename);
        try (Scanner scan = new Scanner(f)) {
            for (User u : users) {
                if (scan.hasNext()) {
                    u.read(scan);
                    scan.nextLine();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Write user's id, name, pet, and house to file
    public void write(String filename) {

        try (FileWriter f = new FileWriter(filename)) {
            for (User u : users) {
                u.write(f);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Returns user with matching id
    public User findUser(int id) {
        for (User u : users) {
            if (u.getId() == id)
                return u;
        }
        return null;
    }

    // Displays info of user with matching id if found
    public void userDisplay(int id) {
        User u = findUser(id);

        if (u == null) {
            System.out.println("User with id " + id + " not found.");
        } else {
            System.out.println("ID: " + u.id);
            System.out.println("Name: " + u.name);
            System.out.println("Pet: " + u.pet);
            System.out.println("House: " + u.getHouse().name);
            System.out.println();
        }

    }

    // Method reads from users text file and puts each user into array list
    public static UserList grabUsers() {
        UserList userList = new UserList();
        String name = "";
        String pet = "";
        String house = "";
        int id = 0;

        try {
            Scanner scanner = new Scanner(new File("users.txt"));

            while (scanner.hasNextLine()) {
                id = Integer.parseInt(scanner.nextLine());
                if (id >= 0) {
                    name = scanner.nextLine();
                    house = scanner.nextLine();
                    pet = scanner.nextLine();
                    User user = new User(id, name, pet, new House(house, "", "", 0));
                    userList.users.add(user);
                }
            }
            scanner.close();
            return userList;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
