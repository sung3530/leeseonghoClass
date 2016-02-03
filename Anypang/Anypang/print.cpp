#include "print.h"
#include "AniPangMap.h"
void print::setSettingMap(){
	gotoxy(18, 3);
	cout << "ÀÌ¼ºÈ£ ÀÛÇ°ÀÌ´Ù!!! Ä¼Ä¼Ä¼Ä¼Ä¼Ä¼Ä¼Ä¼";
	gotoxy(18, 8);
	cout << " x 0 1 2 3 4 5 6 7 8";
	gotoxy(18, 9);
	cout << "y¡á¡á¡á¡á¡á¡á¡á¡á¡á¡á¡á\n";
	gotoxy(18, 10);
	cout << "0¡á                  ¡á\n";
	gotoxy(18, 11);
	cout << "1¡á                  ¡á\n";
	gotoxy(18, 12);
	cout << "2¡á                  ¡á\n";
	gotoxy(18, 13);
	cout << "3¡á                  ¡á\n";
	gotoxy(18, 14);
	cout << "4¡á                  ¡á\n";
	gotoxy(18, 15);
	cout << "5¡á                  ¡á\n";
	gotoxy(18, 16);
	cout << "6¡á                  ¡á\n";
	gotoxy(18, 17);
	cout << "7¡á                  ¡á\n";
	gotoxy(18, 18);
	cout << "8¡á                  ¡á\n";
	gotoxy(19, 19);
	cout << "¡á¡á¡á¡á¡á¡á¡á¡á¡á¡á¡á\n";
}

void print::resetMap(){
	Sleep(1000);
	this->removeCursor();
	system("cls");
	setSettingMap();
	AniPangMap *test = AniPangMap::CreateInstance();
	char** map =test->getMap();

	for (int i = 0; i < 9; i++)
	{
		for (int j = 0; j < 9; j++)
		{
			gotoxy(21+2*i, 10+j);
			cout << map[j][i];
		}
		cout << "\n";
	}
	gotoxy(19,21);
}
void print::printMap(){
	Sleep(1000);
	this->removeCursor();
	AniPangMap *test = AniPangMap::CreateInstance();
	char** map = test->getMap();

	for (int i = 0; i < 9; i++)
	{
		for (int j = 0; j < 9; j++)
		{
			gotoxy(21 + 2 * i, 10 + j);
			cout << map[j][i];
		}
		cout << "\n";
	}
	gotoxy(19, 21);
}