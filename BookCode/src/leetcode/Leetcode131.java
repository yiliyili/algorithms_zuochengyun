import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class Leetcode131 {

    public List<List<String>> partition(String s) {
        int len = s.length();
        List<List<String>> res = new ArrayList<>();
        if (len == 0) {
            return res;
        }

        // Stack ����� Java ���ĵ����Ƽ�д�� Deque<Integer> stack = new ArrayDeque<Integer>();
        // ע�⣺ֻʹ�� stack ��صĽӿ�
        Deque<String> stack = new ArrayDeque<>();
        backtracking(s, 0, len, stack, res);
        return res;
    }

    /**
     * @param s
     * @param start ��ʼ�ַ�������
     * @param len   �ַ��� s �ĳ��ȣ���������Ϊȫ�ֱ���
     * @param path  ��¼�Ӹ���㵽Ҷ�ӽ���·��
     * @param res   ��¼���еĽ��
     */
    private void backtracking(String s, int start, int len, Deque<String> path, List<List<String>> res) {
        if (start == len) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = start; i < len; i++) {

            // ��Ϊ��ȡ�ַ������������ܵģ���ˣ����ô��Ӵ������ķ�ʽ�ж�һ���Ӵ��Ƿ��ǻ����Ӵ�
            // ���ǵĻ�����֦
            if (!checkPalindrome(s, start, i)) {
                continue;
            }

            path.addLast(s.substring(start, i + 1));
            backtracking(s, i + 1, len, path, res);
            path.removeLast();
        }
    }

    /**
     * ��һ����ʱ�临�Ӷ��� O(N)����ˣ����Բ��ö�̬�滮�Ȱѻ����Ӵ��Ľ����¼��һ�������
     *
     * @param str
     * @param left  �Ӵ�����߽磬����ȡ��
     * @param right �Ӵ����ұ߽磬����ȡ��
     * @return
     */
    private boolean checkPalindrome(String str, int left, int right) {
        // �ϸ�С�ڼ���
        while (left < right) {
            if (str.charAt(left) != str.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }


    
     public static void main(String[] args) {
        String word = "aab";
        Leetcode131 solution = new Leetcode131();
        List<List<String>> arr = solution.partition(word);
        System.out.println(arr);
    }
}
