package co.yedam.mypj;

import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.Scanner;
import co.yedam.mypj.grade.menu.GradeMenu;
import co.yedam.mypj.student.menu.StudentManager;
import co.yedam.mypj.student.service.StudentService;
import co.yedam.mypj.student.service.StudentVO;
import co.yedam.mypj.student.serviceImpl.StudentServiceImpl;

public class MainMenu {
	private StudentManager sm = new StudentManager(); // 학생 관리 메뉴
	private GradeMenu gm = new GradeMenu(); // 성적 관리 메뉴
	private StudentService dao = new StudentServiceImpl();

	private Scanner sc = new Scanner(System.in);

	private void title() {
		System.out.println("======================");
		System.out.println("     학 사 정 보 조 회    ");
		System.out.println("======================");
		System.out.println("	안녕하세요!");
		System.out.println("     ♡♡ 현재 시각은 ♡♡");
		System.out.println(" " + sfd.format(date));
		System.out.println("  입니다. 즐거운 하루 되세요!");
		System.out.println("----------------------");
		System.out.println("     1. 학 생 조 회");
		System.out.println("     2. 성 적 조 회");
		System.out.println("       3. 종  료");
		System.out.println("----------------------");
		System.out.println("원하는 작업을 선택 하세요..");
	}

	public void run() {
		boolean b = false;
		while (!b) {
			if (studentLogin()) {
				do {
					title();
					int mainKey = sc.nextInt();
					sc.nextLine();
					switch (mainKey) {
					case 1:
						sm.run();
						break;
					case 2:
						gm.run();
						break;
					case 3:
						b = true;
						sc.close();
						System.out.println("작업을 종료 합니다..");
						break;
					}
				} while (!b);
			}
		}
	}

	private boolean studentLogin() {
		StudentVO vo = new StudentVO();
		boolean l = false;

			System.out.println("------- 접 속 하 기 --------");
			System.out.println("사용자 이름을 입력 해주세요.");
			vo.setStudentName(sc.nextLine());
			System.out.println("생년월일 6자리를 입력 해주세요.");
			vo.setStudentBirth(sc.nextLine());

			vo = dao.studentSelect(vo);
			if (vo != null) {
				System.out.println("   " + vo.getStudentName() + "님 환영합니다!");
				l = true;
			} else {
				System.out.println("이름 또는 생년월일이 일치하지 않습니다.");
				System.out.println("다시 한번 입력 해주세요.");
			}
			return l;
		}

	Date date = new Date();
	SimpleDateFormat sfd = new SimpleDateFormat("yy년 MM월 dd일 HH시 mm분");
}
