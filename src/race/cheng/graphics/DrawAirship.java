package race.cheng.graphics;

import static race.cheng.service.Constant.X_SPAN;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.util.ArrayList;

import javax.microedition.khronos.opengles.GL10;

/**
 * ���Ʒ�ͧ---��������ͻ���������
 * 
 * @author chengkai
 * 
 */
public class DrawAirship extends Shape {
	// ��ͧ���й켣���ĵ�λ��
	public static float feitingX;
	public static float feitingY;
	public static float feitingZ;
	/**
	 * ��ͧ������ԲA�뾶
	 */
	public static float A = 7 * X_SPAN;
	/**
	 * ��ͧ����B�뾶
	 */
	public static float B = 3 * X_SPAN;
	/**
	 * ��ͧ��ǰ�Ƕ�
	 */
	public static float angle = 360;
	/**
	 * ��ͧ�Ŷ��Ƕ�
	 */
	public static float angleRotate = 0;
	public static float height = 10;
	// �������ߵ�ǰ֡�Ƕ�
	public static float angleY = 270;
	DrawSpheroid bodyback;
	DrawSpheroid bodyhead;
	DrawSpheroid cabin;
	DrawWing wing;
	public static goThread thread;

	public final static float BODYBACK_A = 6f;
	public final static float BODYBACK_B = 1f;
	public final static float BODYBACK_C = 1f;

	public final static float BODYHEAD_A = 2f;
	public final static float BODYHEAD_B = 1f;
	public final static float BODYHEAD_C = 1f;

	public final static float CABIN_A = 0.4f;
	public final static float CABIN_B = 0.2f;
	public final static float CABIN_C = 0.2f;

	public float mAngleX;
	public float mAngleY;
	public float mAngleZ;

	public DrawAirship(float scale) {
		super(scale);

		bodyback = new DrawSpheroid(BODYBACK_A * scale, BODYBACK_B * scale,
				BODYBACK_C * scale, 18, -90, 90, -90, 90);
		bodyhead = new DrawSpheroid(BODYHEAD_A * scale, BODYHEAD_B * scale,
				BODYHEAD_C * scale, 18, -90, 90, -90, 90);
		cabin = new DrawSpheroid(CABIN_A * scale, CABIN_B * scale, CABIN_C
				* scale, 18, 0, 360, -90, 90);
		wing = new DrawWing(scale * BODYBACK_A / 6, scale * BODYBACK_B / 6,
				scale * BODYBACK_A / 8, scale * BODYBACK_B / 16, scale
						* BODYHEAD_C / 1.5f);
		thread = new goThread();
		// thread.start();
	}

	public void drawSelf(GL10 gl, int texId, int number) {
		feitingX = (float) (A * Math.cos(Math.toRadians(angle)));
		feitingY = (float) (height * Math.sin(Math.toRadians(angleY)));
		feitingZ = (float) (B * Math.sin(Math.toRadians(angle)));

		gl.glRotatef(mAngleZ, 0, 0, 1);// ��Z����ת
		gl.glRotatef(mAngleY, 0, 1, 0);// ��Y����ת
		gl.glRotatef(mAngleX, 1, 0, 0);// ��X����ת

		gl.glPushMatrix();

		gl.glTranslatef(feitingX, feitingY, feitingZ);
		gl.glRotatef(angleRotate - 90, 0, 1, 0);

		gl.glPushMatrix();
		gl.glTranslatef(scale * BODYBACK_A * 10 / 12, 0, scale * BODYHEAD_C
				/ 1.7f);
		gl.glRotatef(-90, 1, 0, 0);
		gl.glRotatef(15, 0, 0, 1);
		wing.drawSelf(gl, texId);
		gl.glPopMatrix();

		gl.glPushMatrix();
		gl.glTranslatef(scale * BODYBACK_A * 10 / 12, 0, -scale * BODYHEAD_C
				/ 1.7f);
		gl.glRotatef(90, 1, 0, 0);
		gl.glRotatef(15, 0, 0, 1);
		wing.drawSelf(gl, texId);
		gl.glPopMatrix();

		gl.glPushMatrix();
		gl.glTranslatef(scale * BODYBACK_A * 10 / 12, -scale * BODYHEAD_C
				/ 1.7f, 0);
		gl.glRotatef(15, 0, 0, 1);
		wing.drawSelf(gl, texId);
		gl.glPopMatrix();

		gl.glPushMatrix();
		gl.glTranslatef(scale * BODYBACK_A * 10 / 12,
				scale * BODYHEAD_C / 1.7f, 0);
		gl.glRotatef(165, 0, 0, 1);
		wing.drawSelf(gl, texId);
		gl.glPopMatrix();

		gl.glPushMatrix();
		gl.glRotatef(180, 1, 0, 0);
		bodyback.drawSelf(gl, texId);
		gl.glPopMatrix();

		gl.glPushMatrix();
		gl.glRotatef(180, 0, 1, 0);
		bodyhead.drawSelf(gl, texId);
		gl.glPopMatrix();

		gl.glPushMatrix();
		gl.glTranslatef(scale * BODYBACK_A / 4, -scale * BODYBACK_B, 0);
		gl.glRotatef(180, 1, 0, 0);
		cabin.drawSelf(gl, texId);
		gl.glPopMatrix();

		gl.glPopMatrix();
	}

	// ���������ڲ���
	private class DrawSpheroid {
		private FloatBuffer mVertexBuffer;// �����������ݻ���
		private FloatBuffer mTextureBuffer;// ������
		public float mAngleX;// ��x����ת�Ƕ�
		public float mAngleY;// ��y����ת�Ƕ�
		public float mAngleZ;// ��z����ת�Ƕ�
		int vCount = 0;

		// float a;//����뾶��
		// float b;
		// float c;
		// float angleSpan;//������е�λ�зֵĽǶ�
		// float hAngleBegin;//���Ȼ�����ʼ�Ƕ�
		// float hAngleOver;//���Ȼ��ƽ����Ƕ�
		// float vAngleBegin;//γ�Ȼ�����ʼ�Ƕ�
		// float vAngleOver;//γ�Ȼ��ƽ����Ƕ�
		// hAngle��ʾ���ȣ�vAngle��ʾγ�ȡ�
		public DrawSpheroid(float a, float b, float c, float angleSpan,
				float hAngleBegin, float hAngleOver, float vAngleBegin,
				float vAngleOver) {
			ArrayList<Float> alVertix = new ArrayList<Float>();// ��Ŷ�������

			for (float vAngle = vAngleBegin; vAngle < vAngleOver; vAngle = vAngle
					+ angleSpan)// ��ֱ����angleSpan��һ��
			{
				for (float hAngle = hAngleBegin; hAngle < hAngleOver; hAngle = hAngle
						+ angleSpan)// ˮƽ����angleSpan��һ��
				{// ����������һ���ǶȺ�����Ӧ�Ĵ˵��������ϵ�����
					float x1 = (float) (a * Math.cos(Math.toRadians(vAngle)) * Math
							.cos(Math.toRadians(hAngle)));
					float y1 = (float) (b * Math.cos(Math.toRadians(vAngle)) * Math
							.sin(Math.toRadians(hAngle)));
					float z1 = (float) (c * Math.sin(Math.toRadians(vAngle)));

					float x2 = (float) (a
							* Math.cos(Math.toRadians(vAngle + angleSpan)) * Math
							.cos(Math.toRadians(hAngle)));
					float y2 = (float) (b
							* Math.cos(Math.toRadians(vAngle + angleSpan)) * Math
							.sin(Math.toRadians(hAngle)));
					float z2 = (float) (c * Math.sin(Math.toRadians(vAngle
							+ angleSpan)));

					float x3 = (float) (a
							* Math.cos(Math.toRadians(vAngle + angleSpan)) * Math
							.cos(Math.toRadians(hAngle + angleSpan)));
					float y3 = (float) (b
							* Math.cos(Math.toRadians(vAngle + angleSpan)) * Math
							.sin(Math.toRadians(hAngle + angleSpan)));
					float z3 = (float) (c * Math.sin(Math.toRadians(vAngle
							+ angleSpan)));

					float x4 = (float) (a * Math.cos(Math.toRadians(vAngle)) * Math
							.cos(Math.toRadians(hAngle + angleSpan)));
					float y4 = (float) (b * Math.cos(Math.toRadians(vAngle)) * Math
							.sin(Math.toRadians(hAngle + angleSpan)));
					float z4 = (float) (c * Math.sin(Math.toRadians(vAngle)));

					// �����������XYZ��������Ŷ��������ArrayList
					alVertix.add(x1);
					alVertix.add(y1);
					alVertix.add(z1);
					alVertix.add(x2);
					alVertix.add(y2);
					alVertix.add(z2);
					alVertix.add(x4);
					alVertix.add(y4);
					alVertix.add(z4);

					alVertix.add(x4);
					alVertix.add(y4);
					alVertix.add(z4);
					alVertix.add(x2);
					alVertix.add(y2);
					alVertix.add(z2);
					alVertix.add(x3);
					alVertix.add(y3);
					alVertix.add(z3);
				}
			}
			vCount = alVertix.size() / 3;// ���������Ϊ����ֵ������1/3����Ϊһ��������3������

			// ��alVertix�е�����ֵת�浽һ��int������
			float[] vertices = new float[vCount * 3];
			for (int i = 0; i < alVertix.size(); i++) {
				vertices[i] = alVertix.get(i);
			}
			// ���������������ݻ���
			// vertices.length*4����Ϊһ�������ĸ��ֽ�
			ByteBuffer vbb = ByteBuffer.allocateDirect(vertices.length * 4);
			vbb.order(ByteOrder.nativeOrder());// �����ֽ�˳��
			mVertexBuffer = vbb.asFloatBuffer();// ת��Ϊint�ͻ���
			mVertexBuffer.put(vertices);// �򻺳����з��붥����������
			mVertexBuffer.position(0);// ���û�������ʼλ��

			// ����

			// ��ȡ�з���ͼ����������
			float[] texCoorArray = generateTexCoor(
					(int) ((hAngleOver - hAngleBegin) / angleSpan), // ����ͼ�зֵ�����
					(int) ((vAngleOver - vAngleBegin) / angleSpan) // ����ͼ�зֵ�����
			);

			ByteBuffer tbb = ByteBuffer.allocateDirect(texCoorArray.length * 4);
			tbb.order(ByteOrder.nativeOrder());
			mTextureBuffer = tbb.asFloatBuffer();
			mTextureBuffer.put(texCoorArray);
			mTextureBuffer.position(0);
		}

		public void drawSelf(GL10 gl, int textureId) {
			gl.glRotatef(mAngleZ, 0, 0, 1);// ��Z����ת
			gl.glRotatef(mAngleY, 0, 1, 0);// ��Y����ת
			gl.glRotatef(mAngleX, 1, 0, 0);// ��X����ת

			gl.glEnableClientState(GL10.GL_VERTEX_ARRAY);

			// Ϊ����ָ��������������
			gl.glVertexPointer(3, // ÿ���������������Ϊ3
					GL10.GL_FLOAT, // ��������ֵ������
					0, // ����������������֮��ļ��
					mVertexBuffer // ������������
			);

			gl.glEnable(GL10.GL_TEXTURE_2D);
			gl.glEnableClientState(GL10.GL_TEXTURE_COORD_ARRAY);
			gl.glTexCoordPointer(2, GL10.GL_FLOAT, 0, mTextureBuffer);
			gl.glBindTexture(GL10.GL_TEXTURE_2D, textureId);

			// ����ͼ��
			gl.glDrawArrays(GL10.GL_TRIANGLES, 0, vCount);// ����ͼ��

			gl.glDisableClientState(GL10.GL_TEXTURE_COORD_ARRAY);// �رջ���
			gl.glEnable(GL10.GL_TEXTURE_2D);
			gl.glDisableClientState(GL10.GL_VERTEX_ARRAY);
		}

		// �Զ��з����������������ķ���
		public float[] generateTexCoor(int bw, int bh) {
			float[] result = new float[bw * bh * 6 * 2];
			float sizew = 1.0f / bw;// ����
			float sizeh = 1.0f / bh;// ����
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

					result[c++] = s + sizew;
					result[c++] = t;

					result[c++] = s;
					result[c++] = t + sizeh;

					result[c++] = s + sizew;
					result[c++] = t + sizeh;
				}
			}
			return result;
		}
	}

	// ���ƻ����ڲ���
	private class DrawWing {
		private FloatBuffer mVertexBuffer;// �����������ݻ���
		private FloatBuffer mTexBuffer;// ������ɫ���ݻ���
		int vCount = 0;// ��������

		public DrawWing(float hWidth, float hLength, float lWidth,
				float lLength, float height) {
			// ����
			vCount = 36;
			float vertices[] = new float[] { -hWidth / 2, height / 2,
					-hLength / 2, lWidth / 2, -height / 2, -lLength / 2,
					-lWidth / 2, -height / 2, -lLength / 2,

					-hWidth / 2, height / 2, -hLength / 2, hWidth / 2,
					height / 2, -hLength / 2, lWidth / 2, -height / 2,
					-lLength / 2,

					-lWidth / 2, -height / 2, -lLength / 2, -lWidth / 2,
					-height / 2, lLength / 2, -hWidth / 2, height / 2,
					hLength / 2,

					-lWidth / 2, -height / 2, -lLength / 2, -hWidth / 2,
					height / 2, hLength / 2, -hWidth / 2, height / 2,
					-hLength / 2,

					-hWidth / 2, height / 2, -hLength / 2, -hWidth / 2,
					height / 2, hLength / 2, hWidth / 2, height / 2,
					hLength / 2,

					-hWidth / 2, height / 2, -hLength / 2, hWidth / 2,
					height / 2, hLength / 2, hWidth / 2, height / 2,
					-hLength / 2,

					hWidth / 2, height / 2, -hLength / 2, hWidth / 2,
					height / 2, hLength / 2, lWidth / 2, -height / 2,
					lLength / 2,

					hWidth / 2, height / 2, -hLength / 2, lWidth / 2,
					-height / 2, lLength / 2, lWidth / 2, -height / 2,
					-lLength / 2,

					-hWidth / 2, height / 2, hLength / 2, -lWidth / 2,
					-height / 2, lLength / 2, lWidth / 2, -height / 2,
					lLength / 2,

					-hWidth / 2, height / 2, hLength / 2, lWidth / 2,
					-height / 2, lLength / 2, hWidth / 2, height / 2,
					hLength / 2,

					-lWidth / 2, -height / 2, lLength / 2, -lWidth / 2,
					-height / 2, -lLength / 2, lWidth / 2, -height / 2,
					lLength / 2,

					-lWidth / 2, -height / 2, -lLength / 2, lWidth / 2,
					-height / 2, -lLength / 2, lWidth / 2, -height / 2,
					lLength / 2 };
			ByteBuffer vbb = ByteBuffer.allocateDirect(vertices.length * 4);
			vbb.order(ByteOrder.nativeOrder());// �����ֽ�˳��
			mVertexBuffer = vbb.asFloatBuffer();// ת��Ϊint�ͻ���
			mVertexBuffer.put(vertices);// �򻺳����з��붥����������
			mVertexBuffer.position(0);// ���û�������ʼλ��

			// ��������
			float[] texCoor = new float[] { 1, 0, 0, 1, 1, 1,

			1, 0, 0, 0, 0, 1,

			0, 1, 1, 1, 1, 0,

			0, 1, 1, 0, 0, 0,

			0, 0, 0, 1, 1, 1,

			0, 0, 1, 1, 1, 0,

			1, 0, 0, 0, 0, 1,

			1, 0, 0, 1, 1, 1,

			0, 0, 0, 1, 1, 1,

			0, 0, 1, 1, 1, 0,

			0, 0, 0, 1, 1, 0,

			0, 1, 1, 1, 1, 0 };
			// ���������������ݻ���
			ByteBuffer cbb = ByteBuffer.allocateDirect(texCoor.length * 4);
			cbb.order(ByteOrder.nativeOrder());// �����ֽ�˳��
			mTexBuffer = cbb.asFloatBuffer();// ת��Ϊint�ͻ���
			mTexBuffer.put(texCoor);// �򻺳����з��붥����ɫ����
			mTexBuffer.position(0);// ���û�������ʼλ��
		}

		public void drawSelf(GL10 gl, int texId) {
			gl.glEnableClientState(GL10.GL_VERTEX_ARRAY);// ���ö�����������
			gl.glVertexPointer// Ϊ����ָ��������������
			(3, // ÿ���������������Ϊ3 xyz
					GL10.GL_FLOAT, // ��������ֵ������Ϊ GL_FIXED
					0, // ����������������֮��ļ��
					mVertexBuffer // ������������
			);

			// ��������
			gl.glEnable(GL10.GL_TEXTURE_2D);
			// ����ʹ������ST���껺��
			gl.glEnableClientState(GL10.GL_TEXTURE_COORD_ARRAY);
			// Ϊ����ָ������ST���껺��
			gl.glTexCoordPointer(2, GL10.GL_FLOAT, 0, mTexBuffer);
			// �󶨵�ǰ����
			gl.glBindTexture(GL10.GL_TEXTURE_2D, texId);

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

	// ��ͧ�˶��߳�
	public class goThread extends Thread {
		public boolean flag = true;// ��ͧ�˶���־λ

		public void run() {
			while (flag) {
				angle = angle - 0.2f;
				angleY = angleY + 30;
				angleRotate = angleRotate + 0.2f;
				if (angle <= 0) {
					angle = 360;
				}
				if (angleY >= 360) {
					angleY = 0;
				}
				if (angleRotate >= 360) {
					angleRotate = 0;
				}
				try {
					Thread.sleep(100);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}
}
