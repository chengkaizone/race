package race.cheng.graphics;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;

import javax.microedition.khronos.opengles.GL10;

import race.cheng.main.R;
import race.cheng.main.RaceActivity;
import race.cheng.view.MyGLSurfaceView;
import android.media.MediaPlayer;

/**
 * ���Ƶ���ʱ
 * 
 * @author chengkai
 * 
 */
public class DrawCountdown extends Shape {
	// ����ʱ��ĸߺͿ�
	private static float countdown_Height = 20;
	private static float countdown_Width = 20;

	public static float Countdown_Z_Offset = -20;// ����ʱ����ʼλ��

	public static int PictureFlag = 3;// ���Ƶ���ʱ��ı�־λ
	public static boolean flag = true;// �߳̿��Ʊ�־λ��Ĭ��Ϊtrue

	Countdown daojishi;// ����ʱ��
	public static ThreadGo go;// �˶������߳�

	public DrawCountdown(float scale) {
		super(scale);
		daojishi = new Countdown(scale);// ����ʱ��
		go = new ThreadGo();
	}

	@Override
	public void drawSelf(GL10 gl, int texId, int number) {
		gl.glPushMatrix();

		if (PictureFlag == 3) {
			gl.glPushMatrix();// ����3
			gl.glTranslatef(0, 0, Countdown_Z_Offset);
			daojishi.drawSelf(gl, texId, 2);
			gl.glPopMatrix();
		} else if (PictureFlag == 2) {
			gl.glPushMatrix();// ����2
			gl.glTranslatef(0, 0, Countdown_Z_Offset);
			daojishi.drawSelf(gl, texId, 1);
			gl.glPopMatrix();
		} else if (PictureFlag == 1) {
			gl.glPushMatrix();// ����1
			gl.glTranslatef(0, 0, Countdown_Z_Offset);
			daojishi.drawSelf(gl, texId, 0);
			gl.glPopMatrix();
		} else if (PictureFlag == 0) {
			gl.glPushMatrix();// ����GO
			gl.glTranslatef(0, 0, Countdown_Z_Offset);
			daojishi.drawSelf(gl, texId, 3);
			gl.glPopMatrix();
		}

		gl.glPopMatrix();
	}

	// ���Ƶ���ʱ���ڲ���
	// ���ڲ���
	private class Countdown {
		private FloatBuffer vertexBuffer;// ����Buffer
		private FloatBuffer[] textureBuffer;// ��������Buffer
		private int vCount = 0;// ������

		public Countdown(float scale) {
			float[] vertice = new float[] {// ��Ŷ������������
			-countdown_Width / 2 * scale, countdown_Height / 2 * scale, 0,
					-countdown_Width / 2 * scale,
					-countdown_Height / 2 * scale, 0,
					countdown_Width / 2 * scale, countdown_Height / 2 * scale,
					0,

					-countdown_Width / 2 * scale,
					-countdown_Height / 2 * scale, 0,
					countdown_Width / 2 * scale, -countdown_Height / 2 * scale,
					0, countdown_Width / 2 * scale,
					countdown_Height / 2 * scale, 0 };
			vCount = vertice.length / 3;// ��������

			ByteBuffer vbb = ByteBuffer.allocateDirect(vertice.length * 4);
			vbb.order(ByteOrder.nativeOrder());
			vertexBuffer = vbb.asFloatBuffer();
			vertexBuffer.put(vertice);
			vertexBuffer.position(0);
			float[][] textures = new float[][] { { 0, 0, 0, 1, 0.25f, 0,

			0, 1, 0.25f, 1, 0.25f, 0 }, { 0.25f, 0, 0.25f, 1, 0.5f, 0,

			0.25f, 1, 0.5f, 1, 0.5f, 0 }, { 0.5f, 0, 0.5f, 1, 0.75f, 0,

			0.5f, 1, 0.75f, 1, 0.75f, 0 }, { 0.75f, 0, 0.75f, 1, 1, 0,

			0.75f, 1, 1, 1, 1, 0 } };
			textureBuffer = new FloatBuffer[4];
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
			gl.glDisableClientState(GL10.GL_VERTEX_ARRAY);// �رն�������
		}
	}

	// ����ʱ�Ʋ����߳�
	public class ThreadGo extends Thread {
		public void run() {
			while (flag) {
				if (RaceActivity.soundFlag == true && PictureFlag == 3
						&& Countdown_Z_Offset == -20)// ���Ž�ͨ������
				{
					MyGLSurfaceView.activity.playSound(8, 0);// ��ͨ������
				}

				Countdown_Z_Offset = Countdown_Z_Offset + 0.3f;
				if (Countdown_Z_Offset > -11f) {
					Countdown_Z_Offset = -20;// λ�û�ԭ
					PictureFlag = PictureFlag - 1;// ����һ��ͼ������20

					if (RaceActivity.soundFlag == true && PictureFlag > 0)// ���Ž�ͨ������
					{
						MyGLSurfaceView.activity.playSound(8, 0);// ��ͨ������
					} else if (RaceActivity.soundFlag == true
							&& PictureFlag == 0) {
						MyGLSurfaceView.activity.playSound(1, 0);// ��ͨ������
					}
				}
				if (PictureFlag < 0)// ������ʱ��󣬽����߳�
				{
					MyGLSurfaceView.daojishiFlag = false;// �����Ƶ���ʱ
					flag = false;

					MyGLSurfaceView.timeFlag = true;// ��ʼ��ʱ
					MyGLSurfaceView.gameStartTime = System.currentTimeMillis();// ��¼��Ϸ��ʼʱ��
					MyGLSurfaceView.benquanStartTime = MyGLSurfaceView.gameStartTime;// ��¼��Ϸ��Ȧ��ʼʱ��

					RaceActivity.inGame = true;// ��ʾ��ǰ״̬Ϊ����Ϸ��
					RaceActivity.keyFlag = true;// ���ó����ɿ�

					if (RaceActivity.soundFlag == true
							&& RaceActivity.inGame == true)// ������Ϸ�У�������ЧΪ�ɿ���״̬ʱ����������
					{
						RaceActivity.mpBack.stop();
						RaceActivity.mpBack = MediaPlayer.create(
								MyGLSurfaceView.activity, R.raw.backsound);
						RaceActivity.mpBack.setLooping(true);// ѭ������
						RaceActivity.mpBack.start();// ����������
					}
				}
				try {
					Thread.sleep(60);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}
}
