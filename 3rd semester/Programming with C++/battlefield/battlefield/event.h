#pragma once


class Event
{
protected:
	float pos_x;
	float pos_y;

	float duration=2.0f;
	float delay = 0.0f;
	float elapsed_time = 0.0f;
	float elapsed_delay = 0.0f;

	bool e_active = true;

public:
	virtual void draw() {};
	virtual void update();
	Event(float x=0.0f, float y=0.0f,float dur=2.0f,float del=0.0f);
	
	virtual ~Event() {};
	bool active() { return e_active; }
	void disable() { e_active = false; }
	bool waiting();
};

class BombEvent : public Event
{
	float m_orientation;
	float m_scale;
public:
	void draw() override;
	BombEvent(float x,float y);

};