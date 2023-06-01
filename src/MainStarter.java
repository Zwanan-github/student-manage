import java.sql.SQLException;

import javax.swing.UnsupportedLookAndFeelException;

import view.StudentPage;

/**
 * 
 * @author hu'hao
 *
 */
public class MainStarter {
	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException, UnsupportedLookAndFeelException {
		new StudentPage().setVisible(true);
	}
}
