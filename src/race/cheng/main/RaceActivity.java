package race.cheng.main;

import static race.cheng.service.Constant.BREAKING;
import static race.cheng.service.Constant.CHOOSE;
import static race.cheng.service.Constant.ENTER_ABOUT_VIEW;
import static race.cheng.service.Constant.ENTER_HELP_VIEW;
import static race.cheng.service.Constant.ENTER_MENU;
import static race.cheng.service.Constant.ENTER_SET_VIEW;
import static race.cheng.service.Constant.ENTER_SOUND;
import static race.cheng.service.Constant.HISTORY;
import static race.cheng.service.Constant.LOADING;
import static race.cheng.service.Constant.OVER;
import static race.cheng.service.Constant.START_GAME;
import static race.cheng.service.Constant.STRIVE;
import static race.cheng.service.Constant.screenRatio854x480;
import static race.cheng.service.Constant.screenRatio800x480;

import java.util.HashMap;
import java.util.Map;

import race.cheng.service.Constant;
import race.cheng.service.RotateUtil;
import race.cheng.view.MyGLSurfaceView;
import race.cheng.view.ViewSoundControl;
import race.cheng.view.ViewAbout;
import race.cheng.view.ViewBreaking;
import race.cheng.view.ViewChoose;
import race.cheng.view.ViewHelp;
import race.cheng.view.ViewHistory;
import race.cheng.view.ViewLoading;
import race.cheng.view.ViewMainMenu;
import race.cheng.view.ViewOver;
import race.cheng.view.ViewSet;
import race.cheng.view.ViewStart;
import race.cheng.view.ViewTry;
import android.app.Activity;
import android.app.Service;
import android.content.pm.ActivityInfo;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.hardware.SensorListener;
import android.hardware.SensorManager;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.SoundPool;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.Vibrator;
import android.util.DisplayMetrics;
import android.view.KeyEvent;
import android.view.Window;
import android.view.WindowManager;
/**
 * 游戏逻辑控制类---主要逻辑都在此处理
 * @author chengkai
 *
 */
public class RaceActivity extends Activity {
	private MyGLSurfaceView mGLSurfaceView;
	ViewStart viewStart;
	ViewSoundControl soundControl;
	ViewMainMenu viewMainMenu;
	ViewSet viewSet;
	ViewHelp viewHelp;
	ViewAbout viewAbout;
	public static ViewLoading loading;
	ViewOver over;
	ViewChoose choose;
	ViewHistory history;
	ViewBreaking breaking;
	ViewTry strive;

	Handler hd;
	public static Resources rs;
	private Vibrator mVibrator;
	// 媒体播放器
	public static MediaPlayer mpBack;
	// 声音池
	public static SoundPool soundPool;
	public static Map<Integer, Integer> soundPoolMap;
	// 音效暂停
	public static boolean pauseFlag = false;
	// 短音控制
	public static boolean soundFlag = true;
	// 是否处于游戏中
	public static boolean inGame = false;
	// 屏幕宽高及比例
	public static float screenHeight;
	public static float screenWidth;
	public static float screenRatio;
	// 屏幕Id
	public static int screenId;
	// 屏幕图片宽
	public static float screenPictureWidth = 480;
	// 屏幕图片自适应偏移量
	public static float screen_xOffset;

	// 是否启用传感器
	public static boolean sensorFlag = true;
	// 返回键控制；默认不可控；因为startView中键盘不可控
	public static boolean keyFlag = false;
	// 当前界面
	public static int viewFlag;
	// 数字数组浅灰白
	public static Bitmap[] number = new Bitmap[12];
	// 传感器管理
	SensorManager mySensorManager;
	// 数字2数组 暗灰
	public static Bitmap[] shu = new Bitmap[11];
	// 姿态传感器监听方向
	private SensorListener mySensorListener = new SensorListener() {

		@Override
		public void onSensorChanged(int sensor, float[] values) {
			if (sensor == SensorManager.SENSOR_ORIENTATION
					&& sensorFlag&& inGame) {
				int[] directionDotXY = RotateUtil.getDirectionDot(
						new double[] { values[0], values[1], values[2] });
				if (directionDotXY[0] > 20) {// right
					MyGLSurfaceView.keyState = MyGLSurfaceView.keyState | 0x4;
				} else if (directionDotXY[0] < -20) {// left
					MyGLSurfaceView.keyState = MyGLSurfaceView.keyState | 0x8;
				} else {// no right no left
					MyGLSurfaceView.keyState = MyGLSurfaceView.keyState & 0x3;
				}
			}
		}

		@Override
		public void onAccuracyChanged(int sensor, int accuracy) {
		}
	};

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		rs = getResources();
		// 灰体数字位图对象0-9
		number[0] = BitmapFactory.decodeResource(rs, R.drawable.zero);
		number[1] = BitmapFactory.decodeResource(rs, R.drawable.one);
		number[2] = BitmapFactory.decodeResource(rs, R.drawable.two);
		number[3] = BitmapFactory.decodeResource(rs, R.drawable.three);
		number[4] = BitmapFactory.decodeResource(rs, R.drawable.four);
		number[5] = BitmapFactory.decodeResource(rs, R.drawable.five);
		number[6] = BitmapFactory.decodeResource(rs, R.drawable.six);
		number[7] = BitmapFactory.decodeResource(rs, R.drawable.seven);
		number[8] = BitmapFactory.decodeResource(rs, R.drawable.eight);
		number[9] = BitmapFactory.decodeResource(rs, R.drawable.nine);
		// 灰体冒号
		number[10] = BitmapFactory.decodeResource(rs, R.drawable.colon);
		// 灰体连字符
		number[11] = BitmapFactory.decodeResource(rs, R.drawable.line);

		// 黑体数字位图对象
		shu[0] = BitmapFactory.decodeResource(rs, R.drawable.shu0);
		shu[1] = BitmapFactory.decodeResource(rs, R.drawable.shu1);
		shu[2] = BitmapFactory.decodeResource(rs, R.drawable.shu2);
		shu[3] = BitmapFactory.decodeResource(rs, R.drawable.shu3);
		shu[4] = BitmapFactory.decodeResource(rs, R.drawable.shu4);
		shu[5] = BitmapFactory.decodeResource(rs, R.drawable.shu5);
		shu[6] = BitmapFactory.decodeResource(rs, R.drawable.shu6);
		shu[7] = BitmapFactory.decodeResource(rs, R.drawable.shu7);
		shu[8] = BitmapFactory.decodeResource(rs, R.drawable.shu8);
		shu[9] = BitmapFactory.decodeResource(rs, R.drawable.shu9);
		// 黑体百分号
		shu[10] = BitmapFactory.decodeResource(rs, R.drawable.baifenhao);
		// 请求横屏
		this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);
		this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
				WindowManager.LayoutParams.FLAG_FULLSCREEN);
		// 获取屏幕分辨率
		DisplayMetrics dm = new DisplayMetrics();
		// 将分辨率信息传递给dm
		getWindowManager().getDefaultDisplay().getMetrics(dm);
		// 计算屏幕宽高
		screenWidth = dm.widthPixels;
		screenHeight = dm.heightPixels;
		float screenHeightTemp = screenHeight;
		float screenWidthTemp = screenWidth;
		// 指定屏幕宽高--指定高度不能大于宽度
		if (screenHeightTemp > screenWidthTemp) {
			screenWidth = screenHeightTemp;
			screenHeight = screenWidthTemp;
		}
		// 计算宽高比
		screenRatio = screenWidth / screenHeight;
		// 根据屏幕分辨率的比例来判断属于哪一种屏幕类型
		if (Math.abs(screenRatio - screenRatio854x480) < 0.01f) {
			screenId = 2;
		} else if (Math.abs(screenRatio - screenRatio800x480) < 0.01f) {
			screenId = 1;
		} else {
			screenId = 0;
		}
		// 初始化振动器
		mVibrator = (Vibrator) this.getApplication().getSystemService(
				Service.VIBRATOR_SERVICE);
		// 初始化声音
		initSounds();
		// 根据实际屏幕宽度计算x轴向上的偏移量
		screen_xOffset = (screenWidth - screenPictureWidth) / 2;

		hd = new Handler() {
			@Override
			public void handleMessage(Message msg) {
				// 根据消息判断进入那个视图界面
				switch (msg.what) {
				case ENTER_SOUND:
					viewFlag = ENTER_SOUND;
					keyFlag = true;
					soundControl = new ViewSoundControl(RaceActivity.this);
					setContentView(soundControl);
					// 设置可触控
					soundControl.setFocusableInTouchMode(true);
					// 请求获焦
					soundControl.requestFocus();
					break;
				case ENTER_MENU:
					viewFlag = ENTER_MENU;
					// 设置键盘可触控
					keyFlag = true;
					viewMainMenu = new ViewMainMenu(RaceActivity.this);
					setContentView(viewMainMenu);
					viewMainMenu.setFocusableInTouchMode(true);
					viewMainMenu.requestFocus();
					break;
			 	case ENTER_SET_VIEW:
					viewFlag = ENTER_SET_VIEW;
					keyFlag = true;
					viewSet = new ViewSet(RaceActivity.this);
					setContentView(viewSet);
					viewSet.setFocusableInTouchMode(true);
					viewSet.requestFocus();
					break;
				case ENTER_HELP_VIEW:
					viewFlag = ENTER_HELP_VIEW;
					keyFlag = true;
					viewHelp = new ViewHelp(RaceActivity.this);
					setContentView(viewHelp);
					viewHelp.setFocusableInTouchMode(true);
					viewHelp.requestFocus();
					break;
				case ENTER_ABOUT_VIEW:
					viewFlag = ENTER_ABOUT_VIEW;
					keyFlag = true;
					viewAbout = new ViewAbout(RaceActivity.this);
					setContentView(viewAbout);
					viewAbout.setFocusableInTouchMode(true);
					viewAbout.requestFocus();
					break;
				case START_GAME:
					viewFlag = START_GAME;
					mGLSurfaceView = new MyGLSurfaceView(RaceActivity.this);
					// 设置3D游戏界面
					setContentView(mGLSurfaceView);
					mGLSurfaceView.setFocusableInTouchMode(true);
					mGLSurfaceView.requestFocus();
					break;
				case LOADING:
					viewFlag = LOADING;
					// 设置键盘不可用
					keyFlag = false;
					loading = new ViewLoading(RaceActivity.this);
					setContentView(loading);
					loading.setFocusableInTouchMode(true);
					loading.requestFocus();
					new Thread() {
						public void run() {
							MyGLSurfaceView.loadObjectVertex();
							toAnotherView(START_GAME);
						}
					}.start();
					break;
				case OVER:
					viewFlag = OVER;
					over = new ViewOver(RaceActivity.this);
					setContentView(over);
					over.setFocusableInTouchMode(true);
					over.requestFocus();
					break;
				case CHOOSE:
					viewFlag = CHOOSE;
					choose = new ViewChoose(RaceActivity.this);
					setContentView(choose);
					choose.setFocusableInTouchMode(true);
					choose.requestFocus();
					break;
				case HISTORY:
					viewFlag = HISTORY;
					history = new ViewHistory(RaceActivity.this);
					setContentView(history);
					history.setFocusableInTouchMode(true);
					history.requestFocus();
					break;
				case BREAKING:
					viewFlag = BREAKING;
					breaking = new ViewBreaking(RaceActivity.this);
					setContentView(breaking);
					breaking.setFocusableInTouchMode(true);
					breaking.requestFocus();
					new Thread() {
						public void run() {
							try {
								Thread.sleep(1000);
							} catch (Exception e) {
								e.printStackTrace();
							}
							// 进入游戏界面
							toAnotherView(OVER);
						}
					}.start();
					break;
				case STRIVE:
					viewFlag = STRIVE;
					strive = new ViewTry(RaceActivity.this);
					setContentView(strive);
					strive.setFocusableInTouchMode(true);
					strive.requestFocus();
					new Thread() {
						public void run() {
							try {
								Thread.sleep(1000);
							} catch (Exception e) {
								e.printStackTrace();
							}
							toAnotherView(OVER);
						}
					}.start();
				}
			}
		};
		viewFlag = Constant.START_VIEW;
		// 创建开始界面
		viewStart = new ViewStart(this);
		// 进入开始界面
		setContentView(viewStart);

		mySensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
	}

	@Override
	protected void onPause() {
		super.onPause();
		mySensorManager.unregisterListener(mySensorListener);
		pauseFlag = true;
		if (soundFlag) {
			mpBack.pause();
		}
		// 恢复键盘状态
		MyGLSurfaceView.keyState = 0;
	}

	@Override
	protected void onResume() {
		super.onResume();
		// 注册姿态传感器
		mySensorManager.registerListener(mySensorListener,
				SensorManager.SENSOR_ORIENTATION,
				SensorManager.SENSOR_DELAY_GAME);
		if (soundFlag && inGame) {
			mpBack.start();
		}
		pauseFlag = false;
		MyGLSurfaceView.keyState = 0;
	}

	public void initSounds() {
		mpBack = MediaPlayer.create(this, R.raw.backsound);
		mpBack.setLooping(true);
		soundPool = new SoundPool(4, AudioManager.STREAM_MUSIC, 100);
		soundPoolMap = new HashMap<Integer, Integer>();
		//声音池的几种短促音
		soundPoolMap.put(1, soundPool.load(this, R.raw.lightsound1, 1));
		//刹车
		soundPoolMap.put(2, soundPool.load(this, R.raw.shache, 1));
		//减油
		soundPoolMap.put(3, soundPool.load(this, R.raw.jianyou, 1));
		//提速
		soundPoolMap.put(4, soundPool.load(this, R.raw.cartisu, 1));
		//撞车
		soundPoolMap.put(6, soundPool.load(this, R.raw.zhuangche, 1));
		
		soundPoolMap.put(7, soundPool.load(this, R.raw.gotobject, 1));
		soundPoolMap.put(8, soundPool.load(this, R.raw.lightsound2, 1));
	}

	/**
	 * 播放短音
	 * 
	 * @param soundId
	 * @param loop
	 */
	public void playSound(int soundId, int loop) {
		if (pauseFlag) {
			return;
		}
		AudioManager mgr = (AudioManager) this.getSystemService(AUDIO_SERVICE);
		float volumnCurr = mgr.getStreamVolume(AudioManager.STREAM_MUSIC);
		float volumnMax = mgr.getStreamMaxVolume(AudioManager.STREAM_MUSIC);
		float volumn = volumnCurr / volumnMax;
		//1和8播放高质量的声音
		if (soundId == 1 || soundId == 8) {
			soundPool.play(soundPoolMap.get(soundId), volumn, volumn, 1, loop,
					1f);
		} else {
			soundPool.play(soundPoolMap.get(soundId), volumn, volumn, 1, loop,
					0.5f);
		}
	}
	//根据视图标志位发送消息；进入相应的视图界面
	public void toAnotherView(int flag) {
		switch (flag) {
		case 0:
			// 声音选择
			hd.sendEmptyMessage(ENTER_SOUND);
			break;
		case 1:
			// 主菜单界面
			hd.sendEmptyMessage(ENTER_MENU);
			break;
		case 2:
			// 设置
			hd.sendEmptyMessage(ENTER_SET_VIEW);
			break;
		case 3:
			// 帮助界面
			hd.sendEmptyMessage(ENTER_HELP_VIEW);
			break;
		case 4:
			//关于界面
			hd.sendEmptyMessage(ENTER_ABOUT_VIEW);
			break;
		case 5:
			//开始游戏界面
			hd.sendEmptyMessage(START_GAME);
			break;
		case 6:
			//加载界面
			hd.sendEmptyMessage(LOADING);
			break;
		case 8:
			//结束界面
			hd.sendEmptyMessage(OVER);
			break;
		case 9:
			//选择界面
			hd.sendEmptyMessage(CHOOSE);
			break;
		case 10:
			//历史记录界面
			hd.sendEmptyMessage(HISTORY);
			break;
		case 11:
			//冲破记录界面
			hd.sendEmptyMessage(BREAKING);
			break;
		case 12:
			//再接再厉界面
			hd.sendEmptyMessage(STRIVE);
			break;
		}
	}

	public boolean onKeyDown(int keyCode, KeyEvent event) {
		if (!keyFlag) {
			return true;
		}
		if (keyCode == KeyEvent.KEYCODE_BACK) {
			switch (viewFlag) {
			//当前界面为设置界面、声音选择界面、结束、选择界面是按下返回键将进入菜单界面
			case ENTER_SET_VIEW:
			case ENTER_SOUND:
			case OVER:
			case CHOOSE:
				toAnotherView(ENTER_MENU);
				break;
				//如果是帮助界面、多页、主要是回退页面
			case ENTER_HELP_VIEW:
				if (ViewHelp.viewFlag == 0) {
					toAnotherView(ENTER_MENU);
					ViewHelp.hvt.flag = false;
				} else if (ViewHelp.viewFlag == 1) {
					ViewHelp.viewFlag = 0;
				} else if (ViewHelp.viewFlag == 2) {
					ViewHelp.viewFlag = 1;
				} else if (ViewHelp.viewFlag == 3) {
					ViewHelp.viewFlag = 2;
				} else if (ViewHelp.viewFlag == 4) {
					ViewHelp.viewFlag = 3;
				} else if (ViewHelp.viewFlag == 5) {
					ViewHelp.viewFlag = 4;
				} else if (ViewHelp.viewFlag == 6) {
					ViewHelp.viewFlag = 5;
				}
				break;
				//如果是关于界面
			case ENTER_ABOUT_VIEW:
				if (ViewAbout.viewFlag == 0) {
					// 返回菜单界面
					toAnotherView(ENTER_MENU);
					ViewAbout.avt.flag = false;
				} else if (ViewAbout.viewFlag == 1) {
					ViewAbout.viewFlag = 0;
				}
				break;
			case HISTORY:
				// 返回选择界面
				toAnotherView(CHOOSE);
				break;
			case BREAKING:
			case STRIVE:
				toAnotherView(OVER);
				break;
			case ENTER_MENU:
				// 菜单界面按返回键退出游戏、0正常退出进程
				System.exit(0);
				break;
			}
			return true;
		}
		return false;
	}

	/**
	 * 触发震动
	 */
	public void vibrator() {
		mVibrator.vibrate(new long[] { 100, 10, 100, 1000 }, -1);
	}
}