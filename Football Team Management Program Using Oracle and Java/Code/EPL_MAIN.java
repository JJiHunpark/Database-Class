//http://mainichibenkyo.tistory.com/53
package EPLTEAM;
import java.util.*;
public class EPL_MAIN {

	public static void main(String args[]) {
		Scanner scan = new Scanner(System.in);
		int mainNo, cmdNo, cmdNo2, cmdNo3 = 0;
		
		System.out.println("---EPLSP_MAIN---");
		System.out.println("[[�����Ͻ� �޴��� �����Ͻʽÿ�.]]");
		System.out.println("�Ǧ�������������������������������������������������������");
		System.out.println("  1.�� ���� �� 2.���� ����  �� 3.���� ���� �� 4.����  ");
		System.out.println("�Ŧ�������������������������������������������������������");
		System.out.print("=> ");
		
		mainNo = scan.nextInt() ;
		System.out.println("");
		
		if(mainNo == 1) {		//������
			while (true) {
				System.out.println("");
				System.out.println("---EPLSP_TEAM---");
				System.out.println("[[���ϴ� �޴��� �����Ͻʽÿ�.]]");
				System.out.println("�Ǧ���������������������������������������������������������������������������������");
				System.out.println("  1.�� ��ȸ �� 2.�� ���� ���� �� 3.�� ���� �� 4.���ο� �� �߰� �� 5.����    ");
				System.out.println("  ��eTc.6.�˻���                                                                                                                 ");
				System.out.println("�Ŧ���������������������������������������������������������������������������������");
				System.out.print("=> ");
				cmdNo = scan.nextInt();
				System.out.println("");
				
				if (cmdNo == 1) {
					EPL_TEAM select = new EPL_TEAM(); // ��ȸ Ŭ������ ��ü ����
					select.selectMethod(); // ��ȸ Ŭ������ ��ȸ �޼ҵ� ����
				}
				else if (cmdNo == 2) {
					EPL_TEAM update = new EPL_TEAM(); // ���� Ŭ������ ��ü ����
					update.updateMethod(); // ���� Ŭ������ ���� �޼ҵ� ����
				}
				else if (cmdNo == 3) {
					EPL_TEAM delete = new EPL_TEAM(); // ���� Ŭ������ ��ü ����
					delete.deleteMethod(); // ���� Ŭ������ ���� �޼ҵ� ����
				}
				else if (cmdNo == 4) {
					EPL_TEAM insert = new EPL_TEAM(); // �Է� Ŭ������ ��ü ����
					insert.insertMethod(); // �Է� Ŭ������ �Է� �޼ҵ� ����
				}
				else if (cmdNo == 6) {
					EPL_TEAM insert = new EPL_TEAM(); // �Է� Ŭ������ ��ü ����
					insert.textra_round(); // �Է� Ŭ������ �Է� �޼ҵ� ����
				}
				else {
					System.out.println("�� �� �Է��ϼ̽��ϴ�.");
					scan.close();
					break ;
				}			
			}
		} //mainNo == 1
		
		else if(mainNo == 2) {		//��������
			while (true) {
				System.out.println("");
				System.out.println("---EPLSP_MANAGER---");
				System.out.println("[[���ϴ� �޴��� �����Ͻʽÿ�.]]");
				System.out.println("�Ǧ���������������������������������������������������������������������������������������");
				System.out.println("  1.���� ��ȸ �� 2.���� ���� ���� �� 3.���� ���� �� 4.���ο� ���� �߰� �� 5.����   ");
				System.out.println("  ��eTc.6.�˻���                                                                                                                               ");
				System.out.println("�Ŧ���������������������������������������������������������������������������������������");
				System.out.print("=> ");
				cmdNo2 = scan.nextInt();
				System.out.println("");
				
				if (cmdNo2 == 1) {
					EPL_MANAGER select = new EPL_MANAGER(); // ��ȸ Ŭ������ ��ü ����
					select.selectMethod(); // ��ȸ Ŭ������ ��ȸ �޼ҵ� ����
				}
				else if (cmdNo2 == 2) {
					EPL_MANAGER update = new EPL_MANAGER(); // ���� Ŭ������ ��ü ����
					update.updateMethod(); // ���� Ŭ������ ���� �޼ҵ� ����
				}
				else if (cmdNo2 == 3) {
					EPL_MANAGER delete = new EPL_MANAGER(); // ���� Ŭ������ ��ü ����
					delete.deleteMethod(); // ���� Ŭ������ ���� �޼ҵ� ����
				}
				else if (cmdNo2 == 4) {
					EPL_MANAGER insert = new EPL_MANAGER(); // �Է� Ŭ������ ��ü ����
					insert.insertMethod(); // �Է� Ŭ������ �Է� �޼ҵ� ����
				}
				else if (cmdNo2 == 6) {
					EPL_MANAGER insert = new EPL_MANAGER(); // �Է� Ŭ������ ��ü ����
					insert.extra_round(); // �Է� Ŭ������ �Է� �޼ҵ� ����
				}
				else {
					System.out.println("�� �� �Է��ϼ̽��ϴ�.");
					scan.close();
					break ;
				}			
			}
		}//mainNO == 2
		
		else if(mainNo == 3) {		//��������
			while (true) {
				System.out.println("");
				System.out.println("---EPLSP_PLAYER---");
				System.out.println("[[���ϴ� �޴��� �����Ͻʽÿ�.]]");
				System.out.println("�Ǧ���������������������������������������������������������������������������������������");
				System.out.println("  1.���� ��ȸ �� 2.���� ���� ���� �� 3.���� ���� �� 4.���ο� ���� �߰� �� 5.����  " );
				System.out.println("  ��eTc.6.�˻���                                                                                                                         ");
				System.out.println("�Ŧ���������������������������������������������������������������������������������������");
				System.out.print("=> ");

				cmdNo3 = scan.nextInt();
				System.out.println("");
				
				if (cmdNo3 == 1) {
					EPL_PLAYER select = new EPL_PLAYER(); // ��ȸ Ŭ������ ��ü ����
					select.selectMethod(); // ��ȸ Ŭ������ ��ȸ �޼ҵ� ����
				}
				else if (cmdNo3 == 2) {
					EPL_PLAYER update = new EPL_PLAYER(); // ���� Ŭ������ ��ü ����
					update.updateMethod(); // ���� Ŭ������ ���� �޼ҵ� ����
				}
				else if (cmdNo3 == 3) {
					EPL_PLAYER delete = new EPL_PLAYER(); // ���� Ŭ������ ��ü ����
					delete.deleteMethod(); // ���� Ŭ������ ���� �޼ҵ� ����
				}
				else if (cmdNo3 == 4) {
					EPL_PLAYER insert = new EPL_PLAYER(); // �Է� Ŭ������ ��ü ����
					insert.insertMethod(); // �Է� Ŭ������ �Է� �޼ҵ� ����
				}
				else if (cmdNo3 == 6) {
					EPL_PLAYER insert = new EPL_PLAYER(); // �Է� Ŭ������ ��ü ����
					insert.pextra_round(); // �Է� Ŭ������ �Է� �޼ҵ� ����
				}
				else {
					System.out.println("�� �� �Է��ϼ̽��ϴ�.");
					scan.close();
					break ;
				}			
				
			}
		}//mainNO == 3
		else if(mainNo == 4) {
			scan.close();
		}//mainNO == 4
		else 
			System.out.println("�߸� �Է��ϼ̽��ϴ�.");
	}
}