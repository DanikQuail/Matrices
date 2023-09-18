package cz.educanet.matrices;

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

    /**
     * TODO: Implement
     */
    @Override
    public double determinant() {
        return 0;
    }

    /**
     * TODO: Implement
     */
    @Override
    public boolean isSquare() {
        return false;
    }

    /**
     * TODO: Implement
     */
    @Override
    public boolean isDiagonal() {
        return false;
    }


    @Override
    public Number getTrace() {
        return null;
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
