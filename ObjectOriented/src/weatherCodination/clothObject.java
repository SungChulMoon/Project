package weatherCodination;

import java.awt.Image;


/** 
 * �ڵ� �ʿ��� �� Ŭ����
 * �� Ŭ������ �ڵ� �ʿ��� �� ��ü�� �����Ѵ�.
 * 
 * @author ����
 * 
 */

public class clothObject {
	/**�β����� ��Ÿ���� int ����*/
	int thick;
	/**��Ÿ���� ��Ÿ���� int�迭 ����*/
	int[] style=new int [4];
	/**���� �̹����� ��Ÿ���� Image ����*/
	Image image;
	/**���θ� ��ũ�� ��Ÿ���� String ����*/
	String link;
	
	/**
	 * �� ��ü�� ������
	 * 
	 * @param th ���� �β���
	 * @param st ���� ��Ÿ�� �迭
	 * @param img �� �̹���
	 * @param lk ���θ� ��ũ
	 */
	clothObject(int th, int[] st, Image img, String lk) {
		thick=th;
		for(int i=0; i<4; i++) {
			style[i]=st[i];
		}
		image=img;
		link=lk;
	}
}


/**
 * �ѿ��� ������ ��� outerŬ����.
 * 
 * @author ����
 * @see clothObject
 */
class outer extends clothObject{
	
	outer(int th, int[] st, Image img, String link) {
		super(th, st, img, link);
	}
};
/**
 * ������ ������ ��� topŬ����.
 * 
 * @author ����
 * @see clothObject
 */
class top extends clothObject{
	top(int th, int[] st, Image img, String link) {
		super(th, st, img, link);
	}
};
/**
 * ������ ������ ��� pantsŬ����.
 * 
 * @author ����
 * @see clothObject
 */
class pants extends clothObject{
	pants(int th, int[] st, Image img, String link) {
		super(th, st, img, link);
	}
};
/**
 * �Ź��� ������ ��� shoesŬ����.
 * 
 * @author ����
 * @see clothObject
 */
class shoes extends clothObject{
	shoes(int th, int[] st, Image img, String link) {
		super(th, st, img, link);
	}
};