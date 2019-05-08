package twoD.array;

import java.util.Scanner;

public class TwoDArray {
	public static final Scanner CONSOLE = new Scanner(System.in);
	public void test1() {
		int[][] arr = new int[15][11];
		for(int i =0; i<arr.length; i++) {
			for(int j=0; j<arr[i].length; j++) {
				arr[i][j] = i*arr[i].length + j;
				System.out.print(arr[i][j]+1 + " ");
			}
			System.out.println();
		}
	}
	
	public void test2() {
		String[][] students = {{"홍길동", "장보고"},
					{"이순신", "이태백"},
					{"유관순", "김정희"},
					{"윤봉길", "대조영"},
					{"장영실", "김유신"},
					{"임꺽정", "이사부"},
				};
//		String[] students= {"홍길동","이순신","유관순","윤봉길"
//				,"장영실","임걱정","장보고","이태백","김정희",
//				"대조영","김유신","이사부"};
		int index = 0;

		String[][] arr1 = new String[students.length/2][2];
		String[][] arr2 = new String[students.length/2][2];
		
		for(int i=0; i<arr1.length; i++) {
			for(int j=0; j<arr1[i].length; j++) {
				arr1[i][j] = students[index][0];
				arr2[i][j] = students[index++][1];
			}
		}
		
		System.out.println("=== 1분단 ===");
		for(int i =0;i<arr1.length; i++) {
			for(int j=0;j<arr1[i].length; j++)
				System.out.print(arr1[i][j] + " ");
			System.out.println();
		}

		System.out.println("=== 2분단 ===");
		for(int i =0;i<arr2.length; i++) {
			for(int j=0;j<arr2[i].length; j++)
				System.out.print(arr2[i][j] + " ");
			System.out.println();
		}
		
		System.out.print("=============================\n"
				+ "검색할 학생 이름을 입력하세요: ");
		String name = CONSOLE.nextLine();
		
		int bundan = 0;
		int row = 0, col = 0; //위치

		for(int i =0;i<arr1.length; i++) {
			for(int j=0;j<arr1[i].length; j++) {
				if(arr1[i][j].equals(name)) {
					bundan = 1;
					row = i;
					col = j;
				}
			}
		}
		
		if(bundan !=0) return;
		for(int i =0;i<arr2.length; i++) {
			for(int j=0;j<arr2[i].length; j++) {
				if(arr2[i][j].equals(name)) {
					bundan = 2;
					row = i;
					col = j;
				}
			}
		}
		if(bundan == 0)
			System.out.println("검색 하신 학생은 없습니다!");

		System.out.println("\n검색하신 " + name + " 학생은 " + bundan +"분단\n"
				+ (row+1)+"번째 줄, " +(col+1) +"번째 칸에 있습니다.");
	}
	
	public void test3() {
		System.out.print("가로 행의 수를 입력 : ");
		int row = CONSOLE.nextInt();
		System.out.print("세로 열의 수를 입력 : ");
		int col = CONSOLE.nextInt();
		
		char[][] arr = new char[row][col];
		char ch = '\u0000';

		for(int i=0; i<row; i++) {
			for(int j=0; j<col; j++) {
				ch = (char)(65 + (int)(Math.random()*26));
				arr[i][j] = ch;
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
	}
	
	public void test4() {
		System.out.println("================== A반 성적표 ==================");
		System.out.println("이름\t국어\t영어\t수학\t합계\t평균");
		System.out.println("---------------------------------------------");
		int[][] scores = {{80,90,77},
				{78,97,86},
				{71,68,88}, };
		String[] names = {"홍길동", "이순신", "유관순"};
		int sum = 0;
		int korSum = 0, engSum = 0, mathSum = 0;
		double avg = 0, avgSum = 0;
		
		for(int i=0; i<scores.length; i++) {
			sum = 0; avg =0;
			korSum +=scores[i][0];
			engSum +=scores[i][1];
			mathSum +=scores[i][2];
			System.out.print(names[i] + "\t");
			for(int j=0; j<scores[i].length; j++) {
				System.out.print(scores[i][j] + "\t");
				sum +=scores[i][j];
			}
			avg = sum /3.0;
			avgSum += avg;
			System.out.print(sum + "\t");
			System.out.printf("%.1f\n", avg);
		}
		System.out.println("---------------------------------------------");
		sum = korSum + engSum + mathSum;
		System.out.printf("합계\t%d\t%d\t%d\t%d\t%.1f\n", 
				korSum, engSum, mathSum, sum, (avgSum/3.0));
	}
	
	//가변형
	public void test5() {
		String[][] animals = new String[3][];
		animals[0] = new String[2];
		animals[1] = new String[3];
		animals[2] = new String[1];
		
		String animal = "";
		for(int i =0; i<animals.length; i++) {
			switch(i) {
			case 0: animal = "포유류"; break;
			case 1: animal = "조류"; break;
			case 2: animal = "파충류"; break;
			}

			for(int j=0; j<animals[i].length; j++) {
				System.out.print(animal + animals[i].length +"가지 입력 " +(j+1) +"번째 : ");
				animals[i][j] = CONSOLE.nextLine();
			}
		}
		
		System.out.print("출력을 원하는 동물(0.포유류 1.조류 2.파충류): ");
		int choice = CONSOLE.nextInt();

		for(int i =0; i<animals.length; i++) {
			if(i==choice) {
				System.out.print("animals["+i+"] = {");
				for(int j=0; j<animals[i].length; j++) {
					System.out.print(animals[i][j]);
					if(j != animals[i].length - 1)
						System.out.print(", ");
				}
				System.out.println("}");
			}
		}
	}
	
	public void test6() {
		System.out.print("아침 식단(음식은 공백으로 구분해 주세요) : ");
		String morning = CONSOLE.nextLine();
		System.out.print("점심 식단(음식은 공백으로 구분해 주세요) : ");
		String noon = CONSOLE.nextLine();
		System.out.print("저녁 식단(음식은 공백으로 구분해 주세요) : ");
		String dinner = CONSOLE.nextLine();


		String[][] diet = new String[3][];
		diet[0] = morning.split(" ");
		diet[1] = noon.split(" ");
		diet[2] = dinner.split(" ");

		for(int i =0 ;i<diet.length; i++) {
			switch(i) {
			case 0: System.out.println("=== 아침 식단 ==="); break;
			case 1: System.out.println("=== 점심 식단 ==="); break;
			case 2: System.out.println("=== 저녁 식단 ==="); break;
			}
			for(int j=0; j<diet[i].length; j++)
				System.out.print(diet[i][j]+ " ");
			System.out.println();
		}
	}
	
	public void test7() {
		System.out.print("좋아하는 색깔을 입력하세요.(단어사이는 공백으로 구분) => ");
		String[] colors = CONSOLE.nextLine().split(" ");
		String[][] data = new String[colors.length][]; 

		int index = 0;

		for(String col : colors) {
			System.out.printf("%s 사물을 나열해보세요.(단어사이는 공백으로 구분) => ", col);
			data[index++] = CONSOLE.nextLine().split(" ");
		}
		
		int choice = 0;
		do {
			System.out.println("당신이 좋아하는 색깔을 선택하세요.(종료하려면 0 입력)");
			for(int i =0; i<data.length; i++)
				System.out.print((i+1) +". " + colors[i] + " ");
			System.out.print("\n=> ");
			choice = CONSOLE.nextInt();
			if(choice == 0) {
				System.out.println("프로그램을 종료합니다...");
				break;
			}

			for(int i =0 ;i<data[choice-1].length; i++) {
				System.out.print(data[choice-1][i] + " ");
			}
			System.out.println();
		} while(choice != 0);
	}
}
