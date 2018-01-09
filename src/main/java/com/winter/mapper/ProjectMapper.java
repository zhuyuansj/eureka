package com.winter.mapper;

import com.winter.model.Project;
import org.apache.ibatis.annotations.Mapper;

/**
 * ProjectMapper类
 * Created By Donghua.Chen on  2018/1/9
 */
@Mapper
public interface ProjectMapper {

    /**
     * 插入project数据
     * @param project
     * @return
     */
    int addProjectSelective(Project project);
}
