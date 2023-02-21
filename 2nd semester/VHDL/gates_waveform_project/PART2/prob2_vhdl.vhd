library IEEE;
use IEEE.STD_LOGIC_1164.all;

ENTITY prob2_vhdl IS
PORT ( x1, x2, x3, x4 : IN STD_LOGIC ;
			f				 : OUT STD_LOGIC );
END prob2_vhdl;

ARCHITECTURE Behavior OF prob2_vhdl IS
BEGIN 
	f<= (not x1 and x2 and x3 and x4) or (x1 and not x2 and x3 and x4) or (x1 and x2 and not x3 and x4) 
	or (x1 and x2 and x3 and not x4);
END Behavior;