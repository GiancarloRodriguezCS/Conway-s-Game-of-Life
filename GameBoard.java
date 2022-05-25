public class GameBoard {

    private static boolean[][] board;
    private static double percent;

    private static int numAlive = 0;
    private static int numDead = 0;

    public static void setBoardLength(){board = new boolean[GUI.getNumRows()][GUI.getNumCols()];}

    public static void generateValues(){
        percent = GUI.getPercent();
        System.out.println(percent);

        for(int r = 0; r < board.length; r++){
            for(int c = 0; c < board[0].length; c++){
                if(Math.random() < percent ){
                    board[r][c] = true;
                    numAlive++;
                }
                else{
                    board[r][c] = false;
                    numDead++;

                }
            }
        }
    }

    public static String drawBoard(){
        String MAP = "";
        String alive = "\u25A0";
        String dead = "\u25A1";

        for(int r = 0; r < GUI.getNumRows(); r++) {
            for (int c = 0; c < GUI.getNumCols(); c++) {
                if(board[r][c]){
                    MAP += alive + "   ";
                }
                else{
                    MAP += dead + "   ";
                }
            }
            MAP += "\n";
        }
        return MAP;
    }

    public static void elJuegoDeVida(){
        for(int r = 0; r < board.length; r++) {
            for (int c = 0; c < board[0].length; c++) {
                int counter = 0;
                if(board[r][c]) {
                    if(r != 0) {
                        if(c != 0) {
                            if (board[r - 1][c - 1]) {
                                counter++;
                            }
                        }
                        if (board[r - 1][c]) {
                            counter++;
                        }
                        if(c != board[0].length - 1) {
                            if (board[r - 1][c + 1]) {
                                counter++;
                            }
                        }
                    }
                    if(c != board[0].length - 1) {
                        if (board[r][c + 1]) {
                            counter++;
                        }
                        if(r != board.length - 1) {
                            if (board[r + 1][c + 1]) {
                                counter++;
                            }
                        }
                    }
                    if(r != board.length - 1) {
                        if (board[r + 1][c]) {
                            counter++;
                        }
                        if(c != 0) {
                            if (board[r + 1][c - 1]) {
                                counter++;
                            }
                        }
                    }
                    if(c != 0) {
                        if (board[r][c - 1]) {
                            counter++;
                        }
                    }
                    if ((counter > 3) || (counter <= 1)) {
                        board[r][c] = false;
                        numDead++;
                        numAlive--;
                    }

                }
                else{
                    if(r != 0) {
                        if(c != 0) {
                            if (board[r - 1][c - 1]) {
                                counter++;
                            }
                        }
                        if (board[r - 1][c]) {
                            counter++;
                        }
                        if(c != board[0].length - 1) {
                            if (board[r - 1][c + 1]) {
                                counter++;
                            }
                        }
                    }
                    if(c != board[0].length - 1) {
                        if (board[r][c + 1]) {
                            counter++;
                        }
                        if(r != board.length - 1) {
                            if (board[r + 1][c + 1]) {
                                counter++;
                            }
                        }
                    }
                    if(r != board.length - 1) {
                        if (board[r + 1][c]) {
                            counter++;
                        }
                        if(c != 0) {
                            if (board[r + 1][c - 1]) {
                                counter++;
                            }
                        }
                    }
                    if(c != 0) {
                        if (board[r][c - 1]) {
                            counter++;
                        }
                    }
                    if(counter == 3){
                        board[r][c] = true;
                        numAlive++;
                        numDead--;
                    }
                }
            }
        }
    }

    public static int getNumAlive(){
        return numAlive;
    }
    public static int getNumDead(){
        return numDead;
    }

    public static void setNumAlive(){numAlive = 0;}
    public static void setNumDead(){numDead = 0;}

    public static void bringLife(int row, int col){board[row][col] = true; numAlive++; numDead--;}
    public static void bringDeath(int row, int col){board[row][col] = false; numAlive--; numDead++;}

    public static void makeCurrency(){
        board = new boolean[25][25];
        for(int r = 0; r < board.length; r++){
            for(int c = 0; c < board[0].length; c++){
                if((r == 0) && (c >= 7 && c <= 17)){
                    board[r][c] = true;
                    numAlive++;
                }
                else if((r == 1) && (c == 5 || c == 6 || c == 7 || c == 17 || c == 18 || c == 19)){
                    board[r][c] = true;
                    numAlive++;
                }
                else if((r == 2) && (c == 4 || c == 5 || c == 19 || c == 20)){
                    board[r][c] = true;
                    numAlive++;
                }
                else if((r == 3) && (c == 3 || c == 4 || c == 20 || c == 21)){
                    board[r][c] = true;
                    numAlive++;
                }
                else if((r == 4) && (c == 2 || c == 3 || c == 21 || c == 22)){
                    board[r][c] = true;
                    numAlive++;
                }
                else if((r == 5) && (c == 1 || c == 2 || c == 22 || c == 23)){
                    board[r][c] = true;
                    numAlive++;
                }
                else if((r == 6) && (c == 1 || c == 9 || c == 10 || c == 11 || c == 12 || c == 13 || c == 14 || c == 15 || c == 23)){
                    board[r][c] = true;
                    numAlive++;
                }
                else if((r == 7) && (c == 0 || c == 1 || c == 9 || c == 10 || c == 11 || c == 12 || c == 13 || c == 14 || c == 15 || c == 16 || c == 23 || c == 24)){
                    board[r][c] = true;
                    numAlive++;
                }
                else if((r == 8) && (c == 0 || c == 9 || c == 10 || c == 15 || c == 16 || c == 17 || c == 24)){
                    board[r][c] = true;
                    numAlive++;
                }
                else if((r == 9) && (c == 0 || c == 9 || c == 10 || c == 16 || c == 17 || c == 18 || c == 24)){
                    board[r][c] = true;
                    numAlive++;
                }
                else if((r == 10) && (c == 0 || c == 9 || c == 10 || c == 17 || c == 18 || c == 24)){
                    board[r][c] = true;
                    numAlive++;
                }
                else if((r == 11) && (c == 0 || c == 9 || c == 10 || c == 17 || c == 18 || c == 24)){
                    board[r][c] = true;
                    numAlive++;
                }
                else if((r == 12) && (c == 0 || c == 7 || c == 8 || c == 9 || c == 10 || c == 11 || c == 12 || c == 13 || c == 17 || c == 18 || c == 24)){
                    board[r][c] = true;
                    numAlive++;
                }
                else if((r == 13) && (c == 0 || c == 9 || c == 10 || c == 17 || c == 18 || c == 24)){
                    board[r][c] = true;
                    numAlive++;
                }
                else if((r == 14) && (c == 0 || c == 9 || c == 10 || c == 17 || c == 18 || c == 24)){
                    board[r][c] = true;
                    numAlive++;
                }
                else if((r == 15) && (c == 0 || c == 9 || c == 10 || c == 16 || c == 17 || c == 18 || c == 24)){
                    board[r][c] = true;
                    numAlive++;
                }
                else if((r == 16) && (c == 0 || c == 9 || c == 10 || c == 15 || c == 16 || c == 17 || c == 24)){
                    board[r][c] = true;
                    numAlive++;
                }
                else if((r == 17) && (c == 0 || c == 1 || c == 9 || c == 10 || c == 11 || c == 12 || c == 13 || c == 14 || c == 15 || c == 16 || c == 23 || c == 24)){
                    board[r][c] = true;
                    numAlive++;
                }
                else if((r == 18) && (c == 1 || c == 9 || c == 10 || c == 11 || c == 12 || c == 13 || c == 14 || c == 15 || c == 23)){
                    board[r][c] = true;
                    numAlive++;
                }
                else if((r == 19) && (c == 1 || c == 2 || c == 22 || c == 23)){
                    board[r][c] = true;
                    numAlive++;
                }
                else if((r == 20) && (c == 2 || c == 3 || c == 21 || c == 22)){
                    board[r][c] = true;
                    numAlive++;
                }
                else if((r == 21) && (c == 3 || c == 4 || c == 20 || c == 21)){
                    board[r][c] = true;
                    numAlive++;
                }
                else if((r == 22) && (c == 4 || c == 5 || c == 19 || c == 20)){
                    board[r][c] = true;
                    numAlive++;
                }
                else if((r == 23) && (c == 5 || c == 6 || c == 7 || c == 17 || c == 18 || c == 19)){
                    board[r][c] = true;
                    numAlive++;
                }
                else if((r == 24) && (c >= 7 && c <= 17)){
                    board[r][c] = true;
                    numAlive++;
                }
                else{
                    board[r][c] = false;
                    numDead++;
                }
            }
        }
    }

    public static void makePenis(){
        board = new boolean[25][25];
        for(int r = 0; r < board.length; r++) {
            for (int c = 0; c < board[0].length; c++) {
                if((r == 1) && (c >= 9 && c <= 14)){
                    board[r][c] = true;
                    numAlive++;
                }
                else if((r == 2) && ( c == 8 || c == 9 || c == 10 || c == 13 || c == 14 || c == 15)){
                    board[r][c] = true;
                    numAlive++;
                }
                else if((r == 3) && (c == 7 || c == 8 || c == 9 || c == 14 || c == 15 || c == 16)){
                    board[r][c] = true;
                    numAlive++;
                }
                else if((r == 4) && (c == 7 || c == 8 || c == 15 || c == 16)){
                    board[r][c] = true;
                    numAlive++;
                }
                else if((r >= 5 && r <= 11) && (c == 7 || c == 16)){
                    board[r][c] = true;
                    numAlive++;
                }
                else if((r == 12) && (c == 6 || c == 7 || c == 8 || c == 15 || c == 16 || c == 17)){
                    board[r][c] = true;
                    numAlive++;
                }
                else if((r == 13) && (c >=4 && c <=19 && c != 11 && c != 12)){
                    board[r][c] = true;
                    numAlive++;
                }
                else if((r == 14) && (c == 3 || c == 4 || c == 10 || c == 11 || c == 12 || c == 13 || c == 19 || c == 20)){
                    board[r][c] = true;
                    numAlive++;
                }
                else if((r == 15) && (c == 3 || c == 11 || c == 12 || c == 20)){
                    board[r][c] = true;
                    numAlive++;
                }
                else if((r == 16) && (c == 2 || c == 3 || c == 11 || c == 12 || c == 20 || c == 21)){
                    board[r][c] = true;
                    numAlive++;
                }
                else if((r == 17) && (c == 2 || c == 3 || c == 11 || c == 12 || c == 20 || c == 21)){
                    board[r][c] = true;
                    numAlive++;
                }
                else if((r == 18) && (c == 2 || c == 3 || c == 11 || c == 12 || c == 20 || c == 21)){
                    board[r][c] = true;
                    numAlive++;
                }
                else if((r == 19) && (c == 3 || c == 11 || c == 12 || c == 20)){
                    board[r][c] = true;
                    numAlive++;
                }
                else if((r == 20) && (c == 3 || c == 4 || c == 10 || c == 11 || c == 12 || c == 13 || c == 19 || c == 20)){
                    board[r][c] = true;
                    numAlive++;
                }
                else if((r == 21) && (c >=4 && c <=19 && c != 11 && c != 12)){
                    board[r][c] = true;
                    numAlive++;
                }
                else if((r == 22) && (c == 6 || c == 7 || c == 8 || c == 15 || c == 16 || c == 17)){
                    board[r][c] = true;
                    numAlive++;
                }
                else{
                    board[r][c] = false;
                    numDead++;
                }
            }
        }
    }

    public static void wipeValues(){
        for(int r = 0; r < board.length; r++ ){
            for(int c = 0; c < board[0].length; c++){
                board[r][c] = false;
            }
        }
    }

}
