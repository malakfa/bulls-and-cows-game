import javax.swing.JOptionPane;

public class Game {/*the class Game construct game objects , each object represent a logic game*/
	protected String num = "";// number to guess
	protected int guessTimes;
	protected final int NUM_LENGTH = 4;
	
	public Game() {
		this.guessTimes = 0;
		this.num = createNum(); // creates a 4 different digits number
		
    }
	
		public String getNum() {// get number											
			return num;
			}

	
		public int getGuesses() {//get guessTimes 											
			return guessTimes;
			}
		
	private String  createNum() {// create a 4 digit number
		String returnedNum = "";
		int i = 0;
		int rand;
		while(i < NUM_LENGTH) {
			rand = (int)(Math.random()*10);
			if (!(returnedNum.contains(""+rand)))	{
				returnedNum += rand;
				i++;
			}
		  }
			return returnedNum;
			
		}// end of create_num
	public int play(String guess) {//this function returns the number of boo and the number of hits
		guessTimes++;
		int bool = 0;
		int hits = 0;
		int valid_input = check_input(guess);
		if(valid_input == 1) {
			for(int i=0; i < NUM_LENGTH ;i++) {	
				for(int j = 0; j < NUM_LENGTH ;j++) {
						if(this.getNum().charAt(i) == guess.charAt(j)) {
							if(i == j) {
								bool++;}
							else {
								hits++;}
							}
					}
				}
				
			}// end if
		else {
			return -1;
		}

		return	(bool*10 + hits);
		
		
	}
	private int check_input(String inp) {//this function checks if the input is valid
		if(inp.length()!= NUM_LENGTH) {
			JOptionPane.showMessageDialog(null,"unvalid input ! the input must be 4 digits" );
			return 0;
		}
		if(!(inp.matches("[0-9]+"))) {
			JOptionPane.showMessageDialog(null,"unvalid input ! the input must contain only digits" );
			return 0;
		}
		
		for(int i=0; i < NUM_LENGTH ;i++) {	
			for(int j = i+1; j < NUM_LENGTH ;j++) {
				if(inp.charAt(i) == inp.charAt(j)) {
					JOptionPane.showMessageDialog(null,"unvalid input ! the input must contain different digits" );
					return 0;
					}
				}
			}
		return 1;
		
	}// end of check_input
		
	
}


