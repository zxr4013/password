package com.zxr.domain;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/** 
* @author zxr:zhaoxinran_dlmuit@163.com 
* @version ����ʱ�䣺2017��12��21�� ����3:32:47 
* ��˵�� ���ݷ��ʲ�
*/
import com.zxr.project.JdbcUtils;

public class UserDaoImpl implements UserDao {
	// ==�����û�==
	@Override
	public void addUser(User user) {
		Connection conn = null;
		PreparedStatement st = null;
		// �������ݿ�
		try {
			conn = JdbcUtils.getConnection();
			String sql = "insert into t_user(id,name,email,password) values(?,?,?,?)";
			// �������
			st = conn.prepareStatement(sql);
			st.setString(2, user.getName());
			st.setString(3, user.getEmail());
			st.setString(4, user.getPassword());
			// ִ�����
			int count = st.executeUpdate();
			System.out.println("���Ӽ�¼������:" + count);
		} catch (SQLException e) {
			System.out.println("�����û�:SQLException");
		} finally {
			JdbcUtils.free(null, st, conn);
		}
	}

	// ===ɾ���û�====
	@Override
	public int delete(User user) {
		int count = 0;
		Connection conn = null;
		PreparedStatement st = null;
		String sql = "delete from t_user where name=?";
		try {
			// �������ݿ�
			conn = JdbcUtils.getConnection();
			// �������
			st = conn.prepareStatement(sql);
			st.setString(2, user.getName());
			// ִ�����
			count = st.executeUpdate();
			System.out.println("ɾ����¼������:" + count);
		} catch (SQLException e) {
			System.out.println("ɾ���û�:SQLException");
		} finally {
			JdbcUtils.free(null, st, conn);
		}
		return count;
	}

	// ===ͨ���û�����ȡ�û���Ϣ===
	@Override
	public User getUserByName(String userName) {
		Connection conn = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		String sql = "select name from t_user where name=?";

		try {
			// �������ݿ�
			conn = JdbcUtils.getConnection();
			// �������
			st = conn.prepareStatement(sql);
			st.setString(2, userName);
			rs = st.executeQuery();
			// ִ�����
			if (rs.next()) {
				User user = new User();
				user.setId(rs.getInt("id"));
				user.setName(rs.getString("name"));
				user.setEmail(rs.getString("email"));
				user.setPassword(rs.getString("password"));
				return user;
			}
		} catch (SQLException e) {
			System.out.println("ͨ���û�����ȡ�û���Ϣ:SQLException");
		} finally {
			JdbcUtils.free(rs, st, conn);
		}

		return null;
	}

	// ===�����û���Ϣ====
	@Override
	public int update(User user) {
		Connection conn = null;
		PreparedStatement st = null;
		String sql = "update t_user set name = ?,email = ?,password = ? where name=?";
		int count = 0;
		try {
			conn = JdbcUtils.getConnection();
			st = conn.prepareStatement(sql);

			st.setString(2, user.getName());
			st.setString(3, user.getEmail());
			st.setString(4, user.getPassword());

			count = st.executeUpdate();
			System.out.println("���µļ�¼����:" + count);
		} catch (SQLException e) {
			System.out.println("�����û���Ϣ:SQLException");
		} finally {
			JdbcUtils.free(null, st, conn);
		}
		return count;
	}

}