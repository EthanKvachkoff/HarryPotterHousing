// Class Questions, C211 Group Project, Spring 2023
// Author: Catlin Kramka
package application;

public class Questions {
    //Instance variables
    int points;
   
    String prompt;
    
    String answers[];
   
    House house;

    //Non-default constructor
    public Questions(String prompt, String answer[], House house, int points) {
        super();
        this.prompt = prompt;
        this.answers = null;
        this.house = house;
        this.points = points;     
    }

    /**
     * @return the points
     */
    public int getPoints() {
        return points;
    }

    /**
     * @param points the points to set
     */
    public void setPoints(int points) {
        this.points = points;
    }

    /**
     * @return the prompts
     */
    public String getPrompt() {
        return prompt;
    }

    /**
     * @param prompts the prompts to set
     */
    public void setPrompt(String prompt) {
        this.prompt = prompt;
    }

    /**
     * @return the answers
     */
    public String[] getAnswers() {
        return answers;
    }

    /**
     * @param answers the answers to set
     */
    public void setAnswers(String answerss[]) {
        this.answers = answerss;
    }
    
    public House calulateHouse () {
        return house;       
    }
}
