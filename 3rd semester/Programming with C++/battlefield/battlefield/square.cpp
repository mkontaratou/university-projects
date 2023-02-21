#include "square.h"
#include "graphics.h"
#include "ship.h"


void Square::update()
{
}

void Square::draw()
{
	if (!sqr_active)
	{
		graphics::Brush br1;
		if (!sqr_highlighted)
		{
			
			br1.fill_color[0] = 0.3f;
			br1.fill_color[1] = 0.3f;
			br1.fill_color[2] = 0.3f;
			
		}
		else
		{
			br1.fill_color[0] = 0.5f;
			br1.fill_color[1] = 0.5f;
			br1.fill_color[2] = 0.5f;
			
		}
		br1.outline_opacity = 1.0f;
		br1.outline_color[0] = 0.7f;
		br1.outline_color[1] = 0.7f;
		br1.outline_color[2] = 0.7f;
		br1.fill_opacity = 0.1f;
		graphics::drawRect(sqr_pos[0], sqr_pos[1], BOARD_SIZE, BOARD_SIZE, br1);


	}
	else
	{
		if (sqr_placed)
		{
			graphics::Brush br2;
			br2.fill_color[0] = 1.0f;
			br2.fill_color[1] = 0.0f;
			br2.fill_color[2] = 0.0f;
			br2.outline_opacity = 0.3f;
			br2.fill_opacity = 0.5f;
			graphics::drawRect(sqr_pos[0], sqr_pos[1], BOARD_SIZE, BOARD_SIZE, br2);
		}
		else
		{
			graphics::Brush br3;
			br3.fill_color[0] = 0.0f;
			br3.fill_color[1] = 1.0f;
			br3.fill_color[2] = 1.0f;
			br3.outline_opacity = 0.3f;
			br3.fill_opacity = 0.5f;
			graphics::drawRect(sqr_pos[0], sqr_pos[1], BOARD_SIZE, BOARD_SIZE, br3);

		}
	}
}

void Square::init()
{
}

Square::Square(const Game& mygame)
	:Gameobject(mygame)
{
}

bool Square::contains(float x, float y)
{
	return distance(x, y, sqr_pos[0], sqr_pos[1]) < 20.0f;
}
