package race.cheng.thread;

import static race.cheng.view.MyGLSurfaceView.carAlpha;
import static race.cheng.view.MyGLSurfaceView.carX;
import static race.cheng.view.MyGLSurfaceView.carZ;
import race.cheng.graphics.SpeedSpringForControl;
import race.cheng.view.MyGLSurfaceView;

/**
 * 速度控制线程
 * 
 * @author chengkai
 * 
 */
public class ThreadSpeed extends Thread {
	MyGLSurfaceView surface;

	public static boolean flag = true;

	public ThreadSpeed(MyGLSurfaceView surface) {
		this.surface = surface;
	}

	public void run() {
		while (flag) {
			try {
				for (int i = 0; i < MyGLSurfaceView.ssfcList.size(); i++) {
					SpeedSpringForControl ssfc = MyGLSurfaceView.ssfcList
							.get(i);
					ssfc.checkColl(carX, carZ, carAlpha);
				}
				Thread.sleep(50);// 50
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
