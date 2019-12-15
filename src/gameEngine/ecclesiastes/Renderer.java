package gameEngine.ecclesiastes;

import java.awt.image.DataBufferInt;

import gameEngine.ecclesiastes.gfx.Font;
import gameEngine.ecclesiastes.gfx.Image;
import gameEngine.ecclesiastes.gfx.ImageTile;

public class Renderer {

	private int pixelWidth, pixelHeight;
	private int[] pixels;
	private int[] zBuffer;
	private int zDepth = 0;

	private Font font = Font.STANDARD;

	public Renderer(GameContainer gameContainer) {

		pixelWidth = gameContainer.getWidth();
		pixelHeight = gameContainer.getHeight();

		pixels = ((DataBufferInt) gameContainer.getWindow().getImage().getRaster().getDataBuffer()).getData();
		zBuffer = new int[pixels.length];

	}

	public void clear() {
		for (int i = 0; i < pixels.length; i++) {
			pixels[i] = 0;
			zBuffer[i] = 0;
		}
	}

	public void setPixel(int x, int y, int value) {

		int alpha = ((value >> 24) & 0xff);
		
		if ((x < 0) || (x >= pixelWidth) || (y < 0) || (y >= pixelHeight) || alpha == 0) {
			return;
		}
		if (zBuffer[x + y * pixelWidth] > zDepth) {
			return;
		}
		
		if (alpha == 255) {
		pixels[x + y * pixelWidth] = value;
		} else {
			
			int pixelColor = pixels[x + y * pixelWidth];
			int newRed = ((pixelColor >> 16) & 0xff) - (int) ((((pixelColor >> 16) & 0xff) - ((value >> 16) & 0xff)) * (alpha / 255f));
			int newGreen = ((pixelColor >> 8) & 0xff) - (int) ((((pixelColor >> 8) & 0xff) - ((value >> 8) & 0xff)) * (alpha / 255f));
			int newBlue = (pixelColor & 0xff) - (int) (((pixelColor & 0xff) - (value & 0xff)) * (alpha / 255f));
			
			pixels[x + y * pixelWidth] = (255 << 24 | newRed << 16 | newGreen << 8 | newBlue);
		}
		
	}

	public void drawImage(Image image, int offX, int offY) {

		int newX = 0;
		int newY = 0;
		int newWidth = image.getWidth();
		int newHeight = image.getHeight();

		if (offX < -image.getWidth()) { return; }
		if (offY < -image.getHeight()) { return; }
		if (offX >= pixelWidth) { return; }
		if (offY >= pixelHeight) { return; }
		if (offX < 0) { newX = newX - offX; }
		if (offY < 0) { newY = newY - offY; }
		
		if (newWidth + offX >= pixelWidth) { newWidth = newWidth - (newWidth + offX - pixelWidth); }
		if (newWidth + offY >= pixelHeight) { newHeight = newHeight - (newHeight + offY - pixelHeight); }

		for (int y = newY; y < newHeight; y++) {
			for (int x = newX; x < newWidth; x++) {
				setPixel(x + offX, y + offY, image.getPixels()[x + y * image.getWidth()]);
			}
		}

	}

	public void drawImageTile(ImageTile image, int offX, int offY, int tileX, int tileY) {

		if (offX < -image.getTileWidth()) { return; }
		if (offY < -image.getTileHeight()) { return; }
		if (offX >= pixelWidth) { return; }
		if (offY >= pixelHeight) { return; }

		int newX = 0;
		int newY = 0;
		int newWidth = image.getTileWidth();
		int newHeight = image.getTileHeight();

		if (offX < 0) { newX = newX - offX; }
		if (offY < 0) { newY = newY - offY; }
		if (newWidth + offX >= pixelWidth) { newWidth = newWidth - (newWidth + offX - pixelWidth); }
		if (newWidth + offY >= pixelHeight) { newHeight = newHeight - (newHeight + offY - pixelHeight); }

		for (int y = newY; y < newHeight; y++) {
			for (int x = newX; x < newWidth; x++) {
				setPixel(x + offX, y + offY, image.getPixels()[(x + tileX * image.getTileWidth())
						+ (y + tileY * image.getTileHeight()) * image.getWidth()]);
			}
		}

	}

	public void drawText(String text, int offX, int offY, int color) {

		int offset = 0;

		for (int i = 0; i < text.length(); i++) {

			int unicode = text.codePointAt(i) - 32;
			for (int y = 0; y < font.getFontImage().getHeight(); y++) {
				for (int x = 0; x < font.getWidths()[unicode]; x++) {

					if (font.getFontImage().getPixels()[(x + font.getOffsets()[unicode])
							+ y * font.getFontImage().getWidth()] == 0xffffffff) {
						setPixel(x + offX + offset, y + offY, color);
					}

				}
			}
			
			offset += font.getWidths()[unicode];

		}
	}
	
	public void drawRect(int offX, int offY, int width, int height, int color) {
		
		for (int y = 0; y <= height; y++) {
			setPixel(offX, y + offY, color);
			setPixel(offX + width, y + offY, color);
		}
		
		for (int x = 0; x <= width; x++) {
			setPixel(x + offX, offY, color);
			setPixel(x + offX, offY + height, color); 
		}		
	}
	
	public void drawRectOpaque(int offX, int offY, int width, int height, int color) {
		
		if (offX < -width) { return; }
		if (offY < -height) { return; }
		if (offX >= pixelWidth) { return; }
		if (offY >= pixelHeight) { return; }

		int newX = 0;
		int newY = 0;
		int newWidth = width;
		int newHeight = height ;

		if (offX < 0) { newX = newX - offX; }
		if (offY < 0) { newY = newY - offY; }
		if (newWidth + offX >= pixelWidth) { newWidth = newWidth - (newWidth + offX - pixelWidth); }
		if (newWidth + offY >= pixelHeight) { newHeight = newHeight - (newHeight + offY - pixelHeight); }	
		
		for (int y = 0; y <= height; y++) {
			for (int x = 0; x <= width; x++) {
				setPixel(x + offX, y + offY, color); 
			}
		}
	}

	public int getzDepth() {
		return zDepth;
	}

	public void setzDepth(int zDepth) {
		this.zDepth = zDepth;
	}

}
