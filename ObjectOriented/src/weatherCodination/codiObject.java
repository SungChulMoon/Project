package weatherCodination;

import weatherCodination.*;
import java.util.Random;

/**
 * �ϼ��� �ڵ� ��ü
 * 
 * @author ����
 * @see clothObject
 */
public class codiObject {
	/**���� ���� �����ϱ� ���� ���� ��ü*/
	Random random=new Random();
	
	/**
	 * �ڵ� �Ϸ�� outer��ü
	 * */
	outer codiOuter;
	/**�ڵ� �Ϸ�� top��ü
	 * */
	top codiTop;
	/**�ڵ� �Ϸ�� pants��ü*/
	pants codiPants;
	/**�ڵ� �Ϸ�� shoes��ü*/
	shoes codiShoes;
	
	
	/**
	 * �ϼ��ڵ� ��ü�� �����ϱ� ���� ������
	 * �������� �켱 ���� ��Ʈ�������� ���� �����ؼ� �ڵ� �ϼ��Ѵ�.
	 * */
	codiObject() {
		System.out.println(random.nextInt(3));
		codiOuter=addCloth.clo_outer.get(matchCloth.priorityMatrix[0][random.nextInt(3)]);
		codiTop=addCloth.clo_top.get(matchCloth.priorityMatrix[1][random.nextInt(3)]);
		codiPants=addCloth.clo_pants.get(matchCloth.priorityMatrix[2][random.nextInt(3)]);
		codiShoes=addCloth.clo_shoes.get(matchCloth.priorityMatrix[3][random.nextInt(3)]);
		
	}
}