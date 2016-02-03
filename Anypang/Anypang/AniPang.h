#include "AniPangMap.h"
#include "print.h"
#include "Pang.h"
#include "LowerOneDown.h"
#include "ChangeCoordinate.h"
class AniPang{
private :
	AniPangMap *aniPangMap = AniPangMap::CreateInstance();
	print printMap;
	Pang pang;
	LowerOneDown lowerOneDown;
	bool pangCheckBl;
	ChangeCoordinate changeCoordinate;
public :
	void gameSetting();
	void gamePlaying();
	void pangPlaying();

};