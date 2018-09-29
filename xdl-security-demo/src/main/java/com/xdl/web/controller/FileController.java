package com.xdl.web.controller;

import com.xdl.dto.FileInfo;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.IOUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;

/**
 * 文件
 *
 * @author xdl
 * @date 2018-09-29
 */
@RestController
@RequestMapping("/file")
@Slf4j
public class FileController {

    private String folder = "D:\\ideaProject\\xdl-security\\xdl-security-demo\\src\\main\\java\\com\\xdl\\web" +
            "\\controller";

    @PostMapping
    public FileInfo upload(MultipartFile file) throws IOException {
        log.info(file.toString());


        File localFile = new File(folder, System.currentTimeMillis() + ".txt");
        file.transferTo(localFile);

        return new FileInfo(localFile.getAbsolutePath());
    }

    @GetMapping("/{id}")
    public void download(HttpServletRequest request, HttpServletResponse response, @PathVariable String id) {
        try (
                InputStream inputStream = new FileInputStream(new File(folder, id + ".txt"));
                OutputStream outputStream = response.getOutputStream()
        ) {
            response.setContentType("application/x-download");
            response.addHeader("Content-Disposition", "attachment;filename=test.txt");

            IOUtils.copy(inputStream, outputStream);
            outputStream.flush();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
