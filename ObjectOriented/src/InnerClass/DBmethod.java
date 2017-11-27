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
		String url = "jdbc:mysql://168.131.153.176:3306/moon";
		String dbid = "superuser";
		String dbpw = "1234";
		Class.forName("com.mysql.jdbc.Driver");
		conn = DriverManager.getConnection(url, dbid, dbpw);
	}
	public static int addWeather(String getWeather) throws Exception{
		getInfo();
		PreparedStatement pst =conn.prepareStatement("insert into nowweather values(?)");
		pst.setString(1, getWeather);
		
		int cnt = pst.executeUpdate();
		return cnt;
	}
	public static int foreWeather(String getWeather) throws Exception{
		getInfo();
		PreparedStatement pst =conn.prepareStatement("insert into forecastweather values(?)");
		pst.setString(1, getWeather);
		int cnt = pst.executeUpdate();
		return cnt;
	}
	public static String getnowWeahter() throws Exception{
		getInfo();
		ArrayList<String> arr = new ArrayList<>();
		PreparedStatement pst =conn.prepareStatement("select * from nowweather");
		ResultSet rs = pst.executeQuery();
		while(rs.next()) {
			arr.add(rs.getString(1));
		}
		return arr.get(arr.size()-1);
	}
	public static String getforeWeahter() throws Exception{
		getInfo();
		ArrayList<String> arr = new ArrayList<>();
		PreparedStatement pst =conn.prepareStatement("select * from forecastweather");
		ResultSet rs = pst.executeQuery();
		while(rs.next()) {
			arr.add(rs.getString(1));
			System.out.println("예측날씨가 분류되:"+rs.getString(1));
		}
		return arr.get(arr.size()-1);
	}
	public static nowWeather getNowweatherParsed()throws Exception{
		getInfo();
		ArrayList<nowWeather> nowlist = new ArrayList<>();
		PreparedStatement pst =conn.prepareStatement("select * from nowweatherparsered");
		ResultSet rs = pst.executeQuery();
		while(rs.next()) {
			nowlist.add(new nowWeather(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5)));
			
		}
		return nowlist.get(nowlist.size()-1);
	}
	public static int addParseredWeather(String getTemp,String getMaxtemp,String getMintemp, String getmain,String getLocation) throws Exception{
		getInfo();
		PreparedStatement pst =conn.prepareStatement("insert into nowweatherparsered values(?,?,?,?,?)");
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
}
