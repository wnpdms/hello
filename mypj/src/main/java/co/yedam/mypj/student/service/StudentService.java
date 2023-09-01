package co.yedam.mypj.student.service;

import java.util.List;

public interface StudentService {
	List<StudentVO> studentSelectList();
	StudentVO studentSelect(StudentVO vo);
	int studentInsert(StudentVO vo); // 학생 등록
	int studentUpdate(StudentVO vo); // 학생 정보 수정
	int studentDelete(StudentVO vo); // 학생 정보 삭제
}
