package co.yedam.mypj.student.service;

import lombok.Data;

@Data
public class StudentVO {
	private String studentName;
	private String studentAge;
	private String studentBirth;
	private String studentNumber;
	
	public String toString() {
		System.out.print(studentName + " : ");
		System.out.print(studentAge + "세 : ");
		System.out.print(studentBirth + " : ");
		System.out.println(studentNumber + "학번");
		return null;
	}
}