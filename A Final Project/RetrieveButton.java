/**
* DataStudent2.java
* Assignment: This assignment is for use by teachers who collect their students data at the 
* beginning of the year. The teachers can save the data in a txt and then can have the data 
* easily accessible when they want it. 
* data at the beginning of the year. 
* Purpose: To practice how to create a simple data base to which one can pull information from.
* @version 6/7/14
* @author John Dale
*/

/*
* Is accessed when the Retrieve Button is clicked. Depending on if the client clicks the button
* individualButton or massButton the code checks the user's click descion and then in ActionListener  
* an if statement takes the user to IndividualStudent info class or pulls up the mass printout 
* or just the raw data
*/

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;
import java.io.*;

public class RetrieveButton extends JFrame implements ActionListener {
   //initializes the txt I use and modify, initializes the JButtons and JFrame so it can be accesed 
   //throughout the class
   private String modNameofTxt;
   private JButton individualButton = new JButton("Individual Data Print Out"); 
   private JButton massButton = new JButton("Full Data Set Print Out");
   JFrame frame = new JFrame();
   
   /*
   *constructs the txt file from a parameter it was passed from in DataStudent 
   *constructs the two JButtons and the JFrame 
   */   
   public RetrieveButton(String modNameofTxt){
      this.modNameofTxt = modNameofTxt;
      
      frame.setTitle("Individaul or Mass Printout");
      frame.setLayout(new FlowLayout());
   
      individualButton.addActionListener(this);
      massButton.addActionListener(this);
      frame.add(individualButton);
      frame.add(massButton);
      
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.setSize(new Dimension(500, 100));
   
      frame.setVisible(true);
   
   }
   /*
   * Checks the source of the users click and saves as a variable, this variable then determines which if
   * statement to call true and thus call the code
   * If user clicks individual Button then they are taken to Individual student class 
   * If user clicks mass print out then it prints the data in raw data form.
   */
   public void actionPerformed(ActionEvent evt) {
      Object src = evt.getSource();
      if(src == individualButton){
         try{
            //scanner scans the file so I can acess tokens
            Scanner file = new Scanner(new File(this.modNameofTxt));
            //arraylist created so I can save the names I retrieve from the file
            ArrayList<String> nameLabels = new ArrayList<String>();
            //while the file has a line, the scanner operates and grabs a line 
            //it then splits the line based on the symbol and then takes the first split
            //and saves it in the array list                               
            while(file.hasNextLine() == true){
            
               String line = file.nextLine();
                  
               if(line == null){
                  break;
               }                     
               String split[] = line.split(">");
               String name = split[0];  
               System.out.println(line);
               nameLabels.add(name);
            } 
            
            Collections.sort(nameLabels);
               
            IndividualStudent window1 = new IndividualStudent(nameLabels, this.modNameofTxt);
            
         }
         catch(IOException d){
            System.out.println("Dang IOException");
         }
      }
      else{
         //accesses the file and opens it. 
         Desktop dT = Desktop.getDesktop();
         try {
            dT.open(new File(this.modNameofTxt) );
         } 
         catch (IOException e) {
         	
            e.printStackTrace();
         }
      }
   }
   
}

class RetrieveButtonTester{
   public static void main(String [] args){
      RetrieveButton window1 = new RetrieveButton("math1.txt");
   }

}