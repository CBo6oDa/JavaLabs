package test;

public class Code {

    public static double EXP = 0.000000001;

    public static int integerTask(int countOfBytes) {

        assert (countOfBytes > 0);

        countOfBytes -= countOfBytes % 1024;
        int countOfKilobytes = countOfBytes / 1024;
        return countOfKilobytes;

    }

    public static boolean booleanTask(int A) {

        return A % 2 == 0;

    }

    public static int ifTask(int value) {

        if (value > 0) {
            return ++value;
        }
        if (value < 0)
            return value -= 2;

        return value = 10;

    }

    public static Month caseTask(int value) {

        assert (value >= 1 && value <= 12);

        switch (value){

            case 1 :
                return Month.January;
            case 2 :
                return Month.February;
            case 3 :
                return Month.March;
            case 4 :
                return Month.April;
            case 5 :
                return Month.March;
            case 6 :
                return Month.June;
            case 7 :
                return Month.July;
            case 8 :
                return Month.August;
            case 9 :
                return Month.September;
            case 10 :
                return Month.October;
            case 11 :
                return Month.November;
            case 12 :
                return Month.December;
            default:
                throw new RuntimeException("");
        }
    }

    public static double forTask(double X, int N) {

        assert (N > 0);

        double totalValue = 0;
        double numerator = X;
        double denominator = 1;
        int sign = 1;
        int multiplier = 1;

        for (int i = 0; i < N; ++i) {

            totalValue += sign * (numerator / denominator);
            numerator *= X * X;
            denominator *= (multiplier + 1) * (multiplier + 2);
            sign *= -1;
            multiplier += 2;

        }

        return totalValue;

    }

    public static TwoInt whileTask(int N, int K) {

        assert (N > 0 && K > 0);

        int fraction = 0;
        int remainder = 0;

        if (N < K) {

            while (N < K) {
                N *= 10;
            }
            while (N >= K) {
                remainder += 1;
                N -= K;
            }
            fraction = 0;
            return new TwoInt(fraction, remainder);
        } else {
            while (N >= K) {
                fraction += 1;
                N -= K;
            }
        }
        remainder = N;
        return new TwoInt(fraction, remainder);

    }

    public static double arrayTask(double[] array, int L, int R) {

        assert (array.length >= R && R >= L && L >= 1);

        double sum = 0;

        for (int i = 0; i < array.length; ++i) {
            if (i >= L && i <= R) {
                sum += array[i];
            }
        }
        return sum;

    }

    public static int[][] MatrixTask(int[][] array) {

        assert (array.length > 0 && array[0].length > 0);

        int min;
        int max;

        for (int i = 0; i < array.length; i++) {
            max = min = array[i][0];
            for (int j = 0; j < array[i].length; j++) {
                if (array[i][j] > max) {
                    max = array[i][j];

                } else if (array[i][j] < min) {
                    min = array[i][j];
                }
            }
            for (int j = 0; j < array[i].length; j++) {
                if (array[i][j] == max) {
                    array[i][j] = min;

                } else if (array[i][j] == min) {
                    array[i][j] = max;
                }
            }
        }

        return array;
    }

    public static boolean forCheck(double actual, double expected) {

        if (Math.abs(Math.abs(actual) - Math.abs(expected)) < EXP) {
            return true;
        }
        return false;

    }

    public static TwoDouble getResult(int a, int b) {

        assert (a > 0 && b > 0);

        TwoDouble obj = new TwoDouble();
        obj.perimeter = 2 * (a + b);
        obj.area = obj.a * obj.b;
        return obj;

    }


    public enum Month {January, February, April, March, May, June, July, August, September, October, November, December}

    public static class TwoDouble {
        double a;
        double b;
        double perimeter;
        double area;

        public TwoDouble(double a, double b) {

            this.a = a;
            this.b = b;
        }
        public TwoDouble(){};

    }

    public static boolean equals(TwoDouble ob1,TwoDouble ob2) {

        return (ob1.a == ob2.b) && (ob1.a == ob2.b);
    }

    public static boolean equals(TwoInt ob1, TwoInt ob2) {

        return (ob1.firstField == ob2.firstField) && (ob1.secondField == ob2.secondField);

    }

    public static class TwoInt {
        int firstField;
        int secondField;


        public TwoInt(int a, int b) {
            this.firstField = a;
            this.secondField = b;
        }
    }
}