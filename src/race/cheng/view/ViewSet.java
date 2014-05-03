package race.cheng.view;

import static race.cheng.service.Constant.ENTER_MENU;
import race.cheng.main.R;
import race.cheng.main.RaceActivity;
import race.cheng.thread.ThreadSetView;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

/**
 * 游戏设置视图
 * 
 * @author chengkai
 * 
 */
public class ViewSet extends SurfaceView implements SurfaceHolder.Callback {
	RaceActivity activity;// 声明引用
	Bitmap set;// 设置界面背景

	float screenWidth = 480;// 图片宽度
	float x_Offset = RaceActivity.screenWidth / 2 - screenWidth / 2;

	Bitmap keyboard;// 键盘控制
	Bitmap sensor;// 传感器控制
	Bitmap open;// 开启
	Bitmap close;// 关闭
	Paint paint;// 画笔
	int exTemp = 0;// 绘制键盘或传感器的标志位 0表示绘制源，1表示绘制键盘，2表示绘制传感器,3表示开启声音，4表示关闭声音

	ThreadSetView svt;// 创建线程引用

	public ViewSet(RaceActivity activity) {
		super(activity);
		this.activity = activity;
		getHolder().addCallback(this);
		paint = new Paint();
		set = BitmapFactory.decodeResource(this.getResources(), R.drawable.set);
		keyboard = BitmapFactory.decodeResource(this.getResources(),
				R.drawable.keyboard);
		sensor = BitmapFactory.decodeResource(this.getResources(),
				R.drawable.sensor);
		open = BitmapFactory.decodeResource(this.getResources(),
				R.drawable.open);
		close = BitmapFactory.decodeResource(this.getResources(),
				R.drawable.close);
		svt = new ThreadSetView(this);// 创建对象
	}

	@Override
	public boolean onTouchEvent(MotionEvent event) {
		switch (event.getAction()) {
		case MotionEvent.ACTION_DOWN:
			int x = (int) event.getX();// 获取X坐标
			int y = (int) event.getY();
			if (x > 387 + x_Offset && x < 474 + x_Offset && y > 280 && y < 310)// 点击返回键
			{
				activity.toAnotherView(ENTER_MENU);// 返回值主菜单
				svt.flag = false;
			}
			if (x > 60 + x_Offset && x < 185 + x_Offset && y > 158 && y < 185)// 点击开启声音
			{
				RaceActivity.soundFlag = true;
				exTemp = 3;
			}
			if (x > 60 + x_Offset && x < 185 + x_Offset && y > 202 && y < 229)// 点击关闭声音
			{
				RaceActivity.soundFlag = false;
				exTemp = 4;
			}
			if (x > 295 + x_Offset && x < 417 + x_Offset && y > 158 && y < 186)// 点击键盘体验
			{
				RaceActivity.sensorFlag = false;
				exTemp = 1;

			}
			if (x > 278 + x_Offset && x < 434 + x_Offset && y > 200 && y < 230)// 点击传感器体验
			{
				RaceActivity.sensorFlag = true;

				exTemp = 2;
			}
			break;

		}
		return true;
	}

	@Override
	public void onDraw(Canvas canvas) {
		super.onDraw(canvas);

		if (exTemp == 0) {
			canvas.drawBitmap(set, RaceActivity.screenWidth / 2 - screenWidth
					/ 2, 0, paint);
		}
		if (exTemp == 1) {
			canvas.drawBitmap(keyboard, RaceActivity.screenWidth / 2
					- screenWidth / 2, 0, paint);// 绘制设置界面的最初控制
			exTemp = 0;
		}
		if (exTemp == 2) {
			canvas.drawBitmap(sensor, RaceActivity.screenWidth / 2
					- screenWidth / 2, 0, paint);// 绘制设置界面的最初控制
			exTemp = 0;
		}
		if (exTemp == 3) {
			canvas.drawBitmap(open, RaceActivity.screenWidth / 2 - screenWidth
					/ 2, 0, paint);// 绘制设置界面的最初控制
			exTemp = 0;
		}
		if (exTemp == 4) {
			canvas.drawBitmap(close, RaceActivity.screenWidth / 2 - screenWidth
					/ 2, 0, paint);// 绘制设置界面的最初控制
			exTemp = 0;
		}

	}

	@Override
	public void surfaceChanged(SurfaceHolder holder, int format, int width,
			int height) {
	}

	@Override
	public void surfaceCreated(SurfaceHolder holder) {
		svt.start();// 开启线程
	}

	@Override
	public void surfaceDestroyed(SurfaceHolder holder) {
	}
}
