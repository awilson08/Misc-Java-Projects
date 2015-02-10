import java.awt.EventQueue;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JTabbedPane;
import javax.swing.JButton;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextPane;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.awt.SystemColor;
import java.io.IOException;


public class Hangman implements ActionListener  {
	
	private static MyHangmanGame game;
	private JFrame frmLetsPlayHangman;
	private JTextField nextLetter;
	private JLabel lblLettersGuessed;
	private JLabel lblSecretWord;
	private JLabel lblNumGuessRemain;
	JLabel lblhangman0;

	/**
	 * Launch the application.
	 * @throws Exception 
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Hangman window = new Hangman();
					window.frmLetsPlayHangman.setVisible(true);
					
				} 
				catch (Exception e) {
					System.out.println("Threw an exception");
				}
			}
		});
        
		
		
		
		
	} //end main


	private static void playGame() throws Exception {
		game  = new MyHangmanGame();
		
	}


	/**
	 * Create the application.
	 * @throws Exception 
	 */
	public Hangman() throws Exception {
		playGame();
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 * @throws IOException 
	 */
	private void initialize() throws IOException {
		frmLetsPlayHangman = new JFrame();
		frmLetsPlayHangman.getContentPane().setBackground(SystemColor.activeCaption);
		frmLetsPlayHangman.setTitle("Let's Play Hangman");
		frmLetsPlayHangman.getContentPane().setLayout(new GridLayout(0, 2, 0, 0));
		
		JPanel LeftPanel = new JPanel();
		frmLetsPlayHangman.getContentPane().add(LeftPanel);
		LeftPanel.setLayout(new GridLayout(4, 0, 0, 0));
		
		JPanel NorthLeft = new JPanel();
		LeftPanel.add(NorthLeft);
		NorthLeft.setLayout(new GridLayout(1, 3, 0, 0));
		
		lblSecretWord = new JLabel("Secret Word: " + game.displayGameState());
		lblSecretWord.setVerticalAlignment(SwingConstants.BOTTOM);
		NorthLeft.add(lblSecretWord);
		lblSecretWord.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		lblLettersGuessed = new JLabel("Letters Guessed: " + game.lettersGuessed());
		lblLettersGuessed.setFont(new Font("Tahoma", Font.PLAIN, 15));
		LeftPanel.add(lblLettersGuessed);
		
		lblNumGuessRemain = new JLabel("Guesses Remaining: " + game.numGuessesRemaining());
		lblNumGuessRemain.setVerticalAlignment(SwingConstants.TOP);
		LeftPanel.add(lblNumGuessRemain);
		lblNumGuessRemain.setHorizontalAlignment(SwingConstants.LEFT);
		lblNumGuessRemain.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		JPanel BottomLeft = new JPanel();
		LeftPanel.add(BottomLeft);
		
		nextLetter = new JTextField();
		BottomLeft.add(nextLetter);
		nextLetter.setHorizontalAlignment(SwingConstants.CENTER);
		nextLetter.setFont(new Font("Tahoma", Font.PLAIN, 15));
		nextLetter.setColumns(1);
		
		JButton btnGuessButton = new JButton("Guess");
		btnGuessButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		BottomLeft.add(btnGuessButton);
		
		lblhangman0 = new JLabel("Hangman");
		lblhangman0.setIcon(new ImageIcon(this.getClass().getResource("Hangman-0.png")));
		frmLetsPlayHangman.getContentPane().add(lblhangman0);
		btnGuessButton.addActionListener(this);

	

}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if (!game.gameOver()){
            String guess = nextLetter.getText().toUpperCase();
            
            
            if (game.makeGuess(guess.charAt(0))){
            	JOptionPane.showMessageDialog(null, "Yes!");
            }
            else{
            	JOptionPane.showMessageDialog(null, "Nope!");
            
            }
            
          //repaint whole screen
            nextLetter.setText(""); //clear JTextField
            lblSecretWord.setText("Secret Word: " + game.displayGameState());
            lblLettersGuessed.setText("Letters Guessed: " + game.lettersGuessed());
            lblNumGuessRemain.setText("Guesses Remaining: " + game.numGuessesRemaining());
            lblhangman0.setIcon(new ImageIcon(this.getClass().getResource("Hangman-" + (6-game.numGuessesRemaining()) + ".png")));
            
            
            if(game.isWin()){
            	JOptionPane.showMessageDialog(null, "CONGRATS YOU WIN!");
                
              }
              else if (game.gameOver()){
            	  JOptionPane.showMessageDialog(null, "Sorry, you lose. The word was: "+game.getSecretWord());
                
              }
            
            
		}
		
	}
}
