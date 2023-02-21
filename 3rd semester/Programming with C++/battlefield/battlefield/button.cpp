#include "button.h"
#include "graphics.h"
#include "defines.h"

void Button::draw()
{
	
	
	
	graphics::Brush br;
	
	
	float h= 1.0f * b_highlighted;
	br.fill_color[0] = b_color[0];
	br.fill_color[1] = b_color[1];
	br.fill_color[2] = b_color[2];

	br.outline_opacity = 0.0f ;
	br.fill_opacity = 0.8f;
	
	graphics::drawRect(b_pos[0], b_pos[1],b_dimensions[0], b_dimensions[1], br);
	graphics::resetPose();

}

void Button::update()
{
}

Button::Button(float color_r, float color_g, float color_b, float dim_w, float dim_h)
{
	b_color[0] = color_r;
	b_color[1] = color_g;
	b_color[2] = color_b;
	b_dimensions[0] = dim_w;
	b_dimensions[1] = dim_h;
}


Button::~Button()
{
}

bool Button::contains(float x, float y)
{
	
	return distance(x,y,b_pos[0],b_pos[1])<b_dimensions[1];
}
