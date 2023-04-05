
import javax.swing.JOptionPane;
public class Main {//Q1-The Main runs the guessing game
	public static void main(String[] args) {
		Game g = new Game();
		System.out.println(g.getNum());
		int win = 0;
		String guessesList = "";
		String guess ;
		int status;
		int hit ;//the number of digits that appear in the original number but in different location
		int bool;
		int replay = 1;
		while(replay == 1) {
			while(win == 0) {
				guess = JOptionPane.showInputDialog("Please enter your guess: ");
				status = g.play(guess);
				if(status != -1) {
					hit = (status)%10;
					bool = (status-hit)/10;
					guessesList += (guess + " " + bool + " bool" + " and  "+ hit + " hits"+ "\n");
					JOptionPane.showMessageDialog(null, guessesList );
					if(bool == 4) {
						win = 1;
						JOptionPane.showMessageDialog(null, "congratulations !! You succeeded after " + g.getGuesses()+ " guesses :) ");
						
					}// end if2
				}// end if1
			}// end while2
			guess = JOptionPane.showInputDialog("If you want to play again then enter Y");
			if(guess.contains("Y")) {
				g = new Game();											
				guessesList = "";
				win = 0;
			}
			else {
				JOptionPane.showMessageDialog(null, "Thanks for playing , Hope you enjoyed :]");
				replay = 0;
			}
		}// end while1
		
	}
	
}
