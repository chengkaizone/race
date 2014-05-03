package race.cheng.thread;

import static race.cheng.view.MyGLSurfaceView.carAlpha;
import static race.cheng.view.MyGLSurfaceView.carX;
import static race.cheng.view.MyGLSurfaceView.carZ;
import race.cheng.graphics.KZBJForControl;
import race.cheng.view.MyGLSurfaceView;

/**
 * 检查可撞飞的部件
 * 
 * @author chengkai
 * 
 */
public class ThreadColl extends Thread {
	MyGLSurfaceView surface;

	public static boolean flag = true;

	public ThreadColl(MyGLSurfaceView surface) {
		this.surface = surface;
	}

	public void run() {
		while (flag) {
			for (KZBJForControl kzbjfcTemp : MyGLSurfaceView.kzbjList) {
				if (!kzbjfcTemp.state) {
					kzbjfcTemp.checkColl(carX, carZ, carAlpha);
				}
				kzbjfcTemp.go();
			}
			try {
				Thread.sleep(50);// 50
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
