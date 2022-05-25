import javax.swing.*;

public class Overseer {
    private static int genCounter = 1;
    private static String life = "";
    private static String death = "";

    public Overseer(){
        GUI.buildFrame();
    }

    public static void display(){
        String notExit = "";
        while (!notExit.equalsIgnoreCase("Exit")) {
            notExit = JOptionPane.showInputDialog(null, GameBoard.drawBoard() + "\n"
                    + "Generation: " + genCounter + "\n"
                    + "Number of Alive: " + GameBoard.getNumAlive() + "\n"
                    + "Number of Dead: " + GameBoard.getNumDead() + "\n"
                    + "Type 'exit' to exit" + "\n"
                    + "Type 'restart' to restart the board" + "\n"
                    + "Type 'new' to create a new board" + "\n"
                    + "Type 'bring life' to become God" + "\n"
                    + "Type 'bring death' to also become God");
            if (notExit.equalsIgnoreCase("restart")) {
                genCounter = 0;
                GameBoard.setNumAlive();
                GameBoard.setNumDead();
                GameBoard.setBoardLength();
                GameBoard.wipeValues();
                GameBoard.generateValues();
                notExit = "";
            }
            if(notExit.equalsIgnoreCase("new")){
                genCounter = 1;
                GameBoard.setNumAlive();
                GameBoard.setNumDead();
                notExit = "exit";
                GUI.buildFrame();
            }
            if(notExit.equalsIgnoreCase("bring death")){
                notExit = "exit";
                GUI.buildGod();
                death = "bring death";
            }
            if(notExit.equalsIgnoreCase("bring life")){
                notExit = "exit";
                GUI.buildGod();
                life = "bring life";
            }
            if(!life.equalsIgnoreCase("bring life") && !death.equalsIgnoreCase("bring death")){
                GameBoard.elJuegoDeVida();
                genCounter++;
            }
        }
    }

    public static String getLife(){return life;}
    public static String getDeath(){return death;}

    public static void setLife(){life = "";}
    public static void setDeath(){death = "";}
}
