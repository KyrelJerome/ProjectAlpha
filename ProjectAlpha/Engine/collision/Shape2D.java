package collision;

import Maths.Vector2f;

public abstract class Shape2D {
	protected Vector2f[] vertices;//Clockwise edges
	public void rotateShapeRad(float angle) {
		for(int i = 0; i < vertices.length; i ++) {
			vertices[i].rotate(angle);
		}
	}
	public void scale(float constant) {
		for(int i = 0; i < vertices.length; i ++) {
			vertices[i].multiply(constant);
		}
	}
	public abstract float getMaxX();
	public abstract float getMinX();
	public abstract float getMaxY();
	public abstract float getMinY();


}
