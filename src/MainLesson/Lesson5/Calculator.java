package MainLesson.Lesson5;

public class Calculator {


    int getMax(int a, int b, int c) {
        int max = a;
        if (b > max) {
            max = b;
        }
        if (c > max) {
            max = c;
        }
        return max;
    }

    int getMin(int a, int b, int c) {
        int min = a;
        if (b < min) {
            min = b;
        }
        if (c < min) {
            min = c;
        }
        return min;
    }

    int getSum(int a, int b) {
        int multiple = a + b;
        return multiple;
    }

    int getMean(int a, int b, int c) {
        int mean = (a + b + c) / 3;
        return mean;
    }


    int getMultiple(int a, int b) {
        int multiple = a * b;
        return multiple;
    }

    int getMaxAndMeanMultiple(int a, int b, int c) {
        int max = getMax(a, b, c);
        int mean = getMean(a, b, c);
        return getSum(max, mean);
    }

    int getFactorial(int n) {
        if (n == 1 || n == 0) {
            return 1;
        }
        return getFactorial(n - 1) * n;
    }


}
