package application;

public class Questions extends House{
    //Instance variables
    int points;
   
    String prompts;
    
    String answers;

    //Non-default constructor
    public Questions (String prompts, String answers, House house, int points) {
        super();
        this.prompts = prompts;
        this.answers = answers;
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
    public String getPrompts() {
        return prompts;
    }

    /**
     * @param prompts the prompts to set
     */
    public void setPrompts(String prompts) {
        this.prompts = prompts;
    }

    /**
     * @return the answers
     */
    public String getAnswers() {
        return answers;
    }

    /**
     * @param answers the answers to set
     */
    public void setAnswers(String answers) {
        this.answers = answers;
    }
    public double calulateHouse () {
        
    }
}
