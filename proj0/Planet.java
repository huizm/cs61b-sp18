public class Planet {
    
    public double xxPos;
    public double xxVel;
    public double yyPos;
    public double yyVel;
    public double mass;
    public String imgFileName;

    private static final double gravitational = 6.67e-11;

    public Planet(double xP, double yP, double xV, double yV, double m, String img) {
        this.xxPos = xP;
        this.yyPos = yP;
        this.xxVel = xV;
        this.yyVel = yV;
        this.mass = m;
        this.imgFileName = img;
    }

    public Planet(Planet p) {
        this.xxPos = p.xxPos;
        this.xxVel = p.xxVel;
        this.yyPos = p.yyPos;
        this.yyVel = p.yyVel;
        this.mass = p.mass;
        this.imgFileName = p.imgFileName;
    }

    public double calcDistance(Planet p) {
        double dx = p.xxPos - this.xxPos;
        double dy = p.yyPos - this.yyPos;
        double rSquared = Math.pow(dx * dx + dy * dy, 0.5);
        return rSquared;
    }

    public double calcForceExertedBy(Planet p) {
        double distance = calcDistance(p);
        double force = gravitational * this.mass * p.mass / (distance * distance);
        return force;
    }

    public double calcForceExertedByX(Planet p) {
        double dxSigned = p.xxPos - this.xxPos;
        double force = calcForceExertedBy(p);
        double forceX = force * dxSigned / calcDistance(p);
        return forceX;
    }

    public double calcForceExertedByY(Planet p) {
        double dySigned = p.yyPos - this.yyPos;
        double force = calcForceExertedBy(p);
        double forceY = force * dySigned / calcDistance(p);
        return forceY;
    }

    public double calcNetForceExertedByX(Planet[] ps) {
        double netForceX = .0;
        for (Planet p: ps) {
            if (!this.equals(p)) {
                netForceX += calcForceExertedByX(p);
            }
        }
        return netForceX;
    }

    public double calcNetForceExertedByY(Planet[] ps) {
        double netForceY = .0;
        for (Planet p: ps) {
            if (!this.equals(p)) {
                netForceY += calcForceExertedByY(p);
            }
        }
        return netForceY;
    }

    public void update(double time, double xForce, double yForce) {
        // calculate acceleration
        double ax = xForce / this.mass;
        double ay = yForce / this.mass;

        // calculate new velocity
        double vx = this.xxVel + time * ax;
        double vy = this.yyVel + time * ay;

        // calculate new position
        double px = this.xxPos + time * vx;
        double py = this.yyPos + time * vy;

        // update `this`
        this.xxVel = vx;
        this.yyVel = vy;
        this.xxPos = px;
        this.yyPos = py;
    }

    public void draw() {
        StdDraw.picture(xxPos, yyPos, "./images/" + imgFileName);
    }
}
