public class Leetcode79 {
//����һ����ά�����һ�����ʣ��ҳ��õ����Ƿ�����������С�
    private boolean[][] marked;

    //        x-1,y
    // x,y-1  x,y    x,y+1
    //        x+1,y
    private int[][] direction = {{-1, 0}, {0, -1}, {0, 1}, {1, 0}};//��������
    // �������ж�����
    private int m;
    // �������ж�����
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
        this.word = word;//this��Ϊ�˽���ֲ������ͳ�Ա�����Ķ�����
        this.board = board;
        //���� board[i][j] Ϊ�������
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
        //��i�е�j�е��ַ��Ƿ�ͱ����ҵ�word�ַ����ĵ�start���ַ����
        if (board[i][j] == word.charAt(start)) {
            marked[i][j] = true; //��Ϊ�Ѿ����ʹ����ַ�
            for (int k = 0; k < 4; k++) {//4������Ѱ����һ����ȵ��ַ�
                int newX = i + direction[k][0];
                int newY = j + direction[k][1];
                //�ھ�������δ�����ʹ�
                if (inArea(newX, newY) && !marked[newX][newY]) {
                    if (dfs(newX, newY, start + 1)) {
                        return true;
                    }
                }
            }
            //����,��Ϊû�з��ʹ����ַ�,˵��û����marked[i][j]��ͷ���ַ�������word
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

