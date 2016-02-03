#include "AniPang.h"

void AniPang::gameSetting(){
	this->aniPangMap->firstMapSetting();
}
void AniPang::pangPlaying(){
	while (true)
	{
		pang.pang();
		printMap.printMap();
		pangCheckBl = pang.pangCheck();
		if (pangCheckBl == true)
			lowerOneDown.lowerOneDownCheck();
		else
			break;
	}
}
void AniPang::gamePlaying(){
	this->gameSetting();
	printMap.setSettingMap();
	while (true){
		printMap.printMap();
		this->pangPlaying();

		changeCoordinate.changeCoordinate();

	}
}

