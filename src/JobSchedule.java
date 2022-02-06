import java.util.LinkedList;
import java.util.List;

public class JobSchedule {
static List<String> resultArray= new LinkedList<>();
static String initialString;
    static int[] initialPattern=new int[7];
    static int unknownCount=0;
    static List<Integer> unknownPositions =new LinkedList<>();

    public static String replaceChar(char[] ch) {
        StringBuilder myString = new StringBuilder(initialString);
        for (int i = 0; i < unknownCount; i++) {
        myString.setCharAt(unknownPositions.get(i), ch[i]);
        }
        return myString.toString();
    }

    // Recursive function to print all n-digit numbers
    // whose sum of digits equals to given sum

    // n, sum --> value of inputs
    // out --> output array
    // index --> index of next digit to be
    // filled in output array
    static void findNDigitNumsUtil(int n, int sum, char out[],
                                   int index, int max)
    {

        // Base case
        if (index > n || sum < 0)
            return;

        // If number becomes N-digit
        if (index == n)
        {
            // if sum of its digits is equal to given sum,
            // print it
            if(sum == 0)
            {
//                System.out.print(out);
                resultArray.add(replaceChar(out));
            }
            return;
        }

        // Traverse through every digit. Note that
        // here we're considering leading 0's as digits
        for (int i = 0; i <= max; i++)
        {
            // append current digit to number
            out[index] = (char)(i + '0');

            // recurse for next digit with reduced sum
            findNDigitNumsUtil(n, sum - i, out, index + 1,max);
        }
    }

    // This is mainly a wrapper over findNDigitNumsUtil.
    // It explicitly handles leading digit
    static void findNDigitNums(int n, int sum, int max)
    {
        // output array to store N-digit numbers
        char[] out = new char[n];

        // fill 1st position by every digit from 1 to 9 and
        // calls findNDigitNumsUtil() for remaining positions
        for (int i = 0; i <= max; i++)
        {
            out[0] = (char)(i + '0');
            findNDigitNumsUtil(n, sum - i, out, 1, max);
        }
    }


    public static List<String> findSchedules(int workHours, int dayHours, String pattern)
    {
        initialString=pattern;
        int initialSum=0;
        List<String> finalResultArray= new LinkedList<>();

        for (int i = 0; i < pattern.length(); i++) {
            if(pattern.charAt(i)!='?'){
            initialPattern[i]=Integer.parseInt(String.valueOf(pattern.charAt(i)));}
            else{
                unknownCount++;
                unknownPositions.add(i);
                initialPattern[i]=0;
            }
        }
        for (int x:initialPattern
             ) {
            initialSum+=x;
        }
        if(initialSum==workHours) {
            finalResultArray.add(pattern);
        }
        else{
        int balance=workHours-initialSum;
        findNDigitNums(unknownCount,balance, dayHours);
        }
        finalResultArray=resultArray;
return finalResultArray;
    }
    public static void main(String[] args) {
        List<String> schedules = findSchedules(8, 3, "?12??2?");
        for (String schedule:schedules
             ) {
            System.out.println("schedule "+ schedule);
        }
    }
}
