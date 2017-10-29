package 计算器;

import java.awt.*;
import java.awt.event.*;
import java.lang.Math;

class MyCal extends WindowAdapter  implements ActionListener
{
    private Button b[];
    private TextField tf;
    private String tfstr;
    private Frame f;
    private double d1,d2,result;
    private int operator;
    public MyCal(String str)
    {
        f=new Frame(str);
        tf=new TextField();
        f.add("North",tf);
        Panel  p=new Panel();
        p.setLayout(new GridLayout(4,5));
        b=new Button[20];
        String s[]={"1","2","3","Root","AC","4","5","6","*","-","7","8","9","/","+",".","0","x^y","log10","="};
        for (int i=0;i<b.length;i++)
        {
          b[i]=new Button(s[i]);
          b[i].addActionListener(this);
          p.add(b[i]);
         }
        f.add(p);
        f.setSize(300,400);
        f.addWindowListener(this);
        f.setResizable(false);
        f.setVisible(true);
    }
      public void windowClosing(WindowEvent e)
      {
        System.exit(0);
      }
      public void actionPerformed(ActionEvent e)
      {
            tfstr=tf.getText();
            String s=e.getActionCommand();
            if (s.equals("+"))
            {
              d1=Double.parseDouble(tfstr);
              tfstr="";
              tf.setText(tfstr);
              operator=1;
            }
            else if(s.equals("="))
            {
              if(operator==1)
              {
                d2=Double.parseDouble(tfstr);
                result=d1+d2;
                tfstr=Double.toString(result);
                tf.setText(tfstr);
              }
              if(operator==2)
              {
                d2=Double.parseDouble(tfstr);
                result=d1-d2;
                tfstr=Double.toString(result);
                tf.setText(tfstr);
              }
              if(operator==3)
              {
                d2=Double.parseDouble(tfstr);
                result=d1*d2;
                tfstr=Double.toString(result);
                tf.setText(tfstr);
              }
              if(operator==4)
              {
                d2=Double.parseDouble(tfstr);
                result=d1/d2;
                tfstr=Double.toString(result);
                tf.setText(tfstr);
              }
              if(operator==5)
              {
                d2=Double.parseDouble(tfstr);
                result=Math.pow(d1,d2);
                tfstr=Double.toString(result);
                tf.setText(tfstr);
              }
              if(operator==6)
              {
                result=Math.log10(d1);
                tfstr=Double.toString(result);
                tf.setText(tfstr);
              }
              if(operator==7)
              {
                result=Math.sqrt(d1);
                tfstr=Double.toString(result);
                tf.setText(tfstr);
              }
            }
            else if(s.equals("-"))
            {
              if(tfstr.equals(""))
              {
                d1=0.0;
                tfstr="";
                tf.setText(tfstr);
              }
              else
              {
                d1=Double.parseDouble(tfstr);
                tfstr="";
                tf.setText(tfstr);
              }
              operator=2;
            }
            else if(s.equals("*"))
            {
              d1=Double.parseDouble(tfstr);
              tfstr="";
              tf.setText(tfstr);
              operator=3;
            }
            else if(s.equals("/"))
            {
              d1=Double.parseDouble(tfstr);
              tfstr="";
              tf.setText(tfstr);
              operator=4;
            }
            else if(s.equals("AC"))
            {
              tf.setText("");
            }
            else if(s.equals("x^y"))
            {
              d1=Double.parseDouble(tfstr);
              tfstr="";
              tf.setText(tfstr);
              operator=5;
            }
            else if(s.equals("log10"))
            {
              d1=Double.parseDouble(tfstr);
              tfstr="";
              tf.setText(tfstr);
              operator=6;
            }
            else if(s.equals("Root"))
            {
              d1=Double.parseDouble(tfstr);
              tfstr="";
              tf.setText(tfstr);
              operator=7;
            }
            else
            {
              tfstr+=s;
              tf.setText(tfstr);
            }

      }
}
public class  Test
{
    public  static void main(String a[])
    {
      MyCal my=new MyCal("calculator");
    }
}
