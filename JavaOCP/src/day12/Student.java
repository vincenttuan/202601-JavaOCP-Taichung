package day12;

public class Student {
	String name;
	Integer score;
	
	public Student(String name, Integer score) {
		this.name = name;
		this.score = score;
	}

	@Override
	public String toString() {
		return "Student [name=" + name + ", score=" + score + "]";
	}
	
}
