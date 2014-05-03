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
 * ��Ϸ�߼�������---��Ҫ�߼����ڴ˴���
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
	// ý�岥����
	public static MediaPlayer mpBack;
	// ������
	public static SoundPool soundPool;
	public static Map<Integer, Integer> soundPoolMap;
	// ��Ч��ͣ
	public static boolean pauseFlag = false;
	// ��������
	public static boolean soundFlag = true;
	// �Ƿ�����Ϸ��
	public static boolean inGame = false;
	// ��Ļ��߼�����
	public static float screenHeight;
	public static float screenWidth;
	public static float screenRatio;
	// ��ĻId
	public static int screenId;
	// ��ĻͼƬ��
	public static float screenPictureWidth = 480;
	// ��ĻͼƬ����Ӧƫ����
	public static float screen_xOffset;

	// �Ƿ����ô�����
	public static boolean sensorFlag = true;
	// ���ؼ����ƣ�Ĭ�ϲ��ɿأ���ΪstartView�м��̲��ɿ�
	public static boolean keyFlag = false;
	// ��ǰ����
	public static int viewFlag;
	// ��������ǳ�Ұ�
	public static Bitmap[] number = new Bitmap[12];
	// ����������
	SensorManager mySensorManager;
	// ����2���� ����
	public static Bitmap[] shu = new Bitmap[11];
	// ��̬��������������
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
		// ��������λͼ����0-9
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
		// ����ð��
		number[10] = BitmapFactory.decodeResource(rs, R.drawable.colon);
		// �������ַ�
		number[11] = BitmapFactory.decodeResource(rs, R.drawable.line);

		// ��������λͼ����
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
		// ����ٷֺ�
		shu[10] = BitmapFactory.decodeResource(rs, R.drawable.baifenhao);
		// �������
		this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);
		this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
				WindowManager.LayoutParams.FLAG_FULLSCREEN);
		// ��ȡ��Ļ�ֱ���
		DisplayMetrics dm = new DisplayMetrics();
		// ���ֱ�����Ϣ���ݸ�dm
		getWindowManager().getDefaultDisplay().getMetrics(dm);
		// ������Ļ���
		screenWidth = dm.widthPixels;
		screenHeight = dm.heightPixels;
		float screenHeightTemp = screenHeight;
		float screenWidthTemp = screenWidth;
		// ָ����Ļ���--ָ���߶Ȳ��ܴ��ڿ��
		if (screenHeightTemp > screenWidthTemp) {
			screenWidth = screenHeightTemp;
			screenHeight = screenWidthTemp;
		}
		// �����߱�
		screenRatio = screenWidth / screenHeight;
		// ������Ļ�ֱ��ʵı������ж�������һ����Ļ����
		if (Math.abs(screenRatio - screenRatio854x480) < 0.01f) {
			screenId = 2;
		} else if (Math.abs(screenRatio - screenRatio800x480) < 0.01f) {
			screenId = 1;
		} else {
			screenId = 0;
		}
		// ��ʼ������
		mVibrator = (Vibrator) this.getApplication().getSystemService(
				Service.VIBRATOR_SERVICE);
		// ��ʼ������
		initSounds();
		// ����ʵ����Ļ��ȼ���x�����ϵ�ƫ����
		screen_xOffset = (screenWidth - screenPictureWidth) / 2;

		hd = new Handler() {
			@Override
			public void handleMessage(Message msg) {
				// ������Ϣ�жϽ����Ǹ���ͼ����
				switch (msg.what) {
				case ENTER_SOUND:
					viewFlag = ENTER_SOUND;
					keyFlag = true;
					soundControl = new ViewSoundControl(RaceActivity.this);
					setContentView(soundControl);
					// ���ÿɴ���
					soundControl.setFocusableInTouchMode(true);
					// �����
					soundControl.requestFocus();
					break;
				case ENTER_MENU:
					viewFlag = ENTER_MENU;
					// ���ü��̿ɴ���
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
					// ����3D��Ϸ����
					setContentView(mGLSurfaceView);
					mGLSurfaceView.setFocusableInTouchMode(true);
					mGLSurfaceView.requestFocus();
					break;
				case LOADING:
					viewFlag = LOADING;
					// ���ü��̲�����
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
							// ������Ϸ����
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
		// ������ʼ����
		viewStart = new ViewStart(this);
		// ���뿪ʼ����
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
		// �ָ�����״̬
		MyGLSurfaceView.keyState = 0;
	}

	@Override
	protected void onResume() {
		super.onResume();
		// ע����̬������
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
		//�����صļ��̴ֶ���
		soundPoolMap.put(1, soundPool.load(this, R.raw.lightsound1, 1));
		//ɲ��
		soundPoolMap.put(2, soundPool.load(this, R.raw.shache, 1));
		//����
		soundPoolMap.put(3, soundPool.load(this, R.raw.jianyou, 1));
		//����
		soundPoolMap.put(4, soundPool.load(this, R.raw.cartisu, 1));
		//ײ��
		soundPoolMap.put(6, soundPool.load(this, R.raw.zhuangche, 1));
		
		soundPoolMap.put(7, soundPool.load(this, R.raw.gotobject, 1));
		soundPoolMap.put(8, soundPool.load(this, R.raw.lightsound2, 1));
	}

	/**
	 * ���Ŷ���
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
		//1��8���Ÿ�����������
		if (soundId == 1 || soundId == 8) {
			soundPool.play(soundPoolMap.get(soundId), volumn, volumn, 1, loop,
					1f);
		} else {
			soundPool.play(soundPoolMap.get(soundId), volumn, volumn, 1, loop,
					0.5f);
		}
	}
	//������ͼ��־λ������Ϣ��������Ӧ����ͼ����
	public void toAnotherView(int flag) {
		switch (flag) {
		case 0:
			// ����ѡ��
			hd.sendEmptyMessage(ENTER_SOUND);
			break;
		case 1:
			// ���˵�����
			hd.sendEmptyMessage(ENTER_MENU);
			break;
		case 2:
			// ����
			hd.sendEmptyMessage(ENTER_SET_VIEW);
			break;
		case 3:
			// ��������
			hd.sendEmptyMessage(ENTER_HELP_VIEW);
			break;
		case 4:
			//���ڽ���
			hd.sendEmptyMessage(ENTER_ABOUT_VIEW);
			break;
		case 5:
			//��ʼ��Ϸ����
			hd.sendEmptyMessage(START_GAME);
			break;
		case 6:
			//���ؽ���
			hd.sendEmptyMessage(LOADING);
			break;
		case 8:
			//��������
			hd.sendEmptyMessage(OVER);
			break;
		case 9:
			//ѡ�����
			hd.sendEmptyMessage(CHOOSE);
			break;
		case 10:
			//��ʷ��¼����
			hd.sendEmptyMessage(HISTORY);
			break;
		case 11:
			//���Ƽ�¼����
			hd.sendEmptyMessage(BREAKING);
			break;
		case 12:
			//�ٽ���������
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
			//��ǰ����Ϊ���ý��桢����ѡ����桢������ѡ������ǰ��·��ؼ�������˵�����
			case ENTER_SET_VIEW:
			case ENTER_SOUND:
			case OVER:
			case CHOOSE:
				toAnotherView(ENTER_MENU);
				break;
				//����ǰ������桢��ҳ����Ҫ�ǻ���ҳ��
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
				//����ǹ��ڽ���
			case ENTER_ABOUT_VIEW:
				if (ViewAbout.viewFlag == 0) {
					// ���ز˵�����
					toAnotherView(ENTER_MENU);
					ViewAbout.avt.flag = false;
				} else if (ViewAbout.viewFlag == 1) {
					ViewAbout.viewFlag = 0;
				}
				break;
			case HISTORY:
				// ����ѡ�����
				toAnotherView(CHOOSE);
				break;
			case BREAKING:
			case STRIVE:
				toAnotherView(OVER);
				break;
			case ENTER_MENU:
				// �˵����水���ؼ��˳���Ϸ��0�����˳�����
				System.exit(0);
				break;
			}
			return true;
		}
		return false;
	}

	/**
	 * ������
	 */
	public void vibrator() {
		mVibrator.vibrate(new long[] { 100, 10, 100, 1000 }, -1);
	}
}