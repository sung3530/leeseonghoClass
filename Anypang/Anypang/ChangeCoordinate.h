#include "AniPangMap.h"
#include "Pang.h"
#include "print.h"
class ChangeCoordinate{
private : 
	AniPangMap *aniPangMap = AniPangMap::CreateInstance();
	Pang pang;
	print printMap;
	char** map;
	char** mapTemp;
	int firstCoordinate[2];
	int secondCoordinate[2];

	bool pangBl;
	bool coordinateBl;
	char charTemp;
private :
	void setTempMap();
	bool checkCoordinate(int first[2], int second[2]);
public :
	void changeCoordinate();

};