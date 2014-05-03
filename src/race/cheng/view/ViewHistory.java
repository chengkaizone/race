package race.cheng.view;

import static race.cheng.main.RaceActivity.number;

import java.util.ArrayList;

import race.cheng.main.R;
import race.cheng.main.RaceActivity;
import race.cheng.service.DBUtil;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

/**
 * 历史界面
 * 
 * @author chengkai
 * 
 */
public class ViewHistory extends SurfaceView implements SurfaceHolder.Callback {
	RaceActivity activity;
	Bitmap history;
	Paint paint;
	ArrayList<String[]> al = new ArrayList<String[]>();
	boolean moveFlag = false;
	// 记录开始的位置
	private float startMoveY = 0;
	// 表格行之间的宽度
	float width = 25;
	// 显示最多行数
	int TOTAL_ROWS = 5;
	// 当前表格第一行行号
	int rowFirst = 0;

	public ViewHistory(RaceActivity activity) {
		super(activity);
		this.activity = activity;
		paint = new Paint();
		this.getHolder().addCallback(this);
		history = BitmapFactory.decodeResource(getResources(),
				R.drawable.history);
		al = DBUtil.getResult();
	}

	@Override
	protected void onDraw(Canvas canvas) {
		super.onDraw(canvas);
		canvas.drawBitmap(history, RaceActivity.screen_xOffset, 0, paint);
		for (int i = 0; i < 5; i++) {
			if (i + rowFirst > al.size() - 1) {
				break;
			}
			int currIndex = i + rowFirst;
			String timeStr = al.get(currIndex)[0];
			String dateStr = al.get(currIndex)[1];
			for (int j = 0; j < timeStr.length(); j++) {
				char c = timeStr.charAt(j);
				if (c == ':') {
					canvas.drawBitmap(number[10], 21 + j * 16
							+ RaceActivity.screen_xOffset, 139 + i * width,
							paint);
				} else {
					canvas.drawBitmap(number[c - '0'], 21 + j * 16
							+ RaceActivity.screen_xOffset, 139 + i * width,
							paint);
				}
			}
			for (int j = 0; j < dateStr.length(); j++) {
				char d = dateStr.charAt(j);
				if (d == '-') {
					canvas.drawBitmap(number[11], 134 + j * 16
							+ RaceActivity.screen_xOffset, 139 + i * width,
							paint);
				} else if (d == ' ') {
					continue;
				} else if (d == ':') {
					canvas.drawBitmap(number[10], 134 + j * 16
							+ RaceActivity.screen_xOffset, 139 + i * width,
							paint);
				} else {
					canvas.drawBitmap(number[d - '0'], 134 + j * 16
							+ RaceActivity.screen_xOffset, 139 + i * width,
							paint);
				}
			}
		}
	}

	@Override
	public boolean onTouchEvent(MotionEvent event) {
		return true;
	}

	@Override
	public void surfaceChanged(SurfaceHolder holder, int format, int width,
			int height) {
	}

	@Override
	public void surfaceCreated(SurfaceHolder holder) {
		repaint();
	}

	@Override
	public void surfaceDestroyed(SurfaceHolder holder) {
	}

	public void repaint() {
		Canvas canvas = this.getHolder().lockCanvas();
		try {
			synchronized (canvas) {
				onDraw(canvas);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (canvas != null) {
				this.getHolder().unlockCanvasAndPost(canvas);
			}
		}
	}
}
