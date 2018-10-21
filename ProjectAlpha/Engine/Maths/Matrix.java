package Maths;

//TODO: Add IllegalOperationExceptions
public class Matrix {
	int rows;
	int columns;
	float[][] matrix;

	public Matrix() {
		matrix = new float[1][1];
		matrix[0][0] = 0;
		rows = 0;
		columns = 0;
	}

	public Matrix(int rows,int columns){
		if(0 < rows &&  0 < columns) {

			matrix = new float[rows][columns];
			this.columns = columns;
			this.rows = rows;
			for(int i = 0; i < rows; i ++) {
				for(int j = 0; j < columns; j ++) {
					matrix[i][j] = 0;
				}
			}
		}
	}
	
	public Matrix getRow(int index) {
		Matrix returnable = new Matrix(1,columns);
		for(int i = 0; i < columns; i ++) {
			returnable.setElement(index, i, getElement(index,i));
		}
		return returnable;
	}
	public Matrix getColumn(int index) {
		Matrix returnable = new Matrix(rows,1);
		for(int i = 0; i < rows; i ++) {
			returnable.setElement(i, index, getElement(i,index));
		}
		return returnable;
	}
	/**
	 * Returns square Identity matrix I_size_x_size .
	 * @param size - the rows and columns 
	 * @return unsaved reference of I_n matrix where n = size.
	 */
	public static Matrix getIdentity(int size) {
		if(0 < size) {
			
			Matrix matrix = new Matrix(size,size);
			for(int i = 0; i < size; i ++) {
				matrix.setElement(i, i, 1);
			}
			return matrix;
		}
		return null;
	}
	
	/**
	 * Multiplies matrices as m1*m2;
	 * @param m1 - Matrix to multiply on left of m2.
	 * @param m2 - Matrix to multiply on right of m1.
	 * @return If m1 can be multiplied by m2, returns m1*m2 and otherwise returns null;
	 */
	public Matrix multiply(Matrix  m1,Matrix m2) {
		if(m1.getNumColumns() == m2.getNumRows()){
			Matrix output = new Matrix(m1.getNumRows(),m2.getNumColumns());
			for(int i = 0; i < output.getNumRows(); i ++) {
				for(int j = 0; j < output.getNumColumns(); j ++) {
					m1.setElement(i,j, dot(m1.getRow(i),m2.getColumn(j)));
				}
			}
		}
		
		return null;		
	}
	public void multiply(float c1) {
		
		for(int i = 0; i < getNumRows(); i ++) {
			for(int j = 0; j < getNumColumns(); j ++) {
				setElement(i,j, getElement(i, j)*c1);
			}
		}
	}
	protected boolean equals(Matrix m1, Matrix m2){
		if(m1.getNumRows() == m2.getNumRows() && m1.getNumColumns() == m2.getNumColumns())
		for(int i = 0; i < getNumRows(); i ++) {
			for(int j = 0; j < getNumColumns(); j ++) {
				if(m1.getElement(i, j) != m2.getElement(i, j)) return false;
			}
		}
		return true;
	}
	
	/**
	 * 
	 * @return dot product of m1*m2, 
	 */
	protected float dot(Matrix m1, Matrix m2) {
		float total =  0;
		if(m1.getNumRows() == 1 && m2.getNumColumns() == 1 && m1.getNumColumns() == m2.getNumRows()) {
			for(int i = 0; i < columns; i ++) {
				total += m1.getElement(0, i)*m1.getElement(i,0);
			}
		}
		return (Float) null;
	}
	public float getElement(int row, int column) {
		return matrix[row][column];
	}
	public void setElement(int row, int column, float value) {
		matrix[row][column] = value;
	}
	public int getNumColumns() {
		return columns;
	}
	public int getNumRows() {
		return rows;
	}


}
