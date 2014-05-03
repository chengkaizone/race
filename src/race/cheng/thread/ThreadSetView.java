package race.cheng.thread;

import race.cheng.view.ViewSet;
import android.graphics.Canvas;
import android.view.SurfaceHolder;

/**
 * ������ͼ����
 * 
 * @author chengkai
 * 
 */
public class ThreadSetView extends Thread {
	ViewSet setView;// ��������
	SurfaceHolder holder;
	public boolean flag = true;

	public ThreadSetView(ViewSet setView) {
		this.setView = setView;
		this.holder = setView.getHolder();
	}

	public void run() {
		Canvas canvas;

		while (flag) {
			canvas = null;
			if (true) {
				try {

					canvas = this.holder.lockCanvas();
					synchronized (this.holder) {
						setView.onDraw(canvas);
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
				sleep(500);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
