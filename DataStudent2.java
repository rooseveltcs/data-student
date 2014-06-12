import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;
import java.io.PrintWriter;
import java.io.File;
import java.awt.event.*;
import java.io.*;
import javax.swing.JMenuBar;
import javax.swing.JComboBox;


/*    
*Writes the first two buttons of the program
**/
public class DataStudent2 extends JFrame implements ActionListener{
   JButton enterButton = new JButton("Enter Student Information");
   JButton retrieveButton = new JButton("Retrieve Student Information");
   
   public DataStudent2(){
      JFrame frame = new JFrame();
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.setSize(new Dimension(500, 100));
      frame.setTitle("DataStudent");
      frame.setLayout(new FlowLayout());
     
     //enter student info butto
      enterButton.addActionListener(this);
      retrieveButton.addActionListener(this);
      frame.add(this.enterButton);
      frame.add(this.retrieveButton);
      frame.setVisible(true);
      //retrieve student info button
      //retrieveButton.setBackground(( new Color(31, 190,214))):
   }
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
      else{
         String text2 = "Type the name of the file you want to retrieve information from (ex. Period1) : ";
         String nameofTxt = JOptionPane.showInputDialog(null,text2);
         String modNameofTxt = (nameofTxt + ".txt").toLowerCase() + "";
         
         RetrieveButton window = new RetrieveButton(modNameofTxt);  
      }
      
   }
   
}

class DataStudent{
   public static void main(String [] args){
      DataStudent2 window1 = new DataStudent2();
   }

}