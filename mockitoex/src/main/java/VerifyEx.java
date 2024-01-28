class VerifyEx {
    private Doc doc;

//    public void setDoc(IDoc doc) {
//        this.doc = doc;
//    }

    public void doIt(String str) {
        if (str == "Hello") {
            doc.say("Hello World1!");
            doc.say("Hello World1!");
        } else doc.say("Good Bye!");
    }
}
