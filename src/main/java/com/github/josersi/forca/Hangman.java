package main.java.com.github.josersi.forca;

class Hangman {
    private static String[] steps = new String[] {
            "           +---+\n" +
            "           |   |\n" +
            "           |\n" +
            "           |\n" +
            "           |\n" +
            "           |\n" +
            "           | %s\n"+
            "           =========",
            "           +---+\n" +
            "           |   |\n"+
            "           |   O\n"+
            "           |\n"+
            "           |\n"+
            "           |\n"+
            "           | %s\n"+
            "           =========",
            "           +---+\n"+
            "           |   |\n"+
            "           |   O\n"+
            "           |   |\n"+
            "           |\n"+
            "           |\n"+
            "           | %s\n"+
            "           =========",
            "           +---+\n"+
            "           |   |\n"+
            "               O\n"+
            "           |  /|\n"+
            "           |\n"+
            "           |\n"+
            "           | %s\n"+
            "           =========",
            "           +---+\n"+
            "           |   |\n"+
            "           |   O\n"+
            "           |  /|\\\n" +
            "           |\n"+
            "           |\n"+
            "           | %s\n"+
            "           =========",
            "           +---+\n"+
            "           |   |\n"+
            "           |   O\n"+
            "           |  /|\\\n"+
            "           |  /\n"+
            "           |\n"+
            "           | %s\n"+
            "           =========",
            "           +---+\n"+
            "           |   |\n"+
            "           |   O\n"+
            "           |  /|\\\n"+
            "           |  / \\\n"+
            "           |\n"+
            "           | %s\n"+
            "           ========="
    };

    static String get(int i, String placeholder) {
        return String.format(steps[i], placeholder);
    }
}
