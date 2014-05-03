package race.cheng.graphics;

import static race.cheng.service.Constant.CAR_MAX_SPEED;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;

import javax.microedition.khronos.opengles.GL10;

/**
 * �����Ǳ���
 * 
 * @author chengkai
 * 
 */
public class DrawPanel extends Shape {
	private final float PANELLENGTH = 0.6f;// �Ǳ��̵ĳ���
	private final float PANELHEIGHT = 0.5f;// �Ǳ��̵ĸ߶�
	private final float POINTER = 0.2f;// ָ��ĳ���
	private final float POINTER_H = 0.011f;// ָ��ĸ߶�

	Panel panel;
	Pointer pointer;
	float angle = 60;// ָ��ĳ�ʼλ��
	float zAngle = 60;// ָ��Ƕ�

	public DrawPanel(float scale) {
		super(scale);
		panel = new Panel(scale);
		pointer = new Pointer(scale);
	}

	@Override
	public void drawSelf(GL10 gl, int texId, int number) {
		gl.glPushMatrix();// ������
		panel.drawSelf(gl, texId);
		gl.glPopMatrix();

		gl.glPushMatrix();// ����ָ��
		gl.glTranslatef(0f, 0f, 0.05f);
		gl.glRotatef(zAngle, 0, 0, 1);
		pointer.drawSelf(gl, texId);
		gl.glPopMatrix();

	}

	public void changepointer(float v)// ָ��Ƕ�ת�ķ���
	{
		// ***********ÿ����0.6km/h��zAngle����1��**************
		float vSpan = CAR_MAX_SPEED * 1.3f / 267;// ÿһ�Ǳ���ָ��Ƕ�����ʾ�ĳ���
		if (v <= CAR_MAX_SPEED * 1.3f && v >= 0) {
			float v_Angle = v / vSpan;
			zAngle = angle - v_Angle;
		}

	}

	private class Panel {
		private FloatBuffer vertexBuffer;// ����Buffer
		private FloatBuffer textureBuffer;// ��������Buffer
		private int vCount = 0;// ������

		public Panel(float scale) {
			float[] vertice = new float[] {// ��Ŷ������������
			-PANELLENGTH / 2 * scale, PANELHEIGHT / 2 * scale, 0,
					-PANELLENGTH / 2 * scale, -PANELHEIGHT / 2 * scale, 0,
					PANELLENGTH / 2 * scale, PANELHEIGHT / 2 * scale, 0,

					PANELLENGTH / 2 * scale, PANELHEIGHT / 2 * scale, 0,
					-PANELLENGTH / 2 * scale, -PANELHEIGHT / 2 * scale, 0,
					PANELLENGTH / 2 * scale, -PANELHEIGHT / 2 * scale, 0,

			};
			vCount = vertice.length / 3;// ��������

			ByteBuffer vbb = ByteBuffer.allocateDirect(vertice.length * 4);
			vbb.order(ByteOrder.nativeOrder());
			vertexBuffer = vbb.asFloatBuffer();
			vertexBuffer.put(vertice);
			vertexBuffer.position(0);
			float[] textures = new float[] { 0.07f, 0.14f, 0.07f, 1, 0.93f,
					0.14f,

					0.93f, 0.14f, 0.07f, 1, 0.93f, 1 };
			ByteBuffer tbb = ByteBuffer.allocateDirect(textures.length * 4);
			tbb.order(ByteOrder.nativeOrder());
			textureBuffer = tbb.asFloatBuffer();
			textureBuffer.put(textures);
			textureBuffer.position(0);
		}

		public void drawSelf(GL10 gl, int texId) {
			gl.glEnableClientState(GL10.GL_VERTEX_ARRAY);// ������������
			gl.glVertexPointer(3, GL10.GL_FLOAT, 0, vertexBuffer);

			gl.glEnable(GL10.GL_TEXTURE_2D);// ��������
			gl.glEnableClientState(GL10.GL_TEXTURE_COORD_ARRAY);// ������������
			gl.glTexCoordPointer(2, GL10.GL_FLOAT, 0, textureBuffer);
			gl.glBindTexture(GL10.GL_TEXTURE_2D, texId);// ������
			gl.glDrawArrays(GL10.GL_TRIANGLES, 0, vCount);

			gl.glDisable(GL10.GL_TEXTURE_2D);// �ر�����
			gl.glDisableClientState(GL10.GL_TEXTURE_COORD_ARRAY);// �ر���������

		}
	}

	private class Pointer// ����ָ����ڲ���
	{

		private FloatBuffer vertexBuffer;// ����Buffer
		private FloatBuffer textureBuffer;// ��������Buffer
		private int vCount = 0;// ������

		public Pointer(float scale) {
			float[] vertice = new float[] {// ��Ŷ������������
			-POINTER * scale, POINTER_H / 2 * scale, 0, -POINTER * scale,
					-POINTER_H / 2 * scale, 0, 0, POINTER_H / 2 * scale, 0,

					0, POINTER_H / 2 * scale, 0, -POINTER * scale,
					-POINTER_H / 2 * scale, 0, 0, -POINTER_H / 2 * scale, 0 };
			vCount = vertice.length / 3;// ��������

			ByteBuffer vbb = ByteBuffer.allocateDirect(vertice.length * 4);
			vbb.order(ByteOrder.nativeOrder());
			vertexBuffer = vbb.asFloatBuffer();
			vertexBuffer.put(vertice);
			vertexBuffer.position(0);

			float textures[] = new float[] { 0, 0, 0, 0.125f, 0.5f, 0,

			0.5f, 0, 0, 0.125f, 0.5f, 0.125f };
			ByteBuffer tbb = ByteBuffer.allocateDirect(textures.length * 4);
			tbb.order(ByteOrder.nativeOrder());
			textureBuffer = tbb.asFloatBuffer();
			textureBuffer.put(textures);
			textureBuffer.position(0);
		}

		public void drawSelf(GL10 gl, int texId) {
			gl.glEnableClientState(GL10.GL_VERTEX_ARRAY);// ������������
			gl.glVertexPointer(3, GL10.GL_FLOAT, 0, vertexBuffer);

			gl.glEnable(GL10.GL_TEXTURE_2D);// ��������
			gl.glEnableClientState(GL10.GL_TEXTURE_COORD_ARRAY);// ������������
			gl.glTexCoordPointer(2, GL10.GL_FLOAT, 0, textureBuffer);
			gl.glBindTexture(GL10.GL_TEXTURE_2D, texId);// ������
			gl.glDrawArrays(GL10.GL_TRIANGLES, 0, vCount);

			gl.glDisable(GL10.GL_TEXTURE_2D);// �ر�����
			gl.glDisableClientState(GL10.GL_TEXTURE_COORD_ARRAY);// �ر���������
		}
	}
}
