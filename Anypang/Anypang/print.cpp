#include "print.h"
#include "AniPangMap.h"
void print::setSettingMap(){
	gotoxy(18, 3);
	cout << "�̼�ȣ ��ǰ�̴�!!! ļļļļļļļļ";
	gotoxy(18, 8);
	cout << " x 0 1 2 3 4 5 6 7 8";
	gotoxy(18, 9);
	cout << "y������������\n";
	gotoxy(18, 10);
	cout << "0��                  ��\n";
	gotoxy(18, 11);
	cout << "1��                  ��\n";
	gotoxy(18, 12);
	cout << "2��                  ��\n";
	gotoxy(18, 13);
	cout << "3��                  ��\n";
	gotoxy(18, 14);
	cout << "4��                  ��\n";
	gotoxy(18, 15);
	cout << "5��                  ��\n";
	gotoxy(18, 16);
	cout << "6��                  ��\n";
	gotoxy(18, 17);
	cout << "7��                  ��\n";
	gotoxy(18, 18);
	cout << "8��                  ��\n";
	gotoxy(19, 19);
	cout << "������������\n";
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