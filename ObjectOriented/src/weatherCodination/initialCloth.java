package weatherCodination;

import java.awt.Image;
import java.util.*;

import javax.swing.ImageIcon;

/** 
 * 옷 객체를 생성하는 클래스
 * 
 * @author 지우
 * 
 */
public class initialCloth {
	/**아우터 객체를 담고 있는 ArrayList*/
	static public ArrayList<outer> clo_outer = new ArrayList<outer>();
	/**상의 객체를 담고 있는 ArrayList*/
	static public ArrayList<top> clo_top = new ArrayList<top>();
	/**하의 객체를 담고 있는 ArrayList*/
	static public ArrayList<pants> clo_pants = new ArrayList<pants>();
	/**신발 객체를 담고 있는 ArrayList*/
	static public ArrayList<shoes> clo_shoes = new ArrayList<shoes>();

	/**이미지 경로를 담아두는 String*/
	String imgPath = "src/clothes/";

	/**
	 * addCloth의 생성자
	 * 
	 * */
	initialCloth(String sex) { //매개변수로 성별 가져와서 객체 생성
		this.initialOuter(sex);
		this.initialTop(sex);
		this.initialPants(sex);
		this.initialShoes(sex);
	}

	
	/**
	 * 초기 outer객체를 생성해 ArrayList인 clo_outer에 삽입하는 함수
	 * */
	public void initialOuter(String sex) {
		String outerPath;
		
		String[] w_initialOuter= {"cardigan1.PNG", "coat1.PNG","coat2.PNG","coat3.PNG","coat4.PNG","coat5.PNG",
				"pd1.PNG","pd2.PNG","pd3.PNG","pd4.PNG"};
		String[] w_link= {"https://codibook.net/","https://codibook.net/","https://codibook.net/","https://codibook.net/item/7767169","https://codibook.net/item/7786366",
				"https://ko.codibook.net/item/7786180","https://codibook.net/item/7780295?recStrategy=004061","https://codibook.net/codi/7502288","https://codibook.net/","https://codibook.net/"};
		
		int[] w_thick={1,3,3,3,4,3,5,5,3,2};
		int[][] w_style= {{3,0,1,3},{5,0,2,2},{5,0,2,4},{5,0,5,2},{0,5,0,5},
						{2,3,0,5},{3,3,0,3},{0,5,0,3},{3,4,0,3},{2,2,0,5}};
		int[] w_weather= {2,2,2,2,2,2,2,2,2,2};
		
		if(sex=="여자") {
			outerPath = imgPath + "outer/";

			for (int i = 0; i < w_initialOuter.length; i++) {
				ImageIcon icon = new ImageIcon(outerPath + w_initialOuter[i]);
				Image img = icon.getImage();
				Image changedImg = img.getScaledInstance(250, 250, Image.SCALE_SMOOTH);

				outer tmp = new outer(w_weather[i], w_thick[i], w_style[i], changedImg, w_link[i]);
				clo_outer.add(tmp);
			}
		}else {
			//남자일 때
			outerPath = imgPath + "outer/man/";
		}
	
	}
	/**
	 * 초기 top객체를 생성해 ArrayList인 clo_top에 삽입하는 함수
	 * */
	public void initialTop(String sex)  {
		String topPath;
		String[] initialtop= {"mtm1.PNG", "nt1.PNG","nt2.PNG","nt3.PNG","nt4.PNG","nt5.PNG",
								"nt6.PNG","nt6.PNG","nt8.PNG","shirts1.PNG","shirts2.PNG","shirts3.PNG","t1.PNG"};
		
		int[] thick={3,4,4,5,5,3,5,4,4,2,2,2,2};
		int[][] style= {{3,3,0,3},{3,3,3,2},{5,0,5,3},{2,3,0,3},{3,3,0,4},
						{0,5,0,0},{1,5,0,0},{3,3,3,2},{0,2,0,5},{5,0,5,5},{5,0,3,3},{3,0,0,5},{3,3,3,3}};
		
		String[] link= {"https://codibook.net/item/7780475?recStrategy=004061","https://codibook.net/","https://codibook.net/","https://codibook.net/","https://codibook.net/",
				"https://codibook.net/","https://codibook.net/","https://codibook.net/","https://codibook.net/","https://codibook.net/",
				"https://codibook.net/","https://codibook.net/","https://codibook.net/"};
		int[] weather= {2,2,2,2,2,2,2,2,2,2,2,2,2};

		if (sex == "여자") {
			topPath=imgPath+"pants/";
			
			for (int i = 0; i < initialtop.length; i++) {
				ImageIcon icon = new ImageIcon(topPath + initialtop[i]);
				Image img = icon.getImage();
				Image changedImg = img.getScaledInstance(250, 250, Image.SCALE_SMOOTH);

				top tmp = new top(weather[i], thick[i], style[i], changedImg, link[i]);
				clo_top.add(tmp);
			}
		}
	}
	/**
	 * 초기 pants객체를 생성해 ArrayList인 clo_pants에 삽입하는 함수
	 * */
	public void initialPants(String sex)  {
		String pantsPath;
		String[] initialPants= {"pants1.PNG","pants2.PNG","pants3.PNG","pants4.PNG","pants5.PNG",
				"skt1.PNG","skt2.PNG","skt3.PNG","skt4.PNG","skt5.PNG"};
		
		String[] link= {"https://codibook.net/","https://codibook.net/","https://codibook.net/","https://codibook.net/item/7774804","https://codibook.net/item/7639641",
				"https://codibook.net/","https://codibook.net/","https://codibook.net/","https://codibook.net/","https://codibook.net/"};
		
		int[] thick={3,3,3,3,3,4,4,4,4,3};
		int[][] style= {{5,2,3,3},{3,2,3,4},{0,0,0,5},{3,2,0,5},{5,2,2,3},
						{2,5,5,0},{2,0,0,5},{4,0,2,3},{0,5,3,5},{5,0,4,1}};
		int[] weather= {2,2,2,2,2,2,2,2,2,2};
		
		if (sex == "여자") {
			pantsPath=imgPath+"pants/";
			
			for (int i = 0; i < initialPants.length; i++) {
				ImageIcon icon = new ImageIcon(pantsPath + initialPants[i]);
				Image img = icon.getImage();
				Image changedImg = img.getScaledInstance(250, 250, Image.SCALE_SMOOTH);

				pants tmp = new pants(weather[i], thick[i], style[i], changedImg, link[i]);
				clo_pants.add(tmp);
			}
		} else {

		}
	}
	
	/**
	 * 초기 shoes객체를 생성해 ArrayList인 clo_shoes에 삽입하는 함수
	 * */
	public void initialShoes(String sex)  {
		String shoesPath;
		String[] initialShoes= {"sh1.PNG","sh2.PNG","sh3.PNG","sh4.PNG","sh5.PNG","sh6.PNG"};
		
		int[] thick={2,3,4,3,5,3};
		int[][] style= {{1,5,3,2},{5,1,2,5},{5,0,0,5},{5,5,0,5},{3,3,3,2},
						{4,4,1,4}};
		
		String[] link={"https://codibook.net/","https://codibook.net/","https://codibook.net/","https://codibook.net/","https://codibook.net/","https://codibook.net/"};
		int[] weather= {2,2,2,2,2,2};

		if (sex == "여자") {
			shoesPath = imgPath + "shoes/";
			for (int i = 0; i < initialShoes.length; i++) {
				ImageIcon icon = new ImageIcon(shoesPath + initialShoes[i]);
				Image img = icon.getImage();
				Image changedImg = img.getScaledInstance(250, 250, Image.SCALE_SMOOTH);

				shoes tmp = new shoes(weather[i], thick[i], style[i], changedImg, link[i]);
				clo_shoes.add(tmp);
			}
		}
	}
}
