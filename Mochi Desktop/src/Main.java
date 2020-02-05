import javafx.application.Application;
import mochi.db.DBConnection;
import mochi.ui.MainUI;

public class Main {
	public static void main(String[] args) {
		DBConnection database = new DBConnection();
		MainUI.launch(args);
		//Application.launch(MainUI.class, args);
	}
}
