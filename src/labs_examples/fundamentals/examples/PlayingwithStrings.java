package labs_examples.fundamentals.examples;

class Main {
    public static void main(String[] args) {
        String str1 = "Hello String 1!";
        String str2 = "Hello String 2!";

        // concatenating Strings
        System.out.println("The length of the String is " + str1.length());

        // utilizing the String class method equalsIgnoreCase() (these will make more sense soon)
        boolean equalStrings = str1.equalsIgnoreCase(str2);
        System.out.println("Do str1 & str2 match? " + equalStrings);

        // utilizing the String class method subString()
        String subStr = str1.substring(8, 12);
        System.out.println("The substring is: " + subStr);

        // utilizing the String class method charAt()
        char letterAt = str2.charAt(8);
        System.out.println("The letter at the 8th index of str2 is " + letterAt);

        // utilizing the String class method toUpperCase()
        System.out.println("All uppercase: " + str1.toUpperCase());
        // utilizing the String class method to LowerCase()
        System.out.println("All lowercase: " + str1.toLowerCase());

    }
}