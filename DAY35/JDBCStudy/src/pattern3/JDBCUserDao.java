package pattern3;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

public class JDBCUserDao implements UserDao {
	private DataSource dataSource;
	
	
	public DataSource getDataSource() {
		return dataSource;
	}

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	@Override
	public void create(User user) throws Exception {
		Connection con = null;
		PreparedStatement pstmt = null;
		String sql = "INSERT INTO users \r\n" + "VALUES     (?, \r\n" + "            ?, \r\n" + "            ?, \r\n"
				+ "            ?, \r\n" + "            SYSDATE) ";
		try {
			con = dataSource.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, user.getId());
			pstmt.setString(2, user.getName());
			pstmt.setString(3, user.getPasswd());
			pstmt.setString(4, user.getEmail());
			pstmt.executeUpdate();
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
				if (con != null)
					con.close(); // 아파치코드 : close 오버라이딩
//				UserConnectionPool.getInstance().releaseConnection(con); //선생님이 만든 코드
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}

	@Override
	public User read(String id) throws Exception {
		User user = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select id, name, passwd,email, regdate\r\n" + "from users\r\n" + "where id=?";
		try {
			con = dataSource.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.executeQuery();
			rs = pstmt.getResultSet();
			if (rs.next()) {
				user = new User();
				user.setId(rs.getString("id"));
				user.setName(rs.getString("name"));
				user.setPasswd(rs.getString("passwd"));
				user.setRegdate(rs.getString("regdate"));
			}
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (con != null)
					con.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return user;
	}

	@Override
	public void update(User user) throws Exception {
		Connection con = null;
		PreparedStatement pstmt = null;
		String sql = "update users \r\n" + "set name = ?, passwd = ?, email = ? \r\n" + "where id = ?";
		try {
			con = dataSource.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, user.getName());
			pstmt.setString(2, user.getPasswd());
			pstmt.setString(3, user.getEmail());
			pstmt.setString(4, user.getId());
			pstmt.executeUpdate();
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

	@Override
	public void delete(String id) throws Exception {
		Connection con = null;
		PreparedStatement pstmt = null;
		String sql = "delete from users\r\n" + "where id =?";
		try {
			con = dataSource.getConnection();
			con.setAutoCommit(false);
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.executeUpdate();
		} catch (Exception e) {
			con.rollback();
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

	@Override
	public List<User> listAll() throws Exception {
		List<User> list = new ArrayList<User>();
		User user = new User();
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select id, name, passwd,email, regdate\r\n" + "from users";
		try {
			con = dataSource.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.executeQuery();
			rs = pstmt.getResultSet();
			while (rs.next()) {
				user.setId(rs.getString("id"));
				user.setName(rs.getString("name"));
				user.setPasswd(rs.getString("passwd"));
				user.setRegdate(rs.getString("regdate"));
				list.add(user);
			}
		} catch (Exception e) {
			con.rollback();
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
		return list;
	}

	@Override
	public User certify(String id, String passwd) throws Exception {
		User user = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select id, name, passwd,email, regdate\r\n" + "from users\r\n" + "where id =? and passwd = ?";
		try {
			con = dataSource.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, passwd);
			pstmt.executeQuery();
			rs = pstmt.getResultSet();
			if (rs.next()) {
				user = new User();
				user.setId(rs.getString("id"));
				user.setName(rs.getString("name"));
				user.setPasswd(rs.getString("passwd"));
				user.setRegdate(rs.getString("regdate"));
			}
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (con != null)
					con.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return user;
	}

	@Override
	public List<Map<String,String>> employeeList() throws Exception {
		List<Map<String, String>> list = null;
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "select employee_id, first_name|| ' ' ||last_name name, salary, department_name, city\r\n" + 
				"from employees e left outer join departments d\r\n" + 
				"on e.department_id = d.department_id\r\n" + 
				"left outer join locations l\r\n" + 
				"on d.location_id = l.location_id";
		try {
			con = dataSource.getConnection();
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			list = new ArrayList<Map<String,String>>();
			ResultSetMetaData rsd = rs.getMetaData();
			int columnCount = rsd.getColumnCount();
			while (rs.next()) {
				Map<String,String> row = new LinkedHashMap<String,String>();
				for (int i = 1; i <= columnCount; i++) {
					String columnName = rsd.getColumnLabel(i);
					String columnValue = rs.getString(i);
					row.put(columnName, columnValue);
				}
				list.add(row);
			}
		} catch (Exception e) {
			con.rollback();
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
		return list;
	}


}
