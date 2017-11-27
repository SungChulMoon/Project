package InnerClass;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;

import java.net.URL;
import java.util.logging.Handler;

/**
 * Thread를 통하여 현재날씨를 가지고 있는 Json값을 읽어 오기 위한 클래스
 * @author Moon light
 * @see Thread
 */

public class AsyncDownThread extends Thread {

	private String addr;
	setLocation sl = new setLocation();
	public AsyncDownThread(String addr) {
		this.addr = addr;

	}
	public void run() {
		String result = downloadHtml(addr);
		try {
		//	if(DBmethod.addWeather(result)>0) {
			//	System.out.println("현재 날씨가 저장되었습니다.");
			//}
			sl.setfromThread(result);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	private String downloadHtml(String addr) {
		StringBuilder html = new StringBuilder();
		try {
			URL url = new URL(addr);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			if (conn != null) {
				conn.setConnectTimeout(10000);
				// 10초 동안 url가 연결이 안되면 끊어 버려라
				conn.setUseCaches(false);
				// 캐쉬 삭제
				if (conn.getResponseCode() == HttpURLConnection.HTTP_OK) {
					// 버퍼 사용해서 속도 상승
					BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
					while (true) {
						String line = br.readLine();
						if (line == null)
							break;//문장이 없으면 끝내라
						html.append(line+"\n");
						
					}
					br.close();
				}
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return html.toString();
	}
}
