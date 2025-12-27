package com.malachi.DSA.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Maze {
    public static void main(String[] args) {
        boolean[][] maze = {
                {true, true,true},
                {true, true,true},
                {true, true,true}
        };
        int[][] paths = new int[maze.length][maze[0].length];
        printMazePath(maze, 0,0, "",1, paths);
    }

    public static int pathCount(int r, int c, int targetRow, int targetCol){
        if(r == targetRow || c == targetCol){
//            System.out.println("( " + r + " , " + c + " )");
            return 1;
        }

        int left = pathCount(r - 1, c, targetRow, targetCol);
        int right = pathCount(r, c - 1, targetRow,targetCol);

        return left + right;
    }

    public static List<String> showPathToDestination(int r, int c, int targetRow, int targetCol, String path){
        if(r == targetRow && c == targetCol){
            List<String> list = new ArrayList<>();
            list.add(path);
            return list;
        }
        List<String> result = new ArrayList<>();
        //only go down if we are yet to reach the final row.
         if(r > 1){
             List<String> ans = showPathToDestination(r - 1, c, targetRow, targetCol, path + "D");
             result.addAll(ans);
         }
         //only go right if we are yet to reach the final column.
         if(c > 1){
             List<String> ans = showPathToDestination(r, c - 1, targetRow,targetCol, path + "R");
             result.addAll(ans);
         }

         return result;
    }

    public static List<String> pathDiagonal(int r, int c, int targetRow, int targetCol, String path){
        if(r == targetRow && c == targetCol){
            List<String> list = new ArrayList<>();
            list.add(path);
            return list;
        }
        List<String> result = new ArrayList<>();
        //only go down if we are yet to reach the final row.
        if(r > 1){
            List<String> ans = pathDiagonal(r - 1, c, targetRow, targetCol, path + "down ");
            result.addAll(ans);
        }

        //for diagonal movement row and column must be greater than one.
        if(r > 1 && c > 1){
            List<String> ans = pathDiagonal(r - 1, c - 1, targetRow, targetCol, path + "diagonal ");
            result.addAll(ans);
        }
        //only go right if we are yet to reach the final column.
        if(c > 1){
            List<String> ans = pathDiagonal(r, c - 1, targetRow,targetCol, path + "right ");
            result.addAll(ans);
        }

        return result;
    }

    public static void pathRestriction(boolean[][] maze, int r, int c, String path){
        if(r == maze.length - 1 && c == maze[0].length - 1){
            System.out.println(path);
            return;
        }

        //there is an obstacle.
        if(!maze[r][c]){
            return;
        }

        if(r < maze.length - 1){
            pathRestriction(maze, r + 1, c, path + "D");
        }

        if(c < maze[0].length - 1){
            pathRestriction(maze, r, c + 1, path + "R");
        }
    }

    /*
    Important Points:
    1. Marking false simply means I have that cell in my current path.
    2. So when that path is over, and you are returning from the recursive call, you should restore the path to its already default. So other recursive calls can use that path.
    3. While you are moving back, you restore the maze as it was changing "false" back to "true" (emphasizing point 2)
    4. This process is called "BACKTRACKING" (It simply means that if I had not taken this path what will my array look like)
    */

    public static void allPaths(boolean[][] maze, int r, int c, String path){
        if(r == maze.length - 1 && c == maze[0].length - 1){
            System.out.println(path);
            return;
        }

        //already visited.
        if(!maze[r][c]){
            return;
        }

        //Mark as false as we are using this "cell" in our "path".
        maze[r][c] = false;

        if(r < maze.length - 1){
            allPaths(maze, r + 1, c, path + "D");
        }

        if(c < maze[0].length - 1){
            allPaths(maze, r, c + 1, path + "R");
        }

        if(c > 0 && maze[r][c - 1]){
            allPaths(maze, r, c - 1, path + "L");
        }

        if(r > 0 &&  maze[r - 1][c]){
            allPaths(maze, r - 1, c, path + "U");
        }

        /*
        At this point the method/function call will be over and will be returned to the method/function that invoked it.
        Restore cell to it original default, so other recursive calls can make use of this "cell" as a "path".
       */
        maze[r][c] = true;
    }

    public static void printMazePath(boolean[][] maze, int r, int c, String p, int step, int[][] paths){
        if(r == maze.length - 1 && c == maze[0].length - 1){
            System.out.println(p);
            paths[r][c] = step;
            Stream.of(paths).forEach(item -> System.out.println(Arrays.toString(item)));
            return;
        }

        //already visited.
        if(!maze[r][c]){
           return;
        }

        //Mark this maze cell as false as we are using this "cell" while traversing the maze.
        maze[r][c] = false;

        //number the paths that has been traversed.
        paths[r][c] = step;

        if(r < maze.length - 1){
            printMazePath(maze, r + 1, c, p + "D",step + 1,paths);
        }

        if(c < maze[0].length - 1){
            printMazePath(maze, r, c + 1, p + "R",step + 1,paths);
        }

        if(c > 0 && maze[r][c - 1]){
            printMazePath(maze, r, c - 1, p + "L",step + 1,paths);
        }

        if(r > 0 &&  maze[r - 1][c]){
            printMazePath(maze, r - 1, c, p + "U", step + 1,paths);
        }

        /*
        At this point the method/function call will be over and will be returned to the method/function that invoked it.
        Restore cell to it original default, so other recursive calls can make use of this "cell" as a "p".
       */
        maze[r][c] = true;
        //reset the cell in this path to it default value of zero(0)
        paths[r][c] = 0;
    }


}
