package race.cheng.view;

import static race.cheng.service.Constant.ENTER_MENU;
import race.cheng.main.R;
import race.cheng.main.RaceActivity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

/**
 * 声音控制界面
 * 
 * @author chengkai
 * 
 */
public class ViewSoundControl extends SurfaceView implements
		SurfaceHolder.Callback {

	RaceActivity activity;// 声明引用
	Bitmap sound;// 声明引用
	float screenWidth = 480;
	float x_Offset = RaceActivity.screenWidth / 2 - screenWidth / 2;

	public ViewSoundControl(RaceActivity activity) {
		super(activity);
		this.activity = activity;
		getHolder().addCallback(this);// 设置生命周期接口
		sound = BitmapFactory.decodeResource(this.getResources(),
				R.drawable.sound);// 加载图片
	}

	@Override
	protected void onDraw(Canvas canvas) {
		super.onDraw(canvas);
		canvas.drawBitmap(sound,
				RaceActivity.screenWidth / 2 - screenWidth / 2, 0, null);
	}

	@Override
	public boolean onTouchEvent(MotionEvent event) {
		switch (event.getAction()) {
		case MotionEvent.ACTION_DOWN:
			int x = (int) event.getX();// 获取X坐标
			int y = (int) event.getY();
			if (x > 10 + x_Offset && x < 97 + x_Offset && y > 280 && y < 310) {
				RaceActivity.soundFlag = true;// 开启声音
				activity.toAnotherView(ENTER_MENU);
			} else if (x > 380 + x_Offset && x < 468 + x_Offset && y > 280
					&& y < 310) {
				RaceActivity.soundFlag = false;// 关闭声音
				activity.toAnotherView(ENTER_MENU);
			}
			break;

		}
		return true;
	}

	@Override
	public boolean onKeyDown(int keyCode, KeyEvent e) // 触控事件
	{
		if (keyCode == 4) // 返回系统
		{
			return false;
		}
		return true;
	}

	@Override
	public void surfaceChanged(SurfaceHolder holder, int format, int width,
			int height) {
	}

	@Override
	public void surfaceCreated(SurfaceHolder holder) {
		Canvas canvas = holder.lockCanvas();// 获取画布
		try {
			synchronized (holder) {
				onDraw(canvas);// 绘制
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
}
