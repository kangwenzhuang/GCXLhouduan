package com.kang.qiandao.utils;

import javax.servlet.http.HttpServletResponse;
import java.io.*;

public class FileDownload {
    public static void fileDownload(HttpServletResponse response, String filePath) throws IOException
    {
        File file = new File(filePath);
        OutputStream out = null;
        InputStream in = null;
        System.out.println("filePath:" + filePath);
        try
        {
            in = new FileInputStream(file);
            response.reset();
            response.setHeader("Content-Length", "" + file.length());
            response.setContentType("application/octet-stream; charset=utf-8");
            response.setHeader("Content-Disposition", "attachment; filename="  + file.getName());
            out = response.getOutputStream();
            byte[] buf = new byte[1024];
            int len = 0;
            while( (len = in.read(buf, 0 , 1024)) != -1)
            {
                out.write(buf, 0 , len);
            }

        }finally
        {
            if (in != null)
            {
                try
                {
                    in.close();
                } catch (IOException e)
                {
                    e.printStackTrace();
                }
            }
            if (out != null)
            {
                try
                {
                    out.close();
                } catch (IOException e)
                {
                    e.printStackTrace();
                }
            }
        }
    }
}
