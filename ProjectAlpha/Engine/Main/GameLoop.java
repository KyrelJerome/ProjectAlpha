package Main;

import org.lwjgl.*;
import org.lwjgl.glfw.*;
import org.lwjgl.opengl.*;
import org.lwjgl.system.*;


import static org.lwjgl.glfw.Callbacks.*;
import static org.lwjgl.glfw.GLFW.*;
import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.opengl.GL13.*;
import static org.lwjgl.system.MemoryStack.*;
import static org.lwjgl.system.MemoryUtil.*;

import Controllers.KeyedInput;

import java.nio.*;

public abstract class GameLoop {
	// The window handle
	private long window;
	public static String name;
	//Dimensions
	public static final int WIDTH = 1280;
	public static final int HEIGHT = 720;
	public static  int systemWindowWIDTH;
	public static  int systemWindowHeight;
	public static double SCALEWIDTH = 1;
	public static double SCALEHEIGHT = 1;
	//Game Thread
	private static int UPS = 60;
	private static final double ns = 1000000000.0 / UPS;
	private static int updates = 0;
	private static int frames = 0;
	protected KeyedInput keyboard = new KeyedInput();
	protected void run() {
		System.out.println(name + Version.getVersion() + "!");

		init();//Initialization and Setup
		loop();//Game Loop
		close();//Close Program
		
	}
	
	private void init() {
		// Setup an error callback. The default implementation
		// will print the error message in System.err.
		GLFWErrorCallback.createPrint(System.err).set();

		// Initialize GLFW. Most GLFW functions will not work before doing this.
		if ( !glfwInit() )
			throw new IllegalStateException("Unable to initialize GLFW");

		// Configure GLFW
		glfwDefaultWindowHints(); // optional, the current window hints are already the default
		glfwWindowHint(GLFW_VISIBLE, GLFW_FALSE); // the window will stay hidden after creation
		glfwWindowHint(GLFW_RESIZABLE, GLFW_FALSE); // the window will be resizable

		// Create the window
		window = glfwCreateWindow(WIDTH,HEIGHT, "Project Alpha", NULL, NULL);
		if ( window == NULL )
			throw new RuntimeException("Failed to create the GLFW window");

		// Setup a key callback. It will be called every time a key is pressed, repeated or released.
		glfwSetKeyCallback(window,keyboard);// We will detect this in the rendering loo);

		// Get the thread stack and push a new frame
		try ( MemoryStack stack = stackPush() ) {
			IntBuffer pWidth = stack.mallocInt(1); // int*
			IntBuffer pHeight = stack.mallocInt(1); // int*

			// Get the window size passed to glfwCreateWindow
			glfwGetWindowSize(window, pWidth, pHeight);

			// Get the resolution of the primary monitor
			GLFWVidMode vidmode = glfwGetVideoMode(glfwGetPrimaryMonitor());
			SCALEWIDTH = (vidmode.width()/WIDTH);
			SCALEHEIGHT = (vidmode.width()/HEIGHT);
			// Center the window
			glfwSetWindowPos(
					window,
					(vidmode.width() - pWidth.get(0)) / 2,
					(vidmode.height() - pHeight.get(0)) / 2
					);
		} // the stack frame is popped automatically

		// Make the OpenGL context current
		glfwMakeContextCurrent(window);
		// Enable v-sync
		glfwSwapInterval(1);

		// Make the window visible
		glfwShowWindow(window);
		GL.createCapabilities();
		glEnable(GL_DEPTH_TEST);
		glActiveTexture(GL_TEXTURE1);
		glEnable(GL_BLEND);
		glBlendFunc(GL_SRC_ALPHA, GL_ONE_MINUS_SRC_ALPHA);
		System.out.println("OpenGL: " + glGetString(GL_VERSION));
		gameLoopInit();
	}

	private void loop() {
		glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
		double unprocessed = 0.0;
		long frameStart = System.nanoTime();
		long lastTime = System.nanoTime();
		long timer = System.currentTimeMillis();
		while (! glfwWindowShouldClose(window)) {
			frameStart = System.nanoTime();
			// Poll for window events. The key callback above will only be
			// invoked during this call.
			unprocessed = (frameStart - lastTime) /ns;
			//System.out.println("unprocessed :" + unprocessed);
			lastTime = frameStart;
			gameLoopGetInputs();
			update();
			updates++;
			if (unprocessed >= 1.0) {
				updates++;
				update();
				unprocessed--;
			}
			render();
			frames++;
			if (System.currentTimeMillis() - timer > 1000) {
				timer += 1000;
				System.out.println(updates + " ups, " + frames + " fps");
				updates = 0;
				frames = 0;
			}
		}
	}

	//Only used in game loop
	private void update() {
		glfwPollEvents();
		gameLoopUpdate();
		
	}
	
	private void render() {
		glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT); // clear the framebuffer
		gameLoopRender();
		glfwSwapBuffers(window); // swap the color buffers

	}
	
	private void close() {
		// Free the window callbacks and destroy the window
				glfwFreeCallbacks(window);
				glfwDestroyWindow(window);

				// Terminate GLFW and free the error callback
				glfwTerminate();
				glfwSetErrorCallback(null).free();
	}
	
	public abstract void gameLoopInit();
	public abstract void gameLoopUpdate();
	public abstract void gameLoopRender();
	public abstract void gameLoopGetInputs();
	
	
}
