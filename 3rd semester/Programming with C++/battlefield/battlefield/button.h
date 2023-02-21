#pragma once


class Button
{
	float b_pos[2];
	float b_color[3];
	float b_orientation;
	float b_dimensions[2];

	bool b_highlighted = false;
	bool b_active = false;

public:
	void draw();
	void update();
	Button(float color_r, float color_g, float color_b, float dim_w, float dim_h);
	~Button();
	float getPosX() { return b_pos[0]; }
	float getPosY() { return b_pos[1]; }
	void setPosX(float x) { b_pos[0] = x; }
	void setPosY(float y) { b_pos[1] = y; }
	void setHighlight(bool h) { b_highlighted = h; }
	void setActive(bool a) { b_active = a; }

	bool getHighlight() { return b_highlighted; }
	bool contains(float x, float y);


};