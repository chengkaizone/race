package race.cheng.thread;

import race.cheng.view.ViewAbout;
import android.graphics.Canvas;
import android.view.SurfaceHolder;

/**
 * ������ͼ�߳�
 * 
 * @author chengkai
 * 
 */
public class ThreadAboutView extends Thread {
	ViewAbout aboutView;// ��������
	SurfaceHolder holder;
	public boolean flag = true;

	public ThreadAboutView(ViewAbout aboutView) {
		this.aboutView = aboutView;
		this.holder = aboutView.getHolder();
	}

	public void run() {
		Canvas canvas;
		while (flag) {
			canvas = null;
			if (true) {
				try {
					canvas = this.holder.lockCanvas();
					synchronized (this.holder) {
						aboutView.onDraw(canvas);
					}
				} catch (Exception e) {
					e.printStackTrace();
				} finally {
					if (canvas != null) {
						this.holder.unlockCanvasAndPost(canvas);
					}
				}
			}
			try {
				sleep(100);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
