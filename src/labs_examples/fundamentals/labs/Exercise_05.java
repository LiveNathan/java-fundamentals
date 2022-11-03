package labs_examples.fundamentals.labs;


/**
 * Fundamentals Exercise 5: Working with Strings
 * <p>
 * Please follow the instructions in the comments below
 */

public class Exercise_05 {

    public static void main(String[] args) {

        String str = "hello!";
        // please declare an int variable below, and set it to the value of the length of "str"
        int stringLength = str.length();
        System.out.printf("The length of string is " + stringLength);

        String str2 = "hello";
        // please initialize a boolean variable and test whether str is equal to str2
        boolean areStringsEqualLength = str.equals(str2);
        System.out.printf("%nString and String2 are equal: " + areStringsEqualLength);

        // please concatenate str & str2 and set the result to a new String variable below
        String str3 = str + str2;
        System.out.printf("%nString + String2 = " + str3);

        // please demonstrate the use of any other method that is available to us in the String class
        // for example, replace(), substring(), contains(), indexOf() etc
        String strl21 = str.replace('l', '1');
        System.out.printf("%n" + str + " with the l's changed to numbers is " + strl21);

        String strPartial = str3.substring(0, 4);
        System.out.printf("%nIn every hello there is a " + strPartial);

        int indexOfFirstO = str2.indexOf('o');
        System.out.printf("%nThe index of the first o in Strin3 is " + indexOfFirstO);


    }


}