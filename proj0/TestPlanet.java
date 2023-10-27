public class TestPlanet {
    public static void main(String[] args) {
        checkPlanet();
    }

    private static void checkEquals(double expected, double actual, String label, double eps) {
        if (Math.abs(expected - actual) <= eps) {
            System.out.print("PASS: ");
        } else {
            System.out.print("FAIL: ");
        }
        System.out.println(label + ": Expected " + expected + " and you gave " + actual);
    }

    private static void checkPlanet() {
        Planet one = new Planet(1.0, 1.0, 3.0, 4.0, 5.0, null);
        Planet other = new Planet(3.0, 4.0, 1.0, 1.0, 10.0, null);

        double pairwiseForce = one.calcForceExertedBy(other);
        checkEquals(3.0318e-10, pairwiseForce, "calcForceExertedBy()", 0.05);
    }
}
