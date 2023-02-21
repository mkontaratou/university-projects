#pragma once
#include "defines.h"
#include "gameobject.h"


class Ship:public Gameobject, public Collidable
{
	float s_pos[2];
	float s_color[3];
	float s_orientation=0.0f;



	bool s_highlighted = false;
	bool s_active = false;



public:
	void update() override;
	void draw() override;
	void init() override;
	Ship(const class Game& mygame);
	float getPosX() { return s_pos[0]; }
	float getPosY() { return s_pos[1]; }
	float getOrientation() { return s_orientation; }
	void setPosX(float x) { s_pos[0] = x; }
	void setPosY(float y) { s_pos[1] = y; }
	
	void setHighlight(bool h) { s_highlighted = h; }
	void setActive(bool a) { s_active = a; }
	
	bool contains(float x, float y);

	

	Rect getCollisonHull() const override;
	
};
