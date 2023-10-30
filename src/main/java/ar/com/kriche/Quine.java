package ar.com.kriche;

/** A program that prints itself. */
public class Quine {

	public static void main(String[] args) {

		char doubleQuote = 34;

		String[] sourceLines = {
				"package ar.com.kriche;",
				"",
				"/** A program that prints itself. */",
				"public class Quine {",
				"",
				"	public static void main(String[] args) {",
				"",
				"		char doubleQuote = 34;",
				"",
				"		String[] sourceLines = {",
				",",
				"				",
				"		};",
				"",
				"		// print up to the String[] sourceLines = { line:",
				"		for (int i = 0; i < 10; i++) {",
				"			System.out.println(sourceLines[i]);",
				"		}",
				"",
				"		// print the content of sourceLines array:",
				"		for (int i = 0; i < sourceLines.length; i++) {",
				"			System.out.println(sourceLines[11] + doubleQuote + sourceLines[i] + doubleQuote + sourceLines[10]);",
				"		}",
				"",
				"		// close sourceLines array and print the for statements:",
				"		for (int i = 12; i < sourceLines.length; i++) {",
				"			System.out.println(sourceLines[i]);",
				"		}",
				"",
				"	}",
				"",
				"}",
		};

		// print up to the String[] sourceLines = { line:
		for (int i = 0; i < 10; i++) {
			System.out.println(sourceLines[i]);
		}

		// print the content of sourceLines array:
		for (int i = 0; i < sourceLines.length; i++) {
			System.out.println(sourceLines[11] + doubleQuote + sourceLines[i] + doubleQuote + sourceLines[10]);
		}

		// close sourceLines array and print the for statements:
		for (int i = 12; i < sourceLines.length; i++) {
			System.out.println(sourceLines[i]);
		}

	}

}
