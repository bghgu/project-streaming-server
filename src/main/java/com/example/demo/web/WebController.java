package com.example.demo.web;

import com.example.demo.model.Content;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.method.annotation.StreamingResponseBody;

import java.io.*;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by ds on 2019-06-11 오후 12:37.
 */

@Controller
public class WebController {

    private final static String ROOT = System.getProperty("user.dir");
    private final static String DIR = "/file/";
    private final static String path = ROOT + DIR;

    @GetMapping("/")
    public String index(final Model model) {
        String test = "D:\\예능";
        subDirList(test);
        model.addAttribute("contents", getFileList());
        return "index";
    }

    @GetMapping("/view")
    public String view(final Model model, @RequestParam("title") final String title) {
        model.addAttribute("fileName", title);
        return "view";
    }

    @GetMapping("/download")
    public StreamingResponseBody stream(@RequestParam("fileName") final String fileName) throws Exception {
        final File file = new File(ROOT + DIR + fileName);
        final InputStream is = new FileInputStream(file);
        return os -> {
            readAndWrite(is, os);
        };
    }

    private void readAndWrite(final InputStream is, OutputStream os) throws IOException {
        byte[] data = new byte[2048];
        int read = 0;
        while ((read = is.read(data)) > 0) {
            os.write(data, 0, read);
        }
        os.flush();
    }

    private List<Content> getFileList() {
        List<Content> contentList = new LinkedList<>();
        File dirFile = new File(path);
        File[] fileList = dirFile.listFiles();
        for (File tempFile : fileList) {
            if (tempFile.isFile()) {
                contentList.add(new Content(tempFile.getName()));
            }
        }
        return contentList;
    }

    private void subDirList(String source) {
        File dir = new File(source);
        File[] fileList = dir.listFiles();
        try {
            for (int i = 0; i < fileList.length; i++) {
                File file = fileList[i];
                if (file.isFile()) {
                    // 파일이 있다면 파일 이름 출력
                    System.out.println("\t 파일 이름 = " + file.getName());
                } else if (file.isDirectory()) {
                    System.out.println("디렉토리 이름 = " + file.getName());
                    // 서브디렉토리가 존재하면 재귀적 방법으로 다시 탐색
                    subDirList(file.getCanonicalPath().toString());
                }
            }
        } catch (IOException e) {

        }
    }

}