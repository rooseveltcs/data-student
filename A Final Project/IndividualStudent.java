/*
* Is accessed when the Retrieve Button is clicked. Depending on if the client clicks the button
* individualButton or massButton the code checks the user's click descion and then in ActionListener  
* an if statement takes the user to IndividualStudent info class or pulls up the mass printout 
* or just the raw data
*/

/*
* The purpose of this class was to create a button screen that the user can easily click on and then 
* access the data. This class then displays the data in a Drawingpanel.
*/

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;
import java.io.*;

public class IndividualStudent extends JFrame implements ActionListener{
   //This initializes the array list that I will add the buttons 
   //to that I create using the namelabel Array list
   private final ArrayList<JButton> buttons = new ArrayList<JButton>();
   //This Array list is from RetrieveButton and is a field variable 
   private ArrayList<String> nameLabels;
   //This is the name of the txt files I will be manipulating
   private String modNameofTxt;
   
   /*
   *This initializes the nameLabel Array as well as the txt name
   * and calls the initGUI method.
   */
   public IndividualStudent(ArrayList<String> nameLabels, String modNameofTxt){
      super();
      this.modNameofTxt = modNameofTxt;
      this.nameLabels = nameLabels;
      initGUI();
    
      
   }
   /*
   * initGUI stands for initializing the GUI for the names of in the array list 
   * picked out from the previous class. It takes in nameLabels therefore as a parameter 
   * and creates individaul buttons for each name in the nameLables. While adding the button
   * a actionlistener is also attached that then sends the code to the method actionListener 
   * that is overridden in this class. 
   * Creates buttons in a JFrame and a JPanel that interact to diplay the buttons. 
   * The buttons are 
   */
   public void initGUI() {
      JFrame frame = new JFrame("StudentInfo");
      frame.setPreferredSize(new Dimension(1000,1000));
      frame.setLayout(new FlowLayout());
      JPanel panel = new JPanel();
      panel.setPreferredSize(new Dimension(1000, 1000)); 
      for (int i = 0; i < this.nameLabels.size(); i++) {
         String name = this.nameLabels.get(i);
         //name label point = button name now
         JButton button = new JButton(name);
         button.setActionCommand(name);
         button.addActionListener(this);
         buttons.add(button);
         panel.add(button);
      }  
      System.out.println(this.nameLabels);
      frame.add(panel);
      frame.pack();
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.setVisible(true);
   }       
   
   /*
   * When a button is clicked, its the source from which button was clicked is checked.
   * This command is stored in actionCommand where it checks the which button was pressed 
   * thus knows the name of the button. The method then enters a while loop that checks 
   * and if a file has a next line by using a scanner. It then checks the first (0) split place 
   * of the line and compares to the name of the button clicked. If true then it passes the 
   * line on the txt file as a parameter to the method displayInfo.
   * Method has try and catch exception becayse actionPerformed is an inherited method and is
   * persnickity about FileNotFoundException.   
   */
   public void actionPerformed(ActionEvent e) {
      try{
         Scanner file = new Scanner(new File(this.modNameofTxt));
         String actionCommand = ((JButton) e.getSource()).getActionCommand();
         
         while(file.hasNextLine() == true){
         
            String line = file.nextLine();
                  
            if(line == null){
               break;
            }                     
            String split[] = line.split(">");
            String name = split[0];  
            System.out.println(line);
            
            if(name.equals(actionCommand)){
               displayInfo(line);
            }
         } 
      }
      catch(FileNotFoundException c){
         System.out.println("File not found exception");
      }
   }
   
   /*
   *This method is called in ActionPerformed it is the actual display 
   *panel of student information when the button for a student is clicked.
   */
   public static void displayInfo(String line){
   
      JFrame frame = new JFrame("StudentInfo");
      frame.setPreferredSize(new Dimension(1000,1000));
      frame.setLayout(new FlowLayout());
      JPanel panel = new JPanel();
      panel.setPreferredSize(new Dimension(1000, 1000));
       
      String[] dataSet = {"Name: ", "Name Called By: ", "Grade Number: ", "Birthday: ", "Email: ", "Cell Number: ", "Parent Email: ", "Parent Number: ", "General Comments: "};
      String split[] = line.split(">");
      String txt = "";  
      int panelHeight = 500;
      DrawingPanel p = new DrawingPanel(780, panelHeight);
      Graphics g = p.getGraphics(); 
      for(int i = 1; i < dataSet.length; i++){
         g.drawString(dataSet[i] + split[i], 10, 10 + (i * 15));
      }
   }
   
}

/*
* Tests the txt test123.txt and the names in it by creating a fake but accurate array 
* to the file
*/
class IndividualStudentTester {
   public static void main(String[] args){
      ArrayList<String> nameLabels = new ArrayList<String>();
      nameLabels.add("John");
      nameLabels.add("Spencer");
      nameLabels.add("Peter");
      nameLabels.add("Rena");
      nameLabels.add("Jody");
   
      IndividualStudent window1 = new IndividualStudent(nameLabels, "math1.txt");
   }
}            

   

