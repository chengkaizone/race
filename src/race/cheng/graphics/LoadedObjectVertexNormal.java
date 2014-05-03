package race.cheng.graphics;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;

import javax.microedition.khronos.opengles.GL10;

/**
 * ����obj---3ds maxͼƬ���������
 * 
 * @author chengkai
 * 
 */
public class LoadedObjectVertexNormal {
	private FloatBuffer mVertexBuffer;// �����������ݻ���
	private FloatBuffer mNormalBuffer;// ���㷨�������ݻ���
	int vCount = 0;

	public LoadedObjectVertexNormal(float[] vertices, float[] normals) {
		// �����������ݵĳ�ʼ��================begin============================
		vCount = vertices.length / 3;
		// ���������������ݻ���
		// vertices.length*4����Ϊһ�������ĸ��ֽ�
		ByteBuffer vbb = ByteBuffer.allocateDirect(vertices.length * 4);
		vbb.order(ByteOrder.nativeOrder());// �����ֽ�˳��
		mVertexBuffer = vbb.asFloatBuffer();// ת��ΪFloat�ͻ���
		mVertexBuffer.put(vertices);// �򻺳����з��붥����������
		mVertexBuffer.position(0);// ���û�������ʼλ��

		ByteBuffer vbn = ByteBuffer.allocateDirect(normals.length * 4);
		vbn.order(ByteOrder.nativeOrder());// �����ֽ�˳��
		mNormalBuffer = vbn.asFloatBuffer();// ת��ΪFloat�ͻ���
		mNormalBuffer.put(normals);// �򻺳����з��붥����������
		mNormalBuffer.position(0);// ���û�������ʼλ��
	}

	public void drawSelf(GL10 gl, float r, float g, float b) {
		gl.glEnableClientState(GL10.GL_VERTEX_ARRAY);// ���ö�����������
		gl.glEnableClientState(GL10.GL_NORMAL_ARRAY);// ���ö��㷨��������

		// Ϊ����ָ��������������
		gl.glVertexPointer(3, // ÿ���������������Ϊ3 xyz
				GL10.GL_FLOAT, // ��������ֵ������Ϊ GL_FIXED
				0, // ����������������֮��ļ��
				mVertexBuffer // ������������
		);

		// Ϊ����ָ�����㷨��������
		gl.glNormalPointer(GL10.GL_FLOAT, 0, mNormalBuffer);

		setMaterial(gl, r, g, b);

		// ����ͼ��
		gl.glDrawArrays(GL10.GL_TRIANGLES, // �������η�ʽ���
				0, // ��ʼ����
				vCount // ���������
		);

		gl.glDisableClientState(GL10.GL_NORMAL_ARRAY);// ���ö��㷨��������
		gl.glDisableClientState(GL10.GL_VERTEX_ARRAY);// ���ö�����������
	}

	public void setMaterial(GL10 gl, float r, float g, float b) {
		float ambientMaterial[] = { 0.4f * r, 0.4f * g, 0.4f * b, 1.0f };
		gl.glMaterialfv(GL10.GL_FRONT_AND_BACK, GL10.GL_AMBIENT,
				ambientMaterial, 0);
		// ɢ���Ϊ��ɫ����
		float diffuseMaterial[] = { 0.5f * r, 0.5f * g, 0.5f * b, 1.0f };
		gl.glMaterialfv(GL10.GL_FRONT_AND_BACK, GL10.GL_DIFFUSE,
				diffuseMaterial, 0);
		// �߹����Ϊ��ɫ
		float specularMaterial[] = { 0.8f * r, 0.8f * g, 0.8f * b, 1.0f };
		gl.glMaterialfv(GL10.GL_FRONT_AND_BACK, GL10.GL_SPECULAR,
				specularMaterial, 0);
		// �߹ⷴ������,��Խ���������ԽСԽ��
		float shininessMaterial[] = { 1.5f };
		gl.glMaterialfv(GL10.GL_FRONT_AND_BACK, GL10.GL_SHININESS,
				shininessMaterial, 0);
	}
}
