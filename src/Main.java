import java.util.*;

public class Main {

    public static int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                int[] result = new int[]{map.get(complement), nums[i]};
                return result;
                //return new int[]{map.get(complement), i};
            } else {
                map.put(nums[i], nums[i]);
            }
        }
        return new int[]{};
    }

    public static boolean isPalindrome(int x) {

        char[] digits = String.valueOf(x).toCharArray();
        // i is the index
        for (int i = 0; i < digits.length / 2; i++) {
            if (digits[i] != digits[digits.length - 1 - i]) {
//                    if(digits.length % 2 != 0 && i == digits.length/2){
//                        continue;
//                    }
                return false;
            }
        }
        System.out.println("It is palindrome.");
        return true;
    }

    public static int romanToInt(String s) {
        //define the dictionary
        HashMap<Character, Integer> dictionary = new HashMap<Character, Integer>();

        dictionary.put('I', 1);
        dictionary.put('V', 5);
        dictionary.put('X', 10);
        dictionary.put('L', 50);
        dictionary.put('C', 100);
        dictionary.put('D', 500);
        dictionary.put('M', 1000);

        int result = 0;
        //string into char array -> evaluate each char(roman numbers)
        char[] romanChar = s.toCharArray();

        if (1 <= s.length() && s.length() <= 15) {
            for (int i = 0; i < romanChar.length; i++) {

                // LIX -> when finds a char num which is I, checks the next char if it is V or X
                char nextRomanNum;
                int edgeCaseNum = 0;
                int last_idx = romanChar.length - 1;

                //An edgecase happens only if 'I' isn't a last num
                if(i != last_idx) {
                    if (romanChar[i] == 'I') {
                        nextRomanNum = romanChar[i + 1];
                        if (nextRomanNum == 'V') {
                            edgeCaseNum = 4;
                        }
                        if (nextRomanNum == 'X') {
                            edgeCaseNum = 9;
                        }
                    }
                    if (romanChar[i] == 'X') {
                        nextRomanNum = romanChar[i + 1];
                        if (nextRomanNum == 'L') {
                            edgeCaseNum = 40;
                        }
                        if (nextRomanNum == 'C') {
                            edgeCaseNum = 90;
                        }
                    }
                    if (romanChar[i] == 'C') {
                        nextRomanNum = romanChar[i + 1];
                        if (nextRomanNum == 'D') {
                            edgeCaseNum = 400;
                        }
                        if (nextRomanNum == 'M') {
                            edgeCaseNum = 900;
                        }
                    }
                }
                //add arab num equivalent to roman num to the result
                if (edgeCaseNum != 0) {
                    //and skip the next iteration
                    i++;
                    result += edgeCaseNum;

                }else{
                    int arab_num = dictionary.get(romanChar[i]);
                    result += arab_num;

                }
            }
        }
        return result;
    }

    public static String longestCommonPrefix(String[] strs) {

        String firstStr = strs[0];
        //check if the string we have selected as our comparison point is empty
        if (firstStr.length() == 0) {
            return "";
        }
        boolean shouldContinue = true;
        int index = 0;
        while (shouldContinue) {
            for (String str : strs) {
                //check if the str we are comparing to is empty
                if(str.length() == 0){
                    return "";
                }
                if (firstStr.charAt(0) != str.charAt(0)) {
                    return "";
                } else {
                    //checking if we have reached the end of the shortest string in strs
                    if(firstStr.length() < index+1 || str.length() < index+1){
                        return firstStr.substring(0, index);
                    }
                    if (firstStr.charAt(index) != str.charAt(index)) {
                        return firstStr.substring(0, index);
                    }
                }
            }
            index++;
        }
        return firstStr.substring(0, index);
    }

//    public boolean isValid(String s) {
//        char[] validString = s.toCharArray();
//        String firstStrPair = strBrackets[0];
//        boolean shouldContinue = true;
//        while(shouldContinue){
//            for(String strBracket : strBrackets){
//
//            }
//        }
//    }

    public static String getSmallestAndLargest(String s, int k) {
        String smallest = "";
        String largest = "";

        for(int i = 0; i < s.length(); i++){
            //if k=3 and the lenght of the string is 7(welcome) i=7, then k+i=10
            //10 is more than 7, so we need to exist
            if(k+i > s.length()){
                break;
            }
            String result = s.substring(i,k+i);
            Integer smallLexiInt = result.compareTo(smallest);
            Integer largeLexiInt = result.compareTo(largest);

            if(smallLexiInt < 0 || smallest == ""){
                smallest = result;
            }
            if(largeLexiInt > 0 || largest == ""){
                largest = result;
            }
        }
        // Complete the function
        // 'smallest' must be the lexicographically smallest substring of length 'k'
        // 'largest' must be the lexicographically largest substring of length 'k'

        return smallest + "\n" + largest;
    }

    public static boolean isAnagram(String a, String b) {

        HashMap<Character, Integer> hashMapA = new HashMap<Character, Integer>();
        HashMap<Character, Integer> hashMapB = new HashMap<Character, Integer>();
        char[] firstAnagrams = a.toCharArray();
        char[] secondAnagrams = b.toCharArray();

        //checking each char from the char array
        for(char firstAnagram:firstAnagrams){
                //if key do not exists, put 1 as value
                //otherwise sum 1 to the value linked to key
                 
        }

        for(char secondAnagram:secondAnagrams){
                hashMapB.merge(secondAnagram, 1, Integer::sum);
            }

       if(hashMapA.keySet() != (hashMapB.keySet()) ){
           return false;
       }

       for(Character keyA : hashMapA.keySet() ){
           if (!hashMapA.get(keyA).equals(hashMapB.get(keyA))) {
               return false;
           }
        }
        return true;
    }

    public static int simpleArraySum(List<Integer> ar) {

        boolean array = ar.isEmpty();
        int sum = 0;

        if(array == true){
            System.out.println("The array is empty");
        }
        else{
            for (int i = 0; i < ar.size(); i ++){
                ar.add(i);
                sum =+i;
            }
        }
        return sum;
    }

    public static List<Integer> gradingStudents(List<Integer> grades) {
        // Write your code here

        List<Integer> roundedGrades = new ArrayList<Integer>();


        for(Integer grade : grades){
            int nextDivisibleByFive=0;
            if(grade < 38){
                roundedGrades.add(grade);
            }
            //difference between the grade and the next multiple of 5 is 1
            if(grade > 38 && grade < nextDivisibleByFive && nextDivisibleByFive % 5 == 0){
                int gradesDifference1 = 1;
                gradesDifference1 = nextDivisibleByFive - grade;
                grade = nextDivisibleByFive;
                roundedGrades.add(grade);
            }
            //difference between the grade and the next multiple of 5 is 2
            if(grade > 38 && grade < nextDivisibleByFive && nextDivisibleByFive % 5 == 0){
                int gradesDifference2 = 2;
                gradesDifference2 = nextDivisibleByFive - grade;
                grade = nextDivisibleByFive;
                roundedGrades.add(grade);
            }
            //any other number more that 38
            else{
                roundedGrades.add(grade);
            }
        }
        return roundedGrades;
    }

    public static int pageCount(int n, int p) {
        // Write your code here
        //if n is odd -> 1st page is alone
        //if n is even -> 1st and last page are alone
        //if n-p > p then start from the end, otherwise from the start
        //if n-p = p then it does not matter
        //if n is even -> p-1(start or end) -> (p-1)/2 +1 is the number of flips
        //if n is odd -> p-1(start) -> (p-1)/2 +1 is the number of flips
        //when we need to go to page 1 or last page
        int differenceBetweenNandP = n - p;
        int pagesNeedToBeTurned = 0;

        if(n%2 == 0){
            //start from the beginning
            if(differenceBetweenNandP > p){
                pagesNeedToBeTurned = (p-1)/2 + 1;
            }
            //does not matter where you start from
            if(differenceBetweenNandP == p){
                pagesNeedToBeTurned = (p-1)/2 + 1;
            }
            //start from the end
            if(differenceBetweenNandP < p){
                pagesNeedToBeTurned = (differenceBetweenNandP -1)/2 +1;
            }
            //wanted page is the last one
            if(n == p){
                pagesNeedToBeTurned = 0;
            }
            //wanted page is the first one
            if(p == 1){
                pagesNeedToBeTurned = 0;
            }
            //wanted page is either 2nd or 3rd
            if(p == 2 || p == 3){
                pagesNeedToBeTurned = p/2;
            }
        }
        //n is odd
        else{
            //start from the beginning
            if(differenceBetweenNandP > p){
                pagesNeedToBeTurned = (p-1)/2 +1;
            }
            //start from the end
            if(differenceBetweenNandP < p){
                //13-7=6  13,12 11,10 9,8 7
                pagesNeedToBeTurned = (differenceBetweenNandP)/2;
            }
            //wanted page is the first one
            if(p == 1){
                pagesNeedToBeTurned = 0;
            }
            //wanted page is either 2nd or 3rd
            if(p == 2 || p == 3){
                pagesNeedToBeTurned = p/2;
            }
        }
        return pagesNeedToBeTurned;
    }

    static int getMoneySpent(int[] keyboards, int[] drives, int b) {
        /*
         * Write your code here.
         */
        List<Integer> sumCombinations = new ArrayList<Integer>();

        for(int i = 0; i < keyboards.length; i++){
            for(int j = 0; j < drives.length; j++){
                int curr_SumCombination = keyboards[i] + drives[j];
                sumCombinations.add(curr_SumCombination);
            }
        }

        int curr_highestPrice = -1;
        for(int s = 0; s < sumCombinations.size(); s++){
           int  curr_total_price = sumCombinations.get(s);
            if(curr_total_price <= b){
                if(curr_highestPrice < curr_total_price){
                    curr_highestPrice = curr_total_price;
                }
            }
        }
        return curr_highestPrice;
    }
    static String catAndMouse(int x, int y, int z) {
        String winner = new String();
        int difference1 = Math.abs(x-z);
        int difference2 = Math.abs(y-z);

        if(difference1 < difference2){
            winner = "Cat A";
        }
        if(difference1 > difference2){
            winner = "Cat B";
        }
        else{
            winner = "Mouse C";
        }
        return winner;
    }

    public static void main(String[] args) {
//        int[] keyboards = {40,50,60};
//        int[] drives = {5,8,12};
//        int b = 60;
//        getMoneySpent(keyboards,drives,b);
        int x = 1;
        int y = 3;
        int z = 2;
        catAndMouse(1,3,2);

        //int result = pageCount(15603,6957);
        //System.out.println(result);
        //int[] testNums = {2,7,11,15};
        //int [] result = twoSum(testNums, 9);
        //System.out.println(result[0]);
        //System.out.println(result[1]);

        //instance of tha main class
        //boolean result = isPalindrome(24342);
        //System.out.println(result);

        //System.out.println(romanToInt("CMI"));
//        String[] input = new String[]{"flower","flow","flight"};
//        System.out.println(longestCommonPrefix(input));


//        Scanner scan = new Scanner(System.in);
//        String s = scan.next();
//        int k = scan.nextInt();
//        scan.close();
//        System.out.println(getSmallestAndLargest(s, k));
          //isAnagram("anagram", "margana");
          //System.out.println(isAnagram("anagram", "margana"));
            //List<Integer> grades = new ArrayList<>(Arrays.asList(73,67,40,33));
            //gradingStudents(grades);
    }

}
