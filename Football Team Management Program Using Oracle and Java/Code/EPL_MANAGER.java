package EPLTEAM;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class EPL_MANAGER {

	Scanner scan = new Scanner(System.in);  // �� �޼ҵ庰 �ߺ��Ǵ� �׸� ����.
	Scanner scan2 = new Scanner(System.in);
	String driver = "oracle.jdbc.driver.OracleDriver"; 
	String url = "jdbc:oracle:thin:@localhost:1521:orcl";
	
		public void selectMethod() {		//���� ��ȸ
			String sql = "SELECT * FROM MANAGER";
			Connection con = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			
			System.out.println("���� �ڵ� \t���� �� \t��� \t��ุ�� \t����");
			try {
				Class.forName(driver);
				con = DriverManager.getConnection(url, "pjh", "2015150046");
				pstmt = con.prepareStatement(sql);
				rs = pstmt.executeQuery(); 
				while (rs.next()) {
					String managercode = rs.getString("M_CODE"); 
					String managername = rs.getString("M_NAME"); 
					String managerCAREER_Y = rs.getString("M_CAREER_Y");
					String managercontract = rs.getString("M_CONTRACT");	
					String managercontry = rs.getString("M_NATIONALITY");
					System.out.println(managercode + "\t" + managername +  "\t" + managerCAREER_Y + 
							"\t" + managercontract + "\t" + managercontry);
				}
			}		
			catch (Exception e) {System.out.println(e.getMessage());}		
			finally {
				try {rs.close();
					pstmt.close();
					con.close();
				} catch (Exception e) {}
			}
		}
	
	
	
		public void updateMethod() {		//���� ����	
			String sql = "UPDATE MANAGER SET M_CAREER_Y=?, M_CONTRACT=? WHERE M_CODE=?";	
			Connection con = null;
			PreparedStatement pstmt = null;		
			try {
				Class.forName(driver);
				con = DriverManager.getConnection(url, "pjh", "2015150046");
				pstmt = con.prepareStatement(sql);
				
				System.out.printf("������ ������ �ڵ� �Է�: ");
				String managercode = scan.next();
				System.out.printf("������ ���� ��� �Է�(Year): ");
				String managerCAREER_Y = scan2.nextLine();
				System.out.printf("������ ���� ��� �Է�(ex.2019-11-11): ");
				String managercontract = scan2.nextLine();		
				pstmt.setString(1, managerCAREER_Y);
				pstmt.setString(2, managercontract);
				pstmt.setString(3, managercode);
				
				int cnt = pstmt.executeUpdate(); 
				System.out.println(cnt + "���� ����Ǿ����ϴ�.");
			}
			catch (Exception e) {System.out.println(e.getMessage());}
			finally {
				try {				
					pstmt.close();
					con.close();
				} catch (Exception e) {
				}
			}
		}
	

	
		public void deleteMethod() {		//���� ����
			String sql = "DELETE FROM MANAGER WHERE M_CODE = ?";
			String managercode = "";
			
			Connection con = null;
			PreparedStatement pstmt = null;		
			try {
				Class.forName(driver);
				con = DriverManager.getConnection(url, "pjh", "2015150046");
				pstmt = con.prepareStatement(sql);
				
				System.out.print("������ �����ڵ带 �Է��Ͻÿ�: ");
				managercode = scan.next();
				
				pstmt.setString(1, managercode);
				int cnt = pstmt.executeUpdate(); 
				System.out.println(cnt + "���� ����Ǿ����ϴ�.");
			}
			catch (Exception e) {System.out.println(e.getMessage());}
			finally {
				try {
					pstmt.close();
					con.close();
				} catch (Exception e) {
				}
			}
		}
	

		public void insertMethod() {		//���� ����
			String sql = "INSERT INTO MANAGER(M_CODE, M_NAME, M_CAREER_Y, M_CONTRACT, M_NATIONALITY) VALUES(?, ?, ?, ?, ?)";			
			Connection con = null;
			PreparedStatement pstmt = null;
			
			try {
				Class.forName(driver);
				con = DriverManager.getConnection(url, "pjh", "2015150046");
				pstmt = con.prepareStatement(sql);
				
				System.out.printf("�Է��� ���� �ڵ�: ");
				String managercode = scan.next();
				System.out.printf("�Է��� ���� �̸�: ");
				String managername = scan2.nextLine();
				System.out.printf("�Է��� ���� ���(Year): ");
				String managerCAREER_Y = scan2.nextLine();
				System.out.printf("�Է��� ���� ���(ex.2019-11-11): ");
				String managercontract = scan2.nextLine();
				System.out.printf("�Է��� ���� ����: ");
				String managerNATIONALITY = scan2.nextLine();
				
				pstmt.setString(1, managercode);
				pstmt.setString(2, managername);
				pstmt.setString(3, managerCAREER_Y);
				pstmt.setString(4, managercontract);
				pstmt.setString(5, managerNATIONALITY);
				int cnt = pstmt.executeUpdate(); 
				System.out.println(cnt + "���� ����Ǿ����ϴ�.");			
			}
			catch (Exception e) {System.out.println(e.getMessage());}
			finally {
				try {
					pstmt.close();
					con.close();
				} catch (Exception e) {
				}
			}
		}
		
///////////////////////////////////////////////////////////////////////////////////////////////////////���ǹ�
		
		public void extra_round() {		
			System.out.println(" ");
			System.out.println("[[���ϴ� �޴��� �����Ͻʽÿ�.]]");
			System.out.println("");
			System.out.println("�� A.�̸� �� ���� �˻�");
			System.out.println("��");
			System.out.println("�� B.�������� ���� �˻�");
			System.out.println("��");
			System.out.println("�� C.���� �� ���� �˻�");
			System.out.println("��");
			System.out.println("�� D.��� ���� �� ���� �˻�");
			System.out.println("��");
			System.out.println("�� E.��� �� ���� �˻�");
			System.out.print("=> ");
			String sel = scan.next();
			
			if(sel.equals("A")){
				String sql = "SELECT m.m_name, m.m_CAREER_Y, m.m_contract, m.m_NATIONALITY, e.t_name "
						+ "FROM team e, manager m "
						+ "WHERE E.M_CODE = M.M_CODE "
						+ "ORDER BY M_NAME";
				Connection con = null;
				PreparedStatement pstmt = null;
				ResultSet rs = null;
				
				System.out.println("���� �̸� \t\t���(Y)\t���Ⱓ \t���� \t�� ��");
				System.out.println("����������������������������������������������������������������������������������������������������������������������");
				try {
					Class.forName(driver);
					con = DriverManager.getConnection(url, "pjh", "2015150046");
					pstmt = con.prepareStatement(sql);
					rs = pstmt.executeQuery(); 
					while (rs.next()) {
						String managername = rs.getString("M_NAME"); 
						String managerCAREER_Y = rs.getString("M_CAREER_Y");
						String managercontract = rs.getString("M_CONTRACT");	
						String managercontry = rs.getString("M_NATIONALITY");
						String timename = rs.getString("T_NAME");
						System.out.println(managername +  "\t\t" + managerCAREER_Y + 
								"\t" + managercontract + "\t" + managercontry + "\t" + timename);
					}
				}		
				catch (Exception e) {System.out.println(e.getMessage());}		
				finally {
					try {rs.close();
						pstmt.close();
						con.close();
					} catch (Exception e) {}
				}
			}//sel=1
	/////////////////////////////////////
			if(sel.equals("E")){
				String sql = "SELECT m.m_name, m.m_CAREER_Y, m.m_contract, m.m_NATIONALITY, e.t_name "
						+ "FROM team e, manager m "
						+ "WHERE E.M_CODE = M.M_CODE "
						+ "ORDER BY M_CONTRACT DESC";
				Connection con = null;
				PreparedStatement pstmt = null;
				ResultSet rs = null;
				
				System.out.println("���� �̸� \t\t���(Y)\t���Ⱓ \t���� \t�� ��");
				System.out.println("����������������������������������������������������������������������������������������������������������������������");
				try {
					Class.forName(driver);
					con = DriverManager.getConnection(url, "pjh", "2015150046");
					pstmt = con.prepareStatement(sql);
					rs = pstmt.executeQuery(); 
					while (rs.next()) {
						String managername = rs.getString("M_NAME"); 
						String managerCAREER_Y = rs.getString("M_CAREER_Y");
						String managercontract = rs.getString("M_CONTRACT");	
						String managercontry = rs.getString("M_NATIONALITY");
						String timename = rs.getString("T_NAME");
						System.out.println(managername +  "\t\t" + managerCAREER_Y + 
								"\t" + managercontract + "\t" + managercontry + "\t" + timename);
					}
				}		
				catch (Exception e) {System.out.println(e.getMessage());}		
				finally {
					try {rs.close();
						pstmt.close();
						con.close();
					} catch (Exception e) {}
				}
			}//sel=5
	  //////////////////////////////
			if(sel.equals("C")){
				String sql = "SELECT m.m_name, m.m_CAREER_Y, m.m_contract, m.m_NATIONALITY, e.t_name "
						+ "FROM team e, manager m "
						+ "WHERE E.M_CODE = M.M_CODE "
						+ "ORDER BY M_NATIONALITY";
				Connection con = null;
				PreparedStatement pstmt = null;
				ResultSet rs = null;
				
				System.out.println("���� �̸� \t\t���(Y)\t���Ⱓ \t���� \t�� ��");
				System.out.println("����������������������������������������������������������������������������������������������������������������������");
				
				try {
					Class.forName(driver);
					con = DriverManager.getConnection(url, "pjh", "2015150046");
					pstmt = con.prepareStatement(sql);
					rs = pstmt.executeQuery(); 
					while (rs.next()) {
						String managername = rs.getString("M_NAME"); 
						String managerCAREER_Y = rs.getString("M_CAREER_Y");
						String managercontract = rs.getString("M_CONTRACT");	
						String managercontry = rs.getString("M_NATIONALITY");
						String timename = rs.getString("T_NAME");
						System.out.println(managername +  "\t\t" + managerCAREER_Y + 
								"\t" + managercontract + "\t" + managercontry + "\t" + timename);
					}
				}		
				catch (Exception e) {System.out.println(e.getMessage());}		
				finally {
					try {rs.close();
						pstmt.close();
						con.close();
					} catch (Exception e) {}
				}
			}//sel=3
		//////////////////////////////
			if(sel.equals("D")){
				String sql = "SELECT m.m_name, m.m_CAREER_Y, m.m_contract, m.m_NATIONALITY, e.t_name "
						+ "FROM team e, manager m "
						+ "WHERE E.M_CODE = M.M_CODE "
						+ "ORDER BY M_CONTRACT";
				Connection con = null;
				PreparedStatement pstmt = null;
				ResultSet rs = null;
				
				System.out.println("���� �̸� \t\t���(Y)\t���Ⱓ \t���� \t�� ��");
				System.out.println("����������������������������������������������������������������������������������������������������������������������");
				
				try {
					Class.forName(driver);
					con = DriverManager.getConnection(url, "pjh", "2015150046");
					pstmt = con.prepareStatement(sql);
					rs = pstmt.executeQuery(); 
					while (rs.next()) {
						String managername = rs.getString("M_NAME"); 
						String managerCAREER_Y = rs.getString("M_CAREER_Y");
						String managercontract = rs.getString("M_CONTRACT");	
						String managercontry = rs.getString("M_NATIONALITY");
						String timename = rs.getString("T_NAME");
						System.out.println(managername +  "\t\t" + managerCAREER_Y + 
								"\t" + managercontract + "\t" + managercontry + "\t" + timename);
					}
				}		
				catch (Exception e) {System.out.println(e.getMessage());}		
				finally {
					try {rs.close();
						pstmt.close();
						con.close();
					} catch (Exception e) {}
				}
			}//sel=4
			
			
			///���� �˻����
			
			if(sel.equals("B")){
				System.out.printf("���� �Է�: ");
				String mNATIONALITY = scan.next();
				
				String sql = "SELECT * "
						+ "FROM MANAGER "
						+ "where M_NATIONALITY = ?";
				
				Connection con = null;
				PreparedStatement pstmt = null;
				ResultSet rs = null;
				
				System.out.println("���� �ڵ� \t�̸�\t���(Y)\t���Ⱓ \t����");
				System.out.println("����������������������������������������������������������������������������������������������������������������������");
				
				try {
					Class.forName(driver);
					con = DriverManager.getConnection(url, "pjh", "2015150046");
					
					pstmt = con.prepareStatement(sql);
					pstmt.setString(1, mNATIONALITY);
					
					rs = pstmt.executeQuery(); 
					while (rs.next()) {
						String managercode = rs.getString("M_CODE"); 
						String managername = rs.getString("M_NAME"); 
						String managerCAREER_Y = rs.getString("M_CAREER_Y");
						String managercontract = rs.getString("M_CONTRACT");	
						String managercontry = rs.getString("M_NATIONALITY");
						System.out.println(managercode + "\t" + managername +  "\t" + managerCAREER_Y + 
								"\t" + managercontract + "\t" + managercontry);
					}
				}		
				catch (Exception e) {System.out.println(e.getMessage());}		
				finally {
					try {rs.close();
						pstmt.close();
						con.close();
					} catch (Exception e) {}
				}
			}//sel=2 
			
		}//extra_round Ʋ
}//��ü Ʋ
