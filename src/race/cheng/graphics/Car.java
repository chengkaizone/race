package race.cheng.graphics;

import static race.cheng.service.Constant.MAP_LEVEL1;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.util.ArrayList;

import javax.microedition.khronos.opengles.GL10;

public class Car {
	// ��뾶
	public final static float RADIUS = DrawMiniMap.MAP_LENGHT
			/ MAP_LEVEL1[0].length / 2;// ��뾶
	public final static float ANGLE_SPAN = 18;// ���и�ߴ�

	int count = 0;// ����
	public float scale;// �ߴ�
	DrawBall car;// С��
	DrawBall carBig;// ��

	public static boolean flag = true;// ��С�������̱߳�־λ

	public static LightTurn lt;// ���ƴ�С�����Ƶ��߳�

	public Car(float scale) {
		this.scale = scale;
		car = new DrawBall(1 * scale);
		carBig = new DrawBall(2 * scale);
		lt = new LightTurn();
	}

	public void drawSelf(GL10 gl) {
		// count�ܱ�2�����ͻ��ƴ󳵣��������С��
		if (count % 2 == 0) {
			gl.glPushMatrix();
			float[] directionParams = { 0, 35f, 35f, 0 };
			gl.glLightfv(GL10.GL_LIGHT0, GL10.GL_POSITION, directionParams, 0);
			initMaterial(gl, 1, 0, 0, 1);// ��ʼ������
			// gl.glTranslatef(-MiniMap.MAP_LENGHT+3*scale*MiniMap.WIDTH+scale*RADIUS,
			// MiniMap.MAP_HEIGHT-3*scale*MiniMap.HEIGHT-scale*RADIUS, 0);
			initLight(gl, 1, 1, 1, 1);// ����
			car.drawSelf(gl);
			closeLight(gl);// �ص�
			gl.glPopMatrix();
		} else {
			gl.glPushMatrix();
			float[] directionParams = { 0, 35f, 35f, 0 };
			gl.glLightfv(GL10.GL_LIGHT0, GL10.GL_POSITION, directionParams, 0);
			initMaterial(gl, 1, 0, 0, 1);// ��ʼ������
			// gl.glTranslatef(-MiniMap.MAP_LENGHT+3*scale*MiniMap.WIDTH+scale*RADIUS,
			// MiniMap.MAP_HEIGHT-3*scale*MiniMap.HEIGHT-scale*RADIUS, 0);
			initLight(gl, 1, 1, 1, 1);// ����
			carBig.drawSelf(gl);
			closeLight(gl);// �ص�
			gl.glPopMatrix();
		}
	}

	// ���ƴ�С�����Ƶ��߳�
	public class LightTurn extends Thread {
		public LightTurn() {
		}

		@Override
		public void run() {
			while (flag) {
				try {
					count += 1;
					sleep(500);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}

	// ��ʼ����
	private void initLight(GL10 gl, float r, float g, float b, float a) {
		gl.glEnable(GL10.GL_LIGHTING);// �������
		gl.glEnable(GL10.GL_LIGHT0);// ��0�ŵ�

		// ����������
		float[] ambientParams = { 0.2f * r, 0.2f * g, 0.2f * b, 1.0f * a };// �����
																			// RGBA
		gl.glLightfv(GL10.GL_LIGHT0, GL10.GL_AMBIENT, ambientParams, 0);

		// ɢ�������
		float[] diffuseParams = { 1f * r, 1f * g, 1f * b, 1.0f * a };// ����� RGBA
		gl.glLightfv(GL10.GL_LIGHT0, GL10.GL_DIFFUSE, diffuseParams, 0);

		// ���������
		float[] specularParams = { 1f * r, 1f * g, 1f * b, 1.0f * a };// �����
																		// RGBA
		gl.glLightfv(GL10.GL_LIGHT0, GL10.GL_SPECULAR, specularParams, 0);
	}

	// �رյ�
	private void closeLight(GL10 gl) {
		gl.glDisable(GL10.GL_LIGHT0);
		gl.glDisable(GL10.GL_LIGHTING);
	}

	// ��ʼ������
	private void initMaterial(GL10 gl, float r, float g, float b, float a) {
		// ������
		float ambientMaterial[] = { 1 * r, 1 * g, 1 * b, 1.0f * a };
		gl.glMaterialfv(GL10.GL_FRONT_AND_BACK, GL10.GL_AMBIENT,
				ambientMaterial, 0);
		// ɢ���
		float diffuseMaterial[] = { 1 * r, 1 * g, 1 * b, 1.0f * a };
		gl.glMaterialfv(GL10.GL_FRONT_AND_BACK, GL10.GL_DIFFUSE,
				diffuseMaterial, 0);
		// �߹����
		float specularMaterial[] = { 1 * r, 1 * g, 1 * b, 1.0f * a };
		gl.glMaterialfv(GL10.GL_FRONT_AND_BACK, GL10.GL_SPECULAR,
				specularMaterial, 0);
		gl.glMaterialf(GL10.GL_FRONT_AND_BACK, GL10.GL_SHININESS, 100.0f);
	}

	private class DrawBall {
		private FloatBuffer mVertexBuffer;// �����������ݻ���
		private FloatBuffer mNormalBuffer;// �����������ݻ���
		int vCount = 0;// ��������

		public DrawBall(float scale) {
			ArrayList<Float> alVertix = new ArrayList<Float>();// ��Ŷ��������ArrayList

			for (float vAngle = 90; vAngle > -90; vAngle = vAngle - ANGLE_SPAN)// ��ֱ����angleSpan��һ��
			{
				for (float hAngle = 360; hAngle > 0; hAngle = hAngle
						- ANGLE_SPAN)// ˮƽ����angleSpan��һ��
				{
					// ����������һ���ǶȺ�����Ӧ�Ĵ˵��������ϵ��ı��ζ�������
					// ��������������ı��ε�������

					double xozLength = scale * RADIUS
							* Math.cos(Math.toRadians(vAngle));
					float x1 = (float) (xozLength * Math.cos(Math
							.toRadians(hAngle)));
					float z1 = (float) (xozLength * Math.sin(Math
							.toRadians(hAngle)));
					float y1 = (float) (scale * RADIUS * Math.sin(Math
							.toRadians(vAngle)));

					xozLength = scale * RADIUS
							* Math.cos(Math.toRadians(vAngle - ANGLE_SPAN));
					float x2 = (float) (xozLength * Math.cos(Math
							.toRadians(hAngle)));
					float z2 = (float) (xozLength * Math.sin(Math
							.toRadians(hAngle)));
					float y2 = (float) (scale * RADIUS * Math.sin(Math
							.toRadians(vAngle - ANGLE_SPAN)));

					xozLength = scale * RADIUS
							* Math.cos(Math.toRadians(vAngle - ANGLE_SPAN));
					float x3 = (float) (xozLength * Math.cos(Math
							.toRadians(hAngle - ANGLE_SPAN)));
					float z3 = (float) (xozLength * Math.sin(Math
							.toRadians(hAngle - ANGLE_SPAN)));
					float y3 = (float) (scale * RADIUS * Math.sin(Math
							.toRadians(vAngle - ANGLE_SPAN)));

					xozLength = scale * RADIUS
							* Math.cos(Math.toRadians(vAngle));
					float x4 = (float) (xozLength * Math.cos(Math
							.toRadians(hAngle - ANGLE_SPAN)));
					float z4 = (float) (xozLength * Math.sin(Math
							.toRadians(hAngle - ANGLE_SPAN)));
					float y4 = (float) (scale * RADIUS * Math.sin(Math
							.toRadians(vAngle)));

					// ������һ������
					alVertix.add(x1);
					alVertix.add(y1);
					alVertix.add(z1);
					alVertix.add(x2);
					alVertix.add(y2);
					alVertix.add(z2);
					alVertix.add(x4);
					alVertix.add(y4);
					alVertix.add(z4);
					// �����ڶ�������
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
			float vertices[] = new float[vCount * 3];
			for (int i = 0; i < alVertix.size(); i++) {
				vertices[i] = alVertix.get(i);
			}

			// �������ƶ������ݻ���
			ByteBuffer vbb = ByteBuffer.allocateDirect(vertices.length * 4);
			vbb.order(ByteOrder.nativeOrder());// �����ֽ�˳��
			mVertexBuffer = vbb.asFloatBuffer();// ת��Ϊint�ͻ���
			mVertexBuffer.put(vertices);// �򻺳����з��붥����������
			mVertexBuffer.position(0);// ���û�������ʼλ��

			// �������㷨�������ݻ���
			// vertices.length*4����Ϊһ��float�ĸ��ֽ�
			ByteBuffer nbb = ByteBuffer.allocateDirect(vertices.length * 4);
			nbb.order(ByteOrder.nativeOrder());// �����ֽ�˳��
			mNormalBuffer = vbb.asFloatBuffer();// ת��Ϊint�ͻ���
			mNormalBuffer.put(vertices);// �򻺳����з��붥����������
			mNormalBuffer.position(0);// ���û�������ʼλ��
		}

		public void drawSelf(GL10 gl) {
			gl.glEnableClientState(GL10.GL_VERTEX_ARRAY);// �򿪶��㻺��
			gl.glVertexPointer(3, GL10.GL_FLOAT, 0, mVertexBuffer);// ָ�����㻺��

			gl.glEnableClientState(GL10.GL_NORMAL_ARRAY);// �򿪷���������
			gl.glNormalPointer(GL10.GL_FLOAT, 0, mNormalBuffer);// ָ������������

			gl.glDrawArrays(GL10.GL_TRIANGLES, 0, vCount);// ����ͼ��

			gl.glDisableClientState(GL10.GL_VERTEX_ARRAY);// �رջ���
			gl.glDisableClientState(GL10.GL_NORMAL_ARRAY);
		}
	}
}
