package labs_examples.inheritance.labs;

public class accessModifiers {
    public static void main(String[] args) {
        AccessMod obj = new AccessMod();

        // try to set each instance var on the "obj" object
        // hint - only two will work
        obj.publicVar.length();
        obj.protectedVar.length();
    }
}

class AccessMod {

    public String publicVar;
    protected String protectedVar;
    private String privateVar;

}