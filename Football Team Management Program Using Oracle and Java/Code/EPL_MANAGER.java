package EPLTEAM;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class EPL_MANAGER {

	Scanner scan = new Scanner(System.in);  // 각 메소드별 중복되는 항목 빼냄.
	Scanner scan2 = new Scanner(System.in);
	String driver = "oracle.jdbc.driver.OracleDriver"; 
	String url = "jdbc:oracle:thin:@localhost:1521:orcl";
	
		public void selectMethod() {		//정보 조회
			String sql = "SELECT * FROM MANAGER";
			Connection con = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			
			System.out.println("감독 코드 \t감독 명 \t경력 \t계약만료 \t국적");
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
	
	
	
		public void updateMethod() {		//정보 수정	
			String sql = "UPDATE MANAGER SET M_CAREER_Y=?, M_CONTRACT=? WHERE M_CODE=?";	
			Connection con = null;
			PreparedStatement pstmt = null;		
			try {
				Class.forName(driver);
				con = DriverManager.getConnection(url, "pjh", "2015150046");
				pstmt = con.prepareStatement(sql);
				
				System.out.printf("수정할 감독의 코드 입력: ");
				String managercode = scan.next();
				System.out.printf("수정할 감독 경력 입력(Year): ");
				String managerCAREER_Y = scan2.nextLine();
				System.out.printf("수정할 감독 계약 입력(ex.2019-11-11): ");
				String managercontract = scan2.nextLine();		
				pstmt.setString(1, managerCAREER_Y);
				pstmt.setString(2, managercontract);
				pstmt.setString(3, managercode);
				
				int cnt = pstmt.executeUpdate(); 
				System.out.println(cnt + "건이 실행되었습니다.");
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
	

	
		public void deleteMethod() {		//정보 삭제
			String sql = "DELETE FROM MANAGER WHERE M_CODE = ?";
			String managercode = "";
			
			Connection con = null;
			PreparedStatement pstmt = null;		
			try {
				Class.forName(driver);
				con = DriverManager.getConnection(url, "pjh", "2015150046");
				pstmt = con.prepareStatement(sql);
				
				System.out.print("삭제할 감독코드를 입력하시오: ");
				managercode = scan.next();
				
				pstmt.setString(1, managercode);
				int cnt = pstmt.executeUpdate(); 
				System.out.println(cnt + "건이 실행되었습니다.");
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
	

		public void insertMethod() {		//정보 삽입
			String sql = "INSERT INTO MANAGER(M_CODE, M_NAME, M_CAREER_Y, M_CONTRACT, M_NATIONALITY) VALUES(?, ?, ?, ?, ?)";			
			Connection con = null;
			PreparedStatement pstmt = null;
			
			try {
				Class.forName(driver);
				con = DriverManager.getConnection(url, "pjh", "2015150046");
				pstmt = con.prepareStatement(sql);
				
				System.out.printf("입력할 감독 코드: ");
				String managercode = scan.next();
				System.out.printf("입력할 감독 이름: ");
				String managername = scan2.nextLine();
				System.out.printf("입력할 감독 경력(Year): ");
				String managerCAREER_Y = scan2.nextLine();
				System.out.printf("입력할 감독 계약(ex.2019-11-11): ");
				String managercontract = scan2.nextLine();
				System.out.printf("입력할 감독 국적: ");
				String managerNATIONALITY = scan2.nextLine();
				
				pstmt.setString(1, managercode);
				pstmt.setString(2, managername);
				pstmt.setString(3, managerCAREER_Y);
				pstmt.setString(4, managercontract);
				pstmt.setString(5, managerNATIONALITY);
				int cnt = pstmt.executeUpdate(); 
				System.out.println(cnt + "건이 실행되었습니다.");			
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
		
///////////////////////////////////////////////////////////////////////////////////////////////////////질의문
		
		public void extra_round() {		
			System.out.println(" ");
			System.out.println("[[원하는 메뉴를 선택하십시오.]]");
			System.out.println("");
			System.out.println("┎ A.이름 순 감독 검색");
			System.out.println("┃");
			System.out.println("┠ B.국적으로 감독 검색");
			System.out.println("┃");
			System.out.println("┠ C.국적 순 감독 검색");
			System.out.println("┃");
			System.out.println("┠ D.계약 만료 순 감독 검색");
			System.out.println("┃");
			System.out.println("┖ E.경력 순 감독 검색");
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
				
				System.out.println("감독 이름 \t\t경력(Y)\t계약기간 \t국적 \t팀 명");
				System.out.println("───────────────────────────────────────────────────────────");
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
				
				System.out.println("감독 이름 \t\t경력(Y)\t계약기간 \t국적 \t팀 명");
				System.out.println("───────────────────────────────────────────────────────────");
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
				
				System.out.println("감독 이름 \t\t경력(Y)\t계약기간 \t국적 \t팀 명");
				System.out.println("───────────────────────────────────────────────────────────");
				
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
				
				System.out.println("감독 이름 \t\t경력(Y)\t계약기간 \t국적 \t팀 명");
				System.out.println("───────────────────────────────────────────────────────────");
				
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
			
			
			///국적 검색기능
			
			if(sel.equals("B")){
				System.out.printf("국가 입력: ");
				String mNATIONALITY = scan.next();
				
				String sql = "SELECT * "
						+ "FROM MANAGER "
						+ "where M_NATIONALITY = ?";
				
				Connection con = null;
				PreparedStatement pstmt = null;
				ResultSet rs = null;
				
				System.out.println("감독 코드 \t이름\t경력(Y)\t계약기간 \t국적");
				System.out.println("───────────────────────────────────────────────────────────");
				
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
			
		}//extra_round 틀
}//전체 틀
