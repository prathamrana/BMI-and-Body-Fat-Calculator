///BMI Calculator 
//Pratham Rana

import java.awt.*; 
import java.awt.event.*;
import javax.swing.*; 
import java.text.DecimalFormat;

public class BMICalculator implements ActionListener{
//All the declarations
   private JFrame frame;
   private JLabel height, inches, heinches, feet, weight, waist, pounds, neck, ninches, hips, hinches, title;
   private JLabel activity, ac2, bmi, wth, bfp, lbm, activitylabel, blank, bmiText, dietText;
   private JTextField intext, ftext, ptext, wtext, ntext, htext;
   private JRadioButton genderM, genderF, se, mo, ac;
   private ButtonGroup genderGroup, activityGroup;
   private JButton Clear, Calc;
   private double ft, in, lbs, wai, ne, hi, metricheight, metricwai, metrichi, metricne, fheight, bodymassindex;
   private double waisttoheight, bodyfatpercent, fatmass, leanmass, metricweight;
   
   //Default constructor
   public BMICalculator(){
   //All the settings of the variables.
      frame = new JFrame("BMI And Body Fat Calculator");
      title = new JLabel("U.S. Units only");
      height = new JLabel("Height:  ");
      intext = new JTextField(5);
      double in = 0.0;
      ftext = new JTextField(5);
      double ft = 0.0;
      feet = new JLabel("feet ");
      inches = new JLabel("inches ");
      weight = new JLabel("Weight:");
      pounds = new JLabel("pounds");
      ptext = new JTextField(5);
      double lbs = 0.0;
      waist = new JLabel("Waist:  ");
      wtext = new JTextField(5);
      double wai = 0.0;
      neck = new JLabel("Neck:  ");
      ninches = new JLabel("inches");
      ntext = new JTextField(5);
      double ne = 0.0;
      hips = new JLabel("Hips (Female only): ");
      htext = new JTextField(5);
      double hi = 0.0;
      hinches = new JLabel("inches");
      heinches = new JLabel("inches");
      bmi = new JLabel();
      wth = new JLabel();
      bfp = new JLabel();
      lbm = new JLabel();
      blank = new JLabel("             ");
      activitylabel = new JLabel();
      bmiText = new JLabel();
      dietText = new JLabel();
      genderM = new JRadioButton("Male", false );
      genderF = new JRadioButton("Female", false );
      activity = new JLabel("Level of activity: ");
      se = new JRadioButton("Sedentary", false);
      mo = new JRadioButton("Moderate", false);
      ac = new JRadioButton("Active", false);
      ac2 = new JLabel("Activity:");
      Clear = new JButton("Clear");
      Calc = new JButton("Calculate");
      
      //buttongroup for the gender Radiobuttons
      genderGroup = new ButtonGroup();
      genderGroup.add( genderM );
      genderGroup.add( genderF );
      
      //buttongroup for the activity Radiobuttons
      activityGroup = new ButtonGroup();
      activityGroup.add(se);
      activityGroup.add(mo);
      activityGroup.add(ac);
      
      //Panel 1 for the title 
      JPanel panel1 = new JPanel(new GridLayout(2,3));
      panel1.add(title);
      
      //Panel 2 for the height
      JPanel panel2 = new JPanel(new FlowLayout());
      panel2.add(height);
      panel2.add(ftext);
      panel2.add(feet);
      panel2.add(intext);
      panel2.add(heinches);
      
      //Panel 3 for the weight
      JPanel panel3 = new JPanel(new FlowLayout());
      panel3.add(weight);
      panel3.add(ptext);
      panel3.add(pounds);
      
      //Panel 4 for the waist
      JPanel panel4 = new JPanel(new FlowLayout());
      panel4.add(waist);
      panel4.add(wtext);
      panel4.add(inches);
      
      //Panel 5 for the neck
      JPanel panel5 = new JPanel(new FlowLayout());
      panel5.add(neck);
      panel5.add(ntext);
      panel5.add(ninches);
      
      //Panel 6 for the hips
      JPanel panel6 = new JPanel(new FlowLayout());
      panel6.add(hips);
      panel6.add(htext);
      panel6.add(hinches);
      
      //Panel 7 for the sex RadioButtons
      JPanel panel7 = new JPanel(new FlowLayout());
      panel7.add(new JLabel("Sex: "));
      panel7.add(genderM);
      panel7.add(genderF);
      
      //Panels 8-9 for the Level of Activity RadioButtons
      JPanel panel8 = new JPanel();
      panel8.setLayout(new BoxLayout(panel8, BoxLayout.Y_AXIS));
      panel8.add(se);
      panel8.add(mo);
      panel8.add(ac);
      
      JPanel panel9 = new JPanel();
      panel9.setLayout(new BoxLayout(panel9, BoxLayout.Y_AXIS));
      panel9.add(new JLabel("Level of"));
      panel9.add(ac2);
      
      //Panel 10 is to organize the previous panels into one
      JPanel panel10 = new JPanel(new FlowLayout());
      panel10.add(panel9);
      panel10.add(panel8);
      
      //Panel 11 is the buttons
      JPanel panel11 = new JPanel(new FlowLayout());
      panel11.add(Clear);
      panel11.add(Calc);
      //Actionlistener for all the buttons and radiobuttons
      Clear.addActionListener(this);
      Calc.addActionListener(this);
      
      //Male radiobutton actionlistener
      genderM.addActionListener(
         new ActionListener(){
            public void actionPerformed(ActionEvent m){
               if(genderM.isSelected()){
                  htext.setEditable(false);
                  htext.setText("0");
               }
            }
         }
      );
      
      //female radiobutton actionlistener
      genderF.addActionListener(
         new ActionListener(){
            public void actionPerformed(ActionEvent f){
               if(genderF.isSelected()){
                  htext.setEditable(true);
               } 
           }
         }
      );
      
      //panel 12 for all the labels that have undergone calculations from
      //the actionlistener method.  
      JPanel panel12 = new JPanel();
      panel12.setLayout(new BoxLayout(panel12, BoxLayout.Y_AXIS));
      panel12.add(bmi);
      panel12.add(wth);
      panel12.add(bfp);
      panel12.add(lbm);
      
      //panel 13 for JLabels regarding the information on BMI and other messages related to BMI.
      JPanel panel13 = new JPanel();
      panel13.setLayout(new BoxLayout(panel13, BoxLayout.Y_AXIS));
      panel13.add(bmiText);
      panel13.add(dietText);
      panel13.add(activitylabel);
      
      //The final panel to put everything into a proper Box layout.
      //Helps organize everything.
      JPanel panelfinal = new JPanel();
      panelfinal.setLayout(new BoxLayout(panelfinal, BoxLayout.Y_AXIS));
      panelfinal.add(panel1);
      panelfinal.add(panel2);
      panelfinal.add(panel3);
      panelfinal.add(panel4);
      panelfinal.add(panel5);
      panelfinal.add(panel6);
      panelfinal.add(panel7);
      panelfinal.add(panel10);
      panelfinal.add(panel11);
      panelfinal.add(panel12);
      panelfinal.add(blank);
      panelfinal.add(panel13);
      
      //Frame settings including the type of Layout
      frame.setLayout(new FlowLayout());  
      frame.add(panelfinal);
      frame.setSize(850, 850);
      frame.setVisible(true);
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
   }
   
      public void actionPerformed(ActionEvent a){
      
      //Decimalformat declaration to round the numbers perfectly
      DecimalFormat BMIs = new DecimalFormat("##.#");
      DecimalFormat WTHs = new DecimalFormat("#.##");
      
      //Calculate button action for female gender with sedentary activity
      if(a.getActionCommand().equals("Calculate") && genderF.isSelected() == true && se.isSelected()){
         //converting all the String variables from the textfields
         //into doubles for calculations
         ft = Double.parseDouble(ftext.getText());
         in = Double.parseDouble(intext.getText());
         lbs = Double.parseDouble(ptext.getText());
         wai = Double.parseDouble(wtext.getText());
         ne = Double.parseDouble(ntext.getText());
         hi = Double.parseDouble(htext.getText());
         
         //height declaration to convert the ft and in height
         //into inches only.
         fheight = (ft*12)+in;
         
         //all the metric conversions for other calculations
         metricheight = fheight * 2.54;
         metrichi = hi * 2.54;
         metricne = ne * 2.54;
         metricwai = wai * 2.54;
         metricweight = lbs * 0.45359237;
         
         //bmi formula to calculate bmi
         bodymassindex = 703*lbs/(fheight *fheight);
       String bodymassindexString = "Body mass index:   " + BMIs.format(bodymassindex) + "  lb/in2";
        bmi.setText(bodymassindexString);
        
        //waist to height ratio formula
        waisttoheight = wai/fheight;
        String wthString = "Waist-to-Height ratio:   " + WTHs.format(waisttoheight);
        wth.setText(wthString);
        
        //body fat percent formula.
        //Had to use metric units previously declared to make the calculation less complicated
        bodyfatpercent = 495/(1.29579 - .35004 * Math.log10(metricwai + metrichi - metricne) + 0.22100 * Math.log10(metricheight))-450;
        String fatpercentString = "Percent Body Fat:  " + BMIs.format(bodyfatpercent) + "%";
        bfp.setText(fatpercentString);
        
        //fat mass formula for later use in calculating lean mass.
        fatmass = (bodyfatpercent/100) * lbs;
        
        //lean mass formula for calculating lean mass.
        leanmass = lbs - fatmass;
        String leanmassString = "Lean Body Mass:  " + BMIs.format(leanmass) + " lbs";
        lbm.setText(leanmassString);
        
        //This String declaration is for the activity needed.
        String sedentaryString = "You need to be more active throughout the day.  Walking, jogging, or going to the gym could be great activites in order to stay healthy.";
        activitylabel.setText(sedentaryString);
        
        //These String declarations are for later use in the if else statements regarding BMI.
        String vsunderweight = "Your BMI is way below normal.  You are very severely underweight.";
        String sunderweight = "Your BMI is below normal.  You are severely underweight.";
        String underweight = "Yout BMI is a little below normal.  You are underweight.";
        String normal = "Your BMI is normal.";
        String overweight = "Your BMI is slightly above normal.  You are overweight.";
        String Obese1 = "You are moderately obese.  This is Obese Class I.";
        String Obese2 = "You are severely obese.  This is Obese Class II.";
        String Obese3 = "This is morbid obesity.  You are in Obese Class III.";
        String underweightdiet = "Your diet should contain fats with at least 49-50 grams of protein per day.";
        String normaldiet = "Your diet seems normal but it should contain at least 49-50 grams of protein per day.";
        String obesediet = "Your diet needs to have very little fat with at least 49-50 grams of protein per day.";
        
        //if else statements regarding BMI.
        //Display recommendations regarding diet and other information regarding BMI.
        if(bodymassindex <= 15.0){
          bmiText.setText(vsunderweight);
          dietText.setText(underweightdiet);
        } 
        else if(bodymassindex >=15.0 & bodymassindex<= 16.0){
         bmiText.setText(sunderweight);
         dietText.setText(underweightdiet);
        }
        else if(bodymassindex >=16.0 & bodymassindex<= 18.5){
         bmiText.setText(underweight);
         dietText.setText(underweightdiet);
        }
        else if(bodymassindex >=18.5 & bodymassindex<= 25){
         bmiText.setText(normal);
         dietText.setText(normaldiet);
        }
        else if(bodymassindex >= 25.0 & bodymassindex<= 30.0){
         bmiText.setText(overweight);
         dietText.setText(obesediet);
        }
        else if(bodymassindex >= 30.0 & bodymassindex<= 35.0){
         bmiText.setText(Obese1);
         dietText.setText(obesediet);
        }
        else if(bodymassindex >= 35.0 & bodymassindex<= 40.0){
         bmiText.setText(Obese2);
         dietText.setText(obesediet);
        }
        else if(bodymassindex >= 40){
         bmiText.setText(Obese3);
         dietText.setText(obesediet);
        }
        }
        
        //Calculate button action for female gender with moderate activity
    else if(a.getActionCommand().equals("Calculate") && genderF.isSelected() == true && mo.isSelected()){
         //converting all the String variables from the textfields
         //into doubles for calculations
         ft = Double.parseDouble(ftext.getText());
         in = Double.parseDouble(intext.getText());
         lbs = Double.parseDouble(ptext.getText());
         wai = Double.parseDouble(wtext.getText());
         ne = Double.parseDouble(ntext.getText());
         hi = Double.parseDouble(htext.getText());
         
         //height declaration to convert the ft and in height
         //into inches only.
         fheight = (ft*12)+in;
         
         //all the metric conversions for other calculations
         metricheight = fheight * 2.54;
         metrichi = hi * 2.54;
         metricne = ne * 2.54;
         metricwai = wai * 2.54;
         metricweight = lbs * 0.45359237;
         
         //bmi formula to calculate bmi
         bodymassindex = 703*lbs/(fheight *fheight);
       String bodymassindexString = "Body mass index:   " + BMIs.format(bodymassindex) + "  lb/in2";
        bmi.setText(bodymassindexString);
        
        //waist to height ratio formula
        waisttoheight = wai/fheight;
        String wthString = "Waist-to-Height ratio:   " + WTHs.format(waisttoheight);
        wth.setText(wthString);
        
        //body fat percent formula.
        //Had to use metric units previously declared to make the calculation less complicated
        bodyfatpercent = 495/(1.29579 - .35004 * Math.log10(metricwai + metrichi - metricne) + 0.22100 * Math.log10(metricheight))-450;
        String fatpercentString = "Percent Body Fat:  " + BMIs.format(bodyfatpercent) + "%";
        bfp.setText(fatpercentString);
        
        //fat mass formula for later use in calculating lean mass.
        fatmass = (bodyfatpercent/100) * lbs;
        
        //lean mass formula for calculating lean mass.
        leanmass = lbs - fatmass;
        String leanmassString = "Lean Body Mass:  " + BMIs.format(leanmass) + " lbs";
        lbm.setText(leanmassString);
        
        //This String declaration is for the activity needed.
        String moderateString = "Great job!  You are fairly active througout the day which keeps your body healthy.";
        activitylabel.setText(moderateString);
        
        //These String declarations are for later use in the if else statements regarding BMI.
        String vsunderweight = "Your BMI is way below normal.  You are very severely underweight.";
        String sunderweight = "Your BMI is below normal.  You are severely underweight.";
        String underweight = "Yout BMI is a little below normal.  You are underweight.";
        String normal = "Your BMI is normal.";
        String overweight = "Your BMI is slightly above normal.  You are overweight.";
        String Obese1 = "You are moderately obese.  This is Obese Class I.";
        String Obese2 = "You are severely obese.  This is Obese Class II.";
        String Obese3 = "This is morbid obesity.  You are in Obese Class III.";
        String underweightdiet = "Your diet should contain fats with at least 49-50 grams of protein per day.";
        String normaldiet = "Your diet seems normal but it should contain at least 49-50 grams of protein per day.";
        String obesediet = "Your diet needs to have very little fat with at least 49-50 grams of protein per day.";
        
        //if else statements regarding BMI.
        //Display recommendations regarding diet and other information regarding BMI.
        if(bodymassindex <= 15.0){
          bmiText.setText(vsunderweight);
          dietText.setText(underweightdiet);
        } 
        else if(bodymassindex >=15.0 & bodymassindex<= 16.0){
         bmiText.setText(sunderweight);
         dietText.setText(underweightdiet);
        }
        else if(bodymassindex >=16.0 & bodymassindex<= 18.5){
         bmiText.setText(underweight);
         dietText.setText(underweightdiet);
        }
        else if(bodymassindex >=18.5 & bodymassindex<= 25){
         bmiText.setText(normal);
         dietText.setText(normaldiet);
        }
        else if(bodymassindex >= 25.0 & bodymassindex<= 30.0){
         bmiText.setText(overweight);
         dietText.setText(obesediet);
        }
        else if(bodymassindex >= 30.0 & bodymassindex<= 35.0){
         bmiText.setText(Obese1);
         dietText.setText(obesediet);
        }
        else if(bodymassindex >= 35.0 & bodymassindex<= 40.0){
         bmiText.setText(Obese2);
         dietText.setText(obesediet);
        }
        else if(bodymassindex >= 40){
         bmiText.setText(Obese3);
         dietText.setText(obesediet);
        }
        }
        
        //Calculate button action for female gender with high activity
   else if(a.getActionCommand().equals("Calculate") && genderF.isSelected() == true && ac.isSelected()){
         //converting all the String variables from the textfields
         //into doubles for calculations
         ft = Double.parseDouble(ftext.getText());
         in = Double.parseDouble(intext.getText());
         lbs = Double.parseDouble(ptext.getText());
         wai = Double.parseDouble(wtext.getText());
         ne = Double.parseDouble(ntext.getText());
         hi = Double.parseDouble(htext.getText());
         
         //height declaration to convert the ft and in height
         //into inches only.
         fheight = (ft*12)+in;
         
         //all the metric conversions for other calculations
         metricheight = fheight * 2.54;
         metrichi = hi * 2.54;
         metricne = ne * 2.54;
         metricwai = wai * 2.54;
         metricweight = lbs * 0.45359237;
         
         //bmi formula to calculate bmi
         bodymassindex = 703*lbs/(fheight *fheight);
       String bodymassindexString = "Body mass index:   " + BMIs.format(bodymassindex) + "  lb/in2";
        bmi.setText(bodymassindexString);
        
        //waist to height ratio formula
        waisttoheight = wai/fheight;
        String wthString = "Waist-to-Height ratio:   " + WTHs.format(waisttoheight);
        wth.setText(wthString);
        
        //body fat percent formula.
        //Had to use metric units previously declared to make the calculation less complicated
        bodyfatpercent = 495/(1.29579 - .35004 * Math.log10(metricwai + metrichi - metricne) + 0.22100 * Math.log10(metricheight))-450;
        String fatpercentString = "Percent Body Fat:  " + BMIs.format(bodyfatpercent) + "%";
        bfp.setText(fatpercentString);
        
        //fat mass formula for later use in calculating lean mass.
        fatmass = (bodyfatpercent/100) * lbs;
        
        //lean mass formula for calculating lean mass.
        leanmass = lbs - fatmass;
        String leanmassString = "Lean Body Mass:  " + BMIs.format(leanmass) + " lbs";
        lbm.setText(leanmassString);
        
        //This String declaration is for the activity needed.
        String activeString = "You are most likely a very active person doing vigorous activities throughout the day.  Keep it up!";
        activitylabel.setText(activeString);
        
        //These String declarations are for later use in the if else statements regarding BMI.
        String vsunderweight = "Your BMI is way below normal.  You are very severely underweight.";
        String sunderweight = "Your BMI is below normal.  You are severely underweight.";
        String underweight = "Yout BMI is a little below normal.  You are underweight.";
        String normal = "Your BMI is normal.";
        String overweight = "Your BMI is slightly above normal.  You are overweight.";
        String Obese1 = "You are moderately obese.  This is Obese Class I.";
        String Obese2 = "You are severely obese.  This is Obese Class II.";
        String Obese3 = "This is morbid obesity.  You are in Obese Class III.";
        String underweightdiet = "Your diet should contain fats with at least 49-50 grams of protein per day.";
        String normaldiet = "Your diet seems normal but it should contain at least 49-50 grams of protein per day.";
        String obesediet = "Your diet needs to have very little fat with at least 49-50 grams of protein per day.";
        
        //if else statements regarding BMI.
        //Display recommendations regarding diet and other information regarding BMI.
        if(bodymassindex <= 15.0){
          bmiText.setText(vsunderweight);
          dietText.setText(underweightdiet);
        } 
        else if(bodymassindex >=15.0 & bodymassindex<= 16.0){
         bmiText.setText(sunderweight);
         dietText.setText(underweightdiet);
        }
        else if(bodymassindex >=16.0 & bodymassindex<= 18.5){
         bmiText.setText(underweight);
         dietText.setText(underweightdiet);
        }
        else if(bodymassindex >=18.5 & bodymassindex<= 25){
         bmiText.setText(normal);
         dietText.setText(normaldiet);
        }
        else if(bodymassindex >= 25.0 & bodymassindex<= 30.0){
         bmiText.setText(overweight);
         dietText.setText(obesediet);
        }
        else if(bodymassindex >= 30.0 & bodymassindex<= 35.0){
         bmiText.setText(Obese1);
         dietText.setText(obesediet);
        }
        else if(bodymassindex >= 35.0 & bodymassindex<= 40.0){
         bmiText.setText(Obese2);
         dietText.setText(obesediet);
        }
        else if(bodymassindex >= 40){
         bmiText.setText(Obese3);
         dietText.setText(obesediet);
        }
        }
        
        //Calculate button action for male gender with sedentary activity
   else if(a.getActionCommand().equals("Calculate") && genderM.isSelected() == true && se.isSelected()){
         //converting all the String variables from the textfields
         //into doubles for calculations
         ft = Double.parseDouble(ftext.getText());
         in = Double.parseDouble(intext.getText());
         lbs = Double.parseDouble(ptext.getText());
         wai = Double.parseDouble(wtext.getText());
         ne = Double.parseDouble(ntext.getText());
         hi = Double.parseDouble(htext.getText());
         
         //height declaration to convert the ft and in height
         //into inches only.
         fheight = (ft*12)+in;
         
         //all the metric conversions for other calculations
         metricheight = fheight * 2.54;
         metrichi = hi * 2.54;
         metricne = ne * 2.54;
         metricwai = wai * 2.54;
         metricweight = lbs * 0.45359237;
         
         //bmi formula to calculate bmi
         bodymassindex = 703*lbs/(fheight *fheight);
       String bodymassindexString = "Body mass index:   " + BMIs.format(bodymassindex) + "  lb/in2";
        bmi.setText(bodymassindexString);
        
        //waist to height ratio formula
        waisttoheight = wai/fheight;
        String wthString = "Waist-to-Height ratio:   " + WTHs.format(waisttoheight);
        wth.setText(wthString);
        
        //body fat percent formula.
        //Had to use metric units previously declared to make the calculation less complicated
        bodyfatpercent = 495/(1.29579 - .35004 * Math.log10(metricwai - metricne) + 0.22100 * Math.log10(metricheight))-450;
        String fatpercentString = "Percent Body Fat:  " + BMIs.format(bodyfatpercent) + "%";
        bfp.setText(fatpercentString);
        
        //fat mass formula for later use in calculating lean mass.
        fatmass = (bodyfatpercent/100) * lbs;
        
        //lean mass formula for calculating lean mass.
        leanmass = lbs - fatmass;
        String leanmassString = "Lean Body Mass:  " + BMIs.format(leanmass) + " lbs";
        lbm.setText(leanmassString);
        
        //This String declaration is for the activity needed.
        String sedentaryString = "You need to be more active throughout the day.  Walking, jogging, or going to the gym could be great activites in order to stay healthy.";
        activitylabel.setText(sedentaryString);
        
        //These String declarations are for later use in the if else statements regarding BMI.
        String vsunderweight = "Your BMI is way below normal.  You are very severely underweight.";
        String sunderweight = "Your BMI is below normal.  You are severely underweight.";
        String underweight = "Yout BMI is a little below normal.  You are underweight.";
        String normal = "Your BMI is normal.";
        String overweight = "Your BMI is slightly above normal.  You are overweight.";
        String Obese1 = "You are moderately obese.  This is Obese Class I.";
        String Obese2 = "You are severely obese.  This is Obese Class II.";
        String Obese3 = "This is morbid obesity.  You are in Obese Class III.";
        String underweightdiet = "Your diet should contain fats with at least 49-50 grams of protein per day.";
        String normaldiet = "Your diet seems normal but it should contain at least 49-50 grams of protein per day.";
        String obesediet = "Your diet needs to have very little fat with at least 49-50 grams of protein per day.";
        
        //if else statements regarding BMI.
        //Display recommendations regarding diet and other information regarding BMI.
        if(bodymassindex <= 15.0){
          bmiText.setText(vsunderweight);
          dietText.setText(underweightdiet);
        } 
        else if(bodymassindex >=15.0 & bodymassindex<= 16.0){
         bmiText.setText(sunderweight);
         dietText.setText(underweightdiet);
        }
        else if(bodymassindex >=16.0 & bodymassindex<= 18.5){
         bmiText.setText(underweight);
         dietText.setText(underweightdiet);
        }
        else if(bodymassindex >=18.5 & bodymassindex<= 25){
         bmiText.setText(normal);
         dietText.setText(normaldiet);
        }
        else if(bodymassindex >= 25.0 & bodymassindex<= 30.0){
         bmiText.setText(overweight);
         dietText.setText(obesediet);
        }
        else if(bodymassindex >= 30.0 & bodymassindex<= 35.0){
         bmiText.setText(Obese1);
         dietText.setText(obesediet);
        }
        else if(bodymassindex >= 35.0 & bodymassindex<= 40.0){
         bmiText.setText(Obese2);
         dietText.setText(obesediet);
        }
        else if(bodymassindex >= 40){
         bmiText.setText(Obese3);
         dietText.setText(obesediet);
        }
        }
        
        //Calculate button action for male gender with moderate activity
    else if(a.getActionCommand().equals("Calculate") && genderM.isSelected() == true && mo.isSelected()){
         //converting all the String variables from the textfields
         //into doubles for calculations
         ft = Double.parseDouble(ftext.getText());
         in = Double.parseDouble(intext.getText());
         lbs = Double.parseDouble(ptext.getText());
         wai = Double.parseDouble(wtext.getText());
         ne = Double.parseDouble(ntext.getText());
         hi = Double.parseDouble(htext.getText());
         
         //height declaration to convert the ft and in height
         //into inches only.
         fheight = (ft*12)+in;
         
         //all the metric conversions for other calculations
         metricheight = fheight * 2.54;
         metrichi = hi * 2.54;
         metricne = ne * 2.54;
         metricwai = wai * 2.54;
         metricweight = lbs * 0.45359237;
         
         //bmi formula to calculate bmi
         bodymassindex = 703*lbs/(fheight *fheight);
       String bodymassindexString = "Body mass index:   " + BMIs.format(bodymassindex) + "  lb/in2";
        bmi.setText(bodymassindexString);
        
        //waist to height ratio formula
        waisttoheight = wai/fheight;
        String wthString = "Waist-to-Height ratio:   " + WTHs.format(waisttoheight);
        wth.setText(wthString);
        
        //body fat percent formula.
        //Had to use metric units previously declared to make the calculation less complicated
        bodyfatpercent = 495/(1.29579 - .35004 * Math.log10(metricwai - metricne) + 0.22100 * Math.log10(metricheight))-450;
        String fatpercentString = "Percent Body Fat:  " + BMIs.format(bodyfatpercent) + "%";
        bfp.setText(fatpercentString);
        
        //fat mass formula for later use in calculating lean mass.
        fatmass = (bodyfatpercent/100) * lbs;
        
        //lean mass formula for calculating lean mass.
        leanmass = lbs - fatmass;
        String leanmassString = "Lean Body Mass:  " + BMIs.format(leanmass) + " lbs";
        lbm.setText(leanmassString);
        
        //This String declaration is for the activity needed.
        String moderateString = "Great job!  You are fairly active througout the day which keeps your body healthy.";
        activitylabel.setText(moderateString);
        
        //These String declarations are for later use in the if else statements regarding BMI.
        String vsunderweight = "Your BMI is way below normal.  You are very severely underweight.";
        String sunderweight = "Your BMI is below normal.  You are severely underweight.";
        String underweight = "Yout BMI is a little below normal.  You are underweight.";
        String normal = "Your BMI is normal.";
        String overweight = "Your BMI is slightly above normal.  You are overweight.";
        String Obese1 = "You are moderately obese.  This is Obese Class I.";
        String Obese2 = "You are severely obese.  This is Obese Class II.";
        String Obese3 = "This is morbid obesity.  You are in Obese Class III.";
        String underweightdiet = "Your diet should contain fats with at least 49-50 grams of protein per day.";
        String normaldiet = "Your diet seems normal but it should contain at least 49-50 grams of protein per day.";
        String obesediet = "Your diet needs to have very little fat with at least 49-50 grams of protein per day.";
        
        //if else statements regarding BMI.
        //Display recommendations regarding diet and other information regarding BMI.
        if(bodymassindex <= 15.0){
          bmiText.setText(vsunderweight);
          dietText.setText(underweightdiet);
        } 
        else if(bodymassindex >=15.0 & bodymassindex<= 16.0){
         bmiText.setText(sunderweight);
         dietText.setText(underweightdiet);
        }
        else if(bodymassindex >=16.0 & bodymassindex<= 18.5){
         bmiText.setText(underweight);
         dietText.setText(underweightdiet);
        }
        else if(bodymassindex >=18.5 & bodymassindex<= 25){
         bmiText.setText(normal);
         dietText.setText(normaldiet);
        }
        else if(bodymassindex >= 25.0 & bodymassindex<= 30.0){
         bmiText.setText(overweight);
         dietText.setText(obesediet);
        }
        else if(bodymassindex >= 30.0 & bodymassindex<= 35.0){
         bmiText.setText(Obese1);
         dietText.setText(obesediet);
        }
        else if(bodymassindex >= 35.0 & bodymassindex<= 40.0){
         bmiText.setText(Obese2);
         dietText.setText(obesediet);
        }
        else if(bodymassindex >= 40){
         bmiText.setText(Obese3);
         dietText.setText(obesediet);
        }
        }
        
        //Calculate button action for male gender with high activity
    else if(a.getActionCommand().equals("Calculate") && genderM.isSelected() == true && ac.isSelected()){
         //converting all the String variables from the textfields
         //into doubles for calculations
         ft = Double.parseDouble(ftext.getText());
         in = Double.parseDouble(intext.getText());
         lbs = Double.parseDouble(ptext.getText());
         wai = Double.parseDouble(wtext.getText());
         ne = Double.parseDouble(ntext.getText());
         hi = Double.parseDouble(htext.getText());
         
         //height declaration to convert the ft and inches height
         //into inches only.
         fheight = (ft*12)+in;
         
         //all the metric conversions for other calculations
         metricheight = fheight * 2.54;
         metrichi = hi * 2.54;
         metricne = ne * 2.54;
         metricwai = wai * 2.54;
         metricweight = lbs * 0.45359237;
         
         //bmi formula to calculate bmi
         bodymassindex = 703*lbs/(fheight *fheight);
       String bodymassindexString = "Body mass index:   " + BMIs.format(bodymassindex) + "  lb/in2";
        bmi.setText(bodymassindexString);
        
        //waist to height ratio formula
        waisttoheight = wai/fheight;
        String wthString = "Waist-to-Height ratio:   " + WTHs.format(waisttoheight);
        wth.setText(wthString);
        
        //body fat percent formula.
        //Had to use metric units previously declared to make the calculations less complicated.
        bodyfatpercent = 495/(1.29579 - .35004 * Math.log10(metricwai - metricne) + 0.22100 * Math.log10(metricheight))-450;
        String fatpercentString = "Percent Body Fat:  " + BMIs.format(bodyfatpercent) + "%";
        bfp.setText(fatpercentString);
        
        //fat mass formula for later use in calculating lean mass.
        fatmass = (bodyfatpercent/100) * lbs;
        
        //lean mass formula for calculating lean mass.
        leanmass = lbs - fatmass;
        String leanmassString = "Lean Body Mass:  " + BMIs.format(leanmass) + " lbs";
        lbm.setText(leanmassString);
        
        //This String declaration is for the activity needed.
        String activeString = "You are most likely a very active person doing vigorous activities throughout the day.  Keep it up!";
        activitylabel.setText(activeString);
        
        //These String declarations are for later use in the if else statements regarding BMI.
        String vsunderweight = "Your BMI is way below normal.  You are very severely underweight.";
        String sunderweight = "Your BMI is below normal.  You are severely underweight.";
        String underweight = "Yout BMI is a little below normal.  You are underweight.";
        String normal = "Your BMI is normal.";
        String overweight = "Your BMI is slightly above normal.  You are overweight.";
        String Obese1 = "You are moderately obese.  This is Obese Class I.";
        String Obese2 = "You are severely obese.  This is Obese Class II.";
        String Obese3 = "This is morbid obesity.  You are in Obese Class III.";
        String underweightdiet = "Your diet should contain fats with at least 49-50 grams of protein per day.";
        String normaldiet = "Your diet seems normal but it should contain at least 49-50 grams of protein per day.";
        String obesediet = "Your diet needs to have very little fat with at least 49-50 grams of protein per day.";
        
        //if else statements regarding BMI.
        //Display recommendations regarding diet and other information regarding BMI.
        if(bodymassindex <= 15.0){
          bmiText.setText(vsunderweight);
          dietText.setText(underweightdiet);
        } 
        else if(bodymassindex >=15.0 & bodymassindex<= 16.0){
         bmiText.setText(sunderweight);
         dietText.setText(underweightdiet);
        }
        else if(bodymassindex >=16.0 & bodymassindex<= 18.5){
         bmiText.setText(underweight);
         dietText.setText(underweightdiet);
        }
        else if(bodymassindex >=18.5 & bodymassindex<= 25){
         bmiText.setText(normal);
         dietText.setText(normaldiet);
        }
        else if(bodymassindex >= 25.0 & bodymassindex<= 30.0){
         bmiText.setText(overweight);
         dietText.setText(obesediet);
        }
        else if(bodymassindex >= 30.0 & bodymassindex<= 35.0){
         bmiText.setText(Obese1);
         dietText.setText(obesediet);
        }
        else if(bodymassindex >= 35.0 & bodymassindex<= 40.0){
         bmiText.setText(Obese2);
         dietText.setText(obesediet);
        }
        else if(bodymassindex >= 40){
         bmiText.setText(Obese3);
         dietText.setText(obesediet);
        }
        }
        
        //Clear button action command
    else if(a.getActionCommand().equals("Clear")){
         //Setting all of the textfields to null
         wtext.setText(null);
         ptext.setText(null);
         intext.setText(null);
         ftext.setText(null);
         ntext.setText(null);
         htext.setText(null);
         
         //Cleared all the radiobuttons using the buttongroups
         genderGroup.clearSelection();
         activityGroup.clearSelection();
         
         //Cleared all the JLabels that appear after the Calculate button is selected
         bmi.setText(null);
         wth.setText(null);
         bfp.setText(null);
         lbm.setText(null);
         bmiText.setText(null);
         dietText.setText(null);
         activitylabel.setText(null);
        }
   }
   
   //The Main method
   public static void main(String[] args){
      BMICalculator gui = new BMICalculator();
   }
}

