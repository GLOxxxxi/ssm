package com.suncaper.demo.mapper.exend;

import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BatchExtendMapper  {
    void deletes(@Param("ids") List<Long> ids);

    Long selectIdByName(String name);
}
