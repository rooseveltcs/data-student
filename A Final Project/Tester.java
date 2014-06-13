import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;
import javax.swing.*;
import javax.swing.JMenuBar;
import java.io.PrintWriter;
import java.io.File;
import java.io.*;
import java.util.*;
import javax.swing.*;
import javax.swing.JMenuBar;
import java.awt.Component;
import java.awt.Container;


public class Tester {

   public static void main(String[] args){
      int panelHeight = 500;
      DrawingPanel p = new DrawingPanel(780, panelHeight);
      Graphics g = p.getGraphics(); 
      drawGraph(g); 
   }
   
    public static void drawGraph(Graphics g) {
         g.drawString("Jack", 10, 10);
         g.drawString("Jack", 10, 20);
         g.drawString("Jack", 10, 30);
      }  
   } 

