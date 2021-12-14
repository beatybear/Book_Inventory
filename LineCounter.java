package beaty;

import java.io.BufferedReader;
import java.io.IOException;

public class LineCounter {
	public int getNumberOfLines(BufferedReader bReader) throws IOException {
		int count = 0;
		boolean isComment = false;
		String line = null;
		while ((line = bReader.readLine()) != null) {
			line = line.trim();
			if ("".equals(line) || line.startsWith("//")) {
				continue;
			}
			if (isComment) {
				if (EndOfComment(line)) {
					line = line.substring(line.indexOf("*/") + 2).trim();
					isComment = false;
					if ("".equals(line) || line.startsWith("//")) {
						continue;
					}
				} else
					continue;
			}
			if (isLine(line)) {
				count++;
			}
			if (isThisAComment(line)) {
				isComment = true;
			}
		}
		return count;
	}

	private boolean isThisAComment(String line) {
		int index = line.indexOf("/*");
		if (index < 0) {
			return false;
		}
		int quoteStartIndex = line.indexOf("\"");
		if (quoteStartIndex != -1 && quoteStartIndex < index) {
			while (quoteStartIndex > -1) {
				line = line.substring(quoteStartIndex + 1);
				int quoteEndIndex = line.indexOf("\"");
				line = line.substring(quoteEndIndex + 1);
				quoteStartIndex = line.indexOf("\"");
			}
			return isThisAComment(line);
		}
		return !EndOfComment(line.substring(index + 2));
	}

	private boolean EndOfComment(String line) {
		int index = line.indexOf("*/");
		if (index < 0) {
			return false;
		} else {
			String small = line.substring(index + 2).trim();
			if ("".equals(small) || small.startsWith("//")) {
				return true;
			}
			if (isThisAComment(small)) {
				return false;
			} else {
				return true;
			}
		}
	}

	private boolean isLine(String line) {
		boolean isLine = false;
		line = line.trim();
		if ("".equals(line) || line.startsWith("//")) {
			return isLine;
		}
		if (line.length() == 1) {
			return true;
		}
		int index = line.indexOf("/*");
		if (index != 0) {
			return true;
		} else {
			while (line.length() > 0) {
				line = line.substring(index + 2);
				int endCommentPosition = line.indexOf("*/");
				if (endCommentPosition < 0) {
					return false;
				}
				if (endCommentPosition == line.length() - 2) {
					return false;
				} else {
					String subString = line.substring(endCommentPosition + 2).trim();
					if ("".equals(subString) || subString.indexOf("//") == 0) {
						return false;
					} else {
						if (subString.startsWith("/*")) {
							line = subString;
							continue;
						}
						return true;
					}
				}

			}
		}
		return isLine;
	}
}