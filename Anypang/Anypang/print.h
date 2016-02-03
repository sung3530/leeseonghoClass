#ifndef print_h
#define print_h

#include <stdlib.h>
#include <stdio.h>
#include <iostream>
#include <windows.h>
#include <conio.h>
#include <time.h>
using namespace std;

class print
{
private :
	void removeCursor() // Ä¿¼­ ±ôºýÀÓ Á¦°Å
	{
		CONSOLE_CURSOR_INFO cur;
		GetConsoleCursorInfo(GetStdHandle(STD_OUTPUT_HANDLE), &cur);
		cur.bVisible = 0;
		SetConsoleCursorInfo(GetStdHandle(STD_OUTPUT_HANDLE), &cur);
	}
	
public :
	void gotoxy(int x, int y){
		COORD Pos = { x, y };
		SetConsoleCursorPosition(GetStdHandle(STD_OUTPUT_HANDLE), Pos);
	}
	void printMap();
	void resetMap();
	void setSettingMap();
	
};
#endif