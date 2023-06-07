package cn.test.controller;

import cn.test.entity.AppVersion;
import cn.test.service.AppVersionService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (AppVersion)表控制层
 *
 * @author makejava
 * @since 2023-06-07 10:21:38
 */
@RestController
@RequestMapping("appVersion")
public class AppVersionController {
    /**
     * 服务对象
     */
    @Resource
    private AppVersionService appVersionService;

    /**
     * 分页查询
     *
     * @param appVersion 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @GetMapping
    public ResponseEntity<Page<AppVersion>> queryByPage(AppVersion appVersion, PageRequest pageRequest) {
        return ResponseEntity.ok(this.appVersionService.queryByPage(appVersion, pageRequest));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public ResponseEntity<AppVersion> queryById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(this.appVersionService.queryById(id));
    }

    /**
     * 新增数据
     *
     * @param appVersion 实体
     * @return 新增结果
     */
    @PostMapping
    public ResponseEntity<AppVersion> add(AppVersion appVersion) {
        return ResponseEntity.ok(this.appVersionService.insert(appVersion));
    }

    /**
     * 编辑数据
     *
     * @param appVersion 实体
     * @return 编辑结果
     */
    @PutMapping
    public ResponseEntity<AppVersion> edit(AppVersion appVersion) {
        return ResponseEntity.ok(this.appVersionService.update(appVersion));
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @DeleteMapping
    public ResponseEntity<Boolean> deleteById(Long id) {
        return ResponseEntity.ok(this.appVersionService.deleteById(id));
    }

}

