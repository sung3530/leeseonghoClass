#include "Random.h"
using namespace std;
char Random::randomShape(){
	random = rand() % 4;
	switch (random)
	{
	case 0 :
		shape = '#';
		break;
	case 1 :
		shape = '@';
		break;
	case 2 :
		shape = '$';
		break;
	case 3 :
		shape = '%';
		break;
	}
	return shape;
}