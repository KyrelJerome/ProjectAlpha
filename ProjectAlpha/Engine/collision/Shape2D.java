package collision;

import Maths.Vector2f;
/** 
 * Assumes all Shape2D objects include a 
 */
public abstract class Shape2D {
	
	public abstract void rotateShapeRad(float angle);
	//TODO 
	public abstract void scale(float constant);
	public abstract float getMaxX();
	public abstract float getMinX();
	public abstract float getMaxY();
	public abstract float getMinY();
}
