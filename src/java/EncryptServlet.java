import com.fileutility.util.SendMailSSL;
import com.fileutiliy.dto.User;
import java.io.*;
import javax.servlet.annotation.MultipartConfig;
import java.io.File;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;

@MultipartConfig
public class EncryptServlet extends HttpServlet {

    private final String UPLOAD_DIRECTORY = "E:\\FileUtilityData\\encrypt";
    private static final String ALGORITHM = "AES";
    private static final String TRANSFORMATION = "AES";
    private static final String key = "Mary has one cat";
    private static final String subject = "Securing & Shearing  Files";
    private static final String body = "There is a file which is encrypted by using Securing And Shearing Website.Hope it wll be helpful.";
    protected void service(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {

        //process only if its multipart content
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
                        User user = (User) request.getSession().getAttribute("user");
                        File encryptedFile = encrypt(key, file);
                        String to = inputs.get("txtEmailId");
                        String checkBoxValue = inputs.get("chkfile");
                        if ("on".equals(checkBoxValue)) {
                            try {
                                

                                SendMailSSL.send(to, subject, body, encryptedFile);
                            } catch (Exception ex) {
                                ex.printStackTrace();
                            }
                        }
                        response.setContentType("text/html");
                        PrintWriter out = response.getWriter();

                        response.setContentType("APPLICATION/OCTET-STREAM");
                        response.setHeader("Content-Disposition", "attachment; filename=\"" +encryptedFile.getName() + "\"");

                        FileInputStream fileInputStream = new FileInputStream(encryptedFile);

                        int i;
                        while ((i = fileInputStream.read()) != -1) {
                            out.write(i);
                        }
                        fileInputStream.close();
                        out.close();
                    }
                }

                //File uploaded successfully
                request.setAttribute("message", "File Uploaded Successfully");
            } catch (Exception ex) {
                request.setAttribute("message", "File Upload Failed due to " + ex);
            }

        } else {
            request.setAttribute("message",
                    "Sorry this Servlet only handles file upload request");
        }

       request.getRequestDispatcher("/encrypt.jsp").forward(request, response);
        
    }

    public File encrypt(String key, File inputFile) 
    {
        return doCrypto(Cipher.ENCRYPT_MODE, key, inputFile);
    }

    private File doCrypto(int cipherMode, String key, File inputFile) 
    {
        try {
            String name= inputFile.getName().replace(".txt", ".enc");
            File outputFile = new File(UPLOAD_DIRECTORY + File.separator + name);
            Key secretKey = new SecretKeySpec(key.getBytes(), ALGORITHM);
            Cipher cipher = Cipher.getInstance(TRANSFORMATION);
            cipher.init(cipherMode, secretKey);
 
            FileInputStream inputStream = new FileInputStream(inputFile);
            byte[] inputBytes = new byte[(int) inputFile.length()];
            inputStream.read(inputBytes);

            byte[] outputBytes = cipher.doFinal(inputBytes);

            FileOutputStream outputStream = new FileOutputStream(outputFile);
            outputStream.write(outputBytes);

            inputStream.close();
            outputStream.close();
            return outputFile;
        } catch (NoSuchPaddingException | NoSuchAlgorithmException
                | InvalidKeyException | BadPaddingException
                | IllegalBlockSizeException | IOException ex) {
            ex.printStackTrace();
        }
      
       return null;} }
