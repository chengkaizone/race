package race.cheng.view;

import static race.cheng.service.Constant.ENTER_SOUND;
import race.cheng.main.R;
import race.cheng.main.RaceActivity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

/**
 * ��Ϸ��ʼ����
 * 
 * @author chengkai
 * 
 */
public class ViewStart extends SurfaceView implements SurfaceHolder.Callback {
	RaceActivity activity;
	Paint paint;
	// ��Ϸ��ʼ����ʹ�����ű仯��logoͼƬ
	int currentAloha = 0;
	int screenWidth = 480;
	int screenHeight = 320;
	int sleepSpan = 50;
	// ����ͼƬ��־
	Bitmap[] logos = new Bitmap[2];
	Bitmap currentLogo;
	Bitmap sound;

	public ViewStart(RaceActivity activity) {
		super(activity);
		this.activity = activity;
		this.getHolder().addCallback(this);// �����������ڻص��ӿڵ�ʵ����
		paint = new Paint(); // ��������
		paint.setAntiAlias(true); // �򿪿����
		paint.setFilterBitmap(true);// �����˲���
		logos[0] = BitmapFactory.decodeResource(activity.getResources(),
				R.drawable.baina);// ���ذ���ͼƬ
		logos[1] = BitmapFactory.decodeResource(activity.getResources(),
				R.drawable.bnkjs);// ����logoͼƬ
	}

	@Override
	public void onDraw(Canvas canvas) {
		try {
			// ���ƺ�ɫ�������屳��
			paint.setColor(Color.BLACK);
			paint.setAlpha(255);
			canvas.drawRect(0, 0, screenWidth, screenHeight, paint);
			// ����ƽ����ͼ
			if (currentLogo == null)
				return;
			paint.setAlpha(currentAloha);
			canvas.drawBitmap(currentLogo, RaceActivity.screen_xOffset, 0,
					paint);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void surfaceChanged(SurfaceHolder arg0, int arg1, int arg2, int arg3) {
	}

	@Override
	public void surfaceCreated(SurfaceHolder arg0) {
		// ����ʱ�����ı�͸���ȵ��߳�
		new Thread() {
			public void run() {
				//���λ�������logoͼƬ
				for (Bitmap bm : logos) {
					currentLogo = bm;
					// ��̬����ͼƬ��͸����ֵ�������ػ�--
					for (int i = 255; i > -10; i = i - 10) {
						currentAloha = i;
						if (currentAloha < 0) {
							currentAloha = 0;
						}
						SurfaceHolder myholder = ViewStart.this.getHolder();
						Canvas canvas = myholder.lockCanvas();
						try {
							synchronized (myholder) {
								// ��������λͼ���Ʒ���
								onDraw(canvas);
							}
						} catch (Exception e) {
							e.printStackTrace();
						} finally {
							if (canvas != null) {
								myholder.unlockCanvasAndPost(canvas);
							}
						}
						try {
							//�տ�ʼ������ͣ��1��
							if (i == 255) {
								Thread.sleep(1000);
							}
							//����ÿ��50�������һ��
							Thread.sleep(sleepSpan);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				}
				// ��ʾ��logo������������ý���
				activity.toAnotherView(ENTER_SOUND);
			}
		}.start();
	}

	@Override
	public void surfaceDestroyed(SurfaceHolder arg0) {
	}

}
