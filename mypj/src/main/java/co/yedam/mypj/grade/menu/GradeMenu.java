package co.yedam.mypj.grade.menu;

import java.util.List;
import java.util.Scanner;

import co.yedam.mypj.grade.service.GradeService;
import co.yedam.mypj.grade.service.GradeVO;
import co.yedam.mypj.grade.serviceImpl.GradeServiceImpl;
import co.yedam.mypj.student.service.StudentVO;

public class GradeMenu {
	private Scanner sc = new Scanner(System.in);
	GradeService dao = new GradeServiceImpl();

	private void gradeTitle() {
		System.out.println("======================");
		System.out.println("   성 적 조 회 시 스 템    ");
		System.out.println("======================");
		System.out.println("     1. 성 적 입 력");
		System.out.println("     2. 전 체 조 회");
		System.out.println("     3. 선 택 조 회");
		System.out.println("     4. 성 적 삭 제");
		System.out.println("  5. 상위 메뉴로 돌아가기");
		System.out.println("----------------------");
		System.out.println("원하는 작업을 선택 하세요..");
	}

	public void run() {
		boolean o = false;
		do {
			gradeTitle();
			int key = sc.nextInt();
			sc.nextLine();
			switch (key) {
			case 1:
				gradeInsert();
				break;
			case 2:
				gradeSelectList();
				break;
			case 3:
				gradeSelect();
				break;
			case 4:
				gradeDelete();
				break;
			case 5:
				o = true;
				System.out.println("학사 정보 탭으로 돌아갑니다..");
				break;
			}
		} while (!o);
	}

	private void gradeInsert() {
		GradeVO vo = new GradeVO();
		System.out.println("----------------------");
		System.out.println("     성  적  입  력");
		System.out.println("----------------------");
		System.out.println("등록할 학생 이름 :");
		vo.setGradeSName(sc.nextLine());
		System.out.println("학생의 학번 입력 :");
		vo.setGradeSNumber(sc.nextInt());
		System.out.println("학생의 점수 입력 :");
		vo.setGradeSScore(sc.nextInt());

		int score = vo.getGradeSScore();
		String grade;

		if (score > 90)
			grade = "A";
		else if (score > 80)
			grade = "B";
		else if (score > 70)
			grade = "C";
		else if (score > 60)
			grade = "D";
		else
			grade = "F";

		vo.setGradeSGrade(grade);

		int g = dao.gradeInsert(vo);
		if (g != 0) {
			System.out.println("학생 정보를 등록했습니다!");
		} else {
			System.out.println("학생 정보 등록을 실패했습니다.");
		}

	}

	private void gradeSelectList() { // 전체 학생 조회
		List<GradeVO> grades = dao.gradeSelectList();
		System.out.println("----------------------");
		System.out.println("     성  적  목  록");
		System.out.println("----------------------");

		for (GradeVO k : grades) {
			System.out.print(k.getGradeSName() + " : ");
			System.out.print(k.getGradeSNumber() + "학번 : ");
			System.out.print(k.getGradeSScore() + "점이고 등급은 ");
			System.out.println(k.getGradeSGrade() + "입니다.");
		}

	}

	private void gradeSelect() { // 선택 학생 조회
		GradeVO vo = new GradeVO();
		System.out.println("조회할 학생의 이름을 입력하세요.");
		vo.setGradeSName(sc.nextLine());
		System.out.println("조회할 학생의 학번을 입력하세요.");
		vo.setGradeSNumber(sc.nextInt());
		List<GradeVO> grades = dao.gradeSelect(vo);

		System.out.println("----------------------");
		System.out.println("     성  적  목  록");
		System.out.println("----------------------");

		for (GradeVO k : grades) {
			System.out.print(k.getGradeSName() + " : ");
			System.out.print(k.getGradeSNumber() + "학번 : ");
			System.out.print(k.getGradeSScore() + "점이고 등급은 ");
			System.out.println(k.getGradeSGrade() + "입니다.");
		}
	}

	private void gradeDelete() {
		GradeVO vo = new GradeVO();
		System.out.println("삭제할 학생의 이름을 입력하세요.");
		vo.setGradeSName(sc.nextLine());
		System.out.println("삭제할 학생의 학번을 입력하세요.");
		vo.setGradeSNumber(sc.nextInt());

		int d = dao.gradeDelete(vo);
		if (d != 0) {
			System.out.println("학생 정보를 삭제했습니다!");
		} else {
			System.out.println("학생 정보 삭제를 실패했습니다.");
		}

	}
}
