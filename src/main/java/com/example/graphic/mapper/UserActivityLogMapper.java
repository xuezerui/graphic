package com.example.graphic.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.graphic.entity.UserActivityLog;
import org.apache.ibatis.annotations.Mapper;

/**
 * 用户操作日志 Mapper
 */
@Mapper
public interface UserActivityLogMapper extends BaseMapper<UserActivityLog> {
} 