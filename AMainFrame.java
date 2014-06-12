import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;
import java.io.PrintWriter;
import java.io.File;
import java.awt.event.*;
import java.io.*;
import javax.swing.JMenuBar;


public class AMainFrame{

   public static void main(String[] args) {
      beginning();
      // StudentInfo window = new StudentInfo();
   
   
   }
    /*
    *Writes the first two buttons of the program
    **/
   public static void beginning(){
   
      JFrame frame = new JFrame();
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.setSize(new Dimension(500, 100));
      frame.setTitle("DataStudent");
      frame.setLayout(new FlowLayout());
     
     //enter student info button
      JButton enterButton = new JButton();
      enterButton.setText("Enter Student Information");
      enterButton.setBackground(Color.ORANGE);
      frame.add(enterButton);
      String text1 = "Type the name of the file you want your information saved in (ex. Period1) : ";
      enterButton.addActionListener(new MessageListener(text1,1));
     
     //retrieve student info button
      JButton retrieveButton = new JButton();
      retrieveButton.setText("Retrieve Student Information");
      retrieveButton.setBackground(( new Color(31, 190,214)));
      frame.add(retrieveButton);
      String text2 = "Type the name of the file you want to retrieve information from (ex. Period1) : ";
      retrieveButton.addActionListener(new MessageListener(text2,1));
     
      frame.setVisible(true);
     
   }
   
   
}

class MessageListener implements ActionListener{

   private String text;
   private int source;
   
   
   public MessageListener(String text, int source){
      this.text = text; 
      this.source = source;
   }

   public void actionPerformed (ActionEvent event) {
      if(source == 1){
         String nameofTxt = JOptionPane.showInputDialog(null,this.text);
         String modNameofTxt = (nameofTxt + ".txt") + "";
         System.out.println("EnterStudentData button clicked" + modNameofTxt);
         try{   
            File file = new File(modNameofTxt);
         
            if (file.createNewFile()){
               System.out.println("File is created");
            }
            else{
               System.out.println("File already exists");
            }
         } 
         catch(IOException e) {
            e.printStackTrace();
         }
         
         StudentInfo window = new StudentInfo();
         
        //pop up enter of student info screen
        // StudentInfo gui = new StudentInfo();
        //serialize data
        //txt file is oneline = onestudentinfo
      
      }
      else{
         String nameofTxt = JOptionPane.showInputDialog(null,this.text);
         String modNameofTxt = (nameofTxt + ".txt") + "";
         System.out.println("RetrieveStudentData button clicked");
         //individual or mas printout screen code
         //if(user asks for indivudal data){
         //ask for name of file
            //file is then deserialized into objects stored in arrays
            //print data to a drawing panel
         // }else{
         //somehow have txt file pull up.
         //}
      }
         
     //  System.exit(0);
   }
}
class StudentInfo implements ActionListener{

   public void actionPerformed (ActionEvent e) { 
//       JTextField[] field = {name, calledbyname, gradenumber, birthday, email, cellnumber, parentsemail, parentsnumber};
      String[] labels = {"Name: ", "Name Called by: ", "Grade Number (9-12): ", "Birthday: ", "Email: ", "Cell Number: ", "Parents Email: ", "Parents Number: ", "General Comments: "};
      
      
      JPanel p = new JPanel(new FlowLayout());
      
      for (int i = 0; i < labels.length; i++) {
         JLabel l = new JLabel(labels[i], JLabel.TRAILING);
         p.add(l);
         JTextField textField = new JTextField(10);
         l.setLabelFor(textField);
         p.add(textField);
      
      }
      JFrame frame = new JFrame();
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.setSize(new Dimension(500,500));  
      frame.setTitle("InputScreen");
      frame.setLayout(new GridLayout());
      frame.add(p);
      frame.setVisible(true);
      
      


     //  JInternalFrame Frame = new JInternalFrame();
//       iFrame.setLayout(new GridLayout(8,2));
//    	
//    	 
//    	
//       JLabel label1 = new JLabel("Name: ");
//       JLabel label2 = new JLabel("Last Name");
//       JLabel label3 = new JLabel("Street");
//       JLabel label4 = new JLabel("City");
//       JLabel label5 = new JLabel("State");
//       JLabel label6 = new JLabel("Zip");
//       JLabel label7 = new JLabel("Phone");
//       JLabel label8 = new JLabel("Click Button to Submit Form --&gt;");
//    	
//    	
//       JTextField textfield1 = new JTextField(10);
//       JTextField textfield2 = new JTextField(10);
//       JTextField textfield3 = new JTextField(10);
//       JTextField textfield4 = new JTextField(10);
//       JTextField textfield5 = new JTextField(10);
//       JTextField textfield6 = new JTextField(10);
//       JTextField textfield7 = new JTextField(10);
//       JButton button1 = new JButton("Submit Data"); 		
//    	
//       textfield1.addActionListener(this);
//       textfield2.addActionListener(this);
//       textfield3.addActionListener(this);
//       textfield4.addActionListener(this);
//       textfield5.addActionListener(this);
//       textfield6.addActionListener(this);
//       textfield7.addActionListener(this);
//       button1.addActionListener(this);
//    	
//    	//textfield1.setSize(10, 10);
//    	
//       iFrame.add(label1);
//       iFrame.add(textfield1);
//       iFrame.add(label2);
//       iFrame.add(textfield2);
//       iFrame.add(label3);
//       iFrame.add(textfield3);
//       iFrame.add(label4);
//       iFrame.add(textfield4);
//       iFrame.add(label5);
//       iFrame.add(textfield5);
//       iFrame.add(label6);
//       iFrame.add(textfield6);
//       iFrame.add(label7);
//       iFrame.add(textfield7);
//       iFrame.add(label8);
//       iFrame.add(button1);
//    
//       iFrame.setSize(200, 500);
//       iFrame.setVisible(true);
//    	
//       add(iFrame);
   
   }
}