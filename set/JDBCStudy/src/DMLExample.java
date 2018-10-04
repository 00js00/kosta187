import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;

/**
 * 
 * @author 서지원
 *
 */
public class DMLExample {
	String driver = "oracle.jdbc.OracleDriver";
	String url = "jdbc:oracle:thin:@localhost:1521:xe";
	String username = "hr";
	String password = "hr";

	public void create(String departmentName, int managerId, int locationId) {
		String mId = "NULL";
		String lId = "NULL";
		if (managerId != 0) {
			mId = managerId + "";
		}
		if (locationId != 0) {
			lId = locationId + "";
		}

		String sql = "INSERT INTO departments \r\n" + "            (department_id, \r\n"
				+ "             department_name, \r\n" + "             location_id, \r\n"
				+ "             manager_id) \r\n" + "VALUES      (departments_seq.NEXTVAL, \r\n" + "             '"
				+ departmentName + "', \r\n" + "             " + mId + ", \r\n" + "             " + lId + ") ";
		Connection con = null;
		Statement stmt = null;

		try {
			Class.forName(driver).newInstance();
			try {
				con = DriverManager.getConnection(url, username, password);
				con.setAutoCommit(false);
				stmt = con.createStatement();
				int count = stmt.executeUpdate(sql); // 변경된 수를 알려줌 -- auto commit
				con.commit();
				System.out.println(count + "행이 추가되었습니다..");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			try {
				con.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} finally {
				try {
					if (stmt != null)
						stmt.close();
					if (con != null)
						con.close();
				} catch (Exception e2) {
					e2.printStackTrace();
				}

			}
		}

	}

	public void create2(String departmentName, int managerId, int locationId) {

		String sql = "INSERT INTO departments \r\n" + "            (department_id, \r\n"
				+ "             department_name, \r\n" + "             location_id, \r\n"
				+ "             manager_id) \r\n" + "VALUES      (departments_seq.NEXTVAL, \r\n" + "?, \r\n" + "?, \r\n"
				+ "?) ";
		Connection con = null;
		PreparedStatement pstmt = null;

		try {
			Class.forName(driver).newInstance();
			try {
				con = DriverManager.getConnection(url, username, password);
				con.setAutoCommit(false);

				// sql 전처리 - 서버에 보내기 전에 미리 전처리
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, departmentName);

				if (managerId != 0) {
					pstmt.setInt(2, managerId);
				} else {
					pstmt.setNull(2, Types.INTEGER);
				}
				if (locationId != 0) {
					pstmt.setInt(3, locationId);
				} else {
					pstmt.setNull(3, Types.INTEGER);
				}

				int count = pstmt.executeUpdate(); // 변경된 수를 알려줌 -- auto commit
				con.commit();
				System.out.println(count + "행이 추가되었습니다..");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			try {
				con.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} finally {
				try {
					if (pstmt != null)
						pstmt.close();
					if (con != null)
						con.close();
				} catch (Exception e2) {
					e2.printStackTrace();
				}

			}
		}

	}

	public void create3(Department department) {

		String sql = "INSERT INTO departments \r\n" + "            (department_id, \r\n"
				+ "             department_name, \r\n" + "             location_id, \r\n"
				+ "             manager_id) \r\n" + "VALUES      (departments_seq.NEXTVAL, \r\n" + "?, \r\n" + "?, \r\n"
				+ "?) ";
		Connection con = null;
		PreparedStatement pstmt = null;

		try {
			Class.forName(driver).newInstance();
			try {
				con = DriverManager.getConnection(url, username, password);
				con.setAutoCommit(false);

				// sql 전처리 - 서버에 보내기 전에 미리 전처리
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, department.getDepartmentName());

				if (department.getManagerId() != 0) {
					pstmt.setInt(2, department.getManagerId());
				} else {
					pstmt.setNull(2, Types.INTEGER);
				}
				if (department.getLocationId() != 0) {
					pstmt.setInt(3, department.getLocationId());
				} else {
					pstmt.setNull(3, Types.INTEGER);
				}

				int count = pstmt.executeUpdate(); // 변경된 수를 알려줌 -- auto commit
				con.commit();
				System.out.println(count + "행이 추가되었습니다..");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			try {
				con.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} finally {
				try {
					if (pstmt != null)
						pstmt.close();
					if (con != null)
						con.close();
				} catch (Exception e2) {
					e2.printStackTrace();
				}

			}
		}

	}

	public void create3(String departmentName, int managerId, int locationId) {
		create3(new Department(0, departmentName, managerId, locationId));
	}

	public void delete(int departmentId) {
		String sql = "delete from departments \r\n" + 
				"where Department_Id =?";
		Connection con = null;
		PreparedStatement pstmt = null;

		try {
			Class.forName(driver).newInstance();
			try {
				con = DriverManager.getConnection(url, username, password);
				con.setAutoCommit(false);

				// sql 전처리 - 서버에 보내기 전에 미리 전처리
				pstmt = con.prepareStatement(sql);
				pstmt.setInt(1, departmentId);

				int count = pstmt.executeUpdate(); // 변경된 수를 알려줌 -- auto commit
				con.commit();
				System.out.println(count + "행이 삭제되었습니다..");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			try {
				con.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} finally {
				try {
					if (pstmt != null)
						pstmt.close();
					if (con != null)
						con.close();
				} catch (Exception e2) {
					e2.printStackTrace();
				}

			}
		}

	}

	public static void main(String[] args) {
		DMLExample exam = new DMLExample();
//		exam.create3("코스타4", 0, 0);
		exam.delete(360);
	}
}
