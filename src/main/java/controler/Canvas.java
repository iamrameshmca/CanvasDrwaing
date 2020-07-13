package controler;

/**
 * The is interface for a Canvas Draw. This interface exposes following methods
 * to draw
 */

public interface Canvas {

	public String render();

	public void drawLine(int x1, int y1, int x2, int y2, char mChar);

	public void drawRectangle(int x1, int y1, int x2, int y2, char mchar);

	public void bucketFill(int x, int y, char mchar);

}