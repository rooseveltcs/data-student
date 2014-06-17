import java.awt.*;
import javax.swing.*;
import java.util.*;
import java.io.*;
import java.awt.event.*;

/**
* DataStudent2.java
* This class is accessed when the student info button is pressed.
* It creates a JFrame that displays so a user can enter their data.
* Once a user has entered their data it then saves the data as a single line in a txt
* The user can either click next or Done. Done will send the client back to the beginning 
* of the program while next will clear the text field and allow for another entry
* @param modNameofTxt is the name of the text file
* @param Name is the variable name of the JTextedField where name is entered into by user
* @param NameCalledBy is the variable name of the JTextedField where NameCalledBy is entered into by user
* @param GradeNumber is the variable name of the JTextedField where GradeNumber is entered into by user
* @param Birthday is the variable name of the JTextedField where Birthday is entered into by user
* @param Email is the variable name of the JTextedField where Email is entered into by user
* @param CellNumber is the variable name of the JTextedField where CellNumber is entered into by user
* @param ParentEmail is the variable name of the JTextedField where ParentEmail is entered into by user
* @param ParentNumber is the variable name of the JTextedField where ParentNumber is entered into by user
* @param GeneralComments is the variable name of the JTextedArea where GeneralComments is entered into by user
* @param printOut is the name PrintStream variable that is created to use between methods easily
* @param nextStudentButton is the name of the JButton for next button
* @param doneButton is the name of the JButton for done button
* @version 6/7/14
* @author John Dale
*/

public class StudentInfoButton extends JFrame implements ActionListener{
   //Is the name of the txt file I will be manipulating
   private String modNameofTxt;
   //Are the names of the points of notice 
   private JTextField Name;
   private JTextField NameCalledBy;
   private JComboBox GradeNumber; 
   private JTextField Birthday;
   private JTextField Email;
   private JTextField CellNumber;
   private JTextField ParentEmail;  
   private JTextField ParentNumber ;
   private JTextArea GeneralComments;
   JFrame frame = new JFrame();
   //Is the name of the PrintStream I use across methods
   private PrintStream printOut;
   //Initializes buttons so that I can use their names across methods
   JButton nextStudentButton = new JButton("Next Student");
   JButton doneButton = new JButton("Done");   
   
   /**
   * This constructor is long and tedious, it is so because it needs 
   * to add individual components for each part. I could maybe run a 
   * for loop with arrays but the data and the names are not always sutible for this. 
   * Besides constructing Jlabels, JButtons and JTextFields, this class adds 
   * actionlisteners to buttons done and next
   * 
   */
   public StudentInfoButton(String modNameofTxt){
      
      this.modNameofTxt = modNameofTxt;
      //creates the labels for each part of the display screen
      JLabel labelName = new JLabel("Name: ");
      JLabel labelNameCalledBy = new JLabel("Name Called by: ");
      JLabel labelGradeNumber = new JLabel("Grade Number: ");
      JLabel labelBirthday = new JLabel("Birthday (DD/MM/YY): ");
      JLabel labelEmail = new JLabel("Email: ");
      JLabel labelCellNumber = new JLabel("Cell Number: ");
      JLabel labelPEmail = new JLabel("Parents Email: ");
      JLabel labelPNumber = new JLabel("Parents Number: ");
      JLabel labelGC = new JLabel("General Comments: ");
   
      //adds JTextFields
      //this.Name, this.NameCalledBy, this.Birthday,this.Email, this.CellNumber, this.ParentEmail, this.GeneralComments
      this.Name = new JTextField(10);
      this.NameCalledBy = new JTextField(10);
      this.GradeNumber  = new JComboBox(new DefaultComboBoxModel(new String[] {"Fifth Year Senior","12", "11", "10", "9", }));
      this.GradeNumber.setSelectedIndex(4);
      this.Birthday = new JTextField(10);
      this.Email = new JTextField(10);
      this.CellNumber = new JTextField(10);
      this.ParentEmail = new JTextField(10);  
      this.ParentNumber = new JTextField(10);
      this.GeneralComments = new JTextArea(2,10);
      
      this.ParentNumber.setText("(###)-###-####");
      this.CellNumber.setText("(###)-###-####");
   	
      //adds all components; labels and textfields
      frame.add(labelName);
      frame.add(this.Name);
      frame.add(labelNameCalledBy);
      frame.add(this.NameCalledBy);
      frame.add(labelGradeNumber);
      frame.add(this.GradeNumber);
      frame.add(labelBirthday);
      frame.add(this.Birthday);
      frame.add(labelEmail);
      frame.add(this.Email);
      frame.add(labelCellNumber);
      frame.add(this.CellNumber);
      frame.add(labelPEmail);
      frame.add(this.ParentEmail);
      frame.add(labelPNumber);
      frame.add(this.ParentNumber);
      frame.add(labelGC);
      frame.add(GeneralComments);
      
      //adds done and nextStudentButton to frame
      frame.add(doneButton);
      frame.add(nextStudentButton);
      //sets logistics for JFrame
      frame.setSize(700, 700);
      frame.setDefaultCloseOperation(HIDE_ON_CLOSE);
      frame.setLayout(new GridLayout(10,2));
      frame.setVisible(true);
      //sets the action commmands for the buttons and saves them useful 
      //for when differeniating between which button clicked
      doneButton.setActionCommand("Done");
      nextStudentButton.setActionCommand("Next Student"); 
      //creates the file and the Printstream so I can print to a file
      //checks to make sure no error and if so designates so by printing to console error.
      try{  
         File outputFile = new File(this.modNameofTxt);
         PrintStream printOut = new PrintStream(outputFile);
         this.printOut = printOut;
      }
      catch(IOException e){
         System.out.print("error IO");
      }
      
      //adds an action listener to both buttons
      nextStudentButton.addActionListener(this); 
      doneButton.addActionListener(this);           	   
   }
   
   /**
   * This method checks what button was pressed and then runs an if 
   * statement depending on the button
   * @param src equals the source of the button clicked.
   */
   public void actionPerformed (ActionEvent evt){
      //gets the source of the button pressed
      Object src = evt.getSource();  
      if(src == doneButton){  
         doneButtonScreen();         
      }
      else if (src == nextStudentButton){
         nextButtonScreen();
      }
   } 
   
   /**
   * Saves the information entered by client as variables saves variables 
   * to array and then prints array to txt
   * then resets txt boxes to orginal format for new enter.
   * @param dataSet is array that holds the string values from the text fields
   */   
   public void nextButtonScreen(){
   
      String Name2 = this.Name.getText();
      String NameCalledBy2 = this.NameCalledBy.getText();
      String GradeNumber2 = this.GradeNumber.getSelectedItem().toString();
      String Birthday2 = this.Birthday.getText();
      String Email2 = this.Email.getText();
      String CellNumber2 = this.CellNumber.getText();
      String ParentEmail2 = this.ParentEmail.getText();
      String ParentNumber2 = this.ParentNumber.getText();
      String GeneralComments2 = this.GeneralComments.getText();
         
      String[] dataSet = {Name2, NameCalledBy2, GradeNumber2, Birthday2, Email2, CellNumber2, ParentEmail2, ParentNumber2, GeneralComments2 };    
      //runs through array and adds data to a line in txt spliting data by the symbol
      for(int i = 0; i < dataSet.length - 1; i++){
         System.out.print(dataSet[i] + ">"); 
         this.printOut.print((dataSet[i] + ">"));   
      }
      System.out.print(dataSet[8]);
      this.printOut.println((dataSet[8])); 
            
             
      this.Name.setText("");
      this.NameCalledBy.setText("");
      this.Birthday.setText("");
      this.Email.setText("");
      this.CellNumber.setText("(###)-###-####");
      this.ParentEmail.setText("");
      this.ParentNumber.setText("(###)-###-####");
      this.GeneralComments.setText("");
      System.out.println("Next");
   
   }
   
   /**
   * Saves the information entered by client as variables saves variables 
   * to array and then prints array to txt as a single line, different parts are 
   * differniated in line by comma or other symbol
   * then checks by yes/no to see if client is done and then exits the program
   * @param dataSet is array that holds the string values from the text fields
   * @param choice is the value of the JOption Screen is the user clicks yes, no or cancel. 
   */
   public void doneButtonScreen(){
   
      String Name2 = this.Name.getText();
      String NameCalledBy2 = this.NameCalledBy.getText();
      String GradeNumber2 = this.GradeNumber.getSelectedItem().toString();
      String Birthday2 = this.Birthday.getText();
      String Email2 = this.Email.getText();
      String CellNumber2 = this.CellNumber.getText();
      String ParentEmail2 = this.ParentEmail.getText();
      String ParentNumber2 = this.ParentNumber.getText();
      String GeneralComments2 = this.GeneralComments.getText();
         
      String[] dataSet = {Name2, NameCalledBy2, GradeNumber2, Birthday2, Email2, CellNumber2, ParentEmail2, ParentNumber2, GeneralComments2 };    
      //runs through array and adds data to a line in txt spliting data by the symbol
      for(int i = 0; i < dataSet.length - 1; i++){
         System.out.print(dataSet[i] + ">");  
         this.printOut.print(dataSet[i] + ">");  
      }
            
      System.out.println(dataSet[8]);
      this.printOut.println(dataSet[8]);
      System.out.println();
            
      this.printOut.close(); 
      //creates a yes or no window for user to choose from
      int choice = JOptionPane.showConfirmDialog(null, "Are you sure your Done?");
      if(choice == JOptionPane.YES_OPTION){
         System.out.print("Done");
         frame.setVisible(false);
         DataStudent2 window1 = new DataStudent2();
      }
   }
}

/**
* Tests the StudentInfoButtonClass
*/
class StudentInfoTester{
   public static void main(String [] args){
      StudentInfoButton window1 = new StudentInfoButton("Txt.txt");
   }
}