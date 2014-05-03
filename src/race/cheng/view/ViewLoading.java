package race.cheng.view;

import static race.cheng.main.RaceActivity.shu;
import race.cheng.main.R;
import race.cheng.main.RaceActivity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

/**
 * ] ��Ϸ���ȼ��ؽ���
 * 
 * @author chengkai
 * 
 */
public class ViewLoading extends SurfaceView implements SurfaceHolder.Callback {
	RaceActivity activity;// ��������
	Paint paint;// ����
	Bitmap load1;// ���ؽ��汳��ͼ
	Bitmap load2;// ���ؽ����� 439/31
	Bitmap load3;// ���ص�
	Bitmap load4;// ���ص�Ľ���

	int process = 0;// loading���ȱ�־λ
	int pointNum = -1;// ���Ƶ�������ı�־λ

	public static boolean loadFlag = true;// loading�̱߳�־λ��true��ʾloading�У�FALSE��ʾ����loading��
	public static float xoffset = 330;// load2λͼƫ����

	float screenWidth = 480;// ͼƬ���
	float x_Offset = RaceActivity.screenWidth / 2 - screenWidth / 2;

	PointGoThread pgt;// loading�е�Ļ����߳�

	public ViewLoading(RaceActivity activity) {
		super(activity);
		this.activity = activity;
		paint = new Paint();
		getHolder().addCallback(this);
		load1 = BitmapFactory.decodeResource(this.getResources(),
				R.drawable.load1);// ���ؽ���1
		load2 = BitmapFactory.decodeResource(this.getResources(),
				R.drawable.load2);// ���ؽ���2
		load3 = BitmapFactory.decodeResource(this.getResources(),
				R.drawable.load3);// ���ؽ���3
		load4 = BitmapFactory.decodeResource(this.getResources(),
				R.drawable.load4);// ���ؽ���4

		pgt = new PointGoThread(this);
		pgt.start();
	}
	/**
	 * ���ݽ��Ȳý�λͼ---����������Ч
	 * @return
	 */
	public Bitmap getProcessBitmap() {
		return Bitmap.createBitmap(load2, 0, 0, 439 * process / 100, 31);
	}

	@Override
	protected void onDraw(Canvas canvas) {
		super.onDraw(canvas);
		//��������ͼƬ---�ڽ�������λ�û��ƽ��ȼ���λͼ
		canvas.drawBitmap(load1,
				RaceActivity.screenWidth / 2 - screenWidth / 2, 0, paint);
		if (process != 0) {
			Bitmap currBm = getProcessBitmap();
			canvas.drawBitmap(currBm, RaceActivity.screenWidth / 2
					- screenWidth / 2 + 20.16f, 194.88f, paint);
		}

		String pStr = process + "";
		for (int i = 0; i < pStr.length(); i++) {
			char c = pStr.charAt(i);
			canvas.drawBitmap(shu[c - '0'], RaceActivity.screenWidth / 2
					- screenWidth / 2 + 215 + i * 20, 194.88f, paint);
		}
		//���ֺ�����ưٷֺ�
		canvas.drawBitmap(shu[10], RaceActivity.screenWidth / 2 - screenWidth
				/ 2 + 215 + pStr.length() * 21, 194.88f, paint);
		//�Ȼ��������Ƶ�
		canvas.drawBitmap(load3, RaceActivity.screenWidth / 2 - screenWidth / 2
				+ 220, 145, paint);
		canvas.drawBitmap(load3, RaceActivity.screenWidth / 2 - screenWidth / 2
				+ 260, 145, paint);
		canvas.drawBitmap(load3, RaceActivity.screenWidth / 2 - screenWidth / 2
				+ 300, 145, paint);
		//���ݵ�����������ĻƵ�---ָ�������ص����
		if (pointNum == 0) {
			canvas.drawBitmap(load4, RaceActivity.screenWidth / 2 - screenWidth
					/ 2 + 220, 145, paint);
		} else if (pointNum == 1) {
			canvas.drawBitmap(load4, RaceActivity.screenWidth / 2 - screenWidth
					/ 2 + 260, 145, paint);
		} else if (pointNum == 2) {
			canvas.drawBitmap(load4, RaceActivity.screenWidth / 2 - screenWidth
					/ 2 + 300, 145, paint);
		}
	}

	@Override
	public void surfaceChanged(SurfaceHolder holder, int format, int width,
			int height) {

	}

	@Override
	public void surfaceCreated(SurfaceHolder holder) {
		Canvas canvas = holder.lockCanvas();// ��ȡ����
		try {
			synchronized (holder) {
				onDraw(canvas);// ����
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (canvas != null) {
				holder.unlockCanvasAndPost(canvas);
			}
		}
	}

	@Override
	public void surfaceDestroyed(SurfaceHolder holder) {

	}

	// �ػ�ķ���
	public void repaint() {
		Canvas canvas = this.getHolder().lockCanvas();
		try {
			synchronized (canvas) {
				onDraw(canvas);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (canvas != null) {
				this.getHolder().unlockCanvasAndPost(canvas);
			}
		}
	}
	/**
	 * ���ƽ��ȵ���߳�
	 * @author chengkai
	 *
	 */
	private class PointGoThread extends Thread {
		SurfaceHolder holder;
		ViewLoading load;
		public PointGoThread(ViewLoading load) {
			this.load = load;
			this.holder = load.getHolder();
		}
		public void run() {
			Canvas canvas=null;
			while (loadFlag) {
				if (process >= 99) {
					loadFlag = false;
				}
				pointNum = (pointNum + 1) % 3;
				try {
					canvas = this.holder.lockCanvas();
					synchronized (this.holder) {
						load.onDraw(canvas);
					}
				} catch (Exception e) {
					e.printStackTrace();
				} finally {
					if (canvas != null) {
						this.holder.unlockCanvasAndPost(canvas);
					}
				}
				try {
					sleep(800);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}

	}
}
