#include "AniPangMap.h"

using namespace std;

AniPangMap* AniPangMap::aniPangMap;

void AniPangMap::firstMapSetting(){
	srand((unsigned)time(NULL));
	map = new char*[9];
	for (int i = 0; i < 9; i++)
	{
		map[i] = new char[9];
	}
	for (int i = 0; i < 81; i++)
	{
		map[i / 9][i % 9] = randG.randomShape();
	}
}

AniPangMap* AniPangMap::CreateInstance(){
	if (aniPangMap == NULL)
		aniPangMap = new AniPangMap();
	return aniPangMap;
}

char** AniPangMap::getMap(){
	
	return map;
}

void AniPangMap::DestroyInstace(){
	delete aniPangMap;
}
void AniPangMap::setMap(char** map){
	this->map = map;
}
AniPangMap::AniPangMap(){

}