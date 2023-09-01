package co.yedam.mypj.student.menu;

import java.util.List;
import java.util.Scanner;

import co.yedam.mypj.student.service.StudentService;
import co.yedam.mypj.student.service.StudentVO;
import co.yedam.mypj.student.serviceImpl.StudentServiceImpl;

public class StudentManager {
	private Scanner sc = new Scanner(System.in);
	private StudentService dao = new StudentServiceImpl();
	String name;
	
	private void studentTitle() {
		System.out.println("======================");
		System.out.println("    학생 정보 조회 시스템  ");
		System.out.println("======================");
		System.out.println("     1. 학 생 추 가");
		System.out.println("    2. 전체 학생 조회");
		System.out.println("    3. 특정 학생 조회");
		System.out.println("    4. 학생 정보 수정");
		System.out.println("     5. 학 생 삭 제");
		System.out.println("  6. 상위 메뉴로 돌아가기");
		System.out.println("----------------------");
		System.out.println("원하는 작업을 선택 하세요..");
	}

	public void run() {
		boolean r = false;
		do {
			studentTitle();
			int key = sc.nextInt();
			sc.nextLine();
			switch (key) {
			case 1:
				studentInsert();
				break;
			case 2:
				studentSelectList();
				break;
			case 3:
				studentSelect();
				break;
			case 4:
				studentUpdate();
				break;
			case 5:
				studentDelete();
				break;
			case 6:
				r = true;
				System.out.println("상위 메뉴로 이동합니다..");
				break;
			}
		} while (!r);
	}

	private void studentSelectList() { // 학생 전체 목록
		List<StudentVO> students = dao.studentSelectList();
		System.out.println("----------------------");
		System.out.println("     학  생  목  록");
		System.out.println("----------------------");

		for (StudentVO s : students) {
			System.out.print(s.getStudentName() + " : ");
			System.out.print(s.getStudentAge() + "세 : ");
			System.out.print(s.getStudentBirth() + " : ");
			System.out.println(s.getStudentNumber() + "학번");
		}
	}
	
	private void studentSelect() { // 선택 학생 조회
		StudentVO vo = new StudentVO();
		
		System.out.println("조회할 학생의 이름을 입력하세요.");
		vo.setStudentName(sc.nextLine());
		
		System.out.println("----------------------");
		System.out.println("     학  생  목  록");
		System.out.println("----------------------");
		vo = dao.studentSelect(vo);
		
		if (vo != null) {
			vo.toString();
		} else {
			System.out.println("학생 정보가 존재하지 않습니다.");
		}
		
	}

	private void studentInsert() { // 등록하기
		StudentVO vo = new StudentVO();
		System.out.println("----------------------");
		System.out.println("     등  록  하  기");
		System.out.println("----------------------");
		System.out.println("등록할 학생 이름 :");
		vo.setStudentName(sc.nextLine());
		System.out.println("학생의 나이 :");
		vo.setStudentAge(sc.nextLine());
		System.out.println("학생의 생일 :");
		vo.setStudentBirth(sc.nextLine());
		System.out.println("학생의 학번 :");
		vo.setStudentNumber(sc.nextLine());

		int n = dao.studentInsert(vo);

		if (n != 0) {
			System.out.println("학생 정보를 등록했습니다!");
		} else {
			System.out.println("학생 정보 등록을 실패했습니다.");
		}

	}


	private void studentUpdate() {
		StudentVO vo = new StudentVO();
		System.out.println("수정할 학생의 이름을 입력하세요.");
		vo.setStudentName(sc.nextLine());
	
		System.out.println("학생의 나이를 입력하세요.");
		vo.setStudentAge(sc.nextLine());
		System.out.println("학생의 생년월일을 입력하세요.");
		vo.setStudentBirth(sc.nextLine());
		System.out.println("학생의 학번을 입력하세요.");
		vo.setStudentNumber(sc.nextLine());
		
		int x = dao.studentUpdate(vo);
		if (x != 0) {
			System.out.println("학생 정보 수정이 완료되었습니다!");
		} else {
			System.out.println("학생 정보 수정을 실패했습니다.");
		}
	}

	private void studentDelete() {
		StudentVO vo = new StudentVO();
		System.out.println("삭제할 학생의 이름을 입력하세요.");
		vo.setStudentName(sc.nextLine());
		System.out.println("학생의 학번을 입력하세요.");
		vo.setStudentNumber(sc.nextLine());
		
		int n = dao.studentDelete(vo);
		if (n != 0) {
			System.out.println("학생 정보를 삭제했습니다!");
		} else {
			System.out.println("일치하는 학생 정보가 없습니다.");
		}

	}
}
