package race.cheng.service;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

import race.cheng.entity.Normal;
import race.cheng.graphics.LoadedObjectVertexNormal;
import android.content.res.Resources;

/**
 * 加载图片工具类
 * 
 * @author chengkai
 * 
 */
public class LoadUtil {
	// 求两个向量的叉积
	public static float[] getCrossProduct(float x1, float y1, float z1,
			float x2, float y2, float z2) {
		float A = y1 * z2 - y2 * z1;
		float B = z1 * x2 - z2 * x1;
		float C = x1 * y2 - x2 * y1;

		return new float[] { A, B, C };
	}

	// 向量规格化
	public static float[] vectorNormal(float[] vector) {
		float module = (float) Math.sqrt(vector[0] * vector[0] + vector[1]
				* vector[1] + vector[2] * vector[2]);
		return new float[] { vector[0] / module, vector[1] / module,
				vector[2] / module };
	}

	// 从obj文件中加载携带顶点信息的物体，并自动计算每个顶点的平均法向量
	public static LoadedObjectVertexNormal loadFromFileVertexOnly(String fname,
			Resources r) {
		LoadedObjectVertexNormal lo = null;
		ArrayList<Float> alv = new ArrayList<Float>();
		ArrayList<Integer> alFaceIndex = new ArrayList<Integer>();
		ArrayList<Float> alvResult = new ArrayList<Float>();
		HashMap<Integer, HashSet<Normal>> hmn = new HashMap<Integer, HashSet<Normal>>();

		try {
			InputStream in = r.getAssets().open(fname);
			InputStreamReader isr = new InputStreamReader(in);
			BufferedReader br = new BufferedReader(isr);
			String temps = null;

			while ((temps = br.readLine()) != null) {
				// 用空格分割行中的各个组成部分
				String[] tempsa = temps.split("[ ]+");
				if (tempsa[0].trim().equals("v")) {// 此行为顶点坐标
					alv.add(Float.parseFloat(tempsa[1]));
					alv.add(Float.parseFloat(tempsa[2]));
					alv.add(Float.parseFloat(tempsa[3]));
				} else if (tempsa[0].trim().equals("f")) {// 此行为三角形面
					int[] index = new int[3];// 三个顶点索引值的数组
					// 计算第0个顶点的索引，并获取此顶点的XYZ三个坐标
					index[0] = Integer.parseInt(tempsa[1].split("/")[0]) - 1;
					float x0 = alv.get(3 * index[0]);
					float y0 = alv.get(3 * index[0] + 1);
					float z0 = alv.get(3 * index[0] + 2);
					alvResult.add(x0);
					alvResult.add(y0);
					alvResult.add(z0);
					// 计算第1个顶点的索引，并获取此顶点的XYZ三个坐标
					index[1] = Integer.parseInt(tempsa[2].split("/")[0]) - 1;
					float x1 = alv.get(3 * index[1]);
					float y1 = alv.get(3 * index[1] + 1);
					float z1 = alv.get(3 * index[1] + 2);
					alvResult.add(x1);
					alvResult.add(y1);
					alvResult.add(z1);
					// 计算第2个顶点的索引，并获取此顶点的XYZ三个坐标
					index[2] = Integer.parseInt(tempsa[3].split("/")[0]) - 1;
					float x2 = alv.get(3 * index[2]);
					float y2 = alv.get(3 * index[2] + 1);
					float z2 = alv.get(3 * index[2] + 2);
					alvResult.add(x2);
					alvResult.add(y2);
					alvResult.add(z2);
					// 记录此面的顶点索引
					alFaceIndex.add(index[0]);
					alFaceIndex.add(index[1]);
					alFaceIndex.add(index[2]);
					// 求0号点到1号点的向量
					float vxa = x1 - x0;
					float vya = y1 - y0;
					float vza = z1 - z0;
					// 求0号点到2号点的向量
					float vxb = x2 - x0;
					float vyb = y2 - y0;
					float vzb = z2 - z0;
					// 通过求两个向量的叉积计算法向量
					float[] vNormal = getCrossProduct(vxa, vya, vza, vxb, vyb,
							vzb);

					for (int tempInxex : index) {// 获取当前索引对应点的法向量集合
						HashSet<Normal> hsn = hmn.get(tempInxex);
						if (hsn == null) {// 若集合不存在则创建
							hsn = new HashSet<Normal>();
						}
						// 将此点的法向量添加到集合中
						hsn.add(new Normal(vNormal[0], vNormal[1], vNormal[2]));
						hmn.put(tempInxex, hsn);
					}
				}
			}
			// 生成顶点数组
			int size = alvResult.size();
			float[] vXYZ = new float[size];
			for (int i = 0; i < size; i++) {
				vXYZ[i] = alvResult.get(i);
			}
			// 生成法向量数组
			float[] nXYZ = new float[alFaceIndex.size() * 3];
			int c = 0;
			for (Integer i : alFaceIndex) {
				HashSet<Normal> hsn = hmn.get(i);
				// 求出平均法向量
				float[] tn = Normal.getAverage(hsn);
				// 将计算出的平均法向量存放到法向量数组中
				nXYZ[c++] = tn[0];
				nXYZ[c++] = tn[1];
				nXYZ[c++] = tn[2];
			}
			lo = new LoadedObjectVertexNormal(vXYZ, nXYZ);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return lo;
	}
}
