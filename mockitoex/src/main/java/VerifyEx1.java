class VerifyEx1 {
    private Doc1 doc;
    public void foo(String msg, int n) {
        for (int i = 1; i <= n; i++) {
            StringBuffer buf = new StringBuffer();
            buf.append(msg + i);

            doc.send(buf.toString());
        }
    }
}
