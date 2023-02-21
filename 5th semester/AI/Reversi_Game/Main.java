import java.util.Scanner;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner input = new Scanner(System.in);

        System.out.print("\n\n-------------REVERSI-------------\n\n");
        System.out.print("\nYou will be playing against a computer\n");
        System.out.print("\nComputer plays with X\n");
        System.out.print("Player plays with O\n");

        //Who plays first input
        int turn=0;
        System.out.println("\nTo play first, enter 1, else enter 2");
        input = new Scanner(System.in);
        turn = input.nextInt();
        while(turn!=1 && turn!=2){
            System.out.println("Enter 1 if you want to play first, else enter 2 ");
            input = new Scanner(System.in);
            turn = input.nextInt();
        }

        //depth input
        int depth=0;
        System.out.println("Enter the depth of search: ");
        input = new Scanner(System.in);
        depth = input.nextInt();
        while(depth <=0){
            System.out.println("Enter the depth of search again: ");
            input = new Scanner(System.in);
            depth = input.nextInt();
        }

        //Initialize board and players
        Player Xplayer = new Player(depth,Board.X);
        Player Oplayer = new Player(2, Board.O);
        Board board = new Board();
        board.print();

        //player plays first
        if(turn==1){
            //computer played last
            board.setLastLetter(Board.X);
        } else {
            //player played last
            board.setLastLetter(Board.O);
        }

        int[] rows = new int[]{1,2,3,4,5,6,7,8};
        int[] cols = new int[]{1,2,3,4,5,6,7,8};

        while(!board.isTerminal()){
            System.out.println();
            switch(board.getLastLetter())
            {
                //If X played last, then Ο plays now
                case Board.X:
                    System.out.println("It's player's O turn");
                    Move moveO;
                    Move move = new Move();
                    ArrayList<Move> moves = new ArrayList<Move>(); //list with possible valid moves

                    for(int i=0;i<8;i++){
                        for(int j=0;j<8;j++){
                            if(board.isValid(i,j,Board.O)){
                                System.out.println("You can move to (" +(i+1)+ ","+cols[j] +")");
                                moves.add(new Move(i,j));
                            }
                        }
                    }

                    if(moves.isEmpty())
                        System.out.println("No possible valid moves ");
                    else{
                        boolean wrongMove=true;
                        while(wrongMove) {

                            //user input for row in valid move
                            int r = 0;
                            System.out.println("Enter the number of row: ");
                            input = new Scanner(System.in);
                            r = input.nextInt();
                            while (r < 1 || r > 8) {
                                System.out.println("Wrong input.Enter the number of row again (1-8): ");
                                input = new Scanner(System.in);
                                r = input.nextInt();
                            }
                            r--;

                            //user input for column in valid move
                            int c = 0;
                            System.out.println("Enter the number of column: ");
                            input = new Scanner(System.in);
                            c = input.nextInt();
                            while (c < 1 || c > 8) {
                                System.out.println("Wrong input.Enter the number of column again (1-8): ");
                                input = new Scanner(System.in);
                                c = input.nextInt();
                            }
                            c--;

                            //check that user's choice of movement is valid
                            for (Move m : moves) {
                                if (r == m.getRow() && c == m.getCol()) {
                                    wrongMove = false;
                                    move.setRow(r);
                                    move.setCol(c);
                                }
                            }

                            if(wrongMove)
                                System.out.println("Wrong move entered");
                        }

                    }

                    moveO = move;
                    if(!board.makeMove(moveO.getRow(),moveO.getCol(),Board.O))
                        System.out.println("No valid move detected\n");
                    else
                        System.out.println("You played: ("+rows[moveO.getRow()]+","+cols[moveO.getCol()]+')');

                    break; //next player

                //If O played last, then X plays now
                case Board.O:
                    System.out.println("It's player's X turn");
                    Move moveX = Xplayer.MiniMaxAB(board);
                    if(!board.makeMove(moveX.getRow(),moveX.getCol(),Board.X))
                        System.out.println("No valid move detected\n");
                    else
                        System.out.println("Player X played: ("+rows[moveX.getRow()]+","+cols[moveX.getCol()]+')');
                    break; //next player

                default:
                    break;
            }
            board.print();
        }
    board.printResult();

    }

}
