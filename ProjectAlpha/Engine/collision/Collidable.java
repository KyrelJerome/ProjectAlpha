package collision;

import Maths.Axis;
public interface Collidable {
	public AABB getAABB();
	public float getMaxProjection(Axis x);
	public float getMinProjection(Axis x);
}
