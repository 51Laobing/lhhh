package com.wxc.lhhh.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.wxc.lhhh.model.Admin;
import com.wxc.lhhh.model.Dhjl;
import com.wxc.lhhh.model.FaPiao;
import com.wxc.lhhh.model.LiPin;
import com.wxc.lhhh.model.User;

public class MySQLUtil {
	/**
	 * 获取Mysql数据库连接
	 * 
	 * @return Connection
	 */
	private Connection getConn() {
		Connection conn = null;

		// 数据库IP、端口、用户名和密码
		String host = PropertiesUtil.getPropertyValue("host");
		String port = PropertiesUtil.getPropertyValue("port");
		String username = PropertiesUtil.getPropertyValue("username");
		String password = PropertiesUtil.getPropertyValue("password");
		// 数据库名称
		String dbName = PropertiesUtil.getPropertyValue("dbName");
		// JDBC URL
		String url = String.format("jdbc:mysql://%s:%s/%s", host, port, dbName);

		try {
			// 加载MySQL驱动
			Class.forName("com.mysql.jdbc.Driver");
			// 获取数据库连接
			conn = DriverManager.getConnection(url, username, password);
		} catch (ClassNotFoundException e) {
		} catch (SQLException e) {
		}
		return conn;
	}

	public static boolean checkAdminLogin(String glyyhm, String glymm) {
		boolean result = false;
		String sql = "select * from gly where glyyhm=? and glymm=?";
		try {
			Connection conn = new MySQLUtil().getConn();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, glyyhm);
			ps.setString(2, glymm);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				result = true;
			}
			// 释放资源
			rs.close();
			ps.close();
			conn.close();
		} catch (SQLException e) {
		}
		return result;
	}

	public static String findValueByKey(String key) {
		String sql = "select kvvalue from kv where kvkey=?";
		String value = "";
		try {
			Connection conn = new MySQLUtil().getConn();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, key);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				value = rs.getString("kvvalue");
			}
			// 释放资源
			rs.close();
			ps.close();
			conn.close();
		} catch (SQLException e) {
		}
		return value;
	}

	public static List<FaPiao> findAllFaPiao() {
		String sql = "select * from fpsc";
		List<FaPiao> fpList = new ArrayList<FaPiao>();
		try {
			Connection conn = new MySQLUtil().getConn();
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				FaPiao fp = new FaPiao();
				fp.setFpscid(rs.getInt("fpscid"));
				fp.setUserid(rs.getString("userid"));
				fp.setShmc(rs.getString("shmc"));
				fp.setLxdh(rs.getString("lxdh"));
				fp.setXfje(rs.getString("xfje"));
				fp.setFpdm(rs.getString("fpdm"));
				fp.setFphm(rs.getString("fphm"));
				fp.setZplj(rs.getString("zplj"));
				fp.setShzt(rs.getString("shzt"));
				fp.setJf(rs.getInt("jf"));
				fp.setShrq(rs.getDate("shrq"));
				fpList.add(fp);
			}
			// 释放资源
			rs.close();
			ps.close();
			conn.close();
		} catch (SQLException e) {
		}
		return fpList;
	}

	public static List<Dhjl> findAllDhjl(String fhzt) {
		String sql = "select * from dhjl where fhzt=?";
		List<Dhjl> dhList = new ArrayList<Dhjl>();
		try {
			Connection conn = new MySQLUtil().getConn();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, fhzt);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Dhjl dh = new Dhjl();
				dh.setDhjlid(rs.getInt("dhjlid"));
				dh.setUserid(rs.getString("userid"));
				dh.setSjhm(rs.getString("sjhm"));
				dh.setLpbh(rs.getString("lpbh"));
				dh.setDhsl(rs.getInt("dhsl"));
				dh.setKcjf(rs.getInt("kcjf"));
				dh.setFhdz(rs.getString("fhdz"));
				dh.setFhzt(rs.getString("fhzt"));
				dh.setDhrq(rs.getDate("dhrq"));
				dhList.add(dh);
			}
			// 释放资源
			rs.close();
			ps.close();
			conn.close();
		} catch (SQLException e) {
		}
		return dhList;
	}

	public static List<User> findAllUser() {
		String sql = "select * from grxx order by zcsj desc";
		List<User> userList = new ArrayList<User>();
		try {
			Connection conn = new MySQLUtil().getConn();
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				User user = new User();
				user.setId(rs.getString("id"));
				user.setMm(rs.getString("mm"));
				user.setNc(rs.getString("nc"));
				user.setJfye(rs.getInt("jfye"));
				userList.add(user);
			}
			// 释放资源
			rs.close();
			ps.close();
			conn.close();
		} catch (SQLException e) {
		}
		return userList;
	}
	
	public static List<User> findUserById(String id) {
		String sql = "select * from grxx where id=? order by zcsj desc";
		List<User> userList = new ArrayList<User>();
		try {
			Connection conn = new MySQLUtil().getConn();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, id);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				User user = new User();
				user.setId(rs.getString("id"));
				user.setMm(rs.getString("mm"));
				user.setNc(rs.getString("nc"));
				user.setJfye(rs.getInt("jfye"));
				userList.add(user);
			}
			// 释放资源
			rs.close();
			ps.close();
			conn.close();
		} catch (SQLException e) {
		}
		return userList;
	}
	
	public static boolean updateUserJfById(String id, int zjjf) {
		String sql = "update grxx set jfye=jfye+? where id=?";
		try {
			Connection conn = new MySQLUtil().getConn();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, zjjf);
			ps.setString(2, id);
			ps.executeUpdate();
			// 释放资源
			ps.close();
			conn.close();
			return true;
		} catch (SQLException e) {
			return false;
		}
	}

	public static boolean updateFpById(int fpscid, int jf, String shzt) {
		String sql = "update fpsc set jf=?, shzt=?, shrq=now() where fpscid=?";
		try {
			Connection conn = new MySQLUtil().getConn();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, jf);
			ps.setString(2, shzt);
			ps.setInt(3, fpscid);
			ps.executeUpdate();

			String sql2 = "update grxx set jfye=jfye+? where id=(select userid from fpsc where fpscid=?)";
			ps = conn.prepareStatement(sql2);
			ps.setInt(1, jf);
			ps.setInt(2, fpscid);
			ps.executeUpdate();
			
			// 释放资源
			ps.close();
			conn.close();
			return true;
		} catch (SQLException e) {
			return false;
		}
	}

	public static boolean updateFhzt(int dhjlid) {
		String sql = "update dhjl set fhzt='y' where dhjlid=?";
		try {
			Connection conn = new MySQLUtil().getConn();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, dhjlid);
			ps.executeUpdate();

			// 释放资源
			ps.close();
			conn.close();
			return true;
		} catch (SQLException e) {
			return false;
		}
	}
	
	public static boolean updateValueByKey(String kvkey,String kvvalue) {
		String sql = "update kv set kvvalue=? where kvkey=?";
		try {
			Connection conn = new MySQLUtil().getConn();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, kvvalue);
			ps.setString(2, kvkey);
			ps.executeUpdate();

			// 释放资源
			ps.close();
			conn.close();
			return true;
		} catch (SQLException e) {
			return false;
		}
	}

	public static List<Admin> findAllAdmin() {
		String sql = "select * from gly";
		List<Admin> glyList = new ArrayList<Admin>();
		try {
			Connection conn = new MySQLUtil().getConn();
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Admin gly = new Admin();
				gly.setGlyid(rs.getInt("glyid"));
				gly.setGlyyhm(rs.getString("glyyhm"));
				gly.setGlymm(rs.getString("glymm"));
				glyList.add(gly);
			}
			// 释放资源
			rs.close();
			ps.close();
			conn.close();
		} catch (SQLException e) {
		}
		return glyList;
	}

	public static boolean saveAdmin(String glyyhm, String glymm) {
		String sql = "insert into gly(glyyhm, glymm) values (?, ?)";
		try {
			Connection conn = new MySQLUtil().getConn();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, glyyhm);
			ps.setString(2, glymm);
			ps.executeUpdate();

			// 释放资源
			ps.close();
			conn.close();
			return true;
		} catch (SQLException e) {
			return false;
		}
	}

	public static List<LiPin> findAllLiPin() {
		String sql = "select * from lp";
		List<LiPin> lpList = new ArrayList<LiPin>();
		try {
			Connection conn = new MySQLUtil().getConn();
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				LiPin lp = new LiPin();
				lp.setLpbh(rs.getString("lpbh"));
				lp.setLpmc(rs.getString("lpmc"));
				lp.setLpdj(rs.getInt("lpdj"));
				lp.setLpzs(rs.getInt("lpzs"));
				lp.setKcsl(rs.getInt("kcsl"));
				lp.setZplj(rs.getString("zplj"));
				lpList.add(lp);
			}
			// 释放资源
			rs.close();
			ps.close();
			conn.close();
		} catch (SQLException e) {
		}
		return lpList;
	}
	
	public static LiPin getLiPinById(String lpbh) {
		String sql = "select * from lp where lpbh=?";
		LiPin lp = new LiPin();
		try {
			Connection conn = new MySQLUtil().getConn();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, lpbh);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				lp.setLpbh(rs.getString("lpbh"));
				lp.setLpmc(rs.getString("lpmc"));
				lp.setLpdj(rs.getInt("lpdj"));
				lp.setLpzs(rs.getInt("lpzs"));
				lp.setKcsl(rs.getInt("kcsl"));
				lp.setZplj(rs.getString("zplj"));
			}
			// 释放资源
			rs.close();
			ps.close();
			conn.close();
		} catch (SQLException e) {
		}
		return lp;
	}
	
	public static boolean saveLipin (LiPin lp) {
		String sql = "insert into lp(lpbh, lpmc, lpdj, lpzs, kcsl, zplj) values (?, ?, ?, ?, ?, ?)";
		try {
			Connection conn = new MySQLUtil().getConn();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, lp.getLpbh());
			ps.setString(2, lp.getLpmc());
			ps.setInt(3, lp.getLpdj());
			ps.setInt(4, lp.getLpzs());
			ps.setInt(5, lp.getKcsl());
			ps.setString(6, lp.getZplj());
			ps.executeUpdate();

			// 释放资源
			ps.close();
			conn.close();
			return true;
		} catch (SQLException e) {
			return false;
		}
	}
	
	public static boolean updateLp(LiPin lp) {
		String sql = "update lp set lpmc=?, lpdj=?, lpzs=?, kcsl=?, zplj=? where lpbh=?";
		try {
			Connection conn = new MySQLUtil().getConn();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, lp.getLpmc());
			ps.setInt(2, lp.getLpdj());
			ps.setInt(3, lp.getLpzs());
			ps.setInt(4, lp.getKcsl());
			ps.setString(5, lp.getZplj());
			ps.setString(6, lp.getLpbh());
			ps.executeUpdate();

			// 释放资源
			ps.close();
			conn.close();
			return true;
		} catch (SQLException e) {
			return false;
		}
	}
	
	public static boolean deleteLpById(String lpbh) {
		String sql = "delete from lp where lpbh=?";
		try {
			Connection conn = new MySQLUtil().getConn();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, lpbh);
			ps.executeUpdate();

			// 释放资源
			ps.close();
			conn.close();
			return true;
		} catch (SQLException e) {
			return false;
		}
	}


}
