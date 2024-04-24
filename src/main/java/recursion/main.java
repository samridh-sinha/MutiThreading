package recursion;

import java.util.ArrayList;

public class main {

    public static void main(String[] args) {

        RecusrsionProblems recusrsionProblems = new RecusrsionProblems();
        recusrsionProblems.printNameNTime("Samridh", 5);

        recusrsionProblems.printIncreaing(5);
        System.out.println();
        recusrsionProblems.printDecreasing(5);

        //Paramerised recursion problems
        System.out.println("Prams");
        recusrsionProblems.sumOfNNumbersParams(5, 0);

        //Functional
        System.out.println("Func");
        int sum = recusrsionProblems.sumOfNNumbersFunc(5);
        System.out.println(sum);

        //
        int factorialofN = recusrsionProblems.factorialofN(5);
        System.out.println("factorialofN = " + factorialofN);

        int[] myArray = {1,2,1};
        recusrsionProblems.reverseArray(myArray, 0, myArray.length-1);

        for (int i: myArray){
            System.out.print(i+" ");
        }


        System.out.println();
        String str = "level000";
        boolean palindrome = recusrsionProblems.checkForPalindrome(str, 0, str.length()-1);
        System.out.println("palindrome = " + palindrome);

        System.out.println();
        int fibo = recusrsionProblems.fibonacci(6);
        System.out.println("fibo = " + fibo);


        System.out.println("Subsequence");
        recusrsionProblems.printSubseuence(0, myArray, new ArrayList<>());


        System.out.println("Subsequence with sum as k");
        int[]arr = {10,1,2,7,6,1,5};
        recusrsionProblems.pintSubsequenceWithSumK(arr, 0, new ArrayList<>(), 0, 8);


        System.out.println("any Subsequence with sum as k");
        recusrsionProblems.pintAnySubsequenceWithSumK(myArray, 0, new ArrayList<>(), 0, 2);


        System.out.println("Count of subsequences ");
        int count = recusrsionProblems.countOfSubsequences(myArray, 0,  0, 2);
        System.out.println(count);


        int[] arr1 = {2,3,6,7};
        recusrsionProblems.getCombinationSum(arr1, 7, 0, new ArrayList<>());


        System.out.println("Power set if a string ");
        recusrsionProblems.powerSet("abc", 0, new ArrayList<>());



//        recusrsionProblems.powerSet2('');

        System.out.println("All permutations of an array");
        recusrsionProblems.permuations(arr1, 0, new ArrayList<>());


    }
}
