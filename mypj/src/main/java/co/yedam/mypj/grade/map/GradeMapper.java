package co.yedam.mypj.grade.map;

import java.util.List;

import co.yedam.mypj.grade.service.GradeVO;

public interface GradeMapper {
	List<GradeVO> gradeSelectList();
	List<GradeVO> gradeSelect(GradeVO vo);
	int gradeInsert(GradeVO vo);
	int gradeDelete(GradeVO vo);
}
