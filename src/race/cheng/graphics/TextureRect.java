package race.cheng.graphics;

import static race.cheng.service.Constant.UNIT_SIZE;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;

import javax.microedition.khronos.opengles.GL10;

/**
 * ���°�ť������
 * 
 * @author chengkai
 * 
 */
public class TextureRect {
	private FloatBuffer mVertexBuffer;// �����������ݻ���
	private FloatBuffer mTextureBuffer;// ������ɫ���ݻ���
	int vCount;
	int texId;

	public void setTexId(int texId) {
		this.texId = texId;
	}

	public TextureRect(float w, float h, float smax, float tmax) {
		// �����������ݵĳ�ʼ��================begin============================
		vCount = 6;
		float vertices[] = new float[] { -w * UNIT_SIZE, h * UNIT_SIZE, 0,
				-w * UNIT_SIZE, -h * UNIT_SIZE, 0, w * UNIT_SIZE,
				h * UNIT_SIZE, 0,

				-w * UNIT_SIZE, -h * UNIT_SIZE, 0, w * UNIT_SIZE,
				-h * UNIT_SIZE, 0, w * UNIT_SIZE, h * UNIT_SIZE, 0 };

		// ���������������ݻ���
		// vertices.length*4����Ϊһ�������ĸ��ֽ�
		ByteBuffer vbb = ByteBuffer.allocateDirect(vertices.length * 4);
		vbb.order(ByteOrder.nativeOrder());// �����ֽ�˳��
		mVertexBuffer = vbb.asFloatBuffer();// ת��Ϊint�ͻ���
		mVertexBuffer.put(vertices);// �򻺳����з��붥����������
		mVertexBuffer.position(0);// ���û�������ʼλ��
		// �ر���ʾ�����ڲ�ͬƽ̨�ֽ�˳��ͬ���ݵ�Ԫ�����ֽڵ�һ��Ҫ����ByteBuffer
		// ת�����ؼ���Ҫͨ��ByteOrder����nativeOrder()�������п��ܻ������
		// �����������ݵĳ�ʼ��================end============================

		// �����������ݵĳ�ʼ��================begin============================
		float textures[] = new float[] { 0, 0, 0, tmax, smax, 0, 0, tmax, smax,
				tmax, smax, 0 };

		// ���������������ݻ���
		ByteBuffer tbb = ByteBuffer.allocateDirect(textures.length * 4);
		tbb.order(ByteOrder.nativeOrder());// �����ֽ�˳��
		mTextureBuffer = tbb.asFloatBuffer();// ת��ΪFloat�ͻ���
		mTextureBuffer.put(textures);// �򻺳����з��붥����ɫ����
		mTextureBuffer.position(0);// ���û�������ʼλ��
	}

	public void drawSelf(GL10 gl) {
		gl.glEnableClientState(GL10.GL_VERTEX_ARRAY);// ���ö�����������

		// Ϊ����ָ��������������
		gl.glVertexPointer(3, GL10.GL_FLOAT, 0, mVertexBuffer);

		// ��������
		gl.glEnable(GL10.GL_TEXTURE_2D);
		// ����ʹ������ST���껺��
		gl.glEnableClientState(GL10.GL_TEXTURE_COORD_ARRAY);
		// Ϊ����ָ������ST���껺��
		gl.glTexCoordPointer(2, GL10.GL_FLOAT, 0, mTextureBuffer);
		// �󶨵�ǰ����
		gl.glBindTexture(GL10.GL_TEXTURE_2D, texId);

		// ����ͼ��
		gl.glDrawArrays(GL10.GL_TRIANGLES, // �������η�ʽ���
				0, vCount);
	}
}
