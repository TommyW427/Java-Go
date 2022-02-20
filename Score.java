

import java.util.ArrayList;
import java.util.Arrays;

public class Score {
	float blackScore;
	float whiteScore;
	int [][] pos;
	int groupNum;
	ArrayList<Integer> boundaries = new ArrayList<Integer>();
	int groupSize=0;
	
	public Score(int bCaptures,int wCaptures, int [][] position) {
		blackScore=bCaptures;
		whiteScore=wCaptures;
		pos=position;
		groupNum=3;
		for (int i = 0; i<pos.length; i++) {
			System.out.println(Arrays.toString(pos[i]));
		}
		//0=no piece, 1 = black piece, 2 = white piece, 
		//3 = already checked no piece
		
		for (int i = 0; i<pos.length; i++) {
			for (int a =0; a<pos[i].length;a++) {
				if (pos[i][a]==0) {
					seed(i,a,0);
					groupNum++;
					if (boundaries.contains(1)) {
						if (!(boundaries.contains(2))) {
							blackScore+=groupSize;

						}
					
					}
					else if (boundaries.contains(2)){
						whiteScore+=groupSize;
					}
					
					boundaries.clear();
					groupSize=0;
					
				}
				else if (pos[i][a]==1) {
					blackScore++;
				}
				else if (pos[i][a]==2) {
					whiteScore++;
				}
				
				
			}
		}
		for (int i = 0; i<pos.length; i++) {
			System.out.println(Arrays.toString(pos[i]));
		}
		whiteScore+=5.5;
		System.out.println("Black Score is " + blackScore);
		System.out.println("White Score is " + whiteScore);
		
	}
	public void seed(int y, int x, int tar) {
		int group=groupNum;
		int self;
		try {
		self = pos[y][x];
		}
		catch (Exception ArrayIndexOutOfBoundsException) {
			return;
		}
		
		if (!(self==tar)) {
			if (!(self==group)) {
				boundaries.add(self);
			}
			return;
		}
		else {
			groupSize++;
			self = group;
			pos[y][x] = group;
			if (group==5 || group==6) {
				for (int c = 0; c<pos.length; c++) {
					System.out.println(Arrays.toString(pos[c]));
				}
				System.out.println("\n");
			}
			seed(y+1,x,tar); //North
			seed(y-1,x,tar); //South
			seed(y,x+1,tar); //East
			seed(y,x-1,tar); //West
		}
		
		
		
	}
	public float getBlackScore() {
		return(blackScore);
	}
	public float getWhiteScore() {
		return(whiteScore);
	}
	

}
