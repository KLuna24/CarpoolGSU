import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

//program allows you to enter time and select a car. it will then give you the amount per hour for each car
//implement item and action
public class Georgiastatecarpool1 extends JFrame implements ItemListener, ActionListener {
  
  //check box
   FlowLayout flowval = new FlowLayout();
   JTextField hoursFieldval = new JTextField(9);
   JLabel hoursLabelval = new JLabel("Enter the time (in hours) you will use our service");
   JCheckBox carBox1 = new JCheckBox("Regular Carpool", false);
   JCheckBox sportscarBox1 = new JCheckBox("Sportscar Carpool", false);
   JCheckBox minivanBox1 = new JCheckBox("Minivan Carpool", false);
   JCheckBox motorcycleBox1 = new JCheckBox("Motorcycle (only 1 passenger)", false);
   JCheckBox suvBox1 = new JCheckBox("Suv Carpool", false);
   JCheckBox petsBox1= new JCheckBox("Pets fee", false);
   JCheckBox nopetsBox1 = new JCheckBox("No pets in carpool ", true);
   
   JLabel main = new JLabel("Georgia State Carpool Service");
    
   Font font1 = new Font("Times New Roman",Font.ITALIC, 25);
   Font font21 = new Font("Times New Roman",Font.PLAIN, 25);
   JLabel labelTotalval = new JLabel("Total equipement");
   JLabel label11 = new JLabel("Select the select the Vehicle ");
   JLabel label22 = new JLabel("Pets?");
   JLabel totalPrice = new JLabel();
   JLabel explainLabel123 = new JLabel();
   int housePriceval = 0;
   int lessonPriceval = 0;
   int equipPriceval = 0;
   int priceval = 0;
   int hours12;
   String outputval = "";
   String equipStringval = "";
   String timeStringval = "";
   String lessonStringval = "";
   public Georgiastatecarpool1()
   {
//menu item value
      super("Menu items");
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      setLayout(flowval);
      ButtonGroup equipmentGroup12 = new ButtonGroup();
      equipmentGroup12.add(carBox1);
      equipmentGroup12.add(sportscarBox1);
      equipmentGroup12.add(minivanBox1);
      equipmentGroup12.add(motorcycleBox1);
      equipmentGroup12.add(suvBox1);
      
      ButtonGroup lessonGroup12 = new ButtonGroup();
      lessonGroup12.add(petsBox1);
      lessonGroup12.add(nopetsBox1);
      add(main);
      add(hoursLabelval);
      add(hoursFieldval);
      add(label11);
      add(carBox1);
      add(sportscarBox1);
      add(minivanBox1);
      add(motorcycleBox1);
      add(suvBox1);
      
      main.setFont(font1);
      label11.setFont(font21);
      label22.setFont(font21);
      totalPrice.setFont(font21);
      
      add(label22);
      add(petsBox1);
      add(nopetsBox1);
      add(labelTotalval);
      add(totalPrice);
      
      totalPrice.setText("$0");
      add(explainLabel123);
      hoursFieldval.addActionListener(this);
      carBox1.addItemListener(this);
      sportscarBox1.addItemListener(this);
      minivanBox1.addItemListener(this);
      motorcycleBox1.addItemListener(this);
      suvBox1.addItemListener(this);
      
      petsBox1.addItemListener(this);
      nopetsBox1.addItemListener(this);
   }
//override method
   @Override
   public void actionPerformed(ActionEvent e1)
   {
      Object sourceval = e1.getSource();
      if(sourceval == hoursFieldval)
      {
        try
        {
           hours12 = Integer.parseInt(hoursFieldval.getText());
        }
        catch(Exception exc12)
        {
           hours12 = 0;
           hoursFieldval.setText("invalid entry");
        }
        housePriceval = hours12 * equipPriceval;
        priceval = housePriceval + lessonPriceval;
        timeStringval = "- for " + hours12 + " hours - ";
        outputval = "$" + priceval;
        totalPrice.setText(outputval);
        outputval = "Rental details: " + equipStringval + timeStringval + lessonStringval;
        explainLabel123.setText(outputval);
      }
   }
   @Override
   public void itemStateChanged(ItemEvent check12)
   {
      Object source12 = check12.getItem();
      int select12 = check12.getStateChange();
      final int HIGH_PRICEval = 20;
      final int MED_PRICEval = 15;
      final int LOW_PRICEval = 7;
      final int PETS_PRICEval = 5;
      if(select12 == ItemEvent.SELECTED)
      {
         if(source12 == carBox1)
         {
         equipStringval = "- car at $" + HIGH_PRICEval + " per hour - " ;
            equipPriceval = HIGH_PRICEval;
         }
         else
            if(source12 == sportscarBox1)
            {
               equipStringval = "- sportscar at $" + HIGH_PRICEval + " per hour - " ;
               equipPriceval = HIGH_PRICEval;
            }
            else
               if(source12 == minivanBox1)
               {
                  equipStringval = " - minivan at $" + MED_PRICEval + " per hour - " ;
                  equipPriceval = MED_PRICEval;
               }
               else
                  if(source12 == motorcycleBox1)
                  {
                     equipStringval = "- motorcycle at $" + MED_PRICEval + " per hour - " ;
                     equipPriceval = MED_PRICEval;
                  }
                  else
                     if(source12 == suvBox1)
                     {
                         equipStringval = " - suv at $" + MED_PRICEval + " per hour - " ;;
                         equipPriceval = MED_PRICEval;
                     }
                     
                              else
                              if(source12 == petsBox1)
                              {
                                 lessonStringval = " - pets @ $" + PETS_PRICEval;
                                 lessonPriceval = PETS_PRICEval;
                              }
                              else
                              {
                                 lessonStringval = " - no pets";
                                 lessonPriceval = 0;
                              }
            housePriceval = hours12 * equipPriceval;
            priceval = housePriceval + lessonPriceval;
            outputval = "$" + priceval;
            totalPrice.setText(outputval);
            outputval = "Carpool Service charge " + equipStringval + timeStringval + lessonStringval;
            explainLabel123.setText(outputval);
        }
     }
     //main method
     public static void main(String[] args)
     {
        Georgiastatecarpool1 frame12 = new Georgiastatecarpool1();
        frame12.setSize(400, 250);
        frame12.setVisible(true);
     }
}


