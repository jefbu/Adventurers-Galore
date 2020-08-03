package gameEngine.ecclesiastes.gfx;

import java.io.Serializable;

public class ImageTile extends Image implements Serializable {

	private static final long serialVersionUID = 1L;
	private int tileWidth, tileHeight;
	
	public ImageTile(String path, int tileWidth, int tileHeight) {
		
		super(path);
		this.tileWidth = tileWidth;
		this.tileHeight = tileHeight;
		
	}

	public int getTileWidth() {
		return tileWidth;
	}

	public void setTileWidth(int tileWidth) {
		this.tileWidth = tileWidth;
	}

	public int getTileHeight() {
		return tileHeight;
	}

	public void setTileHeight(int tileHeight) {
		this.tileHeight = tileHeight;
	}

}
