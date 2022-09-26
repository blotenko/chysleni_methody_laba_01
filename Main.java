import static java.lang.Math.abs;
public class Main {
    static double f(float x){
        double f;
        return f= (Math.pow(x,3)+3*Math.pow(x,2)+12*x+8);
    }

    public static void main(String[] args ){
        float a,b,x = 0,c, eps = 0.1f ;

        System.out.println("Найти корень уравнения на интервале [0;10] при eps=0.00001");
        System.out.println();
        System.out.println("Метод дихотомии: ");

        a = -5;
        b = 5;

        while ( abs(a-b) > eps) {
            c = (a+b)/2;
            if (f(a) * f(c)<= 0) b = c;
            else
            {
                a = c;
                x = (a+b)/2;
            }
        }

        System.out.println("x = " + x + " f(x) = " + f(x));
    }
}

 class MethodIteration {
    private static final double MIN_RANGE = -3;
    private static final double MAX_RANGE = 3;
    private static final double EPS = 0.0001;
    public static double searchX(double minRange, double maxRange, double x) {
        double a = 3 * Math.pow(minRange, 2) - 6 * minRange + 6;
        double b = 3 * Math.pow(maxRange, 2) - 6 * maxRange + 6;
        double c = 3 * Math.pow(x, 2) - 6 * x + 6;
        return a >= b && a >= c ? minRange : b >= a && b >= c ? maxRange : x;
    }

    public static double getLambda(double x) {
        return 1. / (3 * Math.pow(x, 2) - 6 * x + 6);
    }
    
    private static double function(double lambda, double x, double eps) {
        double x0;
        do {
            x0 = x;
            x = x - lambda * (Math.pow(x, 3) - 3 * Math.pow(x, 2) + 6 * x + 3);
        } while (Math.abs(x - x0) >= eps);
        return x;
    }


    public static void main(String[] args) {

        double x = 1;
        System.out.println("Дана функция:\n   y = x^3 - 3*x^2 + 6*x + 3;");
        System.out.printf("   На отрезке: [%.2f, %.2f];\n", MIN_RANGE, MAX_RANGE);

        x = searchX(MIN_RANGE, MAX_RANGE, x);
        double lambda = getLambda(x);

        double result = function(lambda, x, EPS);
        System.out.printf("\nОтвет:\n   x = %.8f;", result);
    }
}


class MethodNewTona{
    public static void main(String[] args) {
        float x = 0, e = 0.1f ;
    System.out.println(NewtonRaphson());
    }
    static double f(double x){
        double f;
        return f= (Math.pow(x,2)-2);
    }
    static double prf(double x){
        double prf;
        return prf = 2*x;
    }
    public static double x_newton_simple(double x, double e) {
        double v =  (f(x) / prf(x));

        if (Math.abs(v) < e) {
            return x - v;
        }
        return x_newton_simple((x - v), e);
    }
    public static double x_newton(double a, double e) {
        double x = a;
        double razn;
        do {
            double xn = x - f(x) / prf(x);
            razn = Math.abs(xn - x);
            x = xn;
        } while (razn > e);

        return x - f(x) / prf(x);
    }

    public static double NewtonRaphson (){
        int iterations_number=0;
        boolean cont = true;
        double x0 , x1, Error=0;
        x0 =-1.8;
        x1=0;

        while (cont){

            x1 = x0 - (f(x0)/prf(x0));
            Error = Math.abs(x1-x0);
            iterations_number++;
            if(iterations_number>100){
                cont = false;
                System.out.println("The Program did it in "+iterations_number+" Step(s)");
                System.out.println("The root is: "+ x1);
                System.out.println("The Error is: "+(Math.abs(x1-x0)/x1)*100+"%");
            }else{
                x0=x1;
            }
        }

        return x1;
    }

}