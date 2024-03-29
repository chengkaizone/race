package race.cheng.graphics;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.util.ArrayList;

import javax.microedition.khronos.opengles.GL10;

/**
 * 绘制赛道标记
 * 
 * @author chengkai
 * 
 */
public class DrawRoadSign extends Shape {
	public final static float ROADSIGN_WIDTH = 30f;// 交通牌长度
	public final static float ROADSIGN_HEIGHT = 15f;// 交通牌高度

	public final static float CYLINDER_HEIGHT = 50;// 支架
	public final static float CYLINDER_R = 1.5f;// 半径
	public final static float DEGREESPAN = 18;// 度数
	public final static int COL = 1;// 块数

	float radiusH = 0.5f;// 小横架的半径
	float length = 10;// 小横架的长度
	float height1 = CYLINDER_HEIGHT - 2 - 4 / 15 * ROADSIGN_HEIGHT;
	float heitht2 = height1 - 7 / 15 * ROADSIGN_HEIGHT;
	Sign sign;// 交通牌
	Cylinder cylinder;// 支架
	Cylinder cylinderH;// 横架
	float yAngle;

	public DrawRoadSign(float scale) {
		super(scale);

		sign = new Sign(scale);
		cylinder = new Cylinder(scale, CYLINDER_HEIGHT, CYLINDER_R, DEGREESPAN,
				COL);// 比例，高度，半径，度数，块数
		cylinderH = new Cylinder(scale, length, radiusH, DEGREESPAN, COL);
	}

	@Override
	public void drawSelf(GL10 gl, int texId, int number) {
		gl.glRotatef(yAngle, 0, 1, 0);
		// 绘制交通牌
		gl.glPushMatrix();
		gl.glTranslatef(-(ROADSIGN_WIDTH / 2 + (length - 0.5f)) * scale,
				(CYLINDER_HEIGHT - ROADSIGN_HEIGHT / 2 - 2) * scale, 0);// -2表示牌子低于支架
		sign.drawSelf(gl, texId, number);
		gl.glPopMatrix();
		// 交通牌背面
		gl.glPushMatrix();
		gl.glTranslatef(-(ROADSIGN_WIDTH / 2 + (length - 0.5f)) * scale,
				(CYLINDER_HEIGHT - ROADSIGN_HEIGHT / 2 - 2) * scale, 0);
		gl.glRotatef(180, 0, 1, 0);// 旋转180度
		sign.drawSelf(gl, texId, number);
		gl.glPopMatrix();
		// 绘制支架
		gl.glPushMatrix();
		gl.glTranslatef(0, CYLINDER_HEIGHT / 2 * scale, 0);
		gl.glRotatef(90, 0, 0, 1);
		cylinder.drawSelf(gl, texId);
		gl.glPopMatrix();
		// 绘制横架1
		gl.glPushMatrix();
		gl.glTranslatef(-(length / 2 - 0.5f) * scale, heitht2 * scale, 0);
		cylinderH.drawSelf(gl, texId);
		gl.glPopMatrix();
		// 绘制横架2
		gl.glPushMatrix();
		gl.glTranslatef(-(length / 2 - 0.5f) * scale, height1 * scale, 0);
		cylinderH.drawSelf(gl, texId);
		gl.glPopMatrix();
	}

	private class Sign {
		private FloatBuffer vertexBuffer;// 顶点Buffer
		private FloatBuffer[] textureBuffer;// 纹理坐标Buffer
		private int vCount = 0;// 顶点数

		public Sign(float scale) {
			float[] vertice = new float[] {// 存放顶点坐标的数组
					-ROADSIGN_WIDTH / 2 * scale,
					ROADSIGN_HEIGHT / 2 * scale,
					0,// 1
					-ROADSIGN_WIDTH / 2 * scale,
					-ROADSIGN_HEIGHT / 2 * scale,
					0,// 2
					ROADSIGN_WIDTH / 2 * scale,
					ROADSIGN_HEIGHT / 2 * scale,
					0,// 4

					ROADSIGN_WIDTH / 2 * scale,
					ROADSIGN_HEIGHT / 2 * scale,
					0,// 4
					-ROADSIGN_WIDTH / 2 * scale,
					-ROADSIGN_HEIGHT / 2 * scale,
					0,// 2
					ROADSIGN_WIDTH / 2 * scale, -ROADSIGN_HEIGHT / 2 * scale,
					0,// 3

			};
			vCount = vertice.length / 3;// 顶点数量

			ByteBuffer vbb = ByteBuffer.allocateDirect(vertice.length * 4);
			vbb.order(ByteOrder.nativeOrder());
			vertexBuffer = vbb.asFloatBuffer();
			vertexBuffer.put(vertice);
			vertexBuffer.position(0);

			float[][] textures = new float[][] {// 纹理坐标
			{// 左转标志
					0, 0.26f, 0, 0.5f, 0.5f, 0.26f,

					0.5f, 0.26f, 0, 0.5f, 0.5f, 0.5f }, {// 右转标志
					0.5f, 0.26f, 0.5f, 0.5f, 1, 0.26f,

					1, 0.26f, 0.5f, 0.5f, 1, 0.5f }, {// 直行标志
					0, 0.5f, 0, 0.75f, 0.5f, 0.5f,

					0.5f, 0.5f, 0, 0.75f, 0.5f, 0.75f }, {// 勿酒驾
					0.5f, 0.5f, 0.5f, 0.75f, 1, 0.5f,

					1, 0.5f, 0.5f, 0.75f, 1, 0.75f }, {// 有隧道
					0, 0.75f, 0, 1, 0.5f, 0.75f,

					0.5f, 0.75f, 0, 1, 0.5f, 1 }, {// 有落石
					0.5f, 0.75f, 0.5f, 1, 1, 0.75f,

					1, 0.75f, 0.5f, 1, 1, 1 }

			};
			textureBuffer = new FloatBuffer[6];
			for (int i = 0; i < textures.length; i++) {
				ByteBuffer tbb = ByteBuffer
						.allocateDirect(textures[i].length * 4);
				tbb.order(ByteOrder.nativeOrder());
				textureBuffer[i] = tbb.asFloatBuffer();
				textureBuffer[i].put(textures[i]);
				textureBuffer[i].position(0);
			}

		}

		public void drawSelf(GL10 gl, int texId, int number) {
			gl.glEnableClientState(GL10.GL_VERTEX_ARRAY);// 开启顶点数组
			gl.glVertexPointer(3, GL10.GL_FLOAT, 0, vertexBuffer);

			gl.glEnable(GL10.GL_TEXTURE_2D);// 允许纹理
			gl.glEnableClientState(GL10.GL_TEXTURE_COORD_ARRAY);// 开启纹理数组
			gl.glTexCoordPointer(2, GL10.GL_FLOAT, 0, textureBuffer[number]);
			gl.glBindTexture(GL10.GL_TEXTURE_2D, texId);// 绑定纹理
			gl.glDrawArrays(GL10.GL_TRIANGLES, 0, vCount);

			gl.glDisable(GL10.GL_TEXTURE_2D);// 关闭纹理
			gl.glDisableClientState(GL10.GL_TEXTURE_COORD_ARRAY);// 关闭纹理数组
		}

	}

	private class Cylinder {
		private FloatBuffer myVertexBuffer;// 顶点坐标缓冲
		private FloatBuffer myTexture;// 纹理缓冲

		int vCount;// 顶点数量

		public Cylinder(float scale, float length, float circle_radius,
				float degreespan, int col) {
			float collength = (float) length * scale / col;// 圆柱每块所占的长度
			int spannum = (int) (360.0f / degreespan);

			ArrayList<Float> val = new ArrayList<Float>();// 顶点存放列表

			for (float circle_degree = 360.0f; circle_degree > 0.0f; circle_degree -= degreespan)// 循环行
			{
				for (int j = 0; j < col; j++)// 循环列
				{
					float x1 = (float) (j * collength - length / 2 * scale);
					float y1 = (float) (circle_radius * scale * Math.sin(Math
							.toRadians(circle_degree)));
					float z1 = (float) (circle_radius * scale * Math.cos(Math
							.toRadians(circle_degree)));

					float x2 = (float) (j * collength - length / 2 * scale);
					float y2 = (float) (circle_radius * scale * Math.sin(Math
							.toRadians(circle_degree - degreespan)));
					float z2 = (float) (circle_radius * scale * Math.cos(Math
							.toRadians(circle_degree - degreespan)));

					float x3 = (float) ((j + 1) * collength - length / 2
							* scale);
					float y3 = (float) (circle_radius * scale * Math.sin(Math
							.toRadians(circle_degree - degreespan)));
					float z3 = (float) (circle_radius * scale * Math.cos(Math
							.toRadians(circle_degree - degreespan)));

					float x4 = (float) ((j + 1) * collength - length / 2
							* scale);
					float y4 = (float) (circle_radius * scale * Math.sin(Math
							.toRadians(circle_degree)));
					float z4 = (float) (circle_radius * scale * Math.cos(Math
							.toRadians(circle_degree)));

					val.add(x1);
					val.add(y1);
					val.add(z1);// 两个三角形，共6个顶点的坐标
					val.add(x2);
					val.add(y2);
					val.add(z2);
					val.add(x4);
					val.add(y4);
					val.add(z4);

					val.add(x2);
					val.add(y2);
					val.add(z2);
					val.add(x3);
					val.add(y3);
					val.add(z3);
					val.add(x4);
					val.add(y4);
					val.add(z4);
				}
			}

			vCount = val.size() / 3;// 确定顶点数量

			// 顶点
			float[] vertexs = new float[vCount * 3];
			for (int i = 0; i < vCount * 3; i++) {
				vertexs[i] = val.get(i);
			}
			ByteBuffer vbb = ByteBuffer.allocateDirect(vertexs.length * 4);
			vbb.order(ByteOrder.nativeOrder());
			myVertexBuffer = vbb.asFloatBuffer();
			myVertexBuffer.put(vertexs);
			myVertexBuffer.position(0);

			// 纹理
			float[] textures = generateTexCoor(col, spannum);
			ByteBuffer tbb = ByteBuffer.allocateDirect(textures.length * 4);
			tbb.order(ByteOrder.nativeOrder());
			myTexture = tbb.asFloatBuffer();
			myTexture.put(textures);
			myTexture.position(0);
		}

		public void drawSelf(GL10 gl, int texId) {

			gl.glEnableClientState(GL10.GL_VERTEX_ARRAY);// 打开顶点缓冲
			gl.glVertexPointer(3, GL10.GL_FLOAT, 0, myVertexBuffer);// 指定顶点缓冲

			gl.glEnable(GL10.GL_TEXTURE_2D);
			gl.glEnableClientState(GL10.GL_TEXTURE_COORD_ARRAY);
			gl.glTexCoordPointer(2, GL10.GL_FLOAT, 0, myTexture);
			gl.glBindTexture(GL10.GL_TEXTURE_2D, texId);

			gl.glDrawArrays(GL10.GL_TRIANGLES, 0, vCount);// 绘制图像

			gl.glDisableClientState(GL10.GL_TEXTURE_COORD_ARRAY);// 关闭缓冲
			gl.glEnable(GL10.GL_TEXTURE_2D);
			gl.glDisableClientState(GL10.GL_VERTEX_ARRAY);
		}

		// 自动切分纹理产生纹理数组的方法
		public float[] generateTexCoor(int bw, int bh) {
			float[] result = new float[bw * bh * 6 * 2];
			float sizew = 1f / bw;// 列数
			float sizeh = 0.125f / bh;// 行数
			int c = 0;
			for (int i = 0; i < bh; i++) {
				for (int j = 0; j < bw; j++) {
					// 每行列一个矩形，由两个三角形构成，共六个点，12个纹理坐标
					float s = j * sizew;
					float t = i * sizeh;

					result[c++] = s;
					result[c++] = t;

					result[c++] = s;
					result[c++] = t + sizeh;

					result[c++] = s + sizew;
					result[c++] = t;

					result[c++] = s;
					result[c++] = t + sizeh;

					result[c++] = s + sizew;
					result[c++] = t + sizeh;

					result[c++] = s + sizew;
					result[c++] = t;
				}
			}
			return result;
		}
	}
}
