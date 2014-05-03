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
 * �������ƽ���
 * 
 * @author chengkai
 * 
 */
public class ViewSoundControl extends SurfaceView implements
		SurfaceHolder.Callback {

	RaceActivity activity;// ��������
	Bitmap sound;// ��������
	float screenWidth = 480;
	float x_Offset = RaceActivity.screenWidth / 2 - screenWidth / 2;

	public ViewSoundControl(RaceActivity activity) {
		super(activity);
		this.activity = activity;
		getHolder().addCallback(this);// �����������ڽӿ�
		sound = BitmapFactory.decodeResource(this.getResources(),
				R.drawable.sound);// ����ͼƬ
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
			int x = (int) event.getX();// ��ȡX����
			int y = (int) event.getY();
			if (x > 10 + x_Offset && x < 97 + x_Offset && y > 280 && y < 310) {
				RaceActivity.soundFlag = true;// ��������
				activity.toAnotherView(ENTER_MENU);
			} else if (x > 380 + x_Offset && x < 468 + x_Offset && y > 280
					&& y < 310) {
				RaceActivity.soundFlag = false;// �ر�����
				activity.toAnotherView(ENTER_MENU);
			}
			break;

		}
		return true;
	}

	@Override
	public boolean onKeyDown(int keyCode, KeyEvent e) // �����¼�
	{
		if (keyCode == 4) // ����ϵͳ
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
