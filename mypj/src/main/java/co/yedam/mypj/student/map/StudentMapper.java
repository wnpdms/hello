package co.yedam.mypj.student.map;

import java.util.List;

import co.yedam.mypj.student.service.StudentVO;

public interface StudentMapper {
	List<StudentVO> studentSelectList();
	StudentVO studentSelect(StudentVO vo);
	int studentInsert(StudentVO vo); // 학생 등록
	int studentUpdate(StudentVO vo); // 학생 정보 수정
	int studentDelete(StudentVO vo); // 학생 정보 삭제
}
