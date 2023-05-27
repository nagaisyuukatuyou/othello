
import java.util.Random;
public class gimic {

	
	int cxp,cyp;
	char space = '＊', black = '黒', white = '白', nl = '　';
	
	Random r = new Random();
	
	
	void gimic() {
		
		
		
	}
	
	public boolean serch(char masu[][]) {
		
		char t, s;
		
		if(gameManager.num == 0) {
			 t = black;
			 s = white;	
		}else {
			t = white;
			s = black;
		}
		
		//対象こま探索
		for(int i = 0; i < 9; i++) {
			
			for(int j = 0; j < 8; j++) {
				
				if(masu[i][j] == t) {
					
					//設置可能探索
					//左上探索				
					for(int k = i - 1, l = j - 1; k >= 2 && l >= 1; k--, l--) {
						
						
							if(masu[k][l] != s ) {
								
								break;
								
							}
							
							if(masu[k-1][l-1] == space) {
								
								masu[k-1][l-1] = nl;
								
							}
						
					}
					//左下探索
					for(int k = i + 1, l = j - 1; k <= 7 && l >= 1; k++, l--) {
						
						
						if(masu[k][l] != s ) {
							
							break;
							
						}
						
						if(masu[k+1][l-1] == space) {
							
							masu[k+1][l-1] = nl;
							
						}
					}
					//右上探索
					for(int k = i - 1, l = j + 1; k >= 2 && l <= 6; k--, l++) {
						
						
						if(masu[k][l] != s ) {
							
							break;
							
						}
						
						if(  masu[k-1][l+1] == space) {
							
							masu[k-1][l+1] = nl;
							
						}
					
					}
					//右下探索
					for(int k = i + 1, l = j + 1; k <= 7 && l <= 6; k++, l++) {
						
						
						if(masu[k][l] != s ) {
							
							break;
							
						}
						
						if( masu[k+1][l+1] == space) {
							
							masu[k+1][l+1] = nl;
							
						}
					}
					//右探索
					for(int  l = j + 1; l <= 6; l++) {
						
						
						if(masu[i][l] != s ) {
							
							break;
							
						}
					
						if( masu[i][l+1] == space) {
							
							masu[i][l+1] = nl;
							
						}
					}
					//左探索
					for(int  l = j - 1; l >= 1; l--) {
						
						
						if(masu[i][l] != s ) {
							
							break;
							
						}
						
						if( masu[i][l-1] == space) {
							
							masu[i][l-1] = nl;
							
						}
					}
					//上探索
					for(int  k = i - 1; k >= 2; k--) {
						
						
						if(masu[k][j] != s ) {
							
							break;
							
						}
						
						if( masu[k-1][j] == space) {
							
							masu[k-1][j] = nl;
							
						}
					}
					//下探索
					for(int  k = i + 1; k <= 7; k++) {
						
						
						if(masu[k][j] != s ) {
							
							break;
							
						}
						
						if(masu[k+1][j] == space) {
							
							masu[k+1][j] = nl;
							
						}
					}
					
				}	
				
				
			}
		}
		
		
		//パス判定
		int nlct = 0;
		
		for(int i = 0; i < 9; i++) {
			
			for(int j = 0; j < 8; j++) {
				
				if(masu[i][j] == nl) {
					
					nlct++;
					
				}
			}
		}
		
		if(nlct == 0) {
			
			return false;
			
		}else {
			
			return true;
		}
		
	}
	
	//ひっくり返す
	public void reverse(char masu[][], int xp, int yp, int player) {
		
		int i = xp, j = yp;
		
		char t, s;
		
		if(player == 0) {
			//player用
			if(gameManager.num == 0) {
				 t = black;
				 s = white;	
			}else {
				t = white;
				s = black;
			}
		}else {
			//cpu用
			if(gameManager.num == 0) {
				t = white;
				s = black;
			}else {
				t = black;
				s = white;	
			}
		}
		
		
		
			
			//左上探索
		if(i > 2 && j > 1) {
			for(int k =  i - 1, l = j - 1; k >= 2 && l >= 1; k--, l--) {
			
			
				if(masu[k][l] != s ) {
				
					break;
				
				}
			
				if( masu[k-1][l-1] == t) {
				
					int o = k, p = l;
					
					for(;i >= o || j >= p; o++, p++) {
						
						masu[o][p] = t;
						
					}	
				
				}
		
			}
		}
		
		if(i < 7 && j > 1) {
			//左下探索
			for(int k = i + 1, l = j - 1; k <= 7 && l >= 1; k++, l--) {
		
		
				if(masu[k][l] != s ) {
			
					break;
			
				}
		
				if( masu[k+1][l-1] == t) {
					
					int o = k, p = l;
					
					for(;i <= o || j >= p; o--, p++) {
						
						masu[o][p] = t;
						
					}	
				
				}
			}
		}
		if(i > 2 && j < 6) {
			//右上探索
			for(int k = i - 1, l = j + 1; k >= 2 && l <= 6; k--, l++) {
		
		
				if(masu[k][l] != s ) {
			
					break;
			
				}
				if( masu[k-1][l+1] == t) {
					
					int o = k, p = l;
					
					for(;i >= o || j <= p; o++, p--) {
						
						masu[o][p] = t;
						
					}	
				
				}
			}
		}
		if(i < 7 && j < 6) {
			//右下探索
			for(int k = i + 1, l = j + 1; k <= 7 && l <= 6; k++, l++) {
		
		
				if(masu[k][l] != s ) {
			
					break;
			
				}	
		
				if( masu[k+1][l+1] == t) {
					
					int o = k, p = l;
					
					for(;i <= o || j <= p; o--, p--) {
						
						masu[o][p] = t;
						
					}	
				
				}
			}
		}
		if(j < 6) {
			//右探索
			for(int  l = j + 1; l <= 6; l++) {
		
		
				if(masu[i][l] != s ) {
			
					break;
				
				}
	
				if( masu[i][l+1] == t) {
					
					int p = l;
					for(;j <= p;  p--) {
						
						masu[i][p] = t;
						
					}	
				
				}
			}
		}
		if(j > 1) {
			//左探索
			for(int  l = j - 1; l >= 1; l--) {
		
		
				if(masu[i][l] != s ) {
			
					break;
			
				}
		
				if( masu[i][l-1] == t) {
					
					int p = l;
					
					for(;j >= p;  p++) {
						
						masu[i][p] = t;
						
					}	
				
				}
			}
		}
		if(i > 2) {
			//上探索
			for(int  k = i - 1; k >= 2; k--) {
		
		
				if(masu[k][j] != s ) {
			
					break;
			
				}
		
				if( masu[k-1][j] == t) {
					
					int o = k;
					for(;i >= o;  o++) {
						
						masu[o][j] = t;
						
					}	
				
				}
			}
		}
		if(i < 7) {
			//下探索
			for(int  k = i + 1; k <= 7; k++) {
		
		
				if(masu[k][j] != s ) {
			
					break;
			
				}
		
				if( masu[k+1][j] == t) {
					
					int o = k;
					for(;i <= o;  o--) {
						
						masu[o][j] = t;
						
					}	
				
				}
			}
		}
		
		
	}
	
	public void clean(char masu[][]) {
		
		for(int i = 0; i < 9; i++) {
			
			for(int j = 0; j < 8; j++) {
				
				if(masu[i][j] == nl){
					
					masu[i][j] = space;
					
				}
				
			}
		}
		
	}
	
	public boolean cpu(char masu[][]) {
		
		char t, s;
		int[] pattern = new int[61];
		int patternct = 1,  xp, yp;
		
		
		if(gameManager.num == 0) {
			t = white;
			s = black;
		}else {
			 t = black;
			 s = white;	
		}
		
		//対象こま探索
		for(int i = 0; i < 9; i++) {
			
			for(int j = 0; j < 8; j++) {
				
				if(masu[i][j] == t) {
					//設置可能探索
					//左上探索
					for(int k = i - 1, l = j - 1; k >= 2 && l >= 1; k--, l--) {
						
						
							if(masu[k][l] != s ) {
								
								break;
								
							}
							
							if(masu[k-1][l-1] == space) {
								
								pattern[patternct] = k -1;
								patternct++;
								pattern[patternct] = l -1;
								patternct++;
								
							}
						
					}
					//左下探索
					for(int k = i + 1, l = j - 1; k <= 7 && l >= 1; k++, l--) {
						
						
						if(masu[k][l] != s ) {
							
							break;
							
						}
						
						if(masu[k+1][l-1] == space) {
							
							pattern[patternct] = k + 1;
							patternct++;
							pattern[patternct] = l - 1;
							patternct++;
							
						}
					}
					//右上探索
					for(int k = i - 1, l = j + 1; k >= 2 && l <= 6; k--, l++) {
						
						
						if(masu[k][l] != s ) {
							
							break;
							
						}
						
						if(masu[k-1][l+1] == space) {
							
							pattern[patternct] = k - 1;
							patternct++;
							pattern[patternct] = l + 1;
							patternct++;
							
						}
					
					}
					//右下探索
					for(int k = i + 1, l = j + 1; k <= 7 && l <= 6; k++, l++) {
						
						
						if(masu[k][l] != s ) {
							
							break;
							
						}
						
						if(masu[k+1][l+1] == space) {
							
							pattern[patternct] = k + 1;
							patternct++;
							pattern[patternct] = l + 1;
							patternct++;
							
						}
					}
					//右探索
					for(int  l = j + 1; l <= 6; l++) {
						
						
						if(masu[i][l] != s ) {
							
							break;
							
						}
					
						if(masu[i][l+1] == space) {
							
							pattern[patternct] = i;
							patternct++;
							pattern[patternct] = l + 1;
							patternct++;
							
						}
					}
					//左探索
					for(int  l = j - 1; l >= 1; l--) {
						
						
						if(masu[i][l] != s ) {
							
							break;
							
						}
						
						if(masu[i][l-1] == space) {
							
							pattern[patternct] = i;
							patternct++;
							pattern[patternct] = l - 1;
							patternct++;
							
						}
					}
					//上探索
					for(int  k = i - 1; k >= 2; k--) {
						
						
						if(masu[k][j] != s ) {
							
							break;
							
						}
						
						if(masu[k-1][j] == space) {
							
							pattern[patternct] = k - 1;
							patternct++;
							pattern[patternct] = j;
							patternct++;
							
						}
					}
					//下探索
					for(int  k = i + 1; k <= 7; k++) {
						
						
						if(masu[k][j] != s ) {
							
							break;
							
						}
						
						if( masu[k+1][j] == space) {
							
							pattern[patternct] = k + 1;
							patternct++;
							pattern[patternct] = j;
							patternct++;
							
						}
					}
					
				}	
				
				
			}
		}
		
		
		
		//手がなければfalseを返す
		if(patternct == 1) {
			
			return false;
			
		}else {
			
			//手決定
			
			int ra = r.nextInt(1,patternct); //☆
			int cyposition;
			
			if(ra % 2 == 0) {
			
				cxp = pattern[ra -1];
				cyposition = pattern[ra];
			
			}else {
			
				cxp = pattern[ra];
				cyposition = pattern[ra + 1];
			
			}
		
			cyp = jConvert(cyposition);
		
			//駒設置
			if(gameManager.num == 0) {
			
				masu[cxp][cyposition] = white;
	
			}else {
	
				masu[cxp][cyposition] = black;
			}
		
			reverse(masu, cxp, cyposition, 1);
			
		
			
			return true;
		}
	}
	
	
	public char jConvert(int j) {
		
		char num = 'n';
		
		switch(j) {
			case 0:
				num = 'Ａ';
				break;
			case 1: 
				num = 'Ｂ';
				break;
			case 2: 
				num = 'Ｃ';
				break;
			case 3:
				num = 'Ｄ';
				break;
			case 4:
				num = 'Ｅ';
				break;
			case 5:
				num = 'Ｆ';
				break;
			case 6:
				num = 'Ｇ';
				break;
			case 7:
				num = 'Ｈ';
				break;
		}
		
		return num;
			
	}
	
	public int jConvert(char j) {
		
		int num = 9;
		
		switch(j) {
			case 'a':
				num = 0;
				break;
			case 'b': 
				num = 1;
				break;
			case 'c': 
				num = 2;
				break;
			case 'd':
				num = 3;
				break;
			case 'e':
				num = 4;
				break;
			case 'f':
				num = 5;
				break;
			case 'g':
				num = 6;
				break;
			case 'h':
				num = 7;
				break;
		}
		
		return num;
			
	}
	
	
	public int judgment(char masu[][]) {
		
		int ans, black = 0, white = 0;
		
		
		for(int i = 1; i < 9; i++) {
			
			for(int j = 0; j < 8; j++) {
				
				if(masu[i][j] == this.black) {
					
					black++;
					
				}else if(masu[i][j] == this.white){
					
					white++;
					
				}
				
			}
		}
		
		System.out.printf("黒は%d,白は%d個です。", black, white);
		
		if(black > white) {
			
			ans = 0;
					
		}else if(black < white) {
			
			ans = 1;
			
		}else {
			
			ans = 2;
			
		}
		
		return ans;
	}
	
	
	
	public boolean playerbot(char masu[][]) {//検証用
		
		char t, s;
		int[] pattern = new int[61];
		int patternct = 1,  xp, yp;
		
		
		if(gameManager.num == 0) {
			 t = '○';
			 s = '●';	
		}else {
			t = '●';
			s = '○';
		}
		
		//対象こま探索
		for(int i = 0; i < 9; i++) {
			
			for(int j = 0; j < 8; j++) {
				
				if(masu[i][j] == t) {
					//設置可能探索
					//左上探索
					for(int k = i - 1, l = j - 1; k >= 2 && l >= 1; k--, l--) {
						
						
							if(masu[k][l] != s ) {
								
								break;
								
							}
							
							if(masu[k-1][l-1] == space) {
								
								pattern[patternct] = k -1;
								patternct++;
								pattern[patternct] = l -1;
								patternct++;
								
							}
						
					}
					//左下探索
					for(int k = i + 1, l = j - 1; k <= 7 && l >= 1; k++, l--) {
						
						
						if(masu[k][l] != s ) {
							
							break;
							
						}
						
						if(masu[k+1][l-1] == space) {
							
							pattern[patternct] = k + 1;
							patternct++;
							pattern[patternct] = l - 1;
							patternct++;
							
						}
					}
					//右上探索
					for(int k = i - 1, l = j + 1; k >= 2 && l <= 6; k--, l++) {
						
						
						if(masu[k][l] != s ) {
							
							break;
							
						}
						
						if(masu[k-1][l+1] == space) {
							
							pattern[patternct] = k - 1;
							patternct++;
							pattern[patternct] = l + 1;
							patternct++;
							
						}
					
					}
					//右下探索
					for(int k = i + 1, l = j + 1; k <= 7 && l <= 6; k++, l++) {
						
						
						if(masu[k][l] != s ) {
							
							break;
							
						}
						
						if(masu[k+1][l+1] == space) {
							
							pattern[patternct] = k + 1;
							patternct++;
							pattern[patternct] = l + 1;
							patternct++;
							
						}
					}
					//右探索
					for(int  l = j + 1; l <= 6; l++) {
						
						
						if(masu[i][l] != s ) {
							
							break;
							
						}
					
						if(masu[i][l+1] == space) {
							
							pattern[patternct] = i;
							patternct++;
							pattern[patternct] = l + 1;
							patternct++;
							
						}
					}
					//左探索
					for(int  l = j - 1; l >= 1; l--) {
						
						
						if(masu[i][l] != s ) {
							
							break;
							
						}
						
						if(masu[i][l-1] == space) {
							
							pattern[patternct] = i;
							patternct++;
							pattern[patternct] = l - 1;
							patternct++;
							
						}
					}
					//上探索
					for(int  k = i - 1; k >= 2; k--) {
						
						
						if(masu[k][j] != s ) {
							
							break;
							
						}
						
						if(masu[k-1][j] == space) {
							
							pattern[patternct] = k - 1;
							patternct++;
							pattern[patternct] = j;
							patternct++;
							
						}
					}
					//下探索
					for(int  k = i + 1; k <= 7; k++) {
						
						
						if(masu[k][j] != s ) {
							
							break;
							
						}
						
						if(masu[k+1][j] == space) {
							
							pattern[patternct] = k + 1;
							patternct++;
							pattern[patternct] = j;
							patternct++;
							
						}
					}
					
				}	
				
				
			}
		}
		

		//手がなければfalseを返す
		if(patternct == 1) {
			
			return false;
			
		}else {
			
			//手決定
			
			//修正予定
			int ra = r.nextInt(1,patternct); //☆
			int cyposition;
			
			if(ra % 2 == 0) {
			
				cxp = pattern[ra -1];
				cyposition = pattern[ra];
			
			}else {
			
				cxp = pattern[ra];
				cyposition = pattern[ra + 1];
			
			}
		
			cyp = jConvert(cyposition);
		
			//駒設置
			if(gameManager.num == 0) {
			
				masu[cxp][cyposition] = black;
	
			}else {
	
				masu[cxp][cyposition] = white;
			}
		
			reverse(masu, cxp, cyposition, 0);
			
			
			
			return true;
			
		
		}
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
