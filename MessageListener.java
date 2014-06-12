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

public class MessageListener implements ActionListener{

   private String text;
   private int source;
  
   
   
   public MessageListener(String text, int source){
      this.text = text; 
      this.source = source;
   }

   public void actionPerformed (ActionEvent event) {
      if(source == 1){
         
         
         // System.out.println("EnterStudentData button clicked" + modNameofTxt);
      //          
      //          try{   
      //             File file = new File(modNameofTxt);
      //          
      //             if (file.createNewFile()){
      //                System.out.println("File is created");
      //             }
      //             else{
      //                System.out.println("File already exists");
      //             }
      //          } 
      //          catch(IOException e) {
      //             e.printStackTrace();
      //          }
         
         // int t = 1;
      //          while(t == 1){
         //pop up enter of student info screen
         StudentInfo window = new StudentInfo(modNameofTxt);
         //serialize data in StudentInfo class
         //}
        
         //txt file is oneline = onestudentinfo
      
      }
      else if(source == 2){
         
         String modNameofTxt = (nameofTxt + ".txt").toLowerCase() + "";
         System.out.println("RetrieveStudentData button clicked");
         
         JFrame frame = new JFrame();
         frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         frame.setSize(new Dimension(500, 100));
         frame.setTitle("Individaul or Mass Printout");
         frame.setLayout(new FlowLayout());
         
      //enter Individual info button
         JButton IndividualButton = new JButton(); 
         IndividualButton.setText("Individual Data Print Out");
         IndividualButton.setBackground(Color.ORANGE);
         IndividualButton.addActionListener(new Retrieve(1, modNameofTxt));
         frame.add(IndividualButton);
         
      
      //full txt info button
         JButton MassButton = new JButton();
         MassButton.setText("Full Data Set Print Out");
         MassButton.setBackground((new Color(31, 190,214)));
         MassButton.addActionListener(new Retrieve(2,modNameofTxt));
         frame.add(MassButton);
         
         frame.setVisible(true);
         //individual or mas printout screen code
         //if(user asks for indivudal data){
         //String nameofWantedTxt = JOptionPane.showInputDialog(null,"Enter the name of the file you would like to access");
         //ask for name of file
            //file is then deserialized into objects stored in arrayList
            //print data to a drawing panel (cleanly)
         // }else{
            //somehow have txt file opened 
            //or i could just have a scrolling panel with all data printed out in a JPane
         //}
      }
         
      // System.exit(0);
   }
}
