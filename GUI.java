import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//Creates main screen for the user to make a board and choose the percent chance of alive and dead cells
public class GUI implements ActionListener {
    private static JFrame menuFrame;
    private static JPanel menuPanel;
    private static JLabel welcomeMessage;
    private static JLabel amtRows;
    private static JTextField rows;
    private static JLabel amtCols;
    private static JTextField cols;
    private static JLabel percentChance;
    private static JTextField chance;
    private static JLabel error;
    private static JLabel preset;
    private static JComboBox inPreset;

    private static JFrame godFrame;
    private static JTextField inRows;
    private static JTextField inCols;
    private static JButton godButton;
    private static JLabel error2;

    private static int percent;
    private static double decimalChance;
    private static int numRows;
    private static int numCols;

    private static JButton moveForth;

    private static String[] thePresets = {"", "Magical Sword", "Funny Currency"};
    private static String word = "";

    //Creates main JFrame for the user to set default values
    public static void buildFrame(){
        menuFrame = new JFrame("The Game of Life");
        menuFrame.setSize(860,310);
        menuFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        menuPanel = new JPanel();
        menuFrame.add(menuPanel);

        menuPanel.setLayout(null);

        welcomeMessage = new JLabel("Welcome to the Game of Life");
        welcomeMessage.setBounds(300,10,300,25);
        welcomeMessage.setFont(new Font("Serif", Font.PLAIN, 20));
        menuPanel.add(welcomeMessage);

        amtRows = new JLabel("How many rows would you like?");
        amtRows.setBounds(60,50,300,25);
        menuPanel.add(amtRows);

        amtCols = new JLabel("How many cols would you like?");
        amtCols.setBounds( 320,50,300,25);
        menuPanel.add(amtCols);

        percentChance = new JLabel("What percent chance would you like");
        percentChance.setBounds(580,50,300,25);
        menuPanel.add(percentChance);

        rows = new JTextField("(5<=)",4);
        rows.setBounds(80,80,150,25);
        menuPanel.add(rows);

        cols = new JTextField("(5<=)",4);
        cols.setBounds(340,80,150,25);
        menuPanel.add(cols);

        chance = new JTextField("(1-80)",4);
        chance.setBounds(610,80,150,25);
        menuPanel.add(chance);

        preset = new JLabel("Choose a Preset");
        preset.setBounds(100,110, 150,25);
        menuPanel.add(preset);

        inPreset = new JComboBox(thePresets);
        inPreset.setBounds(80,130,150,25);
        inPreset.addActionListener(new GUI());
        menuPanel.add(inPreset);

        moveForth = new JButton("Continue");
        moveForth.setBounds(360,230,100,25);
        moveForth.addActionListener(new GUI());
        menuPanel.add(moveForth);

        error = new JLabel("");
        error.setBounds(265, 250,300,25);
        error.setForeground(Color.RED);
        menuPanel.add(error);

        JLabel Note = new JLabel("Note: ");
        Note.setBounds(320,110,100,25);
        menuPanel.add(Note);

        JLabel first = new JLabel("-To choose a preset set the row and col to 25 set the percent to");
        first.setBounds(320,130,500,25);
        menuPanel.add(first);

        JLabel second = new JLabel("  whatever you like, to not have a preset leave the choice box blank");
        second.setBounds(320,150,500,25);
        menuPanel.add(second);

        JLabel third = new JLabel("- " + "\u25A0" + " is alive");
        third.setBounds(320,170,300,25);
        menuPanel.add(third);

        JLabel fourth = new JLabel("- " + "\u25A1" + " is dead");
        fourth.setBounds(320,190,300,25);
        menuPanel.add(fourth);

        menuFrame.setVisible(true);
    }

    //Builds a screen allowing the user to kill or bring a cell to life
    public static void buildGod(){
        godFrame = new JFrame("Hello God");
        godFrame.setSize(300,200);
        godFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel godPanel = new JPanel();
        godFrame.add(godPanel);

        godPanel.setLayout(null);

        JLabel rows = new JLabel("Row");
        rows.setBounds(10,10,50,25);
        godPanel.add(rows);

        inRows = new JTextField(20);
        inRows.setBounds(60,10,50,25);
        godPanel.add(inRows);

        JLabel cols = new JLabel("Col");
        cols.setBounds(10,30,50,25);
        godPanel.add(cols);

        inCols = new JTextField(20);
        inCols.setBounds(60,30,50,25);
        godPanel.add(inCols);

        godButton = new JButton("Continue");
        godButton.setBounds(70,60,100,25);
        godButton.addActionListener(new GUI());
        godPanel.add(godButton);

        error2 = new JLabel("");
        error2.setBounds(30,90,300,25);
        error2.setForeground(Color.RED);
        godPanel.add(error2);

        godFrame.setVisible(true);
    }


    //getters
    public static double getPercent(){
        return decimalChance;
    }

    public static int getNumRows(){
        return numRows;
    }

    public static int getNumCols(){
        return numCols;
    }

    //When button is pressed it moves onto the actual game of life board
    //if a preset is chosen it will display the preset and if not then it will communicate the percent chance chosen
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == inPreset){
            word = (String) inPreset.getSelectedItem();
            System.out.println(word);
        }
        if(e.getSource() == moveForth){
            numRows = Integer.parseInt(rows.getText());
            numCols = Integer.parseInt(cols.getText());
            percent = Integer.parseInt(chance.getText());
            System.out.println(percent);
            if(word.equalsIgnoreCase("magical sword")){
                decimalChance = (double)percent / 100;
                menuFrame.dispose();
                GameBoard.makePenis();
                Overseer.display();
                word = "";
            }
            else if(word.equalsIgnoreCase("Funny Currency")){
                decimalChance = (double)percent / 100;
                System.out.println(word);
                menuFrame.dispose();
                GameBoard.makeCurrency();
                Overseer.display();
                word = "";
            }
            else if((numRows >= 5)){
                if((numCols >= 5)){
                    if((percent >= 1) && (percent <= 80)){
                        decimalChance = (double)percent / 100;
                        GameBoard.setBoardLength();
                        GameBoard.generateValues();
                        menuFrame.dispose();
                        Overseer.display();
                    }
                    else{
                        error.setText("Information Input Incorrectly, Please Try Again!");
                        rows.setText("(5<=)");
                        cols.setText("(5<=)");
                        chance.setText("(1-80)");
                    }
                }
                else{
                    error.setText("Information Input Incorrectly, Please Try Again!");
                    rows.setText("(5<=)");
                    cols.setText("(5<=)");
                    chance.setText("(1-80)");
                }

            }
            else{
                error.setText("Information Input Incorrectly, Please Try Again!");
                rows.setText("(5<=)");
                cols.setText("(5<=)");
                chance.setText("(1-80)");
            }
        }
        else if(e.getSource() == godButton){
            int r = Integer.parseInt(inRows.getText());
            int c = Integer.parseInt(inCols.getText());
            if (r <= numRows) {
                if(c <= numCols) {
                    if (Overseer.getLife().equalsIgnoreCase("bring life")) {
                        GameBoard.bringLife(r - 1, c - 1);
                    } else if (Overseer.getDeath().equalsIgnoreCase("bring death")) {
                        GameBoard.bringDeath(r - 1, c - 1);
                    }
                    godFrame.dispose();
                    Overseer.setLife();
                    Overseer.setDeath();
                    Overseer.display();
                }
                else{
                    error2.setText("Even God's have limits, try again!");
                    inRows.setText("");
                    inCols.setText("");
                }
            }
            else{
                error2.setText("Even God's have limits, try again!");
                inRows.setText("");
                inCols.setText("");
            }
        }
    }
}
