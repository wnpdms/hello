package co.yedam.mypj.student.serviceImpl;

import java.util.List;

import javax.xml.crypto.Data;

import org.apache.ibatis.session.SqlSession;

import co.yedam.mypj.common.DataSource;
import co.yedam.mypj.student.map.StudentMapper;
import co.yedam.mypj.student.service.StudentService;
import co.yedam.mypj.student.service.StudentVO;

public class StudentServiceImpl implements StudentService {
	private SqlSession sqlSession = DataSource.getInstance().openSession(true);
	private StudentMapper map = sqlSession.getMapper(StudentMapper.class);
	@Override
	public List<StudentVO> studentSelectList() {
		return map.studentSelectList();
	}
	@Override
	public StudentVO studentSelect(StudentVO vo) {
		return map.studentSelect(vo);
	}
	@Override
	public int studentInsert(StudentVO vo) {
		return map.studentInsert(vo);
	}
	@Override
	public int studentUpdate(StudentVO vo) {
		return map.studentUpdate(vo);
	}
	@Override
	public int studentDelete(StudentVO vo) {
		return map.studentDelete(vo);
	}
}
