

public class Game {

	gameManager gm = new gameManager();
	
	void Game() {
		
	}
	
	
	public void gameProgression() {
		
		int turn = 1;
		boolean con;
		
		gm.gamemake();
		
		do{
			
			while(true) {
				
				boolean pPath, cPath;
				System.out.println("【" + turn + "ターン目】\n");
				
				
				if(gameManager.num == 0) {
					
					//pPath = gm.playerbot();
					//gm.mapPrint();
					pPath = gm.playerTurn();
					cPath = gm.cpuTurn();
					
				}else {
					
					pPath = gm.cpuTurn();
					cPath = gm.playerTurn();
					//pPath = gm.playerbot();
					//gm.mapPrint();
				}
				
				
				if(pPath && cPath) {
					
					break;
				}
				
				
				turn++;
				
			}
			
			con = gm.result();
			
		}while(con);
		
		System.out.println("ゲームを終了します");
		
	}
}
