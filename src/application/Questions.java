// Class Questions, C211 Group Project, Spring 2023
// Author: Catlin Kramka
package application;

public class Questions {
    //Instance variables
   
    String prompt;
    
    String answers[];
   

    //Non-default constructor
    public Questions (String prompt, String answers[]) {
        super();
        this.prompt = prompt;
        this.answers = null;  
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
    
}
