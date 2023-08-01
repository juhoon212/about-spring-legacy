package xyz.itwill07.aop;

import java.util.List;

import lombok.Setter;

public class HewonServiceImpl implements HewonService{
	
	@Setter
	private HewonDAO hewonDAO;

	@Override
	public void addHewon(Hewon hewon) {
		System.out.println("*** HewonDAOImpl 클래스의 addHewon 메소드 호출");
		hewonDAO.insertHewon(hewon);
	}

	@Override
	public Hewon getHewon(int num) {
		System.out.println("*** HewonDAOImpl 클래스의 getHewon 메소드 호출");
		return hewonDAO.selectHewon(num);
	}

	@Override
	public List<Hewon> selectHewonList() {
		System.out.println("*** HewonDAOImpl 클래스의 getHewonList 메소드 호출");
		return hewonDAO.selectHewonList();
	}

}
