#include "game.h"
#include "defines.h"
#include "graphics.h"
#include "ship.h"
#include "button.h"
#include "square.h"


void Game::update()
{
	//mouse state
	graphics::MouseState ms;
	graphics::getMouseState(ms);

	float mx = graphics::windowToCanvasX(ms.cur_pos_x);
	float my = graphics::windowToCanvasY(ms.cur_pos_y);
	
	if (s_state == STATE_INIT)
	{
		return;
	}
	
	if (s_state == STATE_LOADING)
	{
		
		for (auto s : s_ships)
		{
			delete s;
		}
		s_ships.clear();

		for (auto s : s_squares)
		{
			delete s;
		}
		s_squares.clear();
		for(auto s:s_copy_ships)
		{
			delete s;
		}
		s_copy_ships.clear();

		for (auto s : copy_squares)
		{
			delete s;
		}
		copy_squares.clear();
		for (auto ev : m_events)
		{
			delete ev;
		}
		m_events.clear();

		init();
		s_state = STATE_MENU;
		return;
	}
	
	

	if (s_state == STATE_MENU)
	{
		if (graphics::getKeyState(graphics::SCANCODE_RETURN))
		{
			s_state = STATE_IDLE;

		}

		


		Button* cur_but = nullptr;

		if (bt->contains(mx, my))
		{
			bt->setHighlight(true);
			cur_but = bt;

		}
		else
			bt->setHighlight(false);

		
		if (ms.button_left_pressed && cur_but)
		{
			cur_but->setActive(true);
			s_state = STATE_HELP;
		}

			return;
		
	}
	
	if (s_state == STATE_HELP)
	{
		if (graphics::getKeyState(graphics::SCANCODE_BACKSPACE))
		{
			s_state = STATE_MENU;
		}
		return;
	}
	
	
	if (s_state==STATE_IDLE)
	{
		
		for (auto ship : s_ships)
		{
			s_init_pos_x = ship->getPosX();
			s_init_pos_y = ship->getPosY();
			ship->update();
			if (checkCollision(ship))
			{
				graphics::Brush br;
				br.fill_color[0] = 1.0f;
				br.fill_color[1] = 0.0f;
				br.fill_color[2] = 0.0f;
				graphics::drawText(CANVAS_WIDTH/2-50, 40.0f, 25.0f, "INVALID MOVE", br);
				ship->setPosX(s_init_pos_x);
				ship->setPosY(s_init_pos_y);

			}
		}
			
		
			
			
			
			
		

		
	
		//highlight ship
		Ship* cur_ship = nullptr;
		for (auto ship : s_ships)
		{
			if (ship->contains(mx, my))
			{
				ship->setHighlight(true);
				cur_ship = ship;
		
			}
			else
				ship->setHighlight(false);
		}

	
		//activate ship
		if (ms.button_left_pressed && cur_ship)
		{
			s_active_ship = cur_ship;
			s_active_ship->setActive(true);
			
			for (auto ship : s_ships)
			{
				if (ship != s_active_ship)
					ship->setActive(false);
			}
			
			
		}

		
		


	
	
		Button* cur_but = nullptr;

		if (bt->contains(mx, my))
		{
			bt->setHighlight(true);
			cur_but = bt;
			
		}
		else
			bt->setHighlight(false);



		//activate button
		if (ms.button_left_pressed && cur_but)
		{
			cur_but->setActive(true);
			if (player_turn == 0)
			{
				s_state = STATE_WAIT;
			}
			else
			{
				s_state = STATE_PLAY;
				player_turn = 0;
			}
			
			

			//entopizei pou einai topothetimena ta ploia
			for (auto s : s_ships)
			{
				for (auto square : s_squares)
				{
					if (s->getPosX() == square->getPosX() && s->getPosY() == square->getPosY())
					{
						square->shipPlaced(true);
						if ((s->getOrientation() / 90.0f) / 2 != 0)
							square->shipOrientation(true);
					}
					
					else if ( (s->getOrientation() / 90.0f)/2 != 0)//perritos ara einai katheta to ploio
					{
						if (s->getPosX() == square->getPosX() && (s->getPosY())+BOARD_SIZE == square->getPosY())
							square->shipPlaced(true);
						else if (s->getPosX() == square->getPosX() && (s->getPosY()) - BOARD_SIZE == square->getPosY())
							square->shipPlaced(true);
					}
					else if ((s->getOrientation() / 90.0f)/2 == 0)
					{
						if ((s->getPosX())+ BOARD_SIZE == square->getPosX() && s->getPosY()  == square->getPosY())
							square->shipPlaced(true);
						else if ((s->getPosX())- BOARD_SIZE == square->getPosX() && s->getPosY()  == square->getPosY())
							square->shipPlaced(true);
					}
					else
					{
						square->shipPlaced(false);
					}
				
				}


			}
			
		}
		return;
	}
	
	if (s_state == STATE_WAIT)
	{
		

		sleep(2000);
		for (auto s : s_ships)
		{
			s_copy_ships.push_front(s);
			
		}
		s_ships.clear();

		for (auto s : s_squares)
		{
			copy_squares.push_front(s);
			
		}
		s_squares.clear();

		player_turn = 1;
		s_state = STATE_IDLE;
		init();
		return;
	}
	
	
	
	
	if (s_state == STATE_PLAY)
	{


		graphics::Brush b;
		b.fill_color[0] = 1.0f;
		b.fill_color[1] = 0.0f;
		b.fill_color[2] = 0.1f;
		

		int sum = 0;
		
		for (auto s : s_squares)
		{
			if (s->getDestroyed())
			{
				sum++;
				
			}
			
		}

		graphics::drawText(720, 50, 20.0f, "REMAINING SQUARES TO DESTROY: " + (std::to_string(18-sum)), b);
		
		if (sum == 18)
		{
			winner = player_turn + 1;
			s_state = STATE_FINISH;
			sleep(500);
			return;
		}

		
		
		//highlight square

		Square* cur_square = nullptr;
		for (auto square : s_squares)
		{
			if (square->contains(mx, my))
			{
				square->setHighlight(true);
				cur_square = square;


			}
			else
				square->setHighlight(false);
		}

		
		//activate square
		if (ms.button_left_pressed && cur_square && (!cur_square->getActive()))
		{
			s_active_square = cur_square;
			s_active_square->setActive(true);

			if (!s_active_square->getPlacedShip())
			{
				swapboards();
				sleep(200);
			}
			else
			{
				s_active_square->destroyed(true);
				graphics::playMusic(std::string(ASSET_PATH) + "mixkit-bomb-distant-explotion-2772.wav", 1.0f, false);
				addEvents(new BombEvent(s_active_square->getPosX(), s_active_square->getPosY()));
				
			}
		}


	}
	
	if (s_state == STATE_FINISH)
	{
		if (graphics::getKeyState(graphics::SCANCODE_SPACE))
		{
			s_state = STATE_LOADING;

		}
		if (graphics::getKeyState(graphics::SCANCODE_BACKSPACE))
		{
			graphics::stopMessageLoop();
		}
		return;
	}
	processEvents();
}



void Game::draw()
{
	graphics::MouseState ms;
	graphics::getMouseState(ms);

	float mx = graphics::windowToCanvasX(ms.cur_pos_x);
	float my = graphics::windowToCanvasY(ms.cur_pos_y);


	graphics::setFont(std::string(ASSET_PATH) + "Friedrich.ttf");
	if (s_state == STATE_INIT)
	{
		graphics::Brush b;
		b.outline_opacity = 0.0f;
		b.fill_color[0] = 1.0f;
		b.fill_color[1] = 1.0f;
		b.fill_color[2] = 1.0f;
		
		graphics::drawText(CANVAS_WIDTH/2-100,CANVAS_HEIGHT/2,40.0f,"Loading assets..",b);
		s_state = STATE_LOADING;
		return;
	}
	
	if (s_state == STATE_MENU)
	{
		graphics::Brush br;
		br.texture = std::string(ASSET_PATH) + "banner.png";
		br.outline_opacity = 0.0f;
		
		//draw background
		graphics::drawRect(CANVAS_WIDTH / 2, CANVAS_HEIGHT / 2, CANVAS_WIDTH, CANVAS_HEIGHT, br);
		graphics::playSound(std::string(ASSET_PATH) + "epic-battle-sound-9414.mp3", 0.05f, true);
		
		
		// create help button
		bt = new Button(0.0f,0.0f,1.0f,40.0f,40.0f);
		bt->setPosX( 25);
		bt->setPosY( 25);
		
		
		if (bt->contains(mx, my))
		{
			graphics::Brush b;
			b.outline_color[0] = 0.0f;
			b.outline_color[1] = 0.0f;
			b.outline_color[2] = 0.0f;
			b.fill_color[0] = 0.0f;
			b.fill_color[1] = 0.5f;
			b.fill_color[2] = 1.0f;
			graphics::drawRect(bt->getPosX(),bt->getPosY(), 40.0f, 40.0f, b);

		}
		else
			bt->draw();

		
		graphics::Brush b;
		
		b.fill_opacity = 1.0f;
		b.fill_color[0] = 1.0f;
		b.fill_color[1] = 1.0f;
		b.fill_color[2] = 1.0f;
		graphics::setFont(std::string(ASSET_PATH) + "Vintage King.ttf");
		graphics::drawText(bt->getPosX()-18, bt->getPosY()+2, 12.0f, "HELP", b);
		b.fill_color[0] = 0.0f;
		b.fill_color[1] = 0.0f;
		b.fill_color[2] = 0.4f;
		graphics::drawText(270, 350, 40.0f, "PRESS ENTER TO START", b);
		


	}

	if (s_state == STATE_HELP)
	{
		graphics::Brush br;
		br.texture = std::string(ASSET_PATH) + "banner.png";
		br.outline_opacity = 0.0f;
		graphics::drawRect(CANVAS_WIDTH / 2, CANVAS_HEIGHT / 2, CANVAS_WIDTH, CANVAS_HEIGHT, br);
		
		br.texture = "";
		br.fill_color[0] = 0.0f;
		br.fill_color[1] = 0.7f;
		br.fill_color[2] = 1.0f;
		br.fill_opacity = 0.5f;
		graphics::drawRect(CANVAS_WIDTH / 2, CANVAS_HEIGHT / 2, CANVAS_WIDTH / 2, CANVAS_HEIGHT / 2, br);
		br.fill_color[0] = 0.0f;
		br.fill_color[1] = 0.0f;
		br.fill_color[2] = 0.0f;
		br.fill_opacity = 1.0f;
		//graphics::setFont(std::string(ASSET_PATH) + "Friedrich.ttf");
		graphics::drawText(CANVAS_WIDTH / 2-50, CANVAS_HEIGHT / 2 - 100, 25.0f, "HOW TO PLAY", br);
		graphics::drawText(CANVAS_WIDTH / 2-200, CANVAS_HEIGHT / 2-50, 20.0f, "Players are placing their ships by clicking on them using ", br);
		graphics::drawText(CANVAS_WIDTH / 2 - 200, CANVAS_HEIGHT / 2-30, 20.0f, "the arrows to move them and spacebar to change their", br);
		graphics::drawText(CANVAS_WIDTH / 2 - 200, CANVAS_HEIGHT / 2-10 , 20.0f, "orientation after each player tries to guess where the", br);
		graphics::drawText(CANVAS_WIDTH / 2 - 200, CANVAS_HEIGHT / 2+10, 20.0f, "other player have placed his ships the first player who ", br);
		graphics::drawText(CANVAS_WIDTH / 2 - 200, CANVAS_HEIGHT / 2 + 30, 20.0f, "will destroy the other player's ships wins the game", br);

		br.fill_color[0] = 0.0f;
		br.fill_color[1] = 0.0f;
		br.fill_color[2] = 0.4f;
		graphics::drawText(CANVAS_WIDTH / 2 - 200, CANVAS_HEIGHT / 2 + 80, 30.0f, "press backspace to return", br);
	}

	if (s_state == STATE_IDLE)
	{
		graphics::Brush br;

		br.texture = std::string(ASSET_PATH) + "war2.png";
		br.outline_opacity = 0.0f;
		//draw background
		graphics::drawRect(CANVAS_WIDTH / 2, CANVAS_HEIGHT / 2, CANVAS_WIDTH, CANVAS_HEIGHT, br);

		
		//create ready button
		bt = new Button(0.4f,0.4f,1.0f,100.0f,70.0f);
		bt->setPosX(CANVAS_WIDTH - 200);
		bt->setPosY(CANVAS_HEIGHT - 100);
		
		
		if (bt->contains(mx,my))
		{
			graphics::Brush b;
			b.outline_color[0] = 0.0f;
			b.outline_color[1] = 0.0f;
			b.outline_color[2] = 0.0f;
			b.fill_color[0] = 0.0f;
			b.fill_color[1] = 0.4f;
			b.fill_color[2] = 1.0f;
			graphics::drawRect(CANVAS_WIDTH - 200, CANVAS_HEIGHT - 100, 100.0f,70.0f , b);

		}
		else
			bt->draw();
		
		graphics::Brush b;
		
		

		b.fill_opacity = 1.0f;
		b.fill_color[0] = 0.0f;
		b.fill_color[1] = 0.0f;
		b.fill_color[2] = 0.0f;
		//graphics::setFont(std::string(ASSET_PATH) + "Friedrich.ttf");
		graphics::drawText(bt->getPosX()-40, bt->getPosY()+10, 40.0f, "READY", b);

		
		
		b.fill_color[0] = 0.0f;
		b.fill_color[1] = 0.0f;
		b.fill_color[2] = 0.0f;
		graphics::drawText(100, 50, 40.0f, "PLAYER "+(std::to_string(player_turn+1)), b);
		
		
		
		drawboard();
		for (auto square : s_squares)
		{
			square->draw();
		}

		



		for (auto ship : s_ships)
		{
			ship->draw();
		}
	
	
	
	}

	
		
		
	if (s_state == STATE_WAIT)
	{
		graphics::Brush br;

		br.texture = std::string(ASSET_PATH) + "sea.png";
		br.outline_opacity = 1.0f;
		
		graphics::drawRect(CANVAS_WIDTH / 2, CANVAS_HEIGHT / 2, CANVAS_WIDTH, CANVAS_HEIGHT, br);
		br.texture = "";
		br.fill_color[0] = 0.0f;
		br.fill_color[1] = 0.5f;
		br.fill_color[2] = 1.0f;
		br.outline_opacity = 0.0f;
		graphics::drawRect(CANVAS_WIDTH / 2, CANVAS_HEIGHT / 2, CANVAS_WIDTH/2, CANVAS_HEIGHT/2, br);


		br.fill_color[0] = 1.0f;
		br.fill_color[1] = 1.0f;
		br.fill_color[2] = 1.0f;
		
		graphics::drawText(CANVAS_WIDTH / 2-170, CANVAS_HEIGHT / 2, 40.0f, "PLAYER " + (std::to_string(player_turn + 2))+ " PLACE YOUR SHIPS", br);
		graphics::resetPose();
	}

	
	
	
	if (s_state == STATE_PLAY)
	{
		graphics::Brush br;
		graphics::Brush b;
		
		br.texture = std::string(ASSET_PATH) + "war2.png";
		br.outline_opacity = 1.0f;
		
		
		//draw background
		graphics::drawRect(CANVAS_WIDTH / 2, CANVAS_HEIGHT / 2, CANVAS_WIDTH, CANVAS_HEIGHT, br);
		
		b.fill_color[0] = 0.0f;
		b.fill_color[1] = 0.0f;
		b.fill_color[2] = 0.0f;
		graphics::drawText(100, 50, 40.0f, "PLAYER " + (std::to_string(player_turn + 1)), b);

		

		
		for (auto square : s_squares)
		{
			square->draw();

		}

		for (auto ev : m_events)
		{
			ev->draw();
		
		}
	}

	if (s_state ==STATE_FINISH)
	{
		graphics::Brush br;
		
		br.outline_opacity = 0.0f;

		br.fill_color[0] = 0.0f;
		br.fill_color[1] = 0.3f;
		br.fill_color[2] = 0.7f;
		//draw background
		graphics::drawRect(CANVAS_WIDTH / 2, CANVAS_HEIGHT / 2, CANVAS_WIDTH, CANVAS_HEIGHT, br);
		graphics::resetPose();
		br.texture= std::string(ASSET_PATH) + "gameover.png";
		graphics::drawRect(CANVAS_WIDTH / 2, CANVAS_HEIGHT / 2, CANVAS_WIDTH/2, CANVAS_HEIGHT/2, br);
		br.fill_color[0] = 0.5f;
		br.fill_color[1] = 1.0f;
		br.fill_color[2] = 1.0f;
		graphics::drawText(CANVAS_WIDTH / 2 - 100, 100, 40.0f, "PLAYER " + (std::to_string(winner))+ " WON", br);
		graphics::drawText(20, 450, 40.0f, "PRESS SPACE TO PLAY AGAIN ", br);
		graphics::drawText(620, 450, 40.0f, "PRESS BACKSPACE TO EXIT", br);
		br.fill_color[0] = 0.0f;
		br.fill_color[1] = 0.0f;
		br.fill_color[2] = 0.0f;
		graphics::drawText(CANVAS_WIDTH/2-20, 450, 60.0f, "OR", br);

		graphics::resetPose();
	}
	
}

void Game::init()
{
	for (int i = 0; i < 3; i++)
	{
		for (int j = 0; j < 2; j++)
		{
			Ship* s = new Ship(*this);
			s_ships.push_front(s);

			s->setPosX(CANVAS_WIDTH/3+40+i*120.0f);
			s->setPosY((CANVAS_HEIGHT/10+20)+ j * 120.0f);
		}
	}

	graphics::preloadBitmaps(ASSET_PATH); //load images(png)
	
	//sleep(2000);
}


Game::Game()
{

}

Game::~Game()
{
	for (auto s : s_ships)
	{
		delete s;
	}
	s_ships.clear();
}

void Game::processEvents()
{
	for (auto e : m_events)
	{
		e->update();
	}

	m_events.remove_if([](Event* ev) {return !ev->active(); });
}

void Game::addEvents(Event* evt)
{
	m_events.push_front(evt);
}



void Game::drawboard()
{
	float pos_x = CANVAS_WIDTH / 3, pos_y = CANVAS_HEIGHT / 10 + 20;
	for (int i = 0; i < 10; i++)
	{
		pos_y = CANVAS_HEIGHT / 10 + 20;
		for (int j = 0; j < 10; j++)
		{
			Square* square = new Square(*this);

			s_squares.push_front(square);

			square->setPosX(pos_x);
			square->setPosY(pos_y);


			pos_y += BOARD_SIZE;
		}
		pos_x += BOARD_SIZE;
	}
}

void Game::swapboards()
{
	std::list<Square*>swap;
	if (player_turn == 0)
		player_turn = 1;
	else
		player_turn = 0;
	swap = s_squares;
	s_squares = copy_squares;
	copy_squares = swap;
}



bool Game::checkCollision(Ship *ship)
{
	Rect r1 = ship->getCollisonHull();
	for (auto s : s_ships)
	{
		if (ship != s)
		{
			Rect r2 = s->getCollisonHull();
			if ((r1.ro / 90.0f) / 2 == 0)//an einai orizontia to energo ploio
			{
				if ((r2.ro / 90.0f) / 2 == 0)//an einai orizontia to ploio pou uparxei sygkroysh 
				{
					if (r1.rx + 2 * BOARD_SIZE == r2.rx && r1.ry == r2.ry)
						return true;
					else if (r1.rx - 2 * BOARD_SIZE == r2.rx && r1.ry == r2.ry)
						return true;
					else if (((r1.rx == r2.rx) || (r1.rx + BOARD_SIZE == r2.rx) || (r1.rx - BOARD_SIZE == r2.rx)) && r1.ry == r2.ry)
						return true;
				}
				else//an einai katheta to ploio pou uparxei sygkroysh 
				{
					if (r1.rx - BOARD_SIZE == r2.rx && ((r1.ry == r2.ry) || (r1.ry + BOARD_SIZE == r2.ry) || (r1.ry - BOARD_SIZE == r2.ry)))
						return true;
					else if (r1.rx + BOARD_SIZE == r2.rx && ((r1.ry == r2.ry) || (r1.ry + BOARD_SIZE == r2.ry) || (r1.ry - BOARD_SIZE == r2.ry)))
						return true;
					else if (r1.rx == r2.rx && r1.ry + BOARD_SIZE == r2.ry)
						return true;
					else if (r1.rx == r2.rx && r1.ry - BOARD_SIZE == r2.ry)
						return true;
				}

			}
			else//an einai katheta to energo ploio
			{
				if ((r2.ro / 90.0f) / 2 == 0)//an einai orizontia to ploio pou uparxei sygkroysh 
				{
					if (r1.rx + BOARD_SIZE == r2.rx && ((r1.ry == r2.ry) || (r1.ry + BOARD_SIZE == r2.ry) || (r1.ry - BOARD_SIZE == r2.ry)))
						return true;
					else if (r1.rx -  BOARD_SIZE == r2.rx && ((r1.ry == r2.ry) || (r1.ry + BOARD_SIZE == r2.ry) || (r1.ry - BOARD_SIZE == r2.ry)))
						return true;
					else if (r1.rx  == r2.rx && ((r1.ry == r2.ry) || (r1.ry + BOARD_SIZE == r2.ry) || (r1.ry - BOARD_SIZE == r2.ry)))
						return true;
				}
				else//an einai katheta to ploio pou uparxei sygkroysh 
				{
					if (r1.rx == r2.rx  && ((r1.ry == r2.ry) || (r1.ry + BOARD_SIZE == r2.ry) || (r1.ry - BOARD_SIZE == r2.ry) || (r1.ry + 2*BOARD_SIZE == r2.ry) || (r1.ry - 2*BOARD_SIZE == r2.ry)))
						return true;
					
				}
			}
		}

	}
	return false;
}



