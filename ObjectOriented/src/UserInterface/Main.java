package UserInterface;

import weatherCodination.*;
//날씨에 getnowweatherParsed에 매개변수로 아이디를 넣어 비교하여 마지막 것을 가져오게한다
//

import javax.swing.*;
import java.awt.event.*;
import java.io.IOException;
import java.net.*;
import java.awt.*;
import javax.swing.border.EmptyBorder;

import InnerClass.DBmethod;
import InnerClass.LineChartEx2;
import InnerClass.User;
import InnerClass.getNowWeather;
import InnerClass.nowWeather;
import InnerClass.setLocation;
import InnerClass.tipObject;

/**
 * 유저들의 정보를 읽어오고 현재날씨 와 예상날씨를 매칭을하여 Display하는 클래스
 * @author Moon light
 * @see JFrame
 */
public class Main extends JFrame {
	LineChartEx2 ex;
	ImageIcon weatherIcon;
	ImageIcon weatherIcon2;
	private JPanel contentPane;
	private JTextField tf_local;
	private JLabel la_tip0;
	private JLabel la_tip1;
	private JLabel la_tip2;	
	private JLabel la_weather1;
	private JLabel la_weather3;
	private JLabel la_weather2;
	private JLabel lb_local;
	nowWeather nowinfo ;
	codiDisplay ts;
	User us;
	String location="";
	String weather="";
	String weather2="";
	private JPanel panel;
	private JPanel panel_1;
	private JLabel lb_now_weather;
	private JPanel panel_forecast;
	private JPanel panel_style;

	public Main(String id) {


			setLocation sl = new setLocation();
		try {
			us = DBmethod.getUserinfo(id);
			sl.setlocal(us.getLocation());
			sl.joinThread();
			System.out.println("현재 메인"+sl.getResult());
			getNowWeather.addParsingNowWeather();
			
			nowinfo = DBmethod.getNowweatherParsed();
			System.out.println("현재온도 "+nowinfo.getTemp());
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		Image img = toolkit.getImage("src/Icon.png");
		setIconImage(img);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(300, 50, 1151, 1109);
		setTitle("웨더리쉬");
		setResizable(true);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);
		
		tf_local = new JTextField();
		tf_local.setBounds(110, 45, 905, 40);
		contentPane.add(tf_local);
		tf_local.setColumns(10);
		
		
		ImageIcon Icon_search = new ImageIcon("src/search.PNG");
		ImageIcon Icon_refresh = new ImageIcon("src/refresh.PNG");
		JButton btn_search = new JButton(Icon_search);
		btn_search.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				sl.stopThread();
				if(tf_local.getText().equals("광주")) {
					location ="Gwangju";
				}
				else if(tf_local.getText().equals("서울")) {
					location = "Seoul";
				}
				else if(tf_local.getText().equals("부산")) {
					location ="Busan";
				}
				else {
					location =tf_local.getText();
				}
				sl.setlocal(location);
				
				try {
					sl.joinThread();
					getNowWeather.addParsingNowWeather();
					nowinfo = DBmethod.getNowweatherParsed();
					lb_local.setText("지역 : "+ nowinfo.getLocation());
					System.out.println("새로 검색된 지역"+nowinfo.getLocation());
					la_weather1.setText("현재기온 : "+nowinfo.getTemp());
					la_weather2.setText("최저 기온 : "+nowinfo.getMaxtemp());
					la_weather3.setText("최고 기온 : "+nowinfo.getMintemp());
					lb_now_weather.setText("현재 날씨 : "+nowinfo.getMain());
					setphoto(nowinfo.getMain());
					
//					ex.removeAll();
					panel_forecast.remove(ex);
					
					ex = new LineChartEx2();
					panel_forecast.add(ex);
					panel_forecast.repaint();
					
					weatherIcon = new ImageIcon(weather);
					weatherIcon2 = new ImageIcon(weather2);
					
					ts.removeAll();
					ts = new codiDisplay(us.getGender(), id, nowinfo.getTemp(),us.getSty_str(), us.getSty_size());
					ts.setBounds(17, 723, 1090, 279);
					ts.setOpaque(false);
					contentPane.add(ts);
					ts.repaint();
					
					
					System.out.println(us.getGender());
					
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
				repaint();
			}
		});
		btn_search.setBackground(Color.WHITE);
		btn_search.setBounds(1056, 45, 40, 40);
		contentPane.add(btn_search);
		
		String tip0 = "일교차가 큽니다. 겉옷을 챙기세요";
		String tip0_link = "http://store.musinsa.com/app/product/detail/601276/0";
		la_tip0 = new JLabel(tip0);
		la_tip0.setFont(new Font("나눔바른고딕", Font.PLAIN, 20));
		la_tip0.setBackground(Color.WHITE);
		la_tip0.setBounds(65, 565, 460, 40);
		la_tip0.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		la_tip0.addMouseListener(new MouseAdapter() {
		   public void mouseClicked(MouseEvent e) {
		      if (e.getClickCount() > 0) {
		          if (Desktop.isDesktopSupported()) {
		                Desktop desktop = Desktop.getDesktop();
		                try {
		                    URI uri = new URI(tip0_link);
		                    desktop.browse(uri);
		                } catch (IOException ex) {
		                    ex.printStackTrace();
		                } catch (URISyntaxException ex) {
		                    ex.printStackTrace();
		                }
		        }
		      }
		   }
		});
		contentPane.add(la_tip0);
	
		String tip1 = "소풍 가기 좋은 날씨입니다!! 돗자리를 챙기세요";
		String tip1_link = "http://storefarm.naver.com/mimidari/products/659638670?NaPm=ct%3Dja14njcw%7Cci%3Dfca87b58a32d5807ab5dab601eb1fcd2ba139745%7Ctr%3Dslsl%7Csn%3D354611%7Cic%3D%7Chk%3Def8b50cac278a181c51e2ad775eddd013cab74bb";
		la_tip1 = new JLabel(tip1);
		la_tip1.setFont(new Font("나눔바른고딕", Font.PLAIN, 20));
		la_tip1.setBackground(Color.WHITE);
		la_tip1.setBounds(65, 639, 460, 40);
		la_tip1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		la_tip1.addMouseListener(new MouseAdapter() {
		   public void mouseClicked(MouseEvent e) {
		      if (e.getClickCount() > 0) {
		          if (Desktop.isDesktopSupported()) {
		                Desktop desktop = Desktop.getDesktop();
		                try {
		                    URI uri = new URI(tip1_link);
		                    desktop.browse(uri);
		                } catch (IOException ex) {
		                    ex.printStackTrace();
		                } catch (URISyntaxException ex) {
		                    ex.printStackTrace();
		                }
		        }
		      }
		   }
		});
		contentPane.add(la_tip1);
		
		String tip2 = "tip2";
		String tip2_link = "http://naver.com";
		la_tip2 = new JLabel(tip2);
		la_tip2.setFont(new Font("나눔바른고딕", Font.PLAIN, 20));
		la_tip2.setBackground(Color.WHITE);
		la_tip2.setBounds(110, 695, 460, 40);
		la_tip2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		la_tip2.addMouseListener(new MouseAdapter() {
		   public void mouseClicked(MouseEvent e) {
		      if (e.getClickCount() > 0) {
		          if (Desktop.isDesktopSupported()) {
		                Desktop desktop = Desktop.getDesktop();
		                try {
		                    URI uri = new URI(tip2_link);
		                    desktop.browse(uri);
		                } catch (IOException ex) {
		                    ex.printStackTrace();
		                } catch (URISyntaxException ex) {
		                    ex.printStackTrace();
		                }
		        }
		      }
		   }
		});
		contentPane.add(la_tip2);
		

		
		System.out.println(nowinfo.getMain());
		setphoto(nowinfo.getMain());
		
		weatherIcon = new ImageIcon(weather);
		
		weatherIcon2 = new ImageIcon(weather2);
		la_weather1 = new JLabel("현재온도 : ");
		la_weather1.setFont(new Font("굴림", Font.PLAIN, 23));
		la_weather1.setBounds(40, 128, 150, 65);
		contentPane.add(la_weather1);
		
		la_weather2 = new JLabel("\uCD5C\uC800 \uAE30\uC628 : ");
		la_weather2.setFont(new Font("굴림", Font.PLAIN, 23));
		la_weather2.setBounds(193, 128, 150, 65);
		contentPane.add(la_weather2);
		
		la_weather3 = new JLabel("\uCD5C\uACE0 \uAE30\uC628 : ");
		la_weather3.setFont(new Font("굴림", Font.PLAIN, 23));
		la_weather3.setBounds(344, 128, 150, 65);
		contentPane.add(la_weather3);
		
		lb_local = new JLabel("\uC9C0\uC5ED : ");
		lb_local.setFont(new Font("굴림", Font.PLAIN, 25));
		lb_local.setBounds(110, 97, 228, 28);
		contentPane.add(lb_local);
		lb_now_weather = new JLabel("\uD604\uC7AC \uB0A0\uC528 : ");
		lb_now_weather.setFont(new Font("굴림", Font.PLAIN, 25));
		lb_now_weather.setBounds(40, 200, 228, 21);
		contentPane.add(lb_now_weather);
		lb_local.setText("지역 : "+ nowinfo.getLocation());
		la_weather1.setText("현재기온 : "+nowinfo.getTemp());
		la_weather2.setText("최저 기온 : "+nowinfo.getMaxtemp());
		la_weather3.setText("최고 기온 : "+nowinfo.getMintemp());
		lb_now_weather.setText("현재 날씨 : "+nowinfo.getMain());
		panel = new JPanel() {
			public void paintComponent(Graphics g) {
				g.drawImage(weatherIcon.getImage(),0,0, this.getWidth(),this.getHeight(),null);
			}
		};
		
		panel.setBounds(40, 250, 200, 200);
		contentPane.add(panel);
		
		panel_1 = new JPanel() {
			public void paintComponent(Graphics g) {
			g.drawImage(weatherIcon2.getImage(),0,0, this.getWidth(),this.getHeight(),null);
		}};
		panel_1.setBounds(286, 250, 200, 200);
		contentPane.add(panel_1);
		
	
		
		panel_forecast = new JPanel();
		panel_forecast.setBounds(495, 126, 633, 442);
		contentPane.add(panel_forecast);
		ex = new LineChartEx2();
		panel_forecast.add(ex);
		panel_forecast.setOpaque(false);
		
		ts = new codiDisplay(us.getGender(), id, nowinfo.getTemp(),us.getSty_str(), us.getSty_size());
		ts.setBounds(17, 723, 1090, 279);
		ts.setOpaque(false);
		contentPane.add(ts);
	
	
		
	}
	public void setphoto(String main) {
		switch (nowinfo.getMain()) {
		case "Clear":
			weather ="src/sun1.png";
			weather2 ="src/sun2.png";
			break;
		case "Rain":
		case "Drizzle":
			weather ="src/rain1.png";
			weather2 ="src/rain2.png";
			break;
		case "Mist":
		case "Haze":
		case "Fog":
			weather = "src/fog1.png";
			weather2 = "src/fog2.png";
			break;
		case "Clouds":
			weather = "src/cloudy1.png";
			weather2 ="src/cloudy2.png";
			break;
		case "Lightning":
		case "Thunderstorm":
			weather = "src/thunder1.png";
			weather2 = "src/thunder2.png";
			break;
		case "Snow":
			weather ="src/snow1.png";
			weather2 ="src/snow2.png";
			break;
		default:
			weather ="src/sun1.png";
			weather ="src/sun2.png";
			break;
		}
	}
	class tiplink extends MouseAdapter{
		tipObject to;
		public tiplink(tipObject to) {
			this.to = to;
		}
		@Override
		public void mouseClicked(MouseEvent e) {
			 if (e.getClickCount() > 0) {
		          if (Desktop.isDesktopSupported()) {
		                Desktop desktop = Desktop.getDesktop();
		                try {
		                    URI uri = new URI(to.getLink());
		                    desktop.browse(uri);
		                } catch (IOException ex) {
		                    ex.printStackTrace();
		                } catch (URISyntaxException ex) {
		                    ex.printStackTrace();
		                }
		        }
		      }
		   }
		}

	
	
}