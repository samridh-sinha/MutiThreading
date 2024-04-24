package recursion;

import java.util.ArrayList;
import java.util.List;

public class RecusrsionProblems {


    //print am n tme using recursion
    public void printNameNTime(String name, int n) {
        if (n == 0) {
            return;
        }

        System.out.println(name);
        printNameNTime(name, n - 1);
    }

    public void printIncreaing(int n) {
        if (n == 0)
            return;

        printIncreaing(n - 1);
        System.out.println(n);
    }

    public void printDecreasing(int n) {
        if (n == 0)
            return;
        System.out.println(n);
        printDecreasing(n - 1);
    }


    public void sumOfNNumbersParams(int i, int sum) {
        if (i < 1) {
            System.out.println(sum);
            return;
        }
        sumOfNNumbersParams(i - 1, sum + i);
    }

    public int sumOfNNumbersFunc(int i) {
        if (i < 1)
            return 0;
        return i + sumOfNNumbersFunc(i - 1);
    }

    public int factorialofN(int i) {
        if (i == 1)
            return 1;
        return i * factorialofN(i - 1);
    }

    public void reverseArray(int[] myArray, int l, int r) {

        if (l >= r)
            return;

        int temp = myArray[l];
        myArray[l] = myArray[r];
        myArray[r] = temp;

        reverseArray(myArray, l + 1, r - 1);
    }

    public boolean checkForPalindrome(String str, int low, int high) {

        if (low >= high) {
            return str.charAt(low) == str.charAt(high);
        }

        char ch1 = str.charAt(low);
        char ch2 = str.charAt(high);

        if (ch1 != ch2)
            return false;
        return checkForPalindrome(str, low + 1, high - 1);
    }

    public int fibonacci(int i) {
        if (i <= 1)
            return i;
        return fibonacci(i - 1) + fibonacci(i - 2);
    }

    public void printSubseuence(int i, int[] myArray, List<Integer> list) {
        if (i == myArray.length) {
            System.out.println(list.toString());
            return;
        }

        //Pick the number
        list.add(myArray[i]);
        printSubseuence(i + 1, myArray, list);

        //Not picking the number
        list.remove(list.size() - 1);
        printSubseuence(i + 1, myArray, list);
    }


//    public List<List<Integer>> printSubseuence2(int i, int[] myArray, List<Integer> list) {
//        if (i==myArray.length){
////            System.out.println(list.toString());
//            return new ArrayList<>();
//        }
//
//        //Pick the number
//        list.add(myArray[i]);
//        List<List<Integer>> lists = printSubseuence2(i + 1, myArray, list);
//
//        //Not picking the number
//        list.remove(list.size() - 1);
//        printSubseuence(i+1, myArray, list);
//    }

    private void printArray(int[] myArray) {
        for (int i : myArray) {
            System.out.print(i + ",");
        }
    }

    public void pintSubsequenceWithSumK(int[] myArray, int i, List<Integer> list, int sum, int k) {

        if (i >= myArray.length) {
            if (sum == k)
                System.out.println(list.toString());
            return;
        }

        //Pick a number form array and add it to the sum
        list.add(myArray[i]);
        pintSubsequenceWithSumK(myArray, i + 1, list, sum + myArray[i], k);

        //Unpick the number and check if the sum exists
        list.remove(list.size() - 1);
        pintSubsequenceWithSumK(myArray, i + 1, list, sum, k);
    }


    //Technique to print only one answer
    //If base condition is true return rue
    //Else return false;

    public boolean pintAnySubsequenceWithSumK(int[] myArray, int i, List<Integer> list, int sum, int k) {

        if (i >= myArray.length) {
            if (sum == k) {
                System.out.println(list.toString());
                return true;
            }
            return false;
        }
        //Pick a number form array and add it to the sum
        list.add(myArray[i]);
        if (pintAnySubsequenceWithSumK(myArray, i + 1, list, sum + myArray[i], k))
            return true;
        //Unpick the number and check if the sum exists
        list.remove(list.size() - 1);
        if (pintAnySubsequenceWithSumK(myArray, i + 1, list, sum, k))
            return true;
        return false;
    }

    public int countOfSubsequences(int[] myArray, int i, int sum, int k) {
        if (i >= myArray.length) {
            if (sum == k)
                return 1;
            return 0;
        }

        //Pick a number form array and add it to the sum

        int countOfLeftHalf = countOfSubsequences(myArray, i + 1, sum + myArray[i], k);

        //Unpick the number and check if the sum exists

        int countOfRightHalf = countOfSubsequences(myArray, i + 1, sum, k);

        return countOfLeftHalf + countOfRightHalf;
    }

    public void getCombinationSum(int[] arr, int sum, int start, ArrayList<Integer> list) {

//        if(start>=arr.length){
//            if (sum == 0)
//                System.out.println(list.toString());
//        }
//
//        //Picking the first number
//        list.add(arr[start]);
//        getCombinationSum(arr, sum-arr[start], start+1, list);
//


    }

    public void powerSet(String s, int start, List<String> list) {
        if (start >= s.length()) {
            System.out.println(list.toString());
            return;
        }

        list.add(String.valueOf(s.charAt(start)));
        powerSet(s, start + 1, list);

        list.remove(list.size() - 1);
        powerSet(s, start + 1, list);
    }


    public void powerSet2(String s, int index, StringBuilder current, List<String> result) {
        if (index == s.length()) {
            result.add(current.toString());
            return;
        }

        // Include the current character
        powerSet2(s, index + 1, current.append(s.charAt(index)), result);

        // Exclude the current character
        current.deleteCharAt(current.length() - 1);
        powerSet2(s, index + 1, current, result);
    }

    public void permuations(int[] arr1, int start, List<Integer> list) {

        if (start >= arr1.length) {
            System.out.println(list.toString());
            return;
        }

        for (int i = start; i < arr1.length; i++) {
            swap(arr1, i, start);
            list.add(arr1[i]);

            permuations(arr1, start+1, list);

            list.remove(list.size()-1);
            swap(arr1, arr1[i], arr1[i]);
        }
    }

    public void swap(int[] array, int index1, int index2) {
        int temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
    }

    public List<List<String>> partition(String s) {
        List<List<String>> ans = new ArrayList<>();
        List<String> list = new ArrayList<>();
        StringBuilder palin = new StringBuilder();
        partitonPalindrome(s,0, palin,list, ans);
        return ans;
    }

    public void partitonPalindrome(String s, int start,StringBuilder palin,List<String> list,
                                   List<List<String>> ans){

        if(start>=s.length()){


        }


        for(int i=0;i<s.length();i++){

        }

    }

    public Boolean palinCheck(String str){
        StringBuilder straight = new StringBuilder(str);
        StringBuilder rev = new StringBuilder(str).reverse();
        return straight.toString().equals(rev.toString());
    }
}
