package race.cheng.graphics;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.util.ArrayList;

import javax.microedition.khronos.opengles.GL10;

/**
 * ��־��
 * 
 * @author chengkai
 * 
 */
public class DrawBillBoard extends Shape {
	public final static float ROADSIGN_WIDTH = 30f;// �Ƴ���
	public final static float ROADSIGN_HEIGHT = 15f;// �Ƹ߶�

	public final static float CYLINDER_HEIGHT = 60;// ֧�ܸ߶�
	public final static float CYLINDER_R = 1.5f;// �뾶
	public final static float DEGREESPAN = 18;// ����
	public final static int COL = 1;// ����
	public final static float DISTANCE = 2f;// ֧�������ӽ��Ӿ���

	public final static float SIN60 = 0.8660254f;// sin60��ֵ
	public final static float TAN30 = 0.5773502f;// tan30��ֵ

	float yAngle;
	Sign sign;// ��������
	Cylinder cylinder;

	public DrawBillBoard(float scale) {
		super(scale);
		sign = new Sign(scale);
		cylinder = new Cylinder(scale, CYLINDER_HEIGHT, CYLINDER_R, DEGREESPAN,
				COL);
	}

	@Override
	public void drawSelf(GL10 gl, int texId, int number) {
		gl.glRotatef(yAngle, 0, 1, 0);
		// ���Ƶ�һ������
		gl.glPushMatrix();
		gl.glTranslatef(0, (CYLINDER_HEIGHT + ROADSIGN_HEIGHT / 2 - DISTANCE)
				* scale, ROADSIGN_WIDTH / 2 * scale * TAN30);
		sign.drawSelf(gl, texId, number);
		gl.glPopMatrix();
		// ��һ�����ӱ���
		gl.glPushMatrix();
		gl.glTranslatef(0, (CYLINDER_HEIGHT + ROADSIGN_HEIGHT / 2 - DISTANCE)
				* scale, ROADSIGN_WIDTH / 2 * scale * TAN30);
		gl.glRotatef(180, 0, 1, 0);
		sign.drawSelf(gl, texId, number);
		gl.glPopMatrix();
		// ���Ƶڶ�������
		gl.glPushMatrix();
		gl.glTranslatef(-ROADSIGN_WIDTH / 2 * scale * 1 / 2, (CYLINDER_HEIGHT
				+ ROADSIGN_HEIGHT / 2 - DISTANCE)
				* scale, ROADSIGN_WIDTH / 2 * scale * TAN30 - ROADSIGN_WIDTH
				/ 2 * scale * SIN60);// 1/2��ʾsin30.
		gl.glRotatef(-120, 0, 1, 0);// ��ת-120��
		sign.drawSelf(gl, texId, number);
		gl.glPopMatrix();
		// �ڶ������ӱ���
		gl.glPushMatrix();
		gl.glTranslatef(-ROADSIGN_WIDTH / 2 * scale * 1 / 2, (CYLINDER_HEIGHT
				+ ROADSIGN_HEIGHT / 2 - DISTANCE)
				* scale, ROADSIGN_WIDTH / 2 * scale * TAN30 - ROADSIGN_WIDTH
				/ 2 * scale * SIN60);// 1/2��ʾsin30.
		gl.glRotatef(60, 0, 1, 0);// ��ת60��
		sign.drawSelf(gl, texId, number);
		gl.glPopMatrix();
		// ���Ƶ���������
		gl.glPushMatrix();
		gl.glTranslatef(ROADSIGN_WIDTH / 2 * scale * 1 / 2, (CYLINDER_HEIGHT
				+ ROADSIGN_HEIGHT / 2 - DISTANCE)
				* scale, ROADSIGN_WIDTH / 2 * scale * TAN30 - ROADSIGN_WIDTH
				/ 2 * scale * SIN60);// 1/2��ʾsin30.
		gl.glRotatef(120, 0, 1, 0);// ��ת60��
		sign.drawSelf(gl, texId, number);
		gl.glPopMatrix();
		// ���������ӵı���
		gl.glPushMatrix();
		gl.glTranslatef(ROADSIGN_WIDTH / 2 * scale * 1 / 2, (CYLINDER_HEIGHT
				+ ROADSIGN_HEIGHT / 2 - DISTANCE)
				* scale, ROADSIGN_WIDTH / 2 * scale * TAN30 - ROADSIGN_WIDTH
				/ 2 * scale * SIN60);// 1/2��ʾsin30.
		gl.glRotatef(-60, 0, 1, 0);// ��ת-60��
		sign.drawSelf(gl, texId, number);
		gl.glPopMatrix();
		// ����֧��
		gl.glPushMatrix();
		// gl.glTranslatef(0,
		// CYLINDER_HEIGHT*scale-(CYLINDER_HEIGHT/2+ROADSIGN_HEIGHT/2)*scale+DISTANCE,
		// 0);
		gl.glTranslatef(0, CYLINDER_HEIGHT / 2 * scale, 0);
		gl.glRotatef(90, 0, 0, 1);
		cylinder.drawSelf(gl, texId);
		gl.glPopMatrix();
	}

	private class Sign {
		private FloatBuffer vertexBuffer;// ����Buffer
		private FloatBuffer[] textureBuffer;// ��������Buffer
		private int vCount = 0;// ������

		public Sign(float scale) {
			float[] vertice = new float[] {// ��Ŷ������������
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
			vCount = vertice.length / 3;// ��������

			ByteBuffer vbb = ByteBuffer.allocateDirect(vertice.length * 4);
			vbb.order(ByteOrder.nativeOrder());
			vertexBuffer = vbb.asFloatBuffer();
			vertexBuffer.put(vertice);
			vertexBuffer.position(0);

			float[][] textures = new float[][] { {// ��һ�������������
					0, 0.125f, 0, 0.375f, 0.5f, 0.125f,

					0.5f, 0.125f, 0, 0.375f, 0.5f, 0.375f }, {// �ڶ��������������
					0.5f, 0.125f, 0.5f, 0.375f, 1, 0.125f,

					1f, 0.125f, 0.5f, 0.375f, 1f, 0.375f }, {// �����������������
					0, 0.375f, 0, 0.625f, 0.5f, 0.375f,

					0.5f, 0.375f, 0, 0.625f, 0.5f, 0.625f }, {// ���ĸ������������
					0.5f, 0.375f, 0.5f, 0.625f, 1f, 0.375f,

					1f, 0.375f, 0.5f, 0.625f, 1f, 0.625f }, {// ����������������
					0, 0.625f, 0, 0.875f, 0.5f, 0.625f,

					0.5f, 0.625f, 0, 0.875f, 0.5f, 0.825f }, {// �����������������
					0.5f, 0.625f, 0.5f, 0.875f, 1, 0.625f,

					1, 0.625f, 0.5f, 0.875f, 1, 0.875f } };
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
			gl.glEnableClientState(GL10.GL_VERTEX_ARRAY);// ������������
			gl.glVertexPointer(3, GL10.GL_FLOAT, 0, vertexBuffer);

			gl.glEnable(GL10.GL_TEXTURE_2D);// ��������
			gl.glEnableClientState(GL10.GL_TEXTURE_COORD_ARRAY);// ������������
			gl.glTexCoordPointer(2, GL10.GL_FLOAT, 0, textureBuffer[number]);
			gl.glBindTexture(GL10.GL_TEXTURE_2D, texId);// ������
			gl.glDrawArrays(GL10.GL_TRIANGLES, 0, vCount);

			gl.glDisable(GL10.GL_TEXTURE_2D);// �ر�����
			gl.glDisableClientState(GL10.GL_TEXTURE_COORD_ARRAY);// �ر���������
		}

	}

	private class Cylinder {
		private FloatBuffer myVertexBuffer;// �������껺��
		private FloatBuffer myTexture;// ������

		int vCount;// ��������

		// float length;//Բ������
		// float circle_radius;//Բ�ػ��뾶
		// float degreespan; //Բ�ػ�ÿһ�ݵĶ�����С
		// int col;//Բ������

		public Cylinder(float scale, float length, float circle_radius,
				float degreespan, int col) {

			float collength = (float) length * scale / col;// Բ��ÿ����ռ�ĳ���
			int spannum = (int) (360.0f / degreespan);

			ArrayList<Float> val = new ArrayList<Float>();// �������б�

			for (float circle_degree = 360.0f; circle_degree > 0.0f; circle_degree -= degreespan)// ѭ����
			{
				for (int j = 0; j < col; j++)// ѭ����
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
					val.add(z1);// ���������Σ���6�����������
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

			vCount = val.size() / 3;// ȷ����������

			// ����
			float[] vertexs = new float[vCount * 3];
			for (int i = 0; i < vCount * 3; i++) {
				vertexs[i] = val.get(i);
			}
			ByteBuffer vbb = ByteBuffer.allocateDirect(vertexs.length * 4);
			vbb.order(ByteOrder.nativeOrder());
			myVertexBuffer = vbb.asFloatBuffer();
			myVertexBuffer.put(vertexs);
			myVertexBuffer.position(0);

			// ����
			float[] textures = generateTexCoor(col, spannum);
			ByteBuffer tbb = ByteBuffer.allocateDirect(textures.length * 4);
			tbb.order(ByteOrder.nativeOrder());
			myTexture = tbb.asFloatBuffer();
			myTexture.put(textures);
			myTexture.position(0);
		}

		public void drawSelf(GL10 gl, int texId) {

			gl.glEnableClientState(GL10.GL_VERTEX_ARRAY);// �򿪶��㻺��
			gl.glVertexPointer(3, GL10.GL_FLOAT, 0, myVertexBuffer);// ָ�����㻺��

			gl.glEnable(GL10.GL_TEXTURE_2D);
			gl.glEnableClientState(GL10.GL_TEXTURE_COORD_ARRAY);
			gl.glTexCoordPointer(2, GL10.GL_FLOAT, 0, myTexture);
			gl.glBindTexture(GL10.GL_TEXTURE_2D, texId);

			gl.glDrawArrays(GL10.GL_TRIANGLES, 0, vCount);// ����ͼ��

			gl.glDisableClientState(GL10.GL_TEXTURE_COORD_ARRAY);// �رջ���
			gl.glEnable(GL10.GL_TEXTURE_2D);
			gl.glDisableClientState(GL10.GL_VERTEX_ARRAY);
		}

		// �Զ��з����������������ķ���
		public float[] generateTexCoor(int bw, int bh) {
			float[] result = new float[bw * bh * 6 * 2];
			float sizew = 0.5f / bw;// ����
			float sizeh = 0.125f / bh;// ����
			int c = 0;
			for (int i = 0; i < bh; i++) {
				for (int j = 0; j < bw; j++) {
					// ÿ����һ�����Σ������������ι��ɣ��������㣬12����������
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
