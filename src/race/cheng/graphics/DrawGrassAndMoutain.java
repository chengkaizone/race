package race.cheng.graphics;

import static race.cheng.service.Constant.LAND_HIGHEST;
import static race.cheng.service.Constant.S;
import static race.cheng.service.Constant.T;
import static race.cheng.service.Constant.UNIT_SIZE;
import static race.cheng.service.Constant.X_OFFSET;
import static race.cheng.service.Constant.Z_OFFSET;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.util.ArrayList;

import javax.microedition.khronos.opengles.GL10;

/**
 * ����½����---����ɽ�Ͳݵ�
 * 
 * @author chengkai
 * 
 */
public class DrawGrassAndMoutain {
	private FloatBuffer mVertexBuffer;// �����������ݻ���
	private FloatBuffer mTextureBuffer;// ������ɫ���ݻ���
	int vCount;// ��������
	int texId;// ����Id

	public void setTexId(int texId) {
		this.texId = texId;
	}

	public DrawGrassAndMoutain(short[][] yArray, int rows, int cols) {
		// �����������ݵĳ�ʼ��================begin============================

		ArrayList<Float> alf = new ArrayList<Float>();

		for (int j = 0; j < rows; j++)// ѭ����
		{
			for (int i = 0; i < cols; i++)// ѭ����
			{

				float zsx = X_OFFSET + i * UNIT_SIZE;
				float zsz = Z_OFFSET + j * UNIT_SIZE;

				alf.add(zsx);// ����
				alf.add(yArray[j][i] * LAND_HIGHEST / 255.0f);
				alf.add(zsz);

				alf.add(zsx);// ����
				alf.add(yArray[j + 1][i] * LAND_HIGHEST / 255.0f);
				alf.add(zsz + UNIT_SIZE);

				alf.add(zsx + UNIT_SIZE);// ����
				alf.add(yArray[j][i + 1] * LAND_HIGHEST / 255.0f);
				alf.add(zsz);

				alf.add(zsx + UNIT_SIZE);// ����
				alf.add(yArray[j][i + 1] * LAND_HIGHEST / 255.0f);
				alf.add(zsz);

				alf.add(zsx);// ����
				alf.add(yArray[j + 1][i] * LAND_HIGHEST / 255.0f);
				alf.add(zsz + UNIT_SIZE);

				alf.add(zsx + UNIT_SIZE);// ����
				alf.add(yArray[j + 1][i + 1] * LAND_HIGHEST / 255.0f);
				alf.add(zsz + UNIT_SIZE);
			}
		}

		vCount = alf.size() / 3;// ʵ�ʶ�����

		float vertices[] = new float[alf.size()];
		for (int i = 0; i < alf.size(); i++) {
			vertices[i] = alf.get(i);
		}

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
		// �Զ������������飬20��15��
		float textures[] = generateTexCoor(rows, cols, yArray);

		// ���������������ݻ���
		ByteBuffer tbb = ByteBuffer.allocateDirect(textures.length * 4);
		tbb.order(ByteOrder.nativeOrder());// �����ֽ�˳��
		mTextureBuffer = tbb.asFloatBuffer();// ת��ΪFloat�ͻ���
		mTextureBuffer.put(textures);// �򻺳����з��붥����ɫ����
		mTextureBuffer.position(0);// ���û�������ʼλ��
		// �ر���ʾ�����ڲ�ͬƽ̨�ֽ�˳��ͬ���ݵ�Ԫ�����ֽڵ�һ��Ҫ����ByteBuffer
		// ת�����ؼ���Ҫͨ��ByteOrder����nativeOrder()�������п��ܻ������
		// �����������ݵĳ�ʼ��================end============================
	}

	public void drawSelf(GL10 gl) {
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
		gl.glBindTexture(GL10.GL_TEXTURE_2D, texId);

		// ����ͼ��
		gl.glDrawArrays(GL10.GL_TRIANGLES, // �������η�ʽ���
				0, vCount);

		// �ر�����
		gl.glDisableClientState(GL10.GL_TEXTURE_COORD_ARRAY);
		gl.glDisable(GL10.GL_TEXTURE_2D);
		gl.glDisableClientState(GL10.GL_VERTEX_ARRAY);
	}

	// �Զ��з����������������ķ���
	public float[] generateTexCoor(int bh, int bw, short[][] yArray) {
		ArrayList<Float> alf = new ArrayList<Float>();

		float sizeh = T / bh;// ����
		float sizew = S / bw;// ����

		for (int i = 0; i < bh; i++)// ��ѭ��
		{
			for (int j = 0; j < bw; j++)// ��ѭ��
			{
				// ÿ����һ�����Σ������������ι��ɣ��������㣬12����������
				float s = j * sizew;
				float t = i * sizeh;

				alf.add(s);// ����
				alf.add(t);

				alf.add(s);// ����
				alf.add(t + sizeh);

				alf.add(s + sizew);// ����
				alf.add(t);

				alf.add(s + sizew);// ����
				alf.add(t);

				alf.add(s);// ����
				alf.add(t + sizeh);

				alf.add(s + sizew);// ����
				alf.add(t + sizeh);
			}
		}

		float[] result = new float[alf.size()];
		for (int i = 0; i < alf.size(); i++) {
			result[i] = alf.get(i);
		}
		return result;
	}
}
