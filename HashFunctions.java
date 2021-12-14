package beaty;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;
import java.io.Reader;

import java.util.Hashtable;

import javax.swing.JFileChooser;
import javax.swing.JFrame;

public class HashFunctions {

	public static void main(String[] args) throws IOException {
		// Chooser Method for specific Java files
		JFileChooser chooser = new JFileChooser();
		chooser.setFileFilter(new javax.swing.filechooser.FileFilter() {
			public boolean accept(File f) {
				return f.getName().toLowerCase().endsWith(".java") || f.isDirectory();
			}

			public String getDescription() {
				return "Java Files";
			}
		});
		
		int r = chooser.showOpenDialog(new JFrame());
		
		if (r == JFileChooser.APPROVE_OPTION) {
			final long startTime = System.currentTimeMillis();
			Reader l = new FileReader(chooser.getSelectedFile());
			BufferedReader br = new BufferedReader(l);
			PrintStream o = new PrintStream(new File("output.txt"));
			Hashtable<Integer, String> hash = new Hashtable<Integer, String>();
			String line;
			int i = 0;
			int count = 0;

			LineCounter lC = new LineCounter();
			String name = chooser.getSelectedFile().getName();
			o.println("Number of lines (without comments) of " + name + " is " + lC.getNumberOfLines(br));

			Reader read = new FileReader(chooser.getSelectedFile());
			BufferedReader bR = new BufferedReader(read);

			while ((line = bR.readLine()) != null) {
				if (line.contains("int") || line.contains("double") || line.contains("static")
						|| line.contains("public") || line.contains("String")) {
					count++;
					hash.put(i, line);
					i++;
				}
			}
			for (int j = 0; j < hash.size(); j++) {
				o.println((j + 1) + ". : " + hash.get(j));
			}
			o.println("Number of key words: " + count);
			final long endTime = System.currentTimeMillis();
			o.println("Total execution time in milliseconds: " + (endTime - startTime) + " ms");
			key.close();
		}

	}
}