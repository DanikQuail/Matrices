package cz.educanet.matrices;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.PrintStream;

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
    public void test_Add(){
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

}