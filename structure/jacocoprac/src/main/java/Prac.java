
public class Prac {
    int foo(int c1, int c2, C3Score c3) {
        boolean a1, a2;
        int points = 0;

        a1 = (c1 > 50) || (c2 > 50);
        a2 = a1 &&  (c3== C3Score.PASS);
        if (a2) {
            points = (c1 + c2) / 2;
        }

        return points;
    }
}