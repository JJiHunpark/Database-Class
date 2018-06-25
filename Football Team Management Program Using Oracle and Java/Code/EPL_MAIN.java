//http://mainichibenkyo.tistory.com/53
package EPLTEAM;
import java.util.*;
public class EPL_MAIN {

	public static void main(String args[]) {
		Scanner scan = new Scanner(System.in);
		int mainNo, cmdNo, cmdNo2, cmdNo3 = 0;
		
		System.out.println("---EPLSP_MAIN---");
		System.out.println("[[관리하실 메뉴를 선택하십시오.]]");
		System.out.println("┎───────────────────────────┒");
		System.out.println("  1.팀 관리 ┼ 2.감독 관리  ┼ 3.선수 관리 ┼ 4.종료  ");
		System.out.println("┖───────────────────────────┚");
		System.out.print("=> ");
		
		mainNo = scan.nextInt() ;
		System.out.println("");
		
		if(mainNo == 1) {		//팀관리
			while (true) {
				System.out.println("");
				System.out.println("---EPLSP_TEAM---");
				System.out.println("[[원하는 메뉴를 선택하십시오.]]");
				System.out.println("┎────────────────────────────────────────┒");
				System.out.println("  1.팀 조회 ┼ 2.팀 정보 수정 ┼ 3.팀 삭제 ┼ 4.새로운 팀 추가 ┼ 5.종료    ");
				System.out.println("  ┖eTc.6.검색┒                                                                                                                 ");
				System.out.println("┖────────────────────────────────────────┚");
				System.out.print("=> ");
				cmdNo = scan.nextInt();
				System.out.println("");
				
				if (cmdNo == 1) {
					EPL_TEAM select = new EPL_TEAM(); // 조회 클래스의 객체 생성
					select.selectMethod(); // 조회 클래스의 조회 메소드 실행
				}
				else if (cmdNo == 2) {
					EPL_TEAM update = new EPL_TEAM(); // 수정 클래스의 객체 생성
					update.updateMethod(); // 수정 클래스의 수정 메소드 실행
				}
				else if (cmdNo == 3) {
					EPL_TEAM delete = new EPL_TEAM(); // 삭제 클래스의 객체 생성
					delete.deleteMethod(); // 삭제 클래스의 삭제 메소드 실행
				}
				else if (cmdNo == 4) {
					EPL_TEAM insert = new EPL_TEAM(); // 입력 클래스의 객체 생성
					insert.insertMethod(); // 입력 클래스의 입력 메소드 실행
				}
				else if (cmdNo == 6) {
					EPL_TEAM insert = new EPL_TEAM(); // 입력 클래스의 객체 생성
					insert.textra_round(); // 입력 클래스의 입력 메소드 실행
				}
				else {
					System.out.println("잘 못 입력하셨습니다.");
					scan.close();
					break ;
				}			
			}
		} //mainNo == 1
		
		else if(mainNo == 2) {		//감독관리
			while (true) {
				System.out.println("");
				System.out.println("---EPLSP_MANAGER---");
				System.out.println("[[원하는 메뉴를 선택하십시오.]]");
				System.out.println("┎───────────────────────────────────────────┒");
				System.out.println("  1.감독 조회 ┼ 2.감독 정보 수정 ┼ 3.감독 삭제 ┼ 4.새로운 감독 추가 ┼ 5.종료   ");
				System.out.println("  ┖eTc.6.검색┒                                                                                                                               ");
				System.out.println("┖───────────────────────────────────────────┚");
				System.out.print("=> ");
				cmdNo2 = scan.nextInt();
				System.out.println("");
				
				if (cmdNo2 == 1) {
					EPL_MANAGER select = new EPL_MANAGER(); // 조회 클래스의 객체 생성
					select.selectMethod(); // 조회 클래스의 조회 메소드 실행
				}
				else if (cmdNo2 == 2) {
					EPL_MANAGER update = new EPL_MANAGER(); // 수정 클래스의 객체 생성
					update.updateMethod(); // 수정 클래스의 수정 메소드 실행
				}
				else if (cmdNo2 == 3) {
					EPL_MANAGER delete = new EPL_MANAGER(); // 삭제 클래스의 객체 생성
					delete.deleteMethod(); // 삭제 클래스의 삭제 메소드 실행
				}
				else if (cmdNo2 == 4) {
					EPL_MANAGER insert = new EPL_MANAGER(); // 입력 클래스의 객체 생성
					insert.insertMethod(); // 입력 클래스의 입력 메소드 실행
				}
				else if (cmdNo2 == 6) {
					EPL_MANAGER insert = new EPL_MANAGER(); // 입력 클래스의 객체 생성
					insert.extra_round(); // 입력 클래스의 입력 메소드 실행
				}
				else {
					System.out.println("잘 못 입력하셨습니다.");
					scan.close();
					break ;
				}			
			}
		}//mainNO == 2
		
		else if(mainNo == 3) {		//선수관리
			while (true) {
				System.out.println("");
				System.out.println("---EPLSP_PLAYER---");
				System.out.println("[[원하는 메뉴를 선택하십시오.]]");
				System.out.println("┎───────────────────────────────────────────┒");
				System.out.println("  1.선수 조회 ┼ 2.선수 정보 수정 ┼ 3.선수 삭제 ┼ 4.새로운 선수 추가 ┼ 5.종료  " );
				System.out.println("  ┖eTc.6.검색┒                                                                                                                         ");
				System.out.println("┖───────────────────────────────────────────┚");
				System.out.print("=> ");

				cmdNo3 = scan.nextInt();
				System.out.println("");
				
				if (cmdNo3 == 1) {
					EPL_PLAYER select = new EPL_PLAYER(); // 조회 클래스의 객체 생성
					select.selectMethod(); // 조회 클래스의 조회 메소드 실행
				}
				else if (cmdNo3 == 2) {
					EPL_PLAYER update = new EPL_PLAYER(); // 수정 클래스의 객체 생성
					update.updateMethod(); // 수정 클래스의 수정 메소드 실행
				}
				else if (cmdNo3 == 3) {
					EPL_PLAYER delete = new EPL_PLAYER(); // 삭제 클래스의 객체 생성
					delete.deleteMethod(); // 삭제 클래스의 삭제 메소드 실행
				}
				else if (cmdNo3 == 4) {
					EPL_PLAYER insert = new EPL_PLAYER(); // 입력 클래스의 객체 생성
					insert.insertMethod(); // 입력 클래스의 입력 메소드 실행
				}
				else if (cmdNo3 == 6) {
					EPL_PLAYER insert = new EPL_PLAYER(); // 입력 클래스의 객체 생성
					insert.pextra_round(); // 입력 클래스의 입력 메소드 실행
				}
				else {
					System.out.println("잘 못 입력하셨습니다.");
					scan.close();
					break ;
				}			
				
			}
		}//mainNO == 3
		else if(mainNo == 4) {
			scan.close();
		}//mainNO == 4
		else 
			System.out.println("잘못 입력하셨습니다.");
	}
}