
# HarryPotterHousing
Group project for C211 Programming 2 at Indiana University Northwest

## Contributors
- Ethan Kvachkoff
- Zach Butler
- Catlin Kramka

### Aim and Purpose

The Harry Potter House Quiz purpose and aim is to allow the user to answer multiple choice questions, 
their selection will generate the Hogwarts House that the user will be placed in based on their selection. 
The user will also be able to look up their ID number to find their house and information associated with that house. 

### Src files

**House.java**  
->Authors: Ethan Kvachoff  
-->Purpose - Class to create house elements  

**HouseArray.java**   
->Authors: Ethan Kvachkoff/Zach Butler/Catlin Kramka  
-->Purpose - To use for the setting of the house tile  

**InfoController.java**  
->Authors: Ethan Kvachkoff/Zach Butler/Catlin Kramka  
-->Purpose - To show user info  

**Main.java**   
->Authors: Ethan Kvachkoff/Zach Butler/Catlin Kramka  
-->Purpose - To launch application and display the main GUI  

**MainController.java**    
->Authors: Ethan Kvachkoff/Zach Butler/Catlin Kramka   
-->Purpose - To initiate the actions the user chooses from the main GUI  

**Questions.java**  
->Authors: Catlin Kramka  
-->Purpose - Class to create questions and find the greatest points earned towards a specific house.  

**QuizController.java**  
->Authors: Ethan Kvachkoff/Zach Butler/Catlin Kramka  
-->Purpose - To initiate the selection of the multiple choice questions, from those selections, calculate what house the user will be placed in.  

**DialogueController.java**  
->Authors: Ethan Kvachkoff/Zach Butler/Catlin Kramka  
-->Purpose - To display an ID field and find user's ID to inform the user of their house and associated house information.  

**User.java**  
->Authors: Zach Butler  
-->Purpose - To create a user  

**UserList.java**  
->Authors: Ethan Kvachkoff/Zach Butler/Catlin Kramka   
-->Purpose - To read and write the users id, house, name and pet  

**InfoController**  
->Authors: Ethan Kvachkoff/Zach Butler/Catlin Kramka  
-->Purpose - Used to communicate with the information GUI  

**MainController**  
->Authors: Ethan Kvachkoff/Zach Butler/Catlin Kramka  
-->Purpose - Used to communicate with the main GUI

**QuizController**  
->Authors: Ethan Kvachkoff/Zach Butler/Catlin Kramka  
-->Purpose - Used to communicate with the quiz GUI  

## HOW TO USE:
 - Start by loading the project in any IDE, Eclipse is recommended. 
 - If you download the .jar you can open the jar to launch it as well. (jdk-19)
 - Make sure to have JAVAFX packages installed on your IDE.
 - RUN the program
 
### Main GUI:
     
 To the right is an about text box that tells the user what quiz they are about to take.
 
 Houses and populations of each house shown to the left.
 
 Refresh Button - Used to refresh the populations of the houses once the quiz has been taken.
 
 After completing the quiz you get a specific ID which can be used to load information on reboot of the GUI. This can be done by typing in your ID and pressing the find button. 
 
 House Information Button - Used to view user's pet/house/name/id after quiz has been taken or entered in their valid ID
 
 Start Quiz Button - Used to start the Quiz
 
 
 ### Quiz GUI:
  - Start by entering in your name you want to go by. 
  - Answer the question by pressing the pull down menu labeled *Select an Answer*
  - Once every field has been filled out you can submit the quiz. View house/user information via the House Information Button. 
  
### Dialogue GUI: 
  - User enters their assigned ID into text field to search for their info. 
  
### Info Box GUI:
  - After ID is entered into the ID text field, user can click User Information button and the ID assigned info of the house will 
  be displayed. 
  
   

#### References
 - Hogwarts logo PNG. Hogwarts Logo Png-Free Transparent PNG Logos. (n.d.). April,2023, 
 	https://www.freepnglogos.com/pics/hogwarts 
 - Hogwarts houses. Harry Potter Wiki. (n.d.). April, 2023, 
    https://harrypotter.fandom.com/wiki/Hogwarts_Houses 
 - YouTube. (2020, April 16). JavaFX scene builder tutorial 36 ComboBox. YouTube. April, 2020, 
     https://www.youtube.com/watch?v=rKv8eavrAio&amp;list=PLWRJvaawlhThdHni0kuEEwuMd4Pu9Wjid&amp;index=83 
    (tutorial to learn how to use list view for the Houses list view box)
