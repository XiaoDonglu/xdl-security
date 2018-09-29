package com.xdl.dto;

import lombok.Data;

/**
 * 文件
 *
 * @author xdl
 * @date 2018-09-29
 */
@Data
public class FileInfo {

    private String path;

    public FileInfo(String path) {
        this.path = path;
    }
}
