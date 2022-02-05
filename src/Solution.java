import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;


class Result {

    /*
     * Complete the 'findSubstring' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts following parameters:
     *  1. STRING s
     *  2. INTEGER k
     */

    public static String findSubstring(String str, int K ){

        int N = str.length();

        int []pref = new int[N];

        for (int i = 0; i < N; i++)
        {
            if (str.charAt(i) == 'a' ||
                    str.charAt(i) == 'e' ||
                    str.charAt(i) == 'i' ||
                    str.charAt(i) == 'o' ||
                    str.charAt(i) == 'u')
                pref[i] = 1;

                // Otherwise, store 0
            else
                pref[i] = 0;

            // Process the prefix array
            if (i != 0)
                pref[i] += pref[i - 1];
        }

        // Initialize the variable to store
        // maximum count of vowels
        int maxCount = pref[K - 1];

        // Initialize the variable
        // to store substring
        // with maximum count of vowels
        String res = str.substring(0, K);

        // Loop through the prefix array
        for (int i = K; i < N; i++)
        {
            // Store the current
            // count of vowels
            int currCount = pref[i] -
                    pref[i - K];

            // Update the result if current count
            // is greater than maximum count
            if (currCount > maxCount)
            {
                maxCount = currCount;
                res = str.substring(i - K + 1,
                        i + 1);
            }

            // Update lexicographically smallest
            // substring if the current count
            // is equal to the maximum count
//            else if (currCount == maxCount)
//            {
//                String temp = str.substring(i - K + 1,
//                        i + 1);
//
//                if (temp.compareTo(res) < 0)
//                    res = temp;
//            }
        }
        if(maxCount==0)
        {
            return "Not found!";
        }
        // Return the result
        return res;
    }

}
public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = bufferedReader.readLine();

        int k = Integer.parseInt(bufferedReader.readLine().trim());

        String result = Result.findSubstring(s, k);
        System.out.println(result);

//        bufferedWriter.write(result);
//        bufferedWriter.newLine();

        bufferedReader.close();
//        bufferedWriter.close();
    }
}
