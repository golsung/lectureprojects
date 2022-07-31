package prac;
public class LeapYear {
    public LeapValues ckLeap(int year) {
        ckInput(year);
        if ((year % 4 == 0 && year % 100 != 0) || year % 400 == 0) {
            return LeapValues.LEAP;
        } else {
            return LeapValues.NO_LEAP;
        }
    }

    private void ckInput(int year) {
        if (year < 1 || year > 9999) throw new InvalidRangeException();
    }
}
