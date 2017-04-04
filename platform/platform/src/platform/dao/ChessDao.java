package platform.dao;

import java.sql.SQLException;
import java.util.Map;

import platform.util.JdbcHelper;

public class ChessDao {

	public static void updateOption(Map<Object, Object> map)
			throws SQLException {

		String user_name = map.get("userName").toString();
		String chess_x = map.get("chess_x").toString();
		String chess_y = map.get("chess_y").toString();
		// String pwd = map.get("userpwd").toString();
		// String email = map.get("email").toString();
		String sql = " update t_chess_option chess_x = ? and chess_y = ? where user_name = ?";
		JdbcHelper.update(sql, user_name, chess_x, chess_y);
	}

	public static void sendMessage(Map<Object, Object> map) throws SQLException {

		String message = map.get("message").toString();
		String sql = " update t_message message = ? where user_name = ?";
		JdbcHelper.update(sql, message);
	}

	@SuppressWarnings("unchecked")
	public static String getMessage(String string) throws SQLException {

		Map map;
		String username = string;
		String sql = " select message from t_message where user_name = ?";
		String message = (String) JdbcHelper.querySingle(sql, username);

		return message;
	}
}
