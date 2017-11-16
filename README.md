# DrawSnail

- 복잡한 상황에서 어떤 논리 과정을 거쳐야 하는지 그 과정을 볼 수 있다
- 다중 배열 활용의 이해
### 생각의 흐름
- 무엇이 변하고 있는가? 무엇을 처리해줘야 하는가? 어떤 값을 내가 이용할 수 있는가?
- 이것들이 어떤 반복과 패턴을 취하고 있는가? 무엇을 간단히 줄여볼 수 있을까? 어떤 규칙인가?
- 이제 이것들을 어떤 메소드, 어떤 도구를 이용해 줄일 수 있는가?
- 1,2,3이 정해졌다면 이제 필요에 따라 하나씩 필요한 것을 추가해 나간다.

### DrawSnail

```java
public static int[][] drawSnail(int count) {

  int[][] array = new int[count][count]; //2중 배열로 좌표 저장
  int direction = UP;  //방향
  int size = count;  //한 줄 당 몇 번 반복해야 하는가
  int x=-1, y=0;  //좌표값
  int number = 1; //각 좌표에 넣어줄 값
  
  while(size > 0){
    for(int i=0; i < size; i++){
      switch(direction){
        case UP: x++; break; //x가 처음 값으로 0이 들어가고, 최종적으로 2가 내려간다
        case RIGHT: y++; break; //y가 처음 값으로 1이 들어가고, 최종적으로 2가 내려간다
        case DOWN: x--; break; //x,y가 (2,2)로 시작하고, x가 처음 값으로 1씩 작아진 값이 들어간다.
        case LEFT: y--; break; //x,y가 (2,0)로 시작하고, y가 처음 값으로 1씩 작아진 값이 들어간다.
      }
      array[y][x] = number; //선택된 좌표에 number값을 넣어준다
      number++; //좌표에 값을 넣어준 후에는 1을 증가시킨다
    }
    //for문을 빠졍나오면 한 줄이 끝난 것이므로 다음 방향으로 넘겨준다
    direction++;
    //다만 오른쪽, 왼쪽의 경우 방향이 바뀌면 넣어주는 값이 하나씩 줄어들고, size로 처리해준다.
    if(direction == RIGHT || direction == LEFT) size--;
    //한 바퀴 다 돌면 다시 처음으로 돌아가야 한다.
    if(direction > 3) direction = UP;
  }

  return array;
}
```

### 출력

```java
//달팽이 모양으로 출력해주는 메소드
public static void printSnail(int[][] array){
  int length = array.length;
  //가로줄
  for(int i=0; i<length; i++){
    //가로줄에 세로줄 출력
    for(int j=0; j<length; j++){
      System.out.print(array[i][j]+" ");
    }
  }
}
```
