public class NBody {

    public static void main(String[] args) {
        double T, dt;
        String filename;
        Planet[] planets;

        T = Double.parseDouble(args[0]);
        dt = Double.parseDouble(args[1]);
        filename = args[2];
        planets = readPlanets(filename);

        double radius = readRadius(filename);

        // draw the initial universe
        StdDraw.setScale(-radius, radius);
        drawUniverse(planets);

        // animation
        StdDraw.enableDoubleBuffering();

        int len = planets.length;
        for (double time = 0; time <= T; time += dt) {
            double[] xForces = new double[len];
            double[] yForces = new double[len];
            double xForce, yForce;

            for (int i = 0; i < len; i++) {
                xForce = planets[i].calcNetForceExertedByX(planets);
                yForce = planets[i].calcNetForceExertedByY(planets);
                xForces[i] = xForce;
                yForces[i] = yForce;
            }

            for (int i = 0; i < len; i++) {
                planets[i].update(dt, xForces[i], yForces[i]);
            }

            drawUniverse(planets);
            StdDraw.show();
            StdDraw.pause(10);
        }

        // print final state
        StdOut.printf("%d\n", planets.length);
        StdOut.printf("%.2e\n", radius);
        for (Planet p: planets) {
            StdOut.printf("%11.4e %11.4e %11.4e %11.4e %11.4e %12s\n",
                          p.xxPos, p.yyPos, p.xxVel, p.yyVel, p.mass, p.imgFileName);
        }
    }

    public static double readRadius(String filename) {
        In file = new In(filename);
        file.readInt();
        double radius = file.readDouble();
        return radius;
    }

    public static Planet[] readPlanets(String filename) {
        In file = new In(filename);
        int planetCnt = file.readInt();
        Planet[] planets = new Planet[planetCnt];

        file.readDouble(); // discard radius
        for (int i = 0; i < planetCnt; i++) {
            double xxPos, yyPos, xxVel, yyVel, mass;
            String img;
            xxPos = file.readDouble();
            yyPos = file.readDouble();
            xxVel = file.readDouble();
            yyVel = file.readDouble();
            mass = file.readDouble();
            img = file.readString();

            Planet pi = new Planet(xxPos, yyPos, xxVel, yyVel, mass, img);
            planets[i] = pi;
        }
        return planets;
    }

    private static void drawUniverse(Planet[] planets) {
        StdDraw.clear();
        StdDraw.picture(.0, .0, "./images/starfield.jpg");
        for (Planet p: planets) {
            p.draw();
        }
    }
}
