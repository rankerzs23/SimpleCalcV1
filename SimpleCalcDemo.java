import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class SimpleCalc extends JFrame implements ActionListener
{
   JLabel lnum1, lnum2, lres;
   JTextField tnum1, tnum2, tres;
   JButton bPlus, bMinus, bTimes, bDiv;
   JPanel p1, p2;
   Container c = getContentPane();
   
   SimpleCalc() //constructor serves as 1. GUI Components
   {
      super("Simple Calculator v1");
      lnum1 = new JLabel("Input num1: ");
      lnum2 = new JLabel("Input num2: ");
      lres = new JLabel("Result: ");
      
      tnum1 = new JTextField(5);
      tnum2 = new JTextField(5);
      tres = new JTextField(5); tres.setEditable(false);
      
      bPlus = new JButton("+"); bPlus.addActionListener(this);
      bMinus = new JButton("-"); bMinus.addActionListener(this);
      bTimes = new JButton("*"); bTimes.addActionListener(this);
      bDiv = new JButton("/"); bDiv.addActionListener(this);
      
      p1 = new JPanel(); p1.setLayout(new GridLayout(3,2));
      p1.add(lnum1); p1.add(tnum1);
      p1.add(lnum2); p1.add(tnum2);
      p1.add(lres); p1.add(tres);
      
      p2 = new JPanel(); p2.setLayout(new GridLayout(1,4));
      p2.add(bPlus); p2.add(bMinus); p2.add(bTimes); p2.add(bDiv);
      
      c.setLayout(new BorderLayout());
      c.add(p1, BorderLayout.CENTER);
      c.add(p2, BorderLayout.SOUTH);

      setDefaultCloseOperation(EXIT_ON_CLOSE);
      setSize(300, 200);
      setResizable(false);
   }
   
   public void actionPerformed(ActionEvent e)//2. Listener Method
   {
      double num1 =0, num2=0, res=0;

      try
      {
         num1 = Double.parseDouble(tnum1.getText());
         num2 = Double.parseDouble(tnum2.getText());
         
         if(e.getSource()==bPlus)
         {
            res = add(num1, num2);
         }
         else
         if(e.getSource()==bMinus)
         {
            res = subtract(num1, num2);
         }
         else
         if(e.getSource()==bTimes)
         {
            res = multiply(num1, num2);
         }
         else
         if(e.getSource()==bDiv)
         {
            res = divide(num1, num2);
         }
         tres.setText(res+"");
      }

      catch(NumberFormatException nfe)
      {
         tres.setText("Boang ka!");
      }
      catch(Exception ex)
      {
      
      }
   }
   
   //3. Application Methods
   public double add(double num1, double num2)
   {
      return num1 + num2;
   }
   public double subtract(double num1, double num2)
   {
      return num1 - num2;
   }
   public double multiply(double num1, double num2)
   {
      return num1 * num2;
   }
   public double divide(double num1, double num2)
   {
      return num1 / num2;
   }
 
}

//--------------------------------------------
public class SimpleCalcDemo
{
   public static void main(String args[])
   {
      SimpleCalc calc = new SimpleCalc();
      calc.setVisible(true); //calc.show();
   }
}