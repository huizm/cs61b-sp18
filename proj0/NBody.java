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
        StdDraw.clear();
        StdDraw.picture(.0, .0, "./images/starfield.jpg");

        // draw planets
        for (Planet p: planets) {
            p.draw();
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
}
