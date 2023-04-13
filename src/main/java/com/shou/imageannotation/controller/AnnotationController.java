package com.shou.imageannotation.controller;

import com.shou.imageannotation.po.Annotation;
import com.shou.imageannotation.service.AnnotationService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/annotation")
public class AnnotationController {
    @Autowired
    private AnnotationService annotationService;

    @GetMapping("/all")
    @ResponseStatus(HttpStatus.OK)
    @Secured({"ROLE_admin"})
    @ApiOperation(value = "获取所有标注的信息", notes = "管理员权限")
    public List<Annotation> getAllAnnotation() {
        return annotationService.getAllAnnotation();
    }

    @GetMapping("/byAnnotationID/{annotationID}")
    @ResponseStatus(HttpStatus.OK)
    @Secured({"ROLE_admin","ROLE_annotater","ROLE_checker","ROLE_user"})
    @ApiOperation(value = "获取某个标注的信息", notes = "登录权限")
    public Annotation getAnnotationByID(@PathVariable int annotationID) {
        return annotationService.getAnnotationByID(annotationID);
    }

    @GetMapping("/byImageID/{imageID}")
    @ResponseStatus(HttpStatus.OK)
    @Secured({"ROLE_admin","ROLE_annotater","ROLE_checker","ROLE_user"})
    @ApiOperation(value = "获取某张图片的所有标注的信息", notes = "登录权限")
    public List<Annotation> getAnnotationByImageID(@PathVariable int imageID) {
        return annotationService.getAnnotationByImageID(imageID);
    }

    @GetMapping("/byAnnotaterID/{annotaterID}")
    @ResponseStatus(HttpStatus.OK)
    @Secured({"ROLE_admin","ROLE_annotater","ROLE_checker","ROLE_user"})
    @ApiOperation(value = "获取某个标注者的所有标注的信息", notes = "登录权限")
    public List<Annotation> getAnnotationByAnnotaterID(@PathVariable int annotaterID) {
        return annotationService.getAnnotationByAnnotaterID(annotaterID);
    }

    @GetMapping("/byCheckerID/{checkerID}")
    @ResponseStatus(HttpStatus.OK)
    @Secured({"ROLE_admin","ROLE_annotater","ROLE_checker","ROLE_user"})
    @ApiOperation(value = "获取某个审核者的所有标注的信息", notes = "登录权限")
    public List<Annotation> getAnnotationByCheckerID(@PathVariable int checkerID) {
        return annotationService.getAnnotationByCheckerID(checkerID);
    }

    @PostMapping("/add")
    @ResponseStatus(HttpStatus.CREATED)
    @Secured({"ROLE_admin","ROLE_annotater"})
    @ApiOperation(value = "添加标注", notes = "标注人员权限\n只需要图片ID、标注人员ID、标注内容")
    public int addAnnotation(@RequestBody Annotation annotation) {
        return annotationService.addAnnotation(annotation);
    }

    @PostMapping("/check")
    @ResponseStatus(HttpStatus.OK)
    @Secured({"ROLE_admin","ROLE_checker"})
    @ApiOperation(value = "审核标注", notes = "审核人员权限\n只需要标注ID、审核人员ID、审核意见、审核结果")
    public int updateCheck(@RequestBody Annotation annotation) {
        return annotationService.updateCheck(annotation);
    }

    @DeleteMapping("/delete/{annotationID}")
    @ResponseStatus(HttpStatus.OK)
    @Secured({"ROLE_admin"})
    @ApiOperation(value = "删除标注", notes = "管理员权限")
    public int deleteAnnotation(@PathVariable int annotationID) {
        return annotationService.deleteAnnotation(annotationID);
    }
}
