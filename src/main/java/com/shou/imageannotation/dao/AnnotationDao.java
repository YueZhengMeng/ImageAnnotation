package com.shou.imageannotation.dao;

import com.shou.imageannotation.po.Annotation;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface AnnotationDao {
    @Select("select * from annotation")
    List<Annotation> selectAllAnnotation();

    @Select("select * from annotation where annotationID=#{annotationID}")
    Annotation selectAnnotationByID(int annotationID);

    @Insert("insert into annotation(imageID,annotaterID,annotationDate,annotationResult) values(#{imageID},#{annotaterID},#{annotationDate},#{annotationResult})")
    int addAnnotation(Annotation annotation);

    @Update("update annotation set checkerID = #{checkerID}, checkDate = #{checkDate}, checkOpinion=#{checkOpinion}, checkResult = #{checkResult} where annotationID = #{annotationID}")
    int updateCheck(Annotation annotation);

    @Select("select * from annotation where imageID=#{imageID}")
    List<Annotation> selectAnnotationByImageID(int imageID);

    @Select("select * from annotation where annotaterID=#{annotaterID}")
    List<Annotation> selectAnnotationByAnnotaterID(int annotaterID);

    @Select("select * from annotation where checkerID=#{checkerID}")
    List<Annotation> selectAnnotationByCheckerID(int checkerID);

    @Delete("delete from annotation where annotationID = #{annotationID}")
    int deleteAnnotation(int annotationID);
}
