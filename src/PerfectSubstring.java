class Solution6 {

    public boolean check(int[] arr, int k) {
        for(int val : arr) {
            System.out.println("array outside function"+val);
            if(val != 0 && val != k) return false;
        }
        System.out.println("true");
        return true;
    }

    public int perfectSubstring(String s, int k) {
        int res = 0;
        for(int i=0; i<s.length(); i++) {
            int[] arr = new int[10];
            for(int j = i; j<s.length(); j++) {
                System.out.println(i);
                System.out.println(j);
//                System.out.println("start");
                if(j > i + (10*k)) break;
                System.out.println(s.substring(i,j+1));
                char ch = s.charAt(j);
//                System.out.println("character"+ch);
                arr[ch-'0']++;
//                System.out.println("array inside function"+arr[ch-'0']);
                if(check(arr, k)) res++;
            }
        }
        return res;
    }

}


public class PerfectSubstring {
    public static void main(String[] args) {
        Solution6 solution6=new Solution6();
        int answer = solution6.perfectSubstring("113223", 2);
        System.out.println(answer);
    }
}
