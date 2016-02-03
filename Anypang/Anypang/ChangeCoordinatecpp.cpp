#include "ChangeCoordinate.h"

using namespace std;
void ChangeCoordinate::setTempMap(){
	mapTemp = new char*[9];
	for (int i = 0; i < 9; i++)
	{
		mapTemp[i] = new char[9];
	}
	for (int i = 0; i < 81; i++)
	{
		mapTemp[i / 9][i % 9] = map[i / 9][i % 9];
	}
}
bool ChangeCoordinate::checkCoordinate(int first[2], int second[2]){
	if (first[0] == second[0] - 1 && first[1] == second[1])
		return true;
	if (first[0] == second[0] + 1 && first[1] == second[1])
		return true;
	if (first[1] == second[1] - 1 && first[0] == second[0])
		return true;
	if (first[1] == second[1] + 1 && first[0] == second[0])
		return true;
	if (first[0] == second[0] && first[1] == second[1])
		return false;

	return false;
}
void ChangeCoordinate::changeCoordinate(){
	while (true){
		map = aniPangMap->getMap();
		setTempMap();
		printMap.resetMap();
		cout << "put in first coorDinate ( x , y ) , 0<x , y<8 : ";
		cin >> firstCoordinate[0];//xÁÂÇ¥
		cin >> firstCoordinate[1];
		printMap.gotoxy(19, 22);
		cout << "put in second coorDinate( x , y ) , 0<x , y<8 : ";
		cin >> secondCoordinate[0];
		cin >> secondCoordinate[1];

		coordinateBl = checkCoordinate(firstCoordinate, secondCoordinate);
		if (coordinateBl == true){
			if (firstCoordinate[0] >= 0 && firstCoordinate[0] < 9 && firstCoordinate[1] >= 0 && firstCoordinate[1] < 9){
				if (secondCoordinate[0] >= 0 && secondCoordinate[0] < 9 && secondCoordinate[1] >= 0 && secondCoordinate[1] < 9){
					charTemp = map[firstCoordinate[1]][firstCoordinate[0]];
					map[firstCoordinate[1]][firstCoordinate[0]] = map[secondCoordinate[1]][secondCoordinate[0]];
					map[secondCoordinate[1]][secondCoordinate[0]] = charTemp;
					printMap.printMap();
				}
			}
			pang.pang();
			pangBl = pang.pangCheck();
			if (pangBl == true)
				break;
			else{
				aniPangMap->setMap(mapTemp);
				printMap.gotoxy(19, 23);
				cout << "No Pang\n";
				printMap.gotoxy(43, 9);
				cout << "ÅÍÁú°ÍÀÌ ¾øÂÇ¿ë";
				Sleep(1000);
				printMap.resetMap();
				continue;
			}
		}
		else{
			printMap.gotoxy(19, 23);
			cout << "two Coordinate is not next position \n";
			Sleep(1000);
		}
	}
}

