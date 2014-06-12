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



public class StudentInfoButton extends JFrame implements ActionListener{
   
   private String modNameofTxt;
   private JTextField Name ;
   private JTextField NameCalledBy;
   
   private JComboBox GradeNumber = new JComboBox(new DefaultComboBoxModel(new String[] {"Fifth Year Senior","12", "11", "10", "9", }));
   
   private JTextField Birthday;
   private JTextField Email ;
   private JTextField CellNumber;
   private JTextField ParentEmail;  
   private JTextField ParentNumber ;
   private JTextArea GeneralComments;
   
   private PrintStream printOut;
  
   JButton nextStudentButton = new JButton("Next Student");
   JButton doneButton = new JButton("Done");   
   
    
   public StudentInfoButton(String modNameofTxt){
      this.modNameofTxt = modNameofTxt;
         
         
      JFrame frame = new JFrame();
      
      JLabel labelName = new JLabel("Name: ");
      JLabel labelNameCalledBy = new JLabel("Name Called by: ");
      JLabel labelGradeNumber = new JLabel("Grade Number: ");
      JLabel labelBirthday = new JLabel("Birthday (DD/MM/YY): ");
      JLabel labelEmail = new JLabel("Email: ");
      JLabel labelCellNumber = new JLabel("Cell Number: ");
      JLabel labelPEmail = new JLabel("Parents Email: ");
      JLabel labelPNumber = new JLabel("Parents Number: ");
      JLabel labelGC = new JLabel("General Comments: ");
   
      
      this.Name = new JTextField(10);
      this.NameCalledBy = new JTextField(10);
      this.GradeNumber.setSelectedIndex(4);
      this.Birthday = new JTextField(10);
      this.Email = new JTextField(10);
      this.CellNumber = new JTextField(10);
      this.ParentEmail = new JTextField(10);  
      this.ParentNumber = new JTextField(10);
      this.GeneralComments = new JTextArea(2,10);
      
      this.ParentNumber.setText("(###)-###-####");
      this.CellNumber.setText("(###)-###-####");
   	
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
      
      
      // JButton doneButton = new JButton("Done");    
      frame.add(doneButton);
      //if click done pop up a "are you sure" Yes/No button
      //if yes save student info on page to array with serializing t != 1 
      //if no then pop up disappears and t still equals 1    
      // JButton nextStudentButton = new JButton("Next Student");
      frame.add(nextStudentButton);
      //Save the data in array and then cleared
      
         
      frame.setSize(700, 700);
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.setLayout(new GridLayout(10,2));
      frame.setVisible(true);
         
      doneButton.setActionCommand("Done");
      nextStudentButton.setActionCommand("Next Student"); 
      
      try{  
         File outputFile = new File(this.modNameofTxt);
         PrintStream printOut = new PrintStream(outputFile);
         this.printOut = printOut;
      }
      catch(IOException e){
         System.out.print("error IO");
      }
      nextStudentButton.addActionListener(this); 
      doneButton.addActionListener(this);
         
               	   
   }
   
   public void actionPerformed (ActionEvent evt){
   
      Object src = evt.getSource();  
      if(src == doneButton){  
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
         
         for(int i = 0; i < dataSet.length - 1; i++){
            System.out.print(dataSet[i] + ",");  
            this.printOut.print(dataSet[i] + ",");  
         }
            
         System.out.println(dataSet[8]);
         this.printOut.println(dataSet[8]);
         System.out.println();
            
         this.printOut.close(); 
         
         int choice = JOptionPane.showConfirmDialog(null, "Are you sure your Done?");
         if(choice == JOptionPane.YES_OPTION){
            System.out.print("Done");
            System.exit(0);
         }
         
      }
      else if (src == nextStudentButton){
      
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
         
         for(int i = 0; i < dataSet.length - 1; i++){
            System.out.print(dataSet[i] + ","); 
            this.printOut.print((dataSet[i] + ","));   
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
   } 
}

class DataStudent{
   public static void main(String [] args){
      StudentInfoButton window1 = new StudentInfoButton("Txt.txt");
   }

}