package race.cheng.view;

import static race.cheng.service.Constant.ENTER_MENU;
import static race.cheng.service.Constant.LOADING;
import race.cheng.main.R;
import race.cheng.main.RaceActivity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

/**
 * 游戏结束界面
 * 
 * @author chengkai
 * 
 */
public class ViewOver extends SurfaceView implements SurfaceHolder.Callback {
	RaceActivity activity;// 声明引用
	Bitmap over;// 设置界面背景

	float screenWidth = 480;// 图片宽度
	float x_Offset = RaceActivity.screenWidth / 2 - screenWidth / 2;

	Paint paint;// 画笔

	public ViewOver(RaceActivity activity) {
		super(activity);
		this.activity = activity;
		getHolder().addCallback(this);
		paint = new Paint();
		over = BitmapFactory.decodeResource(this.getResources(),
				R.drawable.over);
	}

	@Override
	public boolean onTouchEvent(MotionEvent event) {
		switch (event.getAction()) {
		case MotionEvent.ACTION_DOWN:
			int x = (int) event.getX();// 获取X坐标
			int y = (int) event.getY();
			if (x > 135 + x_Offset && x < 343 + x_Offset && y > 122 && y < 193)// 点击主菜单
			{
				activity.toAnotherView(LOADING);// 返回值主菜单
			}
			if (x > 135 + x_Offset && x < 343 + x_Offset && y > 193 && y < 265)// 点击在玩一次
			{
				activity.toAnotherView(ENTER_MENU);// 进入游戏
			}
			break;
		}
		return true;
	}

	@Override
	protected void onDraw(Canvas canvas) {
		super.onDraw(canvas);
		canvas.drawBitmap(over, RaceActivity.screenWidth / 2 - screenWidth / 2,
				0, paint);
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
