package com.shou.imageannotation.dao;


import com.shou.imageannotation.po.Image;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface ImageDao {
    @Select("select * from image")
    List<Image> selectAllImage();

    @Select("select * from image where imageID=#{imageID}")
    Image selectImageByID(int imageID);

    @Insert("insert into image(uploaderID,description,path,uploadDate) values(#{uploaderID},#{description},#{path},#{uploadDate})")
    int addImage(Image image);

    @Update("update image set status = #{status} where imageID = #{imageID}")
    int updateImageStatus(int imageID, int status);

    @Delete("delete from image where imageID = #{imageID}")
    int deleteImage(int imageID);

    @Select("select * from image where uploaderID=#{uploaderID}")
    List<Image> selectImageByUploaderID(int uploaderID);
}
