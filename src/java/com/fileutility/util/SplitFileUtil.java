package com.fileutility.util;
import com.mysql.cj.util.StringUtils;
//import com.mysql.jdbc.StringUtils;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class SplitFileUtil {

	public static File split(String source, String dest, String cmt, int no, int size, int lsize,
			boolean batch,String zipPath) {

		List<String> filePaths = new ArrayList<String>();
		
		String name, entry;
		long fsize, mtime;
		boolean ronly;
		File fl = new File(source);
		name = fl.getName();
		fsize = fl.length();
		mtime = fl.lastModified();
		ronly = fl.canWrite();
		if (ronly)
			ronly = false;
		else
			ronly = true;

		try {

			FileInputStream fis = new FileInputStream(fl);
			FileWriter fw = new FileWriter(dest);
			filePaths.add(dest);
			BufferedWriter bw = new BufferedWriter(fw);

			String l1 = new String("jfs" + "," + name + "," + String.valueOf(fsize) + "," + String.valueOf(mtime) + ","
					+ String.valueOf(ronly));

			bw.write(l1, 0, l1.length());
			bw.newLine();
			String cfile;
			if (!StringUtils.isNullOrEmpty(cmt)) {
				cfile = getName(name, -1);
				File bfc = new File((new File(dest)).getParent() + "/" + cfile);
				filePaths.add(bfc.getAbsolutePath());
				if (!bfc.exists()) {
					FileWriter fwc = new FileWriter(bfc);
					BufferedWriter bwc = new BufferedWriter(fwc);
					bwc.write(cmt, 0, cmt.length());
					bwc.close();
					fwc.close();
				}
			} else {
				cfile = "null";
			}
			String bfile;
			FileWriter fw2;
			BufferedWriter bw2;
			bfile = getName(name, -2);
			File bf = new File(new File(dest).getParent() + "/" + bfile);
			filePaths.add(bf.getAbsolutePath());

			fw2 = new FileWriter(bf);
			bw2 = new BufferedWriter(fw2);
			if (batch)
				bfile = getName(name, -2);
			else
				bfile = "null";
			String l2 = new String(cfile + "," + bfile + "," + String.valueOf(no) + "," + String.valueOf(size) + ","
					+ String.valueOf(lsize));
			bw.write(l2, 0, l2.length());
			bw.newLine();
			if (lsize != 0)
				no--;
			for (int i = 1; i <= no; i++) {
				String sname = getName(name, i);
				FileOutputStream fos = new FileOutputStream(new File(dest).getParent() + "/" + sname);
				filePaths.add(new File(dest).getParent() + "/" + sname);
				byte[] data = new byte[size];
				int count = fis.read(data);
				fos.write(data);
				fos.close();
				String ln = new String(sname + "," + String.valueOf(size));
				bw.write(ln, 0, ln.length());
				bw.newLine();
				if (batch) {
					String lb;
					if (i == 1)
						lb = new String("copy /b \"" + sname + "\" \"" + name + "\"");
					else
						lb = new String("copy /b \"" + name + "\"+\"" + sname + "\" \"" + name + "\"");
					bw2.write(lb, 0, lb.length());
					bw2.newLine();
				}
			}
			if (lsize != 0) {
				String sname = getName(name, ++no);
				FileOutputStream fos = new FileOutputStream(new File(dest).getParent() + "/" + sname);
				filePaths.add(new File(dest).getParent() + "/" + sname);
				byte[] data = new byte[lsize];
				int count = fis.read(data);
				fos.write(data);
				fos.close();
				String ln = new String(sname + "," + String.valueOf(lsize));
				bw.write(ln, 0, ln.length());
				bw.newLine();
				if (batch) {
					String lb;
					lb = new String("copy /b \"" + name + "\"+\"" + sname + "\" \"" + name + "\"");
					bw2.write(lb, 0, lb.length());
					bw2.newLine();
				}

			}
			String eof = new String("eof");
			bw.write(eof, 0, eof.length());
			bw.close();
			if (batch) {
				String lb = new String("echo File " + name + " successfully merged");
				bw2.write(lb, 0, lb.length());
			}
			bw2.close();
			fis.close();

			try (ZipOutputStream zipOut = new ZipOutputStream(new FileOutputStream(zipPath))) {
				for (String filePath : filePaths) {
					File fileToZip = new File(filePath);
					zipOut.putNextEntry(new ZipEntry(fileToZip.getName()));
					Files.copy(fileToZip.toPath(), zipOut);
				}
			}

			if (!batch)
				bf.delete();
			
                        return new File(zipPath);
		} catch (Exception e) {
			e.printStackTrace();
		}
                return null;
	}

	public static String getName(String name, int i) {
		String lpart = name.substring(0, name.length() - 4);

		String rpart;
		if (i == 0)
			rpart = ".jfs";
		else if (i == -1)
			rpart = ".cmt";
		else if (i == -2)
			rpart = ".bat";
		else if (i < 10)
			rpart = ".00" + String.valueOf(i);
		else if (i < 100)
			rpart = ".0" + String.valueOf(i);
		else
			rpart = "." + String.valueOf(i);
		return (new String(lpart + rpart));
	}

	public static int[] getAttributesForPredefined(int fileSize, int predefinedSize, int no) {
		int fileAttributes[] = new int[3];
		if (predefinedSize != 0) {
			if (predefinedSize > fileSize) {
				fileAttributes[0] = fileSize;
				fileAttributes[1] = 1;
				fileAttributes[2] = 0;
			} else {
				fileAttributes[0] = predefinedSize;
				fileAttributes[2] = fileSize % predefinedSize;
				if (fileAttributes[2] == 0)
					fileAttributes[1] = fileSize / predefinedSize;
				else
					fileAttributes[1] = (fileSize / predefinedSize) + 1;
			}
		} else if (no != 0) {
			if (fileSize % no == 0) {
				fileAttributes[0] = fileSize / no;
				fileAttributes[1] = no;
				fileAttributes[2] = 0;
			} else {
				fileAttributes[2] = fileSize % no;
				fileAttributes[0] = fileSize / no;
				fileAttributes[1] = no;
				fileAttributes[2] += fileAttributes[0];
			}
		}

		return fileAttributes;
	}
}
