/*
 * Copyright (c) 1995-1998 Sun Microsystems, Inc. All Rights Reserved.
 *
 * Permission to use, copy, modify, and distribute this software
 * and its documentation for NON-COMMERCIAL purposes and without
 * fee is hereby granted provided that this copyright notice
 * appears in all copies. Please refer to the file "copyright.html"
 * for further important copyright and licensing information.
 *
 * SUN MAKES NO REPRESENTATIONS OR WARRANTIES ABOUT THE SUITABILITY OF
 * THE SOFTWARE, EITHER EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED
 * TO THE IMPLIED WARRANTIES OF MERCHANTABILITY, FITNESS FOR A
 * PARTICULAR PURPOSE, OR NON-INFRINGEMENT. SUN SHALL NOT BE LIABLE FOR
 * ANY DAMAGES SUFFERED BY LICENSEE AS A RESULT OF USING, MODIFYING OR
 * DISTRIBUTING THIS SOFTWARE OR ITS DERIVATIVES.
 */

import java.applet.Applet;
import java.awt.*;
import java.awt.event.*;
import com.sun.java.swing.*;
import com.sun.java.swing.border.*;
import java.util.*;
import java.text.*;

public class DecimalFormatDemo extends JPanel {

    static JFrame frame;
    JLabel result;
    NumberFormat inputFormatter;
    String currentPattern;
    double currentNumber = 123.45;
    LocaleGroup availableLocales;

    public DecimalFormatDemo() {
 
        availableLocales = new LocaleGroup();
        inputFormatter = NumberFormat.getNumberInstance();
      
        String[] patternExamples = { 
                 "##.##", 
                 "###,###.##",
                 "##,##,##.##",
                 "#",
                 "000,000.0000",
                 "##.0000",
                 "'hello'###.##"
                 };

        currentPattern = patternExamples[0];

        // Set up the UI for entering a number.
        JLabel numberLabel = new JLabel("Enter the number to format:");
        numberLabel.setAlignmentX(Component.LEFT_ALIGNMENT);

        JTextField numberField = new JTextField();
        numberField.setEditable(true);
        numberField.setAlignmentX(Component.LEFT_ALIGNMENT);
        NumberListener numberListener = new NumberListener();
        numberField.addActionListener(numberListener);
   
        // Set up the UI for selecting a pattern.
        JLabel patternLabel1 = new JLabel("Enter the pattern string or");
        JLabel patternLabel2 = new JLabel("select one from the list:");
        patternLabel1.setAlignmentX(Component.LEFT_ALIGNMENT);
        patternLabel2.setAlignmentX(Component.LEFT_ALIGNMENT);
    
        JComboBox patternList = new JComboBox(patternExamples);
        patternList.setSelectedIndex(0);
        patternList.setEditable(true);
        patternList.setAlignmentX(Component.LEFT_ALIGNMENT);
        PatternListener patternListener = new PatternListener();
        patternList.addActionListener(patternListener);

         // Set up the UI for selecting a locale.
        JLabel localeLabel = new JLabel("Select a Locale from the list:");
        localeLabel.setAlignmentX(Component.LEFT_ALIGNMENT);

        JComboBox localeList = new JComboBox(availableLocales.getStrings());
        localeList.setSelectedIndex(0);
        localeList.setAlignmentX(Component.LEFT_ALIGNMENT);
        LocaleListener localeListener = new LocaleListener();
        localeList.addActionListener(localeListener);

        // Create the UI for displaying result.
        JLabel resultLabel = new JLabel("Result", JLabel.LEFT);
        resultLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
        result = new JLabel(" ");
        result.setForeground(Color.black);
        result.setAlignmentX(Component.LEFT_ALIGNMENT);
        result.setBorder(BorderFactory.createCompoundBorder(
             BorderFactory.createLineBorder(Color.black),
             BorderFactory.createEmptyBorder(5,5,5,5)
        ));
    
        // Lay out everything
        JPanel numberPanel = new JPanel();
        numberPanel.setLayout(new GridLayout(0, 1));
        numberPanel.add(numberLabel);
        numberPanel.add(numberField);
    
        JPanel patternPanel = new JPanel();
        patternPanel.setLayout(new BoxLayout(patternPanel, BoxLayout.Y_AXIS));
        patternPanel.add(patternLabel1);
        patternPanel.add(patternLabel2);
        patternPanel.add(patternList);

        JPanel localePanel = new JPanel();
        localePanel.setLayout(new BoxLayout(localePanel, BoxLayout.Y_AXIS));
        localePanel.add(localeLabel);
        localePanel.add(localeList);

        JPanel resultPanel = new JPanel();
        resultPanel.setLayout(new GridLayout(0, 1));
        resultPanel.add(resultLabel);
        resultPanel.add(result);
    
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        patternPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        numberPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        localePanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        resultPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
    
        add(numberPanel);
        add(Box.createVerticalStrut(10));
        add(patternPanel);
        add(Box.createVerticalStrut(10));
        add(localePanel);
        add(Box.createVerticalStrut(10));
        add(resultPanel);
    
        setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
   
        reformat();
        numberField.setText(result.getText());

    } // constructor


    /** Listens to the pattern combo box. */
    class PatternListener implements ActionListener { 
        public void actionPerformed(ActionEvent e) {
        JComboBox cb = (JComboBox)e.getSource();
        String newSelection = (String)cb.getSelectedItem();
        currentPattern = newSelection;
        reformat();
        }
    }

    /** Listens to the number field. */
    class NumberListener implements ActionListener { 
        public void actionPerformed(ActionEvent evt) {
           JTextField inputField = (JTextField)evt.getSource();
           try {
              Number value = inputFormatter.parse(inputField.getText());
              currentNumber = value.doubleValue();
              reformat();
           }
           catch (ParseException pe) {
              result.setForeground(Color.red);
              result.setText("Illegal Number: " + pe.getMessage());
           }
        }
    }

    /** Listens to the locale combo box. */
    class LocaleListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
        JComboBox cb = (JComboBox)e.getSource();
        int index = cb.getSelectedIndex();
        availableLocales.setCurrent(index);
        reformat();
        }
    }

    /** Manages information about locales for this application. */
    class LocaleGroup {

        Locale currentLocale;
        Locale[] supportedLocales = {
           Locale.US, 
           Locale.GERMANY, 
           Locale.FRANCE
           // Add other locales here, if desired.
        };

        public LocaleGroup() {
           currentLocale = supportedLocales[0];
           } 
        public void setCurrent(int index) {
           currentLocale = supportedLocales[index];
        }
        public Locale getCurrent() {
           return currentLocale;
        }
        public String[] getStrings() {
           String[] localeNames = new String[supportedLocales.length];
           for (int k = 0; k < supportedLocales.length; k++) {
              localeNames[k] = supportedLocales[k].getDisplayName();
           }
           return localeNames;
        }
    }

    /** Reformats the input number and displays result. */
    public void reformat() {
         try {
             NumberFormat nf = 
                NumberFormat.getNumberInstance(availableLocales.getCurrent());
             DecimalFormat df = (DecimalFormat)nf;
             df.applyPattern(currentPattern);
             result.setForeground(Color.black);
             result.setText(df.format(currentNumber));
         }
         catch (IllegalArgumentException iae) {
             result.setForeground(Color.red);
             result.setText("Illegal Pattern: " + iae.getMessage());
         }
    }

    public static void main(String s[]) {
         WindowListener l = new WindowAdapter() {
             public void windowClosing(WindowEvent e) {System.exit(0);}
         };
 
         frame = new JFrame("DecimalFormat Demo");
         frame.addWindowListener(l);
         frame.getContentPane().add("Center", new DecimalFormatDemo());
         frame.pack();
         frame.setVisible(true);
    }
}
