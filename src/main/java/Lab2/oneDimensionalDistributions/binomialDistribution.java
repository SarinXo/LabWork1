package Lab2.oneDimensionalDistributions;

import java.math.BigDecimal;

public class binomialDistribution extends oneDimensionalDistributions {
    private final int N;
    private final double p;
    public binomialDistribution(int d1, double d2){
        this.N=d1;
        this.p=d2;
        double sum = 0;
        BigDecimal bigDecimal;
        for (int i = 0; i <=N; i++)
        {
            x.add(i);
            bigDecimal=getFactorial(N).multiply(BigDecimal.valueOf(Math.pow(p, i)*Math.pow(1 - p, N - i)));
            bigDecimal= bigDecimal.divide(getFactorial(i).multiply(getFactorial(N - i)));
           // Px.add(( getFactorial(N) / (getFactorial(i) * getFactorial(N - i))) * Math.pow(p, i) * Math.pow(1 - p, N - i));
            Px.add(bigDecimal.doubleValue());
            sum += Px.get(i);
            fx.add(sum);
        }
    }
}