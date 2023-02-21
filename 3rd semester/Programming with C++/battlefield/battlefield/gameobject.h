#pragma once
#include "defines.h"

class Collidable
{
public:
	virtual Rect getCollisonHull() const = 0;
};

class Gameobject {
protected:
	const class Game& game;

public:
	Gameobject(const class Game& mygame);
	virtual void update() = 0;
	virtual void draw() = 0;
	virtual void init() = 0;
};