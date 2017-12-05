package alphaGraphics;

import Graphics.Shader;
import Graphics.Texture;
import Graphics.VertexArray;
import Maths.Matrix4f;
import Maths.Vector3f;
public abstract class Background {
	Shader BG;
	private VertexArray background;
	private Vector3f drawLocation;
	private Texture bgTexture;
	
	public Background(String spriteAddress) {
		//BG = new Shader("shaders/bg.vert", "shaders/bg.frag");
	float[] vertices = new float[] {
			-10.0f, -10.0f * 9.0f / 16.0f, 0.0f,
			-10.0f,  10.0f * 9.0f / 16.0f, 0.0f,
			  0.0f,  10.0f * 9.0f / 16.0f, 0.0f,
			  0.0f, -10.0f * 9.0f / 16.0f, 0.0f
		};
		
		byte[] indices = new byte[] {
			0, 1, 2,
			2, 3, 0
		};
		
		float[] tcs = new float[] {
			0, 1,
			0, 0,
			1, 0,
			1, 1
		};
		background = new VertexArray(vertices, indices, tcs);
		bgTexture = new Texture(spriteAddress);
	}
	
	public abstract void init();
	public abstract void loadall();
	public void render() {
		bgTexture.bind();
		BG.enable();
		BG.setUniformMat4f("vw_matrix", Matrix4f.translate(drawLocation));
		background.bind();
		
	}
	public abstract void hide();
	public abstract void kill();
	public abstract void update();
	public abstract void rescale();
/*	public position() {
		
	}*/
}
