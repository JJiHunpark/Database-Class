package EPLTEAM;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class EPL_TEAM {

	Scanner scan = new Scanner(System.in);  // �� �޼ҵ庰 �ߺ��Ǵ� �׸� ����.
	Scanner scan2 = new Scanner(System.in);
	String driver = "oracle.jdbc.driver.OracleDriver"; 
	String url = "jdbc:oracle:thin:@localhost:1521:orcl";
	
		public void selectMethod() {
			String sql = "select T.T_CODE, T.T_NAME, M.M_NAME, T.M_CODE from team T, manager M WHERE T.M_CODE = M.M_CODE";
			Connection con = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			
			System.out.println("�� �ڵ� \t�� �� \t\t���� ��\t���� �ڵ�");
			try {
				Class.forName(driver);
				con = DriverManager.getConnection(url, "pjh", "2015150046");
				pstmt = con.prepareStatement(sql);
				rs = pstmt.executeQuery(); 
				while (rs.next()) {
					String teamcode = rs.getString("T_CODE"); 
					String teamname = rs.getString("T_NAME"); 
					String managername = rs.getString("M_NAME");	
					String managercode = rs.getString("M_CODE"); 
					System.out.println(teamcode + "\t" + teamname +  "\t\t" + managername + "\t\t" + managercode);
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
	
		public void updateMethod() {	// �� ���� ����		
			String sql = "UPDATE TEAM SET M_CODE = ? WHERE T_CODE = ?";	
			Connection con = null;
			PreparedStatement pstmt = null;		
			try {
				Class.forName(driver);
				con = DriverManager.getConnection(url, "pjh", "2015150046");
				pstmt = con.prepareStatement(sql);
				
				System.out.printf("������ ���� �ڵ� �Է�: ");
				String teamcode = scan.next();
				System.out.printf("������ �����ڵ� �Է�: ");
				String managercode = scan2.next();		
				
				pstmt.setString(1, managercode);
				pstmt.setString(2, teamcode);
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
	

	
		public void deleteMethod() {	// �� ����
			String sql = "DELETE FROM TEAM WHERE T_CODE = ?";
			String teamcode = "";
			
			Connection con = null;
			PreparedStatement pstmt = null;		
			try {
				Class.forName(driver);
				con = DriverManager.getConnection(url, "pjh", "2015150046");
				pstmt = con.prepareStatement(sql);
				
				System.out.print("������ ���ڵ带 �Է��Ͻÿ�: ");
				teamcode = scan.next();
				
				pstmt.setString(1, teamcode);
				int cnt = pstmt.executeUpdate(); 
				System.out.println(cnt + "���� ����Ǿ����ϴ�.");	
				//System.out.println(cnt);
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
	
	


		public void insertMethod() {		
			String sql = "INSERT INTO TEAM(T_CODE,T_NAME,M_CODE) VALUES(?, ?, ?)";			
			Connection con = null;
			PreparedStatement pstmt = null;
			
			try {
				Class.forName(driver);
				con = DriverManager.getConnection(url, "pjh", "2015150046");
				pstmt = con.prepareStatement(sql);
				
				System.out.printf("�Է��� ���ڵ�: ");
				String teamcode = scan.next();
				System.out.printf("�Է��� ����: ");
				String teamname = scan2.nextLine();			
				System.out.printf("�Է��� �����ڵ�: ");
				String managercode = scan2.nextLine();			
				
				pstmt.setString(1, teamcode);
				pstmt.setString(2, teamname);
				//pstmt.setInt(3, price);
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
		
///////////////////////////////////////////////////////////////////////////////////////////////////////���ǹ�
		
		public void textra_round() {		
			System.out.println("");
			System.out.println("[[���ϴ� �޴��� �����Ͻʽÿ�.]]");
			System.out.println("");
			System.out.println("�� A.���� ���� �˻�");
			System.out.println("��");
			System.out.println("�� B.���� �޿� ���");
			System.out.println("��     �� B1. �� ��ü");
			System.out.println("��     �� B2. ��Ű��");
			System.out.println("��     �� B3. �����");
			System.out.println("��     �� B4. �̵��ʴ�");
			System.out.println("��     �� B5. ���ݼ�");
			System.out.println("��");
			System.out.println("�� C.���� ���� ���ɴ�");
			System.out.println("��");
			System.out.println("�� D.���� ��� ���� �˻�");
			System.out.println("��");
			System.out.println("�� E.�� ������ �˻�");
			System.out.println("��");
			System.out.println("�� F.�� ��ġ�� �˻�");
			System.out.println("�� ");
			
			System.out.print("=> ");
			String sel = scan.next();
			
			if(sel.equals("A")){
				String sql = "SELECT e.t_name, m.m_name, m.m_contract, m.m_nationality "
						+ "FROM team E, manager M "
						+ "WHERE E.M_CODE = M.M_CODE";
				Connection con = null;
				PreparedStatement pstmt = null;
				ResultSet rs = null;
				
				System.out.println("�� �� \t\t���� �̸� \t\t��� �Ⱓ \t����");
				System.out.println("����������������������������������������������������������������������������������������������������������������������");

				try {
					Class.forName(driver);
					con = DriverManager.getConnection(url, "pjh", "2015150046");
					pstmt = con.prepareStatement(sql);
					rs = pstmt.executeQuery(); 
					while (rs.next()) {
						String timename = rs.getString("T_NAME"); 
						String managername = rs.getString("M_NAME"); 
						String managercontract = rs.getString("m_CONTRACT");
						String managernationality = rs.getString("M_nationality");	
						System.out.println(timename + "\t\t" + managername + "\t\t" + managercontract
								+ "\t" + managernationality) ;
					}
				}		
				catch (Exception e) {System.out.println(e.getMessage());}		
				finally {
					try {rs.close();
						pstmt.close();
						con.close();
					} catch (Exception e) {}
				}
			}//sel=A
		
		if(sel.equals("B1")){
			String sql = "SELECT e.t_name, round(avg(p.p_pay),0), max(p.p_pay), min(p.p_pay) "
					+ "FROM player p, team e "
					+ "WHERE e.t_code= p.t_code "
					+ "GROUP BY e.t_name "
					+ "ORDER BY avg(p.p_pay) desc" ;					
			Connection con = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			
			System.out.println("���� \t\t���� ��� �޿� \t���� �ְ� �޿� \t���� ���� �޿�");
			System.out.println("������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������");

			try {
				Class.forName(driver);
				con = DriverManager.getConnection(url, "pjh", "2015150046");
				pstmt = con.prepareStatement(sql);
				rs = pstmt.executeQuery(); 
				while (rs.next()) {
					String teamname = rs.getString("T_NAME"); 
					long playerpay = rs.getLong("round(avg(p.p_pay),0)");
					long managercontract = rs.getLong("max(p.p_pay)");
					long managernationality = rs.getLong("min(p.p_pay)");	
					System.out.println(teamname + "\t\t" + playerpay+ "\t" + managercontract + "\t" + managernationality) ;
				}
			}	
			catch (Exception e) {System.out.println(e.getMessage());}		
			finally {
				try {rs.close();
					pstmt.close();
					con.close();
				} catch (Exception e) {}
			}
		}//sel=B1
		
		if(sel.equals("B2")){
			String sql = "SELECT e.t_name, p.p_position, ROUND(avg(p.p_pay),0), max(p.p_pay), min(p.p_pay)"
					+ "FROM player p, team e "
					+ "WHERE e.t_code= p.t_code "
					+ "and p.p_position ='GK' "
					+ "GROUP BY e.t_name, p.p_position "
					+ "ORDER BY avg(p.p_pay) desc" ;
			Connection con = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			
			System.out.println("����\t\t������\t\t���� ��� �޿� \t���� �ְ� �޿� \t���� ���� �޿�");
			System.out.println("������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������");

			try {
				Class.forName(driver);
				con = DriverManager.getConnection(url, "pjh", "2015150046");
				pstmt = con.prepareStatement(sql);
				rs = pstmt.executeQuery(); 
				while (rs.next()) {
					String teamname = rs.getString("T_NAME"); 
					String playerposition = rs.getString("p_position"); 
					long playerpay = rs.getLong("round(avg(p.p_pay),0)");
					long managercontract = rs.getLong("max(p.p_pay)");
					long managernationality = rs.getLong("min(p.p_pay)");	
					System.out.println(teamname + "\t\t" + playerposition + "\t\t" + playerpay+ "\t" 
								+ managercontract + "\t" + managernationality) ;
				}
			}	
			catch (Exception e) {System.out.println(e.getMessage());}		
			finally {
				try {rs.close();
					pstmt.close();
					con.close();
				} catch (Exception e) {}
			}
		}//sel=B2
		
		if(sel.equals("B3")){
			String sql = "SELECT e.t_name, p.p_position, ROUND(avg(p.p_pay),0), max(p.p_pay), min(p.p_pay)"
					+ "FROM player p, team e "
					+ "WHERE e.t_code= p.t_code "
					+ "and p.p_position ='DF' "
					+ "GROUP BY e.t_name, p.p_position "
					+ "ORDER BY avg(p.p_pay) desc" ;
			Connection con = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			
			System.out.println("����\t\t������\t\t���� ��� �޿� \t���� �ְ� �޿� \t���� ���� �޿�");
			System.out.println("������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������");

			try {
				Class.forName(driver);
				con = DriverManager.getConnection(url, "pjh", "2015150046");
				pstmt = con.prepareStatement(sql);
				rs = pstmt.executeQuery(); 
				while (rs.next()) {
					String teamname = rs.getString("T_NAME"); 
					String playerposition = rs.getString("p_position"); 
					long playerpay = rs.getLong("round(avg(p.p_pay),0)");
					long managercontract = rs.getLong("max(p.p_pay)");
					long managernationality = rs.getLong("min(p.p_pay)");	
					System.out.println(teamname + "\t\t" + playerposition + "\t\t" + playerpay+ "\t" 
								+ managercontract + "\t" + managernationality) ;
				}
			}	
			catch (Exception e) {System.out.println(e.getMessage());}		
			finally {
				try {rs.close();
					pstmt.close();
					con.close();
				} catch (Exception e) {}
			}
		}//sel=B3
		
		if(sel.equals("B4")){
			String sql = "SELECT e.t_name, p.p_position, ROUND(avg(p.p_pay),0), max(p.p_pay), min(p.p_pay)"
					+ "FROM player p, team e "
					+ "WHERE e.t_code= p.t_code "
					+ "and p.p_position ='MF'"
					+ "GROUP BY e.t_name, p.p_position "
					+ "ORDER BY avg(p.p_pay) desc" ;
			Connection con = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			
			System.out.println("����\t\t������\t\t���� ��� �޿� \t���� �ְ� �޿� \t���� ���� �޿�");
			System.out.println("������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������");

			try {
				Class.forName(driver);
				con = DriverManager.getConnection(url, "pjh", "2015150046");
				pstmt = con.prepareStatement(sql);
				rs = pstmt.executeQuery(); 
				while (rs.next()) {
					String teamname = rs.getString("T_NAME"); 
					String playerposition = rs.getString("p_position"); 
					long playerpay = rs.getLong("round(avg(p.p_pay),0)");
					long managercontract = rs.getLong("max(p.p_pay)");
					long managernationality = rs.getLong("min(p.p_pay)");	
					System.out.println(teamname + "\t\t" + playerposition + "\t\t" + playerpay+ "\t" 
								+ managercontract + "\t" + managernationality) ;
				}
			}	
			catch (Exception e) {System.out.println(e.getMessage());}		
			finally {
				try {rs.close();
					pstmt.close();
					con.close();
				} catch (Exception e) {}
			}
		}//sel=B4
		
		if(sel.equals("B5")){
			String sql = "SELECT e.t_name, p.p_position, ROUND(avg(p.p_pay),0), max(p.p_pay), min(p.p_pay)"
					+ "FROM player p, team e "
					+ "WHERE e.t_code= p.t_code "
					+ "and p.p_position in ('FW', 'ST')"
					+ "GROUP BY e.t_name, p.p_position "
					+ "ORDER BY avg(p.p_pay) desc" ;
			Connection con = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			
			System.out.println("����\t\t������\t\t���� ��� �޿� \t���� �ְ� �޿� \t���� ���� �޿�");
			System.out.println("������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������");

			try {
				Class.forName(driver);
				con = DriverManager.getConnection(url, "pjh", "2015150046");
				pstmt = con.prepareStatement(sql);
				rs = pstmt.executeQuery(); 
				while (rs.next()) {
					String teamname = rs.getString("T_NAME"); 
					String playerposition = rs.getString("p_position"); 
					long playerpay = rs.getLong("round(avg(p.p_pay),0)");
					long managercontract = rs.getLong("max(p.p_pay)");
					long managernationality = rs.getLong("min(p.p_pay)");	
					System.out.println(teamname + "\t\t" + playerposition + "\t\t" + playerpay+ "\t" 
								+ managercontract + "\t" + managernationality) ;
				}
			}	
			catch (Exception e) {System.out.println(e.getMessage());}		
			finally {
				try {rs.close();
					pstmt.close();
					con.close();
				} catch (Exception e) {}
			}
		}//sel=B5
		
		if(sel.equals("C")){
			String sql = "SELECT e.t_name, ROUND(avg(p.p_age),0), max(p.p_age), min(p.p_age)"
					+ "FROM player p, team e "
					+ "WHERE e.t_code= p.t_code "
					+ "GROUP BY e.t_name";
			Connection con = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			
			System.out.println("���� \t\t���� ��� ���� \t���� �ְ� ���� \t���� ���� ����");
			System.out.println("������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������");

			try {
				Class.forName(driver);
				con = DriverManager.getConnection(url, "pjh", "2015150046");
				pstmt = con.prepareStatement(sql);
				rs = pstmt.executeQuery(); 
				while (rs.next()) {
					String teamname = rs.getString("T_NAME"); 
					String playerage = rs.getString("round(avg(p.p_age),0)");
					String maxplayerage = rs.getString("max(p.p_age)");
					String minplayerage = rs.getString("min(p.p_age)");	
					System.out.println(teamname + "\t\t" + playerage+ "\t\t" + maxplayerage + "\t\t" + minplayerage) ;
				}
			}	
			catch (Exception e) {System.out.println(e.getMessage());}		
			finally {
				try {rs.close();
					pstmt.close();
					con.close();
				} catch (Exception e) {}
			}
		}//sel=C
		
		if(sel.equals("D")){
			String sql = "SELECT e.t_name, p.p_name, p.p_cm, p.p_kg, p.p_position, p.p_age,  p.p_pay, p.p_nationality "
					+ "FROM player p, team e "
					+ "WHERE e.t_code= p.t_code "
					+ "AND p_cm > "
					+ "(SELECT avg(p_cm) "
					+ "FROM player "
					+ "WHERE t_code= p.t_code)";
			Connection con = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			
			System.out.println("���� \t\t���� �� \t����\tü��\t������\t����\t�޿�\t\t����");
			System.out.println("������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������");

			try {
				Class.forName(driver);
				con = DriverManager.getConnection(url, "pjh", "2015150046");
				pstmt = con.prepareStatement(sql);
				rs = pstmt.executeQuery(); 
				while (rs.next()) {
					String playername = rs.getString("P_NAME");
					String playercm = rs.getString("p_cm"); 
					String playerkg = rs.getString("p_kg"); 
					String playerposition = rs.getString("P_POSITION"); 
					String playerage = rs.getString("P_AGE");
					String playerpay = rs.getString("P_pay"); 
					String playernationality = rs.getString("P_nationality"); 
					String teamname = rs.getString("T_NAME");  
					
					System.out.println(teamname + "\t\t" + playername + "\t" + playercm+ "\t" + playerkg + "\t" + playerposition 
							+ "\t" + playerage + "\t" + playerpay  + "\t" + playernationality) ;
				}
			}	
			catch (Exception e) {System.out.println(e.getMessage());}		
			finally {
				try {rs.close();
					pstmt.close();
					con.close();
				} catch (Exception e) {}
			}
		}//sel=D
		
		if(sel.equals("E")){
			System.out.printf("�� �ڵ� �Է�: ");
			String tcode = scan.next();
			
			String sql = "select t.t_name, b.b_name, b.b_position from board b, team t where b.t_code=t.t_code and t.t_code LIKE ?";
			Connection con = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			
			System.out.println("���� \t\t���� �̸� \t\t���� ����");
			System.out.println("����������������������������������������������������������������������������������������");

			try {
				Class.forName(driver);
				con = DriverManager.getConnection(url, "pjh", "2015150046");
				
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, tcode);
				
				rs = pstmt.executeQuery(); 
				while (rs.next()) {
					String teamname = rs.getString("T_NAME"); 
					String boardname = rs.getString("B_NAME");
					String boardposition = rs.getString("B_POSITION");
					System.out.println(teamname + "\t" + boardname+ "\t\t" + boardposition) ;
				}
			}	
			catch (Exception e) {System.out.println(e.getMessage());}		
			finally {
				try {rs.close();
					pstmt.close();
					con.close();
				} catch (Exception e) {}
			}
		}//sel=E
		
		if(sel.equals("F")){
			System.out.printf("�� �ڵ� �Է�: ");
			String bposition = scan.next();
			
			String sql = "select t.t_name, c.c_name, c.c_position from coach c, team t where c.t_code=t.t_code and t.t_code LIKE ?";
			Connection con = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			
			System.out.println("���� \t\t��ġ �̸� \t\t��ġ ����");
			System.out.println("����������������������������������������������������������������������������������������");

			try {
				Class.forName(driver);
				con = DriverManager.getConnection(url, "pjh", "2015150046");
				
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, bposition);
				
				rs = pstmt.executeQuery(); 
				while (rs.next()) {
					String teamname = rs.getString("T_NAME"); 
					String coachname = rs.getString("C_NAME");
					String coachposition = rs.getString("C_POSITION");
					System.out.println(teamname + "\t" + coachname+ "\t\t" + coachposition) ;
				}
			}	
			catch (Exception e) {System.out.println(e.getMessage());}		
			finally {
				try {rs.close();
					pstmt.close();
					con.close();
				} catch (Exception e) {}
			}
		}//sel=F
		
	} //���� ��ȭ
} //��ü ��ȣ
