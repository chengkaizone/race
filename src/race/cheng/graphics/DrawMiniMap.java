package race.cheng.graphics;

import static race.cheng.service.Constant.MAP_LEVEL1;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;

import javax.microedition.khronos.opengles.GL10;

/**
 * ���������ͼ
 * 
 * @author chengkai
 * 
 */
public class DrawMiniMap {
	/**
	 * ��ͼ����
	 */
	public static final float MAP_LENGHT = 64;
	/**
	 * ��ͼ���
	 */
	public static final float MAP_HEIGHT = 64;
	/**
	 * ������ΰ볤��
	 */
	public static final float WIDTH = MAP_LENGHT / MAP_LEVEL1[0].length;
	/**
	 * ������ΰ�߶�
	 */
	public static final float HEIGHT = MAP_HEIGHT / MAP_LEVEL1.length;
	Map map;
	public float scale;

	public DrawMiniMap(float scale) {
		this.scale = scale;
		map = new Map(scale);
	}

	public void drawSelf(GL10 gl, int texId, int number, int i, int j) {
		// ɨ���������Ӧλ�û�����Ӧ�������
		switch (number) {
		case -1:
			break;
		case 0:
			gl.glPushMatrix();
			gl.glTranslatef(-MAP_LENGHT * scale + (2 * j + 1) * scale * WIDTH,
					MAP_HEIGHT * scale - (2 * i + 1) * scale * HEIGHT, 0);
			map.drawSelf(gl, texId, number);
			gl.glPopMatrix();
			break;
		case 1:
			gl.glPushMatrix();
			gl.glTranslatef(-MAP_LENGHT * scale + (2 * j + 1) * scale * WIDTH,
					MAP_HEIGHT * scale - (2 * i + 1) * scale * HEIGHT, 0);
			map.drawSelf(gl, texId, number);
			gl.glPopMatrix();
			break;
		case 2:
			gl.glPushMatrix();
			gl.glTranslatef(-MAP_LENGHT * scale + (2 * j + 1) * scale * WIDTH,
					MAP_HEIGHT * scale - (2 * i + 1) * scale * HEIGHT, 0);
			map.drawSelf(gl, texId, number);
			gl.glPopMatrix();
			break;
		case 3:
			gl.glPushMatrix();
			gl.glTranslatef(-MAP_LENGHT * scale + (2 * j + 1) * scale * WIDTH,
					MAP_HEIGHT * scale - (2 * i + 1) * scale * HEIGHT, 0);
			map.drawSelf(gl, texId, number);
			gl.glPopMatrix();
			break;
		case 4:
			gl.glPushMatrix();
			gl.glTranslatef(-MAP_LENGHT * scale + (2 * j + 1) * scale * WIDTH,
					MAP_HEIGHT * scale - (2 * i + 1) * scale * HEIGHT, 0);
			map.drawSelf(gl, texId, number);
			gl.glPopMatrix();
			break;
		case 5:
			gl.glPushMatrix();
			gl.glTranslatef(-MAP_LENGHT * scale + (2 * j + 1) * scale * WIDTH,
					MAP_HEIGHT * scale - (2 * i + 1) * scale * HEIGHT, 0);
			map.drawSelf(gl, texId, number);
			gl.glPopMatrix();
			break;
		case 6:
			gl.glPushMatrix();
			gl.glTranslatef(-MAP_LENGHT * scale + (2 * j + 1) * scale * WIDTH,
					MAP_HEIGHT * scale - (2 * i + 1) * scale * HEIGHT, 0);
			map.drawSelf(gl, texId, number);
			gl.glPopMatrix();
			break;
		case 7:
			gl.glPushMatrix();
			gl.glTranslatef(-MAP_LENGHT * scale + (2 * j + 1) * scale * WIDTH,
					MAP_HEIGHT * scale - (2 * i + 1) * scale * HEIGHT, 0);
			map.drawSelf(gl, texId, number);
			gl.glPopMatrix();
			break;
		case 8:
			gl.glPushMatrix();
			gl.glTranslatef(-MAP_LENGHT * scale + (2 * j + 1) * scale * WIDTH,
					MAP_HEIGHT * scale - (2 * i + 1) * scale * HEIGHT, 0);
			map.drawSelf(gl, texId, number);
			gl.glPopMatrix();
			break;
		case 9:
			gl.glPushMatrix();
			gl.glTranslatef(-MAP_LENGHT * scale + (2 * j + 1) * scale * WIDTH,
					MAP_HEIGHT * scale - (2 * i + 1) * scale * HEIGHT, 0);
			map.drawSelf(gl, texId, number);
			gl.glPopMatrix();
			break;
		}
	}

	private class Map {
		private FloatBuffer vertexBuffer;// ����Buffer
		private FloatBuffer[] textureBuffer;// ��������Buffer
		private int vCount = 0;// ������

		public Map(float scale) {
			float[] vertice = new float[] {// ��Ŷ������������
			-WIDTH * scale, WIDTH * scale, 0,// 1
					-WIDTH * scale, -WIDTH * scale, 0,// 2
					WIDTH * scale, WIDTH * scale, 0,// 4

					WIDTH * scale, WIDTH * scale, 0,// 4
					-WIDTH * scale, -WIDTH * scale, 0,// 2
					WIDTH * scale, -WIDTH * scale, 0,// 3
			};
			vCount = vertice.length / 3;// ��������

			ByteBuffer vbb = ByteBuffer.allocateDirect(vertice.length * 4);
			vbb.order(ByteOrder.nativeOrder());
			vertexBuffer = vbb.asFloatBuffer();
			vertexBuffer.put(vertice);
			vertexBuffer.position(0);
			float[][] textures = new float[][] {// ������������
			{// ��һ��·����������
					0, 0, 0, 0.242f, 0.242f, 0,

					0.242f, 0, 0, 0.242f, 0.242f, 0.242f }, {// �ڶ���·����������
					0.25f, 0, 0.25f, 0.242f, 0.492f, 0,

					0.492f, 0, 0.25f, 0.242f, 0.492f, 0.242f }, {// ������·����������
					0.5f, 0, 0.5f, 0.242f, 0.742f, 0,

					0.742f, 0, 0.5f, 0.242f, 0.742f, 0.242f }, {// ���Ŀ�·����������
					0.75f, 0, 0.75f, 0.242f, 1, 0,

					1, 0, 0.75f, 0.242f, 1, 0.242f }, {// �����·����������
					0, 0.25f, 0, 0.5f, 0.242f, 0.25f,

					0.242f, 0.25f, 0, 0.5f, 0.242f, 0.5f }, {// ������·����������
					0.25f, 0.25f, 0.25f, 0.5f, 0.5f, 0.25f,

					0.5f, 0.25f, 0.25f, 0.5f, 0.5f, 0.5f, }, {// ���߿�·����������
					0.5f, 0, 0.5f, 0.242f, 0.742f, 0,

					0.742f, 0, 0.5f, 0.242f, 0.742f, 0.242f }, {// �ڰ˿�·����������
					0.75f, 0, 0.75f, 0.242f, 1, 0,

					1, 0, 0.75f, 0.242f, 1, 0.242f }, {// �ھſ�·����������
					0, 0.25f, 0, 0.5f, 0.242f, 0.25f,

					0.242f, 0.25f, 0, 0.5f, 0.242f, 0.5f }, {// ��ʮ��·����������
					0.25f, 0.25f, 0.25f, 0.5f, 0.5f, 0.25f,

					0.5f, 0.25f, 0.25f, 0.5f, 0.5f, 0.5f, } };
			textureBuffer = new FloatBuffer[10];
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
}