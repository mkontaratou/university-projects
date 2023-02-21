#pragma once

#include "ship.h"
#include <list>
#include "button.h"
#include "event.h"
#include "square.h"

class Game
{
public:
	enum game_state_t{STATE_INIT,STATE_LOADING,STATE_MENU, STATE_IDLE, STATE_WAIT, STATE_PLAY, STATE_FINISH,STATE_HELP};

protected:
	Button* bt = nullptr;
	Ship* ship = nullptr;
	int player_turn=0;
	int winner = -1;
	std::list<Event*>m_events;
	bool txt = false;
	game_state_t s_state = STATE_INIT;
	std::list<Ship*>s_ships;
	std::list<Ship*>s_copy_ships;
	std::list<Square*>s_squares;
	std::list<Square*>copy_squares;
	Ship* s_active_ship = nullptr;
	Ship* target_ship = nullptr;
	float s_init_pos_x;
	float s_init_pos_y;
	Square* s_active_square = nullptr;


public:
	void update();
	void draw();
	void init();
	Game();
	~Game();
	void processEvents();
	void addEvents(Event * evt);

	void drawboard();
	void swapboards();
	
	
	bool checkCollision(Ship * ship);
	
};