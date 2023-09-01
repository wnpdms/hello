package co.yedam.mypj.grade.serviceImpl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import co.yedam.mypj.common.DataSource;
import co.yedam.mypj.grade.map.GradeMapper;
import co.yedam.mypj.grade.service.GradeService;
import co.yedam.mypj.grade.service.GradeVO;

public class GradeServiceImpl implements GradeService {
	private SqlSession sqlSession = DataSource.getInstance().openSession(true);
	private GradeMapper map = sqlSession.getMapper(GradeMapper.class);

	@Override
	public List<GradeVO> gradeSelectList() {
		return map.gradeSelectList();
	}

	@Override
	public int gradeInsert(GradeVO vo) {
		return map.gradeInsert(vo);
	}

	@Override
	public int gradeDelete(GradeVO vo) {
		return map.gradeDelete(vo);
	}

	@Override
	public List<GradeVO> gradeSelect(GradeVO vo) {
		return map.gradeSelect(vo);
	}

	
	
}
