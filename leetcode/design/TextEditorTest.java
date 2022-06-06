package leetcode.design;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class TextEditorTest {

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
