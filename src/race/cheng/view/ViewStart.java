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
 * 游戏开始界面
 * 
 * @author chengkai
 * 
 */
public class ViewStart extends SurfaceView implements SurfaceHolder.Callback {
	RaceActivity activity;
	Paint paint;
	// 游戏开始界面使用两张变化的logo图片
	int currentAloha = 0;
	int screenWidth = 480;
	int screenHeight = 320;
	int sleepSpan = 50;
	// 百纳图片标志
	Bitmap[] logos = new Bitmap[2];
	Bitmap currentLogo;
	Bitmap sound;

	public ViewStart(RaceActivity activity) {
		super(activity);
		this.activity = activity;
		this.getHolder().addCallback(this);// 设置生命周期回调接口的实现者
		paint = new Paint(); // 创建画笔
		paint.setAntiAlias(true); // 打开抗锯齿
		paint.setFilterBitmap(true);// 设置滤波器
		logos[0] = BitmapFactory.decodeResource(activity.getResources(),
				R.drawable.baina);// 加载百纳图片
		logos[1] = BitmapFactory.decodeResource(activity.getResources(),
				R.drawable.bnkjs);// 加载logo图片
	}

	@Override
	public void onDraw(Canvas canvas) {
		try {
			// 绘制黑色填充矩形清背景
			paint.setColor(Color.BLACK);
			paint.setAlpha(255);
			canvas.drawRect(0, 0, screenWidth, screenHeight, paint);
			// 进行平面贴图
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
		// 创建时开启改变透明度的线程
		new Thread() {
			public void run() {
				//依次绘制两张logo图片
				for (Bitmap bm : logos) {
					currentLogo = bm;
					// 动态更改图片的透明度值并不断重绘--
					for (int i = 255; i > -10; i = i - 10) {
						currentAloha = i;
						if (currentAloha < 0) {
							currentAloha = 0;
						}
						SurfaceHolder myholder = ViewStart.this.getHolder();
						Canvas canvas = myholder.lockCanvas();
						try {
							synchronized (myholder) {
								// 连续调用位图绘制方法
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
							//刚开始绘制是停留1秒
							if (i == 255) {
								Thread.sleep(1000);
							}
							//后面每隔50毫秒绘制一次
							Thread.sleep(sleepSpan);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				}
				// 显示完logo后进入声音设置界面
				activity.toAnotherView(ENTER_SOUND);
			}
		}.start();
	}

	@Override
	public void surfaceDestroyed(SurfaceHolder arg0) {
	}

}
