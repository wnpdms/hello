package co.yedam.mypj.grade.service;

import java.util.List;

public interface GradeService {
	List<GradeVO> gradeSelectList();
	List<GradeVO> gradeSelect(GradeVO vo);
	int gradeInsert(GradeVO vo);
	int gradeDelete(GradeVO vo);
}
