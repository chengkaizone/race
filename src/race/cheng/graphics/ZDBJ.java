package race.cheng.graphics;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.util.ArrayList;

import javax.microedition.khronos.opengles.GL10;

public class ZDBJ {
	int roadTextureId;// ·������id
	int lubiaoTexId;// ·������id

	float partSize;// �����ߴ�
	float roadWidth;// ·��

	Road road;// ��·����
	DrawCylinder lubiao;// ·�����

	float Cylinder_R = 9.6f;// ·��Բ���İ뾶
	float start = 130f;// ·��Բ�����Ƶ���ʼ�Ƕ�
	float over = 50f;// ·��Բ�����ƵĽ����Ƕ�
	float cylinder_offsetY;// ·��Բ��Y����ƫ����
	float cylinder_offsetZ;// ·��Բ��Z����ƫ����

	public float mAngleX;
	public float mAngleY;
	public float mAngleZ;

	public void setTexId(int roadTextureId, int lubiaoTexId) {
		this.roadTextureId = roadTextureId;
		this.lubiaoTexId = lubiaoTexId;
	}

	public ZDBJ(float partSize,// �����ߴ�
			float roadWidth// ·��
	) {
		this.partSize = partSize;
		this.roadWidth = roadWidth;

		road = new Road(partSize, roadWidth, 200);
		lubiao = new DrawCylinder(partSize, Cylinder_R, 1.8f, start, over);

		cylinder_offsetY = (float) (-Cylinder_R * Math
				.sin(Math.toRadians(over)));// ·��Բ��Y����ƫ����
		cylinder_offsetZ = (float) (roadWidth / 2 + Cylinder_R
				* Math.cos(Math.toRadians(over)));// ·��Բ��Z����ƫ����
	}

	// ����ֱ������
	public void drawSelf(GL10 gl) {
		gl.glRotatef(mAngleX, 1, 0, 0);// ��ת
		gl.glRotatef(mAngleY, 0, 1, 0);
		gl.glRotatef(mAngleZ, 0, 0, 1);

		gl.glPushMatrix();// ��·
		road.drawSelf(gl);
		gl.glPopMatrix();

		gl.glPushMatrix();// ·���ϲ�
		gl.glTranslatef(0, cylinder_offsetY, cylinder_offsetZ);
		lubiao.drawSelf(gl);
		gl.glPopMatrix();

		gl.glPushMatrix();// ·���²�
		gl.glTranslatef(0, cylinder_offsetY, -cylinder_offsetZ);
		lubiao.drawSelf(gl);
		gl.glPopMatrix();
	}

	private class Road {
		private FloatBuffer mVertexBuffer;// �����������ݻ���
		private FloatBuffer mTextureBuffer;// �����������ݻ���
		int vCount = 0;

		public Road(float L, float W, int col) {
			float width = L / 2;// ֱ·�����볤
			float height = W / 2;// ֱ·�������
			float lengthSpan = L / col;// ֱ·�������仯��λ

			float REPEAT = 10f;
			float texSpan = REPEAT / col;

			ArrayList<Float> val = new ArrayList<Float>();// �����б�
			ArrayList<Float> tal = new ArrayList<Float>();// �����б�

			for (int i = 0; i < col; i++) {
				float s = i * texSpan;

				float x1 = -width + lengthSpan * i;// ����
				float y1 = height;
				float z1 = 0;

				float s1 = s;
				float t1 = 0;

				float x2 = -width + lengthSpan * i;// ����
				float y2 = -height;
				float z2 = 0;

				float s2 = s;
				float t2 = 1;

				float x3 = -width + lengthSpan * (i + 1);// ����
				float y3 = -height;
				float z3 = 0;

				float s3 = s + texSpan;
				float t3 = 1;

				float x4 = -width + lengthSpan * (i + 1);// ����
				float y4 = height;
				float z4 = 0;

				float s4 = s + texSpan;
				float t4 = 0;

				val.add(x1);
				val.add(y1);
				val.add(z1);
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

				tal.add(s1);
				tal.add(t1);
				tal.add(s2);
				tal.add(t2);
				tal.add(s4);
				tal.add(t4);

				tal.add(s2);
				tal.add(t2);
				tal.add(s3);
				tal.add(t3);
				tal.add(s4);
				tal.add(t4);
			}

			vCount = val.size() / 3;

			float[] vertices = new float[vCount * 3];
			for (int i = 0; i < vCount * 3; i++) {
				vertices[i] = val.get(i);
			}

			// ���������������ݻ���
			// vertices.length*4����Ϊһ�������ĸ��ֽ�
			ByteBuffer vbb = ByteBuffer.allocateDirect(vertices.length * 4);
			vbb.order(ByteOrder.nativeOrder());// �����ֽ�˳��
			mVertexBuffer = vbb.asFloatBuffer();// ת��ΪFloat�ͻ���
			mVertexBuffer.put(vertices);// �򻺳����з��붥����������
			mVertexBuffer.position(0);// ���û�������ʼλ��
			// �ر���ʾ�����ڲ�ͬƽ̨�ֽ�˳��ͬ���ݵ�Ԫ�����ֽڵ�һ��Ҫ����ByteBuffer
			// ת�����ؼ���Ҫͨ��ByteOrder����nativeOrder()�������п��ܻ������
			// �����������ݵĳ�ʼ��================end============================

			// ���� �������ݳ�ʼ��

			float[] texST = new float[vCount * 2];
			for (int i = 0; i < vCount * 2; i++) {
				texST[i] = tal.get(i);
			}

			ByteBuffer tbb = ByteBuffer.allocateDirect(texST.length * 4);
			tbb.order(ByteOrder.nativeOrder());// �����ֽ�˳��
			mTextureBuffer = tbb.asFloatBuffer();// ת��Ϊint�ͻ���
			mTextureBuffer.put(texST);// �򻺳����з��붥����ɫ����
			mTextureBuffer.position(0);// ���û�������ʼλ��
		}

		public void drawSelf(GL10 gl) {
			gl.glRotatef(-90, 1, 0, 0);// ʹֱ��������ת��XOZƽ����

			gl.glEnableClientState(GL10.GL_VERTEX_ARRAY);// ���ö�����������

			// Ϊ����ָ��������������
			gl.glVertexPointer(3, // ÿ���������������Ϊ3 xyz
					GL10.GL_FLOAT, // ��������ֵ������Ϊ GL_FIXED
					0, // ����������������֮��ļ��
					mVertexBuffer // ������������
			);

			// ��������
			gl.glEnable(GL10.GL_TEXTURE_2D);
			// ����ʹ������ST���껺��
			gl.glEnableClientState(GL10.GL_TEXTURE_COORD_ARRAY);
			// Ϊ����ָ������ST���껺��
			gl.glTexCoordPointer(2, GL10.GL_FLOAT, 0, mTextureBuffer);
			// �󶨵�ǰ����
			gl.glBindTexture(GL10.GL_TEXTURE_2D, roadTextureId);

			// ����ͼ��
			gl.glDrawArrays(GL10.GL_TRIANGLES, // �������η�ʽ���
					0, // ��ʼ����
					vCount // ���������
			);

			gl.glDisableClientState(GL10.GL_TEXTURE_COORD_ARRAY);
			gl.glDisable(GL10.GL_TEXTURE_2D);
			gl.glDisableClientState(GL10.GL_VERTEX_ARRAY);
		}
	}

	// ����Բ�����ڲ���
	private class DrawCylinder {
		private FloatBuffer myVertexBuffer;// �������껺��
		private FloatBuffer myTexture;// ������

		int vCount;// ��������

		public DrawCylinder(float length, float circle_radius,
				float degreespan, float startAngle, float overAngle) {
			int spannum = (int) (360.0f / degreespan);

			ArrayList<Float> val = new ArrayList<Float>();// �������б�

			for (float circle_degree = startAngle; circle_degree > overAngle; circle_degree -= degreespan)// ѭ����
			{
				float x1 = (float) (-length / 2);
				float y1 = (float) (circle_radius * Math.sin(Math
						.toRadians(circle_degree)));
				float z1 = (float) (circle_radius * Math.cos(Math
						.toRadians(circle_degree)));

				float x2 = (float) (-length / 2);
				float y2 = (float) (circle_radius * Math.sin(Math
						.toRadians(circle_degree - degreespan)));
				float z2 = (float) (circle_radius * Math.cos(Math
						.toRadians(circle_degree - degreespan)));

				float x3 = (float) (length / 2);
				float y3 = (float) (circle_radius * Math.sin(Math
						.toRadians(circle_degree - degreespan)));
				float z3 = (float) (circle_radius * Math.cos(Math
						.toRadians(circle_degree - degreespan)));

				float x4 = (float) (length / 2);
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
			float[] textures = generateTexCoor(spannum);
			ByteBuffer tbb = ByteBuffer.allocateDirect(textures.length * 4);
			tbb.order(ByteOrder.nativeOrder());
			myTexture = tbb.asFloatBuffer();
			myTexture.put(textures);
			myTexture.position(0);
		}

		public void drawSelf(GL10 gl) {
			gl.glEnableClientState(GL10.GL_VERTEX_ARRAY);// �򿪶��㻺��
			gl.glVertexPointer(3, GL10.GL_FLOAT, 0, myVertexBuffer);// ָ�����㻺��

			gl.glEnable(GL10.GL_TEXTURE_2D);
			gl.glEnableClientState(GL10.GL_TEXTURE_COORD_ARRAY);
			gl.glTexCoordPointer(2, GL10.GL_FLOAT, 0, myTexture);
			gl.glBindTexture(GL10.GL_TEXTURE_2D, lubiaoTexId);

			gl.glDrawArrays(GL10.GL_TRIANGLES, 0, vCount);// ����ͼ��

			gl.glDisableClientState(GL10.GL_TEXTURE_COORD_ARRAY);// �رջ���
			gl.glEnable(GL10.GL_TEXTURE_2D);
			gl.glDisableClientState(GL10.GL_VERTEX_ARRAY);
		}

		// �Զ��з����������������ķ���
		public float[] generateTexCoor(int bh) {
			float[] result = new float[bh * 6 * 2];
			float sizeh = 1.0f / bh;// ����
			float REPEAT = 10;
			int c = 0;
			for (int i = 0; i < bh; i++) {
				// ÿ����һ�����Σ������������ι��ɣ��������㣬12����������
				float t = i * sizeh;

				result[c++] = 0;
				result[c++] = t;

				result[c++] = 0;
				result[c++] = t + sizeh;

				result[c++] = REPEAT;
				result[c++] = t;

				result[c++] = 0;
				result[c++] = t + sizeh;

				result[c++] = REPEAT;
				result[c++] = t + sizeh;

				result[c++] = REPEAT;
				result[c++] = t;
			}
			return result;
		}
	}
}
