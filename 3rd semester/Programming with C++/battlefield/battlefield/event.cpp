#include "event.h"
#include "graphics.h"
#include "defines.h"

void Event::update()
{
	if (!e_active)
		return;
	
	if (waiting())
	{
		elapsed_delay+=graphics::getDeltaTime() / 1000.0f;
		return;
	}
	elapsed_time += graphics::getDeltaTime() / 1000.0f;
	if (elapsed_time > duration)
	{
		e_active = false;
	}
}

Event::Event(float x, float y, float dur, float del)
	:pos_x(x), pos_y(y), duration(dur), delay(del)
{
}

bool Event::waiting()
{
	return elapsed_delay<delay;
}

void BombEvent::draw()
{
	graphics::Brush br;

	float s = elapsed_time / duration;

	
	br.fill_opacity = 1.0f - s;
	br.outline_opacity = 0.0f;
	br.texture = std::string(ASSET_PATH) + "bomb.png";
	graphics::setScale(m_scale + s, m_scale +s );
	graphics::setOrientation(m_orientation + s * 20);
	graphics::drawRect(pos_x,pos_y,50.0f,50.0f,br);

	graphics::resetPose();
	

}

BombEvent::BombEvent(float x, float y)
	:Event(x,y,1.0f,0.0f)
{
	m_orientation = 0.0f;
	m_scale = 0.4f;;
}
