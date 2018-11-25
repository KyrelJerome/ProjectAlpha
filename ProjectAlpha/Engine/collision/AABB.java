package collision;

import Maths.Vector2f;

public class AABB {
	Vector2f topRight;
	Vector2f bottomLeft;
	//TopLeft, BottomRight corners are all we define
	public AABB(Vector2f topLeft, Vector2f bottomRight) {
		
	}
	public AABB(float maxX, float minX,  float maxY, float minY)
	{
		topRight = new Vector2f(maxX, maxY);
		bottomLeft = new Vector2f(minX, minY);
		
	}
	//TODO: Finish method stubs;
	public boolean doesCollide(AABB bound2){
		if((getMaxX()<= bound2.getMaxX() && getMinX() >= bound2.getMinX()) ||
				bound2.getMaxX()<= getMaxX() && bound2.getMinX() >= getMinX())
		{
			
		}
		return true;
	}
	public Collision2D getCollision() {
		return null;
	}
	public float getMaxX() {
		return topRight.getX();
	}
	public float getMinX() {
		return bottomLeft.getX();
	}
	public float getMaxY() {
		return topRight.getX();
	}
	public float getMinY() {
		return bottomLeft.getY();
	}
}
