LIBRARY ieee;
USE ieee.std_logic_1164.all;

-- PACKAGE 1bit ALU 

PACKAGE one_bit_pack IS

	COMPONENT one_bit
	
		PORT( A,B, carryIN,Ainvert,Binvert: IN std_logic;
				f, carryOUT: OUT STD_logic;
				s: IN STD_logic_vector(1 DOWNTO 0));
	
	END COMPONENT;

END PACKAGE one_bit_pack;

LIBRARY ieee;
USE ieee.std_logic_1164.all;

ENTITY one_bit IS
	
	PORT(A,B, carryIN,Ainvert,Binvert: IN STD_logic; f, carryOUT : OUT STD_logic; s: IN STD_logic_vector(1 DOWNTO 0)); 

END one_bit;

ARCHITECTURE Behavioral OF one_bit IS

signal Ai,Bi: std_logic;

BEGIN
	
	-- Invert A.
	with Ainvert select
		Ai <= A when '0', NOT A when '1';
	
	-- Invert B.
	with Binvert select
		Bi <= B when '0', NOT B when '1';

	PROCESS(s) IS
	BEGIN
			case s is
				when "00"=>f<=Ai AND Bi; 
				when "01"=>f<=Ai OR Bi; 
				when "10"=>	f <=(Ai AND (NOT Bi) AND (NOT carryIN)) OR ((NOT Ai) AND Bi AND (NOT carryIN)) OR ((NOT Ai) AND (NOT Bi) AND carryIN) OR (Ai AND Bi AND carryIN); 
				when "11"=>f<=Ai XOR Bi; 
			end case;
	END PROCESS;
	
	carryOUT <= (Ai AND carryIN) OR (Bi AND carryIN) OR (Ai AND Bi);
END Behavioral;

LIBRARY ieee;
USE ieee.std_logic_1164.all;
use work.one_bit_pack.all;

ENTITY meros_deytero IS
	
	PORT(CTRL : IN STD_logic_vector(2 DOWNTO 0);
			A,B : IN std_logic_vector(15 DOWNTO 0);
			F : OUT std_logic_vector(15 DOWNTO 0);
			overflow: OUT std_logic);
	
END meros_deytero;


ARCHITECTURE Structural OF meros_deytero IS

signal c : std_logic_vector(1 TO 15); 
signal carryIN,Ainvert,Binvert,carryOUT : std_logic;
signal S : std_logic_vector(1 DOWNTO 0);

BEGIN
	PROCESS(CTRL) IS
	BEGIN
		CASE CTRL IS
			WHEN "000"=> S<="00"; Ainvert<='0';  Binvert<='0'; carryIN<='0'; -- AND
			WHEN "001"=> S<="01"; Ainvert<='0';  Binvert<='0'; carryIN<='0'; -- OR
			WHEN "010"=> S<="10"; Ainvert<='0';  Binvert<='0'; carryIN<='0'; -- ADD
			WHEN "011"=> S<="10"; Ainvert<='0';  Binvert<='1'; carryIN<='1'; -- SUB
			WHEN "100"=> S<="00"; Ainvert<='1';  Binvert<='1'; carryIN<='0'; -- NOR
			WHEN "101"=> S<="01"; Ainvert<='1';  Binvert<='1'; carryIN<='0'; -- NAND
			WHEN "110"=> S<="11"; Ainvert<='0';  Binvert<='0'; carryIN<='0'; -- XOR
			WHEN OTHERS=> NULL;
		END CASE;
	END PROCESS;


	U1: one_bit port map (A(0),B(0),carryIN, Ainvert, Binvert, F(0), c(1), S);
	U2: one_bit port map (A(1),B(1),c(1), Ainvert, Binvert, F(1), c(2), S);
	U3: one_bit port map (A(2),B(2),c(2), Ainvert, Binvert, F(2), c(3), S);
	U4: one_bit port map (A(3),B(3),c(3), Ainvert, Binvert, F(3), c(4), S);
	U5: one_bit port map (A(4),B(4),c(4), Ainvert, Binvert, F(4), c(5), S);
	U6: one_bit port map (A(5),B(5),c(5), Ainvert, Binvert, F(5), c(6), S);
	U7: one_bit port map (A(6),B(6),c(6), Ainvert, Binvert, F(6), c(7), S);
	U8: one_bit port map (A(7),B(7),c(7), Ainvert, Binvert, F(7), c(8), S);
	U9: one_bit port map (A(8),B(8),c(8), Ainvert, Binvert, F(8), c(9), S);
	U10: one_bit port map (A(9),B(9),c(9), Ainvert, Binvert, F(9), c(10), S);
	U11: one_bit port map (A(10),B(10),c(10), Ainvert, Binvert, F(10), c(11), S);
	U12: one_bit port map (A(11),B(11),c(11), Ainvert, Binvert, F(11), c(12), S);
	U13: one_bit port map (A(12),B(12),c(12), Ainvert, Binvert, F(12), c(13), S);
	U14: one_bit port map (A(13),B(13),c(13), Ainvert, Binvert, F(13), c(14), S);
	U15: one_bit port map (A(14),B(14),c(14), Ainvert, Binvert, F(14), c(15), S);
	U16: one_bit port map (A(15),B(15),c(15), Ainvert, Binvert, F(15), carryOUT, S);
	
	PROCESS(c(15), carryOUT) IS
	BEGIN
		overflow <= c(15) XOR carryOUT;
	END PROCESS;
	
END Structural;