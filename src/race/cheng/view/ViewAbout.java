package race.cheng.view;

import static race.cheng.service.Constant.ENTER_MENU;
import race.cheng.main.R;
import race.cheng.main.RaceActivity;
import race.cheng.thread.ThreadAboutView;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

/**
 * ���ڽ���
 * 
 * @author chengkai
 * 
 */
public class ViewAbout extends SurfaceView implements SurfaceHolder.Callback {
	RaceActivity activity;// ��������
	Bitmap about;
	public static int viewFlag = 0;// ����ı�־λ��0��ʾ��һ�����ڽ��棬1��ʾ�ڶ������ڽ���ͼ��
	float screenWidth = 480;// ͼƬ���
	float x_Offset = RaceActivity.screenWidth / 2 - screenWidth / 2;
	// Bitmap aboutTwo;
	public static ThreadAboutView avt;// �߳�����

	public ViewAbout(RaceActivity activity) {
		super(activity);
		getHolder().addCallback(this);
		this.activity = activity;
		about = BitmapFactory.decodeResource(this.getResources(),
				R.drawable.about);
		// aboutTwo=BitmapFactory.decodeResource(this.getResources(),
		// R.drawable.abouttwo);
		avt = new ThreadAboutView(this);
	}

	@Override
	public boolean onTouchEvent(MotionEvent event) {
		switch (event.getAction()) {
		case MotionEvent.ACTION_DOWN:
			int x = (int) event.getX();// ��ȡX����
			int y = (int) event.getY();// ��ȡY����
			if (viewFlag == 0) {
				// if(x>10+x_Offset&&x<97+x_Offset&&y>278&&y<304)//�����һҳ
				// {
				// viewFlag=1;//�ı��־λ����ڶ���ͼ
				// }
				if (x > 382 + x_Offset && x < 470 + x_Offset && y > 278
						&& y < 305)// �������
				{
					activity.toAnotherView(ENTER_MENU);// ���ز˵�����
					avt.flag = false;// �ر��߳�
				}
			}
			// if(viewFlag==1)
			// {
			// if(x>382+x_Offset&&x<470+x_Offset&&y>278&&y<305)//�������
			// {
			// viewFlag=0;//���ز˵�����
			// }
			// }
			break;
		}

		return true;
	}

	@Override
	public void onDraw(Canvas canvas) {
		super.onDraw(canvas);
		if (viewFlag == 0) {
			canvas.drawBitmap(about, RaceActivity.screenWidth / 2 - screenWidth
					/ 2, 0, null);
		}
		// if(viewFlag==1)
		// {
		// canvas.drawBitmap(aboutTwo,
		// RaceActivity.screenWidth/2-screenWidth/2,0,null);
		// }
	}

	@Override
	public void surfaceChanged(SurfaceHolder holder, int format, int width,
			int height) {

	}

	@Override
	public void surfaceCreated(SurfaceHolder holder) {
		avt.start();// �����߳�
	}

	@Override
	public void surfaceDestroyed(SurfaceHolder holder) {

	}
}
