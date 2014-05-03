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
 * ��Ϸ������ͼ
 * 
 * @author chengkai
 * 
 */
public class ViewSet extends SurfaceView implements SurfaceHolder.Callback {
	RaceActivity activity;// ��������
	Bitmap set;// ���ý��汳��

	float screenWidth = 480;// ͼƬ���
	float x_Offset = RaceActivity.screenWidth / 2 - screenWidth / 2;

	Bitmap keyboard;// ���̿���
	Bitmap sensor;// ����������
	Bitmap open;// ����
	Bitmap close;// �ر�
	Paint paint;// ����
	int exTemp = 0;// ���Ƽ��̻򴫸����ı�־λ 0��ʾ����Դ��1��ʾ���Ƽ��̣�2��ʾ���ƴ�����,3��ʾ����������4��ʾ�ر�����

	ThreadSetView svt;// �����߳�����

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
		svt = new ThreadSetView(this);// ��������
	}

	@Override
	public boolean onTouchEvent(MotionEvent event) {
		switch (event.getAction()) {
		case MotionEvent.ACTION_DOWN:
			int x = (int) event.getX();// ��ȡX����
			int y = (int) event.getY();
			if (x > 387 + x_Offset && x < 474 + x_Offset && y > 280 && y < 310)// ������ؼ�
			{
				activity.toAnotherView(ENTER_MENU);// ����ֵ���˵�
				svt.flag = false;
			}
			if (x > 60 + x_Offset && x < 185 + x_Offset && y > 158 && y < 185)// �����������
			{
				RaceActivity.soundFlag = true;
				exTemp = 3;
			}
			if (x > 60 + x_Offset && x < 185 + x_Offset && y > 202 && y < 229)// ����ر�����
			{
				RaceActivity.soundFlag = false;
				exTemp = 4;
			}
			if (x > 295 + x_Offset && x < 417 + x_Offset && y > 158 && y < 186)// �����������
			{
				RaceActivity.sensorFlag = false;
				exTemp = 1;

			}
			if (x > 278 + x_Offset && x < 434 + x_Offset && y > 200 && y < 230)// �������������
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
					- screenWidth / 2, 0, paint);// �������ý�����������
			exTemp = 0;
		}
		if (exTemp == 2) {
			canvas.drawBitmap(sensor, RaceActivity.screenWidth / 2
					- screenWidth / 2, 0, paint);// �������ý�����������
			exTemp = 0;
		}
		if (exTemp == 3) {
			canvas.drawBitmap(open, RaceActivity.screenWidth / 2 - screenWidth
					/ 2, 0, paint);// �������ý�����������
			exTemp = 0;
		}
		if (exTemp == 4) {
			canvas.drawBitmap(close, RaceActivity.screenWidth / 2 - screenWidth
					/ 2, 0, paint);// �������ý�����������
			exTemp = 0;
		}

	}

	@Override
	public void surfaceChanged(SurfaceHolder holder, int format, int width,
			int height) {
	}

	@Override
	public void surfaceCreated(SurfaceHolder holder) {
		svt.start();// �����߳�
	}

	@Override
	public void surfaceDestroyed(SurfaceHolder holder) {
	}
}
