package race.cheng.service;

import race.cheng.main.R;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;

/**
 * ����������
 * 
 * @author chengkai
 * 
 */
public class Constant {
	/**
	 * ����ѡ�����
	 */
	public static final int ENTER_SOUND = 0;
	/**
	 * ���˵�����
	 */
	public static final int ENTER_MENU = 1;
	/**
	 * ���ý���
	 */
	public static final int ENTER_SET_VIEW = 2;
	/**
	 * ��������
	 */
	public static final int ENTER_HELP_VIEW = 3;
	/**
	 * ���ڽ���
	 */
	public static final int ENTER_ABOUT_VIEW = 4;
	/**
	 * ��Ϸ��ʼ����
	 */
	public static final int START_GAME = 5;
	/**
	 * ��Ϸ���ؽ���
	 */
	public static final int LOADING = 6;
	/**
	 * �ҶȽ������
	 */
	public static final int START_VIEW = 7;
	/**
	 * ��������
	 */
	public static final int OVER = 8;
	/**
	 * ѡ�����
	 */
	public static final int CHOOSE = 9;
	/**
	 * ��ʷ����
	 */
	public static final int HISTORY = 10;
	/**
	 * �Ƽ�¼����
	 */
	public static final int BREAKING = 11;
	/**
	 * �ٽ���������
	 */
	public static final int STRIVE = 12;
	/**
	 * ½�ص�λ��С
	 */
	public static final float UNIT_SIZE = 12f;
	/**
	 * ½����߸߶�
	 */
	public static final float LAND_HIGHEST = 160F;
	/**
	 * �����ʻȦ��
	 */
	public static final int MAX_QUANSHU = 2;
	// ������λ��
	public static float CAR_X;
	public static float CAR_Y = 26f;
	public static float CAR_Z;
	/**
	 * �������ٶ�
	 */
	public static float CAR_SPEED_SPAN = 0.4f;
	// ����������ٶ�
	public static float CAR_MAX_SPEED = 20;
	// ������̥��ƫ����
	public static float WHEEL_X_OFFSET = 7.5f;
	public static float WHEEL_Y_OFFSET = 0.0f;
	public static float WHEEL_Z_OFFSET = 12.5f;
	/**
	 * ��ʼ���߷���Z�Ḻ����Ϊ0�ȣ���y��������ת
	 */
	public static final float DIRECTION_INI = -90F;
	/**
	 * �����λ�ã�����۲���Ŀ����ƽ�����
	 */
	public static final float DISTANCE_CAMERA_TARGET = 2.0F;
	/**
	 * ������ƶ�����
	 */
	public static float MOVE_SPAN = 8F;
	/**
	 * �������ת�ǶȲ���
	 */
	public static float DEGREE_SPAN = 3F;
	// ɽ����
	public static short[][] SyArray;
	// ��������
	public static short[][] CyArray;
	// ƽԭ����
	public static short[][] PyArray;
	// ��������repeat����
	public static final float TRACK_REPEAT = 1.0F;
	// ������Ƥ����ͼ�ļ��з�Χ
	public static final float S = 1.0f;
	public static final float T = 1.0f;
	// ½�ز�������
	public static int COLS;
	// ½�ز�������
	public static int ROWS;
	// ½�ز�����
	public static float X_SPAN;
	// ½�ز�����
	public static float Z_SPAN;
	// ��·���
	public static float ROAD_W;
	/**
	 * ����X����ԭʼƫ����
	 */
	public static float X_OFFSET;
	/**
	 * ����ԭʼZƫ����
	 */
	public static float Z_OFFSET;
	/**
	 * ������ʼλ��X����
	 */
	public static float RACE_BEGIN_X;
	/**
	 * ������ʼZ����
	 */
	public static float RACE_BEGIN_Z;
	/**
	 * ������Ȧ��λ��X����
	 */
	public static float RACE_HALF_X;
	/**
	 * ������Ȧ��Z����
	 */
	public static float RACE_HALF_Z;
	/**
	 * ��ͼ����������---�ɵ�ͼ��������������--����ƽԭ��ɽ�ء�����
	 */
	public static byte[][] MAP_LEVEL0 = {
			{ 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
			{ 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0 },
			{ 0, 0, 0, 0, 0, 0, 0, 0, 2, 0, 0, 0, 0, 0, 0, 0 },
			{ 0, 0, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
			{ 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0 },
			{ 0, 0, 1, 0, 0, 0, 0, 2, 0, 0, 0, 0, 0, 1, 0, 0 },
			{ 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0 },
			{ 0, 0, 0, 0, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
			{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
			{ 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 1, 0, 2, 0, 0, 0 },
			{ 0, 0, 0, 0, 0, 0, 1, 0, 0, 2, 0, 0, 0, 0, 0, 0 },
			{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0 },
			{ 0, 0, 0, 0, 1, 0, 0, 2, 0, 0, 0, 0, 0, 2, 0, 0 },
			{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2, 0, 0, 0, 0 },
			{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0 },
			{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 }, };
	/**
	 * ��ͼ��������---�����������ֱ��
	 */
	public static byte[][] MAP_LEVEL1 = {
			{ -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 },
			{ -1, 5, 0, 0, 0, 0, 0, 2, -1, 5, 0, 0, 0, 2, -1, -1 },
			{ -1, 1, -1, -1, -1, -1, -1, 1, -1, 1, -1, -1, 9, 3, -1, -1 },
			{ -1, 1, -1, -1, -1, -1, -1, 8, 0, 7, -1, -1, 1, -1, -1, -1 },
			{ -1, 4, 0, 6, -1, -1, -1, -1, -1, -1, -1, -1, 8, 0, 2, -1 },
			{ -1, -1, -1, 1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 1, -1 },
			{ -1, -1, -1, 4, 0, 0, 6, -1, -1, -1, -1, -1, -1, 9, 3, -1 },
			{ -1, -1, -1, -1, -1, -1, 1, -1, -1, -1, -1, -1, -1, 1, -1, -1 },
			{ -1, -1, -1, -1, -1, -1, 1, -1, -1, -1, -1, 9, 0, 3, -1, -1 },
			{ -1, -1, -1, -1, 5, 0, 7, -1, -1, -1, -1, 1, -1, -1, -1, -1 },
			{ -1, -1, -1, -1, 1, -1, -1, 9, 6, -1, -1, 8, 0, 0, 2, -1 },
			{ -1, -1, -1, 5, 7, -1, 9, 3, 1, -1, -1, -1, -1, -1, 1, -1 },
			{ -1, -1, 5, 7, -1, -1, 1, -1, 1, 9, 0, 0, 6, -1, 1, -1 },
			{ -1, -1, 1, -1, -1, -1, 1, -1, 1, 1, -1, -1, 4, 0, 3, -1 },
			{ -1, -1, 4, 0, 0, 0, 3, -1, 4, 3, -1, -1, -1, -1, -1, -1 },
			{ -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 } };
	/**
	 * ������ֲ���������ײ��⣻Բ��ƫ�����������
	 */
	public static int[][] WD_COLL = { { -1, -1, 1, 1 }, { 1, -1, -1, 1 } };
	/**
	 * 480*320��߱�
	 */
	public static final float screenRatio480x320 = 1.333f;
	/**
	 * 800*480��߱�
	 */
	public static final float screenRatio800x480 = 1.667f;
	/**
	 * 854*480��߱�
	 */
	public static final float screenRatio854x480 = 1.779f;

	public static float WT = 0.05f;
	/**
	 * ���ⰴ����������
	 */
	public static float[][] XNAN_ON_TOUCH = {
			// 480x320
			{ 0.488f - WT, 0.631f + WT, 0.883f - WT, 0.973f + WT, // ǰ��
					0.763f - WT, 0.9f + WT, 0.881f - WT, 0.973f + WT, // ����
					0.159f, 0.319f, 0.019f, 0.121f, // M
					0.356f, 0.519f, 0.019f, 0.121f, // Q
					0.55f, 0.716f, 0.019f, 0.121f // S
			}, {// 800x480
			0.488f - WT, 0.631f + WT, 0.905f - WT, 0.985f + WT, // ǰ��
					0.763f - WT, 0.902f + WT, 0.905f - WT, 0.985f + WT, // ����
					0.163f, 0.321f, 0.008f, 0.1f, // M
					0.356f, 0.519f, 0.008f, 0.1f, // Q
					0.552f, 0.715f, 0.008f, 0.1f // S
			}, {// 854x480
			0.488f - WT, 0.633f + WT, 0.903f - WT, 0.98f + WT, // ǰ��`
					0.76f - WT, 0.902f + WT, 0.903f - WT, 0.98f + WT, // ����
					0.16f, 0.321f, 0.013f, 0.101f, // M
					0.356f, 0.519f, 0.013f, 0.101f, // Q
					0.552f, 0.717f, 0.013f, 0.101f // S
			} };
	/**
	 * ���ⰴťƽ������ // ��ʱ���������ͼ��M��Q��S���Ǳ��̣�UP��DOWN
	 */
	public static float[][] XNAN_TRASLATE = {
			{ 0, -3.3f, 8.5f, -10, 23.0f, 13.0f, -20f, -4.5f, 2f, -3.5f, -4.5f,
					0.9f, -3.5f, -4.5f, -0.2f, -3.5f, -4.3f, -1.5f, -3.5f,
					4.5f, 0.2f, -3.5f, 4.5f, -1.3f, -3.5f },
			{ 1, -5.0f, 8.5f, -10, 27.0f, 13.0f, -20f, -5.2f, 2f, -3.5f, -5.2f,
					0.9f, -3.5f, -5.2f, -0.2f, -3.5f, -5.0f, -1.5f, -3.5f,
					5.2f, 0.2f, -3.5f, 5.2f, -1.3f, -3.5f },
			{ 2, -6.5f, 8.5f, -10, 29.0f, 13.0f, -20f, -5.5f, 2f, -3.5f, -5.5f,
					0.9f, -3.5f, -5.5f, -0.2f, -3.5f, -5.3f, -1.5f, -3.5f,
					5.5f, 0.2f, -3.5f, 5.5f, -1.3f, -3.5f } };
	// ������ײ�����б�
	public static float[][] PART_LIST;
	// ��
	public static float[][] TREE_LIST;

	// ��ͧ�б�
	public static float[][] AIRSHIP_LIST;
	// ��ײ����
	public static float[][] KEZHUANG_LIST;
	// ��ײ�����뾶
	public static float[] KZBJBJ = { 20f * 20f, 25 * 25, 20 * 20 };
	// ���ٵ��ɰ뾶
	public static float JJSTHBJ = 20f * 20f;
	// ƽԭ�����ߴ�
	public static float PLAIN_SIZE;
	// �����б�
	public static float[][] SPEED_SPRING_LIST;

	/**
	 * ��½�ش�С��ص�����֮���ʼ��
	 * 
	 * @param res
	 */
	public static void initConstant(Resources res) {
		SyArray = loadLandforms(res, R.drawable.shan);
		CyArray = loadLandforms(res, R.drawable.chitang);
		PyArray = loadLandforms(res, R.drawable.py);
		// ���������С����½�ص��к���
		COLS = PyArray[0].length - 1;
		ROWS = PyArray.length - 1;
		// ������С
		X_SPAN = COLS * UNIT_SIZE;
		Z_SPAN = ROWS * UNIT_SIZE;

		CAR_X = X_SPAN * 2.5F;
		CAR_Z = Z_SPAN * 1.5F;

		RACE_BEGIN_X = 2.8F * X_SPAN;
		RACE_BEGIN_Z = 1.5F * X_SPAN;

		RACE_HALF_X = 14.5F * X_SPAN;
		RACE_HALF_Z = 13.5F * X_SPAN;

		PLAIN_SIZE = ROWS * UNIT_SIZE;

		X_OFFSET = -UNIT_SIZE * COLS / 2;
		Z_OFFSET = -UNIT_SIZE * ROWS / 2;
		// ��·���
		ROAD_W = 0.6F * X_SPAN;

		PART_LIST = new float[][] {
				{ 1, 11, 0, 11.5f * X_SPAN, 0, 1.5f * X_SPAN, 90 },
				{ 2, 8, 1, 8.5f * X_SPAN - 120, 0, 2.5f * X_SPAN + 110, -45 },
				{ 2, 2, 2, 2.5f * X_SPAN, 0, 2.5f * X_SPAN - 220, 0 },
				{ 14, 4, 0, 4.5f * X_SPAN, 0, 14.5f * X_SPAN, 90 },
				{ 1, 2, 3, 2.8f * X_SPAN, 2.5f, 1.5f * X_SPAN, 90 },
				{ 0, 5, 4, 5.5f * X_SPAN, 0, 0.5f * X_SPAN + 230, 0, 1 },
				{ 2, 6, 5, 6.5f * X_SPAN, 0, 2.5f * X_SPAN - 170, 180 },
				{ 9, 13, 5, 13.5f * X_SPAN - 100, 0, 9.5f * X_SPAN, -90 },
				{ 9, 12, 1, 12.5f * X_SPAN - 120, 0, 9.5f * X_SPAN + 110, -45 },
				{ 7, 4, 5, 5.5f * X_SPAN - 100, 0, 7.5f * X_SPAN, -180 },
				{ 7, 4, 1, 4.5f * X_SPAN - 120, 0, 7.5f * X_SPAN + 110, -45 },
				{ 3, 3, 5, 3.5f * X_SPAN - 100, 0, 3.5f * X_SPAN, -90 },
				{ 3, 11, 5, 11.5f * X_SPAN - 170, 0, 3.5f * X_SPAN, 90 },
				{ 5, 8, 5, 8.5f * X_SPAN - 100, 0, 5.5f * X_SPAN, -90 },
				{ 11, 9, 5, 9.5f * X_SPAN - 170, 0, 11.5f * X_SPAN, -90 },
				{ 13, 7, 5, 7.5f * X_SPAN, 0, 13.5f * X_SPAN - 100, 180 },
				{ 13, 10, 5, 10.5f * X_SPAN, 0, 13.5f * X_SPAN - 170, 180 },
				{ 3, 2, 1, 2.5f * X_SPAN - 120, 0, 3.5f * X_SPAN + 110, -45 },
				{ 5, 7, 1, 7.5f * X_SPAN - 120, 0, 5.5f * X_SPAN + 110, -45 },
				{ 10, 9, 1, 9.5f * X_SPAN - 120, 0, 10.5f * X_SPAN + 110, -45 },
				{ 12, 7, 1, 7.5f * X_SPAN - 120, 0, 12.5f * X_SPAN + 110, -45 },
				{ 13, 11, 1, 11.5f * X_SPAN - 120, 0, 13.5f * X_SPAN + 110, -45 },
				{ 3, 13, 4, 13.5f * X_SPAN, 0, 3.5f * X_SPAN + 230, 0, 2 },
				{ 4, 8, 4, 8.5f * X_SPAN, 0, 4.5f * X_SPAN - 230, 0, 3 },
				{ 5, 4, 4, 4.5f * X_SPAN, 0, 5.5f * X_SPAN + 230, 0, 4 },
				{ 7, 12, 4, 12.5f * X_SPAN, 0, 7.5f * X_SPAN + 230, 0, 5 },
				{ 8, 5, 4, 5.5f * X_SPAN, 0, 8.5f * X_SPAN + 230, 0, 0 },
				{ 14, 13, 4, 13.5f * X_SPAN, 0, 14.5f * X_SPAN - 230, 0, 1 },
				{ 1, 2, 6, 2.8f * X_SPAN, 0, 2.5f * X_SPAN - 230, -90, 2 },
				{ 1, 7, 6, 7.0f * X_SPAN, 0, 2.5f * X_SPAN - 230, -90, 1 },
				{ 3, 7, 6, 6.5f * X_SPAN + 230, 0, 3.0f * X_SPAN, -180, 0 },
				{ 1, 9, 6, 10.5f * X_SPAN - 230, 0, 2.0f * X_SPAN, 0, 4 },
				{ 1, 13, 6, 13.0f * X_SPAN, 0, 2.5f * X_SPAN - 230, -90, 1 },
				{ 3, 12, 6, 11.5f * X_SPAN + 230, 0, 4.0f * X_SPAN, -180, 0 },
				{ 4, 13, 6, 14f * X_SPAN, 0, 5.5f * X_SPAN - 230, -90, 1 },
				{ 7, 13, 6, 12.5f * X_SPAN + 230, 0, 8.0f * X_SPAN, -180, 1 },
				{ 8, 12, 6, 12.0f * X_SPAN, 0, 7.5f * X_SPAN + 230, 90, 0 },
				{ 10, 13, 6, 14.0f * X_SPAN, 0, 9.5f * X_SPAN + 230, 90, 1 },
				{ 12, 14, 6, 15.5f * X_SPAN - 230, 0, 13.0f * X_SPAN, 0, 1 },
				{ 12, 10, 6, 10.0f * X_SPAN, 0, 11.5f * X_SPAN + 230, 90, 0 },
				{ 13, 9, 6, 8.5f * X_SPAN + 230, 0, 14.0f * X_SPAN, -180, 1 },
				{ 10, 8, 6, 9.5f * X_SPAN - 230, 0, 11.0f * X_SPAN, 0, 0 },
				{ 13, 6, 6, 5.5f * X_SPAN + 230, 0, 14.0f * X_SPAN, 180, 4 },
				{ 14, 2, 6, 3.0f * X_SPAN, 0, 13.5f * X_SPAN + 230, 90, 1 },
				{ 12, 2, 6, 3.5f * X_SPAN - 230, 0, 13.0f * X_SPAN, 0, 1 },
				{ 9, 4, 6, 5.5f * X_SPAN - 230, 0, 10.0f * X_SPAN, 0, 1 },
				{ 9, 5, 6, 6.0f * X_SPAN, 0, 10.5f * X_SPAN - 230, -90, 0 },
				{ 6, 6, 6, 7.5f * X_SPAN - 230, 0, 7.0f * X_SPAN, 0, 0 },
				{ 6, 4, 6, 4.0f * X_SPAN, 0, 5.5f * X_SPAN + 230, 90, 1 },
				{ 5, 3, 6, 4.5f * X_SPAN - 230, 0, 5.0f * X_SPAN, 0, 0 },
				{ 4, 1, 6, 2.0f * X_SPAN, 0, 3.5f * X_SPAN + 230, 90, 1 },
				{ 1, 1, 6, 2.5f * X_SPAN - 230, 0, 2.0f * X_SPAN, 0, 1 },
				{ 3, 8, 6, 9.0f * X_SPAN, 0, 4.5f * X_SPAN - 230, -90, 0 },
				{ 9, 11, 6, 10.5f * X_SPAN + 230, 0, 10.0f * X_SPAN, -180, 0 },
				{ 13, 12, 6, 13.0f * X_SPAN, 0, 14.5f * X_SPAN - 230, -90, 1 },
				{ 1, 2, 7, 2.8f * X_SPAN, 0, 0.5f * X_SPAN + 230, -90, 0 } };

		TREE_LIST = new float[][] {
				// 0��ֱ·��ʻ�������
				{ 1, 3, 3.0f * X_SPAN, 0, 0.5f * X_SPAN + 240, 0, 0 },
				{ 1, 3, 3.25f * X_SPAN, 0, 0.5f * X_SPAN + 240, 0, 1 },
				{ 1, 3, 3.5f * X_SPAN, 0, 0.5f * X_SPAN + 240, 0, 0 },
				{ 1, 3, 3.75f * X_SPAN, 0, 0.5f * X_SPAN + 240, 0, 1 },
				{ 1, 3, 4.0f * X_SPAN, 0, 0.5f * X_SPAN + 240, 0, 0 },

				// 0��ֱ·��ʻ�����Ҳ�
				{ 1, 3, 3.0f * X_SPAN, 0, 2.5f * X_SPAN - 240, 0, 0 },
				{ 1, 3, 3.25f * X_SPAN, 0, 2.5f * X_SPAN - 240, 0, 1 },
				{ 1, 3, 3.5f * X_SPAN, 0, 2.5f * X_SPAN - 240, 0, 0 },
				{ 1, 3, 3.75f * X_SPAN, 0, 2.5f * X_SPAN - 240, 0, 1 },
				{ 1, 3, 4.0f * X_SPAN, 0, 2.5f * X_SPAN - 240, 0, 0 },

				// 1��ֱ·��ʻ�������
				{ 2, 7, 8.5f * X_SPAN - 240, 0, 2.0f * X_SPAN, 0, 0 },
				{ 2, 7, 8.5f * X_SPAN - 240, 0, 2.25f * X_SPAN, 0, 1 },
				{ 2, 7, 8.5f * X_SPAN - 240, 0, 2.5f * X_SPAN, 0, 0 },
				{ 2, 7, 8.5f * X_SPAN - 240, 0, 2.75f * X_SPAN, 0, 1 },
				{ 2, 7, 8.5f * X_SPAN - 240, 0, 3.0f * X_SPAN, 0, 0 },

				// 1��ֱ·��ʻ�����Ҳ�
				{ 2, 7, 6.5f * X_SPAN + 240, 0, 2.0f * X_SPAN, 0, 0 },
				{ 2, 7, 6.5f * X_SPAN + 240, 0, 2.25f * X_SPAN, 0, 1 },
				{ 2, 7, 6.5f * X_SPAN + 240, 0, 2.5f * X_SPAN, 0, 0 },
				{ 2, 7, 6.5f * X_SPAN + 240, 0, 2.75f * X_SPAN, 0, 1 },
				{ 2, 7, 6.5f * X_SPAN + 240, 0, 3.0f * X_SPAN, 0, 0 },

				// 2,6����·��ʻ����
				{ 1, 7, 7.25f * X_SPAN, 0, 0.5f * X_SPAN + 250, 0, 1 },
				{ 1, 7, 7.5f * X_SPAN, 0, 0.5f * X_SPAN + 300, 0, 0 },
				{ 1, 7, 7.78f * X_SPAN, 0, 0.5f * X_SPAN + 430, 0, 1 },

				// 4,8����·��ʻ����
				{ 3, 7, 7.22f * X_SPAN, 0, 4.5f * X_SPAN - 430, 0, 1 },
				{ 3, 7, 7.5f * X_SPAN, 0, 4.5f * X_SPAN - 300, 0, 0 },
				{ 3, 7, 7.75f * X_SPAN, 0, 4.5f * X_SPAN - 250, 0, 1 },

				// 3,7����·��ʻ����
				{ 3, 9, 9.25f * X_SPAN, 0, 4.5f * X_SPAN - 250, 0, 1 },
				{ 3, 9, 9.5f * X_SPAN, 0, 4.5f * X_SPAN - 300, 0, 0 },
				{ 3, 9, 9.78f * X_SPAN, 0, 4.5f * X_SPAN - 430, 0, 1 },

				// 5,9����·��ʻ����
				{ 1, 9, 9.22f * X_SPAN, 0, 0.5f * X_SPAN + 430, 0, 1 },
				{ 1, 9, 9.5f * X_SPAN, 0, 0.5f * X_SPAN + 300, 0, 0 },
				{ 1, 9, 9.75f * X_SPAN, 0, 0.5f * X_SPAN + 250, 0, 1 },

				// ��ʻ�������
				{ 1, 4, 4.25f * X_SPAN, 0, 0.5f * X_SPAN + 240, 0, 1 },
				{ 1, 4, 4.5f * X_SPAN, 0, 0.5f * X_SPAN + 240, 0, 0 },
				{ 1, 4, 4.75f * X_SPAN, 0, 0.5f * X_SPAN + 240, 0, 1 },
				{ 1, 4, 5.0f * X_SPAN, 0, 0.5f * X_SPAN + 240, 0, 0 },
				{ 1, 5, 5.25f * X_SPAN, 0, 0.5f * X_SPAN + 240, 0, 1 },
				{ 1, 5, 5.5f * X_SPAN, 0, 0.5f * X_SPAN + 240, 0, 0 },
				{ 1, 5, 5.75f * X_SPAN, 0, 0.5f * X_SPAN + 240, 0, 1 },
				{ 1, 5, 6.0f * X_SPAN, 0, 0.5f * X_SPAN + 240, 0, 0 },
				{ 1, 6, 6.25f * X_SPAN, 0, 0.5f * X_SPAN + 240, 0, 1 },
				{ 1, 6, 6.5f * X_SPAN, 0, 0.5f * X_SPAN + 240, 0, 0 },
				{ 1, 6, 6.75f * X_SPAN, 0, 0.5f * X_SPAN + 240, 0, 1 },
				{ 1, 6, 7.0f * X_SPAN, 0, 0.5f * X_SPAN + 240, 0, 0 },

				{ 3, 8, 8.0f * X_SPAN, 0, 2.5f * X_SPAN + 240, 0, 0 },
				{ 3, 8, 8.25f * X_SPAN, 0, 2.5f * X_SPAN + 240, 0, 1 },
				{ 3, 8, 8.5f * X_SPAN, 0, 2.5f * X_SPAN + 240, 0, 0 },
				{ 3, 8, 8.75f * X_SPAN, 0, 2.5f * X_SPAN + 240, 0, 1 },
				{ 3, 8, 9.0f * X_SPAN, 0, 2.5f * X_SPAN + 240, 0, 0 },

				{ 2, 9, 8.5f * X_SPAN + 240, 0, 2.0f * X_SPAN, 0, 0 },
				{ 2, 9, 8.5f * X_SPAN + 240, 0, 2.25f * X_SPAN, 0, 1 },
				{ 2, 9, 8.5f * X_SPAN + 240, 0, 2.5f * X_SPAN, 0, 0 },
				{ 2, 9, 8.5f * X_SPAN + 240, 0, 2.75f * X_SPAN, 0, 1 },
				{ 2, 9, 8.5f * X_SPAN + 240, 0, 3.0f * X_SPAN, 0, 0 },

				{ 1, 13, 13.25f * X_SPAN, 0, 0.5f * X_SPAN + 250, 0, 3 },
				{ 1, 13, 13.5f * X_SPAN, 0, 0.5f * X_SPAN + 300, 0, 2 },
				{ 1, 13, 13.78f * X_SPAN, 0, 0.5f * X_SPAN + 430, 0, 3 },

				{ 1, 13, 12.5f * X_SPAN + 240, 0, 2.0f * X_SPAN, 0, 2 },// ����·֮�䣬�����ڲ�
				{ 2, 13, 13f * X_SPAN, 0, 1.5f * X_SPAN + 240, 0, 3 },
				{ 2, 13, 13f * X_SPAN, 0, 3.5f * X_SPAN - 240, 0, 2 },

				{ 2, 13, 13.25f * X_SPAN, 0, 3.5f * X_SPAN - 250, 0, 3 },
				{ 2, 13, 13.5f * X_SPAN, 0, 3.5f * X_SPAN - 300, 0, 2 },
				{ 2, 13, 13.78f * X_SPAN, 0, 3.5f * X_SPAN - 430, 0, 3 },

				{ 3, 12, 13.5f * X_SPAN - 240, 0, 3.0f * X_SPAN, 0, 2 },
				{ 3, 12, 13.5f * X_SPAN - 240, 0, 3.25f * X_SPAN, 0, 3 },
				{ 3, 12, 13.5f * X_SPAN - 240, 0, 3.5f * X_SPAN, 0, 2 },
				{ 3, 12, 13.5f * X_SPAN - 240, 0, 3.75f * X_SPAN, 0, 3 },
				{ 3, 12, 13.5f * X_SPAN - 240, 0, 4.0f * X_SPAN, 0, 2 },

				{ 4, 13, 13.0f * X_SPAN, 0, 3.5f * X_SPAN + 240, 0, 2 },
				{ 4, 13, 13.25f * X_SPAN, 0, 3.5f * X_SPAN + 240, 0, 3 },
				{ 4, 13, 13.5f * X_SPAN, 0, 3.5f * X_SPAN + 240, 0, 2 },
				{ 4, 13, 13.75f * X_SPAN, 0, 3.5f * X_SPAN + 240, 0, 3 },
				{ 4, 13, 14.0f * X_SPAN, 0, 3.5f * X_SPAN + 240, 0, 2 },

				{ 4, 14, 14.25f * X_SPAN, 0, 3.5f * X_SPAN + 250, 0, 3 },
				{ 4, 14, 14.5f * X_SPAN, 0, 3.5f * X_SPAN + 300, 0, 2 },
				{ 4, 14, 14.78f * X_SPAN, 0, 3.5f * X_SPAN + 430, 0, 3 },

				{ 5, 14, 15.5f * X_SPAN - 240, 0, 5.0f * X_SPAN, 0, 2 },
				{ 5, 14, 15.5f * X_SPAN - 240, 0, 5.25f * X_SPAN, 0, 3 },
				{ 5, 14, 15.5f * X_SPAN - 240, 0, 5.5f * X_SPAN, 0, 2 },
				{ 5, 14, 15.5f * X_SPAN - 240, 0, 5.75f * X_SPAN, 0, 3 },
				{ 5, 14, 15.5f * X_SPAN - 240, 0, 6.0f * X_SPAN, 0, 2 },

				{ 6, 14, 14.25f * X_SPAN, 0, 7.5f * X_SPAN - 250, 0, 3 },
				{ 6, 14, 14.5f * X_SPAN, 0, 7.5f * X_SPAN - 300, 0, 2 },
				{ 6, 14, 14.78f * X_SPAN, 0, 7.5f * X_SPAN - 430, 0, 3 },

				{ 7, 13, 14.5f * X_SPAN - 240, 0, 7.0f * X_SPAN, 0, 2 },
				{ 7, 13, 14.5f * X_SPAN - 240, 0, 7.25f * X_SPAN, 0, 3 },
				{ 7, 13, 14.5f * X_SPAN - 240, 0, 7.5f * X_SPAN, 0, 2 },
				{ 7, 13, 14.5f * X_SPAN - 240, 0, 7.75f * X_SPAN, 0, 3 },
				{ 7, 13, 14.5f * X_SPAN - 240, 0, 8.0f * X_SPAN, 0, 2 },

				{ 8, 13, 13.25f * X_SPAN, 0, 9.5f * X_SPAN - 250, 0, 3 },
				{ 8, 13, 13.5f * X_SPAN, 0, 9.5f * X_SPAN - 300, 0, 2 },
				{ 8, 13, 13.78f * X_SPAN, 0, 9.5f * X_SPAN - 430, 0, 3 },

				{ 8, 12, 12.0f * X_SPAN, 0, 9.5f * X_SPAN - 240, 0, 2 },
				{ 8, 12, 12.25f * X_SPAN, 0, 9.5f * X_SPAN - 240, 0, 3 },
				{ 8, 12, 12.5f * X_SPAN, 0, 9.5f * X_SPAN - 240, 0, 2 },
				{ 8, 12, 12.75f * X_SPAN, 0, 9.5f * X_SPAN - 240, 0, 3 },
				{ 8, 12, 13.0f * X_SPAN, 0, 9.5f * X_SPAN - 240, 0, 2 },

				{ 9, 11, 12.5f * X_SPAN - 240, 0, 9.0f * X_SPAN, 0, 2 },
				{ 9, 11, 12.5f * X_SPAN - 240, 0, 9.25f * X_SPAN, 0, 3 },
				{ 9, 11, 12.5f * X_SPAN - 240, 0, 9.5f * X_SPAN, 0, 2 },
				{ 9, 11, 12.5f * X_SPAN - 240, 0, 9.75f * X_SPAN, 0, 3 },
				{ 9, 11, 12.5f * X_SPAN - 240, 0, 10.0f * X_SPAN, 0, 2 },

				{ 10, 12, 12.0f * X_SPAN, 0, 9.5f * X_SPAN + 240, 0, 2 },
				{ 10, 12, 12.25f * X_SPAN, 0, 9.5f * X_SPAN + 240, 0, 3 },
				{ 10, 12, 12.5f * X_SPAN, 0, 9.5f * X_SPAN + 240, 0, 2 },
				{ 10, 12, 12.75f * X_SPAN, 0, 9.5f * X_SPAN + 240, 0, 3 },
				{ 10, 12, 13.0f * X_SPAN, 0, 9.5f * X_SPAN + 240, 0, 2 },
				{ 10, 13, 13.25f * X_SPAN, 0, 9.5f * X_SPAN + 240, 0, 3 },
				{ 10, 13, 13.5f * X_SPAN, 0, 9.5f * X_SPAN + 240, 0, 2 },
				{ 10, 13, 13.75f * X_SPAN, 0, 9.5f * X_SPAN + 240, 0, 3 },
				{ 10, 13, 14.0f * X_SPAN, 0, 9.5f * X_SPAN + 240, 0, 2 },

				{ 10, 14, 14.25f * X_SPAN, 0, 9.5f * X_SPAN + 250, 0, 3 },
				{ 10, 14, 14.5f * X_SPAN, 0, 9.5f * X_SPAN + 300, 0, 2 },
				{ 10, 14, 14.78f * X_SPAN, 0, 9.5f * X_SPAN + 430, 0, 3 },

				{ 11, 14, 15.5f * X_SPAN - 240, 0, 11.0f * X_SPAN, 0, 2 },
				{ 11, 14, 15.5f * X_SPAN - 240, 0, 11.25f * X_SPAN, 0, 3 },
				{ 11, 14, 15.5f * X_SPAN - 240, 0, 11.5f * X_SPAN, 0, 2 },
				{ 11, 14, 15.5f * X_SPAN - 240, 0, 11.75f * X_SPAN, 0, 3 },
				{ 11, 14, 15.5f * X_SPAN - 240, 0, 12.0f * X_SPAN, 0, 2 },
				{ 12, 14, 15.5f * X_SPAN - 240, 0, 12.25f * X_SPAN, 0, 3 },
				{ 12, 14, 15.5f * X_SPAN - 240, 0, 12.5f * X_SPAN, 0, 2 },
				{ 12, 14, 15.5f * X_SPAN - 240, 0, 12.75f * X_SPAN, 0, 3 },
				{ 12, 14, 15.5f * X_SPAN - 240, 0, 13.0f * X_SPAN, 0, 2 },

				{ 13, 14, 14.25f * X_SPAN, 0, 14.5f * X_SPAN - 250, 0, 3 },
				{ 13, 14, 14.5f * X_SPAN, 0, 14.5f * X_SPAN - 300, 0, 2 },
				{ 13, 14, 14.78f * X_SPAN, 0, 14.5f * X_SPAN - 430, 0, 3 },

				{ 13, 13, 13.0f * X_SPAN, 0, 14.5f * X_SPAN - 240, 0, 2 },
				{ 13, 13, 13.25f * X_SPAN, 0, 14.5f * X_SPAN - 240, 0, 3 },
				{ 13, 13, 13.5f * X_SPAN, 0, 14.5f * X_SPAN - 240, 0, 2 },
				{ 13, 13, 13.75f * X_SPAN, 0, 14.5f * X_SPAN - 240, 0, 3 },
				{ 13, 13, 14.0f * X_SPAN, 0, 14.5f * X_SPAN - 240, 0, 2 },

				{ 13, 12, 12.22f * X_SPAN, 0, 14.5f * X_SPAN - 430, 0, 3 },
				{ 13, 12, 12.5f * X_SPAN, 0, 14.5f * X_SPAN - 300, 0, 2 },
				{ 13, 12, 12.75f * X_SPAN, 0, 14.5f * X_SPAN - 250, 0, 3 },

				{ 12, 10, 10.0f * X_SPAN, 0, 13.5f * X_SPAN - 240, 0, 2 },
				{ 12, 10, 10.25f * X_SPAN, 0, 13.5f * X_SPAN - 240, 0, 3 },
				{ 12, 10, 10.75f * X_SPAN, 0, 13.5f * X_SPAN - 240, 0, 3 },
				{ 12, 10, 11.0f * X_SPAN, 0, 13.5f * X_SPAN - 240, 0, 2 },
				{ 12, 11, 11.25f * X_SPAN, 0, 13.5f * X_SPAN - 240, 0, 3 },
				{ 12, 11, 11.5f * X_SPAN, 0, 13.5f * X_SPAN - 240, 0, 2 },
				{ 12, 11, 11.75f * X_SPAN, 0, 13.5f * X_SPAN - 240, 0, 3 },
				{ 12, 11, 12.0f * X_SPAN, 0, 13.5f * X_SPAN - 240, 0, 2 },

				{ 13, 9, 10.5f * X_SPAN - 240, 0, 13.0f * X_SPAN, 0, 2 },
				{ 13, 9, 10.5f * X_SPAN - 240, 0, 13.25f * X_SPAN, 0, 3 },
				{ 13, 9, 10.5f * X_SPAN - 240, 0, 13.5f * X_SPAN, 0, 2 },
				{ 13, 9, 10.5f * X_SPAN - 240, 0, 13.75f * X_SPAN, 0, 3 },
				{ 13, 9, 10.5f * X_SPAN - 240, 0, 14.0f * X_SPAN, 0, 2 },

				{ 14, 9, 9.25f * X_SPAN, 0, 15.5f * X_SPAN - 250, 0, 3 },
				{ 14, 9, 9.5f * X_SPAN, 0, 15.5f * X_SPAN - 300, 0, 2 },
				{ 14, 9, 9.78f * X_SPAN, 0, 15.5f * X_SPAN - 430, 0, 3 },

				{ 14, 8, 8.22f * X_SPAN, 0, 15.5f * X_SPAN - 430, 0, 3 },
				{ 14, 8, 8.5f * X_SPAN, 0, 15.5f * X_SPAN - 300, 0, 2 },
				{ 14, 8, 8.75f * X_SPAN, 0, 15.5f * X_SPAN - 250, 0, 3 },

				{ 11, 8, 7.5f * X_SPAN + 240, 0, 11.0f * X_SPAN, 0, 2 },
				{ 11, 8, 7.5f * X_SPAN + 240, 0, 11.25f * X_SPAN, 0, 3 },
				{ 11, 8, 7.5f * X_SPAN + 240, 0, 11.5f * X_SPAN, 0, 2 },
				{ 11, 8, 7.5f * X_SPAN + 240, 0, 11.75f * X_SPAN, 0, 3 },
				{ 11, 8, 7.5f * X_SPAN + 240, 0, 12.0f * X_SPAN, 0, 2 },
				{ 12, 8, 7.5f * X_SPAN + 240, 0, 12.25f * X_SPAN, 0, 3 },
				{ 12, 8, 7.5f * X_SPAN + 240, 0, 12.5f * X_SPAN, 0, 2 },
				{ 12, 8, 7.5f * X_SPAN + 240, 0, 12.75f * X_SPAN, 0, 3 },
				{ 12, 8, 7.5f * X_SPAN + 240, 0, 13.0f * X_SPAN, 0, 2 },
				{ 13, 8, 7.5f * X_SPAN + 240, 0, 13.25f * X_SPAN, 0, 3 },
				{ 13, 8, 7.5f * X_SPAN + 240, 0, 13.5f * X_SPAN, 0, 2 },
				{ 13, 8, 7.5f * X_SPAN + 240, 0, 13.75f * X_SPAN, 0, 3 },
				{ 13, 8, 7.5f * X_SPAN + 240, 0, 14.0f * X_SPAN, 0, 2 },

				{ 11, 7, 7.25f * X_SPAN, 0, 12.5f * X_SPAN - 250, 0, 3 },
				{ 11, 7, 7.5f * X_SPAN, 0, 12.5f * X_SPAN - 300, 0, 2 },
				{ 11, 7, 7.78f * X_SPAN, 0, 12.5f * X_SPAN - 430, 0, 3 },

				{ 12, 6, 7.5f * X_SPAN - 240, 0, 12.0f * X_SPAN, 0, 2 },
				{ 12, 6, 7.5f * X_SPAN - 240, 0, 12.25f * X_SPAN, 0, 3 },
				{ 12, 6, 7.5f * X_SPAN - 240, 0, 12.5f * X_SPAN, 0, 2 },
				{ 12, 6, 7.5f * X_SPAN - 240, 0, 12.75f * X_SPAN, 0, 3 },
				{ 12, 6, 7.5f * X_SPAN - 240, 0, 13.0f * X_SPAN, 0, 2 },
				{ 13, 6, 7.5f * X_SPAN - 240, 0, 13.25f * X_SPAN, 0, 3 },
				{ 13, 6, 7.5f * X_SPAN - 240, 0, 13.5f * X_SPAN, 0, 2 },
				{ 13, 6, 7.5f * X_SPAN - 240, 0, 13.75f * X_SPAN, 0, 3 },
				{ 13, 6, 7.5f * X_SPAN - 240, 0, 14.0f * X_SPAN, 0, 2 },

				{ 14, 6, 6.25f * X_SPAN, 0, 15.5f * X_SPAN - 250, 0, 3 },
				{ 14, 6, 6.5f * X_SPAN, 0, 15.5f * X_SPAN - 300, 0, 2 },
				{ 14, 6, 6.78f * X_SPAN, 0, 15.5f * X_SPAN - 430, 0, 3 },

				{ 14, 2, 2.22f * X_SPAN, 0, 15.5f * X_SPAN - 430, 0, 5 },
				{ 14, 2, 2.5f * X_SPAN, 0, 15.5f * X_SPAN - 300, 0, 4 },
				{ 14, 2, 2.75f * X_SPAN, 0, 15.5f * X_SPAN - 250, 0, 5 },

				{ 13, 2, 1.5f * X_SPAN + 240, 0, 13.0f * X_SPAN, 0, 4 },
				{ 13, 2, 1.5f * X_SPAN + 240, 0, 13.25f * X_SPAN, 0, 5 },
				{ 13, 2, 1.5f * X_SPAN + 240, 0, 13.5f * X_SPAN, 0, 4 },
				{ 13, 2, 1.5f * X_SPAN + 240, 0, 13.75f * X_SPAN, 0, 5 },
				{ 13, 2, 1.5f * X_SPAN + 240, 0, 14.0f * X_SPAN, 0, 4 },

				{ 12, 2, 2.22f * X_SPAN, 0, 11.5f * X_SPAN + 430, 0, 5 },
				{ 12, 2, 2.5f * X_SPAN, 0, 11.5f * X_SPAN + 300, 0, 4 },
				{ 12, 2, 2.75f * X_SPAN, 0, 11.5f * X_SPAN + 250, 0, 5 },

				{ 11, 3, 3.22f * X_SPAN, 0, 10.5f * X_SPAN + 430, 0, 5 },
				{ 11, 3, 3.5f * X_SPAN, 0, 10.5f * X_SPAN + 300, 0, 4 },
				{ 11, 3, 3.75f * X_SPAN, 0, 10.5f * X_SPAN + 250, 0, 5 },

				{ 10, 4, 3.5f * X_SPAN + 240, 0, 10.0f * X_SPAN, 0, 4 },
				{ 10, 4, 3.5f * X_SPAN + 240, 0, 10.25f * X_SPAN, 0, 5 },
				{ 10, 4, 3.5f * X_SPAN + 240, 0, 10.5f * X_SPAN, 0, 4 },
				{ 10, 4, 3.5f * X_SPAN + 240, 0, 10.75f * X_SPAN, 0, 5 },
				{ 10, 4, 3.5f * X_SPAN + 240, 0, 11.0f * X_SPAN, 0, 4 },

				{ 9, 4, 4.22f * X_SPAN, 0, 8.5f * X_SPAN + 430, 0, 5 },
				{ 9, 4, 4.5f * X_SPAN, 0, 8.5f * X_SPAN + 300, 0, 4 },
				{ 9, 4, 4.75f * X_SPAN, 0, 8.5f * X_SPAN + 250, 0, 5 },

				{ 9, 5, 5.0f * X_SPAN, 0, 8.5f * X_SPAN + 240, 0, 4 },
				{ 9, 5, 5.25f * X_SPAN, 0, 8.5f * X_SPAN + 240, 0, 5 },
				{ 9, 5, 5.5f * X_SPAN, 0, 8.5f * X_SPAN + 240, 0, 4 },
				{ 9, 5, 5.75f * X_SPAN, 0, 8.5f * X_SPAN + 240, 0, 5 },
				{ 9, 5, 6.0f * X_SPAN, 0, 8.5f * X_SPAN + 240, 0, 4 },

				{ 7, 6, 5.5f * X_SPAN + 240, 0, 7.0f * X_SPAN, 0, 4 },
				{ 7, 6, 5.5f * X_SPAN + 240, 0, 7.25f * X_SPAN, 0, 5 },
				{ 7, 6, 5.5f * X_SPAN + 240, 0, 7.5f * X_SPAN, 0, 4 },
				{ 7, 6, 5.5f * X_SPAN + 240, 0, 7.75f * X_SPAN, 0, 5 },
				{ 7, 6, 5.5f * X_SPAN + 240, 0, 8.0f * X_SPAN, 0, 4 },
				{ 8, 6, 5.5f * X_SPAN + 240, 0, 8.25f * X_SPAN, 0, 5 },
				{ 8, 6, 5.5f * X_SPAN + 240, 0, 8.5f * X_SPAN, 0, 4 },
				{ 8, 6, 5.5f * X_SPAN + 240, 0, 8.75f * X_SPAN, 0, 5 },
				{ 8, 6, 5.5f * X_SPAN + 240, 0, 9.0f * X_SPAN, 0, 4 },

				{ 6, 4, 4.0f * X_SPAN, 0, 7.5f * X_SPAN - 240, 0, 4 },
				{ 6, 4, 4.25f * X_SPAN, 0, 7.5f * X_SPAN - 240, 0, 5 },
				{ 6, 4, 4.5f * X_SPAN, 0, 7.5f * X_SPAN - 240, 0, 4 },
				{ 6, 4, 4.75f * X_SPAN, 0, 7.5f * X_SPAN - 240, 0, 5 },
				{ 6, 4, 5.0f * X_SPAN, 0, 7.5f * X_SPAN - 240, 0, 4 },
				{ 6, 5, 5.25f * X_SPAN, 0, 7.5f * X_SPAN - 240, 0, 5 },
				{ 6, 5, 5.5f * X_SPAN, 0, 7.5f * X_SPAN - 240, 0, 4 },
				{ 6, 5, 5.75f * X_SPAN, 0, 7.5f * X_SPAN - 240, 0, 5 },
				{ 6, 5, 6.0f * X_SPAN, 0, 7.5f * X_SPAN - 240, 0, 4 },

				{ 6, 3, 3.22f * X_SPAN, 0, 7.5f * X_SPAN - 430, 0, 5 },
				{ 6, 3, 3.5f * X_SPAN, 0, 7.5f * X_SPAN - 300, 0, 4 },
				{ 6, 3, 3.75f * X_SPAN, 0, 7.5f * X_SPAN - 250, 0, 5 },

				{ 5, 3, 2.5f * X_SPAN + 240, 0, 5.0f * X_SPAN, 0, 4 },
				{ 5, 3, 2.5f * X_SPAN + 240, 0, 5.25f * X_SPAN, 0, 5 },
				{ 5, 3, 2.5f * X_SPAN + 240, 0, 5.5f * X_SPAN, 0, 4 },
				{ 5, 3, 2.5f * X_SPAN + 240, 0, 5.75f * X_SPAN, 0, 5 },
				{ 5, 3, 2.5f * X_SPAN + 240, 0, 6.0f * X_SPAN, 0, 4 },

				{ 4, 2, 2.0f * X_SPAN, 0, 5.5f * X_SPAN - 240, 0, 4 },
				{ 4, 2, 2.25f * X_SPAN, 0, 5.5f * X_SPAN - 240, 0, 5 },
				{ 4, 2, 2.5f * X_SPAN, 0, 5.5f * X_SPAN - 240, 0, 4 },
				{ 4, 2, 2.75f * X_SPAN, 0, 5.5f * X_SPAN - 240, 0, 5 },
				{ 4, 2, 3.0f * X_SPAN, 0, 5.5f * X_SPAN - 240, 0, 4 },

				{ 4, 1, 1.22f * X_SPAN, 0, 5.5f * X_SPAN - 430, 0, 5 },
				{ 4, 1, 1.5f * X_SPAN, 0, 5.5f * X_SPAN - 300, 0, 4 },
				{ 4, 1, 1.75f * X_SPAN, 0, 5.5f * X_SPAN - 250, 0, 5 },

				{ 2, 1, 0.5f * X_SPAN + 240, 0, 2.0f * X_SPAN, 0, 4 },
				{ 2, 1, 0.5f * X_SPAN + 240, 0, 2.25f * X_SPAN, 0, 5 },
				{ 2, 1, 0.5f * X_SPAN + 240, 0, 2.5f * X_SPAN, 0, 4 },
				{ 2, 1, 0.5f * X_SPAN + 240, 0, 2.75f * X_SPAN, 0, 5 },
				{ 2, 1, 0.5f * X_SPAN + 240, 0, 3.0f * X_SPAN, 0, 4 },
				{ 3, 1, 0.5f * X_SPAN + 240, 0, 3.25f * X_SPAN, 0, 5 },
				{ 3, 1, 0.5f * X_SPAN + 240, 0, 3.5f * X_SPAN, 0, 4 },
				{ 3, 1, 0.5f * X_SPAN + 240, 0, 3.75f * X_SPAN, 0, 5 },
				{ 3, 1, 0.5f * X_SPAN + 240, 0, 4.0f * X_SPAN, 0, 4 },

				{ 1, 1, 1.22f * X_SPAN, 0, 0.5f * X_SPAN + 430, 0, 5 },
				{ 1, 1, 1.5f * X_SPAN, 0, 0.5f * X_SPAN + 300, 0, 4 },
				{ 1, 1, 1.75f * X_SPAN, 0, 0.5f * X_SPAN + 250, 0, 5 },

				{ 1, 2, 2.0f * X_SPAN, 0, 0.5f * X_SPAN + 240, 0, 0 },
				{ 1, 2, 2.25f * X_SPAN, 0, 0.5f * X_SPAN + 240, 0, 1 },
				{ 1, 2, 2.5f * X_SPAN, 0, 0.5f * X_SPAN + 240, 0, 0 },

				// ��ʻ�����Ҳ�
				{ 1, 4, 4.25f * X_SPAN, 0, 2.5f * X_SPAN - 240, 0, 1 },
				{ 1, 4, 4.5f * X_SPAN, 0, 2.5f * X_SPAN - 240, 0, 0 },
				{ 1, 4, 4.75f * X_SPAN, 0, 2.5f * X_SPAN - 240, 0, 1 },
				{ 1, 4, 5.0f * X_SPAN, 0, 2.5f * X_SPAN - 240, 0, 0 },
				{ 1, 5, 5.25f * X_SPAN, 0, 2.5f * X_SPAN - 240, 0, 1 },
				{ 1, 5, 5.5f * X_SPAN, 0, 2.5f * X_SPAN - 240, 0, 0 },
				{ 1, 5, 5.75f * X_SPAN, 0, 2.5f * X_SPAN - 240, 0, 1 },
				{ 1, 5, 6.0f * X_SPAN, 0, 2.5f * X_SPAN - 240, 0, 0 },
				{ 1, 6, 6.75f * X_SPAN, 0, 2.5f * X_SPAN - 240, 0, 1 },

				{ 3, 8, 8.0f * X_SPAN, 0, 4.5f * X_SPAN - 240, 0, 0 },
				{ 3, 8, 8.25f * X_SPAN, 0, 4.5f * X_SPAN - 240, 0, 1 },
				{ 3, 8, 8.5f * X_SPAN, 0, 4.5f * X_SPAN - 240, 0, 0 },
				{ 3, 8, 8.75f * X_SPAN, 0, 4.5f * X_SPAN - 240, 0, 1 },
				{ 3, 8, 8.0f * X_SPAN, 0, 4.5f * X_SPAN - 240, 0, 0 },

				{ 2, 9, 10.5f * X_SPAN - 240, 0, 2.0f * X_SPAN, 0, 0 },
				{ 2, 9, 10.5f * X_SPAN - 240, 0, 2.25f * X_SPAN, 0, 1 },
				{ 2, 9, 10.5f * X_SPAN - 240, 0, 2.5f * X_SPAN, 0, 0 },
				{ 2, 9, 10.5f * X_SPAN - 240, 0, 2.75f * X_SPAN, 0, 1 },
				{ 2, 9, 10.5f * X_SPAN - 240, 0, 3.0f * X_SPAN, 0, 0 },

				{ 2, 12, 12.22f * X_SPAN, 0, 1.5f * X_SPAN + 430, 0, 3 },
				{ 2, 12, 12.5f * X_SPAN, 0, 1.5f * X_SPAN + 300, 0, 2 },
				{ 2, 12, 12.75f * X_SPAN, 0, 1.5f * X_SPAN + 250, 0, 3 },

				{ 3, 12, 11.5f * X_SPAN + 240, 0, 3.0f * X_SPAN, 0, 2 },
				{ 3, 12, 11.5f * X_SPAN + 240, 0, 3.25f * X_SPAN, 0, 3 },
				{ 3, 12, 11.5f * X_SPAN + 240, 0, 3.5f * X_SPAN, 0, 2 },
				{ 3, 12, 11.5f * X_SPAN + 240, 0, 3.75f * X_SPAN, 0, 3 },
				{ 3, 12, 11.5f * X_SPAN + 240, 0, 4.0f * X_SPAN, 0, 2 },

				{ 4, 12, 12.22f * X_SPAN, 0, 5.5f * X_SPAN - 430, 0, 3 },
				{ 4, 12, 12.5f * X_SPAN, 0, 5.5f * X_SPAN - 300, 0, 2 },
				{ 4, 12, 12.75f * X_SPAN, 0, 5.5f * X_SPAN - 250, 0, 3 },

				{ 4, 13, 13.0f * X_SPAN, 0, 5.5f * X_SPAN - 240, 0, 2 },
				{ 4, 13, 13.25f * X_SPAN, 0, 5.5f * X_SPAN - 240, 0, 3 },
				{ 4, 13, 13.5f * X_SPAN, 0, 5.5f * X_SPAN - 240, 0, 2 },
				{ 4, 13, 13.75f * X_SPAN, 0, 5.5f * X_SPAN - 240, 0, 3 },
				{ 4, 13, 14.0f * X_SPAN, 0, 5.5f * X_SPAN - 240, 0, 2 },

				{ 5, 14, 13.5f * X_SPAN + 240, 0, 5.0f * X_SPAN, 0, 2 },
				{ 5, 14, 13.5f * X_SPAN + 240, 0, 5.25f * X_SPAN, 0, 3 },
				{ 5, 14, 13.5f * X_SPAN + 240, 0, 5.5f * X_SPAN, 0, 2 },
				{ 5, 14, 13.5f * X_SPAN + 240, 0, 5.75f * X_SPAN, 0, 3 },
				{ 5, 14, 13.5f * X_SPAN + 240, 0, 6.0f * X_SPAN, 0, 2 },

				{ 6, 13, 13.22f * X_SPAN, 0, 5.5f * X_SPAN + 430, 0, 3 },
				{ 6, 13, 13.5f * X_SPAN, 0, 5.5f * X_SPAN + 300, 0, 2 },
				{ 6, 13, 13.75f * X_SPAN, 0, 5.5f * X_SPAN + 250, 0, 3 },

				{ 7, 13, 12.5f * X_SPAN + 240, 0, 7.0f * X_SPAN, 0, 2 },
				{ 7, 13, 12.5f * X_SPAN + 240, 0, 7.25f * X_SPAN, 0, 3 },
				{ 7, 13, 12.5f * X_SPAN + 240, 0, 7.5f * X_SPAN, 0, 2 },
				{ 7, 13, 12.5f * X_SPAN + 240, 0, 7.75f * X_SPAN, 0, 3 },
				{ 7, 13, 12.5f * X_SPAN + 240, 0, 8.0f * X_SPAN, 0, 2 },

				{ 8, 12, 12.0f * X_SPAN, 0, 7.5f * X_SPAN + 240, 0, 2 },
				{ 8, 12, 12.25f * X_SPAN, 0, 7.5f * X_SPAN + 240, 0, 3 },
				{ 8, 12, 12.5f * X_SPAN, 0, 7.5f * X_SPAN + 240, 0, 2 },
				{ 8, 12, 12.75f * X_SPAN, 0, 7.5f * X_SPAN + 240, 0, 3 },
				{ 8, 12, 12.0f * X_SPAN, 0, 7.5f * X_SPAN + 240, 0, 2 },

				{ 8, 11, 11.22f * X_SPAN, 0, 7.5f * X_SPAN + 430, 0, 3 },
				{ 8, 11, 11.5f * X_SPAN, 0, 7.5f * X_SPAN + 300, 0, 2 },
				{ 8, 11, 11.75f * X_SPAN, 0, 7.5f * X_SPAN + 250, 0, 3 },

				{ 9, 11, 10.5f * X_SPAN + 240, 0, 9.0f * X_SPAN, 0, 2 },
				{ 9, 11, 10.5f * X_SPAN + 240, 0, 9.25f * X_SPAN, 0, 3 },
				{ 9, 11, 10.5f * X_SPAN + 240, 0, 9.5f * X_SPAN, 0, 2 },
				{ 9, 11, 10.5f * X_SPAN + 240, 0, 9.75f * X_SPAN, 0, 3 },
				{ 9, 11, 10.5f * X_SPAN + 240, 0, 10.0f * X_SPAN, 0, 2 },

				{ 10, 11, 11.22f * X_SPAN, 0, 11.5f * X_SPAN - 430, 0, 3 },
				{ 10, 11, 11.5f * X_SPAN, 0, 11.5f * X_SPAN - 300, 0, 2 },
				{ 10, 11, 11.75f * X_SPAN, 0, 11.5f * X_SPAN - 250, 0, 3 },

				{ 10, 12, 12.0f * X_SPAN, 0, 11.5f * X_SPAN - 240, 0, 2 },
				{ 10, 12, 12.25f * X_SPAN, 0, 11.5f * X_SPAN - 240, 0, 3 },
				{ 10, 12, 12.5f * X_SPAN, 0, 11.5f * X_SPAN - 240, 0, 2 },
				{ 10, 12, 12.75f * X_SPAN, 0, 11.5f * X_SPAN - 240, 0, 3 },
				{ 10, 12, 13.0f * X_SPAN, 0, 11.5f * X_SPAN - 240, 0, 2 },
				{ 10, 13, 13.25f * X_SPAN, 0, 11.5f * X_SPAN - 240, 0, 3 },
				{ 10, 13, 13.5f * X_SPAN, 0, 11.5f * X_SPAN - 240, 0, 2 },
				{ 10, 13, 13.75f * X_SPAN, 0, 11.5f * X_SPAN - 240, 0, 3 },
				{ 10, 13, 14.0f * X_SPAN, 0, 11.5f * X_SPAN - 240, 0, 2 },

				{ 11, 14, 13.5f * X_SPAN + 240, 0, 11.0f * X_SPAN, 0, 2 },
				{ 11, 14, 13.5f * X_SPAN + 240, 0, 11.25f * X_SPAN, 0, 3 },
				{ 11, 14, 13.5f * X_SPAN + 240, 0, 11.5f * X_SPAN, 0, 2 },
				{ 11, 14, 13.5f * X_SPAN + 240, 0, 11.75f * X_SPAN, 0, 3 },
				{ 11, 14, 13.5f * X_SPAN + 240, 0, 12.0f * X_SPAN, 0, 2 },
				{ 12, 14, 13.5f * X_SPAN + 240, 0, 12.25f * X_SPAN, 0, 3 },
				{ 12, 14, 13.5f * X_SPAN + 240, 0, 12.5f * X_SPAN, 0, 2 },
				{ 12, 14, 13.5f * X_SPAN + 240, 0, 12.75f * X_SPAN, 0, 3 },
				{ 12, 14, 13.5f * X_SPAN + 240, 0, 13.0f * X_SPAN, 0, 2 },

				{ 13, 13, 13.0f * X_SPAN, 0, 12.5f * X_SPAN + 240, 0, 2 },
				{ 13, 13, 13.25f * X_SPAN, 0, 12.5f * X_SPAN + 240, 0, 3 },
				{ 13, 13, 13.5f * X_SPAN, 0, 12.5f * X_SPAN + 240, 0, 2 },
				{ 13, 13, 13.75f * X_SPAN, 0, 12.5f * X_SPAN + 240, 0, 3 },
				{ 13, 13, 14.0f * X_SPAN, 0, 12.5f * X_SPAN + 240, 0, 2 },

				{ 12, 12, 12.25f * X_SPAN, 0, 11.5f * X_SPAN + 250, 0, 3 },
				{ 12, 12, 12.5f * X_SPAN, 0, 11.5f * X_SPAN + 300, 0, 2 },
				{ 12, 12, 12.78f * X_SPAN, 0, 11.5f * X_SPAN + 430, 0, 3 },

				{ 12, 11, 11.0f * X_SPAN, 0, 11.5f * X_SPAN + 240, 0, 2 },
				{ 12, 11, 11.25f * X_SPAN, 0, 11.5f * X_SPAN + 240, 0, 3 },
				{ 12, 11, 11.5f * X_SPAN, 0, 11.5f * X_SPAN + 240, 0, 2 },
				{ 12, 11, 11.75f * X_SPAN, 0, 11.5f * X_SPAN + 240, 0, 3 },
				{ 12, 11, 12.0f * X_SPAN, 0, 11.5f * X_SPAN + 240, 0, 2 },
				{ 12, 10, 10.0f * X_SPAN, 0, 11.5f * X_SPAN + 240, 0, 2 },
				{ 12, 10, 10.75f * X_SPAN, 0, 11.5f * X_SPAN + 240, 0, 3 },

				{ 12, 9, 9.22f * X_SPAN, 0, 11.5f * X_SPAN + 430, 0, 3 },
				{ 12, 9, 9.5f * X_SPAN, 0, 11.5f * X_SPAN + 300, 0, 2 },
				{ 12, 9, 9.75f * X_SPAN, 0, 11.5f * X_SPAN + 250, 0, 3 },

				{ 13, 9, 8.5f * X_SPAN + 240, 0, 13.0f * X_SPAN, 0, 2 },
				{ 13, 9, 8.5f * X_SPAN + 240, 0, 13.25f * X_SPAN, 0, 3 },
				{ 13, 9, 8.5f * X_SPAN + 240, 0, 13.5f * X_SPAN, 0, 2 },
				{ 13, 9, 8.5f * X_SPAN + 240, 0, 13.75f * X_SPAN, 0, 3 },
				{ 13, 9, 8.5f * X_SPAN + 240, 0, 14.0f * X_SPAN, 0, 2 },

				{ 11, 8, 9.5f * X_SPAN - 240, 0, 11.0f * X_SPAN, 0, 2 },
				{ 11, 8, 9.5f * X_SPAN - 240, 0, 12.0f * X_SPAN, 0, 2 },
				{ 12, 8, 9.5f * X_SPAN - 240, 0, 12.25f * X_SPAN, 0, 3 },
				{ 12, 8, 9.5f * X_SPAN - 240, 0, 12.5f * X_SPAN, 0, 2 },
				{ 12, 8, 9.5f * X_SPAN - 240, 0, 12.75f * X_SPAN, 0, 3 },
				{ 12, 8, 9.5f * X_SPAN - 240, 0, 13.0f * X_SPAN, 0, 2 },
				{ 13, 8, 9.5f * X_SPAN - 240, 0, 13.25f * X_SPAN, 0, 3 },
				{ 13, 8, 9.5f * X_SPAN - 240, 0, 13.5f * X_SPAN, 0, 2 },
				{ 13, 8, 9.5f * X_SPAN - 240, 0, 13.75f * X_SPAN, 0, 3 },
				{ 13, 8, 9.5f * X_SPAN - 240, 0, 14.0f * X_SPAN, 0, 2 },

				{ 10, 8, 8.25f * X_SPAN, 0, 9.5f * X_SPAN + 250, 0, 3 },
				{ 10, 8, 8.5f * X_SPAN, 0, 9.5f * X_SPAN + 300, 0, 2 },
				{ 10, 8, 8.78f * X_SPAN, 0, 9.5f * X_SPAN + 430, 0, 3 },

				{ 10, 7, 7.22f * X_SPAN, 0, 9.5f * X_SPAN + 430, 0, 3 },
				{ 10, 7, 7.5f * X_SPAN, 0, 9.5f * X_SPAN + 300, 0, 2 },
				{ 10, 7, 7.75f * X_SPAN, 0, 9.5f * X_SPAN + 250, 0, 3 },

				{ 11, 6, 6.22f * X_SPAN, 0, 10.5f * X_SPAN + 430, 0, 3 },
				{ 11, 6, 6.5f * X_SPAN, 0, 10.5f * X_SPAN + 300, 0, 2 },
				{ 11, 6, 6.75f * X_SPAN, 0, 10.5f * X_SPAN + 250, 0, 3 },

				{ 12, 6, 5.5f * X_SPAN + 240, 0, 12.0f * X_SPAN, 0, 2 },
				{ 12, 6, 5.5f * X_SPAN + 240, 0, 12.25f * X_SPAN, 0, 3 },
				{ 12, 6, 5.5f * X_SPAN + 240, 0, 12.5f * X_SPAN, 0, 2 },
				{ 12, 6, 5.5f * X_SPAN + 240, 0, 12.75f * X_SPAN, 0, 3 },
				{ 12, 6, 5.5f * X_SPAN + 240, 0, 13.0f * X_SPAN, 0, 2 },
				{ 13, 6, 5.5f * X_SPAN + 240, 0, 13.25f * X_SPAN, 0, 3 },
				{ 13, 6, 5.5f * X_SPAN + 240, 0, 13.5f * X_SPAN, 0, 2 },
				{ 13, 6, 5.5f * X_SPAN + 240, 0, 13.75f * X_SPAN, 0, 3 },
				{ 13, 6, 5.5f * X_SPAN + 240, 0, 14.0f * X_SPAN, 0, 2 },

				{ 13, 2, 3.5f * X_SPAN - 240, 0, 13.0f * X_SPAN, 0, 4 },
				{ 13, 2, 3.5f * X_SPAN - 240, 0, 13.25f * X_SPAN, 0, 5 },
				{ 13, 2, 3.5f * X_SPAN - 240, 0, 13.5f * X_SPAN, 0, 4 },
				{ 13, 2, 3.5f * X_SPAN - 240, 0, 13.75f * X_SPAN, 0, 5 },
				{ 13, 2, 3.5f * X_SPAN - 240, 0, 14.0f * X_SPAN, 0, 4 },

				{ 12, 3, 3.25f * X_SPAN, 0, 13.5f * X_SPAN - 250, 0, 5 },
				{ 12, 3, 3.5f * X_SPAN, 0, 13.5f * X_SPAN - 300, 0, 4 },
				{ 12, 3, 3.78f * X_SPAN, 0, 13.5f * X_SPAN - 430, 0, 5 },

				{ 11, 4, 4.25f * X_SPAN, 0, 12.5f * X_SPAN - 250, 0, 5 },
				{ 11, 4, 4.5f * X_SPAN, 0, 12.5f * X_SPAN - 300, 0, 4 },
				{ 11, 4, 4.78f * X_SPAN, 0, 12.5f * X_SPAN - 430, 0, 5 },

				{ 10, 4, 5.5f * X_SPAN - 240, 0, 10.0f * X_SPAN, 0, 4 },
				{ 10, 4, 5.5f * X_SPAN - 240, 0, 10.25f * X_SPAN, 0, 5 },
				{ 10, 4, 5.5f * X_SPAN - 240, 0, 10.5f * X_SPAN, 0, 4 },
				{ 10, 4, 5.5f * X_SPAN - 240, 0, 10.75f * X_SPAN, 0, 5 },
				{ 10, 4, 5.5f * X_SPAN - 240, 0, 11.0f * X_SPAN, 0, 4 },

				{ 9, 5, 5.0f * X_SPAN, 0, 10.5f * X_SPAN - 240, 0, 4 },
				{ 9, 5, 5.25f * X_SPAN, 0, 10.5f * X_SPAN - 240, 0, 5 },
				{ 9, 5, 5.5f * X_SPAN, 0, 10.5f * X_SPAN - 240, 0, 4 },
				{ 9, 5, 5.75f * X_SPAN, 0, 10.5f * X_SPAN - 240, 0, 5 },
				{ 9, 5, 6.0f * X_SPAN, 0, 10.5f * X_SPAN - 240, 0, 4 },

				{ 9, 6, 6.25f * X_SPAN, 0, 10.5f * X_SPAN - 250, 0, 5 },
				{ 9, 6, 6.5f * X_SPAN, 0, 10.5f * X_SPAN - 300, 0, 4 },
				{ 9, 6, 6.78f * X_SPAN, 0, 10.5f * X_SPAN - 430, 0, 5 },

				{ 7, 6, 7.5f * X_SPAN - 240, 0, 7.0f * X_SPAN, 0, 4 },
				{ 7, 6, 7.5f * X_SPAN - 240, 0, 7.25f * X_SPAN, 0, 5 },
				{ 7, 6, 7.5f * X_SPAN - 240, 0, 7.5f * X_SPAN, 0, 4 },
				{ 7, 6, 7.5f * X_SPAN - 240, 0, 7.75f * X_SPAN, 0, 5 },
				{ 7, 6, 7.5f * X_SPAN - 240, 0, 8.0f * X_SPAN, 0, 4 },
				{ 8, 6, 7.5f * X_SPAN - 240, 0, 8.25f * X_SPAN, 0, 5 },
				{ 8, 6, 7.5f * X_SPAN - 240, 0, 8.5f * X_SPAN, 0, 4 },
				{ 8, 6, 7.5f * X_SPAN - 240, 0, 8.75f * X_SPAN, 0, 5 },
				{ 8, 6, 7.5f * X_SPAN - 240, 0, 9.0f * X_SPAN, 0, 4 },

				{ 6, 6, 6.25f * X_SPAN, 0, 5.5f * X_SPAN + 250, 0, 5 },
				{ 6, 6, 6.5f * X_SPAN, 0, 5.5f * X_SPAN + 300, 0, 4 },
				{ 6, 6, 6.78f * X_SPAN, 0, 5.5f * X_SPAN + 430, 0, 5 },

				{ 6, 4, 4.0f * X_SPAN, 0, 5.5f * X_SPAN + 240, 0, 4 },
				{ 6, 4, 4.25f * X_SPAN, 0, 5.5f * X_SPAN + 240, 0, 5 },
				{ 6, 4, 4.5f * X_SPAN, 0, 5.5f * X_SPAN + 240, 0, 4 },
				{ 6, 4, 4.75f * X_SPAN, 0, 5.5f * X_SPAN + 240, 0, 5 },
				{ 6, 4, 5.0f * X_SPAN, 0, 5.5f * X_SPAN + 240, 0, 4 },
				{ 6, 5, 5.25f * X_SPAN, 0, 5.5f * X_SPAN + 240, 0, 5 },
				{ 6, 5, 5.5f * X_SPAN, 0, 5.5f * X_SPAN + 240, 0, 4 },
				{ 6, 5, 5.75f * X_SPAN, 0, 5.5f * X_SPAN + 240, 0, 5 },
				{ 6, 5, 6.0f * X_SPAN, 0, 5.5f * X_SPAN + 240, 0, 4 },

				{ 5, 3, 4.5f * X_SPAN - 240, 0, 5.0f * X_SPAN, 0, 4 },
				{ 5, 3, 4.5f * X_SPAN - 240, 0, 5.25f * X_SPAN, 0, 5 },
				{ 5, 3, 4.5f * X_SPAN - 240, 0, 5.5f * X_SPAN, 0, 4 },
				{ 5, 3, 4.5f * X_SPAN - 240, 0, 5.75f * X_SPAN, 0, 5 },
				{ 5, 3, 4.5f * X_SPAN - 240, 0, 6.0f * X_SPAN, 0, 4 },

				{ 4, 3, 3.25f * X_SPAN, 0, 3.5f * X_SPAN + 250, 0, 5 },
				{ 4, 3, 3.5f * X_SPAN, 0, 3.5f * X_SPAN + 300, 0, 4 },
				{ 4, 3, 3.78f * X_SPAN, 0, 3.5f * X_SPAN + 430, 0, 5 },

				{ 4, 2, 2.0f * X_SPAN, 0, 3.5f * X_SPAN + 240, 0, 4 },
				{ 4, 2, 2.25f * X_SPAN, 0, 3.5f * X_SPAN + 240, 0, 5 },
				{ 4, 2, 2.5f * X_SPAN, 0, 3.5f * X_SPAN + 240, 0, 4 },
				{ 4, 2, 2.75f * X_SPAN, 0, 3.5f * X_SPAN + 240, 0, 5 },
				{ 4, 2, 3.0f * X_SPAN, 0, 3.5f * X_SPAN + 240, 0, 4 },

				{ 2, 1, 2.5f * X_SPAN - 240, 0, 2.0f * X_SPAN, 0, 4 },
				{ 2, 1, 2.5f * X_SPAN - 240, 0, 2.25f * X_SPAN, 0, 5 },
				{ 2, 1, 2.5f * X_SPAN - 240, 0, 2.5f * X_SPAN, 0, 4 },
				{ 2, 1, 2.5f * X_SPAN - 240, 0, 2.75f * X_SPAN, 0, 5 },
				{ 2, 1, 2.5f * X_SPAN - 240, 0, 3.0f * X_SPAN, 0, 4 },
				{ 3, 1, 2.5f * X_SPAN - 240, 0, 3.25f * X_SPAN, 0, 5 },
				{ 3, 1, 2.5f * X_SPAN - 240, 0, 3.5f * X_SPAN, 0, 4 },
				{ 3, 1, 2.5f * X_SPAN - 240, 0, 3.75f * X_SPAN, 0, 5 },
				{ 3, 1, 2.5f * X_SPAN - 240, 0, 4.0f * X_SPAN, 0, 4 },

				{ 1, 2, 2.0f * X_SPAN, 0, 2.5f * X_SPAN - 240, 0, 0 } };
		// ��ͧ�б�
		AIRSHIP_LIST = new float[][] {
				{ 8.0f * X_SPAN, 150, 4.0f * X_SPAN, 0 },
				{ 8.0f * X_SPAN, 150, 4.0f * X_SPAN, 90 },
				{ 8.0f * X_SPAN, 150, 4.0f * X_SPAN, 180 },
				{ 8.0f * X_SPAN, 150, 4.0f * X_SPAN, 270 },

				{ 8.0f * X_SPAN, 150, 12.0f * X_SPAN, 180 },
				{ 8.0f * X_SPAN, 150, 12.0f * X_SPAN, 270 },
				{ 8.0f * X_SPAN, 150, 12.0f * X_SPAN, 360 },
				{ 8.0f * X_SPAN, 150, 12.0f * X_SPAN, 450 } };
		// ��ײ�����б�
		KEZHUANG_LIST = new float[][] {
				{ 1, 1.3f * X_SPAN, 18.6f, 3.0f * X_SPAN, 3, 1 },
				{ 1, 1.4f * X_SPAN, 18.6f, 3.0f * X_SPAN, 3, 1 },
				{ 1, 1.5f * X_SPAN, 18.6f, 3.0f * X_SPAN, 3, 1 },
				{ 1, 1.6f * X_SPAN, 18.6f, 3.0f * X_SPAN, 3, 1 },
				{ 1, 1.7f * X_SPAN, 18.6f, 3.0f * X_SPAN, 3, 1 },
				{ 1, 7.3f * X_SPAN, 18.6f, 2.5f * X_SPAN, 2, 7 },
				{ 1, 7.4f * X_SPAN, 18.6f, 2.5f * X_SPAN, 2, 7 },
				{ 1, 7.5f * X_SPAN, 18.6f, 2.5f * X_SPAN, 2, 7 },
				{ 1, 7.6f * X_SPAN, 18.6f, 2.5f * X_SPAN, 2, 7 },
				{ 1, 7.7f * X_SPAN, 18.6f, 2.5f * X_SPAN, 2, 7 },
				{ 1, 11.3f * X_SPAN, 18.6f, 9.5f * X_SPAN, 9, 11 },
				{ 1, 11.4f * X_SPAN, 18.6f, 9.5f * X_SPAN, 9, 11 },
				{ 1, 11.5f * X_SPAN, 18.6f, 9.5f * X_SPAN, 9, 11 },
				{ 1, 11.6f * X_SPAN, 18.6f, 9.5f * X_SPAN, 9, 11 },
				{ 1, 11.7f * X_SPAN, 18.6f, 9.5f * X_SPAN, 9, 11 },
				{ 1, 14.3f * X_SPAN, 18.6f, 12f * X_SPAN, 12, 14 },
				{ 1, 14.4f * X_SPAN, 18.6f, 12f * X_SPAN, 12, 14 },
				{ 1, 14.5f * X_SPAN, 18.6f, 12f * X_SPAN, 12, 14 },
				{ 1, 14.6f * X_SPAN, 18.6f, 12f * X_SPAN, 12, 14 },
				{ 1, 14.7f * X_SPAN, 18.6f, 12f * X_SPAN, 12, 14 },

				{ 0, 11.0f * X_SPAN, 0, 12.35f * X_SPAN, 12, 11 },
				{ 0, 11.1f * X_SPAN, 0, 12.35f * X_SPAN, 12, 11 },
				{ 0, 11.2f * X_SPAN, 0, 12.35f * X_SPAN, 12, 11 },
				{ 0, 11.3f * X_SPAN, 0, 12.35f * X_SPAN, 12, 11 },
				{ 0, 11.4f * X_SPAN, 0, 12.35f * X_SPAN, 12, 11 },
				{ 0, 11.45f * X_SPAN, 0, 12.425f * X_SPAN, 12, 11 },
				{ 0, 11.5f * X_SPAN, 0, 12.5f * X_SPAN, 12, 11 },
				{ 0, 11.55f * X_SPAN, 0, 12.575f * X_SPAN, 12, 11 },
				{ 0, 11.6f * X_SPAN, 0, 12.65f * X_SPAN, 12, 11 },
				{ 0, 11.7f * X_SPAN, 0, 12.65f * X_SPAN, 12, 11 },
				{ 0, 11.8f * X_SPAN, 0, 12.65f * X_SPAN, 12, 11 },
				{ 0, 11.9f * X_SPAN, 0, 12.65f * X_SPAN, 12, 11 },
				{ 0, 12.0f * X_SPAN, 0, 12.65f * X_SPAN, 12, 11 },

				{ 0, 14.0f * X_SPAN, 0, 13.35f * X_SPAN, 13, 14 },
				{ 0, 14.0906f * X_SPAN, 0, 13.3381f * X_SPAN, 13, 14 },
				{ 0, 14.175f * X_SPAN, 0, 13.3031f * X_SPAN, 13, 14 },
				{ 0, 14.2643f * X_SPAN, 0, 13.3281f * X_SPAN, 13, 14 },
				{ 0, 14.3536f * X_SPAN, 0, 13.3536f * X_SPAN, 13, 14 },
				{ 0, 14.4398f * X_SPAN, 0, 13.3679f * X_SPAN, 13, 14 },
				{ 0, 14.5259f * X_SPAN, 0, 13.3821f * X_SPAN, 13, 14 },
				{ 0, 14.5792f * X_SPAN, 0, 13.2951f * X_SPAN, 13, 14 },
				{ 0, 14.6182f * X_SPAN, 0, 13.2009f * X_SPAN, 13, 14 },
				{ 0, 14.642f * X_SPAN, 0, 13.1017f * X_SPAN, 13, 14 },
				{ 0, 14.65f * X_SPAN, 0, 13.0f * X_SPAN, 13, 14 },

				{ 0, 9.0f * X_SPAN, 0, 3.35f * X_SPAN, 3, 9 },
				{ 0, 9.0906f * X_SPAN, 0, 3.3381f * X_SPAN, 3, 9 },
				{ 0, 9.175f * X_SPAN, 0, 3.3031f * X_SPAN, 3, 9 },
				{ 0, 9.2643f * X_SPAN, 0, 3.3281f * X_SPAN, 3, 9 },
				{ 0, 9.3536f * X_SPAN, 0, 3.3536f * X_SPAN, 3, 9 },
				{ 0, 9.4398f * X_SPAN, 0, 3.3679f * X_SPAN, 3, 9 },
				{ 0, 9.5259f * X_SPAN, 0, 3.3821f * X_SPAN, 3, 9 },
				{ 0, 9.5792f * X_SPAN, 0, 3.2951f * X_SPAN, 3, 9 },
				{ 0, 9.6182f * X_SPAN, 0, 3.2009f * X_SPAN, 3, 9 },
				{ 0, 9.642f * X_SPAN, 0, 3.1017f * X_SPAN, 3, 9 },
				{ 0, 9.65f * X_SPAN, 0, 3.0f * X_SPAN, 3, 9 },

				{ 0, 9.0f * X_SPAN, 0, 14.35f * X_SPAN, 14, 9 },
				{ 0, 9.0906f * X_SPAN, 0, 14.3381f * X_SPAN, 14, 9 },
				{ 0, 9.175f * X_SPAN, 0, 14.3031f * X_SPAN, 14, 9 },
				{ 0, 9.2643f * X_SPAN, 0, 14.3281f * X_SPAN, 14, 9 },
				{ 0, 9.3536f * X_SPAN, 0, 14.3536f * X_SPAN, 14, 9 },
				{ 0, 9.4398f * X_SPAN, 0, 14.3679f * X_SPAN, 14, 9 },
				{ 0, 9.5259f * X_SPAN, 0, 14.3821f * X_SPAN, 14, 9 },
				{ 0, 9.5792f * X_SPAN, 0, 14.2951f * X_SPAN, 14, 9 },
				{ 0, 9.6182f * X_SPAN, 0, 14.2009f * X_SPAN, 14, 9 },
				{ 0, 9.642f * X_SPAN, 0, 14.1017f * X_SPAN, 14, 9 },
				{ 0, 9.65f * X_SPAN, 0, 14.0f * X_SPAN, 14, 9 },

				{ 0, 3.0f * X_SPAN, 0, 12.35f * X_SPAN, 12, 3 },
				{ 0, 3.0906f * X_SPAN, 0, 12.3381f * X_SPAN, 12, 3 },
				{ 0, 3.175f * X_SPAN, 0, 12.3031f * X_SPAN, 12, 3 },
				{ 0, 3.2643f * X_SPAN, 0, 12.3281f * X_SPAN, 12, 3 },
				{ 0, 3.3536f * X_SPAN, 0, 12.3536f * X_SPAN, 12, 3 },
				{ 0, 3.4398f * X_SPAN, 0, 12.3679f * X_SPAN, 12, 3 },
				{ 0, 3.5259f * X_SPAN, 0, 12.3821f * X_SPAN, 12, 3 },
				{ 0, 3.5792f * X_SPAN, 0, 12.2951f * X_SPAN, 12, 3 },
				{ 0, 3.6182f * X_SPAN, 0, 12.2009f * X_SPAN, 12, 3 },
				{ 0, 3.642f * X_SPAN, 0, 12.1017f * X_SPAN, 12, 3 },
				{ 0, 3.65f * X_SPAN, 0, 12.0f * X_SPAN, 12, 3 },

				{ 0, 7.0f * X_SPAN, 0, 11.35f * X_SPAN, 11, 7 },
				{ 0, 7.0906f * X_SPAN, 0, 11.3381f * X_SPAN, 11, 7 },
				{ 0, 7.175f * X_SPAN, 0, 11.3031f * X_SPAN, 11, 7 },
				{ 0, 7.2643f * X_SPAN, 0, 11.3281f * X_SPAN, 11, 7 },
				{ 0, 7.3536f * X_SPAN, 0, 11.3536f * X_SPAN, 11, 7 },
				{ 0, 7.4398f * X_SPAN, 0, 11.3679f * X_SPAN, 11, 7 },
				{ 0, 7.5259f * X_SPAN, 0, 11.3821f * X_SPAN, 11, 7 },
				{ 0, 7.5792f * X_SPAN, 0, 11.2951f * X_SPAN, 11, 7 },
				{ 0, 7.6182f * X_SPAN, 0, 11.2009f * X_SPAN, 11, 7 },
				{ 0, 7.642f * X_SPAN, 0, 11.1017f * X_SPAN, 11, 7 },
				{ 0, 7.65f * X_SPAN, 0, 11.0f * X_SPAN, 11, 7 },

				{ 0, 12.65f * X_SPAN, 0, 4.0f * X_SPAN, 4, 12 },
				{ 0, 12.6619f * X_SPAN, 0, 4.0906f * X_SPAN, 4, 12 },
				{ 0, 12.6969f * X_SPAN, 0, 4.175f * X_SPAN, 4, 12 },
				{ 0, 12.6719f * X_SPAN, 0, 4.2643f * X_SPAN, 4, 12 },
				{ 0, 12.6464f * X_SPAN, 0, 4.3536f * X_SPAN, 4, 12 },
				{ 0, 12.6321f * X_SPAN, 0, 4.4398f * X_SPAN, 4, 12 },
				{ 0, 12.6179f * X_SPAN, 0, 4.5259f * X_SPAN, 4, 12 },
				{ 0, 12.7049f * X_SPAN, 0, 4.5792f * X_SPAN, 4, 12 },
				{ 0, 12.7991f * X_SPAN, 0, 4.6182f * X_SPAN, 4, 12 },
				{ 0, 12.8983f * X_SPAN, 0, 4.642f * X_SPAN, 4, 12 },
				{ 0, 13.0f * X_SPAN, 0, 4.65f * X_SPAN, 4, 12 },

				{ 0, 3.65f * X_SPAN, 0, 6.0f * X_SPAN, 6, 3 },
				{ 0, 3.6619f * X_SPAN, 0, 6.0906f * X_SPAN, 6, 3 },
				{ 0, 3.6969f * X_SPAN, 0, 6.175f * X_SPAN, 6, 3 },
				{ 0, 3.6719f * X_SPAN, 0, 6.2643f * X_SPAN, 6, 3 },
				{ 0, 3.6464f * X_SPAN, 0, 6.3536f * X_SPAN, 6, 3 },
				{ 0, 3.6321f * X_SPAN, 0, 6.4398f * X_SPAN, 6, 3 },
				{ 0, 3.6179f * X_SPAN, 0, 6.5259f * X_SPAN, 6, 3 },
				{ 0, 3.7049f * X_SPAN, 0, 6.5792f * X_SPAN, 6, 3 },
				{ 0, 3.7991f * X_SPAN, 0, 6.6182f * X_SPAN, 6, 3 },
				{ 0, 3.8983f * X_SPAN, 0, 6.642f * X_SPAN, 6, 3 },
				{ 0, 4.0f * X_SPAN, 0, 6.65f * X_SPAN, 6, 3 },

				{ 2, 3.5f * X_SPAN, 2, 1.5f * X_SPAN, 1, 3 },
				{ 2, 4.0f * X_SPAN, 2, 1.5f * X_SPAN, 1, 4 },
				{ 2, 4.5f * X_SPAN, 2, 1.5f * X_SPAN, 1, 4 },
				{ 2, 5.0f * X_SPAN, 2, 1.5f * X_SPAN, 1, 5 },
				{ 2, 5.5f * X_SPAN, 2, 1.5f * X_SPAN, 1, 5 },
				{ 2, 6.0f * X_SPAN, 2, 1.5f * X_SPAN, 1, 6 },
				{ 2, 6.5f * X_SPAN, 2, 1.5f * X_SPAN, 1, 6 },

				{ 2, 14.5f * X_SPAN, 2, 5.0f * X_SPAN, 5, 14 },
				{ 2, 14.5f * X_SPAN, 2, 5.5f * X_SPAN, 5, 14 },
				{ 2, 14.5f * X_SPAN, 2, 6.0f * X_SPAN, 6, 14 },

				{ 2, 11.5f * X_SPAN, 2, 9.0f * X_SPAN, 9, 11 },
				{ 2, 11.5f * X_SPAN, 2, 9.5f * X_SPAN, 9, 11 },
				{ 2, 11.5f * X_SPAN, 2, 10.0f * X_SPAN, 10, 11 },

				{ 2, 8.5f * X_SPAN, 2, 11.5f * X_SPAN, 11, 8 },
				{ 2, 8.5f * X_SPAN, 2, 12.0f * X_SPAN, 11, 8 },
				{ 2, 8.5f * X_SPAN, 2, 12.5f * X_SPAN, 12, 8 },
				{ 2, 8.5f * X_SPAN, 2, 13.0f * X_SPAN, 12, 8 },
				{ 2, 8.5f * X_SPAN, 2, 13.5f * X_SPAN, 13, 8 },

				{ 2, 6.5f * X_SPAN, 2, 7.0f * X_SPAN, 7, 6 },
				{ 2, 6.5f * X_SPAN, 2, 7.5f * X_SPAN, 7, 6 },
				{ 2, 6.5f * X_SPAN, 2, 8.0f * X_SPAN, 8, 6 },
				{ 2, 6.5f * X_SPAN, 2, 8.5f * X_SPAN, 8, 6 },
				{ 2, 6.5f * X_SPAN, 2, 9.0f * X_SPAN, 9, 6 },

				{ 2, 6.5f * X_SPAN, 2, 12.0f * X_SPAN, 12, 6 },
				{ 2, 6.5f * X_SPAN, 2, 12.5f * X_SPAN, 12, 6 },
				{ 2, 6.5f * X_SPAN, 2, 13.0f * X_SPAN, 13, 6 },
				{ 2, 6.5f * X_SPAN, 2, 13.5f * X_SPAN, 13, 6 },
				{ 2, 6.5f * X_SPAN, 2, 14.0f * X_SPAN, 14, 6 } };
		// �����б�
		SPEED_SPRING_LIST = new float[][] {
				{ 0, 3.5f * X_SPAN, 0, 1.35f * X_SPAN, 1, 3 },
				{ 1, 4.0f * X_SPAN, 0, 1.65f * X_SPAN, 1, 3 },
				{ 1, 4.5f * X_SPAN, 0, 1.35f * X_SPAN, 1, 4 },
				{ 0, 5.0f * X_SPAN, 0, 1.65f * X_SPAN, 1, 4 },
				{ 0, 5.5f * X_SPAN, 0, 1.35f * X_SPAN, 1, 5 },
				{ 1, 6.0f * X_SPAN, 0, 1.65f * X_SPAN, 1, 5 },

				{ 1, 10.5f * X_SPAN, 0, 1.35f * X_SPAN, 1, 10 },
				{ 0, 11.0f * X_SPAN, 0, 1.65f * X_SPAN, 1, 10 },
				{ 0, 11.5f * X_SPAN, 0, 1.35f * X_SPAN, 1, 11 },
				{ 1, 12.0f * X_SPAN, 0, 1.65f * X_SPAN, 1, 11 },
				{ 1, 12.5f * X_SPAN, 0, 1.35f * X_SPAN, 1, 12 },

				{ 1, 3.5f * X_SPAN, 0, 14.35f * X_SPAN, 14, 3 },
				{ 0, 4.0f * X_SPAN, 0, 14.65f * X_SPAN, 14, 3 },
				{ 0, 4.5f * X_SPAN, 0, 14.35f * X_SPAN, 14, 4 },
				{ 1, 5.0f * X_SPAN, 0, 14.65f * X_SPAN, 14, 4 },
				{ 1, 5.5f * X_SPAN, 0, 14.35f * X_SPAN, 14, 5 },

				{ 0, 6.35f * X_SPAN, 0, 7f * X_SPAN, 7, 6 },
				{ 1, 6.75f * X_SPAN, 0, 7.5f * X_SPAN, 7, 6 },
				{ 1, 6.35f * X_SPAN, 0, 8f * X_SPAN, 8, 6 },
				{ 0, 6.75f * X_SPAN, 0, 8.5f * X_SPAN, 8, 6 },
				{ 1, 6.35f * X_SPAN, 0, 9f * X_SPAN, 8, 6 },

				{ 1, 14.0f * X_SPAN, 0, 6.65f * X_SPAN, 6, 13 },
				{ 0, 13.5f * X_SPAN, 0, 6.5f * X_SPAN, 6, 13 },
				{ 1, 13.65f * X_SPAN, 0, 7f * X_SPAN, 6, 13 },

				{ 1, 14.35f * X_SPAN, 0, 6.0f * X_SPAN, 6, 14 },
				{ 0, 14.5f * X_SPAN, 0, 6.5f * X_SPAN, 6, 14 } };
	}

	/**
	 * �ӻҶ�ͼ�м���½����ÿ������ĸ߶�
	 * 
	 * @param res
	 * @param drawableId
	 * @return
	 */
	public static short[][] loadLandforms(Resources res, int drawableId) {
		Bitmap bitmap = BitmapFactory.decodeResource(res, drawableId);
		int cols = bitmap.getWidth();
		int rows = bitmap.getHeight();
		// �����ص�λͼ����ת��Ϊ��ɫ����
		short[][] result = new short[rows][cols];

		int count = 0;
		int counts = 0;
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				// ��ȡ��ǰ���ص����ɫֵ
				int color = bitmap.getPixel(j, i);
				// �ֽ���ԭɫ
				int r = Color.red(color);
				int g = Color.green(color);
				int b = Color.blue(color);
				// ͨ����ɫ��ȼ����ÿ�����ص�ĸ߶�---�Լ���½�ظ߶�
				int h = (r + g + b) / 3;
				// ����Ҷ�ͼ�߶�ֵ
				result[i][j] = (short) h;
				counts++;
				if (h == 0) {
					count++;
				}
			}
		}
		return result;
	}
}
