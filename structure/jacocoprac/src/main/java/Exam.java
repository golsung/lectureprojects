public class Exam {
    int foo(int x, int y) {
        int z = 0;
        int w = 0;
        if (x < 7 || y > 0) z= x + y - 3;
        else z = x * (y + 5);
        if (x > 0 && y < 0) w = -1 * x + z;
        else w = y + x * z;
        return w;
    }
}
