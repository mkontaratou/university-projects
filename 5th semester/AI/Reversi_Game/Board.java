import java.util.ArrayList;

public class Board {
    public static final int X= 1;
    public static final int O = -1;
    public static final int EMPTY = 0;

    private int[][] gameBoard;
    private int lastLetter;
    private Move lastMove;
    private ArrayList<Move> areValidMoves;

    //BOARD CONSTRUCTORS
    public Board(){
        areValidMoves = new ArrayList<Move>();
        this.lastMove = new Move();
        this.lastLetter = O;
        this.gameBoard = new int[8][8];

        for(int i=0;i<8;i++){
            for(int j=0;j<8;j++){
                if(i==3 && j==3 || i==4 && j==4)
                    this.gameBoard[i][j]=X;
                else if(i==3 && j==4 || i==4 && j==3)
                    this.gameBoard[i][j]=O;
                else
                    this.gameBoard[i][j]=EMPTY;
            }
        }
    }

    public Board(Board board){
        areValidMoves = new ArrayList<Move>();
        this.lastMove = board.lastMove;
        this.lastLetter = board.lastLetter;
        this.gameBoard = new int [8][8];

        for (int i=0;i<8;i++){
            for(int j=0;j<8;j++){
                this.gameBoard[i][j]= board.gameBoard[i][j];
            }
        }
    }

    //GETTERS SETTERS
    public int[][] getGameBoard() {
        return gameBoard;
    }

    public void setGameBoard(int[][] gameBoard) {
        for (int i=0;i<8;i++){
            for(int j=0;j<8;j++){
                this.gameBoard[i][j]= gameBoard[i][j];
            }
        }
    }

    public int getLastLetter() {
        return lastLetter;
    }

    public void setLastLetter(int lastLetter) {
        this.lastLetter = lastLetter;
    }

    public Move getLastMove() {
        return lastMove;
    }

    public void setLastMove(Move lastMove) {
        this.lastMove = lastMove;
    }



    //Make a move, places X OR O on the board
    boolean makeMove(int row,int col, int letter){
        lastLetter = letter;
        //empty list of valid moves
        if(letter==Board.O)
            areValidMoves.clear();
        if(isValid(row,col,letter)){
            for(Move v:areValidMoves)
                createLine(v.getRow()-row,v.getCol()-col,v.getRow(),v.getCol(),letter);

            gameBoard[row][col]=letter;
            lastMove=new Move(row,col);
            //empty list of valid moves
            areValidMoves.clear();
            return true;
        } else {
            return false;
        }
    }

    //Diagonal, horizontal or vertical line creation using delta
    //deltaR = row increment around a square
    //deltaC = column increment around a square
    void createLine(int deltaR,int deltaC,int r,int c,int letter){
        //if in the row and column of Move v is the same as the one of the player's return
        if(gameBoard[r][c]==letter)
            return;
        else{
            //change the square to the corresponding letter (r,c are v.getRow(), v.getCol())
            //the symbol changes so that it can match with the one of the player's
            gameBoard[r][c]=letter;
            //call createLine() to delta direction
            createLine(deltaR,deltaC,r+deltaR,c+deltaC,letter);
        }

    }


    //Checks whether a move is valid or not if a square is empty
    boolean isValid(int row, int col,int s){

        //not valid if out of bounds of board
        if((row <= -1) || (col <= -1) || (row > 7) || (col > 7))
            return false;

        //not valid if the move is empty
        if(gameBoard[row][col] != EMPTY)
            return false;



        //not valid if there are no neighbors of the opposite color
        //we check whether or not we can move up, down or side to side
        ArrayList<Move> opposites = new ArrayList<Move>();
        //int opSymbol = -s;

        //if we can move upwards
        if(row>0){
            //box right above the given position
            if(gameBoard[row-1][col]==-s)
                opposites.add(new Move(row-1,col));
            //upper left box
            if(col>0){
                if(gameBoard[row-1][col-1]==-s)
                    opposites.add(new Move(row-1,col-1));
            }
            //upper right box
            if(col<7){
                if(gameBoard[row-1][col+1]==-s)
                    opposites.add(new Move(row-1,col+1));
            }
        }

        //if we can move downwards
        if(row<7){
            //box right down the given postition
            if(gameBoard[row+1][col]==-s)
                opposites.add(new Move(row+1,col));
            //down right box
            if(col>0){
                if(gameBoard[row+1][col-1]==-s)
                    opposites.add(new Move(row+1,col-1));
            }
            //down left box
            if(col<7){
                if(gameBoard[row+1][col+1]==-s)
                    opposites.add(new Move(row+1,col+1));
            }


        }

        //if we can move only right and left
        //move right
        if(col<7){
            if(gameBoard[row][col+1]==-s)
                opposites.add(new Move(row,col+1));
        }
        //move left
        if(col>0){
            if(gameBoard[row][col-1]==-s)
                opposites.add(new Move(row, col-1));
        }

        if(opposites.isEmpty())
            return false;


        /*invalid if there is no line in between of the tile we added and one that already exists of the same color
        in the same line
        deltaRow = m.getRow()-row , deltaColumn = m.getCol()-col
         */
        int count=0;
        for(Move m:opposites){
            if (!Line(m.getRow(),m.getCol(),m.getRow()-row,m.getCol()-col,s))
                count++;
            else
                areValidMoves.add(m);
        }

        if(count==opposites.size())
            return false;
        return true;

    }

    //checking whether there is a tile of the player's symbol that creates a line between the one we want to add and
    //the opponent's symbol
    boolean Line(int row,int col, int r,int c,int letter){
        if(gameBoard[row][col]==letter)
            return true;
        if(gameBoard[row][col] == 0)
            return false;
        if((row+r<0) ||(row+r>7))
            return false;
        if((col+c<0) ||(col+c>7))
            return false;

        return Line(row+r,col+c,r,c,letter);
    }

    ArrayList<Board> getChildren(int letter){
        ArrayList<Board> children = new ArrayList<Board>();
        for (int i=0;i<8;i++){
            for(int j=0;j<8;j++){
                if(isValid(i,j,letter)){
                    Board child = new Board(this);
                    child.makeMove(i,j,letter);
                    children.add(child);
                }
            }
        }
        return children;
    }

    //heuristic function, evaluate every state depending on the position
    int evaluate(){
        int scoreX = 0;
        int scoreO = 0;


        //check diagonals
        if(gameBoard[0][0] == X || gameBoard[0][7] == X ||gameBoard[7][0] == X || gameBoard[7][7] == X )
            scoreX+=100;
        else if(gameBoard[0][0] == O || gameBoard[0][7] == O ||gameBoard[7][0] == O || gameBoard[7][7] == O )
            scoreO+=100;


        //checking rows
        for (int row=0;row<8;row++) {
            if (gameBoard[row][0] == X || gameBoard[row][7] == X )
                scoreX+=10;
            else if (gameBoard[row][0] == O || gameBoard[row][7] == O )
                scoreO+=10;
        }

        //checking columns
        for (int col=0;col<8;col++) {
            if (gameBoard[0][col] == X  || gameBoard[7][col] == X ) {
                scoreX+=10;
            } else if (gameBoard[0][col] == O  || gameBoard[7][col] == O) {
                scoreO+=10;
            }
        }

        //checking remaining
        for(int row=1;row<7;row++){
            for(int col=1;col<7;col++){
                if(gameBoard[row][col] == X)
                    scoreX++;
                else if(gameBoard[row][col] == O)
                    scoreO++;
            }
        }

        return scoreX - scoreO;
    }

    //board is full with no space, checks of only one colour
    boolean isTerminal(){
        int count=0;

        for(int i=0;i<8;i++){
            for(int j=0;j<8;j++){
                if(gameBoard[i][j] == O || gameBoard[i][j] == X )
                    count++;
            }
        }

        return count == 64;
    }

    void print(){
        System.out.println("* 1 2 3 4 5 6 7 8 *");
        int[] n =new int[]{1,2,3,4,5,6,7,8};

        for(int r=0;r<8;r++) {
            System.out.print(n[r]+" ");
            for(int c=0;c<8;c++) {
                switch (gameBoard[r][c]){
                    case X:
                        System.out.print("X ");
                        break;
                    case O:
                        System.out.print("O ");
                        break;
                    case EMPTY:
                        System.out.print("- ");
                        break;
                    default:
                        break;
                }
            }
            System.out.println("*");
        }
        System.out.println("* * * * * * * * * *\n");
    }


    void printResult(){
        int scoreX=0;
        int scoreO=0;

        for (int r=0;r<8;r++){
            for(int c=0;c<8;c++){
                if(gameBoard[r][c]==X)
                    scoreX++;
                if(gameBoard[r][c]==O)
                    scoreO++;
            }
        }

        if(scoreO>scoreX)
            System.out.println("Player O, you win!");
        else if(scoreO<scoreX)
            System.out.println("Player X, you win!");
        else
            System.out.println("It's a tie!");

        System.out.print("\n\n-------------GAME OVER-------------\n\n");

    }


}
