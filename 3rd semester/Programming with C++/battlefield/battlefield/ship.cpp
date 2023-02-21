#include "ship.h"
#include "graphics.h"
#include "defines.h"
#include "square.h"
#include "game.h"



void Ship::update()
{
	if (graphics::getKeyState(graphics::SCANCODE_SPACE) && s_active)
	{
		if (s_orientation == 0.0f)
		{
			if ((getPosY() != CANVAS_HEIGHT / 10 + 20) && (getPosY() < CANVAS_HEIGHT / 10 + 20 + 9 * BOARD_SIZE))
				s_orientation = 90.0f;
		}
				
		else
		{
			if ((getPosX()!= CANVAS_WIDTH / 3) &&  (getPosX() < CANVAS_WIDTH / 3 + 9 * BOARD_SIZE))
				s_orientation = 0.0f;
			
		}
			sleep(200);
		
	}

	Square* sqr = nullptr;
	bool flag = false;
	if (graphics::getKeyState(graphics::SCANCODE_RIGHT) && s_active)
	{
		float cur_x = getPosX();
		if ((s_orientation / 90) / 2 == 0)
		{
			if (cur_x + BOARD_SIZE < CANVAS_WIDTH / 3 + 9 * BOARD_SIZE)
			{
				setPosX(cur_x + BOARD_SIZE);
			}
				
		}
		else
		{
			if (cur_x + BOARD_SIZE < CANVAS_WIDTH / 3 + 10 * BOARD_SIZE)
				setPosX(cur_x + BOARD_SIZE);
		}
		
		sleep(50);

	}

	if (graphics::getKeyState(graphics::SCANCODE_LEFT) && s_active)
	{
		float cur_x = getPosX();
		if ((s_orientation / 90) / 2 == 0)
		{
			if (cur_x - BOARD_SIZE  >CANVAS_WIDTH / 3 )
				setPosX(cur_x -BOARD_SIZE);

		}
		else
		{
			if (cur_x - BOARD_SIZE >= CANVAS_WIDTH / 3)
				setPosX(cur_x - BOARD_SIZE);
		}

		sleep(50);

	}

	if (graphics::getKeyState(graphics::SCANCODE_UP) && s_active)
	{
		float cur_y = getPosY();
		if ((s_orientation / 90) / 2 == 0)
		{
			if (cur_y - BOARD_SIZE  >=CANVAS_HEIGHT / 10 + 20)
				setPosY(cur_y - BOARD_SIZE);

		}
		else
		{
			if (cur_y - BOARD_SIZE > CANVAS_HEIGHT / 10 + 20)
				setPosY(cur_y - BOARD_SIZE);
		}
		sleep(50);

	}


	if (graphics::getKeyState(graphics::SCANCODE_DOWN) && s_active)
	{
		float cur_y = getPosY();
		if ((s_orientation / 90) / 2 == 0)
		{
			if (cur_y + BOARD_SIZE < CANVAS_HEIGHT / 10 + 20 + 10 * BOARD_SIZE)
				setPosY(cur_y + BOARD_SIZE);
		}
		else
		{
			if (cur_y + BOARD_SIZE < CANVAS_HEIGHT / 10 + 20 + 9 * BOARD_SIZE)
				setPosY(cur_y + BOARD_SIZE);
		}
		
		sleep(50);

	}
}

void Ship::draw()
{
	graphics::Brush brs;

	float h = 1.0f * s_highlighted;

	brs.fill_color[0] = h;
	brs.fill_color[1] = h;
	brs.fill_color[2] = h;
	brs.outline_opacity =0.0f;
	brs.fill_opacity = 1.0f* s_highlighted;
	if (s_active)
	{
		brs.fill_color[0] = 0.0f;
		brs.fill_color[1] = 0.0f;
		brs.fill_color[2] = 1.0f;
		brs.fill_opacity = 1.0f;
	}
	graphics::setOrientation(s_orientation);
	graphics::drawRect(s_pos[0], s_pos[1], BOARD_SIZE*3,BOARD_SIZE, brs);



	brs.fill_color[0] = s_color[0];
	brs.fill_color[1] = s_color[1];
	brs.fill_color[2] = s_color[2];
	brs.fill_opacity = 1.0f;
	brs.texture = std::string(ASSET_PATH) + "ship.png";
	brs.outline_opacity = 0.0f;
	graphics::setOrientation(s_orientation);
	graphics::drawRect(s_pos[0] ,s_pos[1] , 100, 50, brs);
	graphics::resetPose();

	
	}

void Ship::init()
{
}

Ship::Ship(const Game& mygame)
	:Gameobject(mygame)
{
	s_color[0] = RAND0TO1();
	s_color[1] = RAND0TO1();
	s_color[2] = RAND0TO1();
	float mx = s_color[0];
	if (s_color[1] > mx) mx = s_color[1];
	if (s_color[2] > mx) mx = s_color[2];
	s_color[0] /= mx;
	s_color[1] /= mx;
	s_color[2] /= mx;
}

bool Ship::contains(float x, float y)
{
	return distance(x,y,s_pos[0],s_pos[1])< 40.0f;
}



Rect Ship::getCollisonHull() const
{
	Rect rect;
	rect.rx = s_pos[0];
	rect.ry = s_pos[1];
	rect.rw = 3 * BOARD_SIZE;
	rect.rh = BOARD_SIZE;
	rect.ro=s_orientation;
	return rect;
}

