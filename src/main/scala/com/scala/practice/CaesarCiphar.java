package com.scala.practice;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;
import java.util.stream.Collectors;

public class CaesarCiphar {

    static String[] spanWithHead(String s){
        StringBuilder result1 = new StringBuilder();
        StringBuilder result2 = new StringBuilder();
        char head = s.charAt(0);
        boolean isFound = false;
        for(char value: s.toCharArray()){
            if(value == head && !isFound){
                result1.append(value);
            }else{
                isFound = true;
                result2.append(value);
            }
        }
        return new String[]{result1.toString(), result2.toString()};
    }

    static String[] weightedUniformStrings(String s, int[] queries) {
        char[] chars = s.toCharArray();
        ArrayList<Integer> result = new ArrayList<Integer>();
        int sumOfRepeatedStr = 0;
        char lastChar = '\u0000';
        for(char value: chars){
            if(lastChar == value){
                sumOfRepeatedStr += ((value - 97) % 26) + 1;
                result.add(sumOfRepeatedStr);
            }else{
                lastChar = value;
                result.add(((value - 97) % 26) +1 );
                sumOfRepeatedStr = ((value - 97) % 26) + 1;
            }
        }
        String[] finalResult = new String[queries.length];
        for(int i =0;i<queries.length;i++){
            if(result.contains(queries[i])){
                finalResult[i] = "Yes";
            }else{
                finalResult[i] = "No";
            }
        }
        return finalResult;
    }

    static int theLoveLetterMystery(String s) {
        int size = s.length();
        char[] chars = s.toCharArray();
        int count = 0;
        for(int i =0;i<size/2;i++){
            int first = (int) chars[i];
            int last = (int) chars[size-i-1];
            if(first > last){
                while (chars[i] != chars[size-i-1]){
                    count ++;
                    chars[i] = (char) ((int) chars[i] -1);
                }
            }else {
                while (chars[i] != chars[size - i - 1]) {
                    count++;
                    chars[size - i - 1] = (char) ((int) chars[size - i - 1] - 1);
                }
            }
        }
        return count;
    }

    static String funnyString(String s) {
        char[] chars = s.toCharArray();
        int size = s.length();
        for(int i =0;i<chars.length-1;i++){
            char first = chars[i];
            char last = chars[size - i -1];
            char second = chars[i+1];
            char secondLast = chars[size -i-2];
            int diff1 = Math.abs((int) second - (int) first);
            int diff2 = Math.abs((int) last - (int) secondLast);
            if(diff1 != diff2){
                return "Not Funny";
            }
        }

        return "Funny";

    }

    static int palindromeIndex(String s) {
        for(int x=0;x<=(s.length()-1)/2;x++)
        {
            if(s.charAt(x)!=s.charAt(s.length()-1-x))
            {
                if(s.charAt(x+1)==s.charAt(s.length()-1-x)&&s.charAt(x+2)==s.charAt(s.length()-2-x))
                {
                    return x;
                }
                if(s.charAt(x)==s.charAt(s.length()-2-x))
                {
                    return s.length()-x-1;
                }
            }
        }
        return -1;

    }


    static int alternatingCharacters(String s) {
        char[] chars = s.toCharArray();
        int deletes = 0;
        String expected = "010";
        StringBuilder added = new StringBuilder();
        int count = 0;
        for(char c: chars){
            added.append(c);
            count ++;
            if(count == 3 || (count == 1 && c == '1')){
                if(added.toString().equals(expected)){
                    deletes ++;
                }
                added = new StringBuilder();
                count = 0;
            }

        }
        return deletes;
    }



    static void separateNumbers(String s) {
        char[] charArr = s.toCharArray();
        int totalLength = s.length();
        int count = 1;
        while (count < totalLength){
            StringBuilder comp = new StringBuilder();
            StringBuilder a = new StringBuilder();
            for(int i=1;i<totalLength;i+=count){
                for(int j = 0 ;j<count;j++){
                   a.append(charArr[j]);
                }
                comp.append(Integer.parseInt("" + a) +1);
            }
            if(comp.toString().equals(s)){
                System.out.println("YES "+ a);
                break;
            }else{
                count ++;
            }
        }

    }

    static String superReducedString(String str) {
        Stack<Character> stack = new Stack();
        for (int i = 0; i < str.length(); i++) {
            Character ch = str.charAt(i);
            if (!stack.isEmpty() && ch == stack.peek()) {
                stack.pop(); // since String has 2 adjacent equal characters
            } else {
                stack.push(ch);
            }
        }

        /* Return final result */
        if (stack.isEmpty()) {
            return "Empty String";
        } else {
            StringBuffer sb = new StringBuffer();
            for (char ch : stack) {
                sb.append(ch);
            }
            return sb.toString();
        }

    }

    static int marsExploration(String s) {
        int count = 0;
        String[] strArr = s.split("(?<=\\G.{3})");
        for (String value : strArr) {
            if (!value.equals("SOS")) {
                if (value.charAt(0) != 'S') {
                    count++;
                }
                if (value.charAt(1) != 'O') {
                    count++;
                }
                if (value.charAt(2) != 'S') {
                    count++;
                }
            }
        }
        return count;

    }



    // Complete the caesarCipher function below.
    static String caesarCipher(String text, int s) {
        StringBuilder result = new StringBuilder();
        String input = "abcdefghijklmnopqrstuvwxyz";
        for (int i=0; i<text.length(); i++)
        {
            if(input.indexOf(Character.toLowerCase(text.charAt(i))) != -1) {
                if (Character.isUpperCase(text.charAt(i))) {
                    char ch = (char) (((int) text.charAt(i) +
                            s - 65) % 26 + 65);
                    result.append(ch);
                } else {
                    char ch = (char) (((int) text.charAt(i) +
                            s - 97) % 26 + 97);
                    result.append(ch);
                }
            }else{
                result.append(text.charAt(i));
            }
        }
        return result.toString();
    }

    static int anagram(String s) {
        final int mid = s.length() / 2;
        String[] parts = {s.substring(0, mid),s.substring(mid)};
        if(parts[0].length() != parts[1].length()){
            return -1;
        }
        int count = 0;
        for (char c : parts[0].toCharArray()){
            if(!parts[1].contains(c+"")){
                count ++;
            }else{
                parts[1] = parts[1].replaceFirst(c+"","");
            }
        }
        return count;
    }

    static String twoStrings(String s1, String s2) {
        for(char c : "abcdefghijklmnopqrstuvwxyz".toCharArray())
        {
            if(s1.indexOf(c) > -1 && s2.indexOf(c) > -1){
                return "YES";
            }
        }
        return "NO";

    }

    static int stringConstruction(String s) {
        StringBuilder p = new StringBuilder();
        int dollars = 0;
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            String subStr = s.substring(i);
            if(p.indexOf(subStr) != -1){
                i = i+ p.length();
            }else if(p.indexOf(c+"") == -1){
                p.append(c);
                dollars ++;
            }
        }
        return (int)s.chars().distinct().count();
    }

    static String[] bigSorting(String[] unsorted) {
        Arrays.sort(unsorted, (x, y) -> x.length() == y.length() ? x.compareTo(y) : Integer.compare(x.length(), y.length()));
        return unsorted;

    }

    static void printArray(int arr[])
    {
        int n = arr.length;
        for (int i = 0; i < n; ++i)
            System.out.print(arr[i] + " ");

        System.out.println();
    }


    static void insertionSort1(int n, int[] ar) {
        int sort = ar[n - 1];
        int i;
        for (i = n - 2; (i >= 0) && (ar[i] > sort); i--) {
            ar[i + 1] = ar[i];
            printArray(ar);
        }
        ar[i + 1] = sort;
        printArray(ar);
    }

    static void insertionSort2(int n, int[] arr) {
        for(int i =0; i< n-1; i++){
            int j = i;
            while (j >= 0){
                if(arr[j] > arr[j+1]){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
                j--;
            }

            printArray(arr);
        }


    }

    static int runningTime(int[] arr) {
        int n = arr.length;
        int runningTime = 0;
        for(int i =0; i< n-1; i++){
            int j = i;
            while (j >= 0){
                if(arr[j] > arr[j+1]){
                    runningTime ++;
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
                j--;
            }
        }
        return runningTime;
    }

    static int[] quickSort(int[] arr) {
        int pivot=arr[0];
        int n=arr.length;
        for(int i=1;i<n;i++){
            if(pivot>arr[i]){
                for(int j=i;j>0;j--){
                    int temp=arr[j];
                    arr[j]=arr[j-1];
                    arr[j-1]=temp;
                }
            }
        }
        return arr;

    }

    static void quickSort2(int[] arr) {
        int pivot=arr[0];
        int n=arr.length;
        for(int i=1;i<n;i++){
            if(pivot>arr[i]){
                for(int j=i;j>0;j--){
                    int temp=arr[j];
                    arr[j]=arr[j-1];
                    arr[j-1]=temp;
                }
                int[] left = Arrays.copyOfRange(arr, 0, i);
                int[] right = Arrays.copyOfRange(arr, i + 1, n);
                quickSort2(left);
                quickSort2(right);
            }
            printArray(arr);
        }

    }

    static int partition(int[] A, int lo, int hi){
        int pivot = A[hi];
        int i = lo;
        for(int j =lo; j< hi; j++){
            if(A[j] < pivot){
                int temp = A[j];
                A[j] = A[i];
                A[i] = temp;
                i ++;
            }
        }
        int temp = A[hi];
        A[hi] = A[i];
        A[i] = temp;
        return i;
    }

    static void quickSortInPlace(int[] A, int lo,int hi){
        if(lo < hi){
            int p = partition(A, lo, hi);
            printArray(A);
            quickSortInPlace(A, lo, p-1);
            quickSortInPlace(A, p+1, hi);
        }
    }


    public static void main(String[] args){
        //weightedUniformStrings("abccddde", new int[]{6,1,3,12,5,9,10});
        int[] A = new int[]{5, 8, 1, 3, 7, 9, 2};
        quickSortInPlace(A, 0, A.length-1);
    }

}
