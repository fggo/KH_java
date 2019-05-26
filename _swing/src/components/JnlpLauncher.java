package components;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;

public class JnlpLauncher {
	public static void main(String[] args) throws IOException {
		File f = new File(System.getProperty("user.home"));
		String path = "KH\\KH_java\\_swing\\src\\";
		String filename = "SplitPaneDemo2.jnlp";

		f = new File(f, path+filename);
		Desktop.getDesktop().open(f);
	}
}
