public class Leetcode79 {
//给定一个二维网格和一个单词，找出该单词是否存在于网格中。
    private boolean[][] marked;

    //        x-1,y
    // x,y-1  x,y    x,y+1
    //        x+1,y
    private int[][] direction = {{-1, 0}, {0, -1}, {0, 1}, {1, 0}};//方向数组
    // 盘面上有多少行
    private int m;
    // 盘面上有多少列
    private int n;
    private String word;
    private char[][] board;

    public boolean exist(char[][] board, String word) {
        m = board.length;
        if (m == 0) {
            return false;
        }
        n = board[0].length;
        marked = new boolean[m][n];
        this.word = word;//this是为了解决局部变量和成员变量的二义性
        this.board = board;
        //任意 board[i][j] 为检索起点
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (dfs(i, j, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(int i, int j, int start) {
        if (start == word.length() - 1) {
            return board[i][j] == word.charAt(start);
        }
        //第i行第j列的字符是否和被查找的word字符串的第start个字符相等
        if (board[i][j] == word.charAt(start)) {
            marked[i][j] = true; //改为已经访问过改字符
            for (int k = 0; k < 4; k++) {//4个方向寻找下一个相等的字符
                int newX = i + direction[k][0];
                int newY = j + direction[k][1];
                //在矩阵内且未被访问过
                if (inArea(newX, newY) && !marked[newX][newY]) {
                    if (dfs(newX, newY, start + 1)) {
                        return true;
                    }
                }
            }
            //回溯,改为没有访问过该字符,说明没有以marked[i][j]开头的字符串满足word
            marked[i][j] = false;
        }
        return false;
    }

    private boolean inArea(int x, int y) {
        return x >= 0 && x < m && y >= 0 && y < n;
    }

    public static void main(String[] args) {

//        char[][] board =
//                {
//                        {'A', 'B', 'C', 'E'},
//                        {'S', 'F', 'C', 'S'},
//                        {'A', 'D', 'E', 'E'}
//                };
//
//        String word = "ABCCED";


        char[][] board = {{'a', 'b'}};
        String word = "ba";
        Leetcode79 solution = new Leetcode79();
        boolean exist = solution.exist(board, word);
        System.out.println(exist);
    }
}

