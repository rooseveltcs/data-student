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

import java.util.Collections;


public class RetrieveButton extends JFrame implements ActionListener {
   private String modNameofTxt;
   JButton individualButton = new JButton("Individual Data Print Out"); 
   JButton massButton = new JButton("Full Data Set Print Out");
   
   
   public RetrieveButton(String modNameofTxt){
      this.modNameofTxt = modNameofTxt;
      
      JFrame frame = new JFrame();
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.setSize(new Dimension(500, 100));
      frame.setTitle("Individaul or Mass Printout");
      frame.setLayout(new FlowLayout());
         
      individualButton.addActionListener(this);
      massButton.addActionListener(this);
      frame.add(individualButton);
      frame.add(massButton);
      frame.setVisible(true);
      //enter Individual info button
         
      // IndividualButton.setBackground(Color.ORANGE);
      //MassButton.setBackground((new Color(31, 190,214)));
      //full txt info button
   
   }
   
   public void actionPerformed(ActionEvent evt) {
      Object src = evt.getSource();
      if(src == individualButton){
         try{
            
            FileInputStream fileObject = new FileInputStream(this.modNameofTxt);
            DataInputStream dataObject = new DataInputStream(fileObject);
            BufferedReader getData = new BufferedReader(new InputStreamReader(dataObject));
            
            ArrayList<String> nameLabels = new ArrayList<String>();
            
            while(getData.readLine() != null){
               do{
                  String line = getData.readLine();
                  
                  if(line == null){
                     break;
                  }                     
                  String split[] = line.split(",");
                  System.out.println(split[0]);
                  String name = split[0];  
                  nameLabels.add(name);
                                  
               }while(true);
               dataObject.close();
               Collections.sort(nameLabels);
               
              IndividualStudent window1 = new IndividualStudent(nameLabels, this.modNameofTxt);
            }
            
         }
         catch(IOException d){
            System.out.println("Dang IOException");
         }
         
      }
      else{
         Desktop dt = Desktop.getDesktop();
         try {
            dt.open(new File(this.modNameofTxt) );
         } 
         catch (IOException e) {
         	
            e.printStackTrace();
         }
      
      }
   }
   
}

class DataStudent{
   public static void main(String [] args){
      RetrieveButton window1 = new RetrieveButton("test123.txt");
   }

}