package Controllers;

import org.lwjgl.glfw.GLFWKeyCallback;
import org.lwjgl.glfw.GLFW;
public class KeyedInput extends GLFWKeyCallback{
	private static boolean[] keys = new boolean[600];

	public void invoke(long window, int key, int scancode, int action, int mods) 
	{
		if (key >= 0) {
			keys[key] = action == GLFW.GLFW_RELEASE;}
	}
	public boolean[] getKeys() {
		boolean[] out = new boolean[600];
		for(int i = 0; i < keys.length; i ++)
		{
			out[i] = keys[i];
		}
		return out;
	}
}
