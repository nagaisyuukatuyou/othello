
import java.util.InputMismatchException;
import java.util.Scanner;

public class gameManager {

	static int num;
	char[][] masu = new char[9][8];
	Scanner stdin = new Scanner(System.in);
	gimic gimic = new gimic();
	
	public gameManager(){
		
		System.out.printf("先攻: %c 後攻: %c\n\n", gimic.black, gimic.white);
		
	}
	
	public void gamemake() {
		
		while(true){
			
			System.out.print("実行環境を選んでください。\n[1]eclipse[2]コンソール[3]その他\n");
			
			try {
				
				num = stdin.nextInt();

			}catch(InputMismatchException e) {
				
				System.out.println("無効です。やり直してください。\n");
				stdin.nextLine();
				continue;
			
			}catch(StringIndexOutOfBoundsException e2) {
			

				System.out.println("無効です。やり直してください。\n");
				stdin.nextLine();
				continue;
			
			}
			
			if(num == 1) {
				
				gimic.black = '○';
				gimic.white = '●';
				
			}
		
		
			
			System.out.print("ゲームを開始します。\n先攻[0]か後攻[1]か選んでください。\n");
		
			try {
			
				num = stdin.nextInt();

			}catch(InputMismatchException e) {
				
				System.out.println("無効です。やり直してください。\n");
				stdin.nextLine();
				continue;
			
			}catch(StringIndexOutOfBoundsException e2) {
			

				System.out.println("無効です。やり直してください。\n");
				stdin.nextLine();
				continue;
			
			}
			
			
			stdin.nextLine();
			
			break;
		
		}
		
		
		for(int i = 0; i < 9; i++) {
			
			for(int j = 0; j < 8; j++) {
				
				if(i == 4 && j == 3 || i == 5 && j == 4) {
					
					masu[i][j] = gimic.black;
					
				}else if(i == 4 && j == 4 || i == 5 && j == 3) {
					
					masu[i][j] = gimic.white;
					
				}else if(i == 0) {
					
					char num = gimic.jConvert(j);
					masu[i][j] = num;
					
				}else {
					
					masu[i][j] = gimic.space;
					
				}
				
			}
		}
		
		
		gimic.serch(masu);
		
		
		
	}
	
	public void mapPrint() {
		
		for(int i = 0; i < 9; i++) {
			
			System.out.print(i);
			
			for(int j = 0; j < 8; j++) {
					
				System.out.print(masu[i][j]);
					
			
				if(j == 7) {
					
					System.out.print("\n");
					
				}
				
				
			}
		}	
		
		System.out.print("\n");
		
	}
	
	
	
	public boolean playerTurn() {
		
		int xp;
		char yposition[];
		String strx = "";
		String stry = "";
		
		
		mapPrint();
		
		if(gimic.serch(masu)) {
		
			for(;;) {
			
				System.out.print("あなたのターンです\n駒を置く座標を半角英数字で入力してください(ex: 6d)\n");
				String position =stdin.nextLine();
				
				
				try {
					
					//入力された文字列を切り抜き
					strx = position.substring(0,1);
					stry = position.substring(1,2);
					
					//切り抜いた文字を数値、charに変換
					xp = Integer.parseInt(strx);
					yposition = stry.toCharArray();
				
				}catch(NumberFormatException e) {
					
					try {
						
						xp = Integer.parseInt(stry);
						yposition = strx.toCharArray();
						
					}catch(NumberFormatException e2) {
						
						System.out.println("無効です。やり直してください。\n");
						continue;
					}
					
				}catch(StringIndexOutOfBoundsException e3) {
					

					System.out.println("無効です。やり直してください。\n");
					continue;
					
				}
						
				int yp = gimic.jConvert(yposition[0]);
				yposition[0] =gimic.jConvert(yp);
		
				if(masu[xp][yp] == gimic.nl) {
					
		
					if(num == 0) {
			
						masu[xp][yp] = gimic.black;
			
					}else {
			
						masu[xp][yp] = gimic.white;
					}
				
					gimic.reverse(masu, xp, yp, 0);
				
					gimic.clean(masu);
				
					mapPrint();
				
					System.out.printf("%d%cに駒を設置しました。\nCPUのターンを実行していいですか？(yes or はい)\n", xp, yposition[0]);
					stdin.nextLine();
				
					return false;
			
				}else {
			
					System.out.println("無効です。やり直してください。\n");
				}
			}
			
		}else {
			
			System.out.println("あなたはパスです。\n");
			
			return true;
			
		}
	}
	
	public boolean cpuTurn() {
		
		boolean reverse = gimic.cpu(masu);
		
		mapPrint();
		gimic.serch(masu);
		
		if(reverse) {
			
			System.out.printf("%d%cにCPUが駒を設置しました\n\n", gimic.cxp, gimic.cyp);
			
			return false;
		
		}else {
			
			System.out.println("cpuがパスしました。あなたのターンに進みます。\n");
			
			return true;
					
		}
		
	}
	
	public boolean result() {
		
		int ans = gimic.judgment(masu);
		
		if(num == 0) {
			
			if(ans == 0) {
				
				System.out.println("あなたの勝ちです");
				
			}else if(ans == 1) {
				
				System.out.println("あなたの負けです");
				
			}else if(ans == 2) {
				
				System.out.println("引き分けです");
				
			}
			
		}else {
			

			if(ans == 0) {
				
				System.out.println("あなたの負けです");
				
			}else if(ans == 1) {
				
				System.out.println("あなたの勝ちです");
				
			}else if(ans == 2) {
				
				System.out.println("引き分けです");
			}
		}
		
		while(true) {
			System.out.println("もう一度ゲームをプレイしますか？[y/n]");
			char play = stdin.nextLine().charAt(0);
		
			if(play == 'y') {
			
				gamemake();
				return true;
			
			}else if(play == 'n') {
			
				return false;
			
			}else{
				System.out.println("無効です");
			}
		}

	}
	
	

	public void playerbot() {
		
		boolean reverse = gimic.playerbot(masu);
		
		
	}
	
	
	

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
