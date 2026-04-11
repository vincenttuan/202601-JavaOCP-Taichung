package day9.entity;

public class Student {
	private String name; // 姓名
	private Integer score; // 入學成績
	private Integer sex; // 性別
	private Integer age; // 年齡
	
	public Student() {
		
	}
	
	public Student(String name, Integer score, Integer sex, Integer age) {
		this.name = name;
		this.score = score;
		this.sex = sex;
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getScore() {
		return score;
	}

	public void setScore(Integer score) {
		this.score = score;
	}

	public Integer getSex() {
		return sex;
	}

	public void setSex(Integer sex) {
		this.sex = sex;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}
	
	
}
