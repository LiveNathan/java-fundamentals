package labs_examples.conditions_loops.labs;

public class switchStatement {
//    class Main {
        public static void main(String[] args) {
            // please demonstrate the use of a switch statement below - have a "System.out.println()" statement print for each "case" - be sure to include "break" statements in each case
            String membershipLevel = "gold";

            switch (membershipLevel){
                case "silver":
                    System.out.printf("Your membership level is %s.", membershipLevel);
//                    break;
                case "gold":
                    System.out.printf("Your membership level is %s.", membershipLevel);
//                    break;
                case "platinum":
                    System.out.printf("Your membership level is %s and platinum.", membershipLevel);
//                    break;
            }
            // once you've got that done - run the switch statement with and without the break statements for each case - what happens when we don't have break statements?
        }
//    }
}
