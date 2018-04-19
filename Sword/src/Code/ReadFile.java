package Code;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class ReadFile {
	public ReadFile() {
	}

	/**
	 * 读取某个文件夹下的所有文件
	 */
	public static boolean readfile(String filepath, Map<String, String> folder)
			throws FileNotFoundException, IOException {
		try {

			File file = new File(filepath);
			if (!file.isDirectory()) {
				// System.out.println("文件");
				// System.out.println("path=" + file.getPath());
				// System.out.println("absolutepath=" + file.getAbsolutePath());
				// System.out.println("name=" + file.getName());
				// System.out.println();

				int idx = file.getPath().indexOf("公司电脑备份");
				folder.put(file.getName(), file.getPath().substring(idx));

			} else if (file.isDirectory()) {
				// System.out.println("文件夹");
				String[] filelist = file.list();
				for (int i = 0; i < filelist.length; i++) {
					File readfile = new File(filepath + "\\" + filelist[i]);
					if (!readfile.isDirectory()) {
						// System.out.println("path=" + readfile.getPath());
						// System.out.println("absolutepath=" + readfile.getAbsolutePath());
						// System.out.println("name=" + readfile.getName());
						// System.out.println();

						int idx = file.getPath().indexOf("公司电脑备份");
						folder.put(file.getName(), file.getPath().substring(idx));

					} else if (readfile.isDirectory()) {
						readfile(filepath + "\\" + filelist[i], folder);
					}
				}

			}

		} catch (FileNotFoundException e) {
			System.out.println("readfile()   Exception:" + e.getMessage());
		}
		return true;
	}

	public static void main(String[] args) {
		Map<String, String> folder1 = new HashMap<String, String>();
		Map<String, String> folder2 = new HashMap<String, String>();
		try {
			readfile("C:\\Users\\i317032\\Documents\\WangAnran\\公司电脑备份", folder2);
			readfile("D:\\公司电脑备份", folder1);

			// deletefile("D:/file");
		} catch (FileNotFoundException ex) {
		} catch (IOException ex) {
		}
		if (!folder1.isEmpty()) {
			Iterator iter = folder1.entrySet().iterator();
			while (iter.hasNext()) {
				Map.Entry entry = (Map.Entry) iter.next();
				String key = (String) entry.getKey();
				String value = (String) entry.getValue();
				if (folder2.containsKey(key)) {
					if (folder2.get(key).equals(value)) {
						folder2.remove(key);
					}
				}
			}
		}
		if (!folder2.isEmpty()) {
			System.out.println(folder2.size());
			Iterator iter2 = folder2.entrySet().iterator();
			while (iter2.hasNext()) {
				Map.Entry entry2 = (Map.Entry) iter2.next();
				System.out.println(entry2.getKey());
				System.out.println(entry2.getValue());
			}
		}
		System.out.println("ok");
	}

}
