package EPLTEAM;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class EPL_TEAM {

	Scanner scan = new Scanner(System.in);  // 陝 詭模萄滌 醞犒腎朝 о跡 貍鹵.
	Scanner scan2 = new Scanner(System.in);
	String driver = "oracle.jdbc.driver.OracleDriver"; 
	String url = "jdbc:oracle:thin:@localhost:1521:orcl";
	
		public void selectMethod() {
			String sql = "select T.T_CODE, T.T_NAME, M.M_NAME, T.M_CODE from team T, manager M WHERE T.M_CODE = M.M_CODE";
			Connection con = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			
			System.out.println("ぜ 囀萄 \tぜ 貲 \t\t馬絮 貲\t馬絮 囀萄");
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
	
		public void updateMethod() {	// ぜ 薑爾 熱薑		
			String sql = "UPDATE TEAM SET M_CODE = ? WHERE T_CODE = ?";	
			Connection con = null;
			PreparedStatement pstmt = null;		
			try {
				Class.forName(driver);
				con = DriverManager.getConnection(url, "pjh", "2015150046");
				pstmt = con.prepareStatement(sql);
				
				System.out.printf("熱薑й ぜ曖 囀萄 殮溘: ");
				String teamcode = scan.next();
				System.out.printf("熱薑й 馬絮囀萄 殮溘: ");
				String managercode = scan2.next();		
				
				pstmt.setString(1, managercode);
				pstmt.setString(2, teamcode);
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
	

	
		public void deleteMethod() {	// ぜ 餉薯
			String sql = "DELETE FROM TEAM WHERE T_CODE = ?";
			String teamcode = "";
			
			Connection con = null;
			PreparedStatement pstmt = null;		
			try {
				Class.forName(driver);
				con = DriverManager.getConnection(url, "pjh", "2015150046");
				pstmt = con.prepareStatement(sql);
				
				System.out.print("餉薯й ぜ囀萄蒂 殮溘ж衛螃: ");
				teamcode = scan.next();
				
				pstmt.setString(1, teamcode);
				int cnt = pstmt.executeUpdate(); 
				System.out.println(cnt + "勒檜 褒ч腎歷蝗棲棻.");	
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
				
				System.out.printf("殮溘й ぜ囀萄: ");
				String teamcode = scan.next();
				System.out.printf("殮溘й ぜ貲: ");
				String teamname = scan2.nextLine();			
				System.out.printf("殮溘й 馬絮囀萄: ");
				String managercode = scan2.nextLine();			
				
				pstmt.setString(1, teamcode);
				pstmt.setString(2, teamname);
				//pstmt.setInt(3, price);
				pstmt.setString(3, managercode);
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
		
		public void textra_round() {		
			System.out.println("");
			System.out.println("[[錳ж朝 詭景蒂 摹鷗ж褊衛螃.]]");
			System.out.println("");
			System.out.println("灰 A.ぜ滌 馬絮 匐儀");
			System.out.println("早");
			System.out.println("朵 B.ぜ滌 晝罹 ゎ敕");
			System.out.println("早     汍 B1. ぜ 瞪羹");
			System.out.println("早     汍 B2. 埤酈ぷ");
			System.out.println("早     汍 B3. 熱綠熱");
			System.out.println("早     汍 B4. 嘐萄в渦");
			System.out.println("早     汍 B5. 奢問熱");
			System.out.println("早");
			System.out.println("朵 C.ぜ滌 摹熱 翱滄渠");
			System.out.println("早");
			System.out.println("朵 D.ぜ滌 濰褐 摹熱 匐儀");
			System.out.println("早");
			System.out.println("朵 E.ぜ 爾渦霞 匐儀");
			System.out.println("早");
			System.out.println("朵 F.ぜ 囀纂霞 匐儀");
			System.out.println("汍 ");
			
			System.out.print("=> ");
			String sel = scan.next();
			
			if(sel.equals("A")){
				String sql = "SELECT e.t_name, m.m_name, m.m_contract, m.m_nationality "
						+ "FROM team E, manager M "
						+ "WHERE E.M_CODE = M.M_CODE";
				Connection con = null;
				PreparedStatement pstmt = null;
				ResultSet rs = null;
				
				System.out.println("ぜ 貲 \t\t馬絮 檜葷 \t\t啗擒 晦除 \t措瞳");
				System.out.println("式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式");

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
			
			System.out.println("ぜ貲 \t\t摹熱 ゎ敕 晝罹 \t摹熱 譆堅 晝罹 \t摹熱 譆盪 晝罹");
			System.out.println("式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式");

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
			
			System.out.println("ぜ貲\t\tん雖暮\t\t摹熱 ゎ敕 晝罹 \t摹熱 譆堅 晝罹 \t摹熱 譆盪 晝罹");
			System.out.println("式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式");

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
			
			System.out.println("ぜ貲\t\tん雖暮\t\t摹熱 ゎ敕 晝罹 \t摹熱 譆堅 晝罹 \t摹熱 譆盪 晝罹");
			System.out.println("式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式");

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
			
			System.out.println("ぜ貲\t\tん雖暮\t\t摹熱 ゎ敕 晝罹 \t摹熱 譆堅 晝罹 \t摹熱 譆盪 晝罹");
			System.out.println("式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式");

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
			
			System.out.println("ぜ貲\t\tん雖暮\t\t摹熱 ゎ敕 晝罹 \t摹熱 譆堅 晝罹 \t摹熱 譆盪 晝罹");
			System.out.println("式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式");

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
			
			System.out.println("ぜ貲 \t\t摹熱 ゎ敕 釭檜 \t摹熱 譆堅 釭檜 \t摹熱 譆盪 釭檜");
			System.out.println("式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式");

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
			
			System.out.println("ぜ貲 \t\t摹熱 貲 \t褐濰\t羹醞\tん雖暮\t釭檜\t晝罹\t\t措瞳");
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
			System.out.printf("ぜ 囀萄 殮溘: ");
			String tcode = scan.next();
			
			String sql = "select t.t_name, b.b_name, b.b_position from board b, team t where b.t_code=t.t_code and t.t_code LIKE ?";
			Connection con = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			
			System.out.println("ぜ貲 \t\t爾渦 檜葷 \t\t爾渦 霜嬪");
			System.out.println("式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式");

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
			System.out.printf("ぜ 囀萄 殮溘: ");
			String bposition = scan.next();
			
			String sql = "select t.t_name, c.c_name, c.c_position from coach c, team t where c.t_code=t.t_code and t.t_code LIKE ?";
			Connection con = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			
			System.out.println("ぜ貲 \t\t囀纂 檜葷 \t\t囀纂 霜嬪");
			System.out.println("式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式");

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
		
	} //韓曖 婪��
} //瞪羹 婪��
