package Lab2.oneDimensionalDistributions;

import static java.lang.Math.exp;
import static java.lang.Math.pow;

public class poissonDistribution extends oneDimensionalDistributions {
    private final double a;
    public poissonDistribution(int N, double d1)
    {   this.a=d1;
        double sum = 0;
        for (int i = 0; i <= N; i++)
        {
            x.add(i);
            Px.add((pow(a, i) * exp(-a))/(getFactorial(i)).doubleValue());
            sum += Px.get(i);
            fx.add(sum);
        }
    }
}
