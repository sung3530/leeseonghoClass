#include "LowerOneDown.h"

void LowerOneDown::lowerOneDown(char** map,int i){
	int x = zeroSpace[i][0];
	int y = zeroSpace[i][1];
	while (y != 0){
		map[y][x] = map[y - 1][x];
		y--;
	}
	if (y == 0){
		map[0][x] = test->randG.randomShape();
	}
}
void LowerOneDown::resetZeroSpace(){
	for (int i = 0; i < 9; i++)
	{
		zeroSpace[i][0] = -1;
		zeroSpace[i][1] = -1;
	}
}
void LowerOneDown::lowerOneDownCheck(){
	test = AniPangMap::CreateInstance();
	char** map = test->getMap();
	int breakNumber;
	while (1){
		breakNumber = 0;
		this->resetZeroSpace();//zeroSpace 초기화 널로

		for (int i = 80; i >= 0; i--) // 각 x열마다 젤 위의 빈공간 좌표 zerospace에 넣기
		{
			if (map[i / 9][i % 9] == ' '){
				zeroSpace[i % 9][0] = i % 9;//x좌표
				zeroSpace[i % 9][1] = i / 9;
			}
		}

		for (int i = 0; i < 9; i++)// zerospace가 모두 널이면 while문 나가기
		{
			if (zeroSpace[i][0] == -1){
				breakNumber++;
			}
			if (breakNumber == 9)
				return;
		}
	
		
		for (int i = 0; i < 9; i++) //좌표 들어가있는 zerospace는 한칸 밑으로 내리기
		{
			if (zeroSpace[i][0] != -1){
				this->lowerOneDown(map, i);
			}
		}
		printMap.printMap();
	}
}

