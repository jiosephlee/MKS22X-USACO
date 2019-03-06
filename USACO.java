import java.io.*;
import java.util.*;
public class USACO{
    public static void main(String[] args) throws FileNotFoundException{
        bronze("makelake.1.in");
    }
    public static int bronze(String filename) throws FileNotFoundException{
        File text = new File(filename);
        // can be a path like: "/full/path/to/file.txt" or "../data/file.txt"

        //inf stands for the input file
        Scanner inf = new Scanner(text);
        String lineone = inf.nextLine();
        String[] elements = new String[]{"","","",""}; //R, C, E, N
        for(int i = 0, index = 0; i < lineone.length(); i++){
            if(lineone.charAt(i) == ' '){
                index++;
                //System.out.println(index);
            } else{
                elements[index]+=lineone.substring(i,i+1);
                //System.out.println(elements[index]);
            }
        }
        int R = Integer.parseInt(elements[0]);
        int C = Integer.parseInt(elements[1]);
        int E = Integer.parseInt(elements[2]);
        int N =Integer.parseInt(elements[3]);
        int[][] board = new int[R][C];
        int[][] instructions = new int[N][3];
        for (int xcor = 0; xcor < R; xcor++){
            String line = inf.nextLine();
            for (int ycor = 0; ycor < line.length(); ycor++){
                board[xcor][ycor] = line.charAt(ycor);
                System.out.print(board[xcor][ycor]);
            }
            System.out.println();
        }
        for (int xcor = 0; xcor < N; xcor++){
            String line = inf.nextLine();
            for (int ycor = 0; ycor < 3; ycor++){
                instructions[xcor][ycor] = line.charAt(ycor);
                System.out.print(instructions[xcor][ycor]);
            }
            System.out.println();
        }
        return -1;
    }
}
