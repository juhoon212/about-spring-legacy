package xyz.itwill07.aop;

import java.util.List;

public class HewonDAOImpl implements HewonDAO{

	@Override
	public int insertHewon(Hewon hewon) {
		System.out.println("*** HewonDAOImpl 클래스의 insertHewon 메소드");
		return 0;
	}

	@Override
	public Hewon selectHewon(int num) {
		System.out.println("*** HewonDAOImpl 클래스의 selectHewon 메소드");
		return null;
	}

	@Override
	public List<Hewon> selectHewonList() {
		System.out.println("*** HewonDAOImpl 클래스의 selectHewonList 메소드");
		return null;
	}
}
