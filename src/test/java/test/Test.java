package test;

import org.testng.annotations.DataProvider;

import java.util.Arrays;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;
import static test.Code.*;


public class Test {

    private Code object = new Code();

    /////////////////////////////////////////
    @org.testng.annotations.Test(dataProvider = "twoDoubleProvider")
    public void twoDoubleTest(Code.TwoDouble obj, Code.TwoDouble expected) {

        assertTrue(object.equals(obj,expected));

    }

    @DataProvider
    public Object[][] twoDoubleProvider() {
        return new Object[][]{{new Code().getResult(3, 4), new Code().getResult(14, 12)}, {new Code().getResult(2,3), new Code().getResult(10,6)}};
    }

    /////////////////////////////////////////

    @org.testng.annotations.Test(dataProvider = "intProvider")
    public void integerTest(int countOfBytes, int expected) {
        assertEquals(integerTask(countOfBytes), expected);
    }

    @DataProvider
    public Object[][] intProvider() {
        return new Object[][]{{2047, 1}, {2048, 2}};
    }

    @org.testng.annotations.Test(expectedExceptions = AssertionError.class)
    public void integerNegativeTest() {
        integerTask(0);
    }

    /////////////////////////////////////////

    @org.testng.annotations.Test(dataProvider = "booleanProvider")
    public void booleanTest(int A,boolean expected) {

        assertEquals(booleanTask(A), expected);

    }

    @DataProvider
    public Object[][] booleanProvider() {

        return new Object[][]{{8, true}, {5, false}};

    }

    /////////////////////////////////////////

    @org.testng.annotations.Test(dataProvider = "ifProvider")
    public void ifTest(int number,int expected) {

        assertEquals(ifTask(number), expected);

    }

    @DataProvider
    public Object[][] ifProvider() {

        return new Object[][]{{5, 6}, {-12, -14}, {0, 10}, {23, 24}, {0, 10}, {1, 2}};
    }

    /////////////////////////////////////////

    @org.testng.annotations.Test(dataProvider = "switchProvider")
    public void switchTest(int number, Code.Month expected) {

        assertEquals(caseTask(number), expected);
    }
    @DataProvider
    public Object[][] switchProvider() {

        return new Object[][]{{10, Month.October}, {9, Month.September}};

    }
    @org.testng.annotations.Test(expectedExceptions = AssertionError.class)
    public void caseNegativeTest() {
        caseTask(-1);
    }

    /////////////////////////////////////////

    @org.testng.annotations.Test(dataProvider = "forProvider")
    public void forTest(double X, int N, double expected) {

        assertTrue(forCheck(forTask(X, N), expected));

    }

    @DataProvider
    public Object[][] forProvider() {

        return new Object[][]{{5, 50, -0.95892427466}, {8, 50, 0.98935824662}};

    }

    @org.testng.annotations.Test(expectedExceptions = AssertionError.class)
    public void forNegativeTest() {
        forTask(2, 0);
    }

    /////////////////////////////////////////

    @org.testng.annotations.Test(dataProvider = "negativeWhileProvider", expectedExceptions = AssertionError.class)
    public void whileTest(int N, int K, Code.TwoInt expected) {
        assertTrue(object.equals(whileTask(N, K), expected));
    }

    @DataProvider
    public Object[][] negativeWhileProvider() {
        return new Object[][]{{0, 0, new Code.TwoInt(0, 0)},{0,1, new Code.TwoInt(0,1)}};
    }

    @org.testng.annotations.Test(dataProvider = "whileProvider")
    public void negativeWhileTest(int N, int K, Code.TwoInt expected) {
        assertTrue(object.equals(whileTask(N, K), expected));
    }

    @DataProvider
    public Object[][] whileProvider() {
        return new Object[][]{{25, 5, new Code.TwoInt(5, 0)}, {10, 3, new Code.TwoInt(3, 1)}, {1, 3, new Code.TwoInt(0, 3)}, {10, 1, new Code.TwoInt(10, 0)}, {2, 5, new Code.TwoInt(0, 4)}};
    }

    //TODO create provider for negative tests
    @org.testng.annotations.Test(expectedExceptions = AssertionError.class)
    public void whileNegativeTest() {

        whileTask(-1, -3);
    }

    /////////////////////////////////////////

    @org.testng.annotations.Test(dataProvider = "arrayProvider")
    public void arrayTest(double[] array, int L, int R, double expected) {

        assertEquals(arrayTask(array, L, R), expected);

    }

    @DataProvider
    public Object[][] arrayProvider() {
        return new Object[][]{{new double[]{1, 3, 9, 5, 3, 11, 2, 8}, 2, 4, 17.}, {new double[]{1, 3, 9, 5,
                3, 11, 2, 8}, 1, 3, 17.}};
    }
    /////////////////////////////////////////

    @org.testng.annotations.Test(dataProvider = "matrixProvider")
    public void twoDimensionArrayTest(int[][] array, int[][] expected) {

        assertTrue(Arrays.deepEquals(MatrixTask(array), expected));

    }

    @DataProvider
    public Object[][] matrixProvider() {

        int[][] array1 = {{-3, 6, 10, -2},
                {-98, -9, 2, 1},
                {-2, 1, -1, 1},
                {-8, 1, -5, 3}
        };

        int[][] expected1 = {{10, 6, -3, -2},
                {2, -9, -98, 1},
                {1, -2, -1, -2},
                {3, 1, -5, -8}
        };
        int[][] array2 = {
                {-98, -9, 2, 1},
                {-2, 1, -1, 1},
                {-8, 1, -5, 3},
                {-3, 6, 10, -2}

        };
        int[][] expected2 = {
                {2, -9, -98, 1},
                {1, -2, -1, -2},
                {3, 1, -5, -8},
                {10, 6, -3, -2}
        };
        return new Object[][]{{array1, expected1},{array2,expected2}};
    }

    /////////////////////////////////////////


}