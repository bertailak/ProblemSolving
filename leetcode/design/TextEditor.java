package leetcode.design;

public class TextEditor {

    // https://leetcode.com/problems/design-a-text-editor/

    private StringBuilder sb;
    private int cursor;

    public TextEditor() {
        sb = new StringBuilder();
        cursor = 0;
    }

    public void addText(String text) {
        sb.insert(cursor, text);
        cursor += text.length();
    }

    public int deleteText(int k) {
        int start = Math.max(0, cursor - k);
        int end = cursor;
        sb.delete(start, end);
        int count = end - start;
        cursor = Math.max(0, cursor - count);
        return count;
    }

    public String cursorLeft(int k) {
        cursor = Math.max(0, cursor - k);
        int index = Math.min(10, cursor);
        return sb.substring(cursor - index, cursor).toString();
    }

    public String cursorRight(int k) {
        cursor = Math.min(sb.length(), cursor + k);
        int index = Math.min(10, cursor);
        return sb.substring(cursor - index, cursor).toString();
    }

    public int getCursor() {
        return cursor;
    }

    public String toString() {
        return sb.toString().trim();
    }
}
