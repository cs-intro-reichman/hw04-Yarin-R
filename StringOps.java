import java.util.Arrays;

public class StringOps {
    ////////////////////////////////////////////////////////////
    //////                                               ///////
    ////// Reminder:                                     ///////
    ////// allowed methods                               ///////
    //////                                               ///////
    ////// 1.charAt(int index)                           ///////
    ////// 2.length()                                    ///////
    ////// 3.substring(int start)                        ///////
    ////// 4.substring(int start,int ends)               ///////
    ////// 5.indexOf(String str)                         ///////
    //////                                               ///////
    ////// The rest are not allowed !                    ///////
    ////// if you want to use a different                ///////
    ////// method, and you can implement                 ///////
    ////// it using material from the course             ///////
    ////// you need to implement a version of            ///////
    ////// the function by yourself.                     ///////
    //////                                               ///////
    ////// see example for substring                     ///////
    ////// in Recitation 3 question 5                    ///////
    //////                                               ///////
    ////////////////////////////////////////////////////////////
    public static void main(String[] args) {
        System.out.println(capVowelsLowRest("Hello World"));
        System.out.println(capVowelsLowRest("One two tHRee world"));
        System.out.println(capVowelsLowRest("vowels are fun"));
        System.out.println(capVowelsLowRest("yellow"));
        System.out.println();
        System.out.println(camelCase("hello World"));
        System.out.println(camelCase("HELLO     world"));
        System.out.println(camelCase("   tWo    wordS"));
        System.out.println(camelCase("world"));
        System.out.println(camelCase("  Intro to   coMPUter    sCIEncE  "));
        System.out.println();
        System.out.println(Arrays.toString(allIndexOf("Hello world",'l')));
        System.out.println(Arrays.toString(allIndexOf("Hello worLd",'l')));
        System.out.println(Arrays.toString(allIndexOf("Hello world",'o')));
        System.out.println(Arrays.toString(allIndexOf("Hello world",' ')));
        System.out.println(Arrays.toString(allIndexOf("MMMM",'M')));
    }

    // capVowelsLowRest - returns a string in which all the English vowels
    // (a,e,i,o,u) in the original strings are changed to uppercase
    // and all the other characters are changed to lowercase.
    public static String capVowelsLowRest(String string) {
        String newString = ""; // declaring new string which will be returned as the above rules.
        for (int i = 0; i < string.length(); i++) {
            char currentChar = string.charAt(i); // character we are currently at while going through all in string.
            if (currentChar == 'a' || currentChar == 'e' || currentChar == 'i' || currentChar == 'o'
                    || currentChar == 'u') {
                newString += (char) (currentChar - 32); // convert all lowercased English vowels to uppercase.
            } else if (currentChar == 'A' || currentChar == 'E' || currentChar == 'I' || currentChar == 'O'
                    || currentChar == 'U') {
                newString += currentChar;
            } else if (currentChar >= 'A' && currentChar <= 'Z') {
                newString += (char) (currentChar + 32); // convert every english letter other then English vowels to
                                                        // lowercase.
            } else {
                newString += currentChar;
            }
        }
        return newString;
    }

    // camelCase - convvert a string to a Camel Case form.
    public static String camelCase(String string) {
        String newString = ""; // declaring new string which will be returned as the above rules.
        Boolean isAfterSpace = false; // is a character located after a ' '.
        int i = 0; // go through the string untill i is equal to the string's length.
        // skip first spaces.
        while (i < string.length() && string.charAt(i) == ' ') {
            i++;
        }
        for (; i < string.length(); i++) {
            char currentChar = string.charAt(i); // character we are currently at while going through all in string.
            if (currentChar == ' ') { // check if the next currnet char is ' '.
                isAfterSpace = true;
            } else if (isAfterSpace) {
                // if after ' ' and lower cased - convert to upper case.
                if (currentChar >= 'a' && currentChar <= 'z') {
                    newString += (char) (currentChar - 32);
                } else {
                    newString += currentChar;
                }
                isAfterSpace = false;
            } else {
                // remain lowercase while the char isnt after a ' '.
                if (currentChar >= 'A' && currentChar <= 'Z') {
                    newString += (char) (currentChar + 32);
                } else {
                    newString += currentChar;
                }
            }
        }
        return newString;
    }

    // allIndexOf - returns an array containing all the indexes in which the character appears in the string.
    public static int[] allIndexOf(String string, char chr) {
        int count = 0; // times chr is in strng.
        int[] locationOfChar; // new array with the locations of the char in the string.
        int location = 0; // used to go through the array of that contains the location of chr in string.
        for (int i = 0; i < string.length(); i++) {
            if (string.charAt(i) == chr) {
                count++;
            }
        }
        locationOfChar = new int[count]; // set the array to be count times long.
        for (int i = 0; i < string.length(); i++) {
            if (string.charAt(i) == chr) {
                locationOfChar[location] = i;
                location++;
            }
        }
        return locationOfChar;
    }
}
