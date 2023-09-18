package cz.educanet.matrices;

import java.util.Arrays;

public class Matrix implements IMatrix {

    private final double[][] rawArray;

    public Matrix(double[][] rawArray) {
        this.rawArray = rawArray;
    }

    @Override
    public IMatrix times(IMatrix matrix) {
        if (matrix == null)
            throw new IllegalArgumentException();

        if (getColumns() != matrix.getRows())
            throw new IllegalArgumentException();

        double[][] data = new double[getRows()][matrix.getColumns()];

        for (int i = 0; i < getRows(); i++) {
            for (int j = 0; j < matrix.getColumns(); j++) {
                for (int k = 0; k < getColumns(); k++) {
                    data[i][j] += get(i, k) * matrix.get(k, j);
                }
            }
        }

        return new Matrix(data);
    }

    @Override
    public IMatrix times(Number scalar) {
        if (scalar == null)
            throw new IllegalArgumentException();

        double[][] data = new double[getRows()][getColumns()];

        for (int i = 0; i < getRows(); i++) {
            for (int j = 0; j < getColumns(); j++)
                data[i][j] = get(i, j) * scalar.doubleValue();
        }

        return new Matrix(data);
    }

    @Override
    public IMatrix add(IMatrix matrix) {
        if (matrix == null)
            throw new IllegalArgumentException();

        if (getRows() != matrix.getRows() || getColumns() != matrix.getColumns())
            throw new IllegalArgumentException();

        double[][] data = new double[getRows()][getColumns()];

        for (int i = 0; i < getRows(); i++) {
            for (int j = 0; j < getColumns(); j++)
                data[i][j] = get(i, j) + matrix.get(i, j);
        }

        return new Matrix(data);
    }

    @Override
    public IMatrix transpose() {
        double[][] data = new double[getColumns()][getRows()];

        for (int i = 0; i < getColumns(); i++) {
            for (int j = 0; j < getRows(); j++)
                data[i][j] = get(j, i);
        }

        return new Matrix(data);
    }

    @Override
    public double determinant() {
        return Double.parseDouble(("lol"));
    }

    @Override
    public boolean isSquare() {
        return getRows() == getColumns();
    }

    @Override
    public boolean isDiagonal() {
        if (!isSquare())
            throw new IllegalArgumentException();

        double[][] data = new double[rawArray.length][rawArray[0].length];
        for (int i = 0; i < rawArray.length; i++)
            data[i][i] = rawArray[i][i];

        return Arrays.deepEquals(data, rawArray);
    }


    @Override
    public Number getTrace() {
        if (isSquare()) {
            double total = 0;
            for (int i = 0; i < rawArray.length; i++)
                total += rawArray[i][i];
            return total;
        } else
            throw new RuntimeException();
    }

    @Override
    public int getRows() {
        return rawArray.length;
    }

    @Override
    public int getColumns() {
        if (getRows() > 0)
            return rawArray[0].length;

        return 0;
    }

    @Override
    public double get(int n, int m) {
        if (n >= getRows() || n < 0 || m >= getColumns() || m < 0)
            throw new IllegalArgumentException();

        return rawArray[n][m];
    }
}
