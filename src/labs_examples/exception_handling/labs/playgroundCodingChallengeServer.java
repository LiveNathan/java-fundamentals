package labs_examples.exception_handling.labs;

public class playgroundCodingChallengeServer {
}

class Server {

    public void download(String url) {
        //Surround with try catch
//        try {
//            Connection.getResource(url);
//        } catch (HTTPException httpExceptions) {
//            System.out.println(httpExceptions.toString());
//        }

    }
}

class HTTPException extends Exception {
    //Customize this exception as indicated in the instructions.
    @Override
    public String toString() {
        return "404 - Not Found";
    }

}