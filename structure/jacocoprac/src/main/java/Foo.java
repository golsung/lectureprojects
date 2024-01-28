public class Foo {
    public int foo(int x, int y) {
        int z = 0;
        if (x>10 || y>10)
            z = x+y;
        if (z>30)
            z = 100;
        return z;
    }
}
