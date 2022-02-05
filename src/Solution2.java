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

class Result2 {

    /*
     * Complete the 'rotateLeft' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts following parameters:
     *  1. INTEGER d
     *  2. INTEGER_ARRAY arr
     */

    public static List<Integer> rotateLeft(int d, List<Integer> arr) {
        Integer l=arr.size();
        if(l==d)
        {
            return arr;
        }
        if(l<d)
        {
            d=d-l;
        }
        Integer[] rotatedArray=new Integer[l];
        for(int i=0;i<d;i++)
        {
            System.out.println(d-1-i);
            rotatedArray[l-1-i]=arr.get(d-1-i);
        }
        for(int j=0;j<l-d;j++)
        {
            rotatedArray[j]= arr.get(d+j);
        }
        List<Integer> result= Arrays.asList(rotatedArray);
        System.out.println(result);
        return result;

    }

}

public class Solution2 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(firstMultipleInput[0]);

        int d = Integer.parseInt(firstMultipleInput[1]);

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        List<Integer> result = Result2.rotateLeft(d, arr);

//        bufferedWriter.write(
//                result.stream()
//                        .map(Object::toString)
//                        .collect(joining(" "))
//                        + "\n"
//        );

        bufferedReader.close();
//        bufferedWriter.close();
    }
}
