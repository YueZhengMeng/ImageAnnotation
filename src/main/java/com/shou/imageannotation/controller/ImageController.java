package com.shou.imageannotation.controller;

import com.shou.imageannotation.po.Image;
import com.shou.imageannotation.service.ImageService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/image")
public class ImageController {
    @Autowired
    private ImageService imageService;

    @GetMapping("/all")
    @ResponseStatus(HttpStatus.OK)
    @Secured({"ROLE_admin", "ROLE_checker", "ROLE_annotater"})
    @ApiOperation(value = "获取所有图片的信息", notes = "标注人员和审核人员权限")
    public List<Image> getAllImage() {
        return imageService.getAllImage();
    }

    @GetMapping("/byImageID/{imageID}")
    @ResponseStatus(HttpStatus.OK)
    @Secured({"ROLE_admin", "ROLE_checker", "ROLE_annotater", "ROLE_user"})
    @ApiOperation(value = "获取某张图片的信息", notes = "登录权限")
    public Image getImageByID(@PathVariable int imageID) {
        return imageService.getImageByID(imageID);
    }

    @GetMapping("/byByUploaderID/{uploaderID}")
    @ResponseStatus(HttpStatus.OK)
    @Secured({"ROLE_admin", "ROLE_user"})
    @ApiOperation(value = "获取某个用户上传的所有图片的信息", notes = "用户权限")
    public List<Image> getImageByUploaderID(@PathVariable int uploaderID) {
        return imageService.getImageByUploaderID(uploaderID);
    }

    @PostMapping(value = "/upload", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    @Secured({"ROLE_admin", "ROLE_user"})
    @ApiOperation(value = "添加图片", notes = "用户权限")
    public int uploadImage(@RequestPart("file") MultipartFile file, @RequestParam("uploaderID") int uploaderID, @RequestParam("description") String description) {
        try {
            if (file.isEmpty()) {
                throw new RuntimeException("上传文件不能为空");
            }
            return imageService.uploadImage(file, uploaderID, description);
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    @DeleteMapping("/delete/{imageID}")
    @ResponseStatus(HttpStatus.OK)
    @Secured({"ROLE_admin", "ROLE_user"})
    @ApiOperation(value = "删除图片", notes = "用户权限")
    public int deleteImage(@PathVariable int imageID) {
        return imageService.deleteImage(imageID);
    }

}
