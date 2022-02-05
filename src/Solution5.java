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


class Result5 {

    /*
     * Complete the 'minOperations' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY arr
     *  2. INTEGER threshold
     *  3. INTEGER d
     */

    public static int minOperations(List<Integer> arr, int threshold, int d) {
        int MAX = 200001;
        Integer n= arr.size();
        Integer[] a= new Integer[n];
        arr.toArray(a);
        Vector<Integer> []v = new Vector[MAX];
        for(int i = 0; i < v.length; i++)
            v[i] = new Vector<Integer>();



        for(int i = 0; i < n; i++)
        {
            int cnt = 0;

            // Insert 0 into V[a[i]] as
            // it is the initial state
            System.out.println(a[i]);
            v[a[i]].add(0);

            while (a[i] > 0)
            {
                a[i] /= d;
                cnt++;

                // Insert the moves required
                // to obtain current a[i]
                v[a[i]].add(cnt);
            }
        }
        int ans = Integer.MAX_VALUE;

        // Traverse v[] to obtain
        // minimum count of moves
        for(int i = 0; i < MAX; i++)
        {

            // Check if there are at least
            // K equal elements for v[i]
            if (v[i].size() >= threshold)
            {
                int move = 0;

                Collections.sort(v[i]);

                // Add the sum of minimum K moves
                for(int j = 0; j < threshold; j++)
                {
                    move += v[i].get(j);
                }

                // Update answer
                ans = Math.min(ans, move);
            }
        }

        // Return the final answer
        return ans;}

}
public class Solution5 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int arrCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> arr = IntStream.range(0, arrCount).mapToObj(i -> {
                    try {
                        return bufferedReader.readLine().replaceAll("\\s+$", "");
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                })
                .map(String::trim)
                .map(Integer::parseInt)
                .collect(toList());

        int threshold = Integer.parseInt(bufferedReader.readLine().trim());

        int d = Integer.parseInt(bufferedReader.readLine().trim());

        int result = Result5.minOperations(arr, threshold, d);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
