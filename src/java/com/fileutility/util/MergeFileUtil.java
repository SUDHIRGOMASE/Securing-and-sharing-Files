package com.fileutility.util;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public class MergeFileUtil {

    /**
     * Size of the buffer to read/write data
     */
    private static final int BUFFER_SIZE = 4096;

    /**
     * Extracts a zip file specified by the zipFilePath to a directory specified
     * by destDirectory (will be created if does not exists)
     *
     * @param zipFilePath
     * @param destDirectory
     * @throws IOException
     */
    public static void unzip(String zipFilePath, String destDirectory) throws IOException {
        File destDir = new File(destDirectory);
        if (!destDir.exists()) {
            destDir.mkdir();
        }
        ZipInputStream zipIn = new ZipInputStream(new FileInputStream(zipFilePath));
        ZipEntry entry = zipIn.getNextEntry();
        // iterates over entries in the zip file
        while (entry != null) {
            String filePath = destDirectory + File.separator + entry.getName();
            if (!entry.isDirectory()) {
                // if the entry is a file, extracts it
                extractFile(zipIn, filePath);
            } else {
                // if the entry is a directory, make the directory
                File dir = new File(filePath);
                dir.mkdirs();
            }
            zipIn.closeEntry();
            entry = zipIn.getNextEntry();
        }
        zipIn.close();
    }

    /**
     * Extracts a zip entry (file entry)
     *
     * @param zipIn
     * @param filePath
     * @throws IOException
     */
    private static void extractFile(ZipInputStream zipIn, String filePath) throws IOException {
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(filePath));
        byte[] bytesIn = new byte[BUFFER_SIZE];
        int read = 0;
        while ((read = zipIn.read(bytesIn)) != -1) {
            bos.write(bytesIn, 0, read);
        }
        bos.close();
    }

    // merge fuction
    public static File merge(String split, String dest) {
        File mergedFile = null;
        try {
            File fm = new File(split);
            FileReader fr = new FileReader(fm);
            BufferedReader br = new BufferedReader(fr);

            String l1 = br.readLine();
            StringTokenizer st1 = new StringTokenizer(l1, ",");
            String beg = st1.nextToken();
            if (!(beg.equals("jfs"))) {
                /*
				 * JOptionPane.showMessageDialog((Container) null, "Not a valid split file!",
				 * "FileManipulation System+", JOptionPane.OK_OPTION); return 1;
                 */
            }
            String oname = st1.nextToken();
            long osize = Long.parseLong(st1.nextToken());
            long mtime = Long.parseLong(st1.nextToken());
            String rd = st1.nextToken();
            boolean ronly;
            if (rd.equals("true")) {
                ronly = true;
            } else {
                ronly = false;
            }
            mergedFile = new File(dest + "/" + oname);

            mergedFile.setLastModified(mtime);

            if (ronly) {
                mergedFile.setReadOnly();
            }

            FileOutputStream fos = new FileOutputStream(mergedFile);
            String l2 = br.readLine();
            StringTokenizer st2 = new StringTokenizer(l2, ",");
            String cfile = st2.nextToken();

            String bfile = st2.nextToken();
            String comments;

            int no = Integer.parseInt(st2.nextToken());
            for (int i = 0; i < no; i++) {
                String ln = br.readLine();
                StringTokenizer st = new StringTokenizer(ln, ",");
                File f1 = new File(new File(split).getParent() + "/" + st.nextToken());
                FileInputStream fis = new FileInputStream(f1);
                byte[] data = new byte[Integer.parseInt(st.nextToken())];
                int count = fis.read(data);
                fos.write(data);
                fis.close();

            }
            fos.close();
            br.close();

        } catch (Exception e) {
        }

        /*
		 * JOptionPane.showMessageDialog((Container) null, "Merged successfully!",
		 * "FileManipulation System", JOptionPane.INFORMATION_MESSAGE);
         */
        return mergedFile;
    }

    public static Map<String, String> getFileDetails(File file, boolean cmtFile, boolean batchFile) throws IOException {
        Map<String, String> detailsMap = new HashMap<>();
        FileReader fr = new FileReader(file);
        BufferedReader br = new BufferedReader(fr);
        String l1 = br.readLine();
        StringTokenizer st1 = new StringTokenizer(l1, ",");
        String beg = st1.nextToken();
        detailsMap.put("originalFile", st1.nextToken());
        detailsMap.put("originalSize", st1.nextToken() + " bytes");
        String l2 = br.readLine();
        StringTokenizer st2 = new StringTokenizer(l2, ",");
        String cmt = st2.nextToken();
        String bat = st2.nextToken();
        detailsMap.put("noOfSplits", st2.nextToken());
        detailsMap.put("eachSplitSize", st2.nextToken() + " bytes");
        detailsMap.put("lastSplitSize", st2.nextToken() + " bytes");
        detailsMap.put("haveComments", batchFile ? "Yes" : "No");
        detailsMap.put("haveBatchfile", batchFile ? "Yes" : "No");
        return detailsMap;
    }
}
