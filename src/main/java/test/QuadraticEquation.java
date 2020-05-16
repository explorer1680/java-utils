package test;

public class QuadraticEquation {
    public static Roots findRoots(double a, double b, double c) {
        
    		double temp = Math.sqrt(b*b- 4*a*c);
    		
    		return new Roots((temp-b)/(2*a),(-temp-b)/(2*a) );
    		
    }
    
    public static void main(String[] args) {
        Roots roots = QuadraticEquation.findRoots(2, 10, 8);
        System.out.println("Roots: " + roots.x1 + ", " + roots.x2);
    }
}

class Roots {
    public final double x1, x2;

    public Roots(double x1, double x2) {         
        this.x1 = x1;
        this.x2 = x2;
    }
}