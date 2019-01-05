package collision;

import Maths.Vector2f;

public class ConvexPolygon2D extends Shape{
	protected Vector2f[] vertices;//Clockwise edges

	@Override
	public float getMaxX() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public float getMinX() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public float getMaxY() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public float getMinY() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void scale(float constant) {
		for(int i = 0; i < vertices.length; i ++) {
			vertices[i].multiply(constant);
		}		
	}

	@Override
	public void rotateShapeRad(float angle) {
		for(int i = 0; i < vertices.length; i ++) {
			vertices[i].rotate(angle);
		}
	}
}
