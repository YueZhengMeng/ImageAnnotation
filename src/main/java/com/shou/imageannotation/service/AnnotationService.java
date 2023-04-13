package com.shou.imageannotation.service;

import com.shou.imageannotation.dao.AnnotationDao;
import com.shou.imageannotation.dao.ImageDao;
import com.shou.imageannotation.po.Annotation;
import com.shou.imageannotation.utils.DateTimeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnnotationService {
    @Autowired
    private AnnotationDao annotationDao;

    @Autowired
    private ImageDao imageDao;

    public List<Annotation> getAllAnnotation() {
        return annotationDao.selectAllAnnotation();
    }

    public Annotation getAnnotationByID(int annotationID) {
        return annotationDao.selectAnnotationByID(annotationID);
    }

    public List<Annotation> getAnnotationByImageID(int imageID) {
        return annotationDao.selectAnnotationByImageID(imageID);
    }

    public List<Annotation> getAnnotationByAnnotaterID(int annotaterID) {
        return annotationDao.selectAnnotationByAnnotaterID(annotaterID);
    }

    public List<Annotation> getAnnotationByCheckerID(int checkerID) {
        return annotationDao.selectAnnotationByCheckerID(checkerID);
    }

    public int addAnnotation(Annotation annotation) {
        annotation.setAnnotationDate(DateTimeUtil.getSystemTime());
        imageDao.updateImageStatus(annotation.getImageID(), 2);
        return annotationDao.addAnnotation(annotation);
    }

    public int updateCheck(Annotation annotation) {
        annotation.setCheckDate(DateTimeUtil.getSystemTime());
        if (annotation.getCheckResult() == 1) {
            int imageID = annotationDao.selectAnnotationByID(annotation.getAnnotationID()).getImageID();
            imageDao.updateImageStatus(imageID, 1);
        }
        return annotationDao.updateCheck(annotation);
    }

    public int deleteAnnotation(int annotationID) {
        return annotationDao.deleteAnnotation(annotationID);
    }
}
