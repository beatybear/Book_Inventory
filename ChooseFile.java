package beaty;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import javax.swing.JFileChooser;

public class ChooseFile {
	JFileChooser fC = new JFileChooser();
	StringBuilder sB = new StringBuilder();

	public void pick_me() throws FileNotFoundException {
		if (fC.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
			File file = fC.getSelectedFile();
			Scanner scan = new Scanner(file);
			while (scan.hasNext()) {
				sB.append(scan.nextLine());
				sB.append("\n");
			}
			scan.close();
		} else {
			sB.append("No file was selected");
}}}