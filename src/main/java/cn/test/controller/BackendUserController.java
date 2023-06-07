package cn.test.controller;

import cn.test.entity.BackendUser;
import cn.test.service.BackendUserService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (BackendUser)表控制层
 *
 * @author makejava
 * @since 2023-06-07 10:21:55
 */
@RestController
@RequestMapping("backendUser")
public class BackendUserController {
    /**
     * 服务对象
     */
    @Resource
    private BackendUserService backendUserService;

    /**
     * 分页查询
     *
     * @param backendUser 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @GetMapping
    public ResponseEntity<Page<BackendUser>> queryByPage(BackendUser backendUser, PageRequest pageRequest) {
        return ResponseEntity.ok(this.backendUserService.queryByPage(backendUser, pageRequest));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public ResponseEntity<BackendUser> queryById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(this.backendUserService.queryById(id));
    }

    /**
     * 新增数据
     *
     * @param backendUser 实体
     * @return 新增结果
     */
    @PostMapping
    public ResponseEntity<BackendUser> add(BackendUser backendUser) {
        return ResponseEntity.ok(this.backendUserService.insert(backendUser));
    }

    /**
     * 编辑数据
     *
     * @param backendUser 实体
     * @return 编辑结果
     */
    @PutMapping
    public ResponseEntity<BackendUser> edit(BackendUser backendUser) {
        return ResponseEntity.ok(this.backendUserService.update(backendUser));
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @DeleteMapping
    public ResponseEntity<Boolean> deleteById(Long id) {
        return ResponseEntity.ok(this.backendUserService.deleteById(id));
    }

}

