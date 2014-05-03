package race.cheng.graphics;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;

import javax.microedition.khronos.opengles.GL10;

public class DrawBegin extends Shape {
	DrawBeginLine line;

	public DrawBegin(float scale) {
		super(scale);
		line = new DrawBeginLine(scale);
	}

	@Override
	public void drawSelf(GL10 gl, int texId, int number) {
		gl.glPushMatrix();
		line.drawSelf(gl, texId, number);
		gl.glPopMatrix();
	}

	private class DrawBeginLine {
		private FloatBuffer mVertexBuffer;// �����������ݻ���
		private FloatBuffer mTextureBuffer;// ���������������ݻ���

		int vCount;// ��������

		public DrawBeginLine(float scale) {
			vCount = 6;

			float width = 0.2f;// ���
			float length = 1.0f;// ����
			float verteices[] = { -length * scale, 0, -width * scale,
					-length * scale, 0, width * scale, length * scale, 0,
					-width * scale,

					length * scale, 0, -width * scale, -length * scale, 0,
					width * scale, length * scale, 0, width * scale };

			ByteBuffer vbb = ByteBuffer.allocateDirect(verteices.length * 4); // ���������������ݻ���
			vbb.order(ByteOrder.nativeOrder());// �����ֽ�˳��
			mVertexBuffer = vbb.asFloatBuffer();// ת��Ϊfloat�ͻ���
			mVertexBuffer.put(verteices);// �򻺳����з��붥����������
			mVertexBuffer.position(0);// ���û�������ʼλ��

			float s = 5;// ��������s�����ֵ
			float t = 1;// ��������t�����ֵ

			float textureCoors[] = { 0, 0, 0, t, s, 0,

			s, 0, 0, t, s, t };
			ByteBuffer tbb = ByteBuffer.allocateDirect(textureCoors.length * 4);// ���������������ݻ���
			tbb.order(ByteOrder.nativeOrder());// �����ֽ�˳��
			mTextureBuffer = tbb.asFloatBuffer();// ת��Ϊfloat�ͻ���
			mTextureBuffer.put(textureCoors);// �򻺳����з��붥������
			mTextureBuffer.position(0);// ���û�������ʼλ��
		}

		public void drawSelf(GL10 gl, int texId, int number) {
			gl.glEnableClientState(GL10.GL_VERTEX_ARRAY);// ����ʹ�ö�������
			gl.glVertexPointer(3, GL10.GL_FLOAT, 0, mVertexBuffer);// ָ����������

			gl.glEnable(GL10.GL_TEXTURE_2D);// ����ʹ����������
			gl.glEnableClientState(GL10.GL_TEXTURE_COORD_ARRAY);// ����ʹ��������������
			gl.glTexCoordPointer(2, GL10.GL_FLOAT, 0, mTextureBuffer);// ָ����������
			gl.glBindTexture(GL10.GL_TEXTURE_2D, texId);// ������

			gl.glDrawArrays(GL10.GL_TRIANGLES, 0, vCount);// �������η�ʽ���

			gl.glDisableClientState(GL10.GL_TEXTURE_COORD_ARRAY);// �ر���������
			gl.glDisable(GL10.GL_TEXTURE_2D);// ��ֹʹ������
			gl.glDisableClientState(GL10.GL_VERTEX_ARRAY);// �رն�������
		}
	}
}
