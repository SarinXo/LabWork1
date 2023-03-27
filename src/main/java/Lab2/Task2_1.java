package Lab2;

import Lab2.continuousDistributions.*;
import Lab2.oneDimensionalDistributions.binomialDistribution;
import Lab2.oneDimensionalDistributions.poissonDistribution;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Task2_1 {
    private String menu() {
        return System.lineSeparator() + "  Выберите распределение: " +
                System.lineSeparator() + " 1. Биномиальное распределение" +
                System.lineSeparator() + " 2. Распределение Пуассона" +
                System.lineSeparator() + " 3. Равномерное распределение на отрезке R(a,b)" +
                System.lineSeparator() + " 4. Экспоненциальное распределение Ex(a)" +
                System.lineSeparator() + " 5. Нормальное распределение N(a,o)" +
                System.lineSeparator() + " 6. Распределение Х^2" +
                System.lineSeparator() + " 7. Распределение Стьюдента" +
                System.lineSeparator() + " 8. Распределение Фишера" +
                System.lineSeparator() + " 0. Выйти" + System.lineSeparator();
    }

    public double for1(Scanner in, String s1, String s2) {
        double N = in.nextDouble();
        while (N <= 0) {
            System.out.print(s1 + s2);
            N = in.nextDouble();
        }
        return N;
    }

    public void Task2() throws InputMismatchException {
        Scanner in = new Scanner(System.in);
        Scanner in2 = new Scanner(System.in);
        while (true) {
            try {
                System.out.print(menu());
                int choice = in.nextInt();
                String uncorrected = " Введены некорректные данные.";
                switch (choice) {
                    case (1) -> {

                        String ifN = " Введите число N (N > 0): ";
                        String ifP = " Введите значение вероятности р (0 <= p <= 1): ";
                        System.out.print(ifN);
                        double N = for1(in2, uncorrected, ifN);
                        System.out.print(ifP);
                        double p = in2.nextDouble();
                        while (p > 1 || p < 0) {
                            System.out.print(uncorrected + ifP);
                            p = in2.nextDouble();
                        }
                        binomialDistribution bd = new binomialDistribution((int) N, p);
                        bd.print("Биномиальное распределение");
                    }
                    case (2) -> {
                        String ifk = " Введите параметр k (k > 0): ";
                        String ifa = " Введите параметр а (a > 0): ";
                        System.out.print(ifk);
                        double N = for1(in2, uncorrected, ifk);
                        System.out.print(ifa);
                        double p = in2.nextDouble();
                        while (p <= 0) {
                            System.out.print(uncorrected + ifa);
                            p = in2.nextDouble();
                        }
                        poissonDistribution pd = new poissonDistribution((int) N, p);
                        pd.print("Распределение Пуассона");
                    }
                    case (3), (4), (5), (6) ,(7),(8)-> {
                        String ifa = " Введите нижнюю границу отрезка: ";
                        System.out.print(ifa);
                        double a = in2.nextDouble();
                        String ifb = " Введите верхнюю  границу отрезка: ";
                        System.out.print(ifb);
                        double b = in2.nextDouble();
                        while (b < a) {
                            System.out.print(uncorrected + " Верхняя граница должна быть больше нижней границы." + ifb);
                            b = in2.nextDouble();
                        }
                        String ifh = " Введите шаг: ";
                        System.out.print(ifh);
                        double h = in2.nextDouble();
                        if (choice == 3) {
                            uniformDistribution ud = new uniformDistribution(a, b, h);
                            ud.print("Равномерное распределение на отрезке R(a,b)");
                        }
                        if (choice==4|| choice==5) {
                            ifa = " Введите параметр а: ";
                            System.out.println(ifa);
                            double A = for1(in2, uncorrected, ifa);
                            if (choice == 4) {
                                exponentialDistribution ed = new exponentialDistribution(a, b, h, A);
                                ed.print("Экспоненциальное распределениее Ex(a) (a > 0)");
                            }
                            if (choice == 5) {
                                ifb = " Введите параметр o: ";
                                System.out.println(ifb);
                                double o = for1(in2, uncorrected, ifb);
                                normalDistribution nd = new normalDistribution(a, b, h, A, o);
                                nd.print("Нормальное распределение N(a,o)");
                            }
                        }
                        if (choice==6||choice==7) {
                            ifb = " Введите число степеней свободы k: ";
                            System.out.print(ifb);
                            double k = for1(in2, uncorrected, ifb);
                            if (choice == 6) {
                                chiDistribution x = new chiDistribution(a, b, h, k);
                                x.print("Распределение X^2");
                            }
                            if (choice == 7) {
                                studentDistribution st = new studentDistribution(a, b, h, k);
                                st.print("Распределение Стьюдента");
                            }
                        }
                        if(choice==8){
                            ifb = " Введите число степеней свободы k1: ";
                            System.out.print(ifb);
                            double k1 = for1(in2, uncorrected, ifb);
                            ifb = " Введите число степеней свободы k2: ";
                            System.out.print(ifb);
                            double k2 = for1(in2, uncorrected, ifb);
                               fisherDistributions st=new fisherDistributions(a,b,h,k1,k2);
                               st.print("Распределение Фишера");
                           }
                        }
                    case (0) -> {
                        in.close();
                        in2.close();
                        System.exit(0);
                    }
                    default ->
                            System.out.println(System.lineSeparator() + "Это недопустимый вариант меню! Пожалуйста, выберите другой");
                }
            } catch (InputMismatchException ex) {
                System.out.println(System.lineSeparator() + "Неверный ввод, пожалуйста, укажите целое число от 0 до 8");
            }
        }
    }
}

