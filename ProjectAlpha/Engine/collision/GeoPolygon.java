package collision;

import Maths.Axis;
import Maths.Vector2f;

public class GeoPolygon implements Collidable{
	//TODO Complete constructors
	Shape2D polygon;
	Vector2f center;
	public void rotate(float angle) {
		polygon.rotateShapeRad(angle);
	}
	@Override
	public float getMaxProjection(Axis x) {
		// TODO 	Auto-generated method stub
		return 0;
	}
	@Override
	public float getMinProjection(Axis x) {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public AABB getAABB() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
