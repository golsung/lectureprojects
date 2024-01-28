public class PassOrNotWithFault {
    // score1: A 과목 점수 score2: B 과목 점수
    public String ckScore(int score1, int score2) {
        if (score1<0 ) throw new InvalidRangeException();
        if (score1>100) throw new InvalidRangeException();
        if (score1<50 || score2<50) return "과락";
        if (score1+score2>=120) return "통과";
        return "실패";
    }

}
