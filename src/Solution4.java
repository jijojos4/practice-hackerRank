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

class Result4 {

    /*
     * Complete the 'arrayManipulation' function below.
     *
     * The function is expected to return a LONG_INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER n
     *  2. 2D_INTEGER_ARRAY queries
     */

    public static long arrayManipulation(int n, List<List<Integer>> queries) {
        // Write your code here
        long outputArray[] = new long[n + 2];

        for(List<Integer> query:queries ){
            int a=query.get(0);
            int b=query.get(1);
            int k=query.get(2);
            System.out.println(a+" "+b+" "+k+" "+ outputArray[a]+" "+outputArray[b + 1]);
            outputArray[a] += k;
            outputArray[b + 1] -= k;
            System.out.println(a+" "+b+" "+k+" "+ outputArray[a]+" "+outputArray[b + 1]);
            for (int i = 0; i < outputArray.length; i++) {
                System.out.print(outputArray[i]+" ");
            }
            System.out.println();

        }
        long max = getMax(outputArray);
        return max;
        // Arrays.sort(result);
        // return result[n-1];

    }
    private static long getMax(long[] inputArray) {
        long max = Long.MIN_VALUE;
        long sum = 0;
        for (int i = 0; i < inputArray.length; i++) {
            System.out.println(inputArray[i]);
            sum += inputArray[i];
            System.out.println(sum);
            max = Math.max(max, sum);
        }
        return max;
    }

}

public class Solution4 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(firstMultipleInput[0]);

        int m = Integer.parseInt(firstMultipleInput[1]);

        List<List<Integer>> queries = new ArrayList<>();

        IntStream.range(0, m).forEach(i -> {
            try {
                queries.add(
                        Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                                .map(Integer::parseInt)
                                .collect(toList())
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        long result = Result4.arrayManipulation(n, queries);

//        bufferedWriter.write(String.valueOf(result));
//        bufferedWriter.newLine();

        bufferedReader.close();
//        bufferedWriter.close();
    }
}
