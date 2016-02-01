#include "AnyPang.h"

using namespace std;
AnyPang::AnyPang(){
	map = new char*[9];
}

void AnyPang::firstSetting(){
	srand((unsigned)time(NULL));
	for (int i = 0; i < 81; i++)
	{
		map[i / 9][i % 9] = randG.randomShape();
	}
	
}

AnyPang AnyPang::getIngeist(){
	return AniPang;
}

char** AnyPang::getMap(){
	return map;
}