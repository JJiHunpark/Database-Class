package EPLTEAM;

import java.sql.Connection;
	import java.sql.DriverManager;
	import java.sql.PreparedStatement;
	import java.sql.ResultSet;
	import java.util.Scanner;
	
public class EPL_PLAYER {
		Scanner scan = new Scanner(System.in);  // �� �޼ҵ庰 �ߺ��Ǵ� �׸� ����.
		Scanner scan2 = new Scanner(System.in);
		String driver = "oracle.jdbc.driver.OracleDriver"; 
		String url = "jdbc:oracle:thin:@localhost:1521:orcl";
		
			public void selectMethod() {
				String sql = "SELECT * FROM PLAYER";
				Connection con = null;
				PreparedStatement pstmt = null;
				ResultSet rs = null;
				
				System.out.println("P_CODE \tP_NAME \tp_cm \tp_kg \tP_nationality \tT_CODE \tP_POSITION \tP_CONTRACT "
											+ "	\tP_pay \tP_AGE");
				try {
					Class.forName(driver);
					con = DriverManager.getConnection(url, "pjh", "2015150046");
					pstmt = con.prepareStatement(sql);
					rs = pstmt.executeQuery(); 
					while (rs.next()) {
						String playercode = rs.getString("P_CODE"); 
						String playername = rs.getString("P_NAME");
						String playercm = rs.getString("p_cm");
						String playerkg = rs.getString("p_kg");
						String playernationality = rs.getString("P_nationality");
						String timecode = rs.getString("T_CODE");
						String playerposition = rs.getString("P_POSITION");
						String playercontract = rs.getString("P_CONTRACT");
						long playerpay = rs.getLong("P_pay");
						String playerage = rs.getString("P_AGE");
						
						System.out.println(playercode + "\t" + playername + "\t" + playercm + "\t" + playerkg 
								+ "\t" + playernationality + "\t\t" + timecode + "\t" + playerposition + "\t\t" 
								+ playercontract + "\t" + playerpay + "\t" + playerage);
						
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
		
			public void updateMethod() {			
				String sql = "UPDATE PLAYER SET T_CODE=?, P_CONTRACT=?, P_pay=? WHERE P_CODE = ?";	
				Connection con = null;
				PreparedStatement pstmt = null;		
				try {
					Class.forName(driver);
					con = DriverManager.getConnection(url, "pjh", "2015150046");
					pstmt = con.prepareStatement(sql);
					
					System.out.printf("������ ������ �ڵ� �Է�: ");
					String playercode = scan.next();
					System.out.printf("������ ���ڵ� �Է�: ");
					String teamcode = scan2.nextLine();
					System.out.printf("������ ��ุ���� �Է�: ");
					String playercontract = scan2.nextLine();
					System.out.printf("������ ���� �Է�: ");
					long playerpay = scan2.nextLong();		
					
					pstmt.setString(1, teamcode);
					pstmt.setString(2, playercontract);
					pstmt.setLong(3, playerpay);
					pstmt.setString(4, playercode);
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
		

		
			public void deleteMethod() {
				String sql = "DELETE FROM PLAYER WHERE P_CODE = ?";
				String playercode = "";
				
				Connection con = null;
				PreparedStatement pstmt = null;		
				try {
					Class.forName(driver);
					con = DriverManager.getConnection(url, "pjh", "2015150046");
					pstmt = con.prepareStatement(sql);
					
					System.out.print("������ ���� �ڵ带 �Է��Ͻÿ�: ");
					playercode = scan.next();
					
					pstmt.setString(1, playercode);
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
		
		


			public void insertMethod() {		
				String sql = "INSERT INTO PLAYER(P_CODE, P_NAME, p_cm, p_kg, P_nationality, T_CODE, "
						+ "P_POSITION, P_CONTRACT, P_pay, P_AGE) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";			
				Connection con = null;
				PreparedStatement pstmt = null;
				
				try {
					Class.forName(driver);
					con = DriverManager.getConnection(url, "pjh", "2015150046");
					pstmt = con.prepareStatement(sql);
					
					System.out.printf("�Է��� �����ڵ�: ");
					String playercode = scan.next();
					System.out.printf("�Է��� �����̸�: ");
					String playername = scan2.nextLine();			
					System.out.printf("�Է��� ���� ����: ");
					String playercm = scan2.nextLine();	
					System.out.printf("�Է��� ���� ü��: ");
					String playerkg = scan2.nextLine();
					System.out.printf("�Է��� ���� ����: ");
					String playernationality = scan2.nextLine();
					System.out.printf("�Է��� ���ڵ�: ");
					String timecode = scan2.nextLine();
					System.out.printf("�Է��� ���� ������: ");
					String playerposition = scan2.nextLine();
					System.out.printf("�Է��� ���� ��ุ��: ");
					String playercontract = scan2.nextLine();
					System.out.printf("�Է��� ���� ����: ");
					long playerpay = scan2.nextLong();
					System.out.printf("�Է��� ���� ����: ");
					String playerage = scan2.nextLine();
					
					
					pstmt.setString(1, playercode);
					pstmt.setString(2, playername);
					pstmt.setString(3, playercm);
					pstmt.setString(4, playerkg);
					pstmt.setString(5, playernationality);
					pstmt.setString(6, timecode);
					pstmt.setString(7, playerposition);
					pstmt.setString(8, playercontract);
					pstmt.setLong(9, playerpay);
					pstmt.setString(10, playerage);
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
		
			public void pextra_round() {		
				System.out.println("");
				System.out.println("[[���ϴ� �޴��� �����Ͻʽÿ�.]]");
				System.out.println("");
				System.out.println("�� A.������ �� ���� �˻�");
				System.out.println("��     ��A1. ��Ű��");
				System.out.println("��     ��A2. �����");
				System.out.println("��     ��A3. �̵��ʴ�");
				System.out.println("��     ��A4. ���ݼ�");
				System.out.println("��");
				System.out.println("�� B.�������� ���� �˻�");
				System.out.println("��");
				System.out.println("�� C.�޿� �� ���� ����");
				System.out.println("��     ��C1. ��ü");
				System.out.println("��     ��C2. ��Ű��");
				System.out.println("��     ��C3. �����");
				System.out.println("��     ��C4. �̵��ʴ�");
				System.out.println("��     ��C5. ���ݼ�");
				System.out.println("��");
				System.out.println("�� D.etc");
				System.out.println("��     ��D1. ���� ���� ���� �˻�");
				System.out.println("��     ��D2. ���� ���� ���� �˻�");
				System.out.println("��     ��D3. ü�� ���� ���� �˻�");
				System.out.println("��");
				System.out.println("�� E.���� �ʿ� ���� �˻�");
				System.out.println("��");
				System.out.println("�� F.���� �� ������Ʈ �˻�");
				System.out.println("�� ");
				System.out.print("=> ");
				String sel = scan.next();
				
				if(sel.equals("A1")){
					String sql = "SELECT p.p_name, p.p_cm, p.p_kg, p.p_nationality, p.p_position, p.p_contract, p.p_pay, p.p_age, e.t_name "
							+ "FROM player p, team e "
							+ "WHERE e.t_code = p.t_code "
							+ "and p.p_position='GK'";
					Connection con = null;
					PreparedStatement pstmt = null;
					ResultSet rs = null;
					
					System.out.println("���� �̸� \t����(p_cm) \tü��(p_kg) \t���� \t������ \t��� �Ⱓ \t\t����\t\t����\t�� ��");
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
							String playernationality = rs.getString("P_nationality");
							String playerposition = rs.getString("P_POSITION");
							String playercontract = rs.getString("P_CONTRACT");
							long playerpay = rs.getLong("P_pay");
							String playerage = rs.getString("P_AGE");
							String timname = rs.getString("T_NAME");
							System.out.println(playername + "\t" + playercm + "\t" + playerkg + "\t" + playernationality
									 + "\t" + playerposition + "\t" + playercontract + "\t" + playerpay + "\t" + 
									playerage + "\t" + timname) ;
						}
					}		
					catch (Exception e) {System.out.println(e.getMessage());}		
					finally {
						try {rs.close();
							pstmt.close();
							con.close();
						} catch (Exception e) {}
					}
				}//sel=A1
				
				else if(sel.equals("A2")){
					String sql = "SELECT p.p_name, p.p_cm, p.p_kg, p.p_nationality, p.p_position, p.p_contract, p.p_pay, p.p_age, e.t_name "
							+ "FROM player p, team e "
							+ "WHERE e.t_code = p.t_code "
							+ "and p.p_position='DF'";
					Connection con = null;
					PreparedStatement pstmt = null;
					ResultSet rs = null;
					
					System.out.println("���� �̸� \t����(p_cm) \tü��(p_kg) \t���� \t������ \t��� �Ⱓ \t\t����\t\t����\t�� ��");
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
							String playernationality = rs.getString("P_nationality");
							String playerposition = rs.getString("P_POSITION");
							String playercontract = rs.getString("P_CONTRACT");
							long playerpay = rs.getLong("P_pay");
							String playerage = rs.getString("P_AGE");
							String timname = rs.getString("T_NAME");
							System.out.println(playername + "\t" + playercm + "\t" + playerkg + "\t" + playernationality
									 + "\t" + playerposition + "\t" + playercontract + "\t" + playerpay + "\t" + 
									playerage + "\t" + timname) ;
						}
					}		
					catch (Exception e) {System.out.println(e.getMessage());}		
					finally {
						try {rs.close();
							pstmt.close();
							con.close();
						} catch (Exception e) {}
					}
				}//sel=A2
				
				else if(sel.equals("A3")){
					String sql = "SELECT p.p_name, p.p_cm, p.p_kg, p.p_nationality, p.p_position, p.p_contract, p.p_pay, p.p_age, e.t_name "
							+ "FROM player p, team e "
							+ "WHERE e.t_code = p.t_code "
							+ "and p.p_position='MF'";
					Connection con = null;
					PreparedStatement pstmt = null;
					ResultSet rs = null;
					
					System.out.println("���� �̸� \t����(p_cm) \tü��(p_kg) \t���� \t������ \t��� �Ⱓ \t\t����\t\t����\t�� ��");
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
							String playernationality = rs.getString("P_nationality");
							String playerposition = rs.getString("P_POSITION");
							String playercontract = rs.getString("P_CONTRACT");
							long playerpay = rs.getLong("P_pay");
							String playerage = rs.getString("P_AGE");
							String timname = rs.getString("T_NAME");
							System.out.println(playername + "\t" + playercm + "\t" + playerkg + "\t" + playernationality
									 + "\t" + playerposition + "\t" + playercontract + "\t" + playerpay + "\t" + 
									playerage + "\t" + timname) ;
						}
					}		
					catch (Exception e) {System.out.println(e.getMessage());}		
					finally {
						try {rs.close();
							pstmt.close();
							con.close();
						} catch (Exception e) {}
					}
				}//sel=A3
				
				else if(sel.equals("A4")){
					String sql = "SELECT p.p_name, p.p_cm, p.p_kg, p.p_nationality, p.p_position, p.p_contract, p.p_pay, p.p_age, e.t_name "
							+ "FROM player p, team e "
							+ "WHERE e.t_code = p.t_code "
							+ "and p.p_position in ('FW', 'ST')";
					Connection con = null;
					PreparedStatement pstmt = null;
					ResultSet rs = null;
					
					System.out.println("���� �̸� \t����(p_cm) \tü��(p_kg) \t���� \t������ \t��� �Ⱓ \t\t����\t\t����\t�� ��");
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
							String playernationality = rs.getString("P_nationality");
							String playerposition = rs.getString("P_POSITION");
							String playercontract = rs.getString("P_CONTRACT");
							long playerpay = rs.getLong("P_pay");
							String playerage = rs.getString("P_AGE");
							String timname = rs.getString("T_NAME");
							System.out.println(playername + "\t" + playercm + "\t" + playerkg + "\t" + playernationality
									 + "\t" + playerposition + "\t" + playercontract + "\t" + playerpay + "\t" + 
									playerage + "\t" + timname) ;
						}
					}		
					catch (Exception e) {System.out.println(e.getMessage());}		
					finally {
						try {rs.close();
							pstmt.close();
							con.close();
						} catch (Exception e) {}
					}
				}//sel=A4
				
				if(sel.equals("B")){
					System.out.printf("���� �Է�: ");
					String pnationality = scan.next();
					
					String sql = "SELECT p.p_name, p.p_cm, p.p_kg, p.p_nationality, p.p_position, p.p_contract, p.p_pay, p.p_age, e.t_name "
							+ "FROM player p, team e  "
							+ "WHERE e.t_code = p.t_code "
							+ "and p.p_nationality = ?";
					
					Connection con = null;
					PreparedStatement pstmt = null;
					ResultSet rs = null;
					
					System.out.println("���� �̸� \t����(p_cm) \tü��(p_kg) \t���� \t������ \t��� �Ⱓ \t\t����\t\t����\t�� ��");
					System.out.println("������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������");
					
					try {
						Class.forName(driver);
						con = DriverManager.getConnection(url, "pjh", "2015150046");
						
						pstmt = con.prepareStatement(sql);
						pstmt.setString(1, pnationality);
						
						rs = pstmt.executeQuery(); 
						while (rs.next()) {
							String playername = rs.getString("P_NAME"); 
							String playercm = rs.getString("p_cm");
							String playerkg = rs.getString("p_kg");
							String playernationality = rs.getString("P_nationality");
							String playerposition = rs.getString("P_POSITION");
							String playercontract = rs.getString("P_CONTRACT");
							long playerpay = rs.getLong("P_pay");
							String playerage = rs.getString("P_AGE");
							String timname = rs.getString("T_NAME");
							System.out.println(playername + "\t" + playercm + "\t" + playerkg + "\t" + playernationality
									 + "\t" + playerposition + "\t" + playercontract + "\t" + playerpay + "\t" + 
									playerage + "\t" + timname) ;
						}
					}		
					catch (Exception e) {System.out.println(e.getMessage());}		
					finally {
						try {rs.close();
							pstmt.close();
							con.close();
						} catch (Exception e) {}
					}
				}//sel=B 
				
				if(sel.equals("C1")){
					String sql = "SELECT p.p_name, p.p_pay, p.p_nationality, p.p_position, p.p_contract, p.p_age, e.t_name "
							+ "FROM player p, team e "
							+ "WHERE p.t_code  = e.t_code "
							+ "ORDER BY p.p_pay desc";
					Connection con = null;
					PreparedStatement pstmt = null;
					ResultSet rs = null;
					
					System.out.println("���� �̸�\t\t���� \t������ \t��� �Ⱓ \t\t����\t\t����\t�� ��");
					System.out.println("������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������");
					try {
						Class.forName(driver);
						con = DriverManager.getConnection(url, "pjh", "2015150046");
						pstmt = con.prepareStatement(sql);
						rs = pstmt.executeQuery(); 
						while (rs.next()) {
							String playername = rs.getString("P_NAME"); 
							long playerpay = rs.getLong("P_pay");
							String playernationality = rs.getString("P_nationality");
							String playerposition = rs.getString("P_POSITION");
							String playercontract = rs.getString("P_CONTRACT");
							String playerage = rs.getString("P_AGE");
							String timname = rs.getString("T_NAME");
							System.out.println(playername + "\t" +  "\t" + playernationality + "\t" + playerposition + "\t" 
							+ playercontract + "\t" + playerpay + "\t" + playerage + "\t" + timname) ;
						}
					}		
					catch (Exception e) {System.out.println(e.getMessage());}		
					finally {
						try {rs.close();
							pstmt.close();
							con.close();
						} catch (Exception e) {}
					}
				}//sel=C1
				
				if(sel.equals("C2")){
					String sql = "SELECT p.p_name, p.p_pay, p.p_nationality, p.p_position, p.p_contract, p.p_age, e.t_name "
							+ "FROM player p, team e "
							+ "WHERE p.t_code  = e.t_code "
							+ "and p.p_position = 'GK' "
							+ "ORDER BY p.p_pay desc";
					Connection con = null;
					PreparedStatement pstmt = null;
					ResultSet rs = null;
					
					System.out.println("���� �̸�\t\t���� \t������ \t��� �Ⱓ \t\t����\t\t����\t�� ��");
					System.out.println("������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������");
					try {
						Class.forName(driver);
						con = DriverManager.getConnection(url, "pjh", "2015150046");
						pstmt = con.prepareStatement(sql);
						rs = pstmt.executeQuery(); 
						while (rs.next()) {
							String playername = rs.getString("P_NAME"); 
							long playerpay = rs.getLong("P_pay");
							String playernationality = rs.getString("P_nationality");
							String playerposition = rs.getString("P_POSITION");
							String playercontract = rs.getString("P_CONTRACT");
							String playerage = rs.getString("P_AGE");
							String timname = rs.getString("T_NAME");
							System.out.println(playername + "\t" +  "\t" + playernationality + "\t" + playerposition + "\t" 
							+ playercontract + "\t" + playerpay + "\t" + playerage + "\t" + timname) ;
						}
					}		
					catch (Exception e) {System.out.println(e.getMessage());}		
					finally {
						try {rs.close();
							pstmt.close();
							con.close();
						} catch (Exception e) {}
					}
				}//sel=C2	
				
				if(sel.equals("C3")){
					String sql = "SELECT p.p_name, p.p_pay, p.p_nationality, p.p_position, p.p_contract, p.p_age, e.t_name "
							+ "FROM player p, team e "
							+ "WHERE p.t_code  = e.t_code "
							+ "and p.p_position = 'DF' "
							+ "ORDER BY p.p_pay desc";
					Connection con = null;
					PreparedStatement pstmt = null;
					ResultSet rs = null;
					
					System.out.println("���� �̸�\t\t���� \t������ \t��� �Ⱓ \t\t����\t\t����\t�� ��");
					System.out.println("������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������");
					try {
						Class.forName(driver);
						con = DriverManager.getConnection(url, "pjh", "2015150046");
						pstmt = con.prepareStatement(sql);
						rs = pstmt.executeQuery(); 
						while (rs.next()) {
							String playername = rs.getString("P_NAME"); 
							long playerpay = rs.getLong("P_pay");
							String playernationality = rs.getString("P_nationality");
							String playerposition = rs.getString("P_POSITION");
							String playercontract = rs.getString("P_CONTRACT");
							String playerage = rs.getString("P_AGE");
							String timname = rs.getString("T_NAME");
							System.out.println(playername + "\t" +  "\t" + playernationality + "\t" + playerposition + "\t" 
							+ playercontract + "\t" + playerpay + "\t" + playerage + "\t" + timname) ;
						}
					}		
					catch (Exception e) {System.out.println(e.getMessage());}		
					finally {
						try {rs.close();
							pstmt.close();
							con.close();
						} catch (Exception e) {}
					}
				}//sel=C3	
				
				if(sel.equals("C4")){
					String sql = "SELECT p.p_name, p.p_pay, p.p_nationality, p.p_position, p.p_contract, p.p_age, e.t_name "
							+ "FROM player p, team e "
							+ "WHERE p.t_code  = e.t_code "
							+ "and p.p_position = 'MF' "
							+ "ORDER BY p.p_pay desc";
					Connection con = null;
					PreparedStatement pstmt = null;
					ResultSet rs = null;
					
					System.out.println("���� �̸�\t\t���� \t������ \t��� �Ⱓ \t\t����\t\t����\t�� ��");
					System.out.println("������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������");
					try {
						Class.forName(driver);
						con = DriverManager.getConnection(url, "pjh", "2015150046");
						pstmt = con.prepareStatement(sql);
						rs = pstmt.executeQuery(); 
						while (rs.next()) {
							String playername = rs.getString("P_NAME"); 
							long playerpay = rs.getLong("P_pay");
							String playernationality = rs.getString("P_nationality");
							String playerposition = rs.getString("P_POSITION");
							String playercontract = rs.getString("P_CONTRACT");
							String playerage = rs.getString("P_AGE");
							String timname = rs.getString("T_NAME");
							System.out.println(playername + "\t" +  "\t" + playernationality + "\t" + playerposition + "\t" 
							+ playercontract + "\t" + playerpay + "\t" + playerage + "\t" + timname) ;
						}
					}		
					catch (Exception e) {System.out.println(e.getMessage());}		
					finally {
						try {rs.close();
							pstmt.close();
							con.close();
						} catch (Exception e) {}
					}
				}//sel=C4	
				
				if(sel.equals("C5")){
					String sql = "SELECT p.p_name, p.p_pay, p.p_nationality, p.p_position, p.p_contract, p.p_age, e.t_name "
							+ "FROM player p, team e "
							+ "WHERE p.t_code  = e.t_code "
							+ "and p.p_position in ('ST', 'FW')"
							+ "ORDER BY p.p_pay desc";
					Connection con = null;
					PreparedStatement pstmt = null;
					ResultSet rs = null;
					
					System.out.println("���� �̸�\t\t���� \t������ \t��� �Ⱓ \t\t����\t\t����\t�� ��");
					System.out.println("������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������");
					try {
						Class.forName(driver);
						con = DriverManager.getConnection(url, "pjh", "2015150046");
						pstmt = con.prepareStatement(sql);
						rs = pstmt.executeQuery(); 
						while (rs.next()) {
							String playername = rs.getString("P_NAME"); 
							long playerpay = rs.getLong("P_pay");
							String playernationality = rs.getString("P_nationality");
							String playerposition = rs.getString("P_POSITION");
							String playercontract = rs.getString("P_CONTRACT");
							String playerage = rs.getString("P_AGE");
							String timname = rs.getString("T_NAME");
							System.out.println(playername + "\t" +  "\t" + playernationality + "\t" + playerposition + "\t" 
							+ playercontract + "\t" + playerpay + "\t" + playerage + "\t" + timname) ;
						}
					}		
					catch (Exception e) {System.out.println(e.getMessage());}		
					finally {
						try {rs.close();
							pstmt.close();
							con.close();
						} catch (Exception e) {}
					}
				}//sel=C5	
				
				if(sel.equals("D1")){
					String sql = "SELECT p.p_name, p.p_cm, p.p_kg, p.p_nationality, p.p_position, p.p_contract, p.p_pay, p.p_age, e.t_name "
							+ "FROM player p, team e "
							+ "WHERE e.t_code = p.t_code "
							+ "ORDER BY p.p_age desc";
					Connection con = null;
					PreparedStatement pstmt = null;
					ResultSet rs = null;
					
					System.out.println("���� �̸� \t����(p_cm) \tü��(p_kg) \t���� \t������ \t��� �Ⱓ \t\t����\t\t����\t�� ��");
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
							String playernationality = rs.getString("P_nationality");
							String playerposition = rs.getString("P_POSITION");
							String playercontract = rs.getString("P_CONTRACT");
							long playerpay = rs.getLong("P_pay");
							String playerage = rs.getString("P_AGE");
							String timname = rs.getString("T_NAME");
							System.out.println(playername + "\t" + playercm + "\t" + playerkg + "\t" + playernationality
									 + "\t" + playerposition + "\t" + playercontract + "\t" + playerpay + "\t" + 
									playerage + "\t" + timname) ;
						}
					}		
					catch (Exception e) {System.out.println(e.getMessage());}		
					finally {
						try {rs.close();
							pstmt.close();
							con.close();
						} catch (Exception e) {}
					}
				}//sel=D1
				
				if(sel.equals("D2")){
					String sql = "SELECT p.p_name, p.p_cm, p.p_kg, p.p_nationality, p.p_position, p.p_contract, p.p_pay, p.p_age, e.t_name "
							+ "FROM player p, team e "
							+ "WHERE e.t_code = p.t_code "
							+ "ORDER BY p.p_cm desc";
					Connection con = null;
					PreparedStatement pstmt = null;
					ResultSet rs = null;
					
					System.out.println("���� �̸� \t����(p_cm) \tü��(p_kg) \t���� \t������ \t��� �Ⱓ \t\t����\t\t����\t�� ��");
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
							String playernationality = rs.getString("P_nationality");
							String playerposition = rs.getString("P_POSITION");
							String playercontract = rs.getString("P_CONTRACT");
							long playerpay = rs.getLong("P_pay");
							String playerage = rs.getString("P_AGE");
							String timname = rs.getString("T_NAME");
							System.out.println(playername + "\t" + playercm + "\t" + playerkg + "\t" + playernationality
									 + "\t" + playerposition + "\t" + playercontract + "\t" + playerpay + "\t" + 
									playerage + "\t" + timname) ;
						}
					}		
					catch (Exception e) {System.out.println(e.getMessage());}		
					finally {
						try {rs.close();
							pstmt.close();
							con.close();
						} catch (Exception e) {}
					}
				}//sel=D2
				
				if(sel.equals("D3")){
					String sql = "SELECT p.p_name, p.p_cm, p.p_kg, p.p_nationality, p.p_position, p.p_contract, p.p_pay, p.p_age, e.t_name "
							+ "FROM player p, team e"
							+ "WHERE e.t_code = p.t_code "
							+ "ORDER BY p.p_kg desc";
					Connection con = null;
					PreparedStatement pstmt = null;
					ResultSet rs = null;
					
					System.out.println("���� �̸� \t����(p_cm) \tü��(p_kg) \t���� \t������ \t��� �Ⱓ \t\t����\t\t����\t�� ��");
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
							String playernationality = rs.getString("P_nationality");
							String playerposition = rs.getString("P_POSITION");
							String playercontract = rs.getString("P_CONTRACT");
							long playerpay = rs.getLong("P_pay");
							String playerage = rs.getString("P_AGE");
							String timname = rs.getString("T_NAME");
							System.out.println(playername + "\t" + playercm + "\t" + playerkg + "\t" + playernationality
									 + "\t" + playerposition + "\t" + playercontract + "\t" + playerpay + "\t" + 
									playerage + "\t" + timname) ;
						}
					}		
					catch (Exception e) {System.out.println(e.getMessage());}		
					finally {
						try {rs.close();
							pstmt.close();
							con.close();
						} catch (Exception e) {}
					}
				}//sel=D3
				
				if(sel.equals("E")){
					String sql = "SELECT p.p_name,  p.p_contract, p.p_nationality, p.p_position, p.p_age, p.p_pay "
							+ "FROM player p "
							+ "WHERE p.p_contract IN "
							+ "(SELECT b.p_contract "
							+ "FROM player b "
							+ "WHERE b.p_contract LIKE '2018%')";
					
					Connection con = null;
					PreparedStatement pstmt = null;
					ResultSet rs = null;
					
					System.out.println("���� �̸� \t��� ����\t\t����\t������\t����\t�޿�");
					System.out.println("����������������������������������������������������������������������������������������������������������������������������������������");
					
					try {
						Class.forName(driver);
						con = DriverManager.getConnection(url, "pjh", "2015150046");
						pstmt = con.prepareStatement(sql);
						rs = pstmt.executeQuery(); 
						while (rs.next()) {
							String playername = rs.getString("P_NAME"); 
							String playercontract = rs.getString("P_CONTRACT");
							String playernationality = rs.getString("P_nationality");
							String playerposition = rs.getString("P_POSITION");
							String playerage = rs.getString("P_AGE");
							long playerpay = rs.getLong("P_pay");
							System.out.println(playername + "\t" + playercontract + "\t" + playernationality
									 + "\t" + playerposition  + "\t" + playerage + "\t" + playerpay) ;
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
					String sql = "select a.a_code, a.a_name, p.p_name, t.t_name from player p, agent a, team t where p.p_code=a.p_code and t.t_code= p.t_code";
					
					Connection con = null;
					PreparedStatement pstmt = null;
					ResultSet rs = null;
					
					System.out.println("������Ʈ �ڵ� \t������Ʈ �̸�\t\t���� �̸�\t�� ��");
					System.out.println("����������������������������������������������������������������������������������������������������������������������������������������");
					
					try {
						Class.forName(driver);
						con = DriverManager.getConnection(url, "pjh", "2015150046");
						pstmt = con.prepareStatement(sql);
						rs = pstmt.executeQuery(); 
						while (rs.next()) {
							String agentcode = rs.getString("A_CODE"); 
							String agentname = rs.getString("A_NAME"); 
							String playername = rs.getString("P_NAME"); 
							String teamname = rs.getString("T_NAME"); 
							
							System.out.println(agentcode + "\t" + agentname + "\t" + playername
									 + "\t" + teamname) ;
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
				
			}//���ǹ� Ʋ
} //��ü Ʋ

