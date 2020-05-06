package com.macro.mall.portal.service;

import com.macro.mall.common.api.CommonPage;
import com.macro.mall.common.api.CommonResult;
import com.macro.mall.model.PmsProductCategory;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * 首页内容管理Service
 * Created by macro on 2019/1/28.
 */
@FeignClient("mall-admin")
@RequestMapping("/productCategory")
public interface HomeAdminService {
    /**
     * 根据专题分类分页获取专题
     *
     * @param parentId 专题分类id
     * @param pageSize size
     * @param pageNum  num
     */
    @GetMapping("/list/{parentId}")
    CommonResult<CommonPage<PmsProductCategory>> getCateList(@PathVariable Long parentId,
                                                             @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize,
                                                             @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum);
}
