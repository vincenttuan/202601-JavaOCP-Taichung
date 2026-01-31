package day2;

public class ScoreDemo3 {

	public static void main(String[] args) {
		// 利用陣列來儲存 5 個學生物件
		Student[] students = {
				new Student("John", 95),
				new Student("Mary", 50),
				new Student("Alen", 83),
				new Student("Jack", 40),
				new Student("Rose", 60)
		};
		
		// 利用 for 迴圈印出每一個學生資料
		for(int i=0;i<students.length;i++) {
			students[i].printScore();
		}

	}

}
