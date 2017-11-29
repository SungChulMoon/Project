package InnerClass;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
/**
 * DB에 정보를 넣거나 빼오는 역할을 하는 클래스
 * @author Moon light
 * 
 */
public class DBmethod {
	static Connection conn;
	public static void getInfo() throws Exception {
//		String url = "jdbc:mysql://168.131.153.176:3306/moon";
//		String dbid = "superuser";
//		String dbpw = "1234";
//		Class.forName("com.mysql.jdbc.Driver");
//		conn = DriverManager.getConnection(url, dbid, dbpw); my sql 드라이버 전용
		Class.forName ( "org.sqlite.JDBC");
		conn = DriverManager.getConnection("jdbc:sqlite:resource/database.db");
		System.out.println("sqlite 사용");
	
	}

	
	public static nowWeather getNowweatherParsed()throws Exception{
		getInfo();
		ArrayList<nowWeather> nowlist = new ArrayList<>();
		PreparedStatement pst =conn.prepareStatement("select * from nowweatherparsed");
		ResultSet rs = pst.executeQuery();
		while(rs.next()) {
			nowlist.add(new nowWeather(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5)));
			
		}
		return nowlist.get(nowlist.size()-1);
	}
	public static int addParseredWeather(String getTemp,String getMaxtemp,String getMintemp, String getmain,String getLocation) throws Exception{
		getInfo();
		PreparedStatement pst =conn.prepareStatement("insert into nowweatherparsed values(?,?,?,?,?)");
		pst.setString(1, getTemp);
		pst.setString(2, getMaxtemp);
		pst.setString(3, getMintemp);
		pst.setString(4, getmain);
		pst.setString(5, getLocation);
		int cnt = pst.executeUpdate();
		return cnt;
	}
	public static ArrayList<String> getUserId() throws Exception{
		getInfo();
		ArrayList<String> id = new ArrayList<>();
		PreparedStatement pst =conn.prepareStatement("select * from userinfo");
		ResultSet rs = pst.executeQuery();
		while(rs.next()) {
			id.add(rs.getString(1));
		}
		return id;
	}
	public static ArrayList<String> getUserPass() throws Exception{
		getInfo();
		ArrayList<String> id = new ArrayList<>();
		PreparedStatement pst =conn.prepareStatement("select * from userinfo");
		ResultSet rs = pst.executeQuery();
		while(rs.next()) {
			id.add(rs.getString(2));
		}
		return id;
	}
		
	
	public static int addUserInfo(String id,String password,String name,String location, String gender,String body,String style_str,String style_size) throws Exception{
		getInfo();
		PreparedStatement pst =conn.prepareStatement("insert into userinfo values(?,?,?,?,?,?,?,?)");
		pst.setString(1, id);
		pst.setString(2, password);
		pst.setString(3, name);
		pst.setString(4, location);
		pst.setString(5, gender);
		pst.setString(6, body);
		pst.setString(7, style_str);
		pst.setString(8, style_size);
		int cnt = pst.executeUpdate();
		return cnt;
	}
	public static User getUserinfo(String id) throws Exception{
		getInfo();
		User us = null ;
		PreparedStatement pst =conn.prepareStatement("select * from userinfo");
		ResultSet rs = pst.executeQuery();
		while(rs.next()) {
		if(id.equals(rs.getString(1))) {
			us = new User(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8));
		}
			}
		return us;
	}
	public static int addtip(String weather, String tip, String tiplink) throws Exception{
		getInfo();
		ArrayList<tipObject> arr = new ArrayList<>();
		PreparedStatement pst =conn.prepareStatement("insert into livingtip values(?,?,?)");
		//PreparedStatement pst2 =conn.prepareStatement("delete from livingtip;");
		
		pst.setString(1, weather);
		pst.setString(2, tip);
		pst.setString(3, tiplink);
		int cnt = pst.executeUpdate();
		//pst2.executeUpdate();
		return cnt;
	}
	public static ArrayList<tipObject> selecttip(String weather) throws Exception{
		getInfo();
		ArrayList<tipObject> arr = new ArrayList<>();
		PreparedStatement pst =conn.prepareStatement("select * from tip where weather=?");
		pst.setString(1, weather);
		ResultSet rs = pst.executeQuery();
		if(rs.next()) {
			String tip = rs.getString(2);
			String link = rs.getString(3);
			arr.add(new tipObject(tip, link));
		}
		return arr;
	}
}
