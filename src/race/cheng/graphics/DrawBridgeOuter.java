package race.cheng.graphics;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;

import javax.microedition.khronos.opengles.GL10;

/**
 * ������
 * 
 * @author Administrator
 * 
 */
public class DrawBridgeOuter extends Shape {
	DrawBridge bridge;// �Ŷ���

	public DrawBridgeOuter(float scale) {
		super(scale);
		bridge = new DrawBridge(scale);// �������ζ���
	}

	@Override
	public void drawSelf(GL10 gl, int texId, int number) {
		bridge.drawSelf(gl, texId, number);

	}

	private class DrawBridge {
		private FloatBuffer mVertexBuffer;// �����������ݻ���
		private FloatBuffer mTextureBuffer;// ���������������ݻ���

		int vCount;// ��������
		float lengthOut;// �ܳ�
		float lengthMid;// ����
		float lengthIn;// ���泤
		float height;// �ܸ�
		float heightIn;// ����
		float width;// ��

		public DrawBridge(float scale) {
			lengthOut = 8.0f * scale;// �ܳ�
			lengthMid = 6.0f * scale;// ����
			lengthIn = 4.0f * scale;// ���泤
			height = 3.0f * scale;// �ܸ�
			heightIn = 2.0f * scale;// ����
			width = 1.5f * scale;// ��
			float[] verteices = {
					// ǰ��
					// 1����
					-lengthOut,
					0,
					width,
					-lengthMid,
					0,
					width,
					-lengthIn,
					height,
					width,
					// 2����
					-lengthIn,
					height,
					width,
					-lengthMid,
					0,
					width,
					-lengthIn,
					heightIn,
					width,
					// 3����
					-lengthIn,
					height,
					width,
					-lengthIn,
					heightIn,
					width,
					lengthIn,
					height,
					width,
					// 4����
					lengthIn,
					height,
					width,
					-lengthIn,
					heightIn,
					width,
					lengthIn,
					heightIn,
					width,
					// 5����
					lengthIn,
					heightIn,
					width,
					lengthOut,
					0,
					width,
					lengthIn,
					height,
					width,
					// 6����
					lengthIn,
					heightIn,
					width,
					lengthMid,
					0,
					width,
					lengthOut,
					0,
					width,

					// ����
					// 7����
					-lengthOut,
					0,
					-width,
					-lengthIn,
					height,
					-width,
					-lengthMid,
					0,
					-width,
					// 8����
					-lengthMid,
					0,
					-width,
					-lengthIn,
					height,
					-width,
					-lengthIn,
					heightIn,
					-width,
					// 9��
					-lengthIn,
					height,
					-width,
					lengthIn,
					height,
					-width,
					-lengthIn,
					heightIn,
					-width,

					// 10��
					lengthIn,
					height,
					-width,
					lengthIn,
					heightIn,
					-width,
					-lengthIn,
					heightIn,
					-width,
					// 11
					lengthIn,
					height,
					-width,
					lengthOut,
					0,
					-width,
					lengthIn,
					heightIn,
					-width,
					// 12
					lengthIn,
					heightIn,
					-width,
					lengthOut,
					0,
					-width,
					lengthMid,
					0,
					-width,
					// ����
					// 13
					-lengthOut,
					0,
					-width,
					-lengthOut,
					0,
					width,
					-lengthIn,
					height,
					width,
					// 14
					-lengthIn,
					height,
					width,
					-lengthIn,
					height,
					-width,
					-lengthOut,
					0,
					-width,
					// 15
					-lengthIn,
					height,
					-width,
					-lengthIn,
					height,
					width,
					lengthIn,
					height,
					width,
					// 16
					lengthIn,
					height,
					width,
					lengthIn,
					height,
					-width,
					-lengthIn,
					height,
					-width,
					// 17
					lengthIn,
					height,
					-width,
					lengthIn,
					height,
					width,
					lengthOut,
					0,
					width,
					// 18
					lengthOut,
					0,
					width,
					lengthOut,
					0,
					-width,
					lengthIn,
					height,
					-width,

					// ����
					// 19
					-lengthMid, 0, -width, -lengthIn,
					heightIn,
					width,
					-lengthMid,
					0,
					width,
					// 20
					-lengthIn, heightIn, width, -lengthMid, 0,
					-width,
					-lengthIn,
					heightIn,
					-width,
					// 21
					-lengthIn, heightIn, -width, lengthIn, heightIn, width,
					-lengthIn,
					heightIn,
					width,
					// 22
					lengthIn, heightIn, width, -lengthIn, heightIn, -width,
					lengthIn, heightIn,
					-width,
					// 23
					lengthIn, heightIn, -width, lengthMid, 0, width, lengthIn,
					heightIn, width,
					// 24
					lengthMid, 0, width, lengthIn, heightIn, -width, lengthMid,
					0, -width

			};
			vCount = verteices.length / 3;

			ByteBuffer vbb = ByteBuffer.allocateDirect(verteices.length * 4); // ���������������ݻ���
			vbb.order(ByteOrder.nativeOrder());// �����ֽ�˳��
			mVertexBuffer = vbb.asFloatBuffer();// ת��Ϊfloat�ͻ���
			mVertexBuffer.put(verteices);// �򻺳����з��붥����������
			mVertexBuffer.position(0);// ���û�������ʼλ��

			float[] textureCoors = {
					// 1
					0, 0.5f, 0.17f, 0.5f, 0.34f, 0,
					// 2
					0.34f, 0, 0.17f, 0.5f, 0.34f, 0.25f,
					// 3
					0.34f, 0, 0.34f, 0.25f, 0.68f, 0,
					// 4
					0.68f, 0, 0.34f, 0.25f, 0.68f, 0.25f,
					// 5
					0.68f, 0.25f, 1, 0.5f, 0.68f, 0,
					// 6
					0.68f, 0.25f, 0.85f, 0.5f, 1, 0.5f,
					// 7
					0, 0.5f, 0.34f, 0, 0.17f, 0.5f,
					// 8
					0.17f, 0.5f, 0.34f, 0, 0.34f, 0.25f,
					// 9
					0.34f, 0, 0.68f, 0, 0.34f, 0.25f,
					// 10
					0.68f, 0, 0.68f, 0.25f, 0.34f, 0.25f,
					// 11
					0.68f, 0, 1, 0.5f, 0.68f, 0.25f,
					// 12
					0.68f, 0.25f, 1, 0.5f, 0.85f, 0.5f,
					// 13
					0, 0.5f, 0, 1, 0.34f, 1,
					// 14
					0.34f, 1, 0.34f, 0.5f, 0, 0.5f,
					// 15
					0.34f, 0.5f, 0.34f, 1, 0.68f, 1,
					// 16
					0.68f, 1, 0.68f, 0.5f, 0.34f, 0.5f,
					// 17
					0.68f, 0.5f, 0.68f, 1, 1, 1,
					// 18
					1, 1, 1, 0.5f, 0.68f, 0.5f,
					// 19
					0, 0.5f, 0.34f, 1, 0, 1,
					// 20
					0.34f, 1, 0, 0.5f, 0.34f, 0.5f,
					// 21
					0.34f, 0.5f, 0.68f, 1, 0.34f, 1,
					// 22
					0.68f, 1, 0.34f, 0.5f, 0.68f, 0.5f,
					// 23
					0.68f, 0.5f, 1, 1, 0.68f, 1,
					// 24
					1, 1, 0.68f, 0.5f, 1, 0.5f

			};
			ByteBuffer tbb = ByteBuffer.allocateDirect(textureCoors.length * 4);// ���������������ݻ���
			tbb.order(ByteOrder.nativeOrder());// �����ֽ�˳��
			mTextureBuffer = tbb.asFloatBuffer();// ת��Ϊfloat�ͻ���
			mTextureBuffer.put(textureCoors);// �򻺳����з��붥������
			mTextureBuffer.position(0);// ���û�������ʼλ��

		}

		public void drawSelf(GL10 gl, int texId, int number) {
			gl.glEnableClientState(GL10.GL_VERTEX_ARRAY);// ����ʹ�ö�������
			gl.glVertexPointer(3, GL10.GL_FLOAT, 0, mVertexBuffer);// ָ�㶥�����ݻ���

			gl.glEnable(GL10.GL_TEXTURE_2D);// ����ʹ������
			gl.glEnableClientState(GL10.GL_TEXTURE_COORD_ARRAY);// ����ʹ�������������ݻ���

			gl.glTexCoordPointer(2, GL10.GL_FLOAT, 0, mTextureBuffer);// ָ���������ݻ���
			gl.glBindTexture(GL10.GL_TEXTURE_2D, texId);// ������

			gl.glDrawArrays(GL10.GL_TRIANGLES, 0, vCount);// �������η�ʽ���ƾ���

			gl.glDisableClientState(GL10.GL_TEXTURE_COORD_ARRAY);// ��ֹʹ��������������
			gl.glDisable(GL10.GL_TEXTURE_2D);// �ر�����
			gl.glDisableClientState(GL10.GL_VERTEX_ARRAY);// ��ֹʹ�ö�������

		}
	}
}
