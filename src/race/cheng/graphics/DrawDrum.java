package race.cheng.graphics;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.util.ArrayList;

import javax.microedition.khronos.opengles.GL10;

/**
 * ���ƹ�
 * 
 * @author chengkai
 * 
 */
public class DrawDrum extends Shape {
	DrawTaper taper;// ����Բ׶
	DrawCirque cirque;// Բ��

	public DrawDrum(float scale) {
		super(scale);
		taper = new DrawTaper(scale);
		cirque = new DrawCirque(scale);
	}

	@Override
	public void drawSelf(GL10 gl, int texId, int number) {
		gl.glPushMatrix();
		gl.glTranslatef(0, 0.2f * scale, 0);

		gl.glPushMatrix();
		taper.drawSelf(gl, texId);
		gl.glPopMatrix();

		gl.glPushMatrix();
		cirque.drawSelf(gl, texId);
		gl.glPopMatrix();

		gl.glPopMatrix();
	}

	// ����Բ׶�ڲ���
	private class DrawTaper {
		private FloatBuffer myVertexBuffer;// �������껺��
		private FloatBuffer myTexture;// ������

		int vCount;// ��������

		public DrawTaper(float scale) {
			float height = 5 * scale;
			float circle_radius = 1.5f * scale;
			float degreespan = 36f;
			int col = 1;

			float spanHeight = (float) height / col;// Բ׶ÿ����ռ�ĸ߶�
			int spannum = (int) (360.0f / degreespan);
			float spanR = circle_radius / col;// �뾶��λ����

			ArrayList<Float> val = new ArrayList<Float>();// �������б�

			for (float circle_degree = 360.0f; circle_degree > 0.0f; circle_degree -= degreespan)// ѭ����
			{
				for (int j = 0; j < col; j++)// ѭ����
				{
					float currentR = j * spanR;// ��ǰ�����Բ�뾶
					float currentHeight = height - j * spanHeight;// ��ǰ����ĸ߶�

					float x1 = (float) (currentR * Math.cos(Math
							.toRadians(circle_degree)));
					float y1 = currentHeight;
					float z1 = (float) (currentR * Math.sin(Math
							.toRadians(circle_degree)));

					float x2 = (float) ((currentR + spanR) * Math.cos(Math
							.toRadians(circle_degree)));
					float y2 = currentHeight - spanHeight;
					float z2 = (float) ((currentR + spanR) * Math.sin(Math
							.toRadians(circle_degree)));

					float x3 = (float) ((currentR + spanR) * Math.cos(Math
							.toRadians(circle_degree - degreespan)));
					float y3 = currentHeight - spanHeight;
					float z3 = (float) ((currentR + spanR) * Math.sin(Math
							.toRadians(circle_degree - degreespan)));

					float x4 = (float) ((currentR) * Math.cos(Math
							.toRadians(circle_degree - degreespan)));
					float y4 = currentHeight;
					float z4 = (float) ((currentR) * Math.sin(Math
							.toRadians(circle_degree - degreespan)));

					val.add(x1);
					val.add(y1);
					val.add(z1);// ���������Σ���6�����������
					val.add(x2);
					val.add(y2);
					val.add(z2);
					val.add(x4);
					val.add(y4);
					val.add(z4);

					val.add(x2);
					val.add(y2);
					val.add(z2);
					val.add(x3);
					val.add(y3);
					val.add(z3);
					val.add(x4);
					val.add(y4);
					val.add(z4);
				}
			}

			vCount = val.size() / 3;// ȷ����������

			// ����
			float[] vertexs = new float[vCount * 3];
			for (int i = 0; i < vCount * 3; i++) {
				vertexs[i] = val.get(i);
			}
			ByteBuffer vbb = ByteBuffer.allocateDirect(vertexs.length * 4);
			vbb.order(ByteOrder.nativeOrder());
			myVertexBuffer = vbb.asFloatBuffer();
			myVertexBuffer.put(vertexs);
			myVertexBuffer.position(0);

			// ����
			float[] textures = generateTexCoor(spannum, col);
			ByteBuffer tbb = ByteBuffer.allocateDirect(textures.length * 4);
			tbb.order(ByteOrder.nativeOrder());
			myTexture = tbb.asFloatBuffer();
			myTexture.put(textures);
			myTexture.position(0);
		}

		public void drawSelf(GL10 gl, int texId) {
			gl.glEnableClientState(GL10.GL_VERTEX_ARRAY);// �򿪶��㻺��
			gl.glVertexPointer(3, GL10.GL_FLOAT, 0, myVertexBuffer);// ָ�����㻺��

			gl.glEnable(GL10.GL_TEXTURE_2D);
			gl.glEnableClientState(GL10.GL_TEXTURE_COORD_ARRAY);
			gl.glTexCoordPointer(2, GL10.GL_FLOAT, 0, myTexture);
			gl.glBindTexture(GL10.GL_TEXTURE_2D, texId);

			gl.glDrawArrays(GL10.GL_TRIANGLES, 0, vCount);// ����ͼ��

			gl.glDisableClientState(GL10.GL_TEXTURE_COORD_ARRAY);// �رջ���
			gl.glDisable(GL10.GL_TEXTURE_2D);
			gl.glDisableClientState(GL10.GL_VERTEX_ARRAY);
		}

		// �Զ��з����������������ķ���
		public float[] generateTexCoor(int bw, int bh) {
			float[] result = new float[bw * bh * 6 * 2];
			float sizew = 1.0f / bw;// �е�λ����
			float sizeh = 1.0f / bh;// �е�λ����
			int c = 0;
			for (int j = 0; j < bw; j++) {
				for (int i = 0; i < bh; i++) {
					// ÿ����һ�����Σ������������ι��ɣ��������㣬12����������
					float s = j * sizew;
					float t = i * sizeh;

					result[c++] = s;
					result[c++] = t;

					result[c++] = s;
					result[c++] = t + sizeh;

					result[c++] = s + sizew;
					result[c++] = t;

					result[c++] = s;
					result[c++] = t + sizeh;

					result[c++] = s + sizew;
					result[c++] = t + sizeh;

					result[c++] = s + sizew;
					result[c++] = t;
				}
			}
			return result;
		}
	}

	// ����Բ���ڲ���
	private class DrawCirque {
		private FloatBuffer myVertex;// ���㻺��
		private FloatBuffer myTexture;// ������

		int vcount;

		public DrawCirque(float scale) {
			float ring_Span = 36;
			float circle_Span = 45;
			float ring_Radius = 1.5f * scale;
			float circle_Radius = 0.2f * scale;

			ArrayList<Float> val = new ArrayList<Float>();

			for (float circle_Degree = 0f; circle_Degree < 360f; circle_Degree += circle_Span) {
				for (float ring_Degree = 0f; ring_Degree < 360f; ring_Degree += ring_Span) {
					float x1 = (float) ((ring_Radius + circle_Radius
							* Math.cos(Math.toRadians(circle_Degree))) * Math
							.cos(Math.toRadians(ring_Degree)));
					float y1 = (float) (circle_Radius * Math.sin(Math
							.toRadians(circle_Degree)));
					float z1 = (float) ((ring_Radius + circle_Radius
							* Math.cos(Math.toRadians(circle_Degree))) * Math
							.sin(Math.toRadians(ring_Degree)));

					float x2 = (float) ((ring_Radius + circle_Radius
							* Math.cos(Math.toRadians(circle_Degree))) * Math
							.cos(Math.toRadians(ring_Degree + ring_Span)));
					float y2 = (float) (circle_Radius * Math.sin(Math
							.toRadians(circle_Degree)));
					float z2 = (float) ((ring_Radius + circle_Radius
							* Math.cos(Math.toRadians(circle_Degree))) * Math
							.sin(Math.toRadians(ring_Degree + ring_Span)));

					float x3 = (float) ((ring_Radius + circle_Radius
							* Math.cos(Math.toRadians(circle_Degree
									+ circle_Span))) * Math.cos(Math
							.toRadians(ring_Degree + ring_Span)));
					float y3 = (float) (circle_Radius * Math.sin(Math
							.toRadians(circle_Degree + circle_Span)));
					float z3 = (float) ((ring_Radius + circle_Radius
							* Math.cos(Math.toRadians(circle_Degree
									+ circle_Span))) * Math.sin(Math
							.toRadians(ring_Degree + ring_Span)));

					float x4 = (float) ((ring_Radius + circle_Radius
							* Math.cos(Math.toRadians(circle_Degree
									+ circle_Span))) * Math.cos(Math
							.toRadians(ring_Degree)));
					float y4 = (float) (circle_Radius * Math.sin(Math
							.toRadians(circle_Degree + circle_Span)));
					float z4 = (float) ((ring_Radius + circle_Radius
							* Math.cos(Math.toRadians(circle_Degree
									+ circle_Span))) * Math.sin(Math
							.toRadians(ring_Degree)));

					val.add(x1);
					val.add(y1);
					val.add(z1);
					val.add(x4);
					val.add(y4);
					val.add(z4);
					val.add(x2);
					val.add(y2);
					val.add(z2);

					val.add(x2);
					val.add(y2);
					val.add(z2);
					val.add(x4);
					val.add(y4);
					val.add(z4);
					val.add(x3);
					val.add(y3);
					val.add(z3);
				}
			}
			vcount = val.size() / 3;
			float[] vertexs = new float[vcount * 3];
			for (int i = 0; i < vcount * 3; i++) {
				vertexs[i] = val.get(i);
			}
			ByteBuffer vbb = ByteBuffer.allocateDirect(vertexs.length * 4);
			vbb.order(ByteOrder.nativeOrder());
			myVertex = vbb.asFloatBuffer();
			myVertex.put(vertexs);
			myVertex.position(0);

			// ����
			int row = (int) (360.0f / circle_Span);
			int col = (int) (360.0f / ring_Span);
			float[] textures = generateTexCoor(row, col);

			ByteBuffer tbb = ByteBuffer.allocateDirect(textures.length * 4);
			tbb.order(ByteOrder.nativeOrder());
			myTexture = tbb.asFloatBuffer();
			myTexture.put(textures);
			myTexture.position(0);
		}

		public void drawSelf(GL10 gl, int texId) {
			gl.glEnableClientState(GL10.GL_VERTEX_ARRAY);
			gl.glVertexPointer(3, GL10.GL_FLOAT, 0, myVertex);

			gl.glEnable(GL10.GL_TEXTURE_2D);
			gl.glEnableClientState(GL10.GL_TEXTURE_COORD_ARRAY);
			gl.glTexCoordPointer(2, GL10.GL_FLOAT, 0, myTexture);
			gl.glBindTexture(GL10.GL_TEXTURE_2D, texId);

			gl.glDrawArrays(GL10.GL_TRIANGLES, 0, vcount);

			gl.glDisableClientState(GL10.GL_TEXTURE_COORD_ARRAY);// �رջ���
			gl.glDisable(GL10.GL_TEXTURE_2D);
			gl.glDisableClientState(GL10.GL_VERTEX_ARRAY);
		}

		// �Զ��з����������������ķ���
		public float[] generateTexCoor(int bw, int bh) {
			float[] result = new float[bw * bh * 6 * 2];
			float sizew = 1.0f / bw;// ����
			float sizeh = 1.0f / bh;// ����
			int c = 0;
			for (int i = 0; i < bh; i++) {
				for (int j = 0; j < bw; j++) {
					// ÿ����һ�����Σ������������ι��ɣ��������㣬12����������
					float s = j * sizew;
					float t = i * sizeh;

					result[c++] = s;
					result[c++] = t;

					result[c++] = s;
					result[c++] = t + sizeh;

					result[c++] = s + sizew;
					result[c++] = t;

					result[c++] = s + sizew;
					result[c++] = t;

					result[c++] = s;
					result[c++] = t + sizeh;

					result[c++] = s + sizew;
					result[c++] = t + sizeh;
				}
			}
			return result;
		}
	}
}
