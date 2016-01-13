package com.wxc.lhhh.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.wxc.lhhh.model.Dhjl;
import com.wxc.lhhh.model.FaPiao;
import com.wxc.lhhh.model.LiPin;
import com.wxc.lhhh.model.MyDhjl;
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

	public static List<FaPiao> findAllFaPiaoByUserId(String userid) {
		String sql = "select * from fpsc where userid=?";
		List<FaPiao> fpList = new ArrayList<FaPiao>();
		try {
			Connection conn = new MySQLUtil().getConn();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, userid);
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

	public static List<FaPiao> findAllFaPiao(String shmc, String lxdh) {
		String sql = "select * from fpsc where shmc=? and lxdh=?";
		List<FaPiao> fpList = new ArrayList<FaPiao>();
		try {
			Connection conn = new MySQLUtil().getConn();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, shmc);
			ps.setString(2, lxdh);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				FaPiao fp = new FaPiao();
				fp.setFpscid(rs.getInt("fpscid"));
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

	public static boolean saveFPSCInfo(String userid, String shmc, String lxdh,
			String xfje, String fpdm, String fphm, String zplj) {
		String sql = "insert into fpsc(userid, shmc, lxdh, xfje, fpdm, fphm, zplj) values (?, ?, ?, ?, ?, ?, ?)";
		try {
			Connection conn = new MySQLUtil().getConn();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, userid);
			ps.setString(2, shmc);
			ps.setString(3, lxdh);
			ps.setString(4, xfje);
			ps.setString(5, fpdm);
			ps.setString(6, fphm);
			ps.setString(7, zplj);
			ps.executeUpdate();
			// 释放资源
			ps.close();
			conn.close();
			return true;
		} catch (SQLException e) {
			return false;
		}
	}

	public static boolean saveUserInfo(String id, String mm, String nc) {
		boolean hasId = checkGrxx(id);
		if (!hasId) {
			String sql = "insert into grxx(id,mm, nc, zcsj) values (?, ?, ?, now())";
			try {
				Connection conn = new MySQLUtil().getConn();
				PreparedStatement ps = conn.prepareStatement(sql);
				ps.setString(1, id);
				ps.setString(2, mm);
				ps.setString(3, nc);
				ps.executeUpdate();
				// 释放资源
				ps.close();
				conn.close();
				return true;
			} catch (SQLException e) {
				return false;
			}
		} else {
			return false;
		}
	}

	public static boolean checkGrxx(String id) {
		boolean result = false;
		String sql = "select * from grxx where id=?";
		try {
			Connection conn = new MySQLUtil().getConn();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, id);
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

	public static boolean checkUser(String id, String mm) {
		boolean result = false;
		String sql = "select * from grxx where id=? and mm=?";
		try {
			Connection conn = new MySQLUtil().getConn();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, id);
			ps.setString(2, mm);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				result = true;
			}
			// 释放资源
			rs.close();
			ps.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	public static User findUserById(String id) {
		User user = new User();
		String sql = "select * from grxx where id=?";
		try {
			Connection conn = new MySQLUtil().getConn();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, id);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				user.setId(rs.getString("id"));
				user.setNc(rs.getString("nc"));
				user.setJfye(rs.getInt("jfye"));
			}
			// 释放资源
			rs.close();
			ps.close();
			conn.close();
		} catch (SQLException e) {
		}
		return user;
	}

	public static boolean updateUserMM(String id, String newmm) {
		String sql = "update grxx set mm=? where id=?";
		try {
			Connection conn = new MySQLUtil().getConn();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, newmm);
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

	public static boolean updateUserNcById(String id, String newnc) {
		String sql = "update grxx set nc=? where id=?";
		try {
			Connection conn = new MySQLUtil().getConn();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, newnc);
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

	public static LiPin findLiPin(String lpbh) {
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

	public static boolean compJf(String id, int jfzs) {
		boolean result = false;
		String sql = "select * from grxx where id=? and jfye>=?";
		try {
			Connection conn = new MySQLUtil().getConn();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, id);
			ps.setInt(2, jfzs);
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

	public static List<Dhjl> findAllDhjl(String userid) {
		String sql = "select * from dhjl where userid=?";
		List<Dhjl> dhList = new ArrayList<Dhjl>();
		try {
			Connection conn = new MySQLUtil().getConn();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, userid);
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

	public static List<MyDhjl> findAllMyDhjlByUserId(String userid) {
		String sql = "select * from mydhjl where userid=?";
		List<MyDhjl> mydhList = new ArrayList<MyDhjl>();
		try {
			Connection conn = new MySQLUtil().getConn();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, userid);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				MyDhjl mydh = new MyDhjl();
				mydh.setDhjlid(rs.getInt("dhjlid"));
				mydh.setUserid(rs.getString("userid"));
				mydh.setLpbh(rs.getString("lpbh"));
				mydh.setDhsl(rs.getInt("dhsl"));
				mydh.setFhzt(rs.getString("fhzt"));
				mydh.setDhrq(rs.getDate("dhrq"));
				mydh.setLpbh(rs.getString("lpbh"));
				mydh.setLpmc(rs.getString("lpmc"));
				mydh.setLpdj(rs.getInt("lpdj"));
				mydhList.add(mydh);
			}
			// 释放资源
			rs.close();
			ps.close();
			conn.close();
		} catch (SQLException e) {
		}
		return mydhList;
	}

	public static boolean saveDhjl(String userid, String sjhm, String lpbh,
			int dhsl, String fhdz) {
		String sql = "";
		int jfzs = 0;

		try {
			sql = "select lpdj from lp where lpbh=?";
			Connection conn = new MySQLUtil().getConn();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, lpbh);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				jfzs = dhsl * rs.getInt("lpdj");
				if (compJf(userid, jfzs)) {
					// 扣除用户积分
					sql = "update grxx set jfye=jfye-? where id=?";
					ps = conn.prepareStatement(sql);
					ps.setInt(1, jfzs);
					ps.setString(2, sjhm);
					ps.executeUpdate();

					// 扣除商品数量
					sql = "update lp set kcsl=kcsl-? where lpbh=?";
					ps = conn.prepareStatement(sql);
					ps.setInt(1, dhsl);
					ps.setString(2, lpbh);
					ps.executeUpdate();

					// 添加兑换记录
					sql = "insert into dhjl(userid,sjhm,lpbh,dhsl,kcjf,fhdz,fhzt,dhrq) values(?, ?, ?, ?, ?, ?, 'n', now() )";
					ps = conn.prepareStatement(sql);
					ps.setString(1, userid);
					ps.setString(2, sjhm);
					ps.setString(3, lpbh);
					ps.setInt(4, dhsl);
					ps.setInt(5, jfzs);
					ps.setString(6, fhdz);
					ps.executeUpdate();
				}
			}
			// 释放资源
			ps.close();
			conn.close();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

}
