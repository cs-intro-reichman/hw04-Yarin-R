public class ArrayOps {
    public static void main(String[] args) {
        System.out.println(findMissingInt(new int[] { 1 }));
        System.out.println(secondMaxValue(new int[] { 0, 5,  2, 3, 1, 3 }));
        System.out.println(secondMaxValue(new int[] { 2, 8, 3, 7, 8 }));
        System.out.println(containsTheSameElements(new int[] { 1, 2, 1, 1, 2 }, new int[] { 2, 3, 2, 1 }));
        System.out.println(containsTheSameElements(new int[] { 2, 2, 3, 7, 8, 3, 2 }, new int[] { 8, 2, 7, 7, 3 }));
        System.out.println(containsTheSameElements(new int[] { 1, 2, 3 }, new int[] { 1, 2, 3 }));
        System.out.println(containsTheSameElements(new int[] { 3, -4, 1, 2, 5 }, new int[] { 1, 3, -4, 5 }));
        System.out.println();
        System.out.println(isSorted(new int[] { 7, 5, 4, 3, -12 }));
        System.out.println(isSorted(new int[] { 1, 2, 3 }));
        System.out.println(isSorted(new int[] { 1, -2, 3 }));
        System.out.println(isSorted(new int[] { 1, 1, 500 }));
        System.out.println(isSorted(new int[] { 1, 3, 2 }));
        System.out.println(isSorted(new int[] { 500, 500, 1 }));
    }

    // findMissingInt - finds the missing int in array such that 0 <= int <=
    // array.length.
    public static int findMissingInt(int[] array) {
        int len = array.length; // array length.
        int sum = 0; // sum of arrays in array.
        for (int i = 0; i < len; i++) {
            sum += array[i]; // summing the arrays in array.
        }
        // return the sub of the sum of all numbers up to maxVal(using a formula) and
        // sum.
        return ((len * (len + 1)) / 2) - sum;
    }

    // secondMaxValue - returns the second maximum value in array.
    public static int secondMaxValue(int[] array) {
        int len = array.length; // array's length.
        int realMax = array[0]; // max value in array.
        int secondaryMax = array[0]; // second max value in array.
        for (int i = 1; i < len; i++) { // go through the array's variables.
            if (realMax < array[i]) {
                secondaryMax = realMax; // save the second max value before changing the max value.
                realMax = array[i];
            } else if (secondaryMax < array[i]) {
                // search if there are any umbers between the max value and the second max
                // value.
                secondaryMax = array[i];
            }
        }
        return secondaryMax; // return the second max value in array.
    }

    // firstContainsEveryElementInSecond - check if the second array is contained in
    // teh first array.
    public static boolean firstContainsEveryElementInSecond(int[] array1, int[] array2) {
        int len1 = array1.length; // array1's length.
        int len2 = array2.length; // array2's length.
        boolean isInArray1; // flag indicator to check if the arrays contain the same elements.
        for (int i = 0; i < len1; i++) {
            isInArray1 = false;
            for (int j = 0; j < len2; j++) {
                if (array1[i] == array2[j]) {
                    isInArray1 = true;
                }
            }
            if (!isInArray1) {
                return false;
            }
        }
        return true;
    }

    // containsTheSameElements - check if the the arrays contain the same elements.
    public static boolean containsTheSameElements(int[] array1, int[] array2) {
        return (firstContainsEveryElementInSecond(array1, array2) && firstContainsEveryElementInSecond(array2, array1));
    }

    // checks if the array is decreasing or increasing.
    public static boolean isSorted(int[] array) {
        int len = array.length; // array's length.
        boolean isIncreasing = true; // are 2 consertive numbers are increasing.
        boolean isDecreasing = true; // are 2 consertive numbers are decreasing.
        if (len > 2) { // check if checking is needed(if the length is 2 or smaller it doesn't matter).
            for (int i = 1; i < len; i++) {
                if (array[i] < array[i - 1]) {
                    isIncreasing = false;
                }
                if (array[i] > array[i - 1]) {
                    isDecreasing = false;
                }
            }
        }
        return isIncreasing || isDecreasing;
    }

}
