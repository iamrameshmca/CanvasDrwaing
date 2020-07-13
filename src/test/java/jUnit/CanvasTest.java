package jUnit;

import exception.CanvasException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import controler.DrawCanvasImpl;

import static org.junit.jupiter.api.Assertions.*;

class CanvasTest {

    @Test
    void testConstructor() {
        DrawCanvasImpl canvas  = new DrawCanvasImpl(20, 4);
        assertEquals(canvas.render(),
        "----------------------\n" +
        "|                    |\n" +
        "|                    |\n" +
        "|                    |\n" +
        "|                    |\n" +
        "----------------------");
    }

    @Test
    void testConstructorException() {
        Executable closureContainingCodeToTest = () -> new DrawCanvasImpl(0, 4);
        assertThrows(CanvasException.class, closureContainingCodeToTest);
    }

    @Test
    void testDrawLineException() {
        Executable closureContainingCodeToTest = () -> new DrawCanvasImpl().drawLine(1,2,3,4,'x');
        assertThrows(CanvasException.class, closureContainingCodeToTest);
    }

    @Test
    void testDrawLine() {
        DrawCanvasImpl canvas = new DrawCanvasImpl(3,5);
        canvas.drawLine(1, 2, 1, 4, 'x');
        assertEquals(canvas.render(),
        "-----\n" +
            "|   |\n" +
            "|x  |\n" +
            "|x  |\n" +
            "|x  |\n" +
            "|   |\n" +
            "-----");
    }

    @Test
    void testDrawRectangle() {
        DrawCanvasImpl canvas = new DrawCanvasImpl(8,4);
        canvas.drawRectangle(2, 1, 6, 3, 'x');
        assertEquals(canvas.render(),
            "----------\n" +
            "| xxxxx  |\n" +
            "| x   x  |\n" +
            "| xxxxx  |\n" +
            "|        |\n" +
            "----------");
    }

    @Test
    void testBucketFill() {
        DrawCanvasImpl canvas = new DrawCanvasImpl(8,4);
        canvas.drawRectangle(2, 1, 6, 3, 'x');
        canvas.bucketFill(3,2, 'o');
        assertEquals(canvas.render(),
    "----------\n" +
            "| xxxxx  |\n" +
            "| xooox  |\n" +
            "| xxxxx  |\n" +
            "|        |\n" +
            "----------");
    }
}