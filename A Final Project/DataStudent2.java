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
*Writes the first three buttons of the program and directs the student to the various classes
*/

import java.awt.*;
import javax.swing.*;
import java.util.*;
import java.awt.event.*;
import java.io.*;



public class DataStudent2 extends JFrame implements ActionListener{
   //creates the button and initializes the buttons
   JButton enterButton = new JButton("Enter Student Information");
   JButton retrieveButton = new JButton("Retrieve Student Information");
   JButton finalButton = new JButton("Finished with Data Analysis");
   
/*
* constucts the field variables further by adding action listener and adds them to Jframe
*/
   public DataStudent2(){
      JFrame frame = new JFrame();
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.setSize(new Dimension(500, 100));
      frame.setTitle("DataStudent");
      frame.setLayout(new FlowLayout());
     
      finalButton.addActionListener(this);
      enterButton.addActionListener(this);
      retrieveButton.addActionListener(this);
      frame.add(this.enterButton);
      frame.add(this.retrieveButton);
      frame.add(this.finalButton);
   
      frame.setVisible(true);
   }
/*
*checks the source of which button was clicked and saves as src variable
*Then it runs through if statements for various buttons.
*/
   public void actionPerformed(ActionEvent evt) {
      Object src = evt.getSource();
      if(src == enterButton){
         String text1 = "Type the name of the file you want your information saved in (ex. Period1) : ";
         String nameofTxt = JOptionPane.showInputDialog(null,text1);
         String modNameofTxt = (nameofTxt + ".txt").toLowerCase() + "";
         
         try {  
            String fileName = modNameofTxt; 
            File output = new File(fileName); 
            output.createNewFile();
            if (!output.isFile()) { 
               System.out.println("File creation of" + output + "failed");
            }
            StudentInfoButton window = new StudentInfoButton(modNameofTxt);
         }
         catch(IOException d) {
            System.out.println("Error writing to file");
         }
         
      }
      else if(src == retrieveButton){
         String text2 = "Type the name of the file you want to retrieve information from (ex. Period1) : ";
         String nameofTxt = JOptionPane.showInputDialog(null,text2);
         String modNameofTxt = (nameofTxt + ".txt").toLowerCase() + "";
      
         RetrieveButton window = new RetrieveButton(modNameofTxt);  
      }
      else if(src == finalButton){
         System.exit(0);
      }
   }
   
}
//tests the DataStudent2 class
class DataStudent{
   public static void main(String [] args){
      DataStudent2 window1 = new DataStudent2();
   }
}