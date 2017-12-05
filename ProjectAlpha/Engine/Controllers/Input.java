package Controllers;

import org.lwjgl.glfw.GLFWKeyCallback;
import org.lwjgl.glfw.GLFW;
public class Input extends GLFWKeyCallback{
	public static boolean[] keys = new boolean[600];

	public void invoke(long window, int key, int scancode, int action, int mods) 
	{
		if (key >= 0) {
			keys[key] = action == GLFW.GLFW_RELEASE;}
	}
}
