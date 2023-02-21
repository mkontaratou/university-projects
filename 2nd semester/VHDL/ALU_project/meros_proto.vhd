LIBRARY ieee;
USE ieee.std_logic_1164.all;

PACKAGE one_bit_package IS

	COMPONENT one_bit
	
		PORT( A,B, carryIN: IN std_logic;
					Ainvert,Binvert: IN std_logic;
					F, carryOUT: OUT STD_logic;
					s: IN STD_logic_vector(1 DOWNTO 0));
	
	END COMPONENT;

END PACKAGE one_bit_package;

LIBRARY ieee;
USE ieee.std_logic_1164.all;

ENTITY meros_proto IS
	
	PORT(A,B, carryIN: IN STD_logic; Ainvert,Binvert: IN std_logic; F, carryOUT : OUT STD_logic; s: IN STD_logic_vector(1 DOWNTO 0)); 
END meros_proto;

ARCHITECTURE Behavioral OF meros_proto IS

signal Ai,Bi: std_logic;

BEGIN
	with Ainvert select
		Ai <= A when '0', NOT A when '1';
	with Binvert select
		Bi <= B when '0', NOT B when '1';

	PROCESS(s) IS
	BEGIN
			case s is
				when "00"=>F<=Ai AND Bi; 
				when "01"=>F<=Ai OR Bi; 
				when "10"=>	F <=(Ai AND (NOT Bi) AND (NOT carryIN)) OR ((NOT Ai) AND Bi AND (NOT carryIN)) OR ((NOT Ai) AND (NOT Bi) AND carryIN) OR (Ai AND Bi AND carryIN); 
				when "11"=>F<=Ai XOR Bi; 
			end case;
	END PROCESS;
	carryOUT <= (Ai AND carryIN) OR (Bi AND carryIN) OR (Ai AND Bi);
END Behavioral;
