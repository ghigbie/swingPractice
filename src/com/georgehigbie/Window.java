package com.georgehigbie;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.GridLayout;

import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.ListModel;

import java.awt.BorderLayout;

import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class Window {

    private JFrame frame;
    private JPanel outerPanel;
    private JButton buttonAdd;
    private JButton buttonRemove;
    private JPanel textPanelLeft;
    private JPanel textPanelRight;
    private JList textListLeft;
    private JList textListRight;

    private String caseString = "Case";
    private String motherString = "Motherboard";
    private String cpuString = "CPU";
    private String ramString = "RAM";
    private String gpuString = "GPU";
    private String hddString = "HDD";
    private String psuString = "PSU";
    public DefaultListModel defaultLeft = new DefaultListModel();
    public DefaultListModel defaultRight = new DefaultListModel();
    public ArrayList<String> componentsArrayList = new ArrayList<String>();
    public ArrayList<String> addedArrayList = new ArrayList<String>();

    private String[] componentsString = {caseString, motherString, cpuString, ramString, gpuString, hddString, psuString};
    private String[] addedComponents = new String[componentsString.length];

    private int addedPressed = 0;
    private int removedPressed = 0;


    /**
     * Launch the application. The main method is the entry point to a Java application.
     * For this assessment, you shouldn't have to add anything to this.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Window window = new Window();
                    window.frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }


    public Window() { //constructor for the window class
        initialize();
    }


    public void initialize() {//initialize contents of frame

        frame = new JFrame();
        frame.setBounds(100, 100, 450, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setLayout(new GridLayout(1, 3));

        buildMenuItems();
        buildPanelItems();

    }

    public void buildMenuItems(){

        JMenuBar menuBar = new JMenuBar();
        JMenu fileMenu = new JMenu("File");
        JMenu helpMenu = new JMenu("Help");
        JMenu aboutMenu = new JMenu("About");

        JMenuItem loadMenuItem = new JMenuItem("Load");
        JMenuItem saveMenuItem = new JMenuItem("Save");
        JMenuItem exitMenuItem = new JMenuItem("Exit");

        loadMenuItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                loadProgramPressed();
            }});

        saveMenuItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                saveProgramPressed();
            }});

        exitMenuItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                exitProgramPressed();
            }});



        JMenuItem noclickMenuItem = new JMenuItem("Don\'t click here looking for help.");
        JMenuItem aboutMenuItem = new JMenuItem("This program simulates building a computer");

        helpMenu.add(noclickMenuItem);
        aboutMenu.add(aboutMenuItem);

        fileMenu.add(loadMenuItem);
        fileMenu.add(saveMenuItem);
        fileMenu.addSeparator();
        fileMenu.add(exitMenuItem);

        menuBar.add(fileMenu);
        menuBar.add(helpMenu);
        menuBar.add(aboutMenu);

        frame.setJMenuBar(menuBar);
    }

    public void buildPanelItems(){

        componentsArrayList.add(caseString);
        componentsArrayList.add(motherString);
        componentsArrayList.add(cpuString);
        componentsArrayList.add(ramString);
        componentsArrayList.add(gpuString);
        componentsArrayList.add(hddString);
        componentsArrayList.add(psuString);

        defaultLeft.addElement(caseString);
        defaultLeft.addElement(motherString);
        defaultLeft.addElement(cpuString);
        defaultLeft.addElement(ramString);
        defaultLeft.addElement(gpuString);
        defaultLeft.addElement(hddString);
        defaultLeft.addElement(psuString);

        textPanelLeft = new JPanel();
        textPanelLeft.setLayout(new BoxLayout(textPanelLeft, BoxLayout.Y_AXIS));
        textListLeft = new JList(defaultLeft);
        textPanelLeft.setBackground(Color.WHITE);
        textListLeft.setAlignmentX(0.1f);
        textPanelLeft.add(textListLeft);

        JPanel buttonPanel = new JPanel();
        JPanel centerPanel = new JPanel();
        buttonAdd = new JButton(">>");
        buttonRemove = new JButton("<<");

        buttonAdd.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                addButtonPressed();
            }});

        buttonRemove.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                removeButtonPressed();
            }});

        BoxLayout buttonBox = new BoxLayout(buttonPanel, BoxLayout.Y_AXIS);
        centerPanel.setLayout(buttonBox);
        centerPanel.setBackground(Color.LIGHT_GRAY);
        buttonPanel.add(buttonAdd);
        buttonPanel.add(buttonRemove);

        buttonPanel.setBackground(Color.LIGHT_GRAY);
        //buttonPanel.add(centerPanel);

        textPanelRight = new JPanel();
        textPanelRight.setLayout(new BoxLayout(textPanelRight, BoxLayout.Y_AXIS));
        textListRight = new JList(defaultRight);
        textPanelRight.setBackground(Color.WHITE);
        textPanelRight.add(textListRight);

        frame.add(textPanelLeft);
        frame.add(buttonPanel);
        frame.add(textPanelRight);
    }

    public void addButtonPressed(){
        if(addedPressed < 7){
            defaultRight.addElement(defaultLeft.getElementAt(0));
            defaultLeft.removeElementAt(0);
            addedPressed++;
        }

    }

    public void removeButtonPressed(){
        if(addedPressed > 0){
            addedPressed--;
            defaultLeft.addElement(defaultRight.getElementAt(0));
            defaultRight.removeElementAt(0);
        }
    }

    public void loadProgramPressed(){

    }

    public void saveProgramPressed(){

    }

    public void exitProgramPressed(){
        System.exit(0);
    }
}


