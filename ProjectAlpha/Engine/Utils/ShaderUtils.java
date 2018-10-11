package Utils;

import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.opengl.GL20.*;

public class ShaderUtils {

	private ShaderUtils() {
		
	}
	public static int load(String shader) {
			String vert = FileUtils.loadAsString(shader + ".vs");
			String frag = FileUtils.loadAsString(shader + ".fs");
			return create(vert, frag);
	}
	public static int create(String vert, String frag)
	{
		int program = glCreateProgram();
		int vertID = glCreateShader(GL_VERTEX_SHADER);
		int fragID = glCreateShader(GL_FRAGMENT_SHADER);
		glShaderSource(vertID,vert);
		glCompileShader(vertID);
		if (glGetShaderi(vertID,GL_COMPILE_STATUS) == GL_FALSE)
		{
			System.err.println("Failed to compile vertex shader!");
			System.err.println(glGetShaderInfoLog(vertID));
			return -1;
		}
		glShaderSource(fragID,frag);
		glCompileShader(fragID);
		if (glGetShaderi(fragID,GL_COMPILE_STATUS) == GL_FALSE)
		{
			System.err.println("Failed to compile fragment shader!");
			System.err.println(glGetShaderInfoLog(fragID));
			return -1;
		}
		glAttachShader(program, vertID);
		glAttachShader(program,fragID);
		glLinkProgram(program);
		if(glGetProgrami(program, GL_LINK_STATUS)!= 1)
		{
			System.err.println(glGetProgramInfoLog(program));
			System.exit(1);
		}
		glValidateProgram(program);
		if(glGetProgrami(program, GL_VALIDATE_STATUS)!= 1)
		{
			System.err.println(glGetProgramInfoLog(program));
			System.exit(1);
		}
		glDeleteShader(vertID);
		glDeleteShader(fragID);
		
		return program;
	}
}
