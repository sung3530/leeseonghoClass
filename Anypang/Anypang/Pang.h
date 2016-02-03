#ifndef Pang_h
#define Pang_h
#include "AniPangMap.h"

class Pang{
private : 
	int stack[2][200];
	int order = 0;
	AniPangMap *test = AniPangMap::CreateInstance();
	char** map;
private :
	void push(int x, int y);
	int xPop();
	int yPop();
public : 
	void pang();
	bool pangCheck();
};
#endif