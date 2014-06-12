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

public class IndividualStudent extends JFrame implements ActionListener{

   private final ArrayList<JButton> buttons = new ArrayList<JButton>();
   private ArrayList<String> nameLabels;
   private String modNameofTxt;
   
   public IndividualStudent(ArrayList<String> nameLabels, String modNameofTxt){
      super();
      this.modNameofTxt = modNameofTxt;
      this.nameLabels = nameLabels;
      initGUI(this.nameLabels);
    
      
   }

   public void initGUI(ArrayList<String> nameLabels) {
   
      JFrame frame = new JFrame("StudentInfo");
      frame.setPreferredSize(new Dimension(1000,1000));
   
      frame.setLayout(new FlowLayout());
      JPanel panel = new JPanel();
      panel.setPreferredSize(new Dimension(1000, 1000)); 
      for (int i = 0; i < nameLabels.size(); i++) {
         String name = nameLabels.get(i);
         JButton button = new JButton(name);
         
         button.setActionCommand(name);
         button.addActionListener(this);
         buttons.add(button);
         panel.add(button);
      }
            
      System.out.println(nameLabels);
      frame.add(panel);
      frame.pack();
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.setVisible(true);
   
   }       
    
    //x = name clicked
      //read the name on the button
      //read through file and find line
         //if (buttonname == split[0] in line)
            //for each split have it equal a number 
            //that number corelates with a number where it is displayed in the JPanel 
            //JFrame 
   public void actionPerformed(ActionEvent e) {
      try{
         Scanner nameOfButtonClicked = new Scanner(new File(this.modNameofTxt));
         String actionCommand = ((JButton) e.getSource()).getActionCommand();
         while(nameOfButtonClicked.hasNextLine() == true){
         
            String line = nameOfButtonClicked.nextLine();
                  
            if(line == null){
               break;
            }                     
            String split[] = line.split(",");
            String name = split[0];  
         
            if(name.equals(actionCommand)){
               displayInfo(line);
            }
         } 
         System.out.println("Action command for pressed button: " + actionCommand);
      }
      catch(FileNotFoundException c){
         System.out.println("File not found exception");
      }
        // Use the action command to determine which button was pressed
   }
   public static void displayInfo(String line){
      JFrame frame = new JFrame("StudentInfo");
      frame.setPreferredSize(new Dimension(1000,1000));
   
      frame.setLayout(new FlowLayout());
      JPanel panel = new JPanel(new GridLayout(10,2));
      panel.setPreferredSize(new Dimension(1000, 1000));  
      String split[] = line.split(",");
      String name = split[0];  
      for(int i = 0; i < split.length; i++){
         System.out.println(line);
         JTextField field = new JTextField();
         field.setText(split[i]);
         field.setEditable(false);
         panel.add(field);
         
      }
      frame.add(panel);
      frame.pack();
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.setVisible(true);
   }
}

class Tester {
   public static void main(String[] args){
      ArrayList<String> nameLabels = new ArrayList<String>();
      nameLabels.add("Andy Dale");
      nameLabels.add("Blake d");
      nameLabels.add("Cooper Rico");
      nameLabels.add("Dale Caro");
      IndividualStudent window1 = new IndividualStudent(nameLabels, "test123.txt");
   }
}            

   

