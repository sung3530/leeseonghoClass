#include "Pang.h"
#include "AniPangMap.h"

using namespace std;
void Pang::push(int x, int y){
	stack[0][order] = x;
	stack[1][order] = y;
	order++;
}
int Pang::xPop(){
	order--;
	return stack[0][order];
}
int Pang::yPop(){
	return stack[1][order];
}

void Pang::pang(){
	map = test->getMap();
	for (int i = 0; i < 9; i++)
	{
		for (int j = 0; j < 7; j++)
		{
			if (map[i][j] == map[i][j + 1] && map[i][j + 1] == map[i][j + 2]){
				push(i, j);
				push(i, j + 1);
				push(i, j + 2);
			}
		}
	}
	for (int i = 0; i < 9; i++)
	{
		for (int j = 0; j < 7; j++)
		{
			if (map[j][i] == map[j + 1][i] && map[j + 1][i] == map[j + 2][i]){
				push(j, i);
				push(j + 1, i);
				push(j + 2, i);
			}
		}
	}
	while (order!=0){
		map[xPop()][yPop()] = ' ';
	}
}
bool Pang::pangCheck(){
	map = test->getMap();
	for (int i = 0; i < 81; i++)
	{
		if (map[i / 9][i % 9] == ' ')
			return true;
	}
	return false;
}