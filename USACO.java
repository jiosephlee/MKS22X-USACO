import java.io.*;
import java.util.*;
public class USACO{
    public static void main(String[] args) throws FileNotFoundException{
        System.out.println(bronze("makelake.1.in"));
        System.out.println(silver("ctravel.1.in"));
    }
    public static int bronze(String filename) throws FileNotFoundException{
        File text = new File(filename);
        // can be a path like: "/full/path/to/file.txt" or "../data/file.txt"

        //inf stands for the input file
        Scanner in = new Scanner(text);

        int R = Integer.parseInt(in.next());
        int C = Integer.parseInt(in.next());
        int E = Integer.parseInt(in.next());
        int N = Integer.parseInt(in.next());
        int[][] board = new int[R][C];
        int[][] instructions = new int[N][3];
        for (int xcor = 0; xcor < R; xcor++){
            for (int ycor = 0; ycor < C; ycor++){
                board[xcor][ycor] = Integer.parseInt(in.next());
                //System.out.print(board[xcor][ycor]);
            }
            //System.out.println();
        }
        for (int xcor = 0; xcor < N; xcor++){
            for (int ycor = 0; ycor < 3; ycor++){
                instructions[xcor][ycor] = Integer.parseInt(in.next());
                //System.out.print(instructions[xcor][ycor]);
            }
            //System.out.println();
        }
        return solveBronze(board, E, instructions);
    }
    public static int solveBronze(int[][] board, int E, int[][] instructions){
        for (int[] i : instructions){
            int max = 0;
            for(int xcor = i[0] - 1; xcor < i[0] + 2; xcor++){
                for(int ycor = i[1] - 1; ycor < i[1] + 2; ycor++){
                    if (board[xcor][ycor] > max){
                        max = board[xcor][ycor];
                    }
                }
            }
            max = max - i[2];
            for(int xcor = i[0] - 1; xcor < i[0] + 2; xcor++){
                for(int ycor = i[1] - 1; ycor < i[1] + 2; ycor++){
                    if (board[xcor][ycor] > max){
                        board[xcor][ycor] = max;
                    }
                }
            }
        }
        int sum = 0;
        for (int x = 0; x < board.length; x++){
            for (int y = 0; y < board[0].length; y++){
                //System.out.print(E - board[x][y]);
                if (E - board[x][y] > 0){
                    sum+= E - board[x][y];
                }
            }
            //System.out.println();
        }
        return sum * 72 * 72;
    }
    public static int silver(String filename) throws FileNotFoundException{
        File text = new File(filename);
        // can be a path like: "/full/path/to/file.txt" or "../data/file.txt"

        //read the file
        Scanner in = new Scanner(text);

        int rows,cols,seconds;
        int[][] directions = {{1,0},{0,1},{-1,0},{0,-1}}; // 4 orthogonal directions
        int [] locations = new int[4]; //parameters of problem

        rows = in.nextInt();
        cols = in.nextInt();
        seconds = in.nextInt(); // load problem in parameters

        int[][] board = new int[rows][cols]; //create map
        for (int r = 0;r < rows ;r++ ) {
            String next = in.next();
                for (int c = 0;c < cols ;c++ ) {
                    if(next.charAt(c) == '*'){
                        board[r][c] = -1;
                    }
                }
            }

        locations[0] = in.nextInt() -1;
        locations[1] = in.nextInt()-1 ;
        locations[2] = in.nextInt() -1 ;
        locations[3] = in.nextInt()-1;

        return solveSilver(locations, board);
    }
    public static int solveSilver(int[] locations, int[][] board){
        for (int[] i : instructions){
            int max = 0;
            for(int xcor = i[0] - 1; xcor < i[0] + 2; xcor++){
                for(int ycor = i[1] - 1; ycor < i[1] + 2; ycor++){
                    if (board[xcor][ycor] > max){
                        max = board[xcor][ycor];
                    }
                }
            }
            max = max - i[2];
            for(int xcor = i[0] - 1; xcor < i[0] + 2; xcor++){
                for(int ycor = i[1] - 1; ycor < i[1] + 2; ycor++){
                    if (board[xcor][ycor] > max){
                        board[xcor][ycor] = max;
                    }
                }
            }
        }
        int sum = 0;
        for (int x = 0; x < board.length; x++){
            for (int y = 0; y < board[0].length; y++){
                //System.out.print(E - board[x][y]);
                if (E - board[x][y] > 0){
                    sum+= E - board[x][y];
                }
            }
            //System.out.println();
        }
        return sum * 72 * 72;
    }
}
