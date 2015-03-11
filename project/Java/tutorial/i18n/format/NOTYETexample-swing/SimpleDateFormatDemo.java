
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

public class SimpleDateFormatDemo extends JPanel {

    static JFrame frame;
    JLabel result;
    String currentPattern;
    Date today;
    LocaleGroup availableLocales;

    public SimpleDateFormatDemo() {
 
        today = new Date();
        availableLocales = new LocaleGroup();
 
        String[] patternExamples = { 
                 "dd MMMMM yyyy",
                 "dd.MM.yy", 
                 "MM/dd/yy",
                 "yyyy.MM.dd G 'at' hh:mm:ss z",
                 "EEE, MMM d, ''yy",
                 "h:mm a",
                 "H:mm:ss:SSS",
                 "K:mm a,z",
                 "yyyy.MMMMM.dd GGG hh:mm aaa"
                 };

        currentPattern = patternExamples[0];
 
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
    
        // Create the UI for displaying result
        JLabel resultLabel = new JLabel("Current Date and Time", JLabel.LEFT);
        resultLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
        result = new JLabel(" ");
        result.setForeground(Color.black);
        result.setAlignmentX(Component.LEFT_ALIGNMENT);
        result.setBorder(BorderFactory.createCompoundBorder(
             BorderFactory.createLineBorder(Color.black),
             BorderFactory.createEmptyBorder(5,5,5,5)
        ));
    
        // Lay out everything
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
        localePanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        resultPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
    
        add(patternPanel);
        add(Box.createVerticalStrut(10));
        add(localePanel);
        add(Box.createVerticalStrut(10));
        add(resultPanel);
    
        setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
 
        reformat();
   
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

    /** Formats and displays today's date. */
    public void reformat() {
         SimpleDateFormat formatter = 
            new SimpleDateFormat(currentPattern, 
                                 availableLocales.getCurrent());
         try {
             String dateString = formatter.format(today);
             result.setForeground(Color.black);
             result.setText(dateString);
         }
         catch (IllegalArgumentException iae) {
             result.setForeground(Color.red);
             result.setText("Error: " + iae.getMessage());
         }
    }

    public static void main(String s[]) {
         WindowListener l = new WindowAdapter() {
             public void windowClosing(WindowEvent e) {System.exit(0);}
         };
 
         frame = new JFrame("Date Formatting Demo");
         frame.addWindowListener(l);
         frame.getContentPane().add("Center", new SimpleDateFormatDemo());
         frame.pack();
         frame.setVisible(true);
    }
}
