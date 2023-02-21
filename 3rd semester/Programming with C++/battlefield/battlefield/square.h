#pragma once
#include "defines.h"
#include "gameobject.h"

class Square:public Gameobject
{
	float sqr_pos[2];
	

	bool sqr_highlighted = false;
	bool sqr_active = false;
	bool sqr_placed = false;
	bool s_destroyed = false;
	bool ship_or=false;
public:
	void update() override;
	void draw() override;
	void init() override;
	Square(const class Game& mygame);
	float getPosX() { return sqr_pos[0]; }
	float getPosY() { return sqr_pos[1]; }
	
	void setPosX(float x) { sqr_pos[0] = x; }
	void setPosY(float y) { sqr_pos[1] = y; }

	void setHighlight(bool h) { sqr_highlighted = h; }
	void setActive(bool a) { sqr_active = a; }
	bool getActive() { return sqr_active; }
	bool contains(float x, float y);

	void shipPlaced(bool p) { sqr_placed = p; }
	bool getPlacedShip() { return sqr_placed; }
	void destroyed(bool d) { s_destroyed = d; }
	bool getDestroyed() { return s_destroyed; }
	bool getshipOrientation() { return ship_or; }
	void shipOrientation(bool orien ) { ship_or = orien ; }
};