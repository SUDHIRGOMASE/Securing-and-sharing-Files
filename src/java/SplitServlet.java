import com.fileutility.util.SplitFileUtil;
//import com.mysql.jdbc.StringUtils;
import com.mysql.cj.util.StringUtils;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.io.*;
import javax.crypto.Cipher;
import javax.servlet.*;
import java.util.*;
import java.util.stream.Collectors;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

@MultipartConfig
public class SplitServlet extends HttpServlet {

    private final String UPLOAD_DIRECTORY = "D:\\FileUtilityData\\split";
    String[] predefinedSize = {"10 KB", "100 KB", "120 KB", "500 KB", "720 KB", "1.2 MB", "1.44 MB", "100 MB", "250 MB", "650 MB"};
    private static Map<String, Integer> sizeMap = new HashMap();

    static {
        sizeMap.put("10 KB", 10240);
        sizeMap.put("100 KB", 102400);
        sizeMap.put("120 KB", 122880);
        sizeMap.put("500 KB", 512000);
        sizeMap.put("720 KB", 737280);
        sizeMap.put("1.2 MB", 1213952);
        sizeMap.put("1.44 MB", 1457644);
        sizeMap.put("100 MB", 103809020);
        sizeMap.put("250 MB", 26004085);
        sizeMap.put("650 MB", 674758630);

    }
    int[] predefinedSizeInBytes = {10240, 102400, 122880, 512000, 737280, 1213952, 1457644, 103809020, 26004085, 674758630};

    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // process only if its multipart content
        if (ServletFileUpload.isMultipartContent(request)) {
            try {
                List<FileItem> multiparts = new ServletFileUpload(
                        new DiskFileItemFactory()).parseRequest(request);
                List<FileItem> sortedFileItems
                        = multiparts.stream()
                                .sorted(Comparator.comparing(FileItem::isFormField, Comparator.reverseOrder()))
                                .collect(Collectors.toList());
                Map<String, String> inputs = new HashMap();
                for (FileItem item : sortedFileItems) {

                    // Process regular form field (input type="text|radio|checkbox|etc", select, etc).
                    if (item.isFormField()) {
                        inputs.put(item.getFieldName(), item.getString());
                    }

                    if (!item.isFormField()) {
                        String name = new File(item.getName()).getName();
                        File file = new File(UPLOAD_DIRECTORY + File.separator + name);
                        item.write(file);
                        String source = file.getAbsolutePath(); //"D:\\TYIT_Practical doccumemt\\New Folder\\Sharad.txt";
                        String dest = UPLOAD_DIRECTORY + File.separator + SplitFileUtil.getName(name, 0);
                       
                        String predefinedRadioBtn = inputs.get("predefinedSize");
                        String splitIntoRadioBtn = inputs.get("splitIntoTxtBox");
                        String splitEachFileRadioBtn = inputs.get("splitEachFileTxtBox");
                        int attributes[] = null;
                        if (!StringUtils.isNullOrEmpty(predefinedRadioBtn)) {
                             String selectedSize = inputs.get("predefinedSize");
                            attributes = SplitFileUtil.getAttributesForPredefined((int) file.length(), sizeMap.get(selectedSize), 0);
                        } else if (!StringUtils.isNullOrEmpty(splitIntoRadioBtn)) {
                            int splitIntoNumberOfFiles = Integer.parseInt(inputs.get("splitIntoTxtBox"));

                            attributes = SplitFileUtil.getAttributesForPredefined((int) file.length(), 0, splitIntoNumberOfFiles);
                        } else if (!StringUtils.isNullOrEmpty(splitEachFileRadioBtn)) {
                            int splitFileSize = Integer.parseInt(inputs.get("splitEachFileTxtBox"));
                            String customUnit = (String) inputs.get("cust");
                            if("KB".equals(customUnit)) {
                                splitFileSize = splitFileSize * 1024;
                            } else if("MB".equals(customUnit)) {
                                splitFileSize = splitFileSize * 1000000;
                            }
                            attributes = SplitFileUtil.getAttributesForPredefined((int) file.length(), splitFileSize, 0);
                        }
                        int no = attributes[1];
                        int size = attributes[0];
                        int lsize = attributes[2];
                        String zipFilePath = UPLOAD_DIRECTORY + File.separator + name.substring(0, name.length() - 4) + ".zip";
                        boolean batch = inputs.get("generateBatchFile") == null ? false : true;
                        File zipFile = SplitFileUtil.split(source, dest, inputs.get("comment"), no, size, lsize, batch,zipFilePath);

                        response.setContentType("text/html");
                        PrintWriter out = response.getWriter();

                        response.setContentType("APPLICATION/OCTET-STREAM");
                        response.setHeader("Content-Disposition", "attachment; filename=\"" + zipFile.getName() + "\"");

                        FileInputStream fileInputStream = new FileInputStream(zipFile);

                        int i;
                        while ((i = fileInputStream.read()) != -1) {
                            out.write(i);
                        }
                        fileInputStream.close();
                        out.close();
                    }
                }

                // File uploaded successfully
                request.setAttribute("message", "File Uploaded Successfully");
            } catch (Exception ex) {
                request.setAttribute("message", "File Upload Failed due to " + ex);
            }

        } else {
            request.setAttribute("message",
                    "Sorry this Servlet only handles file upload request");
        }

        request.getRequestDispatcher("/split.jsp").forward(request, response);

    }

}
