package race.cheng.graphics;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;

import javax.microedition.khronos.opengles.GL10;

/**
 * ũ�������
 * 
 * @author chengkai
 * 
 */
public class DrawHouse extends Shape {
	public static final float HOUSE_WIDTH = 10.13f;// ���ӵĿ��
	public static final float HOUSE_HEIGHT = 10f;// ���ӵĸ߶�
	public static final float HOUSE_HEIGHT_DOWN = 5.95f;// ���θ߶�
	public static final float HOUSE_HEIGHT_UP = (HOUSE_HEIGHT - HOUSE_HEIGHT_DOWN);// �����θ߶�
	public static final float HOUSE_LENGTH = 1.5f * HOUSE_WIDTH;// ���ӵĳ���
	public static final float ROOF_TIMES = 1.25f;// �ݶ���Ⱥ����ӿ�ȵı���
	public static final float ROOF_TIMES_LENGTH = 1.1f;// �ݶ����Ⱥ����ӳ��ȵ�

	public static final float ROOF_WIDTH_TIMES = 0.8f;// �ݶ��ĺ��
	public static final float ROOF_WIDTH = 0.9f;// �ݶ��϶��浽�¶���ĺ��

	House_Front houseFront;// ����ǰ��
	House_Right houseRight;// �����Ҳ�
	House_Left houseLeft;// ���ӵ����
	House_Roof houseRoof;// �ݶ�
	public float yAngle;

	public DrawHouse(float scale) {
		super(scale);
		houseFront = new House_Front(scale);
		houseRight = new House_Right(scale);
		houseLeft = new House_Left(scale);
		houseRoof = new House_Roof(scale);
	}

	@Override
	public void drawSelf(GL10 gl, int texId, int number) {
		gl.glRotatef(yAngle, 0, 1, 0);
		// ���Ʒ���ǰ��
		gl.glPushMatrix();
		gl.glTranslatef(0, 0, HOUSE_LENGTH / 2 * scale);
		houseFront.drawSelf(gl, texId, 0);
		gl.glPopMatrix();
		// ���Ʒ�������
		gl.glPushMatrix();
		gl.glTranslatef(HOUSE_WIDTH / 2 * scale, HOUSE_HEIGHT_DOWN / 2 * scale,
				HOUSE_LENGTH / 2 * scale);
		gl.glRotatef(-90, 0, 0, 1);
		houseRight.drawSelf(gl, texId);
		gl.glPopMatrix();
		// ���Ʒ�������
		gl.glPushMatrix();
		gl.glTranslatef(-HOUSE_WIDTH / 2 * scale,
				HOUSE_HEIGHT_DOWN / 2 * scale, HOUSE_LENGTH / 2 * scale);
		gl.glRotatef(90, 0, 0, 1);
		houseLeft.drawSelf(gl, texId);
		gl.glPopMatrix();
		// ���Ʒ��Ӻ���
		gl.glPushMatrix();
		gl.glTranslatef(0, 0, HOUSE_LENGTH / 2 * scale - HOUSE_LENGTH * scale);
		gl.glRotatef(180, 0, 1, 0);
		houseFront.drawSelf(gl, texId, 1);
		gl.glPopMatrix();
		// �����ݶ�
		gl.glPushMatrix();
		gl.glTranslatef(0, (HOUSE_HEIGHT + ROOF_WIDTH) * scale,
				(HOUSE_LENGTH * ROOF_TIMES_LENGTH) / 2 * scale);
		houseRoof.drawSelf(gl, texId);
		gl.glPopMatrix();
	}

	private class House_Front {// ����ǰ�沿�ֵ��ڲ���
		private FloatBuffer vertexBuffer;// ����Buffer
		private FloatBuffer[] textureBuffer;// ��������Buffer
		private int vCount = 0;// ������

		public House_Front(float scale) {
			float[] vertice = new float[] {// ��Ŷ������������
			0, HOUSE_HEIGHT * scale, 0, -HOUSE_WIDTH / 2 * scale,
					HOUSE_HEIGHT_DOWN * scale, 0, HOUSE_WIDTH / 2 * scale,
					HOUSE_HEIGHT_DOWN * scale, 0,

					-HOUSE_WIDTH / 2 * scale, HOUSE_HEIGHT_DOWN * scale, 0,
					-HOUSE_WIDTH / 2 * scale, 0, 0, HOUSE_WIDTH / 2 * scale,
					HOUSE_HEIGHT_DOWN * scale, 0,

					HOUSE_WIDTH / 2 * scale, HOUSE_HEIGHT_DOWN * scale, 0,
					-HOUSE_WIDTH / 2 * scale, 0, 0, HOUSE_WIDTH / 2 * scale, 0,
					0 };
			vCount = vertice.length / 3;// ��������

			ByteBuffer vbb = ByteBuffer.allocateDirect(vertice.length * 4);
			vbb.order(ByteOrder.nativeOrder());
			vertexBuffer = vbb.asFloatBuffer();
			vertexBuffer.put(vertice);
			vertexBuffer.position(0);

			float[][] textures = new float[][] { {// ���ӵ�ǰǽ
					0.75f, 0, 0.5f, 0.203f, 1, 0.203f,

					0.5f, 0.203f, 0.5f, 0.5f, 1, 0.203f,

					1, 0.203f, 0.5f, 0.5f, 1, 0.5f }, {// ���ӵĺ�ǽ
					0.25f, 0, 0, 0.203f, 0.5f, 0.203f,

					0, 0.203f, 0, 0.5f, 0.5f, 0.203f,

					0.5f, 0.203f, 0, 0.5f, 0.5f, 0.5f }

			};
			textureBuffer = new FloatBuffer[2];
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

	private class House_Right {// ���Ʒ����Ҳ�
		private FloatBuffer vertexBuffer;// ����Buffer
		private FloatBuffer textureBuffer;// ��������Buffer
		private int vCount = 0;// ������

		public House_Right(float scale) {
			float[] vertice = new float[] {// ��Ŷ������������
			-HOUSE_HEIGHT_DOWN / 2 * scale, 0, -HOUSE_LENGTH * scale,
					-HOUSE_HEIGHT_DOWN / 2 * scale, 0, 0,
					HOUSE_HEIGHT_DOWN / 2 * scale, 0, -HOUSE_LENGTH * scale,

					HOUSE_HEIGHT_DOWN / 2 * scale, 0, -HOUSE_LENGTH * scale,
					-HOUSE_HEIGHT_DOWN / 2 * scale, 0, 0,
					HOUSE_HEIGHT_DOWN / 2 * scale, 0, 0 };
			vCount = vertice.length / 3;// ��������

			ByteBuffer vbb = ByteBuffer.allocateDirect(vertice.length * 4);
			vbb.order(ByteOrder.nativeOrder());
			vertexBuffer = vbb.asFloatBuffer();
			vertexBuffer.put(vertice);
			vertexBuffer.position(0);

			float[] textures = new float[] {

			1, 0.5f, 0, 0.5f, 1, 1,

			1, 1, 0, 0.5f, 0, 1

			};
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

	private class House_Left {// ���Ʒ������
		private FloatBuffer vertexBuffer;// ����Buffer
		private FloatBuffer textureBuffer;// ��������Buffer
		private int vCount = 0;// ������

		public House_Left(float scale) {
			float[] vertice = new float[] {// ��Ŷ������������
			-HOUSE_HEIGHT_DOWN / 2 * scale, 0, -HOUSE_LENGTH * scale,
					-HOUSE_HEIGHT_DOWN / 2 * scale, 0, 0,
					HOUSE_HEIGHT_DOWN / 2 * scale, 0, -HOUSE_LENGTH * scale,

					HOUSE_HEIGHT_DOWN / 2 * scale, 0, -HOUSE_LENGTH * scale,
					-HOUSE_HEIGHT_DOWN / 2 * scale, 0, 0,
					HOUSE_HEIGHT_DOWN / 2 * scale, 0, 0 };
			vCount = vertice.length / 3;// ��������

			ByteBuffer vbb = ByteBuffer.allocateDirect(vertice.length * 4);
			vbb.order(ByteOrder.nativeOrder());
			vertexBuffer = vbb.asFloatBuffer();
			vertexBuffer.put(vertice);
			vertexBuffer.position(0);

			float[] textures = new float[] {

			0, 1, 1, 1, 0, 0.5f,

			0, 0.5f, 1, 1, 1, 0.5f

			};
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

	private class House_Roof {// �������ڲ���
		private FloatBuffer vertexBuffer;// ����Buffer
		private FloatBuffer textureBuffer;// ��������Buffer
		private int vCount = 0;// ������

		public House_Roof(float scale) {
			float[] vertice = new float[] {// ��Ŷ������������
					// �϶���
					0,
					0,
					-HOUSE_LENGTH * scale * ROOF_TIMES_LENGTH,// 1
					-HOUSE_WIDTH / 2 * ROOF_TIMES * scale,
					-HOUSE_HEIGHT_UP * ROOF_TIMES * scale,
					-HOUSE_LENGTH * ROOF_TIMES_LENGTH * scale,// 2
					-HOUSE_WIDTH / 2 * ROOF_TIMES * scale,
					-HOUSE_HEIGHT_UP * ROOF_TIMES * scale,
					0,// 3

					0,
					0,
					-HOUSE_LENGTH * scale * ROOF_TIMES_LENGTH,// 1
					-HOUSE_WIDTH / 2 * ROOF_TIMES * scale,
					-HOUSE_HEIGHT_UP * ROOF_TIMES * scale,
					0,// 3
					0,
					0,
					0,// 4

					0,
					0,
					-HOUSE_LENGTH * scale * ROOF_TIMES_LENGTH,// 1
					0,
					0,
					0,// 4
					HOUSE_WIDTH / 2 * ROOF_TIMES * scale,
					-HOUSE_HEIGHT_UP * ROOF_TIMES * scale,
					-HOUSE_LENGTH * scale * ROOF_TIMES_LENGTH,// 6

					HOUSE_WIDTH / 2 * ROOF_TIMES * scale,
					-HOUSE_HEIGHT_UP * ROOF_TIMES * scale,
					-HOUSE_LENGTH * scale * ROOF_TIMES_LENGTH,// 6
					0,
					0,
					0,// 4
					HOUSE_WIDTH / 2 * ROOF_TIMES * scale,
					-HOUSE_HEIGHT_UP * ROOF_TIMES * scale,
					0,// 5
						// �ݶ�ǰ��
						// ���
					-HOUSE_WIDTH / 2 * ROOF_TIMES * scale,
					-HOUSE_HEIGHT_UP * ROOF_TIMES * scale,
					0,
					-HOUSE_WIDTH / 2 * ROOF_TIMES * ROOF_WIDTH_TIMES * scale,
					-HOUSE_HEIGHT_UP * ROOF_TIMES * scale,
					0,
					0,
					0,
					0,

					-HOUSE_WIDTH / 2 * ROOF_TIMES * ROOF_WIDTH_TIMES * scale,
					-HOUSE_HEIGHT_UP * ROOF_TIMES * scale,
					0,
					0,
					-ROOF_WIDTH * scale,
					0,
					0,
					0,
					0,
					// �Ҳ�
					0,
					-ROOF_WIDTH * scale,
					0,
					HOUSE_WIDTH / 2 * ROOF_TIMES * ROOF_WIDTH_TIMES * scale,
					-HOUSE_HEIGHT_UP * ROOF_TIMES * scale,
					0,
					HOUSE_WIDTH / 2 * ROOF_TIMES * scale,
					-HOUSE_HEIGHT_UP * ROOF_TIMES * scale,
					0,

					HOUSE_WIDTH / 2 * ROOF_TIMES * scale,
					-HOUSE_HEIGHT_UP * ROOF_TIMES * scale,
					0,
					0,
					0,
					0,
					0,
					-ROOF_WIDTH * scale,
					0,

					// �ݶ�����
					// ���
					-HOUSE_WIDTH / 2 * ROOF_TIMES * scale,
					-HOUSE_HEIGHT_UP * ROOF_TIMES * scale,
					-HOUSE_LENGTH * ROOF_TIMES_LENGTH * scale,
					0,
					0,
					-HOUSE_LENGTH * scale * ROOF_TIMES_LENGTH,
					-HOUSE_WIDTH / 2 * ROOF_TIMES * ROOF_WIDTH_TIMES * scale,
					-HOUSE_HEIGHT_UP * ROOF_TIMES * scale,
					-HOUSE_LENGTH * ROOF_TIMES_LENGTH * scale,

					-HOUSE_WIDTH / 2 * ROOF_TIMES * ROOF_WIDTH_TIMES * scale,
					-HOUSE_HEIGHT_UP * ROOF_TIMES * scale,
					-HOUSE_LENGTH * ROOF_TIMES_LENGTH * scale,
					0,
					0,
					-HOUSE_LENGTH * scale * ROOF_TIMES_LENGTH,
					0,
					-ROOF_WIDTH * scale,
					-HOUSE_LENGTH * scale * ROOF_TIMES_LENGTH,

					// �Ҳ�
					0,
					-ROOF_WIDTH * scale,
					-HOUSE_LENGTH * scale * ROOF_TIMES_LENGTH,
					0,
					0,
					-HOUSE_LENGTH * scale * ROOF_TIMES_LENGTH,
					HOUSE_WIDTH / 2 * ROOF_TIMES * scale,
					-HOUSE_HEIGHT_UP * ROOF_TIMES * scale,
					-HOUSE_LENGTH * scale * ROOF_TIMES_LENGTH,

					HOUSE_WIDTH / 2 * ROOF_TIMES * scale,
					-HOUSE_HEIGHT_UP * ROOF_TIMES * scale,
					-HOUSE_LENGTH * scale * ROOF_TIMES_LENGTH,
					HOUSE_WIDTH / 2 * ROOF_TIMES * ROOF_WIDTH_TIMES * scale,
					-HOUSE_HEIGHT_UP * ROOF_TIMES * scale,
					-HOUSE_LENGTH * scale * ROOF_TIMES_LENGTH,
					0,
					-ROOF_WIDTH * scale,
					-HOUSE_LENGTH * scale * ROOF_TIMES_LENGTH,

					// �¶���
					-HOUSE_WIDTH / 2 * ROOF_TIMES * ROOF_WIDTH_TIMES * scale,
					-HOUSE_HEIGHT_UP * ROOF_TIMES * scale,
					-HOUSE_LENGTH * ROOF_TIMES_LENGTH * scale,
					0,
					-ROOF_WIDTH * scale,
					-HOUSE_LENGTH * scale * ROOF_TIMES_LENGTH,
					-HOUSE_WIDTH / 2 * ROOF_TIMES * ROOF_WIDTH_TIMES * scale,
					-HOUSE_HEIGHT_UP * ROOF_TIMES * scale,
					0,

					0,
					-ROOF_WIDTH * scale,
					-HOUSE_LENGTH * scale * ROOF_TIMES_LENGTH,
					0,
					-ROOF_WIDTH * scale,
					0,
					-HOUSE_WIDTH / 2 * ROOF_TIMES * ROOF_WIDTH_TIMES * scale,
					-HOUSE_HEIGHT_UP * ROOF_TIMES * scale,
					0,

					0,
					-ROOF_WIDTH * scale,
					-HOUSE_LENGTH * scale * ROOF_TIMES_LENGTH,
					HOUSE_WIDTH / 2 * ROOF_TIMES * ROOF_WIDTH_TIMES * scale,
					-HOUSE_HEIGHT_UP * ROOF_TIMES * scale,
					-HOUSE_LENGTH * scale * ROOF_TIMES_LENGTH,
					0,
					-ROOF_WIDTH * scale,
					0,

					HOUSE_WIDTH / 2 * ROOF_TIMES * ROOF_WIDTH_TIMES * scale,
					-HOUSE_HEIGHT_UP * ROOF_TIMES * scale,
					-HOUSE_LENGTH * scale * ROOF_TIMES_LENGTH,
					HOUSE_WIDTH / 2 * ROOF_TIMES * ROOF_WIDTH_TIMES * scale,
					-HOUSE_HEIGHT_UP * ROOF_TIMES * scale,
					0,
					0,
					-ROOF_WIDTH * scale,
					0,

					// �ҵ���
					-HOUSE_WIDTH / 2 * ROOF_TIMES * scale,
					-HOUSE_HEIGHT_UP * ROOF_TIMES * scale,
					-HOUSE_LENGTH * ROOF_TIMES_LENGTH * scale,
					-HOUSE_WIDTH / 2 * ROOF_TIMES * ROOF_WIDTH_TIMES * scale,
					-HOUSE_HEIGHT_UP * ROOF_TIMES * scale,
					0,
					-HOUSE_WIDTH / 2 * ROOF_TIMES * scale,
					-HOUSE_HEIGHT_UP * ROOF_TIMES * scale,
					0,

					-HOUSE_WIDTH / 2 * ROOF_TIMES * scale,
					-HOUSE_HEIGHT_UP * ROOF_TIMES * scale,
					-HOUSE_LENGTH * ROOF_TIMES_LENGTH * scale,
					-HOUSE_WIDTH / 2 * ROOF_TIMES * ROOF_WIDTH_TIMES * scale,
					-HOUSE_HEIGHT_UP * ROOF_TIMES * scale,
					-HOUSE_LENGTH * ROOF_TIMES_LENGTH * scale,
					-HOUSE_WIDTH / 2 * ROOF_TIMES * ROOF_WIDTH_TIMES * scale,
					-HOUSE_HEIGHT_UP * ROOF_TIMES * scale,
					0,

					// �����
					HOUSE_WIDTH / 2 * ROOF_TIMES * ROOF_WIDTH_TIMES * scale,
					-HOUSE_HEIGHT_UP * ROOF_TIMES * scale,
					-HOUSE_LENGTH * scale * ROOF_TIMES_LENGTH,
					HOUSE_WIDTH / 2 * ROOF_TIMES * scale,
					-HOUSE_HEIGHT_UP * ROOF_TIMES * scale,
					-HOUSE_LENGTH * scale * ROOF_TIMES_LENGTH,
					HOUSE_WIDTH / 2 * ROOF_TIMES * scale,
					-HOUSE_HEIGHT_UP * ROOF_TIMES * scale,
					0,// 5

					HOUSE_WIDTH / 2 * ROOF_TIMES * ROOF_WIDTH_TIMES * scale,
					-HOUSE_HEIGHT_UP * ROOF_TIMES * scale,
					-HOUSE_LENGTH * scale * ROOF_TIMES_LENGTH,
					HOUSE_WIDTH / 2 * ROOF_TIMES * scale,
					-HOUSE_HEIGHT_UP * ROOF_TIMES * scale,
					0,// 5
					HOUSE_WIDTH / 2 * ROOF_TIMES * ROOF_WIDTH_TIMES * scale,
					-HOUSE_HEIGHT_UP * ROOF_TIMES * scale, 0

			};
			vCount = vertice.length / 3;// ��������

			ByteBuffer vbb = ByteBuffer.allocateDirect(vertice.length * 4);
			vbb.order(ByteOrder.nativeOrder());
			vertexBuffer = vbb.asFloatBuffer();
			vertexBuffer.put(vertice);
			vertexBuffer.position(0);

			float[] textures = new float[] {// ������������
			// �϶�����������
					0.578f, 0.004f,// 1
					0.5f, 0.07f,// 2
					0.5f, 0.16f,// 3

					0.578f, 0.004f,// 1
					0.5f, 0.16f,// 3
					0.578f, 0.078f,// 4

					0.918f, 0.004f,// 1
					0.918f, 0.078f,// 4
					1, 0.07f,// 6

					1, 0.07f,// 6
					0.918f, 0.078f,// 4
					1, 0.16f,// 5
					// �ݶ�ǰ��
					// ���
					0.52f, 0.152f, 0.52f, 0.168f, 0.695f, 0.012f,

					0.52f, 0.168f, 0.695f, 0.027f, 0.695f, 0.012f,
					// �Ҳ�
					0.52f, 0.168f, 0.695f, 0.012f, 0.695f, 0.027f,

					0.52f, 0.168f, 0.695f, 0.027f, 0.695f, 0.012f,
					// �ݶ�����
					// ���
					0.52f, 0.152f, 0.695f, 0.012f, 0.52f, 0.168f,

					0.52f, 0.168f, 0.695f, 0.012f, 0.695f, 0.027f,
					// �Ҳ�
					0.52f, 0.168f, 0.695f, 0.027f, 0.695f, 0.012f,

					0.52f, 0.168f, 0.695f, 0.012f, 0.695f, 0.027f,

					// �¶�����������
					0.5f, 0.07f,// 2
					0.578f, 0.004f,// 1
					0.5f, 0.16f,// 3

					0.578f, 0.004f,// 1
					0.578f, 0.078f,// 4
					0.5f, 0.16f,// 3

					0.918f, 0.004f,// 1
					1, 0.07f,// 6
					0.918f, 0.078f,// 4

					1, 0.07f,// 6
					1, 0.16f,// 5
					0.918f, 0.078f,// 4

					// �ҵ���
					0.52f, 0.168f, 0.695f, 0.012f, 0.695f, 0.027f,

					0.52f, 0.168f, 0.695f, 0.027f, 0.695f, 0.012f,
					// �����
					0.52f, 0.168f, 0.695f, 0.012f, 0.695f, 0.027f,

					0.52f, 0.168f, 0.695f, 0.027f, 0.695f, 0.012f

			};
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
