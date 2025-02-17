/**

 - @author 이병헌
 - @since 12/4/2024
 - @see https://www.acmicpc.net/problem/5021
 - @git https://github.com/Hunnibs
 - @youtube
 - @performance 1sec 128MB
 - @category # Graph # Tree
 - @note

 */

import java.util.*;
import java.io.*;

public class Main {
    static int[] arr = new int[10];
    static {
        for (int i = 0; i < 10; i++) {
            arr[i] = i;
        }
    }

    public static void main(String[] args) throws IOException{
        System.out.println(Arrays.toString(arr));
    }
}