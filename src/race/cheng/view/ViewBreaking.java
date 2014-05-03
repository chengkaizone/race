package race.cheng.view;

import race.cheng.main.R;
import race.cheng.main.RaceActivity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

/**
 * 破纪录界面
 * 
 * @author chengkai
 * 
 */
public class ViewBreaking extends SurfaceView implements SurfaceHolder.Callback {
	RaceActivity activity;// 声明引用
	Bitmap breaking;

	public ViewBreaking(RaceActivity activity) {
		super(activity);
		getHolder().addCallback(this);
		this.activity = activity;
		breaking = BitmapFactory.decodeResource(this.getResources(),
				R.drawable.breaking);
	}

	@Override
	public void onDraw(Canvas canvas) {
		super.onDraw(canvas);
		canvas.drawBitmap(breaking, RaceActivity.screen_xOffset, 0, null);
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
