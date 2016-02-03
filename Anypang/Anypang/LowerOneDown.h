#include <windows.h>
#include "AniPangMap.h"
#include "print.h"
class LowerOneDown{
private : 
	int zeroSpace[9][2];
	AniPangMap *test;
	print printMap;
private :
	void lowerOneDown(char** map,int i);
	void resetZeroSpace();
public :
	void lowerOneDownCheck();


};