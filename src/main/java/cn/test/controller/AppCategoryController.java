package cn.test.controller;

import cn.test.entity.AppCategory;
import cn.test.service.AppCategoryService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * 手游类别(AppCategory)表控制层
 *
 * @author makejava
 * @since 2023-06-07 10:20:14
 */
@RestController
@RequestMapping("appCategory")
public class AppCategoryController {
    /**
     * 服务对象
     */
    @Resource
    private AppCategoryService appCategoryService;

    /**
     * 分页查询
     *
     * @param appCategory 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @GetMapping
    public ResponseEntity<Page<AppCategory>> queryByPage(AppCategory appCategory, PageRequest pageRequest) {
        return ResponseEntity.ok(this.appCategoryService.queryByPage(appCategory, pageRequest));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public ResponseEntity<AppCategory> queryById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(this.appCategoryService.queryById(id));
    }

    /**
     * 新增数据
     *
     * @param appCategory 实体
     * @return 新增结果
     */
    @PostMapping
    public ResponseEntity<AppCategory> add(AppCategory appCategory) {
        return ResponseEntity.ok(this.appCategoryService.insert(appCategory));
    }

    /**
     * 编辑数据
     *
     * @param appCategory 实体
     * @return 编辑结果
     */
    @PutMapping
    public ResponseEntity<AppCategory> edit(AppCategory appCategory) {
        return ResponseEntity.ok(this.appCategoryService.update(appCategory));
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @DeleteMapping
    public ResponseEntity<Boolean> deleteById(Long id) {
        return ResponseEntity.ok(this.appCategoryService.deleteById(id));
    }

}

