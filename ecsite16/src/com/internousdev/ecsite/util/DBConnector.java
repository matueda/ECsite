package com.internousdev.ecsite.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnector {
	//ドライバー設定
		private static String driverName="com.mysql.jdbc.Driver";
		//URL。この場合はmysqlのローカルホスト
		private static String url="jdbc:mysql://localhost/ecsite";

		//今回はルート
		private static String user="root";
		private static String password="mysql";

		//接続
		public Connection getConnection(){
			Connection con = null;

			try{
					Class.forName(driverName);
					//接続。URL、USER,PASSをゲット
					con=(Connection) DriverManager.getConnection(url,user,password);
					//例外処理
			}catch(ClassNotFoundException e){
				e.printStackTrace();
			}catch(SQLException e){
				e.printStackTrace();
			}
			return con;
		}

}
