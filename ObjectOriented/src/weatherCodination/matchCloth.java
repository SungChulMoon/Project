package weatherCodination;

import java.util.*;

enum tempState {WARM_4,WARM_3,WARM_2,WARM_1,COLD_1,COLD_2,COLD_3,COLD_4} 

/**
 * �������� ���� �����ͷ� ���� ��Ī�ϴ� Ŭ����
 * 
 * @author ����
 *
 */
public class matchCloth {		
	/**��¿� ���� ���� ���¸� �����ϴ� ����*/
	tempState tempST;
	/**�켱������ ���ϱ� ���� �β����� �δ� ����ġ*/
	static int thick_weight;
	/**�켱������ ���ϱ� ���� ��Ÿ�Ͽ� �δ� ����ġ*/
	static int style_weight;
	/**�ʸ��� ����ġ�� ���� ���� ����� ������ �� ��Ʈ����*/
	public static int[][] clothMatrix=new int [4][];
	/**�� ��Ʈ������ ���ؼ� ���� ���� ���� �켱���� 1~3���� ������ �켱���� ��Ʈ����*/
	public static int[][] priorityMatrix=new int[4][3];
	/**DB�� ���� ���� ��Ÿ�� String�� ������ String �迭*/
	String[] styleArray;
	
	/**�� ��Ī Ŭ������ �����ϴ� ������
	 * 
	 * @param temp ���� ���
	 * @param styleSt String������ ������ style ���ڿ�
	 * @param sizeSt ������ style���� ���ڿ�
	 * */
	matchCloth(int temp, String styleSt, String sizeSt) {
		parameterTranslate(styleSt, sizeSt);
		weightAssignment(temp);
		produceClothMatrix();
		priorityMatrix();
	}
	
	/**
	 * DB�� ���� ���� �Ű������� ���� ���ϰ� �����ϴ� �Լ� 
	 * @param styleSt DB�� ���ؼ� ������ style ���ڿ�
	 * @param sizeSt DB�� ���ؼ� ������ ������ style ���� ���ڿ�
	 */
	public void parameterTranslate(String styleSt, String sizeSt){
		int size=Integer.parseInt(sizeSt);
		
		styleArray=new String [size];
		StringTokenizer tokens = new StringTokenizer(styleSt);
		
		for(int i=0; i<size; i++) {
			styleArray[i]=tokens.nextToken(",");
		}
	}
	
		/**
		 * ���� �µ��� ����  ���¸� ���� �� ����ġ�� �ο��ϴ� �Լ�
		 * @param temp ���� �µ�
		 */
	public void weightAssignment(int temp) {	
		if(temp>27) tempST= tempState.WARM_4;
		else if(temp<=27 && temp>23) tempST= tempState.WARM_3;
		else if(temp<=23 && temp>20) tempST= tempState.WARM_2;
		else if(temp<=20 && temp>17) tempST= tempState.WARM_1;
		else if(temp<=17 && temp>12) tempST= tempState.COLD_1;
		else if(temp<=12 && temp>10) tempST= tempState.COLD_2;
		else if(temp<=12 && temp>6) tempST= tempState.COLD_3;
		else  tempST= tempState.COLD_4;
		
		switch(tempST) {
		case WARM_4:
			thick_weight=80;
			break;
		case WARM_3:
			thick_weight=60;
			break;
		case WARM_2:
			thick_weight=40;
			break;
		case WARM_1:
			thick_weight=20;
			break;
		case COLD_1:
			thick_weight=20;
			break;
		case COLD_2:
			thick_weight=40;
			break;
		case COLD_3:
			thick_weight=60;
			break;
		case COLD_4:
			thick_weight=80;
			break;
		}
		
		style_weight=100-thick_weight;
	}
	/**
	 * ����ġ�� ���� ���� ����� ���� ���� �� ��Ʈ����
	 */
	private void produceClothMatrix() {
		int score;
		int cnt=0;
		int style;
		int n;
		
		clothMatrix[0]=new int[addCloth.clo_outer.size()];
		clothMatrix[1]=new int[addCloth.clo_top.size()];
		clothMatrix[2]=new int[addCloth.clo_pants.size()];
		clothMatrix[3]=new int[addCloth.clo_shoes.size()];
		
		
		Random random=new Random();
		n=random.nextInt(styleArray.length);
		
		if(styleArray[n].equals("��ũ")) {
			style=0;
		}else if(styleArray[n].equals("ťƼ")){
			style=1;
		}else if(styleArray[n].equals("����")){
			style=2;
		}else	style=3;

	
		for(int i=0; i<addCloth.clo_outer.size(); i++) {
			score=(int)(addCloth.clo_outer.get(i).thick*matchCloth.thick_weight+addCloth.clo_outer.get(i).style[style]*matchCloth.style_weight)/10;
			clothMatrix[0][i]=score;
		}
		
		for(int i=0; i<addCloth.clo_top.size(); i++) {
			score=(int)(addCloth.clo_top.get(i).thick*matchCloth.thick_weight+addCloth.clo_top.get(i).style[style]*matchCloth.style_weight)/10;
			clothMatrix[1][i]=score;
		}
		for(int i=0; i<addCloth.clo_pants.size(); i++) {
			score=(int)(addCloth.clo_pants.get(i).thick*matchCloth.thick_weight+addCloth.clo_pants.get(i).style[style]*matchCloth.style_weight)/10;
			clothMatrix[2][i]=score;
		}
		for(int i=0; i<addCloth.clo_shoes.size(); i++) {
			score=(int)(addCloth.clo_shoes.get(i).thick*matchCloth.thick_weight+addCloth.clo_shoes.get(i).style[style]*matchCloth.style_weight)/10;
			clothMatrix[3][i]=score;
		}
	}
	/**
	 * �켱���� ��Ʈ������ ����� Ŭ����
	 * 
	 * @param n �ʸ����� ��
	 */
	private void producePriorityMatrix(int n) {
		priorityMatrix[n][0]=0;
		
		for(int i=1; i<clothMatrix[n].length; i++) {
			if(clothMatrix[n][priorityMatrix[n][0]]<=clothMatrix[n][i]) {
				for(int j=1; j<3; j++) {
					priorityMatrix[n][3-j]=priorityMatrix[n][3-j-1];
				}
				priorityMatrix[n][0]=i;
			}else if(clothMatrix[n][priorityMatrix[n][1]]<=clothMatrix[n][i] && clothMatrix[n][priorityMatrix[n][2]]>clothMatrix[n][i]) {
				priorityMatrix[n][2]=priorityMatrix[n][1];
				priorityMatrix[n][1]=i;
			}else if(clothMatrix[n][priorityMatrix[n][2]]<=clothMatrix[n][i]) {
				priorityMatrix[n][2]=i;
			}
		}
	}
	/**
	 * �켱���� ��Ʈ������ �ʱ�ȭ �ϰ�, �켱���� ��Ʈ������ �����ϴ� �Լ��� ȣ���ϴ� �Լ�
	 */
	private void priorityMatrix() {	
		for(int i=0; i<4; i++) {
			for(int j=0; j<3; j++) {
				priorityMatrix[i][j]=0;
			}
		}
			
		producePriorityMatrix(0);
		producePriorityMatrix(1);
		producePriorityMatrix(2);
		producePriorityMatrix(3);	
	
	}
	
}