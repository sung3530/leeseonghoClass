#include <iostream>
#include <stdio.h>
#include <stdlib.h>
#include "Random.h"
class AnyPang{
private:
	char **map;
	static AnyPang AniPang;
	Random randG;
public:
	AnyPang();
	char** getMap();
	static AnyPang getIngeist();
	void firstSetting();

};