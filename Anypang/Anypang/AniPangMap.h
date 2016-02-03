#ifndef AniPangMap_h
#define AniPangMap_h

#include <iostream>
#include <stdio.h>
#include <stdlib.h>
#include "Random.h"
class AniPangMap{
private:
	char** map;
	static AniPangMap* AniPangMap::aniPangMap;
	
	AniPangMap();

public:
	char** getMap();
	void setMap(char** map);
	Random randG;
	static AniPangMap *CreateInstance();
	static void DestroyInstace();
	void firstMapSetting();
};
#endif