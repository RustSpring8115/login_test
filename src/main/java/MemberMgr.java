import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Vector;




public class MemberMgr {
	
	private DBConnectionMgr pool;
	
	public MemberMgr() {
		
		try {
			pool = DBConnectionMgr.getInstance();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	// ID 중복확인
	public boolean checkId(String id) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = null;
		boolean flag = false;
		try {
			con = pool.getConnection();
			sql = "select id from tbMember where id = ?";
			pstmt = con.prepareStatement(sql);
				pstmt.setString(1, id);
				flag = pstmt.executeQuery().next();
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			pool.freeConnection(con,pstmt,rs);
		}
		return flag;
	}
	// 우편번호 검색
		public Vector<ZipCodeBean> zipcodeRead(String area3) {
			Connection con = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			String sql = null;
			
			//백터 클래스 생성
			Vector<ZipCodeBean> vlist = new Vector();
			try {
				con = pool.getConnection(); //커넥션 풀을 이용하여 커넥션 얻기
				sql = "select *from tblZipcode where area3 like ?"; // 실행할 sql문
				pstmt = con.prepareStatement(sql); // 커넥션객체의 메소드를 사용하여 prepareStatement 객체생성
				pstmt.setString(1, "%" + area3 + "%"); // ? 안에 넣을 구문 입력
				rs = pstmt.executeQuery(); // sql문 적용
				
				// 우편번호 DTo 객체 생성	
				ZipCodeBean bean = new ZipCodeBean();
					// sql 테이블의 콜룸값을 얻어와서 set메소드를 사용해서 zipCodeBean객체에 저장
					bean.setZipcode(rs.getString(1));
					bean.setArea1(rs.getString(2));
					bean.setArea2(rs.getString(3));
					bean.setArea3(rs.getString(4));
				vlist.addElement(bean); // vector 배열에 bean 참조변수를 저장 (0)	
			} catch (Exception e) {
				e.printStackTrace();
			}finally {
				pool.freeConnection(con,pstmt,rs);
			}
			return vlist;
	}
	//회원가입
	public boolean insertMember(MemberBean bean) {
		Connection con = null;
		PreparedStatement pstmt = null;
		String sql = null;
		boolean flag = false;
		
		try {
			con = pool.getConnection();
			sql = "insert tblMember(id,pass,name,gender,birthday,"
					+ "eamil,zipcode,adress,hobby,job)values(?,?,?,?,?,?,?,?,?,?)";
			pstmt = con.prepareStatement(sql);
				pstmt.setString(1, bean.getId());
				pstmt.setString(2, bean.getPwd());
				pstmt.setString(3, bean.getName());
				pstmt.setString(4, bean.getGender());
				pstmt.setString(5, bean.getBirthday());
				pstmt.setString(6, bean.getEmail());
				pstmt.setString(7, bean.getZipcode());
				pstmt.setString(8, bean.getAddress());
				
				String hobby[] = bean.getHobby();
				char hb[] = {'0','0','0','0','0'};
				String lists[] = {"인터넷","여행","게임","영화","운동"};
					for (int i = 0; i < hobby.length; i++) {
						for (int j = 0; j < lists.length; j++) {
							if(hobby[i].equals(lists[j])){
								hb[j] = '1';
							}
						}
						
					}
				pstmt.setString(9, new String(hb));
				pstmt.setString(10, bean.getJob());
				if(pstmt.executeUpdate() == 1)
					flag = true;
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			pool.freeConnection(con,pstmt);
		}
		return flag;
	}
	//로그인
	public boolean loginMember(String id, String pwd) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = null;
		boolean flag = false;
		
		try {
			con = pool.getConnection();
			sql = "select id from tblMember where id = ? and pwd = ?";
			pstmt = con.prepareStatement(sql);
				pstmt.setString(1, id);
				pstmt.setString(2, pwd);
				rs = pstmt.executeQuery();
				flag = rs.next();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			pool.freeConnection(con,pstmt,rs);
		}
		return flag;
	}
}//class의 끝


