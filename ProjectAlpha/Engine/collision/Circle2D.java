package collision;

public class Circle2D extends Shape{

	private float radius;	
	public Circle2D (float radius) {
		this.radius = radius;
	}
	@Override
	public float getMaxX() {
		return radius;
	}

	@Override
	public float getMinX() {
		return -radius;
	}

	@Override
	public float getMaxY() {
		return radius;
	}

	@Override
	public float getMinY() {
		return -radius;
	}
	@Override
	public void scale(float constant) {
		radius = radius*constant;
	}
	@Override
	public void rotateShapeRad(float angle) {
		// has no reason to rotate;
	}

}
