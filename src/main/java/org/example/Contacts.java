package org.example;

import javax.swing.*;
import java.awt.*;




public class Contacts {
    JFrame contacts;
    JPanel northPanel,southPanel,westPanel,centerPanel,formPanel,newPanel,listPanel;
    JTextField field,field2,field3;
    String text,text2,text3;
    JButton saveButton,cancelButton,addButton,viewButton,backToListButton,deleteButton;
    JTable contactList;
    CardLayout cardLayout = new CardLayout();



    public Contacts() {
        this.ContactsWindow();
    }

    public JFrame ContactsWindow(){
        contacts=new JFrame("Contacts");
        contacts.setMinimumSize(new Dimension(800,600));
        contacts.setExtendedState(JFrame.MAXIMIZED_BOTH);
        contacts.setVisible(true);
        contacts.setLayout(new BorderLayout());
        //contacts.add(this.north(),BorderLayout.NORTH);
        //contacts.add(this.west(),BorderLayout.WEST);
        //contacts.add(this.south(),BorderLayout.SOUTH);
        contacts.add(this.center(),BorderLayout.CENTER);
        //contacts.add(this.nullPanel(),BorderLayout.EAST);
        return contacts;
    }

    public JPanel north(){
        northPanel= new JPanel();
        northPanel.setBackground(Color.lightGray);
        northPanel.setPreferredSize(new Dimension(100,250));
        return northPanel;
    }
    public JPanel south(){
        southPanel= new JPanel();
        southPanel.setBackground(Color.lightGray);
        southPanel.setPreferredSize(new Dimension(100,200));
        return southPanel;
    }

    public JPanel west(){
        westPanel= new JPanel();
        westPanel.setBackground(Color.lightGray);
        westPanel.setPreferredSize(new Dimension(250,100));

        return westPanel;
    }
    public JPanel center(){
        centerPanel= new JPanel();
        centerPanel.setLayout(cardLayout);
        centerPanel.add(this.contactList());
        centerPanel.add(this.creationForm());
        centerPanel.add(this.contactDetails());
        centerPanel.setBackground(Color.blue);
        centerPanel.setPreferredSize(new Dimension(100,100));
        centerPanel.setForeground(Color.white);
        return centerPanel;
    }
    public JPanel nullPanel(){
        JPanel right=new JPanel();
        right.setPreferredSize(new Dimension(200,100));
        right.setBackground(Color.lightGray);
        return right;
    }

    public JPanel creationForm(){
        formPanel = new JPanel();
        formPanel.setPreferredSize(new Dimension(100,100));
        GridLayout gridLayout = new GridLayout(4,2);
        gridLayout.setHgap(200);
        gridLayout.setVgap(70);
        formPanel.setLayout(gridLayout);
        formPanel.add(this.name());
        formPanel.add(this.field());
        formPanel.add(this.number());
        formPanel.add(this.field2());
        formPanel.add(this.email());
        formPanel.add(this.field3());
        formPanel.add(this.cancel());
        formPanel.add(this.saveContact());
        formPanel.isVisible();
        return formPanel;
    }

    public JPanel contactDetails(){
        newPanel = new JPanel();
        newPanel.setPreferredSize(new Dimension(100,100));
        GridLayout gridLayout = new GridLayout(4,2);
        gridLayout.setHgap(200);
        gridLayout.setVgap(70);
        newPanel.setLayout(gridLayout);
        newPanel.add(this.name());
        newPanel.add(this.nameOutput());
        newPanel.add(this.number());
        newPanel.add(this.numberOutput());
        newPanel.add(this.email());
        newPanel.add(this.emailOutput());
        newPanel.add(this.delete());
        newPanel.add(this.backToList());
        newPanel.isVisible();
        return newPanel;
    }
    public JPanel contactList(){
        listPanel = new JPanel();
        contactList = new JTable(10,1);
        listPanel.add(contactList);
        listPanel.add(this.viewDetails());
        listPanel.add(this.addNewContact());
        return listPanel;
    }


    public JTextField field(){
        field=new JTextField();
        text = field.getText();
        field.setColumns(80);
        return field;
    }
    public JTextField field2(){
        field2=new JTextField();
        text2 =field2.getText();
        field2.setColumns(80);
        return field2;
    }

    public JTextField field3(){
        field3=new JTextField();
        text3=field3.getText();
        field3.setColumns(80);
        return field3;
    }

    public JLabel name(){
        JLabel label1 =new JLabel("Name:");
        label1.setFont(new Font("Verdana", Font.BOLD, 14));
        label1.setBorder(BorderFactory.createEmptyBorder(0,10,0,0));

        return label1;
    }
    public JLabel number(){
        JLabel label1 =new JLabel("Contact:");
        label1.setFont(new Font("Verdana", Font.BOLD, 14));
        label1.setBorder(BorderFactory.createEmptyBorder(0,10,0,0));

        return label1;
    }
    public JLabel email(){
        JLabel label1 =new JLabel("Email:");
        label1.setFont(new Font("Verdana", Font.BOLD, 14));
        label1.setBorder(BorderFactory.createEmptyBorder(0,10,0,0));

        return label1;
    }
    public JLabel nameOutput(){
        JLabel label1 =new JLabel(field.getText());
        label1.setFont(new Font("Verdana", Font.BOLD, 14));
        label1.setBorder(BorderFactory.createEmptyBorder(0,10,0,0));

        return label1;
    }
    public JLabel numberOutput(){
        JLabel label1 =new JLabel(field2.getText());
        label1.setFont(new Font("Verdana", Font.BOLD, 14));
        label1.setBorder(BorderFactory.createEmptyBorder(0,10,0,0));

        return label1;
    }
    public JLabel emailOutput(){
        JLabel label1 =new JLabel(field3.getText());
        label1.setFont(new Font("Verdana", Font.BOLD, 14));
        label1.setBorder(BorderFactory.createEmptyBorder(0,10,0,0));

        return label1;
    }


    public JButton saveContact(){
        saveButton=new JButton("Save Contact");
        saveButton.setBackground(new Color(60,179,113));
        saveButton.setForeground(Color.white);
        saveButton.setFocusPainted(false);
        saveButton.setPreferredSize(new Dimension(100,50));
        saveButton.addActionListener(e -> {
            if(!field.getText().isBlank()&&!field2.getText().isBlank()&&!field3.getText().isBlank()) {
                cardLayout.next(centerPanel);
                field.setText("");
                field2.setText("");
                field3.setText("");
            }});
        return saveButton;
    }
    public JButton cancel(){
        cancelButton=new JButton("Cancel");
        cancelButton.setBackground(new Color(140,17,11));
        cancelButton.setForeground(Color.white);
        cancelButton.setFocusPainted(false);
        cancelButton.setPreferredSize(new Dimension(100,50));
        cancelButton.addActionListener(e -> {
            cardLayout.first(centerPanel);

        });
        return cancelButton;
    }

    public JButton backToList(){
        backToListButton=new JButton("Back To List");
        backToListButton.setBackground(new Color(60,179,113));
        backToListButton.setForeground(Color.white);
        backToListButton.setFocusPainted(false);
        backToListButton.setPreferredSize(new Dimension(100,50));
        backToListButton.addActionListener(e -> {
            cardLayout.first(centerPanel);
        });
        return saveButton;
    }
    public JButton delete(){
        deleteButton=new JButton("Delete");
        deleteButton.setBackground(new Color(140,17,11));
        deleteButton.setForeground(Color.white);
        deleteButton.setFocusPainted(false);
        deleteButton.setPreferredSize(new Dimension(100,50));
        deleteButton.addActionListener(e -> {
            cardLayout.previous(centerPanel);
        });
        return cancelButton;
    }

    public JButton viewDetails(){
        viewButton=new JButton("View Details");
        viewButton.setBackground(new Color(60,179,113));
        viewButton.setForeground(Color.white);
        viewButton.setFocusPainted(false);
        viewButton.setPreferredSize(new Dimension(100,50));
        viewButton.addActionListener(e -> {
            cardLayout.previous(centerPanel);
        });
        return saveButton;
    }
    public JButton addNewContact(){
        addButton=new JButton("Add New Contact");
        addButton.setBackground(new Color(140,17,11));
        addButton.setForeground(Color.white);
        addButton.setFocusPainted(false);
        addButton.setPreferredSize(new Dimension(100,50));
        addButton.addActionListener(e -> {
            cardLayout.next(centerPanel);
        });
        return cancelButton;
    }

}
