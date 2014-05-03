package race.cheng.graphics;

import javax.microedition.khronos.opengles.GL10;

/**
 * 基本图形类
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
	 * 绘制3D图片
	 * 
	 * @param gl
	 * @param drawId
	 * @param number
	 */
	public abstract void drawSelf(GL10 gl, int texId, int number);
}
