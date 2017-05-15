package com.nadan.java.drawsnail;

//����� ������ ��Ȳ�� ���α׷����ϰ�, ������ �ڵ��� �ؾ� �� �� ���� ���� ������ �ϰ� ���� �ൿ�� �ؾ� �ϴ°�
//1. ���� ���ϰ� �ִ°�?=���� ó������� �ϴ°�?=� ���� ���� �̿��� �� �ִ°�?
//2. �̰͵��� � �ں��� ������ ���ϰ� �ִ°�?=������ ������ �ٿ��� �� ������?=� ��Ģ�ΰ�?
//3. ���� �̰͵��� � �޼ҵ�, � ������ �̿��� �ٿ�����?
//4. 1,2,3�� �������ٸ� ���� �ʿ信 ���� �ϳ��� �ʿ��� ���� �߰��� ������.

public class DrawSnail {
	
	final static int UP = 0;
	final static int RIGHT = 1;
	final static int DOWN = 2;
	final static int LEFT = 3;
	
	public static int[][] drawSnail(int count){
		
		int[][] array = new int[count][count]; //2�� �迭�� ��ǥ ����
		int direction = UP;  //����
		int size = count;  //�� �� �� �� �� �ݺ��ؾ� �ϴ°�
		int x=-1, y=0;  //��ǥ��
		int number = 1; //�� ��ǥ�� �־��� ��
		
		while(size > 0){
			for(int i=0; i < size; i++){
				switch(direction){
					case UP: x++; break; //x�� ó�� ������ 0�� ����, ���������� 2�� ��������
					case RIGHT: y++; break; //y�� ó�� ������ 1�� ����, ���������� 2�� ��������
					case DOWN: x--; break; //x,y�� (2,2)�� �����ϰ�, x�� ó�� ������ 1�� �۾��� ���� ����.
					case LEFT: y--; break; //x,y�� (2,0)�� �����ϰ�, y�� ó�� ������ 1�� �۾��� ���� ����.
				}
				array[y][x] = number; //���õ� ��ǥ�� number���� �־��ش�
				number++; //��ǥ�� ���� �־��� �Ŀ��� 1�� ������Ų��
			}
			//for���� ���������� �� ���� ���� ���̹Ƿ� ���� �������� �Ѱ��ش�
			direction++;
			//�ٸ� ������, ������ ��� ������ �ٲ�� �־��ִ� ���� �ϳ��� �پ���, size�� ó�����ش�.
			if(direction == RIGHT || direction == LEFT) size--;
			//�� ���� �� ���� �ٽ� ó������ ���ư��� �Ѵ�.
			if(direction > 3) direction = UP;
		}
		
		return array;
	}
	
	//������ ������� ������ִ� �޼ҵ�
	public static void printSnail(int[][] array){
		int length = array.length;
		//������
		for(int i=0; i<length; i++){
			//�����ٿ� ������ ���
			for(int j=0; j<length; j++){
				System.out.print(array[i][j]+" ");
			}
		}
	}
	
	
}
