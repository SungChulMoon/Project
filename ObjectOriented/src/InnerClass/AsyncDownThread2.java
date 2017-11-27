package InnerClass;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;

import java.net.URL;
import java.util.logging.Handler;
/**
 * Thread�� ���Ͽ� 5�ϰ��� ���� ������ ������ �ִ� Json���� �о� ���� ���� Ŭ����
 * @author Moon light
 * @see Thread
 */

public class AsyncDownThread2 extends Thread {

	private String addr;
	setLocation sl = new setLocation();
	public AsyncDownThread2(String addr) {
		this.addr = addr;

	}
	public void run() {
		String result = downloadHtml(addr);
		try {
		//	if(DBmethod.foreWeather(result)>0) {
			//	System.out.println("����:"+result);
			//}
			sl.setfromThread2(result);
			
			
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
				// 10�� ���� url�� ������ �ȵǸ� ���� ������
				conn.setUseCaches(false);
				// ĳ�� ����
				if (conn.getResponseCode() == HttpURLConnection.HTTP_OK) {
					// ���� ����ؼ� �ӵ� ���
					BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
					while (true) {
						String line = br.readLine();
						if (line == null)
							break;//������ ������ ������
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