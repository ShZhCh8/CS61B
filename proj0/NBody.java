public class NBody{
    public static double readRadius(String filename){
        In file = new In(filename);
        file.readInt();
        return file.readDouble();
    }

    public static Planet[] readPlanets(String filename){
        In file = new In(filename);
        int num_planet = file.readInt();
        Planet[] planets = new Planet[num_planet];
        file.readDouble();
        for(int i = 0; i < num_planet; i += 1){
            planets[i] = new Planet(file.readDouble(), file.readDouble(), file.readDouble(), file.readDouble(), file.readDouble(), file.readString());
        }
        return planets;
    }

    public static void main(String[] args){
        
        double T = Double.parseDouble(args[0]);
        double dt = Double.parseDouble(args[1]);
        String filename = args[2];
        Planet[] planets = readPlanets(filename);
        double radius = readRadius(filename);
        StdDraw.setScale(-radius, radius);
        //StdDraw.clear();
        StdDraw.picture(0, 0, "images\\starfield.jpg");
        for(Planet p: planets){
            p.draw();
        }
        StdDraw.show();
        StdDraw.enableDoubleBuffering();
        for(double t = 0; t < T; t += dt){
            double[] fxs = new double[planets.length];
            double[] fys = new double[planets.length];
            for(int j = 0; j < planets.length; j += 1){
                fxs[j] = planets[j].calcNetForceExertedByX(planets);
                fys[j] = planets[j].calcNetForceExertedByY(planets);
            }
            for(int k = 0; k < planets.length; k += 1)
                planets[k].update(dt, fxs[k], fys[k]);
            StdDraw.picture(0, 0, "images\\starfield.jpg");
            for(Planet p: planets){
                p.draw();
            }
            StdDraw.show();
            StdDraw.pause(10);
        }
        StdOut.printf("%d\n", planets.length);
        StdOut.printf("%.2e\n", radius);
        for (int i = 0; i < planets.length; i++) {
            StdOut.printf("%11.4e %11.4e %11.4e %11.4e %11.4e %12s\n",
                        planets[i].xxPos, planets[i].yyPos, planets[i].xxVel,
                        planets[i].yyVel, planets[i].mass, planets[i].imgFileName);   
}
    }
}