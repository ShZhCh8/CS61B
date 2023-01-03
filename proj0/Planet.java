import java.lang.Math;

public class Planet{
    public double xxPos;
    public double yyPos;
    public double xxVel;
    public double yyVel;
    public double mass;
    public String imgFileName;
    private static final double G = 6.67e-11;
    public Planet(double xP, double yP, double xV, double yV, double m, String img){
        xxPos = xP;
        yyPos = yP;
        xxVel = xV;
        yyVel = yV;
        mass = m;
        imgFileName = img;
    }

    public Planet(Planet p){
    this.xxPos = p.xxPos;
    this.yyPos = p.yyPos;
    this.xxVel = p.xxVel;
    this.yyVel = p.yyVel;
    this.mass = p.mass;
    this.imgFileName = p.imgFileName;
    }

    public double calcDistance(Planet p){
        double x_dis = this.xxPos - p.xxPos;
        double y_dis = this.yyPos - p.yyPos;
        return Math.sqrt(x_dis * x_dis + y_dis * y_dis);
    }

    public double calcForceExertedBy(Planet p){
        double r = this.calcDistance(p);
        return this.mass * p.mass * G / (r * r);
    }

    public double calcForceExertedByX(Planet p){
        double dx = p.xxPos - this.xxPos;
        double r = this.calcDistance(p);
        double f = this.calcForceExertedBy(p);
        return f * dx / r;
    }

    public double calcForceExertedByY(Planet p){
        double dy = p.yyPos - this.yyPos;
        double r = this.calcDistance(p);
        double f = this.calcForceExertedBy(p);
        return f * dy / r;
    }

    public double calcNetForceExertedByX(Planet[] ps){
        double force = 0;
        for(Planet p: ps){
            if(! this.equals(p))
                force += this.calcForceExertedByX(p);
        }
        return force;
    }

    public double calcNetForceExertedByY(Planet[] ps){
        double force = 0;
        for(Planet p: ps){
            if(! this.equals(p))
                force += this.calcForceExertedByY(p);
        }
        return force;
    }

    public void update(double t, double fx, double fy){
        double ax = fx / this.mass;
        double ay = fy / this.mass;
        this.xxVel = this.xxVel + t * ax;
        this.yyVel = this.yyVel + t * ay;
        this.xxPos = this.xxPos + t * xxVel;
        this.yyPos = this.yyPos + t * yyVel;
    }

    public void draw(){
        StdDraw.picture(xxPos, yyPos, "images/" + imgFileName);
    }
}
