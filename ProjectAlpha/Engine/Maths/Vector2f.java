package Maths;

public class Vector2f extends  Matrix{
	private final static Vector2f V_ORIGIN= new Vector2f(0,0);
	private final static Vector2f V_X_AXIS_POS = new Vector2f(1,0);/**X unit vector */
	private final static Vector2f V_Y_AXIS_POS = new Vector2f(0,1);/**Y unit vector */

	public Vector2f() {
		super(1,2);
	}
	public Vector2f(float x, float y) {
		super(1,2);
		setElement(0,0,x);
		setElement(0,1,y);
	}
	private void setX(float x) {
		setElement(0,0,x);
	}
	private void setY(float y) {
		setElement(0,1,y);
	}
	public float getX() {
		return getElement(0,0);
	}
	
	public float getY() {
		return getElement(0,1);
	}
	
	public static Vector2f geti() {
		return V_X_AXIS_POS.copy();
	}
	public static Vector2f getj() {
		return V_Y_AXIS_POS.copy();
	}
	public static float getDot(Vector2f v1, Vector2f v2) {
		
		return v1.getX() * v2.getX() + v1.getY() * v2.getY();
		
	}
	/**
	 * Multiplies vector by -I where I is the appropriate identity matrix
	 */
	public void negate(){
		setX(-getX());
		setY(-getY());
	}
	/**
	 * @returns a seperate vector by -IA where I is the appropriate identity matrix 
	 * and A is the current object.
	 */
	public Vector2f getNegation() {
		return new Vector2f(-getX(),-getY()); 
	}
	
	/**
	 * Translates (this.x,this.y) to (this.x + x, this.y + y)  
	 * @param x - x to add
	 * @param y - y to add                            	
	 */
	public void translate(float x, float y) {
		setX(getX() + x);
		setY(getY() + y);
	}
	
	/** Translates (this.x,this.y) to (x + translation.x, y + translation.y)  
	 * @param Vector2f translation - vector to translate by.
	 */  
	public void translate(Vector2f translation) {
		setX(getX() + translation.getX());
		setY(getY() + translation.getY());
	}

	/**
	 *  Rotates the vector around origin by angle radians. (Positive is clockwise);
	 * @param angle - rotation angle in radians (cartesian).
	 */
	public void rotate(double angle) {
		float cos = (float)Math.cos(angle);
		float sin = (float)Math.sin(angle);
		if(angle>0)
		{
			setX(getX()*cos - getY()*sin);
			setY(getX()*sin + getY()*cos);
		}
		else if(angle < 0)
		{
			setX(getX()*cos - getY()*sin);
			setY(getX()*sin + getY()*cos);
		}
	}
	/**
	 * Rotates the vector around point by angle radians. (Positive is clockwise);
	 * @param angle - rotation angle in radians (cartesian).
	 */
	public void rotateAroundPoint(double angle, Vector2f point) {

		translate(point.copy().getNegation());
		rotate(angle);
		translate(point);
	}
	/*
	public void rotateToAngle() {
		
	}*/
	
	/**
	 * 
	 * @return Deepcopy of this vector. In other words,
	 *  returns a seperate, unsaved  reference;
	 */
	public Vector2f copy(){
		return new Vector2f(this.getX(),this.getY());
	}


}
