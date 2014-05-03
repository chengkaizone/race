package race.cheng.view;

import race.cheng.main.R;
import race.cheng.main.RaceActivity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

/**
 * �Ƽ�¼����
 * 
 * @author chengkai
 * 
 */
public class ViewBreaking extends SurfaceView implements SurfaceHolder.Callback {
	RaceActivity activity;// ��������
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

}
