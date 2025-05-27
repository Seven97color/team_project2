package model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionManager {
  /**
   * データベースURL（DB名は担当するシステムで異なる）
   * ダウンロードしたsqlファイルでDB名を確認
   */
  private static final String URL = "jdbc:mysql://localhost:3306/employee_manager_db";
	
  /**
   * ユーザ（担当するシステムで異なる）
   * ダウンロードしたsqlファイルでユーザ名を確認
   */
  private static final String USER = "employeeU";
	
  /**
   * パスワード（担当するシステムで異なる）
   ** ダウンロードしたsqlファイルでパスワードを確認
   */
  private static final String PASSWORD = "employeeP";
	
  /**
   * データベース接続確立しコネクションを返す
   * @return コネクション
   * @throws ClassNotFoundException
   * @throws SQLException
   */
  public static Connection getConnection() throws ClassNotFoundException, SQLException {
    // ドライバの読み込み
    Class.forName("com.mysql.jdbc.Driver");
    // データベース接続確立
    return DriverManager.getConnection(URL, USER, PASSWORD);
  }
}
