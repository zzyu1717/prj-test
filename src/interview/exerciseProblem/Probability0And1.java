package interview.exerciseProblem;

public class Probability0And1 {
    public static int get0Or1() {
        double random = Math.random();
        if (random - 0.5 < Math.pow(10,-5)) {
            return 0;
        } else {
            return 1;
        }
    }
}
