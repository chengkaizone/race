package race.cheng.graphics;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;

import javax.microedition.khronos.opengles.GL10;

/**
 * ������֤��
 * 
 * @author chengkai
 * 
 */
public class DrawLicensePlate {

	private FloatBuffer mVertexBuffer;// �����������ݻ���
	private FloatBuffer mTextureBuffer;// �����������ݻ���
	int vCount;// ��������

	public DrawLicensePlate(float scale) {
		vCount = 6;// ��������
		float width = 0.38f;// ���
		float length = 1.0f;// ����
		float verteices[] = { -length * scale, width * scale, 0,
				-length * scale, -width * scale, 0, length * scale,
				-width * scale, 0,

				length * scale, -width * scale, 0, length * scale,
				width * scale, 0, -length * scale, width * scale, 0 };
		ByteBuffer vbb = ByteBuffer.allocateDirect(verteices.length * 4); // ���������������ݻ���
		vbb.order(ByteOrder.nativeOrder());// �����ֽ�˳��
		mVertexBuffer = vbb.asFloatBuffer();// ת��Ϊfloat�ͻ���
		mVertexBuffer.put(verteices);// �򻺳����з��붥����������
		mVertexBuffer.position(0);// ���û�������ʼλ��

		float textureCoors[] = { 0, 0.200f, 0, 0.719f, 1, 0.719f, 1, 0.719f, 1,
				0.200f, 0, 0.200f };
		ByteBuffer tbb = ByteBuffer.allocateDirect(textureCoors.length * 4);// ���������������ݻ���
		tbb.order(ByteOrder.nativeOrder());// �����ֽ�˳��
		mTextureBuffer = tbb.asFloatBuffer();// ת��Ϊfloat�ͻ���
		mTextureBuffer.put(textureCoors);// �򻺳����з��붥������
		mTextureBuffer.position(0);// ���û�������ʼλ��
	}

	public void drawSelf(GL10 gl, int textureId) {
		gl.glEnableClientState(GL10.GL_VERTEX_ARRAY);// ����ʹ�ö�������
		gl.glVertexPointer(3, GL10.GL_FLOAT, 0, mVertexBuffer);// ָ���������ݻ���

		gl.glEnable(GL10.GL_TEXTURE_2D);// ����ʹ������
		gl.glEnableClientState(GL10.GL_TEXTURE_COORD_ARRAY);// ����ʹ����������
		gl.glTexCoordPointer(2, GL10.GL_FLOAT, 0, mTextureBuffer);// ָ���������ݻ���
		gl.glBindTexture(GL10.GL_TEXTURE_2D, textureId);// ����������
		gl.glDrawArrays(GL10.GL_TRIANGLES, 0, vCount);// �������η�ʽ���ƾ���

		gl.glDisableClientState(GL10.GL_TEXTURE_COORD_ARRAY);// �ر���������
		gl.glDisable(GL10.GL_TEXTURE_2D);// �ر�����

		gl.glDisableClientState(GL10.GL_VERTEX_ARRAY);// �رն�������
	}
}
