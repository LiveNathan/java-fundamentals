package labs_examples.datatypes_operators.labs;

/**
 * Please demonstrate the use of all logical operators below. These include:
 *
 * AND, short-circuit AND, OR, short-circuit OR, XOR, NOT
 *
 */
class LogicalOperators {

    public static void main(String[] args) {

        // example of "OR"
        boolean a = false;
        boolean b = false;
        if (a & b){
            System.out.print("a AND b are true.");
        }

        if (a && b){
            System.out.printf("%nNo false was encountered.");
        }

        if (a | b){
            System.out.printf("%na or b is true.");
        }

        if (a || b){
            System.out.printf("%ntrue was encountered somewhere.");
        }

        if (a ^ b){
            System.out.printf("%na or b is true, but not both.");
        }

        if (a != b){
            System.out.printf("%na is not b.");
        }

        if (a == b){
            System.out.printf("%na is b.");
        }

    }

}

