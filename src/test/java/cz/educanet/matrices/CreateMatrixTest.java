package cz.educanet.matrices;

import cz.educanet.matrices.IMatrix;
import cz.educanet.matrices.IMatrixFactory;
import cz.educanet.matrices.Matrix;
import cz.educanet.matrices.MatrixFactory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class CreateMatrixTest {

    private final IMatrixFactory matrixFactory = MatrixFactory.instance;

    public void assertMatrix(Matrix matrix, double[][] data) {
        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data[i].length; j++) {
                Assertions.assertEquals(data[i][j], matrix.get(i, j));
            }
        }
    }

    @Test
    public void should_Succeed_When_NumbersFits() {
        double[][][] matrixDataTest = {{{6, 7, 8, 9, 5}}, {{0, 2, 3, 0, 7}}, {{1, 2, 3, 4, 5}}};
        for (double[][] data : matrixDataTest) {
            IMatrix matrix = matrixFactory.create(data);
            assertMatrix((Matrix) matrix, data);
        }
    }

    @Test
    public void should_Succeed_When_SizeFits() {
        double[][][] matrixDataTest = {{{6, 7, 8, 9, 5}}, {{0, 2, 3, 0, 7}}, {{1, 2, 3, 4, 5}}};
        for (double[][] data : matrixDataTest) {
            IMatrix matrix = matrixFactory.create(data);
            Assertions.assertEquals(data.length, matrix.getRows());
            Assertions.assertEquals(data[0].length, matrix.getColumns());
        }
    }

}