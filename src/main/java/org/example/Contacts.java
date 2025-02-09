package org.example;
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Contacts {

    private ArrayList<ContactsList> contactsList = new ArrayList<>();
    private DefaultListModel<String> contactLisstModel;
    private JFrame contacts;
    private JPanel northPanel, southPanel, westPanel, centerPanel, formPanel, viewPanel, listPanel,editPanel;
    private JTextField field, field2, field3,Editfield,Editfield2,Editfield3;
    private String text, text2, text3;
    private JLabel label2, label1, label3, labelOutput1, labelOutput2, labelOutput3,title;
    JList contactListview;
    private JButton saveButton, cancelButton, EditButton, AddButton, backToListButton, deleteButton, viewButton,Edit,EditcancelButton;
    private CardLayout cardLayout = new CardLayout();


    public Contacts() {
        this.ContactsWindow();
    }

    //creating JFrame
    public JFrame ContactsWindow(){
        contacts=new JFrame("Contacts");
        contacts.setMinimumSize(new Dimension(800,600));
        contacts.setExtendedState(JFrame.MAXIMIZED_BOTH);
        contacts.setVisible(true);
        contacts.setLayout(new BorderLayout());
        contacts.add(this.north(),BorderLayout.NORTH);
        contacts.add(this.west(),BorderLayout.WEST);
        contacts.add(this.south(),BorderLayout.SOUTH);
        contacts.add(this.center(),BorderLayout.CENTER);
        contacts.add(this.nullPanel(),BorderLayout.EAST);
        return contacts;
    }


    public JPanel north(){
        northPanel= new JPanel();
        northPanel.setPreferredSize(new Dimension(100,250));
        return northPanel;
    }
    public JPanel south(){
        southPanel= new JPanel();
        southPanel.setPreferredSize(new Dimension(100,200));
        return southPanel;
    }

    public JPanel west(){
        westPanel= new JPanel();
        westPanel.setPreferredSize(new Dimension(250,100));

        return westPanel;
    }
    public JPanel nullPanel(){
        JPanel right=new JPanel();
        right.setPreferredSize(new Dimension(200,100));
        return right;
    }

    /*
     * Parent pannel which is to contain the cardLayouts
     * that make up the UI
     * */
    public JPanel center(){
        centerPanel= new JPanel();
        centerPanel.setLayout(cardLayout);
        centerPanel.add(this.contactList(),"contactList");
        centerPanel.add(this.creationForm(),"creationForm");
        centerPanel.add(this.contactDetails(),"contactDetails");
        centerPanel.add(this.editForm(),"editForm");
        centerPanel.setBackground(Color.blue);
        centerPanel.setPreferredSize(new Dimension(100,100));
        centerPanel.setForeground(Color.white);
        return centerPanel;
    }

    /*
     * Panel which has the first Card
     * */
    public JPanel contactList(){

        listPanel = new JPanel();
        listPanel.setLayout(new BorderLayout());
        listPanel.add(BorderLayout.CENTER,this.upperList());
        listPanel.add(BorderLayout.SOUTH,this.downerList());

        return listPanel;
    }
    //The list part of the contact list
    public JPanel upperList(){
        JPanel up=new JPanel();
        contactLisstModel=new DefaultListModel<>();
        contactListview=new JList<>(contactLisstModel);
        contactListview.setPreferredSize(new Dimension(150,600));
        up.add(contactListview);
        return up;
    }
    //the the downwer panel of the contact List
    public JPanel downerList(){
        JPanel down=new JPanel();
        down.add(this.viewDetailsButton());
        down.add(this.addNewContact());
        down.add(this.EditContact());

        return down;
    }
    /*
     * form card for adding new Contact to the List/firstCard
     * */
    public JPanel creationForm(){
        formPanel = new JPanel();
        formPanel.setPreferredSize(new Dimension(100,100));
        GridLayout gridLayout = new GridLayout(4,2);
        gridLayout.setHgap(10);
        gridLayout.setVgap(10);
        formPanel.setLayout(gridLayout);

        formPanel.add(this.name());
        formPanel.add(this.field());
        formPanel.add(this.number());
        formPanel.add(this.field2());
        formPanel.add(this.email());
        formPanel.add(this.field3());
        formPanel.add(this.cancel());
        formPanel.add(this.saveContact());
        return formPanel;
    }

    //    Edit Form
    public JPanel editForm(){
        editPanel = new JPanel();
        editPanel.setPreferredSize(new Dimension(100,100));
        GridLayout gridLayout = new GridLayout(4,2);
        gridLayout.setHgap(10);
        gridLayout.setVgap(10);
        editPanel.setLayout(gridLayout);
        editPanel.add(this.name());
        editPanel.add(this.Editfield());
        editPanel.add(this.number());
        editPanel.add(this.Editfield2());
        editPanel.add(this.email());
        editPanel.add(this.Editfield3());
        editPanel.add(this.cancelEdit());
        editPanel.add(this.EditButton());
        return editPanel;
    }

    /*
     * label card to show the deails for a pecific contact selected from the firstCard
     * */
    public JPanel contactDetails(){
        viewPanel = new JPanel();
        viewPanel.setPreferredSize(new Dimension(100,100));
        GridLayout gridLayout = new GridLayout(4,2);
        gridLayout.setHgap(20);
        gridLayout.setVgap(20);
        viewPanel.setLayout(gridLayout);
        viewPanel.add(this.name());
        viewPanel.add(this.nameOutput());
        viewPanel.add(this.number());
        viewPanel.add(this.numberOutput());
        viewPanel.add(this.email());
        viewPanel.add(this.emailOutput());
        viewPanel.add(this.delete());
        viewPanel.add(this.backToList());
        viewPanel.isVisible();
        return viewPanel;
    }

    /*
     * making methods to be used in the already made cards
     * */
    public JTextField Editfield(){
        Editfield=new JTextField();
        return Editfield;
    }
    //text field of the number in the formCreation Card
    public JTextField Editfield2(){
        Editfield2=new JTextField();
        return Editfield2;
    }

    //text field of the email in the formCreation Card
    public JTextField Editfield3(){
        Editfield3=new JTextField();
        return Editfield3;
    }


    //text field of the Name in the formCreation Card
    public JTextField field(){
        field=new JTextField();
        return field;
    }
    //text field of the number in the formCreation Card
    public JTextField field2(){
        field2=new JTextField();
        return field2;
    }

    //text field of the email in the formCreation Card
    public JTextField field3(){
        field3=new JTextField();
        //text3=field3.getText();
        return field3;
    }

    //method for the Name label in the formCard
    public JLabel name(){
        label2 =new JLabel("Name:");
        label2.setFont(new Font("Verdana", Font.BOLD, 16));
        label2.setBorder(BorderFactory.createEmptyBorder(0,10,0,0));

        return label2;
    }
    //method for the Number label in the formCard
    public JLabel number(){
        label1 =new JLabel("Contact:");
        label1.setFont(new Font("Verdana", Font.BOLD, 16));
        label1.setBorder(BorderFactory.createEmptyBorder(0,10,0,0));

        return label1;
    }
    //method for the email label in the formCard
    public JLabel email(){
        label3 =new JLabel("Email:");
        label3.setFont(new Font("Verdana", Font.BOLD, 16));
        label3.setBorder(BorderFactory.createEmptyBorder(0,10,0,0));

        return label3;
    }

    //displays the name detail for the selected contact
    public JLabel nameOutput(){
        labelOutput1 =new JLabel();
        labelOutput1.setFont(new Font("Verdana", Font.BOLD, 14));
        labelOutput1.setBorder(BorderFactory.createEmptyBorder(0,10,0,0));

        return labelOutput1;
    }
    //displays the number detail for the selected contact
    public JLabel numberOutput(){
        labelOutput2 =new JLabel();
        labelOutput2.setFont(new Font("Verdana", Font.BOLD, 14));
        labelOutput2.setBorder(BorderFactory.createEmptyBorder(0,10,0,0));

        return labelOutput2;
    }
    //desplays the email detail for the selected contact
    public JLabel emailOutput(){
        labelOutput3 =new JLabel();
        labelOutput3.setFont(new Font("Verdana", Font.BOLD, 14));
        labelOutput3.setBorder(BorderFactory.createEmptyBorder(0,10,0,0));
        return labelOutput3;
    }

    /*
     * Adding designes and actionLitners to the implemeted buttons
     * */
    public JButton saveContact(){
        saveButton=new JButton("Save Contact");
        saveButton.setBackground(new Color(60,179,113));
        saveButton.setForeground(Color.white);
        saveButton.setFocusPainted(false);
        saveButton.setPreferredSize(new Dimension(100,50));

        saveButton.addActionListener(e->{
            String name = field.getText();
            String number = field2.getText();
            String email = field3.getText();
            if (!name.isBlank() && !number.isBlank() && !email.isBlank()) {
                ContactsList newContact = new ContactsList(name, number, email);
                contactsList.add(newContact);
                contactLisstModel.addElement(name);
                field.setText("");
                field2.setText("");
                field3.setText("");

                cardLayout.show(centerPanel, "contactList");}
        });
        return saveButton;
    }

    //design implementaion of the EditButton
    public JButton EditContact(){
        EditButton=new JButton("EDIT");
        EditButton.setBackground(new Color(30,144,255));
        EditButton.setForeground(Color.white);
        EditButton.setFocusPainted(false);
        EditButton.setPreferredSize(new Dimension(100,50));
        EditButton.addActionListener(e->{
            int selectedIndex=contactListview.getSelectedIndex();
            if(selectedIndex >= 0 && selectedIndex < contactLisstModel.size()){
                ContactsList c=contactsList.get(selectedIndex);
                Editfield.setText(c.getNames());
                Editfield3.setText(c.getNumber());
                Editfield2.setText(c.getEmail());
                cardLayout.show(centerPanel,"editForm");
            }
        });
        return EditButton;
    }

    //design Contact Button
    public JButton EditButton(){
        Edit=new JButton("COMFIRM EDIT");
        Edit.setBackground(new Color(30,144,255));
        Edit.setForeground(Color.white);
        Edit.setFocusPainted(false);
        Edit.setPreferredSize(new Dimension(100,50));
        Edit.addActionListener(e->{
            int selectedIndex=contactListview.getSelectedIndex();
            if(selectedIndex >= 0 && selectedIndex < contactLisstModel.size()){
                ContactsList c=contactsList.get(selectedIndex);

                c.setNames(Editfield.getText());
                c.setNumber(Editfield2.getText());
                c.setEmail(Editfield3.getText());



                contactsList.set(selectedIndex,new ContactsList(Editfield.getText(),Editfield2.getText(),Editfield3.getText()));
                contactLisstModel.set(selectedIndex,c.getNames());


                System.out.println(c.getNames());
                cardLayout.show(centerPanel,"contactList");
            }

        });
        return Edit;
    }
    //cancel on edit form
    public JButton cancelEdit(){
        EditcancelButton=new JButton("Cancel");
        EditcancelButton.setBackground(new Color(140,17,11));
        EditcancelButton.setForeground(Color.white);
        EditcancelButton.setFocusPainted(false);
        EditcancelButton.setPreferredSize(new Dimension(100,50));
        EditcancelButton.addActionListener(e->{
            Editfield.setText("");
            Editfield2.setText("");
            Editfield3.setText("");
            cardLayout.show(centerPanel, "contactList");
        });
        return EditcancelButton;
    }
    //logic for the cancel button
    public JButton cancel(){
        cancelButton=new JButton("Cancel");
        cancelButton.setBackground(new Color(140,17,11));
        cancelButton.setForeground(Color.white);
        cancelButton.setFocusPainted(false);
        cancelButton.setPreferredSize(new Dimension(100,50));
        cancelButton.addActionListener(e->{
            field.setText("");
            field2.setText("");
            field3.setText("");
            cardLayout.show(centerPanel, "contactList");
        });
        return cancelButton;
    }

    //logic for the backToList button
    public JButton backToList(){
        backToListButton=new JButton("Back To List");
        backToListButton.setBackground(new Color(60,179,113));
        backToListButton.setForeground(Color.white);
        backToListButton.setFocusPainted(false);
        backToListButton.setPreferredSize(new Dimension(100,50));
        backToListButton.addActionListener(e -> {
            cardLayout.first(centerPanel);
        });
        return backToListButton;
    }

    //Logic for the delete button
    public JButton delete(){
        deleteButton=new JButton("Delete");
        deleteButton.setBackground(new Color(140,17,11));
        deleteButton.setForeground(Color.white);
        deleteButton.setFocusPainted(false);
        deleteButton.setPreferredSize(new Dimension(100,50));
        deleteButton.addActionListener(e -> {
            int selected= contactListview.getSelectedIndex();
            if(selected>=0&&selected<contactLisstModel.size()){
                contactsList.remove(selected);
                contactLisstModel.remove(selected);
                cardLayout.show(centerPanel,"contactList");
            }

        });
        return deleteButton;
    }
    //logic for the viewDetailsButton
    public JButton viewDetailsButton(){
        viewButton=new JButton("View Details");
        viewButton.setBackground(new Color(60,179,113));
        viewButton.setForeground(Color.white);
        viewButton.setFocusPainted(false);
        viewButton.setPreferredSize(new Dimension(150,50));
        viewButton.addActionListener(e->{
            int getSelectedIndex=contactListview.getSelectedIndex();
            if(getSelectedIndex>=0&&getSelectedIndex<contactLisstModel.size()){
                ContactsList c=contactsList.get(getSelectedIndex);
                text=c.getNames();
                text2=c.getNumber();
                text3=c.getEmail();
                labelOutput1.setText(text);
                labelOutput2.setText(text3);
                labelOutput3.setText(text2);
                cardLayout.show(centerPanel,"contactDetails");
            }

        });
        return viewButton;
    }

    //logic for addNewContct Button
    public JButton addNewContact(){
        AddButton=new JButton("Add New Contact");
        AddButton.setBackground(new Color(140,17,11));
        AddButton.setForeground(Color.white);
        AddButton.setFocusPainted(false);
        AddButton.setPreferredSize(new Dimension(150,50));
        AddButton.addActionListener(e->{
            cardLayout.show(centerPanel, "creationForm");
        });
        return AddButton;
    }






}