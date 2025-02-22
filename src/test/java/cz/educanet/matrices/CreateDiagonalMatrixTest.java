package cz.educanet.matrices;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CreateDiagonalMatrixTest {
    private final IMatrixFactory matrixFactory = MatrixFactory.instance;

    public void assertMatrix(IMatrix matrix, double[] diagonal) {
        for (int i = 0; i < diagonal.length; i++)
            for (int j = 0; j < diagonal.length; j++)
                Assertions.assertEquals(i == j ? diagonal[i] : 0, matrix.get(i, j));
    }

    @Test
    public void should_Succeed_When_DiagonalFits() {
        double[][] testMatrix = {
                {2, 4, 6, 10, 12},
                {5, 6, 7, 8, 9}};

        for (double[] diagonal : testMatrix) {
            IMatrix matrix = matrixFactory.createDiagonal(diagonal);
            assertMatrix(matrix, diagonal);
        }
    }

    @Test
    public void should_ThrowException_When_Empty() {
        double[] empty = {};
        Assertions.assertThrows(IllegalArgumentException.class, () -> matrixFactory.createDiagonal(empty).get(0, 0));
    }


}