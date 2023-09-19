package cz.educanet.matrices;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MatrixTest {

    @Test
    public void Should_Return_Multiplied_MatrixByAnotherMatrix() {
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
    public void Should_Return_Multiplied_MatrixByScalar() {
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
    public void Should_Return_AddedUp_Matrix() {
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
    public void Should_Return_Transposed_Matrix() {
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
    public void Should_Return_True_When_Matrix_isSquare() {
        IMatrix testMatrix = MatrixFactory.instance.create(new double[][]{
                {0, 0, 0},
                {0, 0, 0},
                {0, 0, 0}
        });

        assertTrue(testMatrix.isSquare());
    }

    @Test
    public void Should_Return_False_When_Matrix_is_notSquare() {
        IMatrix testMatrix = MatrixFactory.instance.create(new double[][]{
                {0, 0, 0, 0},
                {0, 0, 0, 0},
                {0, 0, 0, 0}
        });

        assertFalse(testMatrix.isSquare());
    }

    @Test
    public void Should_Return_True_When_Matrix_isDiagonal() {
        IMatrix testMatrix = MatrixFactory.instance.create(new double[][]{
                {1, 0, 0},
                {0, 1, 0},
                {0, 0, 1}
        });

        assertTrue(testMatrix.isDiagonal());
    }

    @Test
    public void Should_Return_False_When_Matrix_is_notDiagonal() {
        IMatrix testMatrix = MatrixFactory.instance.create(new double[][]{
                {1, 0, 0},
                {0, 1, 0},
                {1, 1, 1}
        });

        assertFalse(testMatrix.isDiagonal());
    }

    @Test
    public void Should_Throw_Exception_When_DiagonalMatrix_is_notSquare() {
        IMatrix testMatrix = MatrixFactory.instance.create(new double[][]{
                {0, 0, 0, 0},
                {0, 0, 0, 0},
                {0, 0, 0, 0}
        });

        Assertions.assertThrows(IllegalArgumentException.class, testMatrix::isDiagonal);
    }

    @Test
    public void Should_Return_Traced_Matrix() {
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
    public void Should_Throw_Exception_When_TracedMatrix_is_notSquare() {
        IMatrix testMatrix = MatrixFactory.instance.create(new double[][]{
                {5, 8, 2, 4},
                {31, 56, 4, 3},
                {5, 79, 1, 3}
        });


        Assertions.assertThrows(RuntimeException.class, testMatrix::getTrace);
    }

    @Test
    public void Should_Return_Number_Of_Rows() {
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
    public void Should_Return_Number_Of_Columns(){
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
    public void Should_Return_Value_Of_Coordinates(){
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