package controler;

import exception.CanvasException;

/**
 * This is DrawCanvas Controller (Interface Implementation) for Canvas Interface
 * 
 */

public class DrawCanvasImpl implements Canvas {
	char[][] canvasArray;
	int w, h;

	public DrawCanvasImpl() {
	}

	public DrawCanvasImpl(int w, int h) {
		if (w < 1 || h < 1) {
			throw new CanvasException("Canvas width and height can't be 0");
		}
		h += 2;
		w += 2;
		this.w = w;
		this.h = h;
		this.canvasArray = new char[h][w];
		drawLine(0, 0, this.w - 1, 0, '-');
		drawLine(0, this.h - 1, this.w - 1, this.h - 1, '-');
		drawLine(0, 1, 0, this.h - 2, '|');
		drawLine(this.w - 1, 1, this.w - 1, this.h - 2, '|');
	}

	/**
	 * This is render() method, which is used to display the c
	 * 
	 */
	@Override
	public String render() {
		checkCanvas();
		StringBuilder strBuilder = new StringBuilder();
		for (int i = 0; i < this.h; i++) {
			for (int j = 0; j < this.w; j++) {
				strBuilder.append(this.canvasArray[i][j] == '\u0000' ? ' ' : this.canvasArray[i][j]);
			}
			strBuilder.append("\n");
		}
		return strBuilder.toString().trim();
	}

	/**
	 * This is drawLine() method, which is used to draw the line
	 * 
	 */
	@Override
	public void drawLine(int x1, int y1, int x2, int y2, char mChar) {
		checkCanvas();
		for (int i = y1; i <= y2; i++) {
			for (int j = x1; j <= x2; j++) {
				this.canvasArray[i][j] = mChar;
			}
		}
	}

	/**
	 * This is drawRectangle() method, which is used to drawRectangle the line
	 * 
	 */
	@Override
	public void drawRectangle(int x1, int y1, int x2, int y2, char mchar) {
		checkCanvas();
		drawLine(x1, y1, x2, y1, mchar);
		drawLine(x1, y1, x1, y2, mchar);
		drawLine(x2, y1, x2, y2, mchar);
		drawLine(x1, y2, x2, y2, mchar);
	}

	/**
	 * This is bucketFill() method, which is used to bucketFill the line
	 * 
	 */

	@Override
	public void bucketFill(int x, int y, char mchar) {
		checkCanvas();
		if ((int) this.canvasArray[y][x] != 0) {
			return;
		}
		if (x > 0 || x < this.h || y > 0 || y < this.w) {
			if ((int) this.canvasArray[y][x] == 0)
				this.canvasArray[y][x] = mchar;
			bucketFill(x + 1, y, mchar);
			bucketFill(x - 1, y, mchar);
			bucketFill(x, y - 1, mchar);
			bucketFill(x, y + 1, mchar);
		}
	}

	/**
	 * This is checkCanvas() method, which is used to check whether Canvas Instantiated or Not
	 * 
	 */

	private void checkCanvas() {
		if (this.canvasArray == null)
			throw new CanvasException("Draw a canvas first");
	}
}