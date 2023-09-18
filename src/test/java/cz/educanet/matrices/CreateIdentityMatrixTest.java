package cz.educanet.matrices;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CreateIdentityMatrixTest {
    private final IMatrixFactory matrixFactory = MatrixFactory.instance;

    public void assertMatrix(IMatrix matrix, int size) {
        for (int i = 0; i < matrix.getColumns(); i++)
            for (int j = 0; j < matrix.getRows(); j++)
                if (i == j) Assertions.assertEquals(1, matrix.get(i, j));
    }

    @Test
    public void should_Succeed_When_IdentityFits() {
        int[] sizes = {1, 2, 3, 4, 5};

        for (int size : sizes) {
            IMatrix matrix = matrixFactory.createIdentity(size);
            assertMatrix(matrix, size);
        }
    }

    @Test
    public void should_ThrowException_When_SizeIsLessThanZero() {
        int size = -1;
        Assertions.assertThrows(IllegalArgumentException.class, () -> matrixFactory.createIdentity(size));
        int size2 = -2;
        Assertions.assertThrows(IllegalArgumentException.class, () -> matrixFactory.createIdentity(size2));

    }

}