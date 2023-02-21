import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Game.Game;


public class Window extends JFrame {

	private JPanel contentPane;
	private final Action loginAction = new LoginAction(this);
	
	public Window(WindowType type){
		if(type == WindowType.LOGIN){
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setBounds(100, 100, 600, 400);
			contentPane = new JPanel();
			contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
			contentPane.setLayout(new BorderLayout(0, 0));
			setContentPane(contentPane);
			
			JButton btnRootadmin = new JButton("Root:ADMIN");
			btnRootadmin.setAction(loginAction);
			contentPane.add(btnRootadmin, BorderLayout.CENTER);
		}else if(type == WindowType.GAME){
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setBounds(100, 100, 720, 550);
			contentPane = new JPanel();
			contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
			contentPane.setLayout(new BorderLayout(0, 0));
			setContentPane(contentPane);
		}
	}
	
	private class LoginAction extends AbstractAction {
		private Window win;
		public LoginAction(Window w) {
			win = w;
			putValue(NAME, "login");
			putValue(SHORT_DESCRIPTION, "Login as account");
		}
		public void actionPerformed(ActionEvent e) {
			win.dispose();
			Game g = new Game();
		}
	}

}
