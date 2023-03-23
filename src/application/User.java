package application;

public class User {

    // Instance variables
    String name, pet;
    
    //Aggregation relationship
    private House house;
    
    //Non-default constructor
    public User(String name, String pet, House house) {
        super();
        this.name = name;
        this.pet = pet;
        this.house = house;
    }
    
    // Get methods
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
    public void setName(String name) {
        this.name = name;
    }
    
    public void setPet(String pet) {
        this.pet = pet;
    }
    
    public void setHouse(House house) {
        this.house = house;
    }
}

