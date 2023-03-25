// Class House, C211 Group Project, Spring 2023
// Author: Ethan Kvachkoff
package application;

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
    public House(String theName, String theColor, String descrip, int pop) {
        name = theName;
        description = descrip;
        color = theColor;
        population = pop;      
    }
    
    //Setters
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
    
    //Getters
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
    

}
