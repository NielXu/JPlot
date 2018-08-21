package util.matrix;

import java.math.BigDecimal;

/**
 * Matrix class uses two dimensional BigDecimal array to represent the matrix in order to
 * have higher accuracy. It includes most of the calculations that can be applied between
 * two matrices. It is also immutable so that modifying the given array will not affect the
 * array that stores in the matrices and the caluclations will produce a new matrix.
 * @author Daniel Xu
 *
 */
public class Matrix {
	
	// ================================ Static ==================================
	
	/**
	 * Get an square matrix that represents the nth identity matrix. The identity matrix is
	 * the matrix that follows: A[i,j] = 0 if i !=j, A[i,j] = 1 if i == j.
	 * @param n The size of the square matrix
	 * @return Always return a square matrix with size n*n
	 */
	public static Matrix identity(int n) {
		if(n <= 0) {
			throw new DimensionException("Matrix dimension must be greater than 0");
		}
		BigDecimal[][] m = new BigDecimal[n][n];
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				if(i == j) {
					m[i][j] = new BigDecimal("1");
				}
				else {
					m[i][j] = new BigDecimal("0");
				}
			}
		}
		return new Matrix(m);
	}
	
	// ==========================================================================

	/**Matrix represented by 2d bigdecimal array**/
	private BigDecimal[][] matrix;
	
	/**Matrix dimensions**/
	private int rows, cols;
	
	/**
	 * Construct a matrix by given rows and cols. The matrix will be filled
	 * with 0. Please remember that the matrix is immutable, therefore, this
	 * constructor will only be useful when trying to create a matrix with
	 * all 0.
	 * @param rows The number of rows, greater than 0
	 * @param cols The numbre of cols, greater than 0
	 */
	public Matrix(int rows, int cols) {
		if(rows <= 0 || cols <= 0) {
			throw new DimensionException("Matrix dimension must be greater than 0");
		}
		this.rows = rows;
		this.cols = cols;
		matrix = new BigDecimal[rows][cols];
		for(int i=0;i<rows;i++) {
			for(int j=0;j<cols;j++) {
				matrix[i][j] = new BigDecimal("0");
			}
		}
	}
	
	/**
	 * Construct a matrix with a given two dimensional double array.
	 * This method is <b>not recommend</b> since there will be accuracy loss using double
	 * @param m A two dimensional double array that contains elements in matrix
	 */
	public Matrix(double[][] m) {
		if(m == null) {
			throw new NullPointerException("Matrix cannot be null");
		}
		int init_length = m[0].length;
		for(int i=0;i<m.length;i++) {
			if(m[i].length != init_length) {
				throw new DimensionException("Matrix row must have same length");
			}
		}
		matrix = new BigDecimal[m.length][m[0].length];
		this.rows = m.length;
		this.cols = m[0].length;
		for(int i=0;i<rows;i++) {
			for(int j=0;j<cols;j++) {
				matrix[i][j] = new BigDecimal(m[i][j]);
			}
		}
	}
	
	/**
	 * Construct a matrix with a given two dimensional BigDecimal array.
	 * @param m A two dimensional bigdecimal array that contains elements in matrix
	 */
	public Matrix(BigDecimal[][] m) {
		if(m == null) {
			throw new NullPointerException("Matrix cannot be null");
		}
		if(!row_check(m)) {
			throw new DimensionException("Matrix row must have same length");
		}
		matrix = new BigDecimal[m.length][m[0].length];
		this.rows = m.length;
		this.cols = m[0].length;
		for(int i=0;i<rows;i++) {
			for(int j=0;j<cols;j++) {
				matrix[i][j] = m[i][j];
			}
		}
	}
	
	/**
	 * Construct a matrix with a given two dimensional array. The array is in string type
	 * and will be converted to BigDecimal type.
	 * @param m A two dimensional string array that contains elements in matrix
	 */
	public Matrix(String[][] m) {
		if(m == null) {
			throw new NullPointerException("Matrix cannot be null");
		}
		if(!row_check(m)) {
			throw new DimensionException("Matrix row must have same length");
		}
		matrix = new BigDecimal[m.length][m[0].length];
		this.rows = m.length;
		this.cols = m[0].length;
		for(int i=0;i<rows;i++) {
			for(int j=0;j<cols;j++) {
				// Check if string is an actual number
				if(!string_numberic_check(m[i][j])) {
					throw new NumberFormatException("Cannot convert "+m[i][j]+" to BigDecimal");
				}
				matrix[i][j] = new BigDecimal(m[i][j]);
			}
		}
	}
	
	/**
	 * Apply addition between two matrices. In order to do the calculation, the two
	 * matrices must have the same dimension
	 * @param m Another matrix
	 * @return A new matrix that represents the result of the calculation
	 */
	public Matrix add(Matrix m) {
		if(m == null) {
			throw new NullPointerException("Matrix cannot be null");
		}
		if(!same_dimensoin_check(m)) {
			throw new DimensionException("Matrices must have same dimension for addition");
		}
		BigDecimal[][] result = new BigDecimal[rows][cols];
		for(int i=0;i<rows;i++) {
			for(int j=0;j<cols;j++) {
				result[i][j] = m.get(i, j).add(matrix[i][j]);
			}
		}
		return new Matrix(result);
	}
	
	/**
	 * Apply subtraction between two matrices. In order to do the calculation, the two
	 * matrices must have the same dimension
	 * @param m Another matrix
	 * @return A new matrix that represents the result of the calculation
	 */
	public Matrix subtract(Matrix m) {
		if(m == null) {
			throw new NullPointerException("Matrix cannot be null");
		}
		if(!same_dimensoin_check(m)) {
			throw new DimensionException("Matrices must have same dimension for subtraction");
		}
		BigDecimal[][] result = new BigDecimal[rows][cols];
		for(int i=0;i<rows;i++) {
			for(int j=0;j<cols;j++) {
				result[i][j] = m.get(i, j).subtract(matrix[i][j]);
			}
		}
		return new Matrix(result);
	}
	
	/**
	 * Multiply this matrix with another matrix. In order to do the calculation, if this
	 * matrix has dimension m*n, then another matrix must be in n*k. The result matrix will
	 * be in m*k dimension. Please notice that the results between A*B and B*A are sometimes different since
	 * matrices do not follow Commutative Law.
	 * @param m Another matrix
	 * @return A new matrix that represents the result of the calculation
	 */
	public Matrix multiply(Matrix m) {
		if(!multiply_dimension_check(m)) {
			throw new DimensionException("Matrices dimension must follow rule: dim(A) = m*n, dim(B) = n*k");
		}
		BigDecimal[][] result = new BigDecimal[rows][m.cols()];
		for(int i=0;i<result.length;i++) {
			for(int j=0;j<result[0].length;j++) {
				result[i][j] = Linear.dot(get_row(i), m.get_col(j));
			}
		}
		return new Matrix(result);
	}
	
	/**
	 * Multiply the whole matrix by a factor.
	 * @param fac The factor in string format
	 * @return A new matrix that represents the result of the calculation
	 */
	public Matrix factor(String fac) {
		if(fac == null) {
			throw new NullPointerException("Factor cannot be null");
		}
		if(!string_numberic_check(fac)) {
			throw new NumberFormatException("Cannot convert "+fac+" to BigDecimal");
		}
		return factor(new BigDecimal(fac));
	}
	
	/**
	 * Multiply the whole matrix by a factor.
	 * @param fac The factor in BigDecimal format
	 * @return A new matrix that represents the result of the calculation
	 */
	public Matrix factor(BigDecimal fac) {
		if(fac == null) {
			throw new NullPointerException("Factor cannot be null");
		}
		BigDecimal[][] result = new BigDecimal[rows][cols];
		for(int i=0;i<rows;i++) {
			for(int j=0;j<cols;j++) {
				result[i][j] = matrix[i][j].multiply(fac);
			}
		}
		return new Matrix(result);
	}
	
	/**
	 * Multiply a single row in the matrix by a given factor
	 * @param fac The factor in string format
	 * @param row_index The row that will be multiplied with the factor
	 * @return A new matrix that represents the result of the calculation
	 */
	public Matrix factor_row(String fac, int row_index) {
		if(fac == null) {
			throw new NullPointerException("Factor cannoe be null");
		}
		if(!string_numberic_check(fac)) {
			throw new NumberFormatException("Cannot convert "+fac+" to BigDecimal");
		}
		return factor_row(new BigDecimal(fac), row_index);
	}
	
	/**
	 * Multiply a single row in the matrix by a given factor
	 * @param fac The factor in BigDecimal format
	 * @param row_index The row that will be multiplied with the factor
	 * @return A new matrix that represents the result of the calculation
	 */
	public Matrix factor_row(BigDecimal fac, int row_index) {
		if(fac == null) {
			throw new NullPointerException("Factor cannoe be null");
		}
		if(row_index < 0 || row_index >= rows) {
			throw new IndexOutOfBoundsException("Row index out of range");
		}
		BigDecimal[][] result = new BigDecimal[rows][cols];
		for(int i=0;i<rows;i++) {
			for(int j=0;j<cols;j++) {
				if(i == row_index) {
					result[i][j] = fac.multiply(matrix[i][j]);
				}
				else {
					result[i][j] = matrix[i][j];
				}
			}
		}
		return new Matrix(result);
	}
	
	/**
	 * Multiply a single col in the matrix by a given factor
	 * @param fac The factor in string format
	 * @param col_index The col that will be multiplied with the factor
	 * @return A new matrix that represents the result of the calculation
	 */
	public Matrix factor_col(String fac, int col_index) {
		if(fac == null) {
			throw new NullPointerException("Factor cannoe be null");
		}
		if(!string_numberic_check(fac)) {
			throw new NumberFormatException("Cannot convert "+fac+" to BigDecimal");
		}
		return factor_col(new BigDecimal(fac), col_index);
	}
	
	/**
	 * Multiply a single col in the matrix by a given factor
	 * @param fac The factor in BigDecimal format
	 * @param col_index The col that will be multiplied with the factor
	 * @return A new matrix that represents the result of the calculation
	 */
	public Matrix factor_col(BigDecimal fac, int col_index) {
		if(fac == null) {
			throw new NullPointerException("Factor cannoe be null");
		}
		if(col_index < 0 || col_index >= cols) {
			throw new IndexOutOfBoundsException("Row index out of range");
		}
		BigDecimal[][] result = new BigDecimal[rows][cols];
		for(int i=0;i<rows;i++) {
			for(int j=0;j<cols;j++) {
				if(j == col_index) {
					result[i][j] = fac.multiply(matrix[i][j]);
				}
				else {
					result[i][j] = matrix[i][j];
				}
			}
		}
		return new Matrix(result);
	}
	
	/**
	 * Get the tranpose of this matrix
	 * @return A new matrix represnets the transpose of this matrix
	 */
	public Matrix transpose() {
		BigDecimal[][] result = new BigDecimal[cols][rows];
		for(int i=0;i<rows;i++) {
			for(int j=0;j<cols;j++) {
				result[j][i] = matrix[i][j];
			}
		}
		return new Matrix(result);
	}
	
	/**
	 * Get the element in the matrix by the given index. The element will
	 * be in BigDecimal format. BigDecimal is immutable,
	 * therefore, it will not affect the matrix.
	 * affect the matrix.
	 * @param row_index row index, starts from 0
	 * @param col_index col index, starts from 0
	 * @return The element at the given index in BigDecimal format
	 */
	public BigDecimal get(int row_index, int col_index) {
		if(!index_check(row_index, col_index)) {
			throw new IndexOutOfBoundsException("Row index or col index out of range");
		}
		return matrix[row_index][col_index];
	}
	
	/**
	 * Get a BigDecimal array by index that represents a row of the matrix.
	 * BigDecimal is immutable, therefore, it will not affect the matrix.
	 * @param index The number of row, start from 0
	 * @return A BigDecimal array that represents a row of the matrix
	 */
	public BigDecimal[] get_row(int index) {
		if(!index_check(index, 0)) {
			throw new IndexOutOfBoundsException("Row index out of range");
		}
		return matrix[index];
	}
	
	/**
	 * Get a BigDecimal array by index that represents a col of the matrix.
	 * BigDecimal is immutable, therefore, it will not affect the matrix.
	 * @param index The number of col, start from 0
	 * @return A BigDecimal array that represents a col of the matrix
	 */
	public BigDecimal[] get_col(int index) {
		if(!index_check(0, index)) {
			throw new IndexOutOfBoundsException("Col index out of range");
		}
		BigDecimal[] col = new BigDecimal[rows];
		for(int i=0;i<col.length;i++) {
			col[i] = matrix[i][index];
		}
		return col;
	}
	
	/**
	 * Get the number of rows in the matrix
	 * @return Number of rows
	 */
	public int rows() {
		return rows;
	}
	
	/**
	 * Get the number of cols in the matrix
	 * @return Number of cols
	 */
	public int cols() {
		return cols;
	}
	
	/**
	 * Override the toString() method to represents the matrix in format:<br>
	 * a b c<br>
	 * d e f
	 */
	@Override
	public String toString() {
		String str = "";
		for(int i=0;i<rows;i++) {
			for(int j=0;j<cols;j++) {
				str += matrix[i][j];
				if(j != cols-1) str += "\t";
			}
			if(i != rows-1) str += "\n";
		}
		return str;
	}

	// Check if a given string is a number
	private boolean string_numberic_check(String s) {
		try {
			Double.parseDouble(s);
			return true;
		}
		catch(NumberFormatException e) {
			return false;
		}
	}
	
	// Check if index is valid
	private boolean index_check(int row, int col) {
		if(row < 0 || row >= rows || col < 0 || col >= cols) {
			return false;
		}
		return true;
	}
	
	// Check if two matrices can multiply each other
	private boolean multiply_dimension_check(Matrix m) {
		if(cols != m.rows()) {
			return false;
		}
		return true;
	}
	
	// Before applying calculations such as addition, must check if two matrices have same dimension
	private boolean same_dimensoin_check(Matrix m) {
		if(m.rows() == rows && m.cols() == cols) {
			return true;
		}
		return false;
	}
	
	// Check if each row in the matrix has same length
	private boolean row_check(Object[][] m) {
		boolean flag = true;
		int init_length = m[0].length;
		for(int i=0;i<m.length;i++) {
			if(m[i].length != init_length) {
				flag = false;
				break;
			}
		}
		return flag;
	}
}
