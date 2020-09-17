package com.scala.practice;

import java.util.ArrayList;
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

    public static void main(String[] args){
        //weightedUniformStrings("abccddde", new int[]{6,1,3,12,5,9,10});
        System.out.println(funnyString("bcxz"));
    }

}
