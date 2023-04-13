package com.shou.imageannotation.service;

import com.shou.imageannotation.dao.ImageDao;
import com.shou.imageannotation.po.Image;
import com.shou.imageannotation.utils.DateTimeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

@Service
public class ImageService {
    private static final String[] ALLOW_FILE_TYPES = {"jpg", "jpeg", "png"};
    @Autowired
    private ImageDao imageDao;
    @Value("${imageDB.realPath}")
    private String imageRealPath;
    @Value("${imageDB.accessPath}")
    private String imageAccessPath;

    public List<Image> getAllImage() {
        return imageDao.selectAllImage();
    }

    public Image getImageByID(int imageID) {
        return imageDao.selectImageByID(imageID);
    }

    public List<Image> getImageByUploaderID(int uploaderID) {
        return imageDao.selectImageByUploaderID(uploaderID);
    }

    public int uploadImage(MultipartFile file, int uploaderID, String description) {
        //检查图片格式
        String contentType = Objects.requireNonNull(file.getContentType()).toLowerCase();
        boolean allowType = false;
        for (String allowFileType : ALLOW_FILE_TYPES) {
            if (contentType.contains(allowFileType)) {
                allowType = true;
                break;
            }
        }
        if (!allowType) {
            return 0;
        }
        //随机生成文件名，并与原后缀拼接
        String suffix = Objects.requireNonNull(file.getOriginalFilename()).substring(file.getOriginalFilename().lastIndexOf("."));
        String filename = UUID.randomUUID() + suffix;
        //根据文件存储路径保存文件
        String realPath = imageRealPath + filename;
        //防止中文路径乱码
        realPath = new String(realPath.getBytes(StandardCharsets.UTF_8)).trim();
        File savePath = new File(realPath);
        if (!savePath.getParentFile().exists()) {
            savePath.getParentFile().mkdirs();
        }
        try {
            file.transferTo(savePath);
        } catch (IOException e) {
            e.printStackTrace();
        }
        Image image = new Image();
        image.setUploaderID(uploaderID);
        image.setDescription(description);
        image.setPath(imageAccessPath + filename);
        image.setUploadDate(DateTimeUtil.getSystemTime());
        return imageDao.addImage(image);
    }

    public int deleteImage(int imageID) {
        return imageDao.deleteImage(imageID);
    }

}
