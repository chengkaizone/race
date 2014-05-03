package race.cheng.view;

import static race.cheng.service.Constant.CHOOSE;
import static race.cheng.service.Constant.ENTER_ABOUT_VIEW;
import static race.cheng.service.Constant.ENTER_HELP_VIEW;
import static race.cheng.service.Constant.ENTER_SET_VIEW;
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
 * ��Ϸ���˵�����
 * 
 * @author chengkai
 * 
 */
public class ViewMainMenu extends SurfaceView implements SurfaceHolder.Callback {
	RaceActivity activity;// ��������
	Bitmap mainMenu;// ��������
	Paint paint;// ��������
	float screenWidth = 480;
	float x_Offset = RaceActivity.screenWidth / 2 - screenWidth / 2;

	public ViewMainMenu(RaceActivity activity) {
		super(activity);
		this.activity = activity;
		this.getHolder().addCallback(this); // �����������ڽӿ�
		paint = new Paint(); // ��������
		paint.setAntiAlias(true); // �򿪿����
		mainMenu = BitmapFactory.decodeResource(this.getResources(),
				R.drawable.mainmenu);// ���ز˵�ͼƬ
	}

	// �����¼��ص�����
	@Override
	public boolean onTouchEvent(MotionEvent e) {
		float x = e.getX();// ��ȡX����
		float y = e.getY();// ��ȡY����

		switch (e.getAction()) {
		case MotionEvent.ACTION_DOWN:

			if (x > 5 + x_Offset && x < 92 + x_Offset && y > 285 && y < 314)// ������ð�ť
			{
				activity.toAnotherView(ENTER_SET_VIEW);// �������ý���
			}
			if (x > 100 + x_Offset && x < 187 + x_Offset && y > 285 && y < 314)// ���������ť
			{
				activity.toAnotherView(ENTER_HELP_VIEW);// �����������
			}
			if (x > 196 + x_Offset && x < 283 + x_Offset && y > 285 && y < 314)// �����ʼ��Ϸ��ť
			{
				activity.toAnotherView(CHOOSE);// ������Ϸѡ�����
			}
			if (x > 292 + x_Offset && x < 380 + x_Offset && y > 285 && y < 314)// ������ڰ�ť
			{
				activity.toAnotherView(ENTER_ABOUT_VIEW);// ������ڽ���
			}
			if (x > 387 + x_Offset && x < 474 + x_Offset && y > 285 && y < 314)// ����˳���ť
			{
				System.exit(0);// �˳�
			}
			break;
		}
		return true;
	}

	@Override
	public void onDraw(Canvas canvas) {
		super.onDraw(canvas);
		canvas.drawBitmap(mainMenu, RaceActivity.screenWidth / 2 - screenWidth
				/ 2, 0, paint);
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
