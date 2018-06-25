package EPLTEAM;

import java.sql.Connection;
	import java.sql.DriverManager;
	import java.sql.PreparedStatement;
	import java.sql.ResultSet;
	import java.util.Scanner;
	
public class EPL_PLAYER {
		Scanner scan = new Scanner(System.in);  // 陝 詭模萄滌 醞犒腎朝 о跡 貍鹵.
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
					
					System.out.printf("熱薑й 摹熱曖 囀萄 殮溘: ");
					String playercode = scan.next();
					System.out.printf("熱薑й ぜ囀萄 殮溘: ");
					String teamcode = scan2.nextLine();
					System.out.printf("熱薑й 啗擒虜猿橾 殮溘: ");
					String playercontract = scan2.nextLine();
					System.out.printf("熱薑й 翱瑰 殮溘: ");
					long playerpay = scan2.nextLong();		
					
					pstmt.setString(1, teamcode);
					pstmt.setString(2, playercontract);
					pstmt.setLong(3, playerpay);
					pstmt.setString(4, playercode);
					int cnt = pstmt.executeUpdate(); 
					System.out.println(cnt + "勒檜 褒ч腎歷蝗棲棻.");
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
					
					System.out.print("餉薯й 摹熱 囀萄蒂 殮溘ж衛螃: ");
					playercode = scan.next();
					
					pstmt.setString(1, playercode);
					int cnt = pstmt.executeUpdate(); 
					System.out.println(cnt + "勒檜 褒ч腎歷蝗棲棻.");
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
					
					System.out.printf("殮溘й 摹熱囀萄: ");
					String playercode = scan.next();
					System.out.printf("殮溘й 摹熱檜葷: ");
					String playername = scan2.nextLine();			
					System.out.printf("殮溘й 摹熱 褐濰: ");
					String playercm = scan2.nextLine();	
					System.out.printf("殮溘й 摹熱 羹醞: ");
					String playerkg = scan2.nextLine();
					System.out.printf("殮溘й 摹熱 措瞳: ");
					String playernationality = scan2.nextLine();
					System.out.printf("殮溘й ぜ囀萄: ");
					String timecode = scan2.nextLine();
					System.out.printf("殮溘й 摹熱 ん雖暮: ");
					String playerposition = scan2.nextLine();
					System.out.printf("殮溘й 摹熱 啗擒虜猿: ");
					String playercontract = scan2.nextLine();
					System.out.printf("殮溘й 摹熱 熱殮: ");
					long playerpay = scan2.nextLong();
					System.out.printf("殮溘й 摹熱 釭檜: ");
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
					System.out.println(cnt + "勒檜 褒ч腎歷蝗棲棻.");			
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
			
///////////////////////////////////////////////////////////////////////////////////////////////////////韓曖僥
		
			public void pextra_round() {		
				System.out.println("");
				System.out.println("[[錳ж朝 詭景蒂 摹鷗ж褊衛螃.]]");
				System.out.println("");
				System.out.println("灰 A.ん雖暮 滌 摹熱 匐儀");
				System.out.println("早     汍A1. 埤酈ぷ");
				System.out.println("早     汍A2. 熱綠熱");
				System.out.println("早     汍A3. 嘐萄в渦");
				System.out.println("早     汍A4. 奢問熱");
				System.out.println("早");
				System.out.println("早 B.措瞳戲煎 摹熱 匐儀");
				System.out.println("早");
				System.out.println("朵 C.晝罹 牖 摹熱 薑溺");
				System.out.println("早     汍C1. 瞪羹");
				System.out.println("早     汍C2. 埤酈ぷ");
				System.out.println("早     汍C3. 熱綠熱");
				System.out.println("早     汍C4. 嘐萄в渦");
				System.out.println("早     汍C5. 奢問熱");
				System.out.println("早");
				System.out.println("朵 D.etc");
				System.out.println("早     汍D1. 釭檜 晦遽 摹熱 匐儀");
				System.out.println("早     汍D2. 褐濰 晦遽 摹熱 匐儀");
				System.out.println("早     汍D3. 羹醞 晦遽 摹熱 匐儀");
				System.out.println("早");
				System.out.println("朵 E.營啗擒 в蹂 摹熱 匐儀");
				System.out.println("早");
				System.out.println("朵 F.摹熱 滌 縑檜瞪お 匐儀");
				System.out.println("汍 ");
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
					
					System.out.println("摹熱 檜葷 \t褐濰(p_cm) \t羹醞(p_kg) \t措瞳 \tん雖暮 \t啗擒 晦除 \t\t熱殮\t\t釭檜\tぜ 貲");
					System.out.println("式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式");
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
					
					System.out.println("摹熱 檜葷 \t褐濰(p_cm) \t羹醞(p_kg) \t措瞳 \tん雖暮 \t啗擒 晦除 \t\t熱殮\t\t釭檜\tぜ 貲");
					System.out.println("式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式");
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
					
					System.out.println("摹熱 檜葷 \t褐濰(p_cm) \t羹醞(p_kg) \t措瞳 \tん雖暮 \t啗擒 晦除 \t\t熱殮\t\t釭檜\tぜ 貲");
					System.out.println("式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式");
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
					
					System.out.println("摹熱 檜葷 \t褐濰(p_cm) \t羹醞(p_kg) \t措瞳 \tん雖暮 \t啗擒 晦除 \t\t熱殮\t\t釭檜\tぜ 貲");
					System.out.println("式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式");
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
					System.out.printf("措陛 殮溘: ");
					String pnationality = scan.next();
					
					String sql = "SELECT p.p_name, p.p_cm, p.p_kg, p.p_nationality, p.p_position, p.p_contract, p.p_pay, p.p_age, e.t_name "
							+ "FROM player p, team e  "
							+ "WHERE e.t_code = p.t_code "
							+ "and p.p_nationality = ?";
					
					Connection con = null;
					PreparedStatement pstmt = null;
					ResultSet rs = null;
					
					System.out.println("摹熱 檜葷 \t褐濰(p_cm) \t羹醞(p_kg) \t措瞳 \tん雖暮 \t啗擒 晦除 \t\t熱殮\t\t釭檜\tぜ 貲");
					System.out.println("式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式");
					
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
					
					System.out.println("摹熱 檜葷\t\t措瞳 \tん雖暮 \t啗擒 晦除 \t\t熱殮\t\t釭檜\tぜ 貲");
					System.out.println("式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式");
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
					
					System.out.println("摹熱 檜葷\t\t措瞳 \tん雖暮 \t啗擒 晦除 \t\t熱殮\t\t釭檜\tぜ 貲");
					System.out.println("式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式");
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
					
					System.out.println("摹熱 檜葷\t\t措瞳 \tん雖暮 \t啗擒 晦除 \t\t熱殮\t\t釭檜\tぜ 貲");
					System.out.println("式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式");
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
					
					System.out.println("摹熱 檜葷\t\t措瞳 \tん雖暮 \t啗擒 晦除 \t\t熱殮\t\t釭檜\tぜ 貲");
					System.out.println("式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式");
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
					
					System.out.println("摹熱 檜葷\t\t措瞳 \tん雖暮 \t啗擒 晦除 \t\t熱殮\t\t釭檜\tぜ 貲");
					System.out.println("式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式");
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
					
					System.out.println("摹熱 檜葷 \t褐濰(p_cm) \t羹醞(p_kg) \t措瞳 \tん雖暮 \t啗擒 晦除 \t\t熱殮\t\t釭檜\tぜ 貲");
					System.out.println("式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式");
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
					
					System.out.println("摹熱 檜葷 \t褐濰(p_cm) \t羹醞(p_kg) \t措瞳 \tん雖暮 \t啗擒 晦除 \t\t熱殮\t\t釭檜\tぜ 貲");
					System.out.println("式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式");
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
					
					System.out.println("摹熱 檜葷 \t褐濰(p_cm) \t羹醞(p_kg) \t措瞳 \tん雖暮 \t啗擒 晦除 \t\t熱殮\t\t釭檜\tぜ 貲");
					System.out.println("式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式");
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
					
					System.out.println("摹熱 檜葷 \t啗擒 虜猿\t\t措瞳\tん雖暮\t釭檜\t晝罹");
					System.out.println("式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式");
					
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
					
					System.out.println("縑檜瞪お 囀萄 \t縑檜瞪お 檜葷\t\t摹熱 檜葷\tぜ 貲");
					System.out.println("式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式");
					
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
				
			}//韓曖僥 ぎ
} //瞪羹 ぎ

