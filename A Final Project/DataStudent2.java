import java.awt.*;
import javax.swing.*;
import java.util.*;
import java.awt.event.*;
import java.io.*;

/**
* DataStudent2.java
* Writes the first three buttons of the program and directs the student to the various classes
* @param enterButton goes to StudentInfo button class.
* @param retrieveButton goes to retrieve button class.
* @param finalButton closes the program.
* @version 6/7/14
* @author John Dale
*/

public class DataStudent2 extends JFrame implements ActionListener{
   //creates the button and initializes the buttons
   JButton enterButton = new JButton("Enter Student Information");
   JButton retrieveButton = new JButton("Retrieve Student Information");
   JButton finalButton = new JButton("Finished with Data Analysis");
   
   /**
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
   * Checks the source of which button was clicked and saves as src variable
   * Then it runs through if statements for various buttons.
   * @param src equals the source of the button clicked.
   * @param modNameofTxt equals the name of the txt the user enters modified
   * @param modNameofTxt is the name of the JOptionPane that the user enters name of txt into.
   * @exception d catches io Exceptions that may be created by creating the file
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
/**
* runs the DataStudent2 class
*/
class DataStudent{
   public static void main(String [] args){
      DataStudent2 window1 = new DataStudent2();
   }
}