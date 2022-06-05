package leetcode.design;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

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

    @Test
    public void test1() {
        TextEditor te = new TextEditor();
        te.addText("leetcode");
        assertEquals(8, te.getCursor());
        assertEquals("leetcode", te.toString());

        assertEquals(4, te.deleteText(4));
        assertEquals(4, te.getCursor());
        assertEquals("leet", te.toString());

        te.addText("practice");
        assertEquals(12, te.getCursor());
        assertEquals("leetpractice", te.toString());

        assertEquals("etpractice", te.cursorRight(3));
        assertEquals(12, te.getCursor());
        assertEquals("leetpractice", te.toString());

        assertEquals("leet", te.cursorLeft(8));
        assertEquals(4, te.getCursor());
        assertEquals("leetpractice", te.toString());

        assertEquals(4, te.deleteText(10));
        assertEquals(0, te.getCursor());
        assertEquals("practice", te.toString());

        assertEquals("", te.cursorLeft(2));
        assertEquals(0, te.getCursor());
        assertEquals("practice", te.toString());

        assertEquals("practi", te.cursorRight(6));
        assertEquals(6, te.getCursor());
        assertEquals("practice", te.toString());
    }
}
