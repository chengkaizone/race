package race.cheng.view;

import static race.cheng.service.Constant.ENTER_MENU;
import race.cheng.main.R;
import race.cheng.main.RaceActivity;
import race.cheng.thread.ThreadHelpView;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

/**
 * ������ͼ����
 * 
 * @author chengkai
 * 
 */
public class ViewHelp extends SurfaceView implements SurfaceHolder.Callback {
	RaceActivity activity;// ��������
	Paint paint;// ����
	Bitmap helpOne;// ��һ����������
	Bitmap helpTwo;// �ڶ�����������
	Bitmap helpThree;// ��������������
	Bitmap helpFour;// ���ĸ���������
	Bitmap helpFive;// �������������
	Bitmap helpSix;// ��������������
	Bitmap helpSeven;// ���߸���������

	public static int viewFlag = 0;// �ڼ�����������ı�־λ��0
									// ��ʾ��һ���������棬1��ʾ�ڶ����������棬2��ʾ��������������
	public static ThreadHelpView hvt;
	float screenWidth = 480;// ͼƬ���
	float x_Offset = RaceActivity.screenWidth / 2 - screenWidth / 2;

	public ViewHelp(RaceActivity activity) {
		super(activity);
		this.activity = activity;
		paint = new Paint();
		getHolder().addCallback(this);
		helpOne = BitmapFactory.decodeResource(this.getResources(),
				R.drawable.helpone);// ��ʼ����һ�Ű�������
		helpTwo = BitmapFactory.decodeResource(this.getResources(),
				R.drawable.helptwo);// ��ʼ���ڶ��Ű�������
		helpThree = BitmapFactory.decodeResource(this.getResources(),
				R.drawable.helpthree);// ��ʼ�������Ű�������
		helpFour = BitmapFactory.decodeResource(this.getResources(),
				R.drawable.helpfour);// ��ʼ�������Ű�������
		helpFive = BitmapFactory.decodeResource(this.getResources(),
				R.drawable.helpfive);// ��ʼ�������Ű�������
		helpSix = BitmapFactory.decodeResource(this.getResources(),
				R.drawable.helpsix);// ��ʼ�������Ű�������
		helpSeven = BitmapFactory.decodeResource(this.getResources(),
				R.drawable.helpseven);// ��ʼ�������Ű�������

		hvt = new ThreadHelpView(this);
	}

	@Override
	public boolean onTouchEvent(MotionEvent event) {
		switch (event.getAction()) {
		case MotionEvent.ACTION_DOWN:
			int x = (int) event.getX();// ��ȡX����
			int y = (int) event.getY();// ��ȡY����
			if (viewFlag == 0)// ��һ��ͼ
			{
				if (x > 10 + x_Offset && x < 97 + x_Offset && y > 278
						&& y < 304)// �����һҳ
				{
					viewFlag = 1;// �ı��־λ����ڶ���ͼ
				}
				if (x > 382 + x_Offset && x < 470 + x_Offset && y > 278
						&& y < 305)// �������
				{
					activity.toAnotherView(ENTER_MENU);// �������˵�
					hvt.flag = false;// �ر��߳�
				}
				break;
			}
			if (viewFlag == 1)// �ڶ���ͼ
			{
				if (x > 10 + x_Offset && x < 97 + x_Offset && y > 278
						&& y < 304)// �����һҳ
				{
					viewFlag = 2;// �ı��־λ���������ͼ
				}
				if (x > 382 + x_Offset && x < 470 + x_Offset && y > 278
						&& y < 305)// �������
				{
					viewFlag = 0;// �ı��־λ�����һ��ͼ
				}
				break;
			}
			if (viewFlag == 2)// ������ͼ
			{
				if (x > 10 + x_Offset && x < 97 + x_Offset && y > 278
						&& y < 304)// �����һҳ
				{
					viewFlag = 3;// �ı��־λ������ķ�ͼ
				}
				if (x > 382 + x_Offset && x < 470 + x_Offset && y > 278
						&& y < 305)// �������
				{
					viewFlag = 1;// �ı��־λ����ڶ���ͼ
				}
				break;
			}
			if (viewFlag == 3)// ���ķ�ͼ
			{
				if (x > 10 + x_Offset && x < 97 + x_Offset && y > 278
						&& y < 304)// �����һҳ
				{
					viewFlag = 4;// �ı��־λ������ķ�ͼ
				}
				if (x > 382 + x_Offset && x < 470 + x_Offset && y > 278
						&& y < 305)// �������
				{
					viewFlag = 2;// �ı��־λ����ڶ���ͼ
				}
				break;
			}
			if (viewFlag == 4)// �����ͼ
			{
				if (x > 10 + x_Offset && x < 97 + x_Offset && y > 278
						&& y < 304)// �����һҳ
				{
					viewFlag = 5;// �ı��־λ������ķ�ͼ
				}
				if (x > 382 + x_Offset && x < 470 + x_Offset && y > 278
						&& y < 305)// �������
				{
					viewFlag = 3;// �ı��־λ����ڶ���ͼ
				}
				break;
			}
			if (viewFlag == 5)// ������ͼ
			{
				if (x > 10 + x_Offset && x < 97 + x_Offset && y > 278
						&& y < 304)// �����һҳ
				{
					viewFlag = 6;// �ı��־λ������ķ�ͼ
				}
				if (x > 382 + x_Offset && x < 470 + x_Offset && y > 278
						&& y < 305)// �������
				{
					viewFlag = 4;// �ı��־λ����ڶ���ͼ
				}
				break;
			}
			if (viewFlag == 6)// ���߷�ͼ
			{
				if (x > 10 + x_Offset && x < 97 + x_Offset && y > 278
						&& y < 304)// �������
				{
					viewFlag = 5;// �ı��־λ���������ͼ
				}
				break;
			}
		}
		return true;
	}

	@Override
	public void onDraw(Canvas canvas) {
		super.onDraw(canvas);
		if (viewFlag == 0)// ���Ƶ�һ��ͼ
		{
			canvas.drawBitmap(helpOne, RaceActivity.screenWidth / 2
					- screenWidth / 2, 0, paint);
		}
		if (viewFlag == 1)// ���Ƶڶ���ͼ
		{
			canvas.drawBitmap(helpTwo, RaceActivity.screenWidth / 2
					- screenWidth / 2, 0, paint);
		}
		if (viewFlag == 2)// ���Ƶ�����ͼ
		{
			canvas.drawBitmap(helpThree, RaceActivity.screenWidth / 2
					- screenWidth / 2, 0, paint);
		}
		if (viewFlag == 3)// ���Ƶ��ķ�ͼ
		{
			canvas.drawBitmap(helpFour, RaceActivity.screenWidth / 2
					- screenWidth / 2, 0, paint);
		}
		if (viewFlag == 4)// ���Ƶ����ͼ
		{
			canvas.drawBitmap(helpFive, RaceActivity.screenWidth / 2
					- screenWidth / 2, 0, paint);
		}
		if (viewFlag == 5)// ���Ƶ�����ͼ
		{
			canvas.drawBitmap(helpSix, RaceActivity.screenWidth / 2
					- screenWidth / 2, 0, paint);
		}
		if (viewFlag == 6)// ���Ƶ��߷�ͼ
		{
			canvas.drawBitmap(helpSeven, RaceActivity.screenWidth / 2
					- screenWidth / 2, 0, paint);
		}
	}

	@Override
	public void surfaceChanged(SurfaceHolder holder, int format, int width,
			int height) {
	}

	@Override
	public void surfaceCreated(SurfaceHolder holder) {
		hvt.start();
	}

	@Override
	public void surfaceDestroyed(SurfaceHolder holder) {
	}
}
