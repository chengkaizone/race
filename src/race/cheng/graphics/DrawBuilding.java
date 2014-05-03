package race.cheng.graphics;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.util.ArrayList;

import javax.microedition.khronos.opengles.GL10;

public class DrawBuilding extends Shape {
	// �����峤������
	public static float LENGTH = 15f;
	public static float WIDTH = 10f;
	public static float HEIGHT = 12f;
	// Բ���ߡ��뾶���и����������
	public static float CYLINDER_HEIGHT = 50f;
	public static float CIRCLE_RADIUS = 20f;
	public static float DEGREESPAN = 18f;
	public static int COL = 1;

	private Cube cubeBuilding;
	private DrawCylinder cylinderBuilding;
	private DrawCylinderTop buildingRoof;
	// �����������ת���Ƕ�
	public float mAngleX;
	public float mAngleY;
	public float mAngleZ;

	public DrawBuilding(float scale) {
		super(scale);
		cubeBuilding = new Cube(scale);
		cylinderBuilding = new DrawCylinder(scale * CYLINDER_HEIGHT, scale
				* CIRCLE_RADIUS, scale * DEGREESPAN, COL);
		buildingRoof = new DrawCylinderTop(scale * CYLINDER_HEIGHT * 0.2f,
				scale * CIRCLE_RADIUS * 0.8f, scale * DEGREESPAN, COL);
	}

	@Override
	public void drawSelf(GL10 gl, int texId, int number) {
		gl.glRotatef(mAngleX, 1, 0, 0);// ��ת
		gl.glRotatef(mAngleY, 0, 1, 0);
		gl.glRotatef(mAngleZ, 0, 0, 1);

		gl.glPushMatrix();
		gl.glTranslatef(-scale * CIRCLE_RADIUS, scale * CYLINDER_HEIGHT / 2, 0);
		gl.glRotatef(90, 0, 0, 1);
		cylinderBuilding.drawSelf(gl, texId);
		gl.glPopMatrix();

		gl.glPushMatrix();
		gl.glTranslatef(-scale * CIRCLE_RADIUS, scale * CYLINDER_HEIGHT + scale
				* CYLINDER_HEIGHT * 0.2f / 2, 0);
		gl.glRotatef(90, 0, 0, 1);
		buildingRoof.drawSelf(gl, texId);
		gl.glPopMatrix();

		gl.glPushMatrix();
		gl.glTranslatef(0.8f * scale * LENGTH, scale * HEIGHT, 0);
		cubeBuilding.drawSelf(gl, texId);
		gl.glPopMatrix();
	}

	private class Cube {
		private FloatBuffer mVertexBuffer;// �����������ݻ���
		private FloatBuffer mTextureBuffer; // �����������ݻ���
		public float mOffsetX;
		public float mOffsetY; // �������С
		int vCount;// ��������

		public Cube(float scale) {
			vCount = 36;
			float[] verteices = {

					// ����
					-scale * LENGTH,
					HEIGHT * scale,
					-scale * WIDTH,
					-scale * LENGTH,
					HEIGHT * scale,
					scale * WIDTH,
					scale * LENGTH,
					HEIGHT * scale,
					scale * WIDTH,

					-scale * LENGTH,
					HEIGHT * scale,
					-scale * WIDTH,
					scale * LENGTH,
					HEIGHT * scale,
					scale * WIDTH,
					scale * LENGTH,
					HEIGHT * scale,
					-scale * WIDTH,

					// ����
					scale * LENGTH,
					HEIGHT * scale,
					-scale * WIDTH,
					scale * LENGTH,
					-HEIGHT * scale,
					-scale * WIDTH,
					-scale * LENGTH,
					-HEIGHT * scale,
					-scale * WIDTH,

					scale * LENGTH,
					HEIGHT * scale,
					-scale * WIDTH,
					-scale * LENGTH,
					-HEIGHT * scale,
					-scale * WIDTH,
					-scale * LENGTH,
					HEIGHT * scale,
					-scale * WIDTH,

					// ǰ��
					-scale * LENGTH, HEIGHT * scale, scale * WIDTH,
					-scale * LENGTH,
					-HEIGHT * scale,
					scale * WIDTH,
					scale * LENGTH,
					-HEIGHT * scale,
					scale * WIDTH,

					-scale * LENGTH,
					HEIGHT * scale,
					scale * WIDTH,
					scale * LENGTH,
					-HEIGHT * scale,
					scale * WIDTH,
					scale * LENGTH,
					HEIGHT * scale,
					scale * WIDTH,

					// ����
					-scale * LENGTH, -HEIGHT * scale, scale * WIDTH,
					-scale * LENGTH, -HEIGHT * scale, -scale * WIDTH,
					scale * LENGTH, -HEIGHT * scale, -scale * WIDTH,

					-scale * LENGTH,
					-HEIGHT * scale,
					scale * WIDTH,
					scale * LENGTH,
					-HEIGHT * scale,
					-scale * WIDTH,
					scale * LENGTH,
					-HEIGHT * scale,
					scale * WIDTH,

					// ����
					-scale * LENGTH, -HEIGHT * scale, -scale * WIDTH,
					-scale * LENGTH, -HEIGHT * scale, -scale * WIDTH,
					-scale * LENGTH, -HEIGHT * scale, scale * WIDTH,

					-scale * LENGTH, HEIGHT * scale, -scale * WIDTH,
					-scale * LENGTH, -HEIGHT * scale,
					scale * WIDTH,
					-scale * LENGTH,
					HEIGHT * scale,
					scale * WIDTH,

					// ����
					scale * LENGTH, HEIGHT * scale, scale * WIDTH,
					scale * LENGTH, -HEIGHT * scale, scale * WIDTH,
					scale * LENGTH, -HEIGHT * scale, -scale * WIDTH,

					scale * LENGTH, HEIGHT * scale, scale * WIDTH,
					scale * LENGTH, -HEIGHT * scale, -scale * WIDTH,
					scale * LENGTH, HEIGHT * scale, -scale * WIDTH

			};

			ByteBuffer vbb = ByteBuffer.allocateDirect(verteices.length * 4); // ���������������ݻ���
			vbb.order(ByteOrder.nativeOrder());// �����ֽ�˳��
			mVertexBuffer = vbb.asFloatBuffer();// ת��Ϊfloat�ͻ���
			mVertexBuffer.put(verteices);// �򻺳����з��붥����������
			mVertexBuffer.position(0);// ���û�������ʼλ��

			float[] textureCoors = new float[vCount * 2];
			for (int i = 0; i < vCount / 6; i++)// ��������������
			{
				textureCoors[i * 12] = 0;
				textureCoors[(i * 12) + 1] = 0;

				textureCoors[(i * 12) + 2] = 0;
				textureCoors[(i * 12) + 3] = 0.125f;

				textureCoors[(i * 12) + 4] = 0.125f;
				textureCoors[(i * 12) + 5] = 0.125f;

				textureCoors[(i * 12) + 6] = 0;
				textureCoors[(i * 12) + 7] = 0;

				textureCoors[(i * 12) + 8] = 0.125f;
				textureCoors[(i * 12) + 9] = 0.125f;

				textureCoors[(i * 12) + 10] = 0.125f;
				textureCoors[(i * 12) + 11] = 0;

			}

			ByteBuffer tbb = ByteBuffer.allocateDirect(textureCoors.length * 4);// ���������������ݻ���
			tbb.order(ByteOrder.nativeOrder());// �����ֽ�˳��
			mTextureBuffer = tbb.asFloatBuffer();// ת��Ϊfloat�ͻ���
			mTextureBuffer.put(textureCoors);// �򻺳����з��붥����������
			mTextureBuffer.position(0);// ���û�������ʼλ��

		}

		public void drawSelf(GL10 gl, int texId) {
			gl.glRotatef(mOffsetX, 1, 0, 0);
			gl.glRotatef(mOffsetY, 0, 1, 0);

			gl.glEnableClientState(GL10.GL_VERTEX_ARRAY);
			gl.glVertexPointer(3, GL10.GL_FLOAT, 0, mVertexBuffer);

			gl.glEnable(GL10.GL_TEXTURE_2D);// ��������
			gl.glEnableClientState(GL10.GL_TEXTURE_COORD_ARRAY);// ����ʹ����������
			gl.glTexCoordPointer(2, GL10.GL_FLOAT, 0, mTextureBuffer);// ָ����������
			gl.glBindTexture(GL10.GL_TEXTURE_2D, texId);// ������
			gl.glDrawArrays(GL10.GL_TRIANGLES, 0, vCount);// ����

			gl.glDisableClientState(GL10.GL_TEXTURE_COORD_ARRAY);// �ر���������
			gl.glDisable(GL10.GL_TEXTURE_2D);// �ر�����

		}
	}

	private class DrawCylinder {
		private FloatBuffer myVertexBuffer;// �������껺��
		private FloatBuffer myTexture;// ������
		int vCount;// ��������

		public float mAngleX;
		public float mAngleY;
		public float mAngleZ;

		public DrawCylinder(float length, float circle_radius,
				float degreespan, int col) {
			float collength = (float) length / col;// Բ��ÿ����ռ�ĳ���
			int spannum = (int) (360.0f / degreespan);

			ArrayList<Float> val = new ArrayList<Float>();// �������б�

			for (float circle_degree = 360.0f; circle_degree > 0.0f; circle_degree -= degreespan)// ѭ����
			{
				for (int j = 0; j < col; j++)// ѭ����
				{
					float x1 = (float) (j * collength - length / 2);
					float y1 = (float) (circle_radius * Math.sin(Math
							.toRadians(circle_degree)));
					float z1 = (float) (circle_radius * Math.cos(Math
							.toRadians(circle_degree)));

					float x2 = (float) (j * collength - length / 2);
					float y2 = (float) (circle_radius * Math.sin(Math
							.toRadians(circle_degree - degreespan)));
					float z2 = (float) (circle_radius * Math.cos(Math
							.toRadians(circle_degree - degreespan)));

					float x3 = (float) ((j + 1) * collength - length / 2);
					float y3 = (float) (circle_radius * Math.sin(Math
							.toRadians(circle_degree - degreespan)));
					float z3 = (float) (circle_radius * Math.cos(Math
							.toRadians(circle_degree - degreespan)));

					float x4 = (float) ((j + 1) * collength - length / 2);
					float y4 = (float) (circle_radius * Math.sin(Math
							.toRadians(circle_degree)));
					float z4 = (float) (circle_radius * Math.cos(Math
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

		public void drawSelf(GL10 gl, int textureId) {
			gl.glRotatef(mAngleX, 1, 0, 0);// ��ת
			gl.glRotatef(mAngleY, 0, 1, 0);
			gl.glRotatef(mAngleZ, 0, 0, 1);

			gl.glEnableClientState(GL10.GL_VERTEX_ARRAY);// �򿪶��㻺��
			gl.glVertexPointer(3, GL10.GL_FLOAT, 0, myVertexBuffer);// ָ�����㻺��

			gl.glEnable(GL10.GL_TEXTURE_2D);
			gl.glEnableClientState(GL10.GL_TEXTURE_COORD_ARRAY);
			gl.glTexCoordPointer(2, GL10.GL_FLOAT, 0, myTexture);
			gl.glBindTexture(GL10.GL_TEXTURE_2D, textureId);

			gl.glDrawArrays(GL10.GL_TRIANGLES, 0, vCount);// ����ͼ��

			gl.glDisableClientState(GL10.GL_TEXTURE_COORD_ARRAY);// �رջ���
			gl.glEnable(GL10.GL_TEXTURE_2D);
			gl.glDisableClientState(GL10.GL_VERTEX_ARRAY);
		}

		// �Զ��з����������������ķ���
		public float[] generateTexCoor(int bw, int bh) {
			float[] result = new float[bw * bh * 6 * 2];
			int c = 0;
			for (int i = 0; i < bh; i++) {
				for (int j = 0; j < bw; j++) {
					result[c++] = 0;
					result[c++] = 0;

					result[c++] = 0;
					result[c++] = 0.125f;

					result[c++] = 1f;
					result[c++] = 0;

					result[c++] = 0;
					result[c++] = 0.125f;

					result[c++] = 1f;
					result[c++] = 0.125f;

					result[c++] = 1f;
					result[c++] = 0;
				}
			}
			return result;
		}
	}

	private class DrawCylinderTop {
		private FloatBuffer myVertexBuffer;// �������껺��
		// private FloatBuffer myNormalBuffer;//����������
		private FloatBuffer myTexture;// ������
		int vCount;// ��������

		public float mAngleX;
		public float mAngleY;
		public float mAngleZ;

		public DrawCylinderTop(float length, float circle_radius,
				float degreespan, int col) {
			float collength = (float) length / col;// Բ��ÿ����ռ�ĳ���
			int spannum = (int) (360.0f / degreespan);

			ArrayList<Float> val = new ArrayList<Float>();// �������б�

			for (float circle_degree = 360.0f; circle_degree > 0.0f; circle_degree -= degreespan)// ѭ����
			{
				for (int j = 0; j < col; j++)// ѭ����
				{
					float x1 = (float) (j * collength - length / 2);
					float y1 = (float) (circle_radius * Math.sin(Math
							.toRadians(circle_degree)));
					float z1 = (float) (circle_radius * Math.cos(Math
							.toRadians(circle_degree)));

					float x2 = (float) (j * collength - length / 2);
					float y2 = (float) (circle_radius * Math.sin(Math
							.toRadians(circle_degree - degreespan)));
					float z2 = (float) (circle_radius * Math.cos(Math
							.toRadians(circle_degree - degreespan)));

					float x3 = (float) ((j + 1) * collength - length / 2);
					float y3 = (float) (circle_radius * Math.sin(Math
							.toRadians(circle_degree - degreespan)));
					float z3 = (float) (circle_radius * Math.cos(Math
							.toRadians(circle_degree - degreespan)));

					float x4 = (float) ((j + 1) * collength - length / 2);
					float y4 = (float) (circle_radius * Math.sin(Math
							.toRadians(circle_degree)));
					float z4 = (float) (circle_radius * Math.cos(Math
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

		public void drawSelf(GL10 gl, int textureId) {
			gl.glRotatef(mAngleX, 1, 0, 0);// ��ת
			gl.glRotatef(mAngleY, 0, 1, 0);
			gl.glRotatef(mAngleZ, 0, 0, 1);

			gl.glEnableClientState(GL10.GL_VERTEX_ARRAY);// �򿪶��㻺��
			gl.glVertexPointer(3, GL10.GL_FLOAT, 0, myVertexBuffer);// ָ�����㻺��

			gl.glEnable(GL10.GL_TEXTURE_2D);
			gl.glEnableClientState(GL10.GL_TEXTURE_COORD_ARRAY);
			gl.glTexCoordPointer(2, GL10.GL_FLOAT, 0, myTexture);
			gl.glBindTexture(GL10.GL_TEXTURE_2D, textureId);

			gl.glDrawArrays(GL10.GL_TRIANGLES, 0, vCount);// ����ͼ��

			gl.glDisableClientState(GL10.GL_TEXTURE_COORD_ARRAY);// �رջ���
			gl.glEnable(GL10.GL_TEXTURE_2D);
			gl.glDisableClientState(GL10.GL_VERTEX_ARRAY);
		}

		// �Զ��з����������������ķ���
		public float[] generateTexCoor(int bw, int bh) {
			float[] result = new float[bw * bh * 6 * 2];
			float sizeh = 0.5f / bh;// ����
			float sizew = 0.125f / bw;// ����
			int c = 0;
			for (int i = 0; i < bh; i++) {
				for (int j = 0; j < bw; j++) {
					// ÿ����һ�����Σ������������ι��ɣ��������㣬12����������
					float t = 0.125f + i * sizeh;
					float s = j * sizew;

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
