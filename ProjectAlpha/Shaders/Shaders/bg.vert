#version 330 core

layout(location = 0) in vec4 position;
layout(location = 1) in vec2 tc;

uniform mat4 pr_matrix;

in DATA
{
	vec2_tc;
}
fs_in;

uniform sampler2D tex;
void main(){
	gl_position = pr_matrix * position;
	color = texture(tex, fs_in.tc);
}