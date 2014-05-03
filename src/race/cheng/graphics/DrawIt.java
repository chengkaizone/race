package race.cheng.graphics;

import static race.cheng.service.Constant.MAX_QUANSHU;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;

import javax.microedition.khronos.opengles.GL10;

import race.cheng.view.MyGLSurfaceView;

/**
 * ��������
 * 
 * @author chengkai
 * 
 */
public class DrawIt extends Shape {
	public static final float TOTALWIDTH = 1.044f;// �ܳ���
	public static final float NUMBERHEIGTH = 0.06F;// ���ֵĸ߶�
	public static final float NUMBERWIDTH = 0.047f;// ���ֵĿ��

	public static final float PICTUREHEIGHT = 0.06f;// ͼƬ�ĸ߶�
	public static final float PICTUREWIDTH = 0.047f;// ͼƬ�Ŀ��

	public static final float POINTWIDTH = 0.015f;// ��Ŀ��
	// **************��������****************************
	public long timeTotal[] = new long[3];
	public long timeBenQuan[] = new long[3];
	TimeTotal timeTotals;
	TimeBenQuan timeBen;
	Point point;
	Names names;
	QuanShu quan;
	ZongQuan zongQuan;
	XieGang xieGang;

	public DrawIt(float scale) {
		super(scale);
		timeTotals = new TimeTotal(scale);
		timeBen = new TimeBenQuan(scale);
		point = new Point(scale);
		names = new Names(scale);
		quan = new QuanShu(scale);
		zongQuan = new ZongQuan(scale);
		xieGang = new XieGang(scale);
	}

	@Override
	public void drawSelf(GL10 gl, int texId, int number) {
		// �������
		gl.glEnable(GL10.GL_BLEND);
		// ����Դ���������Ŀ��������
		gl.glBlendFunc(GL10.GL_SRC_ALPHA, GL10.GL_ONE_MINUS_SRC_ALPHA);
		gl.glPushMatrix();// ��ʱ
		gl.glTranslatef(-TOTALWIDTH / 2 * scale, 0, 0);
		names.drawSelf(gl, texId, 0);
		gl.glPopMatrix();

		gl.glPushMatrix();// ��
		gl.glTranslatef(
				-(TOTALWIDTH / 2 - PICTUREWIDTH / 2 - NUMBERWIDTH / 2 - 0.01f)
						* scale, 0, 0);
		timeTotals.drawSelf(gl, texId, 2);
		gl.glPopMatrix();

		gl.glPushMatrix();// ð��
		gl.glTranslatef(-(TOTALWIDTH / 2 - PICTUREWIDTH / 2 - NUMBERWIDTH * 2
				- POINTWIDTH / 2 - 0.01f)
				* scale, 0, 0);
		point.drawSelf(gl, texId, 0);
		gl.glPopMatrix();

		gl.glPushMatrix();// ��
		gl.glTranslatef(-(TOTALWIDTH / 2 - PICTUREWIDTH / 2 - NUMBERWIDTH * 5
				/ 2 - POINTWIDTH - 0.01f)
				* scale, 0, 0);
		timeTotals.drawSelf(gl, texId, 1);
		gl.glPopMatrix();

		gl.glPushMatrix();// С����
		gl.glTranslatef(-(TOTALWIDTH / 2 - PICTUREWIDTH / 2 - NUMBERWIDTH * 4
				- POINTWIDTH * 3 / 2 - 0.01f)
				* scale, 0, 0);
		point.drawSelf(gl, texId, 1);
		gl.glPopMatrix();

		gl.glPushMatrix();// ��������
		gl.glTranslatef(-(TOTALWIDTH / 2 - PICTUREWIDTH / 2 - NUMBERWIDTH * 9
				/ 2 - POINTWIDTH * 2 - 0.01f)
				* scale, 0, 0);
		timeTotals.drawSelf(gl, texId, 0);
		gl.glPopMatrix();

		gl.glPushMatrix();// ��Ȧʱ
		gl.glTranslatef(-(TOTALWIDTH / 2 - PICTUREWIDTH - NUMBERWIDTH * 6
				- POINTWIDTH * 2 - 0.03f)
				* scale, 0, 0);
		names.drawSelf(gl, texId, 1);
		gl.glPopMatrix();

		gl.glPushMatrix();// ��
		gl.glTranslatef(-(TOTALWIDTH / 2 - PICTUREWIDTH * 3 / 2 - NUMBERWIDTH
				* 13 / 2 - POINTWIDTH * 2 - 0.04f)
				* scale, 0, 0);
		timeBen.drawSelf(gl, texId, 2);
		gl.glPopMatrix();

		gl.glPushMatrix();// ð��
		gl.glTranslatef(-(TOTALWIDTH / 2 - PICTUREWIDTH * 3 / 2 - NUMBERWIDTH
				* 8 - POINTWIDTH * 5 / 2 - 0.04f)
				* scale, 0, 0);
		point.drawSelf(gl, texId, 0);
		gl.glPopMatrix();

		gl.glPushMatrix();// ��
		gl.glTranslatef(-(TOTALWIDTH / 2 - PICTUREWIDTH * 3 / 2 - NUMBERWIDTH
				* 17 / 2 - POINTWIDTH * 3 - 0.04f)
				* scale, 0, 0);
		timeBen.drawSelf(gl, texId, 1);
		gl.glPopMatrix();

		gl.glPushMatrix();// С����
		gl.glTranslatef(-(TOTALWIDTH / 2 - PICTUREWIDTH * 3 / 2 - NUMBERWIDTH
				* 10 - POINTWIDTH * 7 / 2 - 0.04f)
				* scale, 0, 0);
		point.drawSelf(gl, texId, 1);
		gl.glPopMatrix();

		gl.glPushMatrix();// ��������
		gl.glTranslatef(-(TOTALWIDTH / 2 - PICTUREWIDTH * 3 / 2 - NUMBERWIDTH
				* 21 / 2 - POINTWIDTH * 4 - 0.04f)
				* scale, 0, 0);
		timeBen.drawSelf(gl, texId, 0);
		gl.glPopMatrix();

		gl.glPushMatrix();// lap
		gl.glTranslatef(-(TOTALWIDTH / 2 - PICTUREWIDTH * 2 - NUMBERWIDTH * 12
				- POINTWIDTH * 4 - 0.06f)
				* scale, 0, 0);
		names.drawSelf(gl, texId, 2);
		gl.glPopMatrix();

		// ***********
		gl.glPushMatrix();// �ܵ�Ȧ��
		gl.glTranslatef(-(TOTALWIDTH / 2 - PICTUREWIDTH * 5 / 2 - NUMBERWIDTH
				* 25 / 2 - POINTWIDTH * 4 - 0.07f)
				* scale, 0, 0);
		quan.drawSelf(gl, texId, 0);
		gl.glPopMatrix();

		gl.glPushMatrix();// б��
		gl.glTranslatef(-(TOTALWIDTH / 2 - PICTUREWIDTH * 5 / 2 - NUMBERWIDTH
				* 27 / 2 - POINTWIDTH * 4 - 0.07f)
				* scale, 0, 0);
		xieGang.drawSelf(gl, texId, 0);
		gl.glPopMatrix();

		gl.glPushMatrix();// ��Ȧ��
		gl.glTranslatef(-(TOTALWIDTH / 2 - PICTUREWIDTH * 5 / 2 - NUMBERWIDTH
				* 29 / 2 - POINTWIDTH * 4 - 0.07f)
				* scale, 0, 0);
		zongQuan.drawSelf(gl, texId);
		gl.glPopMatrix();
		gl.glDisable(GL10.GL_BLEND);
	}

	public void toBenQuanTime(long ms)// �㱾Ȧʱ����㷨
	{
		timeBenQuan[0] = (long) Math.floor((ms % 1000) / 10);
		timeBenQuan[1] = (long) Math.floor((ms % 60000) / 1000);
		timeBenQuan[2] = (long) Math.floor((ms / 60000));
	}

	public void toTotalTime(long ms)// ����ʱ��ķ���
	{
		timeTotal[0] = (long) Math.floor((ms % 1000) / 10);
		timeTotal[1] = (long) Math.floor((ms % 60000) / 1000);
		timeTotal[2] = (long) Math.floor((ms / 60000));
	}

	// ʱ�������ڲ���
	private class First {
		private FloatBuffer vertexBuffer;// ����Buffer
		private FloatBuffer textureBuffer;// ��������Buffer
		private int vCount = 0;// ������

		public First(float scale, float texture[]) {
			float[] vertice = new float[] {// ��Ŷ������������
			-NUMBERWIDTH / 2 * scale, NUMBERHEIGTH / 2 * scale, 0,
					-NUMBERWIDTH / 2 * scale, -NUMBERHEIGTH / 2 * scale, 0,
					NUMBERWIDTH / 2 * scale, NUMBERHEIGTH / 2 * scale, 0,

					NUMBERWIDTH / 2 * scale, NUMBERHEIGTH / 2 * scale, 0,
					-NUMBERWIDTH / 2 * scale, -NUMBERHEIGTH / 2 * scale, 0,
					NUMBERWIDTH / 2 * scale, -NUMBERHEIGTH / 2 * scale, 0 };
			vCount = vertice.length / 3;// ��������

			ByteBuffer vbb = ByteBuffer.allocateDirect(vertice.length * 4);
			vbb.order(ByteOrder.nativeOrder());
			vertexBuffer = vbb.asFloatBuffer();
			vertexBuffer.put(vertice);
			vertexBuffer.position(0);
			float[] textures = new float[vCount * 2];
			textures = texture;
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

	// ��Ȧʱ����ʾ�ڲ���
	private class TimeBenQuan {
		First[] numbers = new First[10];

		public TimeBenQuan(float scale) {
			// ����0-9ʮ�����ֵ��������
			for (int i = 0; i < 10; i++) {
				numbers[i] = new First(scale, new float[] { 0.099f * i, 0f,
						0.099f * i, 0.277f, 0.099f * (i + 1), 0f,
						0.099f * (i + 1), 0f, 0.099f * i, 0.277f,
						0.099f * (i + 1), 0.277f });
			}
		}

		public void drawSelf(GL10 gl, int texId, int number) {
			String scoreStr;
			if (timeBenQuan[number] < 10) {
				scoreStr = "0" + timeBenQuan[number] + "";
			} else {
				scoreStr = timeBenQuan[number] + "";
			}
			for (int i = 0; i < scoreStr.length(); i++) {// ���÷��е�ÿ�������ַ�����
				char c = scoreStr.charAt(i);
				gl.glPushMatrix();
				gl.glTranslatef(i * NUMBERWIDTH * scale, 0, 0);
				numbers[c - '0'].drawSelf(gl, texId);
				gl.glPopMatrix();
			}
		}
	}

	// ��ʱ����ڲ���
	private class TimeTotal {
		First[] numbers = new First[10];

		public TimeTotal(float scale) {
			// ����0-9ʮ�����ֵ��������
			for (int i = 0; i < 10; i++) {
				numbers[i] = new First(scale, new float[] { 0.099f * i, 0f,
						0.099f * i, 0.277f, 0.099f * (i + 1), 0f,
						0.099f * (i + 1), 0f, 0.099f * i, 0.277f,
						0.099f * (i + 1), 0.277f

				});
			}
		}

		public void drawSelf(GL10 gl, int texId, int number) {
			String scoreStr;
			if (timeTotal[number] < 10) {
				scoreStr = "0" + timeTotal[number] + "";
			} else {
				scoreStr = timeTotal[number] + "";
			}
			for (int i = 0; i < scoreStr.length(); i++) {// ���÷��е�ÿ�������ַ�����
				char c = scoreStr.charAt(i);
				gl.glPushMatrix();
				gl.glTranslatef(i * NUMBERWIDTH * scale, 0, 0);
				numbers[c - '0'].drawSelf(gl, texId);
				gl.glPopMatrix();
			}
		}
	}

	// б���ڲ���
	private class XieGang {
		First xie;

		public XieGang(float scale) {
			// ����0-9ʮ�����ֵ��������
			for (int i = 0; i < 10; i++) {
				xie = new First(scale, new float[] { 0.613f, 0.441f, 0.613f,
						0.754f, 0.695f, 0.441f, 0.695f, 0.441f, 0.613f, 0.754f,
						0.695f, 0.754f });
			}
		}

		public void drawSelf(GL10 gl, int texId, int number) {
			gl.glPushMatrix();
			xie.drawSelf(gl, texId);
			gl.glPopMatrix();
		}
	}

	// ���ڲ���
	private class Point {
		private FloatBuffer vertexBuffer;// ����Buffer
		private FloatBuffer[] textureBuffer;// ��������Buffer
		private int vCount = 0;// ������

		public Point(float scale) {
			float[] vertice = new float[] {// ��Ŷ������������
			-POINTWIDTH / 2 * scale, NUMBERHEIGTH / 2 * scale, 0,
					-POINTWIDTH / 2 * scale, -NUMBERHEIGTH / 2 * scale, 0,
					POINTWIDTH / 2 * scale, NUMBERHEIGTH / 2 * scale, 0,

					POINTWIDTH / 2 * scale, NUMBERHEIGTH / 2 * scale, 0,
					-POINTWIDTH / 2 * scale, -NUMBERHEIGTH / 2 * scale, 0,
					POINTWIDTH / 2 * scale, -NUMBERHEIGTH / 2 * scale, 0 };
			vCount = vertice.length / 3;// ��������

			ByteBuffer vbb = ByteBuffer.allocateDirect(vertice.length * 4);
			vbb.order(ByteOrder.nativeOrder());
			vertexBuffer = vbb.asFloatBuffer();
			vertexBuffer.put(vertice);
			vertexBuffer.position(0);
			float[][] textures = new float[][] {
					{ 0.73f, 0.441f, 0.73f, 0.754f, 0.781f, 0.441f,

					0.781f, 0.441f, 0.73f, 0.754f, 0.781f, 0.754f },
					{ 0.805f, 0.441f, 0.805f, 0.754f, 0.855f, 0.441f,

					0.855f, 0.441f, 0.805f, 0.754f, 0.855f, 0.754f } };
			textureBuffer = new FloatBuffer[3];
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

	// ͼƬ�ڲ���
	private class Word {
		private FloatBuffer vertexBuffer;// ����Buffer
		private FloatBuffer textureBuffer;// ��������Buffer
		private int vCount = 0;// ������

		public Word(float scale, float texture[]) {
			float[] vertice = new float[] {// ��Ŷ������������
			-PICTUREWIDTH / 2 * scale, PICTUREHEIGHT / 2 * scale, 0,
					-PICTUREWIDTH / 2 * scale, -PICTUREHEIGHT / 2 * scale, 0,
					PICTUREWIDTH / 2 * scale, PICTUREHEIGHT / 2 * scale, 0,

					PICTUREWIDTH / 2 * scale, PICTUREHEIGHT / 2 * scale, 0,
					-PICTUREWIDTH / 2 * scale, -PICTUREHEIGHT / 2 * scale, 0,
					PICTUREWIDTH / 2 * scale, -PICTUREHEIGHT / 2 * scale, 0 };
			vCount = vertice.length / 3;// ��������

			ByteBuffer vbb = ByteBuffer.allocateDirect(vertice.length * 4);
			vbb.order(ByteOrder.nativeOrder());
			vertexBuffer = vbb.asFloatBuffer();
			vertexBuffer.put(vertice);
			vertexBuffer.position(0);
			float[] textures = new float[vCount * 2];
			textures = texture;
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

	private class Names {
		Word[] name = new Word[3];

		public Names(float scale) {
			for (int i = 0; i < 3; i++) {
				name[i] = new Word(scale, new float[] { 0.193f * i, 0.32f,
						0.193f * i, 0.805f, 0.193f * (i + 1), 0.32f,
						0.193f * (i + 1), 0.32f, 0.193f * i, 0.805f,
						0.193f * (i + 1), 0.805f });
			}
		}

		public void drawSelf(GL10 gl, int texId, int number) {
			gl.glPushMatrix();
			name[number].drawSelf(gl, texId);
			gl.glPopMatrix();
		}
	}

	private class QuanShu {
		First[] quanShu = new First[4];

		public QuanShu(float scale) {
			for (int i = 0; i < 4; i++) {
				quanShu[i] = new First(scale, new float[] { 0.099f * i, 0f,
						0.099f * i, 0.277f, 0.099f * (i + 1), 0f,
						0.099f * (i + 1), 0f, 0.099f * i, 0.277f,
						0.099f * (i + 1), 0.277f });
			}
		}

		public void drawSelf(GL10 gl, int texId, int number) {
			String scoreStr = MyGLSurfaceView.quanshu + "";
			for (int i = 0; i < scoreStr.length(); i++) {// ���÷��е�ÿ�������ַ�����
				char c = scoreStr.charAt(i);
				gl.glPushMatrix();
				quanShu[c - '0'].drawSelf(gl, texId);
				gl.glPopMatrix();
			}
		}
	}

	private class ZongQuan// ��Ȧ��
	{
		First zongQuan;

		public ZongQuan(float scale) {
			zongQuan = new First(scale, new float[] { 0.099f * MAX_QUANSHU, 0f,
					0.099f * MAX_QUANSHU, 0.277f, 0.099f * (MAX_QUANSHU + 1),
					0f, 0.099f * (MAX_QUANSHU + 1), 0f, 0.099f * MAX_QUANSHU,
					0.277f, 0.099f * (MAX_QUANSHU + 1), 0.277f });
		}

		public void drawSelf(GL10 gl, int texId) {
			gl.glPushMatrix();
			zongQuan.drawSelf(gl, texId);
			gl.glPopMatrix();
		}
	}
}
