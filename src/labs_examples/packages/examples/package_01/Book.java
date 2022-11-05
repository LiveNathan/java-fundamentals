package labs_examples.packages.examples.package_01;

/**
* Created by ryandesmond on 3/27/17.
*/
public class Book {
    private final String title;
    private final String author;
    private final int pubDate;

    public Book(String t, String a, int d) {
        title = t;
        author = a;
        pubDate = d;
    }

    public void show() {
        System.out.println(title);
        System.out.println(author);
        System.out.println(pubDate);
        System.out.println();
    }
}

