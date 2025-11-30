package com.malachi.DSA.maths;

public class NewtonRaphson {
    public static void main(String[] args) {
     int n = 20;
     double result = sqrt(n);
        System.out.println("square root of " + n + " is: " + result);
    }

    /*
    STEPS:
    1. Assign the value of n to x.
    2. Choose your error_boundary. Where,
        error =  | root - x |
        you can return the "root" when [error < error_boundary](which can be 1 or 0.001 or 0.0001) is satisfied.
    3. Assign the calculated root to the value of x until the error_boundary check is satisfied. Then return the root.
     */
    public static double sqrt(int n){
        if(n <= 0) return 0.0;
        //x is the closet root(the assumed root of n) of n. So we start with n as the closet root of n. i.e x = n at the start.
        double x = n;
        double root;
        while(true){
            root = 0.5 * (x + (n/x)); //Newton-Raphson method for finding the square root of a number.
            double precision = 0.000000000000001;
            if(Math.abs(root - x) < precision){
                break;
            }
            x = root;
        }
        return root;
    }
}
