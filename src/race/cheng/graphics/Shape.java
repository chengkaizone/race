package race.cheng.graphics;

import javax.microedition.khronos.opengles.GL10;

/**
 * ����ͼ����
 * 
 * @author chengkai
 * 
 */
public abstract class Shape {
	float scale;

	public Shape(float scale) {
		this.scale = scale;
	}

	/**
	 * ����3DͼƬ
	 * 
	 * @param gl
	 * @param drawId
	 * @param number
	 */
	public abstract void drawSelf(GL10 gl, int texId, int number);
}
