package cz.educanet.matrices;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MatrixTest {

    @Test
    public void test_Times() {
        IMatrix testMatrix = MatrixFactory.instance.create(new double[][]{
                {1, 2, 3},
                {4, 5, 6}
        });
        IMatrix testTimesMatrix = MatrixFactory.instance.create(new double[][]{
                {1, 2},
                {3, 4},
                {5, 6}
        });

        IMatrix expectedResult = MatrixFactory.instance.create(new double[][]{
                {22, 28},
                {49, 64}
        });

        if (testMatrix.getColumns() != testTimesMatrix.getRows()) {
            throw new IllegalArgumentException();
        }

        IMatrix result = testMatrix.times(testTimesMatrix);

        for (int i = 0; i < result.getRows(); i++) {
            for (int j = 0; j < result.getColumns(); j++) {
                Assertions.assertEquals(expectedResult.get(i, j), result.get(i, j));
            }
        }
    }

    @Test
    public void test_Times_Scalar() {
        IMatrix testMatrix = MatrixFactory.instance.create(new double[][]{
                {12, 4, 17},
                {4, 8, 9}
        });

        int scalar = 6;

        IMatrix expectedResult = MatrixFactory.instance.create(new double[][]{
                {72, 24, 102},
                {24, 48, 54}
        });


        IMatrix result = testMatrix.times(scalar);

        for (int i = 0; i < result.getRows(); i++) {
            for (int j = 0; j < result.getColumns(); j++) {
                Assertions.assertEquals(expectedResult.get(i, j), result.get(i, j));
            }
        }
    }

    @Test
    public void test_Add() {
        IMatrix testMatrix = MatrixFactory.instance.create(new double[][]{
                {1, 2, 3},
                {4, 5, 6}
        });

        IMatrix addMatrix = MatrixFactory.instance.create(new double[][]{
                {4, 5, 1},
                {2, 0, 8}
        });

        IMatrix expectedResult = MatrixFactory.instance.create(new double[][]{
                {5, 7, 4},
                {6, 5, 14}
        });

        IMatrix result = testMatrix.add(addMatrix);

        for (int i = 0; i < result.getRows(); i++) {
            for (int j = 0; j < result.getColumns(); j++) {
                Assertions.assertEquals(expectedResult.get(i, j), result.get(i, j));
            }
        }
    }

    @Test
    public void transpose_Test() {
        IMatrix testMatrix = MatrixFactory.instance.create(new double[][]{
                {1, 5, 4},
                {8, 4, 1},
                {7, 2, 1}
        });
        IMatrix expectedResult = MatrixFactory.instance.create(new double[][]{
                {1, 8, 7},
                {5, 4, 2},
                {4, 1, 1}
        });

        IMatrix result = testMatrix.transpose();

        for (int i = 0; i < result.getRows(); i++) {
            for (int j = 0; j < result.getColumns(); j++) {
                Assertions.assertEquals(expectedResult.get(i, j), result.get(i, j));
            }
        }
    }

    @Test
    public void isSquare_Test_True() {
        IMatrix testMatrix = MatrixFactory.instance.create(new double[][]{
                {0, 0, 0},
                {0, 0, 0},
                {0, 0, 0}
        });

        assertTrue(testMatrix.isSquare());
    }

    @Test
    public void isSquare_Test_False() {
        IMatrix testMatrix = MatrixFactory.instance.create(new double[][]{
                {0, 0, 0, 0},
                {0, 0, 0, 0},
                {0, 0, 0, 0}
        });

        assertFalse(testMatrix.isSquare());
    }

    @Test
    public void isDiagonal_Test_True() {
        IMatrix testMatrix = MatrixFactory.instance.create(new double[][]{
                {1, 0, 0},
                {0, 1, 0},
                {0, 0, 1}
        });

        assertTrue(testMatrix.isDiagonal());
    }

    @Test
    public void isDiagonal_Test_False() {
        IMatrix testMatrix = MatrixFactory.instance.create(new double[][]{
                {1, 0, 0},
                {0, 1, 0},
                {1, 1, 1}
        });

        assertFalse(testMatrix.isDiagonal());
    }

    @Test
    public void isDiagonal_Test_ThrowsException() {
        IMatrix testMatrix = MatrixFactory.instance.create(new double[][]{
                {0, 0, 0, 0},
                {0, 0, 0, 0},
                {0, 0, 0, 0}
        });

        Assertions.assertThrows(IllegalArgumentException.class, testMatrix::isDiagonal);
    }

    @Test
    public void trace_Test() {
        IMatrix testMatrix = MatrixFactory.instance.create(new double[][]{
                {5, 8, 2},
                {31, 56, 4},
                {5, 79, 1}
        });

        double expectedResult = 62;

        double result = testMatrix.getTrace().intValue();

        Assertions.assertEquals(expectedResult, result);
    }

    @Test
    public void trace_Test_ThrowsException() {
        IMatrix testMatrix = MatrixFactory.instance.create(new double[][]{
                {5, 8, 2, 4},
                {31, 56, 4, 3},
                {5, 79, 1, 3}
        });


        Assertions.assertThrows(RuntimeException.class, testMatrix::getTrace);
    }

    @Test
    public void rows_Test() {
        IMatrix testMatrix = MatrixFactory.instance.create(new double[][]{
                {1, 0, 0},
                {0, 1, 0},
                {0, 0, 1},
                {0, 0, 0}
        });

        int expectedResult = 4;

        int result = testMatrix.getRows();

        Assertions.assertEquals(expectedResult, result);
    }

    @Test
    public void columns_Test(){
        IMatrix testMatrix = MatrixFactory.instance.create(new double[][]{
                {1, 0, 0, 0},
                {0, 1, 0, 0},
                {0, 0, 1, 0}
        });

        int expectedResult = 4;

        int result = testMatrix.getColumns();

        Assertions.assertEquals(expectedResult, result);
    }

    @Test
    public void get_Test(){
        IMatrix testMatrix = MatrixFactory.instance.create(new double[][]{
                {1, 0, 0, 0},
                {0, 1, 0, 0},
                {0, 0, 5, 0}
        });

        double expectedResult = 5;

        double result = testMatrix.get(2, 2);

        Assertions.assertEquals(expectedResult, result);
    }


}