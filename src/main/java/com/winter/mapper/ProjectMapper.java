package com.winter.mapper;

import com.winter.model.Project;

/**
 * ProjectMapper类
 * Created By Donghua.Chen on  2018/1/9
 */
public interface ProjectMapper {

    /**
     * 插入project数据
     * @param project
     * @return
     */
    int addProjectSelective(Project project);
}
